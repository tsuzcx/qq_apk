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

public class icons_finder_msg_alias_holder
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -16.0F, 0.0F, 1.0F, -99.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 99.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-352965);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(44.0F, 0.0F);
      localPath.cubicTo(46.209141F, 0.0F, 48.0F, 1.790861F, 48.0F, 4.0F);
      localPath.lineTo(48.0F, 44.0F);
      localPath.cubicTo(48.0F, 46.209141F, 46.209141F, 48.0F, 44.0F, 48.0F);
      localPath.lineTo(4.0F, 48.0F);
      localPath.cubicTo(1.790861F, 48.0F, 0.0F, 46.209141F, 0.0F, 44.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(23.683332F, 23.1F);
      ((Path)localObject2).lineTo(23.683332F, 22.534708F);
      ((Path)localObject2).cubicTo(23.683332F, 22.267069F, 23.408792F, 21.828356F, 23.169777F, 21.711769F);
      ((Path)localObject2).lineTo(16.566032F, 18.490547F);
      ((Path)localObject2).cubicTo(14.78502F, 17.621792F, 14.344835F, 15.520065F, 15.620893F, 14.00743F);
      ((Path)localObject2).lineTo(16.042681F, 13.507443F);
      ((Path)localObject2).cubicTo(16.685894F, 12.74498F, 17.266666F, 11.158456F, 17.266666F, 10.161883F);
      ((Path)localObject2).lineTo(17.266666F, 8.166908F);
      ((Path)localObject2).cubicTo(17.266666F, 6.364067F, 15.803188F, 4.9F, 14.0F, 4.9F);
      ((Path)localObject2).cubicTo(12.199027F, 4.9F, 10.733334F, 6.364403F, 10.733334F, 8.166177F);
      ((Path)localObject2).lineTo(10.733334F, 10.160839F);
      ((Path)localObject2).cubicTo(10.733334F, 11.159942F, 11.311705F, 12.740564F, 11.957258F, 13.505697F);
      ((Path)localObject2).lineTo(12.379046F, 14.005615F);
      ((Path)localObject2).cubicTo(13.657743F, 15.521171F, 13.21275F, 17.620926F, 11.434173F, 18.488852F);
      ((Path)localObject2).lineTo(4.830427F, 21.711407F);
      ((Path)localObject2).cubicTo(4.593186F, 21.827177F, 4.316667F, 22.270123F, 4.316667F, 22.534708F);
      ((Path)localObject2).lineTo(4.316667F, 23.1F);
      ((Path)localObject2).lineTo(23.683332F, 23.1F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2.916667F, 23.333334F);
      ((Path)localObject2).lineTo(2.916667F, 22.534708F);
      ((Path)localObject2).cubicTo(2.916667F, 21.735437F, 3.497843F, 20.803892F, 4.216447F, 20.453222F);
      ((Path)localObject2).lineTo(10.820192F, 17.230667F);
      ((Path)localObject2).cubicTo(11.77794F, 16.763296F, 12.000635F, 15.72814F, 11.309019F, 14.908412F);
      ((Path)localObject2).lineTo(10.887232F, 14.408494F);
      ((Path)localObject2).cubicTo(10.029037F, 13.391333F, 9.333333F, 11.491079F, 9.333333F, 10.160839F);
      ((Path)localObject2).lineTo(9.333333F, 8.166177F);
      ((Path)localObject2).cubicTo(9.333333F, 5.589119F, 11.427916F, 3.5F, 14.0F, 3.5F);
      ((Path)localObject2).cubicTo(16.57733F, 3.5F, 18.666666F, 5.59181F, 18.666666F, 8.166908F);
      ((Path)localObject2).lineTo(18.666666F, 10.161883F);
      ((Path)localObject2).cubicTo(18.666666F, 11.490846F, 17.967754F, 13.39667F, 17.112768F, 14.410169F);
      ((Path)localObject2).lineTo(16.690981F, 14.910155F);
      ((Path)localObject2).cubicTo(16.003204F, 15.725443F, 16.218052F, 16.76313F, 17.179808F, 17.232262F);
      ((Path)localObject2).lineTo(23.783552F, 20.453484F);
      ((Path)localObject2).cubicTo(24.501402F, 20.80364F, 25.083334F, 21.729364F, 25.083334F, 22.534708F);
      ((Path)localObject2).lineTo(25.083334F, 23.333334F);
      ((Path)localObject2).cubicTo(25.083334F, 23.977665F, 24.560999F, 24.5F, 23.916666F, 24.5F);
      ((Path)localObject2).lineTo(4.083334F, 24.5F);
      ((Path)localObject2).cubicTo(3.439001F, 24.5F, 2.916667F, 23.977665F, 2.916667F, 23.333334F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_finder_msg_alias_holder
 * JD-Core Version:    0.7.0.1
 */