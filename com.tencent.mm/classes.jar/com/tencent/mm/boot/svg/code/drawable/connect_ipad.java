package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class connect_ipad
  extends c
{
  private final int height = 104;
  private final int width = 104;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 104;
      return 104;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(0.8F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(19.409714F, 0.4F);
      localPath.lineTo(84.590286F, 0.4F);
      localPath.cubicTo(86.705803F, 0.4F, 87.478561F, 0.606131F, 88.253471F, 1.020557F);
      localPath.cubicTo(88.997551F, 1.418493F, 89.581505F, 2.002449F, 89.979446F, 2.746525F);
      localPath.cubicTo(90.393867F, 3.521435F, 90.599998F, 4.294195F, 90.599998F, 6.409713F);
      localPath.lineTo(90.599998F, 6.409713F);
      localPath.lineTo(90.599998F, 97.590286F);
      localPath.cubicTo(90.599998F, 99.705803F, 90.393867F, 100.47856F, 89.979446F, 101.25347F);
      localPath.cubicTo(89.581505F, 101.99755F, 88.997551F, 102.5815F, 88.253471F, 102.97945F);
      localPath.cubicTo(87.478561F, 103.39387F, 86.705803F, 103.6F, 84.590286F, 103.6F);
      localPath.lineTo(84.590286F, 103.6F);
      localPath.lineTo(19.409714F, 103.6F);
      localPath.cubicTo(17.294195F, 103.6F, 16.521435F, 103.39387F, 15.746526F, 102.97945F);
      localPath.cubicTo(15.002449F, 102.5815F, 14.418493F, 101.99755F, 14.020557F, 101.25347F);
      localPath.cubicTo(13.606131F, 100.47856F, 13.4F, 99.705803F, 13.4F, 97.590286F);
      localPath.lineTo(13.4F, 97.590286F);
      localPath.lineTo(13.4F, 6.409713F);
      localPath.cubicTo(13.4F, 4.294195F, 13.606131F, 3.521435F, 14.020557F, 2.746525F);
      localPath.cubicTo(14.418493F, 2.002449F, 15.002449F, 1.418493F, 15.746526F, 1.020557F);
      localPath.cubicTo(16.521435F, 0.606131F, 17.294195F, 0.4F, 19.409714F, 0.4F);
      localPath.lineTo(19.409714F, 0.4F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(0.8F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(18.4F, 10.4F);
      localPath.lineTo(85.599998F, 10.4F);
      localPath.lineTo(85.599998F, 91.599998F);
      localPath.lineTo(18.4F, 91.599998F);
      localPath.lineTo(18.4F, 10.4F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(52.0F, 4.25F);
      ((Path)localObject2).cubicTo(52.552284F, 4.25F, 53.0F, 4.697715F, 53.0F, 5.25F);
      ((Path)localObject2).cubicTo(53.0F, 5.802285F, 52.552284F, 6.25F, 52.0F, 6.25F);
      ((Path)localObject2).cubicTo(51.447716F, 6.25F, 51.0F, 5.802285F, 51.0F, 5.25F);
      ((Path)localObject2).cubicTo(51.0F, 4.697715F, 51.447716F, 4.25F, 52.0F, 4.25F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(0.8F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(52.0F, 95.0F);
      ((Path)localObject1).cubicTo(53.380711F, 95.0F, 54.5F, 96.119286F, 54.5F, 97.5F);
      ((Path)localObject1).cubicTo(54.5F, 98.880714F, 53.380711F, 100.0F, 52.0F, 100.0F);
      ((Path)localObject1).cubicTo(50.619289F, 100.0F, 49.5F, 98.880714F, 49.5F, 97.5F);
      ((Path)localObject1).cubicTo(49.5F, 96.119286F, 50.619289F, 95.0F, 52.0F, 95.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_ipad
 * JD-Core Version:    0.7.0.1
 */