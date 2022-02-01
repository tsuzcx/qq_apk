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

public class pc_connect_succ
  extends c
{
  private final int height = 26;
  private final int width = 26;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 26;
      return 26;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -204.0F, 0.0F, 1.0F, -261.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 205.0F, 0.0F, 1.0F, 262.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16268960);
      ((Paint)localObject1).setStrokeWidth(1.285714F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 12.148149F);
      ((Path)localObject2).cubicTo(24.0F, 5.372445F, 18.627556F, 0.0F, 11.851851F, 0.0F);
      ((Path)localObject2).cubicTo(5.372445F, 0.0F, 0.0F, 5.372445F, 0.0F, 12.148149F);
      ((Path)localObject2).cubicTo(0.0F, 18.627556F, 5.372445F, 24.0F, 11.851851F, 24.0F);
      ((Path)localObject2).cubicTo(18.627556F, 24.0F, 24.0F, 18.627556F, 24.0F, 12.148149F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(6.252277F, 13.007762F);
      ((Path)localObject1).cubicTo(6.088865F, 12.838639F, 6.064898F, 12.553898F, 6.207098F, 12.360409F);
      ((Path)localObject1).lineTo(6.400117F, 12.097771F);
      ((Path)localObject1).cubicTo(6.538578F, 11.90937F, 6.797776F, 11.869274F, 6.991251F, 12.017562F);
      ((Path)localObject1).lineTo(9.395165F, 13.860023F);
      ((Path)localObject1).cubicTo(9.768337F, 14.146039F, 10.365941F, 14.132068F, 10.727476F, 13.83088F);
      ((Path)localObject1).lineTo(17.770195F, 7.963725F);
      ((Path)localObject1).cubicTo(17.949402F, 7.814432F, 18.228569F, 7.825638F, 18.393208F, 7.988234F);
      ((Path)localObject1).lineTo(18.490576F, 8.084394F);
      ((Path)localObject1).cubicTo(18.655449F, 8.247223F, 18.652159F, 8.513998F, 18.478809F, 8.684599F);
      ((Path)localObject1).lineTo(10.683666F, 16.356184F);
      ((Path)localObject1).cubicTo(10.345078F, 16.689405F, 9.800654F, 16.680157F, 9.481133F, 16.349468F);
      ((Path)localObject1).lineTo(6.252277F, 13.007762F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.pc_connect_succ
 * JD-Core Version:    0.7.0.1
 */