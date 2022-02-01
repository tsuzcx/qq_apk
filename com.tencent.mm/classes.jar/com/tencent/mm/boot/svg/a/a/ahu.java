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

public final class ahu
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      ((Path)localObject).moveTo(41.0F, 8.0F);
      ((Path)localObject).cubicTo(42.656853F, 8.0F, 44.0F, 9.343145F, 44.0F, 11.0F);
      ((Path)localObject).lineTo(44.0F, 35.0F);
      ((Path)localObject).cubicTo(44.0F, 36.656853F, 42.656853F, 38.0F, 41.0F, 38.0F);
      ((Path)localObject).lineTo(22.0F, 38.0F);
      ((Path)localObject).lineTo(17.414213F, 42.585785F);
      ((Path)localObject).cubicTo(16.633165F, 43.366837F, 15.366835F, 43.366837F, 14.585787F, 42.585785F);
      ((Path)localObject).cubicTo(14.210713F, 42.210712F, 14.0F, 41.702007F, 14.0F, 41.171574F);
      ((Path)localObject).lineTo(14.0F, 38.0F);
      ((Path)localObject).lineTo(7.0F, 38.0F);
      ((Path)localObject).cubicTo(5.343146F, 38.0F, 4.0F, 36.656853F, 4.0F, 35.0F);
      ((Path)localObject).lineTo(4.0F, 11.0F);
      ((Path)localObject).cubicTo(4.0F, 9.343145F, 5.343146F, 8.0F, 7.0F, 8.0F);
      ((Path)localObject).lineTo(41.0F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(41.0F, 10.4F);
      ((Path)localObject).lineTo(7.0F, 10.4F);
      ((Path)localObject).cubicTo(6.668629F, 10.4F, 6.4F, 10.66863F, 6.4F, 11.0F);
      ((Path)localObject).lineTo(6.4F, 35.0F);
      ((Path)localObject).cubicTo(6.4F, 35.331371F, 6.668629F, 35.599998F, 7.0F, 35.599998F);
      ((Path)localObject).lineTo(16.4F, 35.599998F);
      ((Path)localObject).lineTo(16.4F, 40.205887F);
      ((Path)localObject).lineTo(21.005888F, 35.599998F);
      ((Path)localObject).lineTo(41.0F, 35.599998F);
      ((Path)localObject).cubicTo(41.331371F, 35.599998F, 41.599998F, 35.331371F, 41.599998F, 35.0F);
      ((Path)localObject).lineTo(41.599998F, 11.0F);
      ((Path)localObject).cubicTo(41.599998F, 10.66863F, 41.331371F, 10.4F, 41.0F, 10.4F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.973389F, 26.133495F);
      ((Path)localObject).lineTo(33.973389F, 28.533497F);
      ((Path)localObject).lineTo(13.973389F, 28.533497F);
      ((Path)localObject).lineTo(13.973389F, 26.133495F);
      ((Path)localObject).lineTo(33.973389F, 26.133495F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.973389F, 17.133495F);
      ((Path)localObject).lineTo(33.973389F, 19.533497F);
      ((Path)localObject).lineTo(13.973389F, 19.533497F);
      ((Path)localObject).lineTo(13.973389F, 17.133495F);
      ((Path)localObject).lineTo(33.973389F, 17.133495F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahu
 * JD-Core Version:    0.7.0.1
 */