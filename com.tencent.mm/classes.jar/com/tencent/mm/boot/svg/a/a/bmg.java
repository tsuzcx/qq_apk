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

public final class bmg
  extends c
{
  private final int height = 76;
  private final int width = 76;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 76;
      return 76;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
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
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-789517);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.cubicTo(74.209137F, 0.0F, 76.0F, 1.790861F, 76.0F, 4.0F);
      localPath.lineTo(76.0F, 72.0F);
      localPath.cubicTo(76.0F, 74.209137F, 74.209137F, 76.0F, 72.0F, 76.0F);
      localPath.lineTo(4.0F, 76.0F);
      localPath.cubicTo(1.790861F, 76.0F, 0.0F, 74.209137F, 0.0F, 72.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-5658199);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(25.5F, 0.0F);
      ((Path)localObject3).cubicTo(27.985281F, 0.0F, 30.0F, 2.014719F, 30.0F, 4.5F);
      ((Path)localObject3).cubicTo(30.0F, 6.985282F, 27.985281F, 9.0F, 25.5F, 9.0F);
      ((Path)localObject3).cubicTo(23.014719F, 9.0F, 21.0F, 6.985282F, 21.0F, 4.5F);
      ((Path)localObject3).cubicTo(21.0F, 2.014719F, 23.014719F, 0.0F, 25.5F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(4.140231F, 10.026411F);
      ((Path)localObject3).cubicTo(17.423513F, 9.986368F, 30.706797F, 9.996379F, 44.0F, 10.026411F);
      ((Path)localObject3).cubicTo(43.940479F, 11.688178F, 43.910717F, 13.349946F, 43.890877F, 15.011714F);
      ((Path)localObject3).lineTo(10.786833F, 15.011714F);
      ((Path)localObject3).cubicTo(10.608268F, 23.610863F, 11.35229F, 32.330139F, 9.645998F, 40.809158F);
      ((Path)localObject3).cubicTo(8.71349F, 45.454102F, 5.162022F, 48.867733F, 1.154221F, 51.0F);
      ((Path)localObject3).cubicTo(0.191952F, 46.204899F, 4.050949F, 42.450905F, 3.961666F, 37.765923F);
      ((Path)localObject3).cubicTo(4.358478F, 28.526091F, 4.021188F, 19.276251F, 4.140231F, 10.026411F);
      ((Path)localObject3).lineTo(4.140231F, 10.026411F);
      ((Path)localObject3).lineTo(4.140231F, 10.026411F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(22.522583F, 17.0F);
      ((Path)localObject2).cubicTo(24.810589F, 17.040438F, 27.108543F, 17.050549F, 29.396551F, 17.060658F);
      ((Path)localObject2).cubicTo(29.476133F, 18.395117F, 29.545769F, 19.729574F, 29.615402F, 21.074142F);
      ((Path)localObject2).cubicTo(34.410271F, 21.084253F, 39.205135F, 21.074142F, 44.0F, 21.084253F);
      ((Path)localObject2).cubicTo(44.0F, 22.529917F, 44.0F, 23.985689F, 43.990051F, 25.431355F);
      ((Path)localObject2).cubicTo(39.145447F, 25.441463F, 34.310791F, 25.431355F, 29.476133F, 25.441463F);
      ((Path)localObject2).cubicTo(29.505978F, 27.463371F, 29.515924F, 29.485279F, 29.496029F, 31.507185F);
      ((Path)localObject2).cubicTo(33.654232F, 31.486967F, 37.802486F, 31.517296F, 41.950741F, 31.517296F);
      ((Path)localObject2).cubicTo(41.851265F, 36.046368F, 42.139751F, 40.595661F, 41.851265F, 45.124733F);
      ((Path)localObject2).cubicTo(41.920898F, 47.551022F, 39.463779F, 49.158436F, 37.255356F, 48.946136F);
      ((Path)localObject2).cubicTo(29.177698F, 49.027012F, 21.090092F, 49.027012F, 13.002487F, 48.87537F);
      ((Path)localObject2).cubicTo(13.002487F, 43.102825F, 12.992539F, 37.33028F, 13.012435F, 31.557734F);
      ((Path)localObject2).cubicTo(16.175852F, 31.547625F, 19.33927F, 31.466747F, 22.502687F, 31.466747F);
      ((Path)localObject2).cubicTo(22.522583F, 26.644499F, 22.522583F, 21.822248F, 22.522583F, 17.0F);
      ((Path)localObject2).lineTo(22.522583F, 17.0F);
      ((Path)localObject2).lineTo(22.522583F, 17.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.007324F, 36.017189F);
      ((Path)localObject2).cubicTo(19.997559F, 39.004719F, 19.997559F, 41.981876F, 20.007324F, 44.959034F);
      ((Path)localObject2).cubicTo(24.939476F, 44.979782F, 29.861862F, 45.104259F, 34.784245F, 44.782684F);
      ((Path)localObject2).cubicTo(34.960045F, 41.857395F, 35.028412F, 38.932106F, 34.989346F, 36.006813F);
      ((Path)localObject2).cubicTo(29.998594F, 35.996441F, 24.998075F, 35.996441F, 20.007324F, 36.017189F);
      ((Path)localObject2).lineTo(20.007324F, 36.017189F);
      ((Path)localObject2).lineTo(20.007324F, 36.017189F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bmg
 * JD-Core Version:    0.7.0.1
 */