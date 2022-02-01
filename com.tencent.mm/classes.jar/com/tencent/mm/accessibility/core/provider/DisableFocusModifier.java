package com.tencent.mm.accessibility.core.provider;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.uitl.AccUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/DisableFocusModifier;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "TAG", "", "dealNodeInfo", "", "view", "Landroid/view/View;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getAuthority", "", "needDisFocus", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DisableFocusModifier
  extends Provider
{
  public static final DisableFocusModifier INSTANCE;
  public static final String TAG = "MicroMsg.Acc.DisableFocusModifier";
  
  static
  {
    AppMethodBeat.i(234306);
    DisableFocusModifier localDisableFocusModifier = new DisableFocusModifier();
    INSTANCE = localDisableFocusModifier;
    localDisableFocusModifier.addRootIdMapper$plugin_autoaccessibility_release((m)1.INSTANCE);
    AppMethodBeat.o(234306);
  }
  
  private final boolean needDisFocus(View paramView)
  {
    AppMethodBeat.i(234296);
    boolean bool = getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234243);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "config");
        List localList = (List)paramAnonymousMMBaseAccessibilityConfig.getDisFocusViewRootMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localList == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234243);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        if (paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, localList) != null) {}
        for (boolean bool = true;; bool = false)
        {
          AppMethodBeat.o(234243);
          return Boolean.valueOf(bool);
        }
      }
    });
    AppMethodBeat.o(234296);
    return bool;
  }
  
  public final void dealNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234310);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    if (needDisFocus(paramView))
    {
      logMsg("MicroMsg.Acc.DisableFocusModifier", paramView, "success ");
      paramView.setImportantForAccessibility(2);
    }
    AppMethodBeat.o(234310);
  }
  
  public final int getAuthority()
  {
    AppMethodBeat.i(234314);
    if (AccUtil.INSTANCE.isAccessibilityEnabled())
    {
      AppMethodBeat.o(234314);
      return 1;
    }
    AppMethodBeat.o(234314);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.DisableFocusModifier
 * JD-Core Version:    0.7.0.1
 */