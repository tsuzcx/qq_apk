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

public final class cbm
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint.setColor(-16268960);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(160.0F, 74.916672F);
      ((Path)localObject).cubicTo(160.0F, 74.916672F, 160.0F, 74.916672F, 160.0F, 74.916672F);
      ((Path)localObject).lineTo(160.0F, 90.030312F);
      ((Path)localObject).cubicTo(160.0F, 128.80115F, 133.61324F, 162.59669F, 96.0F, 172.0F);
      ((Path)localObject).cubicTo(58.386761F, 162.59669F, 32.0F, 128.80115F, 32.0F, 90.030312F);
      ((Path)localObject).lineTo(32.0F, 44.0F);
      ((Path)localObject).lineTo(96.0F, 20.0F);
      ((Path)localObject).lineTo(160.0F, 44.0F);
      ((Path)localObject).lineTo(160.0F, 74.916672F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(150.39999F, 74.056938F);
      ((Path)localObject).lineTo(150.39999F, 51.495453F);
      ((Path)localObject).lineTo(96.0F, 29.895454F);
      ((Path)localObject).lineTo(41.599998F, 51.495453F);
      ((Path)localObject).lineTo(41.599998F, 90.030312F);
      ((Path)localObject).cubicTo(41.599998F, 123.59032F, 63.904877F, 152.94469F, 96.0F, 162.06497F);
      ((Path)localObject).cubicTo(128.09512F, 152.94469F, 150.39999F, 123.59032F, 150.39999F, 90.030312F);
      ((Path)localObject).lineTo(150.39999F, 82.615417F);
      ((Path)localObject).lineTo(82.631294F, 119.29995F);
      ((Path)localObject).lineTo(82.153336F, 119.55992F);
      ((Path)localObject).cubicTo(81.563126F, 119.83688F, 80.898697F, 120.0F, 80.194435F, 120.0F);
      ((Path)localObject).cubicTo(78.559601F, 120.0F, 77.138397F, 119.15552F, 76.392494F, 117.90834F);
      ((Path)localObject).lineTo(76.108261F, 117.32383F);
      ((Path)localObject).lineTo(64.208199F, 92.818626F);
      ((Path)localObject).cubicTo(64.079659F, 92.551865F, 64.0F, 92.249413F, 64.0F, 91.95546F);
      ((Path)localObject).cubicTo(64.0F, 90.827217F, 64.97583F, 89.913078F, 66.177963F, 89.913078F);
      ((Path)localObject).cubicTo(66.67041F, 89.913078F, 67.117584F, 90.064301F, 67.483299F, 90.319176F);
      ((Path)localObject).lineTo(81.5233F, 99.700203F);
      ((Path)localObject).cubicTo(82.546204F, 100.32889F, 83.77549F, 100.69931F, 85.093498F, 100.69931F);
      ((Path)localObject).cubicTo(85.877419F, 100.69931F, 86.628754F, 100.56338F, 87.325775F, 100.32379F);
      ((Path)localObject).cubicTo(87.325775F, 100.32379F, 132.81609F, 81.36927F, 150.39999F, 74.056938F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cbm
 * JD-Core Version:    0.7.0.1
 */