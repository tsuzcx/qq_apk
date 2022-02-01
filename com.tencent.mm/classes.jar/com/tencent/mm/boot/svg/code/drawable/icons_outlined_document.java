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

public class icons_outlined_document
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
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(1.5F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(41.993713F, 6.0F);
      localPath.lineTo(60.0F, 24.0F);
      localPath.lineTo(60.0F, 63.004063F);
      localPath.cubicTo(60.0F, 64.662689F, 58.662483F, 66.0F, 57.012573F, 66.0F);
      localPath.lineTo(17.987425F, 66.0F);
      localPath.cubicTo(16.34676F, 66.0F, 15.0F, 64.658676F, 15.0F, 63.004063F);
      localPath.lineTo(15.0F, 8.995937F);
      localPath.cubicTo(15.0F, 7.33731F, 16.337517F, 6.0F, 17.987425F, 6.0F);
      localPath.lineTo(41.993713F, 6.0F);
      localPath.close();
      localPath.moveTo(37.199001F, 9.6F);
      localPath.lineTo(18.6F, 9.6F);
      localPath.lineTo(18.6F, 62.400002F);
      localPath.lineTo(56.400002F, 62.400002F);
      localPath.lineTo(56.400002F, 28.799F);
      localPath.lineTo(42.0F, 28.799999F);
      localPath.cubicTo(39.349033F, 28.799999F, 37.200001F, 26.650967F, 37.200001F, 24.0F);
      localPath.lineTo(37.199001F, 9.6F);
      localPath.close();
      localPath.moveTo(56.109001F, 25.200001F);
      localPath.lineTo(40.799F, 9.897F);
      localPath.lineTo(40.799999F, 24.0F);
      localPath.cubicTo(40.799999F, 24.662743F, 41.337257F, 25.200001F, 42.0F, 25.200001F);
      localPath.lineTo(56.109001F, 25.200001F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_document
 * JD-Core Version:    0.7.0.1
 */