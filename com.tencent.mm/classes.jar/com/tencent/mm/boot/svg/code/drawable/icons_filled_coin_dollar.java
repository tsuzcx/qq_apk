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

public class icons_filled_coin_dollar
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.25F, 17.25F);
      ((Path)localObject).lineTo(33.75F, 17.25F);
      ((Path)localObject).lineTo(33.750156F, 21.911428F);
      ((Path)localObject).cubicTo(28.705769F, 22.645191F, 24.75F, 25.811863F, 24.75F, 30.0F);
      ((Path)localObject).cubicTo(24.75F, 34.188137F, 28.705769F, 37.354809F, 33.750156F, 38.08857F);
      ((Path)localObject).lineTo(33.750156F, 38.08857F);
      ((Path)localObject).lineTo(33.750217F, 45.523701F);
      ((Path)localObject).cubicTo(31.063194F, 44.964249F, 29.25F, 43.455738F, 29.25F, 42.0F);
      ((Path)localObject).lineTo(29.25F, 42.0F);
      ((Path)localObject).lineTo(24.75F, 42.0F);
      ((Path)localObject).cubicTo(24.75F, 46.188137F, 28.705769F, 49.354809F, 33.750156F, 50.08857F);
      ((Path)localObject).lineTo(33.750156F, 50.08857F);
      ((Path)localObject).lineTo(33.75F, 54.75F);
      ((Path)localObject).lineTo(38.25F, 54.75F);
      ((Path)localObject).lineTo(38.250839F, 50.088425F);
      ((Path)localObject).cubicTo(43.294754F, 49.354389F, 47.25F, 46.187859F, 47.25F, 42.0F);
      ((Path)localObject).cubicTo(47.25F, 37.812141F, 43.294754F, 34.645611F, 38.250839F, 33.911575F);
      ((Path)localObject).lineTo(38.250839F, 33.911575F);
      ((Path)localObject).lineTo(38.250786F, 26.476507F);
      ((Path)localObject).cubicTo(40.937256F, 27.036127F, 42.75F, 28.544443F, 42.75F, 30.0F);
      ((Path)localObject).lineTo(42.75F, 30.0F);
      ((Path)localObject).lineTo(47.25F, 30.0F);
      ((Path)localObject).cubicTo(47.25F, 25.81214F, 43.294754F, 22.645609F, 38.250839F, 21.911573F);
      ((Path)localObject).lineTo(38.250839F, 21.911573F);
      ((Path)localObject).lineTo(38.25F, 17.25F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.250786F, 38.476509F);
      ((Path)localObject).cubicTo(40.937256F, 39.036129F, 42.75F, 40.544445F, 42.75F, 42.0F);
      ((Path)localObject).cubicTo(42.75F, 43.455555F, 40.937256F, 44.963871F, 38.250786F, 45.523491F);
      ((Path)localObject).lineTo(38.250786F, 45.523491F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.750217F, 26.476299F);
      ((Path)localObject).lineTo(33.750217F, 33.523701F);
      ((Path)localObject).cubicTo(31.063194F, 32.964249F, 29.25F, 31.455738F, 29.25F, 30.0F);
      ((Path)localObject).cubicTo(29.25F, 28.544262F, 31.063194F, 27.035751F, 33.750217F, 26.476299F);
      ((Path)localObject).lineTo(33.750217F, 26.476299F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_coin_dollar
 * JD-Core Version:    0.7.0.1
 */