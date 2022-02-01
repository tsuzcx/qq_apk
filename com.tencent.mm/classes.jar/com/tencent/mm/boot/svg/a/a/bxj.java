package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bxj
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      ((Canvas)localObject1).save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.364812F, 19.181551F);
      ((Path)localObject2).cubicTo(12.244402F, 19.242964F, 12.108849F, 19.279133F, 11.96517F, 19.279133F);
      ((Path)localObject2).cubicTo(11.631642F, 19.279133F, 11.3417F, 19.091883F, 11.189525F, 18.81534F);
      ((Path)localObject2).lineTo(11.131536F, 18.685736F);
      ((Path)localObject2).lineTo(8.703769F, 13.2521F);
      ((Path)localObject2).cubicTo(8.677545F, 13.192948F, 8.661293F, 13.125885F, 8.661293F, 13.060705F);
      ((Path)localObject2).cubicTo(8.661293F, 12.810536F, 8.860375F, 12.60784F, 9.105626F, 12.60784F);
      ((Path)localObject2).cubicTo(9.206091F, 12.60784F, 9.297321F, 12.641372F, 9.371931F, 12.697886F);
      ((Path)localObject2).lineTo(12.236277F, 14.777978F);
      ((Path)localObject2).cubicTo(12.444962F, 14.917379F, 12.695753F, 14.999514F, 12.964643F, 14.999514F);
      ((Path)localObject2).cubicTo(13.124574F, 14.999514F, 13.277856F, 14.969373F, 13.420058F, 14.916249F);
      ((Path)localObject2).lineTo(26.890791F, 8.801055F);
      ((Path)localObject2).cubicTo(24.47632F, 5.897741F, 20.499477F, 4.0F, 15.999631F, 4.0F);
      ((Path)localObject2).cubicTo(8.635438F, 4.0F, 2.666667F, 9.074583F, 2.666667F, 15.334453F);
      ((Path)localObject2).cubicTo(2.666667F, 18.749407F, 4.4621F, 21.824146F, 7.273258F, 23.901979F);
      ((Path)localObject2).cubicTo(7.498933F, 24.06587F, 7.646306F, 24.335255F, 7.646306F, 24.64043F);
      ((Path)localObject2).cubicTo(7.646306F, 24.741402F, 7.625991F, 24.832577F, 7.599398F, 24.929028F);
      ((Path)localObject2).cubicTo(7.3752F, 25.78352F, 7.015818F, 27.151159F, 6.999197F, 27.215586F);
      ((Path)localObject2).cubicTo(6.971126F, 27.322208F, 6.927173F, 27.434483F, 6.927173F, 27.547134F);
      ((Path)localObject2).cubicTo(6.927173F, 27.796926F, 7.125886F, 28.0F, 7.372245F, 28.0F);
      ((Path)localObject2).cubicTo(7.468277F, 28.0F, 7.546949F, 27.963455F, 7.628577F, 27.915983F);
      ((Path)localObject2).lineTo(10.547586F, 26.196449F);
      ((Path)localObject2).cubicTo(10.766983F, 26.067221F, 10.999308F, 25.987347F, 11.25564F, 25.987347F);
      ((Path)localObject2).cubicTo(11.391932F, 25.987347F, 11.523791F, 26.008823F, 11.647525F, 26.047628F);
      ((Path)localObject2).cubicTo(13.009336F, 26.446995F, 14.478628F, 26.668907F, 15.999631F, 26.668907F);
      ((Path)localObject2).cubicTo(23.363455F, 26.668907F, 29.333334F, 21.594324F, 29.333334F, 15.334453F);
      ((Path)localObject2).cubicTo(29.333334F, 13.438972F, 28.782625F, 11.65313F, 27.814178F, 10.082793F);
      ((Path)localObject2).lineTo(12.462321F, 19.123907F);
      ((Path)localObject2).lineTo(12.364812F, 19.181551F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      ((Canvas)localObject1).drawPath((Path)localObject2, localPaint);
      ((Canvas)localObject1).restore();
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(32.0F, 0.0F);
      ((Path)localObject1).lineTo(32.0F, 32.0F);
      ((Path)localObject1).lineTo(0.0F, 32.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bxj
 * JD-Core Version:    0.7.0.1
 */