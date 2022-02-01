package com.tencent.mm.boot.svg.code.drawable;

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

public class appbrand_menu_setting
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(31.689205F, 3.6F);
      ((Path)localObject2).lineTo(28.310795F, 3.6F);
      ((Path)localObject2).lineTo(26.377216F, 11.334318F);
      ((Path)localObject2).lineTo(24.435577F, 11.931427F);
      ((Path)localObject2).cubicTo(23.3022F, 12.279973F, 22.206543F, 12.734787F, 21.161264F, 13.289021F);
      ((Path)localObject2).lineTo(19.365543F, 14.24116F);
      ((Path)localObject2).lineTo(12.526829F, 10.137933F);
      ((Path)localObject2).lineTo(10.137933F, 12.526829F);
      ((Path)localObject2).lineTo(14.24116F, 19.365543F);
      ((Path)localObject2).lineTo(13.289021F, 21.161264F);
      ((Path)localObject2).cubicTo(12.734787F, 22.206543F, 12.279973F, 23.3022F, 11.931427F, 24.435577F);
      ((Path)localObject2).lineTo(11.334318F, 26.377216F);
      ((Path)localObject2).lineTo(3.6F, 28.310795F);
      ((Path)localObject2).lineTo(3.6F, 31.689205F);
      ((Path)localObject2).lineTo(11.334318F, 33.622784F);
      ((Path)localObject2).lineTo(11.931427F, 35.564423F);
      ((Path)localObject2).cubicTo(12.279973F, 36.6978F, 12.734787F, 37.793457F, 13.289021F, 38.838734F);
      ((Path)localObject2).lineTo(14.24116F, 40.634457F);
      ((Path)localObject2).lineTo(10.137933F, 47.473171F);
      ((Path)localObject2).lineTo(12.526829F, 49.862068F);
      ((Path)localObject2).lineTo(19.365543F, 45.758839F);
      ((Path)localObject2).lineTo(21.161264F, 46.710979F);
      ((Path)localObject2).cubicTo(22.206543F, 47.265213F, 23.3022F, 47.720028F, 24.435577F, 48.068573F);
      ((Path)localObject2).lineTo(26.377216F, 48.665684F);
      ((Path)localObject2).lineTo(28.310795F, 56.400002F);
      ((Path)localObject2).lineTo(31.689205F, 56.400002F);
      ((Path)localObject2).lineTo(33.622784F, 48.665684F);
      ((Path)localObject2).lineTo(35.564423F, 48.068573F);
      ((Path)localObject2).cubicTo(36.6978F, 47.720028F, 37.793457F, 47.265213F, 38.838734F, 46.710979F);
      ((Path)localObject2).lineTo(40.634457F, 45.758839F);
      ((Path)localObject2).lineTo(47.473171F, 49.862068F);
      ((Path)localObject2).lineTo(49.862068F, 47.473171F);
      ((Path)localObject2).lineTo(45.758839F, 40.634457F);
      ((Path)localObject2).lineTo(46.710979F, 38.838734F);
      ((Path)localObject2).cubicTo(47.265213F, 37.793457F, 47.720028F, 36.6978F, 48.068573F, 35.564423F);
      ((Path)localObject2).lineTo(48.665684F, 33.622784F);
      ((Path)localObject2).lineTo(56.400002F, 31.689205F);
      ((Path)localObject2).lineTo(56.400002F, 28.310795F);
      ((Path)localObject2).lineTo(48.665684F, 26.377216F);
      ((Path)localObject2).lineTo(48.068573F, 24.435577F);
      ((Path)localObject2).cubicTo(47.720028F, 23.3022F, 47.265213F, 22.206543F, 46.710979F, 21.161264F);
      ((Path)localObject2).lineTo(45.758839F, 19.365543F);
      ((Path)localObject2).lineTo(49.862068F, 12.526829F);
      ((Path)localObject2).lineTo(47.473171F, 10.137933F);
      ((Path)localObject2).lineTo(40.634457F, 14.24116F);
      ((Path)localObject2).lineTo(38.838734F, 13.289021F);
      ((Path)localObject2).cubicTo(37.793457F, 12.734787F, 36.6978F, 12.279973F, 35.564423F, 11.931427F);
      ((Path)localObject2).lineTo(33.622784F, 11.334318F);
      ((Path)localObject2).lineTo(31.689205F, 3.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.525154F, 10.108457F);
      ((Path)localObject2).lineTo(46.022694F, 6.809935F);
      ((Path)localObject2).cubicTo(47.203121F, 6.101678F, 48.714096F, 6.287688F, 49.6875F, 7.261093F);
      ((Path)localObject2).lineTo(52.738907F, 10.3125F);
      ((Path)localObject2).cubicTo(53.712311F, 11.285906F, 53.898323F, 12.796881F, 53.190067F, 13.977308F);
      ((Path)localObject2).lineTo(49.891544F, 19.474846F);
      ((Path)localObject2).cubicTo(50.547363F, 20.711716F, 51.091198F, 22.017067F, 51.509537F, 23.377384F);
      ((Path)localObject2).lineTo(57.727608F, 24.931902F);
      ((Path)localObject2).cubicTo(59.063107F, 25.265778F, 60.0F, 26.465727F, 60.0F, 27.842329F);
      ((Path)localObject2).lineTo(60.0F, 32.157669F);
      ((Path)localObject2).cubicTo(60.0F, 33.534275F, 59.063107F, 34.734222F, 57.727608F, 35.0681F);
      ((Path)localObject2).lineTo(51.509537F, 36.622616F);
      ((Path)localObject2).cubicTo(51.091198F, 37.982933F, 50.547363F, 39.288284F, 49.891544F, 40.525154F);
      ((Path)localObject2).lineTo(53.190067F, 46.022694F);
      ((Path)localObject2).cubicTo(53.898323F, 47.203121F, 53.712311F, 48.714096F, 52.738907F, 49.6875F);
      ((Path)localObject2).lineTo(49.6875F, 52.738907F);
      ((Path)localObject2).cubicTo(48.714096F, 53.712311F, 47.203121F, 53.898323F, 46.022694F, 53.190067F);
      ((Path)localObject2).lineTo(40.525154F, 49.891544F);
      ((Path)localObject2).cubicTo(39.288284F, 50.547363F, 37.982933F, 51.091198F, 36.622616F, 51.509537F);
      ((Path)localObject2).lineTo(35.0681F, 57.727608F);
      ((Path)localObject2).cubicTo(34.734222F, 59.063107F, 33.534275F, 60.0F, 32.157669F, 60.0F);
      ((Path)localObject2).lineTo(27.842329F, 60.0F);
      ((Path)localObject2).cubicTo(26.465727F, 60.0F, 25.265778F, 59.063107F, 24.931902F, 57.727608F);
      ((Path)localObject2).lineTo(23.377384F, 51.509537F);
      ((Path)localObject2).cubicTo(22.017067F, 51.091198F, 20.711716F, 50.547363F, 19.474846F, 49.891544F);
      ((Path)localObject2).lineTo(13.977308F, 53.190067F);
      ((Path)localObject2).cubicTo(12.796881F, 53.898323F, 11.285906F, 53.712311F, 10.3125F, 52.738907F);
      ((Path)localObject2).lineTo(7.261093F, 49.6875F);
      ((Path)localObject2).cubicTo(6.287688F, 48.714096F, 6.101678F, 47.203121F, 6.809935F, 46.022694F);
      ((Path)localObject2).lineTo(10.108457F, 40.525154F);
      ((Path)localObject2).cubicTo(9.452636F, 39.288284F, 8.9088F, 37.982933F, 8.490464F, 36.622616F);
      ((Path)localObject2).lineTo(2.272393F, 35.0681F);
      ((Path)localObject2).cubicTo(0.9368921F, 34.734222F, 0.0F, 33.534275F, 0.0F, 32.157669F);
      ((Path)localObject2).lineTo(0.0F, 27.842329F);
      ((Path)localObject2).cubicTo(0.0F, 26.465727F, 0.9368921F, 25.265778F, 2.272393F, 24.931902F);
      ((Path)localObject2).lineTo(8.490464F, 23.377384F);
      ((Path)localObject2).cubicTo(8.9088F, 22.017067F, 9.452636F, 20.711716F, 10.108457F, 19.474846F);
      ((Path)localObject2).lineTo(6.809935F, 13.977308F);
      ((Path)localObject2).cubicTo(6.101678F, 12.796881F, 6.287688F, 11.285906F, 7.261093F, 10.3125F);
      ((Path)localObject2).lineTo(10.3125F, 7.261093F);
      ((Path)localObject2).cubicTo(11.285906F, 6.287688F, 12.796881F, 6.101678F, 13.977308F, 6.809935F);
      ((Path)localObject2).lineTo(19.474846F, 10.108457F);
      ((Path)localObject2).cubicTo(20.711716F, 9.452636F, 22.017067F, 8.9088F, 23.377384F, 8.490464F);
      ((Path)localObject2).lineTo(24.931902F, 2.272393F);
      ((Path)localObject2).cubicTo(25.265778F, 0.9368921F, 26.465727F, 0.0F, 27.842329F, 0.0F);
      ((Path)localObject2).lineTo(32.157669F, 0.0F);
      ((Path)localObject2).cubicTo(33.534275F, 0.0F, 34.734222F, 0.9368921F, 35.0681F, 2.272393F);
      ((Path)localObject2).lineTo(36.622616F, 8.490464F);
      ((Path)localObject2).cubicTo(37.982933F, 8.9088F, 39.288284F, 9.452636F, 40.525154F, 10.108457F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 38.400002F);
      ((Path)localObject2).cubicTo(34.639191F, 38.400002F, 38.400002F, 34.639191F, 38.400002F, 30.0F);
      ((Path)localObject2).cubicTo(38.400002F, 25.360807F, 34.639191F, 21.6F, 30.0F, 21.6F);
      ((Path)localObject2).cubicTo(25.360807F, 21.6F, 21.6F, 25.360807F, 21.6F, 30.0F);
      ((Path)localObject2).cubicTo(21.6F, 34.639191F, 25.360807F, 38.400002F, 30.0F, 38.400002F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 42.0F);
      ((Path)localObject2).cubicTo(23.372583F, 42.0F, 18.0F, 36.627419F, 18.0F, 30.0F);
      ((Path)localObject2).cubicTo(18.0F, 23.372583F, 23.372583F, 18.0F, 30.0F, 18.0F);
      ((Path)localObject2).cubicTo(36.627419F, 18.0F, 42.0F, 23.372583F, 42.0F, 30.0F);
      ((Path)localObject2).cubicTo(42.0F, 36.627419F, 36.627419F, 42.0F, 30.0F, 42.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_setting
 * JD-Core Version:    0.7.0.1
 */