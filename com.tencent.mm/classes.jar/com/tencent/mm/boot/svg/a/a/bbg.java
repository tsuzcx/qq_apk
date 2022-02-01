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

public final class bbg
  extends c
{
  private final int height = 49;
  private final int width = 49;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 49;
      return 49;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-7503);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -187.0F, 0.0F, 1.0F, -58.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 146.0F, 0.0F, 1.0F, 56.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 90.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.347368F, 0.0F, 1.0F, 0.347368F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(24.252632F, 4.042105F);
      ((Path)localObject2).cubicTo(35.414597F, 4.042105F, 44.463158F, 13.090666F, 44.463158F, 24.252632F);
      ((Path)localObject2).cubicTo(44.463158F, 35.414597F, 35.414597F, 44.463158F, 24.252632F, 44.463158F);
      ((Path)localObject2).cubicTo(13.090666F, 44.463158F, 4.042105F, 35.414597F, 4.042105F, 24.252632F);
      ((Path)localObject2).cubicTo(4.042105F, 13.090666F, 13.090666F, 4.042105F, 24.252632F, 4.042105F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.252632F, 6.467369F);
      ((Path)localObject2).cubicTo(14.430102F, 6.467369F, 6.467369F, 14.430102F, 6.467369F, 24.252632F);
      ((Path)localObject2).cubicTo(6.467369F, 34.075161F, 14.430102F, 42.037895F, 24.252632F, 42.037895F);
      ((Path)localObject2).cubicTo(34.075161F, 42.037895F, 42.037895F, 34.075161F, 42.037895F, 24.252632F);
      ((Path)localObject2).cubicTo(42.037895F, 14.430102F, 34.075161F, 6.467369F, 24.252632F, 6.467369F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.178829F, 15.157895F);
      ((Path)localObject2).lineTo(28.291775F, 17.305264F);
      ((Path)localObject2).lineTo(21.585367F, 24.252632F);
      ((Path)localObject2).lineTo(28.291775F, 31.200001F);
      ((Path)localObject2).lineTo(26.178829F, 33.34737F);
      ((Path)localObject2).lineTo(19.028698F, 25.973974F);
      ((Path)localObject2).cubicTo(18.106813F, 25.023302F, 18.11141F, 23.477219F, 19.028698F, 22.531288F);
      ((Path)localObject2).lineTo(26.178829F, 15.157895F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbg
 * JD-Core Version:    0.7.0.1
 */