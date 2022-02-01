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

public class icons_filled_volume_up
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
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.3F, 4.7F);
      ((Path)localObject).cubicTo(11.7F, 4.3F, 12.3F, 4.3F, 12.7F, 4.7F);
      ((Path)localObject).cubicTo(12.9F, 4.9F, 13.0F, 5.1F, 13.0F, 5.4F);
      ((Path)localObject).lineTo(13.0F, 18.6F);
      ((Path)localObject).cubicTo(13.0F, 19.200001F, 12.6F, 19.6F, 12.0F, 19.6F);
      ((Path)localObject).cubicTo(11.7F, 19.6F, 11.5F, 19.5F, 11.3F, 19.299999F);
      ((Path)localObject).lineTo(7.5F, 15.5F);
      ((Path)localObject).lineTo(3.0F, 15.5F);
      ((Path)localObject).cubicTo(2.4F, 15.5F, 2.0F, 15.1F, 2.0F, 14.5F);
      ((Path)localObject).lineTo(2.0F, 9.5F);
      ((Path)localObject).cubicTo(2.0F, 8.9F, 2.4F, 8.5F, 3.0F, 8.5F);
      ((Path)localObject).lineTo(7.5F, 8.5F);
      ((Path)localObject).lineTo(11.3F, 4.7F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.200001F, 17.9F);
      ((Path)localObject).lineTo(17.1F, 16.799999F);
      ((Path)localObject).lineTo(17.200001F, 16.700001F);
      ((Path)localObject).cubicTo(18.5F, 15.4F, 19.1F, 13.8F, 19.1F, 12.0F);
      ((Path)localObject).cubicTo(19.1F, 10.2F, 18.4F, 8.6F, 17.200001F, 7.3F);
      ((Path)localObject).lineTo(17.1F, 7.2F);
      ((Path)localObject).lineTo(18.200001F, 6.1F);
      ((Path)localObject).lineTo(18.299999F, 6.2F);
      ((Path)localObject).cubicTo(19.799999F, 7.7F, 20.700001F, 9.8F, 20.700001F, 12.0F);
      ((Path)localObject).cubicTo(20.700001F, 14.2F, 19.9F, 16.200001F, 18.299999F, 17.799999F);
      ((Path)localObject).lineTo(18.200001F, 17.9F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.200001F, 15.9F);
      ((Path)localObject).lineTo(15.1F, 14.8F);
      ((Path)localObject).lineTo(15.2F, 14.7F);
      ((Path)localObject).cubicTo(15.9F, 14.0F, 16.299999F, 13.0F, 16.299999F, 12.0F);
      ((Path)localObject).cubicTo(16.299999F, 11.0F, 15.9F, 10.0F, 15.2F, 9.3F);
      ((Path)localObject).lineTo(15.1F, 9.2F);
      ((Path)localObject).lineTo(16.200001F, 8.1F);
      ((Path)localObject).lineTo(16.299999F, 8.2F);
      ((Path)localObject).cubicTo(17.299999F, 9.2F, 17.9F, 10.6F, 17.9F, 12.0F);
      ((Path)localObject).cubicTo(17.9F, 13.4F, 17.299999F, 14.8F, 16.299999F, 15.8F);
      ((Path)localObject).lineTo(16.200001F, 15.9F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_volume_up
 * JD-Core Version:    0.7.0.1
 */