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

public final class kv
  extends c
{
  private final int height = 44;
  private final int width = 44;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 44;
      return 44;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -32.0F, 0.0F, 1.0F, -21.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 21.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16409779);
      ((Paint)localObject1).setStrokeWidth(1.2F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(22.594595F, 43.400002F);
      ((Path)localObject2).cubicTo(33.818893F, 43.400002F, 43.400002F, 33.818893F, 43.400002F, 22.594595F);
      ((Path)localObject2).cubicTo(43.400002F, 10.363577F, 33.994289F, 0.6F, 22.594595F, 0.6F);
      ((Path)localObject2).cubicTo(10.181107F, 0.6F, 0.6F, 10.181107F, 0.6F, 22.594595F);
      ((Path)localObject2).cubicTo(0.6F, 33.994289F, 10.363577F, 43.400002F, 22.594595F, 43.400002F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16409779);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(23.815264F, 31.186165F);
      ((Path)localObject1).cubicTo(26.139557F, 28.861872F, 27.466667F, 25.724232F, 27.466667F, 22.370899F);
      ((Path)localObject1).cubicTo(27.466667F, 19.017567F, 26.139557F, 15.879927F, 23.815264F, 13.555634F);
      ((Path)localObject1).lineTo(25.370899F, 12.0F);
      ((Path)localObject1).cubicTo(28.025043F, 14.654144F, 29.666666F, 18.320812F, 29.666666F, 22.370899F);
      ((Path)localObject1).cubicTo(29.666666F, 26.420988F, 28.025043F, 30.087654F, 25.370899F, 32.741798F);
      ((Path)localObject1).lineTo(23.815264F, 31.186165F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(20.18545F, 27.556349F);
      ((Path)localObject1).cubicTo(21.553268F, 26.18853F, 22.333334F, 24.34425F, 22.333334F, 22.370899F);
      ((Path)localObject1).cubicTo(22.333334F, 20.397549F, 21.553268F, 18.553268F, 20.18545F, 17.18545F);
      ((Path)localObject1).lineTo(21.741085F, 15.629815F);
      ((Path)localObject1).cubicTo(23.466278F, 17.355009F, 24.533333F, 19.738342F, 24.533333F, 22.370899F);
      ((Path)localObject1).cubicTo(24.533333F, 25.003456F, 23.466278F, 27.386789F, 21.741085F, 29.111984F);
      ((Path)localObject1).lineTo(20.18545F, 27.556349F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(18.111269F, 25.48217F);
      ((Path)localObject1).lineTo(15.0F, 22.370899F);
      ((Path)localObject1).lineTo(18.111269F, 19.25963F);
      ((Path)localObject1).cubicTo(18.907513F, 20.055874F, 19.4F, 21.155872F, 19.4F, 22.370899F);
      ((Path)localObject1).cubicTo(19.4F, 23.585926F, 18.907513F, 24.685926F, 18.111269F, 25.48217F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kv
 * JD-Core Version:    0.7.0.1
 */