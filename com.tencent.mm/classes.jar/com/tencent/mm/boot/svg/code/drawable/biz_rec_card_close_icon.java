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

public class biz_rec_card_close_icon
  extends c
{
  private final int height = 14;
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
      return 14;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(13.0F, 0.0F);
      ((Path)localObject3).cubicTo(16.865993F, 0.0F, 20.0F, 3.134007F, 20.0F, 7.0F);
      ((Path)localObject3).cubicTo(20.0F, 10.865993F, 16.865993F, 14.0F, 13.0F, 14.0F);
      ((Path)localObject3).lineTo(7.0F, 14.0F);
      ((Path)localObject3).cubicTo(3.134007F, 14.0F, 0.0F, 10.865993F, 0.0F, 7.0F);
      ((Path)localObject3).cubicTo(0.0F, 3.134007F, 3.134007F, 0.0F, 7.0F, 0.0F);
      ((Path)localObject3).lineTo(13.0F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(13.0F, 0.5F);
      ((Path)localObject3).lineTo(7.0F, 0.5F);
      ((Path)localObject3).cubicTo(3.410149F, 0.5F, 0.5F, 3.410149F, 0.5F, 7.0F);
      ((Path)localObject3).cubicTo(0.5F, 10.51181F, 3.284996F, 13.373151F, 6.766866F, 13.495897F);
      ((Path)localObject3).lineTo(7.0F, 13.5F);
      ((Path)localObject3).lineTo(13.0F, 13.5F);
      ((Path)localObject3).cubicTo(16.589851F, 13.5F, 19.5F, 10.58985F, 19.5F, 7.0F);
      ((Path)localObject3).cubicTo(19.5F, 3.48819F, 16.715004F, 0.6268495F, 13.233134F, 0.504103F);
      ((Path)localObject3).lineTo(13.0F, 0.5F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.353554F, 4.02022F);
      ((Path)localObject2).lineTo(13.02022F, 4.686887F);
      ((Path)localObject2).lineTo(10.686F, 7.02F);
      ((Path)localObject2).lineTo(13.02022F, 9.353554F);
      ((Path)localObject2).lineTo(12.353554F, 10.02022F);
      ((Path)localObject2).lineTo(10.02F, 7.686F);
      ((Path)localObject2).lineTo(7.686887F, 10.02022F);
      ((Path)localObject2).lineTo(7.02022F, 9.353554F);
      ((Path)localObject2).lineTo(9.353F, 7.02F);
      ((Path)localObject2).lineTo(7.02022F, 4.686887F);
      ((Path)localObject2).lineTo(7.686887F, 4.02022F);
      ((Path)localObject2).lineTo(10.02F, 6.353F);
      ((Path)localObject2).lineTo(12.353554F, 4.02022F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.biz_rec_card_close_icon
 * JD-Core Version:    0.7.0.1
 */