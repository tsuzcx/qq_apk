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

public class ipcall_giftcard_bg
  extends c
{
  private final int height = 342;
  private final int width = 450;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 450;
      return 342;
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
      localCanvas.saveLayerAlpha(null, 7, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(70.67984F, 150.63449F);
      ((Path)localObject).cubicTo(67.97303F, 110.35668F, 80.408836F, 71.12603F, 108.70876F, 42.23457F);
      ((Path)localObject).cubicTo(166.09906F, -16.355326F, 266.99811F, -10.238467F, 334.07306F, 55.896957F);
      ((Path)localObject).cubicTo(401.14804F, 122.03238F, 408.99899F, 223.14223F, 351.6087F, 281.73212F);
      ((Path)localObject).cubicTo(320.71915F, 313.26736F, 277.22516F, 326.05713F, 233.18497F, 320.83246F);
      ((Path)localObject).cubicTo(228.70084F, 330.40506F, 222.63911F, 339.28018F, 214.97217F, 347.10776F);
      ((Path)localObject).cubicTo(173.24408F, 389.71017F, 99.767357F, 385.15027F, 50.857311F, 336.92297F);
      ((Path)localObject).cubicTo(1.947269F, 288.69565F, -3.874857F, 215.06361F, 37.85323F, 172.46121F);
      ((Path)localObject).cubicTo(47.367443F, 162.74765F, 58.53215F, 155.48589F, 70.67984F, 150.63449F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(70.67984F, 150.63449F);
      ((Path)localObject).cubicTo(73.46225F, 192.03729F, 92.244995F, 234.54659F, 126.2444F, 268.06973F);
      ((Path)localObject).cubicTo(157.21716F, 298.60867F, 195.40207F, 316.3501F, 233.18497F, 320.83246F);
      ((Path)localObject).cubicTo(253.10619F, 278.3053F, 241.89159F, 222.01225F, 201.96808F, 182.64603F);
      ((Path)localObject).cubicTo(164.20978F, 145.41478F, 111.81031F, 134.20828F, 70.67984F, 150.63449F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ipcall_giftcard_bg
 * JD-Core Version:    0.7.0.1
 */