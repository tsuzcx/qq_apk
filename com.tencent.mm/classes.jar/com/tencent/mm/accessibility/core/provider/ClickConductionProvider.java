package com.tencent.mm.accessibility.core.provider;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.uitl.AccUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/ClickConductionProvider;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "TAG", "", "dealAccEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "dealOnViewInflateAsync", "getAuthority", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ClickConductionProvider
  extends Provider
{
  public static final ClickConductionProvider INSTANCE;
  public static final String TAG = "MicroMsg.Acc.ClickConductionProvider";
  
  static
  {
    AppMethodBeat.i(234256);
    INSTANCE = new ClickConductionProvider();
    AppMethodBeat.o(234256);
  }
  
  public final void dealAccEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(234273);
    s.u(paramView, "view");
    s.u(paramAccessibilityEvent, "event");
    if (((paramAccessibilityEvent.getEventType() & 0x1) != 1) || (!AccUtil.INSTANCE.isAccessibilityEnabled()))
    {
      AppMethodBeat.o(234273);
      return;
    }
    logMsg("MicroMsg.Acc.ClickConductionProvider", paramView, "ClickEvent get");
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234212);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        Map localMap = (Map)paramAnonymousMMBaseAccessibilityConfig.getClickViewRootTargetMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localMap == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234212);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        View localView = paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, p.p((Iterable)localMap.keySet()));
        if (localView == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234212);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        r localr = (r)localMap.get(Integer.valueOf(localView.getId()));
        paramAnonymousMMBaseAccessibilityConfig = localr;
        if (localr == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = (r)localMap.get(ClickConductionProvider.INSTANCE.getLayoutId(localView));
          if (paramAnonymousMMBaseAccessibilityConfig == null)
          {
            paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
            AppMethodBeat.o(234212);
            return paramAnonymousMMBaseAccessibilityConfig;
          }
        }
        ClickConductionProvider.INSTANCE.logMsg("MicroMsg.Acc.ClickConductionProvider", this.$view, "success Found data, perform Click");
        if (((Boolean)((b)paramAnonymousMMBaseAccessibilityConfig.bsD).invoke(this.$view)).booleanValue())
        {
          paramAnonymousMMBaseAccessibilityConfig = localView.findViewById(((Number)paramAnonymousMMBaseAccessibilityConfig.bsC).intValue());
          if (paramAnonymousMMBaseAccessibilityConfig == null) {}
          for (paramAnonymousMMBaseAccessibilityConfig = null; paramAnonymousMMBaseAccessibilityConfig == null; paramAnonymousMMBaseAccessibilityConfig = Boolean.valueOf(paramAnonymousMMBaseAccessibilityConfig.performClick()))
          {
            paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
            AppMethodBeat.o(234212);
            return paramAnonymousMMBaseAccessibilityConfig;
          }
          paramAnonymousMMBaseAccessibilityConfig.booleanValue();
        }
        paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
        AppMethodBeat.o(234212);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234273);
  }
  
  public final void dealOnViewInflateAsync(View paramView)
  {
    AppMethodBeat.i(234266);
    s.u(paramView, "view");
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234182);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        if (paramAnonymousMMBaseAccessibilityConfig.getClickViewRootTargetMap$plugin_autoaccessibility_release().containsKey(Integer.valueOf(this.$view.getId())))
        {
          ClickConductionProvider.INSTANCE.logMsg("MicroMsg.Acc.ClickConductionProvider", this.$view, "set Clickable true");
          this.$view.setClickable(true);
          paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
          AppMethodBeat.o(234182);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
        AppMethodBeat.o(234182);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234266);
  }
  
  public final int getAuthority()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.ClickConductionProvider
 * JD-Core Version:    0.7.0.1
 */