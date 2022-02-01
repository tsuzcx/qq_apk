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

public class lucky_money_unmute_icon
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -319.0F, 0.0F, 1.0F, -177.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 319.0F, 0.0F, 1.0F, 177.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2147483648);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 36.0F);
      localPath.cubicTo(0.0F, 16.117748F, 16.117748F, 0.0F, 36.0F, 0.0F);
      localPath.lineTo(36.0F, 0.0F);
      localPath.cubicTo(55.882252F, 0.0F, 72.0F, 16.117748F, 72.0F, 36.0F);
      localPath.lineTo(72.0F, 36.0F);
      localPath.cubicTo(72.0F, 55.882252F, 55.882252F, 72.0F, 36.0F, 72.0F);
      localPath.lineTo(36.0F, 72.0F);
      localPath.cubicTo(16.117748F, 72.0F, 0.0F, 55.882252F, 0.0F, 36.0F);
      localPath.lineTo(0.0F, 36.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 15.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 3.5F, 0.0F, 1.0F, 7.666667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.275F, 0.5583333F);
      ((Path)localObject2).cubicTo(16.975F, -0.1416667F, 18.025F, -0.1416667F, 18.725F, 0.5583333F);
      ((Path)localObject2).cubicTo(19.075001F, 0.9083334F, 19.25F, 1.258333F, 19.25F, 1.783333F);
      ((Path)localObject2).lineTo(19.25F, 1.783333F);
      ((Path)localObject2).lineTo(19.25F, 24.883333F);
      ((Path)localObject2).cubicTo(19.25F, 25.933332F, 18.549999F, 26.633333F, 17.5F, 26.633333F);
      ((Path)localObject2).cubicTo(16.975F, 26.633333F, 16.625F, 26.458334F, 16.275F, 26.108334F);
      ((Path)localObject2).lineTo(16.275F, 26.108334F);
      ((Path)localObject2).lineTo(9.625F, 19.458334F);
      ((Path)localObject2).lineTo(1.75F, 19.458334F);
      ((Path)localObject2).cubicTo(0.7F, 19.458334F, 0.0F, 18.758333F, 0.0F, 17.708334F);
      ((Path)localObject2).lineTo(0.0F, 17.708334F);
      ((Path)localObject2).lineTo(0.0F, 8.958333F);
      ((Path)localObject2).cubicTo(0.0F, 7.908333F, 0.7F, 7.208334F, 1.75F, 7.208334F);
      ((Path)localObject2).lineTo(1.75F, 7.208334F);
      ((Path)localObject2).lineTo(9.625F, 7.208334F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.35F, 3.008333F);
      ((Path)localObject2).lineTo(28.525F, 3.183333F);
      ((Path)localObject2).cubicTo(31.15F, 5.808333F, 32.724998F, 9.483334F, 32.724998F, 13.333333F);
      ((Path)localObject2).cubicTo(32.724998F, 17.183332F, 31.325001F, 20.683332F, 28.525F, 23.483334F);
      ((Path)localObject2).lineTo(28.35F, 23.658333F);
      ((Path)localObject2).lineTo(26.424999F, 21.733334F);
      ((Path)localObject2).lineTo(26.6F, 21.558332F);
      ((Path)localObject2).cubicTo(28.875F, 19.283333F, 29.924999F, 16.483334F, 29.924999F, 13.333333F);
      ((Path)localObject2).cubicTo(29.924999F, 10.183333F, 28.700001F, 7.383333F, 26.6F, 5.108333F);
      ((Path)localObject2).lineTo(26.424999F, 4.933333F);
      ((Path)localObject2).lineTo(28.35F, 3.008333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.85F, 6.508333F);
      ((Path)localObject2).lineTo(25.025F, 6.683333F);
      ((Path)localObject2).cubicTo(26.775F, 8.433333F, 27.825001F, 10.883333F, 27.825001F, 13.333333F);
      ((Path)localObject2).cubicTo(27.825001F, 15.783333F, 26.775F, 18.233334F, 25.025F, 19.983334F);
      ((Path)localObject2).lineTo(24.85F, 20.158333F);
      ((Path)localObject2).lineTo(22.924999F, 18.233334F);
      ((Path)localObject2).lineTo(23.1F, 18.058332F);
      ((Path)localObject2).cubicTo(24.325001F, 16.833334F, 25.025F, 15.083333F, 25.025F, 13.333333F);
      ((Path)localObject2).cubicTo(25.025F, 11.583333F, 24.325001F, 9.833333F, 23.1F, 8.608334F);
      ((Path)localObject2).lineTo(22.924999F, 8.433333F);
      ((Path)localObject2).lineTo(24.85F, 6.508333F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.lucky_money_unmute_icon
 * JD-Core Version:    0.7.0.1
 */