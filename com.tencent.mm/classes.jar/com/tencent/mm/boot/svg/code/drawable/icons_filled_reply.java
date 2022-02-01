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

public class icons_filled_reply
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
      ((Path)localObject).moveTo(10.0F, 2.5F);
      ((Path)localObject).cubicTo(14.602373F, 2.5F, 18.333334F, 5.671316F, 18.333334F, 9.583333F);
      ((Path)localObject).cubicTo(18.333334F, 11.697003F, 17.244169F, 13.594444F, 15.51687F, 14.892278F);
      ((Path)localObject).lineTo(15.768618F, 17.058012F);
      ((Path)localObject).cubicTo(15.795188F, 17.286591F, 15.631427F, 17.493431F, 15.402847F, 17.52F);
      ((Path)localObject).cubicTo(15.324681F, 17.529087F, 15.24554F, 17.515852F, 15.174582F, 17.481827F);
      ((Path)localObject).lineTo(12.688788F, 16.289864F);
      ((Path)localObject).cubicTo(11.845224F, 16.534145F, 10.94082F, 16.666666F, 10.0F, 16.666666F);
      ((Path)localObject).cubicTo(5.397627F, 16.666666F, 1.666667F, 13.49535F, 1.666667F, 9.583333F);
      ((Path)localObject).cubicTo(1.666667F, 5.671316F, 5.397627F, 2.5F, 10.0F, 2.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.5F, 8.0F);
      ((Path)localObject).cubicTo(5.947715F, 8.0F, 5.5F, 8.447715F, 5.5F, 9.0F);
      ((Path)localObject).cubicTo(5.5F, 9.552285F, 5.947715F, 10.0F, 6.5F, 10.0F);
      ((Path)localObject).cubicTo(7.052285F, 10.0F, 7.5F, 9.552285F, 7.5F, 9.0F);
      ((Path)localObject).cubicTo(7.5F, 8.447715F, 7.052285F, 8.0F, 6.5F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.0F, 8.0F);
      ((Path)localObject).cubicTo(9.447715F, 8.0F, 9.0F, 8.447715F, 9.0F, 9.0F);
      ((Path)localObject).cubicTo(9.0F, 9.552285F, 9.447715F, 10.0F, 10.0F, 10.0F);
      ((Path)localObject).cubicTo(10.552284F, 10.0F, 11.0F, 9.552285F, 11.0F, 9.0F);
      ((Path)localObject).cubicTo(11.0F, 8.447715F, 10.552284F, 8.0F, 10.0F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.5F, 8.0F);
      ((Path)localObject).cubicTo(12.947716F, 8.0F, 12.5F, 8.447715F, 12.5F, 9.0F);
      ((Path)localObject).cubicTo(12.5F, 9.552285F, 12.947716F, 10.0F, 13.5F, 10.0F);
      ((Path)localObject).cubicTo(14.052284F, 10.0F, 14.5F, 9.552285F, 14.5F, 9.0F);
      ((Path)localObject).cubicTo(14.5F, 8.447715F, 14.052284F, 8.0F, 13.5F, 8.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_reply
 * JD-Core Version:    0.7.0.1
 */