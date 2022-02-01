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

public final class brb
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-11962667);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.04F, 6.94F);
      localPath.cubicTo(8.881784E-016F, 2.86F, 4.0F, -0.44F, 7.99F, 0.0F);
      localPath.cubicTo(20.370001F, 0.04F, 32.75F, -0.07F, 45.119999F, 0.05F);
      localPath.cubicTo(48.709999F, 0.04F, 51.970001F, 3.27F, 51.939999F, 6.87F);
      localPath.cubicTo(52.119999F, 18.57F, 51.889999F, 30.280001F, 52.040001F, 41.990002F);
      localPath.cubicTo(46.029999F, 42.0F, 40.009998F, 42.009998F, 34.0F, 41.990002F);
      localPath.lineTo(34.0F, 36.0F);
      localPath.cubicTo(36.66F, 36.009998F, 39.330002F, 35.990002F, 42.0F, 36.0F);
      localPath.lineTo(42.0F, 26.0F);
      localPath.cubicTo(39.330002F, 26.01F, 36.650002F, 25.99F, 33.98F, 26.0F);
      localPath.cubicTo(33.98F, 23.98F, 33.91F, 21.940001F, 34.169998F, 19.93F);
      localPath.cubicTo(35.740002F, 17.24F, 39.43F, 18.280001F, 42.0F, 17.940001F);
      localPath.lineTo(42.0F, 8.01F);
      localPath.cubicTo(36.900002F, 8.270001F, 30.84F, 6.82F, 26.700001F, 10.63F);
      localPath.cubicTo(22.530001F, 14.63F, 24.4F, 20.889999F, 24.01F, 26.0F);
      localPath.lineTo(18.0F, 26.0F);
      localPath.lineTo(18.0F, 36.0F);
      localPath.lineTo(24.0F, 36.0F);
      localPath.cubicTo(24.0F, 38.0F, 23.99F, 39.990002F, 24.0F, 41.990002F);
      localPath.cubicTo(15.99F, 42.0F, 7.97F, 42.0F, -0.04F, 41.990002F);
      localPath.cubicTo(0.09F, 30.309999F, -0.1F, 18.620001F, 0.04F, 6.94F);
      localPath.lineTo(0.04F, 6.94F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-9398565);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 42.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(-0.04F, -0.01F);
      ((Path)localObject3).cubicTo(7.97F, 0.0F, 15.99F, 0.0F, 24.0F, -0.01F);
      ((Path)localObject3).lineTo(24.0F, 10.0F);
      ((Path)localObject3).cubicTo(17.690001F, 9.83F, 11.35F, 10.34F, 5.07F, 9.75F);
      ((Path)localObject3).cubicTo(0.85F, 8.58F, -0.57F, 3.92F, -0.04F, -0.01F);
      ((Path)localObject3).lineTo(-0.04F, -0.01F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(34.0F, -0.01F);
      ((Path)localObject2).cubicTo(40.009998F, 0.01F, 46.029999F, 0.0F, 52.040001F, -0.01F);
      ((Path)localObject2).cubicTo(52.549999F, 3.89F, 51.209999F, 8.51F, 47.029999F, 9.72F);
      ((Path)localObject2).cubicTo(42.720001F, 10.34F, 38.34F, 9.85F, 34.0F, 10.0F);
      ((Path)localObject2).lineTo(34.0F, -0.01F);
      ((Path)localObject2).lineTo(34.0F, -0.01F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.brb
 * JD-Core Version:    0.7.0.1
 */