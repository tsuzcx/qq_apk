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

public class moment_luckymoney_payment_close
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(32.091885F, 29.970562F);
      ((Path)localObject).lineTo(46.941124F, 15.121321F);
      ((Path)localObject).lineTo(44.819805F, 13.0F);
      ((Path)localObject).lineTo(29.970562F, 27.849243F);
      ((Path)localObject).lineTo(15.121321F, 13.0F);
      ((Path)localObject).lineTo(13.0F, 15.121321F);
      ((Path)localObject).lineTo(27.849243F, 29.970562F);
      ((Path)localObject).lineTo(13.0F, 44.819805F);
      ((Path)localObject).lineTo(15.121321F, 46.941124F);
      ((Path)localObject).lineTo(29.970562F, 32.091885F);
      ((Path)localObject).lineTo(44.819805F, 46.941124F);
      ((Path)localObject).lineTo(46.941124F, 44.819805F);
      ((Path)localObject).lineTo(32.091885F, 29.970562F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.moment_luckymoney_payment_close
 * JD-Core Version:    0.7.0.1
 */