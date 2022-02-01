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

public class album_facebook_icon_pressed
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
      localPaint1.setColor(-12822120);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.972387F, 0.04029851F);
      ((Path)localObject2).lineTo(1.027612F, 0.04029851F);
      ((Path)localObject2).cubicTo(0.4835821F, 0.04029851F, 0.04029851F, 0.4835821F, 0.04029851F, 1.027612F);
      ((Path)localObject2).lineTo(0.04029851F, 16.972387F);
      ((Path)localObject2).cubicTo(0.04029851F, 17.516418F, 0.4835821F, 17.959702F, 1.027612F, 17.959702F);
      ((Path)localObject2).lineTo(9.611194F, 17.959702F);
      ((Path)localObject2).lineTo(9.611194F, 11.021642F);
      ((Path)localObject2).lineTo(7.273881F, 11.021642F);
      ((Path)localObject2).lineTo(7.273881F, 8.314925F);
      ((Path)localObject2).lineTo(9.611194F, 8.314925F);
      ((Path)localObject2).lineTo(9.611194F, 6.320149F);
      ((Path)localObject2).cubicTo(9.611194F, 4.002985F, 11.028358F, 2.747015F, 13.090299F, 2.747015F);
      ((Path)localObject2).cubicTo(14.077612F, 2.747015F, 14.930597F, 2.820895F, 15.179105F, 2.854478F);
      ((Path)localObject2).lineTo(15.179105F, 5.272388F);
      ((Path)localObject2).lineTo(13.748507F, 5.272388F);
      ((Path)localObject2).cubicTo(12.626865F, 5.272388F, 12.405224F, 5.802985F, 12.405224F, 6.588806F);
      ((Path)localObject2).lineTo(12.405224F, 8.314925F);
      ((Path)localObject2).lineTo(15.085074F, 8.314925F);
      ((Path)localObject2).lineTo(14.735821F, 11.021642F);
      ((Path)localObject2).lineTo(12.405224F, 11.021642F);
      ((Path)localObject2).lineTo(12.405224F, 17.966417F);
      ((Path)localObject2).lineTo(16.972387F, 17.966417F);
      ((Path)localObject2).cubicTo(17.516418F, 17.966417F, 17.959702F, 17.523134F, 17.959702F, 16.979105F);
      ((Path)localObject2).lineTo(17.959702F, 1.027612F);
      ((Path)localObject2).cubicTo(17.959702F, 0.4768657F, 17.523134F, 0.04029851F, 16.972387F, 0.04029851F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_facebook_icon_pressed
 * JD-Core Version:    0.7.0.1
 */