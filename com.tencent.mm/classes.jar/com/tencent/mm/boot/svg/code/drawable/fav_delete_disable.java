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

public class fav_delete_disable
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
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.773552F, 3.399997F);
      ((Path)localObject2).lineTo(4.585906F, 17.047535F);
      ((Path)localObject2).cubicTo(4.611062F, 17.470152F, 4.961127F, 17.799999F, 5.384492F, 17.799999F);
      ((Path)localObject2).lineTo(12.615507F, 17.799999F);
      ((Path)localObject2).cubicTo(13.038874F, 17.799999F, 13.388938F, 17.470152F, 13.414094F, 17.047535F);
      ((Path)localObject2).lineTo(14.226447F, 3.399997F);
      ((Path)localObject2).lineTo(3.773552F, 3.399997F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.428572F, 3.399997F);
      ((Path)localObject2).lineTo(14.611974F, 17.118837F);
      ((Path)localObject2).cubicTo(14.549085F, 18.175381F, 13.673922F, 19.0F, 12.615507F, 19.0F);
      ((Path)localObject2).lineTo(5.384492F, 19.0F);
      ((Path)localObject2).cubicTo(4.326078F, 19.0F, 3.450916F, 18.175381F, 3.388026F, 17.118837F);
      ((Path)localObject2).lineTo(2.571429F, 3.399997F);
      ((Path)localObject2).lineTo(0.5F, 3.399997F);
      ((Path)localObject2).lineTo(0.5F, 2.699997F);
      ((Path)localObject2).cubicTo(0.5F, 2.423855F, 0.7238576F, 2.199997F, 1.0F, 2.199997F);
      ((Path)localObject2).lineTo(17.0F, 2.199997F);
      ((Path)localObject2).cubicTo(17.276142F, 2.199997F, 17.5F, 2.423855F, 17.5F, 2.699997F);
      ((Path)localObject2).lineTo(17.5F, 3.399997F);
      ((Path)localObject2).lineTo(15.428572F, 3.399997F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.0F, 2.728557E-005F);
      ((Path)localObject2).cubicTo(11.276142F, 2.728557E-005F, 11.5F, 0.2238849F, 11.5F, 0.500027F);
      ((Path)localObject2).lineTo(11.5F, 1.200024F);
      ((Path)localObject2).lineTo(6.5F, 1.200024F);
      ((Path)localObject2).lineTo(6.5F, 0.500027F);
      ((Path)localObject2).cubicTo(6.5F, 0.2238849F, 6.723857F, 2.728557E-005F, 7.0F, 2.728557E-005F);
      ((Path)localObject2).lineTo(11.0F, 2.728557E-005F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.5F, 6.0F);
      ((Path)localObject2).lineTo(7.700012F, 6.0F);
      ((Path)localObject2).lineTo(8.200012F, 15.0F);
      ((Path)localObject2).lineTo(7.0F, 15.0F);
      ((Path)localObject2).lineTo(6.5F, 6.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.299988F, 6.0F);
      ((Path)localObject2).lineTo(11.5F, 6.0F);
      ((Path)localObject2).lineTo(11.0F, 15.0F);
      ((Path)localObject2).lineTo(9.799988F, 15.0F);
      ((Path)localObject2).lineTo(10.299988F, 6.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fav_delete_disable
 * JD-Core Version:    0.7.0.1
 */