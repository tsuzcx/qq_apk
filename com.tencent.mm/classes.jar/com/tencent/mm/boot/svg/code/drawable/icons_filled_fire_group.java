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

public class icons_filled_fire_group
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(11.400269F, 2.517334F);
      localPath.cubicTo(13.169039F, 2.517334F, 14.561768F, 4.004761F, 15.030518F, 5.490356F);
      localPath.cubicTo(15.552286F, 7.143982F, 14.414429F, 8.989746F, 15.246948F, 9.6875F);
      localPath.cubicTo(16.079468F, 10.385254F, 17.137695F, 9.151978F, 17.675499F, 8.222563F);
      localPath.cubicTo(18.322906F, 9.388592F, 18.786436F, 10.688976F, 19.006195F, 12.058325F);
      localPath.cubicTo(18.557396F, 11.419344F, 17.83005F, 11.0F, 17.0F, 11.0F);
      localPath.cubicTo(15.622662F, 11.0F, 14.526316F, 12.156236F, 14.526316F, 13.555392F);
      localPath.lineTo(14.526316F, 14.22028F);
      localPath.lineTo(14.535017F, 14.425994F);
      localPath.cubicTo(14.575209F, 14.916504F, 14.751698F, 15.472079F, 15.003282F, 15.913879F);
      localPath.lineTo(15.026F, 15.95F);
      localPath.lineTo(13.452537F, 16.762081F);
      localPath.cubicTo(12.888078F, 17.052834F, 12.5F, 17.709015F, 12.5F, 18.344902F);
      localPath.lineTo(12.5F, 18.611111F);
      localPath.cubicTo(12.5F, 19.378174F, 13.121827F, 20.0F, 13.888889F, 20.0F);
      localPath.lineTo(15.648956F, 20.000032F);
      localPath.cubicTo(14.580757F, 20.635218F, 13.332978F, 21.0F, 12.0F, 21.0F);
      localPath.cubicTo(8.051327F, 21.0F, 4.850294F, 17.798967F, 4.850294F, 13.850294F);
      localPath.cubicTo(4.850294F, 10.704843F, 6.784547F, 8.523933F, 7.732305F, 7.688896F);
      localPath.cubicTo(7.536916F, 8.592954F, 7.534505F, 10.416115F, 7.894422F, 10.677346F);
      localPath.cubicTo(7.898918F, 10.680611F, 7.910906F, 10.667218F, 7.912342F, 10.657651F);
      localPath.cubicTo(8.579097F, 6.213791F, 12.569551F, 5.145668F, 11.400269F, 2.517334F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(17.0F, 12.0F);
      ((Path)localObject).cubicTo(17.813892F, 12.0F, 18.473684F, 12.69727F, 18.473684F, 13.555636F);
      ((Path)localObject).lineTo(18.473684F, 14.220628F);
      ((Path)localObject).cubicTo(18.473684F, 14.663615F, 18.252975F, 15.29889F, 17.982979F, 15.636723F);
      ((Path)localObject).lineTo(17.849783F, 15.803385F);
      ((Path)localObject).cubicTo(17.632591F, 16.075148F, 17.700438F, 16.421043F, 18.00415F, 16.577421F);
      ((Path)localObject).lineTo(20.089542F, 17.651161F);
      ((Path)localObject).cubicTo(20.316233F, 17.767879F, 20.5F, 18.076454F, 20.5F, 18.344902F);
      ((Path)localObject).lineTo(20.5F, 18.611111F);
      ((Path)localObject).cubicTo(20.5F, 18.825888F, 20.325888F, 19.0F, 20.111111F, 19.0F);
      ((Path)localObject).lineTo(13.888889F, 19.0F);
      ((Path)localObject).cubicTo(13.674111F, 19.0F, 13.5F, 18.825888F, 13.5F, 18.611111F);
      ((Path)localObject).lineTo(13.5F, 18.344902F);
      ((Path)localObject).cubicTo(13.5F, 18.07848F, 13.683529F, 17.767963F, 13.910457F, 17.651073F);
      ((Path)localObject).lineTo(15.995851F, 16.576889F);
      ((Path)localObject).cubicTo(16.298296F, 16.421099F, 16.368622F, 16.076046F, 16.150217F, 15.802804F);
      ((Path)localObject).lineTo(16.017021F, 15.636165F);
      ((Path)localObject).cubicTo(15.746012F, 15.297111F, 15.526316F, 14.663693F, 15.526316F, 14.22028F);
      ((Path)localObject).lineTo(15.526316F, 13.555392F);
      ((Path)localObject).cubicTo(15.526316F, 12.696373F, 16.187763F, 12.0F, 17.0F, 12.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_fire_group
 * JD-Core Version:    0.7.0.1
 */