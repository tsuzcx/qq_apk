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

public class icons_filled_myminiprogram
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject3 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject3).setColor(16777215);
      Object localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(0.0F, 0.0F);
      ((Path)localObject4).lineTo(24.0F, 0.0F);
      ((Path)localObject4).lineTo(24.0F, 24.0F);
      ((Path)localObject4).lineTo(0.0F, 24.0F);
      ((Path)localObject4).lineTo(0.0F, 0.0F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint1, paramVarArgs);
      localObject4 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject3).setColor(16777215);
      ((Paint)localObject4).setColor(-15616);
      ((Paint)localObject4).setStrokeWidth(1.2F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.6F, 7.0F);
      localPath.cubicTo(13.6F, 5.122232F, 15.122231F, 3.6F, 17.0F, 3.6F);
      localPath.lineTo(17.000002F, 3.6F);
      localPath.cubicTo(18.877769F, 3.6F, 20.400002F, 5.122232F, 20.400002F, 7.0F);
      localPath.lineTo(20.400002F, 7.0F);
      localPath.cubicTo(20.400002F, 8.877768F, 18.877769F, 10.4F, 17.000002F, 10.4F);
      localPath.lineTo(17.0F, 10.4F);
      localPath.cubicTo(15.122231F, 10.4F, 13.6F, 8.877768F, 13.6F, 7.0F);
      localPath.lineTo(13.6F, 7.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject3).setColor(-15616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 0.7071068F, 0.7071068F, -7.348426F, -0.7071068F, 0.7071068F, 17.74617F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(17.147308F, 13.74342F);
      ((Path)localObject1).lineTo(18.347309F, 13.74342F);
      ((Path)localObject1).lineTo(18.347309F, 21.74342F);
      ((Path)localObject1).lineTo(17.147308F, 21.74342F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 14.0F);
      ((Path)localObject2).lineTo(19.0F, 14.0F);
      ((Path)localObject2).lineTo(19.0F, 15.2F);
      ((Path)localObject2).lineTo(14.0F, 15.2F);
      ((Path)localObject2).lineTo(14.0F, 14.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 14.0F);
      ((Path)localObject2).lineTo(15.2F, 14.0F);
      ((Path)localObject2).lineTo(15.2F, 19.0F);
      ((Path)localObject2).lineTo(14.0F, 19.0F);
      ((Path)localObject2).lineTo(14.0F, 14.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(16777215);
      ((Paint)localObject2).setColor(-15616);
      ((Paint)localObject2).setStrokeWidth(1.2F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(3.6F, 7.0F);
      ((Path)localObject3).cubicTo(3.6F, 5.122232F, 5.122232F, 3.6F, 7.0F, 3.6F);
      ((Path)localObject3).lineTo(7.0F, 3.6F);
      ((Path)localObject3).cubicTo(8.877768F, 3.6F, 10.4F, 5.122232F, 10.4F, 7.0F);
      ((Path)localObject3).lineTo(10.4F, 7.0F);
      ((Path)localObject3).cubicTo(10.4F, 8.877768F, 8.877768F, 10.4F, 7.0F, 10.4F);
      ((Path)localObject3).lineTo(7.0F, 10.4F);
      ((Path)localObject3).cubicTo(5.122232F, 10.4F, 3.6F, 8.877768F, 3.6F, 7.0F);
      ((Path)localObject3).lineTo(3.6F, 7.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(16777215);
      localPaint2.setColor(-15616);
      localPaint2.setStrokeWidth(1.2F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(3.6F, 17.0F);
      ((Path)localObject1).cubicTo(3.6F, 15.122231F, 5.122232F, 13.6F, 7.0F, 13.6F);
      ((Path)localObject1).lineTo(7.0F, 13.6F);
      ((Path)localObject1).cubicTo(8.877768F, 13.6F, 10.4F, 15.122231F, 10.4F, 17.0F);
      ((Path)localObject1).lineTo(10.4F, 17.000002F);
      ((Path)localObject1).cubicTo(10.4F, 18.877769F, 8.877768F, 20.400002F, 7.0F, 20.400002F);
      ((Path)localObject1).lineTo(7.0F, 20.400002F);
      ((Path)localObject1).cubicTo(5.122232F, 20.400002F, 3.6F, 18.877769F, 3.6F, 17.000002F);
      ((Path)localObject1).lineTo(3.6F, 17.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_myminiprogram
 * JD-Core Version:    0.7.0.1
 */