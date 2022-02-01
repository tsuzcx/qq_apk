package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.b;
import com.tencent.mm.plugin.emojicapture.a.c;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"DEFAULT_STROKE_COLOR", "", "DEFAULT_TEXT_COLOR", "STROKE_COLORS", "", "getSTROKE_COLORS", "()[I", "TEXT_COLORS", "getTEXT_COLORS", "findStrokeColor", "textColor", "findTextColor", "isRedPackageScene", "", "scene", "waitUploading", "waitingMixing", "getIconNorColor", "Landroid/view/View;", "getIconSelColor", "getTextColor", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojicapture_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final int[] ykb = { -1, -16777216, -314573, -12493, -4920114, -4724993, -144437 };
  private static final int[] ykc = { -16777216, -1, -15616, -2724096, -16339626, -15954996, -298125 };
  
  public static final int KT(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(475);
    Object localObject = ykb;
    int i;
    if (localObject.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label50;
      }
    }
    label50:
    int k;
    for (localObject = null;; localObject = Integer.valueOf(k))
    {
      if (localObject != null) {
        break label255;
      }
      AppMethodBeat.o(475);
      return -1;
      i = 0;
      break;
      i = localObject[0];
      int m = k.ad((int[])localObject);
      k = i;
      if (m != 0)
      {
        k = Color.red(paramInt) - Color.red(i);
        int n = Color.green(paramInt) - Color.green(i);
        int i1 = Color.blue(paramInt) - Color.blue(i);
        double d1 = Math.sqrt(k * k + n * n + i1 * i1);
        k = i;
        if (m > 0) {
          for (;;)
          {
            k = localObject[j];
            n = Color.red(paramInt) - Color.red(k);
            i1 = Color.green(paramInt) - Color.green(k);
            int i2 = Color.blue(paramInt) - Color.blue(k);
            double d3 = Math.sqrt(n * n + i1 * i1 + i2 * i2);
            double d2 = d1;
            if (Double.compare(d1, d3) > 0)
            {
              d2 = d3;
              i = k;
            }
            k = i;
            if (j == m) {
              break;
            }
            j += 1;
            d1 = d2;
          }
        }
      }
    }
    label255:
    paramInt = ((Integer)localObject).intValue();
    AppMethodBeat.o(475);
    return paramInt;
  }
  
  public static final int KU(int paramInt)
  {
    AppMethodBeat.i(476);
    paramInt = k.B(ykb, paramInt);
    if (paramInt < 0)
    {
      AppMethodBeat.o(476);
      return -16777216;
    }
    paramInt = ykc[paramInt];
    AppMethodBeat.o(476);
    return paramInt;
  }
  
  public static final boolean KV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static final boolean KW(int paramInt)
  {
    AppMethodBeat.i(480);
    if ((KV(paramInt)) && ((paramInt == 4) || (paramInt == 5)))
    {
      AppMethodBeat.o(480);
      return true;
    }
    AppMethodBeat.o(480);
    return false;
  }
  
  public static final void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(479);
    s.u(paramImageView, "<this>");
    paramImageView.setImageDrawable(bb.m(paramImageView.getContext(), paramInt1, paramInt2));
    AppMethodBeat.o(479);
  }
  
  public static final int[] dEF()
  {
    return ykb;
  }
  
  public static final int[] dEG()
  {
    return ykc;
  }
  
  public static final int eZ(View paramView)
  {
    AppMethodBeat.i(477);
    s.u(paramView, "<this>");
    Resources localResources = paramView.getContext().getResources();
    paramView = paramView.getContext();
    int i = a.b.iconColor;
    if (paramView == null) {}
    TypedValue localTypedValue;
    for (i = 0;; i = localTypedValue.resourceId)
    {
      i = localResources.getColor(i);
      AppMethodBeat.o(477);
      return i;
      localTypedValue = new TypedValue();
      paramView.getTheme().resolveAttribute(i, localTypedValue, true);
    }
  }
  
  public static final int fa(View paramView)
  {
    AppMethodBeat.i(478);
    s.u(paramView, "<this>");
    int i = paramView.getContext().getResources().getColor(a.c.FG_0);
    AppMethodBeat.o(478);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.b
 * JD-Core Version:    0.7.0.1
 */