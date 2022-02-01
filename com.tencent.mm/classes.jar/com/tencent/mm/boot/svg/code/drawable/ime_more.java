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

public class ime_more
  extends c
{
  private final int height = 20;
  private final int width = 37;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 37;
      return 20;
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
      localPaint1.setColor(-13158600);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -688.0F, 0.0F, 1.0F, -992.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 688.0F, 0.0F, 1.0F, 992.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(34.022831F, 0.381236F);
      ((Path)localObject2).lineTo(34.022831F, 0.3812359F);
      ((Path)localObject2).cubicTo(34.486294F, -0.09800371F, 35.224876F, -0.08425931F, 35.672504F, 0.4119338F);
      ((Path)localObject2).cubicTo(36.109169F, 0.8959763F, 36.109165F, 1.663374F, 35.672501F, 2.147414F);
      ((Path)localObject2).lineTo(19.339128F, 19.634293F);
      ((Path)localObject2).lineTo(19.339128F, 19.634293F);
      ((Path)localObject2).cubicTo(18.883545F, 20.121902F, 18.145044F, 20.121902F, 17.689459F, 19.634293F);
      ((Path)localObject2).lineTo(1.356088F, 2.147414F);
      ((Path)localObject2).lineTo(1.356088F, 2.147414F);
      ((Path)localObject2).cubicTo(0.8926715F, 1.668126F, 0.7450592F, 0.8910465F, 1.327579F, 0.381236F);
      ((Path)localObject2).cubicTo(1.910099F, -0.1285746F, 2.996424F, 0.3708868F, 3.005762F, 0.381236F);
      ((Path)localObject2).lineTo(18.514301F, 16.985031F);
      ((Path)localObject2).lineTo(34.022842F, 0.381236F);
      ((Path)localObject2).lineTo(34.022831F, 0.381236F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_more
 * JD-Core Version:    0.7.0.1
 */