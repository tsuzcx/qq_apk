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

public class icons_filled_quote
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
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.689013F, 24.0F);
      ((Path)localObject).cubicTo(25.153582F, 26.820965F, 22.424442F, 31.386164F, 22.501591F, 37.695599F);
      ((Path)localObject).lineTo(22.501591F, 37.695599F);
      ((Path)localObject).lineTo(22.501591F, 48.0F);
      ((Path)localObject).lineTo(32.805992F, 48.0F);
      ((Path)localObject).lineTo(32.805992F, 37.695599F);
      ((Path)localObject).lineTo(27.652996F, 37.695599F);
      ((Path)localObject).cubicTo(27.652996F, 33.263943F, 29.370663F, 30.041195F, 32.805992F, 28.027359F);
      ((Path)localObject).cubicTo(31.394672F, 25.342453F, 30.689013F, 24.0F, 30.689013F, 24.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(47.369011F, 24.0F);
      ((Path)localObject).cubicTo(41.833584F, 26.820965F, 39.104443F, 31.386164F, 39.181591F, 37.695599F);
      ((Path)localObject).lineTo(39.181591F, 37.695599F);
      ((Path)localObject).lineTo(39.181591F, 48.0F);
      ((Path)localObject).lineTo(49.485992F, 48.0F);
      ((Path)localObject).lineTo(49.485992F, 37.695599F);
      ((Path)localObject).lineTo(44.332996F, 37.695599F);
      ((Path)localObject).cubicTo(44.332996F, 33.263943F, 46.050663F, 30.041195F, 49.485992F, 28.027359F);
      ((Path)localObject).cubicTo(48.074673F, 25.342453F, 47.369011F, 24.0F, 47.369011F, 24.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_quote
 * JD-Core Version:    0.7.0.1
 */