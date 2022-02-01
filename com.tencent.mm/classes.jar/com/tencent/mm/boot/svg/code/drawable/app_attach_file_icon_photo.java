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

public class app_attach_file_icon_photo
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(90.0F, 116.0F);
      ((Path)localObject3).cubicTo(90.0F, 118.20914F, 88.209137F, 120.0F, 86.0F, 120.0F);
      ((Path)localObject3).lineTo(4.0F, 120.0F);
      ((Path)localObject3).cubicTo(1.790861F, 120.0F, 2.569541E-013F, 118.20914F, 2.557954E-013F, 116.0F);
      ((Path)localObject3).lineTo(2.557954E-013F, 4.0F);
      ((Path)localObject3).cubicTo(2.555249E-013F, 1.790861F, 1.790861F, 1.293991E-015F, 4.0F, 0.0F);
      ((Path)localObject3).lineTo(60.0F, 0.0F);
      ((Path)localObject3).lineTo(90.0F, 30.0F);
      ((Path)localObject3).lineTo(90.0F, 116.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(201326592);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(90.0F, 116.0F);
      ((Path)localObject3).cubicTo(90.0F, 118.20914F, 88.209137F, 120.0F, 86.0F, 120.0F);
      ((Path)localObject3).lineTo(4.0F, 120.0F);
      ((Path)localObject3).cubicTo(1.790861F, 120.0F, 2.569541E-013F, 118.20914F, 2.557954E-013F, 116.0F);
      ((Path)localObject3).lineTo(2.557954E-013F, 4.0F);
      ((Path)localObject3).cubicTo(2.555249E-013F, 1.790861F, 1.790861F, 1.293991E-015F, 4.0F, 0.0F);
      ((Path)localObject3).lineTo(60.0F, 0.0F);
      ((Path)localObject3).lineTo(90.0F, 30.0F);
      ((Path)localObject3).lineTo(90.0F, 116.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(1275068416);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(65.099998F, 56.700001F);
      ((Path)localObject3).cubicTo(66.425484F, 56.700001F, 67.5F, 57.774517F, 67.5F, 59.099998F);
      ((Path)localObject3).lineTo(67.5F, 90.300003F);
      ((Path)localObject3).cubicTo(67.5F, 91.625481F, 66.425484F, 92.699997F, 65.099998F, 92.699997F);
      ((Path)localObject3).lineTo(24.9F, 92.699997F);
      ((Path)localObject3).cubicTo(23.574516F, 92.699997F, 22.5F, 91.625481F, 22.5F, 90.300003F);
      ((Path)localObject3).lineTo(22.5F, 59.099998F);
      ((Path)localObject3).cubicTo(22.5F, 57.774517F, 23.574516F, 56.700001F, 24.9F, 56.700001F);
      ((Path)localObject3).lineTo(65.099998F, 56.700001F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(37.757999F, 73.146004F);
      ((Path)localObject3).lineTo(26.099001F, 82.573997F);
      ((Path)localObject3).lineTo(26.1F, 89.099998F);
      ((Path)localObject3).lineTo(63.900002F, 89.099998F);
      ((Path)localObject3).lineTo(63.900002F, 83.227997F);
      ((Path)localObject3).lineTo(57.0F, 77.015999F);
      ((Path)localObject3).lineTo(52.279301F, 81.265877F);
      ((Path)localObject3).lineTo(55.181744F, 83.842255F);
      ((Path)localObject3).lineTo(49.79924F, 83.849998F);
      ((Path)localObject3).lineTo(37.757999F, 73.146004F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(63.900002F, 60.299999F);
      ((Path)localObject3).lineTo(26.1F, 60.299999F);
      ((Path)localObject3).lineTo(26.099001F, 77.945F);
      ((Path)localObject3).lineTo(35.865932F, 70.048988F);
      ((Path)localObject3).cubicTo(37.006538F, 69.126801F, 38.646725F, 69.164574F, 39.743664F, 70.138298F);
      ((Path)localObject3).lineTo(50.021301F, 79.261879F);
      ((Path)localObject3).lineTo(55.394485F, 74.426918F);
      ((Path)localObject3).cubicTo(56.307217F, 73.605461F, 57.692783F, 73.605461F, 58.605515F, 74.426918F);
      ((Path)localObject3).lineTo(63.900002F, 79.192001F);
      ((Path)localObject3).lineTo(63.900002F, 60.299999F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(90.0F, 30.0F);
      ((Path)localObject1).lineTo(64.0F, 30.0F);
      ((Path)localObject1).cubicTo(61.790859F, 30.0F, 60.0F, 28.209139F, 60.0F, 26.0F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(90.0F, 30.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 25, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_photo
 * JD-Core Version:    0.7.0.1
 */