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

public class wallet_wxcredit_success
  extends c
{
  private final int height = 240;
  private final int width = 240;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 240;
      return 240;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15879408);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(95.550003F, 0.86F);
      ((Path)localObject2).cubicTo(119.32F, -2.19F, 144.07001F, 2.98F, 164.58F, 15.41F);
      ((Path)localObject2).cubicTo(186.83F, 28.719999F, 204.03F, 50.299999F, 211.85001F, 75.040001F);
      ((Path)localObject2).cubicTo(219.42999F, 98.529999F, 218.59F, 124.63F, 209.5F, 147.57001F);
      ((Path)localObject2).cubicTo(199.91F, 172.10001F, 180.97F, 192.78999F, 157.39999F, 204.55F);
      ((Path)localObject2).cubicTo(134.64999F, 216.07001F, 107.76F, 218.98F, 83.029999F, 212.84F);
      ((Path)localObject2).cubicTo(56.389999F, 206.36F, 32.599998F, 189.17999F, 17.92F, 166.03F);
      ((Path)localObject2).cubicTo(4.3F, 144.85001F, -1.44F, 118.78F, 1.94F, 93.839996F);
      ((Path)localObject2).cubicTo(4.98F, 69.989998F, 16.41F, 47.369999F, 33.669998F, 30.65F);
      ((Path)localObject2).cubicTo(50.330002F, 14.34F, 72.389999F, 3.65F, 95.550003F, 0.86F);
      ((Path)localObject2).lineTo(95.550003F, 0.86F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(158.3F, 71.290001F);
      ((Path)localObject2).cubicTo(138.2F, 94.330002F, 118.23F, 117.5F, 98.190002F, 140.60001F);
      ((Path)localObject2).cubicTo(88.050003F, 130.48F, 77.910004F, 120.35F, 67.790001F, 110.2F);
      ((Path)localObject2).cubicTo(66.690002F, 109.14F, 65.529999F, 108.0F, 63.959999F, 107.72F);
      ((Path)localObject2).cubicTo(58.369999F, 106.48F, 52.709999F, 114.39F, 57.259998F, 118.78F);
      ((Path)localObject2).cubicTo(69.360001F, 131.0F, 81.57F, 143.12F, 93.730003F, 155.3F);
      ((Path)localObject2).cubicTo(96.07F, 158.10001F, 100.88F, 158.17999F, 103.15F, 155.25999F);
      ((Path)localObject2).cubicTo(124.54F, 130.60001F, 145.89999F, 105.9F, 167.3F, 81.25F);
      ((Path)localObject2).cubicTo(168.06F, 80.260002F, 168.99001F, 79.309998F, 169.25F, 78.040001F);
      ((Path)localObject2).cubicTo(170.72F, 72.43F, 162.64F, 66.639999F, 158.3F, 71.290001F);
      ((Path)localObject2).lineTo(158.3F, 71.290001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wallet_wxcredit_success
 * JD-Core Version:    0.7.0.1
 */