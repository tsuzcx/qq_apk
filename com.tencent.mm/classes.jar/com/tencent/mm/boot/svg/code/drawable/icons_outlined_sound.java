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

public class icons_outlined_sound
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.6F, 5.0F);
      ((Path)localObject).cubicTo(10.152285F, 5.0F, 10.6F, 5.447715F, 10.6F, 6.0F);
      ((Path)localObject).lineTo(10.6F, 18.0F);
      ((Path)localObject).cubicTo(10.6F, 18.552284F, 10.152285F, 19.0F, 9.6F, 19.0F);
      ((Path)localObject).cubicTo(9.047715F, 19.0F, 8.6F, 18.552284F, 8.6F, 18.0F);
      ((Path)localObject).lineTo(8.6F, 6.0F);
      ((Path)localObject).cubicTo(8.6F, 5.447715F, 9.047715F, 5.0F, 9.6F, 5.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.4F, 8.0F);
      ((Path)localObject).cubicTo(18.952284F, 8.0F, 19.4F, 8.447715F, 19.4F, 9.0F);
      ((Path)localObject).lineTo(19.4F, 15.0F);
      ((Path)localObject).cubicTo(19.4F, 15.552284F, 18.952284F, 16.0F, 18.4F, 16.0F);
      ((Path)localObject).cubicTo(17.847715F, 16.0F, 17.4F, 15.552284F, 17.4F, 15.0F);
      ((Path)localObject).lineTo(17.4F, 9.0F);
      ((Path)localObject).cubicTo(17.4F, 8.447715F, 17.847715F, 8.0F, 18.4F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.2F, 8.0F);
      ((Path)localObject).cubicTo(5.752285F, 8.0F, 6.2F, 8.447715F, 6.2F, 9.0F);
      ((Path)localObject).lineTo(6.2F, 15.0F);
      ((Path)localObject).cubicTo(6.2F, 15.552284F, 5.752285F, 16.0F, 5.2F, 16.0F);
      ((Path)localObject).cubicTo(4.647715F, 16.0F, 4.2F, 15.552284F, 4.2F, 15.0F);
      ((Path)localObject).lineTo(4.2F, 9.0F);
      ((Path)localObject).cubicTo(4.2F, 8.447715F, 4.647715F, 8.0F, 5.2F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.0F, 9.0F);
      ((Path)localObject).cubicTo(14.552284F, 9.0F, 15.0F, 9.447715F, 15.0F, 10.0F);
      ((Path)localObject).lineTo(15.0F, 14.0F);
      ((Path)localObject).cubicTo(15.0F, 14.552284F, 14.552284F, 15.0F, 14.0F, 15.0F);
      ((Path)localObject).cubicTo(13.447716F, 15.0F, 13.0F, 14.552284F, 13.0F, 14.0F);
      ((Path)localObject).lineTo(13.0F, 10.0F);
      ((Path)localObject).cubicTo(13.0F, 9.447715F, 13.447716F, 9.0F, 14.0F, 9.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_sound
 * JD-Core Version:    0.7.0.1
 */