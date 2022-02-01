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

public class icons_outlined_bottle
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
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(37.997719F, 34.5F);
      ((Path)localObject2).lineTo(42.194859F, 30.302864F);
      ((Path)localObject2).cubicTo(42.644943F, 29.852776F, 42.8978F, 29.242327F, 42.8978F, 28.605808F);
      ((Path)localObject2).lineTo(42.8978F, 18.993319F);
      ((Path)localObject2).lineTo(50.952572F, 10.938545F);
      ((Path)localObject2).lineTo(47.55846F, 7.544433F);
      ((Path)localObject2).lineTo(39.503689F, 15.599206F);
      ((Path)localObject2).lineTo(29.891199F, 15.599206F);
      ((Path)localObject2).cubicTo(29.254679F, 15.599206F, 28.64423F, 15.852062F, 28.194143F, 16.302149F);
      ((Path)localObject2).lineTo(9.996292F, 34.5F);
      ((Path)localObject2).lineTo(22.5F, 34.5F);
      ((Path)localObject2).lineTo(22.5F, 38.099991F);
      ((Path)localObject2).lineTo(0.0F, 38.099991F);
      ((Path)localObject2).lineTo(0.0F, 34.5F);
      ((Path)localObject2).lineTo(4.920025F, 34.5F);
      ((Path)localObject2).cubicTo(4.987604F, 34.422539F, 5.058281F, 34.346844F, 5.132054F, 34.273071F);
      ((Path)localObject2).lineTo(25.648558F, 13.756565F);
      ((Path)localObject2).cubicTo(26.773777F, 12.631347F, 28.2999F, 11.999206F, 29.891199F, 11.999206F);
      ((Path)localObject2).lineTo(38.01252F, 11.999206F);
      ((Path)localObject2).lineTo(45.437141F, 4.574585F);
      ((Path)localObject2).lineTo(43.315819F, 2.453264F);
      ((Path)localObject2).lineTo(44.37648F, 1.392604F);
      ((Path)localObject2).cubicTo(44.962265F, 0.8068177F, 45.912014F, 0.8068177F, 46.497799F, 1.392604F);
      ((Path)localObject2).lineTo(57.104401F, 11.999206F);
      ((Path)localObject2).cubicTo(57.690189F, 12.584992F, 57.690189F, 13.534739F, 57.104401F, 14.120526F);
      ((Path)localObject2).lineTo(56.043743F, 15.181187F);
      ((Path)localObject2).lineTo(53.922421F, 13.059866F);
      ((Path)localObject2).lineTo(46.497799F, 20.484488F);
      ((Path)localObject2).lineTo(46.497799F, 28.605808F);
      ((Path)localObject2).cubicTo(46.497799F, 30.197107F, 45.865658F, 31.72323F, 44.74044F, 32.84845F);
      ((Path)localObject2).lineTo(43.08889F, 34.5F);
      ((Path)localObject2).lineTo(49.5F, 34.5F);
      ((Path)localObject2).lineTo(49.5F, 38.099991F);
      ((Path)localObject2).lineTo(31.5F, 38.099991F);
      ((Path)localObject2).lineTo(31.5F, 34.5F);
      ((Path)localObject2).lineTo(37.997719F, 34.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(34.5F, 49.5F);
      ((Path)localObject2).lineTo(48.0F, 49.5F);
      ((Path)localObject2).lineTo(48.0F, 53.099991F);
      ((Path)localObject2).lineTo(34.5F, 53.099991F);
      ((Path)localObject2).lineTo(34.5F, 49.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.5F, 42.0F);
      ((Path)localObject2).lineTo(37.5F, 42.0F);
      ((Path)localObject2).lineTo(37.5F, 45.599991F);
      ((Path)localObject2).lineTo(25.5F, 45.599991F);
      ((Path)localObject2).lineTo(25.5F, 42.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 42.0F);
      ((Path)localObject2).lineTo(18.0F, 42.0F);
      ((Path)localObject2).lineTo(18.0F, 45.599991F);
      ((Path)localObject2).lineTo(12.0F, 45.599991F);
      ((Path)localObject2).lineTo(12.0F, 42.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_bottle
 * JD-Core Version:    0.7.0.1
 */