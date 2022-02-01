package com.tencent.mm.boot.svg.a.a;

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

public final class boq
  extends c
{
  private final int height = 100;
  private final int width = 100;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject2 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-15028967);
      ((Paint)localObject2).setStrokeWidth(1.96F);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(49.0F, 0.9799995F);
      ((Path)localObject3).cubicTo(75.520714F, 0.9799995F, 97.020004F, 22.479284F, 97.020004F, 49.0F);
      ((Path)localObject3).cubicTo(97.020004F, 75.520714F, 75.520714F, 97.020004F, 49.0F, 97.020004F);
      ((Path)localObject3).cubicTo(22.479284F, 97.020004F, 0.9799995F, 75.520714F, 0.9799995F, 49.0F);
      ((Path)localObject3).cubicTo(0.9799995F, 22.479284F, 22.479284F, 0.9799995F, 49.0F, 0.9799995F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-15028967);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(45.596504F, 87.379501F);
      ((Path)localObject2).cubicTo(45.311245F, 88.296371F, 45.560669F, 89.657684F, 46.151157F, 90.416939F);
      ((Path)localObject2).lineTo(47.928844F, 92.702698F);
      ((Path)localObject2).cubicTo(48.520428F, 93.463364F, 49.480667F, 93.461952F, 50.071156F, 92.702698F);
      ((Path)localObject2).lineTo(51.848843F, 90.416939F);
      ((Path)localObject2).cubicTo(52.440426F, 89.656281F, 52.686527F, 88.289207F, 52.403496F, 87.379501F);
      ((Path)localObject2).lineTo(49.516502F, 78.100136F);
      ((Path)localObject2).cubicTo(49.231247F, 77.183273F, 48.766525F, 77.19043F, 48.483498F, 78.100136F);
      ((Path)localObject2).lineTo(45.596504F, 87.379501F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localPaint.setStrokeWidth(1.96F);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(78.489311F, 86.901474F);
      ((Path)localObject1).cubicTo(78.21859F, 86.711105F, 77.946815F, 86.55085F, 77.6791F, 86.424408F);
      ((Path)localObject1).lineTo(58.566147F, 77.397362F);
      ((Path)localObject1).cubicTo(54.962547F, 75.695381F, 54.140015F, 71.747421F, 56.766563F, 68.754417F);
      ((Path)localObject1).lineTo(58.378567F, 66.917511F);
      ((Path)localObject1).cubicTo(60.966438F, 63.968586F, 63.106014F, 58.298977F, 63.106014F, 54.390598F);
      ((Path)localObject1).lineTo(63.106014F, 48.363018F);
      ((Path)localObject1).cubicTo(63.106014F, 40.597996F, 56.790562F, 34.299999F, 49.000072F, 34.299999F);
      ((Path)localObject1).cubicTo(41.207775F, 34.299999F, 34.894135F, 40.596203F, 34.894135F, 48.363018F);
      ((Path)localObject1).lineTo(34.894135F, 54.390598F);
      ((Path)localObject1).cubicTo(34.894135F, 58.299099F, 37.033085F, 63.966492F, 39.621418F, 66.914436F);
      ((Path)localObject1).lineTo(41.233421F, 68.750412F);
      ((Path)localObject1).cubicTo(43.861019F, 71.74308F, 43.038033F, 75.689438F, 39.434158F, 77.392319F);
      ((Path)localObject1).lineTo(20.305996F, 86.430649F);
      ((Path)localObject1).cubicTo(20.043016F, 86.554909F, 19.775612F, 86.712585F, 19.508852F, 86.900047F);
      ((Path)localObject1).cubicTo(27.86791F, 93.415367F, 38.156105F, 97.019997F, 49.0F, 97.019997F);
      ((Path)localObject1).cubicTo(59.84309F, 97.019997F, 70.130569F, 93.415909F, 78.489311F, 86.901474F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.boq
 * JD-Core Version:    0.7.0.1
 */