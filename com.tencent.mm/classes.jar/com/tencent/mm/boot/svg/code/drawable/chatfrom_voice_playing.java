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

public class chatfrom_voice_playing
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 72.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(42.834522F, 12.0F);
      ((Path)localObject2).cubicTo(48.806351F, 18.142136F, 52.5F, 26.627417F, 52.5F, 36.0F);
      ((Path)localObject2).cubicTo(52.5F, 45.372581F, 48.806351F, 53.857864F, 42.834522F, 60.0F);
      ((Path)localObject2).lineTo(39.334347F, 56.400002F);
      ((Path)localObject2).cubicTo(44.410397F, 51.179184F, 47.549999F, 43.966694F, 47.549999F, 36.0F);
      ((Path)localObject2).cubicTo(47.549999F, 28.033304F, 44.410397F, 20.820816F, 39.334347F, 15.6F);
      ((Path)localObject2).lineTo(42.834522F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(34.667442F, 20.4F);
      ((Path)localObject2).cubicTo(38.549126F, 24.392387F, 40.950001F, 29.907822F, 40.950001F, 36.0F);
      ((Path)localObject2).cubicTo(40.950001F, 42.092178F, 38.549126F, 47.607613F, 34.667442F, 51.599998F);
      ((Path)localObject2).lineTo(31.167261F, 48.0F);
      ((Path)localObject2).cubicTo(34.153175F, 44.928932F, 36.0F, 40.686291F, 36.0F, 36.0F);
      ((Path)localObject2).cubicTo(36.0F, 31.313709F, 34.153175F, 27.071068F, 31.167261F, 24.0F);
      ((Path)localObject2).lineTo(34.667442F, 20.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.500357F, 28.799999F);
      ((Path)localObject2).cubicTo(28.291904F, 30.642641F, 29.4F, 33.188225F, 29.4F, 36.0F);
      ((Path)localObject2).cubicTo(29.4F, 38.811775F, 28.291904F, 41.357361F, 26.500357F, 43.200001F);
      ((Path)localObject2).lineTo(19.5F, 36.0F);
      ((Path)localObject2).lineTo(26.500357F, 28.799999F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chatfrom_voice_playing
 * JD-Core Version:    0.7.0.1
 */