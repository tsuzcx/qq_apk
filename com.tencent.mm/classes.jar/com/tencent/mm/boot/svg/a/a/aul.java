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

public final class aul
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
      Object localObject = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(3.6F);
      localPath = c.l(paramVarArgs);
      localPath.moveTo(50.391575F, 17.210928F);
      localPath.lineTo(37.490154F, 24.799999F);
      localPath.lineTo(21.0F, 24.799999F);
      localPath.cubicTo(20.337257F, 24.799999F, 19.799999F, 25.337257F, 19.799999F, 26.0F);
      localPath.lineTo(19.799999F, 46.0F);
      localPath.cubicTo(19.799999F, 46.662743F, 20.337257F, 47.200001F, 21.0F, 47.200001F);
      localPath.lineTo(37.490154F, 47.200001F);
      localPath.lineTo(50.391575F, 54.78907F);
      localPath.cubicTo(50.575989F, 54.897549F, 50.786049F, 54.95475F, 51.0F, 54.95475F);
      localPath.cubicTo(51.662743F, 54.95475F, 52.200001F, 54.417492F, 52.200001F, 53.754749F);
      localPath.lineTo(52.200001F, 18.245251F);
      localPath.cubicTo(52.200001F, 18.031298F, 52.142799F, 17.821238F, 52.034321F, 17.636826F);
      localPath.cubicTo(51.698299F, 17.065586F, 50.962814F, 16.874905F, 50.391575F, 17.210928F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, 0.7071068F, -14.464876F, -0.7071068F, 0.7071068F, 37.749733F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(36.535519F, 7.962539F);
      ((Path)localObject).lineTo(40.135517F, 7.962539F);
      ((Path)localObject).lineTo(40.135517F, 64.708496F);
      ((Path)localObject).lineTo(36.535519F, 64.708496F);
      ((Path)localObject).lineTo(36.535519F, 7.962539F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aul
 * JD-Core Version:    0.7.0.1
 */