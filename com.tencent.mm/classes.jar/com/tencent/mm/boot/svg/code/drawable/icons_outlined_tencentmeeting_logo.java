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

public class icons_outlined_tencentmeeting_logo
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      ((Path)localObject).moveTo(33.421936F, 23.540632F);
      ((Path)localObject).lineTo(30.371902F, 26.590569F);
      ((Path)localObject).lineTo(25.19693F, 21.415598F);
      ((Path)localObject).lineTo(20.010904F, 26.601721F);
      ((Path)localObject).lineTo(15.488806F, 22.079622F);
      ((Path)localObject).lineTo(20.339279F, 17.229147F);
      ((Path)localObject).lineTo(20.689379F, 16.886322F);
      ((Path)localObject).lineTo(20.685791F, 16.882637F);
      ((Path)localObject).lineTo(25.19693F, 12.371497F);
      ((Path)localObject).lineTo(33.421837F, 20.596403F);
      ((Path)localObject).cubicTo(34.233562F, 21.408131F, 34.233562F, 22.728907F, 33.421936F, 23.540632F);
      ((Path)localObject).lineTo(33.421936F, 23.540632F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.57815F, 23.54073F);
      ((Path)localObject).cubicTo(5.766424F, 22.728907F, 5.766424F, 21.408131F, 6.578053F, 20.596403F);
      ((Path)localObject).lineTo(14.803057F, 12.371593F);
      ((Path)localObject).lineTo(19.314198F, 16.882734F);
      ((Path)localObject).lineTo(14.803057F, 21.393873F);
      ((Path)localObject).lineTo(9.617321F, 26.579706F);
      ((Path)localObject).lineTo(6.57815F, 23.54073F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.107685F, 19.910656F);
      ((Path)localObject).lineTo(25.19693F, 11.0F);
      ((Path)localObject).lineTo(20.000042F, 16.196888F);
      ((Path)localObject).lineTo(14.803057F, 11.0F);
      ((Path)localObject).lineTo(5.892304F, 19.910656F);
      ((Path)localObject).cubicTo(4.702549F, 21.100508F, 4.702549F, 23.036528F, 5.892402F, 24.226477F);
      ((Path)localObject).lineTo(9.617321F, 27.951202F);
      ((Path)localObject).lineTo(14.803057F, 22.765371F);
      ((Path)localObject).lineTo(20.010904F, 27.973314F);
      ((Path)localObject).lineTo(25.19693F, 22.787191F);
      ((Path)localObject).lineTo(30.371902F, 27.962065F);
      ((Path)localObject).lineTo(34.107685F, 24.226379F);
      ((Path)localObject).cubicTo(35.29744F, 23.036528F, 35.29744F, 21.100508F, 34.107685F, 19.910656F);
      ((Path)localObject).lineTo(34.107685F, 19.910656F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_tencentmeeting_logo
 * JD-Core Version:    0.7.0.1
 */