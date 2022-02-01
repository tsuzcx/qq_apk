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

public class icons_outlined_imac
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(22.0F, 18.0F);
      ((Path)localObject).cubicTo(22.0F, 18.552284F, 21.552284F, 19.0F, 21.0F, 19.0F);
      ((Path)localObject).lineTo(15.155F, 19.0F);
      ((Path)localObject).lineTo(15.777017F, 20.839968F);
      ((Path)localObject).cubicTo(15.794435F, 20.891525F, 15.803319F, 20.94558F, 15.803319F, 21.0F);
      ((Path)localObject).cubicTo(15.803319F, 21.276142F, 15.579461F, 21.5F, 15.303319F, 21.5F);
      ((Path)localObject).lineTo(8.696681F, 21.5F);
      ((Path)localObject).cubicTo(8.642261F, 21.5F, 8.588206F, 21.491116F, 8.536649F, 21.473698F);
      ((Path)localObject).cubicTo(8.275032F, 21.385315F, 8.1346F, 21.101583F, 8.222983F, 20.839968F);
      ((Path)localObject).lineTo(8.843F, 19.0F);
      ((Path)localObject).lineTo(3.0F, 19.0F);
      ((Path)localObject).cubicTo(2.447715F, 19.0F, 2.0F, 18.552284F, 2.0F, 18.0F);
      ((Path)localObject).lineTo(2.0F, 5.0F);
      ((Path)localObject).cubicTo(2.0F, 4.447715F, 2.447715F, 4.0F, 3.0F, 4.0F);
      ((Path)localObject).lineTo(21.0F, 4.0F);
      ((Path)localObject).cubicTo(21.552284F, 4.0F, 22.0F, 4.447715F, 22.0F, 5.0F);
      ((Path)localObject).lineTo(22.0F, 18.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.888774F, 18.999989F);
      ((Path)localObject).lineTo(10.111226F, 18.999989F);
      ((Path)localObject).lineTo(9.672034F, 20.299999F);
      ((Path)localObject).lineTo(14.327966F, 20.299999F);
      ((Path)localObject).lineTo(13.888774F, 18.999989F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.799999F, 16.200001F);
      ((Path)localObject).lineTo(3.199F, 16.200001F);
      ((Path)localObject).lineTo(3.2F, 17.799999F);
      ((Path)localObject).lineTo(20.799999F, 17.799999F);
      ((Path)localObject).lineTo(20.799999F, 16.200001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.799999F, 5.2F);
      ((Path)localObject).lineTo(3.2F, 5.2F);
      ((Path)localObject).lineTo(3.199F, 15.0F);
      ((Path)localObject).lineTo(20.799999F, 15.0F);
      ((Path)localObject).lineTo(20.799999F, 5.2F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_imac
 * JD-Core Version:    0.7.0.1
 */