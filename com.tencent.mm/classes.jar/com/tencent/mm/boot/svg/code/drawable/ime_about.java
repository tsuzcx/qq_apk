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

public class ime_about
  extends c
{
  private final int height = 51;
  private final int width = 51;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 51;
      return 51;
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
      localPaint1.setColor(-11842483);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -597.0F, 0.0F, 1.0F, -1120.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 597.0F, 0.0F, 1.0F, 1120.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.159399F, 0.002324762F);
      ((Path)localObject2).cubicTo(11.078797F, 0.1905454F, -0.185896F, 11.760048F, 0.002324773F, 25.844204F);
      ((Path)localObject2).cubicTo(0.190546F, 39.918678F, 11.760054F, 51.187038F, 25.840601F, 50.997646F);
      ((Path)localObject2).cubicTo(39.921204F, 50.809425F, 51.185898F, 39.239925F, 50.997677F, 25.155767F);
      ((Path)localObject2).cubicTo(50.811905F, 11.078847F, 39.239944F, -0.1858959F, 25.159399F, 0.002324762F);
      ((Path)localObject2).lineTo(25.159399F, 0.002324762F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(27.986217F, 8.500915F);
      ((Path)localObject2).cubicTo(30.577452F, 8.500915F, 31.342466F, 10.002951F, 31.342466F, 11.723595F);
      ((Path)localObject2).cubicTo(31.342466F, 13.872827F, 29.620653F, 15.859384F, 26.685757F, 15.859384F);
      ((Path)localObject2).cubicTo(24.230539F, 15.859384F, 23.062368F, 14.62326F, 23.131601F, 12.583276F);
      ((Path)localObject2).cubicTo(23.132826F, 10.862688F, 24.574146F, 8.500915F, 27.986217F, 8.500915F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.339331F, 41.437798F);
      ((Path)localObject2).cubicTo(19.567707F, 41.437798F, 18.270922F, 40.361958F, 19.509438F, 35.633625F);
      ((Path)localObject2).lineTo(21.540909F, 27.251574F);
      ((Path)localObject2).cubicTo(21.89303F, 25.907372F, 21.9513F, 25.369478F, 21.540909F, 25.369478F);
      ((Path)localObject2).cubicTo(21.011475F, 25.369478F, 18.710474F, 26.298393F, 17.350521F, 27.212727F);
      ((Path)localObject2).lineTo(16.466518F, 25.762894F);
      ((Path)localObject2).cubicTo(20.777119F, 22.165052F, 25.732521F, 20.053442F, 27.856266F, 20.053442F);
      ((Path)localObject2).cubicTo(29.626665F, 20.053442F, 29.920515F, 22.149246F, 29.036512F, 25.371927F);
      ((Path)localObject2).lineTo(26.708742F, 34.186241F);
      ((Path)localObject2).cubicTo(26.298351F, 35.744152F, 26.475609F, 36.282043F, 26.886055F, 36.282043F);
      ((Path)localObject2).cubicTo(27.415487F, 36.282043F, 29.159174F, 35.638466F, 30.871248F, 34.29187F);
      ((Path)localObject2).lineTo(31.87179F, 35.636074F);
      ((Path)localObject2).cubicTo(27.683794F, 39.824066F, 23.113348F, 41.437798F, 21.339275F, 41.437798F);
      ((Path)localObject2).lineTo(21.339275F, 41.437798F);
      ((Path)localObject2).lineTo(21.339331F, 41.437798F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_about
 * JD-Core Version:    0.7.0.1
 */