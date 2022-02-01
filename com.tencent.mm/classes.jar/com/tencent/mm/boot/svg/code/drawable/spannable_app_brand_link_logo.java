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

public class spannable_app_brand_link_logo
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -415.0F, 0.0F, 1.0F, -651.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 415.0F, 0.0F, 1.0F, 651.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-723724);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 30.0F);
      ((Path)localObject2).cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).lineTo(30.0F, 0.0F);
      ((Path)localObject2).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject2).lineTo(60.0F, 30.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject2).lineTo(30.0F, 60.0F);
      ((Path)localObject2).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject2).lineTo(0.0F, 30.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-9074981);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(39.0F, 12.0F);
      ((Path)localObject1).cubicTo(36.800449F, 12.0F, 34.799099F, 12.586F, 33.0F, 14.0F);
      ((Path)localObject1).cubicTo(29.98325F, 15.412F, 27.9F, 18.645334F, 28.0F, 22.0F);
      ((Path)localObject1).lineTo(28.0F, 38.0F);
      ((Path)localObject1).cubicTo(27.9F, 40.428001F, 25.2805F, 42.666668F, 22.0F, 43.0F);
      ((Path)localObject1).cubicTo(18.81885F, 42.666668F, 16.200001F, 40.428001F, 16.0F, 38.0F);
      ((Path)localObject1).cubicTo(16.200001F, 35.701332F, 17.5299F, 34.006001F, 19.0F, 33.0F);
      ((Path)localObject1).cubicTo(19.59885F, 33.130001F, 19.739901F, 33.074001F, 20.0F, 33.0F);
      ((Path)localObject1).cubicTo(21.099701F, 32.524666F, 22.141649F, 31.586F, 23.0F, 30.0F);
      ((Path)localObject1).cubicTo(23.099751F, 28.886667F, 22.03635F, 27.582666F, 20.0F, 28.0F);
      ((Path)localObject1).cubicTo(19.68465F, 27.582666F, 19.208851F, 27.664F, 19.0F, 28.0F);
      ((Path)localObject1).cubicTo(18.747999F, 27.811333F, 18.74605F, 27.812F, 19.0F, 28.0F);
      ((Path)localObject1).cubicTo(16.0219F, 28.614F, 13.75015F, 30.371334F, 12.0F, 33.0F);
      ((Path)localObject1).cubicTo(11.5057F, 34.150002F, 11.0F, 35.853333F, 11.0F, 38.0F);
      ((Path)localObject1).cubicTo(11.0F, 43.364666F, 15.9569F, 48.0F, 22.0F, 48.0F);
      ((Path)localObject1).cubicTo(24.199551F, 48.0F, 26.200899F, 47.414001F, 28.0F, 46.0F);
      ((Path)localObject1).cubicTo(31.01675F, 44.588001F, 33.099998F, 41.354668F, 33.0F, 38.0F);
      ((Path)localObject1).lineTo(33.0F, 22.0F);
      ((Path)localObject1).cubicTo(33.099998F, 19.572001F, 35.718849F, 17.333334F, 39.0F, 17.0F);
      ((Path)localObject1).cubicTo(42.1805F, 17.333334F, 44.799999F, 19.572001F, 45.0F, 22.0F);
      ((Path)localObject1).cubicTo(44.799999F, 24.382668F, 43.357651F, 26.143999F, 41.0F, 27.0F);
      ((Path)localObject1).cubicTo(39.960751F, 27.374001F, 38.8694F, 28.362667F, 38.0F, 30.0F);
      ((Path)localObject1).cubicTo(37.8853F, 31.135334F, 38.943501F, 32.433998F, 41.0F, 32.0F);
      ((Path)localObject1).cubicTo(41.241901F, 32.433998F, 41.670898F, 32.359333F, 42.0F, 32.0F);
      ((Path)localObject1).cubicTo(42.157101F, 32.218666F, 42.224701F, 32.197334F, 42.0F, 32.0F);
      ((Path)localObject1).cubicTo(44.997601F, 31.370667F, 47.255699F, 29.618668F, 49.0F, 27.0F);
      ((Path)localObject1).cubicTo(49.494301F, 25.850666F, 50.0F, 24.146667F, 50.0F, 22.0F);
      ((Path)localObject1).cubicTo(50.0F, 16.635334F, 45.043098F, 12.0F, 39.0F, 12.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.spannable_app_brand_link_logo
 * JD-Core Version:    0.7.0.1
 */