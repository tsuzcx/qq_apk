package com.tencent.mm.plugin.account.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMClearEditText;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/account/sdk/MMImeClearEditText;", "Lcom/tencent/mm/ui/base/MMClearEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iImeEditTextEnableListener", "Lcom/tencent/mm/plugin/account/sdk/IImeEditTextEnableListener;", "isSafetyMode", "", "onNewClickListener", "Landroid/view/View$OnClickListener;", "onNewFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "onOriClickListener", "onOriFocusChangeListener", "ifShowImeIndependent", "initView", "", "onFinishInflate", "onSelectionChanged", "selStart", "selEnd", "setEnabled", "enabled", "setImeEditTextEnableListener", "listener", "setOnClickListener", "l", "setOnFocusChangeListener", "switchToSafetyMode", "account-sdk_release"})
public final class MMImeClearEditText
  extends MMClearEditText
{
  private boolean nai;
  private View.OnFocusChangeListener naj;
  private View.OnFocusChangeListener nak;
  private View.OnClickListener nal;
  private final View.OnClickListener nam;
  private b nas;
  
  public MMImeClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187275);
    this.nak = ((View.OnFocusChangeListener)new b(this));
    this.nam = ((View.OnClickListener)new a(this));
    initView();
    AppMethodBeat.o(187275);
  }
  
  public MMImeClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187277);
    this.nak = ((View.OnFocusChangeListener)new b(this));
    this.nam = ((View.OnClickListener)new a(this));
    initView();
    AppMethodBeat.o(187277);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(187259);
    super.setOnClickListener(this.nam);
    AppMethodBeat.o(187259);
  }
  
  public final boolean byX()
  {
    if (this.nai) {
      com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.DxH;
    }
    return false;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(187260);
    super.onFinishInflate();
    com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.DxH;
    AppMethodBeat.o(187260);
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187272);
    super.onSelectionChanged(paramInt1, paramInt2);
    byX();
    AppMethodBeat.o(187272);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(187274);
    super.setEnabled(paramBoolean);
    com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.DxH;
    AppMethodBeat.o(187274);
  }
  
  public final void setImeEditTextEnableListener(b paramb)
  {
    AppMethodBeat.i(187263);
    p.k(paramb, "listener");
    this.nas = paramb;
    AppMethodBeat.o(187263);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nal = paramOnClickListener;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(187265);
    this.naj = paramOnFocusChangeListener;
    super.setOnFocusChangeListener(this.nak);
    AppMethodBeat.o(187265);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(MMImeClearEditText paramMMImeClearEditText) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186451);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/sdk/MMImeClearEditText$onNewClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      this.nat.byX();
      localObject = MMImeClearEditText.b(this.nat);
      if (localObject != null) {
        ((View.OnClickListener)localObject).onClick(paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/sdk/MMImeClearEditText$onNewClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186451);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
  static final class b
    implements View.OnFocusChangeListener
  {
    b(MMImeClearEditText paramMMImeClearEditText) {}
    
    public final void onFocusChange(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(186956);
      this.nat.byX();
      View.OnFocusChangeListener localOnFocusChangeListener = MMImeClearEditText.a(this.nat);
      if (localOnFocusChangeListener != null)
      {
        localOnFocusChangeListener.onFocusChange(paramView, paramBoolean);
        AppMethodBeat.o(186956);
        return;
      }
      AppMethodBeat.o(186956);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.MMImeClearEditText
 * JD-Core Version:    0.7.0.1
 */