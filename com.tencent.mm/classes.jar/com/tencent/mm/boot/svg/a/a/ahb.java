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

public final class ahb
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
      localPaint2.setColor(-14671840);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(44.0F, 0.0F);
      localPath.cubicTo(46.209141F, 0.0F, 48.0F, 1.790861F, 48.0F, 4.0F);
      localPath.lineTo(48.0F, 44.0F);
      localPath.cubicTo(48.0F, 46.209141F, 46.209141F, 48.0F, 44.0F, 48.0F);
      localPath.lineTo(4.0F, 48.0F);
      localPath.cubicTo(1.790861F, 48.0F, 0.0F, 46.209141F, 0.0F, 44.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-15616);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 13.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 204, 31);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.361448F, 1.952645F);
      ((Path)localObject2).cubicTo(16.126657F, 3.079886F, 16.332129F, 4.269144F, 16.332129F, 6.769299F);
      ((Path)localObject2).cubicTo(16.332129F, 7.451479F, 16.149721F, 7.621433F, 16.3936F, 8.051712F);
      ((Path)localObject2).cubicTo(16.906F, 8.060103F, 19.500208F, 8.234269F, 20.209095F, 8.490161F);
      ((Path)localObject2).cubicTo(21.089422F, 8.807939F, 21.764603F, 9.31892F, 22.107843F, 10.083771F);
      ((Path)localObject2).cubicTo(23.332994F, 12.813801F, 21.794872F, 20.18185F, 18.917391F, 22.550528F);
      ((Path)localObject2).cubicTo(18.054035F, 23.261503F, 16.303766F, 23.174044F, 14.963611F, 23.283785F);
      ((Path)localObject2).cubicTo(14.332603F, 23.335329F, 11.736202F, 23.342722F, 7.207496F, 23.322222F);
      ((Path)localObject2).lineTo(7.207099F, 9.847586F);
      ((Path)localObject2).cubicTo(7.405709F, 9.748565F, 7.629142F, 9.623837F, 7.900378F, 9.464798F);
      ((Path)localObject2).cubicTo(8.686465F, 9.003915F, 9.149695F, 8.480839F, 9.49743F, 7.561347F);
      ((Path)localObject2).cubicTo(9.694043F, 7.040648F, 9.760807F, 6.529837F, 9.832299F, 5.018408F);
      ((Path)localObject2).cubicTo(9.841782F, 4.818275F, 9.844152F, 4.755302F, 9.860264F, 4.300997F);
      ((Path)localObject2).cubicTo(9.933334F, 2.240632F, 10.151803F, 1.506536F, 11.292878F, 0.9766398F);
      ((Path)localObject2).cubicTo(12.817902F, 0.268352F, 14.639641F, 0.8891153F, 15.361448F, 1.952645F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.707109F, 10.278362F);
      ((Path)localObject2).lineTo(5.707365F, 23.314808F);
      ((Path)localObject2).cubicTo(4.635487F, 23.309116F, 3.472677F, 23.302191F, 2.219274F, 23.294199F);
      ((Path)localObject2).cubicTo(1.155582F, 23.287859F, 0.2941177F, 22.433678F, 0.2941177F, 21.375988F);
      ((Path)localObject2).lineTo(0.2941177F, 12.275348F);
      ((Path)localObject2).cubicTo(0.2941177F, 11.213089F, 1.165207F, 10.357124F, 2.233762F, 10.357124F);
      ((Path)localObject2).lineTo(4.577087F, 10.357124F);
      ((Path)localObject2).cubicTo(4.956631F, 10.357124F, 5.32018F, 10.333967F, 5.707109F, 10.278362F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahb
 * JD-Core Version:    0.7.0.1
 */