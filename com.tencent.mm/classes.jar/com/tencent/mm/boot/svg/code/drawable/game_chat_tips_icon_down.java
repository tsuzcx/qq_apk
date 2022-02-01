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

public class game_chat_tips_icon_down
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
      ((Path)localObject).moveTo(3.184F, 8.954001F);
      ((Path)localObject).lineTo(3.968F, 8.17F);
      ((Path)localObject).lineTo(8.0F, 12.16F);
      ((Path)localObject).lineTo(12.018F, 8.17F);
      ((Path)localObject).lineTo(12.816F, 8.954001F);
      ((Path)localObject).lineTo(8.518F, 13.196F);
      ((Path)localObject).cubicTo(8.368671F, 13.3453F, 8.19133F, 13.42F, 7.986F, 13.42F);
      ((Path)localObject).cubicTo(7.79F, 13.42F, 7.622F, 13.3453F, 7.482F, 13.196F);
      ((Path)localObject).lineTo(3.184F, 8.954001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.212F, 4.474F);
      ((Path)localObject).lineTo(3.996F, 3.69F);
      ((Path)localObject).lineTo(8.014F, 7.68F);
      ((Path)localObject).lineTo(12.032F, 3.69F);
      ((Path)localObject).lineTo(12.83F, 4.474F);
      ((Path)localObject).lineTo(8.546F, 8.716F);
      ((Path)localObject).cubicTo(8.39667F, 8.86533F, 8.21933F, 8.94F, 8.014F, 8.94F);
      ((Path)localObject).cubicTo(7.80867F, 8.94F, 7.636F, 8.86533F, 7.496F, 8.716F);
      ((Path)localObject).lineTo(3.212F, 4.474F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.game_chat_tips_icon_down
 * JD-Core Version:    0.7.0.1
 */