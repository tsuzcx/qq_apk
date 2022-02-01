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
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"calculatePopupMenuLocation", "Landroid/graphics/Point;", "anchor", "Landroid/view/View;", "loadImageView", "", "imageView", "Landroid/widget/ImageView;", "url", "", "radius", "", "isRound", "", "defaultRes", "", "width", "height", "plugin-card_release"})
public final class m
{
  public static final void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(218588);
    p.h(paramImageView, "imageView");
    p.h(paramString, "url");
    Object localObject1 = new e.a();
    Object localObject2 = com.tencent.mm.plugin.card.model.m.Zk(paramString);
    p.g(localObject2, "CardSimpleGetPicStrategy…etPictureStoragePath(url)");
    ((e.a)localObject1).yI((String)localObject2);
    ((e.a)localObject1).hgP = true;
    ((e.a)localObject1).hhb = paramBoolean;
    ((e.a)localObject1).hgS = paramInt2;
    ((e.a)localObject1).hgT = paramInt3;
    ((e.a)localObject1).hgO = true;
    if (paramInt1 >= 0) {
      ((e.a)localObject1).hgU = paramInt1;
    }
    localObject1 = ((e.a)localObject1).aru();
    localObject2 = com.tencent.mm.loader.e.hfa;
    com.tencent.mm.loader.e.aqU().a(paramString, paramImageView, (com.tencent.mm.loader.c.e)localObject1);
    AppMethodBeat.o(218588);
  }
  
  public static final Point dJ(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(218590);
    p.h(paramView, "anchor");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[0];
    int n = paramView.getWidth() / 2;
    int k = arrayOfInt[1];
    int j = arrayOfInt[1] + paramView.getHeight();
    if (k < 0)
    {
      paramView = ak.getContext();
      p.g(paramView, "MMApplicationContext.getContext()");
      paramView = paramView.getResources();
      p.g(paramView, "MMApplicationContext.getContext().resources");
      if (j <= paramView.getDisplayMetrics().heightPixels) {
        break label148;
      }
      paramView = ak.getContext();
      p.g(paramView, "MMApplicationContext.getContext()");
      paramView = paramView.getResources();
      p.g(paramView, "MMApplicationContext.getContext().resources");
      j = paramView.getDisplayMetrics().heightPixels;
    }
    label148:
    for (;;)
    {
      paramView = new Point(n + m, (i + j) / 2);
      AppMethodBeat.o(218590);
      return paramView;
      i = k;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m
 * JD-Core Version:    0.7.0.1
 */