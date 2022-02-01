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

public final class anv
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
      localObject2 = c.a((float[])localObject2, 0.9659258F, 0.258819F, -5.141926F, -0.258819F, 0.9659258F, 10.155929F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(54.0F, 51.299999F);
      ((Path)localObject2).lineTo(54.0F, 60.019806F);
      ((Path)localObject2).cubicTo(54.0F, 61.665722F, 52.665489F, 63.0F, 51.013268F, 63.0F);
      ((Path)localObject2).lineTo(23.986732F, 63.0F);
      ((Path)localObject2).cubicTo(22.337206F, 63.0F, 21.0F, 61.665161F, 21.0F, 60.019806F);
      ((Path)localObject2).lineTo(21.0F, 38.912449F);
      ((Path)localObject2).cubicTo(21.30163F, 39.048756F, 21.609167F, 39.183006F, 21.921507F, 39.314156F);
      ((Path)localObject2).cubicTo(23.265209F, 39.878365F, 24.582113F, 40.336334F, 25.839781F, 40.650318F);
      ((Path)localObject2).cubicTo(28.095984F, 41.213585F, 30.050961F, 41.29538F, 31.665142F, 40.707027F);
      ((Path)localObject2).cubicTo(36.233082F, 39.042068F, 38.330482F, 32.089893F, 35.980827F, 29.450768F);
      ((Path)localObject2).cubicTo(35.513691F, 28.926079F, 33.744747F, 27.074095F, 30.979206F, 24.204306F);
      ((Path)localObject2).cubicTo(29.871628F, 23.055052F, 28.685123F, 21.826685F, 27.498646F, 20.600201F);
      ((Path)localObject2).cubicTo(26.786768F, 19.864321F, 26.233141F, 19.292643F, 25.91646F, 18.965904F);
      ((Path)localObject2).cubicTo(24.742807F, 17.753525F, 22.812239F, 16.810616F, 21.0F, 16.491131F);
      ((Path)localObject2).lineTo(21.0F, 11.980193F);
      ((Path)localObject2).cubicTo(21.0F, 10.334278F, 22.334511F, 9.0F, 23.986732F, 9.0F);
      ((Path)localObject2).lineTo(51.013268F, 9.0F);
      ((Path)localObject2).cubicTo(52.662796F, 9.0F, 54.0F, 10.334839F, 54.0F, 11.980193F);
      ((Path)localObject2).lineTo(54.0F, 17.700001F);
      ((Path)localObject2).lineTo(49.489227F, 17.700001F);
      ((Path)localObject2).cubicTo(45.916843F, 17.700001F, 43.338657F, 20.655678F, 43.812843F, 24.19775F);
      ((Path)localObject2).lineTo(46.832333F, 46.752647F);
      ((Path)localObject2).cubicTo(47.173195F, 49.298794F, 49.442432F, 51.299999F, 51.99622F, 51.299999F);
      ((Path)localObject2).lineTo(54.0F, 51.299999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.5F, 51.0F);
      ((Path)localObject2).lineTo(31.5F, 54.599998F);
      ((Path)localObject2).lineTo(43.5F, 54.599998F);
      ((Path)localObject2).lineTo(43.5F, 51.0F);
      ((Path)localObject2).lineTo(31.5F, 51.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(47.381012F, 23.720068F);
      ((Path)localObject2).cubicTo(47.195469F, 22.334118F, 48.097511F, 21.299999F, 49.489227F, 21.299999F);
      ((Path)localObject2).lineTo(56.252983F, 21.299999F);
      ((Path)localObject2).cubicTo(57.736332F, 21.299999F, 58.942211F, 22.507206F, 58.942211F, 23.991302F);
      ((Path)localObject2).lineTo(58.942211F, 45.008698F);
      ((Path)localObject2).cubicTo(58.942211F, 46.505844F, 57.751324F, 47.700001F, 56.243904F, 47.700001F);
      ((Path)localObject2).lineTo(51.99622F, 47.700001F);
      ((Path)localObject2).cubicTo(51.252003F, 47.700001F, 50.502827F, 47.039314F, 50.400501F, 46.274967F);
      ((Path)localObject2).lineTo(47.381012F, 23.720068F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.397715F, 34.010975F);
      ((Path)localObject2).lineTo(18.843857F, 32.824669F);
      ((Path)localObject2).cubicTo(18.686981F, 32.704899F, 18.495085F, 32.640022F, 18.297714F, 32.640022F);
      ((Path)localObject2).cubicTo(17.800659F, 32.640022F, 17.397715F, 33.042965F, 17.397715F, 33.54002F);
      ((Path)localObject2).lineTo(17.397715F, 56.090065F);
      ((Path)localObject2).lineTo(10.394293F, 58.243305F);
      ((Path)localObject2).cubicTo(9.746578F, 58.443615F, 8.94323F, 58.050762F, 8.692907F, 57.394131F);
      ((Path)localObject2).lineTo(2.382967F, 40.842251F);
      ((Path)localObject2).cubicTo(2.170552F, 40.285057F, 2.433447F, 39.769848F, 3.021453F, 39.607578F);
      ((Path)localObject2).lineTo(10.757407F, 37.078484F);
      ((Path)localObject2).cubicTo(10.796127F, 32.456417F, 10.941004F, 29.350193F, 11.192037F, 27.759811F);
      ((Path)localObject2).cubicTo(11.49506F, 25.840052F, 11.986672F, 24.227743F, 12.668005F, 23.031994F);
      ((Path)localObject2).cubicTo(13.272918F, 21.970364F, 14.12464F, 21.166481F, 15.179122F, 20.576422F);
      ((Path)localObject2).cubicTo(15.977722F, 20.129547F, 16.848448F, 19.829689F, 17.721182F, 19.654343F);
      ((Path)localObject2).cubicTo(18.236618F, 19.550785F, 18.62059F, 19.512987F, 18.799316F, 19.509129F);
      ((Path)localObject2).lineTo(18.970287F, 19.502258F);
      ((Path)localObject2).cubicTo(20.092958F, 19.454565F, 21.868908F, 20.169153F, 22.670456F, 20.997149F);
      ((Path)localObject2).cubicTo(22.986925F, 21.323669F, 23.539995F, 21.894772F, 24.25102F, 22.62977F);
      ((Path)localObject2).cubicTo(25.436043F, 23.854748F, 26.621038F, 25.081554F, 27.770212F, 26.273972F);
      ((Path)localObject2).cubicTo(30.42823F, 29.032187F, 32.213764F, 30.901539F, 32.63187F, 31.371153F);
      ((Path)localObject2).cubicTo(33.230915F, 32.043999F, 32.028763F, 36.028717F, 29.772131F, 36.851231F);
      ((Path)localObject2).cubicTo(29.621887F, 36.905994F, 29.469059F, 36.95356F, 29.313614F, 36.994114F);
      ((Path)localObject2).cubicTo(27.844446F, 37.377403F, 26.174154F, 37.131363F, 24.516998F, 36.460342F);
      ((Path)localObject2).cubicTo(23.847412F, 36.189213F, 23.35302F, 35.923737F, 23.111376F, 35.7687F);
      ((Path)localObject2).lineTo(20.397715F, 33.9902F);
      ((Path)localObject2).lineTo(20.397715F, 34.010975F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.anv
 * JD-Core Version:    0.7.0.1
 */