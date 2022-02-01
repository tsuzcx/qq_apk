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

public final class as
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -3.0F, 0.0F, 1.0F, -3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-855310);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(36.0F, 0.0F);
      ((Path)localObject2).cubicTo(55.882252F, 0.0F, 72.0F, 16.117748F, 72.0F, 36.0F);
      ((Path)localObject2).cubicTo(72.0F, 55.882252F, 55.882252F, 72.0F, 36.0F, 72.0F);
      ((Path)localObject2).cubicTo(16.117748F, 72.0F, 0.0F, 55.882252F, 0.0F, 36.0F);
      ((Path)localObject2).cubicTo(0.0F, 16.117748F, 16.117748F, 0.0F, 36.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3355444);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(46.47831F, 37.814087F);
      ((Path)localObject1).cubicTo(46.420712F, 37.830936F, 46.363693F, 37.848957F, 46.30571F, 37.864826F);
      ((Path)localObject1).cubicTo(45.952164F, 37.966301F, 45.5895F, 38.028397F, 45.230137F, 38.028397F);
      ((Path)localObject1).cubicTo(43.644321F, 38.028397F, 42.748917F, 36.946468F, 43.229877F, 35.611637F);
      ((Path)localObject1).cubicTo(43.58168F, 34.63549F, 44.505203F, 33.811554F, 45.632362F, 33.430145F);
      ((Path)localObject1).cubicTo(47.379341F, 32.786633F, 48.599976F, 31.318983F, 48.599976F, 29.611168F);
      ((Path)localObject1).cubicTo(48.599976F, 27.309984F, 46.383671F, 25.444473F, 43.649944F, 25.444473F);
      ((Path)localObject1).cubicTo(40.916027F, 25.444473F, 38.699917F, 27.309984F, 38.699917F, 29.611168F);
      ((Path)localObject1).lineTo(38.699917F, 42.38903F);
      ((Path)localObject1).cubicTo(38.699917F, 45.46204F, 36.937229F, 48.156776F, 34.299889F, 49.68084F);
      ((Path)localObject1).cubicTo(32.86224F, 50.511631F, 31.168789F, 51.0F, 29.350056F, 51.0F);
      ((Path)localObject1).cubicTo(24.19426F, 51.0F, 20.0F, 47.137138F, 20.0F, 42.38903F);
      ((Path)localObject1).cubicTo(20.0F, 40.877697F, 20.427824F, 39.458237F, 21.173315F, 38.222336F);
      ((Path)localObject1).cubicTo(22.327042F, 36.309612F, 24.249531F, 34.844902F, 26.552137F, 34.177097F);
      ((Path)localObject1).cubicTo(26.554075F, 34.17651F, 26.55582F, 34.175922F, 26.55776F, 34.175331F);
      ((Path)localObject1).cubicTo(26.946022F, 34.053291F, 27.348633F, 33.985512F, 27.745621F, 33.985512F);
      ((Path)localObject1).cubicTo(29.338419F, 33.985512F, 30.238089F, 35.072533F, 29.754993F, 36.413242F);
      ((Path)localObject1).cubicTo(29.427629F, 37.321804F, 28.545996F, 38.10421F, 27.518133F, 38.520489F);
      ((Path)localObject1).cubicTo(27.39537F, 38.561821F, 27.275908F, 38.60825F, 27.157993F, 38.657223F);
      ((Path)localObject1).cubicTo(25.525244F, 39.338154F, 24.400026F, 40.751148F, 24.400026F, 42.38903F);
      ((Path)localObject1).cubicTo(24.400026F, 44.690212F, 26.616135F, 46.555527F, 29.350056F, 46.555527F);
      ((Path)localObject1).cubicTo(32.083782F, 46.555527F, 34.299889F, 44.690212F, 34.299889F, 42.38903F);
      ((Path)localObject1).lineTo(34.299889F, 29.611168F);
      ((Path)localObject1).cubicTo(34.299889F, 26.537962F, 36.062382F, 23.84342F, 38.699917F, 22.319159F);
      ((Path)localObject1).cubicTo(40.137566F, 21.488367F, 41.831017F, 21.0F, 43.649944F, 21.0F);
      ((Path)localObject1).cubicTo(48.805546F, 21.0F, 53.0F, 24.86286F, 53.0F, 29.611168F);
      ((Path)localObject1).cubicTo(53.0F, 31.122305F, 52.571983F, 32.541958F, 51.826492F, 33.777863F);
      ((Path)localObject1).cubicTo(50.677807F, 35.682159F, 48.767147F, 37.141972F, 46.47831F, 37.814087F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.as
 * JD-Core Version:    0.7.0.1
 */