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

public final class bbm
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
      localPaint.setColor(-436207616);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(17.25F, 13.5F);
      ((Path)localObject).lineTo(17.250641F, 18.628893F);
      ((Path)localObject).lineTo(19.68198F, 16.196699F);
      ((Path)localObject).lineTo(20.742641F, 17.257359F);
      ((Path)localObject).lineTo(17.56064F, 20.438892F);
      ((Path)localObject).lineTo(17.560659F, 20.439341F);
      ((Path)localObject).lineTo(16.853554F, 21.146446F);
      ((Path)localObject).cubicTo(16.658291F, 21.341709F, 16.341709F, 21.341709F, 16.146446F, 21.146446F);
      ((Path)localObject).lineTo(16.146446F, 21.146446F);
      ((Path)localObject).lineTo(12.25736F, 17.257359F);
      ((Path)localObject).lineTo(13.31802F, 16.196699F);
      ((Path)localObject).lineTo(15.750641F, 18.628893F);
      ((Path)localObject).lineTo(15.75F, 13.5F);
      ((Path)localObject).lineTo(17.25F, 13.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.25F, 15.0F);
      ((Path)localObject).lineTo(8.25F, 16.5F);
      ((Path)localObject).lineTo(6.75F, 16.5F);
      ((Path)localObject).lineTo(6.75F, 15.0F);
      ((Path)localObject).lineTo(8.25F, 15.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.25F, 12.0F);
      ((Path)localObject).lineTo(8.25F, 13.5F);
      ((Path)localObject).lineTo(6.75F, 13.5F);
      ((Path)localObject).lineTo(6.75F, 12.0F);
      ((Path)localObject).lineTo(8.25F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.25F, 10.5F);
      ((Path)localObject).lineTo(17.25F, 12.0F);
      ((Path)localObject).lineTo(15.75F, 12.0F);
      ((Path)localObject).lineTo(15.75F, 10.5F);
      ((Path)localObject).lineTo(17.25F, 10.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.853553F, 2.853553F);
      ((Path)localObject).lineTo(11.74264F, 6.742641F);
      ((Path)localObject).lineTo(10.68198F, 7.803301F);
      ((Path)localObject).lineTo(8.250641F, 5.371107F);
      ((Path)localObject).lineTo(8.25F, 10.5F);
      ((Path)localObject).lineTo(6.75F, 10.5F);
      ((Path)localObject).lineTo(6.750641F, 5.371107F);
      ((Path)localObject).lineTo(4.318019F, 7.803301F);
      ((Path)localObject).lineTo(3.257359F, 6.742641F);
      ((Path)localObject).lineTo(7.146447F, 2.853553F);
      ((Path)localObject).cubicTo(7.341709F, 2.658291F, 7.658291F, 2.658291F, 7.853553F, 2.853553F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.25F, 7.5F);
      ((Path)localObject).lineTo(17.25F, 9.0F);
      ((Path)localObject).lineTo(15.75F, 9.0F);
      ((Path)localObject).lineTo(15.75F, 7.5F);
      ((Path)localObject).lineTo(17.25F, 7.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbm
 * JD-Core Version:    0.7.0.1
 */