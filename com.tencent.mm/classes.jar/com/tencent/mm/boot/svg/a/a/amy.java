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

public final class amy
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
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
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 0.7071068F, 0.7071068F, 3.576279E-007F, -0.7071068F, 0.7071068F, 9.862136F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.6659409F, 1.425962F);
      ((Path)localObject2).cubicTo(0.907191F, 0.942068F, 1.495037F, 0.7453674F, 1.97893F, 0.986618F);
      ((Path)localObject2).lineTo(1.97893F, 0.986618F);
      ((Path)localObject2).lineTo(18.15151F, 9.04964F);
      ((Path)localObject2).cubicTo(18.341776F, 9.144499F, 18.495995F, 9.298717F, 18.590853F, 9.488983F);
      ((Path)localObject2).cubicTo(18.832104F, 9.972877F, 18.635403F, 10.560722F, 18.15151F, 10.801972F);
      ((Path)localObject2).lineTo(18.15151F, 10.801972F);
      ((Path)localObject2).lineTo(1.97893F, 18.864994F);
      ((Path)localObject2).cubicTo(1.761161F, 18.973566F, 1.510763F, 18.997149F, 1.276552F, 18.931145F);
      ((Path)localObject2).cubicTo(0.7561243F, 18.784483F, 0.4531277F, 18.2437F, 0.59979F, 17.723272F);
      ((Path)localObject2).lineTo(0.59979F, 17.723272F);
      ((Path)localObject2).lineTo(2.394836F, 11.351548F);
      ((Path)localObject2).lineTo(9.34992F, 10.574074F);
      ((Path)localObject2).cubicTo(9.647224F, 10.540835F, 9.879302F, 10.31128F, 9.922745F, 10.023385F);
      ((Path)localObject2).lineTo(9.93007F, 9.925448F);
      ((Path)localObject2).cubicTo(9.93007F, 9.593053F, 9.680258F, 9.313755F, 9.34992F, 9.276823F);
      ((Path)localObject2).lineTo(9.34992F, 9.276823F);
      ((Path)localObject2).lineTo(2.394836F, 8.498549F);
      ((Path)localObject2).lineTo(0.59979F, 2.12834F);
      ((Path)localObject2).cubicTo(0.5447872F, 1.933164F, 0.551997F, 1.726748F, 0.618759F, 1.53734F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.amy
 * JD-Core Version:    0.7.0.1
 */