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

public final class io
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-36352);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(15.346995F, 0.57833F);
      localPath.cubicTo(22.18465F, -1.173255F, 29.903292F, 1.138837F, 34.658615F, 6.363563F);
      localPath.cubicTo(39.944534F, 11.888561F, 41.47625F, 20.57642F, 38.492908F, 27.612785F);
      localPath.cubicTo(35.00901F, 36.751053F, 24.086781F, 42.075871F, 14.7263F, 39.233299F);
      localPath.cubicTo(7.257939F, 37.361607F, 1.38136F, 30.705584F, 0.2901382F, 23.098701F);
      localPath.cubicTo(-1.531902F, 13.179729F, 5.435899F, 2.640195F, 15.346995F, 0.57833F);
      localPath.lineTo(15.346995F, 0.57833F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-70474);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(13.42649F, 0.627618F);
      ((Path)localObject2).cubicTo(22.175201F, -1.891849F, 32.143734F, 3.427025F, 34.983315F, 12.055199F);
      ((Path)localObject2).cubicTo(37.472946F, 18.893751F, 35.273273F, 27.092016F, 29.664099F, 31.721035F);
      ((Path)localObject2).cubicTo(23.984934F, 36.70998F, 15.086246F, 37.41983F, 8.687188F, 33.410679F);
      ((Path)localObject2).cubicTo(2.728066F, 29.891422F, -0.7814165F, 22.712942F, 0.148447F, 15.854395F);
      ((Path)localObject2).cubicTo(0.9183331F, 8.685912F, 6.447518F, 2.377248F, 13.42649F, 0.627618F);
      ((Path)localObject2).lineTo(13.42649F, 0.627618F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-36352);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(15.025599F, 27.656855F);
      ((Path)localObject1).lineTo(15.003011F, 27.679443F);
      ((Path)localObject1).lineTo(17.831438F, 30.50787F);
      ((Path)localObject1).lineTo(31.450668F, 16.888639F);
      ((Path)localObject1).lineTo(28.622242F, 14.060212F);
      ((Path)localObject1).lineTo(17.854027F, 24.828426F);
      ((Path)localObject1).lineTo(11.996721F, 18.971123F);
      ((Path)localObject1).lineTo(9.168295F, 21.799549F);
      ((Path)localObject1).lineTo(15.025599F, 27.656855F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.io
 * JD-Core Version:    0.7.0.1
 */