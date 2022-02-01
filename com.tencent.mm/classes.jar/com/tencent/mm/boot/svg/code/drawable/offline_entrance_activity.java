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

public class offline_entrance_activity
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
      ((Path)localObject).moveTo(18.0F, 3.0F);
      ((Path)localObject).cubicTo(18.552284F, 3.0F, 19.0F, 3.447715F, 19.0F, 4.0F);
      ((Path)localObject).lineTo(19.0F, 20.0F);
      ((Path)localObject).cubicTo(19.0F, 20.552284F, 18.552284F, 21.0F, 18.0F, 21.0F);
      ((Path)localObject).lineTo(6.0F, 21.0F);
      ((Path)localObject).cubicTo(5.447715F, 21.0F, 5.0F, 20.552284F, 5.0F, 20.0F);
      ((Path)localObject).lineTo(5.0F, 4.0F);
      ((Path)localObject).cubicTo(5.0F, 3.447715F, 5.447715F, 3.0F, 6.0F, 3.0F);
      ((Path)localObject).lineTo(18.0F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.799999F, 4.2F);
      ((Path)localObject).lineTo(6.2F, 4.2F);
      ((Path)localObject).lineTo(6.2F, 19.799999F);
      ((Path)localObject).lineTo(17.799999F, 19.799999F);
      ((Path)localObject).lineTo(17.799F, 14.409F);
      ((Path)localObject).lineTo(11.328912F, 17.912493F);
      ((Path)localObject).lineTo(11.269167F, 17.94499F);
      ((Path)localObject).cubicTo(11.195391F, 17.97961F, 11.112337F, 18.0F, 11.024304F, 18.0F);
      ((Path)localObject).cubicTo(10.81995F, 18.0F, 10.6423F, 17.89444F, 10.549062F, 17.738543F);
      ((Path)localObject).lineTo(10.513533F, 17.66548F);
      ((Path)localObject).lineTo(9.026025F, 14.602328F);
      ((Path)localObject).cubicTo(9.009957F, 14.568983F, 9.0F, 14.531177F, 9.0F, 14.494432F);
      ((Path)localObject).cubicTo(9.0F, 14.353402F, 9.121979F, 14.239135F, 9.272245F, 14.239135F);
      ((Path)localObject).cubicTo(9.333801F, 14.239135F, 9.389698F, 14.258038F, 9.435412F, 14.289897F);
      ((Path)localObject).lineTo(11.190413F, 15.462525F);
      ((Path)localObject).cubicTo(11.318275F, 15.541111F, 11.471936F, 15.587414F, 11.636687F, 15.587414F);
      ((Path)localObject).cubicTo(11.734677F, 15.587414F, 11.828594F, 15.570422F, 11.915722F, 15.540474F);
      ((Path)localObject).cubicTo(11.915722F, 15.540474F, 14.154441F, 14.607664F, 16.365448F, 13.686844F);
      ((Path)localObject).lineTo(16.821758F, 13.496811F);
      ((Path)localObject).cubicTo(17.154654F, 13.35818F, 17.483322F, 13.221321F, 17.799871F, 13.089524F);
      ((Path)localObject).lineTo(17.799999F, 4.2F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.5F, 9.0F);
      ((Path)localObject).lineTo(13.5F, 10.2F);
      ((Path)localObject).lineTo(7.5F, 10.2F);
      ((Path)localObject).lineTo(7.5F, 9.0F);
      ((Path)localObject).lineTo(13.5F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.5F, 6.0F);
      ((Path)localObject).lineTo(13.5F, 7.2F);
      ((Path)localObject).lineTo(7.5F, 7.2F);
      ((Path)localObject).lineTo(7.5F, 6.0F);
      ((Path)localObject).lineTo(13.5F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.offline_entrance_activity
 * JD-Core Version:    0.7.0.1
 */