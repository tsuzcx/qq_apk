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

public final class xp
  extends c
{
  private final int height = 33;
  private final int width = 33;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 33;
      return 33;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.i(paramVarArgs);
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
      ((Paint)localObject3).setColor(-1);
      localObject4 = c.a((float[])localObject2, 1.0F, 0.0F, -226.0F, 0.0F, 1.0F, -665.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject3, paramVarArgs);
      localObject3 = c.a((float[])localObject4, 0.7071068F, -0.7071068F, 553.11835F, 0.7071068F, 0.7071068F, 28.051147F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(244.19849F, 680.19849F);
      ((Path)localObject1).lineTo(244.19849F, 660.69849F);
      ((Path)localObject1).lineTo(241.19849F, 660.69849F);
      ((Path)localObject1).lineTo(241.19849F, 680.19849F);
      ((Path)localObject1).lineTo(221.69849F, 680.19849F);
      ((Path)localObject1).lineTo(221.69849F, 683.19849F);
      ((Path)localObject1).lineTo(241.19849F, 683.19849F);
      ((Path)localObject1).lineTo(241.19849F, 702.69849F);
      ((Path)localObject1).lineTo(244.19849F, 702.69849F);
      ((Path)localObject1).lineTo(244.19849F, 683.19849F);
      ((Path)localObject1).lineTo(263.69849F, 683.19849F);
      ((Path)localObject1).lineTo(263.69849F, 680.19849F);
      ((Path)localObject1).lineTo(244.19849F, 680.19849F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xp
 * JD-Core Version:    0.7.0.1
 */