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

public class icons_filled_horizontal_hint
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
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-2565928);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 72.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint((Paint)localObject2, paramVarArgs));
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 73.379517F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(33.182804F, 9.1807F);
      localPath.cubicTo(36.510818F, 9.85755F, 39.171448F, 12.370893F, 40.060535F, 15.61657F);
      localPath.lineTo(40.198818F, 16.196712F);
      localPath.lineTo(36.471546F, 16.198015F);
      localPath.cubicTo(35.929024F, 14.665001F, 34.713825F, 13.449974F, 33.180702F, 12.907688F);
      localPath.lineTo(33.182804F, 9.1807F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 118.61823F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(62.817955F, 9.180089F);
      localPath.lineTo(62.819298F, 12.906894F);
      localPath.cubicTo(61.284847F, 13.44888F, 60.068565F, 14.664676F, 59.525921F, 16.198818F);
      localPath.lineTo(55.798935F, 16.196712F);
      localPath.cubicTo(56.475975F, 12.867753F, 58.990555F, 10.206556F, 62.237572F, 9.318225F);
      localPath.lineTo(62.817955F, 9.180089F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 96.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(52.200001F, 9.0F);
      localPath.lineTo(52.200001F, 12.6F);
      localPath.lineTo(43.799999F, 12.6F);
      localPath.lineTo(43.799999F, 9.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 118.61823F, 0.0F, -1.0F, 100.61873F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(62.817955F, 46.799999F);
      localPath.lineTo(62.819298F, 50.526806F);
      localPath.cubicTo(61.284847F, 51.06879F, 60.068565F, 52.284588F, 59.525921F, 53.818729F);
      localPath.lineTo(55.798935F, 53.816624F);
      localPath.cubicTo(56.475975F, 50.487663F, 58.990555F, 47.826466F, 62.237572F, 46.938137F);
      localPath.lineTo(62.817955F, 46.799999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 69.599998F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(33.0F, 20.249113F);
      localPath.lineTo(36.599998F, 20.249113F);
      localPath.lineTo(36.599998F, 25.052113F);
      localPath.lineTo(33.0F, 25.052113F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 69.599998F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(33.0F, 29.102409F);
      localPath.lineTo(36.599998F, 29.102409F);
      localPath.lineTo(36.599998F, 33.902409F);
      localPath.lineTo(33.0F, 33.902409F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 122.4F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(59.400002F, 37.952705F);
      localPath.lineTo(63.0F, 37.952705F);
      localPath.lineTo(63.0F, 42.749706F);
      localPath.lineTo(59.400002F, 42.749706F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 122.4F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(59.400002F, 29.102409F);
      localPath.lineTo(63.0F, 29.102409F);
      localPath.lineTo(63.0F, 33.902409F);
      localPath.lineTo(59.400002F, 33.902409F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 122.4F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(59.400002F, 20.249113F);
      localPath.lineTo(63.0F, 20.249113F);
      localPath.lineTo(63.0F, 25.052113F);
      localPath.lineTo(59.400002F, 25.052113F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray(arrayOfFloat, 1.0F, -1.224647E-016F, 5.878305E-015F, -1.224647E-016F, -1.0F, 96.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(45.0F, 33.0F);
      ((Path)localObject1).cubicTo(49.970562F, 33.0F, 54.0F, 37.029438F, 54.0F, 42.0F);
      ((Path)localObject1).lineTo(54.0F, 54.0F);
      ((Path)localObject1).cubicTo(54.0F, 58.970562F, 49.970562F, 63.0F, 45.0F, 63.0F);
      ((Path)localObject1).lineTo(18.0F, 63.0F);
      ((Path)localObject1).cubicTo(13.029437F, 63.0F, 9.0F, 58.970562F, 9.0F, 54.0F);
      ((Path)localObject1).lineTo(9.0F, 42.0F);
      ((Path)localObject1).cubicTo(9.0F, 37.029438F, 13.029437F, 33.0F, 18.0F, 33.0F);
      ((Path)localObject1).lineTo(45.0F, 33.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(45.0F, 36.599998F);
      ((Path)localObject1).lineTo(18.0F, 36.599998F);
      ((Path)localObject1).cubicTo(15.16678F, 36.599998F, 12.843178F, 38.78194F, 12.617901F, 41.557117F);
      ((Path)localObject1).lineTo(12.6F, 42.0F);
      ((Path)localObject1).lineTo(12.6F, 54.0F);
      ((Path)localObject1).cubicTo(12.6F, 56.833221F, 14.78194F, 59.156822F, 17.557116F, 59.382099F);
      ((Path)localObject1).lineTo(18.0F, 59.400002F);
      ((Path)localObject1).lineTo(45.0F, 59.400002F);
      ((Path)localObject1).cubicTo(47.833221F, 59.400002F, 50.156822F, 57.21806F, 50.382099F, 54.442883F);
      ((Path)localObject1).lineTo(50.400002F, 54.0F);
      ((Path)localObject1).lineTo(50.400002F, 42.0F);
      ((Path)localObject1).cubicTo(50.400002F, 39.166779F, 48.21806F, 36.843178F, 45.442883F, 36.617901F);
      ((Path)localObject1).lineTo(45.0F, 36.599998F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_horizontal_hint
 * JD-Core Version:    0.7.0.1
 */