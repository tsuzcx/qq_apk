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

public final class py
  extends c
{
  private final int height = 39;
  private final int width = 39;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 39;
      return 39;
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
      localCanvas.saveLayerAlpha(null, 128, 31);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-4210753);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -267.0F, 0.0F, 1.0F, -942.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(290.74658F, 962.36731F);
      ((Path)localObject2).lineTo(281.66696F, 950.38226F);
      ((Path)localObject2).cubicTo(281.66696F, 950.38226F, 280.07489F, 947.68597F, 281.897F, 946.12305F);
      ((Path)localObject2).cubicTo(285.00061F, 943.46094F, 288.86172F, 945.61859F, 292.41647F, 942.0F);
      ((Path)localObject2).cubicTo(293.6008F, 943.90704F, 293.0603F, 947.88342F, 290.84427F, 948.85449F);
      ((Path)localObject2).cubicTo(288.6282F, 949.82556F, 285.94733F, 949.91528F, 285.94733F, 949.91528F);
      ((Path)localObject2).lineTo(295.28461F, 966.53125F);
      ((Path)localObject2).lineTo(295.02689F, 966.30566F);
      ((Path)localObject2).cubicTo(295.32394F, 967.01917F, 295.48572F, 967.78772F, 295.48572F, 968.58862F);
      ((Path)localObject2).cubicTo(295.48572F, 972.34052F, 291.93597F, 975.38196F, 287.55713F, 975.38196F);
      ((Path)localObject2).cubicTo(283.17831F, 975.38196F, 279.62857F, 972.34052F, 279.62857F, 968.58862F);
      ((Path)localObject2).cubicTo(279.62857F, 964.83679F, 283.17831F, 961.79529F, 287.55713F, 961.79529F);
      ((Path)localObject2).cubicTo(288.69171F, 961.79529F, 289.77066F, 961.99951F, 290.74658F, 962.36731F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(278.57144F, 946.18054F);
      ((Path)localObject2).lineTo(278.57144F, 948.52997F);
      ((Path)localObject2).cubicTo(273.52835F, 951.29187F, 270.11429F, 956.60687F, 270.11429F, 962.71021F);
      ((Path)localObject2).cubicTo(270.11429F, 971.65698F, 277.45041F, 978.90973F, 286.5F, 978.90973F);
      ((Path)localObject2).cubicTo(295.54959F, 978.90973F, 302.88571F, 971.65698F, 302.88571F, 962.71021F);
      ((Path)localObject2).cubicTo(302.88571F, 957.0437F, 299.94287F, 952.0567F, 295.48572F, 949.16162F);
      ((Path)localObject2).lineTo(295.48572F, 946.71899F);
      ((Path)localObject2).cubicTo(301.1608F, 949.84253F, 305.0F, 955.83313F, 305.0F, 962.71021F);
      ((Path)localObject2).cubicTo(305.0F, 972.8114F, 296.71725F, 981.0F, 286.5F, 981.0F);
      ((Path)localObject2).cubicTo(276.28275F, 981.0F, 268.0F, 972.8114F, 268.0F, 962.71021F);
      ((Path)localObject2).cubicTo(268.0F, 955.41418F, 272.3212F, 949.11597F, 278.57144F, 946.18054F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.py
 * JD-Core Version:    0.7.0.1
 */