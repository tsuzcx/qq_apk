package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class connect_kidwatch
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.2F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(14.040588F, 1.6F);
      localPath.cubicTo(14.612605F, 1.6F, 15.144863F, 1.801876F, 15.562161F, 2.143979F);
      localPath.cubicTo(15.979461F, 2.486082F, 16.281799F, 2.968412F, 16.393978F, 3.529301F);
      localPath.lineTo(16.393978F, 3.529301F);
      localPath.lineTo(16.61931F, 4.656161F);
      localPath.cubicTo(17.477869F, 4.813973F, 18.223148F, 5.294681F, 18.725643F, 5.96714F);
      localPath.cubicTo(19.149321F, 6.534123F, 19.4F, 7.237807F, 19.4F, 8.0F);
      localPath.lineTo(19.4F, 8.0F);
      localPath.lineTo(19.4F, 16.0F);
      localPath.cubicTo(19.4F, 16.762192F, 19.149321F, 17.465878F, 18.725643F, 18.03286F);
      localPath.cubicTo(18.223148F, 18.70532F, 17.477869F, 19.186028F, 16.61931F, 19.343838F);
      localPath.lineTo(16.61931F, 19.343838F);
      localPath.lineTo(16.393982F, 20.470678F);
      localPath.cubicTo(16.286753F, 21.006828F, 16.005791F, 21.471195F, 15.61674F, 21.809908F);
      localPath.cubicTo(15.229675F, 22.146891F, 14.735665F, 22.359625F, 14.199301F, 22.39481F);
      localPath.lineTo(14.199301F, 22.39481F);
      localPath.lineTo(9.959412F, 22.4F);
      localPath.cubicTo(9.412643F, 22.4F, 8.902194F, 22.215565F, 8.493759F, 21.900496F);
      localPath.cubicTo(8.087106F, 21.586802F, 7.781466F, 21.143675F, 7.641919F, 20.624121F);
      localPath.lineTo(7.641919F, 20.624121F);
      localPath.lineTo(7.378449F, 19.343426F);
      localPath.cubicTo(6.520835F, 19.18519F, 5.776415F, 18.704735F, 5.274358F, 18.03286F);
      localPath.cubicTo(4.85068F, 17.465878F, 4.6F, 16.762192F, 4.6F, 16.0F);
      localPath.lineTo(4.6F, 16.0F);
      localPath.lineTo(4.6F, 8.0F);
      localPath.cubicTo(4.6F, 7.237807F, 4.85068F, 6.534123F, 5.274358F, 5.96714F);
      localPath.cubicTo(5.776852F, 5.294681F, 6.522131F, 4.813973F, 7.38069F, 4.656161F);
      localPath.lineTo(7.38069F, 4.656161F);
      localPath.lineTo(7.606018F, 3.529321F);
      localPath.cubicTo(7.7182F, 2.968412F, 8.020539F, 2.486082F, 8.437839F, 2.143979F);
      localPath.cubicTo(8.855137F, 1.801876F, 9.387395F, 1.6F, 9.959412F, 1.6F);
      localPath.lineTo(9.959412F, 1.6F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.2F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.6F, 8.6F);
      ((Path)localObject2).cubicTo(6.6F, 7.495431F, 7.495431F, 6.6F, 8.6F, 6.6F);
      ((Path)localObject2).lineTo(15.4F, 6.6F);
      ((Path)localObject2).cubicTo(16.50457F, 6.6F, 17.4F, 7.495431F, 17.4F, 8.6F);
      ((Path)localObject2).lineTo(17.4F, 15.4F);
      ((Path)localObject2).cubicTo(17.4F, 16.50457F, 16.50457F, 17.4F, 15.4F, 17.4F);
      ((Path)localObject2).lineTo(8.6F, 17.4F);
      ((Path)localObject2).cubicTo(7.495431F, 17.4F, 6.6F, 16.50457F, 6.6F, 15.4F);
      ((Path)localObject2).lineTo(6.6F, 8.6F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(11.0F, 4.0F);
      ((Path)localObject1).cubicTo(11.0F, 3.447715F, 11.447715F, 3.0F, 12.0F, 3.0F);
      ((Path)localObject1).lineTo(12.0F, 3.0F);
      ((Path)localObject1).cubicTo(12.552285F, 3.0F, 13.0F, 3.447715F, 13.0F, 4.0F);
      ((Path)localObject1).lineTo(13.0F, 4.0F);
      ((Path)localObject1).cubicTo(13.0F, 4.552285F, 12.552285F, 5.0F, 12.0F, 5.0F);
      ((Path)localObject1).lineTo(12.0F, 5.0F);
      ((Path)localObject1).cubicTo(11.447715F, 5.0F, 11.0F, 4.552285F, 11.0F, 4.0F);
      ((Path)localObject1).lineTo(11.0F, 4.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_kidwatch
 * JD-Core Version:    0.7.0.1
 */