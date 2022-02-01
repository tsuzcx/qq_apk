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

public final class bcm
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
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(17.0F, 15.0F);
      ((Path)localObject2).lineTo(17.0F, 19.0F);
      ((Path)localObject2).lineTo(13.0F, 19.0F);
      ((Path)localObject2).lineTo(13.0F, 15.0F);
      ((Path)localObject2).lineTo(17.0F, 15.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.0F, 17.0F);
      ((Path)localObject2).lineTo(22.0F, 19.0F);
      ((Path)localObject2).lineTo(20.0F, 19.0F);
      ((Path)localObject2).lineTo(20.0F, 17.0F);
      ((Path)localObject2).lineTo(22.0F, 17.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.0F, 16.0F);
      ((Path)localObject2).lineTo(14.0F, 16.0F);
      ((Path)localObject2).lineTo(14.0F, 18.0F);
      ((Path)localObject2).lineTo(16.0F, 18.0F);
      ((Path)localObject2).lineTo(16.0F, 16.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.5F, 0.0F);
      ((Path)localObject2).cubicTo(11.709139F, 0.0F, 13.5F, 1.79298F, 13.5F, 4.000207F);
      ((Path)localObject2).lineTo(13.5F, 5.710186F);
      ((Path)localObject2).cubicTo(13.5F, 6.849296F, 12.900932F, 8.482861F, 12.168087F, 9.351573F);
      ((Path)localObject2).lineTo(11.806555F, 9.780132F);
      ((Path)localObject2).cubicTo(11.480202F, 10.16699F, 11.5F, 10.736298F, 11.5F, 11.451569F);
      ((Path)localObject2).lineTo(11.5F, 18.0F);
      ((Path)localObject2).lineTo(1.0F, 18.0F);
      ((Path)localObject2).cubicTo(0.4477153F, 18.0F, 0.0F, 17.552284F, 0.0F, 17.0F);
      ((Path)localObject2).lineTo(0.0F, 16.315464F);
      ((Path)localObject2).cubicTo(0.0F, 15.630374F, 0.4981509F, 14.831908F, 1.114098F, 14.531333F);
      ((Path)localObject2).lineTo(6.774451F, 11.769143F);
      ((Path)localObject2).cubicTo(7.595377F, 11.36854F, 7.786259F, 10.481262F, 7.193445F, 9.778639F);
      ((Path)localObject2).lineTo(6.831913F, 9.350138F);
      ((Path)localObject2).cubicTo(6.096318F, 8.478285F, 5.5F, 6.849496F, 5.5F, 5.709291F);
      ((Path)localObject2).lineTo(5.5F, 3.99958F);
      ((Path)localObject2).cubicTo(5.5F, 1.790673F, 7.295356F, 0.0F, 9.5F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.0F, 15.0F);
      ((Path)localObject2).lineTo(20.0F, 17.0F);
      ((Path)localObject2).lineTo(18.0F, 17.0F);
      ((Path)localObject2).lineTo(18.0F, 15.0F);
      ((Path)localObject2).lineTo(20.0F, 15.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.0F, 10.0F);
      ((Path)localObject2).lineTo(17.0F, 14.0F);
      ((Path)localObject2).lineTo(13.0F, 14.0F);
      ((Path)localObject2).lineTo(13.0F, 10.0F);
      ((Path)localObject2).lineTo(17.0F, 10.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.0F, 10.0F);
      ((Path)localObject2).lineTo(22.0F, 14.0F);
      ((Path)localObject2).lineTo(18.0F, 14.0F);
      ((Path)localObject2).lineTo(18.0F, 10.0F);
      ((Path)localObject2).lineTo(22.0F, 10.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.0F, 11.0F);
      ((Path)localObject2).lineTo(14.0F, 11.0F);
      ((Path)localObject2).lineTo(14.0F, 13.0F);
      ((Path)localObject2).lineTo(16.0F, 13.0F);
      ((Path)localObject2).lineTo(16.0F, 11.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.0F, 11.0F);
      ((Path)localObject2).lineTo(19.0F, 11.0F);
      ((Path)localObject2).lineTo(19.0F, 13.0F);
      ((Path)localObject2).lineTo(21.0F, 13.0F);
      ((Path)localObject2).lineTo(21.0F, 11.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bcm
 * JD-Core Version:    0.7.0.1
 */