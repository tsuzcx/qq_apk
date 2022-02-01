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

public class game_chat_tips_icon_up
  extends c
{
  private final int height = 16;
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
      return 16;
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
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.816F, 11.328F);
      ((Path)localObject).lineTo(12.032F, 12.112F);
      ((Path)localObject).lineTo(8.0F, 8.122F);
      ((Path)localObject).lineTo(3.982F, 12.112F);
      ((Path)localObject).lineTo(3.184F, 11.328F);
      ((Path)localObject).lineTo(7.482F, 7.086F);
      ((Path)localObject).cubicTo(7.63133F, 6.93667F, 7.804F, 6.862F, 8.0F, 6.862F);
      ((Path)localObject).cubicTo(8.20533F, 6.862F, 8.378F, 6.93667F, 8.518F, 7.086F);
      ((Path)localObject).lineTo(12.816F, 11.328F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.816F, 6.764F);
      ((Path)localObject).lineTo(12.032F, 7.548F);
      ((Path)localObject).lineTo(8.014F, 3.558F);
      ((Path)localObject).lineTo(3.996F, 7.548F);
      ((Path)localObject).lineTo(3.198F, 6.764F);
      ((Path)localObject).lineTo(7.482F, 2.522F);
      ((Path)localObject).cubicTo(7.63133F, 2.37267F, 7.80867F, 2.298F, 8.014F, 2.298F);
      ((Path)localObject).cubicTo(8.21933F, 2.298F, 8.392F, 2.37267F, 8.532F, 2.522F);
      ((Path)localObject).lineTo(12.816F, 6.764F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.game_chat_tips_icon_up
 * JD-Core Version:    0.7.0.1
 */