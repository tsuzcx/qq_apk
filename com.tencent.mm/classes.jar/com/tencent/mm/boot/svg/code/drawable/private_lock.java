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

public class private_lock
  extends c
{
  private final int height = 15;
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
      return 15;
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
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(3.33365F, 3.50016F);
      ((Path)localObject).cubicTo(3.33365F, 2.0274F, 4.52755F, 0.833496F, 6.00031F, 0.833496F);
      ((Path)localObject).cubicTo(7.47307F, 0.833496F, 8.66698F, 2.0274F, 8.66698F, 3.50016F);
      ((Path)localObject).lineTo(8.66698F, 5.5001F);
      ((Path)localObject).lineTo(10.6664F, 5.5001F);
      ((Path)localObject).cubicTo(11.0349F, 5.5001F, 11.3337F, 5.79842F, 11.3337F, 6.16577F);
      ((Path)localObject).lineTo(11.3337F, 13.5011F);
      ((Path)localObject).cubicTo(11.3337F, 13.8687F, 11.0372F, 14.1668F, 10.6664F, 14.1668F);
      ((Path)localObject).lineTo(1.33424F, 14.1668F);
      ((Path)localObject).cubicTo(0.965728F, 14.1668F, 0.666992F, 13.8684F, 0.666992F, 13.5011F);
      ((Path)localObject).lineTo(0.666992F, 6.16577F);
      ((Path)localObject).cubicTo(0.666992F, 5.79813F, 0.963411F, 5.5001F, 1.33424F, 5.5001F);
      ((Path)localObject).lineTo(3.33365F, 5.5001F);
      ((Path)localObject).lineTo(3.33365F, 3.50016F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.86698F, 3.50016F);
      ((Path)localObject).lineTo(7.86698F, 5.5001F);
      ((Path)localObject).lineTo(4.13365F, 5.5001F);
      ((Path)localObject).lineTo(4.13365F, 3.50016F);
      ((Path)localObject).cubicTo(4.13365F, 2.46923F, 4.96938F, 1.63349F, 6.00031F, 1.63349F);
      ((Path)localObject).cubicTo(7.03124F, 1.63349F, 7.86698F, 2.46923F, 7.86698F, 3.50016F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(1.46695F, 13.3667F);
      ((Path)localObject).lineTo(1.46695F, 6.30006F);
      ((Path)localObject).lineTo(10.5336F, 6.30006F);
      ((Path)localObject).lineTo(10.5336F, 13.3667F);
      ((Path)localObject).lineTo(1.46695F, 13.3667F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.00032F, 9.16677F);
      ((Path)localObject).cubicTo(5.00032F, 9.57684F, 5.24714F, 9.92925F, 5.60032F, 10.0836F);
      ((Path)localObject).lineTo(5.60032F, 11.5001F);
      ((Path)localObject).lineTo(6.40032F, 11.5001F);
      ((Path)localObject).lineTo(6.40032F, 10.0836F);
      ((Path)localObject).cubicTo(6.7535F, 9.92926F, 7.00032F, 9.57684F, 7.00032F, 9.16677F);
      ((Path)localObject).cubicTo(7.00032F, 8.61449F, 6.55261F, 8.16677F, 6.00032F, 8.16677F);
      ((Path)localObject).cubicTo(5.44804F, 8.16677F, 5.00032F, 8.61449F, 5.00032F, 9.16677F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.private_lock
 * JD-Core Version:    0.7.0.1
 */