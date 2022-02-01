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

public class pardus_music_pause_icon
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
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-420614675);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.0F, 22.0F);
      ((Path)localObject2).cubicTo(17.075132F, 22.0F, 22.0F, 17.075132F, 22.0F, 11.0F);
      ((Path)localObject2).cubicTo(22.0F, 4.924868F, 17.075132F, 0.0F, 11.0F, 0.0F);
      ((Path)localObject2).cubicTo(4.924868F, 0.0F, 0.0F, 4.924868F, 0.0F, 11.0F);
      ((Path)localObject2).cubicTo(0.0F, 17.075132F, 4.924868F, 22.0F, 11.0F, 22.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-436207616);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.7F, 7.65F);
      ((Path)localObject2).cubicTo(7.7F, 7.373858F, 7.923857F, 7.15F, 8.2F, 7.15F);
      ((Path)localObject2).lineTo(9.4F, 7.15F);
      ((Path)localObject2).cubicTo(9.676142F, 7.15F, 9.9F, 7.373858F, 9.9F, 7.65F);
      ((Path)localObject2).lineTo(9.9F, 14.9F);
      ((Path)localObject2).cubicTo(9.9F, 15.176142F, 9.676142F, 15.4F, 9.4F, 15.4F);
      ((Path)localObject2).lineTo(8.2F, 15.4F);
      ((Path)localObject2).cubicTo(7.923857F, 15.4F, 7.7F, 15.176142F, 7.7F, 14.9F);
      ((Path)localObject2).lineTo(7.7F, 7.65F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(12.65F, 7.65F);
      ((Path)localObject1).cubicTo(12.65F, 7.373858F, 12.873857F, 7.15F, 13.15F, 7.15F);
      ((Path)localObject1).lineTo(14.349999F, 7.15F);
      ((Path)localObject1).cubicTo(14.626142F, 7.15F, 14.849999F, 7.373858F, 14.849999F, 7.65F);
      ((Path)localObject1).lineTo(14.849999F, 14.9F);
      ((Path)localObject1).cubicTo(14.849999F, 15.176142F, 14.626142F, 15.4F, 14.349999F, 15.4F);
      ((Path)localObject1).lineTo(13.15F, 15.4F);
      ((Path)localObject1).cubicTo(12.873857F, 15.4F, 12.65F, 15.176142F, 12.65F, 14.9F);
      ((Path)localObject1).lineTo(12.65F, 7.65F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.pardus_music_pause_icon
 * JD-Core Version:    0.7.0.1
 */