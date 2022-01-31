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

public final class ast
  extends c
{
  private final int height = 131;
  private final int width = 131;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject2 = c.i(paramVarArgs);
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
      localCanvas.saveLayerAlpha(null, 128, 4);
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
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(4.166667F);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(22.242647F, 9.672728F);
      localPath.lineTo(6.25F, 9.672728F);
      localPath.cubicTo(2.79822F, 9.672728F, -4.227211E-016F, 12.470947F, 0.0F, 15.922728F);
      localPath.lineTo(0.0F, 21.607521F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, -0.7071068F, -0.7071068F, 33.526459F, 0.7071068F, -0.7071068F, 5.469288F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.j(paramVarArgs);
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
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(5.0F);
      localObject2 = c.j(paramVarArgs);
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
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.j(paramVarArgs);
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
      localPaint1.setColor(-1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(29.208591F, 45.839653F);
      ((Path)localObject1).lineTo(21.852119F, 45.839653F);
      ((Path)localObject1).cubicTo(22.811659F, 48.09166F, 24.115648F, 50.098885F, 25.76409F, 51.836845F);
      ((Path)localObject1).cubicTo(27.2157F, 50.172318F, 28.37207F, 48.189571F, 29.208591F, 45.839653F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(36.958721F, 45.839653F);
      ((Path)localObject1).lineTo(33.24358F, 45.839653F);
      ((Path)localObject1).cubicTo(32.087212F, 49.168705F, 30.512581F, 51.934757F, 28.495087F, 54.211243F);
      ((Path)localObject1).cubicTo(30.955446F, 55.973682F, 33.93248F, 57.271034F, 37.5F, 58.05434F);
      ((Path)localObject1).cubicTo(36.68808F, 58.837646F, 35.630127F, 60.404259F, 35.088848F, 61.383392F);
      ((Path)localObject1).cubicTo(31.299896F, 60.404259F, 28.224447F, 58.886604F, 25.690279F, 56.854904F);
      ((Path)localObject1).cubicTo(23.008488F, 58.960037F, 19.760815F, 60.502174F, 15.873447F, 61.57922F);
      ((Path)localObject1).cubicTo(15.479791F, 60.722481F, 14.397233F, 59.057953F, 13.708332F, 58.225689F);
      ((Path)localObject1).cubicTo(17.472681F, 57.393425F, 20.54813F, 56.120552F, 23.033091F, 54.309155F);
      ((Path)localObject1).cubicTo(20.990993F, 51.959236F, 19.416365F, 49.14423F, 18.136978F, 45.839653F);
      ((Path)localObject1).lineTo(14.249611F, 45.839653F);
      ((Path)localObject1).lineTo(14.249611F, 42.363731F);
      ((Path)localObject1).lineTo(24.386288F, 42.363731F);
      ((Path)localObject1).cubicTo(24.140253F, 41.384598F, 23.697388F, 40.136204F, 23.229919F, 39.15707F);
      ((Path)localObject1).lineTo(27.068079F, 38.031067F);
      ((Path)localObject1).cubicTo(27.683168F, 39.181545F, 28.37207F, 40.723682F, 28.618105F, 41.75177F);
      ((Path)localObject1).lineTo(26.625216F, 42.363731F);
      ((Path)localObject1).lineTo(36.958721F, 42.363731F);
      ((Path)localObject1).lineTo(36.958721F, 45.839653F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ast
 * JD-Core Version:    0.7.0.1
 */