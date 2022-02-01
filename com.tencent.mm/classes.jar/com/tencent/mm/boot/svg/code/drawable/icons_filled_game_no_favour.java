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

public class icons_filled_game_no_favour
  extends c
{
  private final int height = 17;
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
      return 17;
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
      localPaint.setColor(-2130706433);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(2.43618F, 2.02016F);
      ((Path)localObject).cubicTo(2.39192F, 1.93924F, 2.27571F, 1.93924F, 2.23146F, 2.02016F);
      ((Path)localObject).lineTo(1.52526F, 3.3114F);
      ((Path)localObject).cubicTo(1.51455F, 3.33097F, 1.49845F, 3.34707F, 1.47888F, 3.35778F);
      ((Path)localObject).lineTo(0.187638F, 4.06398F);
      ((Path)localObject).cubicTo(0.106725F, 4.10823F, 0.106725F, 4.22444F, 0.187638F, 4.26869F);
      ((Path)localObject).lineTo(1.47888F, 4.9749F);
      ((Path)localObject).cubicTo(1.49845F, 4.9856F, 1.51455F, 5.0017F, 1.52526F, 5.02127F);
      ((Path)localObject).lineTo(2.23146F, 6.31252F);
      ((Path)localObject).cubicTo(2.27571F, 6.39343F, 2.39192F, 6.39343F, 2.43618F, 6.31252F);
      ((Path)localObject).lineTo(3.14238F, 5.02127F);
      ((Path)localObject).cubicTo(3.15308F, 5.0017F, 3.16918F, 4.9856F, 3.18876F, 4.9749F);
      ((Path)localObject).lineTo(4.48F, 4.26869F);
      ((Path)localObject).cubicTo(4.56091F, 4.22444F, 4.56091F, 4.10823F, 4.48F, 4.06398F);
      ((Path)localObject).lineTo(3.18876F, 3.35778F);
      ((Path)localObject).cubicTo(3.16918F, 3.34707F, 3.15308F, 3.33097F, 3.14238F, 3.3114F);
      ((Path)localObject).lineTo(2.43618F, 2.02016F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.65071F, 2.4668F);
      ((Path)localObject).cubicTo(9.56391F, 2.24262F, 9.24671F, 2.24262F, 9.1599F, 2.4668F);
      ((Path)localObject).lineTo(7.57924F, 6.54916F);
      ((Path)localObject).cubicTo(7.55681F, 6.60709F, 7.51461F, 6.65521F, 7.4601F, 6.68502F);
      ((Path)localObject).lineTo(4.5643F, 8.26879F);
      ((Path)localObject).cubicTo(4.38179F, 8.36861F, 4.38179F, 8.63073F, 4.5643F, 8.73055F);
      ((Path)localObject).lineTo(7.4601F, 10.3143F);
      ((Path)localObject).cubicTo(7.51461F, 10.3441F, 7.55681F, 10.3923F, 7.57924F, 10.4502F);
      ((Path)localObject).lineTo(9.1599F, 14.5325F);
      ((Path)localObject).cubicTo(9.24671F, 14.7567F, 9.56391F, 14.7567F, 9.65071F, 14.5325F);
      ((Path)localObject).lineTo(11.2314F, 10.4502F);
      ((Path)localObject).cubicTo(11.2538F, 10.3923F, 11.296F, 10.3441F, 11.3505F, 10.3143F);
      ((Path)localObject).lineTo(14.2463F, 8.73055F);
      ((Path)localObject).cubicTo(14.4288F, 8.63073F, 14.4288F, 8.36861F, 14.2463F, 8.26879F);
      ((Path)localObject).lineTo(11.3505F, 6.68502F);
      ((Path)localObject).cubicTo(11.296F, 6.65521F, 11.2538F, 6.60709F, 11.2314F, 6.54916F);
      ((Path)localObject).lineTo(9.65071F, 2.4668F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_game_no_favour
 * JD-Core Version:    0.7.0.1
 */