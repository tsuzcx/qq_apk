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

public class remittance_extra_buy_favor
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
      ((Path)localObject2).moveTo(16.25F, 16.25F);
      ((Path)localObject2).cubicTo(16.578791F, 16.250807F, 16.851986F, 15.996735F, 16.875F, 15.66875F);
      ((Path)localObject2).lineTo(16.25F, 4.375F);
      ((Path)localObject2).cubicTo(16.25F, 4.029822F, 15.970178F, 3.75F, 15.625F, 3.75F);
      ((Path)localObject2).lineTo(4.375F, 3.75F);
      ((Path)localObject2).cubicTo(4.029822F, 3.75F, 3.75F, 4.029822F, 3.75F, 4.375F);
      ((Path)localObject2).lineTo(3.125F, 15.625F);
      ((Path)localObject2).cubicTo(3.125F, 15.970178F, 3.404822F, 16.25F, 3.75F, 16.25F);
      ((Path)localObject2).lineTo(16.25F, 16.25F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.25F, 17.5F);
      ((Path)localObject2).lineTo(3.75F, 17.5F);
      ((Path)localObject2).cubicTo(2.714466F, 17.5F, 1.875F, 16.660534F, 1.875F, 15.625F);
      ((Path)localObject2).lineTo(2.5F, 4.375F);
      ((Path)localObject2).cubicTo(2.5F, 3.339466F, 3.339466F, 2.5F, 4.375F, 2.5F);
      ((Path)localObject2).lineTo(15.625F, 2.5F);
      ((Path)localObject2).cubicTo(16.643686F, 2.499723F, 17.476231F, 3.312841F, 17.5F, 4.33125F);
      ((Path)localObject2).lineTo(18.125F, 15.625F);
      ((Path)localObject2).cubicTo(18.125F, 16.660534F, 17.285534F, 17.5F, 16.25F, 17.5F);
      ((Path)localObject2).lineTo(16.25F, 17.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.5F, 6.25F);
      ((Path)localObject2).cubicTo(12.5F, 5.904822F, 12.779822F, 5.625F, 13.125F, 5.625F);
      ((Path)localObject2).cubicTo(13.470178F, 5.625F, 13.75F, 5.904822F, 13.75F, 6.25F);
      ((Path)localObject2).cubicTo(13.75F, 8.321068F, 12.071068F, 10.0F, 10.0F, 10.0F);
      ((Path)localObject2).cubicTo(7.928932F, 10.0F, 6.25F, 8.321068F, 6.25F, 6.25F);
      ((Path)localObject2).cubicTo(6.25F, 5.904822F, 6.529822F, 5.625F, 6.875F, 5.625F);
      ((Path)localObject2).cubicTo(7.220178F, 5.625F, 7.5F, 5.904822F, 7.5F, 6.25F);
      ((Path)localObject2).cubicTo(7.5F, 7.630712F, 8.619288F, 8.75F, 10.0F, 8.75F);
      ((Path)localObject2).cubicTo(11.380712F, 8.75F, 12.5F, 7.630712F, 12.5F, 6.25F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.remittance_extra_buy_favor
 * JD-Core Version:    0.7.0.1
 */