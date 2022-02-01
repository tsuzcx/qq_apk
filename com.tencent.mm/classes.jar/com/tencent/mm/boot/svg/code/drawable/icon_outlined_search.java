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

public class icon_outlined_search
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.6F, 0.0F, 1.0F, 3.6F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.245378F, 0.0F);
      ((Path)localObject2).cubicTo(11.246897F, 0.0F, 14.490756F, 3.243859F, 14.490756F, 7.245378F);
      ((Path)localObject2).cubicTo(14.490756F, 9.048666F, 13.831973F, 10.698084F, 12.741946F, 11.966092F);
      ((Path)localObject2).lineTo(17.0F, 16.225233F);
      ((Path)localObject2).lineTo(16.121727F, 17.103506F);
      ((Path)localObject2).lineTo(11.853742F, 12.836574F);
      ((Path)localObject2).cubicTo(10.601368F, 13.869984F, 8.995869F, 14.490756F, 7.245378F, 14.490756F);
      ((Path)localObject2).cubicTo(3.243859F, 14.490756F, 0.0F, 11.246897F, 0.0F, 7.245378F);
      ((Path)localObject2).cubicTo(0.0F, 3.243859F, 3.243859F, 0.0F, 7.245378F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(7.245375F, 1.242078F);
      ((Path)localObject2).cubicTo(3.929831F, 1.242078F, 1.242062F, 3.929847F, 1.242062F, 7.245391F);
      ((Path)localObject2).cubicTo(1.242062F, 10.560935F, 3.929831F, 13.248704F, 7.245375F, 13.248704F);
      ((Path)localObject2).cubicTo(10.560919F, 13.248704F, 13.248688F, 10.560935F, 13.248688F, 7.245391F);
      ((Path)localObject2).cubicTo(13.248688F, 3.929847F, 10.560919F, 1.242078F, 7.245375F, 1.242078F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_outlined_search
 * JD-Core Version:    0.7.0.1
 */