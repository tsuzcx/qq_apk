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

public class connect_mac_lock
  extends c
{
  private final int height = 104;
  private final int width = 104;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 104;
      return 104;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject4 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject4).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(0.8F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.4F, 16.4F);
      localPath.cubicTo(0.4F, 14.190861F, 2.190861F, 12.4F, 4.4F, 12.4F);
      localPath.lineTo(99.599998F, 12.4F);
      localPath.cubicTo(101.80914F, 12.4F, 103.6F, 14.190861F, 103.6F, 16.4F);
      localPath.lineTo(103.6F, 75.599998F);
      localPath.cubicTo(103.6F, 77.809135F, 101.80914F, 79.599998F, 99.599998F, 79.599998F);
      localPath.lineTo(4.4F, 79.599998F);
      localPath.cubicTo(2.190861F, 79.599998F, 0.4F, 77.809135F, 0.4F, 75.599998F);
      localPath.lineTo(0.4F, 16.4F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject4).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(0.8F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(60.0F, 79.5F);
      localPath.lineTo(60.677261F, 85.256729F);
      localPath.cubicTo(60.871513F, 86.90786F, 62.066837F, 88.266708F, 63.679722F, 88.66993F);
      localPath.lineTo(68.029854F, 89.757462F);
      localPath.cubicTo(68.600014F, 89.900002F, 69.0F, 90.412292F, 69.0F, 91.0F);
      localPath.cubicTo(69.0F, 91.552284F, 68.552284F, 92.0F, 68.0F, 92.0F);
      localPath.lineTo(36.0F, 92.0F);
      localPath.cubicTo(35.447716F, 92.0F, 35.0F, 91.552284F, 35.0F, 91.0F);
      localPath.cubicTo(35.0F, 90.412292F, 35.399982F, 89.900002F, 35.970142F, 89.757462F);
      localPath.lineTo(40.320278F, 88.66993F);
      localPath.cubicTo(41.933163F, 88.266708F, 43.128487F, 86.90786F, 43.322739F, 85.256729F);
      localPath.lineTo(44.0F, 79.5F);
      localPath.lineTo(44.0F, 79.5F);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject4).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(0.8F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 66.5F);
      localPath.lineTo(104.0F, 66.5F);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 42.0F, 0.0F, 1.0F, 33.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(0.0F, 0.0F);
      ((Path)localObject4).lineTo(20.0F, 0.0F);
      ((Path)localObject4).lineTo(20.0F, 20.0F);
      ((Path)localObject4).lineTo(0.0F, 20.0F);
      ((Path)localObject4).lineTo(0.0F, 0.0F);
      ((Path)localObject4).close();
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 3.5F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(0.8F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.4F, 6.9F);
      ((Path)localObject3).cubicTo(0.4F, 6.347715F, 0.847715F, 5.9F, 1.4F, 5.9F);
      ((Path)localObject3).lineTo(11.599999F, 5.9F);
      ((Path)localObject3).cubicTo(12.152285F, 5.9F, 12.599999F, 6.347715F, 12.599999F, 6.9F);
      ((Path)localObject3).lineTo(12.599999F, 15.1F);
      ((Path)localObject3).cubicTo(12.599999F, 15.652286F, 12.152285F, 16.1F, 11.599999F, 16.1F);
      ((Path)localObject3).lineTo(1.4F, 16.1F);
      ((Path)localObject3).cubicTo(0.847715F, 16.1F, 0.4F, 15.652286F, 0.4F, 15.1F);
      ((Path)localObject3).lineTo(0.4F, 6.9F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(0.8F);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.5F, 6.0F);
      ((Path)localObject2).lineTo(3.5F, 3.23134F);
      ((Path)localObject2).cubicTo(3.5F, 1.44672F, 4.843146F, 0.0F, 6.5F, 0.0F);
      ((Path)localObject2).cubicTo(8.156855F, 0.0F, 9.5F, 1.44672F, 9.5F, 3.23134F);
      ((Path)localObject2).lineTo(9.5F, 6.0F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(6.0F, 11.229322F);
      ((Path)localObject1).cubicTo(5.558524F, 11.036433F, 5.25F, 10.595913F, 5.25F, 10.083333F);
      ((Path)localObject1).cubicTo(5.25F, 9.392978F, 5.809644F, 8.833333F, 6.5F, 8.833333F);
      ((Path)localObject1).cubicTo(7.190356F, 8.833333F, 7.75F, 9.392978F, 7.75F, 10.083333F);
      ((Path)localObject1).cubicTo(7.75F, 10.595913F, 7.441476F, 11.036433F, 7.0F, 11.229322F);
      ((Path)localObject1).lineTo(7.0F, 13.0F);
      ((Path)localObject1).lineTo(6.0F, 13.0F);
      ((Path)localObject1).lineTo(6.0F, 11.229322F);
      ((Path)localObject1).lineTo(6.0F, 11.229322F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_mac_lock
 * JD-Core Version:    0.7.0.1
 */