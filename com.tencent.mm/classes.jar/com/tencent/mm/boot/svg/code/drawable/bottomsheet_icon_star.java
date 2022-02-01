package com.tencent.mm.boot.svg.code.drawable;

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

public class bottomsheet_icon_star
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-8683387);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(53.089928F, 45.616577F);
      ((Path)localObject2).lineTo(53.623455F, 47.162701F);
      ((Path)localObject2).cubicTo(53.623455F, 47.162701F, 53.01152F, 44.282021F, 54.975307F, 42.670761F);
      ((Path)localObject2).cubicTo(54.863106F, 42.752514F, 54.75811F, 42.829773F, 54.656723F, 42.905239F);
      ((Path)localObject2).lineTo(73.0F, 26.948959F);
      ((Path)localObject2).lineTo(48.666668F, 26.948959F);
      ((Path)localObject2).cubicTo(48.666668F, 26.948959F, 45.512344F, 26.898201F, 45.061729F, 24.253796F);
      ((Path)localObject2).cubicTo(45.0784F, 24.353516F, 45.093723F, 24.444702F, 45.109043F, 24.537237F);
      ((Path)localObject2).lineTo(36.420692F, 0.0F);
      ((Path)localObject2).lineTo(27.904024F, 24.459076F);
      ((Path)localObject2).cubicTo(27.915741F, 24.39035F, 27.926556F, 24.326115F, 27.938272F, 24.253796F);
      ((Path)localObject2).cubicTo(27.916191F, 24.383163F, 27.882845F, 24.501301F, 27.848598F, 24.61854F);
      ((Path)localObject2).lineTo(27.758926F, 24.875479F);
      ((Path)localObject2).cubicTo(26.960882F, 26.899998F, 24.333334F, 26.948959F, 24.333334F, 26.948959F);
      ((Path)localObject2).lineTo(0.0F, 26.948959F);
      ((Path)localObject2).lineTo(18.472155F, 43.11681F);
      ((Path)localObject2).cubicTo(19.523445F, 44.343559F, 19.512178F, 45.986263F, 19.435574F, 46.744949F);
      ((Path)localObject2).lineTo(11.566444F, 71.872879F);
      ((Path)localObject2).lineTo(34.679054F, 56.182972F);
      ((Path)localObject2).lineTo(34.246914F, 56.595779F);
      ((Path)localObject2).cubicTo(34.246914F, 56.595779F, 36.448177F, 54.918938F, 38.753086F, 56.595779F);
      ((Path)localObject2).cubicTo(38.745876F, 56.588593F, 38.740017F, 56.583202F, 38.732807F, 56.575569F);
      ((Path)localObject2).lineTo(61.149216F, 72.0F);
      ((Path)localObject2).lineTo(53.089928F, 45.616577F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_star
 * JD-Core Version:    0.7.0.1
 */