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

public final class dn
  extends c
{
  private final int height = 96;
  private final int width = 130;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 130;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Object localObject3 = c.k(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.k(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.a((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -238.0F, 0.0F, 1.0F, -166.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.a((float[])localObject2, 1.0F, 0.0F, 238.0F, 0.0F, 1.0F, 166.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject3, paramVarArgs);
      localObject3 = c.a((float[])localObject4, 0.7071068F, -0.7071068F, 50.781029F, 0.7071068F, 0.7071068F, -41.066437F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(75.899033F, 17.651163F);
      ((Path)localObject1).lineTo(92.860985F, 63.180599F);
      ((Path)localObject1).lineTo(92.860985F, 63.180599F);
      ((Path)localObject1).cubicTo(93.053787F, 63.698135F, 92.790543F, 64.273987F, 92.27301F, 64.466789F);
      ((Path)localObject1).cubicTo(91.968353F, 64.580292F, 91.627533F, 64.538605F, 91.359215F, 64.355019F);
      ((Path)localObject1).lineTo(74.961952F, 53.135838F);
      ((Path)localObject1).lineTo(58.56469F, 64.355019F);
      ((Path)localObject1).lineTo(58.56469F, 64.355019F);
      ((Path)localObject1).cubicTo(58.108883F, 64.666885F, 57.486565F, 64.550201F, 57.174698F, 64.094391F);
      ((Path)localObject1).cubicTo(56.991112F, 63.826077F, 56.949425F, 63.48526F, 57.062923F, 63.180599F);
      ((Path)localObject1).lineTo(74.024872F, 17.651163F);
      ((Path)localObject1).lineTo(74.024872F, 17.651163F);
      ((Path)localObject1).cubicTo(74.217682F, 17.133627F, 74.793526F, 16.870382F, 75.311066F, 17.063189F);
      ((Path)localObject1).cubicTo(75.583107F, 17.164541F, 75.797684F, 17.379114F, 75.899033F, 17.651163F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.dn
 * JD-Core Version:    0.7.0.1
 */