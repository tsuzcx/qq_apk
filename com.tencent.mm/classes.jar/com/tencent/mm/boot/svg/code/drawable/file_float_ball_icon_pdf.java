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

public class file_float_ball_icon_pdf
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      ((Paint)localObject).setColor(-1686720);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.448731F, 18.021973F);
      ((Path)localObject).lineTo(14.105469F, 18.021973F);
      ((Path)localObject).cubicTo(16.487793F, 18.021973F, 18.139648F, 19.640625F, 18.139648F, 22.03125F);
      ((Path)localObject).cubicTo(18.139648F, 24.421875F, 16.437988F, 26.040527F, 14.01416F, 26.040527F);
      ((Path)localObject).lineTo(11.590332F, 26.040527F);
      ((Path)localObject).lineTo(11.590332F, 30.0F);
      ((Path)localObject).lineTo(9.448731F, 30.0F);
      ((Path)localObject).lineTo(9.448731F, 18.021973F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.590332F, 19.773438F);
      ((Path)localObject).lineTo(11.590332F, 24.313965F);
      ((Path)localObject).lineTo(13.532715F, 24.313965F);
      ((Path)localObject).cubicTo(15.068359F, 24.313965F, 15.964844F, 23.483887F, 15.964844F, 22.03125F);
      ((Path)localObject).cubicTo(15.964844F, 20.595215F, 15.07666F, 19.773438F, 13.541016F, 19.773438F);
      ((Path)localObject).lineTo(11.590332F, 19.773438F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.700195F, 18.021973F);
      ((Path)localObject).lineTo(24.074707F, 18.021973F);
      ((Path)localObject).cubicTo(27.652344F, 18.021973F, 29.769043F, 20.188477F, 29.769043F, 23.981934F);
      ((Path)localObject).cubicTo(29.769043F, 27.775391F, 27.660645F, 30.0F, 24.074707F, 30.0F);
      ((Path)localObject).lineTo(19.700195F, 30.0F);
      ((Path)localObject).lineTo(19.700195F, 18.021973F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.841797F, 19.831543F);
      ((Path)localObject).lineTo(21.841797F, 28.19043F);
      ((Path)localObject).lineTo(23.850586F, 28.19043F);
      ((Path)localObject).cubicTo(26.257813F, 28.19043F, 27.585938F, 26.721191F, 27.585938F, 23.990234F);
      ((Path)localObject).cubicTo(27.585938F, 21.309082F, 26.241211F, 19.831543F, 23.850586F, 19.831543F);
      ((Path)localObject).lineTo(21.841797F, 19.831543F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.612305F, 30.0F);
      ((Path)localObject).lineTo(31.470703F, 30.0F);
      ((Path)localObject).lineTo(31.470703F, 18.021973F);
      ((Path)localObject).lineTo(39.107422F, 18.021973F);
      ((Path)localObject).lineTo(39.107422F, 19.831543F);
      ((Path)localObject).lineTo(33.612305F, 19.831543F);
      ((Path)localObject).lineTo(33.612305F, 23.367676F);
      ((Path)localObject).lineTo(38.634277F, 23.367676F);
      ((Path)localObject).lineTo(38.634277F, 25.11084F);
      ((Path)localObject).lineTo(33.612305F, 25.11084F);
      ((Path)localObject).lineTo(33.612305F, 30.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.file_float_ball_icon_pdf
 * JD-Core Version:    0.7.0.1
 */