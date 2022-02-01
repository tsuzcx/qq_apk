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

public class icons_filled_pk
  extends c
{
  private final int height = 10;
  private final int width = 18;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 18;
      return 10;
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
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-40634);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.060205F, 0.4090909F);
      ((Path)localObject2).cubicTo(6.369799F, 0.4126834F, 6.679006F, 0.4312131F, 6.986642F, 0.4646092F);
      ((Path)localObject2).cubicTo(7.339861F, 0.503057F, 7.681112F, 0.6101192F, 7.989411F, 0.7792127F);
      ((Path)localObject2).cubicTo(8.333344F, 0.9757457F, 8.58698F, 1.289006F, 8.69964F, 1.656402F);
      ((Path)localObject2).cubicTo(8.838752F, 2.07853F, 8.874283F, 2.52558F, 8.803482F, 2.962932F);
      ((Path)localObject2).cubicTo(8.749542F, 3.399462F, 8.617428F, 3.823882F, 8.412914F, 4.217645F);
      ((Path)localObject2).cubicTo(8.212292F, 4.615706F, 7.908782F, 4.958365F, 7.531035F, 5.213272F);
      ((Path)localObject2).cubicTo(7.224313F, 5.412164F, 6.881096F, 5.554053F, 6.519355F, 5.63151F);
      ((Path)localObject2).cubicTo(6.089562F, 5.702914F, 5.653637F, 5.735136F, 5.217461F, 5.727742F);
      ((Path)localObject2).lineTo(2.994571F, 5.727091F);
      ((Path)localObject2).lineTo(2.428752F, 8.590909F);
      ((Path)localObject2).lineTo(0.4285714F, 8.578101F);
      ((Path)localObject2).lineTo(2.098239F, 0.4090909F);
      ((Path)localObject2).lineTo(6.060205F, 0.4090909F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.355572F, 3.898091F);
      ((Path)localObject2).lineTo(5.495778F, 3.898173F);
      ((Path)localObject2).cubicTo(5.581F, 3.89971F, 5.666189F, 3.895757F, 5.750834F, 3.886351F);
      ((Path)localObject2).lineTo(5.877331F, 3.86816F);
      ((Path)localObject2).cubicTo(5.983348F, 3.844003F, 6.083936F, 3.79975F, 6.173829F, 3.737718F);
      ((Path)localObject2).cubicTo(6.284537F, 3.658217F, 6.373488F, 3.551347F, 6.432285F, 3.427198F);
      ((Path)localObject2).cubicTo(6.492223F, 3.30439F, 6.530942F, 3.17202F, 6.546751F, 3.035874F);
      ((Path)localObject2).cubicTo(6.567501F, 2.899471F, 6.557087F, 2.760043F, 6.516317F, 2.628388F);
      ((Path)localObject2).cubicTo(6.4833F, 2.513803F, 6.408965F, 2.416102F, 6.308167F, 2.354807F);
      ((Path)localObject2).cubicTo(6.217813F, 2.302069F, 6.1178F, 2.268678F, 6.014281F, 2.256687F);
      ((Path)localObject2).lineTo(5.878738F, 2.244544F);
      ((Path)localObject2).lineTo(5.878738F, 2.244544F);
      ((Path)localObject2).lineTo(5.742765F, 2.239372F);
      ((Path)localObject2).lineTo(3.683571F, 2.239091F);
      ((Path)localObject2).lineTo(3.355572F, 3.898091F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15683841);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(14.079637F, 8.578101F);
      ((Path)localObject1).lineTo(12.029649F, 5.35032F);
      ((Path)localObject1).lineTo(10.817412F, 6.477665F);
      ((Path)localObject1).lineTo(10.41055F, 8.590909F);
      ((Path)localObject1).lineTo(8.41037F, 8.578101F);
      ((Path)localObject1).lineTo(10.051476F, 0.445096F);
      ((Path)localObject1).lineTo(11.99841F, 0.445096F);
      ((Path)localObject1).lineTo(11.385926F, 3.553142F);
      ((Path)localObject1).lineTo(14.827817F, 0.4408263F);
      ((Path)localObject1).lineTo(17.454935F, 0.445096F);
      ((Path)localObject1).lineTo(13.469698F, 4.052069F);
      ((Path)localObject1).lineTo(16.318954F, 8.565293F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pk
 * JD-Core Version:    0.7.0.1
 */