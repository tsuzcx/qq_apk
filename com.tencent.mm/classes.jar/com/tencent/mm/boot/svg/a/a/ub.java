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

public final class ub
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-16268960);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.cubicTo(114.62742F, 0.0F, 120.0F, 5.372582F, 120.0F, 12.0F);
      localPath.lineTo(120.0F, 108.0F);
      localPath.cubicTo(120.0F, 114.62742F, 114.62742F, 120.0F, 108.0F, 120.0F);
      localPath.lineTo(12.0F, 120.0F);
      localPath.cubicTo(5.372582F, 120.0F, 0.0F, 114.62742F, 0.0F, 108.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(44.260315F, 12.026479F);
      ((Path)localObject2).cubicTo(44.504608F, 12.008928F, 44.75127F, 12.0F, 45.0F, 12.0F);
      ((Path)localObject2).cubicTo(50.580982F, 12.0F, 55.105263F, 16.48245F, 55.105263F, 22.000519F);
      ((Path)localObject2).lineTo(55.105263F, 26.275465F);
      ((Path)localObject2).cubicTo(55.105263F, 29.12324F, 53.591827F, 33.20715F, 51.740429F, 35.378933F);
      ((Path)localObject2).lineTo(50.827084F, 36.450333F);
      ((Path)localObject2).cubicTo(49.337765F, 38.197376F, 49.803001F, 40.420994F, 51.885597F, 41.426277F);
      ((Path)localObject2).lineTo(66.18544F, 48.328896F);
      ((Path)localObject2).cubicTo(67.739876F, 49.079231F, 69.0F, 51.062923F, 69.0F, 52.788658F);
      ((Path)localObject2).lineTo(69.0F, 54.503906F);
      ((Path)localObject2).cubicTo(69.0F, 55.882462F, 67.860817F, 57.0F, 66.47007F, 57.0F);
      ((Path)localObject2).lineTo(63.54414F, 57.0F);
      ((Path)localObject2).cubicTo(63.177319F, 53.856773F, 61.040966F, 50.727318F, 58.235985F, 49.359085F);
      ((Path)localObject2).lineTo(41.254925F, 41.075943F);
      ((Path)localObject2).cubicTo(40.895622F, 40.900677F, 40.910355F, 40.971035F, 41.171318F, 40.66169F);
      ((Path)localObject2).lineTo(42.255917F, 39.376011F);
      ((Path)localObject2).cubicTo(45.004707F, 36.117599F, 47.099998F, 30.393791F, 47.099998F, 26.130558F);
      ((Path)localObject2).lineTo(47.099998F, 21.000622F);
      ((Path)localObject2).cubicTo(47.099998F, 17.660835F, 46.049252F, 14.565118F, 44.260315F, 12.026479F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.495739F, 37.050415F);
      ((Path)localObject2).cubicTo(21.288954F, 34.434856F, 19.5F, 29.548489F, 19.5F, 26.127872F);
      ((Path)localObject2).lineTo(19.5F, 20.998741F);
      ((Path)localObject2).cubicTo(19.5F, 14.37202F, 24.886068F, 9.0F, 31.5F, 9.0F);
      ((Path)localObject2).cubicTo(38.127419F, 9.0F, 43.5F, 14.378941F, 43.5F, 21.000622F);
      ((Path)localObject2).lineTo(43.5F, 26.130558F);
      ((Path)localObject2).cubicTo(43.5F, 29.547888F, 41.702797F, 34.448582F, 39.504261F, 37.054718F);
      ((Path)localObject2).lineTo(38.419662F, 38.340397F);
      ((Path)localObject2).cubicTo(36.651096F, 40.436852F, 37.203564F, 43.105194F, 39.676647F, 44.311531F);
      ((Path)localObject2).lineTo(56.657707F, 52.594673F);
      ((Path)localObject2).cubicTo(58.503605F, 53.495079F, 60.0F, 55.875511F, 60.0F, 57.946388F);
      ((Path)localObject2).lineTo(60.0F, 60.004684F);
      ((Path)localObject2).cubicTo(60.0F, 61.658951F, 58.647224F, 63.0F, 56.995712F, 63.0F);
      ((Path)localObject2).lineTo(6.004289F, 63.0F);
      ((Path)localObject2).cubicTo(4.345066F, 63.0F, 3.0F, 61.667267F, 3.0F, 60.004684F);
      ((Path)localObject2).lineTo(3.0F, 57.946388F);
      ((Path)localObject2).cubicTo(3.0F, 55.891125F, 4.494453F, 53.495724F, 6.342293F, 52.593998F);
      ((Path)localObject2).lineTo(23.323353F, 44.30743F);
      ((Path)localObject2).cubicTo(25.786131F, 43.105621F, 26.358778F, 40.443787F, 24.580336F, 38.335918F);
      ((Path)localObject2).lineTo(23.495739F, 37.050415F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ub
 * JD-Core Version:    0.7.0.1
 */