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

public final class ke
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
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
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-8617851);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(32.905201F, 39.858799F);
      ((Path)localObject2).cubicTo(33.5872F, 40.153049F, 34.106949F, 39.579674F, 34.364075F, 39.163048F);
      ((Path)localObject2).lineTo(35.824326F, 37.079922F);
      ((Path)localObject2).cubicTo(36.377075F, 36.140797F, 36.22995F, 35.869923F, 35.824326F, 35.689796F);
      ((Path)localObject2).cubicTo(35.252327F, 35.435425F, 35.054325F, 35.578423F, 34.364075F, 36.384174F);
      ((Path)localObject2).lineTo(32.905201F, 38.470047F);
      ((Path)localObject2).cubicTo(32.649448F, 38.882549F, 32.496826F, 39.681423F, 32.905201F, 39.858799F);
      ((Path)localObject2).lineTo(32.905201F, 39.858799F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(46.660702F, 39.015923F);
      ((Path)localObject2).cubicTo(48.523827F, 42.023048F, 46.255074F, 46.432674F, 42.103951F, 46.478046F);
      ((Path)localObject2).cubicTo(37.885448F, 46.522049F, 30.714825F, 39.858799F, 30.714825F, 39.858799F);
      ((Path)localObject2).lineTo(34.364075F, 32.910923F);
      ((Path)localObject2).cubicTo(34.364075F, 32.910923F, 44.772823F, 35.967548F, 46.660702F, 39.015923F);
      ((Path)localObject2).lineTo(46.660702F, 39.015923F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(42.3927F, 19.708174F);
      ((Path)localObject2).cubicTo(45.130325F, 24.813547F, 44.440075F, 29.763548F, 43.121449F, 34.301048F);
      ((Path)localObject2).cubicTo(41.188202F, 33.163921F, 40.485577F, 32.631798F, 39.472198F, 32.215172F);
      ((Path)localObject2).cubicTo(39.855824F, 30.103172F, 39.436451F, 29.568298F, 38.74345F, 26.656048F);
      ((Path)localObject2).cubicTo(37.273575F, 20.468548F, 29.613451F, 16.426048F, 21.958826F, 17.623672F);
      ((Path)localObject2).cubicTo(14.11445F, 18.851547F, 10.813075F, 27.984299F, 12.6707F, 35.219547F);
      ((Path)localObject2).cubicTo(14.39495F, 41.929546F, 17.600075F, 45.615921F, 24.147825F, 48.196796F);
      ((Path)localObject2).cubicTo(24.147825F, 48.196796F, 25.239574F, 50.983921F, 26.3382F, 53.060173F);
      ((Path)localObject2).cubicTo(27.425825F, 55.118549F, 29.257326F, 57.229172F, 29.257326F, 57.229172F);
      ((Path)localObject2).cubicTo(24.162951F, 56.829048F, 9.15895F, 50.127296F, 3.4307F, 40.516048F);
      ((Path)localObject2).cubicTo(-2.2948F, 30.904799F, -1.2443F, 18.309797F, 9.553576F, 11.368798F);
      ((Path)localObject2).cubicTo(20.422951F, 4.386548F, 36.872074F, 9.410798F, 42.3927F, 19.708174F);
      ((Path)localObject2).lineTo(42.3927F, 19.708174F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(52.619949F, 11.374298F);
      ((Path)localObject2).cubicTo(48.230949F, 14.465298F, 45.361324F, 18.084297F, 43.851574F, 21.794048F);
      ((Path)localObject2).cubicTo(42.831326F, 17.757048F, 40.25045F, 14.191673F, 36.553074F, 12.065923F);
      ((Path)localObject2).cubicTo(41.01495F, 4.948923F, 46.541077F, 2.116423F, 53.3377F, 0.9490479F);
      ((Path)localObject2).cubicTo(58.103451F, 1.796048F, 64.212578F, 2.900173F, 67.931953F, 5.812423F);
      ((Path)localObject2).cubicTo(63.604824F, 5.919673F, 58.500824F, 7.235548F, 52.619949F, 11.374298F);
      ((Path)localObject2).lineTo(52.619949F, 11.374298F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(76.689323F, 47.502422F);
      ((Path)localObject2).cubicTo(63.804199F, 59.665672F, 57.090076F, 65.93705F, 50.418575F, 75.296677F);
      ((Path)localObject2).cubicTo(49.258076F, 72.314301F, 46.985199F, 71.445297F, 46.0392F, 69.044548F);
      ((Path)localObject2).cubicTo(45.098701F, 66.645172F, 46.329327F, 64.926422F, 46.0392F, 63.485424F);
      ((Path)localObject2).cubicTo(45.75045F, 62.045799F, 44.389198F, 60.316048F, 43.120075F, 60.010799F);
      ((Path)localObject2).cubicTo(53.559074F, 46.021549F, 73.639572F, 39.956425F, 75.960579F, 22.488422F);
      ((Path)localObject2).cubicTo(78.080826F, 6.521923F, 65.395073F, 1.918423F, 54.796574F, 0.2532979F);
      ((Path)localObject2).cubicTo(68.315575F, -1.165702F, 79.491577F, 3.396548F, 84.717949F, 13.456048F);
      ((Path)localObject2).cubicTo(89.193573F, 22.080048F, 89.458954F, 35.451923F, 76.689323F, 47.502422F);
      ((Path)localObject2).lineTo(76.689323F, 47.502422F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ke
 * JD-Core Version:    0.7.0.1
 */