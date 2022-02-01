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

public final class bnh
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-2565928);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(60.0F, 0.0F);
      localPath.lineTo(60.0F, 60.0F);
      localPath.lineTo(0.0F, 60.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(6.0F, 30.0F);
      ((Path)localObject).cubicTo(6.0F, 43.200001F, 16.799999F, 54.0F, 30.0F, 54.0F);
      ((Path)localObject).cubicTo(43.200001F, 54.0F, 54.0F, 43.200001F, 54.0F, 30.0F);
      ((Path)localObject).cubicTo(54.0F, 16.799999F, 43.200001F, 6.0F, 30.0F, 6.0F);
      ((Path)localObject).cubicTo(16.799999F, 6.0F, 6.0F, 16.799999F, 6.0F, 30.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.0F, 30.0F);
      ((Path)localObject).cubicTo(10.0F, 19.0F, 19.0F, 10.0F, 30.0F, 10.0F);
      ((Path)localObject).cubicTo(41.0F, 10.0F, 50.0F, 19.0F, 50.0F, 30.0F);
      ((Path)localObject).cubicTo(50.0F, 41.0F, 41.0F, 50.0F, 30.0F, 50.0F);
      ((Path)localObject).cubicTo(19.0F, 50.0F, 10.0F, 41.0F, 10.0F, 30.0F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 25, 31);
      localPaint = c.a(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bnh
 * JD-Core Version:    0.7.0.1
 */