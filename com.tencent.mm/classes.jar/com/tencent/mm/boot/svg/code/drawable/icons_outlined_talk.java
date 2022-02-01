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

public class icons_outlined_talk
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.149248F, 8.000936F);
      ((Path)localObject2).cubicTo(17.128059F, 7.950083F, 17.105125F, 7.899974F, 17.080488F, 7.8507F);
      ((Path)localObject2).cubicTo(16.487715F, 6.665152F, 15.0461F, 6.184613F, 13.860551F, 6.777387F);
      ((Path)localObject2).lineTo(3.6F, 11.907662F);
      ((Path)localObject2).lineTo(3.6F, 46.308914F);
      ((Path)localObject2).lineTo(15.392785F, 51.362965F);
      ((Path)localObject2).cubicTo(15.569283F, 51.438606F, 15.754222F, 51.492794F, 15.943634F, 51.524361F);
      ((Path)localObject2).cubicTo(17.251083F, 51.742271F, 18.487629F, 50.859024F, 18.705536F, 49.551575F);
      ((Path)localObject2).lineTo(20.805315F, 36.952904F);
      ((Path)localObject2).lineTo(28.187292F, 34.492241F);
      ((Path)localObject2).lineTo(17.149248F, 8.000936F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(29.938093F, 37.703377F);
      ((Path)localObject2).lineTo(24.0F, 39.682739F);
      ((Path)localObject2).lineTo(22.256556F, 50.14341F);
      ((Path)localObject2).cubicTo(21.711784F, 53.412033F, 18.620419F, 55.620152F, 15.351797F, 55.075378F);
      ((Path)localObject2).cubicTo(14.878268F, 54.99646F, 14.415921F, 54.860992F, 13.974675F, 54.671886F);
      ((Path)localObject2).lineTo(1.818242F, 49.461987F);
      ((Path)localObject2).cubicTo(0.7151906F, 48.98925F, -2.182254E-011F, 47.904636F, -2.182254E-011F, 46.704552F);
      ((Path)localObject2).lineTo(-2.182787E-011F, 11.536842F);
      ((Path)localObject2).cubicTo(-2.182787E-011F, 10.400526F, 0.6420071F, 9.361736F, 1.658359F, 8.85356F);
      ((Path)localObject2).lineTo(12.250582F, 3.557449F);
      ((Path)localObject2).cubicTo(15.214453F, 2.075514F, 18.818491F, 3.27686F, 20.300426F, 6.240731F);
      ((Path)localObject2).cubicTo(20.36202F, 6.363917F, 20.419353F, 6.489188F, 20.472324F, 6.61632F);
      ((Path)localObject2).lineTo(31.758642F, 33.70348F);
      ((Path)localObject2).cubicTo(32.395893F, 35.232883F, 31.672661F, 36.989304F, 30.143257F, 37.626556F);
      ((Path)localObject2).cubicTo(30.075827F, 37.654652F, 30.007395F, 37.680275F, 29.938093F, 37.703377F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.42498F, 47.42498F);
      ((Path)localObject2).cubicTo(45.228367F, 43.62159F, 47.400002F, 38.48727F, 47.400002F, 33.0F);
      ((Path)localObject2).cubicTo(47.400002F, 27.51273F, 45.228367F, 22.378408F, 41.42498F, 18.575022F);
      ((Path)localObject2).lineTo(43.970562F, 16.029438F);
      ((Path)localObject2).cubicTo(48.313709F, 20.372583F, 51.0F, 26.372583F, 51.0F, 33.0F);
      ((Path)localObject2).cubicTo(51.0F, 39.627419F, 48.313709F, 45.627419F, 43.970562F, 49.970562F);
      ((Path)localObject2).lineTo(41.42498F, 47.42498F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(35.485283F, 41.485283F);
      ((Path)localObject2).cubicTo(37.72353F, 39.247032F, 39.0F, 36.229118F, 39.0F, 33.0F);
      ((Path)localObject2).cubicTo(39.0F, 29.770882F, 37.72353F, 26.752968F, 35.485283F, 24.514719F);
      ((Path)localObject2).lineTo(38.030865F, 21.969133F);
      ((Path)localObject2).cubicTo(40.853912F, 24.792179F, 42.599998F, 28.692179F, 42.599998F, 33.0F);
      ((Path)localObject2).cubicTo(42.599998F, 37.307819F, 40.853912F, 41.207821F, 38.030865F, 44.030865F);
      ((Path)localObject2).lineTo(35.485283F, 41.485283F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_talk
 * JD-Core Version:    0.7.0.1
 */