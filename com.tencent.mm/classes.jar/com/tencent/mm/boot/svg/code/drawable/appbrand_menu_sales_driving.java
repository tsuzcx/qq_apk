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

public class appbrand_menu_sales_driving
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
      localPaint.setColor(-40634);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.0F, 2.133333F);
      ((Path)localObject).cubicTo(18.503691F, 2.133333F, 20.533333F, 3.98389F, 20.533333F, 6.266667F);
      ((Path)localObject).lineTo(20.532515F, 8.799334F);
      ((Path)localObject).lineTo(23.552595F, 8.8F);
      ((Path)localObject).cubicTo(24.254547F, 8.8F, 24.836283F, 9.344244F, 24.882977F, 10.044641F);
      ((Path)localObject).lineTo(26.038532F, 27.377975F);
      ((Path)localObject).cubicTo(26.087515F, 28.112724F, 25.531591F, 28.748064F, 24.796843F, 28.797047F);
      ((Path)localObject).lineTo(24.708151F, 28.799999F);
      ((Path)localObject).lineTo(7.291849F, 28.799999F);
      ((Path)localObject).cubicTo(6.555469F, 28.799999F, 5.958515F, 28.203047F, 5.958515F, 27.466667F);
      ((Path)localObject).lineTo(7.117024F, 10.044641F);
      ((Path)localObject).cubicTo(7.163717F, 9.344244F, 7.745452F, 8.8F, 8.447404F, 8.8F);
      ((Path)localObject).lineTo(11.466516F, 8.799334F);
      ((Path)localObject).lineTo(11.466667F, 6.266667F);
      ((Path)localObject).cubicTo(11.466667F, 3.98389F, 13.496309F, 2.133333F, 16.0F, 2.133333F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.0F, 4.0F);
      ((Path)localObject).cubicTo(14.5626F, 4.0F, 13.44436F, 4.957164F, 13.34112F, 6.09477F);
      ((Path)localObject).lineTo(13.333333F, 6.266667F);
      ((Path)localObject).lineTo(13.331515F, 8.799334F);
      ((Path)localObject).lineTo(18.665516F, 8.799334F);
      ((Path)localObject).lineTo(18.666666F, 6.266667F);
      ((Path)localObject).cubicTo(18.666666F, 5.112959F, 17.616873F, 4.100856F, 16.213129F, 4.007082F);
      ((Path)localObject).lineTo(16.0F, 4.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_sales_driving
 * JD-Core Version:    0.7.0.1
 */