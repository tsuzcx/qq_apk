package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bsc
  extends c
{
  private final int height = 50;
  private final int width = 50;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 50;
      return 50;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 0.8910065F, 0.4539905F, -8.881499F, 0.4539905F, -0.8910065F, 36.994106F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(25.83573F, 29.0F);
      localPath.cubicTo(26.399111F, 31.619719F, 27.385025F, 33.732395F, 28.793476F, 35.422535F);
      localPath.cubicTo(29.075167F, 35.84507F, 29.356857F, 36.267605F, 29.638548F, 36.549297F);
      localPath.cubicTo(31.046997F, 37.957745F, 33.018829F, 38.943661F, 35.131504F, 39.0F);
      localPath.lineTo(38.793476F, 39.0F);
      localPath.cubicTo(41.187843F, 38.802818F, 43.300518F, 37.676056F, 44.568123F, 35.84507F);
      localPath.cubicTo(45.27235F, 34.859154F, 45.835732F, 33.591549F, 45.976574F, 32.323944F);
      localPath.lineTo(45.976574F, 30.774649F);
      localPath.cubicTo(45.976574F, 28.802816F, 45.694885F, 26.97183F, 45.131504F, 25.140844F);
      localPath.cubicTo(44.990658F, 24.718309F, 44.849815F, 24.295774F, 44.708969F, 23.732395F);
      localPath.cubicTo(44.286434F, 22.183098F, 44.145588F, 20.492958F, 44.145588F, 18.943663F);
      localPath.cubicTo(44.145588F, 18.239437F, 44.286434F, 16.830986F, 44.286434F, 16.830986F);
      localPath.cubicTo(44.42728F, 15.845071F, 43.723053F, 15.0F, 42.737137F, 15.0F);
      localPath.cubicTo(42.032913F, 15.0F, 41.187843F, 15.56338F, 40.765308F, 16.12676F);
      localPath.cubicTo(39.920238F, 16.97183F, 39.497704F, 18.098591F, 39.497704F, 19.225351F);
      localPath.lineTo(39.497704F, 22.746479F);
      localPath.lineTo(39.497704F, 23.169014F);
      localPath.cubicTo(39.356857F, 24.295774F, 38.370941F, 25.0F, 37.244183F, 25.0F);
      localPath.lineTo(17.976576F, 25.0F);
      localPath.cubicTo(16.872005F, 25.0F, 15.976575F, 25.89543F, 15.976575F, 27.0F);
      localPath.cubicTo(15.976575F, 28.10457F, 16.872005F, 29.0F, 17.976576F, 29.0F);
      localPath.lineTo(25.83573F, 29.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 0.7660444F, 0.6427876F, -14.573307F, -0.6427876F, 0.7660444F, 12.015224F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(-1.861548F, 39.610298F);
      localPath.cubicTo(2.055231F, 31.076334F, 14.849355F, 15.051029F, 20.299797F, 12.444754F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 0.9271839F, 0.3746066F, -4.2529F, -0.3746066F, 0.9271839F, 3.769188F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(2.540471F, 13.01096F);
      ((Path)localObject).lineTo(10.597422F, 8.574231F);
      ((Path)localObject).lineTo(12.597422F, 17.074232F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bsc
 * JD-Core Version:    0.7.0.1
 */