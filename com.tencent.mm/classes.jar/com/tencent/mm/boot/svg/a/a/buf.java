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

public final class buf
  extends c
{
  private final int height = 67;
  private final int width = 67;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 67;
      return 67;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(35.416668F, 58.488819F);
      ((Path)localObject).lineTo(35.416668F, 67.0F);
      ((Path)localObject).lineTo(31.25F, 67.0F);
      ((Path)localObject).lineTo(31.25F, 58.488819F);
      ((Path)localObject).cubicTo(21.490765F, 57.440975F, 13.888889F, 49.115345F, 13.888889F, 39.0F);
      ((Path)localObject).lineTo(13.888889F, 33.400002F);
      ((Path)localObject).lineTo(18.055555F, 33.400002F);
      ((Path)localObject).lineTo(18.055555F, 39.0F);
      ((Path)localObject).cubicTo(18.055555F, 47.505184F, 24.895649F, 54.400002F, 33.333332F, 54.400002F);
      ((Path)localObject).cubicTo(41.771015F, 54.400002F, 48.611111F, 47.505184F, 48.611111F, 39.0F);
      ((Path)localObject).lineTo(48.611111F, 33.400002F);
      ((Path)localObject).lineTo(52.777779F, 33.400002F);
      ((Path)localObject).lineTo(52.777779F, 39.0F);
      ((Path)localObject).cubicTo(52.777779F, 49.115345F, 45.175903F, 57.440975F, 35.416668F, 58.488819F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.222221F, 22.111111F);
      ((Path)localObject).cubicTo(22.222221F, 15.974614F, 27.196836F, 11.0F, 33.333332F, 11.0F);
      ((Path)localObject).cubicTo(39.46983F, 11.0F, 44.444443F, 15.974614F, 44.444443F, 22.111111F);
      ((Path)localObject).lineTo(44.444443F, 39.08889F);
      ((Path)localObject).cubicTo(44.444443F, 45.225388F, 39.46983F, 50.200001F, 33.333332F, 50.200001F);
      ((Path)localObject).cubicTo(27.196836F, 50.200001F, 22.222221F, 45.225388F, 22.222221F, 39.08889F);
      ((Path)localObject).lineTo(22.222221F, 22.111111F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.buf
 * JD-Core Version:    0.7.0.1
 */