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

public class icons_filled_duddle
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(44.430546F, 20.098555F);
      ((Path)localObject).cubicTo(35.796257F, 22.485422F, 23.661943F, 32.746632F, 16.620869F, 46.05238F);
      ((Path)localObject).lineTo(12.643434F, 43.94762F);
      ((Path)localObject).cubicTo(20.245993F, 29.580816F, 33.361794F, 18.48963F, 43.231533F, 15.761231F);
      ((Path)localObject).cubicTo(47.055542F, 14.704119F, 50.059509F, 15.430939F, 50.94257F, 18.308987F);
      ((Path)localObject).cubicTo(51.626526F, 20.53812F, 50.546776F, 23.276211F, 48.298676F, 26.003262F);
      ((Path)localObject).cubicTo(44.513027F, 30.595423F, 40.259773F, 37.587383F, 38.060089F, 42.721901F);
      ((Path)localObject).cubicTo(37.800529F, 43.327766F, 37.57674F, 43.892372F, 37.391201F, 44.407986F);
      ((Path)localObject).cubicTo(42.81765F, 40.371899F, 46.638741F, 38.876896F, 49.13517F, 40.479836F);
      ((Path)localObject).cubicTo(51.517227F, 42.009335F, 51.378086F, 44.97728F, 49.628651F, 48.784992F);
      ((Path)localObject).cubicTo(50.701393F, 48.220657F, 52.006596F, 47.471478F, 53.518982F, 46.542164F);
      ((Path)localObject).lineTo(55.874874F, 50.37619F);
      ((Path)localObject).cubicTo(51.871368F, 52.836224F, 49.154423F, 54.184273F, 47.411106F, 54.478592F);
      ((Path)localObject).cubicTo(43.444099F, 55.148331F, 42.811646F, 51.909317F, 44.601807F, 48.728851F);
      ((Path)localObject).cubicTo(45.552029F, 47.040653F, 46.138824F, 45.60154F, 46.326122F, 44.587551F);
      ((Path)localObject).cubicTo(46.345699F, 44.481575F, 46.359947F, 44.385365F, 46.369709F, 44.29958F);
      ((Path)localObject).cubicTo(45.48328F, 44.54977F, 42.980667F, 45.798183F, 39.469227F, 48.476501F);
      ((Path)localObject).cubicTo(36.263023F, 50.922001F, 33.275475F, 51.461197F, 32.392006F, 48.005173F);
      ((Path)localObject).cubicTo(31.978731F, 46.388496F, 32.572819F, 44.103054F, 33.923698F, 40.949825F);
      ((Path)localObject).cubicTo(36.29147F, 35.422955F, 40.768135F, 28.063726F, 44.826424F, 23.140837F);
      ((Path)localObject).cubicTo(46.042713F, 21.665424F, 46.621895F, 20.39011F, 46.656567F, 19.821276F);
      ((Path)localObject).cubicTo(46.215672F, 19.744463F, 45.457436F, 19.814678F, 44.430546F, 20.098555F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_duddle
 * JD-Core Version:    0.7.0.1
 */