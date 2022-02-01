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

public class app_brand_recommend_video_icon
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -307.0F, 0.0F, 1.0F, -1235.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 307.0F, 0.0F, 1.0F, 1235.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(855638016);
      localPaint2.setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.0F, 31.5F);
      ((Path)localObject2).cubicTo(24.560413F, 31.5F, 31.5F, 24.560413F, 31.5F, 16.0F);
      ((Path)localObject2).cubicTo(31.5F, 7.439586F, 24.560413F, 0.5F, 16.0F, 0.5F);
      ((Path)localObject2).cubicTo(7.439586F, 0.5F, 0.5F, 7.439586F, 0.5F, 16.0F);
      ((Path)localObject2).cubicTo(0.5F, 24.560413F, 7.439586F, 31.5F, 16.0F, 31.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(14.023999F, 10.208398F);
      ((Path)localObject1).cubicTo(13.896853F, 10.128932F, 13.749936F, 10.086796F, 13.6F, 10.086796F);
      ((Path)localObject1).cubicTo(13.158173F, 10.086796F, 12.8F, 10.444968F, 12.8F, 10.886796F);
      ((Path)localObject1).lineTo(12.8F, 21.113203F);
      ((Path)localObject1).cubicTo(12.8F, 21.26314F, 12.842135F, 21.410057F, 12.921601F, 21.537203F);
      ((Path)localObject1).cubicTo(13.155769F, 21.911873F, 13.64933F, 22.02577F, 14.023999F, 21.791603F);
      ((Path)localObject1).lineTo(22.205126F, 16.678398F);
      ((Path)localObject1).cubicTo(22.30814F, 16.614014F, 22.39514F, 16.527014F, 22.459524F, 16.424F);
      ((Path)localObject1).cubicTo(22.693693F, 16.04933F, 22.579794F, 15.55577F, 22.205126F, 15.321602F);
      ((Path)localObject1).lineTo(14.023999F, 10.208398F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_recommend_video_icon
 * JD-Core Version:    0.7.0.1
 */