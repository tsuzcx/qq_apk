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

public class webview_keep_banner_icon
  extends c
{
  private final int height = 67;
  private final int width = 84;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 84;
      return 67;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-9538696);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(66.830002F, 3.1693F);
      ((Path)localObject2).cubicTo(66.650002F, 2.9883F, 66.452003F, 2.8253F, 66.238998F, 2.6813F);
      ((Path)localObject2).cubicTo(65.814003F, 2.3943F, 65.331001F, 2.1873F, 64.810997F, 2.0813F);
      ((Path)localObject2).cubicTo(64.551003F, 2.0283F, 64.281998F, 2.0003F, 64.005997F, 2.0003F);
      ((Path)localObject2).lineTo(19.993999F, 2.0003F);
      ((Path)localObject2).cubicTo(19.443001F, 2.0003F, 18.917999F, 2.1123F, 18.440001F, 2.3143F);
      ((Path)localObject2).cubicTo(17.007F, 2.9213F, 16.0F, 4.3433F, 16.0F, 6.0003F);
      ((Path)localObject2).lineTo(16.0F, 60.999298F);
      ((Path)localObject2).cubicTo(16.0F, 63.216301F, 17.788F, 65.000298F, 19.993999F, 65.000298F);
      ((Path)localObject2).lineTo(64.005997F, 65.000298F);
      ((Path)localObject2).cubicTo(66.209999F, 65.000298F, 68.0F, 63.209301F, 68.0F, 60.999298F);
      ((Path)localObject2).lineTo(68.0F, 6.0003F);
      ((Path)localObject2).cubicTo(68.0F, 4.8923F, 67.553001F, 3.8923F, 66.830002F, 3.1693F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(65.0F, 60.999298F);
      ((Path)localObject2).cubicTo(65.0F, 61.5513F, 64.554001F, 62.000301F, 64.005997F, 62.000301F);
      ((Path)localObject2).lineTo(19.993999F, 62.000301F);
      ((Path)localObject2).cubicTo(19.445999F, 62.000301F, 19.0F, 61.5513F, 19.0F, 60.999298F);
      ((Path)localObject2).lineTo(19.0F, 6.0003F);
      ((Path)localObject2).cubicTo(19.0F, 5.5093F, 19.329F, 5.1963F, 19.611F, 5.0763F);
      ((Path)localObject2).cubicTo(19.731001F, 5.0253F, 19.860001F, 5.0003F, 19.993999F, 5.0003F);
      ((Path)localObject2).lineTo(64.005997F, 5.0003F);
      ((Path)localObject2).cubicTo(64.075996F, 5.0003F, 64.144997F, 5.0073F, 64.210999F, 5.0203F);
      ((Path)localObject2).cubicTo(64.335999F, 5.0463F, 64.453003F, 5.0953F, 64.559998F, 5.1673F);
      ((Path)localObject2).cubicTo(64.612999F, 5.2033F, 64.663002F, 5.2443F, 64.708F, 5.2903F);
      ((Path)localObject2).cubicTo(64.841003F, 5.4233F, 65.0F, 5.6543F, 65.0F, 6.0003F);
      ((Path)localObject2).lineTo(65.0F, 60.999298F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(27.0F, 12.0F);
      ((Path)localObject2).cubicTo(25.342501F, 12.0F, 24.0F, 13.3425F, 24.0F, 15.0F);
      ((Path)localObject2).cubicTo(24.0F, 16.657499F, 25.342501F, 18.0F, 27.0F, 18.0F);
      ((Path)localObject2).cubicTo(28.657499F, 18.0F, 30.0F, 16.657499F, 30.0F, 15.0F);
      ((Path)localObject2).cubicTo(30.0F, 13.3425F, 28.657499F, 12.0F, 27.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.0F, 42.0F);
      ((Path)localObject2).lineTo(39.0F, 42.0F);
      ((Path)localObject2).lineTo(39.0F, 45.0F);
      ((Path)localObject2).lineTo(24.0F, 45.0F);
      ((Path)localObject2).lineTo(24.0F, 42.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.0F, 33.0F);
      ((Path)localObject2).lineTo(39.0F, 33.0F);
      ((Path)localObject2).lineTo(39.0F, 36.0F);
      ((Path)localObject2).lineTo(24.0F, 36.0F);
      ((Path)localObject2).lineTo(24.0F, 33.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.0F, 24.0F);
      ((Path)localObject2).lineTo(51.0F, 24.0F);
      ((Path)localObject2).lineTo(51.0F, 27.0F);
      ((Path)localObject2).lineTo(24.0F, 27.0F);
      ((Path)localObject2).lineTo(24.0F, 24.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.webview_keep_banner_icon
 * JD-Core Version:    0.7.0.1
 */