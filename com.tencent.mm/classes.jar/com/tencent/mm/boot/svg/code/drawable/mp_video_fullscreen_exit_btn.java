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

public class mp_video_fullscreen_exit_btn
  extends c
{
  private final int height = 33;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 33;
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-2565928);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(32.0F, 0.0F);
      localPath.lineTo(32.0F, 32.0F);
      localPath.lineTo(0.0F, 32.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint(localPaint2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.416667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 17.916666F);
      ((Path)localObject2).lineTo(24.0F, 23.25F);
      ((Path)localObject2).cubicTo(24.0F, 23.98638F, 23.403046F, 24.583334F, 22.666666F, 24.583334F);
      ((Path)localObject2).lineTo(17.333334F, 24.583334F);
      ((Path)localObject2).lineTo(17.333334F, 22.983334F);
      ((Path)localObject2).lineTo(22.4F, 22.983334F);
      ((Path)localObject2).lineTo(22.4F, 17.916666F);
      ((Path)localObject2).lineTo(24.0F, 17.916666F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.698144F, 14.559919F);
      ((Path)localObject2).cubicTo(9.434524F, 14.559919F, 10.031477F, 15.156873F, 10.031477F, 15.893252F);
      ((Path)localObject2).lineTo(10.031477F, 21.226585F);
      ((Path)localObject2).lineTo(8.431478F, 21.226585F);
      ((Path)localObject2).lineTo(8.431478F, 17.291279F);
      ((Path)localObject2).lineTo(1.135565F, 24.587191F);
      ((Path)localObject2).lineTo(0.004194131F, 23.45582F);
      ((Path)localObject2).lineTo(7.300095F, 16.15992F);
      ((Path)localObject2).lineTo(3.364811F, 16.15992F);
      ((Path)localObject2).lineTo(3.364811F, 14.559919F);
      ((Path)localObject2).lineTo(8.698144F, 14.559919F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.864435F, 0.5794758F);
      ((Path)localObject2).lineTo(23.995806F, 1.710847F);
      ((Path)localObject2).lineTo(16.699905F, 9.006747F);
      ((Path)localObject2).lineTo(20.635189F, 9.006747F);
      ((Path)localObject2).lineTo(20.635189F, 10.606748F);
      ((Path)localObject2).lineTo(15.301856F, 10.606748F);
      ((Path)localObject2).cubicTo(14.565476F, 10.606748F, 13.968523F, 10.009794F, 13.968523F, 9.273415F);
      ((Path)localObject2).lineTo(13.968523F, 3.940081F);
      ((Path)localObject2).lineTo(15.568522F, 3.940081F);
      ((Path)localObject2).lineTo(15.568522F, 7.875388F);
      ((Path)localObject2).lineTo(22.864435F, 0.5794758F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.666667F, 0.5833333F);
      ((Path)localObject2).lineTo(6.666667F, 2.183333F);
      ((Path)localObject2).lineTo(1.6F, 2.183333F);
      ((Path)localObject2).lineTo(1.6F, 7.25F);
      ((Path)localObject2).lineTo(0.0F, 7.25F);
      ((Path)localObject2).lineTo(0.0F, 1.916667F);
      ((Path)localObject2).cubicTo(0.0F, 1.180287F, 0.5969537F, 0.5833333F, 1.333333F, 0.5833333F);
      ((Path)localObject2).lineTo(6.666667F, 0.5833333F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.mp_video_fullscreen_exit_btn
 * JD-Core Version:    0.7.0.1
 */