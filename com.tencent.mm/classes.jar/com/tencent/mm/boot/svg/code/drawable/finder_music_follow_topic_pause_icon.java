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

public class finder_music_follow_topic_pause_icon
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
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -580.0F, 0.0F, 1.0F, -160.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 70.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 514.0F, 0.0F, 1.0F, 90.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(0.8F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 0.3999996F);
      localPath.cubicTo(18.406504F, 0.3999996F, 23.6F, 5.593496F, 23.6F, 12.0F);
      localPath.cubicTo(23.6F, 18.406504F, 18.406504F, 23.6F, 12.0F, 23.6F);
      localPath.cubicTo(5.593496F, 23.6F, 0.3999996F, 18.406504F, 0.3999996F, 12.0F);
      localPath.cubicTo(0.3999996F, 5.593496F, 5.593496F, 0.3999996F, 12.0F, 0.3999996F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-436207616);
      localObject3 = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.5F, 0.0F, 1.0F, 5.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.520833F, 2.4375F);
      ((Path)localObject2).lineTo(4.604167F, 2.4375F);
      ((Path)localObject2).cubicTo(4.903321F, 2.4375F, 5.145834F, 2.680013F, 5.145834F, 2.979167F);
      ((Path)localObject2).lineTo(5.145834F, 10.020833F);
      ((Path)localObject2).cubicTo(5.145834F, 10.319987F, 4.903321F, 10.5625F, 4.604167F, 10.5625F);
      ((Path)localObject2).lineTo(3.520833F, 10.5625F);
      ((Path)localObject2).cubicTo(3.221679F, 10.5625F, 2.979167F, 10.319987F, 2.979167F, 10.020833F);
      ((Path)localObject2).lineTo(2.979167F, 2.979167F);
      ((Path)localObject2).cubicTo(2.979167F, 2.680013F, 3.221679F, 2.4375F, 3.520833F, 2.4375F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.395833F, 2.4375F);
      ((Path)localObject2).lineTo(9.479167F, 2.4375F);
      ((Path)localObject2).cubicTo(9.778321F, 2.4375F, 10.020833F, 2.680013F, 10.020833F, 2.979167F);
      ((Path)localObject2).lineTo(10.020833F, 10.020833F);
      ((Path)localObject2).cubicTo(10.020833F, 10.319987F, 9.778321F, 10.5625F, 9.479167F, 10.5625F);
      ((Path)localObject2).lineTo(8.395833F, 10.5625F);
      ((Path)localObject2).cubicTo(8.096679F, 10.5625F, 7.854167F, 10.319987F, 7.854167F, 10.020833F);
      ((Path)localObject2).lineTo(7.854167F, 2.979167F);
      ((Path)localObject2).cubicTo(7.854167F, 2.680013F, 8.096679F, 2.4375F, 8.395833F, 2.4375F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_music_follow_topic_pause_icon
 * JD-Core Version:    0.7.0.1
 */