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

public class c2c_remittance_expired_icon
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(20.0F, 0.0F);
      ((Path)localObject).cubicTo(31.045694F, 0.0F, 40.0F, 8.954305F, 40.0F, 20.0F);
      ((Path)localObject).cubicTo(40.0F, 31.045694F, 31.045694F, 40.0F, 20.0F, 40.0F);
      ((Path)localObject).cubicTo(8.954305F, 40.0F, 0.0F, 31.045694F, 0.0F, 20.0F);
      ((Path)localObject).cubicTo(0.0F, 8.954305F, 8.954305F, 0.0F, 20.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 2.4F);
      ((Path)localObject).cubicTo(10.279788F, 2.4F, 2.4F, 10.279788F, 2.4F, 20.0F);
      ((Path)localObject).cubicTo(2.4F, 29.720211F, 10.279788F, 37.599998F, 20.0F, 37.599998F);
      ((Path)localObject).cubicTo(29.720211F, 37.599998F, 37.599998F, 29.720211F, 37.599998F, 20.0F);
      ((Path)localObject).cubicTo(37.599998F, 10.279788F, 29.720211F, 2.4F, 20.0F, 2.4F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 26.806641F);
      ((Path)localObject).cubicTo(20.952148F, 26.806641F, 21.669922F, 27.524414F, 21.669922F, 28.476563F);
      ((Path)localObject).cubicTo(21.669922F, 29.414063F, 20.952148F, 30.146484F, 20.0F, 30.146484F);
      ((Path)localObject).cubicTo(19.0625F, 30.146484F, 18.330078F, 29.414063F, 18.330078F, 28.476563F);
      ((Path)localObject).cubicTo(18.330078F, 27.524414F, 19.0625F, 26.806641F, 20.0F, 26.806641F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.318359F, 8.862305F);
      ((Path)localObject).lineTo(21.142578F, 22.983398F);
      ((Path)localObject).lineTo(18.857422F, 22.983398F);
      ((Path)localObject).lineTo(18.681641F, 8.862305F);
      ((Path)localObject).lineTo(21.318359F, 8.862305F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.c2c_remittance_expired_icon
 * JD-Core Version:    0.7.0.1
 */