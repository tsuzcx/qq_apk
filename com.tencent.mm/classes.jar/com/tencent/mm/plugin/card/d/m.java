package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"calculatePopupMenuLocation", "Landroid/graphics/Point;", "anchor", "Landroid/view/View;", "loadImageView", "", "imageView", "Landroid/widget/ImageView;", "url", "", "radius", "", "isRound", "", "defaultRes", "", "width", "height", "loadImageViewCallback", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "Landroid/graphics/Bitmap;", "plugin-card_release"})
public final class m
{
  private static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, kotlin.g.a.m<? super g<?>, ? super Bitmap, x> paramm)
  {
    AppMethodBeat.i(201728);
    p.h(paramImageView, "imageView");
    p.h(paramString, "url");
    Object localObject1 = new e.a();
    Object localObject2 = com.tencent.mm.plugin.card.model.m.ajp(paramString);
    p.g(localObject2, "CardSimpleGetPicStrategy…etPictureStoragePath(url)");
    ((e.a)localObject1).Hh((String)localObject2);
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZV = false;
    ((e.a)localObject1).hZM = paramInt1;
    ((e.a)localObject1).hZN = paramInt2;
    ((e.a)localObject1).hZI = true;
    localObject1 = ((e.a)localObject1).aJT();
    localObject2 = com.tencent.mm.loader.e.hXU;
    com.tencent.mm.loader.e.aJs().a(paramString, paramImageView, (com.tencent.mm.loader.c.e)localObject1, paramm);
    AppMethodBeat.o(201728);
  }
  
  public static final void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201726);
    p.h(paramImageView, "imageView");
    p.h(paramString, "url");
    Object localObject1 = new e.a();
    Object localObject2 = com.tencent.mm.plugin.card.model.m.ajp(paramString);
    p.g(localObject2, "CardSimpleGetPicStrategy…etPictureStoragePath(url)");
    ((e.a)localObject1).Hh((String)localObject2);
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZV = paramBoolean;
    ((e.a)localObject1).hZM = paramInt2;
    ((e.a)localObject1).hZN = paramInt3;
    ((e.a)localObject1).hZI = true;
    if (paramInt1 >= 0) {
      ((e.a)localObject1).hZO = paramInt1;
    }
    localObject1 = ((e.a)localObject1).aJT();
    localObject2 = com.tencent.mm.loader.e.hXU;
    com.tencent.mm.loader.e.aJs().a(paramString, paramImageView, (com.tencent.mm.loader.c.e)localObject1);
    AppMethodBeat.o(201726);
  }
  
  public static final Point dB(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(201730);
    p.h(paramView, "anchor");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[0];
    int n = paramView.getWidth() / 2;
    int k = arrayOfInt[1];
    int j = arrayOfInt[1] + paramView.getHeight();
    if (k < 0)
    {
      paramView = MMApplicationContext.getContext();
      p.g(paramView, "MMApplicationContext.getContext()");
      paramView = paramView.getResources();
      p.g(paramView, "MMApplicationContext.getContext().resources");
      if (j <= paramView.getDisplayMetrics().heightPixels) {
        break label148;
      }
      paramView = MMApplicationContext.getContext();
      p.g(paramView, "MMApplicationContext.getContext()");
      paramView = paramView.getResources();
      p.g(paramView, "MMApplicationContext.getContext().resources");
      j = paramView.getDisplayMetrics().heightPixels;
    }
    label148:
    for (;;)
    {
      paramView = new Point(n + m, (i + j) / 2);
      AppMethodBeat.o(201730);
      return paramView;
      i = k;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.m
 * JD-Core Version:    0.7.0.1
 */