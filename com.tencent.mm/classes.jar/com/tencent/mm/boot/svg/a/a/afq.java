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

public final class afq
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(64.0F, 0.0F);
      localPath.lineTo(64.0F, 64.0F);
      localPath.lineTo(0.0F, 64.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 14.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(10.46244F, 16.854254F);
      ((Path)localObject2).cubicTo(11.012562F, 13.594092F, 13.590585F, 11.023504F, 16.854254F, 10.484127F);
      ((Path)localObject2).lineTo(16.854254F, 1.037311F);
      ((Path)localObject2).cubicTo(16.854254F, 0.4643545F, 16.389896F, 3.552714E-014F, 15.817086F, 3.552714E-014F);
      ((Path)localObject2).lineTo(15.572806F, 3.552714E-014F);
      ((Path)localObject2).cubicTo(15.297821F, 3.552714E-014F, 15.034029F, 0.1093578F, 14.839513F, 0.3038724F);
      ((Path)localObject2).lineTo(0.3037239F, 14.839531F);
      ((Path)localObject2).cubicTo(0.1092075F, 15.033894F, -4.192202E-013F, 15.297835F, -4.192202E-013F, 15.572818F);
      ((Path)localObject2).lineTo(-4.192202E-013F, 15.817095F);
      ((Path)localObject2).cubicTo(-4.192202E-013F, 16.3899F, 0.4643587F, 16.854254F, 1.037169F, 16.854254F);
      ((Path)localObject2).lineTo(10.46244F, 16.854254F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15683841);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(19.101488F, 10.490272F);
      ((Path)localObject2).cubicTo(22.347433F, 11.043116F, 24.907736F, 13.606618F, 25.455734F, 16.854254F);
      ((Path)localObject2).lineTo(34.74585F, 16.854254F);
      ((Path)localObject2).cubicTo(35.413944F, 16.854254F, 35.955742F, 16.312603F, 35.955742F, 15.64435F);
      ((Path)localObject2).lineTo(35.955742F, 15.619847F);
      ((Path)localObject2).cubicTo(35.955742F, 15.299031F, 35.828236F, 14.991223F, 35.601353F, 14.764338F);
      ((Path)localObject2).lineTo(21.191387F, 0.3543949F);
      ((Path)localObject2).cubicTo(20.964502F, 0.1273583F, 20.656698F, 3.552714E-014F, 20.335884F, 3.552714E-014F);
      ((Path)localObject2).lineTo(20.311382F, 3.552714E-014F);
      ((Path)localObject2).cubicTo(19.643135F, 3.552714E-014F, 19.101488F, 0.541651F, 19.101488F, 1.209904F);
      ((Path)localObject2).lineTo(19.101488F, 10.490272F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-372399);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(16.854254F, 25.485985F);
      ((Path)localObject2).cubicTo(13.585773F, 24.945852F, 11.005052F, 22.368458F, 10.460077F, 19.101488F);
      ((Path)localObject2).lineTo(1.209893F, 19.101488F);
      ((Path)localObject2).cubicTo(0.541797F, 19.101488F, -4.192202E-013F, 19.643135F, -4.192202E-013F, 20.311382F);
      ((Path)localObject2).lineTo(-4.192202E-013F, 20.322121F);
      ((Path)localObject2).cubicTo(-4.192202E-013F, 20.642933F, 0.1275084F, 20.950739F, 0.3543918F, 21.177622F);
      ((Path)localObject2).lineTo(14.778121F, 35.601353F);
      ((Path)localObject2).cubicTo(15.005004F, 35.828236F, 15.312809F, 35.955742F, 15.633622F, 35.955742F);
      ((Path)localObject2).lineTo(15.644361F, 35.955742F);
      ((Path)localObject2).cubicTo(16.312609F, 35.955742F, 16.854254F, 35.413944F, 16.854254F, 34.74585F);
      ((Path)localObject2).lineTo(16.854254F, 25.485985F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16268960);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(25.458155F, 19.101488F);
      ((Path)localObject1).cubicTo(24.915146F, 22.355904F, 22.352272F, 24.926037F, 19.101488F, 25.479784F);
      ((Path)localObject1).lineTo(19.101488F, 34.74585F);
      ((Path)localObject1).cubicTo(19.101488F, 35.413944F, 19.643135F, 35.955742F, 20.311382F, 35.955742F);
      ((Path)localObject1).lineTo(20.346624F, 35.955742F);
      ((Path)localObject1).cubicTo(20.667437F, 35.955742F, 20.975243F, 35.828236F, 21.202126F, 35.601353F);
      ((Path)localObject1).lineTo(35.601353F, 21.202126F);
      ((Path)localObject1).cubicTo(35.828236F, 20.975243F, 35.955742F, 20.667437F, 35.955742F, 20.346624F);
      ((Path)localObject1).lineTo(35.955742F, 20.311382F);
      ((Path)localObject1).cubicTo(35.955742F, 19.643135F, 35.413944F, 19.101488F, 34.74585F, 19.101488F);
      ((Path)localObject1).lineTo(25.458155F, 19.101488F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.afq
 * JD-Core Version:    0.7.0.1
 */