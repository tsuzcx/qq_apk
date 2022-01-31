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

public final class acf
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.333333F, 0.0F, 1.0F, 2.333333F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(11.666667F, 21.933332F);
      ((Path)localObject2).cubicTo(17.33679F, 21.933332F, 21.933332F, 17.33679F, 21.933332F, 11.666667F);
      ((Path)localObject2).cubicTo(21.933332F, 5.996543F, 17.33679F, 1.4F, 11.666667F, 1.4F);
      ((Path)localObject2).cubicTo(5.996543F, 1.4F, 1.4F, 5.996543F, 1.4F, 11.666667F);
      ((Path)localObject2).cubicTo(1.4F, 17.33679F, 5.996543F, 21.933332F, 11.666667F, 21.933332F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.666667F, 23.333334F);
      ((Path)localObject2).cubicTo(5.223345F, 23.333334F, 0.0F, 18.109989F, 0.0F, 11.666667F);
      ((Path)localObject2).cubicTo(0.0F, 5.223345F, 5.223345F, 0.0F, 11.666667F, 0.0F);
      ((Path)localObject2).cubicTo(18.109989F, 0.0F, 23.333334F, 5.223345F, 23.333334F, 11.666667F);
      ((Path)localObject2).cubicTo(23.333334F, 18.109989F, 18.109989F, 23.333334F, 11.666667F, 23.333334F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(11.666667F, 17.85F);
      ((Path)localObject2).cubicTo(14.276042F, 17.85F, 16.468582F, 16.065317F, 17.090242F, 13.65F);
      ((Path)localObject2).lineTo(6.243091F, 13.65F);
      ((Path)localObject2).cubicTo(6.864751F, 16.065317F, 9.057291F, 17.85F, 11.666667F, 17.85F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.666667F, 12.25F);
      ((Path)localObject2).lineTo(18.666666F, 12.25F);
      ((Path)localObject2).cubicTo(18.666666F, 16.115993F, 15.53266F, 19.25F, 11.666667F, 19.25F);
      ((Path)localObject2).cubicTo(7.800674F, 19.25F, 4.666667F, 16.115993F, 4.666667F, 12.25F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(7.583334F, 9.916667F);
      ((Path)localObject1).cubicTo(6.616835F, 9.916667F, 5.833334F, 9.133165F, 5.833334F, 8.166667F);
      ((Path)localObject1).cubicTo(5.833334F, 7.200168F, 6.616835F, 6.416667F, 7.583334F, 6.416667F);
      ((Path)localObject1).cubicTo(8.549831F, 6.416667F, 9.333333F, 7.200168F, 9.333333F, 8.166667F);
      ((Path)localObject1).cubicTo(9.333333F, 9.133165F, 8.549831F, 9.916667F, 7.583334F, 9.916667F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(15.75F, 9.916667F);
      ((Path)localObject1).cubicTo(14.783502F, 9.916667F, 14.0F, 9.133165F, 14.0F, 8.166667F);
      ((Path)localObject1).cubicTo(14.0F, 7.200168F, 14.783502F, 6.416667F, 15.75F, 6.416667F);
      ((Path)localObject1).cubicTo(16.716497F, 6.416667F, 17.5F, 7.200168F, 17.5F, 8.166667F);
      ((Path)localObject1).cubicTo(17.5F, 9.133165F, 16.716497F, 9.916667F, 15.75F, 9.916667F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.acf
 * JD-Core Version:    0.7.0.1
 */