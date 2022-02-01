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

public class default_facebookapp
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      ((Paint)localObject).setColor(-12953699);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(192.0F, 0.0F);
      localPath.lineTo(192.0F, 192.0F);
      localPath.lineTo(0.0F, 192.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(104.72727F, 192.0F);
      ((Path)localObject).lineTo(104.72727F, 117.81818F);
      ((Path)localObject).lineTo(80.0F, 117.81818F);
      ((Path)localObject).lineTo(80.0F, 87.272728F);
      ((Path)localObject).lineTo(104.72727F, 87.272728F);
      ((Path)localObject).lineTo(104.72727F, 61.090908F);
      ((Path)localObject).cubicTo(104.62603F, 44.320255F, 121.20966F, 29.09091F, 138.18182F, 29.09091F);
      ((Path)localObject).lineTo(164.36363F, 29.09091F);
      ((Path)localObject).lineTo(164.36363F, 58.18182F);
      ((Path)localObject).lineTo(148.36363F, 58.18182F);
      ((Path)localObject).cubicTo(137.98802F, 58.097572F, 133.74586F, 62.343899F, 133.81818F, 72.727272F);
      ((Path)localObject).lineTo(133.81818F, 87.272728F);
      ((Path)localObject).lineTo(164.36363F, 87.272728F);
      ((Path)localObject).lineTo(158.54546F, 117.81818F);
      ((Path)localObject).lineTo(133.81818F, 117.81818F);
      ((Path)localObject).lineTo(133.81818F, 192.0F);
      ((Path)localObject).lineTo(104.72727F, 192.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_facebookapp
 * JD-Core Version:    0.7.0.1
 */