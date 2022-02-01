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

public class icons_outlined_searchlogo
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(34.91217F, 25.634386F);
      ((Path)localObject2).lineTo(62.88139F, 22.10429F);
      ((Path)localObject2).cubicTo(63.703297F, 22.000555F, 64.453674F, 22.582748F, 64.557411F, 23.404654F);
      ((Path)localObject2).cubicTo(64.562668F, 23.446283F, 64.56617F, 23.488115F, 64.567917F, 23.530039F);
      ((Path)localObject2).lineTo(64.734268F, 27.522442F);
      ((Path)localObject2).cubicTo(64.768753F, 28.350151F, 64.125725F, 29.049099F, 63.298016F, 29.083588F);
      ((Path)localObject2).cubicTo(63.272408F, 29.084654F, 63.246777F, 29.085066F, 63.221146F, 29.084818F);
      ((Path)localObject2).lineTo(35.085579F, 28.814285F);
      ((Path)localObject2).cubicTo(34.262814F, 28.806374F, 33.599998F, 28.137154F, 33.599998F, 27.314354F);
      ((Path)localObject2).lineTo(33.599998F, 27.12258F);
      ((Path)localObject2).cubicTo(33.599998F, 26.366777F, 34.162315F, 25.729029F, 34.91217F, 25.634386F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.766682F, 20.061838F);
      ((Path)localObject2).lineTo(29.342863F, 3.458134F);
      ((Path)localObject2).cubicTo(29.517294F, 2.648279F, 30.315214F, 2.133165F, 31.125071F, 2.307596F);
      ((Path)localObject2).cubicTo(31.185011F, 2.320506F, 31.244104F, 2.33708F, 31.302017F, 2.357223F);
      ((Path)localObject2).lineTo(35.062096F, 3.665077F);
      ((Path)localObject2).cubicTo(35.844543F, 3.937233F, 36.258217F, 4.792157F, 35.986061F, 5.574604F);
      ((Path)localObject2).cubicTo(35.972595F, 5.613317F, 35.95755F, 5.651462F, 35.94096F, 5.688943F);
      ((Path)localObject2).lineTo(29.085533F, 21.177128F);
      ((Path)localObject2).cubicTo(28.75878F, 21.915348F, 27.906366F, 22.262547F, 27.156805F, 21.962723F);
      ((Path)localObject2).lineTo(26.675968F, 21.770388F);
      ((Path)localObject2).cubicTo(25.996847F, 21.498739F, 25.612673F, 20.776876F, 25.766682F, 20.061838F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.266468F, 28.823395F);
      ((Path)localObject2).lineTo(3.164927F, 29.070791F);
      ((Path)localObject2).cubicTo(2.336627F, 29.085321F, 1.653377F, 28.425632F, 1.638846F, 27.597334F);
      ((Path)localObject2).cubicTo(1.637931F, 27.545189F, 1.639736F, 27.493032F, 1.644254F, 27.441076F);
      ((Path)localObject2).lineTo(1.952801F, 23.892786F);
      ((Path)localObject2).cubicTo(2.024568F, 23.067472F, 2.751794F, 22.456602F, 3.577107F, 22.52837F);
      ((Path)localObject2).cubicTo(3.63907F, 22.533756F, 3.700639F, 22.542994F, 3.761456F, 22.556026F);
      ((Path)localObject2).lineTo(17.588251F, 25.518911F);
      ((Path)localObject2).cubicTo(18.335178F, 25.678967F, 18.842522F, 26.374777F, 18.766514F, 27.134871F);
      ((Path)localObject2).lineTo(18.732712F, 27.472881F);
      ((Path)localObject2).cubicTo(18.657032F, 28.229677F, 18.026922F, 28.810055F, 17.266468F, 28.823395F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.348227F, 37.991795F);
      ((Path)localObject2).lineTo(17.201086F, 62.313091F);
      ((Path)localObject2).cubicTo(16.998087F, 63.116261F, 16.182426F, 63.602798F, 15.379255F, 63.399796F);
      ((Path)localObject2).cubicTo(15.33699F, 63.389114F, 15.295212F, 63.376595F, 15.254037F, 63.362274F);
      ((Path)localObject2).lineTo(11.406978F, 62.024166F);
      ((Path)localObject2).cubicTo(10.624531F, 61.75201F, 10.210857F, 60.897087F, 10.483013F, 60.114639F);
      ((Path)localObject2).cubicTo(10.49315F, 60.085499F, 10.504183F, 60.056675F, 10.516097F, 60.028214F);
      ((Path)localObject2).lineTo(20.178617F, 36.945522F);
      ((Path)localObject2).cubicTo(20.475008F, 36.23748F, 21.258097F, 35.867428F, 21.993301F, 36.08799F);
      ((Path)localObject2).lineTo(22.32498F, 36.187492F);
      ((Path)localObject2).cubicTo(23.093952F, 36.418186F, 23.544954F, 37.213444F, 23.348227F, 37.991795F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.317963F, 35.512115F);
      ((Path)localObject2).lineTo(54.749126F, 59.141342F);
      ((Path)localObject2).cubicTo(55.305676F, 59.754974F, 55.259399F, 60.703594F, 54.645767F, 61.260143F);
      ((Path)localObject2).cubicTo(54.630245F, 61.274223F, 54.614426F, 61.287979F, 54.598324F, 61.301399F);
      ((Path)localObject2).lineTo(51.640293F, 63.766422F);
      ((Path)localObject2).cubicTo(51.00388F, 64.296768F, 50.058029F, 64.210785F, 49.527683F, 63.574368F);
      ((Path)localObject2).cubicTo(49.504158F, 63.546135F, 49.481674F, 63.517048F, 49.460285F, 63.487164F);
      ((Path)localObject2).lineTo(30.853853F, 37.492882F);
      ((Path)localObject2).cubicTo(30.37924F, 36.829819F, 30.52125F, 35.909061F, 31.173584F, 35.419811F);
      ((Path)localObject2).lineTo(31.306885F, 35.319836F);
      ((Path)localObject2).cubicTo(31.92638F, 34.855213F, 32.797729F, 34.938522F, 33.317963F, 35.512115F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_searchlogo
 * JD-Core Version:    0.7.0.1
 */