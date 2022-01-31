package com.tencent.mm.bs;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.api.s.a;
import com.tencent.mm.cache.e;
import com.tencent.mm.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

final class a$b
  implements Runnable
{
  n wht;
  boolean whu;
  
  a$b(a parama, n paramn, boolean paramBoolean)
  {
    this.wht = paramn;
    this.whu = paramBoolean;
  }
  
  private static Bitmap a(Bitmap paramBitmap, Rect paramRect, float paramFloat, BitmapFactory.Options paramOptions, Matrix paramMatrix)
  {
    AppMethodBeat.i(116320);
    for (;;)
    {
      try
      {
        if ((paramBitmap.getWidth() - paramRect.width() <= 9) && (paramBitmap.getHeight() - paramRect.height() <= 9)) {
          continue;
        }
        localBitmap = Bitmap.createBitmap(paramBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramMatrix, true);
        paramBitmap = localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Bitmap localBitmap;
        ab.printErrStackTrace("MicroMsg.DrawingPresenter", localOutOfMemoryError, "", new Object[0]);
        float f1 = 1920.0F / paramOptions.outHeight;
        float f2 = 1920.0F / paramOptions.outWidth;
        if (f1 <= f2) {
          continue;
        }
        paramMatrix.reset();
        paramMatrix.postScale(f1, f1, 0.0F, 0.0F);
        paramMatrix.postRotate(-paramFloat);
        if ((paramBitmap.getWidth() - paramRect.width() <= 9) && (paramBitmap.getHeight() - paramRect.height() <= 9)) {
          continue;
        }
        paramBitmap = Bitmap.createBitmap(paramBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramMatrix, true);
        continue;
        f1 = f2;
        continue;
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
        continue;
      }
      AppMethodBeat.o(116320);
      return paramBitmap;
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
      paramBitmap = localBitmap;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(116319);
    Object localObject4;
    try
    {
      if (Looper.myLooper() == null) {
        Looper.prepare();
      }
      Iterator localIterator1 = this.whn.whe.iterator();
      while (localIterator1.hasNext()) {
        ((b)localIterator1.next()).CD();
      }
      Iterator localIterator2;
      Object localObject3;
      int i;
      int j;
      Object localObject1;
      Bitmap localBitmap1;
      throw localBitmap2;
    }
    catch (Exception localException1)
    {
      this.wht.onError(localException1);
      try
      {
        localIterator2 = this.whn.whe.iterator();
        while (localIterator2.hasNext()) {
          ((b)localIterator2.next()).onFinish();
        }
        localObject3 = null;
      }
      catch (Exception localException2)
      {
        AppMethodBeat.o(116319);
        return;
      }
      if (!this.whn.whc.getBaseBoardView().dQS())
      {
        i = this.whn.whc.getBaseBoardView().getAliveRect().width();
        j = this.whn.whc.getBaseBoardView().getAliveRect().height();
        localObject1 = localObject3;
        if (i <= 0) {
          break label800;
        }
        localObject1 = localObject3;
        if (j <= 0) {
          break label800;
        }
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        break label800;
      }
      while (localObject1 == null)
      {
        this.wht.onError(new NullPointerException("bitmap is null!"));
        try
        {
          localObject1 = this.whn.whe.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((b)((Iterator)localObject1).next()).onFinish();
          }
          localBitmap1 = this.whn.whg;
        }
        catch (Exception localException3)
        {
          AppMethodBeat.o(116319);
          return;
        }
        continue;
        this.whn.onDestroy();
        AppMethodBeat.o(116319);
        return;
      }
      localObject3 = new Canvas(localBitmap1);
      localObject4 = this.whn.whe.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((b)((Iterator)localObject4).next()).CB().c((Canvas)localObject3);
      }
    }
    finally
    {
      try
      {
        localObject3 = this.whn.whe.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((b)((Iterator)localObject3).next()).onFinish();
        }
        AppMethodBeat.o(116319);
      }
      catch (Exception localException5) {}
    }
    label388:
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(this.whn.bWd.path, localOptions);
    float f1 = localOptions.outHeight * 1.0F / localBitmap2.getHeight();
    float f2 = localOptions.outWidth * 1.0F / localBitmap2.getWidth();
    if (f1 > f2) {
      break label803;
    }
    for (;;)
    {
      f1 = this.whn.whc.getBaseBoardView().b(this.whn.whc.getBaseBoardView().getMainMatrix());
      localObject4 = new Matrix();
      ((Matrix)localObject4).postScale(f2, f2, 0.0F, 0.0F);
      ((Matrix)localObject4).postRotate(-f1);
      Rect localRect = new Rect(this.whn.whc.getBaseBoardView().getAliveRect());
      ab.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[] { localRect, Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
      if (localRect.left < 0) {
        localRect.left = 0;
      }
      if (localRect.top < 0) {
        localRect.top = 0;
      }
      if (localRect.bottom < 0) {
        localRect.bottom = 0;
      }
      if (localRect.right < 0) {
        localRect.right = 0;
      }
      if (localRect.bottom > localBitmap2.getHeight()) {
        localRect.bottom = localBitmap2.getHeight();
      }
      if (localRect.right > localBitmap2.getWidth()) {
        localRect.right = localBitmap2.getWidth();
      }
      Object localObject2 = a(localBitmap2, localRect, f1, localOptions, (Matrix)localObject4);
      this.wht.b((Bitmap)localObject2, this.whu);
      try
      {
        localObject2 = this.whn.whe.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((b)((Iterator)localObject2).next()).onFinish();
        }
        f1 = f2;
      }
      catch (Exception localException4)
      {
        AppMethodBeat.o(116319);
        return;
      }
      break label803;
      this.whn.onDestroy();
      AppMethodBeat.o(116319);
      return;
      this.whn.onDestroy();
      AppMethodBeat.o(116319);
      return;
      this.whn.onDestroy();
      break label388;
      label800:
      break;
      label803:
      f2 = f1;
      if (f1 == 0.0F) {
        f2 = 1.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bs.a.b
 * JD-Core Version:    0.7.0.1
 */