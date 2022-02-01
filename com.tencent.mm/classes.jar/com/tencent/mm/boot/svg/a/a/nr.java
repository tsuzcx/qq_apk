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

public final class nr
  extends c
{
  private final int height = 102;
  private final int width = 102;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 102;
      return 102;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(51.0F, 102.0F);
      localPath.cubicTo(79.166519F, 102.0F, 102.0F, 79.166519F, 102.0F, 51.0F);
      localPath.cubicTo(102.0F, 22.833477F, 79.166519F, 0.0F, 51.0F, 0.0F);
      localPath.cubicTo(22.833477F, 0.0F, 0.0F, 22.833477F, 0.0F, 51.0F);
      localPath.cubicTo(0.0F, 79.166519F, 22.833477F, 102.0F, 51.0F, 102.0F);
      localPath.close();
      localPath.moveTo(51.0F, 98.0F);
      localPath.cubicTo(76.957382F, 98.0F, 98.0F, 76.957382F, 98.0F, 51.0F);
      localPath.cubicTo(98.0F, 25.042616F, 76.957382F, 4.0F, 51.0F, 4.0F);
      localPath.cubicTo(25.042616F, 4.0F, 4.0F, 25.042616F, 4.0F, 51.0F);
      localPath.cubicTo(4.0F, 76.957382F, 25.042616F, 98.0F, 51.0F, 98.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.65625F, 0.0F, 1.0F, 21.515625F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.878576F, 23.757034F);
      ((Path)localObject2).cubicTo(1.297392F, 23.163979F, 1.223493F, 22.150276F, 1.725052F, 21.477392F);
      ((Path)localObject2).lineTo(3.063973F, 19.681114F);
      ((Path)localObject2).cubicTo(3.560368F, 19.015158F, 4.494505F, 18.877115F, 5.162043F, 19.381565F);
      ((Path)localObject2).lineTo(18.21077F, 29.242313F);
      ((Path)localObject2).cubicTo(18.873106F, 29.742832F, 19.922352F, 29.727772F, 20.574799F, 29.191858F);
      ((Path)localObject2).lineTo(54.486485F, 1.337144F);
      ((Path)localObject2).cubicTo(55.129768F, 0.8087597F, 56.127621F, 0.8442794F, 56.730663F, 1.431485F);
      ((Path)localObject2).lineTo(57.708359F, 2.383506F);
      ((Path)localObject2).cubicTo(58.304504F, 2.963994F, 58.304089F, 3.903913F, 57.714062F, 4.476437F);
      ((Path)localObject2).lineTo(20.482594F, 40.603558F);
      ((Path)localObject2).cubicTo(19.889599F, 41.178963F, 18.940239F, 41.167206F, 18.356556F, 40.571602F);
      ((Path)localObject2).lineTo(1.878576F, 23.757034F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.nr
 * JD-Core Version:    0.7.0.1
 */