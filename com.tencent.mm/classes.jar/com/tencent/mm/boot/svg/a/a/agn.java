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

public final class agn
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
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
      ((Paint)localObject2).setColor(-5592406);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -70.0F, 0.0F, 1.0F, -199.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 69.0F, 0.0F, 1.0F, 98.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 101.67347F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 6.326531F);
      ((Path)localObject2).cubicTo(0.0F, 2.959657F, 2.683541F, 0.3265306F, 6.0F, 0.3265306F);
      ((Path)localObject2).lineTo(42.0F, 0.3265306F);
      ((Path)localObject2).cubicTo(45.310848F, 0.3265306F, 48.0F, 2.954165F, 48.0F, 6.326531F);
      ((Path)localObject2).lineTo(48.0F, 41.32653F);
      ((Path)localObject2).cubicTo(48.0F, 44.693405F, 45.31646F, 47.32653F, 42.0F, 47.32653F);
      ((Path)localObject2).lineTo(6.0F, 47.32653F);
      ((Path)localObject2).cubicTo(2.689151F, 47.32653F, 0.0F, 44.698895F, 0.0F, 41.32653F);
      ((Path)localObject2).lineTo(0.0F, 6.326531F);
      ((Path)localObject2).lineTo(0.0F, 6.326531F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.0F, 6.326531F);
      ((Path)localObject2).cubicTo(4.0F, 5.198393F, 4.89154F, 4.326531F, 6.0F, 4.326531F);
      ((Path)localObject2).lineTo(42.0F, 4.326531F);
      ((Path)localObject2).cubicTo(43.105782F, 4.326531F, 44.0F, 5.195782F, 44.0F, 6.326531F);
      ((Path)localObject2).lineTo(44.0F, 41.32653F);
      ((Path)localObject2).cubicTo(44.0F, 42.45467F, 43.108459F, 43.32653F, 42.0F, 43.32653F);
      ((Path)localObject2).lineTo(6.0F, 43.32653F);
      ((Path)localObject2).cubicTo(4.894218F, 43.32653F, 4.0F, 42.457279F, 4.0F, 41.32653F);
      ((Path)localObject2).lineTo(4.0F, 6.326531F);
      ((Path)localObject2).lineTo(4.0F, 6.326531F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.agn
 * JD-Core Version:    0.7.0.1
 */