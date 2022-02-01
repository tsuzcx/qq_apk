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

public class safe_keyboard
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(18.976F, 13.707F);
      localPath.lineTo(22.375999F, 15.107F);
      localPath.lineTo(22.37619F, 18.54903F);
      localPath.lineTo(22.370853F, 18.715483F);
      localPath.cubicTo(22.289001F, 19.985718F, 21.265184F, 21.120491F, 19.268848F, 22.134066F);
      localPath.lineTo(18.975F, 22.277F);
      localPath.lineTo(18.949036F, 22.265596F);
      localPath.cubicTo(16.687336F, 21.175404F, 15.576191F, 19.942669F, 15.576191F, 18.54903F);
      localPath.lineTo(15.576F, 15.107F);
      localPath.lineTo(18.976F, 13.707F);
      localPath.close();
      localPath.moveTo(20.590921F, 16.270679F);
      localPath.lineTo(19.007719F, 17.853748F);
      localPath.lineTo(18.237106F, 17.083136F);
      localPath.lineTo(17.530001F, 17.790243F);
      localPath.lineTo(19.007786F, 19.268028F);
      localPath.lineTo(21.298029F, 16.977785F);
      localPath.lineTo(20.590921F, 16.270679F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 2.0F);
      ((Path)localObject).cubicTo(17.522848F, 2.0F, 22.0F, 6.477152F, 22.0F, 12.0F);
      ((Path)localObject).cubicTo(22.0F, 12.545638F, 21.956299F, 13.08107F, 21.872208F, 13.602985F);
      ((Path)localObject).lineTo(20.728035F, 13.130697F);
      ((Path)localObject).cubicTo(20.775518F, 12.760503F, 20.799999F, 12.38311F, 20.799999F, 12.0F);
      ((Path)localObject).cubicTo(20.799999F, 7.139894F, 16.860106F, 3.2F, 12.0F, 3.2F);
      ((Path)localObject).cubicTo(7.139894F, 3.2F, 3.2F, 7.139894F, 3.2F, 12.0F);
      ((Path)localObject).cubicTo(3.2F, 16.860106F, 7.139894F, 20.799999F, 12.0F, 20.799999F);
      ((Path)localObject).cubicTo(12.986324F, 20.799999F, 13.934749F, 20.637732F, 14.820034F, 20.338436F);
      ((Path)localObject).cubicTo(15.004388F, 20.690775F, 15.247229F, 21.028742F, 15.545754F, 21.352346F);
      ((Path)localObject).cubicTo(14.443761F, 21.771164F, 13.248605F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject).cubicTo(6.477152F, 22.0F, 2.0F, 17.522848F, 2.0F, 12.0F);
      ((Path)localObject).cubicTo(2.0F, 6.477152F, 6.477152F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.376F, 15.0F);
      ((Path)localObject).lineTo(14.376F, 17.0F);
      ((Path)localObject).lineTo(9.0F, 17.0F);
      ((Path)localObject).lineTo(9.0F, 15.0F);
      ((Path)localObject).lineTo(14.376F, 15.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.5F, 11.0F);
      ((Path)localObject).lineTo(8.5F, 13.0F);
      ((Path)localObject).lineTo(6.5F, 13.0F);
      ((Path)localObject).lineTo(6.5F, 11.0F);
      ((Path)localObject).lineTo(8.5F, 11.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.5F, 11.0F);
      ((Path)localObject).lineTo(11.5F, 13.0F);
      ((Path)localObject).lineTo(9.5F, 13.0F);
      ((Path)localObject).lineTo(9.5F, 11.0F);
      ((Path)localObject).lineTo(11.5F, 11.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.5F, 11.0F);
      ((Path)localObject).lineTo(14.5F, 13.0F);
      ((Path)localObject).lineTo(12.5F, 13.0F);
      ((Path)localObject).lineTo(12.5F, 11.0F);
      ((Path)localObject).lineTo(14.5F, 11.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.5F, 11.0F);
      ((Path)localObject).lineTo(17.5F, 13.0F);
      ((Path)localObject).lineTo(15.5F, 13.0F);
      ((Path)localObject).lineTo(15.5F, 11.0F);
      ((Path)localObject).lineTo(17.5F, 11.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.5F, 8.0F);
      ((Path)localObject).lineTo(8.5F, 10.0F);
      ((Path)localObject).lineTo(6.5F, 10.0F);
      ((Path)localObject).lineTo(6.5F, 8.0F);
      ((Path)localObject).lineTo(8.5F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.5F, 8.0F);
      ((Path)localObject).lineTo(11.5F, 10.0F);
      ((Path)localObject).lineTo(9.5F, 10.0F);
      ((Path)localObject).lineTo(9.5F, 8.0F);
      ((Path)localObject).lineTo(11.5F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.5F, 8.0F);
      ((Path)localObject).lineTo(14.5F, 10.0F);
      ((Path)localObject).lineTo(12.5F, 10.0F);
      ((Path)localObject).lineTo(12.5F, 8.0F);
      ((Path)localObject).lineTo(14.5F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.5F, 8.0F);
      ((Path)localObject).lineTo(17.5F, 10.0F);
      ((Path)localObject).lineTo(15.5F, 10.0F);
      ((Path)localObject).lineTo(15.5F, 8.0F);
      ((Path)localObject).lineTo(17.5F, 8.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.safe_keyboard
 * JD-Core Version:    0.7.0.1
 */