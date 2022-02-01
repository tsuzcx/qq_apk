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

public class icons_filled_ban_comment_on
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.0F, 16.666666F);
      ((Path)localObject).cubicTo(14.602373F, 16.666666F, 18.333334F, 13.49535F, 18.333334F, 9.583333F);
      ((Path)localObject).cubicTo(18.333334F, 5.671316F, 14.602373F, 2.5F, 10.0F, 2.5F);
      ((Path)localObject).cubicTo(5.397627F, 2.5F, 1.666667F, 5.671316F, 1.666667F, 9.583333F);
      ((Path)localObject).cubicTo(1.666667F, 11.697003F, 2.755832F, 13.594444F, 4.483131F, 14.892278F);
      ((Path)localObject).lineTo(4.231382F, 17.058012F);
      ((Path)localObject).cubicTo(4.204812F, 17.286591F, 4.368573F, 17.493431F, 4.597153F, 17.52F);
      ((Path)localObject).cubicTo(4.675319F, 17.529087F, 4.754461F, 17.515852F, 4.825418F, 17.481827F);
      ((Path)localObject).lineTo(7.311212F, 16.289864F);
      ((Path)localObject).cubicTo(8.154776F, 16.534145F, 9.05918F, 16.666666F, 10.0F, 16.666666F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_ban_comment_on
 * JD-Core Version:    0.7.0.1
 */