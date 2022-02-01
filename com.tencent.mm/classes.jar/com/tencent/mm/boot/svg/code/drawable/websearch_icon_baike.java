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

public class websearch_icon_baike
  extends c
{
  private final int height = 16;
  private final int width = 12;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 16;
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-5066062);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -138.0F, 0.0F, 1.0F, -671.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 69.0F, 0.0F, 1.0F, 68.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.15F, 2.4F);
      ((Path)localObject2).lineTo(6.15F, 13.35697F);
      ((Path)localObject2).lineTo(13.5F, 13.35697F);
      ((Path)localObject2).cubicTo(13.83137F, 13.35697F, 14.1F, 13.088341F, 14.1F, 12.756969F);
      ((Path)localObject2).lineTo(14.1F, 11.400009F);
      ((Path)localObject2).lineTo(14.1F, 3.0F);
      ((Path)localObject2).cubicTo(14.1F, 2.668629F, 13.83137F, 2.4F, 13.5F, 2.4F);
      ((Path)localObject2).lineTo(6.15F, 2.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.25F, 2.4F);
      ((Path)localObject2).lineTo(3.9F, 2.4F);
      ((Path)localObject2).lineTo(3.9F, 13.35697F);
      ((Path)localObject2).lineTo(5.25F, 13.35697F);
      ((Path)localObject2).lineTo(5.25F, 2.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.1F, 14.132156F);
      ((Path)localObject2).cubicTo(13.916262F, 14.212435F, 13.713331F, 14.256969F, 13.5F, 14.256969F);
      ((Path)localObject2).lineTo(3.9F, 14.256969F);
      ((Path)localObject2).lineTo(3.9F, 15.6F);
      ((Path)localObject2).lineTo(13.5F, 15.6F);
      ((Path)localObject2).cubicTo(13.83137F, 15.6F, 14.1F, 15.33137F, 14.1F, 15.0F);
      ((Path)localObject2).lineTo(14.1F, 14.132156F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.0F, 1.5F);
      ((Path)localObject2).lineTo(13.5F, 1.5F);
      ((Path)localObject2).cubicTo(14.328427F, 1.5F, 15.0F, 2.171573F, 15.0F, 3.0F);
      ((Path)localObject2).lineTo(15.0F, 15.0F);
      ((Path)localObject2).cubicTo(15.0F, 15.828427F, 14.328427F, 16.5F, 13.5F, 16.5F);
      ((Path)localObject2).lineTo(3.0F, 16.5F);
      ((Path)localObject2).lineTo(3.0F, 1.5F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.websearch_icon_baike
 * JD-Core Version:    0.7.0.1
 */