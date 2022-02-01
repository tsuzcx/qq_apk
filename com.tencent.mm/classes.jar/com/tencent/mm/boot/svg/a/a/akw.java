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

public final class akw
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
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(10.999252F, 14.071F);
      ((Path)localObject).lineTo(8.464466F, 11.535534F);
      ((Path)localObject).lineTo(7.050252F, 12.949747F);
      ((Path)localObject).lineTo(11.646446F, 17.545942F);
      ((Path)localObject).cubicTo(11.820013F, 17.719507F, 12.089437F, 17.738792F, 12.284306F, 17.603798F);
      ((Path)localObject).lineTo(12.353554F, 17.545942F);
      ((Path)localObject).lineTo(16.949747F, 12.949747F);
      ((Path)localObject).lineTo(15.535534F, 11.535534F);
      ((Path)localObject).lineTo(12.999252F, 14.071F);
      ((Path)localObject).lineTo(13.0F, 6.0F);
      ((Path)localObject).lineTo(19.0F, 6.0F);
      ((Path)localObject).cubicTo(19.552284F, 6.0F, 20.0F, 6.447715F, 20.0F, 7.0F);
      ((Path)localObject).lineTo(20.0F, 20.5F);
      ((Path)localObject).cubicTo(20.0F, 21.052284F, 19.552284F, 21.5F, 19.0F, 21.5F);
      ((Path)localObject).lineTo(5.0F, 21.5F);
      ((Path)localObject).cubicTo(4.447715F, 21.5F, 4.0F, 21.052284F, 4.0F, 20.5F);
      ((Path)localObject).lineTo(4.0F, 7.0F);
      ((Path)localObject).cubicTo(4.0F, 6.447715F, 4.447715F, 6.0F, 5.0F, 6.0F);
      ((Path)localObject).lineTo(11.0F, 6.0F);
      ((Path)localObject).lineTo(11.0F, 2.0F);
      ((Path)localObject).lineTo(13.0F, 2.0F);
      ((Path)localObject).lineTo(13.0F, 6.25F);
      ((Path)localObject).lineTo(11.0F, 6.25F);
      ((Path)localObject).lineTo(10.999252F, 14.071F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.akw
 * JD-Core Version:    0.7.0.1
 */