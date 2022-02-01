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

public class actionbar_voip_video_icon
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 27.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(2.39584F, 1.509198F);
      ((Path)localObject3).cubicTo(3.783774F, 0.7104563F, 5.511202F, 1.13978F, 7.038928F, 1.0F);
      ((Path)localObject3).cubicTo(20.049559F, 1.089858F, 33.060188F, 0.93011F, 46.060833F, 1.06989F);
      ((Path)localObject3).cubicTo(48.067844F, 0.9500787F, 49.24609F, 3.136633F, 48.95652F, 4.913833F);
      ((Path)localObject3).cubicTo(48.93655F, 15.956433F, 49.046387F, 27.009018F, 48.906597F, 38.061604F);
      ((Path)localObject3).cubicTo(48.97649F, 40.038486F, 46.889599F, 41.276535F, 45.082291F, 40.947056F);
      ((Path)localObject3).cubicTo(31.3727F, 40.927086F, 17.663111F, 41.026928F, 3.953521F, 40.90712F);
      ((Path)localObject3).cubicTo(1.956494F, 41.026928F, 0.7383078F, 38.890297F, 1.047847F, 37.093128F);
      ((Path)localObject3).cubicTo(1.007906F, 26.719473F, 1.067817F, 16.335835F, 1.017892F, 5.952197F);
      ((Path)localObject3).cubicTo(1.067817F, 4.404635F, 0.8281741F, 2.42775F, 2.39584F, 1.509198F);
      ((Path)localObject3).lineTo(2.39584F, 1.509198F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(52.016338F, 14.457662F);
      ((Path)localObject2).cubicTo(57.03326F, 10.022178F, 61.740986F, 5.203629F, 66.967361F, 1.0F);
      ((Path)localObject2).cubicTo(68.353752F, 3.066532F, 67.924866F, 5.616935F, 67.974739F, 7.955645F);
      ((Path)localObject2).cubicTo(67.944817F, 17.713709F, 67.974739F, 27.471775F, 67.974739F, 37.229839F);
      ((Path)localObject2).cubicTo(68.014633F, 38.590725F, 67.675514F, 39.840725F, 66.95739F, 41.0F);
      ((Path)localObject2).cubicTo(61.731014F, 36.836693F, 57.08313F, 31.997984F, 52.036285F, 27.612904F);
      ((Path)localObject2).cubicTo(51.97644F, 23.227823F, 52.006363F, 18.842741F, 52.016338F, 14.457662F);
      ((Path)localObject2).lineTo(52.016338F, 14.457662F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.actionbar_voip_video_icon
 * JD-Core Version:    0.7.0.1
 */