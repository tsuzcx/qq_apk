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

public final class bil
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPath.moveTo(16.0F, 29.0F);
      localPath.cubicTo(17.726973F, 27.70042F, 19.455055F, 28.159777F, 21.0F, 28.0F);
      localPath.cubicTo(34.0089F, 28.089874F, 47.05442F, 27.920113F, 60.0F, 28.0F);
      localPath.cubicTo(62.067753F, 27.960056F, 63.226467F, 30.137007F, 63.0F, 32.0F);
      localPath.cubicTo(62.976746F, 42.619518F, 62.966755F, 53.34449F, 63.0F, 64.0F);
      localPath.cubicTo(63.246445F, 65.83699F, 62.057766F, 68.023926F, 60.0F, 68.0F);
      localPath.cubicTo(46.335217F, 68.023926F, 32.600464F, 67.944038F, 19.0F, 68.0F);
      localPath.cubicTo(17.10766F, 68.253601F, 14.970034F, 67.065269F, 15.0F, 65.0F);
      localPath.cubicTo(14.920089F, 54.383034F, 15.0899F, 43.678036F, 15.0F, 33.0F);
      localPath.cubicTo(15.059934F, 31.435186F, 14.790233F, 29.447971F, 16.0F, 29.0F);
      localPath.lineTo(16.0F, 29.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(66.0F, 41.0F);
      ((Path)localObject).cubicTo(71.038727F, 37.01664F, 75.738205F, 32.185577F, 81.0F, 28.0F);
      ((Path)localObject).cubicTo(82.33345F, 30.067574F, 81.934341F, 32.589008F, 82.0F, 35.0F);
      ((Path)localObject).cubicTo(81.944321F, 44.712051F, 81.974251F, 54.505295F, 82.0F, 64.0F);
      ((Path)localObject).cubicTo(82.004189F, 65.629852F, 81.664948F, 66.860313F, 81.0F, 68.0F);
      ((Path)localObject).cubicTo(75.718254F, 63.824509F, 71.018768F, 58.993443F, 66.0F, 55.0F);
      ((Path)localObject).lineTo(66.0F, 41.0F);
      ((Path)localObject).lineTo(66.0F, 41.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bil
 * JD-Core Version:    0.7.0.1
 */