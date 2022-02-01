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

public class icons_filled_transfer2
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(39.045101F, 43.661018F);
      ((Path)localObject).lineTo(35.702599F, 50.790489F);
      ((Path)localObject).cubicTo(35.517517F, 51.185265F, 35.561123F, 51.649364F, 35.816505F, 52.002754F);
      ((Path)localObject).cubicTo(36.204689F, 52.539909F, 36.95483F, 52.660675F, 37.491989F, 52.272491F);
      ((Path)localObject).lineTo(51.892452F, 41.865765F);
      ((Path)localObject).cubicTo(52.282711F, 41.583736F, 52.513863F, 41.131504F, 52.513863F, 40.650002F);
      ((Path)localObject).cubicTo(52.513863F, 39.821575F, 51.842289F, 39.150002F, 51.013863F, 39.150002F);
      ((Path)localObject).lineTo(41.16F, 39.150002F);
      ((Path)localObject).lineTo(41.154835F, 39.161018F);
      ((Path)localObject).lineTo(21.0F, 39.161018F);
      ((Path)localObject).lineTo(21.0F, 43.661018F);
      ((Path)localObject).lineTo(39.045101F, 43.661018F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.628757F, 28.338949F);
      ((Path)localObject).lineTo(36.971264F, 21.209478F);
      ((Path)localObject).cubicTo(37.156345F, 20.814705F, 37.112736F, 20.350603F, 36.857357F, 19.997215F);
      ((Path)localObject).cubicTo(36.46917F, 19.460058F, 35.719032F, 19.339293F, 35.181873F, 19.727478F);
      ((Path)localObject).lineTo(20.781408F, 30.134205F);
      ((Path)localObject).cubicTo(20.391148F, 30.416233F, 20.16F, 30.868465F, 20.16F, 31.349968F);
      ((Path)localObject).cubicTo(20.16F, 32.178394F, 20.831572F, 32.849968F, 21.66F, 32.849968F);
      ((Path)localObject).lineTo(31.513861F, 32.849968F);
      ((Path)localObject).lineTo(31.519028F, 32.838947F);
      ((Path)localObject).lineTo(51.659996F, 32.838947F);
      ((Path)localObject).lineTo(51.659996F, 28.338949F);
      ((Path)localObject).lineTo(33.628757F, 28.338949F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_transfer2
 * JD-Core Version:    0.7.0.1
 */