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

public final class blq
  extends c
{
  private final int height = 34;
  private final int width = 28;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 28;
      return 34;
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -39.0F, 0.0F, 1.0F, -37.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 33.0F, 0.0F, 1.0F, 34.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(10.57191F, 29.428091F);
      localPath.cubicTo(8.159051F, 27.015232F, 6.666667F, 23.681898F, 6.666667F, 20.0F);
      localPath.cubicTo(6.666667F, 12.636204F, 12.636204F, 6.666667F, 20.0F, 6.666667F);
      localPath.lineTo(20.0F, 8.666667F);
      localPath.cubicTo(13.740773F, 8.666667F, 8.666667F, 13.740773F, 8.666667F, 20.0F);
      localPath.cubicTo(8.666667F, 23.048483F, 9.87313F, 25.900885F, 11.986123F, 28.013876F);
      localPath.moveTo(20.0F, 31.333334F);
      localPath.cubicTo(26.259228F, 31.333334F, 31.333334F, 26.259228F, 31.333334F, 20.0F);
      localPath.cubicTo(31.333334F, 16.951517F, 30.126869F, 14.099116F, 28.013876F, 11.986123F);
      localPath.lineTo(29.428091F, 10.57191F);
      localPath.cubicTo(31.84095F, 12.984768F, 33.333332F, 16.318102F, 33.333332F, 20.0F);
      localPath.cubicTo(33.333332F, 27.363796F, 27.363796F, 33.333332F, 20.0F, 33.333332F);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, -0.7071068F, -0.7071068F, 36.499157F, -0.7071068F, 0.7071068F, 15.118446F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(16.714045F, 6.714046F);
      localPath.lineTo(16.714045F, 11.380712F);
      localPath.lineTo(14.714046F, 11.380712F);
      localPath.lineTo(14.714046F, 6.714046F);
      localPath.lineTo(14.714046F, 5.214045F);
      localPath.cubicTo(14.714046F, 4.937903F, 14.937902F, 4.714045F, 15.214046F, 4.714045F);
      localPath.lineTo(21.380713F, 4.714045F);
      localPath.lineTo(21.380713F, 6.714046F);
      localPath.lineTo(16.714045F, 6.714046F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, 0.7071068F, -16.161968F, -0.7071068F, 0.7071068F, 24.876308F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(20.614046F, 30.614046F);
      ((Path)localObject).lineTo(20.614046F, 35.280712F);
      ((Path)localObject).lineTo(18.614046F, 35.280712F);
      ((Path)localObject).lineTo(18.614046F, 30.614046F);
      ((Path)localObject).lineTo(18.614046F, 29.114046F);
      ((Path)localObject).cubicTo(18.614046F, 28.837904F, 18.837904F, 28.614046F, 19.114046F, 28.614046F);
      ((Path)localObject).lineTo(25.280712F, 28.614046F);
      ((Path)localObject).lineTo(25.280712F, 30.614046F);
      ((Path)localObject).lineTo(20.614046F, 30.614046F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.blq
 * JD-Core Version:    0.7.0.1
 */