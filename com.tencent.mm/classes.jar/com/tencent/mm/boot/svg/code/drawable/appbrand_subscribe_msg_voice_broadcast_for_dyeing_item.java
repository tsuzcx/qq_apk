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

public class appbrand_subscribe_msg_voice_broadcast_for_dyeing_item
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
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(16.0F, 0.0F);
      ((Path)localObject2).lineTo(16.0F, 16.0F);
      ((Path)localObject2).lineTo(0.0F, 16.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(13.0F, 8.0F);
      ((Path)localObject1).cubicTo(13.0F, 11.124449F, 11.768582F, 13.953082F, 9.777688F, 16.0005F);
      ((Path)localObject1).lineTo(8.741085F, 14.933333F);
      ((Path)localObject1).cubicTo(10.466279F, 13.158938F, 11.533333F, 10.707635F, 11.533333F, 8.0F);
      ((Path)localObject1).cubicTo(11.533333F, 5.292365F, 10.466279F, 2.841061F, 8.741085F, 1.066667F);
      ((Path)localObject1).lineTo(9.778174F, 1.687539E-014F);
      ((Path)localObject1).cubicTo(11.768784F, 2.047379F, 13.0F, 4.875806F, 13.0F, 8.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(9.333333F, 8.0F);
      ((Path)localObject1).cubicTo(9.333333F, 10.082796F, 8.512522F, 11.968414F, 7.18545F, 13.333333F);
      ((Path)localObject1).lineTo(6.14836F, 12.266666F);
      ((Path)localObject1).cubicTo(7.210018F, 11.174731F, 7.866667F, 9.666237F, 7.866667F, 8.0F);
      ((Path)localObject1).cubicTo(7.866667F, 6.333763F, 7.210018F, 4.825269F, 6.14836F, 3.733333F);
      ((Path)localObject1).lineTo(7.186409F, 2.667654F);
      ((Path)localObject1).cubicTo(8.512918F, 4.032495F, 9.333333F, 5.917706F, 9.333333F, 8.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(5.666667F, 8.0F);
      ((Path)localObject1).cubicTo(5.666667F, 9.041398F, 5.256261F, 9.984207F, 4.592725F, 10.666667F);
      ((Path)localObject1).lineTo(2.0F, 8.0F);
      ((Path)localObject1).lineTo(4.592725F, 5.333334F);
      ((Path)localObject1).cubicTo(5.256261F, 6.015793F, 5.666667F, 6.958602F, 5.666667F, 8.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_subscribe_msg_voice_broadcast_for_dyeing_item
 * JD-Core Version:    0.7.0.1
 */