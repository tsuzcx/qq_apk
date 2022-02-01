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

public final class bvc
  extends c
{
  private final int height = 27;
  private final int width = 29;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 29;
      return 27;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.m(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.a((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject2, 1.0F, 0.0F, -333.0F, 0.0F, 1.0F, -227.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16268960);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 335.0F, 0.0F, 1.0F, 229.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(14211288);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(333.0F, 227.0F);
      ((Path)localObject1).lineTo(362.0F, 227.0F);
      ((Path)localObject1).lineTo(362.0F, 254.0F);
      ((Path)localObject1).lineTo(333.0F, 254.0F);
      ((Path)localObject1).lineTo(333.0F, 227.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bvc
 * JD-Core Version:    0.7.0.1
 */