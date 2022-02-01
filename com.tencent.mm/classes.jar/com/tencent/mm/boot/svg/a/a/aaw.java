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

public final class aaw
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 21.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-499359);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(42.462597F, 24.958805F);
      ((Path)localObject2).cubicTo(42.750237F, 25.252054F, 43.023048F, 25.55946F, 43.284F, 25.879F);
      ((Path)localObject2).lineTo(43.284F, 2.452434F);
      ((Path)localObject2).cubicTo(40.165432F, 1.437185F, 36.847195F, 0.879F, 33.399467F, 0.879F);
      ((Path)localObject2).cubicTo(29.116503F, 0.879F, 25.031225F, 1.734479F, 21.284F, 3.269487F);
      ((Path)localObject2).lineTo(42.474457F, 24.947681F);
      ((Path)localObject2).lineTo(42.462597F, 24.958805F);
      ((Path)localObject2).lineTo(42.462597F, 24.958805F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16384);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(33.085453F, 20.821308F);
      ((Path)localObject2).cubicTo(33.093319F, 20.821308F, 33.101185F, 20.820332F, 33.109051F, 20.820332F);
      ((Path)localObject2).cubicTo(33.505287F, 20.820332F, 33.89661F, 20.843798F, 34.284F, 20.879F);
      ((Path)localObject2).lineTo(18.196526F, 4.879F);
      ((Path)localObject2).cubicTo(11.553879F, 8.305266F, 6.251363F, 13.943353F, 3.284F, 20.819353F);
      ((Path)localObject2).lineTo(33.085453F, 20.819353F);
      ((Path)localObject2).lineTo(33.085453F, 20.821308F);
      ((Path)localObject2).lineTo(33.085453F, 20.821308F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9676047);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(46.343616F, 3.879F);
      ((Path)localObject2).lineTo(46.343616F, 33.680458F);
      ((Path)localObject2).cubicTo(46.343616F, 34.085213F, 46.32114F, 34.48407F, 46.284F, 34.879002F);
      ((Path)localObject2).lineTo(62.284F, 18.795938F);
      ((Path)localObject2).cubicTo(58.860386F, 12.149923F, 53.222122F, 6.845883F, 46.343616F, 3.879F);
      ((Path)localObject2).lineTo(46.343616F, 3.879F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-5117108);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(4.284F, 48.968616F);
      ((Path)localObject2).cubicTo(7.704265F, 55.607681F, 13.332067F, 60.908321F, 20.198982F, 63.879002F);
      ((Path)localObject2).lineTo(20.198982F, 34.101467F);
      ((Path)localObject2).lineTo(20.22439F, 34.101467F);
      ((Path)localObject2).cubicTo(20.22439F, 34.093609F, 20.223412F, 34.086727F, 20.223412F, 34.079849F);
      ((Path)localObject2).cubicTo(20.223412F, 33.673996F, 20.245888F, 33.274044F, 20.284F, 32.879002F);
      ((Path)localObject2).lineTo(4.284F, 48.968616F);
      ((Path)localObject2).lineTo(4.284F, 48.968616F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-10818218);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(24.129469F, 42.824417F);
      ((Path)localObject2).cubicTo(23.832813F, 42.523418F, 23.550991F, 42.208279F, 23.284F, 41.879002F);
      ((Path)localObject2).lineTo(23.284F, 65.299263F);
      ((Path)localObject2).cubicTo(26.411741F, 66.31842F, 29.739231F, 66.878998F, 33.19725F, 66.878998F);
      ((Path)localObject2).cubicTo(37.469097F, 66.878998F, 41.544159F, 66.029541F, 45.284F, 64.504349F);
      ((Path)localObject2).lineTo(24.09387F, 42.860779F);
      ((Path)localObject2).lineTo(24.129469F, 42.824417F);
      ((Path)localObject2).lineTo(24.129469F, 42.824417F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-12799249);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(63.902184F, 21.879F);
      ((Path)localObject2).lineTo(42.240566F, 43.067806F);
      ((Path)localObject2).lineTo(42.218342F, 43.04607F);
      ((Path)localObject2).cubicTo(41.921375F, 43.337547F, 41.608242F, 43.615189F, 41.284F, 43.879002F);
      ((Path)localObject2).lineTo(64.705215F, 43.879002F);
      ((Path)localObject2).cubicTo(65.724403F, 40.754776F, 66.283997F, 37.429974F, 66.283997F, 33.974751F);
      ((Path)localObject2).cubicTo(66.283997F, 29.698456F, 65.431473F, 25.61977F, 63.902184F, 21.879F);
      ((Path)localObject2).lineTo(63.902184F, 21.879F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-11083026);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(33.506523F, 46.939556F);
      ((Path)localObject2).cubicTo(33.094105F, 46.939556F, 32.686596F, 46.917091F, 32.284F, 46.879002F);
      ((Path)localObject2).lineTo(48.36924F, 62.879002F);
      ((Path)localObject2).cubicTo(55.011116F, 59.461384F, 60.313618F, 53.83242F, 63.284F, 46.963978F);
      ((Path)localObject2).lineTo(33.506523F, 46.963978F);
      ((Path)localObject2).lineTo(33.506523F, 46.939556F);
      ((Path)localObject2).lineTo(33.506523F, 46.939556F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1124019);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(24.35268F, 24.71294F);
      ((Path)localObject1).cubicTo(24.648964F, 24.42111F, 24.961426F, 24.143131F, 25.284F, 23.879F);
      ((Path)localObject1).lineTo(1.857434F, 23.879F);
      ((Path)localObject1).cubicTo(0.8421847F, 27.000093F, 0.284F, 30.321016F, 0.284F, 33.77153F);
      ((Path)localObject1).cubicTo(0.284F, 38.052029F, 1.136445F, 42.134678F, 2.667408F, 45.879002F);
      ((Path)localObject1).lineTo(24.3274F, 24.68821F);
      ((Path)localObject1).lineTo(24.35268F, 24.71294F);
      ((Path)localObject1).lineTo(24.35268F, 24.71294F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aaw
 * JD-Core Version:    0.7.0.1
 */