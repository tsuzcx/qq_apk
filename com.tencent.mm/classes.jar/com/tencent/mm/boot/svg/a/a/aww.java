package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class aww
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
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(1.125F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(3.5625F, 6.5625F);
      localPath.cubicTo(3.5625F, 4.905645F, 4.905645F, 3.5625F, 6.5625F, 3.5625F);
      localPath.lineTo(17.4375F, 3.5625F);
      localPath.cubicTo(19.094355F, 3.5625F, 20.4375F, 4.905645F, 20.4375F, 6.5625F);
      localPath.lineTo(20.4375F, 17.4375F);
      localPath.cubicTo(20.4375F, 19.094355F, 19.094355F, 20.4375F, 17.4375F, 20.4375F);
      localPath.lineTo(6.5625F, 20.4375F);
      localPath.cubicTo(4.905645F, 20.4375F, 3.5625F, 19.094355F, 3.5625F, 17.4375F);
      localPath.lineTo(3.5625F, 6.5625F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(12.00001F, 15.584204F);
      ((Path)localObject).lineTo(9.245821F, 17.032167F);
      ((Path)localObject).cubicTo(8.957653F, 17.183666F, 8.601233F, 17.072874F, 8.449733F, 16.784706F);
      ((Path)localObject).cubicTo(8.389405F, 16.669954F, 8.368588F, 16.538517F, 8.390503F, 16.410742F);
      ((Path)localObject).lineTo(8.916507F, 13.343907F);
      ((Path)localObject).lineTo(6.688321F, 11.171963F);
      ((Path)localObject).cubicTo(6.455188F, 10.944715F, 6.450418F, 10.571502F, 6.677666F, 10.338368F);
      ((Path)localObject).cubicTo(6.768158F, 10.245533F, 6.886729F, 10.185119F, 7.015023F, 10.166476F);
      ((Path)localObject).lineTo(10.0943F, 9.719031F);
      ((Path)localObject).lineTo(11.471395F, 6.928733F);
      ((Path)localObject).cubicTo(11.615479F, 6.636787F, 11.968951F, 6.51692F, 12.260898F, 6.661005F);
      ((Path)localObject).cubicTo(12.377152F, 6.71838F, 12.471251F, 6.812478F, 12.528626F, 6.928733F);
      ((Path)localObject).lineTo(13.905721F, 9.719031F);
      ((Path)localObject).lineTo(16.984997F, 10.166476F);
      ((Path)localObject).cubicTo(17.30718F, 10.213292F, 17.530409F, 10.512424F, 17.483593F, 10.834606F);
      ((Path)localObject).cubicTo(17.464951F, 10.9629F, 17.404535F, 11.081471F, 17.311701F, 11.171963F);
      ((Path)localObject).lineTo(15.083514F, 13.343907F);
      ((Path)localObject).lineTo(15.609518F, 16.410742F);
      ((Path)localObject).cubicTo(15.664553F, 16.731623F, 15.449043F, 17.036362F, 15.128163F, 17.091396F);
      ((Path)localObject).cubicTo(15.000386F, 17.113312F, 14.86895F, 17.092495F, 14.754199F, 17.032167F);
      ((Path)localObject).lineTo(12.00001F, 15.584204F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aww
 * JD-Core Version:    0.7.0.1
 */