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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/CallbackCaller;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "CLEAR_DELAY_TIME", "", "TAG", "", "clearTask", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "hoverViewId", "", "dealAccEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "dealNodeInfo", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getAuthority", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CallbackCaller
  extends Provider
{
  private static final long CLEAR_DELAY_TIME = 500L;
  public static final CallbackCaller INSTANCE;
  public static final String TAG = "MicroMsg.Acc.CallbackCaller";
  private static final Runnable clearTask;
  private static final Handler handler;
  private static int hoverViewId;
  
  static
  {
    AppMethodBeat.i(234279);
    INSTANCE = new CallbackCaller();
    handler = new Handler(Looper.getMainLooper());
    clearTask = CallbackCaller..ExternalSyntheticLambda0.INSTANCE;
    hoverViewId = -1;
    INSTANCE.addRootIdMapper$plugin_autoaccessibility_release((m)1.INSTANCE);
    AppMethodBeat.o(234279);
  }
  
  private static final void clearTask$lambda-0()
  {
    hoverViewId = -1;
  }
  
  public final void dealAccEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(234298);
    s.u(paramView, "view");
    s.u(paramAccessibilityEvent, "event");
    if ((paramAccessibilityEvent.getEventType() & 0x80) == 128) {
      hoverViewId = paramView.hashCode();
    }
    if ((paramAccessibilityEvent.getEventType() & 0x8000) == 32768)
    {
      hoverViewId = paramView.hashCode();
      logMsg("MicroMsg.Acc.CallbackCaller", paramView, "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
    }
    if ((paramAccessibilityEvent.getEventType() & 0x8000) == 32768) {
      hoverViewId = paramView.hashCode();
    }
    AppMethodBeat.o(234298);
  }
  
  public final void dealNodeInfo(View paramView, final AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234290);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    if ((paramView.hashCode() != hoverViewId) && (!AccUtil.INSTANCE.isCoolAssistRunning()) && (!AccUtil.INSTANCE.isEnableCallbackRealtime()))
    {
      AppMethodBeat.o(234290);
      return;
    }
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        Object localObject1 = null;
        AppMethodBeat.i(234321);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        Object localObject2 = (Map)paramAnonymousMMBaseAccessibilityConfig.getViewRootCallbackMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localObject2 == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234321);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        paramAnonymousMMBaseAccessibilityConfig = paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, p.p((Iterable)((Map)localObject2).keySet()));
        if (paramAnonymousMMBaseAccessibilityConfig == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = null;
          paramAnonymousMMBaseAccessibilityConfig = (b)((Map)localObject2).get(paramAnonymousMMBaseAccessibilityConfig);
          if (paramAnonymousMMBaseAccessibilityConfig != null) {
            break label145;
          }
          paramAnonymousMMBaseAccessibilityConfig = (b)((Map)localObject2).get(CallbackCaller.INSTANCE.getLayoutId(this.$view));
          label113:
          if (paramAnonymousMMBaseAccessibilityConfig != null) {
            break label148;
          }
          paramAnonymousMMBaseAccessibilityConfig = localObject1;
        }
        for (;;)
        {
          if (paramAnonymousMMBaseAccessibilityConfig != null) {
            break label209;
          }
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234321);
          return paramAnonymousMMBaseAccessibilityConfig;
          paramAnonymousMMBaseAccessibilityConfig = Integer.valueOf(paramAnonymousMMBaseAccessibilityConfig.getId());
          break;
          label145:
          break label113;
          label148:
          localObject2 = (String)paramAnonymousMMBaseAccessibilityConfig.invoke(this.$view);
          paramAnonymousMMBaseAccessibilityConfig = localObject1;
          if (localObject2 != null)
          {
            paramAnonymousMMBaseAccessibilityConfig = paramAccessibilityNodeInfo;
            CallbackCaller.access$getHandler$p().removeCallbacks(CallbackCaller.access$getClearTask$p());
            paramAnonymousMMBaseAccessibilityConfig.setContentDescription((CharSequence)localObject2);
            paramAnonymousMMBaseAccessibilityConfig = Boolean.valueOf(CallbackCaller.access$getHandler$p().postDelayed(CallbackCaller.access$getClearTask$p(), 500L));
          }
        }
        label209:
        paramAnonymousMMBaseAccessibilityConfig.booleanValue();
        paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
        AppMethodBeat.o(234321);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234290);
  }
  
  public final int getAuthority()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.CallbackCaller
 * JD-Core Version:    0.7.0.1
 */