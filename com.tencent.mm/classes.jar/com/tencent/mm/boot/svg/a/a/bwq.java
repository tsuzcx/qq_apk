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

public final class bwq
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 168;
    switch (paramInt)
    {
    }
    for (;;)
    {
      i = 0;
      return i;
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-983041);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 30.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.468225F, 59.379959F);
      ((Path)localObject).cubicTo(-0.09250131F, 58.791977F, -0.1575292F, 57.778301F, 0.3160322F, 57.125431F);
      ((Path)localObject).lineTo(6.444848F, 48.676014F);
      ((Path)localObject).cubicTo(6.921521F, 48.018856F, 7.825557F, 47.888081F, 8.465721F, 48.385208F);
      ((Path)localObject).lineTo(44.835701F, 76.628586F);
      ((Path)localObject).cubicTo(45.475124F, 77.125137F, 46.492798F, 77.106209F, 47.11644F, 76.579811F);
      ((Path)localObject).lineTo(135.63168F, 1.866295F);
      ((Path)localObject).cubicTo(136.25188F, 1.342807F, 137.22249F, 1.386573F, 137.79367F, 1.95812F);
      ((Path)localObject).lineTo(143.57062F, 7.738701F);
      ((Path)localObject).cubicTo(144.14445F, 8.312903F, 144.14244F, 9.244253F, 143.56883F, 9.816217F);
      ((Path)localObject).lineTo(47.031418F, 106.07728F);
      ((Path)localObject).cubicTo(46.456593F, 106.65046F, 45.537498F, 106.63998F, 44.975323F, 106.05048F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bwq
 * JD-Core Version:    0.7.0.1
 */