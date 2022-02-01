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

public class ime_upper_click
  extends c
{
  private final int height = 35;
  private final int width = 33;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 33;
      return 35;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setColor(-13421773);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -31.0F, 0.0F, 1.0F, -1305.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 1306.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.0F, 14.0F);
      ((Path)localObject2).lineTo(24.0F, 14.0F);
      ((Path)localObject2).lineTo(24.0F, 32.0F);
      ((Path)localObject2).lineTo(7.0F, 32.0F);
      ((Path)localObject2).lineTo(7.0F, 14.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.0F, 1.0F);
      ((Path)localObject2).lineTo(30.0F, 16.0F);
      ((Path)localObject2).lineTo(0.0F, 16.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-13421773);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(23.142447F, 33.0F);
      ((Path)localObject1).lineTo(8.662008F, 33.0F);
      ((Path)localObject1).lineTo(8.662008F, 33.0F);
      ((Path)localObject1).cubicTo(7.329121F, 33.0F, 6.248601F, 31.938393F, 6.248601F, 30.628859F);
      ((Path)localObject1).cubicTo(6.248601F, 30.628859F, 6.248601F, 30.628859F, 6.248601F, 30.628859F);
      ((Path)localObject1).lineTo(6.248601F, 17.192503F);
      ((Path)localObject1).lineTo(0.9391059F, 17.105562F);
      ((Path)localObject1).lineTo(0.7058098F, 16.876354F);
      ((Path)localObject1).lineTo(0.7058097F, 16.876352F);
      ((Path)localObject1).cubicTo(-0.23527F, 15.950611F, -0.23527F, 14.45091F, 0.70581F, 13.525177F);
      ((Path)localObject1).lineTo(13.794531F, 0.6895053F);
      ((Path)localObject1).lineTo(13.794531F, 0.689505F);
      ((Path)localObject1).cubicTo(14.73585F, -0.2298351F, 16.256115F, -0.2298351F, 17.197432F, 0.6895053F);
      ((Path)localObject1).lineTo(30.294189F, 13.541003F);
      ((Path)localObject1).lineTo(30.294189F, 13.541003F);
      ((Path)localObject1).cubicTo(31.23527F, 14.466745F, 31.23527F, 15.966447F, 30.294189F, 16.892179F);
      ((Path)localObject1).lineTo(30.060894F, 17.121387F);
      ((Path)localObject1).lineTo(25.555866F, 17.192522F);
      ((Path)localObject1).lineTo(25.555866F, 30.628878F);
      ((Path)localObject1).lineTo(25.555866F, 30.628878F);
      ((Path)localObject1).cubicTo(25.555866F, 31.938412F, 24.475346F, 33.0F, 23.142458F, 33.0F);
      ((Path)localObject1).cubicTo(23.142458F, 33.0F, 23.142458F, 33.0F, 23.142458F, 33.0F);
      ((Path)localObject1).lineTo(23.142447F, 33.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_upper_click
 * JD-Core Version:    0.7.0.1
 */