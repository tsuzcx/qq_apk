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

public final class atf
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
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 34.411766F, 0.0F, 1.0F, 10.5F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.restore();
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(56.302994F, 10.714713F);
      ((Path)localObject).cubicTo(59.58173F, 9.377419F, 62.384918F, 10.660283F, 63.845718F, 14.347345F);
      ((Path)localObject).cubicTo(67.776787F, 24.267017F, 58.574986F, 61.799999F, 51.355621F, 61.799999F);
      ((Path)localObject).cubicTo(49.019794F, 61.799999F, 46.67889F, 59.840286F, 43.951683F, 56.317757F);
      ((Path)localObject).cubicTo(42.722534F, 54.730156F, 41.439453F, 52.837715F, 40.120258F, 50.701832F);
      ((Path)localObject).cubicTo(39.064941F, 48.993191F, 38.027599F, 47.19672F, 37.031036F, 45.378624F);
      ((Path)localObject).lineTo(36.000767F, 43.464806F);
      ((Path)localObject).lineTo(36.000767F, 43.464806F);
      ((Path)localObject).lineTo(35.951084F, 43.555779F);
      ((Path)localObject).cubicTo(34.661964F, 45.989311F, 33.286831F, 48.423641F, 31.879742F, 50.701832F);
      ((Path)localObject).cubicTo(30.560547F, 52.837715F, 29.277468F, 54.730156F, 28.048317F, 56.317757F);
      ((Path)localObject).cubicTo(25.321108F, 59.840286F, 22.980204F, 61.799999F, 20.644381F, 61.799999F);
      ((Path)localObject).cubicTo(13.425013F, 61.799999F, 4.223214F, 24.267017F, 8.154228F, 14.347482F);
      ((Path)localObject).cubicTo(9.615081F, 10.660283F, 12.418269F, 9.377419F, 15.697006F, 10.714713F);
      ((Path)localObject).cubicTo(18.074213F, 11.684302F, 20.697821F, 14.002635F, 23.629663F, 17.475548F);
      ((Path)localObject).cubicTo(25.374382F, 19.542255F, 27.199516F, 21.989664F, 29.078079F, 24.740967F);
      ((Path)localObject).cubicTo(31.158051F, 27.787247F, 33.195827F, 31.044739F, 35.108894F, 34.301495F);
      ((Path)localObject).lineTo(36.001095F, 35.834164F);
      ((Path)localObject).lineTo(36.891106F, 34.301495F);
      ((Path)localObject).cubicTo(38.421562F, 31.696089F, 40.031826F, 29.090214F, 41.679661F, 26.592384F);
      ((Path)localObject).lineTo(42.921921F, 24.740967F);
      ((Path)localObject).cubicTo(44.800484F, 21.989664F, 46.625618F, 19.542255F, 48.370338F, 17.475548F);
      ((Path)localObject).cubicTo(51.302181F, 14.002635F, 53.925789F, 11.684302F, 56.302994F, 10.714713F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.337419F, 14.048108F);
      ((Path)localObject).cubicTo(12.952862F, 13.483391F, 12.239483F, 13.809865F, 11.501062F, 15.673641F);
      ((Path)localObject).cubicTo(10.210722F, 18.929691F, 10.752568F, 27.134665F, 12.665434F, 36.342224F);
      ((Path)localObject).lineTo(13.112896F, 38.403248F);
      ((Path)localObject).lineTo(13.60437F, 40.487656F);
      ((Path)localObject).cubicTo(16.018845F, 50.335995F, 19.492588F, 58.200001F, 20.644381F, 58.200001F);
      ((Path)localObject).cubicTo(21.432722F, 58.200001F, 23.153549F, 56.759392F, 25.201746F, 54.113888F);
      ((Path)localObject).cubicTo(26.344589F, 52.637764F, 27.559311F, 50.846149F, 28.816853F, 48.810089F);
      ((Path)localObject).cubicTo(29.837606F, 47.157406F, 30.845091F, 45.412479F, 31.814318F, 43.644161F);
      ((Path)localObject).lineTo(32.986019F, 41.460941F);
      ((Path)localObject).lineTo(32.986019F, 41.460941F);
      ((Path)localObject).lineTo(33.969002F, 39.551998F);
      ((Path)localObject).lineTo(32.941296F, 37.737453F);
      ((Path)localObject).lineTo(32.004818F, 36.124874F);
      ((Path)localObject).cubicTo(30.130169F, 32.933521F, 28.134232F, 29.742908F, 26.105009F, 26.770954F);
      ((Path)localObject).cubicTo(24.290594F, 24.113604F, 22.536194F, 21.761044F, 20.878828F, 19.797812F);
      ((Path)localObject).cubicTo(18.294254F, 16.736258F, 16.036299F, 14.741029F, 14.337419F, 14.048108F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.498882F, 15.673505F);
      ((Path)localObject).cubicTo(59.760517F, 13.809865F, 59.047138F, 13.483391F, 57.662582F, 14.048108F);
      ((Path)localObject).cubicTo(55.963703F, 14.741029F, 53.705746F, 16.736258F, 51.121174F, 19.797812F);
      ((Path)localObject).cubicTo(49.463806F, 21.761044F, 47.709408F, 24.113604F, 45.894993F, 26.770954F);
      ((Path)localObject).cubicTo(44.271614F, 29.148518F, 42.669537F, 31.666023F, 41.133823F, 34.211895F);
      ((Path)localObject).lineTo(39.514751F, 36.947468F);
      ((Path)localObject).lineTo(38.028F, 39.551998F);
      ((Path)localObject).lineTo(38.537968F, 40.546883F);
      ((Path)localObject).lineTo(39.230133F, 41.87059F);
      ((Path)localObject).cubicTo(40.484726F, 44.238949F, 41.822144F, 46.60651F, 43.183147F, 48.810089F);
      ((Path)localObject).cubicTo(44.440689F, 50.846149F, 45.655411F, 52.637764F, 46.798252F, 54.113888F);
      ((Path)localObject).cubicTo(48.846451F, 56.759392F, 50.56728F, 58.200001F, 51.355621F, 58.200001F);
      ((Path)localObject).cubicTo(52.507412F, 58.200001F, 55.981155F, 50.335995F, 58.39563F, 40.487656F);
      ((Path)localObject).lineTo(58.887104F, 38.403248F);
      ((Path)localObject).cubicTo(61.157104F, 28.377371F, 61.884853F, 19.170872F, 60.498882F, 15.673505F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.atf
 * JD-Core Version:    0.7.0.1
 */