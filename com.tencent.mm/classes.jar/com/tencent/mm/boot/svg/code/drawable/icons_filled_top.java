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

public class icons_filled_top
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.778174F, 7.292893F);
      ((Path)localObject).lineTo(18.849243F, 13.363961F);
      ((Path)localObject).cubicTo(19.239767F, 13.754485F, 19.239767F, 14.38765F, 18.849243F, 14.778174F);
      ((Path)localObject).cubicTo(18.661707F, 14.965711F, 18.407352F, 15.071068F, 18.142136F, 15.071068F);
      ((Path)localObject).lineTo(16.070999F, 15.071F);
      ((Path)localObject).lineTo(16.071068F, 21.0F);
      ((Path)localObject).cubicTo(16.071068F, 21.552284F, 15.623353F, 22.0F, 15.071068F, 22.0F);
      ((Path)localObject).lineTo(9.071068F, 22.0F);
      ((Path)localObject).cubicTo(8.518783F, 22.0F, 8.071068F, 21.552284F, 8.071068F, 21.0F);
      ((Path)localObject).lineTo(8.071F, 15.071F);
      ((Path)localObject).lineTo(6.0F, 15.071068F);
      ((Path)localObject).cubicTo(5.447715F, 15.071068F, 5.0F, 14.623353F, 5.0F, 14.071068F);
      ((Path)localObject).cubicTo(5.0F, 13.805851F, 5.105357F, 13.551497F, 5.292893F, 13.363961F);
      ((Path)localObject).lineTo(11.363961F, 7.292893F);
      ((Path)localObject).cubicTo(11.754485F, 6.902369F, 12.38765F, 6.902369F, 12.778174F, 7.292893F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 5.0F);
      ((Path)localObject).lineTo(4.0F, 5.0F);
      ((Path)localObject).lineTo(4.0F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 3.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_top
 * JD-Core Version:    0.7.0.1
 */