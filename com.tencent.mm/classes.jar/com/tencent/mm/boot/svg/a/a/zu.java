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

public final class zu
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
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.m(paramVarArgs);
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-16777216);
      localCanvas.save();
      Object localObject = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(43.491169F, 12.6F);
      localPath.lineTo(14.091168F, 42.0F);
      localPath.lineTo(29.999989F, 57.908821F);
      localPath.lineTo(59.398491F, 28.508768F);
      localPath.lineTo(59.399723F, 12.6F);
      localPath.lineTo(43.491169F, 12.6F);
      localPath.close();
      localPath.moveTo(60.0F, 9.0F);
      localPath.cubicTo(61.657085F, 8.999896F, 63.00013F, 10.343145F, 63.0F, 12.0F);
      localPath.lineTo(62.99847F, 28.757538F);
      localPath.cubicTo(62.998409F, 29.553082F, 62.682365F, 30.316027F, 62.119843F, 30.878574F);
      localPath.lineTo(32.121319F, 60.878681F);
      localPath.cubicTo(30.949696F, 62.050304F, 29.0502F, 62.050304F, 27.878628F, 60.878731F);
      localPath.lineTo(11.121321F, 44.121319F);
      localPath.cubicTo(9.949747F, 42.949749F, 9.949747F, 41.050251F, 11.121321F, 39.878681F);
      localPath.lineTo(41.121319F, 9.878679F);
      localPath.cubicTo(41.683929F, 9.316071F, 42.446991F, 9.0F, 43.242641F, 9.0F);
      localPath.lineTo(60.0F, 9.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint1.setStrokeWidth(1.2F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(48.0F, 20.4F);
      ((Path)localObject).cubicTo(49.988224F, 20.4F, 51.599998F, 22.011774F, 51.599998F, 24.0F);
      ((Path)localObject).cubicTo(51.599998F, 25.988226F, 49.988224F, 27.6F, 48.0F, 27.6F);
      ((Path)localObject).cubicTo(46.011776F, 27.6F, 44.400002F, 25.988226F, 44.400002F, 24.0F);
      ((Path)localObject).cubicTo(44.400002F, 22.011774F, 46.011776F, 20.4F, 48.0F, 20.4F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.zu
 * JD-Core Version:    0.7.0.1
 */