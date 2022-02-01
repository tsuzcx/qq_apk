package com.tencent.mm.plugin.card.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"calculatePopupMenuLocation", "Landroid/graphics/Point;", "anchor", "Landroid/view/View;", "loadImageView", "", "imageView", "Landroid/widget/ImageView;", "url", "", "radius", "", "isRound", "", "defaultRes", "", "width", "height", "loadImageViewCallback", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "Landroid/graphics/Bitmap;", "plugin-card_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class m
{
  private static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, kotlin.g.a.m<? super g<?>, ? super Bitmap, ah> paramm)
  {
    AppMethodBeat.i(293739);
    s.u(paramImageView, "imageView");
    s.u(paramString, "url");
    Object localObject1 = new e.a();
    Object localObject2 = com.tencent.mm.plugin.card.model.m.akH(paramString);
    s.s(localObject2, "getPictureStoragePath(url)");
    ((e.a)localObject1).GG((String)localObject2);
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqp = false;
    ((e.a)localObject1).nqg = paramInt1;
    ((e.a)localObject1).nqh = paramInt2;
    ((e.a)localObject1).nqc = true;
    localObject1 = ((e.a)localObject1).blI();
    localObject2 = com.tencent.mm.loader.e.noo;
    com.tencent.mm.loader.e.blh().a(paramString, paramImageView, (com.tencent.mm.loader.b.e)localObject1, paramm);
    AppMethodBeat.o(293739);
  }
  
  public static final void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(293736);
    s.u(paramImageView, "imageView");
    s.u(paramString, "url");
    Object localObject1 = new e.a();
    Object localObject2 = com.tencent.mm.plugin.card.model.m.akH(paramString);
    s.s(localObject2, "getPictureStoragePath(url)");
    ((e.a)localObject1).GG((String)localObject2);
    ((e.a)localObject1).nqd = true;
    ((e.a)localObject1).nqp = paramBoolean;
    ((e.a)localObject1).nqg = paramInt2;
    ((e.a)localObject1).nqh = paramInt3;
    ((e.a)localObject1).nqc = true;
    if (paramInt1 >= 0) {
      ((e.a)localObject1).nqi = paramInt1;
    }
    localObject1 = ((e.a)localObject1).blI();
    localObject2 = com.tencent.mm.loader.e.noo;
    com.tencent.mm.loader.e.blh().a(paramString, paramImageView, (com.tencent.mm.loader.b.e)localObject1);
    AppMethodBeat.o(293736);
  }
  
  public static final Point eN(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(293742);
    s.u(paramView, "anchor");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[0];
    int n = paramView.getWidth() / 2;
    int k = arrayOfInt[1];
    int j = arrayOfInt[1] + paramView.getHeight();
    if (k < 0)
    {
      if (j <= MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels) {
        break label116;
      }
      j = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    label116:
    for (;;)
    {
      paramView = new Point(n + m, (i + j) / 2);
      AppMethodBeat.o(293742);
      return paramView;
      i = k;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.m
 * JD-Core Version:    0.7.0.1
 */