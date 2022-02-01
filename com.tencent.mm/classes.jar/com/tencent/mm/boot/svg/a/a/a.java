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

public final class a
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 39.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16268960);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(142.39999F, 92.484291F);
      ((Path)localObject2).lineTo(142.39999F, 33.599998F);
      ((Path)localObject2).lineTo(49.599998F, 33.599998F);
      ((Path)localObject2).lineTo(49.599998F, 158.39999F);
      ((Path)localObject2).lineTo(142.39999F, 158.39999F);
      ((Path)localObject2).lineTo(142.39999F, 102.69538F);
      ((Path)localObject2).lineTo(105.79993F, 141.47121F);
      ((Path)localObject2).cubicTo(105.63241F, 141.6487F, 105.45705F, 141.81863F, 105.2744F, 141.9805F);
      ((Path)localObject2).cubicTo(101.87888F, 144.98962F, 96.686897F, 144.67639F, 93.677773F, 141.28088F);
      ((Path)localObject2).lineTo(72.0F, 116.81955F);
      ((Path)localObject2).lineTo(76.605804F, 112.29486F);
      ((Path)localObject2).lineTo(99.634811F, 130.88316F);
      ((Path)localObject2).lineTo(142.39999F, 92.484291F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(48.0F, 24.0F);
      ((Path)localObject2).lineTo(144.0F, 24.0F);
      ((Path)localObject2).cubicTo(148.41827F, 24.0F, 152.0F, 27.581722F, 152.0F, 32.0F);
      ((Path)localObject2).lineTo(152.0F, 160.0F);
      ((Path)localObject2).cubicTo(152.0F, 164.41827F, 148.41827F, 168.0F, 144.0F, 168.0F);
      ((Path)localObject2).lineTo(48.0F, 168.0F);
      ((Path)localObject2).cubicTo(43.581722F, 168.0F, 40.0F, 164.41827F, 40.0F, 160.0F);
      ((Path)localObject2).lineTo(40.0F, 32.0F);
      ((Path)localObject2).cubicTo(40.0F, 27.581722F, 43.581722F, 24.0F, 48.0F, 24.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(60.0F, 48.0F);
      ((Path)localObject2).lineTo(108.0F, 48.0F);
      ((Path)localObject2).lineTo(108.0F, 57.600002F);
      ((Path)localObject2).lineTo(60.0F, 57.600002F);
      ((Path)localObject2).lineTo(60.0F, 48.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(60.0F, 72.0F);
      ((Path)localObject2).lineTo(108.0F, 72.0F);
      ((Path)localObject2).lineTo(108.0F, 81.599998F);
      ((Path)localObject2).lineTo(60.0F, 81.599998F);
      ((Path)localObject2).lineTo(60.0F, 72.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.a
 * JD-Core Version:    0.7.0.1
 */