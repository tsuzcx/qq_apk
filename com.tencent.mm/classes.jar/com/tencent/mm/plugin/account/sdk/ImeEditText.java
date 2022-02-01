package com.tencent.mm.plugin.account.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.b;
import com.tencent.mm.plugin.account.a.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/sdk/ImeEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSafetyMode", "", "logoDrawable", "Landroid/graphics/drawable/Drawable;", "logoWidth", "Ljava/lang/Integer;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "onNewClickListener", "Landroid/view/View$OnClickListener;", "onNewFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "onOriClickListener", "onOriFocusChangeListener", "getLogoWidth", "ifShowImeIndependent", "initView", "", "onFinishInflate", "onSelectionChanged", "selStart", "selEnd", "setEnabled", "enabled", "setOnClickListener", "l", "setOnFocusChangeListener", "switchToSafetyMode", "updateLogoStatus", "Companion", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeEditText
  extends AppCompatEditText
{
  public static final ImeEditText.a pWP;
  private Drawable pWQ;
  private Integer pWR;
  private boolean pWS;
  private View.OnFocusChangeListener pWT;
  private View.OnFocusChangeListener pWU;
  private View.OnClickListener pWV;
  private final View.OnClickListener pWW;
  private final View.OnTouchListener pWX;
  
  static
  {
    AppMethodBeat.i(304691);
    pWP = new ImeEditText.a((byte)0);
    AppMethodBeat.o(304691);
  }
  
  public ImeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304636);
    this.pWU = new ImeEditText..ExternalSyntheticLambda1(this);
    this.pWW = new ImeEditText..ExternalSyntheticLambda0(this);
    this.pWX = new ImeEditText..ExternalSyntheticLambda2(this);
    initView();
    AppMethodBeat.o(304636);
  }
  
  public ImeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304641);
    this.pWU = new ImeEditText..ExternalSyntheticLambda1(this);
    this.pWW = new ImeEditText..ExternalSyntheticLambda0(this);
    this.pWX = new ImeEditText..ExternalSyntheticLambda2(this);
    initView();
    AppMethodBeat.o(304641);
  }
  
  private static final void a(ImeEditText paramImeEditText, View paramView)
  {
    AppMethodBeat.i(304677);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramImeEditText);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/sdk/ImeEditText", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramImeEditText, "this$0");
    if ((paramImeEditText.bXM()) && (com.tencent.mm.plugin.hld.d.a.JqJ.a((EditText)paramImeEditText, paramImeEditText.getContext())))
    {
      localObject = com.tencent.mm.plugin.hld.d.a.JqJ;
      com.tencent.mm.plugin.hld.d.a.fLy();
    }
    paramImeEditText = paramImeEditText.pWV;
    if (paramImeEditText != null) {
      paramImeEditText.onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/account/sdk/ImeEditText", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(304677);
  }
  
  private static final void a(ImeEditText paramImeEditText, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(304673);
    s.u(paramImeEditText, "this$0");
    if (paramImeEditText.bXM()) {
      paramImeEditText.post(new ImeEditText..ExternalSyntheticLambda3(paramBoolean, paramImeEditText));
    }
    paramImeEditText = paramImeEditText.pWT;
    if (paramImeEditText != null) {
      paramImeEditText.onFocusChange(paramView, paramBoolean);
    }
    AppMethodBeat.o(304673);
  }
  
  private static final void a(boolean paramBoolean, ImeEditText paramImeEditText)
  {
    AppMethodBeat.i(304668);
    s.u(paramImeEditText, "this$0");
    if (paramBoolean)
    {
      if (com.tencent.mm.plugin.hld.d.a.JqJ.a((EditText)paramImeEditText, paramImeEditText.getContext()))
      {
        paramImeEditText = com.tencent.mm.plugin.hld.d.a.JqJ;
        com.tencent.mm.plugin.hld.d.a.fLy();
        AppMethodBeat.o(304668);
      }
    }
    else
    {
      com.tencent.mm.plugin.hld.d.a.JqJ.a(null, null);
      paramImeEditText = com.tencent.mm.plugin.hld.d.a.JqJ;
      com.tencent.mm.plugin.hld.d.a.onHide();
    }
    AppMethodBeat.o(304668);
  }
  
  private static final boolean a(ImeEditText paramImeEditText, View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = null;
    paramView = null;
    AppMethodBeat.i(304685);
    s.u(paramImeEditText, "this$0");
    if (paramImeEditText.getCompoundDrawables()[2] == null)
    {
      AppMethodBeat.o(304685);
      return false;
    }
    if (paramMotionEvent.getAction() != 1)
    {
      AppMethodBeat.o(304685);
      return false;
    }
    if ((paramImeEditText.pWQ != null) && (paramMotionEvent.getX() > paramImeEditText.getWidth() - paramImeEditText.getPaddingRight() - paramImeEditText.getLogoWidth()))
    {
      paramMotionEvent = com.tencent.mm.plugin.hld.d.a.JqJ;
      if (com.tencent.mm.plugin.hld.d.a.fLB())
      {
        if (!paramImeEditText.pWS) {
          break label195;
        }
        paramImeEditText.pWS = false;
        paramImeEditText.setShowSoftInputOnFocus(true);
        paramImeEditText.getInputExtras(true).putBoolean("is_safety_keyboard", false);
        paramMotionEvent = com.tencent.mm.plugin.hld.d.a.JqJ;
        com.tencent.mm.plugin.hld.d.a.onHide();
        if (paramImeEditText.hasFocus())
        {
          paramMotionEvent = paramImeEditText.getContext();
          if (paramMotionEvent == null) {}
          while (paramView == null)
          {
            paramImeEditText = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(304685);
            throw paramImeEditText;
            paramView = paramMotionEvent.getSystemService("input_method");
          }
          ((InputMethodManager)paramView).showSoftInput((View)paramImeEditText, 0);
        }
      }
    }
    for (;;)
    {
      paramImeEditText.bXN();
      AppMethodBeat.o(304685);
      return false;
      label195:
      paramImeEditText.pWS = true;
      paramImeEditText.setShowSoftInputOnFocus(false);
      paramImeEditText.getInputExtras(true).putBoolean("is_safety_keyboard", true);
      paramView = paramImeEditText.getContext();
      if (paramView == null) {}
      for (paramView = localObject; paramView == null; paramView = paramView.getSystemService("input_method"))
      {
        paramImeEditText = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(304685);
        throw paramImeEditText;
      }
      ((InputMethodManager)paramView).hideSoftInputFromWindow(paramImeEditText.getWindowToken(), 0);
      if ((paramImeEditText.hasFocus()) && (com.tencent.mm.plugin.hld.d.a.JqJ.a((EditText)paramImeEditText, paramImeEditText.getContext())))
      {
        paramView = com.tencent.mm.plugin.hld.d.a.JqJ;
        com.tencent.mm.plugin.hld.d.a.fLy();
      }
    }
  }
  
  private final boolean bXM()
  {
    AppMethodBeat.i(304652);
    if (this.pWS)
    {
      com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.JqJ;
      if (com.tencent.mm.plugin.hld.d.a.fLB())
      {
        AppMethodBeat.o(304652);
        return true;
      }
    }
    AppMethodBeat.o(304652);
    return false;
  }
  
  private final void bXN()
  {
    AppMethodBeat.i(304656);
    Object localObject = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (!com.tencent.mm.plugin.hld.d.a.fLB())
    {
      AppMethodBeat.o(304656);
      return;
    }
    if (isEnabled())
    {
      localObject = MMApplicationContext.getResources();
      if (bXM()) {}
      for (int i = a.d.icons_outlined_keyboard;; i = a.d.safe_keyboard)
      {
        this.pWQ = com.tencent.mm.svg.a.a.i((Resources)localObject, i);
        localObject = this.pWQ;
        if (localObject == null) {
          break;
        }
        this.pWQ = ((Drawable)localObject).mutate();
        ((Drawable)localObject).setColorFilter(getResources().getColor(a.a.FG_1), PorterDuff.Mode.SRC_ATOP);
        ((Drawable)localObject).setBounds(0, 0, getLogoWidth(), getLogoWidth());
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], (Drawable)localObject, getCompoundDrawables()[3]);
        AppMethodBeat.o(304656);
        return;
      }
    }
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(304656);
  }
  
  private final int getLogoWidth()
  {
    AppMethodBeat.i(304662);
    if (this.pWR == null) {
      this.pWR = Integer.valueOf(com.tencent.mm.cd.a.bs(getContext(), a.b.Edge_3A));
    }
    Integer localInteger = this.pWR;
    s.checkNotNull(localInteger);
    int i = localInteger.intValue();
    AppMethodBeat.o(304662);
    return i;
  }
  
  private final void initView()
  {
    AppMethodBeat.i(304646);
    super.setOnClickListener(this.pWW);
    AppMethodBeat.o(304646);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(304719);
    super.onFinishInflate();
    com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (!com.tencent.mm.plugin.hld.d.a.fLB())
    {
      AppMethodBeat.o(304719);
      return;
    }
    setOnTouchListener(this.pWX);
    bXN();
    AppMethodBeat.o(304719);
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304731);
    super.onSelectionChanged(paramInt1, paramInt2);
    if (bXM())
    {
      com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.JqJ;
      com.tencent.mm.plugin.hld.d.a.fLz();
    }
    AppMethodBeat.o(304731);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(304733);
    super.setEnabled(paramBoolean);
    bXN();
    AppMethodBeat.o(304733);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pWV = paramOnClickListener;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(304725);
    this.pWT = paramOnFocusChangeListener;
    super.setOnFocusChangeListener(this.pWU);
    AppMethodBeat.o(304725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.ImeEditText
 * JD-Core Version:    0.7.0.1
 */