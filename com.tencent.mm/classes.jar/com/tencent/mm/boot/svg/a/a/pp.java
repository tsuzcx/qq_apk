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

public final class pp
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-14187817);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(144.0F, 0.0F);
      localPath.lineTo(144.0F, 144.0F);
      localPath.lineTo(0.0F, 144.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(61.621193F, 73.147293F);
      localPath.cubicTo(66.188721F, 80.180099F, 59.140778F, 83.233414F, 55.739967F, 85.172226F);
      localPath.cubicTo(43.533539F, 92.134026F, 38.0F, 94.832306F, 38.0F, 98.453674F);
      localPath.lineTo(38.0F, 102.98167F);
      localPath.cubicTo(38.0F, 104.6663F, 39.151512F, 106.0F, 40.956829F, 106.0F);
      localPath.lineTo(103.04317F, 106.0F);
      localPath.cubicTo(104.84849F, 106.0F, 106.0F, 104.6663F, 106.0F, 102.98167F);
      localPath.lineTo(106.0F, 98.453674F);
      localPath.cubicTo(106.0F, 94.832306F, 100.46646F, 92.134026F, 88.260033F, 85.172226F);
      localPath.cubicTo(84.859222F, 83.233414F, 77.811279F, 80.180099F, 82.378807F, 73.147293F);
      localPath.cubicTo(85.826248F, 67.838211F, 88.767876F, 65.557747F, 88.767876F, 56.603626F);
      localPath.cubicTo(88.767876F, 47.310932F, 82.19635F, 38.0F, 72.0F, 38.0F);
      localPath.cubicTo(61.80365F, 38.0F, 55.232128F, 47.310932F, 55.232128F, 56.603626F);
      localPath.cubicTo(55.232128F, 65.557747F, 58.173752F, 67.838211F, 61.621193F, 73.147293F);
      localPath.close();
      localPath.moveTo(66.0F, 97.856636F);
      localPath.lineTo(71.5F, 105.0F);
      localPath.lineTo(77.0F, 97.856636F);
      localPath.lineTo(71.5F, 80.0F);
      localPath.lineTo(66.0F, 97.856636F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-16608256);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(144.0F, 0.0F);
      localPath.lineTo(144.0F, 144.0F);
      localPath.lineTo(0.0F, 144.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-328966);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 31.0F, 0.0F, 1.0F, 39.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(32.0F, 44.0F);
      ((Path)localObject2).lineTo(32.0F, 53.677307F);
      ((Path)localObject2).cubicTo(32.0F, 56.064663F, 33.925228F, 58.0F, 36.31028F, 58.0F);
      ((Path)localObject2).lineTo(61.0F, 58.0F);
      ((Path)localObject2).lineTo(69.314941F, 64.651955F);
      ((Path)localObject2).cubicTo(70.245575F, 65.396461F, 71.0F, 65.035011F, 71.0F, 63.835083F);
      ((Path)localObject2).lineTo(71.0F, 58.0F);
      ((Path)localObject2).lineTo(77.684082F, 58.0F);
      ((Path)localObject2).cubicTo(80.067696F, 58.0F, 82.0F, 56.065983F, 82.0F, 53.677307F);
      ((Path)localObject2).lineTo(82.0F, 23.322693F);
      ((Path)localObject2).cubicTo(82.0F, 20.935335F, 80.07058F, 19.0F, 77.67205F, 19.0F);
      ((Path)localObject2).lineTo(57.0F, 19.0F);
      ((Path)localObject2).lineTo(57.0F, 39.672432F);
      ((Path)localObject2).cubicTo(57.0F, 42.062481F, 55.062813F, 44.0F, 52.683216F, 44.0F);
      ((Path)localObject2).lineTo(32.0F, 44.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(49.672234F, 0.0F);
      ((Path)localObject2).cubicTo(52.062393F, 0.0F, 54.0F, 1.936207F, 54.0F, 4.310226F);
      ((Path)localObject2).lineTo(54.0F, 36.689774F);
      ((Path)localObject2).cubicTo(54.0F, 39.070248F, 52.06081F, 41.0F, 49.689583F, 41.0F);
      ((Path)localObject2).lineTo(23.0F, 41.0F);
      ((Path)localObject2).lineTo(13.670663F, 48.633095F);
      ((Path)localObject2).cubicTo(12.747981F, 49.388016F, 12.0F, 49.036842F, 12.0F, 47.844276F);
      ((Path)localObject2).lineTo(12.0F, 41.0F);
      ((Path)localObject2).lineTo(4.315322F, 41.0F);
      ((Path)localObject2).cubicTo(1.932035F, 41.0F, 0.0F, 39.063793F, 0.0F, 36.689774F);
      ((Path)localObject2).lineTo(0.0F, 4.310226F);
      ((Path)localObject2).cubicTo(0.0F, 1.929754F, 1.93781F, 0.0F, 4.327765F, 0.0F);
      ((Path)localObject2).lineTo(49.672234F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pp
 * JD-Core Version:    0.7.0.1
 */