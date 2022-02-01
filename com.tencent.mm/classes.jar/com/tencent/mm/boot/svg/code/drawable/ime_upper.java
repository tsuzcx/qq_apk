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

public class ime_upper
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
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setColor(-13158600);
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
      localObject1 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(23.142447F, 33.0F);
      ((Path)localObject3).lineTo(8.662008F, 33.0F);
      ((Path)localObject3).lineTo(8.662008F, 33.0F);
      ((Path)localObject3).cubicTo(7.329121F, 33.0F, 6.248601F, 31.938393F, 6.248601F, 30.628859F);
      ((Path)localObject3).cubicTo(6.248601F, 30.628859F, 6.248601F, 30.628859F, 6.248601F, 30.628859F);
      ((Path)localObject3).lineTo(6.248601F, 17.192503F);
      ((Path)localObject3).lineTo(0.9391059F, 17.105562F);
      ((Path)localObject3).lineTo(0.7058098F, 16.876354F);
      ((Path)localObject3).lineTo(0.7058097F, 16.876352F);
      ((Path)localObject3).cubicTo(-0.23527F, 15.950611F, -0.23527F, 14.45091F, 0.70581F, 13.525177F);
      ((Path)localObject3).lineTo(13.794531F, 0.6895053F);
      ((Path)localObject3).lineTo(13.794531F, 0.689505F);
      ((Path)localObject3).cubicTo(14.73585F, -0.2298351F, 16.256115F, -0.2298351F, 17.197432F, 0.6895053F);
      ((Path)localObject3).lineTo(30.294189F, 13.541003F);
      ((Path)localObject3).lineTo(30.294189F, 13.541003F);
      ((Path)localObject3).cubicTo(31.23527F, 14.466745F, 31.23527F, 15.966447F, 30.294189F, 16.892179F);
      ((Path)localObject3).lineTo(30.060894F, 17.121387F);
      ((Path)localObject3).lineTo(25.555866F, 17.192522F);
      ((Path)localObject3).lineTo(25.555866F, 30.628878F);
      ((Path)localObject3).lineTo(25.555866F, 30.628878F);
      ((Path)localObject3).cubicTo(25.555866F, 31.938412F, 24.475346F, 33.0F, 23.142458F, 33.0F);
      ((Path)localObject3).cubicTo(23.142458F, 33.0F, 23.142458F, 33.0F, 23.142458F, 33.0F);
      ((Path)localObject3).lineTo(23.142447F, 33.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(1.687249F, 15.548526F);
      ((Path)localObject3).lineTo(7.857542F, 15.643371F);
      ((Path)localObject3).lineTo(7.857542F, 30.660471F);
      ((Path)localObject3).lineTo(7.857542F, 30.660471F);
      ((Path)localObject3).cubicTo(7.857542F, 31.096981F, 8.217716F, 31.450846F, 8.662012F, 31.450846F);
      ((Path)localObject3).lineTo(23.14245F, 31.450846F);
      ((Path)localObject3).lineTo(23.14245F, 31.450846F);
      ((Path)localObject3).cubicTo(23.586746F, 31.450846F, 23.94692F, 31.096981F, 23.94692F, 30.660471F);
      ((Path)localObject3).lineTo(23.94692F, 15.643371F);
      ((Path)localObject3).lineTo(29.312744F, 15.556429F);
      ((Path)localObject3).lineTo(29.312744F, 15.556429F);
      ((Path)localObject3).cubicTo(29.455614F, 15.255102F, 29.391312F, 14.898149F, 29.151852F, 14.663306F);
      ((Path)localObject3).lineTo(16.103352F, 1.803912F);
      ((Path)localObject3).lineTo(16.103352F, 1.803912F);
      ((Path)localObject3).cubicTo(15.790539F, 1.502666F, 15.289908F, 1.502666F, 14.977095F, 1.803912F);
      ((Path)localObject3).lineTo(1.848152F, 14.65541F);
      ((Path)localObject3).lineTo(1.848152F, 14.65541F);
      ((Path)localObject3).cubicTo(1.608692F, 14.890254F, 1.544388F, 15.247204F, 1.687258F, 15.548532F);
      ((Path)localObject3).lineTo(1.687249F, 15.548526F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_upper
 * JD-Core Version:    0.7.0.1
 */