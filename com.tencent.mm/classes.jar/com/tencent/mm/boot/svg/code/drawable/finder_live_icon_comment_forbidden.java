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

public class finder_live_icon_comment_forbidden
  extends c
{
  private final int height = 12;
  private final int width = 12;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 12;
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
      localPaint.setColor(-372399);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(2.065926F, 3.235363F);
      ((Path)localObject).lineTo(8.412821F, 9.90645F);
      ((Path)localObject).cubicTo(7.697423F, 10.259275F, 6.874957F, 10.460069F, 6.0F, 10.460069F);
      ((Path)localObject).cubicTo(5.576631F, 10.460069F, 5.165552F, 10.413056F, 4.772946F, 10.324555F);
      ((Path)localObject).lineTo(4.386727F, 10.222429F);
      ((Path)localObject).lineTo(2.895251F, 10.974167F);
      ((Path)localObject).cubicTo(2.852676F, 10.995625F, 2.805191F, 11.003973F, 2.758292F, 10.998242F);
      ((Path)localObject).cubicTo(2.655431F, 10.985675F, 2.574446F, 10.909156F, 2.547108F, 10.810864F);
      ((Path)localObject).lineTo(2.53883F, 10.706879F);
      ((Path)localObject).lineTo(2.689878F, 9.341013F);
      ((Path)localObject).cubicTo(1.653499F, 8.522507F, 1.0F, 7.325845F, 1.0F, 5.992814F);
      ((Path)localObject).cubicTo(1.0F, 4.952228F, 1.398218F, 3.99474F, 2.065926F, 3.235363F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(2.06066F, 1.0F);
      ((Path)localObject).lineTo(3.2574F, 2.256973F);
      ((Path)localObject).cubicTo(4.044855F, 1.794569F, 4.987266F, 1.525559F, 6.0F, 1.525559F);
      ((Path)localObject).cubicTo(8.761424F, 1.525559F, 11.0F, 3.525617F, 11.0F, 5.992814F);
      ((Path)localObject).cubicTo(11.0F, 7.156989F, 10.501574F, 8.217155F, 9.684979F, 9.012259F);
      ((Path)localObject).lineTo(10.545941F, 9.919039F);
      ((Path)localObject).lineTo(10.015612F, 10.476479F);
      ((Path)localObject).lineTo(1.53033F, 1.55744F);
      ((Path)localObject).lineTo(2.06066F, 1.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_icon_comment_forbidden
 * JD-Core Version:    0.7.0.1
 */