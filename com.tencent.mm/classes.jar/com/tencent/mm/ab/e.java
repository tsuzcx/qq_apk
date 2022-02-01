package com.tencent.mm.ab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.cl.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;

public final class e
  implements Cloneable
{
  private static int mAt;
  private static Paint mAv;
  private Path cja;
  private float hco;
  private LinkedList<b> hqs;
  public e.a hqt;
  private Bitmap mAu;
  
  static
  {
    AppMethodBeat.i(9272);
    mAt = a.eo(12.0F);
    Paint localPaint = new Paint();
    mAv = localPaint;
    localPaint.setAntiAlias(true);
    mAv.setStyle(Paint.Style.STROKE);
    mAv.setColor(-16776961);
    mAv.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9272);
  }
  
  public e(e.a parama, Path paramPath, float paramFloat, Bitmap paramBitmap)
  {
    AppMethodBeat.i(9269);
    this.hqt = parama;
    this.mAu = paramBitmap;
    this.cja = paramPath;
    this.hco = paramFloat;
    mAv.setStrokeWidth(a.eo(24.0F) * paramFloat);
    AppMethodBeat.o(9269);
  }
  
  public e(e.a parama, LinkedList<b> paramLinkedList, float paramFloat)
  {
    AppMethodBeat.i(9270);
    this.hqt = parama;
    this.hqs = paramLinkedList;
    this.hco = paramFloat;
    mAv.setStrokeWidth(a.eo(24.0F) * paramFloat);
    AppMethodBeat.o(9270);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9271);
    Object localObject1;
    if (this.hqt == e.a.mAw)
    {
      localObject1 = this.mAu;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        paramCanvas.saveLayer(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), null, 31);
        paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        paramCanvas.drawPath(this.cja, mAv);
        mAv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, mAv);
        mAv.setXfermode(null);
        paramCanvas.restore();
      }
      AppMethodBeat.o(9271);
      return;
    }
    float f1;
    int j;
    float f3;
    Object localObject2;
    float f2;
    if (this.hqt == e.a.mAx)
    {
      if (this.hqs.size() <= 0)
      {
        AppMethodBeat.o(9271);
        return;
      }
      localObject1 = (b)this.hqs.getLast();
      f1 = ((b)localObject1).scale;
      int i = ((b)localObject1).color;
      j = (int)(Math.random() * 100.0D);
      f3 = mAt * f1;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), a.d.mosaic_brush_two, (BitmapFactory.Options)localObject2);
      ((BitmapFactory.Options)localObject2).inSampleSize = a.a((BitmapFactory.Options)localObject2, Math.round(((BitmapFactory.Options)localObject2).outWidth * f1 * 0.7F), Math.round(f1 * ((BitmapFactory.Options)localObject2).outHeight * 0.7F));
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
      localObject2 = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), a.d.mosaic_brush_two, (BitmapFactory.Options)localObject2);
      mAv.setStyle(Paint.Style.FILL);
      mAv.setColorFilter(new LightingColorFilter(i, 1));
      if (localObject2 == null) {
        break label462;
      }
      f2 = ((b)localObject1).centerX - ((Bitmap)localObject2).getWidth() * 1.0F / 2.0F;
      f1 = ((b)localObject1).centerY - ((Bitmap)localObject2).getHeight() * 1.0F / 2.0F;
    }
    for (;;)
    {
      if ((j > 0) && (j <= 20))
      {
        f2 += f3;
        f1 += f3;
      }
      for (;;)
      {
        paramCanvas.save();
        paramCanvas.rotate(-((b)localObject1).rotation, ((b)localObject1).centerX, ((b)localObject1).centerY);
        if (localObject2 != null) {
          paramCanvas.drawBitmap((Bitmap)localObject2, f2, f1, mAv);
        }
        paramCanvas.restore();
        mAv.setStyle(Paint.Style.STROKE);
        mAv.setColorFilter(null);
        AppMethodBeat.o(9271);
        return;
        if (80 < j)
        {
          f2 -= f3;
          f1 -= f3;
        }
      }
      label462:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public static final class b
  {
    public float centerX;
    public float centerY;
    public int color = 0;
    public float rotation = 0.0F;
    public float scale = 0.0F;
    
    public b(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.scale = paramFloat1;
      this.color = paramInt;
      this.rotation = paramFloat2;
      this.centerX = paramFloat3;
      this.centerY = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ab.e
 * JD-Core Version:    0.7.0.1
 */