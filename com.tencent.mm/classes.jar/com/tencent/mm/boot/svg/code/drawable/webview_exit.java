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

public class webview_exit
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, -127.0F, 0.0F, 1.0F, -128.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 127.0F, 0.0F, 1.0F, 128.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-9276814);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(78.0F, 47.0F);
      ((Path)localObject3).cubicTo(78.0F, 68.539108F, 60.539104F, 86.0F, 39.0F, 86.0F);
      ((Path)localObject3).cubicTo(17.460896F, 86.0F, 0.0F, 68.539108F, 0.0F, 47.0F);
      ((Path)localObject3).cubicTo(0.0F, 29.647755F, 11.332416F, 14.942338F, 27.0F, 9.880997F);
      ((Path)localObject3).lineTo(27.0F, 18.408052F);
      ((Path)localObject3).cubicTo(15.838201F, 23.098259F, 8.0F, 34.133774F, 8.0F, 47.0F);
      ((Path)localObject3).cubicTo(8.0F, 64.120827F, 21.879173F, 78.0F, 39.0F, 78.0F);
      ((Path)localObject3).cubicTo(56.120827F, 78.0F, 70.0F, 64.120827F, 70.0F, 47.0F);
      ((Path)localObject3).cubicTo(70.0F, 34.133774F, 62.1618F, 23.098259F, 51.0F, 18.408056F);
      ((Path)localObject3).lineTo(51.0F, 9.880997F);
      ((Path)localObject3).cubicTo(66.667587F, 14.942338F, 78.0F, 29.647755F, 78.0F, 47.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(35.0F, 2.0F);
      ((Path)localObject2).cubicTo(35.0F, 0.8954305F, 35.895432F, 0.0F, 37.0F, 0.0F);
      ((Path)localObject2).lineTo(42.0F, 0.0F);
      ((Path)localObject2).cubicTo(43.104568F, 0.0F, 44.0F, 0.8954305F, 44.0F, 2.0F);
      ((Path)localObject2).lineTo(44.0F, 28.0F);
      ((Path)localObject2).cubicTo(44.0F, 29.10457F, 43.104568F, 30.0F, 42.0F, 30.0F);
      ((Path)localObject2).lineTo(37.0F, 30.0F);
      ((Path)localObject2).cubicTo(35.895432F, 30.0F, 35.0F, 29.10457F, 35.0F, 28.0F);
      ((Path)localObject2).lineTo(35.0F, 2.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.webview_exit
 * JD-Core Version:    0.7.0.1
 */