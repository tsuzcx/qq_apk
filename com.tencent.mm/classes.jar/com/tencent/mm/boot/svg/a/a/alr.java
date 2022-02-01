package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class alr
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.652174F, 0.0F);
      ((Path)localObject2).cubicTo(24.296631F, 0.0F, 31.304348F, 7.007716F, 31.304348F, 15.652174F);
      ((Path)localObject2).cubicTo(31.304348F, 24.296631F, 24.296631F, 31.304348F, 15.652174F, 31.304348F);
      ((Path)localObject2).cubicTo(7.007716F, 31.304348F, 0.0F, 24.296631F, 0.0F, 15.652174F);
      ((Path)localObject2).cubicTo(0.0F, 7.007716F, 7.007716F, 0.0F, 15.652174F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(56.347828F, 0.0F);
      ((Path)localObject2).cubicTo(64.992287F, 0.0F, 72.0F, 7.007716F, 72.0F, 15.652174F);
      ((Path)localObject2).cubicTo(72.0F, 24.296631F, 64.992287F, 31.304348F, 56.347828F, 31.304348F);
      ((Path)localObject2).cubicTo(47.703369F, 31.304348F, 40.695656F, 24.296631F, 40.695656F, 15.652174F);
      ((Path)localObject2).cubicTo(40.695656F, 7.007716F, 47.703369F, 0.0F, 56.347828F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.652174F, 40.695656F);
      ((Path)localObject2).cubicTo(24.296631F, 40.695656F, 31.304348F, 47.703369F, 31.304348F, 56.347828F);
      ((Path)localObject2).cubicTo(31.304348F, 64.992287F, 24.296631F, 72.0F, 15.652174F, 72.0F);
      ((Path)localObject2).cubicTo(7.007716F, 72.0F, 0.0F, 64.992287F, 0.0F, 56.347828F);
      ((Path)localObject2).cubicTo(0.0F, 47.703369F, 7.007716F, 40.695656F, 15.652174F, 40.695656F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(56.347828F, 40.695656F);
      ((Path)localObject1).cubicTo(64.992287F, 40.695656F, 72.0F, 47.703369F, 72.0F, 56.347828F);
      ((Path)localObject1).cubicTo(72.0F, 64.992287F, 64.992287F, 72.0F, 56.347828F, 72.0F);
      ((Path)localObject1).cubicTo(47.703369F, 72.0F, 40.695656F, 64.992287F, 40.695656F, 56.347828F);
      ((Path)localObject1).cubicTo(40.695656F, 47.703369F, 47.703369F, 40.695656F, 56.347828F, 40.695656F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.alr
 * JD-Core Version:    0.7.0.1
 */