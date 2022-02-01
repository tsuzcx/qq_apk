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

public class voice2txt_cancel_img
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 13.333333F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(21.952621F, 20.0F);
      ((Path)localObject2).lineTo(28.047379F, 26.094757F);
      ((Path)localObject2).lineTo(23.333334F, 30.808802F);
      ((Path)localObject2).lineTo(11.548221F, 19.023689F);
      ((Path)localObject2).cubicTo(10.246472F, 17.721941F, 10.246472F, 15.611392F, 11.548221F, 14.309644F);
      ((Path)localObject2).lineTo(23.333334F, 2.524531F);
      ((Path)localObject2).lineTo(28.047379F, 7.238576F);
      ((Path)localObject2).lineTo(21.952621F, 13.333333F);
      ((Path)localObject2).lineTo(36.666668F, 13.333333F);
      ((Path)localObject2).cubicTo(47.71236F, 13.333333F, 56.666668F, 22.287638F, 56.666668F, 33.333332F);
      ((Path)localObject2).cubicTo(56.666668F, 44.379028F, 47.71236F, 53.333332F, 36.666668F, 53.333332F);
      ((Path)localObject2).lineTo(0.0F, 53.333332F);
      ((Path)localObject2).lineTo(0.0F, 46.666668F);
      ((Path)localObject2).lineTo(36.666668F, 46.666668F);
      ((Path)localObject2).cubicTo(44.030464F, 46.666668F, 50.0F, 40.697128F, 50.0F, 33.333332F);
      ((Path)localObject2).cubicTo(50.0F, 25.969536F, 44.030464F, 20.0F, 36.666668F, 20.0F);
      ((Path)localObject2).lineTo(21.952621F, 20.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voice2txt_cancel_img
 * JD-Core Version:    0.7.0.1
 */