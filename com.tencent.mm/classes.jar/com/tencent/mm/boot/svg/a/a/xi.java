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

public final class xi
  extends c
{
  private final int height = 102;
  private final int width = 112;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 112;
      return 102;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.i(paramVarArgs);
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-1203649);
      arrayOfFloat = c.a(arrayOfFloat, 0.8987941F, -0.4383712F, 28.1632F, 0.4383712F, 0.8987941F, -19.495651F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(29.793938F, 16.856665F);
      localPath.lineTo(98.796371F, 41.881905F);
      localPath.cubicTo(100.52859F, 42.510136F, 101.42174F, 44.418655F, 100.79126F, 46.144703F);
      localPath.lineTo(87.092262F, 83.648125F);
      localPath.cubicTo(86.461784F, 85.374176F, 84.546432F, 86.26413F, 82.814201F, 85.635902F);
      localPath.lineTo(13.811771F, 60.610661F);
      localPath.cubicTo(12.079545F, 59.982433F, 11.186401F, 58.073914F, 11.81688F, 56.347866F);
      localPath.lineTo(25.515879F, 18.84444F);
      localPath.cubicTo(26.146358F, 17.118393F, 28.06171F, 16.228436F, 29.793938F, 16.856665F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 108, 4);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1203649);
      localPaint1.setStrokeWidth(2.036736F);
      localPaint1.setStrokeCap(Paint.Cap.ROUND);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      arrayOfFloat = c.a(arrayOfFloat, 0.9975641F, 0.06975647F, -3.171511F, -0.06975647F, 0.9975641F, 4.476245F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(67.294525F, 19.508471F);
      ((Path)localObject).cubicTo(72.629021F, 16.715134F, 78.330856F, 15.109462F, 84.400024F, 14.691455F);
      ((Path)localObject).cubicTo(93.764915F, 14.630166F, 101.19274F, 17.516296F, 104.61384F, 23.42067F);
      ((Path)localObject).cubicTo(111.76379F, 35.760567F, 98.705086F, 56.611069F, 75.446419F, 69.991562F);
      ((Path)localObject).cubicTo(52.187748F, 83.372063F, 27.536694F, 84.21563F, 20.386744F, 71.875732F);
      ((Path)localObject).cubicTo(19.534513F, 70.404892F, 18.969391F, 68.813141F, 18.674427F, 67.127533F);
      ((Path)localObject).cubicTo(18.217703F, 63.512241F, 18.431046F, 60.472187F, 19.314455F, 58.00737F);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xi
 * JD-Core Version:    0.7.0.1
 */