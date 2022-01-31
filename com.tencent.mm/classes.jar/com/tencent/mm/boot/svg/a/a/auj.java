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

public final class auj
  extends c
{
  private final int height = 60;
  private final int width = 108;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localPaint1.setColor(-8534461);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 19.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(11.019414F, 3.995966F);
      ((Path)localObject2).cubicTo(27.591017F, -1.722831F, 46.265511F, -1.326381F, 62.484955F, 5.333986F);
      ((Path)localObject2).cubicTo(65.402847F, 6.54316F, 68.521973F, 8.347009F, 69.347031F, 11.587991F);
      ((Path)localObject2).cubicTo(70.634926F, 16.315662F, 69.809868F, 21.370405F, 68.662834F, 26.048519F);
      ((Path)localObject2).cubicTo(68.330795F, 26.286388F, 67.656662F, 26.762131F, 67.314568F, 27.0F);
      ((Path)localObject2).cubicTo(61.639774F, 26.276478F, 55.944859F, 25.384464F, 50.350559F, 24.205025F);
      ((Path)localObject2).cubicTo(48.680317F, 23.640083F, 49.123032F, 21.717299F, 49.424881F, 20.448658F);
      ((Path)localObject2).cubicTo(50.109077F, 17.554569F, 51.135368F, 14.749682F, 52.181786F, 11.964619F);
      ((Path)localObject2).cubicTo(46.335945F, 8.852483F, 39.534241F, 8.35692F, 33.02433F, 8.5155F);
      ((Path)localObject2).cubicTo(27.79225F, 8.674081F, 22.449493F, 9.45707F, 17.821115F, 11.994352F);
      ((Path)localObject2).cubicTo(19.068766F, 15.35427F, 20.447216F, 18.734009F, 20.879869F, 22.311974F);
      ((Path)localObject2).cubicTo(21.141474F, 24.175291F, 18.837347F, 24.47263F, 17.499142F, 24.720409F);
      ((Path)localObject2).cubicTo(12.538729F, 25.42411F, 7.628624F, 26.514349F, 2.638027F, 27.0F);
      ((Path)localObject2).cubicTo(0.7061819F, 26.246744F, 0.9376009F, 23.986977F, 0.5351332F, 22.35162F);
      ((Path)localObject2).cubicTo(-0.03838306F, 17.901463F, -0.772886F, 12.816987F, 2.034325F, 8.931773F);
      ((Path)localObject2).cubicTo(4.338452F, 6.305289F, 7.829858F, 5.195228F, 11.019414F, 3.995966F);
      ((Path)localObject2).lineTo(11.019414F, 3.995966F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.auj
 * JD-Core Version:    0.7.0.1
 */