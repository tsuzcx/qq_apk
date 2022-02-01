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

public final class bbd
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
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -189.0F, 0.0F, 1.0F, -177.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 189.0F, 0.0F, 1.0F, 177.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2147483648);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 36.0F);
      localPath.cubicTo(0.0F, 16.117748F, 16.117748F, 0.0F, 36.0F, 0.0F);
      localPath.lineTo(36.0F, 0.0F);
      localPath.cubicTo(55.882252F, 0.0F, 72.0F, 16.117748F, 72.0F, 36.0F);
      localPath.lineTo(72.0F, 36.0F);
      localPath.cubicTo(72.0F, 55.882252F, 55.882252F, 72.0F, 36.0F, 72.0F);
      localPath.lineTo(36.0F, 72.0F);
      localPath.cubicTo(16.117748F, 72.0F, 0.0F, 55.882252F, 0.0F, 36.0F);
      localPath.lineTo(0.0F, 36.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.962311F, 5.25F);
      ((Path)localObject2).lineTo(15.855F, 12.143F);
      ((Path)localObject2).lineTo(19.775F, 8.225F);
      ((Path)localObject2).cubicTo(20.475F, 7.525F, 21.525F, 7.525F, 22.225F, 8.225F);
      ((Path)localObject2).cubicTo(22.536112F, 8.536111F, 22.70895F, 8.847222F, 22.743519F, 9.281241F);
      ((Path)localObject2).lineTo(22.75F, 9.45F);
      ((Path)localObject2).lineTo(22.749001F, 19.037001F);
      ((Path)localObject2).lineTo(27.787701F, 24.074669F);
      ((Path)localObject2).cubicTo(28.266113F, 23.128498F, 28.525F, 22.064249F, 28.525F, 21.0F);
      ((Path)localObject2).cubicTo(28.525F, 19.25F, 27.825001F, 17.5F, 26.6F, 16.275F);
      ((Path)localObject2).lineTo(26.424999F, 16.1F);
      ((Path)localObject2).lineTo(28.35F, 14.175F);
      ((Path)localObject2).lineTo(28.525F, 14.35F);
      ((Path)localObject2).cubicTo(30.275F, 16.1F, 31.325001F, 18.549999F, 31.325001F, 21.0F);
      ((Path)localObject2).cubicTo(31.325001F, 22.783064F, 30.76885F, 24.566128F, 29.791471F, 26.079357F);
      ((Path)localObject2).lineTo(31.39971F, 27.685888F);
      ((Path)localObject2).cubicTo(32.778111F, 25.729305F, 33.424999F, 23.472467F, 33.424999F, 21.0F);
      ((Path)localObject2).cubicTo(33.424999F, 17.85F, 32.200001F, 15.05F, 30.1F, 12.775F);
      ((Path)localObject2).lineTo(29.924999F, 12.6F);
      ((Path)localObject2).lineTo(31.85F, 10.675F);
      ((Path)localObject2).lineTo(32.025002F, 10.85F);
      ((Path)localObject2).cubicTo(34.650002F, 13.475F, 36.224998F, 17.15F, 36.224998F, 21.0F);
      ((Path)localObject2).cubicTo(36.224998F, 24.184946F, 35.266899F, 27.130367F, 33.3507F, 29.638115F);
      ((Path)localObject2).lineTo(38.660797F, 34.948486F);
      ((Path)localObject2).lineTo(36.804642F, 36.804642F);
      ((Path)localObject2).lineTo(7.106155F, 7.106155F);
      ((Path)localObject2).lineTo(8.962311F, 5.25F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.162F, 14.875F);
      ((Path)localObject2).lineTo(22.749001F, 26.461F);
      ((Path)localObject2).lineTo(22.75F, 32.549999F);
      ((Path)localObject2).cubicTo(22.75F, 33.599998F, 22.049999F, 34.299999F, 21.0F, 34.299999F);
      ((Path)localObject2).cubicTo(20.533333F, 34.299999F, 20.204939F, 34.161728F, 19.891907F, 33.885185F);
      ((Path)localObject2).lineTo(19.775F, 33.775002F);
      ((Path)localObject2).lineTo(13.125F, 27.125F);
      ((Path)localObject2).lineTo(5.25F, 27.125F);
      ((Path)localObject2).cubicTo(4.2525F, 27.125F, 3.570875F, 26.49325F, 3.505206F, 25.529831F);
      ((Path)localObject2).lineTo(3.5F, 25.375F);
      ((Path)localObject2).lineTo(3.5F, 16.625F);
      ((Path)localObject2).cubicTo(3.5F, 15.6275F, 4.13175F, 14.945875F, 5.095169F, 14.880206F);
      ((Path)localObject2).lineTo(5.25F, 14.875F);
      ((Path)localObject2).lineTo(11.162F, 14.875F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbd
 * JD-Core Version:    0.7.0.1
 */