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

public final class qe
  extends c
{
  private final int height = 44;
  private final int width = 44;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 44;
      return 44;
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-526345);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(22.0F, 44.0F);
      localPath.cubicTo(34.150265F, 44.0F, 44.0F, 34.150265F, 44.0F, 22.0F);
      localPath.cubicTo(44.0F, 9.849735F, 34.150265F, -9.094947E-013F, 22.0F, -9.094947E-013F);
      localPath.cubicTo(9.849735F, -9.094947E-013F, 0.0F, 9.849735F, 0.0F, 22.0F);
      localPath.cubicTo(0.0F, 34.150265F, 9.849735F, 44.0F, 22.0F, 44.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(20.066904F, 26.125F);
      ((Path)localObject).cubicTo(21.297941F, 24.891829F, 22.0F, 23.229095F, 22.0F, 21.450001F);
      ((Path)localObject).cubicTo(22.0F, 19.670904F, 21.297941F, 18.008171F, 20.066904F, 16.775F);
      ((Path)localObject).lineTo(21.466976F, 15.3725F);
      ((Path)localObject).cubicTo(23.019651F, 16.927868F, 23.98F, 19.076588F, 23.98F, 21.450001F);
      ((Path)localObject).cubicTo(23.98F, 23.823412F, 23.019651F, 25.972132F, 21.466976F, 27.5275F);
      ((Path)localObject).lineTo(20.066904F, 26.125F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.200144F, 24.254999F);
      ((Path)localObject).lineTo(15.4F, 21.450001F);
      ((Path)localObject).lineTo(18.200144F, 18.645F);
      ((Path)localObject).cubicTo(18.916761F, 19.362862F, 19.360001F, 20.35458F, 19.360001F, 21.450001F);
      ((Path)localObject).cubicTo(19.360001F, 22.54542F, 18.916761F, 23.537138F, 18.200144F, 24.254999F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.qe
 * JD-Core Version:    0.7.0.1
 */