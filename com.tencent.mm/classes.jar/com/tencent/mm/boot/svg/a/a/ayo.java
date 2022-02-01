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

public final class ayo
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
      localCanvas.saveLayerAlpha(null, 46, 31);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16268960);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -327.0F, 0.0F, 1.0F, -562.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 327.0F, 0.0F, 1.0F, 562.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.0F, 24.0F);
      ((Path)localObject2).cubicTo(5.372583F, 24.0F, 0.0F, 18.627417F, 0.0F, 12.0F);
      ((Path)localObject2).cubicTo(0.0F, 5.372583F, 5.372583F, 0.0F, 12.0F, 0.0F);
      ((Path)localObject2).cubicTo(18.627417F, 0.0F, 24.0F, 5.372583F, 24.0F, 12.0F);
      ((Path)localObject2).cubicTo(24.0F, 18.627417F, 18.627417F, 24.0F, 12.0F, 24.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 22.559999F);
      ((Path)localObject2).cubicTo(17.832127F, 22.559999F, 22.559999F, 17.832127F, 22.559999F, 12.0F);
      ((Path)localObject2).cubicTo(22.559999F, 6.167873F, 17.832127F, 1.44F, 12.0F, 1.44F);
      ((Path)localObject2).cubicTo(6.167873F, 1.44F, 1.44F, 6.167873F, 1.44F, 12.0F);
      ((Path)localObject2).cubicTo(1.44F, 17.832127F, 6.167873F, 22.559999F, 12.0F, 22.559999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.28F, 9.6F);
      ((Path)localObject2).lineTo(12.719999F, 9.6F);
      ((Path)localObject2).lineTo(12.719999F, 18.0F);
      ((Path)localObject2).lineTo(11.28F, 18.0F);
      ((Path)localObject2).lineTo(11.28F, 9.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 8.4F);
      ((Path)localObject2).cubicTo(11.337258F, 8.4F, 10.8F, 7.862742F, 10.8F, 7.2F);
      ((Path)localObject2).cubicTo(10.8F, 6.537258F, 11.337258F, 6.0F, 12.0F, 6.0F);
      ((Path)localObject2).cubicTo(12.662742F, 6.0F, 13.2F, 6.537258F, 13.2F, 7.2F);
      ((Path)localObject2).cubicTo(13.2F, 7.862742F, 12.662742F, 8.4F, 12.0F, 8.4F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ayo
 * JD-Core Version:    0.7.0.1
 */