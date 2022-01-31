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

public final class abd
  extends c
{
  private final int height = 84;
  private final int width = 84;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 84;
      return 84;
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
      localCanvas.saveLayerAlpha(null, 128, 4);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(1717131609);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 9.009398F);
      localPath.cubicTo(0.0F, 4.033645F, 4.023195F, 0.0F, 9.009398F, 0.0F);
      localPath.lineTo(74.990601F, 0.0F);
      localPath.cubicTo(79.966354F, 0.0F, 84.0F, 4.023195F, 84.0F, 9.009398F);
      localPath.lineTo(84.0F, 74.990601F);
      localPath.cubicTo(84.0F, 79.966354F, 79.976807F, 84.0F, 74.990601F, 84.0F);
      localPath.lineTo(9.009398F, 84.0F);
      localPath.cubicTo(4.033645F, 84.0F, 0.0F, 79.976807F, 0.0F, 74.990601F);
      localPath.lineTo(0.0F, 9.009398F);
      localPath.close();
      localPath.moveTo(2.0F, 10.000051F);
      localPath.lineTo(2.0F, 73.999947F);
      localPath.cubicTo(2.0F, 78.420212F, 5.581745F, 82.0F, 10.000051F, 82.0F);
      localPath.lineTo(73.999947F, 82.0F);
      localPath.cubicTo(78.420212F, 82.0F, 82.0F, 78.418259F, 82.0F, 73.999947F);
      localPath.lineTo(82.0F, 10.000051F);
      localPath.cubicTo(82.0F, 5.579786F, 78.418259F, 2.0F, 73.999947F, 2.0F);
      localPath.lineTo(10.000051F, 2.0F);
      localPath.cubicTo(5.579786F, 2.0F, 2.0F, 5.581745F, 2.0F, 10.000051F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(1719039606);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(84.0F, 0.0F);
      localPath.lineTo(84.0F, 84.0F);
      localPath.lineTo(0.0F, 84.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 28.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(10.0F, 0.0F);
      ((Path)localObject2).lineTo(10.0F, 10.0F);
      ((Path)localObject2).lineTo(0.0F, 10.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 18.0F);
      ((Path)localObject2).lineTo(10.0F, 18.0F);
      ((Path)localObject2).lineTo(10.0F, 28.0F);
      ((Path)localObject2).lineTo(0.0F, 28.0F);
      ((Path)localObject2).lineTo(0.0F, 18.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(16.0F, 0.0F);
      ((Path)localObject2).lineTo(26.0F, 0.0F);
      ((Path)localObject2).lineTo(26.0F, 10.0F);
      ((Path)localObject2).lineTo(16.0F, 10.0F);
      ((Path)localObject2).lineTo(16.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(16.0F, 18.0F);
      ((Path)localObject2).lineTo(26.0F, 18.0F);
      ((Path)localObject2).lineTo(26.0F, 28.0F);
      ((Path)localObject2).lineTo(16.0F, 28.0F);
      ((Path)localObject2).lineTo(16.0F, 18.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(32.0F, 0.0F);
      ((Path)localObject2).lineTo(42.0F, 0.0F);
      ((Path)localObject2).lineTo(42.0F, 10.0F);
      ((Path)localObject2).lineTo(32.0F, 10.0F);
      ((Path)localObject2).lineTo(32.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(32.0F, 18.0F);
      ((Path)localObject1).lineTo(42.0F, 18.0F);
      ((Path)localObject1).lineTo(42.0F, 28.0F);
      ((Path)localObject1).lineTo(32.0F, 28.0F);
      ((Path)localObject1).lineTo(32.0F, 18.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abd
 * JD-Core Version:    0.7.0.1
 */