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

public final class ben
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(72.0F, 124.8F);
      localPath.cubicTo(101.16064F, 124.8F, 124.8F, 101.16064F, 124.8F, 72.0F);
      localPath.cubicTo(124.8F, 42.839367F, 101.16064F, 19.200001F, 72.0F, 19.200001F);
      localPath.cubicTo(42.839367F, 19.200001F, 19.200001F, 42.839367F, 19.200001F, 72.0F);
      localPath.cubicTo(19.200001F, 101.16064F, 42.839367F, 124.8F, 72.0F, 124.8F);
      localPath.close();
      localPath.moveTo(72.0F, 132.0F);
      localPath.cubicTo(38.862915F, 132.0F, 12.0F, 105.13708F, 12.0F, 72.0F);
      localPath.cubicTo(12.0F, 38.862915F, 38.862915F, 12.0F, 72.0F, 12.0F);
      localPath.cubicTo(105.13708F, 12.0F, 132.0F, 38.862915F, 132.0F, 72.0F);
      localPath.cubicTo(132.0F, 105.13708F, 105.13708F, 132.0F, 72.0F, 132.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(72.0F, 106.8F);
      ((Path)localObject).cubicTo(91.219513F, 106.8F, 106.8F, 91.219513F, 106.8F, 72.0F);
      ((Path)localObject).cubicTo(106.8F, 52.780491F, 91.219513F, 37.200001F, 72.0F, 37.200001F);
      ((Path)localObject).cubicTo(52.780491F, 37.200001F, 37.200001F, 52.780491F, 37.200001F, 72.0F);
      ((Path)localObject).cubicTo(37.200001F, 91.219513F, 52.780491F, 106.8F, 72.0F, 106.8F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(72.0F, 114.0F);
      ((Path)localObject).cubicTo(48.804039F, 114.0F, 30.0F, 95.195961F, 30.0F, 72.0F);
      ((Path)localObject).cubicTo(30.0F, 48.804039F, 48.804039F, 30.0F, 72.0F, 30.0F);
      ((Path)localObject).cubicTo(95.195961F, 30.0F, 114.0F, 48.804039F, 114.0F, 72.0F);
      ((Path)localObject).cubicTo(114.0F, 95.195961F, 95.195961F, 114.0F, 72.0F, 114.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ben
 * JD-Core Version:    0.7.0.1
 */