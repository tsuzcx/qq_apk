package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class bvd
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 4.5F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setStrokeWidth(1.2F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.6F, 9.0F);
      localPath.cubicTo(0.6F, 4.360808F, 4.360808F, 0.6F, 9.0F, 0.6F);
      localPath.lineTo(13.0F, 0.6F);
      localPath.cubicTo(17.639193F, 0.6F, 21.4F, 4.360808F, 21.4F, 9.0F);
      localPath.lineTo(21.4F, 9.0F);
      localPath.cubicTo(21.4F, 13.639193F, 17.639193F, 17.4F, 13.0F, 17.4F);
      localPath.lineTo(9.0F, 17.4F);
      localPath.cubicTo(4.360808F, 17.4F, 0.6F, 13.639193F, 0.6F, 9.0F);
      localPath.lineTo(0.6F, 9.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 9.585787F, 0.7071068F, 0.7071068F, -5.142135F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(7.5F, 8.833333F);
      ((Path)localObject).lineTo(7.5F, 9.166667F);
      ((Path)localObject).lineTo(10.833333F, 9.166667F);
      ((Path)localObject).lineTo(10.833333F, 12.5F);
      ((Path)localObject).lineTo(11.166667F, 12.5F);
      ((Path)localObject).lineTo(11.166667F, 9.166667F);
      ((Path)localObject).lineTo(14.5F, 9.166667F);
      ((Path)localObject).lineTo(14.5F, 8.833333F);
      ((Path)localObject).lineTo(11.166667F, 8.833333F);
      ((Path)localObject).lineTo(11.166667F, 5.5F);
      ((Path)localObject).lineTo(10.833333F, 5.5F);
      ((Path)localObject).lineTo(10.833333F, 8.833333F);
      ((Path)localObject).lineTo(7.5F, 8.833333F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bvd
 * JD-Core Version:    0.7.0.1
 */