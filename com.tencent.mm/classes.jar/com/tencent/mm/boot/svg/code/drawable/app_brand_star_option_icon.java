package com.tencent.mm.boot.svg.code.drawable;

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

public class app_brand_star_option_icon
  extends c
{
  private final int height = 60;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -194.0F, 0.0F, 1.0F, -102.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(224.36317F, 150.10246F);
      ((Path)localObject2).lineTo(204.89511F, 161.91656F);
      ((Path)localObject2).lineTo(210.11502F, 139.75056F);
      ((Path)localObject2).lineTo(192.86317F, 124.88609F);
      ((Path)localObject2).lineTo(215.55734F, 123.00085F);
      ((Path)localObject2).lineTo(224.36317F, 102.0F);
      ((Path)localObject2).lineTo(233.16902F, 123.00085F);
      ((Path)localObject2).lineTo(255.86317F, 124.88609F);
      ((Path)localObject2).lineTo(238.61133F, 139.75056F);
      ((Path)localObject2).lineTo(243.83125F, 161.91656F);
      ((Path)localObject2).lineTo(224.36317F, 150.10246F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(224.24213F, 144.04645F);
      ((Path)localObject2).lineTo(235.99782F, 151.18034F);
      ((Path)localObject2).lineTo(232.84579F, 137.7955F);
      ((Path)localObject2).lineTo(243.26324F, 128.81966F);
      ((Path)localObject2).lineTo(229.55949F, 127.68127F);
      ((Path)localObject2).lineTo(224.24213F, 115.0F);
      ((Path)localObject2).lineTo(218.92476F, 127.68127F);
      ((Path)localObject2).lineTo(205.22099F, 128.81966F);
      ((Path)localObject2).lineTo(215.63844F, 137.7955F);
      ((Path)localObject2).lineTo(212.48642F, 151.18034F);
      ((Path)localObject2).lineTo(224.24213F, 144.04645F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_star_option_icon
 * JD-Core Version:    0.7.0.1
 */