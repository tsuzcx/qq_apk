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

public class app_brand_video_fullscreen_danmaku_showed_btn
  extends c
{
  private final int height = 67;
  private final int width = 156;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 156;
      return 67;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -353.0F, 0.0F, 1.0F, -237.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 353.0F, 0.0F, 1.0F, 237.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16139513);
      ((Paint)localObject1).setStrokeWidth(4.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.0F, 33.5F);
      ((Path)localObject2).cubicTo(2.0F, 16.103029F, 16.103029F, 2.0F, 33.5F, 2.0F);
      ((Path)localObject2).lineTo(122.5F, 2.0F);
      ((Path)localObject2).cubicTo(139.89697F, 2.0F, 154.0F, 16.103029F, 154.0F, 33.5F);
      ((Path)localObject2).lineTo(154.0F, 33.5F);
      ((Path)localObject2).cubicTo(154.0F, 50.896973F, 139.89697F, 65.0F, 122.5F, 65.0F);
      ((Path)localObject2).lineTo(33.5F, 65.0F);
      ((Path)localObject2).cubicTo(16.103029F, 65.0F, 2.0F, 50.896973F, 2.0F, 33.5F);
      ((Path)localObject2).lineTo(2.0F, 33.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16139513);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(45.341103F, 26.941479F);
      ((Path)localObject1).lineTo(52.543945F, 26.941479F);
      ((Path)localObject1).lineTo(52.543945F, 16.137213F);
      ((Path)localObject1).lineTo(42.314373F, 16.137213F);
      ((Path)localObject1).lineTo(42.314373F, 18.550932F);
      ((Path)localObject1).lineTo(49.862038F, 18.550932F);
      ((Path)localObject1).lineTo(49.862038F, 24.52776F);
      ((Path)localObject1).lineTo(42.889069F, 24.52776F);
      ((Path)localObject1).lineTo(41.892933F, 35.561905F);
      ((Path)localObject1).lineTo(50.245167F, 35.561905F);
      ((Path)localObject1).cubicTo(50.245167F, 40.159462F, 50.0536F, 43.224503F, 49.670471F, 44.680397F);
      ((Path)localObject1).cubicTo(49.325653F, 46.059666F, 48.02301F, 46.787613F, 45.762547F, 46.787613F);
      ((Path)localObject1).cubicTo(44.804718F, 46.787613F, 43.885208F, 46.710987F, 42.965694F, 46.634361F);
      ((Path)localObject1).lineTo(43.655331F, 49.201332F);
      ((Path)localObject1).cubicTo(44.574841F, 49.277958F, 45.494354F, 49.354584F, 46.375553F, 49.354584F);
      ((Path)localObject1).cubicTo(49.785408F, 49.201332F, 51.739372F, 48.051941F, 52.237442F, 45.829788F);
      ((Path)localObject1).cubicTo(52.620571F, 43.837513F, 52.850449F, 39.584766F, 52.850449F, 33.148186F);
      ((Path)localObject1).lineTo(44.689781F, 33.148186F);
      ((Path)localObject1).lineTo(45.341103F, 26.941479F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(55.838863F, 20.734772F);
      ((Path)localObject1).lineTo(66.987946F, 20.734772F);
      ((Path)localObject1).cubicTo(68.137337F, 18.665871F, 69.095161F, 16.520342F, 69.938049F, 14.259875F);
      ((Path)localObject1).lineTo(72.581642F, 15.179387F);
      ((Path)localObject1).cubicTo(71.738762F, 17.248289F, 70.780937F, 19.125626F, 69.708168F, 20.734772F);
      ((Path)localObject1).lineTo(74.688858F, 20.734772F);
      ((Path)localObject1).lineTo(74.688858F, 36.098286F);
      ((Path)localObject1).lineTo(66.528191F, 36.098286F);
      ((Path)localObject1).lineTo(66.528191F, 39.814648F);
      ((Path)localObject1).lineTo(76.374634F, 39.814648F);
      ((Path)localObject1).lineTo(76.374634F, 42.381618F);
      ((Path)localObject1).lineTo(66.528191F, 42.381618F);
      ((Path)localObject1).lineTo(66.528191F, 49.737713F);
      ((Path)localObject1).lineTo(63.846279F, 49.737713F);
      ((Path)localObject1).lineTo(63.846279F, 42.381618F);
      ((Path)localObject1).lineTo(54.153091F, 42.381618F);
      ((Path)localObject1).lineTo(54.153091F, 39.814648F);
      ((Path)localObject1).lineTo(63.846279F, 39.814648F);
      ((Path)localObject1).lineTo(63.846279F, 36.098286F);
      ((Path)localObject1).lineTo(55.838863F, 36.098286F);
      ((Path)localObject1).lineTo(55.838863F, 20.734772F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(72.198517F, 33.761192F);
      ((Path)localObject1).lineTo(72.198517F, 29.623388F);
      ((Path)localObject1).lineTo(66.528191F, 29.623388F);
      ((Path)localObject1).lineTo(66.528191F, 33.761192F);
      ((Path)localObject1).lineTo(72.198517F, 33.761192F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(63.846279F, 33.761192F);
      ((Path)localObject1).lineTo(63.846279F, 29.623388F);
      ((Path)localObject1).lineTo(58.290897F, 29.623388F);
      ((Path)localObject1).lineTo(58.290897F, 33.761192F);
      ((Path)localObject1).lineTo(63.846279F, 33.761192F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(58.290897F, 27.324608F);
      ((Path)localObject1).lineTo(63.846279F, 27.324608F);
      ((Path)localObject1).lineTo(63.846279F, 23.071865F);
      ((Path)localObject1).lineTo(58.290897F, 23.071865F);
      ((Path)localObject1).lineTo(58.290897F, 27.324608F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(66.528191F, 23.071865F);
      ((Path)localObject1).lineTo(66.528191F, 27.324608F);
      ((Path)localObject1).lineTo(72.198517F, 27.324608F);
      ((Path)localObject1).lineTo(72.198517F, 23.071865F);
      ((Path)localObject1).lineTo(66.528191F, 23.071865F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(60.359798F, 14.489753F);
      ((Path)localObject1).cubicTo(61.50919F, 16.060587F, 62.505325F, 17.746359F, 63.348213F, 19.508757F);
      ((Path)localObject1).lineTo(60.972805F, 20.543207F);
      ((Path)localObject1).cubicTo(60.053295F, 18.550932F, 58.98053F, 16.826847F, 57.831139F, 15.294326F);
      ((Path)localObject1).lineTo(60.359798F, 14.489753F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(95.952576F, 37.515865F);
      ((Path)localObject1).lineTo(98.557861F, 37.515865F);
      ((Path)localObject1).lineTo(98.557861F, 40.197777F);
      ((Path)localObject1).lineTo(107.40816F, 40.197777F);
      ((Path)localObject1).cubicTo(105.33926F, 38.97176F, 103.73012F, 37.669117F, 102.58073F, 36.213223F);
      ((Path)localObject1).lineTo(92.657654F, 36.213223F);
      ((Path)localObject1).cubicTo(91.316704F, 37.669117F, 89.630928F, 39.010075F, 87.600342F, 40.197777F);
      ((Path)localObject1).lineTo(95.952576F, 40.197777F);
      ((Path)localObject1).lineTo(95.952576F, 37.515865F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(95.952576F, 42.304993F);
      ((Path)localObject1).lineTo(88.711418F, 42.304993F);
      ((Path)localObject1).lineTo(88.711418F, 48.703262F);
      ((Path)localObject1).lineTo(86.106133F, 48.703262F);
      ((Path)localObject1).lineTo(86.106133F, 41.00235F);
      ((Path)localObject1).cubicTo(84.496986F, 41.806923F, 82.772903F, 42.53487F, 80.933876F, 43.186192F);
      ((Path)localObject1).lineTo(79.746178F, 40.887409F);
      ((Path)localObject1).cubicTo(83.88398F, 39.584766F, 87.102272F, 38.05225F, 89.36274F, 36.213223F);
      ((Path)localObject1).lineTo(80.704002F, 36.213223F);
      ((Path)localObject1).lineTo(80.704002F, 33.914444F);
      ((Path)localObject1).lineTo(91.584892F, 33.914444F);
      ((Path)localObject1).cubicTo(92.044647F, 33.263123F, 92.42778F, 32.611801F, 92.734283F, 31.922169F);
      ((Path)localObject1).lineTo(84.918434F, 31.922169F);
      ((Path)localObject1).lineTo(84.918434F, 21.769222F);
      ((Path)localObject1).lineTo(89.36274F, 21.769222F);
      ((Path)localObject1).lineTo(89.36274F, 19.317192F);
      ((Path)localObject1).lineTo(80.244247F, 19.317192F);
      ((Path)localObject1).lineTo(80.244247F, 17.056725F);
      ((Path)localObject1).lineTo(89.36274F, 17.056725F);
      ((Path)localObject1).lineTo(89.36274F, 14.489753F);
      ((Path)localObject1).lineTo(92.006332F, 14.489753F);
      ((Path)localObject1).lineTo(92.006332F, 17.056725F);
      ((Path)localObject1).lineTo(102.38916F, 17.056725F);
      ((Path)localObject1).lineTo(102.38916F, 14.489753F);
      ((Path)localObject1).lineTo(105.03275F, 14.489753F);
      ((Path)localObject1).lineTo(105.03275F, 17.056725F);
      ((Path)localObject1).lineTo(114.15125F, 17.056725F);
      ((Path)localObject1).lineTo(114.15125F, 19.317192F);
      ((Path)localObject1).lineTo(105.03275F, 19.317192F);
      ((Path)localObject1).lineTo(105.03275F, 21.769222F);
      ((Path)localObject1).lineTo(109.47707F, 21.769222F);
      ((Path)localObject1).lineTo(109.47707F, 31.922169F);
      ((Path)localObject1).lineTo(95.301254F, 31.922169F);
      ((Path)localObject1).cubicTo(95.033066F, 32.611801F, 94.726563F, 33.263123F, 94.34343F, 33.914444F);
      ((Path)localObject1).lineTo(113.65318F, 33.914444F);
      ((Path)localObject1).lineTo(113.65318F, 36.213223F);
      ((Path)localObject1).lineTo(105.37757F, 36.213223F);
      ((Path)localObject1).cubicTo(107.48479F, 38.090561F, 110.62646F, 39.584766F, 114.76426F, 40.657532F);
      ((Path)localObject1).lineTo(113.65318F, 42.956314F);
      ((Path)localObject1).cubicTo(111.89079F, 42.343304F, 110.35826F, 41.730297F, 109.05562F, 41.078976F);
      ((Path)localObject1).lineTo(109.05562F, 45.714848F);
      ((Path)localObject1).cubicTo(109.05562F, 47.707123F, 107.94454F, 48.741573F, 105.72239F, 48.741573F);
      ((Path)localObject1).lineTo(102.8106F, 48.741573F);
      ((Path)localObject1).lineTo(102.23591F, 46.442795F);
      ((Path)localObject1).lineTo(104.95613F, 46.519421F);
      ((Path)localObject1).cubicTo(105.95227F, 46.519421F, 106.45034F, 46.059666F, 106.45034F, 45.140152F);
      ((Path)localObject1).lineTo(106.45034F, 42.304993F);
      ((Path)localObject1).lineTo(98.557861F, 42.304993F);
      ((Path)localObject1).lineTo(98.557861F, 49.661087F);
      ((Path)localObject1).lineTo(95.952576F, 49.661087F);
      ((Path)localObject1).lineTo(95.952576F, 42.304993F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(102.38916F, 19.317192F);
      ((Path)localObject1).lineTo(92.006332F, 19.317192F);
      ((Path)localObject1).lineTo(92.006332F, 21.769222F);
      ((Path)localObject1).lineTo(102.38916F, 21.769222F);
      ((Path)localObject1).lineTo(102.38916F, 19.317192F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(106.87178F, 30.006517F);
      ((Path)localObject1).lineTo(106.87178F, 27.707739F);
      ((Path)localObject1).lineTo(87.523712F, 27.707739F);
      ((Path)localObject1).lineTo(87.523712F, 30.006517F);
      ((Path)localObject1).lineTo(106.87178F, 30.006517F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(87.523712F, 25.907026F);
      ((Path)localObject1).lineTo(106.87178F, 25.907026F);
      ((Path)localObject1).lineTo(106.87178F, 23.761499F);
      ((Path)localObject1).lineTo(87.523712F, 23.761499F);
      ((Path)localObject1).lineTo(87.523712F, 25.907026F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_video_fullscreen_danmaku_showed_btn
 * JD-Core Version:    0.7.0.1
 */