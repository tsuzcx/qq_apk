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

public final class awb
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
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject4 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject4).setColor(-526345);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(72.0F, 0.0F);
      localPath.cubicTo(111.7645F, 0.0F, 144.0F, 32.235497F, 144.0F, 72.0F);
      localPath.cubicTo(144.0F, 111.7645F, 111.7645F, 144.0F, 72.0F, 144.0F);
      localPath.cubicTo(32.235497F, 144.0F, 0.0F, 111.7645F, 0.0F, 72.0F);
      localPath.cubicTo(0.0F, 32.235497F, 32.235497F, 0.0F, 72.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.a((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject2).setColor(-15616);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      localObject3 = c.a((float[])localObject4, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(0.9806908F, 18.899986F);
      localPath.lineTo(18.139259F, 18.899986F);
      localPath.lineTo(18.139259F, 18.899986F);
      localPath.lineTo(40.0F, 72.0F);
      localPath.lineTo(0.2849349F, 20.311998F);
      localPath.cubicTo(-0.01031203F, 19.927742F, 0.06184352F, 19.376896F, 0.4460989F, 19.08165F);
      localPath.cubicTo(0.5994136F, 18.963848F, 0.7873452F, 18.899986F, 0.9806908F, 18.899986F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.a((float[])localObject3, -1.0F, 0.0F, 119.90475F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(40.885437F, 18.899986F);
      localPath.lineTo(57.641041F, 18.899986F);
      localPath.lineTo(57.641041F, 18.899986F);
      localPath.lineTo(79.904747F, 72.0F);
      localPath.lineTo(40.189682F, 20.311998F);
      localPath.cubicTo(39.894432F, 19.927742F, 39.966587F, 19.376896F, 40.350845F, 19.08165F);
      localPath.cubicTo(40.504158F, 18.963848F, 40.692089F, 18.899986F, 40.885437F, 18.899986F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(24.133333F, 18.899986F);
      localPath.lineTo(55.866665F, 18.899986F);
      localPath.lineTo(40.0F, 72.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(18.569696F, 13.5F);
      localPath.lineTo(30.933332F, 0.0F);
      localPath.lineTo(18.030989F, 0.0F);
      localPath.cubicTo(17.845423F, -5.850094E-015F, 17.664633F, 0.0588334F, 17.514606F, 0.1680443F);
      localPath.lineTo(1.379839F, 11.913205F);
      localPath.cubicTo(0.9880618F, 12.198396F, 0.9016565F, 12.747187F, 1.186847F, 13.138964F);
      localPath.cubicTo(1.351978F, 13.365809F, 1.615639F, 13.5F, 1.896222F, 13.5F);
      localPath.lineTo(18.569696F, 13.5F);
      localPath.lineTo(18.569696F, 13.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(35.466667F, 0.0F);
      localPath.lineTo(44.533333F, 0.0F);
      localPath.lineTo(55.866665F, 13.5F);
      localPath.lineTo(24.133333F, 13.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.a((float[])localObject3, -1.0F, 0.0F, 128.11855F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(67.544304F, 13.5F);
      ((Path)localObject1).lineTo(80.800003F, 0.0F);
      ((Path)localObject1).lineTo(67.434105F, 0.0F);
      ((Path)localObject1).cubicTo(67.244865F, -1.852616E-015F, 67.060692F, 0.06118328F, 66.909073F, 0.174422F);
      ((Path)localObject1).lineTo(51.182781F, 11.919583F);
      ((Path)localObject1).cubicTo(50.794525F, 12.209551F, 50.714848F, 12.759358F, 51.004814F, 13.147614F);
      ((Path)localObject1).cubicTo(51.170448F, 13.369387F, 51.431015F, 13.5F, 51.707813F, 13.5F);
      ((Path)localObject1).lineTo(67.544304F, 13.5F);
      ((Path)localObject1).lineTo(67.544304F, 13.5F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(96.0F, 0.0F);
      ((Path)localObject1).lineTo(96.0F, 96.0F);
      ((Path)localObject1).lineTo(0.0F, 96.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject1, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awb
 * JD-Core Version:    0.7.0.1
 */