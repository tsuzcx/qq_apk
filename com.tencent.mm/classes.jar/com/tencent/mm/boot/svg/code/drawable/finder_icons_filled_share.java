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

public class finder_icons_filled_share
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
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      Paint localPaint3 = c.instancePaint((Paint)localObject1, paramVarArgs);
      Paint localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-2565928);
      localPaint2.setColor(-6842473);
      localPaint2.setStrokeWidth(3.0F);
      Object localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.5F, 1.5F);
      ((Path)localObject2).lineTo(70.5F, 1.5F);
      ((Path)localObject2).lineTo(70.5F, 70.5F);
      ((Path)localObject2).lineTo(1.5F, 70.5F);
      ((Path)localObject2).lineTo(1.5F, 1.5F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localPaint3 = c.instancePaint(localPaint3, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localCanvas.drawPath((Path)localObject2, localPaint3);
      localCanvas.drawPath((Path)localObject2, localPaint2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setColor(-16777216);
      localPaint1.setStrokeWidth(3.6F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(43.5F, 12.006086F);
      ((Path)localObject1).cubicTo(43.897823F, 12.006086F, 44.279354F, 12.164122F, 44.560661F, 12.445426F);
      ((Path)localObject1).lineTo(60.878681F, 28.763445F);
      ((Path)localObject1).cubicTo(62.050251F, 29.935019F, 62.050251F, 31.834513F, 60.878681F, 33.006084F);
      ((Path)localObject1).lineTo(44.560661F, 49.324104F);
      ((Path)localObject1).cubicTo(43.974873F, 49.909893F, 43.025127F, 49.909893F, 42.439339F, 49.324104F);
      ((Path)localObject1).cubicTo(42.158035F, 49.042801F, 42.0F, 48.66127F, 42.0F, 48.263447F);
      ((Path)localObject1).lineTo(41.999756F, 36.611099F);
      ((Path)localObject1).cubicTo(18.210701F, 36.019882F, 13.14624F, 63.715797F, 13.14624F, 60.714478F);
      ((Path)localObject1).cubicTo(11.452737F, 41.605106F, 20.863182F, 24.122755F, 41.999332F, 22.901964F);
      ((Path)localObject1).lineTo(42.0F, 13.506086F);
      ((Path)localObject1).cubicTo(42.0F, 12.677659F, 42.671574F, 12.006086F, 43.5F, 12.006086F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 230, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icons_filled_share
 * JD-Core Version:    0.7.0.1
 */