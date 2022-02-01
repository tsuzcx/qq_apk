package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_outlined_play_control
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.727834F, 5.5F);
      ((Path)localObject).cubicTo(10.864244F, 5.5F, 10.99791F, 5.537229F, 11.113585F, 5.607441F);
      ((Path)localObject).lineTo(20.65782F, 11.400551F);
      ((Path)localObject).cubicTo(20.998692F, 11.607451F, 21.102316F, 12.043538F, 20.889271F, 12.374578F);
      ((Path)localObject).cubicTo(20.830694F, 12.465598F, 20.751543F, 12.542467F, 20.65782F, 12.599355F);
      ((Path)localObject).lineTo(11.113585F, 18.392464F);
      ((Path)localObject).cubicTo(10.772714F, 18.599365F, 10.323676F, 18.49873F, 10.110632F, 18.167688F);
      ((Path)localObject).cubicTo(10.038335F, 18.055349F, 10.0F, 17.925539F, 10.0F, 17.793062F);
      ((Path)localObject).lineTo(9.999F, 15.426F);
      ((Path)localObject).lineTo(5.113585F, 18.392464F);
      ((Path)localObject).cubicTo(4.772714F, 18.599365F, 4.323677F, 18.49873F, 4.110632F, 18.167688F);
      ((Path)localObject).cubicTo(4.038335F, 18.055349F, 4.0F, 17.925539F, 4.0F, 17.793062F);
      ((Path)localObject).lineTo(4.0F, 6.206843F);
      ((Path)localObject).cubicTo(4.0F, 5.816464F, 4.325862F, 5.5F, 4.727834F, 5.5F);
      ((Path)localObject).cubicTo(4.864245F, 5.5F, 4.99791F, 5.537229F, 5.113585F, 5.607441F);
      ((Path)localObject).lineTo(9.999F, 8.573F);
      ((Path)localObject).lineTo(10.0F, 6.206843F);
      ((Path)localObject).cubicTo(10.0F, 5.816464F, 10.325862F, 5.5F, 10.727834F, 5.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.2F, 7.064F);
      ((Path)localObject).lineTo(11.2F, 9.302F);
      ((Path)localObject).lineTo(14.65782F, 11.400551F);
      ((Path)localObject).cubicTo(14.998692F, 11.607451F, 15.102315F, 12.043538F, 14.889271F, 12.374578F);
      ((Path)localObject).cubicTo(14.830694F, 12.465598F, 14.751542F, 12.542467F, 14.65782F, 12.599355F);
      ((Path)localObject).lineTo(11.2F, 14.697F);
      ((Path)localObject).lineTo(11.2F, 16.934999F);
      ((Path)localObject).lineTo(19.332001F, 11.999F);
      ((Path)localObject).lineTo(11.2F, 7.064F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.2F, 7.064F);
      ((Path)localObject).lineTo(5.2F, 16.934999F);
      ((Path)localObject).lineTo(13.332F, 11.999F);
      ((Path)localObject).lineTo(5.2F, 7.064F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_play_control
 * JD-Core Version:    0.7.0.1
 */