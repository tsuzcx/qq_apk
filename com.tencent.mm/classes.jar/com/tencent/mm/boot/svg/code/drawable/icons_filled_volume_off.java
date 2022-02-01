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

public class icons_filled_volume_off
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
      localPaint.setColor(-16515072);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(27.18198F, 20.81802F);
      ((Path)localObject).lineTo(33.900002F, 14.1F);
      ((Path)localObject).cubicTo(35.099998F, 12.9F, 36.900002F, 12.9F, 38.099998F, 14.1F);
      ((Path)localObject).cubicTo(38.700001F, 14.7F, 39.0F, 15.3F, 39.0F, 16.200001F);
      ((Path)localObject).lineTo(39.0F, 32.63604F);
      ((Path)localObject).lineTo(47.635643F, 41.271683F);
      ((Path)localObject).cubicTo(48.456047F, 39.649471F, 48.900002F, 37.824738F, 48.900002F, 36.0F);
      ((Path)localObject).cubicTo(48.900002F, 33.0F, 47.700001F, 30.0F, 45.599998F, 27.9F);
      ((Path)localObject).lineTo(45.299999F, 27.6F);
      ((Path)localObject).lineTo(48.599998F, 24.299999F);
      ((Path)localObject).lineTo(48.900002F, 24.6F);
      ((Path)localObject).cubicTo(51.900002F, 27.6F, 53.700001F, 31.799999F, 53.700001F, 36.0F);
      ((Path)localObject).cubicTo(53.700001F, 39.056602F, 52.746651F, 42.113205F, 51.071224F, 44.707264F);
      ((Path)localObject).lineTo(53.827003F, 47.463043F);
      ((Path)localObject).cubicTo(56.190712F, 44.108547F, 57.299999F, 40.239155F, 57.299999F, 36.0F);
      ((Path)localObject).cubicTo(57.299999F, 30.6F, 55.200001F, 25.799999F, 51.599998F, 21.9F);
      ((Path)localObject).lineTo(51.299999F, 21.6F);
      ((Path)localObject).lineTo(54.599998F, 18.299999F);
      ((Path)localObject).lineTo(54.900002F, 18.6F);
      ((Path)localObject).cubicTo(59.400002F, 23.1F, 62.099998F, 29.4F, 62.099998F, 36.0F);
      ((Path)localObject).cubicTo(62.099998F, 41.460022F, 60.457474F, 46.509411F, 57.172424F, 50.808464F);
      ((Path)localObject).lineTo(66.27565F, 59.91169F);
      ((Path)localObject).lineTo(63.09367F, 63.09367F);
      ((Path)localObject).lineTo(12.18198F, 12.18198F);
      ((Path)localObject).lineTo(15.363961F, 9.0F);
      ((Path)localObject).lineTo(27.18198F, 20.81802F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.0F, 45.36396F);
      ((Path)localObject).lineTo(39.0F, 55.799999F);
      ((Path)localObject).cubicTo(39.0F, 57.599998F, 37.799999F, 58.799999F, 36.0F, 58.799999F);
      ((Path)localObject).cubicTo(35.099998F, 58.799999F, 34.5F, 58.5F, 33.900002F, 57.900002F);
      ((Path)localObject).lineTo(22.5F, 46.5F);
      ((Path)localObject).lineTo(9.0F, 46.5F);
      ((Path)localObject).cubicTo(7.2F, 46.5F, 6.0F, 45.299999F, 6.0F, 43.5F);
      ((Path)localObject).lineTo(6.0F, 28.5F);
      ((Path)localObject).cubicTo(6.0F, 26.700001F, 7.2F, 25.5F, 9.0F, 25.5F);
      ((Path)localObject).lineTo(19.13604F, 25.5F);
      ((Path)localObject).lineTo(39.0F, 45.36396F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_volume_off
 * JD-Core Version:    0.7.0.1
 */