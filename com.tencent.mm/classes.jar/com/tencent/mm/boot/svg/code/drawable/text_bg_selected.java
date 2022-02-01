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

public class text_bg_selected
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 3.0F);
      localPath.cubicTo(0.0F, 1.343146F, 1.343146F, 0.0F, 3.0F, 0.0F);
      localPath.lineTo(55.5F, 0.0F);
      localPath.cubicTo(57.156853F, 0.0F, 58.5F, 1.343146F, 58.5F, 3.0F);
      localPath.lineTo(58.5F, 55.5F);
      localPath.cubicTo(58.5F, 57.156853F, 57.156853F, 58.5F, 55.5F, 58.5F);
      localPath.lineTo(3.0F, 58.5F);
      localPath.cubicTo(1.343146F, 58.5F, 0.0F, 57.156853F, 0.0F, 55.5F);
      localPath.lineTo(0.0F, 3.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(31.5F, 18.0F);
      ((Path)localObject).lineTo(31.5F, 46.5F);
      ((Path)localObject).cubicTo(31.5F, 47.328426F, 30.828426F, 48.0F, 30.0F, 48.0F);
      ((Path)localObject).lineTo(27.0F, 48.0F);
      ((Path)localObject).cubicTo(26.171574F, 48.0F, 25.5F, 47.328426F, 25.5F, 46.5F);
      ((Path)localObject).lineTo(25.5F, 18.0F);
      ((Path)localObject).lineTo(13.5F, 18.0F);
      ((Path)localObject).cubicTo(12.671573F, 18.0F, 12.0F, 17.328426F, 12.0F, 16.5F);
      ((Path)localObject).lineTo(12.0F, 13.5F);
      ((Path)localObject).cubicTo(12.0F, 12.671573F, 12.671573F, 12.0F, 13.5F, 12.0F);
      ((Path)localObject).lineTo(45.0F, 12.0F);
      ((Path)localObject).cubicTo(45.828426F, 12.0F, 46.5F, 12.671573F, 46.5F, 13.5F);
      ((Path)localObject).lineTo(46.5F, 16.5F);
      ((Path)localObject).cubicTo(46.5F, 17.328426F, 45.828426F, 18.0F, 45.0F, 18.0F);
      ((Path)localObject).lineTo(31.5F, 18.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.text_bg_selected
 * JD-Core Version:    0.7.0.1
 */