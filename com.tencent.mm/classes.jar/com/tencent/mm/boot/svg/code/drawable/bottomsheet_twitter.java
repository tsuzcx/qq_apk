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

public class bottomsheet_twitter
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localPaint.setColor(-9276814);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(136.0F, 32.327599F);
      ((Path)localObject).cubicTo(131.26967F, 34.436882F, 126.21149F, 35.843071F, 120.91914F, 36.452423F);
      ((Path)localObject).cubicTo(126.352F, 33.218185F, 130.52031F, 28.062155F, 132.48738F, 21.921793F);
      ((Path)localObject).cubicTo(127.4292F, 24.921665F, 121.809F, 27.124695F, 115.81413F, 28.29652F);
      ((Path)localObject).cubicTo(111.03696F, 23.187365F, 104.19905F, 20.0F, 96.658615F, 20.0F);
      ((Path)localObject).cubicTo(82.139771F, 20.0F, 70.384193F, 31.765121F, 70.384193F, 46.29575F);
      ((Path)localObject).cubicTo(70.384193F, 48.358162F, 70.61837F, 50.373699F, 71.086716F, 52.295494F);
      ((Path)localObject).cubicTo(49.261616F, 51.217415F, 29.91877F, 40.717865F, 16.94548F, 24.827919F);
      ((Path)localObject).cubicTo(14.697402F, 28.718376F, 13.386023F, 33.218185F, 13.386023F, 38.046104F);
      ((Path)localObject).cubicTo(13.386023F, 47.186337F, 18.022686F, 55.201618F, 25.094769F, 59.935791F);
      ((Path)localObject).cubicTo(20.78595F, 59.795174F, 16.758141F, 58.623348F, 13.198683F, 56.654682F);
      ((Path)localObject).lineTo(13.198683F, 56.982792F);
      ((Path)localObject).cubicTo(13.198683F, 69.732246F, 22.237833F, 80.325546F, 34.274426F, 82.762939F);
      ((Path)localObject).cubicTo(32.073181F, 83.372292F, 29.73143F, 83.700401F, 27.342846F, 83.700401F);
      ((Path)localObject).cubicTo(25.656788F, 83.700401F, 24.017563F, 83.512909F, 22.378338F, 83.231674F);
      ((Path)localObject).cubicTo(25.703623F, 93.684349F, 35.445297F, 101.27777F, 46.919868F, 101.51214F);
      ((Path)localObject).cubicTo(37.927551F, 108.54309F, 26.593487F, 112.76166F, 14.275887F, 112.76166F);
      ((Path)localObject).cubicTo(12.168313F, 112.76166F, 10.06074F, 112.62104F, 8.0F, 112.38667F);
      ((Path)localObject).cubicTo(19.615074F, 119.83948F, 33.431393F, 124.19867F, 48.278084F, 124.19867F);
      ((Path)localObject).cubicTo(96.611778F, 124.19867F, 123.02671F, 84.122261F, 123.02671F, 49.389366F);
      ((Path)localObject).cubicTo(123.02671F, 48.264416F, 122.97987F, 47.09259F, 122.93304F, 45.96764F);
      ((Path)localObject).cubicTo(128.03806F, 42.264671F, 132.48738F, 37.624245F, 136.0F, 32.327599F);
      ((Path)localObject).lineTo(136.0F, 32.327599F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_twitter
 * JD-Core Version:    0.7.0.1
 */