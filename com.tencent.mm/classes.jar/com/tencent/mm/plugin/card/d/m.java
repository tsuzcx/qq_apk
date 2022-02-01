package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"calculatePopupMenuLocation", "Landroid/graphics/Point;", "anchor", "Landroid/view/View;", "loadImageView", "", "imageView", "Landroid/widget/ImageView;", "url", "", "radius", "", "isRound", "", "defaultRes", "", "width", "height", "plugin-card_release"})
public final class m
{
  public static final void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(192851);
    k.h(paramImageView, "imageView");
    k.h(paramString, "url");
    Object localObject1 = new e.a();
    Object localObject2 = com.tencent.mm.plugin.card.model.m.Qy(paramString);
    k.g(localObject2, "CardSimpleGetPicStrategy…etPictureStoragePath(url)");
    ((e.a)localObject1).rf((String)localObject2);
    ((e.a)localObject1).gjE = true;
    ((e.a)localObject1).gjP = paramBoolean;
    ((e.a)localObject1).gjH = paramInt2;
    ((e.a)localObject1).gjI = paramInt3;
    ((e.a)localObject1).gjD = true;
    if (paramInt1 >= 0) {
      ((e.a)localObject1).gjJ = paramInt1;
    }
    localObject1 = ((e.a)localObject1).ahr();
    localObject2 = com.tencent.mm.loader.e.ghT;
    com.tencent.mm.loader.e.agS().a(paramString, paramImageView, (com.tencent.mm.loader.c.e)localObject1);
    AppMethodBeat.o(192851);
  }
  
  public static final Point dE(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(192853);
    k.h(paramView, "anchor");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[0];
    int n = paramView.getWidth() / 2;
    int k = arrayOfInt[1];
    int j = arrayOfInt[1] + paramView.getHeight();
    if (k < 0)
    {
      paramView = aj.getContext();
      k.g(paramView, "MMApplicationContext.getContext()");
      paramView = paramView.getResources();
      k.g(paramView, "MMApplicationContext.getContext().resources");
      if (j <= paramView.getDisplayMetrics().heightPixels) {
        break label148;
      }
      paramView = aj.getContext();
      k.g(paramView, "MMApplicationContext.getContext()");
      paramView = paramView.getResources();
      k.g(paramView, "MMApplicationContext.getContext().resources");
      j = paramView.getDisplayMetrics().heightPixels;
    }
    label148:
    for (;;)
    {
      paramView = new Point(n + m, (i + j) / 2);
      AppMethodBeat.o(192853);
      return paramView;
      i = k;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m
 * JD-Core Version:    0.7.0.1
 */