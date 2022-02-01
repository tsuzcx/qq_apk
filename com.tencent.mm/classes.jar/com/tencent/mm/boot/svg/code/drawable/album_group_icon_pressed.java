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

public class album_group_icon_pressed
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
      localPaint.setColor(-15028967);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(2.5F, 20.0F);
      ((Path)localObject).lineTo(2.5F, 19.315464F);
      ((Path)localObject).cubicTo(2.5F, 18.630375F, 2.998151F, 17.831907F, 3.614098F, 17.531332F);
      ((Path)localObject).lineTo(9.27445F, 14.769143F);
      ((Path)localObject).cubicTo(10.095377F, 14.36854F, 10.286259F, 13.481262F, 9.693445F, 12.778639F);
      ((Path)localObject).lineTo(9.331913F, 12.350138F);
      ((Path)localObject).cubicTo(8.596317F, 11.478285F, 8.0F, 9.849497F, 8.0F, 8.709291F);
      ((Path)localObject).lineTo(8.0F, 6.99958F);
      ((Path)localObject).cubicTo(8.0F, 4.790673F, 9.795356F, 3.0F, 12.0F, 3.0F);
      ((Path)localObject).cubicTo(14.209139F, 3.0F, 16.0F, 4.79298F, 16.0F, 7.000207F);
      ((Path)localObject).lineTo(16.0F, 8.710186F);
      ((Path)localObject).cubicTo(16.0F, 9.849296F, 15.400932F, 11.482861F, 14.668087F, 12.351573F);
      ((Path)localObject).lineTo(14.306555F, 12.780132F);
      ((Path)localObject).cubicTo(13.717032F, 13.478951F, 13.901188F, 14.368398F, 14.725549F, 14.770511F);
      ((Path)localObject).lineTo(20.385902F, 17.531557F);
      ((Path)localObject).cubicTo(21.001202F, 17.831692F, 21.5F, 18.62517F, 21.5F, 19.315464F);
      ((Path)localObject).lineTo(21.5F, 20.0F);
      ((Path)localObject).cubicTo(21.5F, 20.552284F, 21.052284F, 21.0F, 20.5F, 21.0F);
      ((Path)localObject).lineTo(3.5F, 21.0F);
      ((Path)localObject).cubicTo(2.947715F, 21.0F, 2.5F, 20.552284F, 2.5F, 20.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_group_icon_pressed
 * JD-Core Version:    0.7.0.1
 */