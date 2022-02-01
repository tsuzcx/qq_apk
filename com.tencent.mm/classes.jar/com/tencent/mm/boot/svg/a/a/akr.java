package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class akr
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 19.5F);
      ((Path)localObject).cubicTo(45.257992F, 19.5F, 53.36367F, 26.097805F, 57.831261F, 34.052135F);
      ((Path)localObject).cubicTo(48.806961F, 37.807449F, 34.205029F, 43.891659F, 34.205029F, 43.891659F);
      ((Path)localObject).cubicTo(33.900082F, 43.996475F, 33.571373F, 44.055946F, 33.228405F, 44.055946F);
      ((Path)localObject).cubicTo(32.651779F, 44.055946F, 32.113964F, 43.89389F, 31.666443F, 43.618839F);
      ((Path)localObject).lineTo(31.666443F, 43.618839F);
      ((Path)localObject).lineTo(25.523943F, 39.514637F);
      ((Path)localObject).cubicTo(25.363945F, 39.403133F, 25.168303F, 39.336971F, 24.95286F, 39.336971F);
      ((Path)localObject).cubicTo(24.426926F, 39.336971F, 24.0F, 39.736908F, 24.0F, 40.230515F);
      ((Path)localObject).cubicTo(24.0F, 40.359119F, 24.034851F, 40.49144F, 24.091087F, 40.60815F);
      ((Path)localObject).lineTo(24.091087F, 40.60815F);
      ((Path)localObject).lineTo(29.297363F, 51.329178F);
      ((Path)localObject).lineTo(29.421717F, 51.5849F);
      ((Path)localObject).cubicTo(29.748051F, 52.130539F, 30.369825F, 52.5F, 31.085064F, 52.5F);
      ((Path)localObject).cubicTo(31.393179F, 52.5F, 31.683868F, 52.428635F, 31.942083F, 52.307465F);
      ((Path)localObject).lineTo(31.942083F, 52.307465F);
      ((Path)localObject).lineTo(32.151192F, 52.193726F);
      ((Path)localObject).cubicTo(32.151192F, 52.193726F, 48.021008F, 43.603085F, 59.466225F, 37.407566F);
      ((Path)localObject).cubicTo(60.77533F, 40.561371F, 61.5F, 43.808155F, 61.5F, 46.85294F);
      ((Path)localObject).cubicTo(61.5F, 58.938232F, 50.08326F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(21.916739F, 66.0F, 10.5F, 58.938232F, 10.5F, 46.85294F);
      ((Path)localObject).cubicTo(10.5F, 34.767651F, 21.916739F, 19.5F, 36.0F, 19.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.291172F, 7.344808F);
      ((Path)localObject).cubicTo(34.05595F, 7.707764F, 34.514912F, 7.922083F, 34.99791F, 8.138975F);
      ((Path)localObject).cubicTo(37.293617F, 9.169874F, 38.90189F, 9.653906F, 40.273438F, 9.653906F);
      ((Path)localObject).cubicTo(41.783073F, 9.653906F, 43.063473F, 9.488051F, 44.701939F, 9.143051F);
      ((Path)localObject).cubicTo(49.609493F, 8.109704F, 50.804661F, 8.202975F, 52.67065F, 11.157084F);
      ((Path)localObject).cubicTo(54.380756F, 13.864397F, 53.16061F, 16.982483F, 49.438065F, 20.644819F);
      ((Path)localObject).cubicTo(45.36388F, 18.054356F, 40.756786F, 16.5F, 36.0F, 16.5F);
      ((Path)localObject).cubicTo(31.537867F, 16.5F, 27.207455F, 17.867756F, 23.325562F, 20.175764F);
      ((Path)localObject).cubicTo(18.311489F, 14.415737F, 17.180632F, 9.767063F, 20.667408F, 6.4454F);
      ((Path)localObject).cubicTo(23.741673F, 3.516714F, 26.464617F, 4.105002F, 33.291172F, 7.344808F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.akr
 * JD-Core Version:    0.7.0.1
 */