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

public class icons_filled_delete_on
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(7.5F, 15.0F);
      localPath.lineTo(46.5F, 15.0F);
      localPath.lineTo(7.5F, 15.0F);
      localPath.close();
      localPath.moveTo(46.235294F, 19.500006F);
      localPath.lineTo(43.832214F, 60.352333F);
      localPath.cubicTo(43.645664F, 63.523708F, 41.019428F, 66.0F, 37.842571F, 66.0F);
      localPath.lineTo(16.157431F, 66.0F);
      localPath.cubicTo(12.980573F, 66.0F, 10.354336F, 63.523708F, 10.167784F, 60.352333F);
      localPath.lineTo(7.764706F, 19.500006F);
      localPath.lineTo(46.235294F, 19.500006F);
      localPath.close();
      localPath.moveTo(18.0F, 26.999945F);
      localPath.lineTo(19.5F, 53.999981F);
      localPath.lineTo(24.0F, 53.999981F);
      localPath.lineTo(22.800001F, 26.999945F);
      localPath.lineTo(18.0F, 26.999945F);
      localPath.close();
      localPath.moveTo(31.5F, 26.999945F);
      localPath.lineTo(30.0F, 53.999981F);
      localPath.lineTo(34.5F, 53.999981F);
      localPath.lineTo(36.0F, 26.999945F);
      localPath.lineTo(31.5F, 26.999945F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9848077F, -0.1736482F, 2.226877F, 0.1736482F, 0.9848077F, -4.779654F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(4.429283F, 11.836774F);
      ((Path)localObject).lineTo(52.429283F, 11.836774F);
      ((Path)localObject).cubicTo(53.25771F, 11.836774F, 53.929283F, 12.508347F, 53.929283F, 13.336774F);
      ((Path)localObject).lineTo(53.929283F, 16.336781F);
      ((Path)localObject).lineTo(2.929283F, 16.336781F);
      ((Path)localObject).lineTo(2.929283F, 13.336774F);
      ((Path)localObject).cubicTo(2.929283F, 12.508347F, 3.600856F, 11.836774F, 4.429283F, 11.836774F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.429283F, 4.336876F);
      ((Path)localObject).lineTo(34.429283F, 4.336876F);
      ((Path)localObject).cubicTo(35.25771F, 4.336876F, 35.929283F, 5.008449F, 35.929283F, 5.836876F);
      ((Path)localObject).lineTo(35.929283F, 8.836774F);
      ((Path)localObject).lineTo(20.929283F, 8.836774F);
      ((Path)localObject).lineTo(20.929283F, 5.836876F);
      ((Path)localObject).cubicTo(20.929283F, 5.008449F, 21.600857F, 4.336876F, 22.429283F, 4.336876F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_delete_on
 * JD-Core Version:    0.7.0.1
 */