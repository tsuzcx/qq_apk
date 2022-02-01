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

public class c2c_aa_icon_default
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(20.0F, 0.0F);
      ((Path)localObject).cubicTo(31.045694F, 0.0F, 40.0F, 8.954306F, 40.0F, 20.0F);
      ((Path)localObject).cubicTo(40.0F, 31.045694F, 31.045694F, 40.0F, 20.0F, 40.0F);
      ((Path)localObject).cubicTo(8.954306F, 40.0F, 0.0F, 31.045694F, 0.0F, 20.0F);
      ((Path)localObject).cubicTo(0.0F, 8.954306F, 8.954306F, 0.0F, 20.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 1.176471F);
      ((Path)localObject).cubicTo(9.604051F, 1.176471F, 1.176471F, 9.604051F, 1.176471F, 20.0F);
      ((Path)localObject).cubicTo(1.176471F, 30.395948F, 9.604051F, 38.823528F, 20.0F, 38.823528F);
      ((Path)localObject).cubicTo(30.395948F, 38.823528F, 38.823528F, 30.395948F, 38.823528F, 20.0F);
      ((Path)localObject).cubicTo(38.823528F, 9.604051F, 30.395948F, 1.176471F, 20.0F, 1.176471F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.451965F, 10.0F);
      ((Path)localObject).cubicTo(27.884584F, 10.0F, 28.235294F, 10.351369F, 28.235294F, 10.784023F);
      ((Path)localObject).lineTo(28.235294F, 10.784023F);
      ((Path)localObject).lineTo(28.235294F, 20.840981F);
      ((Path)localObject).lineTo(20.570181F, 24.021404F);
      ((Path)localObject).cubicTo(20.482624F, 24.051027F, 20.388624F, 24.06822F, 20.29018F, 24.06822F);
      ((Path)localObject).cubicTo(20.125067F, 24.06822F, 19.97151F, 24.022232F, 19.842844F, 23.943722F);
      ((Path)localObject).lineTo(19.842844F, 23.943722F);
      ((Path)localObject).lineTo(18.083506F, 22.775991F);
      ((Path)localObject).cubicTo(18.037949F, 22.744299F, 17.981506F, 22.725447F, 17.920172F, 22.725447F);
      ((Path)localObject).cubicTo(17.769283F, 22.725447F, 17.647058F, 22.839588F, 17.647058F, 22.98004F);
      ((Path)localObject).cubicTo(17.647058F, 23.016499F, 17.657059F, 23.053991F, 17.673283F, 23.087345F);
      ((Path)localObject).lineTo(17.673283F, 23.087345F);
      ((Path)localObject).lineTo(19.164177F, 26.13707F);
      ((Path)localObject).lineTo(19.199953F, 26.210196F);
      ((Path)localObject).cubicTo(19.29351F, 26.365353F, 19.47151F, 26.470589F, 19.676176F, 26.470589F);
      ((Path)localObject).cubicTo(19.76462F, 26.470589F, 19.847958F, 26.450495F, 19.921957F, 26.415693F);
      ((Path)localObject).lineTo(19.921957F, 26.415693F);
      ((Path)localObject).lineTo(19.981733F, 26.383585F);
      ((Path)localObject).lineTo(28.235294F, 21.941301F);
      ((Path)localObject).lineTo(28.235294F, 29.215977F);
      ((Path)localObject).cubicTo(28.235294F, 29.648981F, 27.883663F, 30.0F, 27.451965F, 30.0F);
      ((Path)localObject).lineTo(27.451965F, 30.0F);
      ((Path)localObject).lineTo(12.548036F, 30.0F);
      ((Path)localObject).cubicTo(12.115416F, 30.0F, 11.764706F, 29.648632F, 11.764706F, 29.215977F);
      ((Path)localObject).lineTo(11.764706F, 29.215977F);
      ((Path)localObject).lineTo(11.764706F, 10.784023F);
      ((Path)localObject).cubicTo(11.764706F, 10.35102F, 12.116338F, 10.0F, 12.548036F, 10.0F);
      ((Path)localObject).lineTo(12.548036F, 10.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.588236F, 15.882353F);
      ((Path)localObject).lineTo(14.705882F, 15.882353F);
      ((Path)localObject).lineTo(14.705882F, 17.058823F);
      ((Path)localObject).lineTo(20.588236F, 17.058823F);
      ((Path)localObject).lineTo(20.588236F, 15.882353F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.588236F, 12.941176F);
      ((Path)localObject).lineTo(14.705882F, 12.941176F);
      ((Path)localObject).lineTo(14.705882F, 14.117647F);
      ((Path)localObject).lineTo(20.588236F, 14.117647F);
      ((Path)localObject).lineTo(20.588236F, 12.941176F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.c2c_aa_icon_default
 * JD-Core Version:    0.7.0.1
 */