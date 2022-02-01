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

public class icons_outlined_wechat
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      c.instancePaint(localPaint1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 72.0F);
      localPath.cubicTo(0.0F, 32.235497F, 32.235497F, 0.0F, 72.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.cubicTo(111.7645F, 0.0F, 144.0F, 32.235497F, 144.0F, 72.0F);
      localPath.lineTo(144.0F, 72.0F);
      localPath.cubicTo(144.0F, 111.7645F, 111.7645F, 144.0F, 72.0F, 144.0F);
      localPath.lineTo(72.0F, 144.0F);
      localPath.cubicTo(32.235497F, 144.0F, 0.0F, 111.7645F, 0.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.close();
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint3 = c.instancePaint(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 144.0F, 0.0F, 0.0F, 0.0F, 144.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { -16587921, -16268960 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(107.6543F, 100.37557F);
      ((Path)localObject2).cubicTo(113.40971F, 96.211189F, 117.08852F, 90.050003F, 117.08852F, 83.205666F);
      ((Path)localObject2).cubicTo(117.08852F, 70.65889F, 104.86362F, 60.489201F, 89.784378F, 60.489201F);
      ((Path)localObject2).cubicTo(74.705139F, 60.489201F, 62.481232F, 70.65889F, 62.481232F, 83.205666F);
      ((Path)localObject2).cubicTo(62.481232F, 95.751457F, 74.705139F, 105.92114F, 89.784378F, 105.92114F);
      ((Path)localObject2).cubicTo(92.900276F, 105.92114F, 95.907776F, 105.4773F, 98.696465F, 104.67599F);
      ((Path)localObject2).cubicTo(98.950073F, 104.59855F, 99.219597F, 104.55685F, 99.500061F, 104.55685F);
      ((Path)localObject2).cubicTo(100.02319F, 104.55685F, 100.50056F, 104.71571F, 100.9491F, 104.97587F);
      ((Path)localObject2).lineTo(106.9263F, 108.42037F);
      ((Path)localObject2).cubicTo(107.09338F, 108.51669F, 107.2545F, 108.59016F, 107.45242F, 108.59016F);
      ((Path)localObject2).cubicTo(107.95565F, 108.59016F, 108.36242F, 108.18306F, 108.36242F, 107.68063F);
      ((Path)localObject2).cubicTo(108.36242F, 107.45722F, 108.27291F, 107.23183F, 108.21622F, 107.01735F);
      ((Path)localObject2).cubicTo(108.18141F, 106.88926F, 107.44446F, 104.14676F, 106.98597F, 102.43494F);
      ((Path)localObject2).cubicTo(106.93326F, 102.24329F, 106.8905F, 102.05762F, 106.8905F, 101.85605F);
      ((Path)localObject2).cubicTo(106.8905F, 101.24539F, 107.19184F, 100.70523F, 107.6543F, 100.37557F);
      ((Path)localObject2).moveTo(80.682335F, 79.57151F);
      ((Path)localObject2).cubicTo(78.673363F, 79.57151F, 77.043312F, 77.944084F, 77.043312F, 75.936356F);
      ((Path)localObject2).cubicTo(77.043312F, 73.928635F, 78.673363F, 72.301208F, 80.682335F, 72.301208F);
      ((Path)localObject2).cubicTo(82.694298F, 72.301208F, 84.323357F, 73.928635F, 84.323357F, 75.936356F);
      ((Path)localObject2).cubicTo(84.323357F, 77.944084F, 82.694298F, 79.57151F, 80.682335F, 79.57151F);
      ((Path)localObject2).moveTo(59.203522F, 35.409836F);
      ((Path)localObject2).cubicTo(75.549805F, 35.409836F, 89.096458F, 45.369019F, 91.563911F, 58.391418F);
      ((Path)localObject2).cubicTo(90.974152F, 58.362621F, 90.382401F, 58.343758F, 89.784676F, 58.343758F);
      ((Path)localObject2).cubicTo(73.281258F, 58.343758F, 59.902683F, 69.475601F, 59.902683F, 83.204971F);
      ((Path)localObject2).cubicTo(59.902683F, 85.520508F, 60.29155F, 87.760582F, 61.003643F, 89.886459F);
      ((Path)localObject2).cubicTo(60.406918F, 89.913269F, 59.808201F, 89.929161F, 59.203522F, 89.929161F);
      ((Path)localObject2).cubicTo(55.465038F, 89.929161F, 51.855846F, 89.394958F, 48.509216F, 88.434784F);
      ((Path)localObject2).cubicTo(48.203892F, 88.341446F, 47.880665F, 88.29081F, 47.545506F, 88.29081F);
      ((Path)localObject2).cubicTo(46.916954F, 88.29081F, 46.346088F, 88.482445F, 45.806053F, 88.793236F);
      ((Path)localObject2).lineTo(45.806053F, 88.793236F);
      ((Path)localObject2).lineTo(38.633419F, 92.927834F);
      ((Path)localObject2).cubicTo(38.433514F, 93.043015F, 38.238586F, 93.131386F, 38.001884F, 93.131386F);
      ((Path)localObject2).cubicTo(37.398197F, 93.131386F, 36.909878F, 92.643852F, 36.909878F, 92.041138F);
      ((Path)localObject2).cubicTo(36.909878F, 91.771065F, 37.017288F, 91.501976F, 37.085911F, 91.243813F);
      ((Path)localObject2).cubicTo(37.127682F, 91.088913F, 38.010834F, 87.799301F, 38.56181F, 85.745903F);
      ((Path)localObject2).cubicTo(38.624466F, 85.514549F, 38.677177F, 85.29213F, 38.677177F, 85.05085F);
      ((Path)localObject2).cubicTo(38.677177F, 84.317062F, 38.315166F, 83.66967F, 37.760212F, 83.273483F);
      ((Path)localObject2).cubicTo(30.852125F, 78.277016F, 26.439344F, 70.883591F, 26.439344F, 62.669994F);
      ((Path)localObject2).cubicTo(26.439344F, 47.615047F, 41.107838F, 35.409836F, 59.203522F, 35.409836F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(98.885429F, 72.301208F);
      ((Path)localObject2).cubicTo(100.89639F, 72.301208F, 102.52545F, 73.928635F, 102.52545F, 75.936356F);
      ((Path)localObject2).cubicTo(102.52545F, 77.944084F, 100.89639F, 79.57151F, 98.885429F, 79.57151F);
      ((Path)localObject2).cubicTo(96.875465F, 79.57151F, 95.245407F, 77.944084F, 95.245407F, 75.936356F);
      ((Path)localObject2).cubicTo(95.245407F, 73.928635F, 96.875465F, 72.301208F, 98.885429F, 72.301208F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(48.281467F, 49.585037F);
      ((Path)localObject2).cubicTo(45.869701F, 49.585037F, 43.913441F, 51.537159F, 43.913441F, 53.94603F);
      ((Path)localObject2).cubicTo(43.913441F, 56.355892F, 45.869701F, 58.30801F, 48.281467F, 58.30801F);
      ((Path)localObject2).cubicTo(50.695217F, 58.30801F, 52.650486F, 56.355892F, 52.650486F, 53.94603F);
      ((Path)localObject2).cubicTo(52.650486F, 51.537159F, 50.695217F, 49.585037F, 48.281467F, 49.585037F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(70.12558F, 49.585037F);
      ((Path)localObject2).cubicTo(67.711823F, 49.585037F, 65.756554F, 51.537159F, 65.756554F, 53.94603F);
      ((Path)localObject2).cubicTo(65.756554F, 56.355892F, 67.711823F, 58.30801F, 70.12558F, 58.30801F);
      ((Path)localObject2).cubicTo(72.538338F, 58.30801F, 74.494598F, 56.355892F, 74.494598F, 53.94603F);
      ((Path)localObject2).cubicTo(74.494598F, 51.537159F, 72.538338F, 49.585037F, 70.12558F, 49.585037F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_wechat
 * JD-Core Version:    0.7.0.1
 */