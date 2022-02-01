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

public class icons_outlined_mic_on
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.546735F, 8.0F);
      ((Path)localObject).lineTo(11.546735F, 16.0F);
      ((Path)localObject).cubicTo(11.546735F, 18.430054F, 13.533122F, 20.4F, 15.983455F, 20.4F);
      ((Path)localObject).cubicTo(18.433788F, 20.4F, 20.420176F, 18.430054F, 20.420176F, 16.0F);
      ((Path)localObject).lineTo(20.420176F, 8.0F);
      ((Path)localObject).cubicTo(20.420176F, 5.569947F, 18.433788F, 3.6F, 15.983455F, 3.6F);
      ((Path)localObject).cubicTo(13.533122F, 3.6F, 11.546735F, 5.569947F, 11.546735F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.513353F, 14.0F);
      ((Path)localObject).lineTo(7.513353F, 16.0F);
      ((Path)localObject).cubicTo(7.513353F, 20.639193F, 11.305547F, 24.4F, 15.983455F, 24.4F);
      ((Path)localObject).cubicTo(20.661364F, 24.4F, 24.453558F, 20.639193F, 24.453558F, 16.0F);
      ((Path)localObject).lineTo(24.453558F, 14.0F);
      ((Path)localObject).lineTo(26.06691F, 14.0F);
      ((Path)localObject).lineTo(26.06691F, 16.0F);
      ((Path)localObject).cubicTo(26.06691F, 21.253473F, 21.98204F, 25.56077F, 16.790396F, 25.968445F);
      ((Path)localObject).lineTo(16.790131F, 30.0F);
      ((Path)localObject).lineTo(15.176778F, 30.0F);
      ((Path)localObject).lineTo(15.176515F, 25.968445F);
      ((Path)localObject).cubicTo(9.984869F, 25.56077F, 5.9F, 21.253473F, 5.9F, 16.0F);
      ((Path)localObject).lineTo(5.9F, 14.0F);
      ((Path)localObject).lineTo(7.513353F, 14.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.983455F, 2.0F);
      ((Path)localObject).cubicTo(19.324818F, 2.0F, 22.033527F, 4.686292F, 22.033527F, 8.0F);
      ((Path)localObject).lineTo(22.033527F, 16.0F);
      ((Path)localObject).cubicTo(22.033527F, 19.313709F, 19.324818F, 22.0F, 15.983455F, 22.0F);
      ((Path)localObject).cubicTo(12.642092F, 22.0F, 9.933382F, 19.313709F, 9.933382F, 16.0F);
      ((Path)localObject).lineTo(9.933382F, 8.0F);
      ((Path)localObject).cubicTo(9.933382F, 4.686292F, 12.642092F, 2.0F, 15.983455F, 2.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_mic_on
 * JD-Core Version:    0.7.0.1
 */