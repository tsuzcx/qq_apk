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

public class icons_outlined_switch_window
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
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.0F, 12.0F);
      ((Path)localObject).cubicTo(21.552284F, 12.0F, 22.0F, 12.447716F, 22.0F, 13.0F);
      ((Path)localObject).lineTo(22.0F, 19.0F);
      ((Path)localObject).cubicTo(22.0F, 19.552284F, 21.552284F, 20.0F, 21.0F, 20.0F);
      ((Path)localObject).lineTo(12.0F, 20.0F);
      ((Path)localObject).cubicTo(11.447716F, 20.0F, 11.0F, 19.552284F, 11.0F, 19.0F);
      ((Path)localObject).lineTo(11.0F, 13.0F);
      ((Path)localObject).cubicTo(11.0F, 12.447716F, 11.447716F, 12.0F, 12.0F, 12.0F);
      ((Path)localObject).lineTo(21.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.799999F, 13.2F);
      ((Path)localObject).lineTo(12.2F, 13.2F);
      ((Path)localObject).lineTo(12.2F, 18.799999F);
      ((Path)localObject).lineTo(20.799999F, 18.799999F);
      ((Path)localObject).lineTo(20.799999F, 13.2F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.0F, 4.0F);
      ((Path)localObject).cubicTo(18.552284F, 4.0F, 19.0F, 4.447715F, 19.0F, 5.0F);
      ((Path)localObject).lineTo(19.0F, 11.0F);
      ((Path)localObject).lineTo(17.799999F, 11.0F);
      ((Path)localObject).lineTo(17.799999F, 5.2F);
      ((Path)localObject).lineTo(3.2F, 5.2F);
      ((Path)localObject).lineTo(3.2F, 15.8F);
      ((Path)localObject).lineTo(10.0F, 15.8F);
      ((Path)localObject).lineTo(10.0F, 17.0F);
      ((Path)localObject).lineTo(3.0F, 17.0F);
      ((Path)localObject).cubicTo(2.447715F, 17.0F, 2.0F, 16.552284F, 2.0F, 16.0F);
      ((Path)localObject).lineTo(2.0F, 5.0F);
      ((Path)localObject).cubicTo(2.0F, 4.447715F, 2.447715F, 4.0F, 3.0F, 4.0F);
      ((Path)localObject).lineTo(18.0F, 4.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_switch_window
 * JD-Core Version:    0.7.0.1
 */