package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_filled_follow
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(50.244003F, 56.653404F);
      ((Path)localObject).lineTo(64.842178F, 42.055225F);
      ((Path)localObject).lineTo(68.519127F, 45.732174F);
      ((Path)localObject).lineTo(51.608696F, 62.637745F);
      ((Path)localObject).cubicTo(50.98391F, 63.262634F, 50.013988F, 63.331936F, 49.312534F, 62.845852F);
      ((Path)localObject).lineTo(49.063271F, 62.637218F);
      ((Path)localObject).lineTo(49.063271F, 62.637218F);
      ((Path)localObject).lineTo(40.614532F, 54.183941F);
      ((Path)localObject).lineTo(44.194534F, 50.603939F);
      ((Path)localObject).lineTo(50.244003F, 56.653404F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.700001F, 9.0F);
      ((Path)localObject).cubicTo(42.327415F, 9.0F, 47.700001F, 14.378941F, 47.700001F, 21.000622F);
      ((Path)localObject).lineTo(47.700001F, 26.130558F);
      ((Path)localObject).cubicTo(47.700001F, 29.547888F, 45.902798F, 34.448582F, 43.704262F, 37.054718F);
      ((Path)localObject).lineTo(42.619663F, 38.340397F);
      ((Path)localObject).cubicTo(41.160698F, 40.069851F, 41.281265F, 42.188492F, 42.756573F, 43.554497F);
      ((Path)localObject).lineTo(36.373032F, 49.940159F);
      ((Path)localObject).cubicTo(34.031471F, 52.284F, 34.030964F, 56.082111F, 36.371891F, 58.426579F);
      ((Path)localObject).lineTo(40.941002F, 63.0F);
      ((Path)localObject).lineTo(10.204288F, 63.0F);
      ((Path)localObject).cubicTo(8.545066F, 63.0F, 7.2F, 61.667267F, 7.2F, 60.004684F);
      ((Path)localObject).lineTo(7.2F, 57.946388F);
      ((Path)localObject).cubicTo(7.2F, 55.891125F, 8.694452F, 53.495724F, 10.542293F, 52.593998F);
      ((Path)localObject).lineTo(27.523352F, 44.30743F);
      ((Path)localObject).cubicTo(29.986132F, 43.105621F, 30.558777F, 40.443787F, 28.780336F, 38.335918F);
      ((Path)localObject).lineTo(27.695738F, 37.050415F);
      ((Path)localObject).cubicTo(25.488953F, 34.434856F, 23.700001F, 29.548489F, 23.700001F, 26.127872F);
      ((Path)localObject).lineTo(23.700001F, 20.998741F);
      ((Path)localObject).cubicTo(23.700001F, 14.37202F, 29.086069F, 9.0F, 35.700001F, 9.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_follow
 * JD-Core Version:    0.7.0.1
 */