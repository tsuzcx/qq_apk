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

public class new_voice2txt_trans_en
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1.setColor(-436207616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9945219F, -0.1045285F, 1.3304F, 0.1045285F, 0.9945219F, -1.247546F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(13.01F, 18.138F);
      ((Path)localObject).lineTo(13.01F, 16.556999F);
      ((Path)localObject).lineTo(5.853F, 16.556999F);
      ((Path)localObject).lineTo(5.853F, 12.698F);
      ((Path)localObject).lineTo(12.313F, 12.698F);
      ((Path)localObject).lineTo(12.313F, 11.117F);
      ((Path)localObject).lineTo(5.853F, 11.117F);
      ((Path)localObject).lineTo(5.853F, 7.581F);
      ((Path)localObject).lineTo(12.721F, 7.581F);
      ((Path)localObject).lineTo(12.721F, 6.0F);
      ((Path)localObject).lineTo(4.0F, 6.0F);
      ((Path)localObject).lineTo(4.0F, 18.138F);
      ((Path)localObject).lineTo(13.01F, 18.138F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.9F, 18.138F);
      ((Path)localObject).lineTo(15.9F, 13.473F);
      ((Path)localObject).cubicTo(15.96F, 12.843F, 16.184999F, 12.348F, 16.545F, 11.988F);
      ((Path)localObject).cubicTo(16.875F, 11.658F, 17.280001F, 11.508F, 17.73F, 11.508F);
      ((Path)localObject).cubicTo(18.93F, 11.508F, 19.545F, 12.168F, 19.545F, 13.488F);
      ((Path)localObject).lineTo(19.545F, 18.138F);
      ((Path)localObject).lineTo(21.135F, 18.138F);
      ((Path)localObject).lineTo(21.135F, 13.353F);
      ((Path)localObject).cubicTo(21.135F, 11.223F, 20.16F, 10.173F, 18.24F, 10.173F);
      ((Path)localObject).cubicTo(17.76F, 10.173F, 17.325001F, 10.263F, 16.934999F, 10.473F);
      ((Path)localObject).cubicTo(16.545F, 10.668F, 16.200001F, 10.953F, 15.9F, 11.343F);
      ((Path)localObject).lineTo(15.9F, 10.383F);
      ((Path)localObject).lineTo(14.31F, 10.383F);
      ((Path)localObject).lineTo(14.31F, 18.138F);
      ((Path)localObject).lineTo(15.9F, 18.138F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.new_voice2txt_trans_en
 * JD-Core Version:    0.7.0.1
 */