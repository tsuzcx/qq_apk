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

public final class zm
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject2 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-16074);
      ((Paint)localObject2).setStrokeWidth(4.8F);
      Object localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(45.0F, 66.0F);
      ((Path)localObject3).lineTo(42.600056F, 66.0F);
      ((Path)localObject3).cubicTo(37.305443F, 66.0F, 33.0F, 61.963409F, 33.0F, 57.0F);
      ((Path)localObject3).cubicTo(33.0F, 52.036591F, 37.305725F, 48.0F, 42.600056F, 48.0F);
      ((Path)localObject3).lineTo(45.0F, 48.0F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-16074);
      ((Paint)localObject2).setStrokeWidth(4.8F);
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 210.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(111.0F, 66.0F);
      ((Path)localObject3).lineTo(108.60006F, 66.0F);
      ((Path)localObject3).cubicTo(103.30544F, 66.0F, 99.0F, 61.963409F, 99.0F, 57.0F);
      ((Path)localObject3).cubicTo(99.0F, 52.036591F, 103.30573F, 48.0F, 108.60006F, 48.0F);
      ((Path)localObject3).lineTo(111.0F, 48.0F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint2, paramVarArgs);
      localObject3 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject3).setColor(-16074);
      ((Paint)localObject3).setStrokeWidth(4.8F);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(44.400005F, 60.0F);
      localPath.lineTo(44.400005F, 60.001617F);
      localPath.cubicTo(44.391766F, 72.237938F, 59.60981F, 84.599998F, 72.0F, 84.599998F);
      localPath.cubicTo(84.386948F, 84.599998F, 99.599998F, 72.239395F, 99.599998F, 60.0F);
      localPath.lineTo(99.599998F, 34.652924F);
      localPath.cubicTo(99.599998F, 30.197235F, 95.144478F, 26.400249F, 89.499962F, 26.400249F);
      localPath.lineTo(84.499893F, 26.400249F);
      localPath.cubicTo(84.382103F, 26.400249F, 84.30455F, 26.435246F, 84.307831F, 26.431129F);
      localPath.lineTo(83.460304F, 27.492258F);
      localPath.cubicTo(80.851486F, 30.827463F, 76.570732F, 32.78677F, 71.999847F, 32.791801F);
      localPath.cubicTo(67.42408F, 32.786766F, 63.142719F, 30.825882F, 60.541359F, 27.495325F);
      localPath.lineTo(59.689983F, 26.428133F);
      localPath.cubicTo(59.695263F, 26.434763F, 59.618225F, 26.4F, 59.500114F, 26.4F);
      localPath.lineTo(54.500042F, 26.4F);
      localPath.cubicTo(48.85545F, 26.4F, 44.400005F, 30.197042F, 44.400005F, 34.652672F);
      localPath.lineTo(44.400005F, 60.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-16074);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(104.91049F, 46.496986F);
      ((Path)localObject2).lineTo(104.86963F, 47.496094F);
      ((Path)localObject2).lineTo(99.425171F, 47.966675F);
      ((Path)localObject2).lineTo(99.425171F, 30.077742F);
      ((Path)localObject2).lineTo(86.924355F, 25.381779F);
      ((Path)localObject2).lineTo(81.476898F, 27.004065F);
      ((Path)localObject2).lineTo(74.956291F, 31.657248F);
      ((Path)localObject2).lineTo(64.975433F, 30.077742F);
      ((Path)localObject2).lineTo(56.890369F, 25.381779F);
      ((Path)localObject2).lineTo(48.26918F, 28.170187F);
      ((Path)localObject2).lineTo(44.771484F, 33.857666F);
      ((Path)localObject2).lineTo(46.043789F, 45.453331F);
      ((Path)localObject2).lineTo(39.263027F, 47.496094F);
      ((Path)localObject2).lineTo(39.263027F, 46.481754F);
      ((Path)localObject2).lineTo(37.086315F, 46.673683F);
      ((Path)localObject2).lineTo(36.085262F, 36.106701F);
      ((Path)localObject2).cubicTo(35.237816F, 26.960608F, 40.776772F, 18.525093F, 49.621746F, 15.341587F);
      ((Path)localObject2).cubicTo(54.455132F, 9.480436F, 61.893879F, 6.0F, 69.672592F, 6.0F);
      ((Path)localObject2).lineTo(74.329178F, 6.0F);
      ((Path)localObject2).cubicTo(82.107887F, 6.0F, 89.546638F, 9.480436F, 94.377838F, 15.341587F);
      ((Path)localObject2).cubicTo(103.22527F, 18.525093F, 108.76395F, 26.960608F, 107.91432F, 36.102219F);
      ((Path)localObject2).lineTo(106.91327F, 46.673683F);
      ((Path)localObject2).lineTo(104.91049F, 46.496986F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-16074);
      localPaint2.setStrokeWidth(4.8F);
      localPaint2.setStrokeCap(Paint.Cap.ROUND);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(57.0F, 93.0F);
      ((Path)localObject2).lineTo(72.0F, 111.0F);
      ((Path)localObject2).lineTo(57.0F, 117.0F);
      ((Path)localObject2).lineTo(48.0F, 93.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-16074);
      localPaint2.setStrokeWidth(4.8F);
      localPaint2.setStrokeCap(Paint.Cap.ROUND);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 168.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(81.0F, 93.0F);
      ((Path)localObject2).lineTo(96.0F, 111.0F);
      ((Path)localObject2).lineTo(81.0F, 117.0F);
      ((Path)localObject2).lineTo(72.0F, 93.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-16074);
      localPaint2.setStrokeWidth(4.8F);
      localPaint2.setStrokeCap(Paint.Cap.ROUND);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(87.0F, 81.0F);
      ((Path)localObject2).lineTo(87.0F, 88.993668F);
      ((Path)localObject2).cubicTo(87.004784F, 90.675812F, 88.42321F, 92.1185F, 90.300102F, 92.344925F);
      ((Path)localObject2).lineTo(104.25684F, 93.992752F);
      ((Path)localObject2).cubicTo(114.9447F, 95.264374F, 122.99962F, 103.46318F, 122.99962F, 113.05984F);
      ((Path)localObject2).lineTo(122.99962F, 135.0F);
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16074);
      localPaint1.setStrokeWidth(4.8F);
      localPaint1.setStrokeCap(Paint.Cap.ROUND);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 77.999619F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(21.0F, 81.0F);
      ((Path)localObject1).lineTo(21.0F, 88.993668F);
      ((Path)localObject1).cubicTo(21.004782F, 90.675812F, 22.42321F, 92.1185F, 24.300104F, 92.344925F);
      ((Path)localObject1).lineTo(38.256844F, 93.992752F);
      ((Path)localObject1).cubicTo(48.944702F, 95.264374F, 56.999619F, 103.46318F, 56.999619F, 113.05984F);
      ((Path)localObject1).lineTo(56.999619F, 135.0F);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.zm
 * JD-Core Version:    0.7.0.1
 */