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

public final class so
  extends c
{
  private final int height = 292;
  private final int width = 378;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 378;
      return 292;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13092808);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(371.0F, 234.00101F);
      localPath.cubicTo(371.0F, 240.06599F, 366.06299F, 245.00101F, 359.99301F, 245.00101F);
      localPath.lineTo(14.007F, 245.00101F);
      localPath.cubicTo(7.938F, 245.00101F, 3.0F, 240.06599F, 3.0F, 234.00101F);
      localPath.lineTo(3.0F, 14.0F);
      localPath.cubicTo(3.0F, 7.935F, 7.938F, 3.001F, 14.007F, 3.001F);
      localPath.lineTo(359.99301F, 3.001F);
      localPath.cubicTo(366.06299F, 3.001F, 371.0F, 7.935F, 371.0F, 14.0F);
      localPath.lineTo(371.0F, 234.00101F);
      localPath.lineTo(371.0F, 234.00101F);
      localPath.close();
      localPath.moveTo(359.99301F, 0.0F);
      localPath.lineTo(14.007F, 0.0F);
      localPath.cubicTo(6.276F, 0.0F, 0.0F, 6.268F, 0.0F, 14.0F);
      localPath.lineTo(0.0F, 234.00101F);
      localPath.cubicTo(0.0F, 241.73F, 6.271F, 248.0F, 14.007F, 248.0F);
      localPath.lineTo(359.99301F, 248.0F);
      localPath.cubicTo(367.724F, 248.0F, 374.0F, 241.733F, 374.0F, 234.00101F);
      localPath.lineTo(374.0F, 14.0F);
      localPath.cubicTo(374.0F, 6.27F, 367.729F, 0.0F, 359.99301F, 0.0F);
      localPath.lineTo(359.99301F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13092808);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(241.0F, 286.00009F);
      localPath.lineTo(132.0F, 286.00009F);
      localPath.lineTo(132.0F, 284.50409F);
      localPath.lineTo(153.71201F, 280.55609F);
      localPath.lineTo(157.658F, 248.00011F);
      localPath.lineTo(215.342F, 248.00011F);
      localPath.lineTo(219.28799F, 280.55609F);
      localPath.lineTo(241.0F, 284.50409F);
      localPath.lineTo(241.0F, 286.00009F);
      localPath.close();
      localPath.moveTo(218.0F, 245.00011F);
      localPath.lineTo(155.0F, 245.00011F);
      localPath.lineTo(151.0F, 278.00009F);
      localPath.lineTo(129.0F, 282.00009F);
      localPath.lineTo(129.0F, 289.00009F);
      localPath.lineTo(244.0F, 289.00009F);
      localPath.lineTo(244.0F, 282.00009F);
      localPath.lineTo(222.0F, 278.00009F);
      localPath.lineTo(218.0F, 245.00011F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13092808);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(2.0F, 199.0F);
      localPath.lineTo(374.0F, 199.0F);
      localPath.lineTo(374.0F, 196.0F);
      localPath.lineTo(2.0F, 196.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-13158344);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 164.0F, 0.0F, 1.0F, 86.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(43.0895F, 21.969101F);
      ((Path)localObject3).lineTo(43.0895F, 49.967098F);
      ((Path)localObject3).lineTo(3.0895F, 49.965099F);
      ((Path)localObject3).lineTo(3.0895F, 21.969101F);
      ((Path)localObject3).lineTo(3.0905F, 21.9671F);
      ((Path)localObject3).lineTo(8.9995F, 21.9671F);
      ((Path)localObject3).lineTo(8.9995F, 18.9671F);
      ((Path)localObject3).lineTo(3.0905F, 18.9671F);
      ((Path)localObject3).cubicTo(1.4415F, 18.9671F, 0.0895F, 20.3111F, 0.0895F, 21.969101F);
      ((Path)localObject3).lineTo(0.0895F, 49.965099F);
      ((Path)localObject3).cubicTo(0.0895F, 51.6241F, 1.4335F, 52.967098F, 3.0905F, 52.967098F);
      ((Path)localObject3).lineTo(43.0895F, 52.967098F);
      ((Path)localObject3).cubicTo(44.738499F, 52.967098F, 46.0895F, 51.6231F, 46.0895F, 49.965099F);
      ((Path)localObject3).lineTo(46.0895F, 21.969101F);
      ((Path)localObject3).cubicTo(46.0895F, 20.310101F, 44.746498F, 18.9671F, 43.0895F, 18.9671F);
      ((Path)localObject3).lineTo(36.9995F, 18.9671F);
      ((Path)localObject3).lineTo(36.9995F, 21.969101F);
      ((Path)localObject3).lineTo(43.0895F, 21.969101F);
      ((Path)localObject3).lineTo(43.0895F, 21.969101F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(12.0F, 19.0F);
      ((Path)localObject3).lineTo(34.0F, 19.0F);
      ((Path)localObject3).lineTo(34.0F, 18.966999F);
      ((Path)localObject3).lineTo(12.0F, 18.966999F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(9.0F, 13.4978F);
      ((Path)localObject3).lineTo(9.0F, 18.966801F);
      ((Path)localObject3).lineTo(12.0F, 18.966801F);
      ((Path)localObject3).lineTo(12.0F, 13.4978F);
      ((Path)localObject3).cubicTo(12.0F, 7.7088F, 16.714001F, 3.0008F, 22.507999F, 3.0008F);
      ((Path)localObject3).lineTo(23.492001F, 3.0008F);
      ((Path)localObject3).cubicTo(29.285999F, 3.0008F, 34.0F, 7.7088F, 34.0F, 13.4978F);
      ((Path)localObject3).lineTo(34.0F, 18.966801F);
      ((Path)localObject3).lineTo(37.0F, 18.966801F);
      ((Path)localObject3).lineTo(37.0F, 13.4978F);
      ((Path)localObject3).cubicTo(37.0F, 6.0438F, 30.952F, -0.0002F, 23.492001F, -0.0002F);
      ((Path)localObject3).lineTo(22.507999F, -0.0002F);
      ((Path)localObject3).cubicTo(15.041F, -0.0002F, 9.0F, 6.0428F, 9.0F, 13.4978F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(37.0F, 22.0F);
      ((Path)localObject3).lineTo(37.0F, 21.969F);
      ((Path)localObject3).lineTo(9.0F, 21.966999F);
      ((Path)localObject3).lineTo(9.0F, 22.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(33.999699F, 19.000299F);
      ((Path)localObject2).lineTo(11.9997F, 19.000299F);
      ((Path)localObject2).lineTo(11.9997F, 18.9673F);
      ((Path)localObject2).lineTo(8.9997F, 18.9673F);
      ((Path)localObject2).lineTo(8.9997F, 21.9673F);
      ((Path)localObject2).lineTo(36.999699F, 21.9683F);
      ((Path)localObject2).lineTo(36.999699F, 18.9673F);
      ((Path)localObject2).lineTo(33.999699F, 18.9673F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.so
 * JD-Core Version:    0.7.0.1
 */