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

public class icons_filled_report_problem
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
      ((Path)localObject).moveTo(63.803913F, 63.158112F);
      ((Path)localObject).lineTo(8.195969F, 63.162773F);
      ((Path)localObject).cubicTo(6.539114F, 63.16291F, 5.195856F, 61.819878F, 5.195717F, 60.163025F);
      ((Path)localObject).cubicTo(5.195673F, 59.636444F, 5.334232F, 59.119129F, 5.597469F, 58.663071F);
      ((Path)localObject).lineTo(33.396782F, 10.500515F);
      ((Path)localObject).cubicTo(34.225044F, 9.065542F, 36.059761F, 8.573707F, 37.494732F, 9.40197F);
      ((Path)localObject).cubicTo(37.950855F, 9.665244F, 38.329639F, 10.043954F, 38.592999F, 10.50003F);
      ((Path)localObject).lineTo(66.401634F, 58.657925F);
      ((Path)localObject).cubicTo(67.230164F, 60.092743F, 66.73867F, 61.927547F, 65.303856F, 62.756081F);
      ((Path)localObject).cubicTo(64.847824F, 63.019413F, 64.330513F, 63.15807F, 63.803913F, 63.158112F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.741211F, 28.634766F);
      ((Path)localObject).lineTo(34.092773F, 45.632813F);
      ((Path)localObject).lineTo(37.907227F, 45.632813F);
      ((Path)localObject).lineTo(38.258789F, 28.634766F);
      ((Path)localObject).lineTo(33.741211F, 28.634766F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.991211F, 54.351563F);
      ((Path)localObject).cubicTo(37.432617F, 54.351563F, 38.557617F, 53.244141F, 38.557617F, 51.855469F);
      ((Path)localObject).cubicTo(38.557617F, 50.466797F, 37.432617F, 49.376953F, 35.991211F, 49.376953F);
      ((Path)localObject).cubicTo(34.567383F, 49.376953F, 33.442383F, 50.466797F, 33.442383F, 51.855469F);
      ((Path)localObject).cubicTo(33.442383F, 53.244141F, 34.567383F, 54.351563F, 35.991211F, 54.351563F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_report_problem
 * JD-Core Version:    0.7.0.1
 */