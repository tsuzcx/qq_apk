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

public class poi_navigation
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
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 11.171573F, 0.7071068F, 0.7071068F, -6.970563F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(14.464238F, 1.160596F);
      ((Path)localObject).lineTo(21.408022F, 18.520058F);
      ((Path)localObject).cubicTo(21.51058F, 18.776449F, 21.385872F, 19.067434F, 21.12948F, 19.169991F);
      ((Path)localObject).cubicTo(20.977533F, 19.230768F, 20.805462F, 19.213343F, 20.668787F, 19.123337F);
      ((Path)localObject).lineTo(14.0F, 14.731639F);
      ((Path)localObject).lineTo(14.0F, 14.731639F);
      ((Path)localObject).lineTo(7.331214F, 19.123337F);
      ((Path)localObject).cubicTo(7.100588F, 19.275213F, 6.790509F, 19.211374F, 6.638632F, 18.980749F);
      ((Path)localObject).cubicTo(6.548625F, 18.844074F, 6.531199F, 18.672003F, 6.591977F, 18.520058F);
      ((Path)localObject).lineTo(13.535762F, 1.160596F);
      ((Path)localObject).cubicTo(13.638318F, 0.9042041F, 13.929303F, 0.7794961F, 14.185696F, 0.8820528F);
      ((Path)localObject).cubicTo(14.312747F, 0.9328734F, 14.413418F, 1.033545F, 14.464238F, 1.160596F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.poi_navigation
 * JD-Core Version:    0.7.0.1
 */