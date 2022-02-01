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

public class finder_icons_outlined_max_window
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.0F, 14.0F);
      ((Path)localObject2).lineTo(18.0F, 18.0F);
      ((Path)localObject2).cubicTo(18.0F, 18.552284F, 17.552284F, 19.0F, 17.0F, 19.0F);
      ((Path)localObject2).lineTo(13.0F, 19.0F);
      ((Path)localObject2).lineTo(13.0F, 17.799999F);
      ((Path)localObject2).lineTo(16.799999F, 17.799999F);
      ((Path)localObject2).lineTo(16.799999F, 14.0F);
      ((Path)localObject2).lineTo(18.0F, 14.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.0F, 1.0F);
      ((Path)localObject2).lineTo(5.0F, 2.2F);
      ((Path)localObject2).lineTo(1.2F, 2.2F);
      ((Path)localObject2).lineTo(1.2F, 6.0F);
      ((Path)localObject2).lineTo(0.0F, 6.0F);
      ((Path)localObject2).lineTo(0.0F, 2.0F);
      ((Path)localObject2).cubicTo(0.0F, 1.447715F, 0.4477153F, 1.0F, 1.0F, 1.0F);
      ((Path)localObject2).lineTo(5.0F, 1.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.796854F, 3.045626F);
      ((Path)localObject2).lineTo(11.32492F, 8.517561F);
      ((Path)localObject2).lineTo(10.476392F, 7.669033F);
      ((Path)localObject2).lineTo(15.948318F, 2.197107F);
      ((Path)localObject2).lineTo(12.996855F, 2.197107F);
      ((Path)localObject2).lineTo(12.996855F, 0.9971068F);
      ((Path)localObject2).lineTo(16.996855F, 0.9971068F);
      ((Path)localObject2).cubicTo(17.549139F, 0.9971068F, 17.996855F, 1.444822F, 17.996855F, 1.997107F);
      ((Path)localObject2).lineTo(17.996855F, 5.997107F);
      ((Path)localObject2).lineTo(16.796854F, 5.997107F);
      ((Path)localObject2).lineTo(16.796854F, 3.045626F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(1.203146F, 16.954374F);
      ((Path)localObject2).lineTo(6.67508F, 11.482439F);
      ((Path)localObject2).lineTo(7.523608F, 12.330968F);
      ((Path)localObject2).lineTo(2.051683F, 17.802893F);
      ((Path)localObject2).lineTo(5.003146F, 17.802893F);
      ((Path)localObject2).lineTo(5.003146F, 19.002893F);
      ((Path)localObject2).lineTo(1.003146F, 19.002893F);
      ((Path)localObject2).cubicTo(0.4508609F, 19.002893F, 0.003145598F, 18.555178F, 0.003145598F, 18.002893F);
      ((Path)localObject2).lineTo(0.003145598F, 14.002893F);
      ((Path)localObject2).lineTo(1.203146F, 14.002893F);
      ((Path)localObject2).lineTo(1.203146F, 16.954374F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icons_outlined_max_window
 * JD-Core Version:    0.7.0.1
 */