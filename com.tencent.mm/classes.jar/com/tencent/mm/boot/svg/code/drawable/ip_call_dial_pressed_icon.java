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

public class ip_call_dial_pressed_icon
  extends c
{
  private final int height = 156;
  private final int width = 156;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 156;
      return 156;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-16139513);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setColor(-16139513);
      localPaint2.setStrokeWidth(3.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(108.80415F, 97.686272F);
      localPath.cubicTo(107.96773F, 97.088669F, 99.069519F, 91.146591F, 97.824875F, 91.09063F);
      localPath.cubicTo(94.858475F, 91.066643F, 88.833847F, 95.100983F, 86.845596F, 95.487724F);
      localPath.cubicTo(83.995979F, 95.469734F, 77.45433F, 92.316818F, 70.376686F, 85.594254F);
      localPath.cubicTo(63.662365F, 78.507927F, 60.513309F, 71.958252F, 60.495342F, 69.105133F);
      localPath.cubicTo(60.881615F, 67.114441F, 64.911003F, 61.083424F, 64.887054F, 58.112385F);
      localPath.cubicTo(64.831154F, 56.867207F, 58.957245F, 47.924107F, 58.299488F, 47.119637F);
      localPath.cubicTo(57.319336F, 45.788513F, 56.338188F, 44.814156F, 55.664463F, 45.030014F);
      localPath.cubicTo(54.357929F, 45.241875F, 43.738976F, 49.063354F, 45.124359F, 59.211658F);
      localPath.cubicTo(46.801193F, 69.131111F, 57.308357F, 83.118889F, 64.887054F, 91.09063F);
      localPath.cubicTo(72.849022F, 98.679619F, 86.820648F, 109.19868F, 96.726944F, 110.87757F);
      localPath.cubicTo(106.86381F, 112.26466F, 110.7894F, 101.4348F, 111.0F, 100.12666F);
      localPath.cubicTo(111.001F, 99.377159F, 109.64056F, 98.283882F, 108.80415F, 97.686272F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ip_call_dial_pressed_icon
 * JD-Core Version:    0.7.0.1
 */