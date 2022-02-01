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

public class icons_filled_finder_icon
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -784.0F, 0.0F, 1.0F, -1557.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 784.0F, 0.0F, 1.0F, 1557.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint(localPaint, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.787208F, 10.822733F);
      ((Path)localObject2).cubicTo(8.502257F, 11.365307F, 8.007208F, 12.257782F, 7.409386F, 13.127485F);
      ((Path)localObject2).cubicTo(6.455327F, 14.51501F, 5.795129F, 15.046297F, 5.415525F, 15.248871F);
      ((Path)localObject2).cubicTo(5.24305F, 15.340753F, 5.031366F, 15.284713F, 4.923446F, 15.121742F);
      ((Path)localObject2).cubicTo(4.493148F, 14.47303F, 3.668594F, 12.764515F, 2.90701F, 9.737386F);
      ((Path)localObject2).cubicTo(2.094733F, 6.508871F, 1.823248F, 3.539168F, 2.246812F, 2.515406F);
      ((Path)localObject2).cubicTo(2.313545F, 2.35402F, 2.506218F, 2.287881F, 2.656515F, 2.376396F);
      ((Path)localObject2).cubicTo(3.230376F, 2.71402F, 4.656119F, 3.943921F, 7.352159F, 8.419564F);
      ((Path)localObject2).cubicTo(7.959089F, 9.427287F, 8.481861F, 10.307089F, 8.787208F, 10.822733F);
      ((Path)localObject2).moveTo(17.019089F, 9.737386F);
      ((Path)localObject2).cubicTo(16.272753F, 12.704911F, 15.465425F, 14.405108F, 15.031366F, 15.080555F);
      ((Path)localObject2).cubicTo(14.900079F, 15.284713F, 14.62899F, 15.341148F, 14.422852F, 15.21303F);
      ((Path)localObject2).cubicTo(13.615921F, 14.711446F, 12.289188F, 13.07501F, 11.135921F, 10.827683F);
      ((Path)localObject2).cubicTo(11.440673F, 10.312832F, 11.96503F, 9.430654F, 12.57394F, 8.419564F);
      ((Path)localObject2).cubicTo(15.278495F, 3.929861F, 16.705425F, 2.706495F, 17.274139F, 2.373228F);
      ((Path)localObject2).cubicTo(17.427999F, 2.283327F, 17.609386F, 2.346495F, 17.6779F, 2.510851F);
      ((Path)localObject2).lineTo(17.679684F, 2.515604F);
      ((Path)localObject2).cubicTo(18.102852F, 3.539168F, 17.831366F, 6.508871F, 17.019089F, 9.737386F);
      ((Path)localObject2).moveTo(19.576515F, 1.73105F);
      ((Path)localObject2).cubicTo(19.060278F, 0.4823366F, 18.197109F, 0.2367921F, 17.727802F, 0.2015446F);
      ((Path)localObject2).cubicTo(15.977307F, 0.07144555F, 13.915327F, 2.214218F, 10.815327F, 7.360555F);
      ((Path)localObject2).cubicTo(10.503446F, 7.878178F, 10.213742F, 8.362535F, 9.96305F, 8.782733F);
      ((Path)localObject2).cubicTo(9.713742F, 8.364713F, 9.424436F, 7.881148F, 9.110772F, 7.360555F);
      ((Path)localObject2).cubicTo(6.010178F, 2.212832F, 3.939287F, 0.07223763F, 2.198099F, 0.2015446F);
      ((Path)localObject2).cubicTo(1.729188F, 0.2367921F, 0.8660198F, 0.4823366F, 0.3495842F, 1.73105F);
      ((Path)localObject2).cubicTo(-0.3626931F, 3.45303F, 0.1725545F, 6.82194F, 0.5551287F, 8.676792F);
      ((Path)localObject2).cubicTo(1.132753F, 11.477782F, 2.062851F, 14.267287F, 2.924832F, 15.783921F);
      ((Path)localObject2).cubicTo(3.498099F, 16.792435F, 4.071168F, 17.30689F, 4.728198F, 17.402733F);
      ((Path)localObject2).cubicTo(4.833545F, 17.418179F, 4.940871F, 17.425901F, 5.047208F, 17.425901F);
      ((Path)localObject2).cubicTo(6.988F, 17.425901F, 8.836119F, 14.891445F, 9.962852F, 12.960158F);
      ((Path)localObject2).cubicTo(11.089584F, 14.891445F, 12.937505F, 17.425901F, 14.878891F, 17.425901F);
      ((Path)localObject2).cubicTo(14.985228F, 17.425901F, 15.092752F, 17.418179F, 15.198297F, 17.402733F);
      ((Path)localObject2).cubicTo(15.854931F, 17.30689F, 16.427999F, 16.792435F, 17.001266F, 15.783921F);
      ((Path)localObject2).cubicTo(17.863247F, 14.267485F, 18.793346F, 11.477782F, 19.37097F, 8.676792F);
      ((Path)localObject2).cubicTo(19.753544F, 6.82194F, 20.288792F, 3.453228F, 19.576515F, 1.73105F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_finder_icon
 * JD-Core Version:    0.7.0.1
 */