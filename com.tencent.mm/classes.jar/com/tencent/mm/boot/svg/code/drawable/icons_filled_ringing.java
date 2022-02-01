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

public class icons_filled_ringing
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
      ((Path)localObject).moveTo(12.035257F, 6.0F);
      ((Path)localObject).lineTo(15.675531F, 6.349707F);
      ((Path)localObject).cubicTo(15.778631F, 6.359618F, 15.857142F, 6.443018F, 15.857142F, 6.542625F);
      ((Path)localObject).lineTo(15.857142F, 8.479497F);
      ((Path)localObject).cubicTo(15.857142F, 8.571278F, 15.790805F, 8.648163F, 15.701707F, 8.668257F);
      ((Path)localObject).lineTo(15.645417F, 8.673137F);
      ((Path)localObject).lineTo(13.436975F, 8.460491F);
      ((Path)localObject).lineTo(13.436975F, 16.061193F);
      ((Path)localObject).lineTo(13.427873F, 16.061819F);
      ((Path)localObject).cubicTo(13.325673F, 17.148512F, 12.375519F, 18.0F, 11.218488F, 18.0F);
      ((Path)localObject).cubicTo(9.993251F, 18.0F, 9.0F, 17.045164F, 9.0F, 15.867313F);
      ((Path)localObject).cubicTo(9.0F, 14.689464F, 9.993251F, 13.734628F, 11.218488F, 13.734628F);
      ((Path)localObject).cubicTo(11.428403F, 13.734628F, 11.631509F, 13.762654F, 11.823977F, 13.815028F);
      ((Path)localObject).lineTo(11.823528F, 6.19364F);
      ((Path)localObject).cubicTo(11.823528F, 6.10186F, 11.88987F, 6.024974F, 11.978968F, 6.00488F);
      ((Path)localObject).lineTo(12.035257F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_ringing
 * JD-Core Version:    0.7.0.1
 */