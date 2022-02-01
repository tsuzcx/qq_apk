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

public class app_brand_open_material_filled_more_night
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
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
      localCanvas.saveLayerAlpha(null, 12, 31);
      localCanvas.drawPath(localPath, c.instancePaint(localPaint2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(1291845631);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
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
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_open_material_filled_more_night
 * JD-Core Version:    0.7.0.1
 */