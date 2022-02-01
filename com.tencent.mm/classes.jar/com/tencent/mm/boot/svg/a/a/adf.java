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

public final class adf
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localCanvas.saveLayerAlpha(null, 51, 31);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-13421773);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(24.0F, 41.599998F);
      localPath.cubicTo(33.720211F, 41.599998F, 41.599998F, 33.720211F, 41.599998F, 24.0F);
      localPath.cubicTo(41.599998F, 14.279788F, 33.720211F, 6.4F, 24.0F, 6.4F);
      localPath.cubicTo(14.279788F, 6.4F, 6.4F, 14.279788F, 6.4F, 24.0F);
      localPath.cubicTo(6.4F, 33.720211F, 14.279788F, 41.599998F, 24.0F, 41.599998F);
      localPath.close();
      localPath.moveTo(24.0F, 44.0F);
      localPath.cubicTo(12.954305F, 44.0F, 4.0F, 35.045696F, 4.0F, 24.0F);
      localPath.cubicTo(4.0F, 12.954305F, 12.954305F, 4.0F, 24.0F, 4.0F);
      localPath.cubicTo(35.045696F, 4.0F, 44.0F, 12.954305F, 44.0F, 24.0F);
      localPath.cubicTo(44.0F, 35.045696F, 35.045696F, 44.0F, 24.0F, 44.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-13421773);
      localPaint.setStrokeWidth(2.4F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(24.0F, 11.2F);
      ((Path)localObject).cubicTo(31.069244F, 11.2F, 36.799999F, 16.930756F, 36.799999F, 24.0F);
      ((Path)localObject).cubicTo(36.799999F, 31.069244F, 31.069244F, 36.799999F, 24.0F, 36.799999F);
      ((Path)localObject).cubicTo(16.930756F, 36.799999F, 11.2F, 31.069244F, 11.2F, 24.0F);
      ((Path)localObject).cubicTo(11.2F, 16.930756F, 16.930756F, 11.2F, 24.0F, 11.2F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.adf
 * JD-Core Version:    0.7.0.1
 */