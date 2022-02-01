package com.tencent.mm.boot.svg.code.drawable;

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

public class app_attach_file_icon_pdf_in_gird
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 23.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(26.599453F, 7.383812E-015F);
      ((Path)localObject2).lineTo(35.745975F, 0.0F);
      ((Path)localObject2).cubicTo(46.030285F, 0.0F, 51.298946F, 5.448687F, 51.298946F, 15.348269F);
      ((Path)localObject2).cubicTo(51.298946F, 25.247852F, 46.002209F, 33.253735F, 35.745975F, 33.253735F);
      ((Path)localObject2).lineTo(26.599453F, 33.253735F);
      ((Path)localObject2).lineTo(26.599453F, 7.383812E-015F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.768106F, 5.216272F);
      ((Path)localObject2).cubicTo(31.768106F, 5.216272F, 28.448256F, 5.216272F, 35.442616F, 5.216272F);
      ((Path)localObject2).cubicTo(42.436977F, 5.216272F, 46.020191F, 8.955566F, 46.020191F, 15.749397F);
      ((Path)localObject2).cubicTo(46.020191F, 22.543228F, 42.417881F, 28.037462F, 35.442616F, 28.037462F);
      ((Path)localObject2).lineTo(31.768106F, 28.037462F);
      ((Path)localObject2).lineTo(31.768106F, 5.216272F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 33.253735F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).cubicTo(0.0F, 0.0F, 6.980508F, 8.159173E-016F, 12.058983F, 0.0F);
      ((Path)localObject2).cubicTo(17.137459F, -8.072894E-016F, 20.661282F, 3.584669F, 21.510666F, 5.115959F);
      ((Path)localObject2).cubicTo(21.597879F, 5.27319F, 21.680771F, 5.428216F, 21.75931F, 5.58182F);
      ((Path)localObject2).cubicTo(22.445667F, 6.924182F, 22.79953F, 8.157933F, 22.79953F, 9.805588F);
      ((Path)localObject2).cubicTo(22.79953F, 12.445591F, 21.901007F, 14.838656F, 20.2218F, 16.626867F);
      ((Path)localObject2).cubicTo(18.306856F, 18.755327F, 15.92558F, 20.037506F, 11.199739F, 20.213055F);
      ((Path)localObject2).cubicTo(6.473898F, 20.037506F, 5.683069F, 20.213055F, 5.683069F, 20.213055F);
      ((Path)localObject2).lineTo(5.683069F, 33.253735F);
      ((Path)localObject2).lineTo(0.0F, 33.253735F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.683069F, 16.30085F);
      ((Path)localObject2).lineTo(11.36023F, 16.30085F);
      ((Path)localObject2).cubicTo(17.764584F, 16.30085F, 17.116463F, 11.837833F, 17.116463F, 9.892929F);
      ((Path)localObject2).cubicTo(17.116463F, 7.948026F, 17.553057F, 3.912204F, 11.36023F, 3.912204F);
      ((Path)localObject2).lineTo(5.683069F, 3.912204F);
      ((Path)localObject2).lineTo(5.683069F, 16.30085F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(53.198906F, 0.0F);
      ((Path)localObject1).lineTo(53.198906F, 33.253735F);
      ((Path)localObject1).lineTo(58.410225F, 33.253735F);
      ((Path)localObject1).lineTo(58.410225F, 17.604918F);
      ((Path)localObject1).lineTo(72.144226F, 17.604918F);
      ((Path)localObject1).lineTo(72.144226F, 13.04068F);
      ((Path)localObject1).lineTo(58.410225F, 13.04068F);
      ((Path)localObject1).lineTo(58.410225F, 5.216272F);
      ((Path)localObject1).lineTo(74.098473F, 5.216272F);
      ((Path)localObject1).lineTo(74.098473F, 0.0F);
      ((Path)localObject1).lineTo(53.198906F, 0.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_pdf_in_gird
 * JD-Core Version:    0.7.0.1
 */