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

public class icons_filled_bluetooth
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(35.557423F, 5.870592F);
      ((Path)localObject).lineTo(50.848534F, 21.151468F);
      ((Path)localObject).cubicTo(52.021313F, 22.321831F, 52.02195F, 24.221327F, 50.850769F, 25.393291F);
      ((Path)localObject).cubicTo(50.850498F, 25.393564F, 50.850224F, 25.393835F, 50.849136F, 25.393291F);
      ((Path)localObject).lineTo(40.242115F, 35.999241F);
      ((Path)localObject).lineTo(40.242115F, 35.999241F);
      ((Path)localObject).lineTo(50.849262F, 46.606583F);
      ((Path)localObject).cubicTo(52.020676F, 47.778229F, 52.020706F, 49.677643F, 50.849331F, 50.849331F);
      ((Path)localObject).lineTo(35.557819F, 66.14209F);
      ((Path)localObject).cubicTo(34.972057F, 66.727898F, 34.022312F, 66.727936F, 33.436501F, 66.142174F);
      ((Path)localObject).cubicTo(33.15517F, 65.860863F, 32.997116F, 65.479317F, 32.997116F, 65.081467F);
      ((Path)localObject).lineTo(32.997116F, 43.244244F);
      ((Path)localObject).lineTo(32.997116F, 43.244244F);
      ((Path)localObject).lineTo(21.150757F, 55.091885F);
      ((Path)localObject).lineTo(16.908117F, 50.849243F);
      ((Path)localObject).lineTo(31.755117F, 35.999241F);
      ((Path)localObject).lineTo(16.908117F, 21.150757F);
      ((Path)localObject).lineTo(21.150757F, 16.908117F);
      ((Path)localObject).lineTo(32.997116F, 28.754242F);
      ((Path)localObject).lineTo(32.997116F, 6.931607F);
      ((Path)localObject).cubicTo(32.997116F, 6.10318F, 33.66869F, 5.431607F, 34.497116F, 5.431607F);
      ((Path)localObject).cubicTo(34.894768F, 5.431607F, 35.276146F, 5.589504F, 35.557423F, 5.870592F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.997116F, 43.241241F);
      ((Path)localObject).lineTo(38.997116F, 54.218243F);
      ((Path)localObject).lineTo(44.487118F, 48.728241F);
      ((Path)localObject).lineTo(38.997116F, 43.241241F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.997116F, 17.795242F);
      ((Path)localObject).lineTo(38.997116F, 28.757242F);
      ((Path)localObject).lineTo(44.478115F, 23.276243F);
      ((Path)localObject).lineTo(38.997116F, 17.795242F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_bluetooth
 * JD-Core Version:    0.7.0.1
 */