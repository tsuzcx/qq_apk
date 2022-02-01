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

public class album_advertise_link_icon
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(1275068416);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(32.485298F, 21.1716F);
      ((Path)localObject).lineTo(35.313702F, 24.0F);
      ((Path)localObject).lineTo(39.5564F, 19.757401F);
      ((Path)localObject).cubicTo(42.680599F, 16.6332F, 42.680599F, 11.5678F, 39.5564F, 8.44365F);
      ((Path)localObject).cubicTo(36.432201F, 5.31945F, 31.3668F, 5.31945F, 28.242701F, 8.44365F);
      ((Path)localObject).lineTo(19.757401F, 16.9289F);
      ((Path)localObject).cubicTo(16.6332F, 20.053101F, 16.6332F, 25.118401F, 19.757401F, 28.242599F);
      ((Path)localObject).lineTo(22.5858F, 25.4142F);
      ((Path)localObject).cubicTo(21.023701F, 23.8521F, 21.023701F, 21.3195F, 22.5858F, 19.757401F);
      ((Path)localObject).lineTo(31.0711F, 11.2721F);
      ((Path)localObject).cubicTo(32.633202F, 9.70998F, 35.165798F, 9.70998F, 36.727901F, 11.2721F);
      ((Path)localObject).cubicTo(38.290001F, 12.8342F, 38.290001F, 15.3668F, 36.727901F, 16.9289F);
      ((Path)localObject).lineTo(32.485298F, 21.1716F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.5147F, 26.8284F);
      ((Path)localObject).lineTo(12.6863F, 24.0F);
      ((Path)localObject).lineTo(8.44367F, 28.242599F);
      ((Path)localObject).cubicTo(5.31948F, 31.3668F, 5.31948F, 36.432201F, 8.44367F, 39.5564F);
      ((Path)localObject).cubicTo(11.5679F, 42.6805F, 16.6332F, 42.6805F, 19.757401F, 39.5564F);
      ((Path)localObject).lineTo(28.242701F, 31.0711F);
      ((Path)localObject).cubicTo(31.366899F, 27.946899F, 31.366899F, 22.881599F, 28.242701F, 19.757401F);
      ((Path)localObject).lineTo(25.4142F, 22.5858F);
      ((Path)localObject).cubicTo(26.976299F, 24.1479F, 26.976299F, 26.6805F, 25.4142F, 28.242599F);
      ((Path)localObject).lineTo(16.929001F, 36.727901F);
      ((Path)localObject).cubicTo(15.3669F, 38.290001F, 12.8342F, 38.290001F, 11.2721F, 36.727901F);
      ((Path)localObject).cubicTo(9.71F, 35.165798F, 9.71F, 32.633202F, 11.2721F, 31.0711F);
      ((Path)localObject).lineTo(15.5147F, 26.8284F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_advertise_link_icon
 * JD-Core Version:    0.7.0.1
 */