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

public class scan_from_gallery
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
      localPaint.setColor(-419430401);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.008198F, 4.0F);
      ((Path)localObject).cubicTo(21.544695F, 4.0F, 22.0F, 4.481137F, 22.0F, 5.074649F);
      ((Path)localObject).lineTo(22.0F, 18.92535F);
      ((Path)localObject).cubicTo(22.0F, 19.521152F, 21.555954F, 20.0F, 21.008198F, 20.0F);
      ((Path)localObject).lineTo(2.991803F, 20.0F);
      ((Path)localObject).cubicTo(2.455306F, 20.0F, 2.0F, 19.518864F, 2.0F, 18.92535F);
      ((Path)localObject).lineTo(2.0F, 5.074649F);
      ((Path)localObject).cubicTo(2.0F, 4.478849F, 2.444045F, 4.0F, 2.991803F, 4.0F);
      ((Path)localObject).lineTo(21.008198F, 4.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.5F, 5.5F);
      ((Path)localObject).lineTo(3.5F, 5.5F);
      ((Path)localObject).lineTo(3.5F, 13.849F);
      ((Path)localObject).lineTo(8.199246F, 10.049258F);
      ((Path)localObject).cubicTo(8.661799F, 9.675185F, 9.404626F, 9.693327F, 9.850495F, 10.085084F);
      ((Path)localObject).lineTo(14.326923F, 14.018227F);
      ((Path)localObject).lineTo(16.609102F, 12.077497F);
      ((Path)localObject).cubicTo(17.071318F, 11.684438F, 17.806723F, 11.692423F, 18.255432F, 12.095083F);
      ((Path)localObject).lineTo(20.5F, 14.136F);
      ((Path)localObject).lineTo(20.5F, 5.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.scan_from_gallery
 * JD-Core Version:    0.7.0.1
 */