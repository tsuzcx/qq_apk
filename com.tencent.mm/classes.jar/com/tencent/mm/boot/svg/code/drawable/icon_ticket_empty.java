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

public class icon_ticket_empty
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(28.666666F, 6.0F);
      localPath.cubicTo(29.403046F, 6.0F, 30.0F, 6.596954F, 30.0F, 7.333334F);
      localPath.lineTo(30.0F, 24.666666F);
      localPath.cubicTo(30.0F, 25.403046F, 29.403046F, 26.0F, 28.666666F, 26.0F);
      localPath.lineTo(3.333333F, 26.0F);
      localPath.cubicTo(2.596954F, 26.0F, 2.0F, 25.403046F, 2.0F, 24.666666F);
      localPath.lineTo(2.0F, 7.333334F);
      localPath.cubicTo(2.0F, 6.596954F, 2.596954F, 6.0F, 3.333333F, 6.0F);
      localPath.lineTo(28.666666F, 6.0F);
      localPath.close();
      localPath.moveTo(28.4F, 7.6F);
      localPath.lineTo(3.6F, 7.6F);
      localPath.lineTo(3.6F, 24.4F);
      localPath.lineTo(28.4F, 24.4F);
      localPath.lineTo(28.4F, 7.6F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 11.333333F);
      localPath.cubicTo(12.73638F, 11.333333F, 13.333333F, 11.930287F, 13.333333F, 12.666667F);
      localPath.lineTo(13.333333F, 16.666666F);
      localPath.cubicTo(13.333333F, 17.403046F, 12.73638F, 18.0F, 12.0F, 18.0F);
      localPath.lineTo(8.0F, 18.0F);
      localPath.cubicTo(7.26362F, 18.0F, 6.666667F, 17.403046F, 6.666667F, 16.666666F);
      localPath.lineTo(6.666667F, 12.666667F);
      localPath.cubicTo(6.666667F, 11.930287F, 7.26362F, 11.333333F, 8.0F, 11.333333F);
      localPath.lineTo(12.0F, 11.333333F);
      localPath.close();
      localPath.moveTo(11.733F, 12.933F);
      localPath.lineTo(8.266F, 12.933F);
      localPath.lineTo(8.266F, 16.399F);
      localPath.lineTo(11.733F, 16.399F);
      localPath.lineTo(11.733F, 12.933F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 12.133333F);
      localPath.cubicTo(16.0F, 11.691505F, 16.358171F, 11.333333F, 16.799999F, 11.333333F);
      localPath.lineTo(24.533333F, 11.333333F);
      localPath.cubicTo(24.975161F, 11.333333F, 25.333332F, 11.691505F, 25.333332F, 12.133333F);
      localPath.lineTo(25.333332F, 12.133333F);
      localPath.cubicTo(25.333332F, 12.575161F, 24.975161F, 12.933333F, 24.533333F, 12.933333F);
      localPath.lineTo(16.799999F, 12.933333F);
      localPath.cubicTo(16.358171F, 12.933333F, 16.0F, 12.575161F, 16.0F, 12.133333F);
      localPath.lineTo(16.0F, 12.133333F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 15.466667F);
      localPath.cubicTo(16.0F, 15.024839F, 16.358171F, 14.666667F, 16.799999F, 14.666667F);
      localPath.lineTo(21.866667F, 14.666667F);
      localPath.cubicTo(22.308495F, 14.666667F, 22.666666F, 15.024839F, 22.666666F, 15.466667F);
      localPath.lineTo(22.666666F, 15.466666F);
      localPath.cubicTo(22.666666F, 15.908494F, 22.308495F, 16.266666F, 21.866667F, 16.266666F);
      localPath.lineTo(16.799999F, 16.266666F);
      localPath.cubicTo(16.358171F, 16.266666F, 16.0F, 15.908494F, 16.0F, 15.466666F);
      localPath.lineTo(16.0F, 15.466667F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.0F, 18.799999F);
      ((Path)localObject).cubicTo(16.0F, 18.358171F, 16.358171F, 18.0F, 16.799999F, 18.0F);
      ((Path)localObject).lineTo(21.866667F, 18.0F);
      ((Path)localObject).cubicTo(22.308495F, 18.0F, 22.666666F, 18.358171F, 22.666666F, 18.799999F);
      ((Path)localObject).lineTo(22.666666F, 18.800001F);
      ((Path)localObject).cubicTo(22.666666F, 19.241829F, 22.308495F, 19.6F, 21.866667F, 19.6F);
      ((Path)localObject).lineTo(16.799999F, 19.6F);
      ((Path)localObject).cubicTo(16.358171F, 19.6F, 16.0F, 19.241829F, 16.0F, 18.800001F);
      ((Path)localObject).lineTo(16.0F, 18.799999F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_ticket_empty
 * JD-Core Version:    0.7.0.1
 */