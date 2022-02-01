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

public final class aij
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
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(48.0F, 0.0F);
      ((Path)localObject2).lineTo(48.0F, 48.0F);
      ((Path)localObject2).lineTo(0.0F, 48.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 6.123234E-017F, -1.0F, 48.0F, 1.0F, 6.123234E-017F, -1.469576E-015F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(24.859856F, 9.448176F);
      ((Path)localObject1).lineTo(42.103119F, 38.48946F);
      ((Path)localObject1).cubicTo(42.385082F, 38.964344F, 42.228687F, 39.577892F, 41.753803F, 39.859856F);
      ((Path)localObject1).cubicTo(41.599304F, 39.951588F, 41.422943F, 40.0F, 41.243263F, 40.0F);
      ((Path)localObject1).lineTo(6.756737F, 40.0F);
      ((Path)localObject1).cubicTo(6.204453F, 40.0F, 5.756737F, 39.552284F, 5.756737F, 39.0F);
      ((Path)localObject1).cubicTo(5.756737F, 38.82032F, 5.805149F, 38.643959F, 5.896883F, 38.48946F);
      ((Path)localObject1).lineTo(23.140144F, 9.448176F);
      ((Path)localObject1).cubicTo(23.422108F, 8.973291F, 24.035654F, 8.816897F, 24.510538F, 9.098861F);
      ((Path)localObject1).cubicTo(24.654358F, 9.184254F, 24.774462F, 9.304357F, 24.859856F, 9.448176F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aij
 * JD-Core Version:    0.7.0.1
 */