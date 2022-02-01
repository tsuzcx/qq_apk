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

public class icons_filled_remove_chosen
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
      ((Path)localObject).moveTo(13.0016F, 2.17811F);
      ((Path)localObject).cubicTo(12.3828F, 1.82084F, 11.6204F, 1.82084F, 11.0016F, 2.17811F);
      ((Path)localObject).lineTo(5.99118F, 5.07085F);
      ((Path)localObject).lineTo(3.8966F, 2.97627F);
      ((Path)localObject).lineTo(2.83594F, 4.03693F);
      ((Path)localObject).lineTo(19.9533F, 21.154301F);
      ((Path)localObject).lineTo(21.014F, 20.093599F);
      ((Path)localObject).lineTo(19.1779F, 18.2575F);
      ((Path)localObject).lineTo(20.0082F, 17.778099F);
      ((Path)localObject).cubicTo(20.627001F, 17.420799F, 21.0082F, 16.760599F, 21.0082F, 16.046101F);
      ((Path)localObject).lineTo(21.0082F, 7.95546F);
      ((Path)localObject).cubicTo(21.0082F, 7.24092F, 20.627001F, 6.58067F, 20.0082F, 6.2234F);
      ((Path)localObject).lineTo(13.0016F, 2.17811F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.5194F, 13.5991F);
      ((Path)localObject).lineTo(14.3777F, 12.7733F);
      ((Path)localObject).lineTo(16.7554F, 10.4557F);
      ((Path)localObject).lineTo(13.4696F, 9.9782F);
      ((Path)localObject).lineTo(12.0001F, 7.00074F);
      ((Path)localObject).lineTo(10.6522F, 9.73188F);
      ((Path)localObject).lineTo(14.5194F, 13.5991F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(2.9949F, 7.95546F);
      ((Path)localObject).cubicTo(2.9949F, 7.47142F, 3.16983F, 7.01229F, 3.47505F, 6.65539F);
      ((Path)localObject).lineTo(7.27145F, 10.4518F);
      ((Path)localObject).lineTo(7.24482F, 10.4557F);
      ((Path)localObject).lineTo(8.45303F, 11.6334F);
      ((Path)localObject).lineTo(9.61814F, 12.7985F);
      ((Path)localObject).lineTo(9.06118F, 16.045799F);
      ((Path)localObject).lineTo(11.5546F, 14.735F);
      ((Path)localObject).lineTo(16.5781F, 19.758499F);
      ((Path)localObject).lineTo(13.0016F, 21.8234F);
      ((Path)localObject).cubicTo(12.3828F, 22.1807F, 11.6204F, 22.1807F, 11.0016F, 21.8234F);
      ((Path)localObject).lineTo(3.9949F, 17.778099F);
      ((Path)localObject).cubicTo(3.3761F, 17.420799F, 2.9949F, 16.760599F, 2.9949F, 16.046101F);
      ((Path)localObject).lineTo(2.9949F, 7.95546F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_remove_chosen
 * JD-Core Version:    0.7.0.1
 */