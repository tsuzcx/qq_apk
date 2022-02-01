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

public class icons_filled_add_chosen
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-855638017);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(13.0018F, 2.17811F);
      ((Path)localObject).cubicTo(12.383F, 1.82084F, 11.6206F, 1.82084F, 11.0018F, 2.17811F);
      ((Path)localObject).lineTo(3.99512F, 6.2234F);
      ((Path)localObject).cubicTo(3.37632F, 6.58067F, 2.99512F, 7.24092F, 2.99512F, 7.95546F);
      ((Path)localObject).lineTo(2.99512F, 16.046101F);
      ((Path)localObject).cubicTo(2.99512F, 16.760599F, 3.37632F, 17.420799F, 3.99512F, 17.778099F);
      ((Path)localObject).lineTo(11.0018F, 21.8234F);
      ((Path)localObject).cubicTo(11.6206F, 22.1807F, 12.383F, 22.1807F, 13.0018F, 21.8234F);
      ((Path)localObject).lineTo(20.0084F, 17.778099F);
      ((Path)localObject).cubicTo(20.627199F, 17.420799F, 21.0084F, 16.760599F, 21.0084F, 16.046101F);
      ((Path)localObject).lineTo(21.0084F, 7.95546F);
      ((Path)localObject).cubicTo(21.0084F, 7.24092F, 20.627199F, 6.58067F, 20.0084F, 6.2234F);
      ((Path)localObject).lineTo(13.0018F, 2.17811F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.4697F, 9.978F);
      ((Path)localObject).lineTo(12.0002F, 7.00054F);
      ((Path)localObject).lineTo(10.5307F, 9.978F);
      ((Path)localObject).lineTo(7.24491F, 10.4555F);
      ((Path)localObject).lineTo(9.62255F, 12.7731F);
      ((Path)localObject).lineTo(9.06126F, 16.045601F);
      ((Path)localObject).lineTo(12.0002F, 14.5005F);
      ((Path)localObject).lineTo(14.9391F, 16.045601F);
      ((Path)localObject).lineTo(14.3778F, 12.7731F);
      ((Path)localObject).lineTo(16.755501F, 10.4555F);
      ((Path)localObject).lineTo(13.4697F, 9.978F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_add_chosen
 * JD-Core Version:    0.7.0.1
 */