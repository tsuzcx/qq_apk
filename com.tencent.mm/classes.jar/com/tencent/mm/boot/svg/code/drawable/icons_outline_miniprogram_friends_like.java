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

public class icons_outline_miniprogram_friends_like
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
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.2F, 16.799999F);
      ((Path)localObject2).lineTo(17.799999F, 16.799999F);
      ((Path)localObject2).lineTo(17.799999F, 16.315464F);
      ((Path)localObject2).cubicTo(17.799999F, 16.08606F, 17.564678F, 15.71002F, 17.35981F, 15.610087F);
      ((Path)localObject2).lineTo(11.699456F, 12.84904F);
      ((Path)localObject2).cubicTo(10.172874F, 12.104393F, 9.795573F, 10.302913F, 10.889337F, 9.006369F);
      ((Path)localObject2).lineTo(11.250869F, 8.577808F);
      ((Path)localObject2).cubicTo(11.802195F, 7.924269F, 12.3F, 6.564391F, 12.3F, 5.710186F);
      ((Path)localObject2).lineTo(12.3F, 4.000207F);
      ((Path)localObject2).cubicTo(12.3F, 2.454914F, 11.045589F, 1.2F, 9.5F, 1.2F);
      ((Path)localObject2).cubicTo(7.956309F, 1.2F, 6.7F, 2.455203F, 6.7F, 3.99958F);
      ((Path)localObject2).lineTo(6.7F, 5.709291F);
      ((Path)localObject2).cubicTo(6.7F, 6.565664F, 7.195747F, 7.920484F, 7.749078F, 8.576312F);
      ((Path)localObject2).lineTo(8.110611F, 9.004812F);
      ((Path)localObject2).cubicTo(9.206636F, 10.30386F, 8.825214F, 12.10365F, 7.300719F, 12.847587F);
      ((Path)localObject2).lineTo(1.640366F, 15.609776F);
      ((Path)localObject2).cubicTo(1.437017F, 15.709009F, 1.2F, 16.088676F, 1.2F, 16.315464F);
      ((Path)localObject2).lineTo(1.2F, 16.799999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.5F, 0.0F);
      ((Path)localObject2).cubicTo(10.702559F, 0.0F, 11.781173F, 0.5313033F, 12.514435F, 1.371512F);
      ((Path)localObject2).lineTo(12.496095F, 1.350642F);
      ((Path)localObject2).lineTo(12.496095F, 1.350642F);
      ((Path)localObject2).cubicTo(12.94908F, 1.126264F, 13.459958F, 1.0F, 14.0F, 1.0F);
      ((Path)localObject2).cubicTo(15.860328F, 1.0F, 17.368422F, 2.49415F, 17.368422F, 4.333506F);
      ((Path)localObject2).lineTo(17.368422F, 5.758488F);
      ((Path)localObject2).cubicTo(17.368422F, 6.707747F, 16.863943F, 8.06905F, 16.246811F, 8.792977F);
      ((Path)localObject2).lineTo(15.942362F, 9.15011F);
      ((Path)localObject2).cubicTo(15.445922F, 9.732459F, 15.601F, 10.473664F, 16.295198F, 10.808759F);
      ((Path)localObject2).lineTo(21.061813F, 13.109632F);
      ((Path)localObject2).cubicTo(21.57996F, 13.359744F, 22.0F, 14.020975F, 22.0F, 14.596219F);
      ((Path)localObject2).lineTo(22.0F, 15.167968F);
      ((Path)localObject2).cubicTo(22.0F, 15.627486F, 21.620274F, 16.0F, 21.156691F, 16.0F);
      ((Path)localObject2).lineTo(18.967646F, 16.0F);
      ((Path)localObject2).lineTo(18.970575F, 16.015045F);
      ((Path)localObject2).cubicTo(18.98982F, 16.116131F, 19.0F, 16.21685F, 19.0F, 16.315464F);
      ((Path)localObject2).lineTo(19.0F, 17.001562F);
      ((Path)localObject2).cubicTo(19.0F, 17.552984F, 18.549074F, 18.0F, 17.998569F, 18.0F);
      ((Path)localObject2).lineTo(1.00143F, 18.0F);
      ((Path)localObject2).cubicTo(0.4483553F, 18.0F, 0.0F, 17.555756F, 0.0F, 17.001562F);
      ((Path)localObject2).lineTo(0.0F, 16.315464F);
      ((Path)localObject2).cubicTo(0.0F, 15.630374F, 0.4981509F, 14.831908F, 1.114098F, 14.531333F);
      ((Path)localObject2).lineTo(6.774451F, 11.769143F);
      ((Path)localObject2).cubicTo(7.595377F, 11.36854F, 7.786259F, 10.481262F, 7.193445F, 9.778639F);
      ((Path)localObject2).lineTo(6.831913F, 9.350138F);
      ((Path)localObject2).cubicTo(6.096318F, 8.478285F, 5.5F, 6.849496F, 5.5F, 5.709291F);
      ((Path)localObject2).lineTo(5.5F, 3.99958F);
      ((Path)localObject2).cubicTo(5.5F, 1.790673F, 7.295356F, 0.0F, 9.5F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.0F, 2.2F);
      ((Path)localObject2).cubicTo(13.699479F, 2.2F, 13.413292F, 2.260354F, 13.153156F, 2.369305F);
      ((Path)localObject2).lineTo(13.143256F, 2.347356F);
      ((Path)localObject2).cubicTo(13.372382F, 2.851302F, 13.5F, 3.410995F, 13.5F, 4.000207F);
      ((Path)localObject2).lineTo(13.5F, 5.710186F);
      ((Path)localObject2).cubicTo(13.5F, 6.849296F, 12.900932F, 8.482861F, 12.168087F, 9.351573F);
      ((Path)localObject2).lineTo(11.806555F, 9.780132F);
      ((Path)localObject2).cubicTo(11.217032F, 10.478951F, 11.401188F, 11.368398F, 12.225549F, 11.770511F);
      ((Path)localObject2).lineTo(17.885902F, 14.531558F);
      ((Path)localObject2).cubicTo(18.04204F, 14.607719F, 18.190676F, 14.71565F, 18.325563F, 14.845601F);
      ((Path)localObject2).lineTo(18.276657F, 14.8F);
      ((Path)localObject2).lineTo(18.276657F, 14.8F);
      ((Path)localObject2).lineTo(20.799999F, 14.8F);
      ((Path)localObject2).lineTo(20.799999F, 14.596219F);
      ((Path)localObject2).cubicTo(20.799999F, 14.484596F, 20.646305F, 14.241552F, 20.540159F, 14.190315F);
      ((Path)localObject2).lineTo(15.773546F, 11.889442F);
      ((Path)localObject2).cubicTo(14.372796F, 11.213292F, 14.021533F, 9.553606F, 15.029153F, 8.371619F);
      ((Path)localObject2).lineTo(15.333601F, 8.014486F);
      ((Path)localObject2).cubicTo(15.76679F, 7.506334F, 16.168421F, 6.420608F, 16.168421F, 5.758488F);
      ((Path)localObject2).lineTo(16.168421F, 4.333506F);
      ((Path)localObject2).cubicTo(16.168421F, 3.159029F, 15.199687F, 2.2F, 14.0F, 2.2F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outline_miniprogram_friends_like
 * JD-Core Version:    0.7.0.1
 */