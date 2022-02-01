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

public class menu_logout_single
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-2565928);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(96.0F, 0.0F);
      localPath.lineTo(96.0F, 96.0F);
      localPath.lineTo(0.0F, 96.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint((Paint)localObject, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-8617851);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(58.234665F, 65.333336F);
      ((Path)localObject).cubicTo(58.234665F, 65.333336F, 56.0F, 64.883553F, 56.0F, 62.666668F);
      ((Path)localObject).lineTo(56.0F, 61.333332F);
      ((Path)localObject).cubicTo(56.0F, 59.977333F, 57.333332F, 58.666668F, 57.333332F, 58.666668F);
      ((Path)localObject).cubicTo(62.017944F, 54.044582F, 65.138985F, 47.470398F, 65.130219F, 37.007732F);
      ((Path)localObject).cubicTo(65.120117F, 24.950094F, 58.554668F, 16.0F, 48.0F, 16.0F);
      ((Path)localObject).cubicTo(37.445332F, 16.0F, 30.897902F, 24.952658F, 30.908001F, 37.007732F);
      ((Path)localObject).cubicTo(30.908001F, 47.468624F, 34.000893F, 54.025047F, 38.753777F, 58.666668F);
      ((Path)localObject).cubicTo(38.666668F, 58.666668F, 40.0F, 59.977333F, 40.0F, 61.333332F);
      ((Path)localObject).lineTo(40.0F, 62.666668F);
      ((Path)localObject).cubicTo(40.0F, 64.883553F, 37.765335F, 65.333336F, 37.765335F, 65.333336F);
      ((Path)localObject).lineTo(17.333334F, 72.444443F);
      ((Path)localObject).cubicTo(14.228F, 73.564445F, 12.0F, 76.518219F, 12.0F, 80.0F);
      ((Path)localObject).lineTo(12.0F, 84.0F);
      ((Path)localObject).lineTo(84.0F, 84.0F);
      ((Path)localObject).lineTo(84.0F, 80.0F);
      ((Path)localObject).cubicTo(84.0F, 76.518219F, 81.771553F, 73.564445F, 78.666664F, 72.46489F);
      ((Path)localObject).lineTo(58.234665F, 65.333336F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.menu_logout_single
 * JD-Core Version:    0.7.0.1
 */