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

public final class aaz
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(11.875F, 21.5F);
      localPath.cubicTo(16.224243F, 21.5F, 19.75F, 18.477922F, 19.75F, 14.75F);
      localPath.cubicTo(19.75F, 12.579542F, 18.554852F, 10.648348F, 16.69787F, 9.413545F);
      localPath.cubicTo(16.3116F, 11.465161F, 15.224228F, 12.390485F, 14.618286F, 12.736572F);
      localPath.cubicTo(17.311035F, 5.655957F, 11.27872F, 2.0F, 10.050639F, 2.0F);
      localPath.cubicTo(11.5F, 5.960645F, 7.516554F, 8.84056F, 6.077288F, 10.181915F);
      localPath.cubicTo(4.787516F, 11.383947F, 4.0F, 12.988145F, 4.0F, 14.75F);
      localPath.cubicTo(4.0F, 18.477922F, 7.525758F, 21.5F, 11.875F, 21.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-2565928);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aaz
 * JD-Core Version:    0.7.0.1
 */