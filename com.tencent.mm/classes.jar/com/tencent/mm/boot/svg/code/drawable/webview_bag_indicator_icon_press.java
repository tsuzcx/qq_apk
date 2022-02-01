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

public class webview_bag_indicator_icon_press
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(72.0F, 130.8F);
      localPath.cubicTo(104.47434F, 130.8F, 130.8F, 104.47434F, 130.8F, 72.0F);
      localPath.cubicTo(130.8F, 39.525658F, 104.47434F, 13.2F, 72.0F, 13.2F);
      localPath.cubicTo(39.525658F, 13.2F, 13.2F, 39.525658F, 13.2F, 72.0F);
      localPath.cubicTo(13.2F, 104.47434F, 39.525658F, 130.8F, 72.0F, 130.8F);
      localPath.close();
      localPath.moveTo(72.0F, 138.0F);
      localPath.cubicTo(35.549206F, 138.0F, 6.0F, 108.45079F, 6.0F, 72.0F);
      localPath.cubicTo(6.0F, 35.549206F, 35.549206F, 6.0F, 72.0F, 6.0F);
      localPath.cubicTo(108.45079F, 6.0F, 138.0F, 35.549206F, 138.0F, 72.0F);
      localPath.cubicTo(138.0F, 108.45079F, 108.45079F, 138.0F, 72.0F, 138.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(72.0F, 106.8F);
      ((Path)localObject).cubicTo(91.219513F, 106.8F, 106.8F, 91.219513F, 106.8F, 72.0F);
      ((Path)localObject).cubicTo(106.8F, 52.780491F, 91.219513F, 37.200001F, 72.0F, 37.200001F);
      ((Path)localObject).cubicTo(52.780491F, 37.200001F, 37.200001F, 52.780491F, 37.200001F, 72.0F);
      ((Path)localObject).cubicTo(37.200001F, 91.219513F, 52.780491F, 106.8F, 72.0F, 106.8F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(72.0F, 114.0F);
      ((Path)localObject).cubicTo(48.804039F, 114.0F, 30.0F, 95.195961F, 30.0F, 72.0F);
      ((Path)localObject).cubicTo(30.0F, 48.804039F, 48.804039F, 30.0F, 72.0F, 30.0F);
      ((Path)localObject).cubicTo(95.195961F, 30.0F, 114.0F, 48.804039F, 114.0F, 72.0F);
      ((Path)localObject).cubicTo(114.0F, 95.195961F, 95.195961F, 114.0F, 72.0F, 114.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.webview_bag_indicator_icon_press
 * JD-Core Version:    0.7.0.1
 */