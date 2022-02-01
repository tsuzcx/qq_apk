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

public final class bqy
  extends c
{
  private final int height = 44;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 44;
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
      localCanvas.saveLayerAlpha(null, 217, 31);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2928046);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(10.666615F, 0.0F);
      localPath.lineTo(12.372898F, 0.0F);
      localPath.cubicTo(20.305622F, 0.02008788F, 25.773712F, 9.732577F, 21.512991F, 16.52228F);
      localPath.cubicTo(17.801077F, 23.834269F, 6.156437F, 23.824224F, 2.464478F, 16.502193F);
      localPath.cubicTo(-1.556764F, 9.973632F, 3.20287F, 0.8738228F, 10.666615F, 0.0F);
      localPath.lineTo(10.666615F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-12537567);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 21.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(6.158603F, 2.137319F);
      localPath.cubicTo(12.047705F, -1.00158F, 20.032927F, 2.687126F, 21.580063F, 9.154857F);
      localPath.cubicTo(23.476555F, 15.432654F, 18.695402F, 22.130304F, 12.34715F, 23.0F);
      localPath.lineTo(9.921639F, 23.0F);
      localPath.cubicTo(4.64141F, 22.400211F, 0.359335F, 17.991756F, 0.0F, 12.673622F);
      localPath.lineTo(0.0F, 10.884251F);
      localPath.cubicTo(0.6188548F, 7.23553F, 2.714976F, 3.736758F, 6.158603F, 2.137319F);
      localPath.lineTo(6.158603F, 2.137319F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-2511616);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 25.0F, 0.0F, 1.0F, 21.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.069737F, 12.944695F);
      ((Path)localObject2).cubicTo(0.2700923F, 6.407746F, 6.477336F, 0.2206352F, 13.014434F, 1.080234F);
      ((Path)localObject2).cubicTo(18.142157F, 1.400085F, 22.220346F, 5.75805F, 23.0F, 10.70574F);
      ((Path)localObject2).lineTo(23.0F, 13.044648F);
      ((Path)localObject2).cubicTo(22.440248F, 18.152264F, 18.332073F, 22.260345F, 13.284314F, 23.0F);
      ((Path)localObject2).lineTo(11.015322F, 23.0F);
      ((Path)localObject2).cubicTo(5.877603F, 22.440262F, 1.3796F, 18.192245F, 1.069737F, 12.944695F);
      ((Path)localObject2).lineTo(1.069737F, 12.944695F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bqy
 * JD-Core Version:    0.7.0.1
 */