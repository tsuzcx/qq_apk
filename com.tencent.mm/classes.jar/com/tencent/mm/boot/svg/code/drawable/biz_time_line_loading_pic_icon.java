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

public class biz_time_line_loading_pic_icon
  extends c
{
  private final int height = 13;
  private final int width = 17;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 17;
      return 13;
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
      localPaint.setColor(-5066062);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(15.8F, 8.795279F);
      ((Path)localObject).lineTo(15.8F, 1.2F);
      ((Path)localObject).lineTo(1.2F, 1.2F);
      ((Path)localObject).lineTo(1.2F, 8.248441F);
      ((Path)localObject).lineTo(5.166038F, 5.041049F);
      ((Path)localObject).cubicTo(5.551499F, 4.729321F, 6.170521F, 4.744439F, 6.542079F, 5.070903F);
      ((Path)localObject).lineTo(10.272436F, 8.348522F);
      ((Path)localObject).lineTo(12.174253F, 6.731248F);
      ((Path)localObject).cubicTo(12.559431F, 6.403698F, 13.172269F, 6.410352F, 13.546193F, 6.745903F);
      ((Path)localObject).lineTo(15.8F, 8.795279F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.8F, 10.108209F);
      ((Path)localObject).lineTo(12.855153F, 7.497908F);
      ((Path)localObject).lineTo(11.122643F, 9.095543F);
      ((Path)localObject).lineTo(12.152032F, 10.0F);
      ((Path)localObject).lineTo(10.595221F, 10.0F);
      ((Path)localObject).lineTo(5.83838F, 5.9897F);
      ((Path)localObject).lineTo(1.2F, 9.74638F);
      ((Path)localObject).lineTo(1.2F, 11.8F);
      ((Path)localObject).lineTo(15.8F, 11.8F);
      ((Path)localObject).lineTo(15.8F, 10.108209F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(0.8430327F, -1.501022E-013F);
      ((Path)localObject).lineTo(16.156967F, -1.501022E-013F);
      ((Path)localObject).cubicTo(16.612989F, -1.501022E-013F, 17.0F, 0.3909238F, 17.0F, 0.8731528F);
      ((Path)localObject).lineTo(17.0F, 12.126847F);
      ((Path)localObject).cubicTo(17.0F, 12.610936F, 16.622561F, 13.0F, 16.156967F, 13.0F);
      ((Path)localObject).lineTo(0.8430327F, 13.0F);
      ((Path)localObject).cubicTo(0.3870097F, 13.0F, 1.545431E-013F, 12.609076F, 1.545431E-013F, 12.126847F);
      ((Path)localObject).lineTo(1.545431E-013F, 0.8731528F);
      ((Path)localObject).cubicTo(1.545431E-013F, 0.3890642F, 0.3774386F, -1.501022E-013F, 0.8430327F, -1.501022E-013F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.biz_time_line_loading_pic_icon
 * JD-Core Version:    0.7.0.1
 */