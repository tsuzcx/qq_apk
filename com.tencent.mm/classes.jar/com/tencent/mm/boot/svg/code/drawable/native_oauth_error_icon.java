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

public class native_oauth_error_icon
  extends c
{
  private final int height = 279;
  private final int width = 279;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 279;
      return 279;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
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
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -17.0F, 0.0F, 1.0F, -250.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 250.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-15683841);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(279.0F, 141.22223F);
      localPath.cubicTo(279.0F, 62.454666F, 216.54533F, 0.0F, 137.77777F, 0.0F);
      localPath.cubicTo(62.454666F, 0.0F, 0.0F, 62.454666F, 0.0F, 141.22223F);
      localPath.cubicTo(0.0F, 216.54533F, 62.454666F, 279.0F, 137.77777F, 279.0F);
      localPath.cubicTo(216.54533F, 279.0F, 279.0F, 216.54533F, 279.0F, 141.22223F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 279.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(134.99942F, 70.5F);
      ((Path)localObject).lineTo(144.00058F, 70.5F);
      ((Path)localObject).cubicTo(145.65565F, 70.5F, 147.03334F, 71.843925F, 147.07448F, 73.501747F);
      ((Path)localObject).lineTo(149.42552F, 168.25435F);
      ((Path)localObject).cubicTo(149.46655F, 169.90797F, 148.15945F, 171.2561F, 146.5058F, 171.2561F);
      ((Path)localObject).lineTo(132.4942F, 171.2561F);
      ((Path)localObject).cubicTo(130.84331F, 171.2561F, 129.53334F, 169.91217F, 129.57448F, 168.25435F);
      ((Path)localObject).lineTo(131.92552F, 73.501747F);
      ((Path)localObject).cubicTo(131.96655F, 71.848129F, 133.34288F, 70.5F, 134.99942F, 70.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(139.5F, 208.5F);
      ((Path)localObject).cubicTo(132.87259F, 208.5F, 127.5F, 203.12741F, 127.5F, 196.5F);
      ((Path)localObject).cubicTo(127.5F, 189.87259F, 132.87259F, 184.5F, 139.5F, 184.5F);
      ((Path)localObject).cubicTo(146.12741F, 184.5F, 151.5F, 189.87259F, 151.5F, 196.5F);
      ((Path)localObject).cubicTo(151.5F, 203.12741F, 146.12741F, 208.5F, 139.5F, 208.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.native_oauth_error_icon
 * JD-Core Version:    0.7.0.1
 */