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

public final class bqb
  extends c
{
  private final int height = 71;
  private final int width = 71;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 71;
      return 71;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.m(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.a((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(85.5F, 0.0F);
      ((Path)localObject3).cubicTo(132.72035F, 0.0F, 171.0F, 38.279652F, 171.0F, 85.5F);
      ((Path)localObject3).cubicTo(171.0F, 132.72035F, 132.72035F, 171.0F, 85.5F, 171.0F);
      ((Path)localObject3).cubicTo(38.279652F, 171.0F, 0.0F, 132.72035F, 0.0F, 85.5F);
      ((Path)localObject3).cubicTo(0.0F, 38.279652F, 38.279652F, 0.0F, 85.5F, 0.0F);
      ((Path)localObject3).close();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-11119016);
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 6.99323F);
      localPath.cubicTo(0.0F, 5.892399F, 0.8977023F, 5.0F, 1.991746F, 5.0F);
      localPath.lineTo(69.008255F, 5.0F);
      localPath.cubicTo(70.108269F, 5.0F, 71.0F, 5.895443F, 71.0F, 6.99323F);
      localPath.lineTo(71.0F, 69.006767F);
      localPath.cubicTo(71.0F, 70.107597F, 70.102295F, 71.0F, 69.008255F, 71.0F);
      localPath.lineTo(1.991746F, 71.0F);
      localPath.cubicTo(0.891735F, 71.0F, 0.0F, 70.104553F, 0.0F, 69.006767F);
      localPath.lineTo(0.0F, 6.99323F);
      localPath.close();
      localPath.moveTo(3.0F, 8.0F);
      localPath.lineTo(68.0F, 8.0F);
      localPath.lineTo(68.0F, 68.0F);
      localPath.lineTo(3.0F, 68.0F);
      localPath.lineTo(3.0F, 8.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 26.0F);
      localPath.lineTo(71.0F, 26.0F);
      localPath.lineTo(71.0F, 29.0F);
      localPath.lineTo(0.0F, 29.0F);
      localPath.lineTo(0.0F, 26.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(12.0F, 39.0F);
      localPath.lineTo(23.0F, 39.0F);
      localPath.lineTo(23.0F, 42.0F);
      localPath.lineTo(12.0F, 42.0F);
      localPath.lineTo(12.0F, 39.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localObject2 = c.a((float[])localObject2, -1.83697E-016F, -1.0F, 22.60606F, 1.0F, -1.83697E-016F, -8.621212F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(8.621212F, 5.606061F);
      localPath.lineTo(22.621212F, 5.606061F);
      localPath.lineTo(22.621212F, 8.60606F);
      localPath.lineTo(8.621212F, 8.60606F);
      localPath.lineTo(8.621212F, 5.606061F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localObject2 = c.a((float[])localObject2, -1.83697E-016F, -1.0F, 62.60606F, 1.0F, -1.83697E-016F, -48.621212F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(48.621212F, 5.606061F);
      ((Path)localObject1).lineTo(62.621212F, 5.606061F);
      ((Path)localObject1).lineTo(62.621212F, 8.60606F);
      ((Path)localObject1).lineTo(48.621212F, 8.60606F);
      ((Path)localObject1).lineTo(48.621212F, 5.606061F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.0F, 53.0F);
      ((Path)localObject2).lineTo(23.0F, 53.0F);
      ((Path)localObject2).lineTo(23.0F, 56.0F);
      ((Path)localObject2).lineTo(12.0F, 56.0F);
      ((Path)localObject2).lineTo(12.0F, 53.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(30.0F, 39.0F);
      ((Path)localObject2).lineTo(41.0F, 39.0F);
      ((Path)localObject2).lineTo(41.0F, 42.0F);
      ((Path)localObject2).lineTo(30.0F, 42.0F);
      ((Path)localObject2).lineTo(30.0F, 39.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(30.0F, 53.0F);
      ((Path)localObject2).lineTo(41.0F, 53.0F);
      ((Path)localObject2).lineTo(41.0F, 56.0F);
      ((Path)localObject2).lineTo(30.0F, 56.0F);
      ((Path)localObject2).lineTo(30.0F, 53.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(48.0F, 39.0F);
      ((Path)localObject2).lineTo(59.0F, 39.0F);
      ((Path)localObject2).lineTo(59.0F, 42.0F);
      ((Path)localObject2).lineTo(48.0F, 42.0F);
      ((Path)localObject2).lineTo(48.0F, 39.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(48.0F, 53.0F);
      ((Path)localObject1).lineTo(59.0F, 53.0F);
      ((Path)localObject1).lineTo(59.0F, 56.0F);
      ((Path)localObject1).lineTo(48.0F, 56.0F);
      ((Path)localObject1).lineTo(48.0F, 53.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bqb
 * JD-Core Version:    0.7.0.1
 */