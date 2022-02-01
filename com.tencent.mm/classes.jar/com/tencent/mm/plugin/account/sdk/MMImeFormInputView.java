package com.tencent.mm.plugin.account.sdk;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.plugin.account.a.d;
import com.tencent.mm.ui.base.MMFormInputView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/sdk/MMImeFormInputView;", "Lcom/tencent/mm/ui/base/MMFormInputView;", "Lcom/tencent/mm/plugin/account/sdk/IImeEditTextEnableListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clearMask", "Landroid/view/View;", "contentET", "Lcom/tencent/mm/plugin/account/sdk/MMImeClearEditText;", "logoIv", "Landroid/widget/ImageView;", "initView", "", "onEnable", "onFinishInflate", "setEnabled", "enabled", "", "updateLogoStatus", "Companion", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMImeFormInputView
  extends MMFormInputView
  implements b
{
  public static final MMImeFormInputView.a pWZ;
  private MMImeClearEditText pXa;
  private ImageView pXb;
  private View pXc;
  
  static
  {
    AppMethodBeat.i(304686);
    pWZ = new MMImeFormInputView.a((byte)0);
    AppMethodBeat.o(304686);
  }
  
  public MMImeFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304651);
    initView();
    AppMethodBeat.o(304651);
  }
  
  public MMImeFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304654);
    initView();
    AppMethodBeat.o(304654);
  }
  
  private static final void a(MMImeFormInputView paramMMImeFormInputView, View paramView)
  {
    AppMethodBeat.i(304676);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMMImeFormInputView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/sdk/MMImeFormInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMMImeFormInputView, "this$0");
    paramMMImeFormInputView = paramMMImeFormInputView.pXa;
    if (paramMMImeFormInputView != null) {
      paramMMImeFormInputView.jmg();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/account/sdk/MMImeFormInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(304676);
  }
  
  private static final void a(MMImeFormInputView paramMMImeFormInputView, boolean paramBoolean)
  {
    AppMethodBeat.i(304669);
    s.u(paramMMImeFormInputView, "this$0");
    if (paramBoolean)
    {
      paramMMImeFormInputView = paramMMImeFormInputView.pXc;
      if (paramMMImeFormInputView != null)
      {
        paramMMImeFormInputView.setVisibility(0);
        AppMethodBeat.o(304669);
      }
    }
    else
    {
      paramMMImeFormInputView = paramMMImeFormInputView.pXc;
      if (paramMMImeFormInputView != null) {
        paramMMImeFormInputView.setVisibility(8);
      }
    }
    AppMethodBeat.o(304669);
  }
  
  private static final void b(MMImeFormInputView paramMMImeFormInputView, View paramView)
  {
    AppMethodBeat.i(304681);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMMImeFormInputView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/sdk/MMImeFormInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMMImeFormInputView, "this$0");
    localObject = paramMMImeFormInputView.pXa;
    if (localObject != null)
    {
      paramView = com.tencent.mm.plugin.hld.d.a.JqJ;
      if (com.tencent.mm.plugin.hld.d.a.fLB())
      {
        if (!((MMImeClearEditText)localObject).pWS) {
          break label216;
        }
        ((MMImeClearEditText)localObject).pWS = false;
        ((MMImeClearEditText)localObject).setShowSoftInputOnFocus(true);
        ((MMImeClearEditText)localObject).getInputExtras(true).putBoolean("is_safety_keyboard", false);
        paramView = com.tencent.mm.plugin.hld.d.a.JqJ;
        com.tencent.mm.plugin.hld.d.a.onHide();
        if (((MMImeClearEditText)localObject).hasFocus())
        {
          paramView = ((MMImeClearEditText)localObject).getContext();
          if (paramView == null) {}
          for (paramView = null; paramView == null; paramView = paramView.getSystemService("input_method"))
          {
            paramMMImeFormInputView = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(304681);
            throw paramMMImeFormInputView;
          }
          ((InputMethodManager)paramView).showSoftInput((View)localObject, 0);
        }
      }
      if (!((MMImeClearEditText)localObject).bXM()) {
        break label326;
      }
      paramMMImeFormInputView = paramMMImeFormInputView.pXb;
      if (paramMMImeFormInputView != null) {
        paramMMImeFormInputView.setImageResource(a.d.icons_outlined_keyboard);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/account/sdk/MMImeFormInputView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(304681);
      return;
      label216:
      ((MMImeClearEditText)localObject).pWS = true;
      ((MMImeClearEditText)localObject).setShowSoftInputOnFocus(false);
      ((MMImeClearEditText)localObject).getInputExtras(true).putBoolean("is_safety_keyboard", true);
      paramView = ((MMImeClearEditText)localObject).getContext();
      if (paramView == null) {}
      for (paramView = null; paramView == null; paramView = paramView.getSystemService("input_method"))
      {
        paramMMImeFormInputView = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(304681);
        throw paramMMImeFormInputView;
      }
      ((InputMethodManager)paramView).hideSoftInputFromWindow(((MMImeClearEditText)localObject).getWindowToken(), 0);
      if ((!((MMImeClearEditText)localObject).hasFocus()) || (!com.tencent.mm.plugin.hld.d.a.JqJ.a((EditText)localObject, ((MMImeClearEditText)localObject).getContext()))) {
        break;
      }
      paramView = com.tencent.mm.plugin.hld.d.a.JqJ;
      com.tencent.mm.plugin.hld.d.a.fLy();
      break;
      label326:
      paramMMImeFormInputView = paramMMImeFormInputView.pXb;
      if (paramMMImeFormInputView != null) {
        paramMMImeFormInputView.setImageResource(a.d.safe_keyboard);
      }
    }
  }
  
  private final void bXN()
  {
    AppMethodBeat.i(304663);
    Object localObject = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (!com.tencent.mm.plugin.hld.d.a.fLB())
    {
      AppMethodBeat.o(304663);
      return;
    }
    localObject = (MMImeClearEditText)findViewById(a.c.edittext);
    ImageView localImageView = (ImageView)findViewById(a.c.logo_iv);
    if (((MMImeClearEditText)localObject).isEnabled())
    {
      localImageView.setVisibility(0);
      AppMethodBeat.o(304663);
      return;
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(304663);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(304658);
    this.pXb = ((ImageView)findViewById(a.c.logo_iv));
    this.pXa = ((MMImeClearEditText)findViewById(a.c.edittext));
    this.pXc = findViewById(a.c.clear_mask);
    Object localObject = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (com.tencent.mm.plugin.hld.d.a.fLB())
    {
      localObject = this.pXb;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.pXa;
      if (localObject != null) {
        ((MMImeClearEditText)localObject).setImeEditTextEnableListener((b)this);
      }
    }
    for (;;)
    {
      localObject = this.pXa;
      if (localObject != null) {
        ((MMImeClearEditText)localObject).setClearBtnCallBcakListener(new MMImeFormInputView..ExternalSyntheticLambda2(this));
      }
      localObject = this.pXc;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new MMImeFormInputView..ExternalSyntheticLambda1(this));
      }
      AppMethodBeat.o(304658);
      return;
      localObject = this.pXb;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
  }
  
  public final void bXL()
  {
    AppMethodBeat.i(304721);
    bXN();
    AppMethodBeat.o(304721);
  }
  
  public final void onFinishInflate()
  {
    AppMethodBeat.i(304716);
    super.onFinishInflate();
    Object localObject = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (!com.tencent.mm.plugin.hld.d.a.fLB())
    {
      AppMethodBeat.o(304716);
      return;
    }
    localObject = this.pXb;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(new MMImeFormInputView..ExternalSyntheticLambda0(this));
    }
    bXN();
    AppMethodBeat.o(304716);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(304709);
    super.setEnabled(paramBoolean);
    bXN();
    AppMethodBeat.o(304709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.MMImeFormInputView
 * JD-Core Version:    0.7.0.1
 */