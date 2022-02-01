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

public class icons_filled_sticker_album
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(62.400002F, 6.0F);
      ((Path)localObject).cubicTo(64.388222F, 6.0F, 66.0F, 7.611775F, 66.0F, 9.6F);
      ((Path)localObject).lineTo(66.0F, 62.400002F);
      ((Path)localObject).cubicTo(66.0F, 64.388222F, 64.388222F, 66.0F, 62.400002F, 66.0F);
      ((Path)localObject).lineTo(9.6F, 66.0F);
      ((Path)localObject).cubicTo(7.611775F, 66.0F, 6.0F, 64.388222F, 6.0F, 62.400002F);
      ((Path)localObject).lineTo(6.0F, 9.6F);
      ((Path)localObject).cubicTo(6.0F, 7.611775F, 7.611775F, 6.0F, 9.6F, 6.0F);
      ((Path)localObject).lineTo(62.400002F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 15.0F);
      ((Path)localObject).cubicTo(24.40202F, 15.0F, 15.0F, 24.40202F, 15.0F, 36.0F);
      ((Path)localObject).cubicTo(15.0F, 47.59798F, 24.40202F, 57.0F, 36.0F, 57.0F);
      ((Path)localObject).cubicTo(47.59798F, 57.0F, 57.0F, 47.59798F, 57.0F, 36.0F);
      ((Path)localObject).cubicTo(57.0F, 24.40202F, 47.59798F, 15.0F, 36.0F, 15.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(47.502914F, 38.099998F);
      ((Path)localObject).cubicTo(46.972424F, 43.986824F, 42.024944F, 48.599998F, 36.0F, 48.599998F);
      ((Path)localObject).cubicTo(29.975056F, 48.599998F, 25.027575F, 43.986824F, 24.497086F, 38.099998F);
      ((Path)localObject).lineTo(24.497086F, 38.099998F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(28.65F, 26.549999F);
      ((Path)localObject).cubicTo(30.389696F, 26.549999F, 31.799999F, 27.960302F, 31.799999F, 29.700001F);
      ((Path)localObject).cubicTo(31.799999F, 31.439697F, 30.389696F, 32.849998F, 28.65F, 32.849998F);
      ((Path)localObject).cubicTo(26.910303F, 32.849998F, 25.5F, 31.439697F, 25.5F, 29.700001F);
      ((Path)localObject).cubicTo(25.5F, 27.960302F, 26.910303F, 26.549999F, 28.65F, 26.549999F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(43.349998F, 26.549999F);
      ((Path)localObject).cubicTo(45.089699F, 26.549999F, 46.5F, 27.960302F, 46.5F, 29.700001F);
      ((Path)localObject).cubicTo(46.5F, 31.439697F, 45.089699F, 32.849998F, 43.349998F, 32.849998F);
      ((Path)localObject).cubicTo(41.610302F, 32.849998F, 40.200001F, 31.439697F, 40.200001F, 29.700001F);
      ((Path)localObject).cubicTo(40.200001F, 27.960302F, 41.610302F, 26.549999F, 43.349998F, 26.549999F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_sticker_album
 * JD-Core Version:    0.7.0.1
 */