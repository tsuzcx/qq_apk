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

public class icons_filled_top_off
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
      ((Path)localObject).moveTo(7.267F, 9.388F);
      ((Path)localObject).lineTo(16.071068F, 18.191999F);
      ((Path)localObject).lineTo(16.071068F, 21.071068F);
      ((Path)localObject).cubicTo(16.071068F, 21.623352F, 15.623353F, 22.071068F, 15.071068F, 22.071068F);
      ((Path)localObject).lineTo(9.071068F, 22.071068F);
      ((Path)localObject).cubicTo(8.518783F, 22.071068F, 8.071068F, 21.623352F, 8.071068F, 21.071068F);
      ((Path)localObject).lineTo(8.071068F, 13.071068F);
      ((Path)localObject).lineTo(6.0F, 13.071068F);
      ((Path)localObject).cubicTo(5.447715F, 13.071068F, 5.0F, 12.623353F, 5.0F, 12.071068F);
      ((Path)localObject).cubicTo(5.0F, 11.805851F, 5.105357F, 11.551497F, 5.292893F, 11.363961F);
      ((Path)localObject).lineTo(7.267F, 9.388F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.12132F, 3.0F);
      ((Path)localObject).lineTo(9.38766F, 7.267F);
      ((Path)localObject).lineTo(11.363961F, 5.292893F);
      ((Path)localObject).cubicTo(11.754485F, 4.902369F, 12.38765F, 4.902369F, 12.778174F, 5.292893F);
      ((Path)localObject).lineTo(18.849243F, 11.363961F);
      ((Path)localObject).cubicTo(19.239767F, 11.754485F, 19.239767F, 12.38765F, 18.849243F, 12.778174F);
      ((Path)localObject).cubicTo(18.661707F, 12.965711F, 18.407352F, 13.071068F, 18.142136F, 13.071068F);
      ((Path)localObject).lineTo(16.071068F, 13.071068F);
      ((Path)localObject).lineTo(16.07066F, 13.949F);
      ((Path)localObject).lineTo(22.091883F, 19.970562F);
      ((Path)localObject).lineTo(21.031223F, 21.031223F);
      ((Path)localObject).lineTo(4.06066F, 4.06066F);
      ((Path)localObject).lineTo(5.12132F, 3.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_top_off
 * JD-Core Version:    0.7.0.1
 */