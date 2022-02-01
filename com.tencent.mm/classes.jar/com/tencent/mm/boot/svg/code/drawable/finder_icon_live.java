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

public class finder_icon_live
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(36.0F, 6.0F);
      localPath.cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      localPath.cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      localPath.cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      localPath.cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      localPath.close();
      localPath.moveTo(36.0F, 10.5F);
      localPath.cubicTo(21.916739F, 10.5F, 10.5F, 21.916739F, 10.5F, 36.0F);
      localPath.cubicTo(10.5F, 50.08326F, 21.916739F, 61.5F, 36.0F, 61.5F);
      localPath.cubicTo(50.08326F, 61.5F, 61.5F, 50.08326F, 61.5F, 36.0F);
      localPath.cubicTo(61.5F, 21.916739F, 50.08326F, 10.5F, 36.0F, 10.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 19.5F);
      ((Path)localObject).cubicTo(45.112698F, 19.5F, 52.5F, 26.887302F, 52.5F, 36.0F);
      ((Path)localObject).cubicTo(52.5F, 45.112698F, 45.112698F, 52.5F, 36.0F, 52.5F);
      ((Path)localObject).cubicTo(26.887302F, 52.5F, 19.5F, 45.112698F, 19.5F, 36.0F);
      ((Path)localObject).cubicTo(19.5F, 26.887302F, 26.887302F, 19.5F, 36.0F, 19.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icon_live
 * JD-Core Version:    0.7.0.1
 */