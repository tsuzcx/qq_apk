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

public final class bdf
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
      Object localObject2 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -120.0F, 0.0F, 1.0F, -426.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 120.0F, 0.0F, 1.0F, 426.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-70474);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(44.0F, 22.271605F);
      ((Path)localObject3).cubicTo(44.0F, 9.849482F, 34.15052F, 0.0F, 21.728395F, 0.0F);
      ((Path)localObject3).cubicTo(9.849482F, 0.0F, 0.0F, 9.849482F, 0.0F, 22.271605F);
      ((Path)localObject3).cubicTo(0.0F, 34.15052F, 9.849482F, 44.0F, 21.728395F, 44.0F);
      ((Path)localObject3).cubicTo(34.15052F, 44.0F, 44.0F, 34.15052F, 44.0F, 22.271605F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-36352);
      ((Paint)localObject1).setStrokeWidth(3.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(42.5F, 22.271605F);
      ((Path)localObject2).cubicTo(42.5F, 10.677909F, 33.32209F, 1.5F, 21.728395F, 1.5F);
      ((Path)localObject2).cubicTo(10.600406F, 1.5F, 1.5F, 10.756952F, 1.5F, 22.271605F);
      ((Path)localObject2).cubicTo(1.5F, 33.32209F, 10.677909F, 42.5F, 21.728395F, 42.5F);
      ((Path)localObject2).cubicTo(33.243046F, 42.5F, 42.5F, 33.399593F, 42.5F, 22.271605F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-36352);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(8.37882F, 23.270937F);
      ((Path)localObject1).cubicTo(8.197487F, 23.075033F, 8.176818F, 22.736786F, 8.330922F, 22.517902F);
      ((Path)localObject1).lineTo(9.380023F, 21.027798F);
      ((Path)localObject1).cubicTo(9.534904F, 20.80781F, 9.826069F, 20.761974F, 10.042893F, 20.935448F);
      ((Path)localObject1).lineTo(17.207075F, 26.667225F);
      ((Path)localObject1).cubicTo(17.418287F, 26.836208F, 17.750328F, 26.833344F, 17.961102F, 26.650051F);
      ((Path)localObject1).lineTo(35.820465F, 11.119163F);
      ((Path)localObject1).cubicTo(36.025688F, 10.940694F, 36.340633F, 10.949186F, 36.533489F, 11.148006F);
      ((Path)localObject1).lineTo(37.460594F, 12.103773F);
      ((Path)localObject1).cubicTo(37.649166F, 12.298171F, 37.650951F, 12.610968F, 37.46806F, 12.798857F);
      ((Path)localObject1).lineTo(17.922888F, 32.87793F);
      ((Path)localObject1).cubicTo(17.738441F, 33.067417F, 17.439091F, 33.059162F, 17.260582F, 32.86631F);
      ((Path)localObject1).lineTo(8.37882F, 23.270937F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bdf
 * JD-Core Version:    0.7.0.1
 */