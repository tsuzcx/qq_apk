package com.tencent.mm.accessibility.core.provider;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.ViewTag;
import com.tencent.mm.accessibility.core.ViewTagManager;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.accessibility.uitl.IdUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/DisableChildModifier;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "TAG", "", "dealNodeInfo", "", "view", "Landroid/view/View;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "dealOnViewInflateAsync", "getAuthority", "", "needDisFocusChild", "callback", "Lkotlin/Function1;", "visitChild", "root", "visitor", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DisableChildModifier
  extends Provider
{
  public static final DisableChildModifier INSTANCE;
  public static final String TAG = "MicroMsg.Acc.DisableChildModifier";
  
  static
  {
    AppMethodBeat.i(234271);
    DisableChildModifier localDisableChildModifier = new DisableChildModifier();
    INSTANCE = localDisableChildModifier;
    localDisableChildModifier.addRootIdMapper$plugin_autoaccessibility_release((m)1.INSTANCE);
    AppMethodBeat.o(234271);
  }
  
  private final void needDisFocusChild(View paramView, final b<? super View, ah> paramb)
  {
    AppMethodBeat.i(234251);
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234288);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        List localList = (List)paramAnonymousMMBaseAccessibilityConfig.getDisableChildViewRootMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localList == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234288);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        DisableChildModifier.INSTANCE.logMsg("MicroMsg.Acc.DisableChildModifier", this.$view, "find rootIds, prepare findRoot");
        if (paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, localList) != null) {
          paramb.invoke(this.$view);
        }
        paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
        AppMethodBeat.o(234288);
        return paramAnonymousMMBaseAccessibilityConfig;
      }
    });
    AppMethodBeat.o(234251);
  }
  
  private final void visitChild(View paramView, b<? super View, ah> paramb)
  {
    AppMethodBeat.i(234242);
    int i;
    int k;
    if ((paramView instanceof ViewGroup))
    {
      i = 0;
      k = ((ViewGroup)paramView).getChildCount();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      View localView = ((ViewGroup)paramView).getChildAt(i);
      s.s(localView, "child");
      paramb.invoke(localView);
      visitChild(localView, paramb);
      if (j >= k)
      {
        AppMethodBeat.o(234242);
        return;
      }
      i = j;
    }
  }
  
  public final void dealNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234275);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    ViewTag localViewTag = ViewTagManager.INSTANCE.getTagData(paramView);
    if (localViewTag == null) {}
    for (boolean bool = false;; bool = s.p(localViewTag.getDisableFocusFlag(), Boolean.TRUE))
    {
      if (bool)
      {
        paramAccessibilityNodeInfo.setVisibleToUser(false);
        paramView.setImportantForAccessibility(4);
      }
      AppMethodBeat.o(234275);
      return;
    }
  }
  
  public final void dealOnViewInflateAsync(View paramView)
  {
    AppMethodBeat.i(234282);
    s.u(paramView, "view");
    needDisFocusChild(paramView, (b)new u(paramView)
    {
      public final void invoke(View paramAnonymousView)
      {
        AppMethodBeat.i(234265);
        s.u(paramAnonymousView, "it");
        DisableChildModifier.access$visitChild(DisableChildModifier.INSTANCE, this.$view, (b)new u(this.$view)
        {
          public final void invoke(View paramAnonymous2View)
          {
            AppMethodBeat.i(234215);
            s.u(paramAnonymous2View, "it");
            paramAnonymous2View = ViewTagManager.INSTANCE.getTagData(paramAnonymous2View);
            if (paramAnonymous2View != null) {
              paramAnonymous2View.setDisableFocusFlag(Boolean.TRUE);
            }
            DisableChildModifier.INSTANCE.logMsg("MicroMsg.Acc.DisableChildModifier", this.$view, s.X("success set tag_acc_disable_flag on child", IdUtil.INSTANCE.getName(this.$view.getId())));
            AppMethodBeat.o(234215);
          }
        });
        AppMethodBeat.o(234265);
      }
    });
    AppMethodBeat.o(234282);
  }
  
  public final int getAuthority()
  {
    AppMethodBeat.i(234286);
    if (AccUtil.INSTANCE.isAccessibilityEnabled()) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(234286);
      return i | 0x2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.DisableChildModifier
 * JD-Core Version:    0.7.0.1
 */