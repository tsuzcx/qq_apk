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

public class flip_camera_icon_nor
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(1.2F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.6F, 5.1F);
      ((Path)localObject2).lineTo(0.6F, 18.9F);
      ((Path)localObject2).cubicTo(0.6F, 19.452284F, 1.047715F, 19.9F, 1.6F, 19.9F);
      ((Path)localObject2).lineTo(24.4F, 19.9F);
      ((Path)localObject2).cubicTo(24.952284F, 19.9F, 25.4F, 19.452284F, 25.4F, 18.9F);
      ((Path)localObject2).lineTo(25.4F, 5.1F);
      ((Path)localObject2).cubicTo(25.4F, 4.547715F, 24.952284F, 4.1F, 24.4F, 4.1F);
      ((Path)localObject2).lineTo(19.191229F, 4.1F);
      ((Path)localObject2).lineTo(16.751053F, 0.6837524F);
      ((Path)localObject2).cubicTo(16.713511F, 0.6311932F, 16.652895F, 0.6F, 16.588306F, 0.6F);
      ((Path)localObject2).lineTo(9.411695F, 0.6F);
      ((Path)localObject2).cubicTo(9.347104F, 0.6F, 9.28649F, 0.6311932F, 9.248947F, 0.6837524F);
      ((Path)localObject2).lineTo(6.808771F, 4.1F);
      ((Path)localObject2).lineTo(1.6F, 4.1F);
      ((Path)localObject2).cubicTo(1.047715F, 4.1F, 0.6F, 4.547715F, 0.6F, 5.1F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.0F, 0.5F);
      ((Path)localObject2).lineTo(5.5F, 0.5F);
      ((Path)localObject2).lineTo(5.5F, 2.0F);
      ((Path)localObject2).lineTo(2.0F, 2.0F);
      ((Path)localObject2).lineTo(2.0F, 0.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(7.0F, 11.0F);
      ((Path)localObject1).lineTo(5.0F, 11.0F);
      ((Path)localObject1).lineTo(7.75F, 8.25F);
      ((Path)localObject1).lineTo(10.5F, 11.0F);
      ((Path)localObject1).lineTo(8.5F, 11.0F);
      ((Path)localObject1).cubicTo(8.5F, 13.485281F, 10.514719F, 15.5F, 13.0F, 15.5F);
      ((Path)localObject1).cubicTo(14.264459F, 15.5F, 15.407109F, 14.978478F, 16.224586F, 14.1388F);
      ((Path)localObject1).lineTo(17.285318F, 15.199532F);
      ((Path)localObject1).cubicTo(16.196331F, 16.310623F, 14.678672F, 17.0F, 13.0F, 17.0F);
      ((Path)localObject1).cubicTo(9.686292F, 17.0F, 7.0F, 14.313708F, 7.0F, 11.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(19.0F, 11.0F);
      ((Path)localObject1).lineTo(21.0F, 11.0F);
      ((Path)localObject1).lineTo(18.25F, 13.75F);
      ((Path)localObject1).lineTo(15.5F, 11.0F);
      ((Path)localObject1).lineTo(17.5F, 11.0F);
      ((Path)localObject1).cubicTo(17.5F, 8.514719F, 15.485281F, 6.5F, 13.0F, 6.5F);
      ((Path)localObject1).cubicTo(11.735541F, 6.5F, 10.592891F, 7.021522F, 9.775414F, 7.8612F);
      ((Path)localObject1).lineTo(8.714682F, 6.800468F);
      ((Path)localObject1).cubicTo(9.803668F, 5.689376F, 11.321328F, 5.0F, 13.0F, 5.0F);
      ((Path)localObject1).cubicTo(16.313709F, 5.0F, 19.0F, 7.686292F, 19.0F, 11.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.flip_camera_icon_nor
 * JD-Core Version:    0.7.0.1
 */