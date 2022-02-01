package com.tencent.mm.plugin.account.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMClearEditText;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/account/sdk/MMImeClearEditText;", "Lcom/tencent/mm/ui/base/MMClearEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iImeEditTextEnableListener", "Lcom/tencent/mm/plugin/account/sdk/IImeEditTextEnableListener;", "isSafetyMode", "", "onNewClickListener", "Landroid/view/View$OnClickListener;", "onNewFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "onOriClickListener", "onOriFocusChangeListener", "ifShowImeIndependent", "initView", "", "onFinishInflate", "onSelectionChanged", "selStart", "selEnd", "setEnabled", "enabled", "setImeEditTextEnableListener", "listener", "setOnClickListener", "l", "setOnFocusChangeListener", "switchToSafetyMode", "account-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMImeClearEditText
  extends MMClearEditText
{
  boolean pWS;
  private View.OnFocusChangeListener pWT;
  private View.OnFocusChangeListener pWU;
  private View.OnClickListener pWV;
  private final View.OnClickListener pWW;
  private b pWY;
  
  public MMImeClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304683);
    this.pWU = new MMImeClearEditText..ExternalSyntheticLambda1(this);
    this.pWW = new MMImeClearEditText..ExternalSyntheticLambda0(this);
    initView();
    AppMethodBeat.o(304683);
  }
  
  public MMImeClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304694);
    this.pWU = new MMImeClearEditText..ExternalSyntheticLambda1(this);
    this.pWW = new MMImeClearEditText..ExternalSyntheticLambda0(this);
    initView();
    AppMethodBeat.o(304694);
  }
  
  private static final void a(MMImeClearEditText paramMMImeClearEditText, View paramView)
  {
    AppMethodBeat.i(304730);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMMImeClearEditText);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/sdk/MMImeClearEditText", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMMImeClearEditText, "this$0");
    if ((paramMMImeClearEditText.bXM()) && (com.tencent.mm.plugin.hld.d.a.JqJ.a((EditText)paramMMImeClearEditText, paramMMImeClearEditText.getContext())))
    {
      localObject = com.tencent.mm.plugin.hld.d.a.JqJ;
      com.tencent.mm.plugin.hld.d.a.fLy();
    }
    paramMMImeClearEditText = paramMMImeClearEditText.pWV;
    if (paramMMImeClearEditText != null) {
      paramMMImeClearEditText.onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/account/sdk/MMImeClearEditText", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(304730);
  }
  
  private static final void a(MMImeClearEditText paramMMImeClearEditText, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(304723);
    s.u(paramMMImeClearEditText, "this$0");
    if (paramMMImeClearEditText.bXM()) {
      paramMMImeClearEditText.post(new MMImeClearEditText..ExternalSyntheticLambda2(paramBoolean, paramMMImeClearEditText));
    }
    paramMMImeClearEditText = paramMMImeClearEditText.pWT;
    if (paramMMImeClearEditText != null) {
      paramMMImeClearEditText.onFocusChange(paramView, paramBoolean);
    }
    AppMethodBeat.o(304723);
  }
  
  private static final void a(boolean paramBoolean, MMImeClearEditText paramMMImeClearEditText)
  {
    AppMethodBeat.i(304713);
    s.u(paramMMImeClearEditText, "this$0");
    if (paramBoolean)
    {
      if (com.tencent.mm.plugin.hld.d.a.JqJ.a((EditText)paramMMImeClearEditText, paramMMImeClearEditText.getContext()))
      {
        paramMMImeClearEditText = com.tencent.mm.plugin.hld.d.a.JqJ;
        com.tencent.mm.plugin.hld.d.a.fLy();
        AppMethodBeat.o(304713);
      }
    }
    else
    {
      com.tencent.mm.plugin.hld.d.a.JqJ.a(null, null);
      paramMMImeClearEditText = com.tencent.mm.plugin.hld.d.a.JqJ;
      com.tencent.mm.plugin.hld.d.a.onHide();
    }
    AppMethodBeat.o(304713);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(304702);
    super.setOnClickListener(this.pWW);
    AppMethodBeat.o(304702);
  }
  
  public final boolean bXM()
  {
    AppMethodBeat.i(304762);
    if (this.pWS)
    {
      com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.JqJ;
      if (com.tencent.mm.plugin.hld.d.a.fLB())
      {
        AppMethodBeat.o(304762);
        return true;
      }
    }
    AppMethodBeat.o(304762);
    return false;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(304745);
    super.onFinishInflate();
    Object localObject = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (!com.tencent.mm.plugin.hld.d.a.fLB())
    {
      AppMethodBeat.o(304745);
      return;
    }
    localObject = this.pWY;
    if (localObject != null) {
      ((b)localObject).bXL();
    }
    AppMethodBeat.o(304745);
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304755);
    super.onSelectionChanged(paramInt1, paramInt2);
    if (bXM())
    {
      com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.JqJ;
      com.tencent.mm.plugin.hld.d.a.fLz();
    }
    AppMethodBeat.o(304755);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(304757);
    super.setEnabled(paramBoolean);
    Object localObject = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (!com.tencent.mm.plugin.hld.d.a.fLB())
    {
      AppMethodBeat.o(304757);
      return;
    }
    localObject = this.pWY;
    if (localObject != null) {
      ((b)localObject).bXL();
    }
    AppMethodBeat.o(304757);
  }
  
  public final void setImeEditTextEnableListener(b paramb)
  {
    AppMethodBeat.i(304750);
    s.u(paramb, "listener");
    this.pWY = paramb;
    AppMethodBeat.o(304750);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pWV = paramOnClickListener;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(304752);
    this.pWT = paramOnFocusChangeListener;
    super.setOnFocusChangeListener(this.pWU);
    AppMethodBeat.o(304752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.MMImeClearEditText
 * JD-Core Version:    0.7.0.1
 */