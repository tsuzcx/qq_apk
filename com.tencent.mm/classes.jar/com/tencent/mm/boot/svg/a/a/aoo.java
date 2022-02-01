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

public final class aoo
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(22.488417F, 14.56481F);
      ((Path)localObject).lineTo(55.441723F, 33.395271F);
      ((Path)localObject).cubicTo(56.880276F, 34.2173F, 57.380066F, 36.049866F, 56.558037F, 37.488419F);
      ((Path)localObject).cubicTo(56.292267F, 37.95351F, 55.906818F, 38.338963F, 55.441723F, 38.604729F);
      ((Path)localObject).lineTo(22.488417F, 57.435192F);
      ((Path)localObject).cubicTo(21.049864F, 58.257221F, 19.2173F, 57.757431F, 18.395271F, 56.318878F);
      ((Path)localObject).cubicTo(18.136246F, 55.865585F, 18.0F, 55.352543F, 18.0F, 54.83046F);
      ((Path)localObject).lineTo(18.0F, 17.169538F);
      ((Path)localObject).cubicTo(18.0F, 15.512685F, 19.343145F, 14.169539F, 21.0F, 14.169539F);
      ((Path)localObject).cubicTo(21.522081F, 14.169539F, 22.035124F, 14.305785F, 22.488417F, 14.56481F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aoo
 * JD-Core Version:    0.7.0.1
 */