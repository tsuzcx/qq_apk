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

public final class bfb
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
      Object localObject1 = c.h(paramVarArgs);
      Object localObject3 = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 76, 4);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(47.924576F, 7.741308F);
      ((Path)localObject3).cubicTo(50.345352F, 5.19123F, 52.666512F, 2.539959F, 55.097248F, 0.0F);
      ((Path)localObject3).cubicTo(55.744781F, 7.23534F, 56.412239F, 14.47068F, 57.0F, 21.70602F);
      ((Path)localObject3).cubicTo(49.488617F, 21.979242F, 41.967274F, 22.242346F, 34.455891F, 22.47509F);
      ((Path)localObject3).cubicTo(37.125721F, 19.459522F, 39.915092F, 16.575506F, 42.564999F, 13.549818F);
      ((Path)localObject3).cubicTo(34.625248F, 10.149714F, 25.041759F, 10.969382F, 18.048405F, 16.170732F);
      ((Path)localObject3).cubicTo(10.985314F, 21.129217F, 7.159889F, 29.912817F, 7.508561F, 38.534508F);
      ((Path)localObject3).cubicTo(5.028012F, 38.706539F, 2.537501F, 38.85833F, 0.05695137F, 39.0F);
      ((Path)localObject3).cubicTo(-0.5507334F, 28.698496F, 3.732946F, 18.22496F, 11.553151F, 11.596783F);
      ((Path)localObject3).cubicTo(21.415575F, 2.853658F, 36.468227F, 1.447068F, 47.924576F, 7.741308F);
      ((Path)localObject3).lineTo(47.924576F, 7.741308F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(44.512123F, 57.352257F);
      ((Path)localObject2).cubicTo(52.926479F, 52.803265F, 57.977089F, 43.098755F, 57.458054F, 33.515553F);
      ((Path)localObject2).cubicTo(59.953415F, 33.313374F, 62.448776F, 33.141525F, 64.944138F, 33.0F);
      ((Path)localObject2).cubicTo(65.543022F, 43.280716F, 61.300911F, 53.763607F, 53.455494F, 60.364697F);
      ((Path)localObject2).cubicTo(43.583847F, 69.108864F, 28.491903F, 70.584763F, 17.033207F, 64.236389F);
      ((Path)localObject2).cubicTo(14.587753F, 66.783829F, 12.242114F, 69.422241F, 9.826604F, 72.0F);
      ((Path)localObject2).cubicTo(9.157847F, 64.600311F, 8.608868F, 57.200623F, 8.0F, 49.800934F);
      ((Path)localObject2).cubicTo(15.306417F, 49.780716F, 22.612833F, 49.780716F, 29.91925F, 49.800934F);
      ((Path)localObject2).cubicTo(27.443853F, 52.722397F, 24.778807F, 55.492226F, 22.413204F, 58.504665F);
      ((Path)localObject2).cubicTo(29.500031F, 61.345257F, 37.814571F, 61.244167F, 44.512123F, 57.352257F);
      ((Path)localObject2).lineTo(44.512123F, 57.352257F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bfb
 * JD-Core Version:    0.7.0.1
 */