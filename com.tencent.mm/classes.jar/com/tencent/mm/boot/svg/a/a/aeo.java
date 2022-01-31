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

public final class aeo
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
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(59.3675F, 24.311686F);
      ((Path)localObject).lineTo(28.040222F, 43.051979F);
      ((Path)localObject).lineTo(27.820826F, 43.181679F);
      ((Path)localObject).cubicTo(27.549904F, 43.319855F, 27.244909F, 43.401234F, 26.921633F, 43.401234F);
      ((Path)localObject).cubicTo(26.171196F, 43.401234F, 25.518824F, 42.979923F, 25.176432F, 42.357704F);
      ((Path)localObject).lineTo(25.045958F, 42.06609F);
      ((Path)localObject).lineTo(19.583479F, 29.840412F);
      ((Path)localObject).cubicTo(19.524475F, 29.707321F, 19.487907F, 29.556429F, 19.487907F, 29.409775F);
      ((Path)localObject).cubicTo(19.487907F, 28.846895F, 19.935843F, 28.390827F, 20.487659F, 28.390827F);
      ((Path)localObject).cubicTo(20.713703F, 28.390827F, 20.918972F, 28.466274F, 21.086845F, 28.59343F);
      ((Path)localObject).lineTo(27.531622F, 33.27364F);
      ((Path)localObject).cubicTo(28.001163F, 33.587292F, 28.565445F, 33.772095F, 29.170448F, 33.772095F);
      ((Path)localObject).cubicTo(29.530293F, 33.772095F, 29.875177F, 33.704277F, 30.195129F, 33.584747F);
      ((Path)localObject).lineTo(57.22311F, 21.483917F);
      ((Path)localObject).cubicTo(52.433365F, 16.118635F, 44.747562F, 12.6F, 36.0F, 12.6F);
      ((Path)localObject).cubicTo(21.301022F, 12.6F, 9.6F, 22.535152F, 9.6F, 34.472527F);
      ((Path)localObject).cubicTo(9.6F, 40.746346F, 12.826998F, 46.636932F, 18.443596F, 50.791683F);
      ((Path)localObject).lineTo(20.152246F, 52.055618F);
      ((Path)localObject).lineTo(19.368248F, 57.928364F);
      ((Path)localObject).lineTo(26.002657F, 54.750523F);
      ((Path)localObject).lineTo(27.320723F, 55.131802F);
      ((Path)localObject).cubicTo(30.084929F, 55.931404F, 33.006275F, 56.345051F, 36.0F, 56.345051F);
      ((Path)localObject).cubicTo(50.698978F, 56.345051F, 62.400002F, 46.409901F, 62.400002F, 34.472527F);
      ((Path)localObject).cubicTo(62.400002F, 30.822855F, 61.306259F, 27.360338F, 59.3675F, 24.311686F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 59.945053F);
      ((Path)localObject).cubicTo(32.613049F, 59.945053F, 29.357191F, 59.468487F, 26.320362F, 58.590019F);
      ((Path)localObject).lineTo(17.421125F, 62.852699F);
      ((Path)localObject).cubicTo(17.157927F, 62.978771F, 16.863625F, 63.025394F, 16.574291F, 62.986851F);
      ((Path)localObject).cubicTo(15.753134F, 62.877464F, 15.176225F, 62.123825F, 15.285729F, 61.303555F);
      ((Path)localObject).lineTo(16.302671F, 53.68589F);
      ((Path)localObject).cubicTo(9.989763F, 49.01606F, 6.0F, 42.139908F, 6.0F, 34.472527F);
      ((Path)localObject).cubicTo(6.0F, 20.404438F, 19.431458F, 9.0F, 36.0F, 9.0F);
      ((Path)localObject).cubicTo(52.568542F, 9.0F, 66.0F, 20.404438F, 66.0F, 34.472527F);
      ((Path)localObject).cubicTo(66.0F, 48.540615F, 52.568542F, 59.945053F, 36.0F, 59.945053F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aeo
 * JD-Core Version:    0.7.0.1
 */