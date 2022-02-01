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

public final class aer
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localPaint.setColor(1275068416);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(16.309931F, 15.561403F);
      ((Path)localObject).lineTo(20.424265F, 19.675735F);
      ((Path)localObject).lineTo(19.575735F, 20.524263F);
      ((Path)localObject).lineTo(15.452851F, 16.401379F);
      ((Path)localObject).cubicTo(14.24281F, 17.400068F, 12.691467F, 18.0F, 11.0F, 18.0F);
      ((Path)localObject).cubicTo(7.134F, 18.0F, 4.0F, 14.866F, 4.0F, 11.0F);
      ((Path)localObject).cubicTo(4.0F, 7.134F, 7.134F, 4.0F, 11.0F, 4.0F);
      ((Path)localObject).cubicTo(14.866F, 4.0F, 18.0F, 7.134F, 18.0F, 11.0F);
      ((Path)localObject).cubicTo(18.0F, 12.742484F, 17.363333F, 14.336264F, 16.309931F, 15.561403F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.799997F, 11.000012F);
      ((Path)localObject).cubicTo(16.799997F, 7.796755F, 14.203255F, 5.200012F, 10.999997F, 5.200012F);
      ((Path)localObject).cubicTo(7.79674F, 5.200012F, 5.199997F, 7.796755F, 5.199997F, 11.000012F);
      ((Path)localObject).cubicTo(5.199997F, 14.20327F, 7.79674F, 16.800013F, 10.999997F, 16.800013F);
      ((Path)localObject).cubicTo(14.203255F, 16.800013F, 16.799997F, 14.20327F, 16.799997F, 11.000012F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aer
 * JD-Core Version:    0.7.0.1
 */