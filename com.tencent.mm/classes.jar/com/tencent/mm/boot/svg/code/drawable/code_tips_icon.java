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

public class code_tips_icon
  extends c
{
  private final int height = 60;
  private final int width = 50;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 50;
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
      localPaint.setColor(-12470760);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(23.0F, 0.0F);
      ((Path)localObject).lineTo(27.0F, 0.0F);
      ((Path)localObject).cubicTo(32.398567F, 0.61F, 37.560276F, 3.83F, 40.0F, 9.0F);
      ((Path)localObject).cubicTo(42.712002F, 13.29F, 42.053062F, 18.67F, 42.0F, 24.0F);
      ((Path)localObject).cubicTo(45.008316F, 24.139999F, 48.552624F, 25.549999F, 49.0F, 29.0F);
      ((Path)localObject).cubicTo(49.131691F, 37.369999F, 48.961964F, 45.75F, 49.0F, 54.0F);
      ((Path)localObject).cubicTo(49.031853F, 56.950001F, 46.775478F, 59.0F, 44.0F, 60.0F);
      ((Path)localObject).lineTo(6.0F, 60.0F);
      ((Path)localObject).cubicTo(3.315282F, 59.169998F, 0.9790345F, 57.02F, 1.0F, 54.0F);
      ((Path)localObject).cubicTo(1.038938F, 45.759998F, 0.869211F, 37.389999F, 1.0F, 29.0F);
      ((Path)localObject).cubicTo(1.438297F, 25.58F, 4.982604F, 24.129999F, 8.0F, 24.0F);
      ((Path)localObject).cubicTo(7.947841F, 18.690001F, 7.308868F, 13.34F, 10.0F, 9.0F);
      ((Path)localObject).cubicTo(12.370737F, 3.92F, 17.442591F, 0.73F, 23.0F, 0.0F);
      ((Path)localObject).lineTo(23.0F, 0.0F);
      ((Path)localObject).lineTo(23.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.0F, 9.0F);
      ((Path)localObject).cubicTo(12.136461F, 13.47097F, 13.192492F, 19.102543F, 13.0F, 24.0F);
      ((Path)localObject).lineTo(37.0F, 24.0F);
      ((Path)localObject).cubicTo(36.783848F, 19.303671F, 37.839878F, 14.003959F, 35.0F, 10.0F);
      ((Path)localObject).cubicTo(30.587132F, 3.575493F, 20.17625F, 3.324083F, 16.0F, 9.0F);
      ((Path)localObject).lineTo(16.0F, 9.0F);
      ((Path)localObject).lineTo(16.0F, 9.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.code_tips_icon
 * JD-Core Version:    0.7.0.1
 */