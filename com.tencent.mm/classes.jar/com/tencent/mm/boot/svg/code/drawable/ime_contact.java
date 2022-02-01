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

public class ime_contact
  extends c
{
  private final int height = 16;
  private final int width = 15;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 15;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -554.0F, 0.0F, 1.0F, -977.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 915.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 534.0F, 0.0F, 1.0F, 62.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.500009F, 7.111099F);
      ((Path)localObject2).lineTo(7.500008F, 7.111099F);
      ((Path)localObject2).cubicTo(9.053308F, 7.111211F, 10.312611F, 5.917395F, 10.312726F, 4.444628F);
      ((Path)localObject2).cubicTo(10.312844F, 2.971868F, 9.053743F, 1.777861F, 7.500437F, 1.777751F);
      ((Path)localObject2).cubicTo(7.500293F, 1.777751F, 7.50015F, 1.777751F, 7.500006F, 1.777751F);
      ((Path)localObject2).lineTo(7.500006F, 1.777751F);
      ((Path)localObject2).cubicTo(5.946707F, 1.777864F, 4.687602F, 2.971863F, 4.687717F, 4.444628F);
      ((Path)localObject2).cubicTo(4.687836F, 5.917229F, 5.946868F, 7.110974F, 7.500006F, 7.111099F);
      ((Path)localObject2).lineTo(7.500009F, 7.111099F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(7.500009F, 8.888881F);
      ((Path)localObject2).lineTo(7.500008F, 8.888881F);
      ((Path)localObject2).cubicTo(4.911181F, 8.888881F, 2.81252F, 6.899036F, 2.81252F, 4.44444F);
      ((Path)localObject2).cubicTo(2.81252F, 1.989845F, 4.911181F, 0.0F, 7.500008F, 0.0F);
      ((Path)localObject2).lineTo(7.500008F, 0.0F);
      ((Path)localObject2).cubicTo(10.088835F, 0.0F, 12.187497F, 1.989845F, 12.187497F, 4.44444F);
      ((Path)localObject2).cubicTo(12.187497F, 6.899036F, 10.088835F, 8.888881F, 7.500008F, 8.888881F);
      ((Path)localObject2).lineTo(7.500009F, 8.888881F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.281262F, 11.555554F);
      ((Path)localObject2).lineTo(3.281262F, 11.555554F);
      ((Path)localObject2).cubicTo(2.504612F, 11.555554F, 1.875014F, 12.152509F, 1.875014F, 12.888888F);
      ((Path)localObject2).lineTo(1.875014F, 14.222222F);
      ((Path)localObject2).lineTo(13.12501F, 14.222222F);
      ((Path)localObject2).lineTo(13.12501F, 12.888888F);
      ((Path)localObject2).lineTo(13.12501F, 12.888888F);
      ((Path)localObject2).cubicTo(13.12501F, 12.152509F, 12.495411F, 11.555554F, 11.718761F, 11.555554F);
      ((Path)localObject2).cubicTo(11.718761F, 11.555554F, 11.718761F, 11.555554F, 11.718761F, 11.555554F);
      ((Path)localObject2).lineTo(3.281269F, 11.555554F);
      ((Path)localObject2).lineTo(3.281262F, 11.555554F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.281262F, 9.777772F);
      ((Path)localObject2).lineTo(11.718755F, 9.777772F);
      ((Path)localObject2).lineTo(11.718755F, 9.777772F);
      ((Path)localObject2).cubicTo(13.530937F, 9.777772F, 15.0F, 11.170666F, 15.0F, 12.888884F);
      ((Path)localObject2).lineTo(15.0F, 14.222218F);
      ((Path)localObject2).lineTo(15.0F, 14.222218F);
      ((Path)localObject2).cubicTo(15.0F, 15.204058F, 14.160536F, 16.0F, 13.124998F, 16.0F);
      ((Path)localObject2).cubicTo(13.124998F, 16.0F, 13.124998F, 16.0F, 13.124998F, 16.0F);
      ((Path)localObject2).lineTo(1.875002F, 16.0F);
      ((Path)localObject2).lineTo(1.875002F, 16.0F);
      ((Path)localObject2).cubicTo(0.8394696F, 16.0F, 0.0F, 15.204061F, 0.0F, 14.222218F);
      ((Path)localObject2).cubicTo(0.0F, 14.222218F, 0.0F, 14.222218F, 0.0F, 14.222218F);
      ((Path)localObject2).lineTo(0.0F, 12.888884F);
      ((Path)localObject2).lineTo(0.0F, 12.888884F);
      ((Path)localObject2).cubicTo(0.0F, 11.170664F, 1.469065F, 9.777772F, 3.281245F, 9.777772F);
      ((Path)localObject2).lineTo(3.281262F, 9.777772F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_contact
 * JD-Core Version:    0.7.0.1
 */