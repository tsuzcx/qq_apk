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

public class common_icons_album
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(17.538166F, 8.3F);
      ((Path)localObject).cubicTo(17.990835F, 8.3F, 18.375F, 8.675888F, 18.375F, 9.13957F);
      ((Path)localObject).lineTo(18.375F, 19.96043F);
      ((Path)localObject).cubicTo(18.375F, 20.4259F, 18.000338F, 20.799999F, 17.538166F, 20.799999F);
      ((Path)localObject).lineTo(2.336834F, 20.799999F);
      ((Path)localObject).cubicTo(1.884164F, 20.799999F, 1.5F, 20.424112F, 1.5F, 19.96043F);
      ((Path)localObject).lineTo(1.5F, 9.13957F);
      ((Path)localObject).cubicTo(1.5F, 8.6741F, 1.874663F, 8.3F, 2.336834F, 8.3F);
      ((Path)localObject).lineTo(17.538166F, 8.3F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.1875F, 4.5F);
      ((Path)localObject).cubicTo(21.739784F, 4.5F, 22.1875F, 4.947715F, 22.1875F, 5.5F);
      ((Path)localObject).lineTo(22.1875F, 16.25F);
      ((Path)localObject).cubicTo(22.1875F, 16.802284F, 21.739784F, 17.25F, 21.1875F, 17.25F);
      ((Path)localObject).lineTo(19.6875F, 17.25F);
      ((Path)localObject).lineTo(19.6875F, 8.5F);
      ((Path)localObject).cubicTo(19.6875F, 7.671573F, 19.015926F, 7.0F, 18.1875F, 7.0F);
      ((Path)localObject).lineTo(4.6875F, 7.0F);
      ((Path)localObject).lineTo(4.6875F, 5.5F);
      ((Path)localObject).cubicTo(4.6875F, 4.947715F, 5.135215F, 4.5F, 5.6875F, 4.5F);
      ((Path)localObject).lineTo(21.1875F, 4.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.109375F, 9.471875F);
      ((Path)localObject).lineTo(2.765625F, 9.471875F);
      ((Path)localObject).lineTo(2.765F, 15.995F);
      ((Path)localObject).lineTo(6.730613F, 13.025983F);
      ((Path)localObject).cubicTo(7.120893F, 12.733738F, 7.747653F, 12.747911F, 8.123856F, 13.053971F);
      ((Path)localObject).lineTo(11.900841F, 16.12674F);
      ((Path)localObject).lineTo(13.82643F, 14.610545F);
      ((Path)localObject).cubicTo(14.216424F, 14.303467F, 14.836923F, 14.309705F, 15.21552F, 14.624284F);
      ((Path)localObject).lineTo(17.108999F, 16.219F);
      ((Path)localObject).lineTo(17.109375F, 9.471875F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.common_icons_album
 * JD-Core Version:    0.7.0.1
 */