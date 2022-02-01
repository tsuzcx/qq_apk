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

public class icons_outlined_comment
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.1F, 13.5F);
      ((Path)localObject2).lineTo(6.036396F, 15.563604F);
      ((Path)localObject2).cubicTo(5.684924F, 15.915076F, 5.115076F, 15.915076F, 4.763604F, 15.563604F);
      ((Path)localObject2).cubicTo(4.594821F, 15.394821F, 4.5F, 15.165902F, 4.5F, 14.927208F);
      ((Path)localObject2).lineTo(4.5F, 13.5F);
      ((Path)localObject2).lineTo(1.35F, 13.5F);
      ((Path)localObject2).cubicTo(0.604416F, 13.5F, 0.0F, 12.895584F, 0.0F, 12.15F);
      ((Path)localObject2).lineTo(0.0F, 1.35F);
      ((Path)localObject2).cubicTo(0.0F, 0.604416F, 0.604416F, 0.0F, 1.35F, 0.0F);
      ((Path)localObject2).lineTo(16.65F, 0.0F);
      ((Path)localObject2).cubicTo(17.395584F, 0.0F, 18.0F, 0.604416F, 18.0F, 1.35F);
      ((Path)localObject2).lineTo(18.0F, 12.15F);
      ((Path)localObject2).cubicTo(18.0F, 12.895584F, 17.395584F, 13.5F, 16.65F, 13.5F);
      ((Path)localObject2).lineTo(8.1F, 13.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.7F, 14.202944F);
      ((Path)localObject2).lineTo(7.602944F, 12.3F);
      ((Path)localObject2).lineTo(16.65F, 12.3F);
      ((Path)localObject2).cubicTo(16.732843F, 12.3F, 16.799999F, 12.232842F, 16.799999F, 12.15F);
      ((Path)localObject2).lineTo(16.799999F, 1.35F);
      ((Path)localObject2).cubicTo(16.799999F, 1.267157F, 16.732843F, 1.2F, 16.65F, 1.2F);
      ((Path)localObject2).lineTo(1.35F, 1.2F);
      ((Path)localObject2).cubicTo(1.267157F, 1.2F, 1.2F, 1.267157F, 1.2F, 1.35F);
      ((Path)localObject2).lineTo(1.2F, 12.15F);
      ((Path)localObject2).cubicTo(1.2F, 12.232842F, 1.267157F, 12.3F, 1.35F, 12.3F);
      ((Path)localObject2).lineTo(5.7F, 12.3F);
      ((Path)localObject2).lineTo(5.7F, 14.202944F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_comment
 * JD-Core Version:    0.7.0.1
 */