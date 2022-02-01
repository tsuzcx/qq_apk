package com.tencent.mm.plugin.account.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.b;
import com.tencent.mm.plugin.hld.d.a;
import com.tencent.mm.ui.base.MMFormInputView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/account/sdk/MMImeFormInputView;", "Lcom/tencent/mm/ui/base/MMFormInputView;", "Lcom/tencent/mm/plugin/account/sdk/IImeEditTextEnableListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentET", "Lcom/tencent/mm/plugin/account/sdk/MMImeClearEditText;", "logoIv", "Landroid/widget/ImageView;", "initView", "", "onEnable", "onFinishInflate", "setEnabled", "enabled", "", "updateLogoStatus", "Companion", "account-sdk_release"})
public final class MMImeFormInputView
  extends MMFormInputView
  implements b
{
  public static final a naw;
  private MMImeClearEditText nau;
  private ImageView nav;
  
  static
  {
    AppMethodBeat.i(187089);
    naw = new a((byte)0);
    AppMethodBeat.o(187089);
  }
  
  public MMImeFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187087);
    initView();
    AppMethodBeat.o(187087);
  }
  
  public MMImeFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187088);
    initView();
    AppMethodBeat.o(187088);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(187078);
    this.nav = ((ImageView)findViewById(a.b.logo_iv));
    this.nau = ((MMImeClearEditText)findViewById(a.b.edittext));
    Object localObject = a.DxH;
    localObject = this.nav;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      AppMethodBeat.o(187078);
      return;
    }
    AppMethodBeat.o(187078);
  }
  
  public final void onFinishInflate()
  {
    AppMethodBeat.i(187082);
    super.onFinishInflate();
    a locala = a.DxH;
    AppMethodBeat.o(187082);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(187081);
    super.setEnabled(paramBoolean);
    a locala = a.DxH;
    AppMethodBeat.o(187081);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/account/sdk/MMImeFormInputView$Companion;", "", "()V", "TAG", "", "account-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.MMImeFormInputView
 * JD-Core Version:    0.7.0.1
 */