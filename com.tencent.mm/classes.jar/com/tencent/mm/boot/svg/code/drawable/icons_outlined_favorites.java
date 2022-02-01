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

public class icons_outlined_favorites
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      ((Path)localObject).moveTo(57.757702F, 21.974848F);
      ((Path)localObject).lineTo(36.774937F, 9.734903F);
      ((Path)localObject).cubicTo(36.466652F, 9.555071F, 35.533482F, 9.554993F, 35.225063F, 9.734903F);
      ((Path)localObject).lineTo(14.2423F, 21.974848F);
      ((Path)localObject).lineTo(36.0F, 34.536663F);
      ((Path)localObject).lineTo(57.757702F, 21.974848F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(59.400002F, 25.183588F);
      ((Path)localObject).lineTo(37.799999F, 37.654354F);
      ((Path)localObject).lineTo(37.799999F, 62.897388F);
      ((Path)localObject).lineTo(58.597191F, 50.765697F);
      ((Path)localObject).cubicTo(58.920998F, 50.576809F, 59.400002F, 49.743988F, 59.400002F, 49.37328F);
      ((Path)localObject).lineTo(59.400002F, 25.183588F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.6F, 25.183588F);
      ((Path)localObject).lineTo(12.6F, 49.37328F);
      ((Path)localObject).cubicTo(12.6F, 49.736622F, 13.083672F, 50.579533F, 13.402809F, 50.765697F);
      ((Path)localObject).lineTo(34.200001F, 62.897388F);
      ((Path)localObject).lineTo(34.200001F, 37.654354F);
      ((Path)localObject).lineTo(12.6F, 25.183588F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.411125F, 6.6253F);
      ((Path)localObject).cubicTo(34.840923F, 5.791252F, 37.160156F, 5.791881F, 38.588875F, 6.6253F);
      ((Path)localObject).lineTo(60.411125F, 19.354948F);
      ((Path)localObject).cubicTo(61.840923F, 20.188995F, 63.0F, 22.218639F, 63.0F, 23.856966F);
      ((Path)localObject).lineTo(63.0F, 49.37328F);
      ((Path)localObject).cubicTo(63.0F, 51.025631F, 61.839844F, 53.041882F, 60.411125F, 53.875301F);
      ((Path)localObject).lineTo(38.588875F, 66.60495F);
      ((Path)localObject).cubicTo(37.159077F, 67.438995F, 34.839844F, 67.438362F, 33.411125F, 66.60495F);
      ((Path)localObject).lineTo(11.588874F, 53.875301F);
      ((Path)localObject).cubicTo(10.159078F, 53.041252F, 9.0F, 51.011608F, 9.0F, 49.37328F);
      ((Path)localObject).lineTo(9.0F, 23.856966F);
      ((Path)localObject).cubicTo(9.0F, 22.204617F, 10.160156F, 20.188366F, 11.588874F, 19.354948F);
      ((Path)localObject).lineTo(33.411125F, 6.6253F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_favorites
 * JD-Core Version:    0.7.0.1
 */