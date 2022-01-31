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

public final class ge
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 58.0F, 0.0F, 1.0F, 47.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-8421505);
      localPaint2.setStrokeWidth(6.0F);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(14.789806F, 18.17482F);
      localPath.cubicTo(16.673128F, 8.137144F, 26.477371F, 0.0F, 36.695896F, 0.0F);
      localPath.lineTo(39.304619F, 0.0F);
      localPath.cubicTo(49.519699F, 0.0F, 59.32843F, 8.142699F, 61.210709F, 18.17482F);
      localPath.lineTo(61.332733F, 18.82518F);
      localPath.cubicTo(63.216057F, 28.862856F, 56.45908F, 37.0F, 46.242638F, 37.0F);
      localPath.lineTo(29.757879F, 37.0F);
      localPath.cubicTo(19.540527F, 37.0F, 12.785503F, 28.857302F, 14.667783F, 18.82518F);
      localPath.lineTo(14.789806F, 18.17482F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-8421505);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 58.108116F);
      localPath.lineTo(0.0F, 75.191879F);
      localPath.cubicTo(0.0F, 95.135857F, 17.01318F, 98.0F, 38.0F, 98.0F);
      localPath.cubicTo(58.991436F, 98.0F, 76.0F, 95.133842F, 76.0F, 75.191879F);
      localPath.lineTo(76.0F, 58.108116F);
      localPath.cubicTo(76.0F, 57.609161F, 75.989349F, 57.112572F, 75.968262F, 56.618538F);
      localPath.cubicTo(75.989166F, 56.483299F, 76.0F, 56.344978F, 76.0F, 56.204269F);
      localPath.lineTo(76.0F, 24.845732F);
      localPath.cubicTo(76.0F, 23.275345F, 74.655647F, 22.0F, 72.997299F, 22.0F);
      localPath.lineTo(3.002698F, 22.0F);
      localPath.cubicTo(1.351378F, 22.0F, 0.0F, 23.274078F, 0.0F, 24.845732F);
      localPath.lineTo(0.0F, 56.204269F);
      localPath.cubicTo(0.0F, 56.34515F, 0.01081983F, 56.483662F, 0.03171553F, 56.619087F);
      localPath.cubicTo(0.01063978F, 57.112938F, 0.0F, 57.609348F, 0.0F, 58.108116F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 36.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(22.0F, 0.0F);
      ((Path)localObject2).cubicTo(34.150265F, 0.0F, 44.0F, 9.849735F, 44.0F, 22.0F);
      ((Path)localObject2).cubicTo(44.0F, 34.150265F, 34.150265F, 44.0F, 22.0F, 44.0F);
      ((Path)localObject2).cubicTo(9.849735F, 44.0F, 0.0F, 34.150265F, 0.0F, 22.0F);
      ((Path)localObject2).cubicTo(0.0F, 9.849735F, 9.849735F, 0.0F, 22.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8421505);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(16.388889F, 15.111111F);
      ((Path)localObject1).cubicTo(16.388889F, 13.178115F, 15.045743F, 11.611111F, 13.388889F, 11.611111F);
      ((Path)localObject1).cubicTo(11.732035F, 11.611111F, 10.388889F, 13.178115F, 10.388889F, 15.111111F);
      ((Path)localObject1).cubicTo(10.388889F, 17.044107F, 11.732035F, 18.611111F, 13.388889F, 18.611111F);
      ((Path)localObject1).cubicTo(15.045743F, 18.611111F, 16.388889F, 17.044107F, 16.388889F, 15.111111F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(33.388889F, 15.111111F);
      ((Path)localObject1).cubicTo(33.388889F, 13.178115F, 32.045742F, 11.611111F, 30.388889F, 11.611111F);
      ((Path)localObject1).cubicTo(28.732035F, 11.611111F, 27.388889F, 13.178115F, 27.388889F, 15.111111F);
      ((Path)localObject1).cubicTo(27.388889F, 17.044107F, 28.732035F, 18.611111F, 30.388889F, 18.611111F);
      ((Path)localObject1).cubicTo(32.045742F, 18.611111F, 33.388889F, 17.044107F, 33.388889F, 15.111111F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(37.0F, 23.0F);
      ((Path)localObject1).cubicTo(36.362629F, 30.839403F, 29.890337F, 37.0F, 22.0F, 37.0F);
      ((Path)localObject1).cubicTo(14.109663F, 37.0F, 7.63737F, 30.839403F, 7.0F, 23.0F);
      ((Path)localObject1).lineTo(37.0F, 23.0F);
      ((Path)localObject1).lineTo(37.0F, 23.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ge
 * JD-Core Version:    0.7.0.1
 */