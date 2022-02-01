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

public class icons_outlined_copy
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(37.200001F, 9.6F);
      ((Path)localObject).lineTo(18.6F, 9.6F);
      ((Path)localObject).lineTo(18.6F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 28.799999F);
      ((Path)localObject).lineTo(42.0F, 28.799999F);
      ((Path)localObject).cubicTo(39.349033F, 28.799999F, 37.200001F, 26.650967F, 37.200001F, 24.0F);
      ((Path)localObject).lineTo(37.200001F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(40.799999F, 9.896984F);
      ((Path)localObject).lineTo(40.799999F, 24.0F);
      ((Path)localObject).cubicTo(40.799999F, 24.662743F, 41.337257F, 25.200001F, 42.0F, 25.200001F);
      ((Path)localObject).lineTo(56.10836F, 25.200001F);
      ((Path)localObject).lineTo(40.799999F, 9.896984F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.987425F, 6.0F);
      ((Path)localObject).lineTo(41.993713F, 6.0F);
      ((Path)localObject).lineTo(60.0F, 24.0F);
      ((Path)localObject).lineTo(60.0F, 63.004063F);
      ((Path)localObject).cubicTo(60.0F, 64.662689F, 58.662483F, 66.0F, 57.012573F, 66.0F);
      ((Path)localObject).lineTo(17.987425F, 66.0F);
      ((Path)localObject).cubicTo(16.34676F, 66.0F, 15.0F, 64.658676F, 15.0F, 63.004063F);
      ((Path)localObject).lineTo(15.0F, 8.995937F);
      ((Path)localObject).cubicTo(15.0F, 7.33731F, 16.337517F, 6.0F, 17.987425F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_copy
 * JD-Core Version:    0.7.0.1
 */