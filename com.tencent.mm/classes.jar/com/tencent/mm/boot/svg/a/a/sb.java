package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class sb
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(13.776992F, 18.44776F);
      ((Path)localObject).cubicTo(13.265816F, 17.781214F, 12.962358F, 16.949373F, 12.962358F, 16.047218F);
      ((Path)localObject).cubicTo(12.962358F, 13.855613F, 14.753219F, 12.078964F, 16.962358F, 12.078964F);
      ((Path)localObject).cubicTo(17.609716F, 12.078964F, 18.221155F, 12.231525F, 18.762138F, 12.502383F);
      ((Path)localObject).cubicTo(18.807144F, 12.174689F, 18.830395F, 11.84006F, 18.830395F, 11.5F);
      ((Path)localObject).cubicTo(18.830395F, 7.468321F, 15.562075F, 4.2F, 11.530396F, 4.2F);
      ((Path)localObject).cubicTo(7.498717F, 4.2F, 4.230395F, 7.468321F, 4.230395F, 11.5F);
      ((Path)localObject).cubicTo(4.230395F, 15.531679F, 7.498717F, 18.799999F, 11.530396F, 18.799999F);
      ((Path)localObject).cubicTo(12.314257F, 18.799999F, 13.069262F, 18.676453F, 13.777F, 18.447771F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.764329F, 19.363182F);
      ((Path)localObject).cubicTo(13.767437F, 19.773621F, 12.675353F, 20.0F, 11.530396F, 20.0F);
      ((Path)localObject).cubicTo(6.835975F, 20.0F, 3.030396F, 16.19442F, 3.030396F, 11.5F);
      ((Path)localObject).cubicTo(3.030396F, 6.80558F, 6.835975F, 3.0F, 11.530396F, 3.0F);
      ((Path)localObject).cubicTo(16.224815F, 3.0F, 20.030396F, 6.80558F, 20.030396F, 11.5F);
      ((Path)localObject).cubicTo(20.030396F, 12.114792F, 19.965126F, 12.714339F, 19.841137F, 13.292091F);
      ((Path)localObject).cubicTo(20.535353F, 14.005841F, 20.962358F, 14.977059F, 20.962358F, 16.047218F);
      ((Path)localObject).cubicTo(20.962358F, 18.238825F, 19.171497F, 20.015472F, 16.962358F, 20.015472F);
      ((Path)localObject).cubicTo(16.15048F, 20.015472F, 15.395096F, 19.775515F, 14.764337F, 19.363186F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.962358F, 18.815472F);
      ((Path)localObject).cubicTo(18.510887F, 18.815472F, 19.762358F, 17.573933F, 19.762358F, 16.047218F);
      ((Path)localObject).cubicTo(19.762358F, 14.520504F, 18.510887F, 13.278965F, 16.962358F, 13.278965F);
      ((Path)localObject).cubicTo(15.41383F, 13.278965F, 14.162358F, 14.520504F, 14.162358F, 16.047218F);
      ((Path)localObject).cubicTo(14.162358F, 17.573933F, 15.41383F, 18.815472F, 16.962358F, 18.815472F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sb
 * JD-Core Version:    0.7.0.1
 */