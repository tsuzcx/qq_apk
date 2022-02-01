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

public final class ajq
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      localObject2 = c.a((float[])localObject2, -0.7071068F, -0.7071068F, 16.485281F, 0.7071068F, -0.7071068F, 8.666666F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(9.212483F, 8.421594F);
      ((Path)localObject2).cubicTo(9.089102F, 8.380463F, 9.037693F, 8.401029F, 8.924594F, 8.462725F);
      ((Path)localObject2).cubicTo(8.554449F, 8.668381F, 7.649652F, 9.161954F, 7.114998F, 9.439589F);
      ((Path)localObject2).cubicTo(6.981335F, 9.511568F, 6.83739F, 9.552699F, 6.672882F, 9.552699F);
      ((Path)localObject2).cubicTo(6.498091F, 9.552699F, 6.343864F, 9.501286F, 6.210201F, 9.419024F);
      ((Path)localObject2).cubicTo(5.459631F, 8.976864F, 4.750187F, 8.462725F, 4.143561F, 7.845758F);
      ((Path)localObject2).cubicTo(3.536936F, 7.239075F, 3.022846F, 6.529563F, 2.580729F, 5.77892F);
      ((Path)localObject2).cubicTo(2.498475F, 5.645244F, 2.447066F, 5.48072F, 2.447066F, 5.316196F);
      ((Path)localObject2).cubicTo(2.447066F, 5.161954F, 2.488193F, 5.007712F, 2.560166F, 4.874036F);
      ((Path)localObject2).cubicTo(2.837774F, 4.329049F, 3.3313F, 3.424165F, 3.536936F, 3.064267F);
      ((Path)localObject2).cubicTo(3.598626F, 2.951157F, 3.61919F, 2.88946F, 3.578063F, 2.77635F);
      ((Path)localObject2).lineTo(2.704111F, 0.4524422F);
      ((Path)localObject2).cubicTo(2.591011F, 0.18509F, 2.333966F, 0.01028278F, 2.025513F, 0.0F);
      ((Path)localObject2).cubicTo(1.902131F, 0.0F, 1.758186F, 0.05141388F, 1.727341F, 0.0616967F);
      ((Path)localObject2).cubicTo(0.7197253F, 0.431877F, 0.0F, 1.388175F, 0.0F, 2.51928F);
      ((Path)localObject2).cubicTo(0.0F, 2.838046F, 0.0822543F, 3.136247F, 0.09253611F, 3.208226F);
      ((Path)localObject2).cubicTo(0.586062F, 5.367609F, 1.686214F, 7.290488F, 3.197637F, 8.802056F);
      ((Path)localObject2).cubicTo(4.70906F, 10.313624F, 6.631754F, 11.413881F, 8.790931F, 11.907455F);
      ((Path)localObject2).cubicTo(8.862903F, 11.92802F, 9.161075F, 12.0F, 9.47981F, 12.0F);
      ((Path)localObject2).cubicTo(10.610807F, 12.0F, 11.567014F, 11.280206F, 11.937158F, 10.272493F);
      ((Path)localObject2).cubicTo(11.94744F, 10.241645F, 12.00913F, 10.097687F, 11.998849F, 9.974293F);
      ((Path)localObject2).cubicTo(11.978285F, 9.66581F, 11.803494F, 9.40874F, 11.536168F, 9.29563F);
      ((Path)localObject2).lineTo(9.212483F, 8.421594F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajq
 * JD-Core Version:    0.7.0.1
 */