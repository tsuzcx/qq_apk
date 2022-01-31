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

public final class fe
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
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
      localPaint1.setColor(-9074981);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -350.0F, 0.0F, 1.0F, -661.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(372.0F, 661.0F);
      ((Path)localObject2).cubicTo(369.8465F, 661.0F, 368.30701F, 661.45575F, 367.0F, 662.0F);
      ((Path)localObject2).cubicTo(364.60251F, 663.65375F, 363.0F, 666.16858F, 363.0F, 669.0F);
      ((Path)localObject2).lineTo(363.0F, 681.0F);
      ((Path)localObject2).cubicTo(363.0F, 683.11066F, 360.98499F, 684.85187F, 359.0F, 685.0F);
      ((Path)localObject2).cubicTo(356.0145F, 684.85187F, 354.0F, 683.11066F, 354.0F, 681.0F);
      ((Path)localObject2).cubicTo(354.0F, 679.43439F, 355.02301F, 678.11578F, 357.0F, 677.0F);
      ((Path)localObject2).cubicTo(356.6145F, 677.43445F, 356.72299F, 677.39087F, 357.0F, 677.0F);
      ((Path)localObject2).cubicTo(357.76901F, 676.96362F, 358.5705F, 676.23358F, 359.0F, 675.0F);
      ((Path)localObject2).cubicTo(359.3075F, 674.13409F, 358.4895F, 673.11987F, 357.0F, 673.0F);
      ((Path)localObject2).cubicTo(356.68051F, 673.11987F, 356.31451F, 673.18311F, 356.0F, 673.0F);
      ((Path)localObject2).cubicTo(355.95999F, 673.29773F, 355.9585F, 673.29822F, 356.0F, 673.0F);
      ((Path)localObject2).cubicTo(353.86301F, 673.922F, 352.11551F, 675.28882F, 351.0F, 677.0F);
      ((Path)localObject2).cubicTo(350.38901F, 678.22778F, 350.0F, 679.55261F, 350.0F, 681.0F);
      ((Path)localObject2).cubicTo(350.0F, 685.39471F, 353.81299F, 689.0F, 359.0F, 689.0F);
      ((Path)localObject2).cubicTo(360.1535F, 689.0F, 361.69299F, 688.54425F, 363.0F, 688.0F);
      ((Path)localObject2).cubicTo(365.39749F, 686.34625F, 367.0F, 683.83142F, 367.0F, 681.0F);
      ((Path)localObject2).lineTo(367.0F, 669.0F);
      ((Path)localObject2).cubicTo(367.0F, 666.88934F, 369.0145F, 665.14813F, 372.0F, 665.0F);
      ((Path)localObject2).cubicTo(373.98499F, 665.14813F, 376.0F, 666.88934F, 376.0F, 669.0F);
      ((Path)localObject2).cubicTo(376.0F, 670.63098F, 374.8905F, 672.00092F, 373.0F, 673.0F);
      ((Path)localObject2).cubicTo(372.2775F, 672.95758F, 371.43799F, 673.7265F, 371.0F, 675.0F);
      ((Path)localObject2).cubicTo(370.681F, 675.88306F, 371.495F, 676.89313F, 373.0F, 677.0F);
      ((Path)localObject2).cubicTo(373.263F, 676.89313F, 373.59299F, 676.83502F, 374.0F, 677.0F);
      ((Path)localObject2).cubicTo(373.96701F, 676.72565F, 374.01901F, 676.70905F, 374.0F, 677.0F);
      ((Path)localObject2).cubicTo(376.15201F, 676.0661F, 377.88901F, 674.70343F, 379.0F, 673.0F);
      ((Path)localObject2).cubicTo(379.61099F, 671.77277F, 380.0F, 670.44739F, 380.0F, 669.0F);
      ((Path)localObject2).cubicTo(380.0F, 664.60529F, 376.18701F, 661.0F, 372.0F, 661.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.fe
 * JD-Core Version:    0.7.0.1
 */