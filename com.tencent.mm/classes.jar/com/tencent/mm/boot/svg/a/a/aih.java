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

public final class aih
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 50.0F, 0.0F, 1.0F, 38.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(12.770331F, 24.77644F);
      ((Path)localObject2).lineTo(7.357673F, 21.65144F);
      ((Path)localObject2).lineTo(4.84934F, 25.995998F);
      ((Path)localObject2).cubicTo(-3.688586F, 40.784119F, -0.6132603F, 59.150406F, 11.409091F, 69.634178F);
      ((Path)localObject2).lineTo(5.462961F, 79.933174F);
      ((Path)localObject2).lineTo(16.288279F, 86.183174F);
      ((Path)localObject2).lineTo(22.234409F, 75.884178F);
      ((Path)localObject2).lineTo(22.234409F, 75.884178F);
      ((Path)localObject2).cubicTo(37.324795F, 81.053955F, 54.768127F, 74.534119F, 63.306053F, 59.745998F);
      ((Path)localObject2).lineTo(65.814384F, 55.40144F);
      ((Path)localObject2).lineTo(60.40173F, 52.27644F);
      ((Path)localObject2).lineTo(57.893394F, 56.620998F);
      ((Path)localObject2).cubicTo(49.83918F, 70.571312F, 32.807831F, 75.446129F, 20.184023F, 68.157776F);
      ((Path)localObject2).cubicTo(6.501737F, 60.258301F, 2.207783F, 43.071308F, 10.261999F, 29.120998F);
      ((Path)localObject2).lineTo(12.770331F, 24.77644F);
      ((Path)localObject2).lineTo(12.770331F, 24.77644F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(57.279774F, 2.683821F);
      ((Path)localObject2).cubicTo(47.713924F, -2.839027F, 35.484741F, 0.4339245F, 29.959208F, 10.004432F);
      ((Path)localObject2).lineTo(16.459326F, 33.386913F);
      ((Path)localObject2).cubicTo(10.936446F, 42.95282F, 14.21182F, 55.18346F, 23.779776F, 60.707523F);
      ((Path)localObject2).cubicTo(33.345627F, 66.23037F, 45.574806F, 62.95742F, 51.100342F, 53.386913F);
      ((Path)localObject2).lineTo(64.600227F, 30.004431F);
      ((Path)localObject2).cubicTo(70.123108F, 20.438522F, 66.847733F, 8.207883F, 57.279774F, 2.683821F);
      ((Path)localObject2).lineTo(57.279774F, 2.683821F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.351049F, 83.597137F);
      ((Path)localObject2).cubicTo(4.272484F, 82.7733F, 4.790811F, 82.441483F, 5.514581F, 82.859352F);
      ((Path)localObject2).lineTo(13.728326F, 87.601563F);
      ((Path)localObject2).cubicTo(14.449492F, 88.017929F, 14.420938F, 88.635574F, 13.671152F, 88.978104F);
      ((Path)localObject2).lineTo(6.594831F, 92.210793F);
      ((Path)localObject2).cubicTo(5.842089F, 92.554672F, 5.167873F, 92.162354F, 5.089617F, 91.341759F);
      ((Path)localObject2).lineTo(4.351049F, 83.597137F);
      ((Path)localObject2).lineTo(4.351049F, 83.597137F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aih
 * JD-Core Version:    0.7.0.1
 */