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

public final class awa
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
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(34.200001F, 15.0F);
      localPath.lineTo(37.799999F, 15.0F);
      localPath.lineTo(37.799999F, 59.001263F);
      localPath.lineTo(36.0F, 60.0F);
      localPath.lineTo(34.200001F, 59.001263F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(3.6F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 14.785034F);
      ((Path)localObject).lineTo(59.572838F, 11.394009F);
      ((Path)localObject).cubicTo(61.212811F, 11.158093F, 62.733517F, 12.296308F, 62.969433F, 13.936279F);
      ((Path)localObject).cubicTo(62.989784F, 14.077757F, 63.0F, 14.220509F, 63.0F, 14.363441F);
      ((Path)localObject).lineTo(63.0F, 50.394005F);
      ((Path)localObject).cubicTo(63.0F, 53.377686F, 60.807602F, 55.908035F, 57.854324F, 56.332874F);
      ((Path)localObject).lineTo(36.0F, 59.476685F);
      ((Path)localObject).lineTo(14.145676F, 56.332874F);
      ((Path)localObject).cubicTo(11.192398F, 55.908035F, 9.0F, 53.377686F, 9.0F, 50.394005F);
      ((Path)localObject).lineTo(9.0F, 14.363441F);
      ((Path)localObject).cubicTo(9.0F, 14.220509F, 9.010215F, 14.077757F, 9.030567F, 13.936279F);
      ((Path)localObject).cubicTo(9.266482F, 12.296308F, 10.787189F, 11.158093F, 12.427162F, 11.394009F);
      ((Path)localObject).lineTo(36.0F, 14.785034F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awa
 * JD-Core Version:    0.7.0.1
 */