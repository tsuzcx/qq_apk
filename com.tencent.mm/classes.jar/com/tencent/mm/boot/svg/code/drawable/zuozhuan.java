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

public class zuozhuan
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-855638017);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 0.0F, 44.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(35.968712F, 3.625293F);
      ((Path)localObject2).cubicTo(43.908043F, 9.608009F, 45.494179F, 20.894049F, 39.511459F, 28.833387F);
      ((Path)localObject2).cubicTo(33.595215F, 36.684509F, 22.492849F, 38.322857F, 14.569242F, 32.572792F);
      ((Path)localObject2).lineTo(14.30337F, 32.376171F);
      ((Path)localObject2).lineTo(17.914261F, 27.584358F);
      ((Path)localObject2).cubicTo(23.207146F, 31.572834F, 30.731163F, 30.515392F, 34.719646F, 25.222498F);
      ((Path)localObject2).cubicTo(38.70813F, 19.929602F, 37.650707F, 12.405581F, 32.357819F, 8.417106F);
      ((Path)localObject2).cubicTo(27.06493F, 4.428627F, 19.540894F, 5.486061F, 15.520621F, 10.820387F);
      ((Path)localObject2).cubicTo(14.559699F, 12.050423F, 13.854734F, 13.409966F, 13.406418F, 14.915149F);
      ((Path)localObject2).lineTo(20.786894F, 15.609411F);
      ((Path)localObject2).lineTo(9.16957F, 26.340914F);
      ((Path)localObject2).lineTo(0.2919844F, 13.682716F);
      ((Path)localObject2).lineTo(7.352542F, 14.346498F);
      ((Path)localObject2).cubicTo(7.930113F, 11.843923F, 8.976221F, 9.561095F, 10.486247F, 7.52814F);
      ((Path)localObject2).lineTo(10.760601F, 7.168062F);
      ((Path)localObject2).cubicTo(16.74332F, -0.7712743F, 28.029375F, -2.357426F, 35.968712F, 3.625293F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.zuozhuan
 * JD-Core Version:    0.7.0.1
 */