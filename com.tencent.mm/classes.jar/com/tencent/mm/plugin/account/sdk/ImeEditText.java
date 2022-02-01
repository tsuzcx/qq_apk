package com.tencent.mm.plugin.account.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.account.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/account/sdk/ImeEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSafetyMode", "", "logoDrawable", "Landroid/graphics/drawable/Drawable;", "logoWidth", "Ljava/lang/Integer;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "onNewClickListener", "Landroid/view/View$OnClickListener;", "onNewFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "onOriClickListener", "onOriFocusChangeListener", "getLogoWidth", "ifShowImeIndependent", "initView", "", "onFinishInflate", "onSelectionChanged", "selStart", "selEnd", "setEnabled", "enabled", "setOnClickListener", "l", "setOnFocusChangeListener", "switchToSafetyMode", "updateLogoStatus", "Companion", "account-sdk_release"})
public final class ImeEditText
  extends AppCompatEditText
{
  public static final a nao;
  private Drawable nag;
  private Integer nah;
  private boolean nai;
  private View.OnFocusChangeListener naj;
  private View.OnFocusChangeListener nak;
  private View.OnClickListener nal;
  private final View.OnClickListener nam;
  private final View.OnTouchListener nan;
  
  static
  {
    AppMethodBeat.i(187199);
    nao = new a((byte)0);
    AppMethodBeat.o(187199);
  }
  
  public ImeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187194);
    this.nak = ((View.OnFocusChangeListener)new d(this));
    this.nam = ((View.OnClickListener)new c(this));
    this.nan = ((View.OnTouchListener)new b(this));
    initView();
    AppMethodBeat.o(187194);
  }
  
  public ImeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187197);
    this.nak = ((View.OnFocusChangeListener)new d(this));
    this.nam = ((View.OnClickListener)new c(this));
    this.nan = ((View.OnTouchListener)new b(this));
    initView();
    AppMethodBeat.o(187197);
  }
  
  private final boolean byX()
  {
    if (this.nai) {
      com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.DxH;
    }
    return false;
  }
  
  private final int getLogoWidth()
  {
    AppMethodBeat.i(187189);
    if (this.nah == null) {
      this.nah = Integer.valueOf(com.tencent.mm.ci.a.aZ(getContext(), a.a.Edge_3A));
    }
    Integer localInteger = this.nah;
    if (localInteger == null) {
      p.iCn();
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(187189);
    return i;
  }
  
  private final void initView()
  {
    AppMethodBeat.i(187174);
    super.setOnClickListener(this.nam);
    AppMethodBeat.o(187174);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(187176);
    super.onFinishInflate();
    com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.DxH;
    AppMethodBeat.o(187176);
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187183);
    super.onSelectionChanged(paramInt1, paramInt2);
    byX();
    AppMethodBeat.o(187183);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(187185);
    super.setEnabled(paramBoolean);
    com.tencent.mm.plugin.hld.d.a locala = com.tencent.mm.plugin.hld.d.a.DxH;
    AppMethodBeat.o(187185);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nal = paramOnClickListener;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(187180);
    this.naj = paramOnFocusChangeListener;
    super.setOnFocusChangeListener(this.nak);
    AppMethodBeat.o(187180);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/account/sdk/ImeEditText$Companion;", "", "()V", "TAG", "", "account-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(ImeEditText paramImeEditText) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186232);
      if (this.nap.getCompoundDrawables()[2] == null)
      {
        AppMethodBeat.o(186232);
        return false;
      }
      p.j(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() != 1)
      {
        AppMethodBeat.o(186232);
        return false;
      }
      if ((ImeEditText.d(this.nap) != null) && (paramMotionEvent.getX() > this.nap.getWidth() - this.nap.getPaddingRight() - ImeEditText.e(this.nap))) {
        ImeEditText.byY();
      }
      AppMethodBeat.o(186232);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ImeEditText paramImeEditText) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(186975);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/sdk/ImeEditText$onNewClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if ((ImeEditText.a(this.nap)) && (com.tencent.mm.plugin.hld.d.a.DxH.a((EditText)this.nap, this.nap.getContext())))
      {
        localObject = com.tencent.mm.plugin.hld.d.a.DxH;
        com.tencent.mm.plugin.hld.d.a.eDy();
      }
      localObject = ImeEditText.c(this.nap);
      if (localObject != null) {
        ((View.OnClickListener)localObject).onClick(paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/sdk/ImeEditText$onNewClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(186975);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
  static final class d
    implements View.OnFocusChangeListener
  {
    d(ImeEditText paramImeEditText) {}
    
    public final void onFocusChange(View paramView, final boolean paramBoolean)
    {
      AppMethodBeat.i(186713);
      if (ImeEditText.a(this.nap)) {
        this.nap.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186881);
            com.tencent.mm.plugin.hld.d.a locala;
            if (paramBoolean)
            {
              if (com.tencent.mm.plugin.hld.d.a.DxH.a((EditText)this.naq.nap, this.naq.nap.getContext()))
              {
                locala = com.tencent.mm.plugin.hld.d.a.DxH;
                com.tencent.mm.plugin.hld.d.a.eDy();
                AppMethodBeat.o(186881);
              }
            }
            else
            {
              com.tencent.mm.plugin.hld.d.a.DxH.a(null, null);
              locala = com.tencent.mm.plugin.hld.d.a.DxH;
              com.tencent.mm.plugin.hld.d.a.onHide();
            }
            AppMethodBeat.o(186881);
          }
        });
      }
      View.OnFocusChangeListener localOnFocusChangeListener = ImeEditText.b(this.nap);
      if (localOnFocusChangeListener != null)
      {
        localOnFocusChangeListener.onFocusChange(paramView, paramBoolean);
        AppMethodBeat.o(186713);
        return;
      }
      AppMethodBeat.o(186713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.sdk.ImeEditText
 * JD-Core Version:    0.7.0.1
 */