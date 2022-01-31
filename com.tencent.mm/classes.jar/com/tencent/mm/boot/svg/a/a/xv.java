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

public final class xv
  extends c
{
  private final int height = 36;
  private final int width = 33;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 33;
      return 36;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localPaint.setColor(-4547478);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(30.0F, 12.851442F);
      ((Path)localObject).lineTo(30.0F, 33.0F);
      ((Path)localObject).lineTo(3.0F, 33.0F);
      ((Path)localObject).lineTo(3.0F, 13.013662F);
      ((Path)localObject).cubicTo(5.081255F, 14.928909F, 9.102742F, 16.658638F, 10.767557F, 17.279522F);
      ((Path)localObject).cubicTo(10.767557F, 16.999113F, 10.605591F, 15.996458F, 10.828888F, 14.533998F);
      ((Path)localObject).cubicTo(6.821816F, 12.432947F, 3.006738F, 8.449286F, 3.017281F, 5.81018F);
      ((Path)localObject).cubicTo(3.016516F, 5.641232F, 3.0105F, 5.515129F, 3.0F, 5.427509F);
      ((Path)localObject).lineTo(3.0F, 3.0F);
      ((Path)localObject).lineTo(30.0F, 3.0F);
      ((Path)localObject).lineTo(30.0F, 5.425335F);
      ((Path)localObject).cubicTo(29.998358F, 5.479269F, 29.997364F, 5.539978F, 29.997057F, 5.607754F);
      ((Path)localObject).cubicTo(30.007599F, 8.24686F, 26.007072F, 12.432947F, 22.0F, 14.533998F);
      ((Path)localObject).cubicTo(22.223297F, 15.996458F, 22.061331F, 16.999113F, 22.061331F, 17.279522F);
      ((Path)localObject).cubicTo(23.773027F, 16.641155F, 27.97599F, 14.830612F, 30.0F, 12.851442F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(0.0F, 3.00742F);
      ((Path)localObject).cubicTo(0.0F, 1.346468F, 1.334511F, 0.0F, 3.001358F, 0.0F);
      ((Path)localObject).lineTo(29.998642F, 0.0F);
      ((Path)localObject).cubicTo(31.656246F, 0.0F, 33.0F, 1.345539F, 33.0F, 3.00742F);
      ((Path)localObject).lineTo(33.0F, 32.99258F);
      ((Path)localObject).cubicTo(33.0F, 34.653534F, 31.665489F, 36.0F, 29.998642F, 36.0F);
      ((Path)localObject).lineTo(3.001358F, 36.0F);
      ((Path)localObject).cubicTo(1.343754F, 36.0F, 0.0F, 34.654461F, 0.0F, 32.99258F);
      ((Path)localObject).lineTo(0.0F, 3.00742F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.5F, 21.014084F);
      ((Path)localObject).cubicTo(18.985281F, 21.014084F, 21.0F, 18.996214F, 21.0F, 16.507042F);
      ((Path)localObject).cubicTo(21.0F, 14.017872F, 18.985281F, 12.0F, 16.5F, 12.0F);
      ((Path)localObject).cubicTo(14.014719F, 12.0F, 12.0F, 14.017872F, 12.0F, 16.507042F);
      ((Path)localObject).cubicTo(12.0F, 18.996214F, 14.014719F, 21.014084F, 16.5F, 21.014084F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xv
 * JD-Core Version:    0.7.0.1
 */