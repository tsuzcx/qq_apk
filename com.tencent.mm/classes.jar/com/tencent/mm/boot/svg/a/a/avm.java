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

public final class avm
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      localPaint.setColor(1275068416);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(13.333333F, 6.243056F);
      ((Path)localObject).cubicTo(13.333333F, 6.243056F, 13.333333F, 6.243056F, 13.333333F, 6.243056F);
      ((Path)localObject).lineTo(13.333333F, 7.502526F);
      ((Path)localObject).cubicTo(13.333333F, 10.733429F, 11.134437F, 13.549725F, 8.0F, 14.333333F);
      ((Path)localObject).cubicTo(4.865563F, 13.549725F, 2.666667F, 10.733429F, 2.666667F, 7.502526F);
      ((Path)localObject).lineTo(2.666667F, 3.666667F);
      ((Path)localObject).lineTo(8.0F, 1.666667F);
      ((Path)localObject).lineTo(13.333333F, 3.666667F);
      ((Path)localObject).lineTo(13.333333F, 6.243056F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.533333F, 6.171412F);
      ((Path)localObject).lineTo(12.533333F, 4.291288F);
      ((Path)localObject).lineTo(8.0F, 2.491288F);
      ((Path)localObject).lineTo(3.466667F, 4.291288F);
      ((Path)localObject).lineTo(3.466667F, 7.502526F);
      ((Path)localObject).cubicTo(3.466667F, 10.299193F, 5.325406F, 12.745391F, 8.0F, 13.505414F);
      ((Path)localObject).cubicTo(10.674594F, 12.745391F, 12.533333F, 10.299193F, 12.533333F, 7.502526F);
      ((Path)localObject).lineTo(12.533333F, 6.884618F);
      ((Path)localObject).lineTo(6.885941F, 9.941663F);
      ((Path)localObject).lineTo(6.846111F, 9.963327F);
      ((Path)localObject).cubicTo(6.796928F, 9.986406F, 6.741558F, 10.0F, 6.682869F, 10.0F);
      ((Path)localObject).cubicTo(6.546633F, 10.0F, 6.4282F, 9.929627F, 6.366042F, 9.825695F);
      ((Path)localObject).lineTo(6.342355F, 9.776986F);
      ((Path)localObject).lineTo(5.350683F, 7.734886F);
      ((Path)localObject).cubicTo(5.339972F, 7.712655F, 5.333334F, 7.687451F, 5.333334F, 7.662955F);
      ((Path)localObject).cubicTo(5.333334F, 7.568935F, 5.414652F, 7.492756F, 5.514831F, 7.492756F);
      ((Path)localObject).cubicTo(5.555867F, 7.492756F, 5.593132F, 7.505358F, 5.623608F, 7.526598F);
      ((Path)localObject).lineTo(6.793608F, 8.308351F);
      ((Path)localObject).cubicTo(6.87885F, 8.360741F, 6.981291F, 8.391609F, 7.091125F, 8.391609F);
      ((Path)localObject).cubicTo(7.156452F, 8.391609F, 7.219063F, 8.380281F, 7.277148F, 8.360316F);
      ((Path)localObject).cubicTo(7.277148F, 8.360316F, 11.068007F, 6.780773F, 12.533333F, 6.171412F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avm
 * JD-Core Version:    0.7.0.1
 */