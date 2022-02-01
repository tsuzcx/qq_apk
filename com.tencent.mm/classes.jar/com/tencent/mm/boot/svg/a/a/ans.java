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

public final class ans
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
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(25.226866F, 14.426866F);
      ((Path)localObject2).lineTo(29.41791F, 5.722388F);
      ((Path)localObject2).cubicTo(29.901493F, 4.674627F, 29.901493F, 3.626866F, 29.498508F, 2.659702F);
      ((Path)localObject2).cubicTo(29.095522F, 1.692537F, 28.289553F, 0.9671642F, 27.161194F, 0.5641791F);
      ((Path)localObject2).lineTo(26.274628F, 0.241791F);
      ((Path)localObject2).cubicTo(25.871641F, 0.08059701F, 25.468657F, 0.0F, 25.065672F, 0.0F);
      ((Path)localObject2).cubicTo(23.292538F, 0.0F, 21.841791F, 1.208955F, 21.438807F, 2.98209F);
      ((Path)localObject2).lineTo(19.585075F, 12.411941F);
      ((Path)localObject2).cubicTo(19.101492F, 14.668656F, 19.826866F, 16.764179F, 21.116419F, 17.247761F);
      ((Path)localObject2).cubicTo(21.277613F, 17.328358F, 21.438807F, 17.328358F, 21.680597F, 17.328358F);
      ((Path)localObject2).cubicTo(22.889553F, 17.408955F, 24.340298F, 16.200001F, 25.226866F, 14.426866F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.313433F, 20.552238F);
      ((Path)localObject2).cubicTo(15.474627F, 19.182089F, 13.782089F, 17.731344F, 11.525373F, 17.247761F);
      ((Path)localObject2).lineTo(4.59403F, 15.555223F);
      ((Path)localObject2).cubicTo(4.271642F, 15.474627F, 3.949254F, 15.474627F, 3.626866F, 15.474627F);
      ((Path)localObject2).cubicTo(1.773134F, 15.474627F, 0.241791F, 16.844776F, 0.08059701F, 18.698507F);
      ((Path)localObject2).lineTo(0.0F, 19.665672F);
      ((Path)localObject2).cubicTo(0.0F, 20.794029F, 0.4029851F, 21.841791F, 1.128358F, 22.567163F);
      ((Path)localObject2).cubicTo(1.773134F, 23.211941F, 2.659702F, 23.534328F, 3.626866F, 23.534328F);
      ((Path)localObject2).cubicTo(3.707463F, 23.534328F, 3.78806F, 23.534328F, 3.868657F, 23.534328F);
      ((Path)localObject2).lineTo(10.961194F, 23.211941F);
      ((Path)localObject2).cubicTo(13.298508F, 22.97015F, 15.152239F, 21.841791F, 15.313433F, 20.552238F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.925373F, 27.564178F);
      ((Path)localObject2).cubicTo(15.555223F, 27.161194F, 13.701492F, 28.450747F, 12.814925F, 30.546268F);
      ((Path)localObject2).lineTo(6.044776F, 45.376118F);
      ((Path)localObject2).cubicTo(5.561194F, 46.423882F, 5.561194F, 47.471642F, 6.044776F, 48.438805F);
      ((Path)localObject2).cubicTo(6.528358F, 49.405972F, 7.334328F, 50.131344F, 8.462687F, 50.453732F);
      ((Path)localObject2).lineTo(9.349254F, 50.776119F);
      ((Path)localObject2).lineTo(9.429851F, 50.776119F);
      ((Path)localObject2).cubicTo(9.591044F, 50.776119F, 9.752239F, 50.776119F, 9.913433F, 50.776119F);
      ((Path)localObject2).cubicTo(11.847761F, 50.776119F, 14.023881F, 49.889553F, 14.507463F, 48.03582F);
      ((Path)localObject2).lineTo(18.456717F, 32.238808F);
      ((Path)localObject2).cubicTo(18.859701F, 30.062687F, 18.295523F, 27.967165F, 16.925373F, 27.564178F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.773134F, 29.337313F);
      ((Path)localObject2).cubicTo(27.725372F, 28.208956F, 26.355225F, 27.483582F, 25.226866F, 27.483582F);
      ((Path)localObject2).cubicTo(24.743284F, 27.483582F, 24.340298F, 27.644775F, 24.01791F, 27.886568F);
      ((Path)localObject2).cubicTo(22.97015F, 28.773134F, 23.131344F, 30.949253F, 24.501492F, 32.883583F);
      ((Path)localObject2).lineTo(37.316418F, 51.582088F);
      ((Path)localObject2).cubicTo(38.04179F, 52.710449F, 39.250748F, 53.274628F, 40.459702F, 53.274628F);
      ((Path)localObject2).cubicTo(41.346268F, 53.274628F, 42.232838F, 52.95224F, 42.95821F, 52.388062F);
      ((Path)localObject2).lineTo(43.683582F, 51.823879F);
      ((Path)localObject2).cubicTo(44.570148F, 51.098507F, 45.05373F, 50.131344F, 45.134327F, 49.002987F);
      ((Path)localObject2).cubicTo(45.214924F, 47.874626F, 44.811939F, 46.826866F, 44.086567F, 46.020897F);
      ((Path)localObject2).lineTo(28.773134F, 29.337313F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(53.919403F, 19.907463F);
      ((Path)localObject2).cubicTo(53.758209F, 17.570148F, 51.823879F, 15.877612F, 49.486568F, 16.200001F);
      ((Path)localObject2).lineTo(30.465672F, 19.020895F);
      ((Path)localObject2).cubicTo(28.208956F, 19.343283F, 26.435822F, 20.713432F, 26.516418F, 22.164179F);
      ((Path)localObject2).cubicTo(26.597015F, 23.614925F, 28.450747F, 24.743284F, 30.788059F, 24.743284F);
      ((Path)localObject2).lineTo(49.567165F, 24.985075F);
      ((Path)localObject2).lineTo(49.647762F, 24.985075F);
      ((Path)localObject2).cubicTo(50.856716F, 24.985075F, 52.06567F, 24.420895F, 52.95224F, 23.534328F);
      ((Path)localObject2).cubicTo(53.677612F, 22.728357F, 54.0F, 21.761194F, 54.0F, 20.794029F);
      ((Path)localObject2).lineTo(53.919403F, 19.907463F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ans
 * JD-Core Version:    0.7.0.1
 */