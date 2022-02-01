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

public class fix_tools_entry
  extends c
{
  private final int height = 68;
  private final int width = 68;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 68;
      return 68;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.133333F, 0.0F, 0.0F, 0.0F, 1.133333F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 6.0F);
      ((Path)localObject2).lineTo(24.0F, 13.582962F);
      ((Path)localObject2).cubicTo(24.0F, 16.068243F, 26.014719F, 18.082962F, 28.5F, 18.082962F);
      ((Path)localObject2).cubicTo(30.985281F, 18.082962F, 33.0F, 16.068243F, 33.0F, 13.582962F);
      ((Path)localObject2).lineTo(33.0F, 6.0F);
      ((Path)localObject2).cubicTo(36.547421F, 7.710701F, 39.0F, 11.381189F, 39.0F, 15.633177F);
      ((Path)localObject2).cubicTo(39.0F, 19.693186F, 36.763893F, 23.223017F, 33.473682F, 25.022778F);
      ((Path)localObject2).lineTo(33.473682F, 49.026318F);
      ((Path)localObject2).cubicTo(33.473682F, 51.773205F, 31.246889F, 54.0F, 28.5F, 54.0F);
      ((Path)localObject2).cubicTo(25.753111F, 54.0F, 23.526316F, 51.773205F, 23.526316F, 49.026318F);
      ((Path)localObject2).lineTo(23.526316F, 25.022778F);
      ((Path)localObject2).cubicTo(20.236107F, 23.223017F, 18.0F, 19.693186F, 18.0F, 15.633177F);
      ((Path)localObject2).cubicTo(18.0F, 11.381189F, 20.452579F, 7.710701F, 24.0F, 6.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fix_tools_entry
 * JD-Core Version:    0.7.0.1
 */