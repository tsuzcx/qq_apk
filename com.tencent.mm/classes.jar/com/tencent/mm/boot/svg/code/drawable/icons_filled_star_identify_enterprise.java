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

public class icons_filled_star_identify_enterprise
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
      localPaint.setColor(-15432210);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(49.138592F, 8.140941F);
      ((Path)localObject).lineTo(53.442348F, 18.53124F);
      ((Path)localObject).lineTo(63.834362F, 22.836712F);
      ((Path)localObject).cubicTo(64.912003F, 23.283083F, 65.423744F, 24.518536F, 64.977371F, 25.596172F);
      ((Path)localObject).lineTo(60.672184F, 35.985615F);
      ((Path)localObject).lineTo(64.977371F, 46.379131F);
      ((Path)localObject).cubicTo(65.423744F, 47.456768F, 64.912003F, 48.692223F, 63.834362F, 49.138592F);
      ((Path)localObject).lineTo(53.441765F, 53.441395F);
      ((Path)localObject).lineTo(49.138592F, 63.834362F);
      ((Path)localObject).cubicTo(48.692223F, 64.912003F, 47.456768F, 65.423744F, 46.379131F, 64.977371F);
      ((Path)localObject).lineTo(35.987389F, 60.671234F);
      ((Path)localObject).lineTo(25.596172F, 64.977371F);
      ((Path)localObject).cubicTo(24.518536F, 65.423744F, 23.283083F, 64.912003F, 22.836712F, 63.834362F);
      ((Path)localObject).lineTo(18.53161F, 53.440811F);
      ((Path)localObject).lineTo(8.140941F, 49.138592F);
      ((Path)localObject).cubicTo(7.063304F, 48.692223F, 6.551563F, 47.456768F, 6.997934F, 46.379131F);
      ((Path)localObject).lineTo(11.301771F, 35.986439F);
      ((Path)localObject).lineTo(6.997934F, 25.596172F);
      ((Path)localObject).cubicTo(6.551563F, 24.518536F, 7.063304F, 23.283083F, 8.140941F, 22.836712F);
      ((Path)localObject).lineTo(18.532192F, 18.530659F);
      ((Path)localObject).lineTo(22.836712F, 8.140941F);
      ((Path)localObject).cubicTo(23.283083F, 7.063304F, 24.518536F, 6.551563F, 25.596172F, 6.997934F);
      ((Path)localObject).lineTo(35.986568F, 11.300819F);
      ((Path)localObject).lineTo(46.379131F, 6.997934F);
      ((Path)localObject).cubicTo(47.456768F, 6.551563F, 48.692223F, 7.063304F, 49.138592F, 8.140941F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(49.268261F, 25.620001F);
      ((Path)localObject).lineTo(32.47031F, 42.41795F);
      ((Path)localObject).lineTo(24.172613F, 34.120251F);
      ((Path)localObject).lineTo(21.0F, 37.292862F);
      ((Path)localObject).lineTo(31.119827F, 47.42001F);
      ((Path)localObject).lineTo(31.119827F, 47.42001F);
      ((Path)localObject).lineTo(31.24193F, 47.532612F);
      ((Path)localObject).cubicTo(31.996153F, 48.168339F, 33.124615F, 48.131176F, 33.834908F, 47.420784F);
      ((Path)localObject).lineTo(33.834908F, 47.420784F);
      ((Path)localObject).lineTo(52.455845F, 28.807583F);
      ((Path)localObject).lineTo(49.268261F, 25.620001F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_star_identify_enterprise
 * JD-Core Version:    0.7.0.1
 */