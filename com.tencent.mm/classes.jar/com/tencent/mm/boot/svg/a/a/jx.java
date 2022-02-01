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

public final class jx
  extends c
{
  private final int height = 54;
  private final int width = 54;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 54;
      return 54;
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
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-13290187);
      ((Paint)localObject).setStrokeWidth(4.0F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(27.0F, 2.0F);
      localPath.cubicTo(40.807121F, 2.0F, 52.0F, 13.192881F, 52.0F, 27.0F);
      localPath.cubicTo(52.0F, 40.807121F, 40.807121F, 52.0F, 27.0F, 52.0F);
      localPath.cubicTo(13.192881F, 52.0F, 2.0F, 40.807121F, 2.0F, 27.0F);
      localPath.cubicTo(2.0F, 13.192881F, 13.192881F, 2.0F, 27.0F, 2.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-13290187);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(18.515137F, 20.405273F);
      ((Path)localObject).lineTo(22.760254F, 20.405273F);
      ((Path)localObject).cubicTo(22.944824F, 17.780273F, 24.77002F, 16.119141F, 27.600098F, 16.119141F);
      ((Path)localObject).cubicTo(30.409668F, 16.119141F, 32.234863F, 17.759766F, 32.234863F, 20.015625F);
      ((Path)localObject).cubicTo(32.234863F, 22.086914F, 31.353027F, 23.255859F, 28.871582F, 24.75293F);
      ((Path)localObject).cubicTo(26.062012F, 26.43457F, 24.811035F, 28.280273F, 24.913574F, 31.233398F);
      ((Path)localObject).lineTo(24.934082F, 32.791992F);
      ((Path)localObject).lineTo(29.179199F, 32.791992F);
      ((Path)localObject).lineTo(29.179199F, 31.561523F);
      ((Path)localObject).cubicTo(29.179199F, 29.490234F, 29.937988F, 28.40332F, 32.583496F, 26.844727F);
      ((Path)localObject).cubicTo(35.290527F, 25.224609F, 36.890137F, 22.989258F, 36.890137F, 19.831055F);
      ((Path)localObject).cubicTo(36.890137F, 15.380859F, 33.239746F, 12.161133F, 27.825684F, 12.161133F);
      ((Path)localObject).cubicTo(21.878418F, 12.161133F, 18.699707F, 15.688477F, 18.515137F, 20.405273F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.312988F, 42.47168F);
      ((Path)localObject).cubicTo(29.199707F, 42.47168F, 30.471191F, 41.220703F, 30.471191F, 39.354492F);
      ((Path)localObject).cubicTo(30.471191F, 37.447266F, 29.199707F, 36.196289F, 27.312988F, 36.196289F);
      ((Path)localObject).cubicTo(25.42627F, 36.196289F, 24.134277F, 37.447266F, 24.134277F, 39.354492F);
      ((Path)localObject).cubicTo(24.134277F, 41.220703F, 25.42627F, 42.47168F, 27.312988F, 42.47168F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.jx
 * JD-Core Version:    0.7.0.1
 */