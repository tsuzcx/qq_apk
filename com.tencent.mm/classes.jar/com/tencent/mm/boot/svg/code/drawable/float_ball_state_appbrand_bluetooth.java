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

public class float_ball_state_appbrand_bluetooth
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
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.889356F, 1.467648F);
      ((Path)localObject2).lineTo(12.712133F, 5.287867F);
      ((Path)localObject2).cubicTo(13.005328F, 5.580458F, 13.005487F, 6.055332F, 12.712692F, 6.348323F);
      ((Path)localObject2).cubicTo(12.712625F, 6.348391F, 12.712556F, 6.348459F, 12.712284F, 6.348323F);
      ((Path)localObject2).lineTo(10.060529F, 8.99981F);
      ((Path)localObject2).lineTo(10.060529F, 8.99981F);
      ((Path)localObject2).lineTo(12.712316F, 11.651646F);
      ((Path)localObject2).cubicTo(13.005169F, 11.944557F, 13.005177F, 12.419411F, 12.712333F, 12.712333F);
      ((Path)localObject2).lineTo(8.889455F, 16.535522F);
      ((Path)localObject2).cubicTo(8.743014F, 16.681974F, 8.505578F, 16.681984F, 8.359125F, 16.535543F);
      ((Path)localObject2).cubicTo(8.288793F, 16.465216F, 8.249279F, 16.369829F, 8.249279F, 16.270367F);
      ((Path)localObject2).lineTo(8.249279F, 10.811061F);
      ((Path)localObject2).lineTo(8.249279F, 10.811061F);
      ((Path)localObject2).lineTo(5.287689F, 13.772971F);
      ((Path)localObject2).lineTo(4.227029F, 12.712311F);
      ((Path)localObject2).lineTo(7.938779F, 8.99981F);
      ((Path)localObject2).lineTo(4.227029F, 5.287689F);
      ((Path)localObject2).lineTo(5.287689F, 4.227029F);
      ((Path)localObject2).lineTo(8.249279F, 7.188561F);
      ((Path)localObject2).lineTo(8.249279F, 1.732902F);
      ((Path)localObject2).cubicTo(8.249279F, 1.525795F, 8.417172F, 1.357902F, 8.624279F, 1.357902F);
      ((Path)localObject2).cubicTo(8.723692F, 1.357902F, 8.819037F, 1.397376F, 8.889356F, 1.467648F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.749279F, 10.81031F);
      ((Path)localObject2).lineTo(9.749279F, 13.554561F);
      ((Path)localObject2).lineTo(11.121779F, 12.18206F);
      ((Path)localObject2).lineTo(9.749279F, 10.81031F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.749279F, 4.448811F);
      ((Path)localObject2).lineTo(9.749279F, 7.189311F);
      ((Path)localObject2).lineTo(11.119529F, 5.819061F);
      ((Path)localObject2).lineTo(9.749279F, 4.448811F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.float_ball_state_appbrand_bluetooth
 * JD-Core Version:    0.7.0.1
 */