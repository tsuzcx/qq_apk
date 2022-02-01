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

public class icons_outlined_vtoh
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.8F, 0.0F, 1.0F, 0.137907F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      float[] arrayOfFloat = c.setMatrixFloatArray((float[])localObject3, -6.123234E-017F, -1.0F, 18.0F, -1.0F, 6.123234E-017F, 10.200001F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      ((Paint)localObject3).setStrokeWidth(0.675F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.83697E-016F, -1.0F, 4.622654F, 1.0F, -1.83697E-016F, 0.653654F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(1.9845F, 4.076309F);
      localPath.lineTo(3.969F, 1.2F);
      localPath.lineTo(-4.172218E-013F, 1.2F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setStrokeWidth(1.575F);
      localObject3 = c.setMatrixFloatArray(arrayOfFloat, 0.9702957F, 0.241922F, -1.185043F, -0.241922F, 0.9702957F, 1.571233F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(8.319938F, 9.418044F);
      ((Path)localObject1).cubicTo(8.427132F, 8.961834F, 8.483838F, 8.486162F, 8.483838F, 7.997246F);
      ((Path)localObject1).cubicTo(8.483838F, 5.092462F, 6.482186F, 2.655188F, 3.782953F, 1.989494F);
      ((Path)localObject1).cubicTo(3.30674F, 1.87205F, 3.138718F, 1.773133F, 3.127783F, 1.813942F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.575F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.7875F, 7.426524F);
      ((Path)localObject2).cubicTo(0.7875F, 6.805204F, 1.29118F, 6.301524F, 1.9125F, 6.301524F);
      ((Path)localObject2).lineTo(8.887501F, 6.301524F);
      ((Path)localObject2).cubicTo(9.508822F, 6.301524F, 10.012501F, 6.805204F, 10.012501F, 7.426524F);
      ((Path)localObject2).lineTo(10.012501F, 19.351524F);
      ((Path)localObject2).cubicTo(10.012501F, 19.972845F, 9.508822F, 20.476524F, 8.887501F, 20.476524F);
      ((Path)localObject2).lineTo(1.9125F, 20.476524F);
      ((Path)localObject2).cubicTo(1.29118F, 20.476524F, 0.7875F, 19.972845F, 0.7875F, 19.351524F);
      ((Path)localObject2).lineTo(0.7875F, 7.426524F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_vtoh
 * JD-Core Version:    0.7.0.1
 */