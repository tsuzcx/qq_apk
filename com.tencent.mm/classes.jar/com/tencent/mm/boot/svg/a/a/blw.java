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

public final class blw
  extends c
{
  private final int height = 36;
  private final int width = 46;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 46;
      return 36;
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
      localPaint.setColor(-9205837);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(9.0F, 12.0F);
      localPath.lineTo(36.0F, 12.0F);
      localPath.lineTo(36.0F, 17.0F);
      localPath.lineTo(9.0F, 17.0F);
      localPath.lineTo(9.0F, 12.0F);
      localPath.lineTo(9.0F, 12.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 3.00742F);
      ((Path)localObject).cubicTo(0.0F, 1.346468F, 1.351781F, 0.0F, 3.000444F, 0.0F);
      ((Path)localObject).lineTo(42.999557F, 0.0F);
      ((Path)localObject).cubicTo(44.656654F, 0.0F, 46.0F, 1.345539F, 46.0F, 3.00742F);
      ((Path)localObject).lineTo(46.0F, 32.99258F);
      ((Path)localObject).cubicTo(46.0F, 34.653534F, 44.64822F, 36.0F, 42.999557F, 36.0F);
      ((Path)localObject).lineTo(3.000444F, 36.0F);
      ((Path)localObject).cubicTo(1.343345F, 36.0F, 0.0F, 34.654461F, 0.0F, 32.99258F);
      ((Path)localObject).lineTo(0.0F, 3.00742F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.066667F, 3.0F);
      ((Path)localObject).lineTo(43.0F, 3.0F);
      ((Path)localObject).lineTo(43.0F, 33.0F);
      ((Path)localObject).lineTo(3.066667F, 33.0F);
      ((Path)localObject).lineTo(3.066667F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.2F, 12.0F);
      ((Path)localObject).lineTo(37.0F, 12.0F);
      ((Path)localObject).lineTo(37.0F, 17.0F);
      ((Path)localObject).lineTo(9.2F, 17.0F);
      ((Path)localObject).lineTo(9.2F, 12.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.blw
 * JD-Core Version:    0.7.0.1
 */