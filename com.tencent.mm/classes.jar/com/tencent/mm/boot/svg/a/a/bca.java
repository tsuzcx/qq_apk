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

public final class bca
  extends c
{
  private final int height = 160;
  private final int width = 160;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 160;
      return 160;
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1250068);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(79.01384F, 0.0F);
      localPath.lineTo(82.415092F, 0.0F);
      localPath.cubicTo(101.12201F, 0.5937107F, 119.53711F, 7.889308F, 133.41383F, 20.467924F);
      localPath.cubicTo(149.52452F, 34.767296F, 159.29559F, 55.79874F, 160.0F, 77.31321F);
      localPath.lineTo(160.0F, 82.485535F);
      localPath.cubicTo(159.38617F, 101.41383F, 151.89937F, 120.04025F, 139.039F, 133.9673F);
      localPath.cubicTo(124.89056F, 149.62515F, 104.3522F, 159.07422F, 83.290565F, 160.0F);
      localPath.lineTo(79.023903F, 160.0F);
      localPath.cubicTo(60.286793F, 159.80881F, 41.730816F, 152.78491F, 27.622641F, 140.4478F);
      localPath.cubicTo(10.898113F, 126.11824F, 0.7044025F, 104.64403F, 0.0F, 82.646538F);
      localPath.lineTo(0.0F, 77.584908F);
      localPath.cubicTo(0.623899F, 55.748428F, 10.616352F, 34.415092F, 27.069183F, 20.035219F);
      localPath.cubicTo(41.237736F, 7.416352F, 60.035221F, 0.2012579F, 79.01384F, 0.0F);
      localPath.lineTo(79.01384F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3355444);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 41.0F, 0.0F, 1.0F, 44.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.019949F, 1.166167F);
      ((Path)localObject2).cubicTo(28.676641F, 0.9363118F, 49.343307F, 0.9562993F, 70.0F, 1.156174F);
      ((Path)localObject2).lineTo(70.0F, 6.852593F);
      ((Path)localObject2).cubicTo(49.333332F, 7.052467F, 28.666666F, 7.042473F, 8.0F, 6.862587F);
      ((Path)localObject2).cubicTo(8.0F, 4.96378F, 8.0F, 3.064974F, 8.019949F, 1.166167F);
      ((Path)localObject2).lineTo(8.019949F, 1.166167F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(5.850852F, 10.178336F);
      ((Path)localObject2).cubicTo(27.607054F, 9.930755F, 49.383244F, 9.950561F, 71.129448F, 10.178336F);
      ((Path)localObject2).cubicTo(72.838364F, 17.189867F, 74.427361F, 24.221203F, 76.156265F, 31.232735F);
      ((Path)localObject2).cubicTo(76.64595F, 33.668945F, 77.455437F, 36.233894F, 76.675934F, 38.709717F);
      ((Path)localObject2).cubicTo(75.586624F, 42.463066F, 71.249374F, 44.740822F, 67.481766F, 43.740589F);
      ((Path)localObject2).cubicTo(64.833443F, 43.294941F, 63.334393F, 40.87854F, 61.705425F, 39.026623F);
      ((Path)localObject2).cubicTo(59.616753F, 41.512352F, 57.098351F, 44.42392F, 53.44067F, 43.948559F);
      ((Path)localObject2).cubicTo(50.132767F, 43.948559F, 47.994122F, 41.294479F, 46.195263F, 38.917686F);
      ((Path)localObject2).cubicTo(44.346436F, 41.45293F, 41.937965F, 44.186237F, 38.450176F, 43.988174F);
      ((Path)localObject2).cubicTo(35.02235F, 44.146626F, 32.693829F, 41.45293F, 30.864986F, 38.977108F);
      ((Path)localObject2).cubicTo(28.976185F, 41.264767F, 26.857529F, 43.968365F, 23.55962F, 43.948559F);
      ((Path)localObject2).cubicTo(19.901939F, 44.414013F, 17.383537F, 41.512352F, 15.284868F, 39.036526F);
      ((Path)localObject2).cubicTo(13.785819F, 40.700279F, 12.506631F, 42.849293F, 10.228076F, 43.552429F);
      ((Path)localObject2).cubicTo(6.370522F, 44.948792F, 1.523596F, 42.760166F, 0.354338F, 38.798847F);
      ((Path)localObject2).cubicTo(-0.4851297F, 36.27351F, 0.3643316F, 33.639233F, 0.874008F, 31.143604F);
      ((Path)localObject2).cubicTo(2.602912F, 24.171686F, 4.181911F, 17.170061F, 5.850852F, 10.178336F);
      ((Path)localObject2).lineTo(5.850852F, 10.178336F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.077558F, 48.742432F);
      ((Path)localObject2).cubicTo(10.055874F, 48.158264F, 12.044182F, 47.574097F, 14.022499F, 47.0F);
      ((Path)localObject2).cubicTo(14.082448F, 52.156792F, 13.952559F, 57.303509F, 14.062465F, 62.4603F);
      ((Path)localObject2).cubicTo(16.550348F, 59.378311F, 18.798435F, 56.115028F, 21.276327F, 53.022968F);
      ((Path)localObject2).cubicTo(33.096268F, 52.932323F, 44.91621F, 52.912178F, 56.736153F, 53.033043F);
      ((Path)localObject2).cubicTo(59.204056F, 56.125103F, 61.452141F, 59.388382F, 63.940025F, 62.4603F);
      ((Path)localObject2).cubicTo(64.049934F, 57.31358F, 63.930031F, 52.156792F, 63.979992F, 47.0F);
      ((Path)localObject2).cubicTo(65.958305F, 47.574097F, 67.946617F, 48.158264F, 69.924934F, 48.742432F);
      ((Path)localObject2).cubicTo(69.994873F, 56.115028F, 70.074806F, 63.4977F, 69.864983F, 70.8703F);
      ((Path)localObject2).cubicTo(49.292488F, 71.031448F, 28.710001F, 71.061668F, 8.147498F, 70.850159F);
      ((Path)localObject2).cubicTo(7.917694F, 63.487629F, 8.007617F, 56.115028F, 8.077558F, 48.742432F);
      ((Path)localObject2).lineTo(8.077558F, 48.742432F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bca
 * JD-Core Version:    0.7.0.1
 */