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

public class c2c_aa_icon_check
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(20.0F, 0.0F);
      ((Path)localObject).cubicTo(31.045694F, 0.0F, 40.0F, 8.954306F, 40.0F, 20.0F);
      ((Path)localObject).cubicTo(40.0F, 31.045694F, 31.045694F, 40.0F, 20.0F, 40.0F);
      ((Path)localObject).cubicTo(8.954306F, 40.0F, 0.0F, 31.045694F, 0.0F, 20.0F);
      ((Path)localObject).cubicTo(0.0F, 8.954306F, 8.954306F, 0.0F, 20.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 1.176471F);
      ((Path)localObject).cubicTo(9.604051F, 1.176471F, 1.176471F, 9.604051F, 1.176471F, 20.0F);
      ((Path)localObject).cubicTo(1.176471F, 30.395948F, 9.604051F, 38.823528F, 20.0F, 38.823528F);
      ((Path)localObject).cubicTo(30.395948F, 38.823528F, 38.823528F, 30.395948F, 38.823528F, 20.0F);
      ((Path)localObject).cubicTo(38.823528F, 9.604051F, 30.395948F, 1.176471F, 20.0F, 1.176471F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.23164F, 13.51582F);
      ((Path)localObject).lineTo(30.772768F, 14.051357F);
      ((Path)localObject).cubicTo(30.849499F, 14.127295F, 30.849628F, 14.250286F, 30.773903F, 14.325228F);
      ((Path)localObject).lineTo(17.266922F, 27.692572F);
      ((Path)localObject).cubicTo(17.113321F, 27.844584F, 16.863773F, 27.84407F, 16.711462F, 27.693333F);
      ((Path)localObject).lineTo(10.573702F, 21.619028F);
      ((Path)localObject).cubicTo(10.498121F, 21.544231F, 10.490384F, 21.41671F, 10.558941F, 21.331051F);
      ((Path)localObject).lineTo(11.310415F, 20.392082F);
      ((Path)localObject).cubicTo(11.377843F, 20.307835F, 11.502753F, 20.286013F, 11.5928F, 20.345577F);
      ((Path)localObject).lineTo(16.661976F, 23.698973F);
      ((Path)localObject).cubicTo(16.842478F, 23.81838F, 17.127102F, 23.803972F, 17.293428F, 23.670231F);
      ((Path)localObject).lineTo(29.941011F, 13.500306F);
      ((Path)localObject).cubicTo(30.024792F, 13.432938F, 30.156973F, 13.441925F, 30.23164F, 13.51582F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.c2c_aa_icon_check
 * JD-Core Version:    0.7.0.1
 */