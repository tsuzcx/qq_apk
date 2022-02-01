package com.tencent.mm.boot.svg.a.a;

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

public final class ni
  extends c
{
  private final int height = 102;
  private final int width = 102;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 102;
      return 102;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -2644.0F, 0.0F, 1.0F, -1910.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(2695.0F, 2012.0F);
      ((Path)localObject2).cubicTo(2666.8335F, 2012.0F, 2644.0F, 1989.1665F, 2644.0F, 1961.0F);
      ((Path)localObject2).cubicTo(2644.0F, 1932.8335F, 2666.8335F, 1910.0F, 2695.0F, 1910.0F);
      ((Path)localObject2).cubicTo(2723.1665F, 1910.0F, 2746.0F, 1932.8335F, 2746.0F, 1961.0F);
      ((Path)localObject2).cubicTo(2746.0F, 1989.1665F, 2723.1665F, 2012.0F, 2695.0F, 2012.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2695.0F, 2009.0F);
      ((Path)localObject2).cubicTo(2668.4902F, 2009.0F, 2647.0F, 1987.5096F, 2647.0F, 1961.0F);
      ((Path)localObject2).cubicTo(2647.0F, 1934.4904F, 2668.4902F, 1913.0F, 2695.0F, 1913.0F);
      ((Path)localObject2).cubicTo(2721.5098F, 1913.0F, 2743.0F, 1934.4904F, 2743.0F, 1961.0F);
      ((Path)localObject2).cubicTo(2743.0F, 1987.5096F, 2721.5098F, 2009.0F, 2695.0F, 2009.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2670.9629F, 1965.1285F);
      ((Path)localObject2).cubicTo(2670.7703F, 1964.9377F, 2670.7505F, 1964.6127F, 2670.9253F, 1964.3942F);
      ((Path)localObject2).lineTo(2672.8416F, 1961.9998F);
      ((Path)localObject2).cubicTo(2673.0134F, 1961.785F, 2673.332F, 1961.7294F, 2673.5615F, 1961.8812F);
      ((Path)localObject2).lineTo(2686.488F, 1970.4324F);
      ((Path)localObject2).cubicTo(2686.9482F, 1970.7368F, 2687.6741F, 1970.7001F, 2688.0981F, 1970.3591F);
      ((Path)localObject2).lineTo(2720.3496F, 1944.4258F);
      ((Path)localObject2).cubicTo(2720.5632F, 1944.254F, 2720.9004F, 1944.2769F, 2721.0906F, 1944.4653F);
      ((Path)localObject2).lineTo(2722.4705F, 1945.8309F);
      ((Path)localObject2).cubicTo(2722.6663F, 1946.0247F, 2722.6665F, 1946.3383F, 2722.4734F, 1946.5293F);
      ((Path)localObject2).lineTo(2688.0308F, 1980.6161F);
      ((Path)localObject2).cubicTo(2687.6389F, 1981.0037F, 2687.0027F, 1981.0023F, 2686.6143F, 1980.618F);
      ((Path)localObject2).lineTo(2670.9629F, 1965.1285F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ni
 * JD-Core Version:    0.7.0.1
 */