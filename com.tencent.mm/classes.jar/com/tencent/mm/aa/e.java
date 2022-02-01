package com.tencent.mm.aa;

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
import com.tencent.mm.cn.a;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.LinkedList;

public final class e
  implements Cloneable
{
  private static int gaN;
  private static Paint gaP;
  private float cHQ;
  private LinkedList<b> cSR;
  public e.a cSS;
  private Bitmap gaO;
  private Path uW;
  
  static
  {
    AppMethodBeat.i(9272);
    gaN = a.bP(12.0F);
    Paint localPaint = new Paint();
    gaP = localPaint;
    localPaint.setAntiAlias(true);
    gaP.setStyle(Paint.Style.STROKE);
    gaP.setColor(-16776961);
    gaP.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9272);
  }
  
  public e(e.a parama, Path paramPath, float paramFloat, Bitmap paramBitmap)
  {
    AppMethodBeat.i(9269);
    this.cSS = parama;
    this.gaO = paramBitmap;
    this.uW = paramPath;
    this.cHQ = paramFloat;
    gaP.setStrokeWidth(a.bP(24.0F) * paramFloat);
    AppMethodBeat.o(9269);
  }
  
  public e(e.a parama, LinkedList<b> paramLinkedList, float paramFloat)
  {
    AppMethodBeat.i(9270);
    this.cSS = parama;
    this.cSR = paramLinkedList;
    this.cHQ = paramFloat;
    gaP.setStrokeWidth(a.bP(24.0F) * paramFloat);
    AppMethodBeat.o(9270);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9271);
    Object localObject1;
    if (this.cSS == e.a.gaQ)
    {
      localObject1 = this.gaO;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        paramCanvas.saveLayer(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), null, 31);
        paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        paramCanvas.drawPath(this.uW, gaP);
        gaP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, gaP);
        gaP.setXfermode(null);
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
    if (this.cSS == e.a.gaR)
    {
      if (this.cSR.size() <= 0)
      {
        AppMethodBeat.o(9271);
        return;
      }
      localObject1 = (b)this.cSR.getLast();
      f1 = ((b)localObject1).scale;
      int i = ((b)localObject1).color;
      j = (int)(Math.random() * 100.0D);
      f3 = gaN * f1;
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233344, (BitmapFactory.Options)localObject2);
      ((BitmapFactory.Options)localObject2).inSampleSize = a.a((BitmapFactory.Options)localObject2, Math.round(((BitmapFactory.Options)localObject2).outWidth * f1 * 0.7F), Math.round(f1 * ((BitmapFactory.Options)localObject2).outHeight * 0.7F));
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
      localObject2 = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233344, (BitmapFactory.Options)localObject2);
      gaP.setStyle(Paint.Style.FILL);
      gaP.setColorFilter(new LightingColorFilter(i, 1));
      if (localObject2 == null) {
        break label460;
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
          paramCanvas.drawBitmap((Bitmap)localObject2, f2, f1, gaP);
        }
        paramCanvas.restore();
        gaP.setStyle(Paint.Style.STROKE);
        gaP.setColorFilter(null);
        AppMethodBeat.o(9271);
        return;
        if (80 < j)
        {
          f2 -= f3;
          f1 -= f3;
        }
      }
      label460:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.e
 * JD-Core Version:    0.7.0.1
 */