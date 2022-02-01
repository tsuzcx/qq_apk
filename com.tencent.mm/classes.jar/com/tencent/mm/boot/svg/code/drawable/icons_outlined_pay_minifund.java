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

public class icons_outlined_pay_minifund
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(52.940491F, 12.0F);
      ((Path)localObject).cubicTo(53.413021F, 12.0F, 53.860718F, 12.206798F, 54.160633F, 12.563604F);
      ((Path)localObject).lineTo(65.641197F, 26.221878F);
      ((Path)localObject).cubicTo(66.102448F, 26.770628F, 66.120819F, 27.556149F, 65.685692F, 28.124908F);
      ((Path)localObject).lineTo(37.183323F, 65.38092F);
      ((Path)localObject).cubicTo(36.550747F, 66.207771F, 35.281704F, 66.20607F, 34.651451F, 65.377533F);
      ((Path)localObject).lineTo(6.311719F, 28.121517F);
      ((Path)localObject).cubicTo(5.888169F, 27.564709F, 5.897053F, 26.800133F, 6.333432F, 26.252865F);
      ((Path)localObject).lineTo(17.224245F, 12.594592F);
      ((Path)localObject).cubicTo(17.523424F, 12.219389F, 17.982986F, 12.0F, 18.469761F, 12.0F);
      ((Path)localObject).lineTo(52.940491F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(46.441002F, 28.971001F);
      ((Path)localObject).lineTo(25.565001F, 28.971001F);
      ((Path)localObject).lineTo(36.0F, 59.577F);
      ((Path)localObject).lineTo(46.441002F, 28.971001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.236F, 28.971001F);
      ((Path)localObject).lineTo(10.893F, 28.971001F);
      ((Path)localObject).lineTo(31.450001F, 55.997002F);
      ((Path)localObject).lineTo(22.236F, 28.971001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(61.095001F, 28.971001F);
      ((Path)localObject).lineTo(49.769001F, 28.971001F);
      ((Path)localObject).lineTo(40.654999F, 55.688999F);
      ((Path)localObject).lineTo(61.095001F, 28.971001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.257999F, 15.085F);
      ((Path)localObject).lineTo(19.241161F, 15.085714F);
      ((Path)localObject).lineTo(10.63F, 25.885F);
      ((Path)localObject).lineTo(22.348F, 25.885F);
      ((Path)localObject).lineTo(27.257999F, 15.085F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(41.289001F, 15.085F);
      ((Path)localObject).lineTo(30.714001F, 15.085F);
      ((Path)localObject).lineTo(25.804001F, 25.885F);
      ((Path)localObject).lineTo(46.202F, 25.885F);
      ((Path)localObject).lineTo(41.289001F, 15.085F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(52.194088F, 15.085714F);
      ((Path)localObject).lineTo(44.744999F, 15.085F);
      ((Path)localObject).lineTo(49.657001F, 25.885F);
      ((Path)localObject).lineTo(61.271999F, 25.885F);
      ((Path)localObject).lineTo(52.194088F, 15.085714F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_pay_minifund
 * JD-Core Version:    0.7.0.1
 */