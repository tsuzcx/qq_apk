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

public final class ahi
  extends c
{
  private final int height = 93;
  private final int width = 93;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 93;
      return 93;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(79.564964F, 14.00827F);
      localPath.cubicTo(98.378479F, 31.740889F, 98.378479F, 61.25771F, 79.564964F, 78.991447F);
      localPath.cubicTo(61.702847F, 97.669518F, 31.972158F, 97.669518F, 14.110418F, 78.991447F);
      localPath.cubicTo(-4.703473F, 61.25771F, -4.703473F, 31.740889F, 14.110418F, 14.00827F);
      localPath.cubicTo(31.970652F, -4.669423F, 61.702847F, -4.669423F, 79.564964F, 14.00827F);
      localPath.close();
      localPath.moveTo(87.011604F, 47.88731F);
      localPath.cubicTo(87.011604F, 25.044458F, 69.258606F, 7.65122F, 48.775578F, 7.65122F);
      localPath.cubicTo(25.459192F, 7.65122F, 7.707256F, 25.044458F, 7.707256F, 47.88731F);
      localPath.cubicTo(7.707256F, 67.955261F, 25.460253F, 85.348503F, 45.943279F, 85.348503F);
      localPath.cubicTo(69.258606F, 85.348503F, 87.011604F, 67.955261F, 87.011604F, 47.88731F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 23.0F, 0.0F, 1.0F, 29.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(1.020108F, 10.956513F);
      ((Path)localObject2).lineTo(10.898551F, 10.956513F);
      ((Path)localObject2).lineTo(23.47826F, 41.739132F);
      ((Path)localObject2).lineTo(0.6186433F, 11.767624F);
      ((Path)localObject2).cubicTo(0.449533F, 11.545901F, 0.4921835F, 11.229069F, 0.7139061F, 11.059958F);
      ((Path)localObject2).cubicTo(0.801882F, 10.992858F, 0.9094632F, 10.956513F, 1.020108F, 10.956513F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(45.936413F, 10.956513F);
      ((Path)localObject2).lineTo(36.289856F, 10.956513F);
      ((Path)localObject2).lineTo(23.47826F, 41.739132F);
      ((Path)localObject2).lineTo(46.337879F, 11.767624F);
      ((Path)localObject2).cubicTo(46.506989F, 11.545901F, 46.464336F, 11.229069F, 46.242615F, 11.059958F);
      ((Path)localObject2).cubicTo(46.15464F, 10.992858F, 46.047058F, 10.956513F, 45.936413F, 10.956513F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(14.347826F, 10.956513F);
      ((Path)localObject2).lineTo(32.608696F, 10.956513F);
      ((Path)localObject2).lineTo(23.47826F, 41.739132F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(11.146245F, 7.826087F);
      ((Path)localObject2).lineTo(18.26087F, 0.0F);
      ((Path)localObject2).lineTo(10.837229F, -9.992007E-016F);
      ((Path)localObject2).cubicTo(10.729838F, -1.361002E-015F, 10.625245F, 0.03424085F, 10.538644F, 0.09774783F);
      ((Path)localObject2).lineTo(1.243732F, 6.914017F);
      ((Path)localObject2).cubicTo(1.018863F, 7.078921F, 0.9702516F, 7.394894F, 1.135155F, 7.619763F);
      ((Path)localObject2).cubicTo(1.230268F, 7.749461F, 1.381481F, 7.826087F, 1.542316F, 7.826087F);
      ((Path)localObject2).lineTo(11.146245F, 7.826087F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(20.869566F, 0.0F);
      ((Path)localObject2).lineTo(26.086956F, 0.0F);
      ((Path)localObject2).lineTo(32.608696F, 7.826087F);
      ((Path)localObject2).lineTo(14.347826F, 7.826087F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(36.323608F, 7.826087F);
      ((Path)localObject1).lineTo(28.695652F, 0.0F);
      ((Path)localObject1).lineTo(36.386032F, 1.221245E-015F);
      ((Path)localObject1).cubicTo(36.495541F, 1.241362E-015F, 36.602081F, 0.035604F, 36.68959F, 0.1014433F);
      ((Path)localObject1).lineTo(45.749187F, 6.917713F);
      ((Path)localObject1).cubicTo(45.972015F, 7.085364F, 46.016747F, 7.40191F, 45.849094F, 7.624738F);
      ((Path)localObject1).cubicTo(45.753708F, 7.751515F, 45.604282F, 7.826087F, 45.445629F, 7.826087F);
      ((Path)localObject1).lineTo(36.323608F, 7.826087F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahi
 * JD-Core Version:    0.7.0.1
 */