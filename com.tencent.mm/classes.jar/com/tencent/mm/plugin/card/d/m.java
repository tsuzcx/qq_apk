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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"calculatePopupMenuLocation", "Landroid/graphics/Point;", "anchor", "Landroid/view/View;", "loadImageView", "", "imageView", "Landroid/widget/ImageView;", "url", "", "radius", "", "isRound", "", "defaultRes", "", "width", "height", "loadImageViewCallback", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "Landroid/graphics/Bitmap;", "plugin-card_release"})
public final class m
{
  private static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, kotlin.g.a.m<? super g<?>, ? super Bitmap, x> paramm)
  {
    AppMethodBeat.i(253874);
    p.k(paramImageView, "imageView");
    p.k(paramString, "url");
    Object localObject1 = new e.a();
    Object localObject2 = com.tencent.mm.plugin.card.model.m.arc(paramString);
    p.j(localObject2, "CardSimpleGetPicStrategy…etPictureStoragePath(url)");
    ((e.a)localObject1).Os((String)localObject2);
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOB = false;
    ((e.a)localObject1).kOs = paramInt1;
    ((e.a)localObject1).kOt = paramInt2;
    ((e.a)localObject1).kOo = true;
    localObject1 = ((e.a)localObject1).aRT();
    localObject2 = com.tencent.mm.loader.e.kMy;
    com.tencent.mm.loader.e.aRs().a(paramString, paramImageView, (com.tencent.mm.loader.c.e)localObject1, paramm);
    AppMethodBeat.o(253874);
  }
  
  public static final void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(253869);
    p.k(paramImageView, "imageView");
    p.k(paramString, "url");
    Object localObject1 = new e.a();
    Object localObject2 = com.tencent.mm.plugin.card.model.m.arc(paramString);
    p.j(localObject2, "CardSimpleGetPicStrategy…etPictureStoragePath(url)");
    ((e.a)localObject1).Os((String)localObject2);
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOB = paramBoolean;
    ((e.a)localObject1).kOs = paramInt2;
    ((e.a)localObject1).kOt = paramInt3;
    ((e.a)localObject1).kOo = true;
    if (paramInt1 >= 0) {
      ((e.a)localObject1).kOu = paramInt1;
    }
    localObject1 = ((e.a)localObject1).aRT();
    localObject2 = com.tencent.mm.loader.e.kMy;
    com.tencent.mm.loader.e.aRs().a(paramString, paramImageView, (com.tencent.mm.loader.c.e)localObject1);
    AppMethodBeat.o(253869);
  }
  
  public static final Point dZ(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(253879);
    p.k(paramView, "anchor");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[0];
    int n = paramView.getWidth() / 2;
    int k = arrayOfInt[1];
    int j = arrayOfInt[1] + paramView.getHeight();
    if (k < 0)
    {
      paramView = MMApplicationContext.getContext();
      p.j(paramView, "MMApplicationContext.getContext()");
      paramView = paramView.getResources();
      p.j(paramView, "MMApplicationContext.getContext().resources");
      if (j <= paramView.getDisplayMetrics().heightPixels) {
        break label148;
      }
      paramView = MMApplicationContext.getContext();
      p.j(paramView, "MMApplicationContext.getContext()");
      paramView = paramView.getResources();
      p.j(paramView, "MMApplicationContext.getContext().resources");
      j = paramView.getDisplayMetrics().heightPixels;
    }
    label148:
    for (;;)
    {
      paramView = new Point(n + m, (i + j) / 2);
      AppMethodBeat.o(253879);
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