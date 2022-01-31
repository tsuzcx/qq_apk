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

public final class aug
  extends c
{
  private final int height = 60;
  private final int width = 108;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-8534461);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(21.318575F, 1.569025F);
      ((Path)localObject3).cubicTo(22.687094F, 0.6905305F, 24.475161F, 1.169709F, 26.023485F, 1.0F);
      ((Path)localObject3).cubicTo(39.029419F, 1.109812F, 52.045345F, 0.9301198F, 65.051277F, 1.089846F);
      ((Path)localObject3).cubicTo(67.09906F, 0.9600685F, 68.237831F, 3.206218F, 67.958138F, 4.993156F);
      ((Path)localObject3).cubicTo(67.928169F, 16.024246F, 68.058029F, 27.065321F, 67.898201F, 38.096413F);
      ((Path)localObject3).cubicTo(67.978111F, 40.063042F, 65.860405F, 41.26099F, 64.092316F, 40.951519F);
      ((Path)localObject3).cubicTo(50.706791F, 40.971485F, 37.311279F, 40.971485F, 23.925755F, 40.951519F);
      ((Path)localObject3).cubicTo(22.167656F, 41.251007F, 20.0F, 40.112957F, 20.089903F, 38.126362F);
      ((Path)localObject3).cubicTo(19.900108F, 27.424706F, 20.089903F, 16.703083F, 20.0F, 6.001427F);
      ((Path)localObject3).cubicTo(20.079914F, 4.464062F, 19.780237F, 2.517399F, 21.318575F, 1.569025F);
      ((Path)localObject3).lineTo(21.318575F, 1.569025F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(1.018742F, 5.804835F);
      ((Path)localObject2).cubicTo(0.949004F, 4.142785F, 1.198068F, 2.470662F, 2.014998F, 1.0F);
      ((Path)localObject2).cubicTo(7.245344F, 5.129942F, 11.828123F, 10.005288F, 16.918993F, 14.306472F);
      ((Path)localObject2).cubicTo(17.048506F, 18.728533F, 16.988731F, 23.150591F, 16.968805F, 27.572651F);
      ((Path)localObject2).cubicTo(11.917787F, 31.984638F, 7.255307F, 36.829765F, 2.005036F, 41.0F);
      ((Path)localObject2).cubicTo(0.6003143F, 38.572399F, 1.098442F, 35.711658F, 1.038667F, 33.05238F);
      ((Path)localObject2).cubicTo(1.04863F, 23.966507F, 1.068555F, 14.880634F, 1.018742F, 5.804835F);
      ((Path)localObject2).lineTo(1.018742F, 5.804835F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aug
 * JD-Core Version:    0.7.0.1
 */