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

public final class ayi
  extends c
{
  private final int height = 144;
  private final int width = 168;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 144;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(84.0F, 24.0F);
      localPath.cubicTo(84.0F, 43.882252F, 100.11775F, 60.0F, 120.0F, 60.0F);
      localPath.lineTo(120.0F, 128.61668F);
      localPath.cubicTo(120.0F, 133.96581F, 119.44305F, 135.90552F, 118.3972F, 137.86107F);
      localPath.cubicTo(117.35136F, 139.81664F, 115.81663F, 141.35136F, 113.86108F, 142.3972F);
      localPath.cubicTo(111.90552F, 143.44304F, 109.9658F, 144.0F, 104.61669F, 144.0F);
      localPath.lineTo(15.383311F, 144.0F);
      localPath.cubicTo(10.034199F, 144.0F, 8.094482F, 143.44304F, 6.138926F, 142.3972F);
      localPath.cubicTo(4.18337F, 141.35136F, 2.648639F, 139.81664F, 1.602796F, 137.86107F);
      localPath.cubicTo(0.5569537F, 135.90552F, 2.407412E-016F, 133.96581F, -4.143361E-016F, 128.61668F);
      localPath.lineTo(4.143361E-016F, 39.383312F);
      localPath.cubicTo(-2.407412E-016F, 34.034199F, 0.5569537F, 32.094482F, 1.602796F, 30.138926F);
      localPath.cubicTo(2.648639F, 28.183371F, 4.18337F, 26.64864F, 6.138926F, 25.602797F);
      localPath.cubicTo(8.094482F, 24.556953F, 10.034199F, 24.0F, 15.383311F, 24.0F);
      localPath.lineTo(84.0F, 24.0F);
      localPath.close();
      localPath.moveTo(31.5F, 108.0F);
      localPath.cubicTo(31.5F, 109.65685F, 32.843147F, 111.0F, 34.5F, 111.0F);
      localPath.lineTo(85.5F, 111.0F);
      localPath.cubicTo(87.156853F, 111.0F, 88.5F, 109.65685F, 88.5F, 108.0F);
      localPath.lineTo(88.5F, 105.94639F);
      localPath.cubicTo(88.5F, 103.87551F, 87.003601F, 101.49508F, 85.157707F, 100.59467F);
      localPath.lineTo(68.176643F, 92.311531F);
      localPath.cubicTo(65.70356F, 91.105194F, 65.1511F, 88.436852F, 66.919662F, 86.340401F);
      localPath.lineTo(68.004265F, 85.054718F);
      localPath.cubicTo(70.202797F, 82.448578F, 72.0F, 77.54789F, 72.0F, 74.130554F);
      localPath.lineTo(72.0F, 69.000626F);
      localPath.cubicTo(72.0F, 62.378941F, 66.627419F, 57.0F, 60.0F, 57.0F);
      localPath.cubicTo(53.38607F, 57.0F, 48.0F, 62.372021F, 48.0F, 68.998741F);
      localPath.lineTo(48.0F, 74.127869F);
      localPath.cubicTo(48.0F, 77.548492F, 49.788952F, 82.434853F, 51.995739F, 85.050415F);
      localPath.lineTo(53.080338F, 86.335915F);
      localPath.cubicTo(54.858776F, 88.443787F, 54.286133F, 91.105621F, 51.823353F, 92.307426F);
      localPath.lineTo(34.842293F, 100.594F);
      localPath.cubicTo(32.994453F, 101.49573F, 31.5F, 103.89112F, 31.5F, 105.94639F);
      localPath.lineTo(31.5F, 108.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 48.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-15819547);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 96.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(38.306896F, 19.482126F);
      ((Path)localObject2).cubicTo(37.560726F, 17.111504F, 38.877605F, 14.584843F, 41.24823F, 13.838673F);
      ((Path)localObject2).cubicTo(43.618851F, 13.092503F, 46.145512F, 14.409382F, 46.891682F, 16.780005F);
      ((Path)localObject2).cubicTo(49.557262F, 25.248697F, 47.36401F, 34.579548F, 40.970562F, 40.972996F);
      ((Path)localObject2).cubicTo(31.59798F, 50.345577F, 16.40202F, 50.345577F, 7.029437F, 40.972996F);
      ((Path)localObject2).cubicTo(-2.343146F, 31.600412F, -2.343146F, 16.404453F, 7.029437F, 7.03187F);
      ((Path)localObject2).cubicTo(13.422884F, 0.6384233F, 22.753736F, -1.55483F, 31.222429F, 1.110751F);
      ((Path)localObject2).cubicTo(33.593052F, 1.856921F, 34.909931F, 4.383581F, 34.163761F, 6.754204F);
      ((Path)localObject2).cubicTo(33.417591F, 9.124827F, 30.89093F, 10.441707F, 28.520308F, 9.695536F);
      ((Path)localObject2).cubicTo(23.220871F, 8.027501F, 17.391516F, 9.397714F, 13.393398F, 13.395831F);
      ((Path)localObject2).cubicTo(7.535534F, 19.253696F, 7.535534F, 28.751171F, 13.393398F, 34.609035F);
      ((Path)localObject2).cubicTo(19.251263F, 40.4669F, 28.748737F, 40.4669F, 34.606602F, 34.609035F);
      ((Path)localObject2).cubicTo(38.604721F, 30.610918F, 39.974934F, 24.781563F, 38.306896F, 19.482126F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ayi
 * JD-Core Version:    0.7.0.1
 */