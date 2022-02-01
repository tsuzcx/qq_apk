package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class wecoin_tutorial_dialog_icon
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -195.0F, 0.0F, 1.0F, -606.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 558.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 195.0F, 0.0F, 1.0F, 48.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 24.0F);
      ((Path)localObject2).lineTo(0.0F, 24.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject2, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(1275068416);
      localPaint.setStrokeWidth(1.2F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(10.130432F, 10.20787F);
      ((Path)localObject1).cubicTo(10.130432F, 10.20787F, 13.099432F, 8.420871F, 13.363432F, 4.915871F);
      ((Path)localObject1).cubicTo(13.434432F, 3.987871F, 13.132432F, 2.540871F, 12.721432F, 2.124871F);
      ((Path)localObject1).cubicTo(12.476432F, 1.875871F, 12.055431F, 2.020871F, 12.022431F, 2.368871F);
      ((Path)localObject1).cubicTo(11.966432F, 2.938871F, 11.754432F, 4.018871F, 11.199431F, 4.758871F);
      ((Path)localObject1).cubicTo(10.753432F, 5.352871F, 9.809432F, 6.03787F, 9.471432F, 6.271871F);
      ((Path)localObject1).cubicTo(8.657432F, 6.749871F, 7.872432F, 7.348871F, 7.152432F, 8.068871F);
      ((Path)localObject1).cubicTo(3.626432F, 11.594871F, 2.957432F, 16.64187F, 5.657432F, 19.342871F);
      ((Path)localObject1).cubicTo(8.358432F, 22.042871F, 13.405432F, 21.373871F, 16.931433F, 17.84787F);
      ((Path)localObject1).cubicTo(20.457432F, 14.321871F, 21.126432F, 9.273871F, 18.426432F, 6.573871F);
      ((Path)localObject1).cubicTo(17.480433F, 5.627871F, 16.081432F, 5.062871F, 15.037432F, 4.945871F);
      ((Path)localObject1).cubicTo(13.993432F, 4.829871F, 13.397431F, 4.915871F, 13.397431F, 4.915871F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wecoin_tutorial_dialog_icon
 * JD-Core Version:    0.7.0.1
 */