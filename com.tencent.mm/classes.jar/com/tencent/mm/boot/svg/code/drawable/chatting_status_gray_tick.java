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

public class chatting_status_gray_tick
  extends c
{
  private final int height = 21;
  private final int width = 28;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 28;
      return 21;
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
      localPaint.setColor(-2763307);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.740437F, 16.820339F);
      ((Path)localObject).cubicTo(15.206292F, 11.227118F, 20.542009F, 5.501695F, 26.097961F, 0.0F);
      ((Path)localObject).cubicTo(26.568466F, 0.4881356F, 27.519485F, 1.474576F, 28.0F, 1.972881F);
      ((Path)localObject).cubicTo(22.303898F, 8.583051F, 15.887022F, 14.532204F, 10.040758F, 21.0F);
      ((Path)localObject).cubicTo(6.677154F, 18.21356F, 3.283518F, 15.488135F, 0.0F, 12.620339F);
      ((Path)localObject).lineTo(0.0F, 10.932203F);
      ((Path)localObject).cubicTo(0.4104398F, 10.718644F, 1.231319F, 10.291526F, 1.641759F, 10.088136F);
      ((Path)localObject).cubicTo(4.334644F, 12.335593F, 7.02753F, 14.593221F, 9.740437F, 16.820339F);
      ((Path)localObject).lineTo(9.740437F, 16.820339F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chatting_status_gray_tick
 * JD-Core Version:    0.7.0.1
 */