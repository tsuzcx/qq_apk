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

public final class aaw
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
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.i(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.a((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 128, 4);
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(1717131609);
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
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(1719039606);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(84.0F, 0.0F);
      localPath.lineTo(84.0F, 84.0F);
      localPath.lineTo(0.0F, 84.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(18.0F, 60.0F);
      localPath.lineTo(66.0F, 60.0F);
      localPath.lineTo(66.0F, 66.0F);
      localPath.lineTo(18.0F, 66.0F);
      localPath.lineTo(18.0F, 60.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject3 = c.a((float[])localObject2, 1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 18.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 58.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(10.0F, 23.0F);
      ((Path)localObject1).lineTo(20.0F, 35.0F);
      ((Path)localObject1).lineTo(-2.664535E-015F, 35.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(7.0F, 0.0F);
      ((Path)localObject2).lineTo(13.0F, 0.0F);
      ((Path)localObject2).lineTo(13.0F, 27.0F);
      ((Path)localObject2).lineTo(7.0F, 27.0F);
      ((Path)localObject2).lineTo(7.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aaw
 * JD-Core Version:    0.7.0.1
 */