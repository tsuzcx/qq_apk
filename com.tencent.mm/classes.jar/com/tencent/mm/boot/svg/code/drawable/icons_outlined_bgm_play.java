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

public class icons_outlined_bgm_play
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.674537F, 3.61005F);
      ((Path)localObject).lineTo(10.851F, 4.798F);
      ((Path)localObject).lineTo(10.75157F, 4.812503F);
      ((Path)localObject).cubicTo(7.037201F, 5.410026F, 4.2F, 8.630246F, 4.2F, 12.513131F);
      ((Path)localObject).cubicTo(4.2F, 16.820951F, 7.692179F, 20.313131F, 12.0F, 20.313131F);
      ((Path)localObject).cubicTo(16.307821F, 20.313131F, 19.799999F, 16.820951F, 19.799999F, 12.513131F);
      ((Path)localObject).cubicTo(19.799999F, 10.729252F, 19.201159F, 9.085239F, 18.193537F, 7.771157F);
      ((Path)localObject).lineTo(19.145F, 7.043F);
      ((Path)localObject).lineTo(19.255844F, 7.187389F);
      ((Path)localObject).cubicTo(20.352266F, 8.678654F, 21.0F, 10.520249F, 21.0F, 12.513131F);
      ((Path)localObject).cubicTo(21.0F, 17.483694F, 16.970562F, 21.51313F, 12.0F, 21.51313F);
      ((Path)localObject).cubicTo(7.029437F, 21.51313F, 3.0F, 17.483694F, 3.0F, 12.513131F);
      ((Path)localObject).cubicTo(3.0F, 7.992879F, 6.332411F, 4.250954F, 10.674537F, 3.61005F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.296652F, 2.074364F);
      ((Path)localObject).lineTo(19.29916F, 2.087085F);
      ((Path)localObject).lineTo(19.299999F, 3.506181F);
      ((Path)localObject).cubicTo(19.299999F, 3.551526F, 19.269487F, 3.591196F, 19.22566F, 3.602832F);
      ((Path)localObject).lineTo(14.499F, 4.857085F);
      ((Path)localObject).lineTo(13.996224F, 12.625195F);
      ((Path)localObject).cubicTo(13.931405F, 13.671558F, 13.062449F, 14.5F, 12.0F, 14.5F);
      ((Path)localObject).cubicTo(10.895431F, 14.5F, 10.0F, 13.604569F, 10.0F, 12.5F);
      ((Path)localObject).cubicTo(10.0F, 11.395431F, 10.895431F, 10.5F, 12.0F, 10.5F);
      ((Path)localObject).cubicTo(12.329764F, 10.5F, 12.640888F, 10.579809F, 12.91511F, 10.721166F);
      ((Path)localObject).lineTo(13.3F, 4.33217F);
      ((Path)localObject).cubicTo(13.3F, 3.878715F, 13.605117F, 3.482018F, 14.043387F, 3.365656F);
      ((Path)localObject).lineTo(19.174339F, 2.003373F);
      ((Path)localObject).cubicTo(19.227718F, 1.989201F, 19.282478F, 2.020984F, 19.296652F, 2.074364F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_bgm_play
 * JD-Core Version:    0.7.0.1
 */