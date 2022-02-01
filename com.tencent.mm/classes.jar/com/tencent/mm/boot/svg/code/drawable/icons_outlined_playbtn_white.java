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

public class icons_outlined_playbtn_white
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.0F, 0.0F);
      ((Path)localObject).cubicTo(24.836555F, 0.0F, 32.0F, 7.163444F, 32.0F, 16.0F);
      ((Path)localObject).cubicTo(32.0F, 24.836555F, 24.836555F, 32.0F, 16.0F, 32.0F);
      ((Path)localObject).cubicTo(7.163444F, 32.0F, 0.0F, 24.836555F, 0.0F, 16.0F);
      ((Path)localObject).cubicTo(0.0F, 7.163444F, 7.163444F, 0.0F, 16.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.0F, 1.0F);
      ((Path)localObject).cubicTo(7.715729F, 1.0F, 1.0F, 7.715729F, 1.0F, 16.0F);
      ((Path)localObject).cubicTo(1.0F, 24.284271F, 7.715729F, 31.0F, 16.0F, 31.0F);
      ((Path)localObject).cubicTo(24.284271F, 31.0F, 31.0F, 24.284271F, 31.0F, 16.0F);
      ((Path)localObject).cubicTo(31.0F, 7.715729F, 24.284271F, 1.0F, 16.0F, 1.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.8F, 10.178544F);
      ((Path)localObject).cubicTo(12.939221F, 10.178544F, 13.076033F, 10.214876F, 13.196911F, 10.283949F);
      ((Path)localObject).lineTo(21.984459F, 15.305406F);
      ((Path)localObject).cubicTo(22.368074F, 15.524613F, 22.50135F, 16.013298F, 22.282143F, 16.396912F);
      ((Path)localObject).cubicTo(22.211271F, 16.520937F, 22.108484F, 16.623724F, 21.984459F, 16.694595F);
      ((Path)localObject).lineTo(13.196911F, 21.716051F);
      ((Path)localObject).cubicTo(12.813297F, 21.935259F, 12.324614F, 21.801981F, 12.105406F, 21.418367F);
      ((Path)localObject).cubicTo(12.036332F, 21.297489F, 12.0F, 21.160677F, 12.0F, 21.021456F);
      ((Path)localObject).lineTo(12.0F, 10.978543F);
      ((Path)localObject).cubicTo(12.0F, 10.536716F, 12.358172F, 10.178544F, 12.8F, 10.178544F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_playbtn_white
 * JD-Core Version:    0.7.0.1
 */