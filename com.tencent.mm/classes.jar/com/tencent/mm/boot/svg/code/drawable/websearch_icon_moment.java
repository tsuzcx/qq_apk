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

public class websearch_icon_moment
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-5066062);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -329.0F, 0.0F, 1.0F, -603.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 262.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 16.5F, 0.0F, 1.0F, 1.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(7.5F, 14.1F);
      localPath.cubicTo(11.14508F, 14.1F, 14.1F, 11.14508F, 14.1F, 7.5F);
      localPath.cubicTo(14.1F, 3.854921F, 11.14508F, 0.9F, 7.5F, 0.9F);
      localPath.cubicTo(3.854921F, 0.9F, 0.9F, 3.854921F, 0.9F, 7.5F);
      localPath.cubicTo(0.9F, 11.14508F, 3.854921F, 14.1F, 7.5F, 14.1F);
      localPath.close();
      localPath.moveTo(7.5F, 15.0F);
      localPath.cubicTo(3.357864F, 15.0F, 0.0F, 11.642136F, 0.0F, 7.5F);
      localPath.cubicTo(0.0F, 3.357864F, 3.357864F, 0.0F, 7.5F, 0.0F);
      localPath.cubicTo(11.642136F, 0.0F, 15.0F, 3.357864F, 15.0F, 7.5F);
      localPath.cubicTo(15.0F, 11.642136F, 11.642136F, 15.0F, 7.5F, 15.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(7.500001F, 9.750002F);
      localPath.cubicTo(8.742641F, 9.750002F, 9.750001F, 8.742642F, 9.750001F, 7.500002F);
      localPath.cubicTo(9.750001F, 6.257361F, 8.742641F, 5.250002F, 7.500001F, 5.250002F);
      localPath.cubicTo(6.25736F, 5.250002F, 5.250001F, 6.257361F, 5.250001F, 7.500002F);
      localPath.cubicTo(5.250001F, 8.742642F, 6.25736F, 9.750002F, 7.500001F, 9.750002F);
      localPath.close();
      localPath.moveTo(7.500001F, 10.650002F);
      localPath.cubicTo(5.760304F, 10.650002F, 4.350001F, 9.239699F, 4.350001F, 7.500002F);
      localPath.cubicTo(4.350001F, 5.760305F, 5.760304F, 4.350002F, 7.500001F, 4.350002F);
      localPath.cubicTo(9.239698F, 4.350002F, 10.650001F, 5.760305F, 10.650001F, 7.500002F);
      localPath.cubicTo(10.650001F, 9.239699F, 9.239698F, 10.650002F, 7.500001F, 10.650002F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.35F, 0.75F);
      localPath.lineTo(5.25F, 0.75F);
      localPath.lineTo(5.25F, 7.5F);
      localPath.lineTo(4.35F, 7.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(9.75F, 7.5F);
      localPath.lineTo(10.65F, 7.5F);
      localPath.lineTo(10.65F, 14.25F);
      localPath.lineTo(9.75F, 14.25F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(7.5F, 4.350002F);
      localPath.lineTo(14.25F, 4.350002F);
      localPath.lineTo(14.25F, 5.350002F);
      localPath.lineTo(7.5F, 5.350002F);
      localPath.lineTo(7.5F, 4.350002F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.75F, 9.75F);
      localPath.lineTo(7.5F, 9.75F);
      localPath.lineTo(7.5F, 10.75F);
      localPath.lineTo(0.75F, 10.75F);
      localPath.lineTo(0.75F, 9.75F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 4.602297F, 0.7071068F, 0.7071068F, -4.702275F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(7.527297F, -0.1706737F);
      localPath.lineTo(8.427297F, -0.1706737F);
      localPath.lineTo(8.427297F, 6.579326F);
      localPath.lineTo(7.527297F, 6.579326F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 10.397703F, 0.7071068F, 0.7071068F, -1.510928F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.572703F, 8.420673F);
      localPath.lineTo(7.472703F, 8.420673F);
      localPath.lineTo(7.472703F, 15.170673F);
      localPath.lineTo(6.572703F, 15.170673F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 9.095675F, 0.7071068F, 0.7071068F, -6.004304F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(8.420672F, 7.527299F);
      localPath.lineTo(15.170672F, 7.527299F);
      localPath.lineTo(15.170672F, 8.427299F);
      localPath.lineTo(8.420672F, 8.427299F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 5.904326F, 0.7071068F, 0.7071068F, -0.2088981F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(-0.1706737F, 6.572703F);
      ((Path)localObject).lineTo(6.579326F, 6.572703F);
      ((Path)localObject).lineTo(6.579326F, 7.472703F);
      ((Path)localObject).lineTo(-0.1706737F, 7.472703F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.websearch_icon_moment
 * JD-Core Version:    0.7.0.1
 */