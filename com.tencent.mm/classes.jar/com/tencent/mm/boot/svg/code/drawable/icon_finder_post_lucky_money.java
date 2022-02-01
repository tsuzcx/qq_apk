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

public class icon_finder_post_lucky_money
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.0F, 6.041652F);
      ((Path)localObject2).cubicTo(4.424702F, 6.041652F, 3.958333F, 5.575284F, 3.958333F, 4.999986F);
      ((Path)localObject2).cubicTo(3.958333F, 4.424688F, 4.424702F, 3.958319F, 5.0F, 3.958319F);
      ((Path)localObject2).cubicTo(5.575298F, 3.958319F, 6.041667F, 4.424688F, 6.041667F, 4.999986F);
      ((Path)localObject2).cubicTo(6.041667F, 5.575284F, 5.575298F, 6.041652F, 5.0F, 6.041652F);
      ((Path)localObject2).moveTo(10.0F, 0.9679613F);
      ((Path)localObject2).cubicTo(10.0F, 0.433371F, 9.544335F, 4.081754E-013F, 9.004602F, 3.836365E-013F);
      ((Path)localObject2).lineTo(0.9953976F, 1.949851E-014F);
      ((Path)localObject2).cubicTo(0.4456547F, -5.495514E-015F, 1.046526E-014F, 0.4386666F, 2.309264E-014F, 0.9679613F);
      ((Path)localObject2).lineTo(2.309264E-014F, 0.9679613F);
      ((Path)localObject2).cubicTo(2.309264E-014F, 2.730402F, 1.527857F, 4.216076F, 3.615429F, 4.680278F);
      ((Path)localObject2).cubicTo(3.587714F, 4.792049F, 3.571429F, 4.908279F, 3.571429F, 5.02868F);
      ((Path)localObject2).cubicTo(3.571429F, 5.076438F, 3.574F, 5.123621F, 3.578571F, 5.170228F);
      ((Path)localObject2).cubicTo(2.200429F, 4.954454F, 0.9662857F, 4.430987F, 2.309264E-014F, 3.696493F);
      ((Path)localObject2).lineTo(4.353626E-014F, 11.490126F);
      ((Path)localObject2).cubicTo(4.499927E-014F, 12.047864F, 0.455664F, 12.5F, 0.9953976F, 12.5F);
      ((Path)localObject2).lineTo(9.004602F, 12.5F);
      ((Path)localObject2).cubicTo(9.554345F, 12.5F, 10.0F, 12.05133F, 10.0F, 11.490126F);
      ((Path)localObject2).lineTo(10.0F, 3.696493F);
      ((Path)localObject2).cubicTo(9.033714F, 4.430987F, 7.799572F, 4.954454F, 6.421429F, 5.170228F);
      ((Path)localObject2).cubicTo(6.426F, 5.123621F, 6.428571F, 5.076438F, 6.428571F, 5.02868F);
      ((Path)localObject2).cubicTo(6.428571F, 4.908279F, 6.412286F, 4.792049F, 6.384572F, 4.680278F);
      ((Path)localObject2).cubicTo(8.472143F, 4.216076F, 10.0F, 2.730402F, 10.0F, 0.9679613F);
      ((Path)localObject2).lineTo(10.0F, 0.9679613F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_finder_post_lucky_money
 * JD-Core Version:    0.7.0.1
 */