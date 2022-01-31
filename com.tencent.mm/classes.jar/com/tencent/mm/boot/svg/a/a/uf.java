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

public final class uf
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(3.6F);
      arrayOfFloat = c.a(arrayOfFloat, 0.9455186F, 0.3255682F, -10.369054F, -0.3255682F, 0.9455186F, 13.085754F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(36.109615F, 51.832035F);
      localPath.cubicTo(36.478947F, 50.021828F, 36.619179F, 49.59024F, 37.102928F, 48.373779F);
      localPath.cubicTo(37.617302F, 47.080311F, 38.366039F, 45.48333F, 39.349148F, 43.58284F);
      localPath.lineTo(35.897518F, 43.687981F);
      localPath.cubicTo(34.035858F, 43.65715F, 32.764465F, 43.080475F, 31.923151F, 42.549831F);
      localPath.moveTo(15.645319F, 47.33276F);
      localPath.cubicTo(14.195042F, 44.757702F, 14.170011F, 43.34008F, 17.084476F, 40.539848F);
      localPath.cubicTo(19.027452F, 38.673027F, 21.284081F, 36.735832F, 23.854359F, 34.728264F);
      localPath.cubicTo(24.246042F, 34.412579F, 24.686108F, 34.170578F, 25.152336F, 34.002579F);
      localPath.cubicTo(26.48819F, 33.521229F, 27.450783F, 34.054688F, 27.943132F, 35.135555F);
      localPath.cubicTo(27.49523F, 33.246681F, 31.003172F, 32.77779F, 33.043427F, 32.451065F);
      localPath.cubicTo(34.511005F, 32.216049F, 35.256187F, 32.098164F, 39.643166F, 32.160069F);
      localPath.cubicTo(44.030144F, 32.221977F, 52.396873F, 32.851471F, 53.08276F, 42.162327F);
      localPath.cubicTo(53.334805F, 45.583813F, 52.80872F, 50.06321F, 51.504498F, 55.600517F);
      localPath.cubicTo(49.439098F, 63.581837F, 42.106003F, 69.948036F, 31.248415F, 66.420189F);
      localPath.cubicTo(27.615129F, 65.239662F, 22.837711F, 59.587795F, 16.916162F, 49.464581F);
      localPath.cubicTo(16.743603F, 49.211441F, 15.805292F, 47.616802F, 15.645319F, 47.33276F);
      localPath.close();
      localPath.moveTo(28.117203F, 34.050526F);
      localPath.cubicTo(27.943542F, 34.584999F, 27.907475F, 35.209015F, 28.048918F, 35.814758F);
      localPath.lineTo(28.442316F, 37.499512F);
      localPath.cubicTo(28.952667F, 39.685127F, 30.270315F, 41.509167F, 32.035316F, 42.622417F);
      localPath.moveTo(31.690058F, 43.151917F);
      localPath.lineTo(22.775629F, 49.957634F);
      localPath.cubicTo(19.907536F, 51.693661F, 18.071772F, 50.685135F, 16.169781F, 48.138805F);
      localPath.moveTo(26.226873F, 33.055264F);
      localPath.lineTo(19.194607F, 18.607109F);
      localPath.cubicTo(18.382626F, 16.222755F, 19.559271F, 13.596453F, 21.822718F, 12.741097F);
      localPath.cubicTo(24.107006F, 11.882895F, 26.174154F, 13.016047F, 27.450985F, 15.504925F);
      localPath.lineTo(32.419773F, 24.335133F);
      localPath.cubicTo(33.146152F, 25.473629F, 34.188427F, 26.598293F, 35.928833F, 26.323759F);
      localPath.cubicTo(37.669239F, 26.049223F, 38.702583F, 25.042978F, 38.702583F, 23.456533F);
      localPath.lineTo(38.487099F, 12.351198F);
      localPath.cubicTo(38.487099F, 10.094774F, 39.539852F, 8.173945F, 41.852806F, 7.715035F);
      localPath.cubicTo(41.938004F, 7.698131F, 42.02367F, 7.68397F, 42.109692F, 7.67257F);
      localPath.cubicTo(44.642258F, 7.33696F, 46.990551F, 9.119869F, 47.489254F, 11.756927F);
      localPath.lineTo(49.095047F, 34.196342F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 24.052986F, 0.7071068F, 0.7071068F, -35.269047F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(54.600002F, 14.228428F);
      ((Path)localObject).lineTo(50.775883F, 16.24984F);
      ((Path)localObject).cubicTo(50.405285F, 16.445734F, 49.946056F, 16.304111F, 49.75016F, 15.933517F);
      ((Path)localObject).cubicTo(49.632858F, 15.711599F, 49.632858F, 15.446037F, 49.75016F, 15.224119F);
      ((Path)localObject).lineTo(51.771572F, 11.400001F);
      ((Path)localObject).lineTo(49.75016F, 7.575882F);
      ((Path)localObject).cubicTo(49.554268F, 7.205287F, 49.695889F, 6.746056F, 50.066483F, 6.550161F);
      ((Path)localObject).cubicTo(50.288403F, 6.432857F, 50.553963F, 6.432857F, 50.775883F, 6.550161F);
      ((Path)localObject).lineTo(54.600002F, 8.571573F);
      ((Path)localObject).lineTo(58.424118F, 6.550161F);
      ((Path)localObject).cubicTo(58.794716F, 6.354267F, 59.253944F, 6.495889F, 59.449841F, 6.866484F);
      ((Path)localObject).cubicTo(59.567142F, 7.088402F, 59.567142F, 7.353964F, 59.449841F, 7.575882F);
      ((Path)localObject).lineTo(57.428429F, 11.400001F);
      ((Path)localObject).lineTo(59.449841F, 15.224119F);
      ((Path)localObject).cubicTo(59.645733F, 15.594714F, 59.504112F, 16.053946F, 59.133518F, 16.24984F);
      ((Path)localObject).cubicTo(58.911598F, 16.367144F, 58.646038F, 16.367144F, 58.424118F, 16.24984F);
      ((Path)localObject).lineTo(54.600002F, 14.228428F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.uf
 * JD-Core Version:    0.7.0.1
 */