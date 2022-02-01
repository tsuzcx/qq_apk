package com.tencent.mm.accessibility.core.provider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/TalkController;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "LONG_TIME_GO", "", "TAG", "", "handler", "Landroid/os/Handler;", "lastTalkString", "longTimeGo", "", "longTimeGoTask", "Ljava/lang/Runnable;", "viewLastValueMap", "", "", "dealNodeInfo", "", "view", "Landroid/view/View;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getAuthority", "recordLongTimeGo", "talk", "talkString", "id", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TalkController
  extends Provider
{
  public static final TalkController INSTANCE;
  private static final long LONG_TIME_GO = 1000L;
  public static final String TAG = "MicroMsg.Acc.TalkController";
  private static final Handler handler;
  private static String lastTalkString;
  private static boolean longTimeGo;
  private static final Runnable longTimeGoTask;
  private static final Map<Integer, Boolean> viewLastValueMap;
  
  static
  {
    AppMethodBeat.i(234241);
    INSTANCE = new TalkController();
    longTimeGo = true;
    viewLastValueMap = (Map)new LinkedHashMap();
    handler = new Handler(Looper.getMainLooper());
    longTimeGoTask = TalkController..ExternalSyntheticLambda0.INSTANCE;
    lastTalkString = "";
    INSTANCE.addRootIdMapper$plugin_autoaccessibility_release((m)1.INSTANCE);
    AppMethodBeat.o(234241);
  }
  
  private static final void longTimeGoTask$lambda-0()
  {
    longTimeGo = true;
  }
  
  private final void recordLongTimeGo()
  {
    AppMethodBeat.i(234209);
    longTimeGo = false;
    handler.removeCallbacks(longTimeGoTask);
    handler.postDelayed(longTimeGoTask, 1000L);
    AppMethodBeat.o(234209);
  }
  
  public final void dealNodeInfo(View paramView, final AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234257);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234231);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        Object localObject2 = (Map)paramAnonymousMMBaseAccessibilityConfig.getTalkMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localObject2 == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234231);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        View localView = paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, p.p((Iterable)((Map)localObject2).keySet()));
        if (localView == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234231);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        Object localObject1 = (b)((Map)localObject2).get(Integer.valueOf(localView.getId()));
        if (localObject1 == null)
        {
          localObject2 = (b)((Map)localObject2).get(TalkController.INSTANCE.getLayoutId(this.$view));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
            AppMethodBeat.o(234231);
            return paramAnonymousMMBaseAccessibilityConfig;
          }
        }
        boolean bool1 = ((Boolean)((b)localObject1).invoke(this.$view)).booleanValue();
        Map localMap = TalkController.access$getViewLastValueMap$p();
        Integer localInteger = Integer.valueOf(this.$view.hashCode());
        localObject2 = localMap.get(localInteger);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = Boolean.FALSE;
          localMap.put(localInteger, localObject1);
        }
        boolean bool2 = ((Boolean)localObject1).booleanValue();
        int i;
        if ((bool1) && ((bool1 != bool2) || (TalkController.access$getLongTimeGo$p())))
        {
          localObject1 = (Map)paramAnonymousMMBaseAccessibilityConfig.getTalkStringMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
          if (localObject1 == null)
          {
            paramAnonymousMMBaseAccessibilityConfig = null;
            if (paramAnonymousMMBaseAccessibilityConfig != null) {
              break label443;
            }
            if (localObject1 != null) {
              break label405;
            }
            i = 0;
            label297:
            if (!TalkController.INSTANCE.talkString(this.$view, i, paramAccessibilityNodeInfo)) {
              TalkController.INSTANCE.talk(this.$view, paramAccessibilityNodeInfo);
            }
            TalkController.INSTANCE.logMsg("MicroMsg.Acc.TalkController", this.$view, "Talk Success");
            TalkController.access$recordLongTimeGo(TalkController.INSTANCE);
          }
        }
        for (;;)
        {
          TalkController.access$getViewLastValueMap$p().put(Integer.valueOf(this.$view.hashCode()), Boolean.valueOf(bool1));
          paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
          AppMethodBeat.o(234231);
          return paramAnonymousMMBaseAccessibilityConfig;
          paramAnonymousMMBaseAccessibilityConfig = (Integer)((Map)localObject1).get(Integer.valueOf(localView.getId()));
          break;
          label405:
          paramAnonymousMMBaseAccessibilityConfig = (Integer)((Map)localObject1).get(TalkController.INSTANCE.getLayoutId(this.$view));
          if (paramAnonymousMMBaseAccessibilityConfig == null)
          {
            i = 0;
            break label297;
          }
          i = paramAnonymousMMBaseAccessibilityConfig.intValue();
          break label297;
          label443:
          i = paramAnonymousMMBaseAccessibilityConfig.intValue();
          break label297;
          if (bool1)
          {
            localObject1 = paramAccessibilityNodeInfo.getContentDescription();
            paramAnonymousMMBaseAccessibilityConfig = (MMBaseAccessibilityConfig)localObject1;
            if (localObject1 == null) {
              paramAnonymousMMBaseAccessibilityConfig = paramAccessibilityNodeInfo.getText();
            }
            localObject1 = paramAnonymousMMBaseAccessibilityConfig;
            if (paramAnonymousMMBaseAccessibilityConfig == null) {
              localObject1 = (CharSequence)"";
            }
            if (!s.p(TalkController.access$getLastTalkString$p(), localObject1)) {
              this.$view.announceForAccessibility((CharSequence)localObject1);
            }
            paramAnonymousMMBaseAccessibilityConfig = TalkController.INSTANCE;
            TalkController.access$setLastTalkString$p(localObject1.toString());
            TalkController.access$recordLongTimeGo(TalkController.INSTANCE);
          }
        }
      }
    });
    AppMethodBeat.o(234257);
  }
  
  public final int getAuthority()
  {
    return 1;
  }
  
  public final void talk(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234270);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    CharSequence localCharSequence2 = paramAccessibilityNodeInfo.getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (localCharSequence2 == null) {
      localCharSequence1 = paramAccessibilityNodeInfo.getText();
    }
    paramAccessibilityNodeInfo = localCharSequence1;
    if (localCharSequence1 == null) {
      paramAccessibilityNodeInfo = (CharSequence)"";
    }
    lastTalkString = paramAccessibilityNodeInfo.toString();
    logMsg("MicroMsg.Acc.TalkController", paramView, s.X("talk self ", paramAccessibilityNodeInfo));
    paramView.announceForAccessibility(paramAccessibilityNodeInfo);
    AppMethodBeat.o(234270);
  }
  
  public final boolean talkString(View paramView, int paramInt, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234278);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    for (;;)
    {
      CharSequence localCharSequence1;
      try
      {
        String str = MMApplicationContext.getContext().getString(paramInt);
        s.s(str, "getContext().getString(id)");
        CharSequence localCharSequence2 = paramAccessibilityNodeInfo.getContentDescription();
        localCharSequence1 = localCharSequence2;
        if (localCharSequence2 == null) {
          localCharSequence1 = paramAccessibilityNodeInfo.getText();
        }
        if (localCharSequence1 == null)
        {
          paramAccessibilityNodeInfo = (CharSequence)"";
          if (((CharSequence)str).length() != 0) {
            break label212;
          }
          i = 1;
          if (i != 0)
          {
            AppMethodBeat.o(234278);
            return false;
          }
          paramView.announceForAccessibility((CharSequence)str);
          logMsg("MicroMsg.Acc.TalkController", paramView, s.X("talk string ", str));
          lastTalkString = paramAccessibilityNodeInfo.toString();
          AppMethodBeat.o(234278);
          return true;
        }
      }
      finally
      {
        Log.e("MicroMsg.Acc.TalkController", "talkString throw " + paramAccessibilityNodeInfo.getClass().getClass().getName() + ' ' + paramAccessibilityNodeInfo.getMessage() + " viewid:" + paramView.getId() + " stringid:" + paramInt + ' ');
        AppMethodBeat.o(234278);
        return false;
      }
      paramAccessibilityNodeInfo = localCharSequence1;
      continue;
      label212:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.TalkController
 * JD-Core Version:    0.7.0.1
 */