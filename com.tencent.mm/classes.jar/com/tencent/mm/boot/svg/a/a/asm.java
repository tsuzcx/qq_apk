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

public final class asm
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-2012855);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(45.0F, 11.2F);
      localPath.lineTo(45.0F, 7.4F);
      localPath.cubicTo(42.200001F, 6.5F, 39.099998F, 6.0F, 36.0F, 6.0F);
      localPath.cubicTo(31.0F, 6.0F, 26.299999F, 7.2F, 22.1F, 9.4F);
      localPath.lineTo(36.099998F, 23.4F);
      localPath.lineTo(42.200001F, 29.5F);
      localPath.cubicTo(43.900002F, 31.1F, 45.0F, 33.400002F, 45.0F, 36.0F);
      localPath.lineTo(45.0F, 27.200001F);
      localPath.lineTo(28.5F, 10.7F);
      localPath.cubicTo(30.9F, 10.0F, 33.400002F, 9.599999F, 36.0F, 9.599999F);
      localPath.cubicTo(39.200001F, 9.599999F, 42.200001F, 10.099999F, 45.0F, 11.2F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1669083);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(24.799999F, 12.099999F);
      localPath.lineTo(22.1F, 9.4F);
      localPath.cubicTo(19.5F, 10.8F, 17.0F, 12.599999F, 14.8F, 14.8F);
      localPath.cubicTo(11.3F, 18.299999F, 8.8F, 22.5F, 7.4F, 27.0F);
      localPath.lineTo(27.200001F, 27.0F);
      localPath.lineTo(35.900002F, 27.0F);
      localPath.cubicTo(38.200001F, 27.0F, 40.517231F, 27.799999F, 42.31723F, 29.6F);
      localPath.lineTo(36.117229F, 23.4F);
      localPath.lineTo(12.8F, 23.4F);
      localPath.cubicTo(14.0F, 21.200001F, 15.5F, 19.200001F, 17.299999F, 17.299999F);
      localPath.cubicTo(19.6F, 15.099999F, 22.1F, 13.3F, 24.799999F, 12.099999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-3367936);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(11.2F, 27.0F);
      localPath.lineTo(7.4F, 27.0F);
      localPath.cubicTo(6.5F, 29.799999F, 6.0F, 32.900002F, 6.0F, 36.0F);
      localPath.cubicTo(6.0F, 41.0F, 7.2F, 45.700001F, 9.4F, 49.900002F);
      localPath.lineTo(23.4F, 35.900002F);
      localPath.lineTo(29.5F, 29.799999F);
      localPath.cubicTo(31.1F, 28.1F, 33.400002F, 27.0F, 36.0F, 27.0F);
      localPath.lineTo(27.200001F, 27.0F);
      localPath.lineTo(10.7F, 43.5F);
      localPath.cubicTo(10.0F, 41.099998F, 9.6F, 38.599998F, 9.6F, 36.0F);
      localPath.cubicTo(9.6F, 32.799999F, 10.2F, 29.799999F, 11.2F, 27.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-8208896);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(12.1F, 47.200001F);
      localPath.lineTo(9.4F, 49.900002F);
      localPath.cubicTo(10.8F, 52.5F, 12.6F, 55.0F, 14.8F, 57.200001F);
      localPath.cubicTo(18.299999F, 60.700001F, 22.5F, 63.200001F, 27.0F, 64.599998F);
      localPath.lineTo(27.0F, 44.799999F);
      localPath.lineTo(27.0F, 36.099998F);
      localPath.cubicTo(27.0F, 33.799999F, 27.799999F, 31.5F, 29.6F, 29.700001F);
      localPath.lineTo(23.4F, 35.900002F);
      localPath.lineTo(23.4F, 59.099998F);
      localPath.cubicTo(21.200001F, 57.900002F, 19.200001F, 56.400002F, 17.299999F, 54.599998F);
      localPath.cubicTo(15.1F, 52.400002F, 13.3F, 49.900002F, 12.1F, 47.200001F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-8930220);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(27.0F, 60.799999F);
      localPath.lineTo(27.0F, 64.599998F);
      localPath.cubicTo(29.799999F, 65.5F, 32.900002F, 66.0F, 36.0F, 66.0F);
      localPath.cubicTo(41.0F, 66.0F, 45.700001F, 64.800003F, 49.900002F, 62.599998F);
      localPath.lineTo(35.900002F, 48.599998F);
      localPath.lineTo(29.799999F, 42.5F);
      localPath.cubicTo(28.1F, 40.900002F, 27.0F, 38.599998F, 27.0F, 36.0F);
      localPath.lineTo(27.0F, 44.799999F);
      localPath.lineTo(43.599998F, 61.299999F);
      localPath.cubicTo(41.200001F, 62.0F, 38.700001F, 62.400002F, 36.099998F, 62.400002F);
      localPath.cubicTo(32.799999F, 62.400002F, 29.799999F, 61.799999F, 27.0F, 60.799999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16339370);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(47.200001F, 59.900002F);
      localPath.lineTo(49.900002F, 62.599998F);
      localPath.cubicTo(52.5F, 61.200001F, 55.0F, 59.400002F, 57.200001F, 57.200001F);
      localPath.cubicTo(60.700001F, 53.700001F, 63.200001F, 49.5F, 64.599998F, 45.0F);
      localPath.lineTo(44.799999F, 45.0F);
      localPath.lineTo(36.099998F, 45.0F);
      localPath.cubicTo(33.799999F, 45.0F, 31.5F, 44.200001F, 29.700001F, 42.400002F);
      localPath.lineTo(35.900002F, 48.599998F);
      localPath.lineTo(59.099998F, 48.599998F);
      localPath.cubicTo(57.900002F, 50.799999F, 56.400002F, 52.799999F, 54.599998F, 54.700001F);
      localPath.cubicTo(52.400002F, 56.900002F, 49.900002F, 58.599998F, 47.200001F, 59.900002F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-15624449);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(60.799999F, 45.0F);
      localPath.lineTo(64.599998F, 45.0F);
      localPath.cubicTo(65.5F, 42.200001F, 66.0F, 39.099998F, 66.0F, 36.0F);
      localPath.cubicTo(66.0F, 31.0F, 64.800003F, 26.299999F, 62.599998F, 22.1F);
      localPath.lineTo(48.599998F, 36.099998F);
      localPath.lineTo(42.5F, 42.200001F);
      localPath.cubicTo(40.900002F, 43.900002F, 38.599998F, 45.0F, 36.0F, 45.0F);
      localPath.lineTo(44.799999F, 45.0F);
      localPath.lineTo(61.299999F, 28.4F);
      localPath.cubicTo(62.0F, 30.799999F, 62.400002F, 33.299999F, 62.400002F, 35.900002F);
      localPath.cubicTo(62.400002F, 39.200001F, 61.799999F, 42.200001F, 60.799999F, 45.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-9144602);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(59.900002F, 24.799999F);
      ((Path)localObject).lineTo(62.599998F, 22.1F);
      ((Path)localObject).cubicTo(61.200001F, 19.5F, 59.400002F, 17.0F, 57.200001F, 14.8F);
      ((Path)localObject).cubicTo(53.700001F, 11.3F, 49.5F, 8.8F, 45.0F, 7.4F);
      ((Path)localObject).lineTo(45.0F, 27.200001F);
      ((Path)localObject).lineTo(45.0F, 35.900002F);
      ((Path)localObject).cubicTo(45.0F, 38.200001F, 44.200001F, 40.512424F, 42.400002F, 42.312424F);
      ((Path)localObject).lineTo(48.599998F, 36.099998F);
      ((Path)localObject).lineTo(48.599998F, 12.8F);
      ((Path)localObject).cubicTo(50.799999F, 14.0F, 52.799999F, 15.5F, 54.700001F, 17.299999F);
      ((Path)localObject).cubicTo(56.900002F, 19.6F, 58.700001F, 22.1F, 59.900002F, 24.799999F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asm
 * JD-Core Version:    0.7.0.1
 */