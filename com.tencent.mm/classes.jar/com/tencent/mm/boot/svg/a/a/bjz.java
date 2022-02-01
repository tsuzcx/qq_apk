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

public final class bjz
  extends c
{
  private final int height = 36;
  private final int width = 36;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 36;
      return 36;
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-352965);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(18.0F, 36.0F);
      localPath.cubicTo(8.058874F, 36.0F, 0.0F, 27.941126F, 0.0F, 18.0F);
      localPath.cubicTo(0.0F, 8.058874F, 8.058874F, 0.0F, 18.0F, 0.0F);
      localPath.cubicTo(27.941126F, 0.0F, 36.0F, 8.058874F, 36.0F, 18.0F);
      localPath.cubicTo(36.0F, 27.941126F, 27.941126F, 36.0F, 18.0F, 36.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(15.882187F, 21.850769F);
      ((Path)localObject).lineTo(25.960957F, 11.772F);
      ((Path)localObject).lineTo(27.873507F, 13.684549F);
      ((Path)localObject).lineTo(17.159441F, 24.394556F);
      ((Path)localObject).cubicTo(16.45635F, 25.097353F, 15.316654F, 25.097116F, 14.613856F, 24.394026F);
      ((Path)localObject).cubicTo(14.613791F, 24.393961F, 14.613726F, 24.393896F, 14.613661F, 24.393831F);
      ((Path)localObject).lineTo(9.0F, 18.775719F);
      ((Path)localObject).lineTo(10.903567F, 16.87215F);
      ((Path)localObject).lineTo(15.882187F, 21.850769F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bjz
 * JD-Core Version:    0.7.0.1
 */