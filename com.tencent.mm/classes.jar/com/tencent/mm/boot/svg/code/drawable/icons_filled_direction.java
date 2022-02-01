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

public class icons_filled_direction
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.5F, 3.0F);
      ((Path)localObject).cubicTo(13.709139F, 3.0F, 15.5F, 4.79298F, 15.5F, 7.000207F);
      ((Path)localObject).lineTo(15.5F, 8.710186F);
      ((Path)localObject).cubicTo(15.5F, 9.849296F, 14.900932F, 11.482861F, 14.168087F, 12.351573F);
      ((Path)localObject).lineTo(13.806555F, 12.780132F);
      ((Path)localObject).cubicTo(13.217032F, 13.478951F, 13.401188F, 14.368398F, 14.225549F, 14.770511F);
      ((Path)localObject).lineTo(19.885902F, 17.531557F);
      ((Path)localObject).cubicTo(20.501202F, 17.831692F, 21.0F, 18.62517F, 21.0F, 19.315464F);
      ((Path)localObject).lineTo(21.0F, 20.0F);
      ((Path)localObject).cubicTo(21.0F, 20.552284F, 20.552284F, 21.0F, 20.0F, 21.0F);
      ((Path)localObject).lineTo(3.0F, 21.0F);
      ((Path)localObject).cubicTo(2.447715F, 21.0F, 2.0F, 20.552284F, 2.0F, 20.0F);
      ((Path)localObject).lineTo(2.0F, 19.315464F);
      ((Path)localObject).cubicTo(2.0F, 18.630375F, 2.498151F, 17.831907F, 3.114098F, 17.531332F);
      ((Path)localObject).lineTo(8.77445F, 14.769143F);
      ((Path)localObject).cubicTo(9.595377F, 14.36854F, 9.786259F, 13.481262F, 9.193445F, 12.778639F);
      ((Path)localObject).lineTo(8.831913F, 12.350138F);
      ((Path)localObject).cubicTo(8.096317F, 11.478285F, 7.5F, 9.849497F, 7.5F, 8.709291F);
      ((Path)localObject).lineTo(7.5F, 6.99958F);
      ((Path)localObject).cubicTo(7.5F, 4.790673F, 9.295356F, 3.0F, 11.5F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.0F, 11.0F);
      ((Path)localObject).cubicTo(21.552284F, 11.0F, 22.0F, 11.447716F, 22.0F, 12.0F);
      ((Path)localObject).cubicTo(22.0F, 12.552284F, 21.552284F, 13.0F, 21.0F, 13.0F);
      ((Path)localObject).cubicTo(20.447716F, 13.0F, 20.0F, 12.552284F, 20.0F, 12.0F);
      ((Path)localObject).cubicTo(20.0F, 11.447716F, 20.447716F, 11.0F, 21.0F, 11.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.483055F, 4.0F);
      ((Path)localObject).cubicTo(21.759197F, 4.0F, 21.983055F, 4.223857F, 21.983055F, 4.5F);
      ((Path)localObject).cubicTo(21.983055F, 4.505554F, 21.982964F, 4.511107F, 21.982779F, 4.516657F);
      ((Path)localObject).lineTo(21.816111F, 9.516658F);
      ((Path)localObject).cubicTo(21.807127F, 9.786166F, 21.586048F, 10.0F, 21.316389F, 10.0F);
      ((Path)localObject).lineTo(20.683611F, 10.0F);
      ((Path)localObject).cubicTo(20.413952F, 10.0F, 20.192873F, 9.786166F, 20.183889F, 9.516658F);
      ((Path)localObject).lineTo(20.017221F, 4.516657F);
      ((Path)localObject).cubicTo(20.008022F, 4.240668F, 20.224298F, 4.009477F, 20.500286F, 4.000278F);
      ((Path)localObject).lineTo(21.483055F, 4.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_direction
 * JD-Core Version:    0.7.0.1
 */