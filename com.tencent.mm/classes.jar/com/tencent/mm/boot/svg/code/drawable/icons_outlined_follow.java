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

public class icons_outlined_follow
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(36.0F, 15.0F);
      localPath.cubicTo(47.59798F, 15.0F, 57.0F, 24.40202F, 57.0F, 36.0F);
      localPath.cubicTo(57.0F, 47.59798F, 47.59798F, 57.0F, 36.0F, 57.0F);
      localPath.cubicTo(24.40202F, 57.0F, 15.0F, 47.59798F, 15.0F, 36.0F);
      localPath.cubicTo(15.0F, 24.40202F, 24.40202F, 15.0F, 36.0F, 15.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-372399);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.25F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 33.75F);
      ((Path)localObject).lineTo(21.0F, 33.75F);
      ((Path)localObject).lineTo(21.0F, 38.25F);
      ((Path)localObject).lineTo(33.75F, 38.25F);
      ((Path)localObject).lineTo(33.75F, 51.0F);
      ((Path)localObject).lineTo(38.25F, 51.0F);
      ((Path)localObject).lineTo(38.25F, 38.25F);
      ((Path)localObject).lineTo(51.0F, 38.25F);
      ((Path)localObject).lineTo(51.0F, 33.75F);
      ((Path)localObject).lineTo(38.25F, 33.75F);
      ((Path)localObject).lineTo(38.25F, 21.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_follow
 * JD-Core Version:    0.7.0.1
 */