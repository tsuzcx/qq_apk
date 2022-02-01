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

public final class asd
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 9.6F);
      ((Path)localObject).cubicTo(21.419683F, 9.6F, 9.6F, 21.419683F, 9.6F, 36.0F);
      ((Path)localObject).cubicTo(9.6F, 50.580318F, 21.419683F, 62.400002F, 36.0F, 62.400002F);
      ((Path)localObject).cubicTo(50.580318F, 62.400002F, 62.400002F, 50.580318F, 62.400002F, 36.0F);
      ((Path)localObject).cubicTo(62.400002F, 21.419683F, 50.580318F, 9.6F, 36.0F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.650002F, 20.700001F);
      ((Path)localObject).cubicTo(42.372036F, 20.700001F, 46.200001F, 24.527966F, 46.200001F, 29.25F);
      ((Path)localObject).cubicTo(46.200001F, 33.178238F, 43.550858F, 36.487736F, 39.941654F, 37.48941F);
      ((Path)localObject).lineTo(48.330002F, 51.009506F);
      ((Path)localObject).lineTo(44.088005F, 51.009506F);
      ((Path)localObject).lineTo(35.897999F, 37.799999F);
      ((Path)localObject).lineTo(31.200001F, 37.799999F);
      ((Path)localObject).lineTo(31.200001F, 51.0F);
      ((Path)localObject).lineTo(27.6F, 51.0F);
      ((Path)localObject).lineTo(27.6F, 20.700001F);
      ((Path)localObject).lineTo(37.650002F, 20.700001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.650002F, 24.299999F);
      ((Path)localObject).lineTo(31.200001F, 24.299999F);
      ((Path)localObject).lineTo(31.200001F, 34.200001F);
      ((Path)localObject).lineTo(37.650002F, 34.200001F);
      ((Path)localObject).cubicTo(40.383808F, 34.200001F, 42.599998F, 31.98381F, 42.599998F, 29.25F);
      ((Path)localObject).cubicTo(42.599998F, 26.51619F, 40.383808F, 24.299999F, 37.650002F, 24.299999F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asd
 * JD-Core Version:    0.7.0.1
 */