package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class akw
  extends c
{
  private final int height = 270;
  private final int width = 270;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 270;
      return 270;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-2206378);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(132.38F, 0.0F);
      ((Path)localObject).lineTo(139.11F, 0.0F);
      ((Path)localObject).cubicTo(170.03F, 0.97F, 200.5F, 12.81F, 223.73F, 33.290001F);
      ((Path)localObject).cubicTo(252.25F, 57.880001F, 269.48001F, 94.879997F, 270.0F, 132.53F);
      ((Path)localObject).lineTo(270.0F, 137.41F);
      ((Path)localObject).cubicTo(269.51001F, 169.64999F, 256.95001F, 201.48F, 235.3F, 225.36F);
      ((Path)localObject).cubicTo(210.50999F, 253.12F, 173.83F, 269.76999F, 136.59F, 270.0F);
      ((Path)localObject).lineTo(131.83F, 270.0F);
      ((Path)localObject).cubicTo(100.09F, 269.31F, 68.800003F, 256.98999F, 45.18F, 235.78F);
      ((Path)localObject).cubicTo(17.51F, 211.35001F, 0.78F, 175.17999F, 0.0F, 138.28F);
      ((Path)localObject).lineTo(0.0F, 132.60001F);
      ((Path)localObject).cubicTo(0.51F, 95.160004F, 17.51F, 58.349998F, 45.740002F, 33.75F);
      ((Path)localObject).cubicTo(69.410004F, 12.69F, 100.71F, 0.55F, 132.38F, 0.0F);
      ((Path)localObject).lineTo(132.38F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(129.28561F, 66.398506F);
      ((Path)localObject).cubicTo(127.90993F, 67.027992F, 128.00961F, 68.716606F, 128.00961F, 69.975571F);
      ((Path)localObject).cubicTo(128.0495F, 101.33981F, 127.98969F, 132.69405F, 128.02956F, 164.05827F);
      ((Path)localObject).cubicTo(127.83018F, 165.34721F, 128.65758F, 166.64615F, 129.96349F, 166.88596F);
      ((Path)localObject).cubicTo(133.33289F, 167.07581F, 136.72224F, 166.97588F, 140.09164F, 166.9559F);
      ((Path)localObject).cubicTo(141.71654F, 167.17572F, 143.26169F, 165.72691F, 142.96263F, 164.05827F);
      ((Path)localObject).cubicTo(142.98256F, 132.36432F, 142.9726F, 100.67036F, 142.96263F, 68.9664F);
      ((Path)localObject).cubicTo(143.24174F, 67.277786F, 141.6667F, 65.818985F, 140.0119F, 66.078773F);
      ((Path)localObject).cubicTo(136.45308F, 66.198669F, 132.77464F, 65.659119F, 129.28561F, 66.398506F);
      ((Path)localObject).lineTo(129.28561F, 66.398506F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(132.43211F, 189.68253F);
      ((Path)localObject).cubicTo(127.1088F, 191.74556F, 126.39702F, 199.80829F, 131.29929F, 202.72841F);
      ((Path)localObject).cubicTo(135.77048F, 206.00732F, 142.81812F, 202.52908F, 142.95847F, 197.03766F);
      ((Path)localObject).cubicTo(143.56999F, 191.69572F, 137.30431F, 187.25075F, 132.43211F, 189.68253F);
      ((Path)localObject).lineTo(132.43211F, 189.68253F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.akw
 * JD-Core Version:    0.7.0.1
 */