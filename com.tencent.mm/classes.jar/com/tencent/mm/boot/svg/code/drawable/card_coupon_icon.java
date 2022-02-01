package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class card_coupon_icon
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
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-353221);
      ((Paint)localObject).setStrokeWidth(3.6F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.3F, 28.78878F);
      localPath.cubicTo(9.583951F, 29.583998F, 12.027272F, 32.505836F, 12.027272F, 36.0F);
      localPath.cubicTo(12.027272F, 39.494164F, 9.583951F, 42.416004F, 6.3F, 43.21122F);
      localPath.lineTo(6.3F, 55.5F);
      localPath.cubicTo(6.3F, 56.162743F, 6.837258F, 56.700001F, 7.5F, 56.700001F);
      localPath.lineTo(64.5F, 56.700001F);
      localPath.cubicTo(65.162743F, 56.700001F, 65.699997F, 56.162743F, 65.699997F, 55.5F);
      localPath.lineTo(65.699997F, 43.21122F);
      localPath.cubicTo(62.41605F, 42.416004F, 59.972729F, 39.494164F, 59.972729F, 36.0F);
      localPath.cubicTo(59.972729F, 32.50552F, 62.416489F, 29.583469F, 65.70089F, 28.788565F);
      localPath.lineTo(65.699997F, 16.5F);
      localPath.cubicTo(65.699997F, 15.837258F, 65.162743F, 15.3F, 64.5F, 15.3F);
      localPath.lineTo(7.5F, 15.3F);
      localPath.cubicTo(6.837258F, 15.3F, 6.3F, 15.837258F, 6.3F, 16.5F);
      localPath.lineTo(6.3F, 28.78878F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-352965);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.818182F, 28.958097F);
      localPath.cubicTo(21.818182F, 28.290884F, 22.359066F, 27.75F, 23.026279F, 27.75F);
      localPath.lineTo(46.382816F, 27.75F);
      localPath.cubicTo(47.05003F, 27.75F, 47.590912F, 28.290884F, 47.590912F, 28.958097F);
      localPath.lineTo(47.590912F, 30.141903F);
      localPath.cubicTo(47.590912F, 30.809116F, 47.05003F, 31.35F, 46.382816F, 31.35F);
      localPath.lineTo(23.026279F, 31.35F);
      localPath.cubicTo(22.359066F, 31.35F, 21.818182F, 30.809116F, 21.818182F, 30.141903F);
      localPath.lineTo(21.818182F, 28.958097F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-352965);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.818182F, 40.208096F);
      ((Path)localObject).cubicTo(21.818182F, 39.540882F, 22.359066F, 39.0F, 23.026279F, 39.0F);
      ((Path)localObject).lineTo(37.791904F, 39.0F);
      ((Path)localObject).cubicTo(38.459118F, 39.0F, 39.0F, 39.540882F, 39.0F, 40.208096F);
      ((Path)localObject).lineTo(39.0F, 41.391903F);
      ((Path)localObject).cubicTo(39.0F, 42.059116F, 38.459118F, 42.599998F, 37.791904F, 42.599998F);
      ((Path)localObject).lineTo(23.026279F, 42.599998F);
      ((Path)localObject).cubicTo(22.359066F, 42.599998F, 21.818182F, 42.059116F, 21.818182F, 41.391903F);
      ((Path)localObject).lineTo(21.818182F, 40.208096F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.card_coupon_icon
 * JD-Core Version:    0.7.0.1
 */