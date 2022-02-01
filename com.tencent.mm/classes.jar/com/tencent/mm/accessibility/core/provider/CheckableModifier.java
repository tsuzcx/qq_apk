package com.tencent.mm.accessibility.core.provider;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.uitl.AccUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/CheckableModifier;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "CLEAR_DELAY_TIME", "", "TAG", "", "clearTask", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "hoverViewId", "", "dealAccEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "dealNodeInfo", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getAuthority", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CheckableModifier
  extends Provider
{
  private static final long CLEAR_DELAY_TIME = 500L;
  public static final CheckableModifier INSTANCE;
  public static final String TAG = "MicroMsg.Acc.CheckableModifier";
  private static final Runnable clearTask;
  private static final Handler handler;
  private static int hoverViewId;
  
  static
  {
    AppMethodBeat.i(234328);
    INSTANCE = new CheckableModifier();
    handler = new Handler(Looper.getMainLooper());
    clearTask = CheckableModifier..ExternalSyntheticLambda0.INSTANCE;
    hoverViewId = -1;
    INSTANCE.addRootIdMapper$plugin_autoaccessibility_release((m)1.INSTANCE);
    AppMethodBeat.o(234328);
  }
  
  private static final void clearTask$lambda-0()
  {
    hoverViewId = -1;
  }
  
  public final void dealAccEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(234349);
    s.u(paramView, "view");
    s.u(paramAccessibilityEvent, "event");
    if ((paramAccessibilityEvent.getEventType() & 0x80) == 128) {
      hoverViewId = paramView.hashCode();
    }
    if ((paramAccessibilityEvent.getEventType() & 0x8000) == 32768)
    {
      hoverViewId = paramView.hashCode();
      logMsg("MicroMsg.Acc.CheckableModifier", paramView, "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
    }
    if ((paramAccessibilityEvent.getEventType() & 0x8000) == 32768) {
      hoverViewId = paramView.hashCode();
    }
    AppMethodBeat.o(234349);
  }
  
  public final void dealNodeInfo(View paramView, final AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234342);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    if ((paramView.hashCode() != hoverViewId) && (!AccUtil.INSTANCE.isCoolAssistRunning()) && (!AccUtil.INSTANCE.isEnableCallbackRealtime()))
    {
      AppMethodBeat.o(234342);
      return;
    }
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234232);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        Map localMap = (Map)paramAnonymousMMBaseAccessibilityConfig.getViewRootCheckedMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localMap == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234232);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        paramAnonymousMMBaseAccessibilityConfig = paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, p.p((Iterable)localMap.keySet()));
        Object localObject;
        if (paramAnonymousMMBaseAccessibilityConfig == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = null;
          localObject = (r)localMap.get(paramAnonymousMMBaseAccessibilityConfig);
          paramAnonymousMMBaseAccessibilityConfig = (MMBaseAccessibilityConfig)localObject;
          if (localObject == null) {
            paramAnonymousMMBaseAccessibilityConfig = (r)localMap.get(CheckableModifier.INSTANCE.getLayoutId(this.$view));
          }
          if (paramAnonymousMMBaseAccessibilityConfig == null) {
            break label244;
          }
          localObject = (b)paramAnonymousMMBaseAccessibilityConfig.bsD;
          if ((localObject == null) || (((Boolean)((b)localObject).invoke(this.$view)).booleanValue() != true)) {
            break label244;
          }
        }
        label244:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label249;
          }
          paramAnonymousMMBaseAccessibilityConfig = ((b)paramAnonymousMMBaseAccessibilityConfig.bsC).invoke(this.$view);
          localObject = paramAccessibilityNodeInfo;
          boolean bool = ((Boolean)paramAnonymousMMBaseAccessibilityConfig).booleanValue();
          ((AccessibilityNodeInfo)localObject).setCheckable(true);
          ((AccessibilityNodeInfo)localObject).setChecked(bool);
          CheckableModifier.access$getHandler$p().postDelayed(CheckableModifier.access$getClearTask$p(), 500L);
          paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
          AppMethodBeat.o(234232);
          return paramAnonymousMMBaseAccessibilityConfig;
          paramAnonymousMMBaseAccessibilityConfig = Integer.valueOf(paramAnonymousMMBaseAccessibilityConfig.getId());
          break;
        }
        label249:
        paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
        AppMethodBeat.o(234232);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234342);
  }
  
  public final int getAuthority()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.CheckableModifier
 * JD-Core Version:    0.7.0.1
 */