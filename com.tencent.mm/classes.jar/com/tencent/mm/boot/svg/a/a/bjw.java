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

public final class bjw
  extends c
{
  private final int height = 128;
  private final int width = 128;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 128;
      return 128;
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
      localObject2 = c.a((float[])localObject2, 1.333333F, 0.0F, 0.0F, 0.0F, 1.333333F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(46.169998F, 15.12F);
      ((Path)localObject2).cubicTo(47.389999F, 15.11F, 48.619999F, 15.11F, 49.84F, 15.13F);
      ((Path)localObject2).cubicTo(50.080002F, 18.379999F, 50.080002F, 21.639999F, 49.84F, 24.879999F);
      ((Path)localObject2).cubicTo(48.610001F, 24.9F, 47.380001F, 24.889999F, 46.16F, 24.879999F);
      ((Path)localObject2).cubicTo(45.919998F, 21.629999F, 45.919998F, 18.370001F, 46.169998F, 15.12F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(23.469999F, 26.01F);
      ((Path)localObject2).cubicTo(24.33F, 25.129999F, 25.190001F, 24.25F, 26.059999F, 23.370001F);
      ((Path)localObject2).cubicTo(28.530001F, 25.469999F, 30.76F, 27.82F, 33.009998F, 30.16F);
      ((Path)localObject2).cubicTo(32.119999F, 31.120001F, 31.18F, 32.029999F, 30.190001F, 32.880001F);
      ((Path)localObject2).cubicTo(27.9F, 30.639999F, 25.6F, 28.41F, 23.469999F, 26.01F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(62.98F, 30.190001F);
      ((Path)localObject2).cubicTo(65.230003F, 27.889999F, 67.449997F, 25.549999F, 69.910004F, 23.459999F);
      ((Path)localObject2).cubicTo(70.769997F, 24.32F, 71.629997F, 25.18F, 72.489998F, 26.049999F);
      ((Path)localObject2).cubicTo(70.410004F, 28.49F, 68.080002F, 30.700001F, 65.800003F, 32.959999F);
      ((Path)localObject2).cubicTo(64.769997F, 32.130001F, 63.830002F, 31.200001F, 62.98F, 30.190001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(43.400002F, 30.610001F);
      ((Path)localObject2).cubicTo(52.099998F, 28.08F, 62.040001F, 33.34F, 64.93F, 41.900002F);
      ((Path)localObject2).cubicTo(67.599998F, 48.98F, 65.129997F, 57.57F, 59.110001F, 62.150002F);
      ((Path)localObject2).cubicTo(53.41F, 66.760002F, 44.830002F, 67.260002F, 38.630001F, 63.360001F);
      ((Path)localObject2).cubicTo(32.720001F, 59.849998F, 29.25F, 52.740002F, 30.129999F, 45.919998F);
      ((Path)localObject2).cubicTo(30.870001F, 38.73F, 36.389999F, 32.369999F, 43.400002F, 30.610001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.14F, 46.169998F);
      ((Path)localObject2).cubicTo(18.370001F, 45.919998F, 21.610001F, 45.93F, 24.84F, 46.150002F);
      ((Path)localObject2).cubicTo(24.879999F, 47.360001F, 24.91F, 48.57F, 24.93F, 49.779999F);
      ((Path)localObject2).cubicTo(21.67F, 50.110001F, 18.370001F, 50.09F, 15.1F, 49.810001F);
      ((Path)localObject2).cubicTo(15.1F, 48.59F, 15.11F, 47.380001F, 15.14F, 46.169998F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(71.110001F, 46.200001F);
      ((Path)localObject2).cubicTo(74.349998F, 45.900002F, 77.620003F, 45.91F, 80.870003F, 46.18F);
      ((Path)localObject2).cubicTo(80.889999F, 47.380001F, 80.900002F, 48.59F, 80.900002F, 49.799999F);
      ((Path)localObject2).cubicTo(77.639999F, 50.099998F, 74.349998F, 50.099998F, 71.089996F, 49.790001F);
      ((Path)localObject2).cubicTo(71.089996F, 48.59F, 71.089996F, 47.389999F, 71.110001F, 46.200001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(23.34F, 69.910004F);
      ((Path)localObject2).cubicTo(25.4F, 67.349998F, 27.82F, 65.139999F, 30.16F, 62.849998F);
      ((Path)localObject2).cubicTo(31.16F, 63.740002F, 32.099998F, 64.68F, 32.849998F, 65.790001F);
      ((Path)localObject2).cubicTo(30.52F, 67.839996F, 28.67F, 70.489998F, 26.02F, 72.120003F);
      ((Path)localObject2).cubicTo(25.030001F, 71.519997F, 24.139999F, 70.779999F, 23.34F, 69.910004F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(62.91F, 65.800003F);
      ((Path)localObject2).cubicTo(63.700001F, 64.699997F, 64.660004F, 63.77F, 65.790001F, 63.02F);
      ((Path)localObject2).cubicTo(67.839996F, 65.379997F, 70.620003F, 67.199997F, 72.150002F, 69.959999F);
      ((Path)localObject2).cubicTo(71.470001F, 70.860001F, 70.739998F, 71.709999F, 69.949997F, 72.529999F);
      ((Path)localObject2).cubicTo(67.400002F, 70.5F, 65.199997F, 68.089996F, 62.91F, 65.800003F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(46.169998F, 71.129997F);
      ((Path)localObject1).cubicTo(47.389999F, 71.110001F, 48.599998F, 71.099998F, 49.82F, 71.110001F);
      ((Path)localObject1).cubicTo(50.09F, 74.360001F, 50.080002F, 77.639999F, 49.82F, 80.889999F);
      ((Path)localObject1).cubicTo(48.610001F, 80.900002F, 47.389999F, 80.900002F, 46.18F, 80.889999F);
      ((Path)localObject1).cubicTo(45.91F, 77.639999F, 45.919998F, 74.379997F, 46.169998F, 71.129997F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bjw
 * JD-Core Version:    0.7.0.1
 */