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

public class sos_question_icon
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setColor(-4210753);
      localPaint2.setStrokeWidth(2.375F);
      localPaint2.setStrokeCap(Paint.Cap.ROUND);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(26.966852F, 0.0F);
      ((Path)localObject2).lineTo(4.337496F, 0.0F);
      ((Path)localObject2).cubicTo(2.001921F, 0.0F, 0.0F, 2.029032F, 0.0F, 4.654839F);
      ((Path)localObject2).lineTo(0.0F, 24.467741F);
      ((Path)localObject2).cubicTo(0.0F, 26.974194F, 1.890703F, 29.122581F, 4.337496F, 29.122581F);
      ((Path)localObject2).lineTo(8.230121F, 29.122581F);
      ((Path)localObject2).lineTo(8.230121F, 36.403225F);
      ((Path)localObject2).lineTo(16.793894F, 29.122581F);
      ((Path)localObject2).lineTo(26.966852F, 29.122581F);
      ((Path)localObject2).cubicTo(29.302427F, 29.122581F, 31.304348F, 27.093548F, 31.304348F, 24.467741F);
      ((Path)localObject2).lineTo(31.304348F, 4.654839F);
      ((Path)localObject2).cubicTo(31.19313F, 2.148387F, 29.302427F, 0.0F, 26.966852F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-4210753);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(14.599606F, 19.08865F);
      ((Path)localObject1).lineTo(17.538462F, 19.08865F);
      ((Path)localObject1).lineTo(17.538462F, 22.0F);
      ((Path)localObject1).lineTo(14.599606F, 22.0F);
      ((Path)localObject1).lineTo(14.599606F, 19.08865F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(12.962524F, 7.765615F);
      ((Path)localObject1).cubicTo(13.738334F, 7.255202F, 14.691645F, 7.0F, 15.822485F, 7.0F);
      ((Path)localObject1).cubicTo(17.308357F, 7.0F, 18.54273F, 7.362656F, 19.52564F, 8.087978F);
      ((Path)localObject1).cubicTo(20.508553F, 8.813301F, 21.0F, 9.887837F, 21.0F, 11.311619F);
      ((Path)localObject1).cubicTo(21.0F, 12.184692F, 20.786327F, 12.920077F, 20.358974F, 13.517797F);
      ((Path)localObject1).cubicTo(20.109137F, 13.880459F, 19.629194F, 14.343852F, 18.919132F, 14.907992F);
      ((Path)localObject1).lineTo(18.218935F, 15.462055F);
      ((Path)localObject1).cubicTo(17.837605F, 15.764273F, 17.584484F, 16.116856F, 17.459566F, 16.519812F);
      ((Path)localObject1).cubicTo(17.380671F, 16.775019F, 17.337936F, 17.171253F, 17.331362F, 17.708529F);
      ((Path)localObject1).lineTo(14.668639F, 17.708529F);
      ((Path)localObject1).cubicTo(14.708087F, 16.573534F, 14.81328F, 15.789458F, 14.984221F, 15.356279F);
      ((Path)localObject1).cubicTo(15.155162F, 14.9231F, 15.595657F, 14.424449F, 16.305719F, 13.860309F);
      ((Path)localObject1).lineTo(17.02564F, 13.286098F);
      ((Path)localObject1).cubicTo(17.262329F, 13.104768F, 17.452991F, 12.90665F, 17.597633F, 12.691739F);
      ((Path)localObject1).cubicTo(17.860619F, 12.322362F, 17.992111F, 11.916054F, 17.992111F, 11.4728F);
      ((Path)localObject1).cubicTo(17.992111F, 10.962388F, 17.845827F, 10.497315F, 17.553255F, 10.077569F);
      ((Path)localObject1).cubicTo(17.260683F, 9.657822F, 16.7265F, 9.447951F, 15.95069F, 9.447951F);
      ((Path)localObject1).cubicTo(15.18803F, 9.447951F, 14.647273F, 9.706512F, 14.328403F, 10.22364F);
      ((Path)localObject1).cubicTo(14.009532F, 10.740768F, 13.850099F, 11.278036F, 13.850099F, 11.83546F);
      ((Path)localObject1).lineTo(11.0F, 11.83546F);
      ((Path)localObject1).cubicTo(11.078896F, 9.921414F, 11.733065F, 8.564813F, 12.962524F, 7.765615F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sos_question_icon
 * JD-Core Version:    0.7.0.1
 */