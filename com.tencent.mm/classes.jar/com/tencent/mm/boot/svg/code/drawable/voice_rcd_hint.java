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

public class voice_rcd_hint
  extends c
{
  private final int height = 180;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 180;
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
      ((Paint)localObject).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(24.0F, 76.0F);
      localPath.lineTo(24.0F, 98.237793F);
      localPath.cubicTo(24.0F, 121.08427F, 40.676159F, 139.71544F, 62.0F, 141.80502F);
      localPath.lineTo(62.0F, 152.0F);
      localPath.lineTo(70.0F, 152.0F);
      localPath.lineTo(70.0F, 141.80527F);
      localPath.lineTo(70.0F, 141.80527F);
      localPath.cubicTo(91.319733F, 139.7189F, 108.0F, 121.12331F, 108.0F, 98.434006F);
      localPath.lineTo(108.0F, 76.0F);
      localPath.lineTo(100.0F, 76.0F);
      localPath.lineTo(100.0F, 98.63076F);
      localPath.cubicTo(100.0F, 118.18871F, 84.777679F, 134.0F, 66.0F, 134.0F);
      localPath.cubicTo(47.218189F, 134.0F, 32.0F, 118.16465F, 32.0F, 98.63076F);
      localPath.lineTo(32.0F, 76.0F);
      localPath.lineTo(24.0F, 76.0F);
      localPath.lineTo(24.0F, 76.0F);
      localPath.close();
      localPath.moveTo(38.0F, 152.0F);
      localPath.cubicTo(35.790859F, 152.0F, 34.0F, 153.79086F, 34.0F, 156.0F);
      localPath.cubicTo(34.0F, 158.20914F, 35.790859F, 160.0F, 38.0F, 160.0F);
      localPath.lineTo(94.0F, 160.0F);
      localPath.cubicTo(96.209137F, 160.0F, 98.0F, 158.20914F, 98.0F, 156.0F);
      localPath.cubicTo(98.0F, 153.79086F, 96.209137F, 152.0F, 94.0F, 152.0F);
      localPath.lineTo(38.0F, 152.0F);
      localPath.close();
      localPath.moveTo(40.0F, 98.660339F);
      localPath.cubicTo(40.0F, 113.75961F, 51.63744F, 126.0F, 66.0F, 126.0F);
      localPath.cubicTo(80.359406F, 126.0F, 92.0F, 113.77821F, 92.0F, 98.660339F);
      localPath.lineTo(92.0F, 45.339664F);
      localPath.cubicTo(92.0F, 30.240385F, 80.362564F, 18.0F, 66.0F, 18.0F);
      localPath.cubicTo(51.640598F, 18.0F, 40.0F, 30.22179F, 40.0F, 45.339664F);
      localPath.lineTo(40.0F, 98.660339F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(104.0F, 80.0F);
      localPath.cubicTo(106.20914F, 80.0F, 108.0F, 78.209137F, 108.0F, 76.0F);
      localPath.cubicTo(108.0F, 73.790863F, 106.20914F, 72.0F, 104.0F, 72.0F);
      localPath.cubicTo(101.79086F, 72.0F, 100.0F, 73.790863F, 100.0F, 76.0F);
      localPath.cubicTo(100.0F, 78.209137F, 101.79086F, 80.0F, 104.0F, 80.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(28.0F, 80.0F);
      ((Path)localObject).cubicTo(30.209139F, 80.0F, 32.0F, 78.209137F, 32.0F, 76.0F);
      ((Path)localObject).cubicTo(32.0F, 73.790863F, 30.209139F, 72.0F, 28.0F, 72.0F);
      ((Path)localObject).cubicTo(25.790861F, 72.0F, 24.0F, 73.790863F, 24.0F, 76.0F);
      ((Path)localObject).cubicTo(24.0F, 78.209137F, 25.790861F, 80.0F, 28.0F, 80.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voice_rcd_hint
 * JD-Core Version:    0.7.0.1
 */