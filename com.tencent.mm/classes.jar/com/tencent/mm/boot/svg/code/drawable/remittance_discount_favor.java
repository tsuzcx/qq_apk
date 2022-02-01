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

public class remittance_discount_favor
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(20.0F, 0.0F);
      ((Path)localObject3).lineTo(20.0F, 20.0F);
      ((Path)localObject3).lineTo(0.0F, 20.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject3, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.6525F, 2.614375F);
      ((Path)localObject2).cubicTo(18.588991F, 2.030811F, 18.127975F, 1.570055F, 17.544374F, 1.506875F);
      ((Path)localObject2).lineTo(10.770625F, 0.773125F);
      ((Path)localObject2).cubicTo(10.394268F, 0.7325341F, 10.019754F, 0.864418F, 9.751875F, 1.131875F);
      ((Path)localObject2).lineTo(1.255625F, 9.62875F);
      ((Path)localObject2).cubicTo(0.7676476F, 10.116875F, 0.7676476F, 10.908125F, 1.255625F, 11.39625F);
      ((Path)localObject2).lineTo(8.76875F, 18.909374F);
      ((Path)localObject2).cubicTo(9.256875F, 19.397352F, 10.048125F, 19.397352F, 10.53625F, 18.909374F);
      ((Path)localObject2).lineTo(19.032499F, 10.413125F);
      ((Path)localObject2).cubicTo(19.300373F, 10.14525F, 19.432314F, 9.770349F, 19.391251F, 9.39375F);
      ((Path)localObject2).lineTo(18.6525F, 2.614375F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.6525F, 18.025625F);
      ((Path)localObject2).lineTo(2.139375F, 10.5125F);
      ((Path)localObject2).lineTo(10.635625F, 2.01625F);
      ((Path)localObject2).lineTo(17.41F, 2.749375F);
      ((Path)localObject2).lineTo(18.14875F, 9.529375F);
      ((Path)localObject2).lineTo(9.6525F, 18.025625F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.864375F, 3.915625F);
      ((Path)localObject2).cubicTo(12.656252F, 3.915625F, 11.676875F, 4.895002F, 11.676875F, 6.103125F);
      ((Path)localObject2).cubicTo(11.676875F, 7.311248F, 12.656252F, 8.290625F, 13.864375F, 8.290625F);
      ((Path)localObject2).cubicTo(15.072498F, 8.290625F, 16.051874F, 7.311248F, 16.051874F, 6.103125F);
      ((Path)localObject2).cubicTo(16.051874F, 4.895002F, 15.072498F, 3.915625F, 13.864375F, 3.915625F);
      ((Path)localObject2).lineTo(13.864375F, 3.915625F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.864375F, 7.040625F);
      ((Path)localObject2).cubicTo(13.529326F, 7.040514F, 13.21979F, 6.861664F, 13.052361F, 6.571448F);
      ((Path)localObject2).cubicTo(12.884934F, 6.281232F, 12.885054F, 5.92374F, 13.052674F, 5.633636F);
      ((Path)localObject2).cubicTo(13.220295F, 5.343531F, 13.529952F, 5.164888F, 13.865F, 5.165F);
      ((Path)localObject2).cubicTo(14.382939F, 5.165173F, 14.802672F, 5.585186F, 14.8025F, 6.103125F);
      ((Path)localObject2).cubicTo(14.802327F, 6.621065F, 14.382315F, 7.040798F, 13.864375F, 7.040625F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.remittance_discount_favor
 * JD-Core Version:    0.7.0.1
 */