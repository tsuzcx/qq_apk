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

public class icon_filled_live_top_like
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      ((Path)localObject).moveTo(12.856425F, 8.430063F);
      ((Path)localObject).cubicTo(13.81917F, 7.437835F, 13.807932F, 5.854358F, 12.828903F, 4.87533F);
      ((Path)localObject).cubicTo(11.839575F, 3.886001F, 10.235558F, 3.886001F, 9.246229F, 4.87533F);
      ((Path)localObject).cubicTo(9.118053F, 5.003506F, 8.955471F, 5.160333F, 8.757743F, 5.34663F);
      ((Path)localObject).lineTo(8.209139F, 5.863517F);
      ((Path)localObject).lineTo(7.660535F, 5.34663F);
      ((Path)localObject).cubicTo(7.462807F, 5.160333F, 7.300226F, 5.003506F, 7.172049F, 4.87533F);
      ((Path)localObject).cubicTo(6.182721F, 3.886001F, 4.578703F, 3.886001F, 3.589375F, 4.87533F);
      ((Path)localObject).cubicTo(2.610358F, 5.854346F, 2.599056F, 7.437913F, 3.553116F, 8.421745F);
      ((Path)localObject).lineTo(8.20911F, 13.077788F);
      ((Path)localObject).lineTo(12.856425F, 8.430063F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.023689F, 4.309644F);
      ((Path)localObject).cubicTo(4.325437F, 3.007896F, 6.435987F, 3.007896F, 7.737734F, 4.309644F);
      ((Path)localObject).cubicTo(7.859606F, 4.431515F, 8.016741F, 4.583088F, 8.209139F, 4.764364F);
      ((Path)localObject).cubicTo(8.401538F, 4.583088F, 8.558672F, 4.431515F, 8.680544F, 4.309644F);
      ((Path)localObject).cubicTo(9.982291F, 3.007896F, 12.092841F, 3.007896F, 13.394588F, 4.309644F);
      ((Path)localObject).cubicTo(14.684228F, 5.599283F, 14.696223F, 7.682747F, 13.430577F, 8.987154F);
      ((Path)localObject).lineTo(8.680544F, 13.737735F);
      ((Path)localObject).cubicTo(8.420208F, 13.998097F, 7.998097F, 13.998119F, 7.737734F, 13.737783F);
      ((Path)localObject).lineTo(2.987428F, 8.987428F);
      ((Path)localObject).cubicTo(1.722054F, 7.682747F, 1.734051F, 5.599283F, 3.023689F, 4.309644F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_live_top_like
 * JD-Core Version:    0.7.0.1
 */