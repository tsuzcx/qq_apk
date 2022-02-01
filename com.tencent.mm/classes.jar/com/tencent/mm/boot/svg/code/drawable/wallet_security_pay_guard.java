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

public class wallet_security_pay_guard
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Canvas)localObject1).save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-15432210);
      ((Paint)localObject2).setStrokeWidth(1.733333F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.999968F, 4.866667F);
      localPath.cubicTo(20.150236F, 4.866667F, 23.993862F, 6.177216F, 27.13068F, 8.403519F);
      localPath.cubicTo(27.133333F, 12.910462F, 26.011505F, 16.810717F, 24.051256F, 20.172611F);
      localPath.cubicTo(22.102459F, 23.51487F, 19.325581F, 26.325237F, 15.999294F, 28.327726F);
      localPath.cubicTo(12.673649F, 26.32453F, 9.897253F, 23.514467F, 7.948724F, 20.172653F);
      localPath.cubicTo(5.988481F, 16.810747F, 4.866667F, 12.910479F, 4.866667F, 8.75285F);
      localPath.cubicTo(8.006618F, 6.177054F, 11.850019F, 4.866667F, 15.999968F, 4.866667F);
      localPath.close();
      ((Canvas)localObject1).drawPath(localPath, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-15432210);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.007088F, 19.410448F);
      ((Path)localObject2).lineTo(5.032304F, 8.867483F);
      ((Path)localObject2).lineTo(5.032304F, 7.892994F);
      ((Path)localObject2).lineTo(16.007088F, 15.516818F);
      ((Path)localObject2).lineTo(26.98192F, 7.892994F);
      ((Path)localObject2).lineTo(26.98192F, 8.867483F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      ((Canvas)localObject1).drawPath((Path)localObject2, localPaint);
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(32.0F, 0.0F);
      ((Path)localObject1).lineTo(32.0F, 32.0F);
      ((Path)localObject1).lineTo(0.0F, 32.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(32.0F, 0.0F);
      ((Path)localObject1).lineTo(32.0F, 32.0F);
      ((Path)localObject1).lineTo(0.0F, 32.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wallet_security_pay_guard
 * JD-Core Version:    0.7.0.1
 */