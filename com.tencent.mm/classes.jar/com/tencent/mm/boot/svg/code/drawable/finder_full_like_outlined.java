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

public class finder_full_like_outlined
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(33.871761F, 18.193398F);
      ((Path)localObject).lineTo(35.030296F, 19.324907F);
      ((Path)localObject).lineTo(35.99308F, 20.239637F);
      ((Path)localObject).lineTo(37.380127F, 18.915659F);
      ((Path)localObject).lineTo(38.114399F, 18.193398F);
      ((Path)localObject).cubicTo(43.972263F, 12.335534F, 53.469738F, 12.335534F, 59.327602F, 18.193398F);
      ((Path)localObject).cubicTo(65.130981F, 23.996773F, 65.184959F, 33.37236F, 59.489552F, 39.242195F);
      ((Path)localObject).lineTo(38.114288F, 60.619694F);
      ((Path)localObject).cubicTo(37.032997F, 61.701305F, 35.331314F, 61.784592F, 34.154396F, 60.869579F);
      ((Path)localObject).lineTo(33.871761F, 60.619804F);
      ((Path)localObject).lineTo(12.495378F, 39.243423F);
      ((Path)localObject).cubicTo(6.801199F, 33.37236F, 6.855182F, 23.996773F, 12.658556F, 18.193398F);
      ((Path)localObject).cubicTo(18.51642F, 12.335534F, 28.013895F, 12.335534F, 33.871761F, 18.193398F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(31.326176F, 20.738983F);
      ((Path)localObject).cubicTo(26.874199F, 16.287006F, 19.656118F, 16.287006F, 15.204141F, 20.738983F);
      ((Path)localObject).cubicTo(10.950482F, 24.992641F, 10.75639F, 31.782394F, 14.612329F, 36.230446F);
      ((Path)localObject).lineTo(15.040962F, 36.697838F);
      ((Path)localObject).lineTo(35.987999F, 57.653999F);
      ((Path)localObject).lineTo(56.905869F, 36.735287F);
      ((Path)localObject).cubicTo(61.088829F, 32.424221F, 61.185925F, 25.632872F, 57.222237F, 21.20422F);
      ((Path)localObject).lineTo(56.782021F, 20.738983F);
      ((Path)localObject).cubicTo(52.330044F, 16.287006F, 45.111961F, 16.287006F, 40.659985F, 20.738983F);
      ((Path)localObject).lineTo(39.453827F, 21.917252F);
      ((Path)localObject).lineTo(35.99308F, 25.185825F);
      ((Path)localObject).lineTo(32.092857F, 21.493258F);
      ((Path)localObject).lineTo(31.326176F, 20.738983F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_full_like_outlined
 * JD-Core Version:    0.7.0.1
 */