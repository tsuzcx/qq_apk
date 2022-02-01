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

public class icon_ad_uninterest
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(3.01421F, 2.64999F);
      ((Path)localObject).lineTo(2.30711F, 3.3571F);
      ((Path)localObject).lineTo(3.94733F, 4.99733F);
      ((Path)localObject).lineTo(4.66314F, 5.71313F);
      ((Path)localObject).lineTo(12.6413F, 13.6913F);
      ((Path)localObject).lineTo(13.3483F, 14.3983F);
      ((Path)localObject).lineTo(16.247F, 17.297001F);
      ((Path)localObject).lineTo(16.9541F, 16.589899F);
      ((Path)localObject).lineTo(14.0554F, 13.6912F);
      ((Path)localObject).lineTo(16.528999F, 11.2173F);
      ((Path)localObject).cubicTo(18.111099F, 9.58676F, 18.0961F, 6.98243F, 16.4841F, 5.37038F);
      ((Path)localObject).cubicTo(14.8569F, 3.7432F, 12.2187F, 3.7432F, 10.5915F, 5.37038F);
      ((Path)localObject).cubicTo(10.4392F, 5.52272F, 10.2427F, 5.71219F, 10.0022F, 5.93878F);
      ((Path)localObject).cubicTo(9.76175F, 5.71219F, 9.56533F, 5.52272F, 9.41299F, 5.37038F);
      ((Path)localObject).cubicTo(8.17737F, 4.13476F, 6.35878F, 3.83742F, 4.84258F, 4.47837F);
      ((Path)localObject).lineTo(3.01421F, 2.64999F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.62701F, 5.26279F);
      ((Path)localObject).lineTo(13.3483F, 12.9841F);
      ((Path)localObject).lineTo(15.8114F, 10.5209F);
      ((Path)localObject).cubicTo(17.014799F, 9.28062F, 17.0007F, 7.30127F, 15.7769F, 6.07749F);
      ((Path)localObject).cubicTo(14.5403F, 4.84083F, 12.5353F, 4.84083F, 11.2986F, 6.07749F);
      ((Path)localObject).cubicTo(11.1384F, 6.23771F, 10.9352F, 6.43374F, 10.688F, 6.66662F);
      ((Path)localObject).lineTo(10.0022F, 7.31272F);
      ((Path)localObject).lineTo(9.31649F, 6.66662F);
      ((Path)localObject).cubicTo(9.06933F, 6.43374F, 8.8661F, 6.23771F, 8.70588F, 6.07749F);
      ((Path)localObject).cubicTo(7.87192F, 5.24353F, 6.68854F, 4.97196F, 5.62701F, 5.26279F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.4751F, 11.2176F);
      ((Path)localObject).cubicTo(1.99515F, 9.69169F, 1.91306F, 7.31351F, 3.22912F, 5.69333F);
      ((Path)localObject).lineTo(3.94131F, 6.40552F);
      ((Path)localObject).cubicTo(3.01011F, 7.63284F, 3.09116F, 9.38541F, 4.18221F, 10.5105F);
      ((Path)localObject).lineTo(10.0022F, 16.330601F);
      ((Path)localObject).lineTo(11.9342F, 14.3984F);
      ((Path)localObject).lineTo(12.6413F, 15.1055F);
      ((Path)localObject).lineTo(10.5915F, 17.1555F);
      ((Path)localObject).cubicTo(10.2661F, 17.4809F, 9.73844F, 17.481001F, 9.41299F, 17.1556F);
      ((Path)localObject).lineTo(3.4751F, 11.2176F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_ad_uninterest
 * JD-Core Version:    0.7.0.1
 */