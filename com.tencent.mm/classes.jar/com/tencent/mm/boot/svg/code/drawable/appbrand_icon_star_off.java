package com.tencent.mm.boot.svg.code.drawable;

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

public class appbrand_icon_star_off
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.733333F, 0.0F, 1.0F, 3.733333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.6F, 13.6F);
      ((Path)localObject2).cubicTo(8.545519F, 13.6F, 10.933333F, 15.987815F, 10.933333F, 18.933332F);
      ((Path)localObject2).cubicTo(10.933333F, 21.878853F, 8.545519F, 24.266666F, 5.6F, 24.266666F);
      ((Path)localObject2).cubicTo(2.654481F, 24.266666F, 0.2666667F, 21.878853F, 0.2666667F, 18.933332F);
      ((Path)localObject2).cubicTo(0.2666667F, 15.987815F, 2.654481F, 13.6F, 5.6F, 13.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.133333F, 14.666667F);
      ((Path)localObject2).lineTo(22.133333F, 16.799999F);
      ((Path)localObject2).lineTo(18.307667F, 16.799667F);
      ((Path)localObject2).lineTo(24.08758F, 22.579086F);
      ((Path)localObject2).lineTo(22.579086F, 24.08758F);
      ((Path)localObject2).lineTo(16.799667F, 18.307667F);
      ((Path)localObject2).lineTo(16.799999F, 22.133333F);
      ((Path)localObject2).lineTo(14.666667F, 22.133333F);
      ((Path)localObject2).lineTo(14.666667F, 14.666667F);
      ((Path)localObject2).lineTo(22.133333F, 14.666667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.6F, 0.2666667F);
      ((Path)localObject2).cubicTo(8.545519F, 0.2666667F, 10.933333F, 2.654481F, 10.933333F, 5.6F);
      ((Path)localObject2).cubicTo(10.933333F, 8.545519F, 8.545519F, 10.933333F, 5.6F, 10.933333F);
      ((Path)localObject2).cubicTo(2.654481F, 10.933333F, 0.2666667F, 8.545519F, 0.2666667F, 5.6F);
      ((Path)localObject2).cubicTo(0.2666667F, 2.654481F, 2.654481F, 0.2666667F, 5.6F, 0.2666667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.933332F, 0.2666667F);
      ((Path)localObject2).cubicTo(21.878853F, 0.2666667F, 24.266666F, 2.654481F, 24.266666F, 5.6F);
      ((Path)localObject2).cubicTo(24.266666F, 8.545519F, 21.878853F, 10.933333F, 18.933332F, 10.933333F);
      ((Path)localObject2).cubicTo(15.987815F, 10.933333F, 13.6F, 8.545519F, 13.6F, 5.6F);
      ((Path)localObject2).cubicTo(13.6F, 2.654481F, 15.987815F, 0.2666667F, 18.933332F, 0.2666667F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_icon_star_off
 * JD-Core Version:    0.7.0.1
 */