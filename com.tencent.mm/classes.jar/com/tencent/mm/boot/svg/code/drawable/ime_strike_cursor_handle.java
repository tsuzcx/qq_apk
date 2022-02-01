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

public class ime_strike_cursor_handle
  extends c
{
  private final int height = 40;
  private final int width = 84;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 84;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -218.0F, 0.0F, 1.0F, -914.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 218.0F, 0.0F, 1.0F, 914.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0E-006F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Paint localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-12799119);
      Object localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.096848F, -5.252941E-013F);
      ((Path)localObject2).lineTo(66.110802F, -5.252941E-013F);
      ((Path)localObject2).lineTo(66.110802F, -5.252941E-013F);
      ((Path)localObject2).cubicTo(66.941673F, -5.252941E-013F, 67.715096F, 0.3172743F, 68.16127F, 0.8418213F);
      ((Path)localObject2).lineTo(83.619934F, 19.023636F);
      ((Path)localObject2).lineTo(83.619934F, 19.023636F);
      ((Path)localObject2).cubicTo(83.875542F, 19.324146F, 84.002205F, 19.666821F, 83.999969F, 20.009117F);
      ((Path)localObject2).cubicTo(83.997658F, 20.345335F, 83.871002F, 20.681187F, 83.619934F, 20.97636F);
      ((Path)localObject2).lineTo(68.16127F, 39.158173F);
      ((Path)localObject2).lineTo(68.16127F, 39.158173F);
      ((Path)localObject2).cubicTo(67.715096F, 39.682724F, 66.941673F, 40.0F, 66.110802F, 40.0F);
      ((Path)localObject2).lineTo(20.096848F, 40.0F);
      ((Path)localObject2).lineTo(20.096848F, 40.0F);
      ((Path)localObject2).cubicTo(19.319271F, 40.0F, 18.588629F, 39.7216F, 18.131413F, 39.2509F);
      ((Path)localObject2).lineTo(0.464364F, 21.069086F);
      ((Path)localObject2).lineTo(0.4643643F, 21.069086F);
      ((Path)localObject2).cubicTo(-0.1547881F, 20.431673F, -0.1547881F, 19.568323F, 0.4643641F, 18.930904F);
      ((Path)localObject2).lineTo(18.12896F, 0.7490912F);
      ((Path)localObject2).lineTo(18.12896F, 0.7490913F);
      ((Path)localObject2).cubicTo(18.586676F, 0.2778731F, 19.318388F, -0.0006616965F, 20.096821F, -5.252941E-013F);
      ((Path)localObject2).lineTo(20.096848F, -5.252941E-013F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-12799119);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(41.263145F, 9.999998F);
      ((Path)localObject2).lineTo(41.263145F, 29.999992F);
      ((Path)localObject2).lineTo(44.21051F, 29.999992F);
      ((Path)localObject2).lineTo(44.21051F, 9.999998F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-12799119);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(26.526306F, 12.85714F);
      ((Path)localObject2).lineTo(26.526306F, 27.142851F);
      ((Path)localObject2).lineTo(29.473675F, 27.142851F);
      ((Path)localObject2).lineTo(29.473675F, 12.85714F);
      ((Path)localObject2).lineTo(26.526306F, 12.85714F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-12799119);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(55.999981F, 12.85714F);
      ((Path)localObject2).lineTo(55.999981F, 27.142851F);
      ((Path)localObject2).lineTo(58.94735F, 27.142851F);
      ((Path)localObject2).lineTo(58.94735F, 12.85714F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-12799119);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.347826F, 7.142856F);
      ((Path)localObject2).lineTo(63.304344F, 7.142856F);
      ((Path)localObject2).lineTo(63.304344F, 35.714283F);
      ((Path)localObject2).lineTo(24.347826F, 35.714283F);
      ((Path)localObject2).lineTo(24.347826F, 7.142856F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint3.setColor(-1);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 6.123234E-017F, -1.0F, 76.211182F, 1.0F, 6.123234E-017F, -33.354038F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(54.782608F, 19.650713F);
      localPath.lineTo(59.139278F, 23.363354F);
      localPath.lineTo(50.425938F, 23.363354F);
      localPath.lineTo(54.782608F, 19.650713F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint3.setColor(-1);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -6.123234E-017F, 1.0F, 9.006214F, 1.0F, 6.123234E-017F, -9.006214F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(30.434782F, 19.650713F);
      ((Path)localObject1).lineTo(34.791454F, 23.363354F);
      ((Path)localObject1).lineTo(26.078112F, 23.363354F);
      ((Path)localObject1).lineTo(30.434782F, 19.650713F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint3);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-1);
      localPaint2.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(41.891304F, 10.499999F);
      ((Path)localObject1).lineTo(43.326088F, 10.499999F);
      ((Path)localObject1).lineTo(43.326088F, 30.92857F);
      ((Path)localObject1).lineTo(41.891304F, 30.92857F);
      ((Path)localObject1).lineTo(41.891304F, 10.499999F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_strike_cursor_handle
 * JD-Core Version:    0.7.0.1
 */