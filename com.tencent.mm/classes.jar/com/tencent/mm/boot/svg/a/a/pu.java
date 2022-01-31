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

public final class pu
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-14187817);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.lineTo(108.0F, 108.0F);
      localPath.lineTo(0.0F, 108.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(59.0F, 27.0F);
      ((Path)localObject).lineTo(80.0F, 27.0F);
      ((Path)localObject).cubicTo(81.327415F, 27.113115F, 82.968498F, 28.671097F, 83.0F, 30.0F);
      ((Path)localObject).lineTo(83.0F, 51.0F);
      ((Path)localObject).cubicTo(82.945999F, 51.277657F, 82.61898F, 52.063435F, 81.5F, 52.5F);
      ((Path)localObject).lineTo(48.5F, 85.5F);
      ((Path)localObject).cubicTo(47.358231F, 87.322365F, 45.247627F, 87.3284F, 44.0F, 85.5F);
      ((Path)localObject).lineTo(24.5F, 66.0F);
      ((Path)localObject).cubicTo(23.321037F, 65.400536F, 22.997021F, 64.616264F, 23.0F, 63.0F);
      ((Path)localObject).cubicTo(23.00152F, 62.774742F, 23.328537F, 61.988964F, 24.5F, 61.5F);
      ((Path)localObject).lineTo(57.5F, 28.5F);
      ((Path)localObject).cubicTo(57.912754F, 27.405708F, 59.0F, 27.0F, 59.0F, 27.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(67.777779F, 36.0F);
      ((Path)localObject).cubicTo(70.865555F, 36.0F, 74.0F, 39.134445F, 74.0F, 43.777779F);
      ((Path)localObject).cubicTo(74.0F, 46.865555F, 70.865555F, 50.0F, 67.777779F, 50.0F);
      ((Path)localObject).cubicTo(63.134445F, 50.0F, 60.0F, 46.865555F, 60.0F, 43.777779F);
      ((Path)localObject).cubicTo(60.0F, 39.134445F, 63.134445F, 36.0F, 67.777779F, 36.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pu
 * JD-Core Version:    0.7.0.1
 */