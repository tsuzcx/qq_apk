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

public class chatfrom_voice_playing_f3_dark
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
      localCanvas.saveLayerAlpha(null, 204, 31);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 72.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.restore();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(52.5F, 36.0F);
      ((Path)localObject).cubicTo(52.5F, 45.372581F, 48.806351F, 53.857864F, 42.834522F, 60.0F);
      ((Path)localObject).lineTo(39.334347F, 56.400002F);
      ((Path)localObject).cubicTo(44.410397F, 51.179184F, 47.549999F, 43.966694F, 47.549999F, 36.0F);
      ((Path)localObject).cubicTo(47.549999F, 28.033304F, 44.410397F, 20.820816F, 39.334347F, 15.6F);
      ((Path)localObject).lineTo(42.834522F, 12.0F);
      ((Path)localObject).cubicTo(48.806351F, 18.142136F, 52.5F, 26.627417F, 52.5F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(40.950001F, 36.0F);
      ((Path)localObject).cubicTo(40.950001F, 42.092178F, 38.549126F, 47.607613F, 34.667442F, 51.599998F);
      ((Path)localObject).lineTo(31.167261F, 48.0F);
      ((Path)localObject).cubicTo(34.153175F, 44.928932F, 36.0F, 40.686291F, 36.0F, 36.0F);
      ((Path)localObject).cubicTo(36.0F, 31.313709F, 34.153175F, 27.071068F, 31.167261F, 24.0F);
      ((Path)localObject).lineTo(34.668404F, 20.40099F);
      ((Path)localObject).cubicTo(38.549522F, 24.393299F, 40.950001F, 29.908325F, 40.950001F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(29.4F, 36.0F);
      ((Path)localObject).cubicTo(29.4F, 38.811775F, 28.291904F, 41.357361F, 26.500357F, 43.200001F);
      ((Path)localObject).lineTo(19.5F, 36.0F);
      ((Path)localObject).lineTo(26.501314F, 28.800985F);
      ((Path)localObject).cubicTo(28.292299F, 30.643549F, 29.4F, 33.188725F, 29.4F, 36.0F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chatfrom_voice_playing_f3_dark
 * JD-Core Version:    0.7.0.1
 */