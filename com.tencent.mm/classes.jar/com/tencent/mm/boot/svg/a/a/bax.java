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

public final class bax
  extends c
{
  private final int height = 1334;
  private final int width = 750;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 750;
      return 1334;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-870400);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      Object localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(750.0F, 0.0F);
      ((Path)localObject3).lineTo(750.0F, 1334.0F);
      ((Path)localObject3).lineTo(0.0F, 1334.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject3 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject3).setColor(-877312);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(68.523438F, 1334.0F);
      ((Path)localObject2).lineTo(849.04688F, 377.42969F);
      ((Path)localObject2).lineTo(5.891446E-014F, 199.80469F);
      ((Path)localObject2).lineTo(0.0F, 1334.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.saveLayerAlpha(null, 69, 31);
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localObject3 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject3).setColor(-748799);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(801.04688F, 102.0F);
      ((Path)localObject2).lineTo(-62.109375F, 375.08594F);
      ((Path)localObject2).lineTo(-62.109375F, 657.77344F);
      ((Path)localObject2).lineTo(785.65625F, 1323.5469F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.saveLayerAlpha(null, 39, 31);
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-25344);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(-88.0F, 1217.8438F);
      ((Path)localObject1).lineTo(903.07813F, 1441.7344F);
      ((Path)localObject1).lineTo(855.39844F, 671.83594F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.saveLayerAlpha(null, 103, 31);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bax
 * JD-Core Version:    0.7.0.1
 */