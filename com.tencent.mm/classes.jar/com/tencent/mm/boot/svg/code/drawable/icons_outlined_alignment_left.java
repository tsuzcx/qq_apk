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

public class icons_outlined_alignment_left
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(3.0F, 5.0F);
      ((Path)localObject).lineTo(21.0F, 5.0F);
      ((Path)localObject).lineTo(21.0F, 6.2F);
      ((Path)localObject).lineTo(3.0F, 6.2F);
      ((Path)localObject).lineTo(3.0F, 5.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.0F, 9.2F);
      ((Path)localObject).lineTo(15.0F, 9.2F);
      ((Path)localObject).lineTo(15.0F, 10.400001F);
      ((Path)localObject).lineTo(3.0F, 10.400001F);
      ((Path)localObject).lineTo(3.0F, 9.2F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.0F, 13.400001F);
      ((Path)localObject).lineTo(21.0F, 13.400001F);
      ((Path)localObject).lineTo(21.0F, 14.6F);
      ((Path)localObject).lineTo(3.0F, 14.6F);
      ((Path)localObject).lineTo(3.0F, 13.400001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.0F, 17.6F);
      ((Path)localObject).lineTo(15.0F, 17.6F);
      ((Path)localObject).lineTo(15.0F, 18.800001F);
      ((Path)localObject).lineTo(3.0F, 18.800001F);
      ((Path)localObject).lineTo(3.0F, 17.6F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_alignment_left
 * JD-Core Version:    0.7.0.1
 */