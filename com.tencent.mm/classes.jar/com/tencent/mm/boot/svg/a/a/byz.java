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

public final class byz
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 24;
    switch (paramInt)
    {
    }
    for (;;)
    {
      i = 0;
      return i;
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
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(6.506432F, 13.860826F);
      ((Path)localObject).cubicTo(6.636235F, 13.790162F, 6.676828F, 13.729498F, 6.712015F, 13.612761F);
      ((Path)localObject).lineTo(6.991965F, 12.516953F);
      ((Path)localObject).cubicTo(7.140923F, 11.939528F, 7.313309F, 11.283925F, 7.441841F, 10.822269F);
      ((Path)localObject).cubicTo(7.494363F, 10.622026F, 7.587211F, 10.440218F, 7.740204F, 10.276154F);
      ((Path)localObject).cubicTo(7.902759F, 10.101835F, 8.097465F, 9.995839F, 8.303811F, 9.93904F);
      ((Path)localObject).cubicTo(9.442805F, 9.601704F, 10.615337F, 9.372323F, 11.794799F, 9.341112F);
      ((Path)localObject).cubicTo(12.964005F, 9.300339F, 14.149704F, 9.447481F, 15.309488F, 9.704654F);
      ((Path)localObject).cubicTo(15.5193F, 9.746941F, 15.73119F, 9.848678F, 15.89527F, 10.001685F);
      ((Path)localObject).cubicTo(16.049095F, 10.145129F, 16.164673F, 10.32959F, 16.231054F, 10.525686F);
      ((Path)localObject).lineTo(16.553032F, 11.442951F);
      ((Path)localObject).cubicTo(16.781395F, 12.110321F, 17.015753F, 12.823044F, 17.127542F, 13.1829F);
      ((Path)localObject).cubicTo(17.182976F, 13.349617F, 17.225382F, 13.427503F, 17.376434F, 13.491679F);
      ((Path)localObject).lineTo(20.506844F, 14.781315F);
      ((Path)localObject).cubicTo(20.878656F, 14.917158F, 21.292042F, 14.823378F, 21.589159F, 14.525319F);
      ((Path)localObject).cubicTo(21.703903F, 14.402271F, 21.786497F, 14.210899F, 21.804928F, 14.170574F);
      ((Path)localObject).cubicTo(22.372828F, 12.821413F, 22.088453F, 11.214275F, 20.960402F, 10.16235F);
      ((Path)localObject).cubicTo(20.642496F, 9.865898F, 20.268604F, 9.670605F, 20.187256F, 9.613917F);
      ((Path)localObject).cubicTo(17.574724F, 8.09789F, 14.633898F, 7.406798F, 11.72079F, 7.508386F);
      ((Path)localObject).cubicTo(8.953338F, 7.604895F, 6.210902F, 8.416797F, 3.799908F, 9.950418F);
      ((Path)localObject).lineTo(3.328416F, 10.259014F);
      ((Path)localObject).cubicTo(3.182032F, 10.357949F, 2.919624F, 10.552284F, 2.689072F, 10.79952F);
      ((Path)localObject).cubicTo(1.687335F, 11.873753F, 1.484151F, 13.397045F, 2.037859F, 14.668129F);
      ((Path)localObject).lineTo(2.126587F, 14.856812F);
      ((Path)localObject).cubicTo(2.14779F, 14.895755F, 2.233988F, 15.091161F, 2.366611F, 15.195662F);
      ((Path)localObject).cubicTo(2.693385F, 15.462043F, 3.112315F, 15.526798F, 3.473734F, 15.365386F);
      ((Path)localObject).lineTo(6.506432F, 13.860826F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.byz
 * JD-Core Version:    0.7.0.1
 */