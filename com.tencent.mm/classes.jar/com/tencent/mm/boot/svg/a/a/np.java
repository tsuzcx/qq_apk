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

public final class np
  extends c
{
  private final int height = 102;
  private final int width = 102;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 102;
      return 102;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(51.0F, 102.0F);
      localPath.cubicTo(79.166519F, 102.0F, 102.0F, 79.166519F, 102.0F, 51.0F);
      localPath.cubicTo(102.0F, 22.833477F, 79.166519F, 0.0F, 51.0F, 0.0F);
      localPath.cubicTo(22.833477F, 0.0F, 0.0F, 22.833477F, 0.0F, 51.0F);
      localPath.cubicTo(0.0F, 79.166519F, 22.833477F, 102.0F, 51.0F, 102.0F);
      localPath.lineTo(51.0F, 102.0F);
      localPath.close();
      localPath.moveTo(51.0F, 98.0F);
      localPath.cubicTo(76.957382F, 98.0F, 98.0F, 76.957382F, 98.0F, 51.0F);
      localPath.cubicTo(98.0F, 25.042616F, 76.957382F, 4.0F, 51.0F, 4.0F);
      localPath.cubicTo(25.042616F, 4.0F, 4.0F, 25.042616F, 4.0F, 51.0F);
      localPath.cubicTo(4.0F, 76.957382F, 25.042616F, 98.0F, 51.0F, 98.0F);
      localPath.lineTo(51.0F, 98.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(60.046738F, 37.910957F);
      ((Path)localObject).cubicTo(69.133621F, 37.910957F, 76.5F, 45.204285F, 76.5F, 54.205479F);
      ((Path)localObject).cubicTo(76.5F, 63.204693F, 69.134888F, 70.5F, 60.046738F, 70.5F);
      ((Path)localObject).lineTo(29.047552F, 70.5F);
      ((Path)localObject).cubicTo(28.745148F, 70.5F, 28.5F, 70.256561F, 28.5F, 69.968216F);
      ((Path)localObject).lineTo(28.5F, 65.689323F);
      ((Path)localObject).cubicTo(28.5F, 65.395622F, 28.735804F, 65.157532F, 29.047586F, 65.157532F);
      ((Path)localObject).lineTo(60.048687F, 65.157532F);
      ((Path)localObject).cubicTo(66.152725F, 65.157532F, 71.106743F, 60.254131F, 71.106743F, 54.205479F);
      ((Path)localObject).cubicTo(71.106743F, 48.155499F, 66.155884F, 43.253426F, 60.048687F, 43.253426F);
      ((Path)localObject).lineTo(40.83506F, 43.253426F);
      ((Path)localObject).lineTo(40.83506F, 48.971561F);
      ((Path)localObject).cubicTo(40.83506F, 49.56155F, 40.448963F, 49.755066F, 39.972683F, 49.402626F);
      ((Path)localObject).lineTo(28.857897F, 41.177834F);
      ((Path)localObject).cubicTo(28.379784F, 40.824039F, 28.38162F, 40.253983F, 28.857897F, 39.901543F);
      ((Path)localObject).lineTo(39.972683F, 31.676752F);
      ((Path)localObject).cubicTo(40.450798F, 31.322954F, 40.83506F, 31.517307F, 40.83506F, 32.107815F);
      ((Path)localObject).lineTo(40.83506F, 37.910957F);
      ((Path)localObject).lineTo(60.046738F, 37.910957F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.np
 * JD-Core Version:    0.7.0.1
 */