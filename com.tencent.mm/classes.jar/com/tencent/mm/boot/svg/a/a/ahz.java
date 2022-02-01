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

public final class ahz
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(10.25783F, 12.349655F);
      localPath.lineTo(13.508F, 15.6F);
      localPath.lineTo(12.0F, 15.6F);
      localPath.cubicTo(11.502944F, 15.6F, 11.1F, 16.002943F, 11.1F, 16.5F);
      localPath.lineTo(11.1F, 48.0F);
      localPath.cubicTo(11.1F, 48.497055F, 11.502944F, 48.900002F, 12.0F, 48.900002F);
      localPath.lineTo(26.1F, 48.900002F);
      localPath.lineTo(26.1F, 55.799999F);
      localPath.lineTo(33.008831F, 48.900002F);
      localPath.lineTo(46.807999F, 48.898998F);
      localPath.lineTo(50.409F, 52.5F);
      localPath.lineTo(34.5F, 52.5F);
      localPath.lineTo(27.621321F, 59.369999F);
      localPath.cubicTo(26.449747F, 60.541573F, 24.550253F, 60.541573F, 23.378679F, 59.369999F);
      localPath.cubicTo(22.816071F, 58.807392F, 22.5F, 58.065651F, 22.5F, 57.27F);
      localPath.lineTo(22.5F, 52.5F);
      localPath.lineTo(12.0F, 52.5F);
      localPath.cubicTo(9.514719F, 52.5F, 7.5F, 50.485283F, 7.5F, 48.0F);
      localPath.lineTo(7.5F, 16.5F);
      localPath.cubicTo(7.5F, 14.632412F, 8.637693F, 13.030547F, 10.25783F, 12.349655F);
      localPath.close();
      localPath.moveTo(60.0F, 12.0F);
      localPath.cubicTo(62.485283F, 12.0F, 64.5F, 14.014719F, 64.5F, 16.5F);
      localPath.lineTo(64.5F, 48.0F);
      localPath.cubicTo(64.5F, 50.485283F, 62.485283F, 52.5F, 60.0F, 52.5F);
      localPath.lineTo(55.5F, 52.5F);
      localPath.lineTo(51.898998F, 48.898998F);
      localPath.lineTo(60.0F, 48.900002F);
      localPath.cubicTo(60.497055F, 48.900002F, 60.900002F, 48.497055F, 60.900002F, 48.0F);
      localPath.lineTo(60.900002F, 16.5F);
      localPath.cubicTo(60.900002F, 16.002943F, 60.497055F, 15.6F, 60.0F, 15.6F);
      localPath.lineTo(18.599001F, 15.6F);
      localPath.lineTo(14.999F, 12.0F);
      localPath.lineTo(60.0F, 12.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(11.545586F, 8.545585F);
      ((Path)localObject).lineTo(14.09117F, 6.0F);
      ((Path)localObject).lineTo(64.27494F, 56.183765F);
      ((Path)localObject).lineTo(61.729351F, 58.729351F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahz
 * JD-Core Version:    0.7.0.1
 */