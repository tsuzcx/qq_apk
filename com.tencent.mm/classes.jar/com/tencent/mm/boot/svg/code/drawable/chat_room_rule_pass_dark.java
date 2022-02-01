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

public class chat_room_rule_pass_dark
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
      localPaint.setColor(-3236350);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(1.0F, 6.0F);
      ((Path)localObject).cubicTo(1.0F, 8.76142F, 3.23858F, 11.0F, 6.0F, 11.0F);
      ((Path)localObject).cubicTo(8.76142F, 11.0F, 11.0F, 8.76142F, 11.0F, 6.0F);
      ((Path)localObject).cubicTo(11.0F, 3.23858F, 8.76142F, 1.0F, 6.0F, 1.0F);
      ((Path)localObject).cubicTo(3.23858F, 1.0F, 1.0F, 3.23858F, 1.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.211371F, 4.27F);
      ((Path)localObject).lineTo(5.41171F, 7.06966F);
      ((Path)localObject).lineTo(4.02876F, 5.68671F);
      ((Path)localObject).lineTo(3.49999F, 6.21548F);
      ((Path)localObject).lineTo(4.70586F, 7.42222F);
      ((Path)localObject).cubicTo(5.09629F, 7.81293F, 5.72954F, 7.81311F, 6.12019F, 7.42262F);
      ((Path)localObject).lineTo(8.74264F, 4.80126F);
      ((Path)localObject).lineTo(8.211371F, 4.27F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chat_room_rule_pass_dark
 * JD-Core Version:    0.7.0.1
 */