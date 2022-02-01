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

public final class we
  extends c
{
  private final int height = 24;
  private final int width = 25;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 25;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject3 = c.m(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.a((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -264.0F, 0.0F, 1.0F, -296.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 256.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 264.0F, 0.0F, 1.0F, 40.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Object localObject4 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject4).setColor(-2565928);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 23.0F);
      ((Path)localObject3).lineTo(24.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 24.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.saveLayerAlpha(null, 0, 31);
      localObject4 = c.a((Paint)localObject4, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setColor(436207615);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(10.0F, 0.0F);
      ((Path)localObject4).cubicTo(15.522847F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      ((Path)localObject4).cubicTo(20.0F, 15.522847F, 15.522847F, 20.0F, 10.0F, 20.0F);
      ((Path)localObject4).cubicTo(4.477152F, 20.0F, 0.0F, 15.522847F, 0.0F, 10.0F);
      ((Path)localObject4).cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(10.0F, 1.666667F);
      ((Path)localObject4).cubicTo(5.397627F, 1.666667F, 1.666667F, 5.397627F, 1.666667F, 10.0F);
      ((Path)localObject4).cubicTo(1.666667F, 14.602373F, 5.397627F, 18.333334F, 10.0F, 18.333334F);
      ((Path)localObject4).cubicTo(14.602373F, 18.333334F, 18.333334F, 14.602373F, 18.333334F, 10.0F);
      ((Path)localObject4).cubicTo(18.333334F, 5.397627F, 14.602373F, 1.666667F, 10.0F, 1.666667F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 1);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setColor(-2130706433);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(10.000875F, 0.0F);
      ((Path)localObject4).cubicTo(15.522847F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      ((Path)localObject4).cubicTo(20.0F, 15.522847F, 15.522847F, 20.0F, 10.0F, 20.0F);
      ((Path)localObject4).cubicTo(4.528486F, 20.0F, 0.08331788F, 15.605688F, 0.001157607F, 10.153726F);
      ((Path)localObject4).lineTo(0.000875017F, 10.133333F);
      ((Path)localObject4).cubicTo(0.000875017F, 9.673096F, 0.3739711F, 9.3F, 0.8342084F, 9.3F);
      ((Path)localObject4).cubicTo(1.294446F, 9.3F, 1.667542F, 9.673096F, 1.667542F, 10.133333F);
      ((Path)localObject4).lineTo(1.665875F, 10.111F);
      ((Path)localObject4).lineTo(1.667875F, 10.111F);
      ((Path)localObject4).lineTo(1.670487F, 10.254773F);
      ((Path)localObject4).cubicTo(1.805149F, 14.739277F, 5.482856F, 18.333334F, 10.0F, 18.333334F);
      ((Path)localObject4).cubicTo(14.602373F, 18.333334F, 18.333334F, 14.602373F, 18.333334F, 10.0F);
      ((Path)localObject4).cubicTo(18.333334F, 5.397963F, 14.602917F, 1.667211F, 10.001006F, 1.666667F);
      ((Path)localObject4).cubicTo(9.539763F, 1.666667F, 9.166667F, 1.293571F, 9.166667F, 0.8333333F);
      ((Path)localObject4).cubicTo(9.166667F, 0.3730961F, 9.539763F, 0.0F, 10.0F, 0.0F);
      ((Path)localObject4).lineTo(10.0F, 0.0F);
      ((Path)localObject4).lineTo(10.000875F, 0.0F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 1);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-2130706433);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 4.451329F, 0.0F, 1.0F, 4.496923F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(6.400186F, -4.547474E-013F);
      ((Path)localObject2).lineTo(6.400015F, 8.271F);
      ((Path)localObject2).lineTo(8.856973F, 5.815717F);
      ((Path)localObject2).lineTo(10.104809F, 7.063553F);
      ((Path)localObject2).lineTo(6.153329F, 11.015032F);
      ((Path)localObject2).cubicTo(5.835256F, 11.333106F, 5.334757F, 11.357574F, 4.988618F, 11.088433F);
      ((Path)localObject2).lineTo(4.905494F, 11.015032F);
      ((Path)localObject2).lineTo(0.954015F, 7.063553F);
      ((Path)localObject2).lineTo(2.20185F, 5.815717F);
      ((Path)localObject2).lineTo(4.635015F, 8.25F);
      ((Path)localObject2).lineTo(4.63548F, -4.547474E-013F);
      ((Path)localObject2).lineTo(6.400186F, -4.547474E-013F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.we
 * JD-Core Version:    0.7.0.1
 */