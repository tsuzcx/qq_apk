package com.tencent.mm.accessibility.core.provider;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/PreFocusModifier;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "TAG", "", "dealNodeInfo", "", "view", "Landroid/view/View;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "dealOnViewInflateAsync", "getAuthority", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PreFocusModifier
  extends Provider
{
  public static final PreFocusModifier INSTANCE;
  public static final String TAG = "MicroMsg.Acc.PreFocusModifier";
  
  static
  {
    AppMethodBeat.i(234214);
    PreFocusModifier localPreFocusModifier = new PreFocusModifier();
    INSTANCE = localPreFocusModifier;
    localPreFocusModifier.addRootIdMapper$plugin_autoaccessibility_release((m)1.INSTANCE);
    AppMethodBeat.o(234214);
  }
  
  public final void dealNodeInfo(View paramView, final AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234228);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    super.dealNodeInfo(paramView, paramAccessibilityNodeInfo);
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234303);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        if ((!paramAnonymousMMBaseAccessibilityConfig.getViewRootCallbackMap$plugin_autoaccessibility_release().containsKey(Integer.valueOf(this.$view.getId()))) && (!paramAnonymousMMBaseAccessibilityConfig.getViewRootDescMap$plugin_autoaccessibility_release().containsKey(Integer.valueOf(this.$view.getId()))) && (!paramAnonymousMMBaseAccessibilityConfig.getTalkMap$plugin_autoaccessibility_release().containsKey(Integer.valueOf(this.$view.getId()))) && (!paramAnonymousMMBaseAccessibilityConfig.getClickViewRootTargetMap$plugin_autoaccessibility_release().containsKey(Integer.valueOf(this.$view.getId()))))
        {
          paramAnonymousMMBaseAccessibilityConfig = paramAnonymousMMBaseAccessibilityConfig.getStartViewId$plugin_autoaccessibility_release();
          int i = this.$view.getId();
          if (paramAnonymousMMBaseAccessibilityConfig == null) {}
          while (paramAnonymousMMBaseAccessibilityConfig.intValue() != i)
          {
            paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
            AppMethodBeat.o(234303);
            return paramAnonymousMMBaseAccessibilityConfig;
          }
        }
        paramAccessibilityNodeInfo.setFocusable(true);
        paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
        AppMethodBeat.o(234303);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234228);
  }
  
  public final void dealOnViewInflateAsync(View paramView)
  {
    AppMethodBeat.i(234219);
    s.u(paramView, "view");
    getConfig(paramView, (b)new u(paramView)
    {
      private static final void invoke$lambda-0(View paramAnonymousView)
      {
        AppMethodBeat.i(234280);
        s.u(paramAnonymousView, "$view");
        paramAnonymousView.setImportantForAccessibility(1);
        PreFocusModifier.INSTANCE.logMsg("MicroMsg.Acc.PreFocusModifier", paramAnonymousView, "success pre focus");
        AppMethodBeat.o(234280);
      }
      
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234293);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        if ((!paramAnonymousMMBaseAccessibilityConfig.getViewRootCallbackMap$plugin_autoaccessibility_release().containsKey(Integer.valueOf(this.$view.getId()))) && (!paramAnonymousMMBaseAccessibilityConfig.getViewRootDescMap$plugin_autoaccessibility_release().containsKey(Integer.valueOf(this.$view.getId()))) && (!paramAnonymousMMBaseAccessibilityConfig.getTalkMap$plugin_autoaccessibility_release().containsKey(Integer.valueOf(this.$view.getId()))))
        {
          paramAnonymousMMBaseAccessibilityConfig = paramAnonymousMMBaseAccessibilityConfig.getStartViewId$plugin_autoaccessibility_release();
          int i = this.$view.getId();
          if (paramAnonymousMMBaseAccessibilityConfig == null) {}
          while (paramAnonymousMMBaseAccessibilityConfig.intValue() != i)
          {
            paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
            AppMethodBeat.o(234293);
            return paramAnonymousMMBaseAccessibilityConfig;
          }
        }
        h.ahAA.bk(new PreFocusModifier.dealOnViewInflateAsync.1..ExternalSyntheticLambda0(this.$view));
        paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
        AppMethodBeat.o(234293);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234219);
  }
  
  public final int getAuthority()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.PreFocusModifier
 * JD-Core Version:    0.7.0.1
 */