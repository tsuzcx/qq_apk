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

public class recharge_icon_normal
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
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
      localPaint.setColor(-11487894);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(32.0F, 64.0F);
      ((Path)localObject).cubicTo(49.673111F, 64.0F, 64.0F, 49.673111F, 64.0F, 32.0F);
      ((Path)localObject).cubicTo(64.0F, 14.326888F, 49.673111F, 0.0F, 32.0F, 0.0F);
      ((Path)localObject).cubicTo(14.326888F, 0.0F, 0.0F, 14.326888F, 0.0F, 32.0F);
      ((Path)localObject).cubicTo(0.0F, 49.673111F, 14.326888F, 64.0F, 32.0F, 64.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.055362F, 31.019482F);
      ((Path)localObject).cubicTo(2.559515F, 38.257221F, 5.435425F, 45.386047F, 10.036881F, 50.881187F);
      ((Path)localObject).cubicTo(14.08299F, 46.574188F, 20.043064F, 45.029606F, 24.71394F, 41.613712F);
      ((Path)localObject).cubicTo(26.132061F, 40.73251F, 26.608074F, 38.811687F, 25.626297F, 37.415623F);
      ((Path)localObject).cubicTo(23.623077F, 34.207653F, 20.757084F, 31.088789F, 21.104177F, 27.009516F);
      ((Path)localObject).cubicTo(20.638081F, 20.05891F, 27.689018F, 13.524151F, 34.630871F, 15.623195F);
      ((Path)localObject).cubicTo(41.850395F, 17.464809F, 45.093235F, 26.979813F, 41.136379F, 33.078922F);
      ((Path)localObject).cubicTo(39.926514F, 35.425491F, 37.06052F, 37.475029F, 38.012543F, 40.415672F);
      ((Path)localObject).cubicTo(42.494999F, 45.019707F, 49.635189F, 46.009819F, 53.849884F, 51.0F);
      ((Path)localObject).cubicTo(60.008297F, 43.910778F, 62.497448F, 33.890816F, 60.097549F, 24.801559F);
      ((Path)localObject).cubicTo(57.16214F, 13.048896F, 46.144428F, 3.652706F, 33.946602F, 3.127945F);
      ((Path)localObject).cubicTo(18.218349F, 1.523959F, 3.015694F, 15.23705F, 3.055362F, 31.019482F);
      ((Path)localObject).lineTo(3.055362F, 31.019482F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.recharge_icon_normal
 * JD-Core Version:    0.7.0.1
 */