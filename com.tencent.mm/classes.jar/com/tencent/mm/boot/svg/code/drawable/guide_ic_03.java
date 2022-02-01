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

public class guide_ic_03
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -287.0F, 0.0F, 1.0F, -610.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 287.0F, 0.0F, 1.0F, 610.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(48.0F, 0.0F);
      ((Path)localObject).lineTo(48.0F, 48.0F);
      ((Path)localObject).lineTo(0.0F, 48.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(24.0F, 4.0F);
      ((Path)localObject).cubicTo(35.045696F, 4.0F, 44.0F, 12.954305F, 44.0F, 24.0F);
      ((Path)localObject).cubicTo(44.0F, 35.045696F, 35.045696F, 44.0F, 24.0F, 44.0F);
      ((Path)localObject).cubicTo(12.954305F, 44.0F, 4.0F, 35.045696F, 4.0F, 24.0F);
      ((Path)localObject).cubicTo(4.0F, 12.954305F, 12.954305F, 4.0F, 24.0F, 4.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 6.4F);
      ((Path)localObject).cubicTo(14.279788F, 6.4F, 6.4F, 14.279788F, 6.4F, 24.0F);
      ((Path)localObject).cubicTo(6.4F, 33.720211F, 14.279788F, 41.599998F, 24.0F, 41.599998F);
      ((Path)localObject).cubicTo(33.720211F, 41.599998F, 41.599998F, 33.720211F, 41.599998F, 24.0F);
      ((Path)localObject).cubicTo(41.599998F, 14.279788F, 33.720211F, 6.4F, 24.0F, 6.4F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.433197F, 22.980652F);
      ((Path)localObject).cubicTo(26.967815F, 22.980652F, 29.414766F, 23.60272F, 31.600103F, 24.773226F);
      ((Path)localObject).lineTo(31.817759F, 24.892101F);
      ((Path)localObject).lineTo(30.650215F, 26.988966F);
      ((Path)localObject).cubicTo(28.765032F, 25.939287F, 26.64102F, 25.380651F, 24.433197F, 25.380651F);
      ((Path)localObject).cubicTo(22.158596F, 25.380651F, 19.973698F, 25.973795F, 18.049559F, 27.083376F);
      ((Path)localObject).lineTo(17.851448F, 27.200001F);
      ((Path)localObject).lineTo(16.615438F, 25.14275F);
      ((Path)localObject).cubicTo(18.957834F, 23.735424F, 21.64163F, 22.980652F, 24.433197F, 22.980652F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.0F, 11.8F);
      ((Path)localObject).cubicTo(18.656855F, 11.8F, 20.0F, 13.143146F, 20.0F, 14.8F);
      ((Path)localObject).cubicTo(20.0F, 16.456854F, 18.656855F, 17.799999F, 17.0F, 17.799999F);
      ((Path)localObject).cubicTo(15.343145F, 17.799999F, 14.0F, 16.456854F, 14.0F, 14.8F);
      ((Path)localObject).cubicTo(14.0F, 13.143146F, 15.343145F, 11.8F, 17.0F, 11.8F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(31.0F, 11.8F);
      ((Path)localObject).cubicTo(32.656853F, 11.8F, 34.0F, 13.143146F, 34.0F, 14.8F);
      ((Path)localObject).cubicTo(34.0F, 16.456854F, 32.656853F, 17.799999F, 31.0F, 17.799999F);
      ((Path)localObject).cubicTo(29.343145F, 17.799999F, 28.0F, 16.456854F, 28.0F, 14.8F);
      ((Path)localObject).cubicTo(28.0F, 13.143146F, 29.343145F, 11.8F, 31.0F, 11.8F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.guide_ic_03
 * JD-Core Version:    0.7.0.1
 */