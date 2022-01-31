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

public final class auf
  extends c
{
  private final int height = 60;
  private final int width = 108;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-3355444);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 19.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(2.358476F, 1.539103F);
      ((Path)localObject3).cubicTo(3.726941F, 0.6805316F, 5.494957F, 1.169718F, 7.033231F, 1.0F);
      ((Path)localObject3).cubicTo(20.038641F, 1.089851F, 33.044052F, 0.9201329F, 46.049461F, 1.079867F);
      ((Path)localObject3).cubicTo(48.057209F, 0.930116F, 49.225895F, 3.126462F, 48.9562F, 4.903505F);
      ((Path)localObject3).cubicTo(48.976177F, 15.615682F, 48.976177F, 26.327858F, 48.9562F, 37.040035F);
      ((Path)localObject3).cubicTo(49.245872F, 38.797112F, 48.077187F, 41.003441F, 46.089417F, 40.903606F);
      ((Path)localObject3).cubicTo(32.384789F, 41.023407F, 18.670176F, 40.923573F, 4.965551F, 40.953522F);
      ((Path)localObject3).cubicTo(3.147591F, 41.253025F, 0.9400672F, 40.084969F, 1.07991F, 38.028389F);
      ((Path)localObject3).cubicTo(0.9200897F, 27.33618F, 1.089899F, 16.633987F, 1.0F, 5.941778F);
      ((Path)localObject3).cubicTo(1.049944F, 4.404336F, 0.8002241F, 2.467558F, 2.358476F, 1.539103F);
      ((Path)localObject3).lineTo(2.358476F, 1.539103F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(52.013893F, 14.44758F);
      ((Path)localObject2).cubicTo(57.040844F, 10.022178F, 61.738647F, 5.21371F, 66.955101F, 1.0F);
      ((Path)localObject2).cubicTo(68.351479F, 3.086694F, 67.922592F, 5.647177F, 67.982437F, 8.006048F);
      ((Path)localObject2).cubicTo(67.942543F, 17.774193F, 67.962486F, 27.532259F, 67.972466F, 37.290321F);
      ((Path)localObject2).cubicTo(68.002388F, 38.63105F, 67.65329F, 39.860886F, 66.935158F, 41.0F);
      ((Path)localObject2).cubicTo(61.728672F, 36.80645F, 57.060791F, 31.997984F, 52.023869F, 27.602823F);
      ((Path)localObject2).cubicTo(51.983971F, 23.217741F, 52.003918F, 18.832661F, 52.013893F, 14.44758F);
      ((Path)localObject2).lineTo(52.013893F, 14.44758F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.auf
 * JD-Core Version:    0.7.0.1
 */