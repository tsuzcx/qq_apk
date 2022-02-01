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

public class icons_half_screen_mode
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
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-436207616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.0F, 10.0F);
      localPath.lineTo(15.0F, 14.166667F);
      localPath.cubicTo(15.0F, 14.626904F, 14.626904F, 15.0F, 14.166667F, 15.0F);
      localPath.lineTo(10.0F, 15.0F);
      localPath.lineTo(10.0F, 13.333333F);
      localPath.lineTo(13.333333F, 13.333333F);
      localPath.lineTo(13.333333F, 10.0F);
      localPath.lineTo(15.0F, 10.0F);
      localPath.close();
      localPath.moveTo(1.666667F, 9.998479F);
      localPath.lineTo(1.666667F, 13.331813F);
      localPath.lineTo(5.0F, 13.331813F);
      localPath.lineTo(5.0F, 14.998479F);
      localPath.lineTo(0.8333333F, 14.998479F);
      localPath.cubicTo(0.3730961F, 14.998479F, 0.0F, 14.625383F, 0.0F, 14.165146F);
      localPath.lineTo(0.0F, 9.998479F);
      localPath.lineTo(1.666667F, 9.998479F);
      localPath.close();
      localPath.moveTo(5.0F, 0.0F);
      localPath.lineTo(5.0F, 1.666667F);
      localPath.lineTo(1.666667F, 1.666667F);
      localPath.lineTo(1.666667F, 5.0F);
      localPath.lineTo(0.0F, 5.0F);
      localPath.lineTo(0.0F, 0.8333333F);
      localPath.cubicTo(0.0F, 0.3730961F, 0.3730961F, 0.0F, 0.8333333F, 0.0F);
      localPath.lineTo(5.0F, 0.0F);
      localPath.close();
      localPath.moveTo(14.166667F, 0.0F);
      localPath.cubicTo(14.626904F, 0.0F, 15.0F, 0.3730961F, 15.0F, 0.8333333F);
      localPath.lineTo(15.0F, 5.0F);
      localPath.lineTo(13.333333F, 5.0F);
      localPath.lineTo(13.333333F, 1.666667F);
      localPath.lineTo(10.0F, 1.666667F);
      localPath.lineTo(10.0F, 0.0F);
      localPath.lineTo(14.166667F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.5F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.74807F, 2.427468F);
      ((Path)localObject2).lineTo(9.240287F, 5.565878F);
      ((Path)localObject2).cubicTo(9.480046F, 5.702883F, 9.563344F, 6.008311F, 9.426339F, 6.248069F);
      ((Path)localObject2).cubicTo(9.382045F, 6.325585F, 9.317802F, 6.389827F, 9.240287F, 6.434122F);
      ((Path)localObject2).lineTo(3.74807F, 9.572532F);
      ((Path)localObject2).cubicTo(3.508311F, 9.709537F, 3.202884F, 9.626239F, 3.065878F, 9.386479F);
      ((Path)localObject2).cubicTo(3.022708F, 9.310931F, 3.0F, 9.225424F, 3.0F, 9.138411F);
      ((Path)localObject2).lineTo(3.0F, 2.86159F);
      ((Path)localObject2).cubicTo(3.0F, 2.585448F, 3.223858F, 2.36159F, 3.5F, 2.36159F);
      ((Path)localObject2).cubicTo(3.587014F, 2.36159F, 3.672521F, 2.384298F, 3.74807F, 2.427468F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_half_screen_mode
 * JD-Core Version:    0.7.0.1
 */