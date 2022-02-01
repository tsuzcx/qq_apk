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

public class connectkeyboad_banner_icon_pclock
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-9473160);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 17.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(45.0513F, 58.846001F);
      localPath.lineTo(48.513302F, 60.0F);
      localPath.lineTo(32.486301F, 60.0F);
      localPath.lineTo(35.948299F, 58.846001F);
      localPath.lineTo(38.000301F, 58.161999F);
      localPath.lineTo(38.000301F, 56.0F);
      localPath.lineTo(38.000301F, 52.0F);
      localPath.lineTo(43.000301F, 52.0F);
      localPath.lineTo(43.000301F, 56.0F);
      localPath.lineTo(43.000301F, 58.161999F);
      localPath.lineTo(45.0513F, 58.846001F);
      localPath.close();
      localPath.moveTo(35.000301F, 49.0F);
      localPath.lineTo(3.0003F, 49.0F);
      localPath.lineTo(3.0003F, 3.0F);
      localPath.lineTo(77.000298F, 3.0F);
      localPath.lineTo(77.000298F, 29.0F);
      localPath.lineTo(80.000298F, 29.0F);
      localPath.lineTo(80.000298F, 2.87F);
      localPath.cubicTo(80.000298F, 1.285F, 78.714302F, 0.0F, 77.129303F, 0.0F);
      localPath.lineTo(2.8713F, 0.0F);
      localPath.cubicTo(1.2893F, 0.0F, 0.0003F, 1.285F, 0.0003F, 2.87F);
      localPath.lineTo(0.0003F, 49.130001F);
      localPath.cubicTo(0.0003F, 50.715F, 1.2853F, 52.0F, 2.8713F, 52.0F);
      localPath.lineTo(35.000301F, 52.0F);
      localPath.lineTo(35.000301F, 56.0F);
      localPath.lineTo(23.000299F, 60.0F);
      localPath.lineTo(23.000299F, 63.0F);
      localPath.lineTo(58.000301F, 63.0F);
      localPath.lineTo(58.000301F, 60.0F);
      localPath.lineTo(46.000301F, 56.0F);
      localPath.lineTo(46.000301F, 52.0F);
      localPath.lineTo(59.000301F, 52.0F);
      localPath.lineTo(59.000301F, 49.0F);
      localPath.lineTo(46.000301F, 49.0F);
      localPath.lineTo(35.000301F, 49.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 60.0F, 0.0F, 1.0F, 30.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.5F, 28.613199F);
      ((Path)localObject2).cubicTo(25.5F, 29.378201F, 24.881001F, 30.0002F, 24.132F, 30.0002F);
      ((Path)localObject2).lineTo(4.868F, 30.0002F);
      ((Path)localObject2).cubicTo(4.11F, 30.0002F, 3.5F, 29.387199F, 3.5F, 28.613199F);
      ((Path)localObject2).lineTo(3.5F, 14.3872F);
      ((Path)localObject2).cubicTo(3.5F, 13.6222F, 4.119F, 13.0002F, 4.868F, 13.0002F);
      ((Path)localObject2).lineTo(24.132F, 13.0002F);
      ((Path)localObject2).cubicTo(24.889999F, 13.0002F, 25.5F, 13.6122F, 25.5F, 14.3872F);
      ((Path)localObject2).lineTo(25.5F, 28.613199F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.0F, 5.4992F);
      ((Path)localObject2).cubicTo(9.0F, 4.3952F, 9.9F, 3.5002F, 10.992F, 3.5002F);
      ((Path)localObject2).lineTo(18.007999F, 3.5002F);
      ((Path)localObject2).cubicTo(19.108F, 3.5002F, 20.0F, 4.3872F, 20.0F, 5.4992F);
      ((Path)localObject2).lineTo(20.0F, 10.0002F);
      ((Path)localObject2).lineTo(9.0F, 10.0002F);
      ((Path)localObject2).lineTo(9.0F, 5.4992F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.132F, 10.0002F);
      ((Path)localObject2).lineTo(23.0F, 10.0002F);
      ((Path)localObject2).lineTo(23.0F, 6.2542F);
      ((Path)localObject2).cubicTo(23.0F, 3.0742F, 20.423F, 0.5002F, 17.245001F, 0.5002F);
      ((Path)localObject2).lineTo(11.755F, 0.5002F);
      ((Path)localObject2).cubicTo(8.582F, 0.5002F, 6.0F, 3.0762F, 6.0F, 6.2542F);
      ((Path)localObject2).lineTo(6.0F, 10.0002F);
      ((Path)localObject2).lineTo(4.868F, 10.0002F);
      ((Path)localObject2).cubicTo(2.459F, 10.0002F, 0.5F, 11.9682F, 0.5F, 14.3872F);
      ((Path)localObject2).lineTo(0.5F, 28.613199F);
      ((Path)localObject2).cubicTo(0.5F, 31.0422F, 2.45F, 33.000198F, 4.868F, 33.000198F);
      ((Path)localObject2).lineTo(24.132F, 33.000198F);
      ((Path)localObject2).cubicTo(26.541F, 33.000198F, 28.5F, 31.0322F, 28.5F, 28.613199F);
      ((Path)localObject2).lineTo(28.5F, 14.3872F);
      ((Path)localObject2).cubicTo(28.5F, 11.9582F, 26.549999F, 10.0002F, 24.132F, 10.0002F);
      ((Path)localObject2).lineTo(24.132F, 10.0002F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connectkeyboad_banner_icon_pclock
 * JD-Core Version:    0.7.0.1
 */