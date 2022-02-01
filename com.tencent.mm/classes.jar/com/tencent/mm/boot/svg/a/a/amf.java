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

public final class amf
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(13.606602F, 17.334524F);
      ((Path)localObject).cubicTo(19.464466F, 11.47666F, 28.961941F, 11.47666F, 34.819805F, 17.334524F);
      ((Path)localObject).cubicTo(35.368225F, 17.882944F, 36.075333F, 18.565023F, 36.941124F, 19.380762F);
      ((Path)localObject).cubicTo(37.806919F, 18.565023F, 38.514027F, 17.882944F, 39.062447F, 17.334524F);
      ((Path)localObject).cubicTo(44.920311F, 11.47666F, 54.417786F, 11.47666F, 60.27565F, 17.334524F);
      ((Path)localObject).cubicTo(66.079025F, 23.137897F, 66.133003F, 32.513489F, 60.437599F, 38.38332F);
      ((Path)localObject).lineTo(39.062447F, 59.760929F);
      ((Path)localObject).cubicTo(37.890934F, 60.932564F, 35.99144F, 60.932663F, 34.819805F, 59.761154F);
      ((Path)localObject).cubicTo(34.819767F, 59.761116F, 34.819733F, 59.761078F, 34.819695F, 59.761044F);
      ((Path)localObject).lineTo(13.443423F, 38.384548F);
      ((Path)localObject).cubicTo(7.749244F, 32.513489F, 7.803227F, 23.137897F, 13.606602F, 17.334524F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.amf
 * JD-Core Version:    0.7.0.1
 */