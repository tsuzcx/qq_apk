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

public final class awc
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
      Object localObject1 = c.h(paramVarArgs);
      Object localObject3 = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localPaint.setStrokeWidth(4.5F);
      Object localObject4 = c.l(paramVarArgs);
      ((Path)localObject4).moveTo(7.25F, 23.25F);
      ((Path)localObject4).lineTo(40.75F, 23.25F);
      ((Path)localObject4).lineTo(40.75F, 65.75F);
      ((Path)localObject4).lineTo(7.25F, 65.75F);
      ((Path)localObject4).lineTo(7.25F, 23.25F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 32.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 1.0F);
      localPath.cubicTo(0.0F, 0.4477152F, 0.4477152F, -2.664535E-015F, 1.0F, -2.664535E-015F);
      localPath.lineTo(2.0F, -2.664535E-015F);
      localPath.cubicTo(2.552285F, -2.664535E-015F, 3.0F, 0.4477152F, 3.0F, 1.0F);
      localPath.lineTo(3.0F, 21.0F);
      localPath.cubicTo(3.0F, 21.552284F, 2.552285F, 22.0F, 2.0F, 22.0F);
      localPath.lineTo(1.0F, 22.0F);
      localPath.cubicTo(0.4477152F, 22.0F, 0.0F, 21.552284F, 0.0F, 21.0F);
      localPath.lineTo(0.0F, 1.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject4 = c.l(paramVarArgs);
      ((Path)localObject4).moveTo(11.998957F, -1.776357E-015F);
      ((Path)localObject4).cubicTo(11.447248F, -1.776357E-015F, 11.0F, 0.4394583F, 11.0F, 1.002462F);
      ((Path)localObject4).lineTo(11.0F, 20.997538F);
      ((Path)localObject4).cubicTo(11.0F, 21.551182F, 11.44266F, 22.0F, 11.998957F, 22.0F);
      ((Path)localObject4).lineTo(13.001043F, 22.0F);
      ((Path)localObject4).cubicTo(13.552752F, 22.0F, 14.0F, 21.560541F, 14.0F, 20.997538F);
      ((Path)localObject4).lineTo(14.0F, 1.002462F);
      ((Path)localObject4).cubicTo(14.0F, 0.4488174F, 13.55734F, -1.776357E-015F, 13.001043F, -1.776357E-015F);
      ((Path)localObject4).lineTo(11.998957F, -1.776357E-015F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      localObject4 = c.l(paramVarArgs);
      ((Path)localObject4).moveTo(0.0F, 22.0F);
      ((Path)localObject4).cubicTo(0.0F, 21.447716F, 0.4477152F, 21.0F, 1.0F, 21.0F);
      ((Path)localObject4).lineTo(47.0F, 21.0F);
      ((Path)localObject4).cubicTo(47.552284F, 21.0F, 48.0F, 21.447716F, 48.0F, 22.0F);
      ((Path)localObject4).lineTo(48.0F, 23.0F);
      ((Path)localObject4).cubicTo(48.0F, 23.552284F, 47.552284F, 24.0F, 47.0F, 24.0F);
      ((Path)localObject4).lineTo(1.0F, 24.0F);
      ((Path)localObject4).cubicTo(0.4477152F, 24.0F, 0.0F, 23.552284F, 0.0F, 23.0F);
      ((Path)localObject4).lineTo(0.0F, 22.0F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 0.9659258F, -0.258819F, 3.58819F, 0.258819F, 0.9659258F, -2.384186E-007F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(15.0F, 1.0F);
      ((Path)localObject3).cubicTo(15.0F, 0.4477152F, 15.447715F, -6.82121E-013F, 16.0F, -6.82121E-013F);
      ((Path)localObject3).lineTo(32.0F, -6.82121E-013F);
      ((Path)localObject3).cubicTo(32.552284F, -6.82121E-013F, 33.0F, 0.4477152F, 33.0F, 1.0F);
      ((Path)localObject3).lineTo(33.0F, 6.0F);
      ((Path)localObject3).cubicTo(33.0F, 6.552285F, 32.552284F, 7.0F, 32.0F, 7.0F);
      ((Path)localObject3).lineTo(16.0F, 7.0F);
      ((Path)localObject3).cubicTo(15.447715F, 7.0F, 15.0F, 6.552285F, 15.0F, 6.0F);
      ((Path)localObject3).lineTo(15.0F, 1.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(-4.547474E-013F, 7.0F);
      ((Path)localObject2).cubicTo(-4.547474E-013F, 6.447715F, 0.4477152F, 6.0F, 1.0F, 6.0F);
      ((Path)localObject2).lineTo(47.0F, 6.0F);
      ((Path)localObject2).cubicTo(47.552284F, 6.0F, 48.0F, 6.447715F, 48.0F, 7.0F);
      ((Path)localObject2).lineTo(48.0F, 9.0F);
      ((Path)localObject2).cubicTo(48.0F, 9.552285F, 47.552284F, 10.0F, 47.0F, 10.0F);
      ((Path)localObject2).lineTo(1.0F, 10.0F);
      ((Path)localObject2).cubicTo(0.4477152F, 10.0F, -4.547474E-013F, 9.552285F, -4.547474E-013F, 9.0F);
      ((Path)localObject2).lineTo(-4.547474E-013F, 7.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awc
 * JD-Core Version:    0.7.0.1
 */