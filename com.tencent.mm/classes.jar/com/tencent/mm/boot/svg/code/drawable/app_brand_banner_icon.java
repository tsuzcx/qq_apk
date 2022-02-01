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

public class app_brand_banner_icon
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-9473160);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 15.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(33.0F, 66.0F);
      ((Path)localObject3).cubicTo(51.225395F, 66.0F, 66.0F, 51.225395F, 66.0F, 33.0F);
      ((Path)localObject3).cubicTo(66.0F, 14.774603F, 51.225395F, 0.0F, 33.0F, 0.0F);
      ((Path)localObject3).cubicTo(14.774603F, 0.0F, 0.0F, 14.774603F, 0.0F, 33.0F);
      ((Path)localObject3).cubicTo(0.0F, 51.225395F, 14.774603F, 66.0F, 33.0F, 66.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(33.0F, 63.0F);
      ((Path)localObject3).cubicTo(49.568542F, 63.0F, 63.0F, 49.568542F, 63.0F, 33.0F);
      ((Path)localObject3).cubicTo(63.0F, 16.431458F, 49.568542F, 3.0F, 33.0F, 3.0F);
      ((Path)localObject3).cubicTo(16.431458F, 3.0F, 3.0F, 16.431458F, 3.0F, 33.0F);
      ((Path)localObject3).cubicTo(3.0F, 49.568542F, 16.431458F, 63.0F, 33.0F, 63.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.400999F, 47.626999F);
      ((Path)localObject2).cubicTo(20.216999F, 47.626999F, 16.0F, 44.080002F, 16.0F, 39.720001F);
      ((Path)localObject2).cubicTo(16.0F, 35.360001F, 20.216999F, 31.813999F, 25.400999F, 31.813999F);
      ((Path)localObject2).cubicTo(26.23F, 31.813999F, 26.900999F, 32.485001F, 26.900999F, 33.313999F);
      ((Path)localObject2).cubicTo(26.900999F, 34.141998F, 26.23F, 34.813999F, 25.400999F, 34.813999F);
      ((Path)localObject2).cubicTo(21.871F, 34.813999F, 19.0F, 37.014999F, 19.0F, 39.720001F);
      ((Path)localObject2).cubicTo(19.0F, 42.425999F, 21.871F, 44.626999F, 25.400999F, 44.626999F);
      ((Path)localObject2).cubicTo(28.931F, 44.626999F, 31.802F, 42.425999F, 31.802F, 39.720001F);
      ((Path)localObject2).lineTo(31.802F, 26.907F);
      ((Path)localObject2).cubicTo(31.802F, 22.547001F, 36.02F, 19.0F, 41.203999F, 19.0F);
      ((Path)localObject2).cubicTo(46.388F, 19.0F, 50.605F, 22.547001F, 50.605F, 26.907F);
      ((Path)localObject2).cubicTo(50.605F, 31.267F, 46.388F, 34.813999F, 41.203999F, 34.813999F);
      ((Path)localObject2).cubicTo(40.375F, 34.813999F, 39.703999F, 34.141998F, 39.703999F, 33.313999F);
      ((Path)localObject2).cubicTo(39.703999F, 32.485001F, 40.375F, 31.813999F, 41.203999F, 31.813999F);
      ((Path)localObject2).cubicTo(44.734001F, 31.813999F, 47.605F, 29.612F, 47.605F, 26.907F);
      ((Path)localObject2).cubicTo(47.605F, 24.201F, 44.734001F, 22.0F, 41.203999F, 22.0F);
      ((Path)localObject2).cubicTo(37.674F, 22.0F, 34.801998F, 24.201F, 34.801998F, 26.907F);
      ((Path)localObject2).lineTo(34.801998F, 39.720001F);
      ((Path)localObject2).cubicTo(34.801998F, 44.080002F, 30.584999F, 47.626999F, 25.400999F, 47.626999F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_banner_icon
 * JD-Core Version:    0.7.0.1
 */