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

public class icons_outlined_mini_window
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
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(19.5F, 3.0F);
      localPath.cubicTo(20.052284F, 3.0F, 20.5F, 3.447715F, 20.5F, 4.0F);
      localPath.lineTo(20.5F, 12.0F);
      localPath.lineTo(19.299999F, 12.0F);
      localPath.lineTo(19.299999F, 4.2F);
      localPath.lineTo(3.2F, 4.2F);
      localPath.lineTo(3.2F, 17.799999F);
      localPath.lineTo(12.0F, 17.799999F);
      localPath.lineTo(12.0F, 19.0F);
      localPath.lineTo(3.0F, 19.0F);
      localPath.cubicTo(2.447715F, 19.0F, 2.0F, 18.552284F, 2.0F, 18.0F);
      localPath.lineTo(2.0F, 4.0F);
      localPath.cubicTo(2.0F, 3.447715F, 2.447715F, 3.0F, 3.0F, 3.0F);
      localPath.lineTo(19.5F, 3.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.0F, 12.8F);
      localPath.cubicTo(21.883656F, 12.8F, 22.6F, 13.516344F, 22.6F, 14.4F);
      localPath.lineTo(22.6F, 14.4F);
      localPath.lineTo(22.6F, 20.0F);
      localPath.cubicTo(22.6F, 20.883656F, 21.883656F, 21.6F, 21.0F, 21.6F);
      localPath.lineTo(21.0F, 21.6F);
      localPath.lineTo(14.4F, 21.6F);
      localPath.cubicTo(13.516344F, 21.6F, 12.8F, 20.883656F, 12.8F, 20.0F);
      localPath.lineTo(12.8F, 20.0F);
      localPath.lineTo(12.8F, 14.4F);
      localPath.cubicTo(12.8F, 13.516344F, 13.516344F, 12.8F, 14.4F, 12.8F);
      localPath.lineTo(14.4F, 12.8F);
      localPath.close();
      localPath.moveTo(21.0F, 14.0F);
      localPath.lineTo(14.4F, 14.0F);
      localPath.cubicTo(14.179086F, 14.0F, 14.0F, 14.179086F, 14.0F, 14.4F);
      localPath.lineTo(14.0F, 14.4F);
      localPath.lineTo(14.0F, 20.0F);
      localPath.cubicTo(14.0F, 20.220915F, 14.179086F, 20.4F, 14.4F, 20.4F);
      localPath.lineTo(14.4F, 20.4F);
      localPath.lineTo(21.0F, 20.4F);
      localPath.cubicTo(21.220915F, 20.4F, 21.4F, 20.220915F, 21.4F, 20.0F);
      localPath.lineTo(21.4F, 20.0F);
      localPath.lineTo(21.4F, 14.4F);
      localPath.cubicTo(21.4F, 14.179086F, 21.220915F, 14.0F, 21.0F, 14.0F);
      localPath.lineTo(21.0F, 14.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.1F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.4008622F, 6.5F);
      ((Path)localObject2).lineTo(0.4008622F, 5.3F);
      ((Path)localObject2).lineTo(4.385F, 5.299356F);
      ((Path)localObject2).lineTo(0.32F, 1.233884F);
      ((Path)localObject2).lineTo(1.168528F, 0.3853554F);
      ((Path)localObject2).lineTo(5.2F, 4.416355F);
      ((Path)localObject2).lineTo(5.200862F, 0.5F);
      ((Path)localObject2).lineTo(6.400862F, 0.5F);
      ((Path)localObject2).lineTo(6.4F, 5.616355F);
      ((Path)localObject2).lineTo(6.401118F, 5.617946F);
      ((Path)localObject2).lineTo(6.4F, 5.618355F);
      ((Path)localObject2).lineTo(6.400862F, 6.0F);
      ((Path)localObject2).cubicTo(6.400862F, 6.24546F, 6.223987F, 6.449608F, 5.990738F, 6.491944F);
      ((Path)localObject2).lineTo(5.900862F, 6.5F);
      ((Path)localObject2).lineTo(5.900862F, 6.5F);
      ((Path)localObject2).lineTo(0.4008622F, 6.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(5.500862F, 12.5F);
      ((Path)localObject1).lineTo(5.500862F, 11.3F);
      ((Path)localObject1).lineTo(9.485F, 11.299356F);
      ((Path)localObject1).lineTo(5.42F, 7.233883F);
      ((Path)localObject1).lineTo(6.268528F, 6.385356F);
      ((Path)localObject1).lineTo(10.3F, 10.416355F);
      ((Path)localObject1).lineTo(10.300862F, 6.5F);
      ((Path)localObject1).lineTo(11.500862F, 6.5F);
      ((Path)localObject1).lineTo(11.5F, 11.616355F);
      ((Path)localObject1).lineTo(11.501119F, 11.617946F);
      ((Path)localObject1).lineTo(11.5F, 11.618356F);
      ((Path)localObject1).lineTo(11.500862F, 12.0F);
      ((Path)localObject1).cubicTo(11.500862F, 12.24546F, 11.323987F, 12.449609F, 11.090737F, 12.491944F);
      ((Path)localObject1).lineTo(11.000862F, 12.5F);
      ((Path)localObject1).lineTo(11.000862F, 12.5F);
      ((Path)localObject1).lineTo(5.500862F, 12.5F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_mini_window
 * JD-Core Version:    0.7.0.1
 */