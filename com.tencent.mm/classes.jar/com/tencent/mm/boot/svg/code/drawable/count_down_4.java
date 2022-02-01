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

public class count_down_4
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(45.344002F, 14.0F);
      ((Path)localObject).lineTo(52.543999F, 14.0F);
      ((Path)localObject).lineTo(52.543999F, 47.984001F);
      ((Path)localObject).lineTo(60.32F, 47.984001F);
      ((Path)localObject).lineTo(60.32F, 54.248001F);
      ((Path)localObject).lineTo(52.543999F, 54.248001F);
      ((Path)localObject).lineTo(52.543999F, 65.407997F);
      ((Path)localObject).lineTo(45.056F, 65.407997F);
      ((Path)localObject).lineTo(45.056F, 54.248001F);
      ((Path)localObject).lineTo(20.0F, 54.248001F);
      ((Path)localObject).lineTo(20.0F, 46.832001F);
      ((Path)localObject).lineTo(45.344002F, 14.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(44.84F, 23.936001F);
      ((Path)localObject).lineTo(26.408001F, 47.984001F);
      ((Path)localObject).lineTo(45.056F, 47.984001F);
      ((Path)localObject).lineTo(45.056F, 23.936001F);
      ((Path)localObject).lineTo(44.84F, 23.936001F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.count_down_4
 * JD-Core Version:    0.7.0.1
 */