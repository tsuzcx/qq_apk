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

public class finder_full_share_outlined
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(39.011105F, 8.994088F);
      ((Path)localObject).cubicTo(39.8018F, 8.994088F, 40.560524F, 9.306245F, 41.122288F, 9.862679F);
      ((Path)localObject).lineTo(62.636173F, 31.172398F);
      ((Path)localObject).cubicTo(63.722767F, 32.248684F, 63.814068F, 33.949959F, 62.904613F, 35.131184F);
      ((Path)localObject).lineTo(62.636173F, 35.435219F);
      ((Path)localObject).lineTo(41.122288F, 56.744938F);
      ((Path)localObject).cubicTo(39.945141F, 57.910912F, 38.04567F, 57.901855F, 36.879696F, 56.724712F);
      ((Path)localObject).cubicTo(36.323261F, 56.162945F, 36.011105F, 55.404224F, 36.011105F, 54.613529F);
      ((Path)localObject).lineTo(36.011105F, 44.764744F);
      ((Path)localObject).cubicTo(28.995237F, 45.328629F, 18.754921F, 49.474026F, 13.427593F, 62.465485F);
      ((Path)localObject).cubicTo(12.542523F, 64.623856F, 10.371325F, 64.605209F, 9.898796F, 61.807617F);
      ((Path)localObject).cubicTo(6.159348F, 39.668301F, 18.754921F, 24.644394F, 36.011105F, 21.925137F);
      ((Path)localObject).lineTo(36.011105F, 11.994088F);
      ((Path)localObject).cubicTo(36.011105F, 10.337234F, 37.354252F, 8.994088F, 39.011105F, 8.994088F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.609001F, 13.434F);
      ((Path)localObject).lineTo(39.611103F, 25.002266F);
      ((Path)localObject).lineTo(36.571484F, 25.481255F);
      ((Path)localObject).cubicTo(22.094788F, 27.762516F, 12.642968F, 39.040146F, 12.850238F, 54.758244F);
      ((Path)localObject).lineTo(12.87F, 55.619999F);
      ((Path)localObject).lineTo(12.945931F, 55.495522F);
      ((Path)localObject).cubicTo(18.267673F, 46.925255F, 26.308218F, 42.200375F, 34.865341F, 41.25795F);
      ((Path)localObject).lineTo(35.722694F, 41.176315F);
      ((Path)localObject).lineTo(39.611103F, 40.863792F);
      ((Path)localObject).lineTo(39.609001F, 53.172001F);
      ((Path)localObject).lineTo(59.673F, 33.303001F);
      ((Path)localObject).lineTo(39.609001F, 13.434F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_full_share_outlined
 * JD-Core Version:    0.7.0.1
 */