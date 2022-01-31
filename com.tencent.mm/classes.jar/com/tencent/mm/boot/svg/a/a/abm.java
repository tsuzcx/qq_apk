package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class abm
  extends c
{
  private final int height = 138;
  private final int width = 138;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 138;
      return 138;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-13917627);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(138.0F, 0.0F);
      localPath.lineTo(138.0F, 138.0F);
      localPath.lineTo(0.0F, 138.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(50.543278F, 90.04454F);
      ((Path)localObject).lineTo(53.041294F, 91.676292F);
      ((Path)localObject).cubicTo(57.280224F, 94.445251F, 62.879478F, 95.920822F, 69.519997F, 95.920822F);
      ((Path)localObject).cubicTo(87.804558F, 95.920822F, 102.0F, 83.834961F, 102.0F, 68.504669F);
      ((Path)localObject).cubicTo(102.0F, 52.329258F, 87.460373F, 39.0F, 69.519997F, 39.0F);
      ((Path)localObject).cubicTo(50.677761F, 39.0F, 36.0F, 52.210297F, 36.0F, 68.504669F);
      ((Path)localObject).cubicTo(36.0F, 73.425583F, 37.425579F, 77.221039F, 41.231678F, 82.927864F);
      ((Path)localObject).lineTo(42.857769F, 85.366013F);
      ((Path)localObject).lineTo(40.056149F, 93.805267F);
      ((Path)localObject).lineTo(50.543278F, 90.04454F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.200001F, 101.92082F);
      ((Path)localObject).cubicTo(32.567047F, 102.34957F, 31.283272F, 100.9991F, 32.080002F, 98.788063F);
      ((Path)localObject).lineTo(36.240002F, 86.257004F);
      ((Path)localObject).cubicTo(32.320972F, 80.380844F, 30.0F, 75.340508F, 30.0F, 68.504669F);
      ((Path)localObject).cubicTo(30.0F, 48.779522F, 47.461079F, 33.0F, 69.519997F, 33.0F);
      ((Path)localObject).cubicTo(90.538918F, 33.0F, 108.0F, 48.779522F, 108.0F, 68.504669F);
      ((Path)localObject).cubicTo(108.0F, 87.70929F, 90.538918F, 101.92082F, 69.519997F, 101.92082F);
      ((Path)localObject).cubicTo(61.798603F, 101.92082F, 55.053051F, 100.15708F, 49.759998F, 96.699547F);
      ((Path)localObject).lineTo(35.200001F, 101.92082F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abm
 * JD-Core Version:    0.7.0.1
 */