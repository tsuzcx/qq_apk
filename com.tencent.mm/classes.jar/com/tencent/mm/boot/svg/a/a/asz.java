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

public final class asz
  extends c
{
  private final int height = 186;
  private final int width = 186;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 186;
      return 186;
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-15683841);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(186.0F, 94.148148F);
      localPath.cubicTo(186.0F, 41.636444F, 144.36356F, 0.0F, 91.851852F, 0.0F);
      localPath.cubicTo(41.636444F, 0.0F, 0.0F, 41.636444F, 0.0F, 94.148148F);
      localPath.cubicTo(0.0F, 144.36356F, 41.636444F, 186.0F, 91.851852F, 186.0F);
      localPath.cubicTo(144.36356F, 186.0F, 186.0F, 144.36356F, 186.0F, 94.148148F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(96.539574F, 101.59992F);
      ((Path)localObject).lineTo(93.960793F, 37.990128F);
      ((Path)localObject).cubicTo(93.939034F, 37.453369F, 93.474998F, 37.0F, 92.925255F, 37.0F);
      ((Path)localObject).lineTo(84.916054F, 37.0F);
      ((Path)localObject).cubicTo(84.37632F, 37.0F, 83.902679F, 37.443295F, 83.880516F, 37.990128F);
      ((Path)localObject).lineTo(81.001671F, 109.00153F);
      ((Path)localObject).cubicTo(80.974144F, 109.68064F, 81.288383F, 110.28124F, 81.791107F, 110.64247F);
      ((Path)localObject).cubicTo(81.98214F, 110.94476F, 82.257759F, 111.19843F, 82.60479F, 111.36398F);
      ((Path)localObject).lineTo(129.58261F, 133.77519F);
      ((Path)localObject).cubicTo(130.08742F, 134.01601F, 130.71049F, 133.82021F, 130.98582F, 133.34332F);
      ((Path)localObject).lineTo(133.9888F, 128.14203F);
      ((Path)localObject).cubicTo(134.26079F, 127.67092F, 134.11714F, 127.02809F, 133.66052F, 126.71911F);
      ((Path)localObject).lineTo(96.539574F, 101.59992F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asz
 * JD-Core Version:    0.7.0.1
 */