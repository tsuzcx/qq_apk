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

public class default_app_brand_service_msg
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localPaint2.setColor(-16268960);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(144.0F, 0.0F);
      localPath.lineTo(144.0F, 144.0F);
      localPath.lineTo(0.0F, 144.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 28.0F, 0.0F, 1.0F, 37.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(51.872231F, -4.296608E-013F);
      ((Path)localObject2).cubicTo(53.655266F, -4.299884E-013F, 54.301838F, 0.1856512F, 54.95369F, 0.534265F);
      ((Path)localObject2).cubicTo(55.605545F, 0.8828796F, 56.117119F, 1.394457F, 56.465736F, 2.046309F);
      ((Path)localObject2).cubicTo(56.81435F, 2.69816F, 57.0F, 3.344733F, 57.0F, 5.12777F);
      ((Path)localObject2).lineTo(57.0F, 38.872231F);
      ((Path)localObject2).cubicTo(57.0F, 40.655266F, 56.81435F, 41.301838F, 56.465736F, 41.95369F);
      ((Path)localObject2).cubicTo(56.117119F, 42.605545F, 55.605545F, 43.117119F, 54.95369F, 43.465736F);
      ((Path)localObject2).cubicTo(54.301838F, 43.81435F, 53.655266F, 44.0F, 51.872231F, 44.0F);
      ((Path)localObject2).lineTo(23.799F, 44.0F);
      ((Path)localObject2).lineTo(14.804203F, 51.496498F);
      ((Path)localObject2).cubicTo(14.337499F, 51.885418F, 13.643877F, 51.822361F, 13.254956F, 51.355656F);
      ((Path)localObject2).cubicTo(13.090218F, 51.15797F, 13.0F, 50.908783F, 13.0F, 50.651455F);
      ((Path)localObject2).lineTo(12.999F, 44.0F);
      ((Path)localObject2).lineTo(5.12777F, 44.0F);
      ((Path)localObject2).cubicTo(3.344733F, 44.0F, 2.69816F, 43.81435F, 2.046309F, 43.465736F);
      ((Path)localObject2).cubicTo(1.394457F, 43.117119F, 0.8828796F, 42.605545F, 0.534265F, 41.95369F);
      ((Path)localObject2).cubicTo(0.1856512F, 41.301838F, 8.715268E-017F, 40.655266F, -1.312064E-016F, 38.872231F);
      ((Path)localObject2).lineTo(1.450176E-016F, 5.12777F);
      ((Path)localObject2).cubicTo(-7.334147E-017F, 3.344733F, 0.1856512F, 2.69816F, 0.534265F, 2.046309F);
      ((Path)localObject2).cubicTo(0.8828796F, 1.394457F, 1.394457F, 0.8828796F, 2.046309F, 0.534265F);
      ((Path)localObject2).cubicTo(2.69816F, 0.1856512F, 3.344733F, -4.297476E-013F, 5.12777F, -4.300752E-013F);
      ((Path)localObject2).lineTo(51.872231F, -4.296608E-013F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(82.872231F, 20.9F);
      ((Path)localObject2).cubicTo(84.655266F, 20.9F, 85.301842F, 21.085651F, 85.95369F, 21.434265F);
      ((Path)localObject2).cubicTo(86.605545F, 21.782879F, 87.117119F, 22.294456F, 87.465736F, 22.946308F);
      ((Path)localObject2).cubicTo(87.814346F, 23.59816F, 88.0F, 24.244734F, 88.0F, 26.027771F);
      ((Path)localObject2).lineTo(88.0F, 26.027771F);
      ((Path)localObject2).lineTo(88.0F, 56.772228F);
      ((Path)localObject2).cubicTo(88.0F, 58.555267F, 87.814346F, 59.201839F, 87.465736F, 59.853691F);
      ((Path)localObject2).cubicTo(87.117119F, 60.505543F, 86.605545F, 61.01712F, 85.95369F, 61.365734F);
      ((Path)localObject2).cubicTo(85.301842F, 61.714348F, 84.655266F, 61.900002F, 82.872231F, 61.900002F);
      ((Path)localObject2).lineTo(82.872231F, 61.900002F);
      ((Path)localObject2).lineTo(76.199997F, 61.900002F);
      ((Path)localObject2).lineTo(76.199997F, 68.651451F);
      ((Path)localObject2).cubicTo(76.199997F, 68.908783F, 76.109779F, 69.157974F, 75.945045F, 69.355659F);
      ((Path)localObject2).cubicTo(75.556122F, 69.822365F, 74.862503F, 69.885422F, 74.395798F, 69.496498F);
      ((Path)localObject2).lineTo(74.395798F, 69.496498F);
      ((Path)localObject2).lineTo(65.279999F, 61.900002F);
      ((Path)localObject2).lineTo(40.127769F, 61.900002F);
      ((Path)localObject2).cubicTo(38.344734F, 61.900002F, 37.698162F, 61.714348F, 37.04631F, 61.365734F);
      ((Path)localObject2).cubicTo(36.394455F, 61.01712F, 35.882881F, 60.505543F, 35.534264F, 59.853691F);
      ((Path)localObject2).cubicTo(35.18565F, 59.201839F, 35.0F, 58.555267F, 35.0F, 56.772228F);
      ((Path)localObject2).lineTo(35.0F, 56.772228F);
      ((Path)localObject2).lineTo(35.0F, 47.0F);
      ((Path)localObject2).lineTo(57.0F, 47.0F);
      ((Path)localObject2).cubicTo(58.597679F, 47.0F, 59.90366F, 45.75108F, 59.994907F, 44.176273F);
      ((Path)localObject2).lineTo(60.0F, 44.0F);
      ((Path)localObject2).lineTo(60.0F, 20.9F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_app_brand_service_msg
 * JD-Core Version:    0.7.0.1
 */