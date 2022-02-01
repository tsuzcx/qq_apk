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

public class chat_room_rule_reject_dark
  extends c
{
  private final int height = 12;
  private final int width = 12;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 12;
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
      localPaint.setColor(1291845631);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(6.0F, 11.0F);
      ((Path)localObject).cubicTo(3.23858F, 11.0F, 1.0F, 8.76142F, 1.0F, 6.0F);
      ((Path)localObject).cubicTo(1.0F, 3.23858F, 3.23858F, 1.0F, 6.0F, 1.0F);
      ((Path)localObject).cubicTo(8.76142F, 1.0F, 11.0F, 3.23858F, 11.0F, 6.0F);
      ((Path)localObject).cubicTo(11.0F, 8.76142F, 8.76142F, 11.0F, 6.0F, 11.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.50262F, 3.96705F);
      ((Path)localObject).lineTo(8.03296F, 4.49738F);
      ((Path)localObject).lineTo(6.53033F, 6.0F);
      ((Path)localObject).lineTo(8.03291F, 7.50258F);
      ((Path)localObject).lineTo(7.50258F, 8.03291F);
      ((Path)localObject).lineTo(6.0F, 6.53033F);
      ((Path)localObject).lineTo(4.49742F, 8.03291F);
      ((Path)localObject).lineTo(3.96709F, 7.50258F);
      ((Path)localObject).lineTo(5.46967F, 6.0F);
      ((Path)localObject).lineTo(3.96705F, 4.49738F);
      ((Path)localObject).lineTo(4.49738F, 3.96705F);
      ((Path)localObject).lineTo(6.0F, 5.46967F);
      ((Path)localObject).lineTo(7.50262F, 3.96705F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chat_room_rule_reject_dark
 * JD-Core Version:    0.7.0.1
 */