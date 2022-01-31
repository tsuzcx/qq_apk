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

public final class yl
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-12889439);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.lineTo(108.0F, 108.0F);
      localPath.lineTo(0.0F, 108.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 37.0F, 0.0F, 1.0F, 20.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(33.02322F, 0.0123783F);
      ((Path)localObject2).lineTo(22.661959F, 0.0123783F);
      ((Path)localObject2).cubicTo(9.465719F, -0.1179083F, 7.780266F, 7.9407F, 7.780266F, 16.662235F);
      ((Path)localObject2).lineTo(7.780266F, 23.004126F);
      ((Path)localObject2).lineTo(1.954969F, 23.004126F);
      ((Path)localObject2).cubicTo(0.8093274F, 22.87384F, -0.12272F, 23.789677F, 0.0132036F, 24.920105F);
      ((Path)localObject2).lineTo(0.0132036F, 36.415977F);
      ((Path)localObject2).cubicTo(-0.12272F, 37.546406F, 0.8093275F, 38.462246F, 1.954969F, 38.331959F);
      ((Path)localObject2).lineTo(7.780266F, 38.331959F);
      ((Path)localObject2).lineTo(7.780266F, 67.07164F);
      ((Path)localObject2).cubicTo(7.659877F, 68.202072F, 8.58804F, 69.117905F, 9.733683F, 68.987625F);
      ((Path)localObject2).lineTo(21.597872F, 68.987625F);
      ((Path)localObject2).cubicTo(22.743513F, 69.117905F, 23.671677F, 68.202072F, 23.306625F, 67.07164F);
      ((Path)localObject2).lineTo(23.314392F, 38.331959F);
      ((Path)localObject2).lineTo(33.02322F, 38.331959F);
      ((Path)localObject2).cubicTo(34.168861F, 38.462246F, 35.10091F, 37.546406F, 34.964985F, 36.415977F);
      ((Path)localObject2).lineTo(34.964985F, 24.920105F);
      ((Path)localObject2).cubicTo(35.10091F, 23.789677F, 34.168861F, 22.87384F, 33.02322F, 23.004126F);
      ((Path)localObject2).lineTo(23.30274F, 23.004126F);
      ((Path)localObject2).lineTo(23.314392F, 17.256189F);
      ((Path)localObject2).cubicTo(23.691093F, 14.807568F, 23.691093F, 15.206092F, 25.994028F, 15.34021F);
      ((Path)localObject2).lineTo(32.941666F, 15.34021F);
      ((Path)localObject2).cubicTo(33.481476F, 15.221419F, 34.05624F, 15.286563F, 34.460125F, 14.899535F);
      ((Path)localObject2).cubicTo(34.864014F, 14.512507F, 35.097027F, 13.983697F, 34.961102F, 13.424232F);
      ((Path)localObject2).lineTo(34.961102F, 1.928357F);
      ((Path)localObject2).cubicTo(35.10091F, 0.79793F, 34.168861F, -0.1179083F, 33.02322F, 0.0123783F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.94553F, 11.293663F);
      ((Path)localObject2).lineTo(26.075583F, 11.109729F);
      ((Path)localObject2).cubicTo(20.044458F, 11.109729F, 19.539598F, 14.340069F, 19.539598F, 17.647049F);
      ((Path)localObject2).lineTo(19.524065F, 24.912441F);
      ((Path)localObject2).cubicTo(19.524065F, 25.456579F, 19.741543F, 25.977726F, 20.129896F, 26.364754F);
      ((Path)localObject2).cubicTo(20.51825F, 26.74795F, 21.04641F, 26.962538F, 21.59787F, 26.962538F);
      ((Path)localObject2).lineTo(31.081455F, 26.962538F);
      ((Path)localObject2).lineTo(31.081455F, 34.365883F);
      ((Path)localObject2).lineTo(21.605639F, 34.365883F);
      ((Path)localObject2).cubicTo(20.459995F, 34.365883F, 19.531832F, 35.281719F, 19.527948F, 36.412148F);
      ((Path)localObject2).lineTo(19.524065F, 65.155663F);
      ((Path)localObject2).lineTo(11.663797F, 65.155663F);
      ((Path)localObject2).lineTo(11.663797F, 36.415977F);
      ((Path)localObject2).cubicTo(11.663797F, 35.285553F, 10.883207F, 34.369713F, 9.733683F, 34.369713F);
      ((Path)localObject2).lineTo(3.896735F, 34.369713F);
      ((Path)localObject2).lineTo(3.896735F, 26.966372F);
      ((Path)localObject2).lineTo(9.733683F, 26.966372F);
      ((Path)localObject2).cubicTo(10.285144F, 26.966372F, 10.813304F, 26.751781F, 11.201657F, 26.368586F);
      ((Path)localObject2).cubicTo(11.590011F, 25.981558F, 11.659914F, 25.460411F, 11.659914F, 24.916273F);
      ((Path)localObject2).lineTo(11.659914F, 16.658403F);
      ((Path)localObject2).cubicTo(11.659914F, 8.067154F, 13.419154F, 3.974623F, 22.658075F, 3.974623F);
      ((Path)localObject2).lineTo(30.941647F, 3.974623F);
      ((Path)localObject2).lineTo(30.941647F, 11.293663F);
      ((Path)localObject2).lineTo(30.94553F, 11.293663F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.yl
 * JD-Core Version:    0.7.0.1
 */