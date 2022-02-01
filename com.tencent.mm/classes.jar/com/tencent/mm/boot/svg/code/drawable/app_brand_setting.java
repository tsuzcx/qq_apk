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

public class app_brand_setting
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
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -1592.0F, 0.0F, 1.0F, -216.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1592.0F, 0.0F, 1.0F, 216.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(43.0F, 71.375237F);
      ((Path)localObject2).cubicTo(40.388981F, 70.747978F, 37.947521F, 69.685074F, 35.756817F, 68.267685F);
      ((Path)localObject2).lineTo(33.071095F, 70.953415F);
      ((Path)localObject2).cubicTo(32.744633F, 71.280716F, 32.349525F, 71.443947F, 31.887455F, 71.443947F);
      ((Path)localObject2).cubicTo(31.425385F, 71.443947F, 31.030279F, 71.280716F, 30.703815F, 70.953415F);
      ((Path)localObject2).lineTo(25.968422F, 66.218018F);
      ((Path)localObject2).cubicTo(25.641121F, 65.891556F, 25.47789F, 65.496452F, 25.47789F, 65.034378F);
      ((Path)localObject2).cubicTo(25.47789F, 64.572304F, 25.641121F, 64.1772F, 25.968422F, 63.850739F);
      ((Path)localObject2).lineTo(28.676521F, 61.142639F);
      ((Path)localObject2).cubicTo(27.294926F, 58.977337F, 26.258167F, 56.570663F, 25.643635F, 54.0F);
      ((Path)localObject2).lineTo(21.67647F, 54.0F);
      ((Path)localObject2).cubicTo(21.213764F, 54.0F, 20.818117F, 53.837502F, 20.491205F, 53.511665F);
      ((Path)localObject2).cubicTo(20.163456F, 53.186668F, 20.0F, 52.793335F, 20.0F, 52.333332F);
      ((Path)localObject2).lineTo(20.0F, 45.666668F);
      ((Path)localObject2).cubicTo(20.0F, 45.206665F, 20.163456F, 44.813332F, 20.491205F, 44.488335F);
      ((Path)localObject2).cubicTo(20.818117F, 44.162498F, 21.213764F, 44.0F, 21.67647F, 44.0F);
      ((Path)localObject2).lineTo(25.432756F, 44.0F);
      ((Path)localObject2).cubicTo(25.968296F, 41.245472F, 26.984692F, 38.662666F, 28.391035F, 36.342514F);
      ((Path)localObject2).lineTo(25.513884F, 33.465363F);
      ((Path)localObject2).cubicTo(25.186583F, 33.137226F, 25.022514F, 32.742958F, 25.022514F, 32.279213F);
      ((Path)localObject2).cubicTo(25.022514F, 31.816303F, 25.186583F, 31.421198F, 25.513884F, 31.093899F);
      ((Path)localObject2).lineTo(30.256813F, 26.350969F);
      ((Path)localObject2).cubicTo(30.584112F, 26.02367F, 30.979218F, 25.8596F, 31.442125F, 25.8596F);
      ((Path)localObject2).cubicTo(31.905033F, 25.8596F, 32.30014F, 26.02367F, 32.628277F, 26.350969F);
      ((Path)localObject2).lineTo(35.322765F, 29.045517F);
      ((Path)localObject2).cubicTo(37.623291F, 27.483685F, 40.215202F, 26.318954F, 43.0F, 25.649855F);
      ((Path)localObject2).lineTo(43.0F, 21.67647F);
      ((Path)localObject2).cubicTo(43.0F, 21.213764F, 43.162498F, 20.818117F, 43.488335F, 20.491205F);
      ((Path)localObject2).cubicTo(43.813332F, 20.164293F, 44.206665F, 20.0F, 44.666668F, 20.0F);
      ((Path)localObject2).lineTo(51.333332F, 20.0F);
      ((Path)localObject2).cubicTo(51.793335F, 20.0F, 52.186668F, 20.164293F, 52.511665F, 20.491205F);
      ((Path)localObject2).cubicTo(52.837502F, 20.818117F, 53.0F, 21.213764F, 53.0F, 21.67647F);
      ((Path)localObject2).lineTo(53.0F, 25.427748F);
      ((Path)localObject2).cubicTo(55.947445F, 25.99736F, 58.698654F, 27.117449F, 61.14241F, 28.676748F);
      ((Path)localObject2).lineTo(63.850739F, 25.968422F);
      ((Path)localObject2).cubicTo(64.1772F, 25.641121F, 64.572304F, 25.47789F, 65.034378F, 25.47789F);
      ((Path)localObject2).cubicTo(65.496452F, 25.47789F, 65.891556F, 25.641121F, 66.218018F, 25.968422F);
      ((Path)localObject2).lineTo(70.953415F, 30.703815F);
      ((Path)localObject2).cubicTo(71.280716F, 31.031116F, 71.443947F, 31.425385F, 71.443947F, 31.887455F);
      ((Path)localObject2).cubicTo(71.443947F, 32.350365F, 71.280716F, 32.744633F, 70.953415F, 33.071095F);
      ((Path)localObject2).lineTo(68.267441F, 35.757065F);
      ((Path)localObject2).cubicTo(69.864319F, 38.225166F, 71.011284F, 41.011517F, 71.592278F, 44.0F);
      ((Path)localObject2).lineTo(75.323532F, 44.0F);
      ((Path)localObject2).cubicTo(75.786232F, 44.0F, 76.181885F, 44.162498F, 76.508797F, 44.488335F);
      ((Path)localObject2).cubicTo(76.836548F, 44.813332F, 77.0F, 45.206665F, 77.0F, 45.666668F);
      ((Path)localObject2).lineTo(77.0F, 52.333332F);
      ((Path)localObject2).cubicTo(77.0F, 52.793335F, 76.836548F, 53.186668F, 76.508797F, 53.511665F);
      ((Path)localObject2).cubicTo(76.181885F, 53.837502F, 75.786232F, 54.0F, 75.323532F, 54.0F);
      ((Path)localObject2).lineTo(71.381409F, 54.0F);
      ((Path)localObject2).cubicTo(70.713364F, 56.794682F, 69.546326F, 59.395546F, 67.979698F, 61.703171F);
      ((Path)localObject2).lineTo(70.570862F, 64.294395F);
      ((Path)localObject2).cubicTo(70.898163F, 64.620857F, 71.062233F, 65.0168F, 71.062233F, 65.479706F);
      ((Path)localObject2).cubicTo(71.062233F, 65.942619F, 70.898163F, 66.338554F, 70.570862F, 66.665024F);
      ((Path)localObject2).lineTo(65.827934F, 71.407951F);
      ((Path)localObject2).cubicTo(65.500633F, 71.736084F, 65.10553F, 71.899323F, 64.642624F, 71.899323F);
      ((Path)localObject2).cubicTo(64.17971F, 71.899323F, 63.784611F, 71.736084F, 63.45647F, 71.407951F);
      ((Path)localObject2).lineTo(60.682983F, 68.63446F);
      ((Path)localObject2).cubicTo(58.355732F, 70.045006F, 55.764164F, 71.063202F, 53.0F, 71.597313F);
      ((Path)localObject2).lineTo(53.0F, 75.323532F);
      ((Path)localObject2).cubicTo(53.0F, 75.787071F, 52.837502F, 76.181885F, 52.511665F, 76.508797F);
      ((Path)localObject2).cubicTo(52.186668F, 76.836548F, 51.793335F, 77.0F, 51.333332F, 77.0F);
      ((Path)localObject2).lineTo(44.666668F, 77.0F);
      ((Path)localObject2).cubicTo(44.206665F, 77.0F, 43.813332F, 76.836548F, 43.488335F, 76.508797F);
      ((Path)localObject2).cubicTo(43.162498F, 76.181885F, 43.0F, 75.787071F, 43.0F, 75.323532F);
      ((Path)localObject2).lineTo(43.0F, 71.375237F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(48.415051F, 30.0F);
      ((Path)localObject2).cubicTo(58.586479F, 30.0F, 66.831772F, 38.244457F, 66.831772F, 48.415886F);
      ((Path)localObject2).cubicTo(66.831772F, 58.586479F, 58.586479F, 66.831772F, 48.415051F, 66.831772F);
      ((Path)localObject2).cubicTo(38.245296F, 66.831772F, 30.0F, 58.586479F, 30.0F, 48.415886F);
      ((Path)localObject2).cubicTo(30.0F, 38.244457F, 38.245296F, 30.0F, 48.415051F, 30.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_setting
 * JD-Core Version:    0.7.0.1
 */