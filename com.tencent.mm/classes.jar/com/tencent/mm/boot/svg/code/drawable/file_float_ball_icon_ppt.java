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

public class file_float_ball_icon_ppt
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
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-892609);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(19.751953F, 16.089844F);
      ((Path)localObject).lineTo(26.326172F, 16.089844F);
      ((Path)localObject).cubicTo(29.689453F, 16.089844F, 32.021484F, 18.375F, 32.021484F, 21.75F);
      ((Path)localObject).cubicTo(32.021484F, 25.125F, 29.619141F, 27.410156F, 26.197266F, 27.410156F);
      ((Path)localObject).lineTo(22.775391F, 27.410156F);
      ((Path)localObject).lineTo(22.775391F, 33.0F);
      ((Path)localObject).lineTo(19.751953F, 33.0F);
      ((Path)localObject).lineTo(19.751953F, 16.089844F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.775391F, 18.5625F);
      ((Path)localObject).lineTo(22.775391F, 24.972656F);
      ((Path)localObject).lineTo(25.517578F, 24.972656F);
      ((Path)localObject).cubicTo(27.685547F, 24.972656F, 28.951172F, 23.800781F, 28.951172F, 21.75F);
      ((Path)localObject).cubicTo(28.951172F, 19.722656F, 27.697266F, 18.5625F, 25.529297F, 18.5625F);
      ((Path)localObject).lineTo(22.775391F, 18.5625F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.file_float_ball_icon_ppt
 * JD-Core Version:    0.7.0.1
 */