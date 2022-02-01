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

public class icons_outlined_htov_new
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(18.0F, 10.0F);
      ((Path)localObject).cubicTo(18.552284F, 10.0F, 19.0F, 10.447716F, 19.0F, 11.0F);
      ((Path)localObject).lineTo(19.0F, 19.0F);
      ((Path)localObject).cubicTo(19.0F, 19.552284F, 18.552284F, 20.0F, 18.0F, 20.0F);
      ((Path)localObject).lineTo(5.0F, 20.0F);
      ((Path)localObject).cubicTo(4.447715F, 20.0F, 4.0F, 19.552284F, 4.0F, 19.0F);
      ((Path)localObject).lineTo(4.0F, 11.0F);
      ((Path)localObject).cubicTo(4.0F, 10.447716F, 4.447715F, 10.0F, 5.0F, 10.0F);
      ((Path)localObject).lineTo(18.0F, 10.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.5F, 11.5F);
      ((Path)localObject).lineTo(5.5F, 11.5F);
      ((Path)localObject).lineTo(5.5F, 18.5F);
      ((Path)localObject).lineTo(17.5F, 18.5F);
      ((Path)localObject).lineTo(17.5F, 11.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.0F, 4.25F);
      ((Path)localObject).cubicTo(19.648605F, 4.25F, 22.621082F, 7.144847F, 22.745918F, 10.763028F);
      ((Path)localObject).lineTo(22.75F, 11.0F);
      ((Path)localObject).lineTo(21.25F, 11.0F);
      ((Path)localObject).cubicTo(21.25F, 8.172993F, 19.015551F, 5.867868F, 16.216404F, 5.754379F);
      ((Path)localObject).lineTo(16.0F, 5.75F);
      ((Path)localObject).lineTo(16.0F, 4.25F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.579505F, 2.079505F);
      ((Path)localObject).lineTo(16.640165F, 3.140165F);
      ((Path)localObject).lineTo(15.53F, 4.249505F);
      ((Path)localObject).lineTo(16.0F, 4.25F);
      ((Path)localObject).lineTo(16.0F, 5.75F);
      ((Path)localObject).lineTo(15.31F, 5.749505F);
      ((Path)localObject).lineTo(16.640165F, 7.079505F);
      ((Path)localObject).lineTo(15.579505F, 8.140165F);
      ((Path)localObject).lineTo(13.079505F, 5.640165F);
      ((Path)localObject).cubicTo(12.813238F, 5.373899F, 12.789032F, 4.957235F, 13.006886F, 4.663623F);
      ((Path)localObject).lineTo(13.079505F, 4.579505F);
      ((Path)localObject).lineTo(15.579505F, 2.079505F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_htov_new
 * JD-Core Version:    0.7.0.1
 */