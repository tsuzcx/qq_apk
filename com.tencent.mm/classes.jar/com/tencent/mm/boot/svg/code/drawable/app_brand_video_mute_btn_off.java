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

public class app_brand_video_mute_btn_off
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -168.0F, 0.0F, 1.0F, -60.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 168.0F, 0.0F, 1.0F, 60.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStrokeWidth(1.5F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.75F, 5.266332F);
      ((Path)localObject2).lineTo(0.75F, 12.733709F);
      ((Path)localObject2).lineTo(5.192494F, 12.733709F);
      ((Path)localObject2).lineTo(11.25F, 17.016748F);
      ((Path)localObject2).lineTo(11.25F, 0.983293F);
      ((Path)localObject2).lineTo(5.192494F, 5.266332F);
      ((Path)localObject2).lineTo(0.75F, 5.266332F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(21.336575F, 12.275914F);
      ((Path)localObject1).lineTo(23.49325F, 14.43259F);
      ((Path)localObject1).cubicTo(23.571356F, 14.510695F, 23.571356F, 14.637328F, 23.49325F, 14.715433F);
      ((Path)localObject1).lineTo(22.715433F, 15.49325F);
      ((Path)localObject1).cubicTo(22.637327F, 15.571355F, 22.510695F, 15.571355F, 22.43259F, 15.49325F);
      ((Path)localObject1).lineTo(20.275915F, 13.336575F);
      ((Path)localObject1).lineTo(18.119238F, 15.49325F);
      ((Path)localObject1).cubicTo(18.041134F, 15.571355F, 17.914501F, 15.571355F, 17.836395F, 15.49325F);
      ((Path)localObject1).lineTo(17.058578F, 14.715433F);
      ((Path)localObject1).cubicTo(16.980474F, 14.637328F, 16.980474F, 14.510695F, 17.058578F, 14.43259F);
      ((Path)localObject1).lineTo(19.215254F, 12.275914F);
      ((Path)localObject1).lineTo(17.058578F, 10.119239F);
      ((Path)localObject1).cubicTo(16.980474F, 10.041134F, 16.980474F, 9.914501F, 17.058578F, 9.836396F);
      ((Path)localObject1).lineTo(17.836395F, 9.058579F);
      ((Path)localObject1).cubicTo(17.914501F, 8.980474F, 18.041134F, 8.980474F, 18.119238F, 9.058579F);
      ((Path)localObject1).lineTo(20.275915F, 11.215254F);
      ((Path)localObject1).lineTo(22.43259F, 9.058579F);
      ((Path)localObject1).cubicTo(22.510695F, 8.980474F, 22.637327F, 8.980474F, 22.715433F, 9.058579F);
      ((Path)localObject1).lineTo(23.49325F, 9.836396F);
      ((Path)localObject1).cubicTo(23.571356F, 9.914501F, 23.571356F, 10.041134F, 23.49325F, 10.119239F);
      ((Path)localObject1).lineTo(21.336575F, 12.275914F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_video_mute_btn_off
 * JD-Core Version:    0.7.0.1
 */