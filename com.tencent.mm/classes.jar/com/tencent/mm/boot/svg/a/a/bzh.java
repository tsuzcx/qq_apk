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

public final class bzh
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
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 204, 31);
      Paint localPaint2 = c.a(localPaint1, paramVarArgs);
      Paint localPaint3 = c.a((Paint)localObject, paramVarArgs);
      localPaint2.setColor(-2565928);
      localPaint3.setColor(-6842473);
      localPaint3.setStrokeWidth(1.2F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.6F, 0.6F);
      ((Path)localObject).lineTo(23.4F, 0.6F);
      ((Path)localObject).lineTo(23.4F, 23.4F);
      ((Path)localObject).lineTo(0.6F, 23.4F);
      ((Path)localObject).lineTo(0.6F, 0.6F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint3 = c.a(localPaint3, paramVarArgs);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.drawPath((Path)localObject, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-10197008);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(17.154173F, 4.5F);
      ((Path)localObject).cubicTo(18.491449F, 4.5F, 18.976379F, 4.639238F, 19.465269F, 4.900699F);
      ((Path)localObject).cubicTo(19.954157F, 5.16216F, 20.337841F, 5.545843F, 20.5993F, 6.034731F);
      ((Path)localObject).cubicTo(20.860762F, 6.52362F, 21.0F, 7.00855F, 21.0F, 8.345828F);
      ((Path)localObject).lineTo(21.0F, 15.654172F);
      ((Path)localObject).cubicTo(21.0F, 16.991449F, 20.860762F, 17.476379F, 20.5993F, 17.965269F);
      ((Path)localObject).cubicTo(20.337841F, 18.454157F, 19.954157F, 18.837841F, 19.465269F, 19.0993F);
      ((Path)localObject).cubicTo(18.976379F, 19.360762F, 18.491449F, 19.5F, 17.154173F, 19.5F);
      ((Path)localObject).lineTo(6.845828F, 19.5F);
      ((Path)localObject).cubicTo(5.50855F, 19.5F, 5.02362F, 19.360762F, 4.534731F, 19.0993F);
      ((Path)localObject).cubicTo(4.045843F, 18.837841F, 3.66216F, 18.454157F, 3.400699F, 17.965269F);
      ((Path)localObject).cubicTo(3.139238F, 17.476379F, 3.0F, 16.991449F, 3.0F, 15.654172F);
      ((Path)localObject).lineTo(3.0F, 8.345828F);
      ((Path)localObject).cubicTo(3.0F, 7.00855F, 3.139238F, 6.52362F, 3.400699F, 6.034731F);
      ((Path)localObject).cubicTo(3.66216F, 5.545843F, 4.045843F, 5.16216F, 4.534731F, 4.900699F);
      ((Path)localObject).cubicTo(5.02362F, 4.639238F, 5.50855F, 4.5F, 6.845828F, 4.5F);
      ((Path)localObject).lineTo(17.154173F, 4.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.804F, 7.92F);
      ((Path)localObject).cubicTo(10.47263F, 7.92F, 10.204F, 8.188629F, 10.204F, 8.520001F);
      ((Path)localObject).lineTo(10.204F, 8.520001F);
      ((Path)localObject).lineTo(10.204F, 15.48F);
      ((Path)localObject).cubicTo(10.204F, 15.811371F, 10.47263F, 16.08F, 10.804F, 16.08F);
      ((Path)localObject).cubicTo(11.135371F, 16.08F, 11.404F, 15.811371F, 11.404F, 15.48F);
      ((Path)localObject).lineTo(11.404F, 15.48F);
      ((Path)localObject).lineTo(11.404F, 8.520001F);
      ((Path)localObject).cubicTo(11.404F, 8.188629F, 11.135371F, 7.92F, 10.804F, 7.92F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.604F, 9.6F);
      ((Path)localObject).cubicTo(15.272629F, 9.6F, 15.004F, 9.86863F, 15.004F, 10.2F);
      ((Path)localObject).lineTo(15.004F, 10.2F);
      ((Path)localObject).lineTo(15.004F, 13.8F);
      ((Path)localObject).cubicTo(15.004F, 14.131371F, 15.272629F, 14.4F, 15.604F, 14.4F);
      ((Path)localObject).cubicTo(15.93537F, 14.4F, 16.204F, 14.131371F, 16.204F, 13.8F);
      ((Path)localObject).lineTo(16.204F, 13.8F);
      ((Path)localObject).lineTo(16.204F, 10.2F);
      ((Path)localObject).cubicTo(16.204F, 9.86863F, 15.93537F, 9.6F, 15.604F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.404F, 9.6F);
      ((Path)localObject).cubicTo(8.072629F, 9.6F, 7.804F, 9.86863F, 7.804F, 10.2F);
      ((Path)localObject).lineTo(7.804F, 10.2F);
      ((Path)localObject).lineTo(7.804F, 13.8F);
      ((Path)localObject).cubicTo(7.804F, 14.131371F, 8.072629F, 14.4F, 8.404F, 14.4F);
      ((Path)localObject).cubicTo(8.735371F, 14.4F, 9.004F, 14.131371F, 9.004F, 13.8F);
      ((Path)localObject).lineTo(9.004F, 13.8F);
      ((Path)localObject).lineTo(9.004F, 10.2F);
      ((Path)localObject).cubicTo(9.004F, 9.86863F, 8.735371F, 9.6F, 8.404F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.204F, 10.2F);
      ((Path)localObject).cubicTo(12.872629F, 10.2F, 12.604F, 10.468629F, 12.604F, 10.8F);
      ((Path)localObject).lineTo(12.604F, 10.8F);
      ((Path)localObject).lineTo(12.604F, 13.2F);
      ((Path)localObject).cubicTo(12.604F, 13.531371F, 12.872629F, 13.8F, 13.204F, 13.8F);
      ((Path)localObject).cubicTo(13.535371F, 13.8F, 13.804F, 13.531371F, 13.804F, 13.2F);
      ((Path)localObject).lineTo(13.804F, 13.2F);
      ((Path)localObject).lineTo(13.804F, 10.8F);
      ((Path)localObject).cubicTo(13.804F, 10.468629F, 13.535371F, 10.2F, 13.204F, 10.2F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bzh
 * JD-Core Version:    0.7.0.1
 */