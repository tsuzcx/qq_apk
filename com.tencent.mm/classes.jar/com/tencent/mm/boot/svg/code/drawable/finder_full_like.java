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

public class finder_full_like
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.658556F, 18.193398F);
      ((Path)localObject).cubicTo(18.51642F, 12.335534F, 28.013895F, 12.335534F, 33.871761F, 18.193398F);
      ((Path)localObject).cubicTo(34.420181F, 18.741817F, 35.127285F, 19.423899F, 35.99308F, 20.239637F);
      ((Path)localObject).cubicTo(36.858875F, 19.423899F, 37.565979F, 18.741817F, 38.114399F, 18.193398F);
      ((Path)localObject).cubicTo(43.972263F, 12.335534F, 53.469738F, 12.335534F, 59.327602F, 18.193398F);
      ((Path)localObject).cubicTo(65.130981F, 23.996773F, 65.184959F, 33.37236F, 59.489552F, 39.242195F);
      ((Path)localObject).lineTo(38.114288F, 60.619694F);
      ((Path)localObject).cubicTo(36.94289F, 61.791439F, 35.043392F, 61.791538F, 33.871761F, 60.620026F);
      ((Path)localObject).cubicTo(33.871723F, 60.619991F, 33.871685F, 60.619953F, 33.871761F, 60.619804F);
      ((Path)localObject).lineTo(12.495378F, 39.243423F);
      ((Path)localObject).lineTo(12.495378F, 39.243423F);
      ((Path)localObject).cubicTo(6.801199F, 33.37236F, 6.855182F, 23.996773F, 12.658556F, 18.193398F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_full_like
 * JD-Core Version:    0.7.0.1
 */