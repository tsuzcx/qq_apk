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

public class download_pause_dark
  extends c
{
  private final int height = 24;
  private final int width = 25;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 25;
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
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -264.0F, 0.0F, 1.0F, -296.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 256.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 264.0F, 0.0F, 1.0F, 36.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2130706433);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.0F, 0.0F);
      localPath.cubicTo(15.522847F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      localPath.cubicTo(20.0F, 15.522847F, 15.522847F, 20.0F, 10.0F, 20.0F);
      localPath.cubicTo(4.477152F, 20.0F, 0.0F, 15.522847F, 0.0F, 10.0F);
      localPath.cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      localPath.close();
      localPath.moveTo(10.0F, 1.666667F);
      localPath.cubicTo(5.397627F, 1.666667F, 1.666667F, 5.397627F, 1.666667F, 10.0F);
      localPath.cubicTo(1.666667F, 14.602373F, 5.397627F, 18.333334F, 10.0F, 18.333334F);
      localPath.cubicTo(14.602373F, 18.333334F, 18.333334F, 14.602373F, 18.333334F, 10.0F);
      localPath.cubicTo(18.333334F, 5.397627F, 14.602373F, 1.666667F, 10.0F, 1.666667F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-855638017);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.000875F, 0.0F);
      localPath.cubicTo(15.522847F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      localPath.cubicTo(20.0F, 15.522847F, 15.522847F, 20.0F, 10.0F, 20.0F);
      localPath.cubicTo(4.528486F, 20.0F, 0.08331788F, 15.605688F, 0.001157607F, 10.153726F);
      localPath.lineTo(0.000875017F, 10.133333F);
      localPath.cubicTo(0.000875017F, 9.673096F, 0.3739711F, 9.3F, 0.8342084F, 9.3F);
      localPath.cubicTo(1.294446F, 9.3F, 1.667542F, 9.673096F, 1.667542F, 10.133333F);
      localPath.lineTo(1.665875F, 10.111F);
      localPath.lineTo(1.667875F, 10.111F);
      localPath.lineTo(1.670487F, 10.254773F);
      localPath.cubicTo(1.805149F, 14.739277F, 5.482856F, 18.333334F, 10.0F, 18.333334F);
      localPath.cubicTo(14.602373F, 18.333334F, 18.333334F, 14.602373F, 18.333334F, 10.0F);
      localPath.cubicTo(18.333334F, 5.397963F, 14.602917F, 1.667211F, 10.001006F, 1.666667F);
      localPath.cubicTo(9.539763F, 1.666667F, 9.166667F, 1.293571F, 9.166667F, 0.8333333F);
      localPath.cubicTo(9.166667F, 0.3730961F, 9.539763F, 0.0F, 10.0F, 0.0F);
      localPath.lineTo(10.0F, 0.0F);
      localPath.lineTo(10.000875F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-855638017);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.451329F, 0.0F, 1.0F, 6.496923F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.400186F, -4.547474E-013F);
      ((Path)localObject2).lineTo(6.400015F, 8.271F);
      ((Path)localObject2).lineTo(8.856973F, 5.815717F);
      ((Path)localObject2).lineTo(10.104809F, 7.063553F);
      ((Path)localObject2).lineTo(6.153329F, 11.015032F);
      ((Path)localObject2).cubicTo(5.835256F, 11.333106F, 5.334757F, 11.357574F, 4.988618F, 11.088433F);
      ((Path)localObject2).lineTo(4.905494F, 11.015032F);
      ((Path)localObject2).lineTo(0.954015F, 7.063553F);
      ((Path)localObject2).lineTo(2.20185F, 5.815717F);
      ((Path)localObject2).lineTo(4.635015F, 8.25F);
      ((Path)localObject2).lineTo(4.63548F, -4.547474E-013F);
      ((Path)localObject2).lineTo(6.400186F, -4.547474E-013F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.download_pause_dark
 * JD-Core Version:    0.7.0.1
 */