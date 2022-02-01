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

public class app_brand_open_material_filled_more_normal
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -343.0F, 0.0F, 1.0F, -36.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 331.0F, 0.0F, 1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-526345);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 16.0F);
      localPath.cubicTo(0.0F, 7.163444F, 7.163444F, 0.0F, 16.0F, 0.0F);
      localPath.lineTo(16.0F, 0.0F);
      localPath.cubicTo(24.836555F, 0.0F, 32.0F, 7.163444F, 32.0F, 16.0F);
      localPath.lineTo(32.0F, 16.0F);
      localPath.cubicTo(32.0F, 24.836555F, 24.836555F, 32.0F, 16.0F, 32.0F);
      localPath.lineTo(16.0F, 32.0F);
      localPath.cubicTo(7.163444F, 32.0F, 0.0F, 24.836555F, 0.0F, 16.0F);
      localPath.lineTo(0.0F, 16.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(1275068416);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(4.583334F, 9.166667F);
      ((Path)localObject2).cubicTo(5.5957F, 9.166667F, 6.416667F, 9.987267F, 6.416667F, 11.0F);
      ((Path)localObject2).cubicTo(6.416667F, 12.012366F, 5.5957F, 12.833333F, 4.583334F, 12.833333F);
      ((Path)localObject2).cubicTo(3.570967F, 12.833333F, 2.75F, 12.012366F, 2.75F, 11.0F);
      ((Path)localObject2).cubicTo(2.75F, 9.987267F, 3.570967F, 9.166667F, 4.583334F, 9.166667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.0F, 9.166667F);
      ((Path)localObject2).cubicTo(12.012366F, 9.166667F, 12.833333F, 9.987267F, 12.833333F, 11.0F);
      ((Path)localObject2).cubicTo(12.833333F, 12.012366F, 12.012366F, 12.833333F, 11.0F, 12.833333F);
      ((Path)localObject2).cubicTo(9.987634F, 12.833333F, 9.166667F, 12.012366F, 9.166667F, 11.0F);
      ((Path)localObject2).cubicTo(9.166667F, 9.987267F, 9.987634F, 9.166667F, 11.0F, 9.166667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.416666F, 9.166667F);
      ((Path)localObject2).cubicTo(18.429033F, 9.166667F, 19.25F, 9.987267F, 19.25F, 11.0F);
      ((Path)localObject2).cubicTo(19.25F, 12.012366F, 18.429033F, 12.833333F, 17.416666F, 12.833333F);
      ((Path)localObject2).cubicTo(16.404301F, 12.833333F, 15.583333F, 12.012366F, 15.583333F, 11.0F);
      ((Path)localObject2).cubicTo(15.583333F, 9.987267F, 16.404301F, 9.166667F, 17.416666F, 9.166667F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_open_material_filled_more_normal
 * JD-Core Version:    0.7.0.1
 */