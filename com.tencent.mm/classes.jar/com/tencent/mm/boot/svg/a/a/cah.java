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

public final class cah
  extends c
{
  private final int height = 70;
  private final int width = 80;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 70;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.saveLayerAlpha(null, 204, 31);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(37.23F, 0.0F);
      ((Path)localObject).lineTo(41.049999F, 0.0F);
      ((Path)localObject).cubicTo(52.900002F, 0.29F, 64.779999F, 5.01F, 72.739998F, 13.96F);
      ((Path)localObject).cubicTo(59.869999F, 19.690001F, 46.950001F, 25.309999F, 34.09F, 31.059999F);
      ((Path)localObject).cubicTo(32.599998F, 31.58F, 30.870001F, 32.650002F, 29.33F, 31.68F);
      ((Path)localObject).cubicTo(25.68F, 29.77F, 22.780001F, 26.700001F, 19.049999F, 24.940001F);
      ((Path)localObject).cubicTo(18.77F, 25.219999F, 18.219999F, 25.77F, 17.950001F, 26.049999F);
      ((Path)localObject).cubicTo(20.110001F, 31.91F, 22.959999F, 37.529999F, 25.639999F, 43.169998F);
      ((Path)localObject).cubicTo(26.77F, 45.57F, 29.459999F, 44.200001F, 31.07F, 43.18F);
      ((Path)localObject).cubicTo(45.869999F, 34.650002F, 60.700001F, 26.18F, 75.529999F, 17.700001F);
      ((Path)localObject).cubicTo(77.879997F, 21.83F, 79.57F, 26.35F, 80.0F, 31.1F);
      ((Path)localObject).lineTo(80.0F, 34.400002F);
      ((Path)localObject).cubicTo(79.529999F, 43.48F, 74.440002F, 51.869999F, 67.239998F, 57.240002F);
      ((Path)localObject).cubicTo(56.189999F, 65.760002F, 41.099998F, 68.0F, 27.75F, 64.529999F);
      ((Path)localObject).cubicTo(22.08F, 62.869999F, 18.26F, 70.190002F, 12.88F, 69.669998F);
      ((Path)localObject).cubicTo(12.94F, 66.330002F, 14.52F, 63.279999F, 14.9F, 60.0F);
      ((Path)localObject).cubicTo(14.76F, 58.48F, 13.17F, 57.740002F, 12.22F, 56.75F);
      ((Path)localObject).cubicTo(5.34F, 51.41F, 0.51F, 43.259998F, 0.0F, 34.470001F);
      ((Path)localObject).lineTo(0.0F, 31.4F);
      ((Path)localObject).cubicTo(0.54F, 23.870001F, 4.14F, 16.76F, 9.59F, 11.6F);
      ((Path)localObject).cubicTo(16.98F, 4.47F, 27.110001F, 0.76F, 37.23F, 0.0F);
      ((Path)localObject).lineTo(37.23F, 0.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cah
 * JD-Core Version:    0.7.0.1
 */