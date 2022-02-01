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

public final class als
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
      ((Path)localObject).moveTo(23.600313F, 33.75F);
      ((Path)localObject).lineTo(5.927285F, 33.75F);
      ((Path)localObject).cubicTo(6.219718F, 33.021572F, 6.659744F, 32.340256F, 7.246615F, 31.753386F);
      ((Path)localObject).lineTo(31.753386F, 7.246615F);
      ((Path)localObject).cubicTo(32.341805F, 6.658195F, 33.02293F, 6.218383F, 33.75F, 5.926443F);
      ((Path)localObject).lineTo(33.75F, 23.600313F);
      ((Path)localObject).cubicTo(28.594849F, 24.529593F, 24.529593F, 28.594849F, 23.600313F, 33.75F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(66.073555F, 33.75F);
      ((Path)localObject).lineTo(48.399685F, 33.75F);
      ((Path)localObject).cubicTo(47.470409F, 28.594849F, 43.405151F, 24.529593F, 38.25F, 23.600313F);
      ((Path)localObject).lineTo(38.25F, 5.927285F);
      ((Path)localObject).cubicTo(38.978428F, 6.219718F, 39.659744F, 6.659744F, 40.246616F, 7.246615F);
      ((Path)localObject).lineTo(64.753387F, 31.753386F);
      ((Path)localObject).cubicTo(65.341805F, 32.341805F, 65.781616F, 33.02293F, 66.073555F, 33.75F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(66.072716F, 38.25F);
      ((Path)localObject).cubicTo(65.780281F, 38.978428F, 65.340256F, 39.659744F, 64.753387F, 40.246616F);
      ((Path)localObject).lineTo(40.246616F, 64.753387F);
      ((Path)localObject).cubicTo(39.658195F, 65.341805F, 38.97707F, 65.781616F, 38.25F, 66.073555F);
      ((Path)localObject).lineTo(38.25F, 48.399685F);
      ((Path)localObject).cubicTo(43.405151F, 47.470409F, 47.470409F, 43.405151F, 48.399685F, 38.25F);
      ((Path)localObject).lineTo(66.072716F, 38.25F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.926443F, 38.25F);
      ((Path)localObject).lineTo(23.600313F, 38.25F);
      ((Path)localObject).cubicTo(24.529593F, 43.405151F, 28.594849F, 47.470409F, 33.75F, 48.399685F);
      ((Path)localObject).lineTo(33.75F, 66.072716F);
      ((Path)localObject).cubicTo(33.021572F, 65.780281F, 32.340256F, 65.340256F, 31.753386F, 64.753387F);
      ((Path)localObject).lineTo(7.246615F, 40.246616F);
      ((Path)localObject).cubicTo(6.658195F, 39.658195F, 6.218383F, 38.97707F, 5.926443F, 38.25F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.als
 * JD-Core Version:    0.7.0.1
 */