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

public class finder_full_share
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
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      Paint localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Paint localPaint3 = c.instancePaint((Paint)localObject, paramVarArgs);
      localPaint2.setColor(-2565928);
      localPaint3.setColor(-6842473);
      localPaint3.setStrokeWidth(3.0F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(1.5F, 1.5F);
      ((Path)localObject).lineTo(70.5F, 1.5F);
      ((Path)localObject).lineTo(70.5F, 70.5F);
      ((Path)localObject).lineTo(1.5F, 70.5F);
      ((Path)localObject).lineTo(1.5F, 1.5F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint3 = c.instancePaint(localPaint3, paramVarArgs);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.drawPath((Path)localObject, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(42.150291F, 9.0F);
      ((Path)localObject).cubicTo(42.928261F, 9.0F, 43.677906F, 9.274708F, 44.269539F, 9.770407F);
      ((Path)localObject).lineTo(44.483742F, 9.966548F);
      ((Path)localObject).lineTo(60.801762F, 26.284567F);
      ((Path)localObject).cubicTo(62.598175F, 28.080978F, 62.673027F, 30.947031F, 61.026314F, 32.832581F);
      ((Path)localObject).lineTo(60.801762F, 33.072792F);
      ((Path)localObject).lineTo(44.483742F, 49.390812F);
      ((Path)localObject).cubicTo(43.195015F, 50.679543F, 41.105568F, 50.679543F, 39.816837F, 49.390812F);
      ((Path)localObject).cubicTo(39.266731F, 48.840706F, 38.930901F, 48.116379F, 38.863064F, 47.347515F);
      ((Path)localObject).lineTo(38.850292F, 47.057358F);
      ((Path)localObject).lineTo(38.848877F, 37.210567F);
      ((Path)localObject).cubicTo(30.454565F, 37.514618F, 24.104624F, 41.666443F, 19.317652F, 48.589512F);
      ((Path)localObject).cubicTo(17.633574F, 51.025078F, 16.300003F, 53.570847F, 15.158597F, 56.29031F);
      ((Path)localObject).lineTo(14.739267F, 57.318371F);
      ((Path)localObject).lineTo(14.520645F, 57.882141F);
      ((Path)localObject).lineTo(13.831736F, 59.713699F);
      ((Path)localObject).lineTo(13.592604F, 60.321098F);
      ((Path)localObject).cubicTo(13.206709F, 61.162777F, 12.397072F, 61.68232F, 11.352628F, 61.469685F);
      ((Path)localObject).cubicTo(10.308184F, 61.25705F, 10.086042F, 60.282413F, 10.003558F, 59.667286F);
      ((Path)localObject).cubicTo(8.119613F, 38.408981F, 19.10014F, 22.050562F, 38.849327F, 20.036772F);
      ((Path)localObject).lineTo(38.850292F, 12.3F);
      ((Path)localObject).cubicTo(38.850292F, 10.47746F, 40.327751F, 9.0F, 42.150291F, 9.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_full_share
 * JD-Core Version:    0.7.0.1
 */