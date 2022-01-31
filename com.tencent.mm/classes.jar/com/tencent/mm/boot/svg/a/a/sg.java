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

public final class sg
  extends c
{
  private final int height = 108;
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
      return 108;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-11890462);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.lineTo(108.0F, 108.0F);
      localPath.lineTo(0.0F, 108.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(30.23671F, 67.604446F);
      ((Path)localObject).cubicTo(27.256218F, 63.563309F, 25.517647F, 58.701523F, 25.517647F, 53.470589F);
      ((Path)localObject).cubicTo(25.517647F, 39.436058F, 38.032604F, 28.058823F, 53.470589F, 28.058823F);
      ((Path)localObject).cubicTo(68.908569F, 28.058823F, 81.423531F, 39.436058F, 81.423531F, 53.470589F);
      ((Path)localObject).cubicTo(81.423531F, 67.505119F, 68.908569F, 78.882355F, 53.470589F, 78.882355F);
      ((Path)localObject).cubicTo(48.763218F, 78.882355F, 44.327625F, 77.824532F, 40.435741F, 75.956108F);
      ((Path)localObject).cubicTo(39.550022F, 75.529457F, 38.487812F, 75.472984F, 37.545677F, 75.728081F);
      ((Path)localObject).cubicTo(35.134289F, 76.382912F, 30.31151F, 77.692581F, 30.31151F, 77.692581F);
      ((Path)localObject).cubicTo(29.714825F, 77.854614F, 29.361446F, 77.497429F, 29.521812F, 76.894905F);
      ((Path)localObject).cubicTo(29.521812F, 76.894905F, 30.542793F, 73.058861F, 31.053284F, 71.140839F);
      ((Path)localObject).cubicTo(31.415718F, 69.684753F, 30.940517F, 68.555336F, 30.23671F, 67.604446F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(53.750118F, 57.423531F);
      ((Path)localObject).cubicTo(55.757057F, 57.423531F, 57.383999F, 55.780151F, 57.383999F, 53.752941F);
      ((Path)localObject).cubicTo(57.383999F, 51.725731F, 55.757057F, 50.082352F, 53.750118F, 50.082352F);
      ((Path)localObject).cubicTo(51.743179F, 50.082352F, 50.116234F, 51.725731F, 50.116234F, 53.752941F);
      ((Path)localObject).cubicTo(50.116234F, 55.780151F, 51.743179F, 57.423531F, 53.750118F, 57.423531F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.09647F, 57.423531F);
      ((Path)localObject).cubicTo(40.103409F, 57.423531F, 41.730354F, 55.780151F, 41.730354F, 53.752941F);
      ((Path)localObject).cubicTo(41.730354F, 51.725731F, 40.103409F, 50.082352F, 38.09647F, 50.082352F);
      ((Path)localObject).cubicTo(36.089531F, 50.082352F, 34.462589F, 51.725731F, 34.462589F, 53.752941F);
      ((Path)localObject).cubicTo(34.462589F, 55.780151F, 36.089531F, 57.423531F, 38.09647F, 57.423531F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(69.403763F, 57.423531F);
      ((Path)localObject).cubicTo(71.410706F, 57.423531F, 73.037643F, 55.780151F, 73.037643F, 53.752941F);
      ((Path)localObject).cubicTo(73.037643F, 51.725731F, 71.410706F, 50.082352F, 69.403763F, 50.082352F);
      ((Path)localObject).cubicTo(67.396828F, 50.082352F, 65.769882F, 51.725731F, 65.769882F, 53.752941F);
      ((Path)localObject).cubicTo(65.769882F, 55.780151F, 67.396828F, 57.423531F, 69.403763F, 57.423531F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sg
 * JD-Core Version:    0.7.0.1
 */