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

public class kids_watch_default_avatar
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-526345);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, -2.449294E-016F, 8.817457E-015F, 2.449294E-016F, 1.0F, -7.105427E-015F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(20.511082F, -8.286722E-016F);
      localPath.lineTo(51.488918F, 8.286722E-016F);
      localPath.cubicTo(58.621067F, -4.814824E-016F, 61.207359F, 0.7426049F, 63.814766F, 2.137062F);
      localPath.cubicTo(66.422173F, 3.531519F, 68.468483F, 5.577827F, 69.862938F, 8.185234F);
      localPath.cubicTo(71.257393F, 10.792642F, 72.0F, 13.378932F, 72.0F, 20.511082F);
      localPath.lineTo(72.0F, 51.488918F);
      localPath.cubicTo(72.0F, 58.621067F, 71.257393F, 61.207359F, 69.862938F, 63.814766F);
      localPath.cubicTo(68.468483F, 66.422173F, 66.422173F, 68.468483F, 63.814766F, 69.862938F);
      localPath.cubicTo(61.207359F, 71.257393F, 58.621067F, 72.0F, 51.488918F, 72.0F);
      localPath.lineTo(20.511082F, 72.0F);
      localPath.cubicTo(13.378932F, 72.0F, 10.792642F, 71.257393F, 8.185234F, 69.862938F);
      localPath.cubicTo(5.577827F, 68.468483F, 3.531519F, 66.422173F, 2.137062F, 63.814766F);
      localPath.cubicTo(0.7426049F, 61.207359F, 3.209883E-016F, 58.621067F, -5.524482E-016F, 51.488918F);
      localPath.lineTo(5.524482E-016F, 20.511082F);
      localPath.cubicTo(-3.209883E-016F, 13.378932F, 0.7426049F, 10.792642F, 2.137062F, 8.185234F);
      localPath.cubicTo(3.531519F, 5.577827F, 5.577827F, 3.531519F, 8.185234F, 2.137062F);
      localPath.cubicTo(10.792642F, 0.7426049F, 13.378932F, 4.814824E-016F, 20.511082F, -8.286722E-016F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 17.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 38, 31);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(34.407829F, 14.910167F);
      localPath.cubicTo(32.89286F, 14.910167F, 31.664755F, 16.146988F, 31.664755F, 17.672895F);
      localPath.cubicTo(31.664755F, 19.198618F, 32.89286F, 20.435623F, 34.407829F, 20.435623F);
      localPath.cubicTo(35.922607F, 20.435623F, 37.150715F, 19.198618F, 37.150715F, 17.672895F);
      localPath.cubicTo(37.150715F, 16.146988F, 35.922607F, 14.910167F, 34.407829F, 14.910167F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.576912F, 14.910167F);
      localPath.cubicTo(20.061945F, 14.910167F, 18.833838F, 16.146988F, 18.833838F, 17.672895F);
      localPath.cubicTo(18.833838F, 19.198618F, 20.061945F, 20.435623F, 21.576912F, 20.435623F);
      localPath.cubicTo(23.091692F, 20.435623F, 24.319799F, 19.198618F, 24.319799F, 17.672895F);
      localPath.cubicTo(24.319799F, 16.146988F, 23.091692F, 14.910167F, 21.576912F, 14.910167F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(29.640059F, 19.583683F);
      localPath.lineTo(28.543238F, 19.583683F);
      localPath.lineTo(28.543238F, 18.627417F);
      localPath.cubicTo(28.869595F, 18.436052F, 29.089516F, 18.080769F, 29.089516F, 17.672821F);
      localPath.cubicTo(29.089516F, 17.062384F, 28.59831F, 16.567656F, 27.992323F, 16.567656F);
      localPath.cubicTo(27.386337F, 16.567656F, 26.894945F, 17.062384F, 26.894945F, 17.672821F);
      localPath.cubicTo(26.894945F, 18.080769F, 27.115051F, 18.436052F, 27.44141F, 18.627417F);
      localPath.lineTo(27.44141F, 19.583683F);
      localPath.lineTo(26.344587F, 19.583683F);
      localPath.cubicTo(26.040297F, 19.583683F, 25.793489F, 19.83049F, 25.793489F, 20.134781F);
      localPath.cubicTo(25.793489F, 20.439074F, 26.040297F, 20.685696F, 26.344587F, 20.685696F);
      localPath.lineTo(29.640059F, 20.685696F);
      localPath.cubicTo(29.944534F, 20.685696F, 30.191158F, 20.439074F, 30.191158F, 20.134781F);
      localPath.cubicTo(30.191158F, 19.83049F, 29.944534F, 19.583683F, 29.640059F, 19.583683F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.113483F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(52.286476F, 26.971176F);
      ((Path)localObject2).cubicTo(51.529179F, 28.02405F, 50.263988F, 28.521561F, 48.521683F, 28.449057F);
      ((Path)localObject2).cubicTo(44.474293F, 28.281427F, 44.110477F, 25.363308F, 44.103058F, 17.066593F);
      ((Path)localObject2).lineTo(44.102318F, 16.406832F);
      ((Path)localObject2).cubicTo(44.101021F, 15.639521F, 43.478714F, 15.018514F, 42.71159F, 15.018514F);
      ((Path)localObject2).lineTo(42.709549F, 15.018514F);
      ((Path)localObject2).cubicTo(41.941311F, 15.019627F, 41.319561F, 15.643229F, 41.320862F, 16.411282F);
      ((Path)localObject2).lineTo(41.321602F, 17.069189F);
      ((Path)localObject2).cubicTo(41.325127F, 20.817667F, 41.327908F, 24.055283F, 42.113205F, 26.514832F);
      ((Path)localObject2).cubicTo(42.691376F, 28.325932F, 43.697525F, 29.618011F, 45.112541F, 30.388845F);
      ((Path)localObject2).cubicTo(40.568012F, 33.112263F, 34.82486F, 34.490009F, 27.992304F, 34.490009F);
      ((Path)localObject2).cubicTo(21.159748F, 34.490009F, 15.41641F, 33.112263F, 10.871881F, 30.388845F);
      ((Path)localObject2).cubicTo(12.286901F, 29.618011F, 13.293046F, 28.326117F, 13.871404F, 26.515203F);
      ((Path)localObject2).cubicTo(14.656517F, 24.055838F, 14.659669F, 20.818594F, 14.663192F, 17.070116F);
      ((Path)localObject2).lineTo(14.663749F, 16.411467F);
      ((Path)localObject2).cubicTo(14.665047F, 15.643414F, 14.043484F, 15.019627F, 13.275245F, 15.018514F);
      ((Path)localObject2).lineTo(13.27302F, 15.018514F);
      ((Path)localObject2).cubicTo(12.50608F, 15.018514F, 11.88359F, 15.639706F, 11.882292F, 16.406832F);
      ((Path)localObject2).lineTo(11.881735F, 17.067705F);
      ((Path)localObject2).cubicTo(11.874132F, 25.36368F, 11.510318F, 28.281427F, 7.462742F, 28.449057F);
      ((Path)localObject2).cubicTo(5.722662F, 28.520819F, 4.455431F, 28.02405F, 3.698318F, 26.971176F);
      ((Path)localObject2).cubicTo(2.336331F, 25.077375F, 2.483378F, 21.436077F, 4.091616F, 17.2307F);
      ((Path)localObject2).cubicTo(6.052729F, 12.102991F, 10.890424F, 7.436448F, 16.71702F, 5.052183F);
      ((Path)localObject2).cubicTo(20.282291F, 3.593216F, 24.076014F, 2.853348F, 27.992304F, 2.853348F);
      ((Path)localObject2).cubicTo(31.908596F, 2.853348F, 35.702133F, 3.593216F, 39.267776F, 5.052183F);
      ((Path)localObject2).cubicTo(45.094185F, 7.436633F, 49.931881F, 12.102991F, 51.892994F, 17.2307F);
      ((Path)localObject2).cubicTo(53.501232F, 21.436077F, 53.648277F, 25.077375F, 52.286476F, 26.971176F);
      ((Path)localObject2).moveTo(54.490875F, 16.237164F);
      ((Path)localObject2).cubicTo(52.230846F, 10.32768F, 46.933842F, 5.184024F, 40.321392F, 2.478037F);
      ((Path)localObject2).cubicTo(36.419746F, 0.8814808F, 32.271484F, 0.0718914F, 27.992304F, 0.0718914F);
      ((Path)localObject2).cubicTo(23.71294F, 0.0718914F, 19.564861F, 0.8814808F, 15.663404F, 2.478037F);
      ((Path)localObject2).cubicTo(9.050954F, 5.183838F, 3.753762F, 10.327494F, 1.493735F, 16.237164F);
      ((Path)localObject2).cubicTo(-0.4790596F, 21.395283F, -0.4985298F, 25.899574F, 1.43996F, 28.59499F);
      ((Path)localObject2).cubicTo(2.320941F, 29.819759F, 4.02449F, 31.237745F, 7.15604F, 31.233295F);
      ((Path)localObject2).cubicTo(12.466768F, 35.239891F, 19.473072F, 37.271469F, 27.992304F, 37.271469F);
      ((Path)localObject2).cubicTo(36.509125F, 37.271469F, 43.513763F, 35.241005F, 48.823933F, 31.237003F);
      ((Path)localObject2).cubicTo(48.832279F, 31.237003F, 48.840992F, 31.23756F, 48.849339F, 31.23756F);
      ((Path)localObject2).cubicTo(51.971615F, 31.23756F, 53.665524F, 29.817719F, 54.544647F, 28.59499F);
      ((Path)localObject2).cubicTo(56.483139F, 25.899574F, 56.463482F, 21.395283F, 54.490875F, 16.237164F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.kids_watch_default_avatar
 * JD-Core Version:    0.7.0.1
 */