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

public class icons_filled_umbrella
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.85F, 12.105901F);
      ((Path)localObject2).lineTo(10.85F, 17.243652F);
      ((Path)localObject2).lineTo(10.85F, 17.243652F);
      ((Path)localObject2).cubicTo(10.85F, 18.76145F, 9.663526F, 20.002131F, 8.16746F, 20.088814F);
      ((Path)localObject2).lineTo(8.0F, 20.093653F);
      ((Path)localObject2).lineTo(7.794312F, 20.093653F);
      ((Path)localObject2).cubicTo(6.2203F, 20.093653F, 4.944312F, 18.817663F, 4.944312F, 17.243652F);
      ((Path)localObject2).cubicTo(4.944312F, 16.77421F, 5.32487F, 16.393652F, 5.794312F, 16.393652F);
      ((Path)localObject2).cubicTo(6.227643F, 16.393652F, 6.585238F, 16.717915F, 6.637689F, 17.13703F);
      ((Path)localObject2).lineTo(6.644311F, 17.243652F);
      ((Path)localObject2).cubicTo(6.644311F, 17.836437F, 7.092823F, 18.324469F, 7.669006F, 18.386904F);
      ((Path)localObject2).lineTo(7.794312F, 18.393652F);
      ((Path)localObject2).lineTo(8.0F, 18.393652F);
      ((Path)localObject2).cubicTo(8.592786F, 18.393652F, 9.080816F, 17.945141F, 9.143252F, 17.368958F);
      ((Path)localObject2).lineTo(9.15F, 17.243652F);
      ((Path)localObject2).lineTo(9.15F, 12.105901F);
      ((Path)localObject2).cubicTo(9.15F, 11.636458F, 9.530558F, 11.2559F, 10.0F, 11.2559F);
      ((Path)localObject2).cubicTo(10.469442F, 11.2559F, 10.85F, 11.636458F, 10.85F, 12.105901F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.0F, 0.0F);
      ((Path)localObject2).cubicTo(10.469442F, 3.307132E-016F, 10.85F, 0.380558F, 10.85F, 0.85F);
      ((Path)localObject2).lineTo(10.85F, 2.0F);
      ((Path)localObject2).lineTo(9.149F, 2.0F);
      ((Path)localObject2).lineTo(9.15F, 0.85F);
      ((Path)localObject2).cubicTo(9.15F, 0.380558F, 9.530558F, 1.259468E-014F, 10.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(10.0F, 1.0F);
      ((Path)localObject1).cubicTo(15.522847F, 1.0F, 20.0F, 5.477152F, 20.0F, 11.0F);
      ((Path)localObject1).lineTo(19.99679F, 11.2559F);
      ((Path)localObject1).lineTo(19.99679F, 11.2559F);
      ((Path)localObject1).cubicTo(19.04615F, 10.470693F, 17.828043F, 10.0F, 16.5F, 10.0F);
      ((Path)localObject1).cubicTo(15.222575F, 10.0F, 14.046865F, 10.435496F, 13.113922F, 11.165782F);
      ((Path)localObject1).cubicTo(12.228573F, 10.556596F, 11.155931F, 10.2F, 10.0F, 10.2F);
      ((Path)localObject1).cubicTo(8.84407F, 10.2F, 7.771427F, 10.556596F, 6.88676F, 11.166119F);
      ((Path)localObject1).cubicTo(5.953135F, 10.435496F, 4.777425F, 10.0F, 3.5F, 10.0F);
      ((Path)localObject1).cubicTo(2.171528F, 10.0F, 0.953063F, 10.470997F, 0.00248315F, 11.255113F);
      ((Path)localObject1).lineTo(0.0F, 11.0F);
      ((Path)localObject1).cubicTo(0.0F, 5.477152F, 4.477152F, 1.0F, 10.0F, 1.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_umbrella
 * JD-Core Version:    0.7.0.1
 */