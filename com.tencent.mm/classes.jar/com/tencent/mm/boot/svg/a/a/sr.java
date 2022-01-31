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

public final class sr
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
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.k(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-14187817);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(192.0F, 0.0F);
      localPath.lineTo(192.0F, 192.0F);
      localPath.lineTo(0.0F, 192.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(9.0F);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(67.522949F, 44.723057F);
      ((Path)localObject2).cubicTo(62.305767F, 46.1451F, 59.208679F, 51.596455F, 60.603512F, 56.891788F);
      ((Path)localObject2).lineTo(84.891624F, 149.09908F);
      ((Path)localObject2).cubicTo(86.2873F, 154.39764F, 91.612236F, 157.54996F, 96.865273F, 156.11813F);
      ((Path)localObject2).lineTo(143.41838F, 143.4292F);
      ((Path)localObject2).cubicTo(148.63556F, 142.00716F, 151.73265F, 136.5558F, 150.33781F, 131.26047F);
      ((Path)localObject2).lineTo(126.04971F, 39.053181F);
      ((Path)localObject2).cubicTo(124.65403F, 33.75462F, 119.32909F, 30.602308F, 114.07606F, 32.034122F);
      ((Path)localObject2).lineTo(67.522949F, 44.723057F);
      ((Path)localObject2).lineTo(67.522949F, 44.723057F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(91.679192F, 139.06816F);
      ((Path)localObject2).cubicTo(87.208977F, 140.27698F, 84.561287F, 144.93335F, 85.759941F, 149.44794F);
      ((Path)localObject2).lineTo(85.759941F, 149.44794F);
      ((Path)localObject2).cubicTo(86.961037F, 153.97171F, 91.582977F, 156.65242F, 96.028748F, 155.45023F);
      ((Path)localObject2).lineTo(144.26404F, 142.40675F);
      ((Path)localObject2).cubicTo(148.73424F, 141.19795F, 151.38194F, 136.54156F, 150.18329F, 132.02698F);
      ((Path)localObject2).lineTo(150.18329F, 132.02698F);
      ((Path)localObject2).cubicTo(148.98219F, 127.5032F, 144.36024F, 124.82249F, 139.91447F, 126.02469F);
      ((Path)localObject2).lineTo(91.679192F, 139.06816F);
      ((Path)localObject2).lineTo(91.679192F, 139.06816F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(57.190487F, 71.99279F);
      ((Path)localObject1).cubicTo(60.604698F, 68.447227F, 62.616844F, 66.206894F, 72.687363F, 66.206894F);
      ((Path)localObject1).cubicTo(82.757881F, 66.206894F, 95.241699F, 77.259491F, 95.241699F, 77.259491F);
      ((Path)localObject1).cubicTo(95.241699F, 77.259491F, 94.297516F, 83.836327F, 87.078506F, 85.587891F);
      ((Path)localObject1).cubicTo(79.862297F, 87.342278F, 68.707642F, 84.29969F, 68.707642F, 84.29969F);
      ((Path)localObject1).lineTo(82.757889F, 139.6217F);
      ((Path)localObject1).cubicTo(82.757889F, 139.6217F, 63.393841F, 167.91832F, 54.868153F, 159.99243F);
      ((Path)localObject1).cubicTo(49.846596F, 155.32349F, 41.53447F, 148.98222F, 34.635799F, 142.95221F);
      ((Path)localObject1).cubicTo(30.892817F, 139.68112F, 29.366961F, 136.37608F, 33.877087F, 132.99181F);
      ((Path)localObject1).cubicTo(42.397156F, 126.60526F, 59.479103F, 112.16973F, 59.793831F, 108.07238F);
      ((Path)localObject1).cubicTo(60.243439F, 102.27158F, 53.413784F, 95.405411F, 53.413784F, 88.684967F);
      ((Path)localObject1).cubicTo(53.413784F, 81.927734F, 53.773468F, 75.538361F, 57.190487F, 71.99279F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(123.78036F, 62.377579F);
      ((Path)localObject1).cubicTo(120.0429F, 63.379025F, 117.82778F, 67.231308F, 118.82819F, 70.964882F);
      ((Path)localObject1).cubicTo(119.83064F, 74.706078F, 123.67509F, 76.926544F, 127.41055F, 75.925629F);
      ((Path)localObject1).lineTo(141.11108F, 72.254578F);
      ((Path)localObject1).cubicTo(144.84854F, 71.253136F, 147.06366F, 67.400848F, 146.06325F, 63.667274F);
      ((Path)localObject1).cubicTo(145.06081F, 59.926083F, 141.21635F, 57.705616F, 137.4809F, 58.706528F);
      ((Path)localObject1).lineTo(123.78036F, 62.377579F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(127.41055F, 75.925629F);
      ((Path)localObject1).cubicTo(123.67309F, 76.927078F, 121.45798F, 80.779358F, 122.45838F, 84.512932F);
      ((Path)localObject1).cubicTo(123.46083F, 88.254128F, 127.30527F, 90.474594F, 131.04073F, 89.473679F);
      ((Path)localObject1).lineTo(144.74127F, 85.802628F);
      ((Path)localObject1).cubicTo(148.47873F, 84.801186F, 150.69385F, 80.948906F, 149.69344F, 77.215324F);
      ((Path)localObject1).cubicTo(148.69099F, 73.474136F, 144.84654F, 71.25367F, 141.11108F, 72.254578F);
      ((Path)localObject1).lineTo(127.41055F, 75.925629F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(131.04073F, 89.473679F);
      ((Path)localObject1).cubicTo(127.30328F, 90.475128F, 125.08817F, 94.327408F, 126.08857F, 98.060989F);
      ((Path)localObject1).cubicTo(127.09102F, 101.80218F, 130.93547F, 104.02264F, 134.67091F, 103.02173F);
      ((Path)localObject1).lineTo(148.37148F, 99.350677F);
      ((Path)localObject1).cubicTo(152.10892F, 98.349236F, 154.32404F, 94.496956F, 153.32362F, 90.763374F);
      ((Path)localObject1).cubicTo(152.32118F, 87.022186F, 148.47673F, 84.80172F, 144.74127F, 85.802628F);
      ((Path)localObject1).lineTo(131.04073F, 89.473679F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(140.12512F, 101.56028F);
      ((Path)localObject1).cubicTo(136.3837F, 102.5628F, 134.16536F, 106.41594F, 135.16577F, 110.14951F);
      ((Path)localObject1).cubicTo(136.16823F, 113.8907F, 140.01041F, 116.11178F, 143.75531F, 115.10834F);
      ((Path)localObject1).lineTo(151.99448F, 112.90066F);
      ((Path)localObject1).cubicTo(155.73589F, 111.89815F, 157.95422F, 108.04501F, 156.95381F, 104.31142F);
      ((Path)localObject1).cubicTo(155.95137F, 100.57024F, 152.10919F, 98.349159F, 148.36429F, 99.352608F);
      ((Path)localObject1).lineTo(140.12512F, 101.56028F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sr
 * JD-Core Version:    0.7.0.1
 */