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

public class icons_outlined_shop
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
      ((Path)localObject).moveTo(24.0F, 21.0F);
      ((Path)localObject).lineTo(24.0F, 18.0F);
      ((Path)localObject).cubicTo(24.0F, 11.372583F, 29.372583F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(42.627419F, 6.0F, 48.0F, 11.372583F, 48.0F, 18.0F);
      ((Path)localObject).lineTo(48.0F, 21.0F);
      ((Path)localObject).lineTo(56.997383F, 21.0F);
      ((Path)localObject).cubicTo(58.655682F, 21.0F, 60.0F, 22.34676F, 60.0F, 24.022451F);
      ((Path)localObject).lineTo(60.0F, 60.024349F);
      ((Path)localObject).cubicTo(60.0F, 63.324608F, 57.31646F, 66.0F, 54.017818F, 66.0F);
      ((Path)localObject).lineTo(17.982182F, 66.0F);
      ((Path)localObject).cubicTo(14.678313F, 66.0F, 12.0F, 63.319809F, 12.0F, 60.024349F);
      ((Path)localObject).lineTo(12.0F, 24.022451F);
      ((Path)localObject).cubicTo(12.0F, 22.353197F, 13.333893F, 21.0F, 15.002615F, 21.0F);
      ((Path)localObject).lineTo(24.0F, 21.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.599993F, 21.0F);
      ((Path)localObject).lineTo(44.399998F, 21.0F);
      ((Path)localObject).lineTo(44.399998F, 18.0F);
      ((Path)localObject).cubicTo(44.39999F, 13.360799F, 40.639183F, 9.599991F, 35.999992F, 9.599991F);
      ((Path)localObject).cubicTo(31.3608F, 9.599991F, 27.599991F, 13.360799F, 27.599991F, 17.99999F);
      ((Path)localObject).lineTo(27.599993F, 21.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 24.6F);
      ((Path)localObject).lineTo(15.6F, 24.6F);
      ((Path)localObject).lineTo(15.6F, 60.024349F);
      ((Path)localObject).cubicTo(15.6F, 61.332809F, 16.667765F, 62.400002F, 17.982182F, 62.400002F);
      ((Path)localObject).lineTo(54.017818F, 62.400002F);
      ((Path)localObject).cubicTo(55.331406F, 62.400002F, 56.400002F, 61.333214F, 56.400002F, 60.024349F);
      ((Path)localObject).lineTo(56.400002F, 24.6F);
      ((Path)localObject).lineTo(48.0F, 24.6F);
      ((Path)localObject).lineTo(48.0F, 33.0F);
      ((Path)localObject).lineTo(44.399998F, 33.0F);
      ((Path)localObject).lineTo(44.399998F, 24.6F);
      ((Path)localObject).lineTo(27.599995F, 24.6F);
      ((Path)localObject).lineTo(27.6F, 33.0F);
      ((Path)localObject).lineTo(24.0F, 33.0F);
      ((Path)localObject).lineTo(24.0F, 24.6F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_shop
 * JD-Core Version:    0.7.0.1
 */