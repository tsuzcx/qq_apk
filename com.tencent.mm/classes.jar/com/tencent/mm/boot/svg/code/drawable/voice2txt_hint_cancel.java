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

public class voice2txt_hint_cancel
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
      localCanvas.saveLayerAlpha(null, 128, 31);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.585786F, 6.0F);
      ((Path)localObject2).lineTo(8.414213F, 7.828427F);
      ((Path)localObject2).lineTo(7.0F, 9.242641F);
      ((Path)localObject2).lineTo(3.464466F, 5.707107F);
      ((Path)localObject2).cubicTo(3.073942F, 5.316583F, 3.073942F, 4.683417F, 3.464466F, 4.292893F);
      ((Path)localObject2).lineTo(7.0F, 0.7573593F);
      ((Path)localObject2).lineTo(8.414213F, 2.171573F);
      ((Path)localObject2).lineTo(6.585786F, 4.0F);
      ((Path)localObject2).lineTo(11.0F, 4.0F);
      ((Path)localObject2).cubicTo(14.313708F, 4.0F, 17.0F, 6.686292F, 17.0F, 10.0F);
      ((Path)localObject2).cubicTo(17.0F, 13.313708F, 14.313708F, 16.0F, 11.0F, 16.0F);
      ((Path)localObject2).lineTo(0.0F, 16.0F);
      ((Path)localObject2).lineTo(0.0F, 14.0F);
      ((Path)localObject2).lineTo(11.0F, 14.0F);
      ((Path)localObject2).cubicTo(13.209139F, 14.0F, 15.0F, 12.209139F, 15.0F, 10.0F);
      ((Path)localObject2).cubicTo(15.0F, 7.790861F, 13.209139F, 6.0F, 11.0F, 6.0F);
      ((Path)localObject2).lineTo(6.585786F, 6.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voice2txt_hint_cancel
 * JD-Core Version:    0.7.0.1
 */