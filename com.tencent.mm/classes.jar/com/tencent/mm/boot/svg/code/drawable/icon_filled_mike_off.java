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

public class icon_filled_mike_off
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.803045F, 14.681725F);
      ((Path)localObject).cubicTo(17.246958F, 13.888364F, 17.5F, 12.973733F, 17.5F, 12.0F);
      ((Path)localObject).lineTo(17.5F, 10.0F);
      ((Path)localObject).lineTo(19.0F, 10.0F);
      ((Path)localObject).lineTo(19.0F, 12.0F);
      ((Path)localObject).cubicTo(19.0F, 13.390109F, 18.594795F, 14.685577F, 17.896053F, 15.774734F);
      ((Path)localObject).lineTo(22.091883F, 19.970562F);
      ((Path)localObject).lineTo(21.031223F, 21.031223F);
      ((Path)localObject).lineTo(4.06066F, 4.06066F);
      ((Path)localObject).lineTo(5.12132F, 3.0F);
      ((Path)localObject).lineTo(8.001753F, 5.880433F);
      ((Path)localObject).cubicTo(8.064982F, 3.726602F, 9.830856F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).cubicTo(14.209139F, 2.0F, 16.0F, 3.790861F, 16.0F, 6.0F);
      ((Path)localObject).lineTo(16.0F, 12.0F);
      ((Path)localObject).cubicTo(16.0F, 12.554274F, 15.887263F, 13.082216F, 15.68347F, 13.562149F);
      ((Path)localObject).lineTo(16.803045F, 14.681725F);
      ((Path)localObject).lineTo(16.803045F, 14.681725F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.681725F, 16.803045F);
      ((Path)localObject).lineTo(15.774734F, 17.896053F);
      ((Path)localObject).cubicTo(14.884093F, 18.467438F, 13.855494F, 18.842539F, 12.75F, 18.960293F);
      ((Path)localObject).lineTo(12.75F, 22.0F);
      ((Path)localObject).lineTo(11.25F, 22.0F);
      ((Path)localObject).lineTo(11.25F, 18.960293F);
      ((Path)localObject).cubicTo(7.736675F, 18.586063F, 5.0F, 15.612624F, 5.0F, 12.0F);
      ((Path)localObject).lineTo(5.0F, 10.0F);
      ((Path)localObject).lineTo(6.5F, 10.0F);
      ((Path)localObject).lineTo(6.5F, 12.0F);
      ((Path)localObject).cubicTo(6.5F, 15.037566F, 8.962434F, 17.5F, 12.0F, 17.5F);
      ((Path)localObject).cubicTo(12.973733F, 17.5F, 13.888364F, 17.246958F, 14.681725F, 16.803045F);
      ((Path)localObject).lineTo(14.681725F, 16.803045F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.562149F, 15.68347F);
      ((Path)localObject).cubicTo(13.082216F, 15.887263F, 12.554274F, 16.0F, 12.0F, 16.0F);
      ((Path)localObject).cubicTo(9.790861F, 16.0F, 8.0F, 14.209139F, 8.0F, 12.0F);
      ((Path)localObject).lineTo(8.0F, 10.121321F);
      ((Path)localObject).lineTo(13.562149F, 15.68347F);
      ((Path)localObject).lineTo(13.562149F, 15.68347F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_mike_off
 * JD-Core Version:    0.7.0.1
 */