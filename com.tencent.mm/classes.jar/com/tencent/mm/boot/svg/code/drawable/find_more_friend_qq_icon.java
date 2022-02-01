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

public class find_more_friend_qq_icon
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint1.setColor(-11615450);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 22.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(41.933807F, 49.914906F);
      ((Path)localObject2).cubicTo(41.570644F, 50.311275F, 41.227612F, 50.729294F, 40.838451F, 51.097359F);
      ((Path)localObject2).cubicTo(40.487732F, 51.429058F, 40.524216F, 51.570423F, 40.975719F, 51.734291F);
      ((Path)localObject2).cubicTo(42.136913F, 52.155849F, 43.283291F, 52.604858F, 44.197063F, 53.508537F);
      ((Path)localObject2).cubicTo(45.815495F, 55.109009F, 45.704506F, 56.791981F, 43.832924F, 58.101368F);
      ((Path)localObject2).cubicTo(42.38126F, 59.11684F, 40.708591F, 59.570095F, 38.99329F, 59.777122F);
      ((Path)localObject2).cubicTo(36.101559F, 60.126083F, 33.230656F, 59.966743F, 30.452709F, 58.994011F);
      ((Path)localObject2).cubicTo(29.062269F, 58.507076F, 27.749409F, 57.874245F, 26.70116F, 56.759575F);
      ((Path)localObject2).cubicTo(26.343731F, 56.379482F, 25.728397F, 56.389385F, 25.382849F, 56.742737F);
      ((Path)localObject2).cubicTo(23.635817F, 58.529011F, 21.405548F, 59.240093F, 19.074354F, 59.648209F);
      ((Path)localObject2).cubicTo(16.275162F, 60.138256F, 13.471354F, 60.077831F, 10.716473F, 59.261181F);
      ((Path)localObject2).cubicTo(9.564925F, 58.919716F, 8.479775F, 58.441273F, 7.610591F, 57.578491F);
      ((Path)localObject2).cubicTo(6.426054F, 56.402687F, 6.420322F, 55.089905F, 7.533151F, 53.832027F);
      ((Path)localObject2).cubicTo(8.453495F, 52.791653F, 9.666688F, 52.2658F, 10.912312F, 51.786369F);
      ((Path)localObject2).cubicTo(11.107172F, 51.711369F, 11.305247F, 51.645142F, 11.596419F, 51.540989F);
      ((Path)localObject2).cubicTo(9.618183F, 49.404907F, 7.894914F, 47.146839F, 7.034678F, 44.239952F);
      ((Path)localObject2).cubicTo(6.190376F, 45.195282F, 5.394721F, 46.07349F, 4.440828F, 46.780331F);
      ((Path)localObject2).cubicTo(3.779506F, 47.270378F, 3.084774F, 47.680897F, 2.271226F, 47.871792F);
      ((Path)localObject2).cubicTo(1.735011F, 47.997593F, 1.362484F, 47.824245F, 1.097032F, 47.363632F);
      ((Path)localObject2).cubicTo(0.382591F, 46.124149F, 0.2373548F, 44.738632F, 0.1548817F, 43.353256F);
      ((Path)localObject2).cubicTo(-0.1224516F, 38.69363F, 1.322785F, 34.514858F, 3.579892F, 30.527548F);
      ((Path)localObject2).cubicTo(4.862279F, 28.262264F, 5.965323F, 25.893255F, 6.504473F, 23.300518F);
      ((Path)localObject2).cubicTo(6.751054F, 22.114952F, 6.751613F, 20.91283F, 6.81871F, 19.717075F);
      ((Path)localObject2).cubicTo(7.093387F, 14.825802F, 8.74914F, 10.514717F, 11.910377F, 6.779717F);
      ((Path)localObject2).cubicTo(14.765344F, 3.406415F, 18.378225F, 1.300613F, 22.616924F, 0.45467F);
      ((Path)localObject2).cubicTo(27.057194F, -0.4316038F, 31.315882F, 0.337217F, 35.249432F, 2.695896F);
      ((Path)localObject2).cubicTo(40.823635F, 6.038349F, 43.90184F, 11.066604F, 45.018581F, 17.439623F);
      ((Path)localObject2).cubicTo(45.276203F, 18.910048F, 45.219173F, 20.39632F, 45.35099F, 21.871557F);
      ((Path)localObject2).cubicTo(45.56612F, 24.281038F, 46.480171F, 26.463255F, 47.490536F, 28.621273F);
      ((Path)localObject2).cubicTo(48.358044F, 30.473915F, 49.474365F, 32.196083F, 50.252827F, 34.092735F);
      ((Path)localObject2).cubicTo(51.863708F, 38.017502F, 52.443676F, 42.047688F, 51.442539F, 46.235378F);
      ((Path)localObject2).cubicTo(51.409828F, 46.372074F, 51.368591F, 46.5075F, 51.321342F, 46.639671F);
      ((Path)localObject2).cubicTo(50.854042F, 47.947216F, 50.269463F, 48.209152F, 49.03027F, 47.634197F);
      ((Path)localObject2).cubicTo(47.603622F, 46.972218F, 46.486183F, 45.911179F, 45.462257F, 44.736794F);
      ((Path)localObject2).cubicTo(45.341763F, 44.598537F, 45.231194F, 44.451225F, 45.045979F, 44.220989F);
      ((Path)localObject2).cubicTo(44.432041F, 46.287029F, 43.348289F, 48.0F, 42.15844F, 49.652973F);
      ((Path)localObject2).cubicTo(42.153828F, 49.801414F, 42.032215F, 49.847973F, 41.933807F, 49.914906F);
      ((Path)localObject2).lineTo(41.933807F, 49.914906F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.find_more_friend_qq_icon
 * JD-Core Version:    0.7.0.1
 */