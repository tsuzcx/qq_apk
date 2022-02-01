package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_filled_resume
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(65.484558F, 29.084822F);
      ((Path)localObject).cubicTo(69.772812F, 45.088806F, 60.275337F, 61.538914F, 44.271355F, 65.827171F);
      ((Path)localObject).cubicTo(28.26737F, 70.115425F, 11.817262F, 60.617947F, 7.529007F, 44.613964F);
      ((Path)localObject).cubicTo(7.119025F, 43.083889F, 6.831688F, 41.536167F, 6.666765F, 39.981419F);
      ((Path)localObject).lineTo(6.566021F, 38.814205F);
      ((Path)localObject).lineTo(12.55276F, 38.415512F);
      ((Path)localObject).cubicTo(12.656483F, 39.972984F, 12.913397F, 41.526562F, 13.324562F, 43.06105F);
      ((Path)localObject).cubicTo(16.755165F, 55.864239F, 29.915253F, 63.462215F, 42.718441F, 60.031612F);
      ((Path)localObject).cubicTo(55.521626F, 56.601009F, 63.119606F, 43.440922F, 59.689003F, 30.637737F);
      ((Path)localObject).cubicTo(56.2584F, 17.834551F, 43.098312F, 10.23657F, 30.295126F, 13.667174F);
      ((Path)localObject).cubicTo(25.014788F, 15.082036F, 20.494555F, 18.191107F, 17.312689F, 22.438446F);
      ((Path)localObject).lineTo(24.83942F, 23.362589F);
      ((Path)localObject).lineTo(24.108204F, 29.317867F);
      ((Path)localObject).lineTo(9.220013F, 27.489826F);
      ((Path)localObject).cubicTo(7.575508F, 27.287907F, 6.406062F, 25.791084F, 6.607982F, 24.14658F);
      ((Path)localObject).lineTo(8.436022F, 9.258388F);
      ((Path)localObject).lineTo(14.391299F, 9.989603F);
      ((Path)localObject).lineTo(13.449316F, 17.651854F);
      ((Path)localObject).cubicTo(17.356117F, 12.950658F, 22.648066F, 9.50454F, 28.74221F, 7.871619F);
      ((Path)localObject).cubicTo(44.746193F, 3.583365F, 61.196304F, 13.080839F, 65.484558F, 29.084822F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.0F, 21.0F);
      ((Path)localObject).lineTo(39.0F, 36.0F);
      ((Path)localObject).lineTo(54.0F, 36.0F);
      ((Path)localObject).lineTo(54.0F, 42.0F);
      ((Path)localObject).lineTo(33.0F, 42.0F);
      ((Path)localObject).lineTo(33.0F, 21.0F);
      ((Path)localObject).lineTo(39.0F, 21.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_resume
 * JD-Core Version:    0.7.0.1
 */