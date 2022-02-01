package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bdl
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      arrayOfFloat = c.a(arrayOfFloat, 0.9945219F, -0.1045285F, 1.296938F, 0.1045285F, 0.9945219F, -1.205674F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(4.805897F, 6.760977F);
      ((Path)localObject).lineTo(4.805897F, 8.477652F);
      ((Path)localObject).lineTo(7.314882F, 8.477652F);
      ((Path)localObject).cubicTo(8.008155F, 10.871091F, 9.246141F, 12.967414F, 11.02884F, 14.783126F);
      ((Path)localObject).cubicTo(9.312166F, 16.235697F, 7.133311F, 17.29211F, 4.508781F, 17.968876F);
      ((Path)localObject).lineTo(5.433144F, 19.487473F);
      ((Path)localObject).cubicTo(8.1237F, 18.728174F, 10.401594F, 17.523201F, 12.250319F, 15.88906F);
      ((Path)localObject).cubicTo(14.000007F, 17.341631F, 16.195368F, 18.56311F, 18.836405F, 19.553499F);
      ((Path)localObject).lineTo(19.793781F, 18.084423F);
      ((Path)localObject).cubicTo(17.284796F, 17.160059F, 15.171967F, 16.037619F, 13.471799F, 14.684088F);
      ((Path)localObject).cubicTo(14.990396F, 13.016933F, 16.145849F, 10.953623F, 16.93816F, 8.477652F);
      ((Path)localObject).lineTo(19.430637F, 8.477652F);
      ((Path)localObject).lineTo(19.430637F, 6.760977F);
      ((Path)localObject).lineTo(13.191189F, 6.760977F);
      ((Path)localObject).cubicTo(12.695994F, 5.688056F, 12.15128F, 4.763693F, 11.557048F, 3.987889F);
      ((Path)localObject).lineTo(9.823867F, 4.615135F);
      ((Path)localObject).cubicTo(10.4181F, 5.291901F, 10.929801F, 6.001679F, 11.342463F, 6.760977F);
      ((Path)localObject).lineTo(4.805897F, 6.760977F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.96553F, 8.477652F);
      ((Path)localObject).lineTo(15.15546F, 8.477652F);
      ((Path)localObject).cubicTo(14.511707F, 10.474936F, 13.537825F, 12.191609F, 12.250319F, 13.611166F);
      ((Path)localObject).cubicTo(10.731724F, 12.125583F, 9.642296F, 10.425416F, 8.96553F, 8.477652F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bdl
 * JD-Core Version:    0.7.0.1
 */