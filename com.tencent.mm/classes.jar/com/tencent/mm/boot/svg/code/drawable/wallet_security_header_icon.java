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

public class wallet_security_header_icon
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      ((Canvas)localObject1).save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.666667F, 0.0F, 1.0F, 0.333333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject2).setColor(-16268960);
      ((Canvas)localObject1).save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(21.333334F, 0.3333333F);
      ((Path)localObject3).lineTo(42.666668F, 8.333333F);
      ((Path)localObject3).lineTo(42.666668F, 23.676769F);
      ((Path)localObject3).cubicTo(42.666668F, 36.600384F, 33.871078F, 47.865562F, 21.333334F, 51.0F);
      ((Path)localObject3).cubicTo(8.795588F, 47.865562F, 0.0F, 36.600384F, 0.0F, 23.676769F);
      ((Path)localObject3).lineTo(0.0F, 8.333333F);
      ((Path)localObject3).lineTo(21.333334F, 0.3333333F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(21.333334F, 3.631818F);
      ((Path)localObject3).lineTo(3.2F, 10.831818F);
      ((Path)localObject3).lineTo(3.2F, 23.676769F);
      ((Path)localObject3).cubicTo(3.2F, 34.863441F, 10.634958F, 44.648228F, 21.333334F, 47.688324F);
      ((Path)localObject3).cubicTo(32.031708F, 44.648228F, 39.466667F, 34.863441F, 39.466667F, 23.676769F);
      ((Path)localObject3).lineTo(39.467133F, 21.204887F);
      ((Path)localObject3).cubicTo(36.813263F, 22.641478F, 33.689526F, 24.33242F, 30.625566F, 25.991001F);
      ((Path)localObject3).lineTo(29.935169F, 26.364727F);
      ((Path)localObject3).cubicTo(23.160681F, 30.031889F, 16.877098F, 33.433315F, 16.877098F, 33.433315F);
      ((Path)localObject3).lineTo(16.717777F, 33.519974F);
      ((Path)localObject3).cubicTo(16.521044F, 33.612293F, 16.299564F, 33.666668F, 16.064812F, 33.666668F);
      ((Path)localObject3).cubicTo(15.519867F, 33.666668F, 15.046134F, 33.385174F, 14.797499F, 32.969448F);
      ((Path)localObject3).lineTo(14.702752F, 32.774612F);
      ((Path)localObject3).lineTo(10.736067F, 24.606211F);
      ((Path)localObject3).cubicTo(10.69322F, 24.517288F, 10.666667F, 24.416471F, 10.666667F, 24.318487F);
      ((Path)localObject3).cubicTo(10.666667F, 23.942408F, 10.991943F, 23.637691F, 11.392655F, 23.637691F);
      ((Path)localObject3).cubicTo(11.556802F, 23.637691F, 11.705862F, 23.688101F, 11.827765F, 23.773058F);
      ((Path)localObject3).lineTo(16.507767F, 26.900068F);
      ((Path)localObject3).cubicTo(16.848734F, 27.109631F, 17.258497F, 27.233103F, 17.697832F, 27.233103F);
      ((Path)localObject3).cubicTo(17.959141F, 27.233103F, 18.209585F, 27.187792F, 18.441925F, 27.107931F);
      ((Path)localObject3).cubicTo(18.441925F, 27.107931F, 18.463028F, 27.099138F, 18.503962F, 27.082083F);
      ((Path)localObject3).lineTo(18.611895F, 27.037111F);
      ((Path)localObject3).cubicTo(19.680883F, 26.591705F, 25.610056F, 24.121304F, 31.197025F, 21.794615F);
      ((Path)localObject3).lineTo(31.893238F, 21.504684F);
      ((Path)localObject3).cubicTo(34.832352F, 20.280748F, 37.614674F, 19.122471F, 39.467327F, 18.352039F);
      ((Path)localObject3).lineTo(39.466667F, 10.831818F);
      ((Path)localObject3).lineTo(21.333334F, 3.631818F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      ((Canvas)localObject1).drawPath((Path)localObject3, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(64.0F, 0.0F);
      ((Path)localObject1).lineTo(64.0F, 64.0F);
      ((Path)localObject1).lineTo(0.0F, 64.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wallet_security_header_icon
 * JD-Core Version:    0.7.0.1
 */