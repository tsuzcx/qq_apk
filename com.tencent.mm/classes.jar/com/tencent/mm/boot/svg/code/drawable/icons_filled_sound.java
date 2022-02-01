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

public class icons_filled_sound
  extends c
{
  private final int height = 24;
  private final int width = 22;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 22;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -299.0F, 0.0F, 1.0F, -821.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 820.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 272.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.966667F, 4.666667F);
      localPath.cubicTo(11.610999F, 4.666667F, 12.133333F, 5.189001F, 12.133333F, 5.833334F);
      localPath.lineTo(12.133333F, 22.166666F);
      localPath.cubicTo(12.133333F, 22.810999F, 11.610999F, 23.333334F, 10.966667F, 23.333334F);
      localPath.cubicTo(10.322334F, 23.333334F, 9.8F, 22.810999F, 9.8F, 22.166666F);
      localPath.lineTo(9.8F, 5.833334F);
      localPath.cubicTo(9.8F, 5.189001F, 10.322334F, 4.666667F, 10.966667F, 4.666667F);
      localPath.close();
      localPath.moveTo(23.1F, 8.166667F);
      localPath.cubicTo(23.744331F, 8.166667F, 24.266666F, 8.689001F, 24.266666F, 9.333333F);
      localPath.lineTo(24.266666F, 18.666666F);
      localPath.cubicTo(24.266666F, 19.310999F, 23.744331F, 19.833334F, 23.1F, 19.833334F);
      localPath.cubicTo(22.455667F, 19.833334F, 21.933332F, 19.310999F, 21.933332F, 18.666666F);
      localPath.lineTo(21.933332F, 9.333333F);
      localPath.cubicTo(21.933332F, 8.689001F, 22.455667F, 8.166667F, 23.1F, 8.166667F);
      localPath.close();
      localPath.moveTo(4.9F, 8.166667F);
      localPath.cubicTo(5.544332F, 8.166667F, 6.066667F, 8.689001F, 6.066667F, 9.333333F);
      localPath.lineTo(6.066667F, 18.666666F);
      localPath.cubicTo(6.066667F, 19.310999F, 5.544332F, 19.833334F, 4.9F, 19.833334F);
      localPath.cubicTo(4.255668F, 19.833334F, 3.733333F, 19.310999F, 3.733333F, 18.666666F);
      localPath.lineTo(3.733333F, 9.333333F);
      localPath.cubicTo(3.733333F, 8.689001F, 4.255668F, 8.166667F, 4.9F, 8.166667F);
      localPath.close();
      localPath.moveTo(17.033333F, 10.5F);
      localPath.cubicTo(17.677666F, 10.5F, 18.200001F, 11.022334F, 18.200001F, 11.666667F);
      localPath.lineTo(18.200001F, 16.333334F);
      localPath.cubicTo(18.200001F, 16.977665F, 17.677666F, 17.5F, 17.033333F, 17.5F);
      localPath.cubicTo(16.389002F, 17.5F, 15.866667F, 16.977665F, 15.866667F, 16.333334F);
      localPath.lineTo(15.866667F, 11.666667F);
      localPath.cubicTo(15.866667F, 11.022334F, 16.389002F, 10.5F, 17.033333F, 10.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 3.5F, 0.0F, 1.0F, 1.166667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(9.333687F, 2.397378F);
      ((Path)localObject2).lineTo(9.333324F, 4.749372F);
      ((Path)localObject2).cubicTo(5.375652F, 5.315477F, 2.333333F, 8.719119F, 2.333333F, 12.833333F);
      ((Path)localObject2).cubicTo(2.333333F, 17.343658F, 5.989675F, 21.0F, 10.5F, 21.0F);
      ((Path)localObject2).cubicTo(15.010325F, 21.0F, 18.666666F, 17.343658F, 18.666666F, 12.833333F);
      ((Path)localObject2).cubicTo(18.666666F, 10.954031F, 18.031885F, 9.22299F, 16.965038F, 7.842927F);
      ((Path)localObject2).lineTo(16.796928F, 7.63268F);
      ((Path)localObject2).lineTo(19.230915F, 6.998589F);
      ((Path)localObject2).cubicTo(20.348316F, 8.667316F, 21.0F, 10.67422F, 21.0F, 12.833333F);
      ((Path)localObject2).cubicTo(21.0F, 18.632322F, 16.29899F, 23.333334F, 10.5F, 23.333334F);
      ((Path)localObject2).cubicTo(4.70101F, 23.333334F, -8.289665E-015F, 18.632322F, -8.289665E-015F, 12.833333F);
      ((Path)localObject2).cubicTo(-8.289665E-015F, 7.428566F, 4.083575F, 2.977569F, 9.333687F, 2.397378F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(19.246092F, 0.5963464F);
      ((Path)localObject2).lineTo(19.24902F, 0.6111901F);
      ((Path)localObject2).lineTo(19.24902F, 0.6111901F);
      ((Path)localObject2).lineTo(19.25F, 3.884869F);
      ((Path)localObject2).cubicTo(19.25F, 3.93777F, 19.214405F, 3.984051F, 19.163275F, 3.997628F);
      ((Path)localObject2).lineTo(14.0F, 5.368759F);
      ((Path)localObject2).lineTo(14.0F, 12.833333F);
      ((Path)localObject2).cubicTo(14.0F, 14.697294F, 12.542927F, 16.220938F, 10.705651F, 16.327393F);
      ((Path)localObject2).lineTo(10.5F, 16.333334F);
      ((Path)localObject2).cubicTo(8.567003F, 16.333334F, 7.0F, 14.76633F, 7.0F, 12.833333F);
      ((Path)localObject2).cubicTo(7.0F, 10.900336F, 8.567003F, 9.333333F, 10.5F, 9.333333F);
      ((Path)localObject2).cubicTo(11.13785F, 9.333333F, 11.735848F, 9.50396F, 12.250842F, 9.802058F);
      ((Path)localObject2).lineTo(12.25F, 3.23064F);
      ((Path)localObject2).cubicTo(12.25F, 2.701622F, 12.605953F, 2.238816F, 13.117253F, 2.103049F);
      ((Path)localObject2).lineTo(19.103392F, 0.5135285F);
      ((Path)localObject2).cubicTo(19.165667F, 0.4969924F, 19.229557F, 0.5340712F, 19.246092F, 0.5963464F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_sound
 * JD-Core Version:    0.7.0.1
 */