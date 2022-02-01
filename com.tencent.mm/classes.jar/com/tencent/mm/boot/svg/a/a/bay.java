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

public final class bay
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localPaint2.setColor(-526345);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(24.0F, 0.0F);
      localPath.cubicTo(37.254837F, 0.0F, 48.0F, 10.745165F, 48.0F, 24.0F);
      localPath.cubicTo(48.0F, 37.254837F, 37.254837F, 48.0F, 24.0F, 48.0F);
      localPath.cubicTo(10.745165F, 48.0F, 0.0F, 37.254837F, 0.0F, 24.0F);
      localPath.cubicTo(0.0F, 10.745165F, 10.745165F, 0.0F, 24.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-15616);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 10.5F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(9.433333F, 0.0004F);
      ((Path)localObject2).lineTo(5.284F, 0.0004F);
      ((Path)localObject2).cubicTo(5.06F, 0.0004F, 4.848F, 0.1004F, 4.710667F, 0.2737334F);
      ((Path)localObject2).lineTo(-4.559316E-014F, 6.183067F);
      ((Path)localObject2).lineTo(6.616F, 6.183067F);
      ((Path)localObject2).lineTo(9.433333F, 0.0004F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(26.666401F, 6.182667F);
      ((Path)localObject2).lineTo(21.687733F, 0.26F);
      ((Path)localObject2).cubicTo(21.549067F, 0.096F, 21.343733F, -3.789561E-014F, 21.1264F, -3.789561E-014F);
      ((Path)localObject2).lineTo(17.255733F, -3.789561E-014F);
      ((Path)localObject2).lineTo(20.0744F, 6.182667F);
      ((Path)localObject2).lineTo(26.666401F, 6.182667F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.438533F, 0.0004F);
      ((Path)localObject2).lineTo(11.250533F, 0.0004F);
      ((Path)localObject2).lineTo(8.4332F, 6.183067F);
      ((Path)localObject2).lineTo(18.254534F, 6.183067F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.02066667F, 7.837733F);
      ((Path)localObject2).lineTo(10.602F, 21.751066F);
      ((Path)localObject2).lineTo(6.468667F, 7.837733F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.187333F, 7.837733F);
      ((Path)localObject2).lineTo(12.871333F, 23.6404F);
      ((Path)localObject2).cubicTo(12.919333F, 23.845734F, 13.11F, 24.000401F, 13.340667F, 24.000401F);
      ((Path)localObject2).cubicTo(13.57F, 24.000401F, 13.763333F, 23.845734F, 13.811334F, 23.6404F);
      ((Path)localObject2).lineTo(18.492666F, 7.837733F);
      ((Path)localObject2).lineTo(8.187333F, 7.837733F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(26.666401F, 7.837733F);
      ((Path)localObject1).lineTo(16.083733F, 21.751066F);
      ((Path)localObject1).lineTo(20.217066F, 7.837733F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bay
 * JD-Core Version:    0.7.0.1
 */