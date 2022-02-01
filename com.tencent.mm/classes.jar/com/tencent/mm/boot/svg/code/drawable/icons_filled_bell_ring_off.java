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

public class icons_filled_bell_ring_off
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
      ((Path)localObject).moveTo(55.359299F, 48.995338F);
      ((Path)localObject).lineTo(66.27565F, 59.91169F);
      ((Path)localObject).lineTo(63.09367F, 63.09367F);
      ((Path)localObject).lineTo(12.18198F, 12.18198F);
      ((Path)localObject).lineTo(15.363961F, 9.0F);
      ((Path)localObject).lineTo(23.455351F, 17.091391F);
      ((Path)localObject).cubicTo(25.319427F, 15.279549F, 27.574619F, 13.867977F, 30.08219F, 12.995409F);
      ((Path)localObject).cubicTo(30.028131F, 12.671648F, 30.0F, 12.339109F, 30.0F, 12.0F);
      ((Path)localObject).cubicTo(30.0F, 8.686292F, 32.686291F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(39.313709F, 6.0F, 42.0F, 8.686292F, 42.0F, 12.0F);
      ((Path)localObject).cubicTo(42.0F, 12.339109F, 41.971867F, 12.671648F, 41.917809F, 12.995409F);
      ((Path)localObject).cubicTo(48.951862F, 15.443072F, 54.0F, 22.132008F, 54.0F, 30.0F);
      ((Path)localObject).lineTo(54.0F, 42.0F);
      ((Path)localObject).cubicTo(54.0F, 44.331779F, 54.453098F, 46.663559F, 55.359299F, 48.995338F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(53.636112F, 60.000072F);
      ((Path)localObject).lineTo(39.0F, 60.000011F);
      ((Path)localObject).lineTo(39.0F, 60.599998F);
      ((Path)localObject).cubicTo(39.0F, 62.256855F, 37.656853F, 63.599998F, 36.0F, 63.599998F);
      ((Path)localObject).cubicTo(34.343147F, 63.599998F, 33.0F, 62.256855F, 33.0F, 60.599998F);
      ((Path)localObject).lineTo(33.0F, 60.0F);
      ((Path)localObject).lineTo(15.560121F, 60.0F);
      ((Path)localObject).cubicTo(14.921177F, 60.0F, 14.298923F, 59.795994F, 13.784002F, 59.417702F);
      ((Path)localObject).cubicTo(12.448801F, 58.436779F, 12.161601F, 56.559189F, 13.142524F, 55.223988F);
      ((Path)localObject).cubicTo(16.380814F, 50.815952F, 18.0F, 46.407974F, 18.0F, 42.0F);
      ((Path)localObject).lineTo(18.0F, 30.0F);
      ((Path)localObject).cubicTo(18.0F, 28.284155F, 18.240082F, 26.624384F, 18.688486F, 25.052446F);
      ((Path)localObject).lineTo(53.636112F, 60.000072F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_bell_ring_off
 * JD-Core Version:    0.7.0.1
 */