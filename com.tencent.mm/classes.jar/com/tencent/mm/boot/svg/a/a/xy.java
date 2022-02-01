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

public final class xy
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint1.setColor(-436207616);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(48.853916F, 22.935286F);
      ((Path)localObject2).cubicTo(53.186268F, 18.470255F, 53.135693F, 11.344611F, 48.730064F, 6.938983F);
      ((Path)localObject2).cubicTo(44.278088F, 2.487006F, 37.060009F, 2.487006F, 32.608028F, 6.938983F);
      ((Path)localObject2).cubicTo(32.031235F, 7.515777F, 31.29962F, 8.221499F, 30.409842F, 9.059835F);
      ((Path)localObject2).lineTo(27.941126F, 11.385826F);
      ((Path)localObject2).lineTo(25.47241F, 9.059835F);
      ((Path)localObject2).cubicTo(24.582632F, 8.221499F, 23.851015F, 7.515777F, 23.274221F, 6.938983F);
      ((Path)localObject2).cubicTo(18.822245F, 2.487006F, 11.604163F, 2.487006F, 7.152186F, 6.938983F);
      ((Path)localObject2).cubicTo(2.746611F, 11.344558F, 2.69575F, 18.470612F, 6.989021F, 22.897852F);
      ((Path)localObject2).lineTo(27.940998F, 43.850048F);
      ((Path)localObject2).lineTo(48.853916F, 22.935286F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.606602F, 4.393398F);
      ((Path)localObject2).cubicTo(10.464466F, -1.464466F, 19.961941F, -1.464466F, 25.819805F, 4.393398F);
      ((Path)localObject2).cubicTo(26.368225F, 4.941818F, 27.075333F, 5.623898F, 27.941126F, 6.439637F);
      ((Path)localObject2).cubicTo(28.806919F, 5.623898F, 29.514027F, 4.941818F, 30.062447F, 4.393398F);
      ((Path)localObject2).cubicTo(35.920311F, -1.464466F, 45.417786F, -1.464466F, 51.27565F, 4.393398F);
      ((Path)localObject2).cubicTo(57.079025F, 10.196773F, 57.133007F, 19.572361F, 51.437599F, 25.442194F);
      ((Path)localObject2).lineTo(30.062447F, 46.819805F);
      ((Path)localObject2).cubicTo(28.890934F, 47.99144F, 26.99144F, 47.991539F, 25.819805F, 46.820026F);
      ((Path)localObject2).lineTo(4.443423F, 25.443422F);
      ((Path)localObject2).cubicTo(-1.250756F, 19.572361F, -1.196773F, 10.196773F, 4.606602F, 4.393398F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xy
 * JD-Core Version:    0.7.0.1
 */