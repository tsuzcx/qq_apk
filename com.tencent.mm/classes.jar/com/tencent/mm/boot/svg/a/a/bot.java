package com.tencent.mm.boot.svg.a.a;

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

public final class bot
  extends c
{
  private final int height = 94;
  private final int width = 88;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 88;
      return 94;
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 8.0F);
      localPath.cubicTo(0.0F, 3.581722F, 3.581722F, 0.0F, 8.0F, 0.0F);
      localPath.lineTo(80.0F, 0.0F);
      localPath.cubicTo(84.418282F, 0.0F, 88.0F, 3.581722F, 88.0F, 8.0F);
      localPath.lineTo(88.0F, 80.0F);
      localPath.cubicTo(88.0F, 84.418282F, 84.418282F, 88.0F, 80.0F, 88.0F);
      localPath.lineTo(8.0F, 88.0F);
      localPath.cubicTo(3.581722F, 88.0F, 0.0F, 84.418282F, 0.0F, 80.0F);
      localPath.lineTo(0.0F, 8.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 75.112701F, 0.7071068F, 0.7071068F, -5.338093F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(40.0F, 84.0F);
      ((Path)localObject).lineTo(48.0F, 84.0F);
      ((Path)localObject).lineTo(48.0F, 90.0F);
      ((Path)localObject).cubicTo(48.0F, 91.104568F, 47.104568F, 92.0F, 46.0F, 92.0F);
      ((Path)localObject).lineTo(40.0F, 92.0F);
      ((Path)localObject).lineTo(40.0F, 92.0F);
      ((Path)localObject).lineTo(40.0F, 84.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bot
 * JD-Core Version:    0.7.0.1
 */