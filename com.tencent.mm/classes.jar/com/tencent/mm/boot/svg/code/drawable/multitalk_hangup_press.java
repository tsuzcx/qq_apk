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

public class multitalk_hangup_press
  extends c
{
  private final int height = 210;
  private final int width = 210;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 210;
      return 210;
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-6802637);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(105.0F, 0.0F);
      localPath.cubicTo(162.9899F, 0.0F, 210.0F, 47.010098F, 210.0F, 105.0F);
      localPath.cubicTo(210.0F, 162.9899F, 162.9899F, 210.0F, 105.0F, 210.0F);
      localPath.cubicTo(47.010098F, 210.0F, 0.0F, 162.9899F, 0.0F, 105.0F);
      localPath.cubicTo(0.0F, 47.010098F, 47.010098F, 0.0F, 105.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-419430401);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(76.287399F, 119.85174F);
      ((Path)localObject).lineTo(59.71011F, 127.19318F);
      ((Path)localObject).cubicTo(57.742802F, 127.97435F, 55.578846F, 127.56027F, 53.990688F, 126.10627F);
      ((Path)localObject).cubicTo(53.344463F, 125.53506F, 52.983376F, 124.49588F, 52.890335F, 124.28806F);
      ((Path)localObject).cubicTo(50.033813F, 117.32584F, 51.68169F, 108.8528F, 57.711308F, 103.13091F);
      ((Path)localObject).cubicTo(59.410564F, 101.51837F, 61.345181F, 100.37341F, 61.827454F, 100.11317F);
      ((Path)localObject).cubicTo(75.704185F, 91.682411F, 91.155785F, 87.512207F, 106.45833F, 87.500053F);
      ((Path)localObject).cubicTo(121.76087F, 87.487946F, 136.91435F, 91.633896F, 149.89516F, 100.04336F);
      ((Path)localObject).cubicTo(150.29495F, 100.35489F, 152.16272F, 101.44485F, 153.69052F, 103.05483F);
      ((Path)localObject).cubicTo(159.11179F, 108.76765F, 159.85818F, 117.23878F, 156.26057F, 124.20612F);
      ((Path)localObject).cubicTo(156.14542F, 124.41411F, 155.62444F, 125.40202F, 154.96666F, 126.02623F);
      ((Path)localObject).cubicTo(153.27293F, 127.53481F, 151.06473F, 127.95235F, 149.18037F, 127.17424F);
      ((Path)localObject).lineTo(133.38289F, 119.85846F);
      ((Path)localObject).cubicTo(132.62151F, 119.49525F, 132.43544F, 119.07961F, 132.2222F, 118.19622F);
      ((Path)localObject).cubicTo(131.59354F, 115.33816F, 129.88763F, 108.27108F, 128.75557F, 104.11407F);
      ((Path)localObject).cubicTo(128.49858F, 103.0748F, 127.97858F, 102.08771F, 127.23932F, 101.30869F);
      ((Path)localObject).cubicTo(126.45077F, 100.47773F, 125.38815F, 99.90686F, 124.30894F, 99.64785F);
      ((Path)localObject).cubicTo(118.35416F, 98.093353F, 112.60017F, 97.110725F, 106.45833F, 97.115593F);
      ((Path)localObject).cubicTo(100.26721F, 97.068527F, 93.633423F, 98.060974F, 87.512726F, 99.625038F);
      ((Path)localObject).cubicTo(86.405861F, 99.885788F, 85.337219F, 100.40637F, 84.405373F, 101.29066F);
      ((Path)localObject).cubicTo(83.528336F, 102.12294F, 82.958061F, 103.05892F, 82.590462F, 104.09869F);
      ((Path)localObject).cubicTo(81.07077F, 108.20583F, 78.612717F, 115.27621F, 77.625069F, 118.18752F);
      ((Path)localObject).cubicTo(77.317818F, 119.07132F, 77.142311F, 119.43527F, 76.287399F, 119.85174F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.multitalk_hangup_press
 * JD-Core Version:    0.7.0.1
 */