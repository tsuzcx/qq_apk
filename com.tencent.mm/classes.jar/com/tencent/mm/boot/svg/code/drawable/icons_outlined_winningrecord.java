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

public class icons_outlined_winningrecord
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.997904F, 2.0F);
      localPath.lineTo(20.0F, 8.0F);
      localPath.lineTo(20.0F, 21.001354F);
      localPath.cubicTo(20.0F, 21.55423F, 19.554161F, 22.0F, 19.004192F, 22.0F);
      localPath.lineTo(4.995809F, 22.0F);
      localPath.cubicTo(4.44892F, 22.0F, 4.0F, 21.552891F, 4.0F, 21.001354F);
      localPath.lineTo(4.0F, 2.998646F);
      localPath.cubicTo(4.0F, 2.44577F, 4.445839F, 2.0F, 4.995809F, 2.0F);
      localPath.lineTo(13.997904F, 2.0F);
      localPath.close();
      localPath.moveTo(12.399F, 3.199F);
      localPath.lineTo(5.2F, 3.2F);
      localPath.lineTo(5.2F, 20.799999F);
      localPath.lineTo(18.799999F, 20.799999F);
      localPath.lineTo(18.799F, 9.6F);
      localPath.lineTo(14.0F, 9.6F);
      localPath.cubicTo(13.116344F, 9.6F, 12.4F, 8.883656F, 12.4F, 8.0F);
      localPath.lineTo(12.399F, 3.199F);
      localPath.close();
      localPath.moveTo(18.702F, 8.4F);
      localPath.lineTo(13.599F, 3.298F);
      localPath.lineTo(13.6F, 8.0F);
      localPath.cubicTo(13.6F, 8.220914F, 13.779086F, 8.4F, 14.0F, 8.4F);
      localPath.lineTo(18.702F, 8.4F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 9.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 3.0F);
      ((Path)localObject2).lineTo(7.5F, 3.0F);
      ((Path)localObject2).lineTo(7.5F, 4.2F);
      ((Path)localObject2).lineTo(0.0F, 4.2F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 6.0F);
      ((Path)localObject2).lineTo(4.0F, 6.0F);
      ((Path)localObject2).lineTo(4.0F, 7.2F);
      ((Path)localObject2).lineTo(0.0F, 7.2F);
      ((Path)localObject2).lineTo(0.0F, 6.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, -1.110223E-016F);
      ((Path)localObject1).lineTo(4.0F, -1.110223E-016F);
      ((Path)localObject1).lineTo(4.0F, 1.2F);
      ((Path)localObject1).lineTo(0.0F, 1.2F);
      ((Path)localObject1).lineTo(0.0F, -1.110223E-016F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_winningrecord
 * JD-Core Version:    0.7.0.1
 */