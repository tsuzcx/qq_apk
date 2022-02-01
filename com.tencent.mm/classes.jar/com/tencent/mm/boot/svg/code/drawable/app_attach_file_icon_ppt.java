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

public class app_attach_file_icon_ppt
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-892609);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 8.0F);
      ((Path)localObject2).lineTo(23.999863F, 1.049432F);
      ((Path)localObject2).cubicTo(23.999954F, 1.055166F, 24.0F, 1.060911F, 24.0F, 1.066667F);
      ((Path)localObject2).lineTo(24.0F, 30.933332F);
      ((Path)localObject2).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject2).lineTo(1.066667F, 32.0F);
      ((Path)localObject2).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject2).lineTo(0.0F, 1.066667F);
      ((Path)localObject2).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject2).lineTo(16.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 8.0F);
      ((Path)localObject1).lineTo(17.066668F, 8.0F);
      ((Path)localObject1).cubicTo(16.477562F, 8.0F, 16.0F, 7.522437F, 16.0F, 6.933333F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 8.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(10.672916F, 24.266666F);
      ((Path)localObject1).lineTo(10.672916F, 21.285418F);
      ((Path)localObject1).lineTo(12.497917F, 21.285418F);
      ((Path)localObject1).cubicTo(14.322917F, 21.285418F, 15.604167F, 20.066668F, 15.604167F, 18.266666F);
      ((Path)localObject1).cubicTo(15.604167F, 16.466667F, 14.360416F, 15.247917F, 12.566667F, 15.247917F);
      ((Path)localObject1).lineTo(9.060416F, 15.247917F);
      ((Path)localObject1).lineTo(9.060416F, 24.266666F);
      ((Path)localObject1).lineTo(10.672916F, 24.266666F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(12.135417F, 19.985416F);
      ((Path)localObject1).lineTo(10.672916F, 19.985416F);
      ((Path)localObject1).lineTo(10.672916F, 16.566668F);
      ((Path)localObject1).lineTo(12.141666F, 16.566668F);
      ((Path)localObject1).cubicTo(13.297916F, 16.566668F, 13.966667F, 17.185417F, 13.966667F, 18.266666F);
      ((Path)localObject1).cubicTo(13.966667F, 19.360416F, 13.291667F, 19.985416F, 12.135417F, 19.985416F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_ppt
 * JD-Core Version:    0.7.0.1
 */