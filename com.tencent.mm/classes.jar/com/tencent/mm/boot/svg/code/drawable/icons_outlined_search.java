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

public class icons_outlined_search
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(48.929794F, 46.684208F);
      ((Path)localObject).lineTo(61.272793F, 59.027206F);
      ((Path)localObject).lineTo(58.727207F, 61.572792F);
      ((Path)localObject).lineTo(46.358551F, 49.204136F);
      ((Path)localObject).cubicTo(42.728428F, 52.200203F, 38.074402F, 54.0F, 33.0F, 54.0F);
      ((Path)localObject).cubicTo(21.402F, 54.0F, 12.0F, 44.598F, 12.0F, 33.0F);
      ((Path)localObject).cubicTo(12.0F, 21.402F, 21.402F, 12.0F, 33.0F, 12.0F);
      ((Path)localObject).cubicTo(44.598F, 12.0F, 54.0F, 21.402F, 54.0F, 33.0F);
      ((Path)localObject).cubicTo(54.0F, 38.227451F, 52.089996F, 43.008789F, 48.929794F, 46.684208F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(50.399994F, 33.000038F);
      ((Path)localObject).cubicTo(50.399994F, 23.390265F, 42.609764F, 15.600037F, 32.999992F, 15.600037F);
      ((Path)localObject).cubicTo(23.390221F, 15.600037F, 15.599991F, 23.390265F, 15.599991F, 33.000038F);
      ((Path)localObject).cubicTo(15.599991F, 42.60981F, 23.390221F, 50.40004F, 32.999992F, 50.40004F);
      ((Path)localObject).cubicTo(42.609764F, 50.40004F, 50.399994F, 42.60981F, 50.399994F, 33.000038F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_search
 * JD-Core Version:    0.7.0.1
 */