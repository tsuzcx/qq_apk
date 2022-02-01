package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class shortvideo_pause_btn
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(637534208);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(60.0F, 0.0F);
      localPath.cubicTo(93.137085F, 0.0F, 120.0F, 26.862915F, 120.0F, 60.0F);
      localPath.cubicTo(120.0F, 93.137085F, 93.137085F, 120.0F, 60.0F, 120.0F);
      localPath.cubicTo(26.862915F, 120.0F, 0.0F, 93.137085F, 0.0F, 60.0F);
      localPath.cubicTo(0.0F, 26.862915F, 26.862915F, 0.0F, 60.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(60.0F, 0.0F);
      ((Path)localObject).cubicTo(93.137085F, 0.0F, 120.0F, 26.862915F, 120.0F, 60.0F);
      ((Path)localObject).cubicTo(120.0F, 93.137085F, 93.137085F, 120.0F, 60.0F, 120.0F);
      ((Path)localObject).cubicTo(26.862915F, 120.0F, 0.0F, 93.137085F, 0.0F, 60.0F);
      ((Path)localObject).cubicTo(0.0F, 26.862915F, 26.862915F, 0.0F, 60.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.0F, 3.6F);
      ((Path)localObject).cubicTo(28.851141F, 3.6F, 3.6F, 28.851141F, 3.6F, 60.0F);
      ((Path)localObject).cubicTo(3.6F, 91.148857F, 28.851141F, 116.4F, 60.0F, 116.4F);
      ((Path)localObject).cubicTo(91.148857F, 116.4F, 116.4F, 91.148857F, 116.4F, 60.0F);
      ((Path)localObject).cubicTo(116.4F, 28.851141F, 91.148857F, 3.6F, 60.0F, 3.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.615383F, 38.0F);
      ((Path)localObject).lineTo(50.846153F, 38.0F);
      ((Path)localObject).cubicTo(52.290592F, 38.0F, 53.46154F, 39.313297F, 53.46154F, 40.933334F);
      ((Path)localObject).lineTo(53.46154F, 79.066666F);
      ((Path)localObject).cubicTo(53.46154F, 80.686699F, 52.290592F, 82.0F, 50.846153F, 82.0F);
      ((Path)localObject).lineTo(45.615383F, 82.0F);
      ((Path)localObject).cubicTo(44.170948F, 82.0F, 43.0F, 80.686699F, 43.0F, 79.066666F);
      ((Path)localObject).lineTo(43.0F, 40.933334F);
      ((Path)localObject).cubicTo(43.0F, 39.313297F, 44.170948F, 38.0F, 45.615383F, 38.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(69.153847F, 38.0F);
      ((Path)localObject).lineTo(74.384613F, 38.0F);
      ((Path)localObject).cubicTo(75.829056F, 38.0F, 77.0F, 39.313297F, 77.0F, 40.933334F);
      ((Path)localObject).lineTo(77.0F, 79.066666F);
      ((Path)localObject).cubicTo(77.0F, 80.686699F, 75.829056F, 82.0F, 74.384613F, 82.0F);
      ((Path)localObject).lineTo(69.153847F, 82.0F);
      ((Path)localObject).cubicTo(67.709412F, 82.0F, 66.53846F, 80.686699F, 66.53846F, 79.066666F);
      ((Path)localObject).lineTo(66.53846F, 40.933334F);
      ((Path)localObject).cubicTo(66.53846F, 39.313297F, 67.709412F, 38.0F, 69.153847F, 38.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.shortvideo_pause_btn
 * JD-Core Version:    0.7.0.1
 */