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

public class icons_outlined_more2
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(36.0F, 66.0F);
      localPath.cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      localPath.cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      localPath.cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      localPath.cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      localPath.close();
      localPath.moveTo(36.0F, 62.400002F);
      localPath.cubicTo(50.580318F, 62.400002F, 62.400002F, 50.580318F, 62.400002F, 36.0F);
      localPath.cubicTo(62.400002F, 21.419683F, 50.580318F, 9.6F, 36.0F, 9.6F);
      localPath.cubicTo(21.419683F, 9.6F, 9.6F, 21.419683F, 9.6F, 36.0F);
      localPath.cubicTo(9.6F, 50.580318F, 21.419683F, 62.400002F, 36.0F, 62.400002F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 39.0F);
      ((Path)localObject).cubicTo(34.343147F, 39.0F, 33.0F, 37.656853F, 33.0F, 36.0F);
      ((Path)localObject).cubicTo(33.0F, 34.343147F, 34.343147F, 33.0F, 36.0F, 33.0F);
      ((Path)localObject).cubicTo(37.656853F, 33.0F, 39.0F, 34.343147F, 39.0F, 36.0F);
      ((Path)localObject).cubicTo(39.0F, 37.656853F, 37.656853F, 39.0F, 36.0F, 39.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 39.0F);
      ((Path)localObject).cubicTo(46.343147F, 39.0F, 45.0F, 37.656853F, 45.0F, 36.0F);
      ((Path)localObject).cubicTo(45.0F, 34.343147F, 46.343147F, 33.0F, 48.0F, 33.0F);
      ((Path)localObject).cubicTo(49.656853F, 33.0F, 51.0F, 34.343147F, 51.0F, 36.0F);
      ((Path)localObject).cubicTo(51.0F, 37.656853F, 49.656853F, 39.0F, 48.0F, 39.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 39.0F);
      ((Path)localObject).cubicTo(22.343145F, 39.0F, 21.0F, 37.656853F, 21.0F, 36.0F);
      ((Path)localObject).cubicTo(21.0F, 34.343147F, 22.343145F, 33.0F, 24.0F, 33.0F);
      ((Path)localObject).cubicTo(25.656855F, 33.0F, 27.0F, 34.343147F, 27.0F, 36.0F);
      ((Path)localObject).cubicTo(27.0F, 37.656853F, 25.656855F, 39.0F, 24.0F, 39.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_more2
 * JD-Core Version:    0.7.0.1
 */