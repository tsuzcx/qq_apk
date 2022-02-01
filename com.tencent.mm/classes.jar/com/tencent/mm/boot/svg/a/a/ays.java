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

public final class ays
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
      arrayOfFloat = c.a(arrayOfFloat, 2.4F, 0.0F, 0.0F, 0.0F, 2.4F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-15028967);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(20.0F, 10.123457F);
      ((Path)localObject2).cubicTo(20.0F, 4.477037F, 15.522963F, 0.0F, 9.876543F, 0.0F);
      ((Path)localObject2).cubicTo(4.477037F, 0.0F, 0.0F, 4.477037F, 0.0F, 10.123457F);
      ((Path)localObject2).cubicTo(0.0F, 15.522963F, 4.477037F, 20.0F, 9.876543F, 20.0F);
      ((Path)localObject2).cubicTo(15.522963F, 20.0F, 20.0F, 15.522963F, 20.0F, 10.123457F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(5.456435F, 10.368831F);
      ((Path)localObject1).lineTo(5.506938F, 10.300112F);
      ((Path)localObject1).cubicTo(5.663359F, 10.087274F, 5.962703F, 10.041537F, 6.175542F, 10.197958F);
      ((Path)localObject1).cubicTo(6.178132F, 10.199862F, 6.180702F, 10.201791F, 6.183252F, 10.203745F);
      ((Path)localObject1).lineTo(8.341835F, 11.858175F);
      ((Path)localObject1).cubicTo(8.519239F, 11.994144F, 8.76716F, 11.989105F, 8.938891F, 11.846039F);
      ((Path)localObject1).lineTo(15.01762F, 6.781966F);
      ((Path)localObject1).cubicTo(15.194826F, 6.634339F, 15.455153F, 6.645353F, 15.619257F, 6.807421F);
      ((Path)localObject1).lineTo(15.619257F, 6.807421F);
      ((Path)localObject1).cubicTo(15.776759F, 6.962969F, 15.778342F, 7.216747F, 15.622794F, 7.37425F);
      ((Path)localObject1).cubicTo(15.621458F, 7.375602F, 15.620112F, 7.376945F, 15.618758F, 7.378278F);
      ((Path)localObject1).lineTo(8.989018F, 13.902933F);
      ((Path)localObject1).cubicTo(8.800759F, 14.088207F, 8.497951F, 14.085789F, 8.312676F, 13.897531F);
      ((Path)localObject1).cubicTo(8.311649F, 13.896486F, 8.310627F, 13.895438F, 8.309609F, 13.894385F);
      ((Path)localObject1).lineTo(5.497875F, 10.98438F);
      ((Path)localObject1).cubicTo(5.335879F, 10.816722F, 5.318373F, 10.556688F, 5.456435F, 10.368831F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ays
 * JD-Core Version:    0.7.0.1
 */