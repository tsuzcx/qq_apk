package com.tencent.mm.plugin.car_license_plate.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.car_license_plate.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.ui.z;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "inputLayout", "Landroid/widget/LinearLayout;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/widget/LinearLayout;)V", "charViews", "", "Landroid/widget/TextView;", "[Landroid/widget/TextView;", "<set-?>", "", "currentText", "getCurrentText", "()Ljava/lang/String;", "", "selectedCharIndex", "getSelectedCharIndex", "()I", "viewCallback", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;)V", "appendText", "", "char", "", "deleteLast", "init", "defaultPlateNo", "notifyTextChanged", "setLetterViewSelected", "index", "updateCurrentText", "Companion", "ViewCallback", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b.a
{
  private static final a.a wcg;
  private final MMActivity activity;
  private final LinearLayout nio;
  b wch;
  String wci;
  private int wcj;
  private TextView[] wck;
  
  static
  {
    AppMethodBeat.i(277754);
    wcg = new a.a((byte)0);
    AppMethodBeat.o(277754);
  }
  
  public a(MMActivity paramMMActivity, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(277693);
    this.activity = paramMMActivity;
    this.nio = paramLinearLayout;
    this.wci = "";
    AppMethodBeat.o(277693);
  }
  
  private final void Id(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(277711);
    int i;
    if (paramInt >= 0)
    {
      TextView[] arrayOfTextView = this.wck;
      localObject1 = arrayOfTextView;
      if (arrayOfTextView == null)
      {
        s.bIx("charViews");
        localObject1 = null;
      }
      if (paramInt <= localObject1.length - 1) {
        i = 1;
      }
    }
    while (i == 0)
    {
      localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(277711);
      throw ((Throwable)localObject1);
      i = 0;
      continue;
      i = 0;
    }
    this.wcj = paramInt;
    Object localObject1 = this.wck;
    int j;
    if (localObject1 == null)
    {
      s.bIx("charViews");
      localObject1 = localObject2;
      int k = localObject1.length;
      j = 0;
      i = 0;
      label119:
      if (j >= k) {
        break label178;
      }
      localObject2 = localObject1[j];
      if (paramInt != i) {
        break label172;
      }
    }
    label172:
    for (boolean bool = true;; bool = false)
    {
      s.checkNotNull(localObject2);
      ((TextView)localObject2).setSelected(bool);
      ((TextView)localObject2).setFocusable(bool);
      j += 1;
      i += 1;
      break label119;
      break;
    }
    label178:
    localObject1 = this.wch;
    if (localObject1 != null)
    {
      localObject2 = c.b.wcB;
      ((b)localObject1).a(c.b.a.Ie(paramInt));
    }
    AppMethodBeat.o(277711);
  }
  
  private static final void a(a parama, int paramInt, View paramView)
  {
    AppMethodBeat.i(277722);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.Id(paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277722);
  }
  
  public final void cRu()
  {
    AppMethodBeat.i(277794);
    TextView[] arrayOfTextView = this.wck;
    Object localObject = arrayOfTextView;
    if (arrayOfTextView == null)
    {
      s.bIx("charViews");
      localObject = null;
    }
    localObject = localObject[this.wcj];
    s.checkNotNull(localObject);
    ((TextView)localObject).setText((CharSequence)"");
    Id(Math.max(this.wcj - 1, 0));
    AppMethodBeat.o(277794);
  }
  
  public final void init(String paramString)
  {
    AppMethodBeat.i(277786);
    s.u(paramString, "defaultPlateNo");
    z localz = new z((Context)this.activity, com.tencent.mm.plugin.car_license_plate.a.h.CarLicensePlateEditInputFrame);
    this.wck = new TextView[8];
    Object localObject2 = this.wck;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("charViews");
      localObject1 = null;
    }
    int k = localObject1.length - 1;
    if (k >= 0) {}
    int j;
    for (final int i = 0;; i = j)
    {
      j = i + 1;
      localObject1 = c.b.wcB;
      localObject2 = c.b.a.Ie(i);
      switch (a.c.$EnumSwitchMapping$0[localObject2.ordinal()])
      {
      default: 
        localObject1 = new TextView((Context)localz);
        this.nio.addView((View)localObject1, new ViewGroup.LayoutParams(localz.getResources().getDimensionPixelSize(a.c.Edge_5A), localz.getResources().getDimensionPixelSize(a.c.Edge_6A)));
        ((TextView)localObject1).setSpannableFactory((Spannable.Factory)new d());
        s.s(localObject1, "");
        com.tencent.mm.plugin.car_license_plate.b.a.a((TextView)localObject1, (InputFilter)new e());
        localObject2 = ((c.b)localObject2).diR();
        s.u(localObject1, "<this>");
        s.u(localObject2, "range");
        com.tencent.mm.plugin.car_license_plate.b.a.a((TextView)localObject1, (InputFilter)new com.tencent.mm.plugin.car_license_plate.b.a.a((CharSequence)localObject2));
        ((TextView)localObject1).setEditableFactory(Editable.Factory.getInstance());
        localObject2 = n.q((CharSequence)paramString, i);
        if (localObject2 == null)
        {
          localObject2 = null;
          label282:
          Object localObject3 = localObject2;
          if (localObject2 == null) {
            localObject3 = "";
          }
          ((TextView)localObject1).setText((CharSequence)localObject3, TextView.BufferType.EDITABLE);
          ((TextView)localObject1).addTextChangedListener((TextWatcher)new f(this));
          localObject3 = this.wck;
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("charViews");
            localObject2 = null;
          }
          localObject2[i] = localObject1;
          if (i == 6)
          {
            com.tencent.mm.plugin.car_license_plate.b.a.a((TextView)localObject1, (InputFilter)new g(this, i));
            ((TextView)localObject1).addTextChangedListener((TextWatcher)new h(this, i, (TextView)localObject1));
          }
          if (i == 7) {
            com.tencent.mm.plugin.car_license_plate.b.a.a((TextView)localObject1, (InputFilter)new i(this));
          }
          ((TextView)localObject1).setOnClickListener(new a..ExternalSyntheticLambda0(this, i));
          if (j <= k) {
            continue;
          }
          if (((CharSequence)paramString).length() != 0) {
            break label513;
          }
        }
        break;
      }
      label513:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label518;
        }
        Id(0);
        AppMethodBeat.o(277786);
        return;
        localObject1 = (TextView)this.nio.findViewById(com.tencent.mm.plugin.car_license_plate.a.d.char_province_short);
        break;
        localObject1 = (TextView)this.nio.findViewById(com.tencent.mm.plugin.car_license_plate.a.d.char_city_letter);
        break;
        localObject2 = ((Character)localObject2).toString();
        break label282;
      }
      label518:
      Id(androidx.core.b.a.clamp(paramString.length() - 1, 0, 7));
      localObject1 = this.wch;
      if (localObject1 != null) {
        ((b)localObject1).aZ(paramString, false);
      }
      AppMethodBeat.o(277786);
      return;
    }
  }
  
  public final void z(char paramChar)
  {
    Object localObject3 = null;
    AppMethodBeat.i(277791);
    Object localObject2 = this.wck;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("charViews");
      localObject1 = null;
    }
    Object localObject5 = localObject1[this.wcj];
    s.checkNotNull(localObject5);
    localObject1 = localObject5.getText();
    int i;
    if (localObject1 == null)
    {
      localObject1 = (CharSequence)"";
      Object localObject4 = this.wck;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("charViews");
        localObject2 = null;
      }
      localObject2 = localObject2[this.wcj];
      s.checkNotNull(localObject2);
      ((TextView)localObject2).setText((CharSequence)String.valueOf(paramChar), TextView.BufferType.SPANNABLE);
      localObject4 = localObject5.getText();
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = (CharSequence)"";
      }
      if (s.p(localObject1.toString(), localObject2.toString()))
      {
        localObject4 = e.wdw;
        long l = e.a.Z((CharSequence)localObject2);
        localObject2 = e.wdw;
        if (l <= e.a.Z((CharSequence)localObject1))
        {
          if (((CharSequence)localObject1).length() != 0) {
            break label248;
          }
          i = 1;
          label194:
          if (i == 0) {
            break label238;
          }
        }
      }
      i = this.wcj;
      localObject1 = this.wck;
      if (localObject1 != null) {
        break label253;
      }
      s.bIx("charViews");
      localObject1 = localObject3;
    }
    label238:
    label248:
    label253:
    for (;;)
    {
      Id(Math.min(i + 1, localObject1.length - 1));
      AppMethodBeat.o(277791);
      return;
      break;
      i = 0;
      break label194;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;", "", "onKeyboardViewRequested", "", "type", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "onTextChanged", "text", "", "allowSubmit", "", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(c.b paramb);
    
    public abstract void aZ(String paramString, boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$1", "Landroid/text/Spannable$Factory;", "newSpannable", "Landroid/text/Spannable;", "source", "", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends Spannable.Factory
  {
    public final Spannable newSpannable(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(277774);
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        paramCharSequence = SpannableStringBuilder.valueOf(paramCharSequence);
        s.s(paramCharSequence, "valueOf(source ?: \"\")");
        paramCharSequence = (Spannable)paramCharSequence;
        AppMethodBeat.o(277774);
        return paramCharSequence;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$2", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements InputFilter
  {
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(277781);
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        AppMethodBeat.o(277781);
        return paramCharSequence;
      }
      paramCharSequence = SpannableStringBuilder.valueOf(paramCharSequence);
      paramCharSequence.setSpan(new e(Util.currentTicks()), 0, paramCharSequence.length(), 18);
      paramCharSequence = (CharSequence)paramCharSequence;
      AppMethodBeat.o(277781);
      return paramCharSequence;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$3", "Lcom/tencent/mm/ui/widget/MMTextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends i
  {
    f(a parama) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(277782);
      a.b(this.wcl);
      AppMethodBeat.o(277782);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$4", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements InputFilter
  {
    g(a parama, int paramInt) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      Object localObject = null;
      AppMethodBeat.i(277744);
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
      {
        paramInt1 = 1;
        if ((paramInt1 != 0) || (!com.tencent.mm.plugin.car_license_plate.b.a.isChinese(n.bx(paramCharSequence)))) {
          break label173;
        }
        TextView[] arrayOfTextView = a.a(this.wcl);
        paramSpanned = arrayOfTextView;
        if (arrayOfTextView == null)
        {
          s.bIx("charViews");
          paramSpanned = null;
        }
        paramSpanned = paramSpanned[7];
        s.checkNotNull(paramSpanned);
        paramSpanned = paramSpanned.getText();
        if (paramSpanned == null) {
          break label165;
        }
        paramSpanned = n.by(paramSpanned);
        if ((paramSpanned == null) || (com.tencent.mm.plugin.car_license_plate.b.a.isChinese(paramSpanned.charValue()) != true)) {
          break label165;
        }
        paramInt1 = 1;
        label113:
        if (paramInt1 == 0) {
          break label173;
        }
        paramCharSequence = a.a(this.wcl);
        if (paramCharSequence != null) {
          break label170;
        }
        s.bIx("charViews");
        paramCharSequence = localObject;
      }
      label165:
      label170:
      for (;;)
      {
        paramCharSequence = paramCharSequence[i];
        s.checkNotNull(paramCharSequence);
        paramCharSequence = paramCharSequence.getText();
        AppMethodBeat.o(277744);
        return paramCharSequence;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label113;
      }
      label173:
      AppMethodBeat.o(277744);
      return paramCharSequence;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$5", "Lcom/tencent/mm/ui/widget/MMTextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends i
  {
    h(a parama, int paramInt, TextView paramTextView) {}
    
    private static final void c(a parama)
    {
      AppMethodBeat.i(277742);
      s.u(parama, "this$0");
      TextView[] arrayOfTextView = a.a(parama);
      parama = arrayOfTextView;
      if (arrayOfTextView == null)
      {
        s.bIx("charViews");
        parama = null;
      }
      parama = parama[7];
      s.checkNotNull(parama);
      parama.setText((CharSequence)"");
      AppMethodBeat.o(277742);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(277758);
      TextView[] arrayOfTextView = a.a(this.wcl);
      paramEditable = arrayOfTextView;
      if (arrayOfTextView == null)
      {
        s.bIx("charViews");
        paramEditable = null;
      }
      paramEditable = paramEditable[i];
      s.checkNotNull(paramEditable);
      paramEditable = paramEditable.getText();
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (paramEditable != null)
        {
          paramEditable = n.by((CharSequence)paramEditable);
          if ((paramEditable == null) || (com.tencent.mm.plugin.car_license_plate.b.a.isChinese(paramEditable.charValue()) != true)) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.wcm.post(new a.h..ExternalSyntheticLambda0(this.wcl));
        }
        AppMethodBeat.o(277758);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$init$2$6", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements InputFilter
  {
    i(a parama) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(277745);
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        AppMethodBeat.o(277745);
        return paramCharSequence;
      }
      TextView[] arrayOfTextView = a.a(this.wcl);
      paramSpanned = arrayOfTextView;
      if (arrayOfTextView == null)
      {
        s.bIx("charViews");
        paramSpanned = null;
      }
      paramSpanned = paramSpanned[6];
      s.checkNotNull(paramSpanned);
      paramSpanned = paramSpanned.getText();
      if (paramSpanned != null)
      {
        paramSpanned = n.by(paramSpanned);
        if ((paramSpanned == null) || (com.tencent.mm.plugin.car_license_plate.b.a.isChinese(paramSpanned.charValue()) != true)) {}
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(277745);
        return paramCharSequence;
      }
      AppMethodBeat.o(277745);
      return paramCharSequence;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    j(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.a
 * JD-Core Version:    0.7.0.1
 */