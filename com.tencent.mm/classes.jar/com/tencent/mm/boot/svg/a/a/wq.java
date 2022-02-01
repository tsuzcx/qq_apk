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

public final class wq
  extends c
{
  private final int height = 25;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 25;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localPaint1.setColor(-2130706433);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -300.0F, 0.0F, 1.0F, -361.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 80.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 256.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, -1.224647E-016F, 336.0F, 1.224647E-016F, -1.0F, 62.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 25.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 14.631578F);
      ((Path)localObject).cubicTo(12.616123F, 14.631578F, 13.173965F, 14.896249F, 13.577975F, 15.324244F);
      ((Path)localObject).lineTo(11.996474F, 17.0F);
      ((Path)localObject).lineTo(10.420135F, 15.326248F);
      ((Path)localObject).cubicTo(10.824295F, 14.897076F, 11.382915F, 14.631578F, 12.0F, 14.631578F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 11.315789F);
      ((Path)localObject).cubicTo(13.479392F, 11.315789F, 14.818777F, 11.951595F, 15.788511F, 12.979636F);
      ((Path)localObject).lineTo(14.524904F, 14.318941F);
      ((Path)localObject).cubicTo(13.878475F, 13.634061F, 12.985869F, 13.210526F, 12.0F, 13.210526F);
      ((Path)localObject).cubicTo(11.012694F, 13.210526F, 10.118925F, 13.635295F, 9.472273F, 14.321935F);
      ((Path)localObject).lineTo(8.209602F, 12.981636F);
      ((Path)localObject).cubicTo(9.179486F, 11.95242F, 10.519649F, 11.315789F, 12.0F, 11.315789F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 8.0F);
      ((Path)localObject).cubicTo(14.343145F, 8.0F, 16.464466F, 9.00736F, 18.0F, 10.636039F);
      ((Path)localObject).lineTo(16.736841F, 11.975821F);
      ((Path)localObject).cubicTo(15.524578F, 10.690021F, 13.849852F, 9.894737F, 12.0F, 9.894737F);
      ((Path)localObject).cubicTo(10.149678F, 9.894737F, 8.47457F, 10.690425F, 7.262234F, 11.9768F);
      ((Path)localObject).lineTo(6.0F, 10.636039F);
      ((Path)localObject).cubicTo(7.535534F, 9.00736F, 9.656855F, 8.0F, 12.0F, 8.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.wq
 * JD-Core Version:    0.7.0.1
 */