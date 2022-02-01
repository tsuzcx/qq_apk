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

public class icons_outlined_pause2
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
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 0.0F);
      ((Path)localObject).cubicTo(18.627417F, 0.0F, 24.0F, 5.372583F, 24.0F, 12.0F);
      ((Path)localObject).cubicTo(24.0F, 18.627417F, 18.627417F, 24.0F, 12.0F, 24.0F);
      ((Path)localObject).cubicTo(5.372583F, 24.0F, 0.0F, 18.627417F, 0.0F, 12.0F);
      ((Path)localObject).cubicTo(0.0F, 5.372583F, 5.372583F, 0.0F, 12.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 0.72F);
      ((Path)localObject).cubicTo(5.770228F, 0.72F, 0.72F, 5.770228F, 0.72F, 12.0F);
      ((Path)localObject).cubicTo(0.72F, 18.229773F, 5.770228F, 23.280001F, 12.0F, 23.280001F);
      ((Path)localObject).cubicTo(18.229773F, 23.280001F, 23.280001F, 18.229773F, 23.280001F, 12.0F);
      ((Path)localObject).cubicTo(23.280001F, 5.770228F, 18.229773F, 0.72F, 12.0F, 0.72F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.2F, 7.8F);
      ((Path)localObject).cubicTo(10.531371F, 7.8F, 10.8F, 8.05072F, 10.8F, 8.36F);
      ((Path)localObject).lineTo(10.8F, 15.64F);
      ((Path)localObject).cubicTo(10.8F, 15.94928F, 10.531371F, 16.200001F, 10.2F, 16.200001F);
      ((Path)localObject).lineTo(9.0F, 16.200001F);
      ((Path)localObject).cubicTo(8.668629F, 16.200001F, 8.4F, 15.94928F, 8.4F, 15.64F);
      ((Path)localObject).lineTo(8.4F, 8.36F);
      ((Path)localObject).cubicTo(8.4F, 8.05072F, 8.668629F, 7.8F, 9.0F, 7.8F);
      ((Path)localObject).lineTo(10.2F, 7.8F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.0F, 7.8F);
      ((Path)localObject).cubicTo(15.33137F, 7.8F, 15.6F, 8.05072F, 15.6F, 8.36F);
      ((Path)localObject).lineTo(15.6F, 15.64F);
      ((Path)localObject).cubicTo(15.6F, 15.94928F, 15.33137F, 16.200001F, 15.0F, 16.200001F);
      ((Path)localObject).lineTo(13.8F, 16.200001F);
      ((Path)localObject).cubicTo(13.468629F, 16.200001F, 13.2F, 15.94928F, 13.2F, 15.64F);
      ((Path)localObject).lineTo(13.2F, 8.36F);
      ((Path)localObject).cubicTo(13.2F, 8.05072F, 13.468629F, 7.8F, 13.8F, 7.8F);
      ((Path)localObject).lineTo(15.0F, 7.8F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_pause2
 * JD-Core Version:    0.7.0.1
 */