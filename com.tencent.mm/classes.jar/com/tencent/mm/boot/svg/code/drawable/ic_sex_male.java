package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class ic_sex_male
  extends c
{
  private final int height = 61;
  private final int width = 61;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 61;
      return 61;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-10970130);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(24.357143F, 31.267857F);
      ((Path)localObject).cubicTo(26.82522F, 35.67271F, 22.368435F, 37.603485F, 20.517857F, 38.94643F);
      ((Path)localObject).cubicTo(12.49915F, 43.231812F, 9.0F, 44.938072F, 9.0F, 46.625F);
      ((Path)localObject).lineTo(9.0F, 50.464287F);
      ((Path)localObject).cubicTo(9.0F, 51.156628F, 9.728162F, 52.0F, 10.535714F, 52.0F);
      ((Path)localObject).lineTo(50.464287F, 52.0F);
      ((Path)localObject).cubicTo(51.271839F, 52.0F, 52.0F, 51.156628F, 52.0F, 50.464287F);
      ((Path)localObject).lineTo(52.0F, 46.625F);
      ((Path)localObject).cubicTo(52.0F, 44.938072F, 48.500851F, 43.231812F, 40.482143F, 38.94643F);
      ((Path)localObject).cubicTo(38.631565F, 37.603485F, 34.174782F, 35.67271F, 36.642857F, 31.267857F);
      ((Path)localObject).cubicTo(39.243069F, 27.868282F, 41.103214F, 26.426222F, 41.25F, 20.517857F);
      ((Path)localObject).cubicTo(41.103214F, 14.887795F, 36.947693F, 9.0F, 30.5F, 9.0F);
      ((Path)localObject).cubicTo(24.052307F, 9.0F, 19.896786F, 14.887795F, 19.75F, 20.517857F);
      ((Path)localObject).cubicTo(19.896786F, 26.426222F, 21.756931F, 27.868282F, 24.357143F, 31.267857F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.714453F, 42.92168F);
      ((Path)localObject).cubicTo(26.309618F, 42.92168F, 23.007446F, 38.011597F, 23.007446F, 38.011597F);
      ((Path)localObject).cubicTo(23.007446F, 38.011597F, 24.622948F, 50.719337F, 30.714453F, 50.719337F);
      ((Path)localObject).cubicTo(36.805958F, 50.719337F, 38.079346F, 38.011597F, 38.079346F, 38.011597F);
      ((Path)localObject).cubicTo(38.079346F, 38.011597F, 35.119289F, 42.92168F, 30.714453F, 42.92168F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ic_sex_male
 * JD-Core Version:    0.7.0.1
 */