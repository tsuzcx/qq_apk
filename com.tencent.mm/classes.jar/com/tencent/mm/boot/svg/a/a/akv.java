package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class akv
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.0F, 29.34668F);
      ((Path)localObject).lineTo(31.819336F, 29.34668F);
      ((Path)localObject).cubicTo(31.983398F, 26.803711F, 33.685547F, 25.183594F, 36.331055F, 25.183594F);
      ((Path)localObject).cubicTo(38.915039F, 25.183594F, 40.637695F, 26.762695F, 40.637695F, 28.936523F);
      ((Path)localObject).cubicTo(40.637695F, 30.966797F, 39.776367F, 32.074219F, 37.233398F, 33.612305F);
      ((Path)localObject).cubicTo(34.40332F, 35.273438F, 33.213867F, 37.119141F, 33.398438F, 40.154297F);
      ((Path)localObject).lineTo(33.418945F, 41.610352F);
      ((Path)localObject).lineTo(38.176758F, 41.610352F);
      ((Path)localObject).lineTo(38.176758F, 40.420898F);
      ((Path)localObject).cubicTo(38.176758F, 38.370117F, 38.935547F, 37.303711F, 41.62207F, 35.745117F);
      ((Path)localObject).cubicTo(44.411133F, 34.083984F, 45.969727F, 31.889648F, 45.969727F, 28.751953F);
      ((Path)localObject).cubicTo(45.969727F, 24.240234F, 42.216797F, 21.0F, 36.597656F, 21.0F);
      ((Path)localObject).cubicTo(30.506836F, 21.0F, 27.164063F, 24.527344F, 27.0F, 29.34668F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.859375F, 51.249023F);
      ((Path)localObject).cubicTo(37.520508F, 51.249023F, 38.833008F, 49.957031F, 38.833008F, 48.336914F);
      ((Path)localObject).cubicTo(38.833008F, 46.716797F, 37.520508F, 45.445313F, 35.859375F, 45.445313F);
      ((Path)localObject).cubicTo(34.198242F, 45.445313F, 32.865234F, 46.716797F, 32.865234F, 48.336914F);
      ((Path)localObject).cubicTo(32.865234F, 49.957031F, 34.198242F, 51.249023F, 35.859375F, 51.249023F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.akv
 * JD-Core Version:    0.7.0.1
 */