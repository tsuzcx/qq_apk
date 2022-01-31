package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class zj
  extends c
{
  private final int height = 111;
  private final int width = 111;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 111;
      return 111;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Object localObject4 = c.k(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.FILL);
      Object localObject3 = c.k(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      ((Paint)localObject4).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      localObject4 = c.a((Paint)localObject4, paramVarArgs);
      ((Paint)localObject4).setColor(-16074);
      localCanvas.save();
      localObject4 = c.a((Paint)localObject4, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(55.5F, 0.0F);
      localPath.cubicTo(86.15181F, 0.0F, 111.0F, 24.848194F, 111.0F, 55.5F);
      localPath.cubicTo(111.0F, 86.15181F, 86.15181F, 111.0F, 55.5F, 111.0F);
      localPath.cubicTo(24.848194F, 111.0F, 0.0F, 86.15181F, 0.0F, 55.5F);
      localPath.cubicTo(0.0F, 24.848194F, 24.848194F, 0.0F, 55.5F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      ((Paint)localObject3).setStrokeWidth(3.0F);
      localObject4 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject3, paramVarArgs);
      localObject4 = c.a((float[])localObject4, 0.8987941F, -0.4383712F, 23.489042F, 0.4383712F, 0.8987941F, -15.173922F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.l(paramVarArgs);
      localPath.moveTo(22.994629F, 17.339851F);
      localPath.cubicTo(22.39213F, 17.121492F, 21.726933F, 17.430361F, 21.509315F, 18.025713F);
      localPath.lineTo(10.605188F, 47.857071F);
      localPath.cubicTo(10.388678F, 48.449402F, 10.695863F, 49.105358F, 11.295349F, 49.322624F);
      localPath.lineTo(66.219894F, 69.228455F);
      localPath.cubicTo(66.822395F, 69.446815F, 67.487595F, 69.137947F, 67.705208F, 68.542595F);
      localPath.lineTo(78.609337F, 38.711235F);
      localPath.cubicTo(78.825844F, 38.118908F, 78.518661F, 37.462952F, 77.919174F, 37.245686F);
      localPath.lineTo(22.994629F, 17.339851F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      localObject3 = c.a((float[])localObject4, 1.0F, 0.0F, 13.269231F, 0.0F, 1.0F, 10.468085F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.a((float[])localObject3, 0.9975641F, 0.06975647F, -1.867919F, -0.06975647F, 0.9975641F, 2.568316F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(39.538136F, 6.310624F);
      ((Path)localObject1).cubicTo(43.658218F, 4.154688F, 48.062016F, 2.915408F, 52.749519F, 2.592784F);
      ((Path)localObject1).cubicTo(59.982471F, 2.545481F, 65.71933F, 4.773037F, 68.361603F, 9.330113F);
      ((Path)localObject1).cubicTo(73.88385F, 18.854218F, 63.797997F, 34.946922F, 45.834229F, 45.274174F);
      ((Path)localObject1).cubicTo(27.870462F, 55.601429F, 8.831288F, 56.25251F, 3.309046F, 46.728405F);
      ((Path)localObject1).cubicTo(2.650827F, 45.593189F, 2.214356F, 44.364651F, 1.986543F, 43.063679F);
      ((Path)localObject1).cubicTo(1.633793F, 40.273342F, 1.798568F, 37.926987F, 2.480866F, 36.024609F);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.zj
 * JD-Core Version:    0.7.0.1
 */