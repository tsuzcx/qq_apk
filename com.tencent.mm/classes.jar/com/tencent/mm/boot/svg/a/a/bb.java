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

public final class bb
  extends c
{
  private final int height = 18;
  private final int width = 18;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 18;
      return 18;
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
      localPaint.setColor(-2130706433);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(14.656855F, 9.0F);
      ((Path)localObject).lineTo(13.808326F, 8.151472F);
      ((Path)localObject).lineTo(15.929646F, 6.030151F);
      ((Path)localObject).cubicTo(17.023115F, 4.936684F, 17.023115F, 3.163822F, 15.929646F, 2.070354F);
      ((Path)localObject).cubicTo(14.836179F, 0.976886F, 13.063316F, 0.976886F, 11.969849F, 2.070354F);
      ((Path)localObject).lineTo(8.080761F, 5.959441F);
      ((Path)localObject).cubicTo(6.987293F, 7.052909F, 6.987293F, 8.82577F, 8.080761F, 9.919239F);
      ((Path)localObject).lineTo(7.232233F, 10.767767F);
      ((Path)localObject).cubicTo(5.670136F, 9.205669F, 5.670136F, 6.67301F, 7.232233F, 5.110913F);
      ((Path)localObject).lineTo(11.121321F, 1.221825F);
      ((Path)localObject).cubicTo(12.683417F, -0.3402718F, 15.216078F, -0.3402718F, 16.778175F, 1.221825F);
      ((Path)localObject).cubicTo(18.340271F, 2.783923F, 18.340271F, 5.316583F, 16.778175F, 6.87868F);
      ((Path)localObject).lineTo(14.656855F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.343146F, 9.0F);
      ((Path)localObject).lineTo(4.191674F, 9.848528F);
      ((Path)localObject).lineTo(2.070354F, 11.969849F);
      ((Path)localObject).cubicTo(0.976886F, 13.063316F, 0.976886F, 14.836179F, 2.070354F, 15.929646F);
      ((Path)localObject).cubicTo(3.163822F, 17.023115F, 4.936684F, 17.023115F, 6.030151F, 15.929646F);
      ((Path)localObject).lineTo(9.919239F, 12.040559F);
      ((Path)localObject).cubicTo(11.012707F, 10.947091F, 11.012707F, 9.17423F, 9.919239F, 8.080761F);
      ((Path)localObject).lineTo(10.767767F, 7.232233F);
      ((Path)localObject).cubicTo(12.329865F, 8.794331F, 12.329865F, 11.32699F, 10.767767F, 12.889088F);
      ((Path)localObject).lineTo(6.87868F, 16.778175F);
      ((Path)localObject).cubicTo(5.316583F, 18.340271F, 2.783923F, 18.340271F, 1.221825F, 16.778175F);
      ((Path)localObject).cubicTo(-0.3402718F, 15.216078F, -0.3402718F, 12.683417F, 1.221825F, 11.121321F);
      ((Path)localObject).lineTo(3.343146F, 9.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bb
 * JD-Core Version:    0.7.0.1
 */