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

public final class ahb
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-65794);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(77.0F, 25.0F);
      ((Path)localObject).lineTo(19.0F, 25.0F);
      ((Path)localObject).cubicTo(17.343F, 25.0F, 16.0F, 26.34297F, 16.0F, 27.999935F);
      ((Path)localObject).lineTo(16.0F, 68.000069F);
      ((Path)localObject).cubicTo(16.0F, 69.657028F, 17.343F, 71.0F, 19.0F, 71.0F);
      ((Path)localObject).lineTo(77.0F, 71.0F);
      ((Path)localObject).cubicTo(78.655998F, 71.0F, 80.0F, 69.657028F, 80.0F, 68.000069F);
      ((Path)localObject).lineTo(80.0F, 27.999935F);
      ((Path)localObject).cubicTo(80.0F, 26.34297F, 78.656998F, 25.0F, 77.0F, 25.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(72.771423F, 39.428131F);
      ((Path)localObject).lineTo(49.779076F, 52.676395F);
      ((Path)localObject).cubicTo(49.218597F, 52.999264F, 48.584373F, 53.06992F, 48.000298F, 52.935474F);
      ((Path)localObject).cubicTo(47.414253F, 53.06992F, 46.781013F, 52.99828F, 46.221519F, 52.676395F);
      ((Path)localObject).lineTo(23.229168F, 39.428131F);
      ((Path)localObject).cubicTo(22.054132F, 38.750996F, 21.650982F, 37.250507F, 22.329454F, 36.076809F);
      ((Path)localObject).lineTo(22.821102F, 35.226955F);
      ((Path)localObject).cubicTo(23.499575F, 34.053257F, 25.004013F, 33.651886F, 26.179049F, 34.329018F);
      ((Path)localObject).lineTo(48.000298F, 46.902115F);
      ((Path)localObject).lineTo(69.820564F, 34.329018F);
      ((Path)localObject).cubicTo(70.995598F, 33.651886F, 72.500038F, 34.053257F, 73.177528F, 35.226955F);
      ((Path)localObject).lineTo(73.669174F, 36.076809F);
      ((Path)localObject).cubicTo(74.349609F, 37.250507F, 73.946457F, 38.750996F, 72.771423F, 39.428131F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahb
 * JD-Core Version:    0.7.0.1
 */