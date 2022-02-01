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

public class icons_filled_black
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.0F, 1.666667F);
      localPath.cubicTo(14.602373F, 1.666667F, 18.333334F, 5.397627F, 18.333334F, 10.0F);
      localPath.cubicTo(18.333334F, 14.602373F, 14.602373F, 18.333334F, 10.0F, 18.333334F);
      localPath.cubicTo(5.397627F, 18.333334F, 1.666667F, 14.602373F, 1.666667F, 10.0F);
      localPath.cubicTo(1.666667F, 5.397627F, 5.397627F, 1.666667F, 10.0F, 1.666667F);
      localPath.close();
      localPath.moveTo(10.0F, 3.333333F);
      localPath.cubicTo(6.318102F, 3.333333F, 3.333333F, 6.318102F, 3.333333F, 10.0F);
      localPath.cubicTo(3.333333F, 13.681898F, 6.318102F, 16.666666F, 10.0F, 16.666666F);
      localPath.cubicTo(13.681898F, 16.666666F, 16.666666F, 13.681898F, 16.666666F, 10.0F);
      localPath.cubicTo(16.666666F, 6.318102F, 13.681898F, 3.333333F, 10.0F, 3.333333F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -0.7071068F, 0.7071068F, 10.0F, 0.7071068F, 0.7071068F, -4.142136F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.004842F, 2.207901F);
      ((Path)localObject).lineTo(11.0F, 2.211273F);
      ((Path)localObject).lineTo(10.995158F, 17.792099F);
      ((Path)localObject).lineTo(9.0F, 17.788727F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_black
 * JD-Core Version:    0.7.0.1
 */