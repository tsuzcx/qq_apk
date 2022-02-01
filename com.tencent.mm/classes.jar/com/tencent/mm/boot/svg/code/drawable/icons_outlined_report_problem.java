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

public class icons_outlined_report_problem
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(35.995144F, 13.200261F);
      ((Path)localObject).lineTo(9.23486F, 59.562687F);
      ((Path)localObject).lineTo(62.764397F, 59.558201F);
      ((Path)localObject).lineTo(35.995144F, 13.200261F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.195969F, 63.162773F);
      ((Path)localObject).cubicTo(6.539114F, 63.16291F, 5.195856F, 61.819878F, 5.195717F, 60.163025F);
      ((Path)localObject).cubicTo(5.195673F, 59.636444F, 5.334232F, 59.119129F, 5.597469F, 58.663071F);
      ((Path)localObject).lineTo(33.396782F, 10.500515F);
      ((Path)localObject).cubicTo(34.225044F, 9.065542F, 36.059761F, 8.573707F, 37.494732F, 9.40197F);
      ((Path)localObject).cubicTo(37.950855F, 9.665244F, 38.329639F, 10.043954F, 38.592999F, 10.50003F);
      ((Path)localObject).lineTo(66.401634F, 58.657925F);
      ((Path)localObject).cubicTo(67.230164F, 60.092743F, 66.73867F, 61.927547F, 65.303856F, 62.756081F);
      ((Path)localObject).cubicTo(64.847824F, 63.019413F, 64.330513F, 63.15807F, 63.803913F, 63.158112F);
      ((Path)localObject).lineTo(8.195969F, 63.162773F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.117676F, 29.862305F);
      ((Path)localObject).lineTo(37.882324F, 29.862305F);
      ((Path)localObject).lineTo(37.589355F, 44.027344F);
      ((Path)localObject).lineTo(34.410645F, 44.027344F);
      ((Path)localObject).lineTo(34.117676F, 29.862305F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.992676F, 51.292969F);
      ((Path)localObject).cubicTo(34.806152F, 51.292969F, 33.868652F, 50.370117F, 33.868652F, 49.212891F);
      ((Path)localObject).cubicTo(33.868652F, 48.055664F, 34.806152F, 47.147461F, 35.992676F, 47.147461F);
      ((Path)localObject).cubicTo(37.193848F, 47.147461F, 38.131348F, 48.055664F, 38.131348F, 49.212891F);
      ((Path)localObject).cubicTo(38.131348F, 50.370117F, 37.193848F, 51.292969F, 35.992676F, 51.292969F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_report_problem
 * JD-Core Version:    0.7.0.1
 */