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

public class checkbox_selected_filled_dark
  extends c
{
  private final int height = 70;
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
      return 70;
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
      ((Paint)localObject).setColor(-16268960);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(34.567902F, 0.0F);
      localPath.cubicTo(54.330372F, 0.0F, 70.0F, 15.66963F, 70.0F, 35.432098F);
      localPath.cubicTo(70.0F, 54.330372F, 54.330372F, 70.0F, 34.567902F, 70.0F);
      localPath.cubicTo(15.66963F, 70.0F, 0.0F, 54.330372F, 0.0F, 35.432098F);
      localPath.cubicTo(0.0F, 15.66963F, 15.66963F, 0.0F, 34.567902F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(52.033009F, 23.0F);
      ((Path)localObject).lineTo(30.091883F, 44.941124F);
      ((Path)localObject).lineTo(20.18198F, 35.031223F);
      ((Path)localObject).lineTo(17.0F, 38.213203F);
      ((Path)localObject).lineTo(27.970562F, 49.183765F);
      ((Path)localObject).cubicTo(29.142136F, 50.355339F, 31.04163F, 50.355339F, 32.213203F, 49.183765F);
      ((Path)localObject).lineTo(55.214989F, 26.18198F);
      ((Path)localObject).lineTo(52.033009F, 23.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.checkbox_selected_filled_dark
 * JD-Core Version:    0.7.0.1
 */