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

public class jd_entrance_icon
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
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
      localPaint.setColor(-499359);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(79.037041F, 25.0F);
      ((Path)localObject).lineTo(29.962963F, 25.0F);
      ((Path)localObject).cubicTo(28.879408F, 25.0F, 28.0F, 25.881067F, 28.0F, 26.966667F);
      ((Path)localObject).lineTo(28.0F, 82.033333F);
      ((Path)localObject).cubicTo(28.0F, 83.118935F, 28.879408F, 84.0F, 29.962963F, 84.0F);
      ((Path)localObject).lineTo(79.037041F, 84.0F);
      ((Path)localObject).cubicTo(80.12059F, 84.0F, 81.0F, 83.118935F, 81.0F, 82.033333F);
      ((Path)localObject).lineTo(81.0F, 26.966667F);
      ((Path)localObject).cubicTo(81.0F, 25.880083F, 80.12059F, 25.0F, 79.037041F, 25.0F);
      ((Path)localObject).lineTo(79.037041F, 25.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(69.222221F, 40.388184F);
      ((Path)localObject).lineTo(69.222221F, 52.533333F);
      ((Path)localObject).cubicTo(69.222221F, 60.679268F, 62.630592F, 67.283333F, 54.5F, 67.283333F);
      ((Path)localObject).cubicTo(46.369408F, 67.283333F, 39.777779F, 60.679268F, 39.777779F, 52.533333F);
      ((Path)localObject).lineTo(39.777779F, 40.388184F);
      ((Path)localObject).cubicTo(38.619629F, 39.835548F, 37.814816F, 38.661449F, 37.814816F, 37.291668F);
      ((Path)localObject).cubicTo(37.814816F, 35.3899F, 39.352795F, 33.849998F, 41.25F, 33.849998F);
      ((Path)localObject).cubicTo(43.147205F, 33.849998F, 44.685184F, 35.3899F, 44.685184F, 37.291668F);
      ((Path)localObject).cubicTo(44.685184F, 38.662434F, 43.880371F, 39.835548F, 42.722221F, 40.388184F);
      ((Path)localObject).lineTo(42.722221F, 52.533333F);
      ((Path)localObject).cubicTo(42.722221F, 59.049885F, 47.99474F, 64.333336F, 54.5F, 64.333336F);
      ((Path)localObject).cubicTo(61.004276F, 64.333336F, 66.277779F, 59.049885F, 66.277779F, 52.533333F);
      ((Path)localObject).lineTo(66.277779F, 40.388184F);
      ((Path)localObject).cubicTo(65.119629F, 39.835548F, 64.314812F, 38.661449F, 64.314812F, 37.291668F);
      ((Path)localObject).cubicTo(64.314812F, 35.3899F, 65.852798F, 33.849998F, 67.75F, 33.849998F);
      ((Path)localObject).cubicTo(69.647202F, 33.849998F, 71.185188F, 35.3899F, 71.185188F, 37.291668F);
      ((Path)localObject).cubicTo(71.185188F, 38.661449F, 70.379387F, 39.835548F, 69.222221F, 40.388184F);
      ((Path)localObject).lineTo(69.222221F, 40.388184F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.jd_entrance_icon
 * JD-Core Version:    0.7.0.1
 */