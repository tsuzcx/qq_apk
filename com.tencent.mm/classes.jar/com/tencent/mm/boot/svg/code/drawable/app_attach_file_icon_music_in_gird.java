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

public class app_attach_file_icon_music_in_gird
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(32.108791F, 26.734407F);
      ((Path)localObject).lineTo(32.108791F, 56.345825F);
      ((Path)localObject).lineTo(32.108791F, 59.810051F);
      ((Path)localObject).cubicTo(32.108791F, 63.036148F, 30.576809F, 66.21981F, 27.572372F, 67.575066F);
      ((Path)localObject).cubicTo(27.013861F, 67.827003F, 23.48564F, 68.589729F, 23.024942F, 68.679375F);
      ((Path)localObject).cubicTo(18.598322F, 69.540695F, 15.197145F, 67.022964F, 15.009837F, 63.314568F);
      ((Path)localObject).cubicTo(14.82253F, 59.606167F, 17.336971F, 57.663437F, 20.254364F, 57.095776F);
      ((Path)localObject).lineTo(26.388245F, 55.791359F);
      ((Path)localObject).cubicTo(27.481236F, 55.558926F, 28.347324F, 54.479134F, 28.347324F, 53.37434F);
      ((Path)localObject).lineTo(28.347324F, 25.242409F);
      ((Path)localObject).cubicTo(28.341309F, 25.103559F, 28.354797F, 24.967648F, 28.385284F, 24.836742F);
      ((Path)localObject).lineTo(28.385284F, 21.949265F);
      ((Path)localObject).cubicTo(28.385284F, 21.397732F, 28.814762F, 20.838921F, 29.348425F, 20.700115F);
      ((Path)localObject).lineTo(63.430626F, 11.835335F);
      ((Path)localObject).cubicTo(63.962555F, 11.69698F, 64.393768F, 12.039573F, 64.393768F, 12.589663F);
      ((Path)localObject).lineTo(64.393768F, 17.198563F);
      ((Path)localObject).cubicTo(64.403229F, 17.2652F, 64.408127F, 17.333122F, 64.408127F, 17.402126F);
      ((Path)localObject).lineTo(64.408127F, 48.572945F);
      ((Path)localObject).lineTo(64.408127F, 52.037174F);
      ((Path)localObject).cubicTo(64.408127F, 55.263268F, 62.876144F, 58.44693F, 59.871708F, 59.802193F);
      ((Path)localObject).cubicTo(59.313194F, 60.054127F, 55.784973F, 60.816853F, 55.32428F, 60.906494F);
      ((Path)localObject).cubicTo(50.897659F, 61.767815F, 47.496479F, 59.250088F, 47.309174F, 55.541687F);
      ((Path)localObject).cubicTo(47.121864F, 51.83329F, 49.636307F, 49.890556F, 52.553699F, 49.322899F);
      ((Path)localObject).lineTo(58.68758F, 48.018478F);
      ((Path)localObject).cubicTo(59.780571F, 47.786045F, 60.64666F, 46.706253F, 60.64666F, 45.601463F);
      ((Path)localObject).lineTo(60.64666F, 19.191336F);
      ((Path)localObject).lineTo(32.108791F, 26.734407F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_music_in_gird
 * JD-Core Version:    0.7.0.1
 */