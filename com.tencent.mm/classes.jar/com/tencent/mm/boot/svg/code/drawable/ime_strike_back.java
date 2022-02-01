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

public class ime_strike_back
  extends c
{
  private final int height = 41;
  private final int width = 41;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 41;
      return 41;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -686.0F, 0.0F, 1.0F, -781.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 686.0F, 0.0F, 1.0F, 781.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.714283F, 24.2857F);
      ((Path)localObject2).lineTo(16.714283F, 28.857141F);
      ((Path)localObject2).cubicTo(16.726444F, 29.483219F, 17.231064F, 29.987841F, 17.857143F, 30.0F);
      ((Path)localObject2).cubicTo(18.488325F, 30.0F, 19.0F, 29.488325F, 19.0F, 28.857143F);
      ((Path)localObject2).lineTo(19.0F, 23.142857F);
      ((Path)localObject2).cubicTo(19.0F, 22.511675F, 18.488325F, 22.0F, 17.857143F, 22.0F);
      ((Path)localObject2).lineTo(12.142858F, 22.0F);
      ((Path)localObject2).cubicTo(11.511676F, 22.0F, 11.0F, 22.511675F, 11.0F, 23.142857F);
      ((Path)localObject2).cubicTo(11.0F, 23.774038F, 11.511676F, 24.285715F, 12.142858F, 24.285715F);
      ((Path)localObject2).lineTo(16.714283F, 24.2857F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.857159F, 18.999096F);
      ((Path)localObject2).cubicTo(29.48834F, 18.999096F, 30.0F, 18.48748F, 30.0F, 17.856371F);
      ((Path)localObject2).cubicTo(30.0F, 17.225262F, 29.48834F, 16.713644F, 28.857159F, 16.713644F);
      ((Path)localObject2).lineTo(24.285727F, 16.713644F);
      ((Path)localObject2).lineTo(24.285727F, 12.142727F);
      ((Path)localObject2).cubicTo(24.273567F, 11.516723F, 23.768948F, 11.012158F, 23.14287F, 11.0F);
      ((Path)localObject2).cubicTo(22.511688F, 11.0F, 22.0F, 11.511617F, 22.0F, 12.142726F);
      ((Path)localObject2).lineTo(22.0F, 17.856358F);
      ((Path)localObject2).cubicTo(21.999527F, 18.487499F, 22.510805F, 18.999512F, 23.141989F, 19.0F);
      ((Path)localObject2).cubicTo(23.157536F, 19.0F, 23.173082F, 18.999706F, 23.188618F, 18.999084F);
      ((Path)localObject2).lineTo(28.857159F, 18.999096F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(2.0F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(20.5F, 1.0F);
      ((Path)localObject1).cubicTo(31.269554F, 1.0F, 40.0F, 9.730447F, 40.0F, 20.5F);
      ((Path)localObject1).cubicTo(40.0F, 31.269554F, 31.269554F, 40.0F, 20.5F, 40.0F);
      ((Path)localObject1).cubicTo(9.730447F, 40.0F, 1.0F, 31.269554F, 1.0F, 20.5F);
      ((Path)localObject1).cubicTo(1.0F, 9.730447F, 9.730447F, 1.0F, 20.5F, 1.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_strike_back
 * JD-Core Version:    0.7.0.1
 */