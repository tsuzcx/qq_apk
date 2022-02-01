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

public final class bcy
  extends c
{
  private final int height = 84;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 84;
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
      localPaint1.setColor(-12206054);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 16.9F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(24.496F, 1.694F);
      ((Path)localObject2).cubicTo(27.290001F, 0.163F, 30.624001F, -0.37F, 33.750999F, 0.264F);
      ((Path)localObject2).cubicTo(36.855F, 0.865F, 39.674F, 2.588F, 41.814999F, 4.89F);
      ((Path)localObject2).cubicTo(44.432999F, 7.703F, 46.105F, 11.33F, 46.761002F, 15.102F);
      ((Path)localObject2).cubicTo(47.716F, 20.528F, 46.660999F, 26.362F, 43.543999F, 30.943001F);
      ((Path)localObject2).cubicTo(42.692001F, 32.194F, 41.686001F, 33.341999F, 40.546001F, 34.339001F);
      ((Path)localObject2).cubicTo(40.050999F, 34.792999F, 39.540001F, 35.269001F, 39.254002F, 35.889F);
      ((Path)localObject2).cubicTo(39.035999F, 36.362F, 39.112999F, 36.896F, 39.099998F, 37.401001F);
      ((Path)localObject2).cubicTo(39.108002F, 37.778F, 39.039001F, 38.196999F, 39.273998F, 38.525002F);
      ((Path)localObject2).cubicTo(39.747002F, 39.23F, 40.511002F, 39.655998F, 41.224998F, 40.078999F);
      ((Path)localObject2).cubicTo(46.189999F, 43.181F, 51.154999F, 46.285F, 56.119999F, 49.388F);
      ((Path)localObject2).cubicTo(56.386002F, 49.556999F, 56.652F, 49.73F, 56.941002F, 49.862F);
      ((Path)localObject2).cubicTo(58.564999F, 50.625F, 59.950001F, 51.889F, 60.856998F, 53.438F);
      ((Path)localObject2).cubicTo(61.652F, 54.780998F, 62.084F, 56.335999F, 62.098F, 57.896999F);
      ((Path)localObject2).cubicTo(62.103001F, 59.264F, 62.098F, 60.632F, 62.099998F, 62.0F);
      ((Path)localObject2).lineTo(0.1F, 62.0F);
      ((Path)localObject2).cubicTo(0.101F, 60.632F, 0.098F, 59.264999F, 0.101F, 57.897999F);
      ((Path)localObject2).cubicTo(0.118F, 56.073002F, 0.708F, 54.259998F, 1.772F, 52.777F);
      ((Path)localObject2).cubicTo(2.712F, 51.443001F, 4.034F, 50.401001F, 5.517F, 49.733002F);
      ((Path)localObject2).cubicTo(10.635F, 46.549999F, 15.741F, 43.345001F, 20.855F, 40.153999F);
      ((Path)localObject2).cubicTo(21.542F, 39.728001F, 22.232F, 39.278999F, 22.774F, 38.671001F);
      ((Path)localObject2).cubicTo(22.988001F, 38.436001F, 23.139F, 38.131001F, 23.101999F, 37.805F);
      ((Path)localObject2).cubicTo(23.061001F, 37.112F, 23.229F, 36.356998F, 22.865F, 35.724998F);
      ((Path)localObject2).cubicTo(22.431999F, 34.953999F, 21.711F, 34.416F, 21.083F, 33.814999F);
      ((Path)localObject2).cubicTo(18.607F, 31.451F, 16.872999F, 28.367001F, 15.939F, 25.086F);
      ((Path)localObject2).cubicTo(14.334F, 19.407F, 15.024F, 13.05F, 18.073F, 7.967F);
      ((Path)localObject2).cubicTo(19.632F, 5.377F, 21.82F, 3.129F, 24.496F, 1.694F);
      ((Path)localObject2).lineTo(24.496F, 1.694F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bcy
 * JD-Core Version:    0.7.0.1
 */