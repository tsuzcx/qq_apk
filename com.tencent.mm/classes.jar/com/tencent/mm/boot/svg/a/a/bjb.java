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

public final class bjb
  extends c
{
  private final int height = 73;
  private final int width = 68;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 68;
      return 73;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-757915);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 9.45F, 0.0F, 1.0F, 6.75F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 2.533342F);
      ((Path)localObject2).cubicTo(0.0F, 1.134216F, 1.137126F, 0.0F, 2.545699F, 0.0F);
      ((Path)localObject2).lineTo(47.404301F, 0.0F);
      ((Path)localObject2).cubicTo(48.810253F, 0.0F, 49.950001F, 1.133553F, 49.950001F, 2.533342F);
      ((Path)localObject2).lineTo(49.950001F, 56.866657F);
      ((Path)localObject2).cubicTo(49.950001F, 58.265785F, 48.812874F, 59.400002F, 47.404301F, 59.400002F);
      ((Path)localObject2).lineTo(2.545699F, 59.400002F);
      ((Path)localObject2).cubicTo(1.139749F, 59.400002F, 0.0F, 58.266449F, 0.0F, 56.866657F);
      ((Path)localObject2).lineTo(0.0F, 2.533342F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.281428F, 4.242857F);
      ((Path)localObject2).lineTo(45.668571F, 4.242857F);
      ((Path)localObject2).lineTo(45.668571F, 55.157143F);
      ((Path)localObject2).lineTo(4.281428F, 55.157143F);
      ((Path)localObject2).lineTo(4.281428F, 4.242857F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(24.975F, 21.214287F);
      ((Path)localObject2).cubicTo(27.733664F, 21.214287F, 29.970001F, 23.430477F, 29.970001F, 26.164286F);
      ((Path)localObject2).cubicTo(29.970001F, 28.898094F, 27.733664F, 31.114285F, 24.975F, 31.114285F);
      ((Path)localObject2).cubicTo(22.216337F, 31.114285F, 19.98F, 28.898094F, 19.98F, 26.164286F);
      ((Path)localObject2).cubicTo(19.98F, 23.430477F, 22.216337F, 21.214287F, 24.975F, 21.214287F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(32.822899F, 26.016615F);
      ((Path)localObject1).cubicTo(42.771538F, 23.7808F, 49.950001F, 17.410063F, 49.950001F, 9.9F);
      ((Path)localObject1).cubicTo(49.950001F, 7.916405F, 49.449215F, 6.012292F, 48.528873F, 4.242857F);
      ((Path)localObject1).lineTo(45.262028F, 4.242857F);
      ((Path)localObject1).cubicTo(45.528664F, 5.070159F, 45.668571F, 5.96271F, 45.668571F, 6.922556F);
      ((Path)localObject1).cubicTo(45.668571F, 13.030636F, 40.002968F, 20.055094F, 32.067444F, 22.827524F);
      ((Path)localObject1).cubicTo(32.532673F, 23.796925F, 32.801483F, 24.876797F, 32.822899F, 26.016615F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(17.1271F, 26.016615F);
      ((Path)localObject1).cubicTo(7.178464F, 23.7808F, 0.0F, 17.410063F, 0.0F, 9.9F);
      ((Path)localObject1).cubicTo(0.0F, 7.916405F, 0.5007839F, 6.012292F, 1.421125F, 4.242857F);
      ((Path)localObject1).lineTo(4.687974F, 4.242857F);
      ((Path)localObject1).cubicTo(4.421336F, 5.070159F, 4.281428F, 5.96271F, 4.281428F, 6.922556F);
      ((Path)localObject1).cubicTo(4.281428F, 13.030636F, 9.947033F, 20.055094F, 17.882557F, 22.827524F);
      ((Path)localObject1).cubicTo(17.417328F, 23.796925F, 17.148516F, 24.876797F, 17.1271F, 26.016615F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bjb
 * JD-Core Version:    0.7.0.1
 */