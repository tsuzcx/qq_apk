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

public final class gj
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject4 = c.m(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      localObject2 = c.a((Paint)localObject4, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -330.0F, 0.0F, 1.0F, -60.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 330.0F, 0.0F, 1.0F, 60.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(0.0F, 0.0F);
      ((Path)localObject4).lineTo(24.0F, 0.0F);
      ((Path)localObject4).lineTo(24.0F, 24.0F);
      ((Path)localObject4).lineTo(0.0F, 24.0F);
      ((Path)localObject4).lineTo(0.0F, 0.0F);
      ((Path)localObject4).close();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStrokeWidth(1.5F);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localObject4 = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(12.0F, 0.0F);
      localPath.lineTo(12.0F, 5.381655F);
      localPath.cubicTo(12.0F, 5.54734F, 12.134315F, 5.681655F, 12.3F, 5.681655F);
      localPath.lineTo(17.964392F, 5.681655F);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 29.681654F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(12.0F, 12.0F);
      ((Path)localObject1).lineTo(12.0F, 17.381655F);
      ((Path)localObject1).cubicTo(12.0F, 17.54734F, 12.134315F, 17.681654F, 12.3F, 17.681654F);
      ((Path)localObject1).lineTo(17.964392F, 17.681654F);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(5.964391F, 17.681654F);
      ((Path)localObject3).lineTo(5.964391F, 12.3F);
      ((Path)localObject3).cubicTo(5.964391F, 12.134315F, 5.830077F, 12.0F, 5.664392F, 12.0F);
      ((Path)localObject3).lineTo(0.0F, 12.0F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(5.964339F, 0.0108777F);
      ((Path)localObject2).lineTo(5.964339F, 5.392532F);
      ((Path)localObject2).cubicTo(5.964339F, 5.558218F, 5.830025F, 5.692533F, 5.664339F, 5.692533F);
      ((Path)localObject2).lineTo(-5.217391E-005F, 5.692533F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.gj
 * JD-Core Version:    0.7.0.1
 */