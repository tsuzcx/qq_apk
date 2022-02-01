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

public final class kp
  extends c
{
  private final int height = 42;
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
      return 42;
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
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-2631721);
      ((Paint)localObject).setStrokeWidth(1.5F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.75F, 21.0F);
      localPath.cubicTo(0.75F, 9.816234F, 9.816234F, 0.75F, 21.0F, 0.75F);
      localPath.lineTo(39.0F, 0.75F);
      localPath.cubicTo(50.183765F, 0.75F, 59.25F, 9.816234F, 59.25F, 21.0F);
      localPath.lineTo(59.25F, 21.0F);
      localPath.cubicTo(59.25F, 32.183765F, 50.183765F, 41.25F, 39.0F, 41.25F);
      localPath.lineTo(21.0F, 41.25F);
      localPath.cubicTo(9.816234F, 41.25F, 0.75F, 32.183765F, 0.75F, 21.0F);
      localPath.lineTo(0.75F, 21.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-2631721);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(37.060661F, 12.06066F);
      ((Path)localObject).lineTo(39.060661F, 14.06066F);
      ((Path)localObject).lineTo(32.059662F, 21.05966F);
      ((Path)localObject).lineTo(39.060661F, 28.060659F);
      ((Path)localObject).lineTo(37.060661F, 30.060659F);
      ((Path)localObject).lineTo(30.060659F, 23.05966F);
      ((Path)localObject).lineTo(23.060659F, 30.060659F);
      ((Path)localObject).lineTo(21.060659F, 28.060659F);
      ((Path)localObject).lineTo(28.060659F, 21.05966F);
      ((Path)localObject).lineTo(21.060659F, 14.06066F);
      ((Path)localObject).lineTo(23.060659F, 12.06066F);
      ((Path)localObject).lineTo(30.060659F, 19.060659F);
      ((Path)localObject).lineTo(37.060661F, 12.06066F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kp
 * JD-Core Version:    0.7.0.1
 */