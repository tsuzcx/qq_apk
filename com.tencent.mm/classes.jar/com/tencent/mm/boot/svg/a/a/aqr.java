package com.tencent.mm.boot.svg.a.a;

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

public final class aqr
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 204, 31);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localPaint.setStrokeWidth(5.0F);
      localPaint.setStrokeCap(Paint.Cap.ROUND);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setPathEffect(new DashPathEffect(new float[] { 14.0F, 14.0F }, 0.0F));
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
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
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, -0.7071068F, -0.7071068F, 91.355339F, 0.7071068F, -0.7071068F, 60.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.586807F, 0.0F, 1.0F, 0.586807F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(33.925903F, 31.532888F);
      ((Path)localObject2).cubicTo(33.552586F, 31.408436F, 33.397038F, 31.470661F, 33.054829F, 31.657339F);
      ((Path)localObject2).cubicTo(31.934872F, 32.279598F, 29.197203F, 33.773014F, 27.579489F, 34.61306F);
      ((Path)localObject2).cubicTo(27.17506F, 34.830853F, 26.739521F, 34.955303F, 26.241764F, 34.955303F);
      ((Path)localObject2).cubicTo(25.712896F, 34.955303F, 25.246248F, 34.79974F, 24.84182F, 34.550835F);
      ((Path)localObject2).cubicTo(22.570797F, 33.212982F, 20.424215F, 31.657339F, 18.588734F, 29.790567F);
      ((Path)localObject2).cubicTo(16.75325F, 27.954908F, 15.197757F, 25.808121F, 13.860032F, 23.536882F);
      ((Path)localObject2).cubicTo(13.611153F, 23.132414F, 13.455604F, 22.634609F, 13.455604F, 22.136803F);
      ((Path)localObject2).cubicTo(13.455604F, 21.670111F, 13.580043F, 21.203417F, 13.797812F, 20.79895F);
      ((Path)localObject2).cubicTo(14.637778F, 19.149967F, 16.131052F, 16.412035F, 16.75325F, 15.323086F);
      ((Path)localObject2).cubicTo(16.939909F, 14.980844F, 17.002129F, 14.794167F, 16.877689F, 14.451925F);
      ((Path)localObject2).lineTo(14.233351F, 7.420418F);
      ((Path)localObject2).cubicTo(13.891142F, 6.611484F, 13.113395F, 6.082565F, 12.180099F, 6.051452F);
      ((Path)localObject2).cubicTo(11.80678F, 6.051452F, 11.371242F, 6.207017F, 11.277912F, 6.238129F);
      ((Path)localObject2).cubicTo(8.229144F, 7.358192F, 6.051452F, 10.251689F, 6.051452F, 13.674104F);
      ((Path)localObject2).cubicTo(6.051452F, 14.638602F, 6.300331F, 15.540875F, 6.331441F, 15.758666F);
      ((Path)localObject2).cubicTo(7.824715F, 22.292368F, 11.153472F, 28.110474F, 15.726624F, 32.684063F);
      ((Path)localObject2).cubicTo(20.299776F, 37.257656F, 26.117325F, 40.586731F, 32.650398F, 42.080151F);
      ((Path)localObject2).cubicTo(32.868168F, 42.142376F, 33.770355F, 42.360165F, 34.73476F, 42.360165F);
      ((Path)localObject2).cubicTo(38.156849F, 42.360165F, 41.050068F, 40.182262F, 42.170021F, 37.133202F);
      ((Path)localObject2).cubicTo(42.20113F, 37.039864F, 42.387791F, 36.604286F, 42.356682F, 36.23093F);
      ((Path)localObject2).cubicTo(42.29446F, 35.297543F, 41.765594F, 34.519722F, 40.956738F, 34.177483F);
      ((Path)localObject2).lineTo(33.925903F, 31.532888F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqr
 * JD-Core Version:    0.7.0.1
 */