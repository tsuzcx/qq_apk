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

public final class op
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
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject4 = c.m(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.a((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(0.0F, 0.0F);
      ((Path)localObject4).lineTo(48.0F, 0.0F);
      ((Path)localObject4).lineTo(48.0F, 48.0F);
      ((Path)localObject4).lineTo(0.0F, 48.0F);
      ((Path)localObject4).lineTo(0.0F, 0.0F);
      ((Path)localObject4).close();
      ((Canvas)localObject1).save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-14474461);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).saveLayerAlpha(null, 76, 31);
      ((Canvas)localObject1).save();
      localObject2 = c.a(localPaint, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(10.740368F, 0.2068763F);
      ((Path)localObject3).lineTo(12.706858F, 0.2068763F);
      ((Path)localObject3).cubicTo(13.314371F, 0.2068763F, 13.806858F, 0.6993631F, 13.806858F, 1.306876F);
      ((Path)localObject3).cubicTo(13.806758F, 1.325002F, 13.806758F, 1.325002F, 13.80626F, 1.34312F);
      ((Path)localObject3).lineTo(13.539227F, 9.44312F);
      ((Path)localObject3).cubicTo(13.519675F, 10.036202F, 13.033229F, 10.506876F, 12.439825F, 10.506876F);
      ((Path)localObject3).lineTo(11.007401F, 10.506876F);
      ((Path)localObject3).cubicTo(10.413997F, 10.506876F, 9.92755F, 10.036202F, 9.907998F, 9.44312F);
      ((Path)localObject3).lineTo(9.640966F, 1.34312F);
      ((Path)localObject3).cubicTo(9.620948F, 0.735937F, 10.09694F, 0.227491F, 10.704123F, 0.2074736F);
      ((Path)localObject3).cubicTo(10.722242F, 0.2069759F, 10.722242F, 0.2069759F, 10.740368F, 0.2068763F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(25.707619F, 6.406519F);
      ((Path)localObject3).cubicTo(26.137196F, 6.836096F, 26.137196F, 7.532578F, 25.707619F, 7.962154F);
      ((Path)localObject3).cubicTo(25.694731F, 7.9749F, 25.694731F, 7.9749F, 25.681568F, 7.98736F);
      ((Path)localObject3).lineTo(19.765182F, 13.526104F);
      ((Path)localObject3).cubicTo(19.331984F, 13.931651F, 18.655197F, 13.920499F, 18.235598F, 13.500898F);
      ((Path)localObject3).lineTo(17.222721F, 12.488022F);
      ((Path)localObject3).cubicTo(16.803122F, 12.068421F, 16.791967F, 11.391635F, 17.197515F, 10.958438F);
      ((Path)localObject3).lineTo(22.736259F, 5.042052F);
      ((Path)localObject3).cubicTo(23.151449F, 4.598554F, 23.847551F, 4.575605F, 24.29105F, 4.990795F);
      ((Path)localObject3).cubicTo(24.304213F, 5.003255F, 24.304213F, 5.003255F, 24.317101F, 5.016001F);
      ((Path)localObject3).lineTo(25.707619F, 6.406519F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(30.516735F, 18.016766F);
      ((Path)localObject3).lineTo(30.516735F, 19.983255F);
      ((Path)localObject3).cubicTo(30.516735F, 20.590769F, 30.024248F, 21.083254F, 29.416735F, 21.083254F);
      ((Path)localObject3).cubicTo(29.398609F, 21.083155F, 29.398609F, 21.083155F, 29.380491F, 21.082657F);
      ((Path)localObject3).lineTo(21.280491F, 20.815624F);
      ((Path)localObject3).cubicTo(20.687408F, 20.796072F, 20.216734F, 20.309626F, 20.216734F, 19.716221F);
      ((Path)localObject3).lineTo(20.216734F, 18.283798F);
      ((Path)localObject3).cubicTo(20.216734F, 17.690393F, 20.687408F, 17.203947F, 21.280491F, 17.184395F);
      ((Path)localObject3).lineTo(29.380491F, 16.917362F);
      ((Path)localObject3).cubicTo(29.987675F, 16.897345F, 30.49612F, 17.373337F, 30.516138F, 17.98052F);
      ((Path)localObject3).cubicTo(30.516636F, 17.99864F, 30.516636F, 17.99864F, 30.516735F, 18.016766F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(4.0F, 10.0F);
      ((Path)localObject3).lineTo(4.0F, 38.0F);
      ((Path)localObject3).lineTo(20.0F, 38.0F);
      ((Path)localObject3).lineTo(20.0F, 26.0F);
      ((Path)localObject3).lineTo(24.0F, 26.0F);
      ((Path)localObject3).lineTo(24.0F, 40.0F);
      ((Path)localObject3).cubicTo(24.0F, 41.104568F, 23.10457F, 42.0F, 22.0F, 42.0F);
      ((Path)localObject3).lineTo(2.0F, 42.0F);
      ((Path)localObject3).cubicTo(0.8954305F, 42.0F, -3.552714E-015F, 41.104568F, -7.105427E-015F, 40.0F);
      ((Path)localObject3).lineTo(-7.105427E-015F, 8.0F);
      ((Path)localObject3).cubicTo(-1.065814E-014F, 6.895431F, 0.8954305F, 6.0F, 2.0F, 6.0F);
      ((Path)localObject3).lineTo(6.0F, 6.0F);
      ((Path)localObject3).lineTo(6.0F, 10.0F);
      ((Path)localObject3).lineTo(4.0F, 10.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      ((Canvas)localObject1).drawPath((Path)localObject3, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(48.0F, 0.0F);
      ((Path)localObject1).lineTo(48.0F, 48.0F);
      ((Path)localObject1).lineTo(0.0F, 48.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.op
 * JD-Core Version:    0.7.0.1
 */