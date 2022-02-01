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

public final class dy
  extends c
{
  private final int height = 42;
  private final int width = 42;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 42;
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -275.0F, 0.0F, 1.0F, -1626.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 126.0F, 0.0F, 1.0F, 1626.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 149.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a(localPaint1, paramVarArgs);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-70474);
      localPaint2.setColor(-36352);
      localPaint2.setStrokeWidth(5.4F);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(42.0F, 21.25926F);
      ((Path)localObject2).cubicTo(42.0F, 9.401778F, 32.598221F, 0.0F, 20.74074F, 0.0F);
      ((Path)localObject2).cubicTo(9.401778F, 0.0F, 0.0F, 9.401778F, 0.0F, 21.25926F);
      ((Path)localObject2).cubicTo(0.0F, 32.598221F, 9.401778F, 42.0F, 20.74074F, 42.0F);
      ((Path)localObject2).cubicTo(32.598221F, 42.0F, 42.0F, 32.598221F, 42.0F, 21.25926F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-36352);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(7.193202F, 22.069902F);
      ((Path)localObject1).cubicTo(7.020972F, 21.90468F, 7.001341F, 21.619408F, 7.147708F, 21.434807F);
      ((Path)localObject1).lineTo(8.144134F, 20.17808F);
      ((Path)localObject1).cubicTo(8.291237F, 19.992548F, 8.567782F, 19.95389F, 8.763619F, 20.093018F);
      ((Path)localObject1).lineTo(15.588285F, 24.941442F);
      ((Path)localObject1).cubicTo(15.783314F, 25.079996F, 16.094162F, 25.074368F, 16.278591F, 24.931952F);
      ((Path)localObject1).lineTo(33.272747F, 11.809155F);
      ((Path)localObject1).cubicTo(33.458961F, 11.665359F, 33.751038F, 11.677971F, 33.934212F, 11.845651F);
      ((Path)localObject1).lineTo(34.814766F, 12.651727F);
      ((Path)localObject1).cubicTo(34.993866F, 12.815679F, 34.995564F, 13.079486F, 34.821854F, 13.237947F);
      ((Path)localObject1).lineTo(16.258057F, 30.172258F);
      ((Path)localObject1).cubicTo(16.08287F, 30.332067F, 15.798551F, 30.325104F, 15.629005F, 30.162458F);
      ((Path)localObject1).lineTo(7.193202F, 22.069902F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.dy
 * JD-Core Version:    0.7.0.1
 */