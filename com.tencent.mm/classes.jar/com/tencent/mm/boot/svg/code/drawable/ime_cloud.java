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

public class ime_cloud
  extends c
{
  private final int height = 14;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 14;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -139.0F, 0.0F, 1.0F, -978.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 915.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 119.0F, 0.0F, 1.0F, 63.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-13421773);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.881187F, 3.538424F);
      ((Path)localObject2).lineTo(14.881187F, 3.538424F);
      ((Path)localObject2).cubicTo(17.706663F, 3.541414F, 19.996592F, 5.880809F, 20.0F, 8.76786F);
      ((Path)localObject2).cubicTo(20.0F, 11.454464F, 17.999907F, 13.687124F, 15.419263F, 13.964733F);
      ((Path)localObject2).lineTo(4.273638F, 14.0F);
      ((Path)localObject2).lineTo(4.273638F, 14.0F);
      ((Path)localObject2).cubicTo(1.914246F, 13.997009F, 0.002438922F, 12.043148F, 0.0F, 9.632352F);
      ((Path)localObject2).lineTo(0.0F, 9.632319F);
      ((Path)localObject2).cubicTo(0.002701322F, 7.324626F, 1.760211F, 5.41643F, 4.014378F, 5.273737F);
      ((Path)localObject2).lineTo(4.014378F, 5.273737F);
      ((Path)localObject2).cubicTo(4.154934F, 2.322929F, 6.535665F, 0.003272704F, 9.426978F, 0.0F);
      ((Path)localObject2).lineTo(9.426978F, 0.0F);
      ((Path)localObject2).cubicTo(11.668377F, 0.008892642F, 13.67539F, 1.420439F, 14.483834F, 3.556513F);
      ((Path)localObject2).cubicTo(14.621008F, 3.544758F, 14.751102F, 3.538428F, 14.881196F, 3.538428F);
      ((Path)localObject2).lineTo(14.881187F, 3.538424F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.426964F, 1.712691F);
      ((Path)localObject2).lineTo(9.426964F, 1.712691F);
      ((Path)localObject2).cubicTo(7.360623F, 1.715183F, 5.686274F, 3.426416F, 5.68432F, 5.537776F);
      ((Path)localObject2).lineTo(5.68432F, 6.978288F);
      ((Path)localObject2).lineTo(4.274523F, 6.978288F);
      ((Path)localObject2).lineTo(4.274523F, 6.978288F);
      ((Path)localObject2).cubicTo(2.840794F, 6.98028F, 1.67901F, 8.167374F, 1.677056F, 9.632346F);
      ((Path)localObject2).lineTo(1.677056F, 9.632231F);
      ((Path)localObject2).cubicTo(1.678456F, 11.097549F, 2.840329F, 12.285237F, 4.274405F, 12.287294F);
      ((Path)localObject2).lineTo(14.881954F, 12.287294F);
      ((Path)localObject2).lineTo(14.881954F, 12.287294F);
      ((Path)localObject2).cubicTo(16.782742F, 12.284304F, 18.322641F, 10.710061F, 18.324581F, 8.767846F);
      ((Path)localObject2).lineTo(18.324581F, 8.767831F);
      ((Path)localObject2).cubicTo(18.321648F, 6.826487F, 16.781889F, 5.253592F, 14.881939F, 5.251115F);
      ((Path)localObject2).lineTo(14.881939F, 5.251115F);
      ((Path)localObject2).cubicTo(12.981637F, 5.253606F, 11.441751F, 6.827042F, 11.439312F, 8.768746F);
      ((Path)localObject2).lineTo(11.439312F, 9.04003F);
      ((Path)localObject2).lineTo(9.761496F, 9.04003F);
      ((Path)localObject2).lineTo(9.761496F, 8.768746F);
      ((Path)localObject2).lineTo(9.761496F, 8.768789F);
      ((Path)localObject2).cubicTo(9.763482F, 6.689676F, 10.970472F, 4.809177F, 12.835934F, 3.978811F);
      ((Path)localObject2).lineTo(12.835933F, 3.978811F);
      ((Path)localObject2).cubicTo(12.233202F, 2.605279F, 10.900105F, 1.718754F, 9.426937F, 1.711788F);
      ((Path)localObject2).lineTo(9.426964F, 1.712691F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_cloud
 * JD-Core Version:    0.7.0.1
 */