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

public class icons_outlined_htov
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
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -6.123234E-017F, -1.0F, 23.89505F, -1.0F, 6.123234E-017F, 18.24F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.83697E-016F, -1.0F, 17.879999F, -1.0F, 1.83697E-016F, 10.002673F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(3.808108F, 4.609096E-014F);
      localPath.lineTo(3.808636F, 1.650499F);
      localPath.cubicTo(6.658098F, 1.989871F, 9.07661F, 4.056784F, 9.793031F, 6.930193F);
      localPath.cubicTo(9.904462F, 7.377116F, 9.971774F, 7.80363F, 9.994242F, 8.230811F);
      localPath.lineTo(10.002673F, 8.551652F);
      localPath.lineTo(8.322673F, 8.551652F);
      localPath.cubicTo(8.322673F, 8.159072F, 8.270389F, 7.767596F, 8.162934F, 7.336621F);
      localPath.cubicTo(7.634586F, 5.217533F, 5.889025F, 3.674474F, 3.809014F, 3.34632F);
      localPath.lineTo(3.808108F, 5.254784F);
      localPath.lineTo(-8.695267E-013F, 2.627392F);
      localPath.lineTo(3.808108F, 4.609096E-014F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 1.224647E-016F, 10.08F, -1.224647E-016F, -1.0F, 26.670099F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 6.30005F);
      ((Path)localObject).cubicTo(0.0F, 5.67873F, 0.5036796F, 5.17505F, 1.125F, 5.17505F);
      ((Path)localObject).lineTo(8.955F, 5.17505F);
      ((Path)localObject).cubicTo(9.576321F, 5.17505F, 10.08F, 5.67873F, 10.08F, 6.30005F);
      ((Path)localObject).lineTo(10.08F, 20.37005F);
      ((Path)localObject).cubicTo(10.08F, 20.991371F, 9.576321F, 21.49505F, 8.955F, 21.49505F);
      ((Path)localObject).lineTo(1.125F, 21.49505F);
      ((Path)localObject).cubicTo(0.5036796F, 21.49505F, 0.0F, 20.991371F, 0.0F, 20.37005F);
      ((Path)localObject).lineTo(0.0F, 6.30005F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_htov
 * JD-Core Version:    0.7.0.1
 */