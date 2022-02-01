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

public class connect_pc_lock
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
      localPath.moveTo(98.718056F, 16.4F);
      localPath.cubicTo(99.050537F, 16.4F, 99.176727F, 16.420479F, 99.299782F, 16.486292F);
      localPath.cubicTo(99.579521F, 16.823275F, 99.599998F, 16.949463F, 99.599998F, 17.281942F);
      localPath.lineTo(99.599998F, 17.281942F);
      localPath.lineTo(99.599998F, 74.718056F);
      localPath.cubicTo(99.599998F, 75.050537F, 99.579521F, 75.176727F, 99.51371F, 75.299782F);
      localPath.cubicTo(99.176727F, 75.579521F, 99.050537F, 75.599998F, 98.718056F, 75.599998F);
      localPath.lineTo(98.718056F, 75.599998F);
      localPath.lineTo(5.281942F, 75.599998F);
      localPath.cubicTo(4.949462F, 75.599998F, 4.823275F, 75.579521F, 4.700217F, 75.51371F);
      localPath.cubicTo(4.420479F, 75.176727F, 4.4F, 75.050537F, 4.4F, 74.718056F);
      localPath.lineTo(4.4F, 74.718056F);
      localPath.lineTo(4.4F, 17.281942F);
      localPath.cubicTo(4.4F, 16.949463F, 4.420479F, 16.823275F, 4.486291F, 16.700216F);
      localPath.cubicTo(4.823275F, 16.420479F, 4.949462F, 16.4F, 5.281942F, 16.4F);
      localPath.lineTo(5.281942F, 16.4F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject4).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(0.8F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(57.0F, 80.0F);
      localPath.lineTo(57.0F, 87.595009F);
      localPath.cubicTo(57.0F, 88.108765F, 57.389294F, 88.538933F, 57.900497F, 88.59005F);
      localPath.lineTo(71.099503F, 89.90995F);
      localPath.cubicTo(71.610703F, 89.961067F, 72.0F, 90.391235F, 72.0F, 90.904991F);
      localPath.lineTo(72.0F, 91.0F);
      localPath.cubicTo(72.0F, 91.552284F, 71.552284F, 92.0F, 71.0F, 92.0F);
      localPath.lineTo(33.0F, 92.0F);
      localPath.cubicTo(32.447716F, 92.0F, 32.0F, 91.552284F, 32.0F, 91.0F);
      localPath.lineTo(32.0F, 90.904991F);
      localPath.cubicTo(32.0F, 90.391235F, 32.389294F, 89.961067F, 32.900497F, 89.90995F);
      localPath.lineTo(46.099503F, 88.59005F);
      localPath.cubicTo(46.610706F, 88.538933F, 47.0F, 88.108765F, 47.0F, 87.595009F);
      localPath.lineTo(47.0F, 80.0F);
      localPath.lineTo(47.0F, 80.0F);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject4).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(0.8F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(98.872231F, 12.4F);
      localPath.cubicTo(100.54198F, 12.4F, 101.15311F, 12.559718F, 101.76505F, 12.886991F);
      localPath.cubicTo(102.34617F, 13.197774F, 102.80222F, 13.653834F, 103.11301F, 14.234948F);
      localPath.cubicTo(103.44028F, 14.846895F, 103.6F, 15.458012F, 103.6F, 17.127769F);
      localPath.lineTo(103.6F, 17.127769F);
      localPath.lineTo(103.6F, 74.872231F);
      localPath.cubicTo(103.6F, 76.541985F, 103.44028F, 77.153107F, 103.11301F, 77.765053F);
      localPath.cubicTo(102.80222F, 78.346169F, 102.34617F, 78.802223F, 101.76505F, 79.113007F);
      localPath.cubicTo(101.15311F, 79.440285F, 100.54198F, 79.599998F, 98.872231F, 79.599998F);
      localPath.lineTo(98.872231F, 79.599998F);
      localPath.lineTo(5.12777F, 79.599998F);
      localPath.cubicTo(3.458012F, 79.599998F, 2.846895F, 79.440285F, 2.234948F, 79.113007F);
      localPath.cubicTo(1.653835F, 78.802223F, 1.197774F, 78.346169F, 0.8869907F, 77.765053F);
      localPath.cubicTo(0.5597178F, 77.153107F, 0.4F, 76.541985F, 0.4F, 74.872231F);
      localPath.lineTo(0.4F, 74.872231F);
      localPath.lineTo(0.4F, 17.127769F);
      localPath.cubicTo(0.4F, 15.458012F, 0.5597178F, 14.846895F, 0.8869907F, 14.234948F);
      localPath.cubicTo(1.197774F, 13.653834F, 1.653835F, 13.197774F, 2.234948F, 12.886991F);
      localPath.cubicTo(2.846895F, 12.559718F, 3.458012F, 12.4F, 5.12777F, 12.4F);
      localPath.lineTo(5.12777F, 12.4F);
      localPath.close();
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_pc_lock
 * JD-Core Version:    0.7.0.1
 */