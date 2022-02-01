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

public class msg_tip_dark_bg
  extends c
{
  private final int height = 36;
  private final int width = 70;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 70;
      return 36;
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
      localPaint.setColor(-13882324);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(66.0F, 0.0F);
      ((Path)localObject).cubicTo(68.209137F, -4.330032E-015F, 70.0F, 1.790861F, 70.0F, 4.0F);
      ((Path)localObject).lineTo(70.0F, 32.0F);
      ((Path)localObject).cubicTo(70.0F, 34.209141F, 68.209137F, 36.0F, 66.0F, 36.0F);
      ((Path)localObject).lineTo(9.997025F, 36.0F);
      ((Path)localObject).cubicTo(7.787886F, 36.0F, 5.997025F, 34.209141F, 5.997025F, 32.0F);
      ((Path)localObject).lineTo(5.997F, 23.448999F);
      ((Path)localObject).lineTo(0.323352F, 18.237267F);
      ((Path)localObject).cubicTo(0.312943F, 18.227705F, 0.3027393F, 18.217924F, 0.2927474F, 18.207933F);
      ((Path)localObject).lineTo(0.2634137F, 18.177328F);
      ((Path)localObject).cubicTo(-0.1102082F, 17.770603F, -0.083373F, 17.138008F, 0.323352F, 16.764385F);
      ((Path)localObject).lineTo(0.323352F, 16.764385F);
      ((Path)localObject).lineTo(5.997F, 11.551F);
      ((Path)localObject).lineTo(5.997025F, 4.0F);
      ((Path)localObject).cubicTo(5.997025F, 1.790861F, 7.787886F, 4.058122E-016F, 9.997025F, 0.0F);
      ((Path)localObject).lineTo(66.0F, 0.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.msg_tip_dark_bg
 * JD-Core Version:    0.7.0.1
 */