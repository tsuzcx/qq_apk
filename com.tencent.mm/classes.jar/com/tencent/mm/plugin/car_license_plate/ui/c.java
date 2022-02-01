package com.tencent.mm.plugin.car_license_plate.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.as;
import com.tencent.mm.plugin.car_license_plate.a.c;
import com.tencent.mm.plugin.car_license_plate.a.d;
import com.tencent.mm.plugin.car_license_plate.a.h;
import com.tencent.mm.ui.x;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController;", "", "()V", "containerLayout", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "keyboardListener", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;", "getKeyboardListener", "()Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;", "setKeyboardListener", "(Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;)V", "keyboardViewsForType", "Landroid/util/SparseArray;", "Landroid/view/ViewGroup;", "initContainerLayout", "", "initKeyboardLayoutForType", "view", "charLayout", "", "", "(Landroid/view/ViewGroup;[Ljava/lang/CharSequence;)V", "showKeyboardForType", "type", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "updateKeyboardViewBehaviorForType", "OnKeyboardOperationListener", "plugin-car-license-plate_release"})
public final class c
{
  Context context;
  RelativeLayout sXU;
  a sXV;
  final SparseArray<ViewGroup> sXW;
  
  public c()
  {
    AppMethodBeat.i(187040);
    this.sXW = new SparseArray(2);
    AppMethodBeat.o(187040);
  }
  
  static void a(ViewGroup paramViewGroup, d.b paramb)
  {
    AppMethodBeat.i(187032);
    Object localObject1 = paramViewGroup.findViewById(a.d.layout_btn_line0);
    p.j(localObject1, "view.findViewById(R.id.layout_btn_line0)");
    localObject1 = (LinearLayout)localObject1;
    Object localObject2 = paramViewGroup.findViewById(a.d.layout_btn_line1);
    p.j(localObject2, "view.findViewById(R.id.layout_btn_line1)");
    localObject2 = (LinearLayout)localObject2;
    Object localObject3 = paramViewGroup.findViewById(a.d.layout_btn_line2);
    p.j(localObject3, "view.findViewById(R.id.layout_btn_line2)");
    localObject3 = (LinearLayout)localObject3;
    Object localObject4 = paramViewGroup.findViewById(a.d.layout_btn_line3);
    p.j(localObject4, "view.findViewById(R.id.layout_btn_line3)");
    localObject4 = (LinearLayout)localObject4;
    paramViewGroup = paramViewGroup.findViewById(a.d.layout_btn_line4);
    p.j(paramViewGroup, "view.findViewById(R.id.layout_btn_line4)");
    paramViewGroup = (LinearLayout)paramViewGroup;
    int i = 0;
    while (i < 5)
    {
      LinearLayout localLinearLayout = new LinearLayout[] { localObject1, localObject2, localObject3, localObject4, paramViewGroup }[i];
      if (localLinearLayout.getVisibility() == 0)
      {
        int k = localLinearLayout.getChildCount();
        int j = 0;
        if (j < k)
        {
          View localView = localLinearLayout.getChildAt(j);
          if ((localView instanceof TextView))
          {
            if (((TextView)localView).getText().length() > 1)
            {
              TextView localTextView = (TextView)localView;
              String str = ((TextView)localView).getText().toString();
              if (str == null)
              {
                paramViewGroup = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(187032);
                throw paramViewGroup;
              }
              str = str.substring(0, 1);
              p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localTextView.setText((CharSequence)str);
            }
            ((TextView)localView).setEnabled(n.c(paramb.cFy(), ((TextView)localView).getText().charAt(0)));
          }
          for (;;)
          {
            j += 1;
            break;
            p.j(localView, "child");
            localView.setVisibility(8);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(187032);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  final void a(ViewGroup paramViewGroup, CharSequence[] paramArrayOfCharSequence)
  {
    AppMethodBeat.i(187028);
    Object localObject1 = paramViewGroup.findViewById(a.d.layout_btn_line0);
    p.j(localObject1, "view.findViewById(R.id.layout_btn_line0)");
    localObject1 = (LinearLayout)localObject1;
    Object localObject2 = paramViewGroup.findViewById(a.d.layout_btn_line1);
    p.j(localObject2, "view.findViewById(R.id.layout_btn_line1)");
    localObject2 = (LinearLayout)localObject2;
    Object localObject3 = paramViewGroup.findViewById(a.d.layout_btn_line2);
    p.j(localObject3, "view.findViewById(R.id.layout_btn_line2)");
    localObject3 = (LinearLayout)localObject3;
    Object localObject4 = paramViewGroup.findViewById(a.d.layout_btn_line3);
    p.j(localObject4, "view.findViewById(R.id.layout_btn_line3)");
    localObject4 = (LinearLayout)localObject4;
    Object localObject5 = paramViewGroup.findViewById(a.d.layout_btn_line4);
    p.j(localObject5, "view.findViewById(R.id.layout_btn_line4)");
    localObject5 = (LinearLayout)localObject5;
    View.OnClickListener localOnClickListener = (View.OnClickListener)new c(this);
    paramViewGroup.findViewById(a.d.btn_delete).setOnTouchListener((View.OnTouchListener)new b(this));
    paramViewGroup = this.context;
    if (paramViewGroup == null) {
      p.bGy("context");
    }
    paramViewGroup = new x(paramViewGroup, a.h.CarLicensePlateKeyboardViewButton);
    int j = paramArrayOfCharSequence.length;
    int i = 4;
    j -= 1;
    for (;;)
    {
      LinearLayout localLinearLayout = (LinearLayout)e.g(new LinearLayout[] { localObject1, localObject2, localObject3, localObject4, localObject5 }, i);
      int k;
      label251:
      int m;
      if (localLinearLayout == null)
      {
        k = j - 1;
        if (k < 0) {
          break label412;
        }
        j = 1;
        m = i - 1;
        if (m < 0) {
          break label418;
        }
      }
      label412:
      label418:
      for (i = 1;; i = 0)
      {
        if ((i | j) != 0) {
          break label424;
        }
        AppMethodBeat.o(187028);
        return;
        CharSequence localCharSequence = (CharSequence)e.g(paramArrayOfCharSequence, j);
        if (localCharSequence != null)
        {
          k = 0;
          while (k < localCharSequence.length())
          {
            char c = localCharSequence.charAt(k);
            TextView localTextView = new TextView((Context)paramViewGroup);
            localTextView.setText((CharSequence)String.valueOf(c));
            localTextView.setOnClickListener(localOnClickListener);
            localLinearLayout.addView((View)localTextView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(0, paramViewGroup.getResources().getDimensionPixelSize(a.c.Edge_5A), 1.0F));
            k += 1;
          }
          localLinearLayout.setVisibility(0);
          break;
        }
        localLinearLayout.setVisibility(8);
        break;
        j = 0;
        break label251;
      }
      label424:
      i = m;
      j = k;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$OnKeyboardOperationListener;", "", "appendText", "", "char", "", "deleteLast", "plugin-car-license-plate_release"})
  public static abstract interface a
  {
    public abstract void G(char paramChar);
    
    public abstract void coS();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$initKeyboardLayoutForType$1", "Lcom/tencent/mm/plugin/appbrand/widget/input/RepeatKeyTouchListener;", "onRepeat", "", "onSingleTap", "plugin-car-license-plate_release"})
  public static final class b
    extends as
  {
    public final void bUS()
    {
      AppMethodBeat.i(187264);
      c.a locala = this.sXX.sXV;
      if (locala != null)
      {
        locala.coS();
        AppMethodBeat.o(187264);
        return;
      }
      AppMethodBeat.o(187264);
    }
    
    public final void coP()
    {
      AppMethodBeat.i(187268);
      c.a locala = this.sXX.sXV;
      if (locala != null)
      {
        locala.coS();
        AppMethodBeat.o(187268);
        return;
      }
      AppMethodBeat.o(187268);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(187576);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$initKeyboardLayoutForType$btnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = this.sXX.sXV;
      if (localObject != null)
      {
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(187576);
          throw paramView;
        }
        ((c.a)localObject).G(((TextView)paramView).getText().charAt(0));
      }
      a.a(this, "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController$initKeyboardLayoutForType$btnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(187576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.c
 * JD-Core Version:    0.7.0.1
 */