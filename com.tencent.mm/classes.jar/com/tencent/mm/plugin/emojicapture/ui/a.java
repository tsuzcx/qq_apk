package com.tencent.mm.plugin.emojicapture.ui;

import a.a.e;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"DEFAULT_STROKE_COLOR", "", "DEFAULT_TEXT_COLOR", "STROKE_COLORS", "", "getSTROKE_COLORS", "()[I", "TEXT_COLORS", "getTEXT_COLORS", "findStrokeColor", "textColor", "findTextColor", "isRedPackageScene", "", "scene", "waitUploading", "waitingMixing", "getIconNorColor", "Landroid/view/View;", "getIconSelColor", "getTextColor", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojicapture_release"})
public final class a
{
  private static final int[] lxj = { -1, -16777216, -314573, -12493, -4920114, -4724993, -144437 };
  private static final int[] lxk = { -16777216, -1, -15616, -2724096, -16339626, -15954996, -298125 };
  
  public static final void a(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(2893);
    j.q(paramImageView, "receiver$0");
    paramImageView.setImageDrawable(aj.g(paramImageView.getContext(), 2131231523, paramInt));
    AppMethodBeat.o(2893);
  }
  
  public static final int[] boT()
  {
    return lxj;
  }
  
  public static final int[] boU()
  {
    return lxk;
  }
  
  public static final int dk(View paramView)
  {
    AppMethodBeat.i(2891);
    j.q(paramView, "receiver$0");
    Context localContext = paramView.getContext();
    j.p(localContext, "context");
    int i = localContext.getResources().getColor(com.tencent.mm.emoji.e.a.A(paramView.getContext(), 2130772208));
    AppMethodBeat.o(2891);
    return i;
  }
  
  public static final int dl(View paramView)
  {
    AppMethodBeat.i(2892);
    j.q(paramView, "receiver$0");
    paramView = paramView.getContext();
    j.p(paramView, "context");
    int i = paramView.getResources().getColor(2131689481);
    AppMethodBeat.o(2892);
    return i;
  }
  
  public static final int uM(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(2889);
    Object localObject = lxj;
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
        break label252;
      }
      paramInt = ((Integer)localObject).intValue();
      AppMethodBeat.o(2889);
      return paramInt;
      i = 0;
      break;
      i = localObject[0];
      k = Color.red(paramInt) - Color.red(i);
      int m = Color.green(paramInt) - Color.green(i);
      int n = Color.blue(paramInt) - Color.blue(i);
      double d1 = Math.sqrt(k * k + m * m + n * n);
      m = e.M((int[])localObject);
      k = i;
      if (m > 0) {
        for (;;)
        {
          k = localObject[j];
          n = Color.red(paramInt) - Color.red(k);
          int i1 = Color.green(paramInt) - Color.green(k);
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
    label252:
    AppMethodBeat.o(2889);
    return -1;
  }
  
  public static final int uN(int paramInt)
  {
    AppMethodBeat.i(2890);
    paramInt = e.k(lxj, paramInt);
    if (paramInt < 0)
    {
      AppMethodBeat.o(2890);
      return -16777216;
    }
    paramInt = lxk[paramInt];
    AppMethodBeat.o(2890);
    return paramInt;
  }
  
  public static final boolean uO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static final boolean uP(int paramInt)
  {
    AppMethodBeat.i(2894);
    if ((uO(paramInt)) && ((paramInt == 4) || (paramInt == 5)))
    {
      AppMethodBeat.o(2894);
      return true;
    }
    AppMethodBeat.o(2894);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a
 * JD-Core Version:    0.7.0.1
 */