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

public final class uv
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 16.799999F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(3.6F);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(1.8F, 13.2F);
      ((Path)localObject2).lineTo(1.8F, 44.400002F);
      ((Path)localObject2).cubicTo(1.8F, 46.056854F, 3.143146F, 47.400002F, 4.8F, 47.400002F);
      ((Path)localObject2).lineTo(57.599998F, 47.400002F);
      ((Path)localObject2).cubicTo(59.256855F, 47.400002F, 60.599998F, 46.056854F, 60.599998F, 44.400002F);
      ((Path)localObject2).lineTo(60.599998F, 13.2F);
      ((Path)localObject2).cubicTo(60.599998F, 11.543146F, 59.256855F, 10.2F, 57.599998F, 10.2F);
      ((Path)localObject2).lineTo(45.873688F, 10.2F);
      ((Path)localObject2).lineTo(40.053158F, 2.051257F);
      ((Path)localObject2).cubicTo(39.940529F, 1.893579F, 39.758686F, 1.8F, 39.564919F, 1.8F);
      ((Path)localObject2).lineTo(22.835083F, 1.8F);
      ((Path)localObject2).cubicTo(22.641312F, 1.8F, 22.459471F, 1.893579F, 22.346844F, 2.051257F);
      ((Path)localObject2).lineTo(16.526312F, 10.2F);
      ((Path)localObject2).lineTo(4.8F, 10.2F);
      ((Path)localObject2).cubicTo(3.143146F, 10.2F, 1.8F, 11.543146F, 1.8F, 13.2F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(4.8F, 1.2F);
      ((Path)localObject2).lineTo(13.2F, 1.2F);
      ((Path)localObject2).lineTo(13.2F, 4.8F);
      ((Path)localObject2).lineTo(4.8F, 4.8F);
      ((Path)localObject2).lineTo(4.8F, 1.2F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(16.799999F, 26.4F);
      ((Path)localObject1).lineTo(12.0F, 26.4F);
      ((Path)localObject1).lineTo(18.6F, 19.799999F);
      ((Path)localObject1).lineTo(25.200001F, 26.4F);
      ((Path)localObject1).lineTo(20.4F, 26.4F);
      ((Path)localObject1).cubicTo(20.4F, 32.364674F, 25.235325F, 37.200001F, 31.200001F, 37.200001F);
      ((Path)localObject1).cubicTo(34.234703F, 37.200001F, 36.977062F, 35.948349F, 38.939007F, 33.933121F);
      ((Path)localObject1).lineTo(41.484764F, 36.478878F);
      ((Path)localObject1).cubicTo(38.871197F, 39.145496F, 35.228813F, 40.799999F, 31.200001F, 40.799999F);
      ((Path)localObject1).cubicTo(23.247099F, 40.799999F, 16.799999F, 34.352901F, 16.799999F, 26.4F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(45.599998F, 26.4F);
      ((Path)localObject1).lineTo(50.400002F, 26.4F);
      ((Path)localObject1).lineTo(43.799999F, 33.0F);
      ((Path)localObject1).lineTo(37.200001F, 26.4F);
      ((Path)localObject1).lineTo(42.0F, 26.4F);
      ((Path)localObject1).cubicTo(42.0F, 20.435326F, 37.164677F, 15.6F, 31.200001F, 15.6F);
      ((Path)localObject1).cubicTo(28.165298F, 15.6F, 25.422937F, 16.851652F, 23.460993F, 18.86688F);
      ((Path)localObject1).lineTo(20.915236F, 16.321123F);
      ((Path)localObject1).cubicTo(23.528803F, 13.654503F, 27.171186F, 12.0F, 31.200001F, 12.0F);
      ((Path)localObject1).cubicTo(39.152901F, 12.0F, 45.599998F, 18.4471F, 45.599998F, 26.4F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.uv
 * JD-Core Version:    0.7.0.1
 */