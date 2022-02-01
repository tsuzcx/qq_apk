package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class tn
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(39.144001F, 13.0F);
      ((Path)localObject).cubicTo(45.408001F, 13.0F, 50.231998F, 15.232F, 53.543999F, 19.768F);
      ((Path)localObject).cubicTo(56.855999F, 24.232F, 58.512001F, 30.351999F, 58.512001F, 38.271999F);
      ((Path)localObject).cubicTo(58.512001F, 46.624001F, 56.712002F, 53.464001F, 53.256001F, 58.647999F);
      ((Path)localObject).cubicTo(49.728001F, 63.832001F, 44.976002F, 66.424004F, 39.071999F, 66.424004F);
      ((Path)localObject).cubicTo(28.92F, 66.424004F, 23.232F, 61.743999F, 22.007999F, 52.383999F);
      ((Path)localObject).lineTo(30.216F, 52.383999F);
      ((Path)localObject).cubicTo(31.224001F, 57.136002F, 34.175999F, 59.512001F, 39.144001F, 59.512001F);
      ((Path)localObject).cubicTo(42.528F, 59.512001F, 45.264F, 57.784F, 47.352001F, 54.472F);
      ((Path)localObject).cubicTo(49.296001F, 51.304001F, 50.304001F, 47.344002F, 50.304001F, 42.591999F);
      ((Path)localObject).lineTo(50.304001F, 41.944F);
      ((Path)localObject).lineTo(49.944F, 41.944F);
      ((Path)localObject).cubicTo(48.431999F, 44.032001F, 46.632F, 45.616001F, 44.543999F, 46.624001F);
      ((Path)localObject).cubicTo(42.528F, 47.560001F, 40.223999F, 48.063999F, 37.632F, 48.063999F);
      ((Path)localObject).cubicTo(32.591999F, 48.063999F, 28.488001F, 46.408001F, 25.464001F, 43.096001F);
      ((Path)localObject).cubicTo(22.440001F, 39.928001F, 21.0F, 35.824001F, 21.0F, 30.784F);
      ((Path)localObject).cubicTo(21.0F, 25.6F, 22.728001F, 21.351999F, 26.184F, 18.040001F);
      ((Path)localObject).cubicTo(29.639999F, 14.656F, 33.959999F, 13.0F, 39.144001F, 13.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.431999F, 19.983999F);
      ((Path)localObject).cubicTo(36.408001F, 19.983999F, 33.959999F, 20.992001F, 32.088001F, 23.007999F);
      ((Path)localObject).cubicTo(30.216F, 25.024F, 29.351999F, 27.615999F, 29.351999F, 30.784F);
      ((Path)localObject).cubicTo(29.351999F, 33.952F, 30.216F, 36.472F, 32.088001F, 38.344002F);
      ((Path)localObject).cubicTo(33.816002F, 40.216F, 36.264F, 41.223999F, 39.431999F, 41.223999F);
      ((Path)localObject).cubicTo(42.528F, 41.223999F, 44.976002F, 40.216F, 46.776001F, 38.344002F);
      ((Path)localObject).cubicTo(48.504002F, 36.400002F, 49.439999F, 33.807999F, 49.439999F, 30.496F);
      ((Path)localObject).cubicTo(49.439999F, 27.184F, 48.504002F, 24.664F, 46.632F, 22.792F);
      ((Path)localObject).cubicTo(44.759998F, 20.92F, 42.312F, 19.983999F, 39.431999F, 19.983999F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.tn
 * JD-Core Version:    0.7.0.1
 */