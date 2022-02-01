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

public final class bvz
  extends c
{
  private final int height = 16;
  private final int width = 12;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
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
      ((Paint)localObject2).setColor(-5066062);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -396.0F, 0.0F, 1.0F, -671.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 327.0F, 0.0F, 1.0F, 68.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 1.5F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.9F, 4.65F);
      ((Path)localObject3).lineTo(0.9F, 13.506087F);
      ((Path)localObject3).cubicTo(0.9F, 13.833202F, 1.166941F, 14.1F, 1.495545F, 14.1F);
      ((Path)localObject3).lineTo(10.504455F, 14.1F);
      ((Path)localObject3).cubicTo(10.832851F, 14.1F, 11.1F, 13.833303F, 11.1F, 13.506087F);
      ((Path)localObject3).lineTo(11.1F, 4.65F);
      ((Path)localObject3).lineTo(0.9F, 4.65F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(0.0F, 4.505613F);
      ((Path)localObject3).cubicTo(0.0F, 4.088299F, 0.3334732F, 3.75F, 0.7506537F, 3.75F);
      ((Path)localObject3).lineTo(11.249347F, 3.75F);
      ((Path)localObject3).cubicTo(11.663921F, 3.75F, 12.0F, 4.08669F, 12.0F, 4.505613F);
      ((Path)localObject3).lineTo(12.0F, 13.506087F);
      ((Path)localObject3).cubicTo(12.0F, 14.331152F, 11.329115F, 15.0F, 10.504455F, 15.0F);
      ((Path)localObject3).lineTo(1.495545F, 15.0F);
      ((Path)localObject3).cubicTo(0.6695784F, 15.0F, 0.0F, 14.329952F, 0.0F, 13.506087F);
      ((Path)localObject3).lineTo(0.0F, 4.505613F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.0F, 3.0F);
      ((Path)localObject2).cubicTo(3.0F, 1.343146F, 4.343146F, 0.0F, 6.0F, 0.0F);
      ((Path)localObject2).cubicTo(7.656854F, 0.0F, 9.0F, 1.343146F, 9.0F, 3.0F);
      ((Path)localObject2).lineTo(8.999999F, 6.75F);
      ((Path)localObject2).lineTo(8.099999F, 6.75F);
      ((Path)localObject2).lineTo(8.099999F, 3.0F);
      ((Path)localObject2).cubicTo(8.099998F, 1.8402F, 7.159796F, 0.8999977F, 5.999998F, 0.8999977F);
      ((Path)localObject2).cubicTo(4.8402F, 0.8999977F, 3.899998F, 1.8402F, 3.899998F, 2.999998F);
      ((Path)localObject2).lineTo(3.9F, 6.75F);
      ((Path)localObject2).lineTo(3.0F, 6.75F);
      ((Path)localObject2).lineTo(3.0F, 3.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bvz
 * JD-Core Version:    0.7.0.1
 */