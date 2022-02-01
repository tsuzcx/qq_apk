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

public class icon_filled_switch_to_voice
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.5F, 7.2F);
      ((Path)localObject).lineTo(14.035534F, 10.735534F);
      ((Path)localObject).cubicTo(14.426058F, 11.126059F, 14.426058F, 11.759223F, 14.035534F, 12.149748F);
      ((Path)localObject).lineTo(10.5F, 15.685282F);
      ((Path)localObject).lineTo(9.085787F, 14.271068F);
      ((Path)localObject).lineTo(10.82321F, 12.532297F);
      ((Path)localObject).cubicTo(7.353332F, 12.865187F, 4.623251F, 15.731236F, 4.504059F, 19.25935F);
      ((Path)localObject).lineTo(4.5F, 19.5F);
      ((Path)localObject).lineTo(2.5F, 19.5F);
      ((Path)localObject).cubicTo(2.5F, 14.701895F, 6.254679F, 10.780743F, 10.986155F, 10.514423F);
      ((Path)localObject).lineTo(9.085787F, 8.614214F);
      ((Path)localObject).lineTo(10.5F, 7.2F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.536373F, 4.875996F);
      ((Path)localObject).cubicTo(20.201252F, 6.587265F, 21.226625F, 8.923888F, 21.226625F, 11.5F);
      ((Path)localObject).cubicTo(21.226625F, 14.076112F, 20.201252F, 16.412735F, 18.536373F, 18.124004F);
      ((Path)localObject).lineTo(17.476358F, 17.062435F);
      ((Path)localObject).cubicTo(18.869394F, 15.622788F, 19.726625F, 13.661503F, 19.726625F, 11.5F);
      ((Path)localObject).cubicTo(19.726625F, 9.338497F, 18.869394F, 7.377212F, 17.476358F, 5.937565F);
      ((Path)localObject).lineTo(18.536373F, 4.875996F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.061394F, 7.351521F);
      ((Path)localObject).cubicTo(17.092913F, 8.429066F, 17.726625F, 9.890527F, 17.726625F, 11.5F);
      ((Path)localObject).cubicTo(17.726625F, 13.109473F, 17.092913F, 14.570934F, 16.061394F, 15.648479F);
      ((Path)localObject).lineTo(15.000154F, 14.587736F);
      ((Path)localObject).cubicTo(15.760526F, 13.781904F, 16.226625F, 12.695384F, 16.226625F, 11.5F);
      ((Path)localObject).cubicTo(16.226625F, 10.304616F, 15.760526F, 9.218096F, 15.000154F, 8.412264F);
      ((Path)localObject).lineTo(16.061394F, 7.351521F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_switch_to_voice
 * JD-Core Version:    0.7.0.1
 */