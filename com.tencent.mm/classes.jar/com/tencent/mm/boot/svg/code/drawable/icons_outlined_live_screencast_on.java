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

public class icons_outlined_live_screencast_on
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
      ((Path)localObject).moveTo(20.0F, 3.0F);
      ((Path)localObject).cubicTo(20.552284F, 3.0F, 21.0F, 3.447715F, 21.0F, 4.0F);
      ((Path)localObject).lineTo(21.0F, 15.0F);
      ((Path)localObject).cubicTo(21.0F, 15.552284F, 20.552284F, 16.0F, 20.0F, 16.0F);
      ((Path)localObject).lineTo(15.937F, 16.0F);
      ((Path)localObject).lineTo(18.799038F, 20.955128F);
      ((Path)localObject).lineTo(17.5F, 21.705128F);
      ((Path)localObject).lineTo(16.052999F, 19.200001F);
      ((Path)localObject).lineTo(7.945F, 19.200001F);
      ((Path)localObject).lineTo(6.499038F, 21.705128F);
      ((Path)localObject).lineTo(5.2F, 20.955128F);
      ((Path)localObject).lineTo(8.059F, 16.0F);
      ((Path)localObject).lineTo(4.0F, 16.0F);
      ((Path)localObject).cubicTo(3.447715F, 16.0F, 3.0F, 15.552284F, 3.0F, 15.0F);
      ((Path)localObject).lineTo(3.0F, 4.0F);
      ((Path)localObject).cubicTo(3.0F, 3.447715F, 3.447715F, 3.0F, 4.0F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.205F, 16.0F);
      ((Path)localObject).lineTo(9.792F, 16.0F);
      ((Path)localObject).lineTo(8.637F, 18.0F);
      ((Path)localObject).lineTo(15.36F, 18.0F);
      ((Path)localObject).lineTo(14.205F, 16.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.799999F, 4.2F);
      ((Path)localObject).lineTo(4.2F, 4.2F);
      ((Path)localObject).lineTo(4.2F, 14.8F);
      ((Path)localObject).lineTo(19.799999F, 14.8F);
      ((Path)localObject).lineTo(19.799999F, 4.2F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_live_screencast_on
 * JD-Core Version:    0.7.0.1
 */