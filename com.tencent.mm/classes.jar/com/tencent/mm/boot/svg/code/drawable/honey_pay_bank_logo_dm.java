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

public class honey_pay_bank_logo_dm
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, -43.0F, 0.0F, 1.0F, -19.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 43.0F, 0.0F, 1.0F, 19.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPaint.setColor(-3367936);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(20.0F, 0.0F);
      localPath.cubicTo(31.045696F, 0.0F, 40.0F, 8.954305F, 40.0F, 20.0F);
      localPath.cubicTo(40.0F, 31.045696F, 31.045696F, 40.0F, 20.0F, 40.0F);
      localPath.cubicTo(8.954305F, 40.0F, 0.0F, 31.045696F, 0.0F, 20.0F);
      localPath.cubicTo(0.0F, 8.954305F, 8.954305F, 0.0F, 20.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.saveLayerAlpha(null, 204, 31);
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(25.152039F, 15.990615F);
      ((Path)localObject3).cubicTo(27.422239F, 12.216314F, 27.87678F, 8.533018F, 26.107307F, 6.763546F);
      ((Path)localObject3).cubicTo(24.653276F, 5.309515F, 21.813135F, 5.310855F, 18.534306F, 6.836318F);
      ((Path)localObject3).cubicTo(18.133711F, 7.022693F, 17.657879F, 6.849034F, 17.471502F, 6.448439F);
      ((Path)localObject3).cubicTo(17.285128F, 6.047844F, 17.458788F, 5.572012F, 17.859383F, 5.385636F);
      ((Path)localObject3).cubicTo(21.680468F, 3.607891F, 25.212727F, 3.606223F, 27.238678F, 5.632175F);
      ((Path)localObject3).cubicTo(29.696928F, 8.090425F, 29.118807F, 12.688654F, 26.316029F, 17.154604F);
      ((Path)localObject3).lineTo(27.95405F, 18.792625F);
      ((Path)localObject3).cubicTo(28.526819F, 19.365395F, 28.526819F, 20.294037F, 27.95405F, 20.866806F);
      ((Path)localObject3).lineTo(20.60014F, 28.220716F);
      ((Path)localObject3).cubicTo(20.02737F, 28.793486F, 19.098728F, 28.793486F, 18.525959F, 28.220716F);
      ((Path)localObject3).lineTo(16.315575F, 26.01033F);
      ((Path)localObject3).cubicTo(12.692017F, 27.609785F, 9.258259F, 27.62686F, 7.251127F, 25.619726F);
      ((Path)localObject3).cubicTo(5.847475F, 24.216076F, 5.407673F, 22.073048F, 5.889585F, 19.581261F);
      ((Path)localObject3).cubicTo(5.97348F, 19.14747F, 6.393147F, 18.863825F, 6.826936F, 18.94772F);
      ((Path)localObject3).cubicTo(7.260726F, 19.031614F, 7.544371F, 19.451281F, 7.460476F, 19.885071F);
      ((Path)localObject3).cubicTo(7.071023F, 21.898788F, 7.401048F, 23.506907F, 8.382498F, 24.488356F);
      ((Path)localObject3).cubicTo(9.753119F, 25.858976F, 12.272025F, 25.895203F, 15.092057F, 24.786814F);
      ((Path)localObject3).lineTo(3.629577F, 13.324334F);
      ((Path)localObject3).cubicTo(3.056808F, 12.751565F, 3.056808F, 11.822923F, 3.629577F, 11.250154F);
      ((Path)localObject3).lineTo(10.983487F, 3.896243F);
      ((Path)localObject3).cubicTo(11.556256F, 3.323474F, 12.484899F, 3.323474F, 13.057667F, 3.896243F);
      ((Path)localObject3).lineTo(25.152039F, 15.990615F);
      ((Path)localObject3).lineTo(25.152039F, 15.990615F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(24.253609F, 17.354927F);
      ((Path)localObject3).lineTo(12.020577F, 5.121895F);
      ((Path)localObject3).lineTo(4.855228F, 12.287244F);
      ((Path)localObject3).lineTo(16.643747F, 24.075762F);
      ((Path)localObject3).cubicTo(18.378481F, 23.169596F, 20.166201F, 21.86643F, 21.82579F, 20.206841F);
      ((Path)localObject3).cubicTo(22.747261F, 19.28537F, 23.558849F, 18.324398F, 24.253609F, 17.354927F);
      ((Path)localObject3).lineTo(24.253609F, 17.354927F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(25.399769F, 18.501087F);
      ((Path)localObject3).cubicTo(24.686337F, 19.472351F, 23.869255F, 20.426117F, 22.957163F, 21.338211F);
      ((Path)localObject3).cubicTo(21.333265F, 22.962107F, 19.577274F, 24.284828F, 17.825621F, 25.257637F);
      ((Path)localObject3).lineTo(19.563049F, 26.995066F);
      ((Path)localObject3).lineTo(26.728397F, 19.829716F);
      ((Path)localObject3).lineTo(25.399769F, 18.501087F);
      ((Path)localObject3).lineTo(25.399769F, 18.501087F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-2565928);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(32.0F, 0.0F);
      ((Path)localObject2).lineTo(32.0F, 32.0F);
      ((Path)localObject2).lineTo(0.0F, 32.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject2, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(43.0F, 19.0F);
      ((Path)localObject1).lineTo(83.0F, 19.0F);
      ((Path)localObject1).lineTo(83.0F, 59.0F);
      ((Path)localObject1).lineTo(43.0F, 59.0F);
      ((Path)localObject1).lineTo(43.0F, 19.0F);
      ((Path)localObject1).close();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.honey_pay_bank_logo_dm
 * JD-Core Version:    0.7.0.1
 */