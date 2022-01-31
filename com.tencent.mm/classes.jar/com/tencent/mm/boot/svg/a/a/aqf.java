package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class aqf
  extends c
{
  private final int height = 72;
  private final int width = 210;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 210;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      ((Paint)localObject).setColor(-6710887);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(198.0F, 0.0F);
      localPath.cubicTo(204.62741F, 0.0F, 210.0F, 5.372582F, 210.0F, 12.0F);
      localPath.lineTo(210.0F, 60.0F);
      localPath.cubicTo(210.0F, 66.627419F, 204.62741F, 72.0F, 198.0F, 72.0F);
      localPath.lineTo(12.0F, 72.0F);
      localPath.cubicTo(5.372582F, 72.0F, 0.0F, 66.627419F, 0.0F, 60.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(3.0F, 11.0F);
      ((Path)localObject).cubicTo(3.0F, 6.581722F, 6.581722F, 3.0F, 11.0F, 3.0F);
      ((Path)localObject).lineTo(97.0F, 3.0F);
      ((Path)localObject).cubicTo(101.41828F, 3.0F, 105.0F, 6.581722F, 105.0F, 11.0F);
      ((Path)localObject).lineTo(105.0F, 61.0F);
      ((Path)localObject).cubicTo(105.0F, 65.418282F, 101.41828F, 69.0F, 97.0F, 69.0F);
      ((Path)localObject).lineTo(11.0F, 69.0F);
      ((Path)localObject).cubicTo(6.581722F, 69.0F, 3.0F, 65.418282F, 3.0F, 61.0F);
      ((Path)localObject).lineTo(3.0F, 11.0F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqf
 * JD-Core Version:    0.7.0.1
 */