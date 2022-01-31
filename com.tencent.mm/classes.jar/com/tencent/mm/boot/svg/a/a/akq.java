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

public final class akq
  extends c
{
  private final int height = 330;
  private final int width = 400;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 400;
      return 330;
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
      ((Paint)localObject2).setColor(-15132133);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 51, 4);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(0.02502626F, 19.949099F);
      ((Path)localObject3).cubicTo(-0.2352469F, 9.319578F, 9.284743F, -0.2399892F, 19.935921F, 0.02999864F);
      ((Path)localObject3).cubicTo(68.396774F, -0.0199991F, 116.85763F, 0.03999819F, 165.31848F, 0.0F);
      ((Path)localObject3).cubicTo(171.28474F, 8.539614F, 176.96069F, 17.299217F, 182.73676F, 25.978825F);
      ((Path)localObject3).cubicTo(129.51091F, 26.068821F, 76.285049F, 25.958826F, 23.059198F, 26.028822F);
      ((Path)localObject3).cubicTo(23.009146F, 87.476044F, 23.019156F, 148.92326F, 23.049187F, 210.37048F);
      ((Path)localObject3).cubicTo(34.921646F, 193.73123F, 48.996414F, 178.78192F, 64.102264F, 165.05254F);
      ((Path)localObject3).cubicTo(77.185997F, 153.22307F, 91.060555F, 142.20357F, 106.04628F, 132.88399F);
      ((Path)localObject3).cubicTo(114.23488F, 127.91422F, 122.7438F, 123.18443F, 132.06358F, 120.68454F);
      ((Path)localObject3).cubicTo(140.48242F, 118.46465F, 149.3217F, 120.68454F, 157.10986F, 124.07439F);
      ((Path)localObject3).cubicTo(168.70203F, 129.39415F, 178.59241F, 137.73376F, 187.58185F, 146.65337F);
      ((Path)localObject3).cubicTo(190.42484F, 149.47324F, 193.28783F, 152.34311F, 195.4501F, 155.75296F);
      ((Path)localObject3).cubicTo(206.52171F, 172.4922F, 217.79355F, 189.10144F, 228.81511F, 205.87068F);
      ((Path)localObject3).cubicTo(217.61336F, 215.95023F, 206.15134F, 225.73979F, 194.9696F, 235.84933F);
      ((Path)localObject3).cubicTo(210.8763F, 259.95825F, 227.06328F, 283.88715F, 243.0F, 307.97607F);
      ((Path)localObject3).cubicTo(168.66199F, 308.01608F, 94.333992F, 307.99606F, 19.995983F, 307.98608F);
      ((Path)localObject3).cubicTo(9.344807F, 308.26605F, -0.2252364F, 298.7265F, 0.03503677F, 288.08698F);
      ((Path)localObject3).cubicTo(-0.01501576F, 198.71101F, -0.005005253F, 109.33505F, 0.02502626F, 19.949099F);
      ((Path)localObject3).lineTo(0.02502626F, 19.949099F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(353.92917F, 0.01836869F);
      ((Path)localObject2).cubicTo(358.48602F, 0.04836348F, 363.25314F, -0.3615654F, 367.54959F, 1.518108F);
      ((Path)localObject2).cubicTo(374.93066F, 4.437602F, 380.09842F, 12.086274F, 379.9682F, 20.034895F);
      ((Path)localObject2).cubicTo(379.99826F, 107.35974F, 379.95819F, 194.69458F, 379.98825F, 282.01944F);
      ((Path)localObject2).cubicTo(379.93817F, 286.27869F, 380.33878F, 290.70792F, 378.78644F, 294.77722F);
      ((Path)localObject2).cubicTo(376.40286F, 301.56604F, 370.05334F, 306.78513F, 362.90262F, 307.74496F);
      ((Path)localObject2).cubicTo(359.6077F, 308.12491F, 356.29272F, 307.96494F, 352.99777F, 307.97491F);
      ((Path)localObject2).cubicTo(321.55066F, 307.96494F, 290.11353F, 307.98492F, 258.66641F, 307.96494F);
      ((Path)localObject2).cubicTo(242.48215F, 284.00909F, 226.44812F, 259.94327F, 210.47418F, 235.84744F);
      ((Path)localObject2).cubicTo(221.64091F, 225.7092F, 233.15817F, 215.96089F, 244.33493F, 205.84265F);
      ((Path)localObject2).cubicTo(240.80965F, 200.27362F, 236.92381F, 194.93454F, 233.44861F, 189.33551F);
      ((Path)localObject2).cubicTo(244.80563F, 180.1571F, 256.76355F, 171.5486F, 269.86319F, 164.98975F);
      ((Path)localObject2).cubicTo(276.66339F, 161.72031F, 284.17462F, 158.63084F, 291.87619F, 159.9906F);
      ((Path)localObject2).cubicTo(302.62228F, 161.67032F, 312.06644F, 167.71927F, 320.33884F, 174.4881F);
      ((Path)localObject2).cubicTo(334.82056F, 186.556F, 346.49805F, 201.58339F, 356.92368F, 217.18068F);
      ((Path)localObject2).cubicTo(356.9537F, 153.47174F, 356.96375F, 89.752792F, 356.91367F, 26.043852F);
      ((Path)localObject2).cubicTo(304.46506F, 25.983862F, 252.01643F, 26.063848F, 199.55782F, 26.003859F);
      ((Path)localObject2).cubicTo(198.15572F, 26.28381F, 197.5448F, 24.794069F, 196.84375F, 23.924219F);
      ((Path)localObject2).cubicTo(191.63594F, 15.925608F, 186.20781F, 8.066972F, 181.0F, 0.05836175F);
      ((Path)localObject2).cubicTo(238.63638F, -0.02162437F, 296.28278F, 0.05836175F, 353.92917F, 0.01836869F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.akq
 * JD-Core Version:    0.7.0.1
 */