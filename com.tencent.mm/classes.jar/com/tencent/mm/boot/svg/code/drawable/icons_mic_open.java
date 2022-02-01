package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_mic_open
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(5.0F);
      localPaint1.setStrokeCap(Paint.Cap.ROUND);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setPathEffect(new DashPathEffect(new float[] { 14.0F, 14.0F }, 0.0F));
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(30.766623F, -1.243008E-015F);
      localPath.lineTo(81.233376F, 1.243008E-015F);
      localPath.cubicTo(91.931602F, -7.222237E-016F, 95.811035F, 1.113907F, 99.722145F, 3.205592F);
      localPath.cubicTo(103.63326F, 5.297278F, 106.70272F, 8.36674F, 108.79441F, 12.277852F);
      localPath.cubicTo(110.88609F, 16.188963F, 112.0F, 20.068398F, 112.0F, 30.766623F);
      localPath.lineTo(112.0F, 81.233376F);
      localPath.cubicTo(112.0F, 91.931602F, 110.88609F, 95.811035F, 108.79441F, 99.722145F);
      localPath.cubicTo(106.70272F, 103.63326F, 103.63326F, 106.70272F, 99.722145F, 108.79441F);
      localPath.cubicTo(95.811035F, 110.88609F, 91.931602F, 112.0F, 81.233376F, 112.0F);
      localPath.lineTo(30.766623F, 112.0F);
      localPath.cubicTo(20.068398F, 112.0F, 16.188963F, 110.88609F, 12.277852F, 108.79441F);
      localPath.cubicTo(8.36674F, 106.70272F, 5.297278F, 103.63326F, 3.205592F, 99.722145F);
      localPath.cubicTo(1.113907F, 95.811035F, 4.814824E-016F, 91.931602F, -8.286722E-016F, 81.233376F);
      localPath.lineTo(8.286722E-016F, 30.766623F);
      localPath.cubicTo(-4.814824E-016F, 20.068398F, 1.113907F, 16.188963F, 3.205592F, 12.277852F);
      localPath.cubicTo(5.297278F, 8.36674F, 8.36674F, 5.297278F, 12.277852F, 3.205592F);
      localPath.cubicTo(16.188963F, 1.113907F, 20.068398F, 7.222237E-016F, 30.766623F, -1.243008E-015F);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 112.0F, 0.0F, -8.286722E-016F, 0.0F, 112.0F, -1.243008E-015F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 1.0F, 0.0F, 0.08367048F, 1.0F, new int[] { -6644737, -6644737 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-8289281);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 32.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(33.359455F, 31.006395F);
      ((Path)localObject2).cubicTo(32.992371F, 30.884022F, 32.839417F, 30.945208F, 32.502922F, 31.128769F);
      ((Path)localObject2).cubicTo(31.401667F, 31.740637F, 28.709707F, 33.209118F, 27.119003F, 34.035141F);
      ((Path)localObject2).cubicTo(26.721329F, 34.249294F, 26.293062F, 34.371666F, 25.803614F, 34.371666F);
      ((Path)localObject2).cubicTo(25.283577F, 34.371666F, 24.82472F, 34.2187F, 24.427044F, 33.973953F);
      ((Path)localObject2).cubicTo(22.193941F, 32.658436F, 20.0832F, 31.128769F, 18.278364F, 29.293165F);
      ((Path)localObject2).cubicTo(16.473528F, 27.488155F, 14.944005F, 25.377213F, 13.628616F, 23.143894F);
      ((Path)localObject2).cubicTo(13.383892F, 22.746181F, 13.23094F, 22.256687F, 13.23094F, 21.767193F);
      ((Path)localObject2).cubicTo(13.23094F, 21.308292F, 13.353302F, 20.849392F, 13.567435F, 20.451677F);
      ((Path)localObject2).cubicTo(14.393377F, 18.830229F, 15.861719F, 16.13801F, 16.473528F, 15.067242F);
      ((Path)localObject2).cubicTo(16.65707F, 14.730715F, 16.718252F, 14.547154F, 16.59589F, 14.210627F);
      ((Path)localObject2).lineTo(13.995701F, 7.296522F);
      ((Path)localObject2).cubicTo(13.659206F, 6.501094F, 12.894445F, 5.981007F, 11.976731F, 5.950413F);
      ((Path)localObject2).cubicTo(11.609646F, 5.950413F, 11.18138F, 6.10338F, 11.089609F, 6.133974F);
      ((Path)localObject2).cubicTo(8.091744F, 7.235335F, 5.950413F, 10.08052F, 5.950413F, 13.445792F);
      ((Path)localObject2).cubicTo(5.950413F, 14.394187F, 6.195137F, 15.281395F, 6.225727F, 15.495549F);
      ((Path)localObject2).cubicTo(7.694069F, 21.92016F, 10.967247F, 27.641123F, 15.464043F, 32.138351F);
      ((Path)localObject2).cubicTo(19.960838F, 36.635578F, 25.681253F, 39.909069F, 32.105247F, 41.377552F);
      ((Path)localObject2).cubicTo(32.319382F, 41.43874F, 33.206505F, 41.652893F, 34.154808F, 41.652893F);
      ((Path)localObject2).cubicTo(37.519756F, 41.652893F, 40.36467F, 39.511356F, 41.465923F, 36.513203F);
      ((Path)localObject2).cubicTo(41.496513F, 36.421425F, 41.680058F, 35.993118F, 41.649467F, 35.625996F);
      ((Path)localObject2).cubicTo(41.588287F, 34.708195F, 41.068249F, 33.943359F, 40.272896F, 33.606831F);
      ((Path)localObject2).lineTo(33.359455F, 31.006395F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_mic_open
 * JD-Core Version:    0.7.0.1
 */