package com.tencent.mm.bt;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Looper;
import com.tencent.mm.api.m;
import com.tencent.mm.api.q.a;
import com.tencent.mm.cache.d;
import com.tencent.mm.e.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class a$b
  implements Runnable
{
  m soN;
  boolean soO;
  
  a$b(a parama, m paramm, boolean paramBoolean)
  {
    this.soN = paramm;
    this.soO = paramBoolean;
  }
  
  private static Bitmap a(Bitmap paramBitmap, Rect paramRect, float paramFloat, BitmapFactory.Options paramOptions, Matrix paramMatrix)
  {
    try
    {
      if ((paramBitmap.getWidth() - paramRect.width() > 9) || (paramBitmap.getHeight() - paramRect.height() > 9)) {
        return Bitmap.createBitmap(paramBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramMatrix, true);
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      y.printErrStackTrace("MicroMsg.DrawingPresenter", localOutOfMemoryError, "", new Object[0]);
      float f1 = 1920.0F / paramOptions.outHeight;
      float f2 = 1920.0F / paramOptions.outWidth;
      if (f1 > f2) {}
      for (;;)
      {
        paramMatrix.reset();
        paramMatrix.postScale(f1, f1, 0.0F, 0.0F);
        paramMatrix.postRotate(-paramFloat);
        if ((paramBitmap.getWidth() - paramRect.width() <= 9) && (paramBitmap.getHeight() - paramRect.height() <= 9)) {
          break;
        }
        return Bitmap.createBitmap(paramBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramMatrix, true);
        f1 = f2;
      }
    }
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
  }
  
  public final void run()
  {
    float f1;
    float f2;
    label734:
    label752:
    for (;;)
    {
      Object localObject4;
      try
      {
        if (Looper.myLooper() == null) {
          Looper.prepare();
        }
        Iterator localIterator1 = this.soH.soA.iterator();
        if (localIterator1.hasNext())
        {
          ((b)localIterator1.next()).tL();
          continue;
        }
        Iterator localIterator2;
        Object localObject3;
        int i;
        int j;
        Object localObject1;
        Bitmap localBitmap1;
        localOptions = new BitmapFactory.Options();
      }
      catch (Exception localException1)
      {
        this.soN.b(localException1);
        try
        {
          localIterator2 = this.soH.soA.iterator();
          if (!localIterator2.hasNext()) {
            break label734;
          }
          ((b)localIterator2.next()).onFinish();
          continue;
          localObject3 = null;
        }
        catch (Exception localException2)
        {
          return;
        }
        if (!this.soH.soy.getBaseBoardView().cLB())
        {
          i = this.soH.soy.getBaseBoardView().getAliveRect().width();
          j = this.soH.soy.getBaseBoardView().getAliveRect().height();
          localObject1 = localObject3;
          if (i <= 0) {
            break label752;
          }
          localObject1 = localObject3;
          if (j <= 0) {
            break label752;
          }
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          break label752;
          if (localObject1 != null) {
            continue;
          }
          this.soN.b(new NullPointerException("bitmap is null!"));
          try
          {
            localObject1 = this.soH.soA.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            ((b)((Iterator)localObject1).next()).onFinish();
            continue;
            localBitmap1 = this.soH.soC;
          }
          catch (Exception localException3)
          {
            return;
          }
        }
        else
        {
          continue;
        }
        this.soH.onDestroy();
        return;
        localObject3 = new Canvas(localBitmap1);
        localObject4 = this.soH.soA.iterator();
        if (((Iterator)localObject4).hasNext())
        {
          ((b)((Iterator)localObject4).next()).tI().c((Canvas)localObject3);
          continue;
        }
      }
      finally
      {
        try
        {
          localObject3 = this.soH.soA.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            ((b)((Iterator)localObject3).next()).onFinish();
            continue;
            throw localBitmap2;
          }
        }
        catch (Exception localException5) {}
      }
      for (;;)
      {
        BitmapFactory.Options localOptions;
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.soH.buT.path, localOptions);
        f1 = localOptions.outHeight * 1.0F / localBitmap2.getHeight();
        f2 = localOptions.outWidth * 1.0F / localBitmap2.getWidth();
        if (f1 <= f2) {
          break label771;
        }
        break;
        f1 = this.soH.soy.getBaseBoardView().b(this.soH.soy.getBaseBoardView().getMainMatrix());
        localObject4 = new Matrix();
        ((Matrix)localObject4).postScale(f2, f2, 0.0F, 0.0F);
        ((Matrix)localObject4).postRotate(-f1);
        Rect localRect = new Rect(this.soH.soy.getBaseBoardView().getAliveRect());
        y.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[] { localRect, Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
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
        this.soN.a((Bitmap)localObject2, this.soO);
        try
        {
          localObject2 = this.soH.soA.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((b)((Iterator)localObject2).next()).onFinish();
          }
          this.soH.onDestroy();
          return;
        }
        catch (Exception localException4)
        {
          return;
        }
        this.soH.onDestroy();
        return;
        this.soH.onDestroy();
      }
    }
    for (;;)
    {
      f2 = f1;
      if (f1 != 0.0F) {
        break;
      }
      f2 = 1.0F;
      break;
      label771:
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bt.a.b
 * JD-Core Version:    0.7.0.1
 */