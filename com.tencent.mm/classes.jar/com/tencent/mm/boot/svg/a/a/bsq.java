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

public final class bsq
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(10.38F, 3.0F);
      ((Path)localObject).lineTo(9.948F, 6.599F);
      ((Path)localObject).lineTo(15.348F, 6.599F);
      ((Path)localObject).lineTo(15.78F, 3.0F);
      ((Path)localObject).lineTo(18.48F, 3.0F);
      ((Path)localObject).lineTo(18.048F, 6.599F);
      ((Path)localObject).lineTo(21.0F, 6.6F);
      ((Path)localObject).lineTo(21.0F, 9.3F);
      ((Path)localObject).lineTo(17.724001F, 9.299F);
      ((Path)localObject).lineTo(17.076F, 14.699F);
      ((Path)localObject).lineTo(21.0F, 14.7F);
      ((Path)localObject).lineTo(21.0F, 17.4F);
      ((Path)localObject).lineTo(16.752001F, 17.399F);
      ((Path)localObject).lineTo(16.32F, 21.0F);
      ((Path)localObject).lineTo(13.62F, 21.0F);
      ((Path)localObject).lineTo(14.052F, 17.399F);
      ((Path)localObject).lineTo(8.652F, 17.399F);
      ((Path)localObject).lineTo(8.22F, 21.0F);
      ((Path)localObject).lineTo(5.52F, 21.0F);
      ((Path)localObject).lineTo(5.952F, 17.399F);
      ((Path)localObject).lineTo(3.0F, 17.4F);
      ((Path)localObject).lineTo(3.0F, 14.7F);
      ((Path)localObject).lineTo(6.276F, 14.699F);
      ((Path)localObject).lineTo(6.924F, 9.299F);
      ((Path)localObject).lineTo(3.0F, 9.3F);
      ((Path)localObject).lineTo(3.0F, 6.6F);
      ((Path)localObject).lineTo(7.248F, 6.599F);
      ((Path)localObject).lineTo(7.68F, 3.0F);
      ((Path)localObject).lineTo(10.38F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.376F, 14.699F);
      ((Path)localObject).lineTo(15.024F, 9.299F);
      ((Path)localObject).lineTo(9.624F, 9.299F);
      ((Path)localObject).lineTo(8.976F, 14.699F);
      ((Path)localObject).lineTo(14.376F, 14.699F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bsq
 * JD-Core Version:    0.7.0.1
 */