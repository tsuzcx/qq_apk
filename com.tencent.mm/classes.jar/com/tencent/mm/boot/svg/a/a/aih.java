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

public final class aih
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 33.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(49.36591F, 13.591381F);
      ((Path)localObject2).cubicTo(61.974216F, 5.669526F, 76.437859F, -0.0890914F, 91.509972F, 0.001043491F);
      ((Path)localObject2).cubicTo(106.56214F, -0.07907641F, 121.00583F, 5.659512F, 133.60416F, 13.571351F);
      ((Path)localObject2).cubicTo(153.29466F, 26.320431F, 169.71339F, 43.736492F, 183.0F, 63.005329F);
      ((Path)localObject2).cubicTo(172.90538F, 77.80748F, 160.79581F, 91.267624F, 147.01047F, 102.70474F);
      ((Path)localObject2).cubicTo(134.60165F, 112.81988F, 120.39736F, 121.36266F, 104.59708F, 124.65759F);
      ((Path)localObject2).cubicTo(91.180801F, 127.50185F, 76.96653F, 125.72919F, 64.428047F, 120.26101F);
      ((Path)localObject2).cubicTo(49.924507F, 114.28207F, 37.306225F, 104.55751F, 25.984684F, 93.801414F);
      ((Path)localObject2).cubicTo(16.33893F, 84.437401F, 7.551019F, 74.141998F, 0.0F, 63.005329F);
      ((Path)localObject2).cubicTo(13.276628F, 43.74651F, 29.685381F, 26.34046F, 49.36591F, 13.591381F);
      ((Path)localObject2).lineTo(49.36591F, 13.591381F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(57.922127F, 11.815232F);
      ((Path)localObject2).cubicTo(35.62434F, 23.804834F, 17.612675F, 42.54858F, 3.0F, 63.000843F);
      ((Path)localObject2).cubicTo(14.612391F, 79.446579F, 28.55723F, 94.373634F, 44.894318F, 106.1734F);
      ((Path)localObject2).cubicTo(58.619869F, 115.88498F, 74.817406F, 123.32853F, 91.931984F, 122.98882F);
      ((Path)localObject2).cubicTo(109.36552F, 122.76901F, 125.62287F, 114.69601F, 139.39825F, 104.52483F);
      ((Path)localObject2).cubicTo(154.72861F, 92.954865F, 167.9458F, 78.697235F, 179.0F, 63.000843F);
      ((Path)localObject2).cubicTo(173.14896F, 54.608124F, 166.59019F, 46.724957F, 159.51311F, 39.341362F);
      ((Path)localObject2).cubicTo(144.49176F, 23.974688F, 126.72929F, 9.996809F, 105.53792F, 4.731375F);
      ((Path)localObject2).cubicTo(89.469955F, 0.6549106F, 72.345413F, 4.081939F, 57.922127F, 11.815232F);
      ((Path)localObject2).lineTo(57.922127F, 11.815232F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(80.946098F, 13.323944F);
      ((Path)localObject2).cubicTo(92.338326F, 10.649595F, 104.67323F, 12.046642F, 115.12279F, 17.335466F);
      ((Path)localObject2).cubicTo(127.67831F, 23.572289F, 137.33563F, 35.23764F, 141.08624F, 48.689217F);
      ((Path)localObject2).cubicTo(144.47583F, 60.564121F, 143.34262F, 73.666435F, 137.84708F, 84.753014F);
      ((Path)localObject2).cubicTo(132.13091F, 96.488213F, 121.66129F, 105.83846F, 109.27625F, 110.14935F);
      ((Path)localObject2).cubicTo(96.800957F, 114.57999F, 82.560669F, 113.82159F, 70.65699F, 108.04379F);
      ((Path)localObject2).cubicTo(59.074226F, 102.53544F, 49.787952F, 92.426796F, 45.285217F, 80.462074F);
      ((Path)localObject2).cubicTo(40.240944F, 67.339806F, 41.033188F, 52.111984F, 47.471401F, 39.598423F);
      ((Path)localObject2).cubicTo(54.050011F, 26.526047F, 66.615562F, 16.607006F, 80.946098F, 13.323944F);
      ((Path)localObject2).lineTo(80.946098F, 13.323944F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(84.991241F, 15.594493F);
      ((Path)localObject2).cubicTo(74.173866F, 17.275282F, 64.046333F, 22.894487F, 56.858078F, 31.109468F);
      ((Path)localObject2).cubicTo(48.590088F, 40.398563F, 44.271141F, 53.019402F, 45.100937F, 65.401543F);
      ((Path)localObject2).cubicTo(45.830761F, 79.146225F, 52.999016F, 92.363792F, 64.106316F, 100.56882F);
      ((Path)localObject2).cubicTo(74.063896F, 108.08762F, 87.110725F, 111.35969F, 99.477715F, 109.47999F);
      ((Path)localObject2).cubicTo(111.90469F, 107.70969F, 123.43189F, 100.70806F, 130.7901F, 90.603439F);
      ((Path)localObject2).cubicTo(138.1983F, 80.628105F, 141.34753F, 67.698952F, 139.468F, 55.456047F);
      ((Path)localObject2).cubicTo(137.52847F, 41.771042F, 129.16051F, 29.180042F, 117.29339F, 21.989449F);
      ((Path)localObject2).cubicTo(107.7657F, 16.091768F, 96.06855F, 13.804303F, 84.991241F, 15.594493F);
      ((Path)localObject2).lineTo(84.991241F, 15.594493F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(66.0F, 38.391891F);
      ((Path)localObject2).cubicTo(71.673454F, 32.422298F, 79.131699F, 28.155405F, 87.267967F, 27.0F);
      ((Path)localObject2).cubicTo(88.195267F, 32.391891F, 89.102615F, 37.793919F, 90.0F, 43.18581F);
      ((Path)localObject2).cubicTo(86.051514F, 44.949326F, 82.561699F, 47.635136F, 79.799751F, 51.0F);
      ((Path)localObject2).cubicTo(75.203156F, 46.793919F, 70.596596F, 42.597973F, 66.0F, 38.391891F);
      ((Path)localObject2).lineTo(66.0F, 38.391891F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(57.91275F, 51.0F);
      ((Path)localObject1).cubicTo(63.611771F, 53.416126F, 69.310791F, 55.832253F, 75.0F, 58.268768F);
      ((Path)localObject1).cubicTo(74.6763F, 59.512512F, 74.352608F, 60.756256F, 74.028908F, 62.0F);
      ((Path)localObject1).cubicTo(68.016006F, 61.592216F, 62.003098F, 61.184429F, 56.0F, 60.786839F);
      ((Path)localObject1).cubicTo(56.313889F, 57.46339F, 56.941662F, 54.180721F, 57.91275F, 51.0F);
      ((Path)localObject1).lineTo(57.91275F, 51.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aih
 * JD-Core Version:    0.7.0.1
 */