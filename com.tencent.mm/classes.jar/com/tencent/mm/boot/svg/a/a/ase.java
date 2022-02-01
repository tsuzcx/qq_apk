package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class ase
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.6F, 33.0F);
      ((Path)localObject2).lineTo(42.0F, 33.0F);
      ((Path)localObject2).lineTo(42.0F, 32.099998F);
      ((Path)localObject2).cubicTo(42.0F, 26.798067F, 46.029438F, 22.5F, 51.0F, 22.5F);
      ((Path)localObject2).cubicTo(53.026093F, 22.5F, 54.895809F, 23.214134F, 56.400002F, 24.419296F);
      ((Path)localObject2).lineTo(56.400002F, 3.6F);
      ((Path)localObject2).lineTo(3.6F, 3.6F);
      ((Path)localObject2).lineTo(3.6F, 33.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.6F, 36.599998F);
      ((Path)localObject2).lineTo(3.6F, 41.400002F);
      ((Path)localObject2).lineTo(36.0F, 41.400002F);
      ((Path)localObject2).lineTo(36.0F, 36.599998F);
      ((Path)localObject2).lineTo(3.6F, 36.599998F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(56.400002F, 33.0F);
      ((Path)localObject2).lineTo(56.400002F, 32.099998F);
      ((Path)localObject2).cubicTo(56.400002F, 28.736214F, 53.928551F, 26.1F, 51.0F, 26.1F);
      ((Path)localObject2).cubicTo(48.071449F, 26.1F, 45.599998F, 28.736214F, 45.599998F, 32.099998F);
      ((Path)localObject2).lineTo(45.599998F, 33.0F);
      ((Path)localObject2).lineTo(56.400002F, 33.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 52.5F);
      ((Path)localObject2).lineTo(20.090042F, 52.5F);
      ((Path)localObject2).cubicTo(19.926783F, 52.5F, 19.764618F, 52.473347F, 19.609945F, 52.421093F);
      ((Path)localObject2).cubicTo(18.825098F, 52.155941F, 18.403799F, 51.304752F, 18.668949F, 50.519901F);
      ((Path)localObject2).lineTo(20.533775F, 45.0F);
      ((Path)localObject2).lineTo(3.0F, 45.0F);
      ((Path)localObject2).cubicTo(1.343146F, 45.0F, -2.962303E-015F, 43.656853F, -2.220446E-016F, 42.0F);
      ((Path)localObject2).lineTo(4.440892E-016F, 3.0F);
      ((Path)localObject2).cubicTo(2.411831E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(57.0F, 0.0F);
      ((Path)localObject2).cubicTo(58.656853F, -3.043592E-016F, 60.0F, 1.343146F, 60.0F, 3.0F);
      ((Path)localObject2).lineTo(60.0F, 33.0F);
      ((Path)localObject2).lineTo(63.013809F, 33.0F);
      ((Path)localObject2).cubicTo(64.663033F, 33.0F, 66.0F, 34.340096F, 66.0F, 35.987827F);
      ((Path)localObject2).lineTo(66.0F, 52.512173F);
      ((Path)localObject2).cubicTo(66.0F, 54.162304F, 64.633003F, 55.5F, 63.013809F, 55.5F);
      ((Path)localObject2).lineTo(38.986191F, 55.5F);
      ((Path)localObject2).cubicTo(37.336964F, 55.5F, 36.0F, 54.159904F, 36.0F, 52.512173F);
      ((Path)localObject2).lineTo(36.0F, 52.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 44.999962F);
      ((Path)localObject2).lineTo(24.333679F, 44.999962F);
      ((Path)localObject2).lineTo(23.016104F, 48.900002F);
      ((Path)localObject2).lineTo(36.0F, 48.900002F);
      ((Path)localObject2).lineTo(36.0F, 44.999962F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(39.599998F, 51.900002F);
      ((Path)localObject2).lineTo(62.400002F, 51.900002F);
      ((Path)localObject2).lineTo(62.400002F, 36.599998F);
      ((Path)localObject2).lineTo(39.599998F, 36.599998F);
      ((Path)localObject2).lineTo(39.599998F, 51.900002F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ase
 * JD-Core Version:    0.7.0.1
 */