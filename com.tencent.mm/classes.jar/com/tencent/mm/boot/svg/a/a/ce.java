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

public final class ce
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-14776843);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(68.0F, 87.0F);
      ((Path)localObject2).cubicTo(68.0F, 88.656853F, 66.656853F, 90.0F, 65.0F, 90.0F);
      ((Path)localObject2).lineTo(3.0F, 90.0F);
      ((Path)localObject2).cubicTo(1.343146F, 90.0F, 2.029061E-016F, 88.656853F, 0.0F, 87.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15177020);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(49.0F, 22.0F);
      ((Path)localObject2).cubicTo(47.343147F, 22.0F, 46.0F, 20.656855F, 46.0F, 19.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(33.0F, 70.0F);
      ((Path)localObject1).lineTo(33.0F, 58.0F);
      ((Path)localObject1).lineTo(21.0F, 58.0F);
      ((Path)localObject1).cubicTo(19.343145F, 58.0F, 18.0F, 56.656853F, 18.0F, 55.0F);
      ((Path)localObject1).lineTo(50.0F, 55.0F);
      ((Path)localObject1).cubicTo(50.0F, 56.656853F, 48.656853F, 58.0F, 47.0F, 58.0F);
      ((Path)localObject1).lineTo(35.0F, 58.0F);
      ((Path)localObject1).lineTo(35.0F, 70.0F);
      ((Path)localObject1).lineTo(41.0F, 70.0F);
      ((Path)localObject1).cubicTo(41.552284F, 70.0F, 42.0F, 70.447716F, 42.0F, 71.0F);
      ((Path)localObject1).cubicTo(42.0F, 71.552284F, 41.552284F, 72.0F, 41.0F, 72.0F);
      ((Path)localObject1).lineTo(27.0F, 72.0F);
      ((Path)localObject1).cubicTo(26.447716F, 72.0F, 26.0F, 71.552284F, 26.0F, 71.0F);
      ((Path)localObject1).cubicTo(26.0F, 70.447716F, 26.447716F, 70.0F, 27.0F, 70.0F);
      ((Path)localObject1).lineTo(33.0F, 70.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(22.963263F, 40.0F);
      ((Path)localObject1).lineTo(45.036739F, 40.0F);
      ((Path)localObject1).cubicTo(45.754581F, 40.0F, 46.371803F, 40.508587F, 46.50906F, 41.213184F);
      ((Path)localObject1).lineTo(49.0F, 54.0F);
      ((Path)localObject1).lineTo(19.0F, 54.0F);
      ((Path)localObject1).lineTo(21.490938F, 41.213184F);
      ((Path)localObject1).cubicTo(21.628197F, 40.508587F, 22.245419F, 40.0F, 22.963263F, 40.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.941095F, 50.631794F);
      ((Path)localObject1).lineTo(31.59338F, 47.182507F);
      ((Path)localObject1).lineTo(34.927055F, 49.438576F);
      ((Path)localObject1).cubicTo(35.184135F, 49.606796F, 35.522869F, 49.573586F, 35.734356F, 49.359222F);
      ((Path)localObject1).lineTo(40.377838F, 44.271843F);
      ((Path)localObject1).lineTo(39.461632F, 43.371574F);
      ((Path)localObject1).lineTo(35.178921F, 48.090324F);
      ((Path)localObject1).lineTo(31.900051F, 45.834148F);
      ((Path)localObject1).cubicTo(31.664028F, 45.665886F, 31.341633F, 45.699165F, 31.127651F, 45.913658F);
      ((Path)localObject1).lineTo(27.104361F, 49.731842F);
      ((Path)localObject1).lineTo(27.941095F, 50.631794F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ce
 * JD-Core Version:    0.7.0.1
 */