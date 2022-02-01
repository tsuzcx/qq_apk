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

public class file_float_ball_icon_pages
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-28160);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 14.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.892308F, 0.0F, 1.0F, 0.4F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 17.73077F);
      localPath.cubicTo(0.0F, 17.454628F, 0.2238576F, 17.23077F, 0.5F, 17.23077F);
      localPath.lineTo(18.207693F, 17.23077F);
      localPath.cubicTo(18.483835F, 17.23077F, 18.707693F, 17.454628F, 18.707693F, 17.73077F);
      localPath.lineTo(18.707693F, 17.73077F);
      localPath.cubicTo(18.707693F, 18.006912F, 18.483835F, 18.23077F, 18.207693F, 18.23077F);
      localPath.lineTo(0.5F, 18.23077F);
      localPath.cubicTo(0.2238576F, 18.23077F, 0.0F, 18.006912F, 0.0F, 17.73077F);
      localPath.lineTo(0.0F, 17.73077F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 8.598819F, 0.7071068F, 0.7071068F, -3.561748F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.703013F, 6.054795F);
      ((Path)localObject).cubicTo(9.661864F, 8.2097F, 9.477281F, 11.611098F, 9.149263F, 16.258991F);
      ((Path)localObject).lineTo(8.048376F, 16.258991F);
      ((Path)localObject).cubicTo(7.720358F, 11.611098F, 7.535775F, 8.2097F, 7.494627F, 6.054795F);
      ((Path)localObject).lineTo(9.703013F, 6.054795F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.711865F, 5.204445F);
      ((Path)localObject).lineTo(7.485774F, 5.204445F);
      ((Path)localObject).cubicTo(7.485774F, 3.151405F, 7.555957F, 0.8660172F, 7.696324F, -1.651719F);
      ((Path)localObject).cubicTo(7.721249F, -2.09888F, 8.091116F, -2.448702F, 8.538972F, -2.448702F);
      ((Path)localObject).lineTo(8.658668F, -2.448701F);
      ((Path)localObject).cubicTo(9.10652F, -2.448701F, 9.476385F, -2.098882F, 9.501314F, -1.651724F);
      ((Path)localObject).cubicTo(9.641682F, 0.8660138F, 9.711865F, 3.151404F, 9.711865F, 5.204445F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.088652F, 17.109341F);
      ((Path)localObject).cubicTo(9.068558F, 17.388567F, 9.047978F, 17.672018F, 9.026913F, 17.95969F);
      ((Path)localObject).lineTo(8.765283F, 19.518766F);
      ((Path)localObject).cubicTo(8.749855F, 19.610703F, 8.662821F, 19.672724F, 8.570885F, 19.657297F);
      ((Path)localObject).cubicTo(8.499893F, 19.645384F, 8.444269F, 19.589758F, 8.432356F, 19.518766F);
      ((Path)localObject).lineTo(8.170726F, 17.95969F);
      ((Path)localObject).cubicTo(8.14966F, 17.672018F, 8.129081F, 17.388567F, 8.108988F, 17.109341F);
      ((Path)localObject).lineTo(9.088652F, 17.109341F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.file_float_ball_icon_pages
 * JD-Core Version:    0.7.0.1
 */