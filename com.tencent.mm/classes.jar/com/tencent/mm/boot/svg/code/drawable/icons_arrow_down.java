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

public class icons_arrow_down
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(352321535);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(12.0F, 0.0F);
      localPath.cubicTo(18.627419F, 0.0F, 24.0F, 5.372582F, 24.0F, 12.0F);
      localPath.lineTo(24.0F, 12.0F);
      localPath.cubicTo(24.0F, 18.627419F, 18.627419F, 24.0F, 12.0F, 24.0F);
      localPath.lineTo(12.0F, 24.0F);
      localPath.cubicTo(5.372582F, 24.0F, 0.0F, 18.627419F, 0.0F, 12.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-855638017);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.715F, 15.2052F);
      ((Path)localObject).cubicTo(12.3185F, 15.5897F, 11.6757F, 15.5897F, 11.2792F, 15.2052F);
      ((Path)localObject).lineTo(7.22413F, 11.273F);
      ((Path)localObject).lineTo(8.28479F, 10.2445F);
      ((Path)localObject).lineTo(11.9971F, 13.8443F);
      ((Path)localObject).lineTo(15.7094F, 10.2445F);
      ((Path)localObject).lineTo(16.7701F, 11.273F);
      ((Path)localObject).lineTo(12.715F, 15.2052F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_arrow_down
 * JD-Core Version:    0.7.0.1
 */