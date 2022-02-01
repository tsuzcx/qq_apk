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

public class icons_outlined_bellring_close
  extends c
{
  private final int height = 25;
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
      return 25;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.186707F, 20.000029F);
      ((Path)localObject2).cubicTo(4.973726F, 20.000029F, 4.766308F, 19.931999F, 4.594667F, 19.805901F);
      ((Path)localObject2).cubicTo(4.149601F, 19.478926F, 4.053867F, 18.853064F, 4.380841F, 18.407995F);
      ((Path)localObject2).cubicTo(5.460271F, 16.93865F, 6.0F, 15.469325F, 6.0F, 14.0F);
      ((Path)localObject2).lineTo(6.0F, 10.0F);
      ((Path)localObject2).cubicTo(6.0F, 7.377336F, 7.682712F, 5.147691F, 10.027397F, 4.331803F);
      ((Path)localObject2).cubicTo(10.009377F, 4.223883F, 10.0F, 4.113037F, 10.0F, 4.0F);
      ((Path)localObject2).cubicTo(10.0F, 2.895431F, 10.895431F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject2).cubicTo(13.104569F, 2.0F, 14.0F, 2.895431F, 14.0F, 4.0F);
      ((Path)localObject2).cubicTo(14.0F, 4.113037F, 13.990623F, 4.223883F, 13.972603F, 4.331803F);
      ((Path)localObject2).cubicTo(16.317287F, 5.147691F, 18.0F, 7.377336F, 18.0F, 10.0F);
      ((Path)localObject2).lineTo(18.0F, 14.0F);
      ((Path)localObject2).cubicTo(18.0F, 15.469309F, 18.539717F, 16.938618F, 19.619152F, 18.407927F);
      ((Path)localObject2).cubicTo(19.745256F, 18.579578F, 19.813261F, 18.787006F, 19.813261F, 19.0F);
      ((Path)localObject2).cubicTo(19.813261F, 19.552299F, 19.365532F, 20.000029F, 18.813232F, 20.000029F);
      ((Path)localObject2).lineTo(13.0F, 20.0F);
      ((Path)localObject2).lineTo(13.0F, 20.200001F);
      ((Path)localObject2).cubicTo(13.0F, 20.752285F, 12.552284F, 21.200001F, 12.0F, 21.200001F);
      ((Path)localObject2).cubicTo(11.447716F, 21.200001F, 11.0F, 20.752285F, 11.0F, 20.200001F);
      ((Path)localObject2).lineTo(11.0F, 20.0F);
      ((Path)localObject2).lineTo(5.186707F, 20.000029F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 3.2F);
      ((Path)localObject2).cubicTo(11.558172F, 3.2F, 11.2F, 3.558172F, 11.2F, 4.0F);
      ((Path)localObject2).cubicTo(11.2F, 4.045741F, 11.203718F, 4.090497F, 11.211012F, 4.134177F);
      ((Path)localObject2).lineTo(11.377702F, 5.132509F);
      ((Path)localObject2).lineTo(10.42177F, 5.465148F);
      ((Path)localObject2).cubicTo(8.508613F, 6.130875F, 7.2F, 7.940861F, 7.2F, 10.0F);
      ((Path)localObject2).lineTo(7.2F, 14.0F);
      ((Path)localObject2).cubicTo(7.2F, 15.630327F, 6.648492F, 17.235512F, 5.574221F, 18.800026F);
      ((Path)localObject2).lineTo(18.425831F, 18.800026F);
      ((Path)localObject2).cubicTo(17.351528F, 17.235563F, 16.799999F, 15.630358F, 16.799999F, 14.0F);
      ((Path)localObject2).lineTo(16.799999F, 10.0F);
      ((Path)localObject2).cubicTo(16.799999F, 7.940861F, 15.491387F, 6.130875F, 13.57823F, 5.465148F);
      ((Path)localObject2).lineTo(12.622298F, 5.132509F);
      ((Path)localObject2).lineTo(12.788988F, 4.134177F);
      ((Path)localObject2).cubicTo(12.796282F, 4.090497F, 12.8F, 4.045741F, 12.8F, 4.0F);
      ((Path)localObject2).cubicTo(12.8F, 3.558172F, 12.441828F, 3.2F, 12.0F, 3.2F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_bellring_close
 * JD-Core Version:    0.7.0.1
 */