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

public class lucky_money_detail_story_video_error_icon
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -172.0F, 0.0F, 1.0F, -175.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 172.0F, 0.0F, 1.0F, 175.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(48.0F, 0.0F);
      ((Path)localObject2).cubicTo(74.509666F, 0.0F, 96.0F, 21.490332F, 96.0F, 48.0F);
      ((Path)localObject2).cubicTo(96.0F, 74.509666F, 74.509666F, 96.0F, 48.0F, 96.0F);
      ((Path)localObject2).cubicTo(21.490332F, 96.0F, 0.0F, 74.509666F, 0.0F, 48.0F);
      ((Path)localObject2).cubicTo(0.0F, 21.490332F, 21.490332F, 0.0F, 48.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(47.978439F, 64.026566F);
      ((Path)localObject2).cubicTo(45.583126F, 64.026566F, 43.68F, 65.864059F, 43.68F, 68.259377F);
      ((Path)localObject2).cubicTo(43.68F, 70.654686F, 45.583126F, 72.492188F, 47.978439F, 72.492188F);
      ((Path)localObject2).cubicTo(50.439377F, 72.492188F, 52.309689F, 70.654686F, 52.309689F, 68.259377F);
      ((Path)localObject2).cubicTo(52.309689F, 65.864059F, 50.439377F, 64.026566F, 47.978439F, 64.026566F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(51.653439F, 19.851563F);
      ((Path)localObject2).lineTo(44.33625F, 19.851563F);
      ((Path)localObject2).lineTo(44.861252F, 56.315624F);
      ((Path)localObject2).lineTo(51.128441F, 56.315624F);
      ((Path)localObject2).lineTo(51.653439F, 19.851563F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.lucky_money_detail_story_video_error_icon
 * JD-Core Version:    0.7.0.1
 */