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

public final class afz
  extends c
{
  private final int height = 48;
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
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-10197008);
      Object localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(24.0F, 0.0F);
      ((Path)localObject3).cubicTo(37.254837F, 0.0F, 48.0F, 10.745165F, 48.0F, 24.0F);
      ((Path)localObject3).cubicTo(48.0F, 37.254837F, 37.254837F, 48.0F, 24.0F, 48.0F);
      ((Path)localObject3).cubicTo(10.745165F, 48.0F, 0.0F, 37.254837F, 0.0F, 24.0F);
      ((Path)localObject3).cubicTo(0.0F, 10.745165F, 10.745165F, 0.0F, 24.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localPaint1.setColor(-1);
      ((Paint)localObject2).setColor(-10197008);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localObject3 = c.a((Paint)localObject2, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 28.133333F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(5.333334F, 8.0F);
      localPath.cubicTo(5.333334F, 7.533333F, 5.666667F, 6.666667F, 7.0F, 6.666667F);
      localPath.cubicTo(8.333333F, 6.666667F, 8.666667F, 7.533333F, 8.666667F, 8.0F);
      localPath.cubicTo(8.666667F, 8.466666F, 8.666667F, 19.799999F, 8.666667F, 20.133333F);
      localPath.cubicTo(8.666667F, 20.466667F, 8.466666F, 21.466667F, 7.0F, 21.466667F);
      localPath.cubicTo(5.533333F, 21.466667F, 5.333334F, 20.466667F, 5.333334F, 20.133333F);
      localPath.cubicTo(5.333334F, 19.799999F, 5.333334F, 8.466666F, 5.333334F, 8.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localObject3 = c.a((Paint)localObject2, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 28.133333F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(23.333334F, 8.0F);
      localPath.cubicTo(23.333334F, 7.533333F, 23.666666F, 6.666667F, 25.0F, 6.666667F);
      localPath.cubicTo(26.333334F, 6.666667F, 26.666666F, 7.533333F, 26.666666F, 8.0F);
      localPath.cubicTo(26.666666F, 8.466666F, 26.666666F, 19.799999F, 26.666666F, 20.133333F);
      localPath.cubicTo(26.666666F, 20.466667F, 26.466667F, 21.466667F, 25.0F, 21.466667F);
      localPath.cubicTo(23.533333F, 21.466667F, 23.333334F, 20.466667F, 23.333334F, 20.133333F);
      localPath.cubicTo(23.333334F, 19.799999F, 23.333334F, 8.466666F, 23.333334F, 8.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localObject3 = c.a((Paint)localObject2, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 28.133333F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(14.4F, 5.333334F);
      ((Path)localObject1).cubicTo(14.4F, 4.866667F, 14.733334F, 4.0F, 16.066668F, 4.0F);
      ((Path)localObject1).cubicTo(17.4F, 4.0F, 17.733334F, 4.866667F, 17.733334F, 5.333334F);
      ((Path)localObject1).cubicTo(17.733334F, 5.8F, 17.733334F, 22.466667F, 17.733334F, 22.799999F);
      ((Path)localObject1).cubicTo(17.733334F, 23.133333F, 17.533333F, 24.133333F, 16.066668F, 24.133333F);
      ((Path)localObject1).cubicTo(14.6F, 24.133333F, 14.4F, 23.133333F, 14.4F, 22.799999F);
      ((Path)localObject1).cubicTo(14.4F, 22.466667F, 14.4F, 5.8F, 14.4F, 5.333334F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(7.0F, 25.333334F);
      ((Path)localObject2).cubicTo(8.288665F, 25.333334F, 9.333333F, 26.228764F, 9.333333F, 27.333334F);
      ((Path)localObject2).cubicTo(9.333333F, 28.437904F, 8.288665F, 29.333334F, 7.0F, 29.333334F);
      ((Path)localObject2).cubicTo(5.711336F, 29.333334F, 4.666667F, 28.437904F, 4.666667F, 27.333334F);
      ((Path)localObject2).cubicTo(4.666667F, 26.228764F, 5.711336F, 25.333334F, 7.0F, 25.333334F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.afz
 * JD-Core Version:    0.7.0.1
 */