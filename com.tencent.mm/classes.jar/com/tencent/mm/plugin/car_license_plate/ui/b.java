package com.tencent.mm.plugin.car_license_plate.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.as;
import com.tencent.mm.plugin.car_license_plate.a.c;
import com.tencent.mm.plugin.car_license_plate.a.d;
import com.tencent.mm.plugin.car_license_plate.a.h;
import com.tencent.mm.ui.z;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController;", "", "()V", "containerLayout", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "keyboardListener", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;", "getKeyboardListener", "()Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;", "setKeyboardListener", "(Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;)V", "keyboardViewsForType", "Landroid/util/SparseArray;", "Landroid/view/ViewGroup;", "initContainerLayout", "", "initKeyboardLayoutForType", "view", "charLayout", "", "", "(Landroid/view/ViewGroup;[Ljava/lang/CharSequence;)V", "showKeyboardForType", "type", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "updateKeyboardViewBehaviorForType", "OnKeyboardOperationListener", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  Context context;
  RelativeLayout wco;
  a wcp;
  final SparseArray<ViewGroup> wcq;
  
  public b()
  {
    AppMethodBeat.i(277712);
    this.wcq = new SparseArray(2);
    AppMethodBeat.o(277712);
  }
  
  static void a(ViewGroup paramViewGroup, c.b paramb)
  {
    AppMethodBeat.i(277729);
    Object localObject1 = paramViewGroup.findViewById(a.d.layout_btn_line0);
    s.s(localObject1, "view.findViewById(R.id.layout_btn_line0)");
    localObject1 = (LinearLayout)localObject1;
    Object localObject2 = paramViewGroup.findViewById(a.d.layout_btn_line1);
    s.s(localObject2, "view.findViewById(R.id.layout_btn_line1)");
    localObject2 = (LinearLayout)localObject2;
    Object localObject3 = paramViewGroup.findViewById(a.d.layout_btn_line2);
    s.s(localObject3, "view.findViewById(R.id.layout_btn_line2)");
    localObject3 = (LinearLayout)localObject3;
    Object localObject4 = paramViewGroup.findViewById(a.d.layout_btn_line3);
    s.s(localObject4, "view.findViewById(R.id.layout_btn_line3)");
    localObject4 = (LinearLayout)localObject4;
    paramViewGroup = paramViewGroup.findViewById(a.d.layout_btn_line4);
    s.s(paramViewGroup, "view.findViewById(R.id.layout_btn_line4)");
    paramViewGroup = (LinearLayout)paramViewGroup;
    int i = 0;
    LinearLayout localLinearLayout;
    int m;
    if (i < 5)
    {
      localLinearLayout = new LinearLayout[] { localObject1, localObject2, localObject3, localObject4, paramViewGroup }[i];
      if (localLinearLayout.getVisibility() == 0)
      {
        m = localLinearLayout.getChildCount();
        if (m <= 0) {}
      }
    }
    int k;
    for (int j = 0;; j = k)
    {
      k = j + 1;
      View localView = localLinearLayout.getChildAt(j);
      if ((localView instanceof TextView))
      {
        if (((TextView)localView).getText().length() > 1)
        {
          TextView localTextView = (TextView)localView;
          String str = ((TextView)localView).getText().toString();
          if (str == null)
          {
            paramViewGroup = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(277729);
            throw paramViewGroup;
          }
          str = str.substring(0, 1);
          s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localTextView.setText((CharSequence)str);
        }
        ((TextView)localView).setEnabled(n.d(paramb.diR(), ((TextView)localView).getText().charAt(0)));
      }
      for (;;)
      {
        if (k >= m)
        {
          i += 1;
          break;
          localView.setVisibility(8);
          continue;
          AppMethodBeat.o(277729);
          return;
        }
      }
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(277741);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb = paramb.wcp;
    if (paramb != null)
    {
      if (paramView == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(277741);
        throw paramb;
      }
      paramb.z(((TextView)paramView).getText().charAt(0));
    }
    a.a(new Object(), "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277741);
  }
  
  final void a(ViewGroup paramViewGroup, CharSequence[] paramArrayOfCharSequence)
  {
    AppMethodBeat.i(277780);
    Object localObject = paramViewGroup.findViewById(a.d.layout_btn_line0);
    s.s(localObject, "view.findViewById(R.id.layout_btn_line0)");
    LinearLayout localLinearLayout1 = (LinearLayout)localObject;
    localObject = paramViewGroup.findViewById(a.d.layout_btn_line1);
    s.s(localObject, "view.findViewById(R.id.layout_btn_line1)");
    LinearLayout localLinearLayout2 = (LinearLayout)localObject;
    localObject = paramViewGroup.findViewById(a.d.layout_btn_line2);
    s.s(localObject, "view.findViewById(R.id.layout_btn_line2)");
    LinearLayout localLinearLayout3 = (LinearLayout)localObject;
    localObject = paramViewGroup.findViewById(a.d.layout_btn_line3);
    s.s(localObject, "view.findViewById(R.id.layout_btn_line3)");
    LinearLayout localLinearLayout4 = (LinearLayout)localObject;
    localObject = paramViewGroup.findViewById(a.d.layout_btn_line4);
    s.s(localObject, "view.findViewById(R.id.layout_btn_line4)");
    LinearLayout localLinearLayout5 = (LinearLayout)localObject;
    b..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new b..ExternalSyntheticLambda0(this);
    paramViewGroup.findViewById(a.d.btn_delete).setOnTouchListener((View.OnTouchListener)new b(this));
    localObject = this.context;
    paramViewGroup = (ViewGroup)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramViewGroup = null;
    }
    localObject = new z(paramViewGroup, a.h.CarLicensePlateKeyboardViewButton);
    int j = paramArrayOfCharSequence.length;
    int i = 4;
    j -= 1;
    for (;;)
    {
      LinearLayout localLinearLayout6 = (LinearLayout)k.m(new LinearLayout[] { localLinearLayout1, localLinearLayout2, localLinearLayout3, localLinearLayout4, localLinearLayout5 }, i);
      if (localLinearLayout6 != null)
      {
        paramViewGroup = (CharSequence)k.m(paramArrayOfCharSequence, j);
        if (paramViewGroup != null) {
          break label311;
        }
        paramViewGroup = null;
        if (paramViewGroup == null) {
          localLinearLayout6.setVisibility(8);
        }
      }
      int k = j - 1;
      label283:
      int m;
      if (k >= 0)
      {
        j = 1;
        m = i - 1;
        if (m < 0) {
          break label428;
        }
      }
      label428:
      for (i = 1;; i = 0)
      {
        if ((i | j) != 0) {
          break label434;
        }
        AppMethodBeat.o(277780);
        return;
        label311:
        k = 0;
        while (k < paramViewGroup.length())
        {
          char c = paramViewGroup.charAt(k);
          TextView localTextView = new TextView((Context)localObject);
          localTextView.setText((CharSequence)String.valueOf(c));
          localTextView.setOnClickListener(localExternalSyntheticLambda0);
          localLinearLayout6.addView((View)localTextView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(0, ((z)localObject).getResources().getDimensionPixelSize(a.c.Edge_5A), 1.0F));
          k += 1;
        }
        localLinearLayout6.setVisibility(0);
        paramViewGroup = ah.aiuX;
        break;
        j = 0;
        break label283;
      }
      label434:
      i = m;
      j = k;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;", "", "appendText", "", "char", "", "deleteLast", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void cRu();
    
    public abstract void z(char paramChar);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$initKeyboardLayoutForType$1", "Lcom/tencent/mm/plugin/appbrand/widget/input/RepeatKeyTouchListener;", "onRepeat", "", "onSingleTap", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends as
  {
    b(b paramb) {}
    
    public final void cRr()
    {
      AppMethodBeat.i(277673);
      b.a locala = this.wcr.wcp;
      if (locala != null) {
        locala.cRu();
      }
      AppMethodBeat.o(277673);
    }
    
    public final void cvh()
    {
      AppMethodBeat.i(277661);
      b.a locala = this.wcr.wcp;
      if (locala != null) {
        locala.cRu();
      }
      AppMethodBeat.o(277661);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.b
 * JD-Core Version:    0.7.0.1
 */