package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class collect_bill_filter_icon
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 20.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 7.0F);
      ((Path)localObject2).cubicTo(0.0F, 5.343145F, 1.343146F, 4.0F, 3.0F, 4.0F);
      ((Path)localObject2).lineTo(53.0F, 4.0F);
      ((Path)localObject2).cubicTo(54.656853F, 4.0F, 56.0F, 5.343145F, 56.0F, 7.0F);
      ((Path)localObject2).lineTo(56.0F, 53.0F);
      ((Path)localObject2).cubicTo(56.0F, 54.656853F, 54.656853F, 56.0F, 53.0F, 56.0F);
      ((Path)localObject2).lineTo(3.0F, 56.0F);
      ((Path)localObject2).cubicTo(1.343146F, 56.0F, 0.0F, 54.656853F, 0.0F, 53.0F);
      ((Path)localObject2).lineTo(0.0F, 7.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.0F, 0.45F);
      ((Path)localObject2).cubicTo(11.0F, 0.2014719F, 11.201471F, 0.0F, 11.45F, 0.0F);
      ((Path)localObject2).lineTo(12.55F, 0.0F);
      ((Path)localObject2).cubicTo(12.798529F, 0.0F, 13.0F, 0.2014719F, 13.0F, 0.45F);
      ((Path)localObject2).lineTo(13.0F, 10.55F);
      ((Path)localObject2).cubicTo(13.0F, 10.798529F, 12.798529F, 11.0F, 12.55F, 11.0F);
      ((Path)localObject2).lineTo(11.45F, 11.0F);
      ((Path)localObject2).cubicTo(11.201471F, 11.0F, 11.0F, 10.798529F, 11.0F, 10.55F);
      ((Path)localObject2).lineTo(11.0F, 0.45F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.0F, 20.0F);
      ((Path)localObject2).lineTo(54.0F, 20.0F);
      ((Path)localObject2).lineTo(54.0F, 22.0F);
      ((Path)localObject2).lineTo(2.0F, 22.0F);
      ((Path)localObject2).lineTo(2.0F, 20.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 30.450001F);
      ((Path)localObject2).cubicTo(9.0F, 30.201473F, 9.201471F, 30.0F, 9.45F, 30.0F);
      ((Path)localObject2).lineTo(17.549999F, 30.0F);
      ((Path)localObject2).cubicTo(17.798527F, 30.0F, 18.0F, 30.201473F, 18.0F, 30.450001F);
      ((Path)localObject2).lineTo(18.0F, 31.549999F);
      ((Path)localObject2).cubicTo(18.0F, 31.798527F, 17.798527F, 32.0F, 17.549999F, 32.0F);
      ((Path)localObject2).lineTo(9.45F, 32.0F);
      ((Path)localObject2).cubicTo(9.201471F, 32.0F, 9.0F, 31.798527F, 9.0F, 31.549999F);
      ((Path)localObject2).lineTo(9.0F, 30.450001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 30.450001F);
      ((Path)localObject2).cubicTo(24.0F, 30.201473F, 24.201473F, 30.0F, 24.450001F, 30.0F);
      ((Path)localObject2).lineTo(32.549999F, 30.0F);
      ((Path)localObject2).cubicTo(32.798527F, 30.0F, 33.0F, 30.201473F, 33.0F, 30.450001F);
      ((Path)localObject2).lineTo(33.0F, 31.549999F);
      ((Path)localObject2).cubicTo(33.0F, 31.798527F, 32.798527F, 32.0F, 32.549999F, 32.0F);
      ((Path)localObject2).lineTo(24.450001F, 32.0F);
      ((Path)localObject2).cubicTo(24.201473F, 32.0F, 24.0F, 31.798527F, 24.0F, 31.549999F);
      ((Path)localObject2).lineTo(24.0F, 30.450001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(38.0F, 30.450001F);
      ((Path)localObject2).cubicTo(38.0F, 30.201473F, 38.201473F, 30.0F, 38.450001F, 30.0F);
      ((Path)localObject2).lineTo(46.549999F, 30.0F);
      ((Path)localObject2).cubicTo(46.798527F, 30.0F, 47.0F, 30.201473F, 47.0F, 30.450001F);
      ((Path)localObject2).lineTo(47.0F, 31.549999F);
      ((Path)localObject2).cubicTo(47.0F, 31.798527F, 46.798527F, 32.0F, 46.549999F, 32.0F);
      ((Path)localObject2).lineTo(38.450001F, 32.0F);
      ((Path)localObject2).cubicTo(38.201473F, 32.0F, 38.0F, 31.798527F, 38.0F, 31.549999F);
      ((Path)localObject2).lineTo(38.0F, 30.450001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(38.0F, 41.450001F);
      ((Path)localObject2).cubicTo(38.0F, 41.201473F, 38.201473F, 41.0F, 38.450001F, 41.0F);
      ((Path)localObject2).lineTo(46.549999F, 41.0F);
      ((Path)localObject2).cubicTo(46.798527F, 41.0F, 47.0F, 41.201473F, 47.0F, 41.450001F);
      ((Path)localObject2).lineTo(47.0F, 42.549999F);
      ((Path)localObject2).cubicTo(47.0F, 42.798527F, 46.798527F, 43.0F, 46.549999F, 43.0F);
      ((Path)localObject2).lineTo(38.450001F, 43.0F);
      ((Path)localObject2).cubicTo(38.201473F, 43.0F, 38.0F, 42.798527F, 38.0F, 42.549999F);
      ((Path)localObject2).lineTo(38.0F, 41.450001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 41.450001F);
      ((Path)localObject2).cubicTo(24.0F, 41.201473F, 24.201473F, 41.0F, 24.450001F, 41.0F);
      ((Path)localObject2).lineTo(32.549999F, 41.0F);
      ((Path)localObject2).cubicTo(32.798527F, 41.0F, 33.0F, 41.201473F, 33.0F, 41.450001F);
      ((Path)localObject2).lineTo(33.0F, 42.549999F);
      ((Path)localObject2).cubicTo(33.0F, 42.798527F, 32.798527F, 43.0F, 32.549999F, 43.0F);
      ((Path)localObject2).lineTo(24.450001F, 43.0F);
      ((Path)localObject2).cubicTo(24.201473F, 43.0F, 24.0F, 42.798527F, 24.0F, 42.549999F);
      ((Path)localObject2).lineTo(24.0F, 41.450001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 41.450001F);
      ((Path)localObject2).cubicTo(9.0F, 41.201473F, 9.201471F, 41.0F, 9.45F, 41.0F);
      ((Path)localObject2).lineTo(17.549999F, 41.0F);
      ((Path)localObject2).cubicTo(17.798527F, 41.0F, 18.0F, 41.201473F, 18.0F, 41.450001F);
      ((Path)localObject2).lineTo(18.0F, 42.549999F);
      ((Path)localObject2).cubicTo(18.0F, 42.798527F, 17.798527F, 43.0F, 17.549999F, 43.0F);
      ((Path)localObject2).lineTo(9.45F, 43.0F);
      ((Path)localObject2).cubicTo(9.201471F, 43.0F, 9.0F, 42.798527F, 9.0F, 42.549999F);
      ((Path)localObject2).lineTo(9.0F, 41.450001F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(43.0F, 0.45F);
      ((Path)localObject1).cubicTo(43.0F, 0.2014719F, 43.201473F, 0.0F, 43.450001F, 0.0F);
      ((Path)localObject1).lineTo(44.549999F, 0.0F);
      ((Path)localObject1).cubicTo(44.798527F, 0.0F, 45.0F, 0.2014719F, 45.0F, 0.45F);
      ((Path)localObject1).lineTo(45.0F, 10.55F);
      ((Path)localObject1).cubicTo(45.0F, 10.798529F, 44.798527F, 11.0F, 44.549999F, 11.0F);
      ((Path)localObject1).lineTo(43.450001F, 11.0F);
      ((Path)localObject1).cubicTo(43.201473F, 11.0F, 43.0F, 10.798529F, 43.0F, 10.55F);
      ((Path)localObject1).lineTo(43.0F, 0.45F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.collect_bill_filter_icon
 * JD-Core Version:    0.7.0.1
 */