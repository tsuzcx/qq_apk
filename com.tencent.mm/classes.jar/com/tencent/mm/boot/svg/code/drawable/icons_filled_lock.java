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

public class icons_filled_lock
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 2.0F);
      ((Path)localObject).cubicTo(14.485281F, 2.0F, 16.5F, 4.014719F, 16.5F, 6.5F);
      ((Path)localObject).lineTo(16.5F, 9.0F);
      ((Path)localObject).lineTo(18.999128F, 9.0F);
      ((Path)localObject).cubicTo(19.551895F, 9.0F, 20.0F, 9.44749F, 20.0F, 9.998503F);
      ((Path)localObject).lineTo(20.0F, 21.001497F);
      ((Path)localObject).cubicTo(20.0F, 21.552956F, 19.555368F, 22.0F, 18.999128F, 22.0F);
      ((Path)localObject).lineTo(5.000872F, 22.0F);
      ((Path)localObject).cubicTo(4.448105F, 22.0F, 4.0F, 21.552511F, 4.0F, 21.001497F);
      ((Path)localObject).lineTo(4.0F, 9.998503F);
      ((Path)localObject).cubicTo(4.0F, 9.447044F, 4.444631F, 9.0F, 5.000872F, 9.0F);
      ((Path)localObject).lineTo(7.5F, 9.0F);
      ((Path)localObject).lineTo(7.5F, 6.5F);
      ((Path)localObject).cubicTo(7.5F, 4.014719F, 9.514719F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 13.0F);
      ((Path)localObject).cubicTo(11.171573F, 13.0F, 10.5F, 13.671573F, 10.5F, 14.5F);
      ((Path)localObject).cubicTo(10.5F, 15.11479F, 10.869861F, 15.643195F, 11.399211F, 15.874842F);
      ((Path)localObject).lineTo(11.4F, 18.0F);
      ((Path)localObject).lineTo(12.599999F, 18.0F);
      ((Path)localObject).lineTo(12.599782F, 15.875282F);
      ((Path)localObject).cubicTo(13.12967F, 15.643866F, 13.5F, 15.11518F, 13.5F, 14.5F);
      ((Path)localObject).cubicTo(13.5F, 13.671573F, 12.828427F, 13.0F, 12.0F, 13.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 3.5F);
      ((Path)localObject).cubicTo(10.343145F, 3.5F, 9.0F, 4.843146F, 9.0F, 6.5F);
      ((Path)localObject).lineTo(9.0F, 9.0F);
      ((Path)localObject).lineTo(15.0F, 9.0F);
      ((Path)localObject).lineTo(15.0F, 6.5F);
      ((Path)localObject).cubicTo(15.0F, 4.843146F, 13.656855F, 3.5F, 12.0F, 3.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_lock
 * JD-Core Version:    0.7.0.1
 */