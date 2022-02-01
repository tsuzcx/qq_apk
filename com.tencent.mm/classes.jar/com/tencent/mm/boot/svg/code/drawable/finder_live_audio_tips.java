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

public class finder_live_audio_tips
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(13.571068F, 4.5F);
      ((Path)localObject).cubicTo(15.380712F, 6.419417F, 16.5F, 9.071068F, 16.5F, 12.0F);
      ((Path)localObject).cubicTo(16.5F, 14.928932F, 15.380712F, 17.580582F, 13.571068F, 19.5F);
      ((Path)localObject).lineTo(12.510407F, 18.375F);
      ((Path)localObject).cubicTo(14.095152F, 16.694124F, 15.0F, 14.425054F, 15.0F, 12.0F);
      ((Path)localObject).cubicTo(15.0F, 9.574946F, 14.095152F, 7.305876F, 12.510407F, 5.625F);
      ((Path)localObject).lineTo(13.571068F, 4.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.096194F, 7.125F);
      ((Path)localObject).cubicTo(12.272463F, 8.372622F, 13.0F, 10.096194F, 13.0F, 12.0F);
      ((Path)localObject).cubicTo(13.0F, 13.903806F, 12.272463F, 15.627378F, 11.096194F, 16.875F);
      ((Path)localObject).lineTo(10.035534F, 15.75F);
      ((Path)localObject).cubicTo(10.968138F, 14.760825F, 11.5F, 13.427082F, 11.5F, 12.0F);
      ((Path)localObject).cubicTo(11.5F, 10.572918F, 10.968138F, 9.239176F, 10.035534F, 8.25F);
      ((Path)localObject).lineTo(11.096194F, 7.125F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.621321F, 9.75F);
      ((Path)localObject).cubicTo(9.164213F, 10.325825F, 9.5F, 11.121321F, 9.5F, 12.0F);
      ((Path)localObject).cubicTo(9.5F, 12.878679F, 9.164213F, 13.674175F, 8.621321F, 14.25F);
      ((Path)localObject).lineTo(8.621321F, 14.25F);
      ((Path)localObject).lineTo(6.5F, 12.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_audio_tips
 * JD-Core Version:    0.7.0.1
 */