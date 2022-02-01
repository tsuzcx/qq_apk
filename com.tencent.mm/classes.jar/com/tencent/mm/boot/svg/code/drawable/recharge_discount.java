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

public class recharge_discount
  extends c
{
  private final int height = 66;
  private final int width = 66;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 66;
      return 66;
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
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-743631);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(25.0F, 0.0F);
      localPath.lineTo(0.0F, 24.999001F);
      localPath.lineTo(0.0F, 66.0F);
      localPath.lineTo(65.999001F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, 0.7071068F, -10.128628F, -0.7071068F, 0.7071068F, 23.250589F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(16.081631F, 14.701631F);
      ((Path)localObject).lineTo(17.521631F, 14.701631F);
      ((Path)localObject).lineTo(17.521631F, 16.841631F);
      ((Path)localObject).lineTo(21.22163F, 16.841631F);
      ((Path)localObject).lineTo(21.22163F, 18.14163F);
      ((Path)localObject).lineTo(17.521631F, 18.14163F);
      ((Path)localObject).lineTo(17.521631F, 20.48163F);
      ((Path)localObject).lineTo(22.101631F, 20.48163F);
      ((Path)localObject).lineTo(22.101631F, 21.841631F);
      ((Path)localObject).lineTo(11.461631F, 21.841631F);
      ((Path)localObject).lineTo(11.461631F, 20.48163F);
      ((Path)localObject).lineTo(16.081631F, 20.48163F);
      ((Path)localObject).lineTo(16.081631F, 18.14163F);
      ((Path)localObject).lineTo(12.56163F, 18.14163F);
      ((Path)localObject).lineTo(12.56163F, 16.841631F);
      ((Path)localObject).lineTo(16.081631F, 16.841631F);
      ((Path)localObject).lineTo(16.081631F, 14.701631F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.94163F, 24.201632F);
      ((Path)localObject).lineTo(18.341631F, 24.201632F);
      ((Path)localObject).lineTo(18.341631F, 22.90163F);
      ((Path)localObject).lineTo(19.741631F, 22.90163F);
      ((Path)localObject).lineTo(19.741631F, 24.201632F);
      ((Path)localObject).lineTo(21.941631F, 24.201632F);
      ((Path)localObject).lineTo(21.941631F, 25.56163F);
      ((Path)localObject).lineTo(19.741631F, 25.56163F);
      ((Path)localObject).lineTo(19.741631F, 31.201632F);
      ((Path)localObject).cubicTo(19.741631F, 32.321632F, 19.201632F, 32.90163F, 18.161631F, 32.90163F);
      ((Path)localObject).lineTo(15.621631F, 32.90163F);
      ((Path)localObject).lineTo(15.32163F, 31.54163F);
      ((Path)localObject).cubicTo(16.12163F, 31.601631F, 16.90163F, 31.64163F, 17.661631F, 31.64163F);
      ((Path)localObject).cubicTo(18.101631F, 31.64163F, 18.341631F, 31.361631F, 18.341631F, 30.841631F);
      ((Path)localObject).lineTo(18.341631F, 25.56163F);
      ((Path)localObject).lineTo(11.94163F, 25.56163F);
      ((Path)localObject).lineTo(11.94163F, 24.201632F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.421631F, 26.48163F);
      ((Path)localObject).cubicTo(14.461631F, 27.64163F, 15.261631F, 28.64163F, 15.82163F, 29.521631F);
      ((Path)localObject).lineTo(14.68163F, 30.32163F);
      ((Path)localObject).cubicTo(14.10163F, 29.361631F, 13.301631F, 28.32163F, 12.301631F, 27.181631F);
      ((Path)localObject).lineTo(13.421631F, 26.48163F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.86163F, 20.281631F);
      ((Path)localObject).cubicTo(5.661631F, 21.30163F, 5.42163F, 22.281631F, 5.141631F, 23.22163F);
      ((Path)localObject).lineTo(3.881631F, 22.861631F);
      ((Path)localObject).cubicTo(4.501631F, 20.781631F, 4.86163F, 18.601631F, 4.94163F, 16.30163F);
      ((Path)localObject).lineTo(6.261631F, 16.40163F);
      ((Path)localObject).cubicTo(6.221631F, 17.261631F, 6.161631F, 18.081631F, 6.061631F, 18.88163F);
      ((Path)localObject).lineTo(7.741631F, 18.88163F);
      ((Path)localObject).lineTo(7.741631F, 14.721631F);
      ((Path)localObject).lineTo(9.121631F, 14.721631F);
      ((Path)localObject).lineTo(9.121631F, 18.88163F);
      ((Path)localObject).lineTo(10.94163F, 18.88163F);
      ((Path)localObject).lineTo(10.94163F, 20.281631F);
      ((Path)localObject).lineTo(9.121631F, 20.281631F);
      ((Path)localObject).lineTo(9.121631F, 25.081631F);
      ((Path)localObject).cubicTo(9.761631F, 24.82163F, 10.381631F, 24.56163F, 11.001631F, 24.281631F);
      ((Path)localObject).lineTo(11.001631F, 25.64163F);
      ((Path)localObject).cubicTo(10.36163F, 25.921631F, 9.741631F, 26.181631F, 9.121631F, 26.421631F);
      ((Path)localObject).lineTo(9.121631F, 33.04163F);
      ((Path)localObject).lineTo(7.741631F, 33.04163F);
      ((Path)localObject).lineTo(7.741631F, 26.941631F);
      ((Path)localObject).cubicTo(6.621631F, 27.32163F, 5.46163F, 27.661631F, 4.301631F, 27.98163F);
      ((Path)localObject).lineTo(3.961631F, 26.581631F);
      ((Path)localObject).cubicTo(5.241631F, 26.32163F, 6.501631F, 25.98163F, 7.741631F, 25.581631F);
      ((Path)localObject).lineTo(7.741631F, 20.281631F);
      ((Path)localObject).lineTo(5.86163F, 20.281631F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.181631F, 16.001631F);
      ((Path)localObject).lineTo(32.321632F, 16.001631F);
      ((Path)localObject).lineTo(32.321632F, 14.661631F);
      ((Path)localObject).lineTo(33.761631F, 14.661631F);
      ((Path)localObject).lineTo(33.761631F, 16.001631F);
      ((Path)localObject).lineTo(41.90163F, 16.001631F);
      ((Path)localObject).lineTo(41.90163F, 17.241631F);
      ((Path)localObject).lineTo(33.761631F, 17.241631F);
      ((Path)localObject).lineTo(33.761631F, 18.38163F);
      ((Path)localObject).lineTo(40.101631F, 18.38163F);
      ((Path)localObject).lineTo(40.101631F, 24.181631F);
      ((Path)localObject).lineTo(39.161629F, 24.181631F);
      ((Path)localObject).cubicTo(40.321632F, 25.181631F, 41.22163F, 26.04163F, 41.861629F, 26.80163F);
      ((Path)localObject).lineTo(40.801632F, 27.54163F);
      ((Path)localObject).cubicTo(40.481632F, 27.12163F, 40.101631F, 26.701632F, 39.681629F, 26.261631F);
      ((Path)localObject).cubicTo(36.281631F, 26.501631F, 31.32163F, 26.72163F, 24.841631F, 26.88163F);
      ((Path)localObject).lineTo(24.661631F, 25.601631F);
      ((Path)localObject).cubicTo(27.46163F, 25.56163F, 30.001631F, 25.521631F, 32.321632F, 25.46163F);
      ((Path)localObject).lineTo(32.321632F, 24.181631F);
      ((Path)localObject).lineTo(25.98163F, 24.181631F);
      ((Path)localObject).lineTo(25.98163F, 18.38163F);
      ((Path)localObject).lineTo(32.321632F, 18.38163F);
      ((Path)localObject).lineTo(32.321632F, 17.241631F);
      ((Path)localObject).lineTo(24.181631F, 17.241631F);
      ((Path)localObject).lineTo(24.181631F, 16.001631F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.661629F, 25.241631F);
      ((Path)localObject).cubicTo(38.38163F, 24.98163F, 38.121632F, 24.72163F, 37.841629F, 24.48163F);
      ((Path)localObject).lineTo(38.341629F, 24.181631F);
      ((Path)localObject).lineTo(33.761631F, 24.181631F);
      ((Path)localObject).lineTo(33.761631F, 25.421631F);
      ((Path)localObject).cubicTo(35.56163F, 25.361631F, 37.181629F, 25.30163F, 38.661629F, 25.241631F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.72163F, 23.101631F);
      ((Path)localObject).lineTo(38.72163F, 21.761631F);
      ((Path)localObject).lineTo(33.761631F, 21.761631F);
      ((Path)localObject).lineTo(33.761631F, 23.101631F);
      ((Path)localObject).lineTo(38.72163F, 23.101631F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.321632F, 23.101631F);
      ((Path)localObject).lineTo(32.321632F, 21.761631F);
      ((Path)localObject).lineTo(27.361631F, 21.761631F);
      ((Path)localObject).lineTo(27.361631F, 23.101631F);
      ((Path)localObject).lineTo(32.321632F, 23.101631F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.361631F, 20.781631F);
      ((Path)localObject).lineTo(32.321632F, 20.781631F);
      ((Path)localObject).lineTo(32.321632F, 19.48163F);
      ((Path)localObject).lineTo(27.361631F, 19.48163F);
      ((Path)localObject).lineTo(27.361631F, 20.781631F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.761631F, 19.48163F);
      ((Path)localObject).lineTo(33.761631F, 20.781631F);
      ((Path)localObject).lineTo(38.72163F, 20.781631F);
      ((Path)localObject).lineTo(38.72163F, 19.48163F);
      ((Path)localObject).lineTo(33.761631F, 19.48163F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.98163F, 27.701632F);
      ((Path)localObject).lineTo(27.281631F, 27.96163F);
      ((Path)localObject).cubicTo(26.80163F, 29.64163F, 26.12163F, 31.101631F, 25.241631F, 32.341629F);
      ((Path)localObject).lineTo(24.04163F, 31.581631F);
      ((Path)localObject).cubicTo(24.921631F, 30.40163F, 25.581631F, 29.101631F, 25.98163F, 27.701632F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.781631F, 32.72163F);
      ((Path)localObject).lineTo(30.501631F, 32.72163F);
      ((Path)localObject).cubicTo(29.32163F, 32.72163F, 28.741631F, 32.161629F, 28.741631F, 31.04163F);
      ((Path)localObject).lineTo(28.741631F, 27.54163F);
      ((Path)localObject).lineTo(30.14163F, 27.54163F);
      ((Path)localObject).lineTo(30.14163F, 30.741631F);
      ((Path)localObject).cubicTo(30.14163F, 31.181631F, 30.40163F, 31.40163F, 30.921631F, 31.40163F);
      ((Path)localObject).lineTo(35.521629F, 31.40163F);
      ((Path)localObject).cubicTo(35.90163F, 31.40163F, 36.161629F, 31.30163F, 36.321632F, 31.12163F);
      ((Path)localObject).cubicTo(36.521629F, 30.90163F, 36.661629F, 30.261631F, 36.741631F, 29.201632F);
      ((Path)localObject).lineTo(38.06163F, 29.62163F);
      ((Path)localObject).cubicTo(37.921631F, 31.101631F, 37.661629F, 31.98163F, 37.301632F, 32.301632F);
      ((Path)localObject).cubicTo(36.981632F, 32.581631F, 36.481632F, 32.72163F, 35.781631F, 32.72163F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.021629F, 27.14163F);
      ((Path)localObject).cubicTo(34.04163F, 28.06163F, 34.821632F, 28.88163F, 35.38163F, 29.581631F);
      ((Path)localObject).lineTo(34.301632F, 30.341631F);
      ((Path)localObject).cubicTo(33.72163F, 29.581631F, 32.941631F, 28.72163F, 31.941631F, 27.80163F);
      ((Path)localObject).lineTo(33.021629F, 27.14163F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.06163F, 27.281631F);
      ((Path)localObject).cubicTo(40.38163F, 28.761631F, 41.40163F, 30.081631F, 42.121632F, 31.201632F);
      ((Path)localObject).lineTo(40.981632F, 31.96163F);
      ((Path)localObject).cubicTo(40.241631F, 30.761631F, 39.241631F, 29.441631F, 37.981632F, 27.98163F);
      ((Path)localObject).lineTo(39.06163F, 27.281631F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.recharge_discount
 * JD-Core Version:    0.7.0.1
 */