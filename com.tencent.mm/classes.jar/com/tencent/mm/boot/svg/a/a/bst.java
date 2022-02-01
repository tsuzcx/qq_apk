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

public final class bst
  extends c
{
  private final int height = 131;
  private final int width = 131;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 131;
      return 131;
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 28.0F, 0.0F, 1.0F, 28.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 2.777778F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Paint localPaint2 = c.a((Paint)localObject2, paramVarArgs);
      localPaint2.setColor(-14494688);
      localPaint2.setStrokeWidth(4.166667F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(22.242647F, 9.672728F);
      localPath.lineTo(6.25F, 9.672728F);
      localPath.cubicTo(2.79822F, 9.672728F, -4.227211E-016F, 12.470947F, 0.0F, 15.922728F);
      localPath.lineTo(0.0F, 21.607521F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-14494688);
      arrayOfFloat = c.a(arrayOfFloat, -0.7071068F, -0.7071068F, 33.526459F, 0.7071068F, -0.7071068F, 5.469288F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(13.547169F, 7.605474F);
      ((Path)localObject1).lineTo(13.547169F, 15.896383F);
      ((Path)localObject1).lineTo(9.380502F, 15.896383F);
      ((Path)localObject1).lineTo(9.380502F, 7.605474F);
      ((Path)localObject1).lineTo(9.380502F, 3.460019F);
      ((Path)localObject1).lineTo(21.880503F, 3.460019F);
      ((Path)localObject1).lineTo(21.880503F, 7.605474F);
      ((Path)localObject1).lineTo(13.547169F, 7.605474F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-14494688);
      ((Paint)localObject1).setStrokeWidth(5.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.127724F, 28.754545F);
      ((Path)localObject2).cubicTo(2.784849F, 28.754545F, 2.5F, 29.040102F, 2.5F, 29.385191F);
      ((Path)localObject2).lineTo(2.5F, 72.869354F);
      ((Path)localObject2).cubicTo(2.5F, 73.223274F, 2.775803F, 73.5F, 3.127724F, 73.5F);
      ((Path)localObject2).lineTo(46.872276F, 73.5F);
      ((Path)localObject2).cubicTo(47.215153F, 73.5F, 47.5F, 73.214447F, 47.5F, 72.869354F);
      ((Path)localObject2).lineTo(47.5F, 29.385191F);
      ((Path)localObject2).cubicTo(47.5F, 29.031269F, 47.224197F, 28.754545F, 46.872276F, 28.754545F);
      ((Path)localObject2).lineTo(3.127724F, 28.754545F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-14494688);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(50.0F, 42.836365F);
      ((Path)localObject2).lineTo(50.0F, 37.861816F);
      ((Path)localObject2).lineTo(70.0F, 37.861816F);
      ((Path)localObject2).lineTo(70.0F, 6.356364F);
      ((Path)localObject2).lineTo(38.333332F, 6.356364F);
      ((Path)localObject2).lineTo(38.333332F, 26.254545F);
      ((Path)localObject2).lineTo(33.333332F, 26.254545F);
      ((Path)localObject2).lineTo(33.333332F, 4.497647F);
      ((Path)localObject2).cubicTo(33.333332F, 2.761085F, 34.735474F, 1.381818F, 36.465107F, 1.381818F);
      ((Path)localObject2).lineTo(71.868225F, 1.381818F);
      ((Path)localObject2).cubicTo(73.613678F, 1.381818F, 75.0F, 2.776822F, 75.0F, 4.497647F);
      ((Path)localObject2).lineTo(75.0F, 39.720535F);
      ((Path)localObject2).cubicTo(75.0F, 41.457096F, 73.597855F, 42.836365F, 71.868225F, 42.836365F);
      ((Path)localObject2).lineTo(50.0F, 42.836365F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-14494688);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(31.18659F, 60.799999F);
      ((Path)localObject1).lineTo(29.49906F, 55.437435F);
      ((Path)localObject1).lineTo(21.721077F, 55.437435F);
      ((Path)localObject1).lineTo(20.033546F, 60.799999F);
      ((Path)localObject1).lineTo(15.277778F, 60.799999F);
      ((Path)localObject1).lineTo(22.963713F, 38.69091F);
      ((Path)localObject1).lineTo(28.409834F, 38.69091F);
      ((Path)localObject1).lineTo(36.111111F, 60.799999F);
      ((Path)localObject1).lineTo(31.18659F, 60.799999F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(25.556374F, 42.919674F);
      ((Path)localObject1).lineTo(22.718254F, 51.974751F);
      ((Path)localObject1).lineTo(28.501883F, 51.974751F);
      ((Path)localObject1).lineTo(25.663763F, 42.919674F);
      ((Path)localObject1).lineTo(25.556374F, 42.919674F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bst
 * JD-Core Version:    0.7.0.1
 */