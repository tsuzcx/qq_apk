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

public class icons_outlined_video_call
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
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.6F, 20.1F);
      ((Path)localObject).lineTo(9.6F, 51.900002F);
      ((Path)localObject).lineTo(47.400002F, 51.900002F);
      ((Path)localObject).lineTo(47.400002F, 20.1F);
      ((Path)localObject).lineTo(9.6F, 20.1F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.0F, 16.5F);
      ((Path)localObject).lineTo(48.0F, 16.5F);
      ((Path)localObject).cubicTo(49.656853F, 16.5F, 51.0F, 17.843145F, 51.0F, 19.5F);
      ((Path)localObject).lineTo(51.0F, 52.5F);
      ((Path)localObject).cubicTo(51.0F, 54.156853F, 49.656853F, 55.5F, 48.0F, 55.5F);
      ((Path)localObject).lineTo(9.0F, 55.5F);
      ((Path)localObject).cubicTo(7.343146F, 55.5F, 6.0F, 54.156853F, 6.0F, 52.5F);
      ((Path)localObject).lineTo(6.0F, 19.5F);
      ((Path)localObject).cubicTo(6.0F, 17.843145F, 7.343146F, 16.5F, 9.0F, 16.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(57.599998F, 40.269749F);
      ((Path)localObject).lineTo(65.400002F, 46.50975F);
      ((Path)localObject).lineTo(65.400002F, 25.49025F);
      ((Path)localObject).lineTo(57.599998F, 31.730249F);
      ((Path)localObject).lineTo(57.599998F, 40.269749F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(54.0F, 30.0F);
      ((Path)localObject).lineTo(64.125916F, 21.899267F);
      ((Path)localObject).cubicTo(65.419701F, 20.864239F, 67.307579F, 21.074003F, 68.342606F, 22.36779F);
      ((Path)localObject).cubicTo(68.768158F, 22.899729F, 69.0F, 23.560659F, 69.0F, 24.241875F);
      ((Path)localObject).lineTo(69.0F, 47.758125F);
      ((Path)localObject).cubicTo(69.0F, 49.414978F, 67.656853F, 50.758125F, 66.0F, 50.758125F);
      ((Path)localObject).cubicTo(65.318787F, 50.758125F, 64.657852F, 50.526283F, 64.125916F, 50.100731F);
      ((Path)localObject).lineTo(54.0F, 42.0F);
      ((Path)localObject).lineTo(54.0F, 30.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_video_call
 * JD-Core Version:    0.7.0.1
 */