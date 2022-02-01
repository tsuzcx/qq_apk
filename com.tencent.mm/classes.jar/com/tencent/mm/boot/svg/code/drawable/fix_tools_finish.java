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

public class fix_tools_finish
  extends c
{
  private final int height = 100;
  private final int width = 100;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 100;
      return 100;
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16139513);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(100.0F, 50.346603F);
      localPath.cubicTo(100.0F, 22.265478F, 77.614815F, 0.0F, 49.382717F, 0.0F);
      localPath.cubicTo(22.385185F, 0.0F, 0.0F, 22.265478F, 0.0F, 50.346603F);
      localPath.cubicTo(0.0F, 77.19976F, 22.385185F, 99.46524F, 49.382717F, 99.46524F);
      localPath.cubicTo(77.614815F, 99.46524F, 100.0F, 77.19976F, 100.0F, 50.346603F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(26.066193F, 52.060669F);
      ((Path)localObject).cubicTo(25.683428F, 51.666645F, 25.640087F, 50.985928F, 25.972504F, 50.536034F);
      ((Path)localObject).lineTo(27.666462F, 48.243423F);
      ((Path)localObject).cubicTo(27.997484F, 47.795414F, 28.617992F, 47.700703F, 29.062307F, 48.039421F);
      ((Path)localObject).lineTo(41.715767F, 57.685711F);
      ((Path)localObject).cubicTo(42.155647F, 58.021053F, 42.853935F, 58.009762F, 43.289238F, 57.649059F);
      ((Path)localObject).lineTo(75.159119F, 31.240854F);
      ((Path)localObject).cubicTo(75.588242F, 30.885271F, 76.256737F, 30.911966F, 76.651161F, 31.299417F);
      ((Path)localObject).lineTo(78.113762F, 32.736153F);
      ((Path)localObject).cubicTo(78.508675F, 33.124081F, 78.514839F, 33.745895F, 78.119637F, 34.132755F);
      ((Path)localObject).lineTo(43.220352F, 68.295197F);
      ((Path)localObject).cubicTo(42.828686F, 68.678596F, 42.199085F, 68.668121F, 41.818119F, 68.275955F);
      ((Path)localObject).lineTo(26.066193F, 52.060669F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fix_tools_finish
 * JD-Core Version:    0.7.0.1
 */