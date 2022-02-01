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

public final class bzl
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -72.0F, 0.0F, 1.0F, -671.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 68.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(18.0F, 0.0F);
      ((Path)localObject).lineTo(18.0F, 18.0F);
      ((Path)localObject).lineTo(0.0F, 18.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint1.setColor(-5066062);
      localPaint2.setColor(-5066062);
      localPaint2.setStrokeWidth(0.2F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(10.942768F, 15.577216F);
      ((Path)localObject).cubicTo(11.560647F, 14.929062F, 12.069468F, 13.967736F, 12.421054F, 12.800017F);
      ((Path)localObject).lineTo(14.708638F, 12.800017F);
      ((Path)localObject).cubicTo(13.826419F, 14.120741F, 12.498858F, 15.116574F, 10.942768F, 15.577216F);
      ((Path)localObject).lineTo(10.942768F, 15.577216F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.291879F, 12.800017F);
      ((Path)localObject).lineTo(5.596716F, 12.800017F);
      ((Path)localObject).cubicTo(5.949279F, 13.970991F, 6.459729F, 14.934596F, 7.079886F, 15.583076F);
      ((Path)localObject).cubicTo(5.514029F, 15.125363F, 4.177679F, 14.126926F, 3.291879F, 12.800017F);
      ((Path)localObject).lineTo(3.291879F, 12.800017F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.079886F, 2.416854F);
      ((Path)localObject).cubicTo(6.360438F, 3.169182F, 5.788461F, 4.344389F, 5.440782F, 5.777099F);
      ((Path)localObject).lineTo(2.946153F, 5.777099F);
      ((Path)localObject).cubicTo(3.807863F, 4.16534F, 5.294288F, 2.939024F, 7.079886F, 2.416854F);
      ((Path)localObject).lineTo(7.079886F, 2.416854F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.054038F, 5.777099F);
      ((Path)localObject).lineTo(12.576989F, 5.777099F);
      ((Path)localObject).cubicTo(12.229961F, 4.34797F, 11.659612F, 3.175041F, 10.942768F, 2.423039F);
      ((Path)localObject).cubicTo(12.718599F, 2.948464F, 14.19591F, 4.171851F, 15.054038F, 5.777099F);
      ((Path)localObject).lineTo(15.054038F, 5.777099F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.932481F, 9.608077F);
      ((Path)localObject).lineTo(15.830781F, 9.608077F);
      ((Path)localObject).cubicTo(15.750047F, 10.52285F, 15.488962F, 11.384886F, 15.083337F, 12.161955F);
      ((Path)localObject).lineTo(12.591964F, 12.161955F);
      ((Path)localObject).cubicTo(12.777848F, 11.377724F, 12.89602F, 10.518944F, 12.932481F, 9.608077F);
      ((Path)localObject).lineTo(12.932481F, 9.608077F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.31929F, 12.161955F);
      ((Path)localObject).lineTo(9.31929F, 9.608077F);
      ((Path)localObject).lineTo(12.294418F, 9.608077F);
      ((Path)localObject).cubicTo(12.254376F, 10.517316F, 12.125136F, 11.381305F, 11.92623F, 12.161955F);
      ((Path)localObject).lineTo(9.31929F, 12.161955F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.31929F, 15.830813F);
      ((Path)localObject).lineTo(9.31929F, 12.800017F);
      ((Path)localObject).lineTo(11.743601F, 12.800017F);
      ((Path)localObject).cubicTo(11.199946F, 14.475256F, 10.315123F, 15.642976F, 9.31929F, 15.830813F);
      ((Path)localObject).lineTo(9.31929F, 15.830813F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.680902F, 12.800017F);
      ((Path)localObject).lineTo(8.680902F, 15.82886F);
      ((Path)localObject).cubicTo(7.692231F, 15.630605F, 6.81457F, 14.46549F, 6.274169F, 12.800017F);
      ((Path)localObject).lineTo(8.680902F, 12.800017F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.723027F, 9.608077F);
      ((Path)localObject).lineTo(8.680902F, 9.608077F);
      ((Path)localObject).lineTo(8.680902F, 12.161955F);
      ((Path)localObject).lineTo(6.09154F, 12.161955F);
      ((Path)localObject).cubicTo(5.892309F, 11.381305F, 5.763394F, 10.517316F, 5.723027F, 9.608077F);
      ((Path)localObject).lineTo(5.723027F, 9.608077F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.680902F, 6.415487F);
      ((Path)localObject).lineTo(8.680902F, 8.969364F);
      ((Path)localObject).lineTo(5.708703F, 8.969364F);
      ((Path)localObject).cubicTo(5.710656F, 8.071844F, 5.800506F, 7.209158F, 5.959696F, 6.415487F);
      ((Path)localObject).lineTo(8.680902F, 6.415487F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.680902F, 2.171395F);
      ((Path)localObject).lineTo(8.680902F, 5.777099F);
      ((Path)localObject).lineTo(6.105539F, 5.777099F);
      ((Path)localObject).cubicTo(6.619895F, 3.808221F, 7.581546F, 2.391462F, 8.680902F, 2.171395F);
      ((Path)localObject).lineTo(8.680902F, 2.171395F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.31929F, 5.777099F);
      ((Path)localObject).lineTo(9.31929F, 2.169442F);
      ((Path)localObject).cubicTo(10.425807F, 2.378115F, 11.394946F, 3.798129F, 11.911906F, 5.777099F);
      ((Path)localObject).lineTo(9.31929F, 5.777099F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.308743F, 8.969364F);
      ((Path)localObject).lineTo(9.31929F, 8.969364F);
      ((Path)localObject).lineTo(9.31929F, 6.415487F);
      ((Path)localObject).lineTo(12.057749F, 6.415487F);
      ((Path)localObject).cubicTo(12.217265F, 7.209158F, 12.306788F, 8.071844F, 12.308743F, 8.969364F);
      ((Path)localObject).lineTo(12.308743F, 8.969364F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.86008F, 8.969364F);
      ((Path)localObject).lineTo(12.947455F, 8.969364F);
      ((Path)localObject).cubicTo(12.945502F, 8.066636F, 12.860862F, 7.210135F, 12.713065F, 6.415487F);
      ((Path)localObject).lineTo(15.352235F, 6.415487F);
      ((Path)localObject).cubicTo(15.674847F, 7.205252F, 15.856174F, 8.06631F, 15.86008F, 8.969364F);
      ((Path)localObject).lineTo(15.86008F, 8.969364F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(2.647957F, 6.415487F);
      ((Path)localObject).lineTo(5.30438F, 6.415487F);
      ((Path)localObject).cubicTo(5.156584F, 7.210135F, 5.071943F, 8.066636F, 5.070315F, 8.969364F);
      ((Path)localObject).lineTo(2.139786F, 8.969364F);
      ((Path)localObject).cubicTo(2.144018F, 8.06631F, 2.325345F, 7.205252F, 2.647957F, 6.415487F);
      ((Path)localObject).lineTo(2.647957F, 6.415487F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(2.169085F, 9.608077F);
      ((Path)localObject).lineTo(5.084965F, 9.608077F);
      ((Path)localObject).cubicTo(5.121751F, 10.518944F, 5.239597F, 11.377724F, 5.425481F, 12.161955F);
      ((Path)localObject).lineTo(2.916529F, 12.161955F);
      ((Path)localObject).cubicTo(2.511229F, 11.384886F, 2.249819F, 10.52285F, 2.169085F, 9.608077F);
      ((Path)localObject).lineTo(2.169085F, 9.608077F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.482841F, 9.344388F);
      ((Path)localObject).cubicTo(16.486097F, 9.325507F, 16.49391F, 9.308579F, 16.49391F, 9.288721F);
      ((Path)localObject).cubicTo(16.49391F, 9.276675F, 16.488377F, 9.26691F, 16.4874F, 9.255515F);
      ((Path)localObject).cubicTo(16.49033F, 9.169898F, 16.500095F, 9.086233F, 16.500095F, 8.999965F);
      ((Path)localObject).cubicTo(16.500095F, 7.932513F, 16.272541F, 6.918449F, 15.868545F, 5.998142F);
      ((Path)localObject).cubicTo(15.861056F, 5.974703F, 15.850314F, 5.954519F, 15.837943F, 5.93401F);
      ((Path)localObject).cubicTo(14.673479F, 3.34823F, 12.089978F, 1.537239F, 9.082946F, 1.50436F);
      ((Path)localObject).cubicTo(9.067646F, 1.504034F, 9.053322F, 1.500128F, 9.038021F, 1.500128F);
      ((Path)localObject).cubicTo(9.035417F, 1.500128F, 9.033138F, 1.50143F, 9.030209F, 1.50143F);
      ((Path)localObject).cubicTo(9.020117F, 1.50143F, 9.01035F, 1.500128F, 9.000258F, 1.500128F);
      ((Path)localObject).cubicTo(8.994399F, 1.500128F, 8.98919F, 1.500779F, 8.983656F, 1.500779F);
      ((Path)localObject).cubicTo(8.982028F, 1.500779F, 8.981051F, 1.500128F, 8.979424F, 1.500128F);
      ((Path)localObject).cubicTo(8.971285F, 1.500128F, 8.963472F, 1.502081F, 8.955334F, 1.502081F);
      ((Path)localObject).cubicTo(5.931699F, 1.520311F, 3.331595F, 3.337161F, 2.162574F, 5.93401F);
      ((Path)localObject).cubicTo(2.149878F, 5.954519F, 2.139135F, 5.974703F, 2.131322F, 5.998142F);
      ((Path)localObject).cubicTo(1.72765F, 6.918449F, 1.500096F, 7.932513F, 1.500096F, 8.999965F);
      ((Path)localObject).cubicTo(1.500096F, 9.077769F, 1.509211F, 9.153621F, 1.511815F, 9.230774F);
      ((Path)localObject).cubicTo(1.507909F, 9.250307F, 1.500096F, 9.268211F, 1.500096F, 9.288721F);
      ((Path)localObject).cubicTo(1.500096F, 9.323228F, 1.509537F, 9.35448F, 1.519628F, 9.385733F);
      ((Path)localObject).cubicTo(1.578877F, 10.544662F, 1.894327F, 11.63653F, 2.423008F, 12.599157F);
      ((Path)localObject).cubicTo(2.429518F, 12.61576F, 2.441238F, 12.629107F, 2.450678F, 12.644408F);
      ((Path)localObject).cubicTo(3.726803F, 14.929387F, 6.161207F, 16.481247F, 8.955334F, 16.497849F);
      ((Path)localObject).cubicTo(8.963472F, 16.497849F, 8.971285F, 16.500128F, 8.979424F, 16.500128F);
      ((Path)localObject).cubicTo(8.981051F, 16.500128F, 8.982028F, 16.499477F, 8.983656F, 16.499477F);
      ((Path)localObject).cubicTo(8.98919F, 16.499477F, 8.994399F, 16.500128F, 9.000258F, 16.500128F);
      ((Path)localObject).cubicTo(9.01035F, 16.500128F, 9.020117F, 16.498825F, 9.030209F, 16.498501F);
      ((Path)localObject).cubicTo(9.033138F, 16.498825F, 9.035417F, 16.500128F, 9.038021F, 16.500128F);
      ((Path)localObject).cubicTo(9.053322F, 16.500128F, 9.067646F, 16.496222F, 9.082946F, 16.495895F);
      ((Path)localObject).cubicTo(11.860796F, 16.465294F, 14.279248F, 14.91897F, 15.549513F, 12.644408F);
      ((Path)localObject).cubicTo(15.558953F, 12.629107F, 15.570348F, 12.61576F, 15.577184F, 12.599157F);
      ((Path)localObject).cubicTo(16.112375F, 11.625135F, 16.429127F, 10.518944F, 16.482841F, 9.344388F);
      ((Path)localObject).lineTo(16.482841F, 9.344388F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bzl
 * JD-Core Version:    0.7.0.1
 */