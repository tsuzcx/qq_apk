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

public class ime_english_qwerty
  extends c
{
  private final int height = 51;
  private final int width = 51;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 51;
      return 51;
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
      localPaint1.setColor(-11842483);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -267.0F, 0.0F, 1.0F, -1119.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 267.0F, 0.0F, 1.0F, 1119.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.5F, 51.0F);
      ((Path)localObject2).cubicTo(11.416579F, 51.0F, 0.0F, 39.58342F, 0.0F, 25.5F);
      ((Path)localObject2).cubicTo(0.0F, 11.416579F, 11.416579F, 0.0F, 25.5F, 0.0F);
      ((Path)localObject2).cubicTo(39.58342F, 0.0F, 51.0F, 11.416579F, 51.0F, 25.5F);
      ((Path)localObject2).cubicTo(51.0F, 39.58342F, 39.58342F, 51.0F, 25.5F, 51.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.624933F, 35.604374F);
      ((Path)localObject2).lineTo(23.183733F, 35.604374F);
      ((Path)localObject2).lineTo(23.183733F, 32.7845F);
      ((Path)localObject2).lineTo(13.606341F, 32.7845F);
      ((Path)localObject2).lineTo(13.606341F, 27.011936F);
      ((Path)localObject2).lineTo(21.780138F, 27.011936F);
      ((Path)localObject2).lineTo(21.780138F, 24.368437F);
      ((Path)localObject2).lineTo(13.606341F, 24.368437F);
      ((Path)localObject2).lineTo(13.606341F, 18.756296F);
      ((Path)localObject2).lineTo(23.182638F, 18.756296F);
      ((Path)localObject2).lineTo(23.182638F, 15.937485F);
      ((Path)localObject2).lineTo(10.624933F, 15.937485F);
      ((Path)localObject2).lineTo(10.624933F, 35.604374F);
      ((Path)localObject2).lineTo(10.624933F, 35.604374F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.988733F, 35.604374F);
      ((Path)localObject2).lineTo(28.970106F, 35.604374F);
      ((Path)localObject2).lineTo(28.970106F, 21.62933F);
      ((Path)localObject2).lineTo(29.023232F, 21.62933F);
      ((Path)localObject2).lineTo(37.91317F, 35.604374F);
      ((Path)localObject2).lineTo(40.731979F, 35.604374F);
      ((Path)localObject2).lineTo(40.731979F, 15.9375F);
      ((Path)localObject2).lineTo(37.750607F, 15.9375F);
      ((Path)localObject2).lineTo(37.750607F, 29.911501F);
      ((Path)localObject2).lineTo(37.697483F, 29.911501F);
      ((Path)localObject2).lineTo(28.793749F, 15.9375F);
      ((Path)localObject2).lineTo(25.988733F, 15.9375F);
      ((Path)localObject2).lineTo(25.988733F, 35.604374F);
      ((Path)localObject2).lineTo(25.988733F, 35.604374F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_english_qwerty
 * JD-Core Version:    0.7.0.1
 */