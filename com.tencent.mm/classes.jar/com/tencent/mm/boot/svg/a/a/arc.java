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

public final class arc
  extends c
{
  private final int height = 76;
  private final int width = 76;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 76;
      return 76;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject3 = c.g(paramVarArgs);
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
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-789517);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.cubicTo(74.209137F, 0.0F, 76.0F, 1.790861F, 76.0F, 4.0F);
      localPath.lineTo(76.0F, 72.0F);
      localPath.cubicTo(76.0F, 74.209137F, 74.209137F, 76.0F, 72.0F, 76.0F);
      localPath.lineTo(4.0F, 76.0F);
      localPath.cubicTo(1.790861F, 76.0F, 0.0F, 74.209137F, 0.0F, 72.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-5658199);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 14.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(3.077093F, 0.4082286F);
      ((Path)localObject3).cubicTo(6.376807F, -1.148992F, 10.591013F, 1.994287F, 9.93107F, 5.685477F);
      ((Path)localObject3).cubicTo(9.553961F, 9.520855F, 4.528967F, 11.36645F, 1.757207F, 8.838369F);
      ((Path)localObject3).cubicTo(-1.137114F, 6.656337F, -0.2886157F, 1.590563F, 3.077093F, 0.4082286F);
      ((Path)localObject3).lineTo(3.077093F, 0.4082286F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(23.623188F, 16.071012F);
      ((Path)localObject3).cubicTo(26.064592F, 14.068773F, 28.851942F, 12.245839F, 32.093967F, 12.086457F);
      ((Path)localObject3).cubicTo(38.943733F, 11.219816F, 45.902229F, 16.987459F, 45.931881F, 24.050083F);
      ((Path)localObject3).cubicTo(46.070259F, 31.361742F, 45.951649F, 38.673401F, 45.971416F, 45.985058F);
      ((Path)localObject3).cubicTo(42.976498F, 46.004982F, 39.971695F, 46.004982F, 36.976776F, 45.985058F);
      ((Path)localObject3).cubicTo(36.897701F, 39.330853F, 37.075615F, 32.676643F, 36.927353F, 26.022438F);
      ((Path)localObject3).cubicTo(37.085503F, 22.396492F, 33.734749F, 19.238733F, 30.196198F, 19.418037F);
      ((Path)localObject3).cubicTo(26.677414F, 19.28854F, 23.465042F, 22.436338F, 23.553999F, 25.992554F);
      ((Path)localObject3).cubicTo(23.326662F, 32.656723F, 23.563883F, 39.320889F, 23.455156F, 45.995018F);
      ((Path)localObject3).lineTo(16.04199F, 45.995018F);
      ((Path)localObject3).cubicTo(16.170485F, 35.127148F, 15.755347F, 24.249311F, 16.249557F, 13.391398F);
      ((Path)localObject3).cubicTo(18.52293F, 13.431244F, 20.796301F, 13.441206F, 23.079557F, 13.431244F);
      ((Path)localObject3).cubicTo(23.208052F, 14.088696F, 23.48481F, 15.403599F, 23.623188F, 16.071012F);
      ((Path)localObject3).lineTo(23.623188F, 16.071012F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(1.0F, 13.019893F);
      ((Path)localObject2).cubicTo(3.673657F, 12.989608F, 6.336828F, 12.989608F, 9.0F, 13.050178F);
      ((Path)localObject2).cubicTo(8.968545F, 24.023357F, 9.010485F, 34.996536F, 8.979031F, 45.979809F);
      ((Path)localObject2).cubicTo(6.326344F, 45.989906F, 3.684142F, 46.0F, 1.031455F, 46.0F);
      ((Path)localObject2).cubicTo(1.0F, 35.00663F, 1.052425F, 24.013262F, 1.0F, 13.019893F);
      ((Path)localObject2).lineTo(1.0F, 13.019893F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.arc
 * JD-Core Version:    0.7.0.1
 */