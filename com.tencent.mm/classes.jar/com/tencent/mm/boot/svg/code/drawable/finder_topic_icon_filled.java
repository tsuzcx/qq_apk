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

public class finder_topic_icon_filled
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
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.104428F, 2.073125F);
      ((Path)localObject).lineTo(10.529613F, 2.074452F);
      ((Path)localObject).lineTo(9.848F, 7.916F);
      ((Path)localObject).lineTo(15.096F, 7.916F);
      ((Path)localObject).lineTo(15.784979F, 2.079345F);
      ((Path)localObject).lineTo(17.210163F, 2.080671F);
      ((Path)localObject).lineTo(16.528999F, 7.916F);
      ((Path)localObject).lineTo(21.5F, 7.91623F);
      ((Path)localObject).lineTo(21.5F, 9.352281F);
      ((Path)localObject).lineTo(16.362F, 9.352F);
      ((Path)localObject).lineTo(15.744F, 14.647F);
      ((Path)localObject).lineTo(21.5F, 14.647719F);
      ((Path)localObject).lineTo(21.5F, 16.083771F);
      ((Path)localObject).lineTo(15.577F, 16.083F);
      ((Path)localObject).lineTo(14.895572F, 21.926874F);
      ((Path)localObject).lineTo(13.445195F, 21.925524F);
      ((Path)localObject).lineTo(14.134F, 16.083F);
      ((Path)localObject).lineTo(8.896F, 16.083F);
      ((Path)localObject).lineTo(8.215021F, 21.920656F);
      ((Path)localObject).lineTo(6.789837F, 21.919329F);
      ((Path)localObject).lineTo(7.47F, 16.083F);
      ((Path)localObject).lineTo(2.5F, 16.083771F);
      ((Path)localObject).lineTo(2.5F, 14.647719F);
      ((Path)localObject).lineTo(7.637F, 14.647F);
      ((Path)localObject).lineTo(8.255F, 9.352F);
      ((Path)localObject).lineTo(2.5F, 9.352281F);
      ((Path)localObject).lineTo(2.5F, 7.91623F);
      ((Path)localObject).lineTo(8.422F, 7.916F);
      ((Path)localObject).lineTo(9.104428F, 2.073125F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.927F, 9.352F);
      ((Path)localObject).lineTo(9.68F, 9.352F);
      ((Path)localObject).lineTo(9.063F, 14.647F);
      ((Path)localObject).lineTo(14.303F, 14.647F);
      ((Path)localObject).lineTo(14.927F, 9.352F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_topic_icon_filled
 * JD-Core Version:    0.7.0.1
 */