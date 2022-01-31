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

public final class aii
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
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
      localPaint.setColor(-8617594);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(76.321457F, 92.678543F);
      ((Path)localObject).cubicTo(84.117851F, 100.47494F, 91.505028F, 104.13172F, 94.236832F, 103.91758F);
      ((Path)localObject).cubicTo(96.968643F, 103.70344F, 103.77161F, 99.025032F, 106.98316F, 99.087303F);
      ((Path)localObject).cubicTo(108.52666F, 99.117226F, 118.61296F, 105.93859F, 119.83391F, 106.72726F);
      ((Path)localObject).cubicTo(121.05486F, 107.51591F, 122.18694F, 108.43717F, 121.97407F, 109.60293F);
      ((Path)localObject).cubicTo(121.7612F, 110.76868F, 117.32839F, 123.60948F, 106.01143F, 121.83133F);
      ((Path)localObject).cubicTo(94.694466F, 120.05317F, 78.917038F, 107.85329F, 69.926674F, 99.073326F);
      ((Path)localObject).lineTo(76.321457F, 92.678543F);
      ((Path)localObject).lineTo(76.321457F, 92.678543F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(76.321457F, 92.678543F);
      ((Path)localObject).cubicTo(68.525063F, 84.882149F, 64.868279F, 77.494972F, 65.08242F, 74.763168F);
      ((Path)localObject).cubicTo(65.296562F, 72.031357F, 69.974968F, 65.228394F, 69.912697F, 62.016838F);
      ((Path)localObject).cubicTo(69.882774F, 60.473339F, 63.061409F, 50.387039F, 62.272747F, 49.166092F);
      ((Path)localObject).cubicTo(61.484085F, 47.945145F, 60.562832F, 46.813057F, 59.397072F, 47.025928F);
      ((Path)localObject).cubicTo(58.231316F, 47.2388F, 45.390518F, 51.671612F, 47.168674F, 62.988571F);
      ((Path)localObject).cubicTo(48.946831F, 74.305534F, 61.146706F, 90.082962F, 69.926674F, 99.073326F);
      ((Path)localObject).lineTo(76.321457F, 92.678543F);
      ((Path)localObject).lineTo(76.321457F, 92.678543F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aii
 * JD-Core Version:    0.7.0.1
 */