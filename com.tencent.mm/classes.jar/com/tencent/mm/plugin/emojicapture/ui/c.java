package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.b;
import com.tencent.mm.ui.ao;
import d.a.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"DEFAULT_STROKE_COLOR", "", "DEFAULT_TEXT_COLOR", "STROKE_COLORS", "", "getSTROKE_COLORS", "()[I", "TEXT_COLORS", "getTEXT_COLORS", "findStrokeColor", "textColor", "findTextColor", "isRedPackageScene", "", "scene", "waitUploading", "waitingMixing", "getIconNorColor", "Landroid/view/View;", "getIconSelColor", "getTextColor", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojicapture_release"})
public final class c
{
  private static final int[] pUF = { -1, -16777216, -314573, -12493, -4920114, -4724993, -144437 };
  private static final int[] pUG = { -16777216, -1, -15616, -2724096, -16339626, -15954996, -298125 };
  
  public static final int Cr(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(475);
    Object localObject = pUF;
    int i;
    if (localObject.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label56;
      }
    }
    label56:
    int k;
    for (localObject = null;; localObject = Integer.valueOf(k))
    {
      if (localObject == null) {
        break label261;
      }
      paramInt = ((Integer)localObject).intValue();
      AppMethodBeat.o(475);
      return paramInt;
      i = 0;
      break;
      i = localObject[0];
      int m = e.O((int[])localObject);
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
    label261:
    AppMethodBeat.o(475);
    return -1;
  }
  
  public static final int Cs(int paramInt)
  {
    AppMethodBeat.i(476);
    paramInt = e.n(pUF, paramInt);
    if (paramInt < 0)
    {
      AppMethodBeat.o(476);
      return -16777216;
    }
    paramInt = pUG[paramInt];
    AppMethodBeat.o(476);
    return paramInt;
  }
  
  public static final boolean Ct(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static final boolean Cu(int paramInt)
  {
    AppMethodBeat.i(480);
    if ((Ct(paramInt)) && ((paramInt == 4) || (paramInt == 5)))
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
    p.h(paramImageView, "$this$setSvgDrawable");
    paramImageView.setImageDrawable(ao.k(paramImageView.getContext(), paramInt1, paramInt2));
    AppMethodBeat.o(479);
  }
  
  public static final int[] ckn()
  {
    return pUF;
  }
  
  public static final int[] cko()
  {
    return pUG;
  }
  
  public static final int dP(View paramView)
  {
    AppMethodBeat.i(477);
    p.h(paramView, "$this$getIconSelColor");
    Context localContext = paramView.getContext();
    p.g(localContext, "context");
    int i = localContext.getResources().getColor(b.ck(paramView.getContext()));
    AppMethodBeat.o(477);
    return i;
  }
  
  public static final int dQ(View paramView)
  {
    AppMethodBeat.i(478);
    p.h(paramView, "$this$getIconNorColor");
    paramView = paramView.getContext();
    p.g(paramView, "context");
    int i = paramView.getResources().getColor(2131099732);
    AppMethodBeat.o(478);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.c
 * JD-Core Version:    0.7.0.1
 */