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

public class icons_outlined_transfer
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
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(22.590546F, 27.0F);
      ((Path)localObject).lineTo(60.0F, 27.0F);
      ((Path)localObject).lineTo(60.0F, 31.5F);
      ((Path)localObject).lineTo(13.496722F, 31.5F);
      ((Path)localObject).cubicTo(12.668295F, 31.5F, 11.996722F, 30.828426F, 11.996722F, 30.0F);
      ((Path)localObject).cubicTo(11.996722F, 29.56789F, 12.183069F, 29.156771F, 12.508029F, 28.871954F);
      ((Path)localObject).lineTo(27.306252F, 15.901824F);
      ((Path)localObject).cubicTo(27.804653F, 15.464992F, 28.562809F, 15.514904F, 28.999641F, 16.013306F);
      ((Path)localObject).cubicTo(29.36046F, 16.42498F, 29.39694F, 17.028662F, 29.08832F, 17.480791F);
      ((Path)localObject).lineTo(22.590546F, 27.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(49.406178F, 45.0F);
      ((Path)localObject).lineTo(11.996722F, 45.0F);
      ((Path)localObject).lineTo(11.996722F, 40.5F);
      ((Path)localObject).lineTo(53.996723F, 40.5F);
      ((Path)localObject).lineTo(58.5F, 40.5F);
      ((Path)localObject).cubicTo(59.328426F, 40.5F, 60.0F, 41.171574F, 60.0F, 42.0F);
      ((Path)localObject).cubicTo(60.0F, 42.43211F, 59.813652F, 42.843231F, 59.488693F, 43.128044F);
      ((Path)localObject).lineTo(44.690472F, 56.098175F);
      ((Path)localObject).cubicTo(44.19207F, 56.535007F, 43.433914F, 56.485096F, 42.997082F, 55.986694F);
      ((Path)localObject).cubicTo(42.636261F, 55.57502F, 42.599781F, 54.971336F, 42.908401F, 54.519211F);
      ((Path)localObject).lineTo(49.406178F, 45.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_transfer
 * JD-Core Version:    0.7.0.1
 */