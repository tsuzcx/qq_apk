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

public final class bly
  extends c
{
  private final int height = 24;
  private final int width = 30;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 24;
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
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(26.0F, 0.0F);
      localPath.lineTo(26.0F, 20.0F);
      localPath.lineTo(0.0F, 20.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localPath.moveTo(24.0F, 2.0F);
      localPath.lineTo(2.0F, 2.0F);
      localPath.lineTo(2.0F, 17.0F);
      localPath.lineTo(24.0F, 17.0F);
      localPath.lineTo(24.0F, 2.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(28.0F, 23.0F);
      localPath.lineTo(29.0F, 23.0F);
      localPath.lineTo(29.0F, 3.0F);
      localPath.lineTo(27.0F, 3.0F);
      localPath.lineTo(27.0F, 21.0F);
      localPath.lineTo(3.0F, 21.0F);
      localPath.lineTo(3.0F, 23.0F);
      localPath.lineTo(28.0F, 23.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(19.784946F, 8.898396F);
      ((Path)localObject).lineTo(15.462585F, 11.916007F);
      ((Path)localObject).lineTo(8.518518F, 6.545455F);
      ((Path)localObject).lineTo(0.0F, 13.368984F);
      ((Path)localObject).lineTo(0.0F, 18.545454F);
      ((Path)localObject).lineTo(25.555555F, 18.545454F);
      ((Path)localObject).lineTo(25.555555F, 13.368984F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bly
 * JD-Core Version:    0.7.0.1
 */