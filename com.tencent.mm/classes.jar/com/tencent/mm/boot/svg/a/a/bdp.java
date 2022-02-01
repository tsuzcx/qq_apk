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

public final class bdp
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-855310);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 30.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(4.0F, 56.998116F);
      ((Path)localObject3).cubicTo(4.0F, 56.997799F, 73.997719F, 57.0F, 73.997719F, 57.0F);
      ((Path)localObject3).cubicTo(74.002319F, 57.0F, 74.0F, 14.001884F, 74.0F, 14.001884F);
      ((Path)localObject3).cubicTo(74.0F, 14.004772F, 56.5F, 14.0F, 56.5F, 14.0F);
      ((Path)localObject3).lineTo(49.0F, 4.0F);
      ((Path)localObject3).lineTo(29.0F, 4.0F);
      ((Path)localObject3).lineTo(21.5F, 14.0F);
      ((Path)localObject3).lineTo(3.999805F, 14.0F);
      ((Path)localObject3).cubicTo(3.999931F, 14.00048F, 4.0F, 56.998116F, 4.0F, 56.998116F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(3.993171F, 10.0F);
      ((Path)localObject3).lineTo(19.5F, 10.0F);
      ((Path)localObject3).lineTo(27.0F, 0.0F);
      ((Path)localObject3).lineTo(51.0F, 0.0F);
      ((Path)localObject3).lineTo(58.5F, 10.0F);
      ((Path)localObject3).lineTo(74.006828F, 10.0F);
      ((Path)localObject3).cubicTo(76.200439F, 10.0F, 78.0F, 11.791705F, 78.0F, 14.001884F);
      ((Path)localObject3).lineTo(78.0F, 56.998116F);
      ((Path)localObject3).cubicTo(78.0F, 59.214787F, 76.208122F, 61.0F, 73.997719F, 61.0F);
      ((Path)localObject3).lineTo(4.002278F, 61.0F);
      ((Path)localObject3).cubicTo(1.794424F, 61.0F, 0.0F, 59.208294F, 0.0F, 56.998116F);
      ((Path)localObject3).lineTo(0.0F, 14.001884F);
      ((Path)localObject3).cubicTo(0.0F, 11.785213F, 1.787804F, 10.0F, 3.993171F, 10.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(21.0F, 33.0F);
      ((Path)localObject2).cubicTo(21.0F, 42.941124F, 29.058874F, 51.0F, 39.0F, 51.0F);
      ((Path)localObject2).cubicTo(44.036018F, 51.0F, 48.588997F, 48.93187F, 51.855957F, 45.598595F);
      ((Path)localObject2).lineTo(49.027344F, 42.769985F);
      ((Path)localObject2).cubicTo(46.484406F, 45.379486F, 42.931446F, 47.0F, 39.0F, 47.0F);
      ((Path)localObject2).cubicTo(31.268013F, 47.0F, 25.0F, 40.731987F, 25.0F, 33.0F);
      ((Path)localObject2).lineTo(30.5F, 33.0F);
      ((Path)localObject2).lineTo(22.5F, 25.0F);
      ((Path)localObject2).lineTo(14.5F, 33.0F);
      ((Path)localObject2).lineTo(21.0F, 33.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(57.0F, 33.0F);
      ((Path)localObject2).cubicTo(57.0F, 23.058874F, 48.941124F, 15.0F, 39.0F, 15.0F);
      ((Path)localObject2).cubicTo(33.963982F, 15.0F, 29.411005F, 17.068129F, 26.144045F, 20.401403F);
      ((Path)localObject2).lineTo(28.972656F, 23.230017F);
      ((Path)localObject2).cubicTo(31.515596F, 20.620514F, 35.068554F, 19.0F, 39.0F, 19.0F);
      ((Path)localObject2).cubicTo(46.731987F, 19.0F, 53.0F, 25.268013F, 53.0F, 33.0F);
      ((Path)localObject2).lineTo(47.5F, 33.0F);
      ((Path)localObject2).lineTo(55.5F, 41.0F);
      ((Path)localObject2).lineTo(63.5F, 33.0F);
      ((Path)localObject2).lineTo(57.0F, 33.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bdp
 * JD-Core Version:    0.7.0.1
 */