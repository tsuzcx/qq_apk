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

public final class bfk
  extends c
{
  private final int height = 242;
  private final int width = 245;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 245;
      return 242;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-3552823);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 55.0F, 0.0F, 1.0F, 75.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(134.481F, 27.639999F);
      ((Path)localObject2).lineTo(125.895F, 36.226002F);
      ((Path)localObject2).cubicTo(110.961F, 21.261F, 90.311996F, 12.0F, 67.499001F, 12.0F);
      ((Path)localObject2).cubicTo(44.686001F, 12.0F, 24.037001F, 21.261F, 9.103F, 36.226002F);
      ((Path)localObject2).lineTo(0.517F, 27.639999F);
      ((Path)localObject2).cubicTo(17.694F, 10.56F, 41.362F, 0.0F, 67.499001F, 0.0F);
      ((Path)localObject2).cubicTo(93.636002F, 0.0F, 117.304F, 10.56F, 134.481F, 27.639999F);
      ((Path)localObject2).lineTo(134.481F, 27.639999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(115.389F, 46.731998F);
      ((Path)localObject2).lineTo(106.807F, 55.313999F);
      ((Path)localObject2).cubicTo(96.758003F, 45.234001F, 82.859001F, 38.995998F, 67.500999F, 38.995998F);
      ((Path)localObject2).cubicTo(52.141998F, 38.995998F, 38.242001F, 45.235001F, 28.191999F, 55.316002F);
      ((Path)localObject2).lineTo(19.608F, 46.731998F);
      ((Path)localObject2).cubicTo(31.899F, 34.536999F, 48.817001F, 27.0F, 67.499001F, 27.0F);
      ((Path)localObject2).cubicTo(86.181F, 27.0F, 103.098F, 34.536999F, 115.389F, 46.731998F);
      ((Path)localObject2).lineTo(115.389F, 46.731998F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(96.195999F, 65.925003F);
      ((Path)localObject2).lineTo(87.607002F, 74.514F);
      ((Path)localObject2).cubicTo(82.516998F, 69.262001F, 75.392998F, 65.992996F, 67.501999F, 65.992996F);
      ((Path)localObject2).cubicTo(59.609001F, 65.992996F, 52.484001F, 69.263F, 47.394001F, 74.516998F);
      ((Path)localObject2).lineTo(38.801998F, 65.925003F);
      ((Path)localObject2).cubicTo(46.134998F, 58.560001F, 56.284F, 54.0F, 67.499001F, 54.0F);
      ((Path)localObject2).cubicTo(78.713997F, 54.0F, 88.862F, 58.560001F, 96.195999F, 65.925003F);
      ((Path)localObject2).lineTo(96.195999F, 65.925003F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(77.199997F, 84.920998F);
      ((Path)localObject2).lineTo(67.498001F, 94.623001F);
      ((Path)localObject2).lineTo(57.796001F, 84.921997F);
      ((Path)localObject2).cubicTo(60.313999F, 82.497002F, 63.729F, 81.0F, 67.499001F, 81.0F);
      ((Path)localObject2).cubicTo(71.268997F, 81.0F, 74.682999F, 82.497002F, 77.199997F, 84.920998F);
      ((Path)localObject2).lineTo(77.199997F, 84.920998F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3552823);
      localPaint1.setStrokeWidth(4.0F);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(123.0F, 7.0F);
      ((Path)localObject1).cubicTo(185.96046F, 7.0F, 237.0F, 58.039536F, 237.0F, 121.0F);
      ((Path)localObject1).cubicTo(237.0F, 183.96046F, 185.96046F, 235.0F, 123.0F, 235.0F);
      ((Path)localObject1).cubicTo(60.039536F, 235.0F, 9.0F, 183.96046F, 9.0F, 121.0F);
      ((Path)localObject1).cubicTo(9.0F, 58.039536F, 60.039536F, 7.0F, 123.0F, 7.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bfk
 * JD-Core Version:    0.7.0.1
 */