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

public class icons_filled_ringtone
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
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(32.0F, 0.0F);
      ((Path)localObject).lineTo(32.0F, 32.0F);
      ((Path)localObject).lineTo(0.0F, 32.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      Paint localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-15616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.0F, 3.333333F);
      ((Path)localObject).cubicTo(16.73638F, 3.333333F, 17.333334F, 3.930287F, 17.333334F, 4.666667F);
      ((Path)localObject).cubicTo(17.333334F, 5.403046F, 16.73638F, 6.0F, 16.0F, 6.0F);
      ((Path)localObject).cubicTo(10.477153F, 6.0F, 6.0F, 10.477153F, 6.0F, 16.0F);
      ((Path)localObject).cubicTo(6.0F, 21.522848F, 10.477153F, 26.0F, 16.0F, 26.0F);
      ((Path)localObject).cubicTo(21.522848F, 26.0F, 26.0F, 21.522848F, 26.0F, 16.0F);
      ((Path)localObject).cubicTo(26.0F, 15.26362F, 26.596954F, 14.666667F, 27.333334F, 14.666667F);
      ((Path)localObject).cubicTo(28.069714F, 14.666667F, 28.666666F, 15.26362F, 28.666666F, 16.0F);
      ((Path)localObject).cubicTo(28.666666F, 22.995607F, 22.995607F, 28.666666F, 16.0F, 28.666666F);
      ((Path)localObject).cubicTo(9.004394F, 28.666666F, 3.333333F, 22.995607F, 3.333333F, 16.0F);
      ((Path)localObject).cubicTo(3.333333F, 9.004394F, 9.004394F, 3.333333F, 16.0F, 3.333333F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 102, 31);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.0F, 8.0F);
      ((Path)localObject).cubicTo(16.73638F, 8.0F, 17.333334F, 8.596953F, 17.333334F, 9.333333F);
      ((Path)localObject).cubicTo(17.333334F, 10.069713F, 16.73638F, 10.666667F, 16.0F, 10.666667F);
      ((Path)localObject).cubicTo(13.054482F, 10.666667F, 10.666667F, 13.054482F, 10.666667F, 16.0F);
      ((Path)localObject).cubicTo(10.666667F, 18.945518F, 13.054482F, 21.333334F, 16.0F, 21.333334F);
      ((Path)localObject).cubicTo(18.945518F, 21.333334F, 21.333334F, 18.945518F, 21.333334F, 16.0F);
      ((Path)localObject).cubicTo(21.333334F, 15.26362F, 21.930286F, 14.666667F, 22.666666F, 14.666667F);
      ((Path)localObject).cubicTo(23.403046F, 14.666667F, 24.0F, 15.26362F, 24.0F, 16.0F);
      ((Path)localObject).cubicTo(24.0F, 20.418278F, 20.418278F, 24.0F, 16.0F, 24.0F);
      ((Path)localObject).cubicTo(11.581722F, 24.0F, 8.0F, 20.418278F, 8.0F, 16.0F);
      ((Path)localObject).cubicTo(8.0F, 11.581722F, 11.581722F, 8.0F, 16.0F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.700123F, 5.89647F);
      ((Path)localObject).lineTo(21.852573F, 5.928303F);
      ((Path)localObject).lineTo(24.750351F, 6.70476F);
      ((Path)localObject).cubicTo(25.066479F, 6.789466F, 25.268364F, 7.087714F, 25.242395F, 7.402726F);
      ((Path)localObject).lineTo(25.221756F, 7.521256F);
      ((Path)localObject).lineTo(24.704117F, 9.453108F);
      ((Path)localObject).cubicTo(24.619411F, 9.769236F, 24.321163F, 9.971121F, 24.006151F, 9.945153F);
      ((Path)localObject).lineTo(23.887621F, 9.924513F);
      ((Path)localObject).lineTo(21.311819F, 9.234328F);
      ((Path)localObject).lineTo(19.241266F, 16.961735F);
      ((Path)localObject).cubicTo(18.764608F, 18.740648F, 16.953796F, 19.79973F, 15.166833F, 19.320915F);
      ((Path)localObject).cubicTo(13.37987F, 18.8421F, 12.325103F, 17.015188F, 12.801761F, 15.236275F);
      ((Path)localObject).cubicTo(13.278419F, 13.457361F, 15.10533F, 12.402594F, 16.892294F, 12.881409F);
      ((Path)localObject).cubicTo(17.003273F, 12.911145F, 17.11141F, 12.946764F, 17.2166F, 12.987752F);
      ((Path)localObject).cubicTo(18.199955F, 13.252976F, 18.518656F, 13.09592F, 18.707426F, 12.544457F);
      ((Path)localObject).lineTo(20.219921F, 6.869844F);
      ((Path)localObject).lineTo(20.268829F, 6.721969F);
      ((Path)localObject).cubicTo(20.477003F, 6.196861F, 20.994143F, 5.864597F, 21.548281F, 5.882721F);
      ((Path)localObject).lineTo(21.700123F, 5.89647F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_ringtone
 * JD-Core Version:    0.7.0.1
 */