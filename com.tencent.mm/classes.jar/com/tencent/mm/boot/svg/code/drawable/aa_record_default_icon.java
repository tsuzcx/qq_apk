package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class aa_record_default_icon
  extends c
{
  private final int height = 100;
  private final int width = 100;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 100;
      return 100;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-2236702);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 10.0F);
      localPath.cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      localPath.lineTo(90.0F, 0.0F);
      localPath.cubicTo(95.52285F, 0.0F, 100.0F, 4.477152F, 100.0F, 10.0F);
      localPath.lineTo(100.0F, 90.0F);
      localPath.cubicTo(100.0F, 95.52285F, 95.52285F, 100.0F, 90.0F, 100.0F);
      localPath.lineTo(10.0F, 100.0F);
      localPath.cubicTo(4.477152F, 100.0F, 0.0F, 95.52285F, 0.0F, 90.0F);
      localPath.lineTo(0.0F, 10.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(74.0F, 52.036991F);
      ((Path)localObject).lineTo(74.0F, 22.99649F);
      ((Path)localObject).cubicTo(74.0F, 21.887833F, 73.103951F, 21.0F, 71.998611F, 21.0F);
      ((Path)localObject).lineTo(28.001389F, 21.0F);
      ((Path)localObject).cubicTo(26.894938F, 21.0F, 26.0F, 21.89386F, 26.0F, 22.99649F);
      ((Path)localObject).lineTo(26.0F, 77.00351F);
      ((Path)localObject).cubicTo(26.0F, 78.112167F, 26.896053F, 79.0F, 28.001389F, 79.0F);
      ((Path)localObject).lineTo(71.998611F, 79.0F);
      ((Path)localObject).cubicTo(73.105064F, 79.0F, 74.0F, 78.10614F, 74.0F, 77.00351F);
      ((Path)localObject).lineTo(74.0F, 55.482319F);
      ((Path)localObject).lineTo(50.747208F, 68.733765F);
      ((Path)localObject).lineTo(50.574451F, 68.832016F);
      ((Path)localObject).cubicTo(50.360592F, 68.938515F, 50.119755F, 69.0F, 49.864151F, 69.0F);
      ((Path)localObject).cubicTo(49.272663F, 69.0F, 48.75824F, 68.677986F, 48.487865F, 68.203201F);
      ((Path)localObject).lineTo(48.384464F, 67.979431F);
      ((Path)localObject).lineTo(44.075783F, 58.647274F);
      ((Path)localObject).cubicTo(44.0289F, 58.545219F, 44.0F, 58.430485F, 44.0F, 58.318916F);
      ((Path)localObject).cubicTo(44.0F, 57.889141F, 44.353222F, 57.539864F, 44.789295F, 57.539864F);
      ((Path)localObject).cubicTo(44.966549F, 57.539864F, 45.129673F, 57.597549F, 45.26133F, 57.694534F);
      ((Path)localObject).lineTo(50.345818F, 61.267784F);
      ((Path)localObject).cubicTo(50.717667F, 61.50803F, 51.161446F, 61.648754F, 51.638618F, 61.648754F);
      ((Path)localObject).cubicTo(51.923122F, 61.648754F, 52.194782F, 61.596142F, 52.447819F, 61.505493F);
      ((Path)localObject).lineTo(74.0F, 52.036991F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.0F, 38.0F);
      ((Path)localObject).lineTo(52.0F, 38.0F);
      ((Path)localObject).lineTo(52.0F, 41.0F);
      ((Path)localObject).lineTo(34.0F, 41.0F);
      ((Path)localObject).lineTo(34.0F, 38.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.0F, 29.0F);
      ((Path)localObject).lineTo(52.0F, 29.0F);
      ((Path)localObject).lineTo(52.0F, 32.0F);
      ((Path)localObject).lineTo(34.0F, 32.0F);
      ((Path)localObject).lineTo(34.0F, 29.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.aa_record_default_icon
 * JD-Core Version:    0.7.0.1
 */