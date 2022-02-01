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

public class finder_live_notice_icon
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(16.0F, 0.0F);
      ((Path)localObject).lineTo(16.0F, 16.0F);
      ((Path)localObject).lineTo(0.0F, 16.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(8.0F, 1.333333F);
      localPath.cubicTo(11.681898F, 1.333333F, 14.666667F, 4.318102F, 14.666667F, 8.0F);
      localPath.cubicTo(14.666667F, 11.681898F, 11.681898F, 14.666667F, 8.0F, 14.666667F);
      localPath.cubicTo(4.318102F, 14.666667F, 1.333333F, 11.681898F, 1.333333F, 8.0F);
      localPath.cubicTo(1.333333F, 4.318102F, 4.318102F, 1.333333F, 8.0F, 1.333333F);
      localPath.close();
      localPath.moveTo(8.0F, 2.333333F);
      localPath.cubicTo(4.870387F, 2.333333F, 2.333333F, 4.870387F, 2.333333F, 8.0F);
      localPath.cubicTo(2.333333F, 11.129614F, 4.870387F, 13.666667F, 8.0F, 13.666667F);
      localPath.cubicTo(11.129614F, 13.666667F, 13.666667F, 11.129614F, 13.666667F, 8.0F);
      localPath.cubicTo(13.666667F, 4.870387F, 11.129614F, 2.333333F, 8.0F, 2.333333F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(8.0F, 4.333333F);
      ((Path)localObject).cubicTo(10.025044F, 4.333333F, 11.666667F, 5.974956F, 11.666667F, 8.0F);
      ((Path)localObject).cubicTo(11.666667F, 10.025044F, 10.025044F, 11.666667F, 8.0F, 11.666667F);
      ((Path)localObject).cubicTo(5.974956F, 11.666667F, 4.333333F, 10.025044F, 4.333333F, 8.0F);
      ((Path)localObject).cubicTo(4.333333F, 5.974956F, 5.974956F, 4.333333F, 8.0F, 4.333333F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_notice_icon
 * JD-Core Version:    0.7.0.1
 */