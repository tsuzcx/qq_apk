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

public class panel_icon_transfer
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-13421773);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 48.0F, 0.0F, 1.0F, 48.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(57.0F, 42.0F);
      ((Path)localObject3).lineTo(71.836067F, 42.0F);
      ((Path)localObject3).cubicTo(73.492928F, 42.0F, 74.836067F, 43.343147F, 74.836067F, 45.0F);
      ((Path)localObject3).cubicTo(74.836067F, 45.955631F, 74.380783F, 46.854092F, 73.610161F, 47.419216F);
      ((Path)localObject3).lineTo(39.985905F, 72.077003F);
      ((Path)localObject3).cubicTo(39.31786F, 72.566902F, 38.379154F, 72.422485F, 37.889256F, 71.75444F);
      ((Path)localObject3).cubicTo(37.593067F, 71.350548F, 37.518009F, 70.825478F, 37.689171F, 70.354782F);
      ((Path)localObject3).lineTo(44.727272F, 51.0F);
      ((Path)localObject3).lineTo(3.0F, 51.0F);
      ((Path)localObject3).cubicTo(1.343146F, 51.0F, 2.029061E-016F, 49.656853F, 0.0F, 48.0F);
      ((Path)localObject3).lineTo(0.0F, 45.0F);
      ((Path)localObject3).cubicTo(-2.029061E-016F, 43.343147F, 1.343146F, 42.0F, 3.0F, 42.0F);
      ((Path)localObject3).lineTo(57.0F, 42.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.272728F, 24.0F);
      ((Path)localObject2).lineTo(75.0F, 24.0F);
      ((Path)localObject2).cubicTo(76.656853F, 24.0F, 78.0F, 25.343145F, 78.0F, 27.0F);
      ((Path)localObject2).lineTo(78.0F, 30.0F);
      ((Path)localObject2).cubicTo(78.0F, 31.656855F, 76.656853F, 33.0F, 75.0F, 33.0F);
      ((Path)localObject2).lineTo(21.0F, 33.0F);
      ((Path)localObject2).lineTo(3.16393F, 33.0F);
      ((Path)localObject2).cubicTo(1.507075F, 33.0F, 0.1639296F, 31.656855F, 0.1639296F, 30.0F);
      ((Path)localObject2).cubicTo(0.1639296F, 29.044369F, 0.6192133F, 28.14591F, 1.389839F, 27.580786F);
      ((Path)localObject2).lineTo(35.014095F, 2.922998F);
      ((Path)localObject2).cubicTo(35.68214F, 2.433096F, 36.620846F, 2.577513F, 37.110744F, 3.24556F);
      ((Path)localObject2).cubicTo(37.406933F, 3.649451F, 37.481991F, 4.174522F, 37.310829F, 4.64522F);
      ((Path)localObject2).lineTo(30.272728F, 24.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.panel_icon_transfer
 * JD-Core Version:    0.7.0.1
 */