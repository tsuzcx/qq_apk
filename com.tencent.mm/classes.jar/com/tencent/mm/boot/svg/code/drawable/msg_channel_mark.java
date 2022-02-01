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

public class msg_channel_mark
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
      localPaint.setColor(-8548183);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.8191F, 5.18372F);
      ((Path)localObject).lineTo(12.7134F, 2.65039F);
      ((Path)localObject).lineTo(11.1134F, 2.65039F);
      ((Path)localObject).lineTo(10.2194F, 5.18306F);
      ((Path)localObject).lineTo(8.48322F, 5.18347F);
      ((Path)localObject).lineTo(7.91841F, 6.78347F);
      ((Path)localObject).lineTo(9.65455F, 6.78306F);
      ((Path)localObject).lineTo(7.34801F, 13.3171F);
      ((Path)localObject).lineTo(8.94801F, 13.3171F);
      ((Path)localObject).lineTo(9.84253F, 10.7831F);
      ((Path)localObject).lineTo(11.709F, 10.7837F);
      ((Path)localObject).lineTo(12.2738F, 9.18373F);
      ((Path)localObject).lineTo(10.4073F, 9.18306F);
      ((Path)localObject).lineTo(11.2543F, 6.78372F);
      ((Path)localObject).lineTo(13.121F, 6.78372F);
      ((Path)localObject).lineTo(13.6858F, 5.18372F);
      ((Path)localObject).lineTo(11.8191F, 5.18372F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.40664F, 9.18311F);
      ((Path)localObject).lineTo(8.71338F, 2.65044F);
      ((Path)localObject).lineTo(7.11338F, 2.65044F);
      ((Path)localObject).lineTo(6.21934F, 5.18311F);
      ((Path)localObject).lineTo(4.35243F, 5.18377F);
      ((Path)localObject).lineTo(3.78762F, 6.78377F);
      ((Path)localObject).lineTo(5.65452F, 6.78311F);
      ((Path)localObject).lineTo(4.80707F, 9.18377F);
      ((Path)localObject).lineTo(2.94041F, 9.18377F);
      ((Path)localObject).lineTo(2.3756F, 10.7838F);
      ((Path)localObject).lineTo(4.24226F, 10.7838F);
      ((Path)localObject).lineTo(3.34798F, 13.3171F);
      ((Path)localObject).lineTo(4.94798F, 13.3171F);
      ((Path)localObject).lineTo(5.84183F, 10.7831F);
      ((Path)localObject).lineTo(7.57968F, 10.7835F);
      ((Path)localObject).lineTo(8.14449F, 9.18353F);
      ((Path)localObject).lineTo(6.40664F, 9.18311F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.msg_channel_mark
 * JD-Core Version:    0.7.0.1
 */