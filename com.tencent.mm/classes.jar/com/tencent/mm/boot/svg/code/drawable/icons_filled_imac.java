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

public class icons_filled_imac
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
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(39.466225F, 45.0F);
      ((Path)localObject2).lineTo(41.331051F, 50.519901F);
      ((Path)localObject2).cubicTo(41.383305F, 50.674576F, 41.409958F, 50.836739F, 41.409958F, 51.0F);
      ((Path)localObject2).cubicTo(41.409958F, 51.828426F, 40.738384F, 52.5F, 39.909958F, 52.5F);
      ((Path)localObject2).lineTo(20.090042F, 52.5F);
      ((Path)localObject2).cubicTo(19.926783F, 52.5F, 19.764618F, 52.473347F, 19.609945F, 52.421093F);
      ((Path)localObject2).cubicTo(18.825098F, 52.155941F, 18.403799F, 51.304752F, 18.668949F, 50.519901F);
      ((Path)localObject2).lineTo(20.533775F, 45.0F);
      ((Path)localObject2).lineTo(3.0F, 45.0F);
      ((Path)localObject2).cubicTo(1.343146F, 45.0F, 2.029061E-016F, 43.656853F, 0.0F, 42.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(57.0F, 0.0F);
      ((Path)localObject2).cubicTo(58.656853F, -3.043592E-016F, 60.0F, 1.343146F, 60.0F, 3.0F);
      ((Path)localObject2).lineTo(60.0F, 42.0F);
      ((Path)localObject2).cubicTo(60.0F, 43.656853F, 58.656853F, 45.0F, 57.0F, 45.0F);
      ((Path)localObject2).lineTo(39.466225F, 45.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(55.5F, 36.0F);
      ((Path)localObject2).lineTo(4.5F, 36.0F);
      ((Path)localObject2).lineTo(4.5F, 40.5F);
      ((Path)localObject2).lineTo(55.5F, 40.5F);
      ((Path)localObject2).lineTo(55.5F, 36.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_imac
 * JD-Core Version:    0.7.0.1
 */