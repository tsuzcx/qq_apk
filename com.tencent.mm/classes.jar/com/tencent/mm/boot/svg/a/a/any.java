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

public final class any
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.0F, 0.0F);
      ((Path)localObject2).lineTo(15.0F, 0.0F);
      ((Path)localObject2).cubicTo(16.656855F, -3.043592E-016F, 18.0F, 1.343146F, 18.0F, 3.0F);
      ((Path)localObject2).lineTo(18.0F, 15.0F);
      ((Path)localObject2).cubicTo(18.0F, 16.656855F, 16.656855F, 18.0F, 15.0F, 18.0F);
      ((Path)localObject2).lineTo(3.0F, 18.0F);
      ((Path)localObject2).cubicTo(1.343146F, 18.0F, -6.852723E-016F, 16.656855F, -8.881784E-016F, 15.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, -5.838192E-016F, 3.0F, -8.881784E-016F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.0F, 12.857142F);
      ((Path)localObject2).lineTo(11.811378F, 14.335172F);
      ((Path)localObject2).cubicTo(11.957373F, 14.411925F, 12.124599F, 14.438412F, 12.287167F, 14.410529F);
      ((Path)localObject2).cubicTo(12.695419F, 14.340508F, 12.96961F, 13.952791F, 12.89959F, 13.544539F);
      ((Path)localObject2).lineTo(12.362664F, 10.414024F);
      ((Path)localObject2).lineTo(14.637116F, 8.196981F);
      ((Path)localObject2).cubicTo(14.755229F, 8.08185F, 14.832094F, 7.930994F, 14.855813F, 7.767766F);
      ((Path)localObject2).cubicTo(14.915376F, 7.357857F, 14.631365F, 6.977275F, 14.221457F, 6.917712F);
      ((Path)localObject2).lineTo(11.07824F, 6.460976F);
      ((Path)localObject2).lineTo(9.672552F, 3.612739F);
      ((Path)localObject2).cubicTo(9.599554F, 3.46483F, 9.479834F, 3.345109F, 9.331924F, 3.272112F);
      ((Path)localObject2).cubicTo(8.960485F, 3.088795F, 8.510765F, 3.241299F, 8.327448F, 3.612739F);
      ((Path)localObject2).lineTo(6.921759F, 6.460976F);
      ((Path)localObject2).lineTo(3.778544F, 6.917712F);
      ((Path)localObject2).cubicTo(3.615316F, 6.94143F, 3.464459F, 7.018295F, 3.349328F, 7.136408F);
      ((Path)localObject2).cubicTo(3.060202F, 7.433021F, 3.066271F, 7.907856F, 3.362884F, 8.196981F);
      ((Path)localObject2).lineTo(5.637336F, 10.414024F);
      ((Path)localObject2).lineTo(5.100411F, 13.544539F);
      ((Path)localObject2).cubicTo(5.072528F, 13.707108F, 5.099014F, 13.874333F, 5.175768F, 14.020329F);
      ((Path)localObject2).cubicTo(5.368519F, 14.386962F, 5.821989F, 14.527922F, 6.188623F, 14.335172F);
      ((Path)localObject2).lineTo(9.0F, 12.857142F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.any
 * JD-Core Version:    0.7.0.1
 */