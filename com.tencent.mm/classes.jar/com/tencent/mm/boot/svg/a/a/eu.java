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

public final class eu
  extends c
{
  private final int height = 63;
  private final int width = 63;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 63;
      return 63;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localPaint1.setColor(-11048043);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -131.0F, 0.0F, 1.0F, -206.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(161.0F, 261.92117F);
      ((Path)localObject2).cubicTo(148.12799F, 260.90228F, 138.0F, 250.13391F, 138.0F, 237.0F);
      ((Path)localObject2).cubicTo(138.0F, 230.57487F, 140.42381F, 224.71585F, 144.40697F, 220.28743F);
      ((Path)localObject2).lineTo(148.24004F, 223.50375F);
      ((Path)localObject2).cubicTo(144.98555F, 227.06102F, 143.0F, 231.79863F, 143.0F, 237.0F);
      ((Path)localObject2).cubicTo(143.0F, 247.27452F, 150.74763F, 255.7395F, 160.71942F, 256.8714F);
      ((Path)localObject2).lineTo(161.0F, 257.10684F);
      ((Path)localObject2).lineTo(161.0F, 253.35852F);
      ((Path)localObject2).cubicTo(161.0F, 253.00606F, 161.22818F, 252.89862F, 161.50964F, 253.09564F);
      ((Path)localObject2).lineTo(170.49036F, 259.38214F);
      ((Path)localObject2).cubicTo(170.77235F, 259.57953F, 170.77182F, 259.89862F, 170.49036F, 260.09564F);
      ((Path)localObject2).lineTo(161.50964F, 266.38214F);
      ((Path)localObject2).cubicTo(161.22765F, 266.57953F, 161.0F, 266.46149F, 161.0F, 266.11926F);
      ((Path)localObject2).lineTo(161.0F, 261.92117F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(161.0F, 212.07884F);
      ((Path)localObject2).cubicTo(161.65979F, 212.02661F, 162.32678F, 212.0F, 163.0F, 212.0F);
      ((Path)localObject2).cubicTo(176.80711F, 212.0F, 188.0F, 223.19289F, 188.0F, 237.0F);
      ((Path)localObject2).cubicTo(188.0F, 244.6545F, 184.55992F, 251.50551F, 179.14146F, 256.09134F);
      ((Path)localObject2).lineTo(175.24045F, 252.81801F);
      ((Path)localObject2).cubicTo(179.96123F, 249.15959F, 183.0F, 243.43468F, 183.0F, 237.0F);
      ((Path)localObject2).cubicTo(183.0F, 225.9543F, 174.0457F, 217.0F, 163.0F, 217.0F);
      ((Path)localObject2).cubicTo(162.325F, 217.0F, 161.65781F, 217.03343F, 161.0F, 217.09875F);
      ((Path)localObject2).lineTo(161.0F, 221.11926F);
      ((Path)localObject2).cubicTo(161.0F, 221.47173F, 160.77182F, 221.57916F, 160.49036F, 221.38214F);
      ((Path)localObject2).lineTo(151.50964F, 215.09564F);
      ((Path)localObject2).cubicTo(151.22765F, 214.89825F, 151.22818F, 214.57916F, 151.50964F, 214.38214F);
      ((Path)localObject2).lineTo(160.49036F, 208.09564F);
      ((Path)localObject2).cubicTo(160.77235F, 207.89825F, 161.0F, 208.01631F, 161.0F, 208.35852F);
      ((Path)localObject2).lineTo(161.0F, 212.07884F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.eu
 * JD-Core Version:    0.7.0.1
 */