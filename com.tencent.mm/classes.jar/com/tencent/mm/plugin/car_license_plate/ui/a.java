package com.tencent.mm.plugin.car_license_plate.ui;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.i;
import java.util.NoSuchElementException;
import kotlin.a.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "inputLayout", "Landroid/widget/LinearLayout;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/widget/LinearLayout;)V", "charViews", "", "Landroid/widget/TextView;", "[Landroid/widget/TextView;", "<set-?>", "", "currentText", "getCurrentText", "()Ljava/lang/String;", "", "selectedCharIndex", "getSelectedCharIndex", "()I", "viewCallback", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;)V", "appendText", "", "char", "", "deleteLast", "init", "defaultPlateNo", "notifyTextChanged", "setLetterViewSelected", "index", "updateCurrentText", "Companion", "ViewCallback", "plugin-car-license-plate_release"})
public final class a
  implements c.a
{
  @Deprecated
  public static final a.a sXO;
  final MMActivity activity;
  final LinearLayout kFi;
  b sXK;
  String sXL;
  private int sXM;
  TextView[] sXN;
  
  static
  {
    AppMethodBeat.i(187620);
    sXO = new a.a((byte)0);
    AppMethodBeat.o(187620);
  }
  
  public a(MMActivity paramMMActivity, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(187619);
    this.activity = paramMMActivity;
    this.kFi = paramLinearLayout;
    this.sXL = "";
    AppMethodBeat.o(187619);
  }
  
  public final void G(char paramChar)
  {
    AppMethodBeat.i(187612);
    Object localObject1 = this.sXN;
    if (localObject1 == null) {
      p.bGy("charViews");
    }
    Object localObject3 = localObject1[this.sXM];
    if (localObject3 == null) {
      p.iCn();
    }
    localObject1 = ((TextView)localObject3).getText();
    if (localObject1 != null)
    {
      localObject1 = localObject1.toString();
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = this.sXN;
      if (localObject1 == null) {
        p.bGy("charViews");
      }
      localObject1 = localObject1[this.sXM];
      if (localObject1 == null) {
        p.iCn();
      }
      ((TextView)localObject1).setText((CharSequence)String.valueOf(paramChar));
      localObject1 = ((TextView)localObject3).getText();
      if (localObject1 == null) {
        break label201;
      }
      localObject1 = localObject1.toString();
      label115:
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "";
      }
      if (!(p.h(localObject2, localObject3) ^ true)) {
        if (((CharSequence)localObject2).length() != 0) {
          break label206;
        }
      }
    }
    label201:
    label206:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = this.sXM;
        localObject1 = this.sXN;
        if (localObject1 == null) {
          p.bGy("charViews");
        }
        HC(Math.min(i + 1, localObject1.length - 1));
      }
      AppMethodBeat.o(187612);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label115;
    }
  }
  
  final void HC(int paramInt)
  {
    AppMethodBeat.i(187610);
    Object localObject = this.sXN;
    if (localObject == null) {
      p.bGy("charViews");
    }
    int i = localObject.length;
    if (paramInt < 0) {}
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        break label70;
      }
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(187610);
      throw ((Throwable)localObject);
      if (i <= paramInt) {
        break;
      }
    }
    label70:
    this.sXM = paramInt;
    localObject = this.sXN;
    if (localObject == null) {
      p.bGy("charViews");
    }
    int k = localObject.length;
    int j = 0;
    i = 0;
    d.b.a locala;
    if (j < k)
    {
      locala = localObject[j];
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        if (locala == null) {
          p.iCn();
        }
        locala.setSelected(bool);
        locala.setFocusable(bool);
        j += 1;
        i += 1;
        break;
      }
    }
    localObject = this.sXK;
    if (localObject != null)
    {
      locala = d.b.sYo;
      ((b)localObject).a(d.b.a.HD(paramInt));
      AppMethodBeat.o(187610);
      return;
    }
    AppMethodBeat.o(187610);
  }
  
  final void cFw()
  {
    boolean bool = false;
    AppMethodBeat.i(187615);
    Object localObject = this.sXN;
    if (localObject == null) {
      p.bGy("charViews");
    }
    b localb = (b)a.f.sXT;
    this.sXL = e.a((Object[])localObject, (CharSequence)"", null, null, 0, null, localb, 30);
    int i = this.sXL.length();
    if (7 > i) {}
    for (;;)
    {
      localObject = this.sXK;
      if (localObject == null) {
        break;
      }
      ((b)localObject).aN(this.sXL, bool);
      AppMethodBeat.o(187615);
      return;
      if (8 >= i) {
        bool = true;
      }
    }
    AppMethodBeat.o(187615);
  }
  
  public final void coS()
  {
    AppMethodBeat.i(187614);
    Object localObject = this.sXN;
    if (localObject == null) {
      p.bGy("charViews");
    }
    localObject = localObject[this.sXM];
    if (localObject == null) {
      p.iCn();
    }
    ((TextView)localObject).setText((CharSequence)"");
    HC(Math.max(this.sXM - 1, 0));
    AppMethodBeat.o(187614);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;", "", "onKeyboardViewRequested", "", "type", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "onTextChanged", "text", "", "allowSubmit", "", "plugin-car-license-plate_release"})
  public static abstract interface b
  {
    public abstract void a(d.b paramb);
    
    public abstract void aN(String paramString, boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$1", "Lcom/tencent/mm/ui/widget/MMTextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "plugin-car-license-plate_release"})
  public static final class c
    extends i
  {
    c(a parama, d.b paramb, String paramString, int paramInt) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(187000);
      a.a(this.sXP);
      AppMethodBeat.o(187000);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$2", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-car-license-plate_release"})
  public static final class d
    implements InputFilter
  {
    d(a parama, d.b paramb, String paramString, int paramInt) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(293069);
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
      {
        paramInt1 = 1;
        if (paramInt1 != 0) {
          break label176;
        }
        p.k(paramCharSequence, "$this$first");
        if (paramCharSequence.length() != 0) {
          break label70;
        }
      }
      label70:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label75;
        }
        paramCharSequence = (Throwable)new NoSuchElementException("Char sequence is empty.");
        AppMethodBeat.o(293069);
        throw paramCharSequence;
        paramInt1 = 0;
        break;
      }
      label75:
      if (com.tencent.mm.plugin.car_license_plate.b.a.isChinese(paramCharSequence.charAt(0)))
      {
        paramSpanned = a.b(this.sXP)[7];
        if (paramSpanned == null) {
          p.iCn();
        }
        paramSpanned = paramSpanned.getText();
        if (paramSpanned != null)
        {
          paramSpanned = n.bl(paramSpanned);
          if ((paramSpanned != null) && (com.tencent.mm.plugin.car_license_plate.b.a.isChinese(paramSpanned.charValue()) == true))
          {
            paramCharSequence = a.b(this.sXP)[this.sXS];
            if (paramCharSequence == null) {
              p.iCn();
            }
            paramCharSequence = paramCharSequence.getText();
            AppMethodBeat.o(293069);
            return paramCharSequence;
          }
        }
      }
      label176:
      AppMethodBeat.o(293069);
      return paramCharSequence;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$3", "Lcom/tencent/mm/ui/widget/MMTextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "plugin-car-license-plate_release"})
  public static final class e
    extends i
  {
    e(TextView paramTextView, a parama, d.b paramb, String paramString, int paramInt) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(293068);
      paramEditable = a.b(this.sXP)[this.sXS];
      if (paramEditable == null) {
        p.iCn();
      }
      paramEditable = paramEditable.getText();
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (paramEditable != null)
        {
          paramEditable = n.bl((CharSequence)paramEditable);
          if (paramEditable != null)
          {
            if (com.tencent.mm.plugin.car_license_plate.b.a.isChinese(paramEditable.charValue()) == true) {
              this.GWx.post((Runnable)new a.e.1(this));
            }
            AppMethodBeat.o(293068);
            return;
          }
        }
      }
      AppMethodBeat.o(293068);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.a
 * JD-Core Version:    0.7.0.1
 */