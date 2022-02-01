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

public class finder_olympics_star
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 32.313709F, 0.7071068F, 0.7071068F, -13.384777F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(32.313709F, 43.813709F);
      ((Path)localObject).lineTo(21.314384F, 47.035336F);
      ((Path)localObject).cubicTo(19.724329F, 47.501053F, 18.057796F, 46.589596F, 17.592081F, 44.999542F);
      ((Path)localObject).cubicTo(17.430813F, 44.448936F, 17.430813F, 43.863636F, 17.592081F, 43.313034F);
      ((Path)localObject).lineTo(20.813709F, 32.313709F);
      ((Path)localObject).lineTo(20.813709F, 32.313709F);
      ((Path)localObject).lineTo(17.592081F, 21.314384F);
      ((Path)localObject).cubicTo(17.126364F, 19.724329F, 18.037821F, 18.057796F, 19.627876F, 17.592081F);
      ((Path)localObject).cubicTo(20.17848F, 17.430813F, 20.763781F, 17.430813F, 21.314384F, 17.592081F);
      ((Path)localObject).lineTo(32.313709F, 20.813709F);
      ((Path)localObject).lineTo(32.313709F, 20.813709F);
      ((Path)localObject).lineTo(43.313034F, 17.592081F);
      ((Path)localObject).cubicTo(44.903088F, 17.126364F, 46.569618F, 18.037821F, 47.035336F, 19.627876F);
      ((Path)localObject).cubicTo(47.196606F, 20.17848F, 47.196606F, 20.763781F, 47.035336F, 21.314384F);
      ((Path)localObject).lineTo(43.813709F, 32.313709F);
      ((Path)localObject).lineTo(43.813709F, 32.313709F);
      ((Path)localObject).lineTo(47.035336F, 43.313034F);
      ((Path)localObject).cubicTo(47.501053F, 44.903088F, 46.589596F, 46.569618F, 44.999542F, 47.035336F);
      ((Path)localObject).cubicTo(44.448936F, 47.196606F, 43.863636F, 47.196606F, 43.313034F, 47.035336F);
      ((Path)localObject).lineTo(32.313709F, 43.813709F);
      ((Path)localObject).lineTo(32.313709F, 43.813709F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_olympics_star
 * JD-Core Version:    0.7.0.1
 */