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

public class icons_filled_tool
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint1.setColor(-2565928);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 1.4F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 3.6F);
      localPath.cubicTo(0.0F, 2.716344F, 0.7163444F, 2.0F, 1.6F, 2.0F);
      localPath.lineTo(6.4F, 2.0F);
      localPath.cubicTo(7.283656F, 2.0F, 8.0F, 2.716344F, 8.0F, 3.6F);
      localPath.lineTo(8.0F, 8.4F);
      localPath.cubicTo(8.0F, 9.283655F, 7.283656F, 10.0F, 6.4F, 10.0F);
      localPath.lineTo(1.6F, 10.0F);
      localPath.cubicTo(0.7163444F, 10.0F, 0.0F, 9.283655F, 0.0F, 8.4F);
      localPath.lineTo(0.0F, 3.6F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(9.6F, 13.200001F);
      localPath.cubicTo(9.6F, 12.316345F, 10.316345F, 11.6F, 11.200001F, 11.6F);
      localPath.lineTo(16.0F, 11.6F);
      localPath.cubicTo(16.883656F, 11.6F, 17.6F, 12.316345F, 17.6F, 13.200001F);
      localPath.lineTo(17.6F, 18.0F);
      localPath.cubicTo(17.6F, 18.883656F, 16.883656F, 19.6F, 16.0F, 19.6F);
      localPath.lineTo(11.200001F, 19.6F);
      localPath.cubicTo(10.316345F, 19.6F, 9.6F, 18.883656F, 9.6F, 18.0F);
      localPath.lineTo(9.6F, 13.200001F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 13.200001F);
      localPath.cubicTo(0.0F, 12.316345F, 0.7163444F, 11.6F, 1.6F, 11.6F);
      localPath.lineTo(6.4F, 11.6F);
      localPath.cubicTo(7.283656F, 11.6F, 8.0F, 12.316345F, 8.0F, 13.200001F);
      localPath.lineTo(8.0F, 18.0F);
      localPath.cubicTo(8.0F, 18.883656F, 7.283656F, 19.6F, 6.4F, 19.6F);
      localPath.lineTo(1.6F, 19.6F);
      localPath.cubicTo(0.7163444F, 19.6F, 0.0F, 18.883656F, 0.0F, 18.0F);
      localPath.lineTo(0.0F, 13.200001F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 8.138711F, 0.7071068F, 0.7071068F, -7.989033F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.612972F, 2.329777F);
      ((Path)localObject).lineTo(15.812972F, 2.329777F);
      ((Path)localObject).cubicTo(16.58617F, 2.329777F, 17.212973F, 2.956579F, 17.212973F, 3.729777F);
      ((Path)localObject).lineTo(17.212973F, 7.929777F);
      ((Path)localObject).cubicTo(17.212973F, 8.702976F, 16.58617F, 9.329778F, 15.812972F, 9.329778F);
      ((Path)localObject).lineTo(11.612972F, 9.329778F);
      ((Path)localObject).cubicTo(10.839773F, 9.329778F, 10.212972F, 8.702976F, 10.212972F, 7.929777F);
      ((Path)localObject).lineTo(10.212972F, 3.729777F);
      ((Path)localObject).cubicTo(10.212972F, 2.956579F, 10.839773F, 2.329777F, 11.612972F, 2.329777F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_tool
 * JD-Core Version:    0.7.0.1
 */