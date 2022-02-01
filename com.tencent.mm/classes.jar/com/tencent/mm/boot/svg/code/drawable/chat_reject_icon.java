package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class chat_reject_icon
  extends c
{
  private final int height = 42;
  private final int width = 42;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 42;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 38, 31);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -1538.0F, 0.0F, 1.0F, -387.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1539.7643F, 389.76389F);
      ((Path)localObject2).cubicTo(1539.5017F, 389.20786F, 1539.599F, 388.52539F, 1540.0621F, 388.06216F);
      ((Path)localObject2).cubicTo(1540.6488F, 387.47556F, 1541.5945F, 387.47012F, 1542.1871F, 388.06277F);
      ((Path)localObject2).lineTo(1548.1244F, 394.0F);
      ((Path)localObject2).lineTo(1570.9926F, 394.0F);
      ((Path)localObject2).cubicTo(1572.6536F, 394.0F, 1574.0F, 395.34311F, 1574.0F, 397.00793F);
      ((Path)localObject2).lineTo(1574.0F, 416.99207F);
      ((Path)localObject2).cubicTo(1574.0F, 417.79092F, 1573.6871F, 418.51703F, 1573.1799F, 419.05563F);
      ((Path)localObject2).lineTo(1577.2443F, 423.11996F);
      ((Path)localObject2).cubicTo(1577.8313F, 423.70694F, 1577.8357F, 424.65421F, 1577.2449F, 425.24493F);
      ((Path)localObject2).cubicTo(1576.7841F, 425.70578F, 1576.1017F, 425.80792F, 1575.5428F, 425.54321F);
      ((Path)localObject2).cubicTo(1575.4706F, 425.39014F, 1575.371F, 425.24667F, 1575.2443F, 425.11996F);
      ((Path)localObject2).lineTo(1540.1871F, 390.06277F);
      ((Path)localObject2).cubicTo(1540.0601F, 389.93573F, 1539.9167F, 389.83615F, 1539.7643F, 389.76389F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(1540.0359F, 394.16028F);
      ((Path)localObject2).cubicTo(1538.8513F, 394.56421F, 1538.0F, 395.68658F, 1538.0F, 397.00793F);
      ((Path)localObject2).lineTo(1538.0F, 416.99207F);
      ((Path)localObject2).cubicTo(1538.0F, 418.65689F, 1539.3418F, 420.0F, 1540.9968F, 420.0F);
      ((Path)localObject2).lineTo(1547.0F, 420.0F);
      ((Path)localObject2).lineTo(1547.0F, 426.88751F);
      ((Path)localObject2).cubicTo(1547.0F, 428.08762F, 1547.6836F, 428.36902F, 1548.5267F, 427.52051F);
      ((Path)localObject2).lineTo(1556.0F, 420.0F);
      ((Path)localObject2).lineTo(1565.8756F, 420.0F);
      ((Path)localObject2).lineTo(1540.0359F, 394.16028F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chat_reject_icon
 * JD-Core Version:    0.7.0.1
 */