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

public final class hs
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(16777215);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1.68F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject2 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(20.265253F, 6.581F);
      ((Path)localObject1).lineTo(20.265253F, 6.579F);
      ((Path)localObject1).lineTo(20.265253F, 6.579F);
      ((Path)localObject1).cubicTo(20.195253F, 6.213F, 20.050253F, 5.821F, 19.870253F, 5.5F);
      ((Path)localObject1).cubicTo(19.680252F, 5.171F, 19.435253F, 4.873F, 19.143253F, 4.62F);
      ((Path)localObject1).lineTo(19.143253F, 4.62F);
      ((Path)localObject1).lineTo(19.142254F, 4.62F);
      ((Path)localObject1).cubicTo(16.892254F, 2.671F, 14.291253F, 1.171F, 11.478253F, 0.199F);
      ((Path)localObject1).cubicTo(11.478253F, 0.199F, 11.477253F, 0.198F, 11.476253F, 0.198F);
      ((Path)localObject1).cubicTo(11.124253F, 0.077F, 10.712253F, 0.005F, 10.345253F, 0.0F);
      ((Path)localObject1).cubicTo(9.964253F, 0.0F, 9.583253F, 0.064F, 9.219253F, 0.19F);
      ((Path)localObject1).cubicTo(9.219253F, 0.19F, 9.218253F, 0.19F, 9.218253F, 0.191F);
      ((Path)localObject1).lineTo(9.217253F, 0.191F);
      ((Path)localObject1).cubicTo(6.406253F, 1.165F, 3.806253F, 2.668F, 1.557253F, 4.618F);
      ((Path)localObject1).cubicTo(1.557253F, 4.618F, 1.556253F, 4.619F, 1.556253F, 4.619F);
      ((Path)localObject1).lineTo(1.556253F, 4.62F);
      ((Path)localObject1).cubicTo(1.275253F, 4.863F, 1.006253F, 5.184F, 0.819253F, 5.5F);
      ((Path)localObject1).cubicTo(0.628253F, 5.83F, 0.494253F, 6.191F, 0.420253F, 6.57F);
      ((Path)localObject1).lineTo(0.420253F, 6.571F);
      ((Path)localObject1).lineTo(0.420253F, 6.572F);
      ((Path)localObject1).cubicTo(-0.141747F, 9.494F, -0.139747F, 12.497F, 0.424253F, 15.419F);
      ((Path)localObject1).lineTo(0.424253F, 15.421F);
      ((Path)localObject1).lineTo(0.424253F, 15.421F);
      ((Path)localObject1).cubicTo(0.495253F, 15.787F, 0.639253F, 16.179001F, 0.819253F, 16.5F);
      ((Path)localObject1).cubicTo(1.009253F, 16.83F, 1.254253F, 17.127001F, 1.546253F, 17.379999F);
      ((Path)localObject1).lineTo(1.547253F, 17.379999F);
      ((Path)localObject1).lineTo(1.547253F, 17.381001F);
      ((Path)localObject1).cubicTo(3.797253F, 19.329F, 6.399253F, 20.829F, 9.211253F, 21.801001F);
      ((Path)localObject1).cubicTo(9.212253F, 21.801001F, 9.212253F, 21.802F, 9.213253F, 21.802F);
      ((Path)localObject1).cubicTo(9.566253F, 21.923F, 9.977253F, 21.995001F, 10.345253F, 22.0F);
      ((Path)localObject1).cubicTo(10.725253F, 21.999001F, 11.106253F, 21.936001F, 11.470253F, 21.809999F);
      ((Path)localObject1).lineTo(11.471253F, 21.809999F);
      ((Path)localObject1).cubicTo(11.471253F, 21.809F, 11.471253F, 21.809F, 11.472253F, 21.809F);
      ((Path)localObject1).cubicTo(14.284253F, 20.834F, 16.884253F, 19.332001F, 19.132254F, 17.382F);
      ((Path)localObject1).cubicTo(19.132254F, 17.382F, 19.133253F, 17.381001F, 19.133253F, 17.381001F);
      ((Path)localObject1).lineTo(19.134253F, 17.381001F);
      ((Path)localObject1).cubicTo(19.415253F, 17.136999F, 19.683252F, 16.816F, 19.870253F, 16.5F);
      ((Path)localObject1).cubicTo(20.061253F, 16.17F, 20.196253F, 15.809F, 20.269253F, 15.43F);
      ((Path)localObject1).lineTo(20.269253F, 15.429F);
      ((Path)localObject1).lineTo(20.269253F, 15.429F);
      ((Path)localObject1).cubicTo(20.831253F, 12.506F, 20.830254F, 9.503F, 20.265253F, 6.581F);
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(5.103153F, 17.0F);
      ((Path)localObject2).lineTo(6.419153F, 17.0F);
      ((Path)localObject2).lineTo(6.419153F, 8.238F);
      ((Path)localObject2).cubicTo(6.827153F, 7.338F, 7.179153F, 6.371F, 7.518153F, 5.336F);
      ((Path)localObject2).lineTo(6.107153F, 5.0F);
      ((Path)localObject2).cubicTo(5.564153F, 7.002F, 4.221153F, 9.515F, 3.285153F, 10.792F);
      ((Path)localObject2).lineTo(4.113153F, 12.001F);
      ((Path)localObject2).cubicTo(4.465153F, 11.558F, 4.804153F, 11.114F, 5.103153F, 10.657F);
      ((Path)localObject2).lineTo(5.103153F, 17.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(15.076653F, 5.4974F);
      ((Path)localObject1).lineTo(15.076653F, 9.9854F);
      ((Path)localObject1).lineTo(12.173653F, 9.9854F);
      ((Path)localObject1).lineTo(12.173653F, 11.1544F);
      ((Path)localObject1).lineTo(15.836653F, 11.1544F);
      ((Path)localObject1).lineTo(15.836653F, 12.3774F);
      ((Path)localObject1).lineTo(12.579653F, 12.3774F);
      ((Path)localObject1).cubicTo(13.462653F, 13.4794F, 14.655653F, 14.3664F, 16.284653F, 15.1454F);
      ((Path)localObject1).lineTo(16.284653F, 15.1454F);
      ((Path)localObject1).lineTo(15.538653F, 16.4084F);
      ((Path)localObject1).cubicTo(14.249653F, 15.5884F, 13.082653F, 14.5414F, 12.173653F, 13.3854F);
      ((Path)localObject1).lineTo(12.173653F, 13.3854F);
      ((Path)localObject1).lineTo(12.173653F, 16.9594F);
      ((Path)localObject1).lineTo(10.856653F, 16.9594F);
      ((Path)localObject1).lineTo(10.856653F, 13.3584F);
      ((Path)localObject1).cubicTo(9.987653F, 14.5674F, 8.942653F, 15.4684F, 7.273653F, 16.516399F);
      ((Path)localObject1).lineTo(7.273653F, 16.516399F);
      ((Path)localObject1).lineTo(6.486653F, 15.3064F);
      ((Path)localObject1).cubicTo(8.346653F, 14.4064F, 9.391653F, 13.5604F, 10.259653F, 12.3774F);
      ((Path)localObject1).lineTo(10.259653F, 12.3774F);
      ((Path)localObject1).lineTo(7.220653F, 12.3774F);
      ((Path)localObject1).lineTo(7.220653F, 11.1544F);
      ((Path)localObject1).lineTo(10.856653F, 11.1544F);
      ((Path)localObject1).lineTo(10.856653F, 9.9854F);
      ((Path)localObject1).lineTo(7.952653F, 9.9854F);
      ((Path)localObject1).lineTo(7.952653F, 5.4974F);
      ((Path)localObject1).lineTo(15.076653F, 5.4974F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(13.678753F, 6.787F);
      ((Path)localObject1).lineTo(9.349753F, 6.787F);
      ((Path)localObject1).lineTo(9.349753F, 8.695F);
      ((Path)localObject1).lineTo(13.678753F, 8.695F);
      ((Path)localObject1).lineTo(13.678753F, 6.787F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.hs
 * JD-Core Version:    0.7.0.1
 */