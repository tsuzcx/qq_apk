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

public class icon_filled_qqmusic
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
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(18.372496F, 2.85027F);
      ((Path)localObject).lineTo(18.388624F, 3.044145F);
      ((Path)localObject).cubicTo(21.180046F, 5.038913F, 23.0F, 8.30692F, 23.0F, 12.0F);
      ((Path)localObject).cubicTo(23.0F, 18.075132F, 18.075132F, 23.0F, 12.0F, 23.0F);
      ((Path)localObject).cubicTo(5.924868F, 23.0F, 1.0F, 18.075132F, 1.0F, 12.0F);
      ((Path)localObject).cubicTo(1.0F, 5.924868F, 5.924868F, 1.0F, 12.0F, 1.0F);
      ((Path)localObject).cubicTo(13.508068F, 1.0F, 14.945256F, 1.303477F, 16.253824F, 1.852691F);
      ((Path)localObject).cubicTo(14.491923F, 2.685543F, 13.080966F, 3.054949F, 9.446322F, 3.365224F);
      ((Path)localObject).cubicTo(8.114638F, 3.419226F, 7.822844F, 3.987392F, 8.570937F, 5.069723F);
      ((Path)localObject).lineTo(8.6657F, 5.20207F);
      ((Path)localObject).lineTo(13.248832F, 13.1415F);
      ((Path)localObject).cubicTo(12.849658F, 13.049127F, 12.431204F, 13.0F, 12.0F, 13.0F);
      ((Path)localObject).cubicTo(9.238576F, 13.0F, 7.0F, 15.014719F, 7.0F, 17.5F);
      ((Path)localObject).cubicTo(7.0F, 19.985281F, 9.238576F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject).cubicTo(14.761424F, 22.0F, 17.0F, 19.985281F, 17.0F, 17.5F);
      ((Path)localObject).cubicTo(17.0F, 16.89559F, 16.867601F, 16.31901F, 16.62878F, 15.792655F);
      ((Path)localObject).lineTo(16.519991F, 15.570215F);
      ((Path)localObject).lineTo(16.478785F, 15.497319F);
      ((Path)localObject).lineTo(16.440762F, 15.43F);
      ((Path)localObject).lineTo(16.440762F, 15.43F);
      ((Path)localObject).lineTo(16.401527F, 15.363338F);
      ((Path)localObject).lineTo(12.0F, 7.703892F);
      ((Path)localObject).lineTo(12.371978F, 7.455636F);
      ((Path)localObject).cubicTo(14.694061F, 5.876977F, 16.342192F, 4.198401F, 17.31637F, 2.419908F);
      ((Path)localObject).lineTo(17.315317F, 2.419309F);
      ((Path)localObject).cubicTo(17.750837F, 1.512854F, 17.978531F, 1.003898F, 17.998402F, 0.8924422F);
      ((Path)localObject).cubicTo(18.019985F, 0.771378F, 18.248217F, 1.439142F, 18.372496F, 2.85027F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_qqmusic
 * JD-Core Version:    0.7.0.1
 */