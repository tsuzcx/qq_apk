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

public class icons_left_down_arrow
  extends c
{
  private final int height = 17;
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
      return 17;
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(4.61934F, 13.168F);
      ((Path)localObject).lineTo(11.286F, 13.168F);
      ((Path)localObject).lineTo(11.286F, 11.8346F);
      ((Path)localObject).lineTo(5.5623F, 11.8346F);
      ((Path)localObject).lineTo(12.6667F, 4.73021F);
      ((Path)localObject).lineTo(11.7239F, 3.78741F);
      ((Path)localObject).lineTo(4.61934F, 10.892F);
      ((Path)localObject).lineTo(4.61934F, 5.16797F);
      ((Path)localObject).lineTo(3.28601F, 5.16797F);
      ((Path)localObject).lineTo(3.28601F, 11.8346F);
      ((Path)localObject).lineTo(3.28601F, 13.168F);
      ((Path)localObject).lineTo(4.61934F, 13.168F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_left_down_arrow
 * JD-Core Version:    0.7.0.1
 */