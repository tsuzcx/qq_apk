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

public class app_brand_video_danmaku_showed_btn
  extends c
{
  private final int height = 47;
  private final int width = 110;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 110;
      return 47;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -558.0F, 0.0F, 1.0F, -257.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 558.0F, 0.0F, 1.0F, 257.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16139513);
      ((Paint)localObject1).setStrokeWidth(3.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.5F, 23.5F);
      ((Path)localObject2).cubicTo(1.5F, 11.349735F, 11.349735F, 1.5F, 23.5F, 1.5F);
      ((Path)localObject2).lineTo(86.5F, 1.5F);
      ((Path)localObject2).cubicTo(98.650269F, 1.5F, 108.5F, 11.349735F, 108.5F, 23.5F);
      ((Path)localObject2).lineTo(108.5F, 23.5F);
      ((Path)localObject2).cubicTo(108.5F, 35.650265F, 98.650269F, 45.5F, 86.5F, 45.5F);
      ((Path)localObject2).lineTo(23.5F, 45.5F);
      ((Path)localObject2).cubicTo(11.349735F, 45.5F, 1.5F, 35.650265F, 1.5F, 23.5F);
      ((Path)localObject2).lineTo(1.5F, 23.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16139513);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(31.969F, 18.688999F);
      ((Path)localObject1).lineTo(37.044998F, 18.688999F);
      ((Path)localObject1).lineTo(37.044998F, 11.075F);
      ((Path)localObject1).lineTo(29.836F, 11.075F);
      ((Path)localObject1).lineTo(29.836F, 12.776F);
      ((Path)localObject1).lineTo(35.154999F, 12.776F);
      ((Path)localObject1).lineTo(35.154999F, 16.988001F);
      ((Path)localObject1).lineTo(30.240999F, 16.988001F);
      ((Path)localObject1).lineTo(29.539F, 24.764F);
      ((Path)localObject1).lineTo(35.424999F, 24.764F);
      ((Path)localObject1).cubicTo(35.424999F, 28.004F, 35.290001F, 30.164F, 35.02F, 31.190001F);
      ((Path)localObject1).cubicTo(34.777F, 32.161999F, 33.859001F, 32.674999F, 32.265999F, 32.674999F);
      ((Path)localObject1).cubicTo(31.591F, 32.674999F, 30.943001F, 32.620998F, 30.295F, 32.567001F);
      ((Path)localObject1).lineTo(30.781F, 34.375999F);
      ((Path)localObject1).cubicTo(31.429001F, 34.43F, 32.077F, 34.484001F, 32.698002F, 34.484001F);
      ((Path)localObject1).cubicTo(35.101002F, 34.375999F, 36.478001F, 33.566002F, 36.828999F, 32.0F);
      ((Path)localObject1).cubicTo(37.098999F, 30.596001F, 37.261002F, 27.599001F, 37.261002F, 23.063F);
      ((Path)localObject1).lineTo(31.51F, 23.063F);
      ((Path)localObject1).lineTo(31.969F, 18.688999F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(39.367001F, 14.315F);
      ((Path)localObject1).lineTo(47.223999F, 14.315F);
      ((Path)localObject1).cubicTo(48.034F, 12.857F, 48.709F, 11.345F, 49.303001F, 9.752F);
      ((Path)localObject1).lineTo(51.166F, 10.4F);
      ((Path)localObject1).cubicTo(50.571999F, 11.858F, 49.896999F, 13.181F, 49.140999F, 14.315F);
      ((Path)localObject1).lineTo(52.651001F, 14.315F);
      ((Path)localObject1).lineTo(52.651001F, 25.142F);
      ((Path)localObject1).lineTo(46.900002F, 25.142F);
      ((Path)localObject1).lineTo(46.900002F, 27.761F);
      ((Path)localObject1).lineTo(53.839001F, 27.761F);
      ((Path)localObject1).lineTo(53.839001F, 29.57F);
      ((Path)localObject1).lineTo(46.900002F, 29.57F);
      ((Path)localObject1).lineTo(46.900002F, 34.754002F);
      ((Path)localObject1).lineTo(45.009998F, 34.754002F);
      ((Path)localObject1).lineTo(45.009998F, 29.57F);
      ((Path)localObject1).lineTo(38.179001F, 29.57F);
      ((Path)localObject1).lineTo(38.179001F, 27.761F);
      ((Path)localObject1).lineTo(45.009998F, 27.761F);
      ((Path)localObject1).lineTo(45.009998F, 25.142F);
      ((Path)localObject1).lineTo(39.367001F, 25.142F);
      ((Path)localObject1).lineTo(39.367001F, 14.315F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(50.896F, 23.495001F);
      ((Path)localObject1).lineTo(50.896F, 20.579F);
      ((Path)localObject1).lineTo(46.900002F, 20.579F);
      ((Path)localObject1).lineTo(46.900002F, 23.495001F);
      ((Path)localObject1).lineTo(50.896F, 23.495001F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(45.009998F, 23.495001F);
      ((Path)localObject1).lineTo(45.009998F, 20.579F);
      ((Path)localObject1).lineTo(41.095001F, 20.579F);
      ((Path)localObject1).lineTo(41.095001F, 23.495001F);
      ((Path)localObject1).lineTo(45.009998F, 23.495001F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(41.095001F, 18.959F);
      ((Path)localObject1).lineTo(45.009998F, 18.959F);
      ((Path)localObject1).lineTo(45.009998F, 15.962F);
      ((Path)localObject1).lineTo(41.095001F, 15.962F);
      ((Path)localObject1).lineTo(41.095001F, 18.959F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(46.900002F, 15.962F);
      ((Path)localObject1).lineTo(46.900002F, 18.959F);
      ((Path)localObject1).lineTo(50.896F, 18.959F);
      ((Path)localObject1).lineTo(50.896F, 15.962F);
      ((Path)localObject1).lineTo(46.900002F, 15.962F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(42.553001F, 9.914F);
      ((Path)localObject1).cubicTo(43.362999F, 11.021F, 44.064999F, 12.209F, 44.659F, 13.451F);
      ((Path)localObject1).lineTo(42.985001F, 14.18F);
      ((Path)localObject1).cubicTo(42.337002F, 12.776F, 41.581001F, 11.561F, 40.771F, 10.481F);
      ((Path)localObject1).lineTo(42.553001F, 9.914F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(67.636002F, 26.141001F);
      ((Path)localObject1).lineTo(69.472F, 26.141001F);
      ((Path)localObject1).lineTo(69.472F, 28.031F);
      ((Path)localObject1).lineTo(75.709F, 28.031F);
      ((Path)localObject1).cubicTo(74.250999F, 27.167F, 73.116997F, 26.249001F, 72.306999F, 25.223F);
      ((Path)localObject1).lineTo(65.314003F, 25.223F);
      ((Path)localObject1).cubicTo(64.369003F, 26.249001F, 63.181F, 27.194F, 61.75F, 28.031F);
      ((Path)localObject1).lineTo(67.636002F, 28.031F);
      ((Path)localObject1).lineTo(67.636002F, 26.141001F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(67.636002F, 29.516001F);
      ((Path)localObject1).lineTo(62.533001F, 29.516001F);
      ((Path)localObject1).lineTo(62.533001F, 34.025002F);
      ((Path)localObject1).lineTo(60.696999F, 34.025002F);
      ((Path)localObject1).lineTo(60.696999F, 28.598F);
      ((Path)localObject1).cubicTo(59.563F, 29.165001F, 58.348F, 29.677999F, 57.051998F, 30.136999F);
      ((Path)localObject1).lineTo(56.215F, 28.517F);
      ((Path)localObject1).cubicTo(59.131001F, 27.599001F, 61.398998F, 26.518999F, 62.992001F, 25.223F);
      ((Path)localObject1).lineTo(56.889999F, 25.223F);
      ((Path)localObject1).lineTo(56.889999F, 23.603001F);
      ((Path)localObject1).lineTo(64.557999F, 23.603001F);
      ((Path)localObject1).cubicTo(64.882004F, 23.143999F, 65.152F, 22.684999F, 65.367996F, 22.198999F);
      ((Path)localObject1).lineTo(59.860001F, 22.198999F);
      ((Path)localObject1).lineTo(59.860001F, 15.044F);
      ((Path)localObject1).lineTo(62.992001F, 15.044F);
      ((Path)localObject1).lineTo(62.992001F, 13.316F);
      ((Path)localObject1).lineTo(56.566002F, 13.316F);
      ((Path)localObject1).lineTo(56.566002F, 11.723F);
      ((Path)localObject1).lineTo(62.992001F, 11.723F);
      ((Path)localObject1).lineTo(62.992001F, 9.914F);
      ((Path)localObject1).lineTo(64.855003F, 9.914F);
      ((Path)localObject1).lineTo(64.855003F, 11.723F);
      ((Path)localObject1).lineTo(72.171997F, 11.723F);
      ((Path)localObject1).lineTo(72.171997F, 9.914F);
      ((Path)localObject1).lineTo(74.035004F, 9.914F);
      ((Path)localObject1).lineTo(74.035004F, 11.723F);
      ((Path)localObject1).lineTo(80.460999F, 11.723F);
      ((Path)localObject1).lineTo(80.460999F, 13.316F);
      ((Path)localObject1).lineTo(74.035004F, 13.316F);
      ((Path)localObject1).lineTo(74.035004F, 15.044F);
      ((Path)localObject1).lineTo(77.167F, 15.044F);
      ((Path)localObject1).lineTo(77.167F, 22.198999F);
      ((Path)localObject1).lineTo(67.177002F, 22.198999F);
      ((Path)localObject1).cubicTo(66.987999F, 22.684999F, 66.772003F, 23.143999F, 66.501999F, 23.603001F);
      ((Path)localObject1).lineTo(80.110001F, 23.603001F);
      ((Path)localObject1).lineTo(80.110001F, 25.223F);
      ((Path)localObject1).lineTo(74.278F, 25.223F);
      ((Path)localObject1).cubicTo(75.763F, 26.546F, 77.976997F, 27.599001F, 80.892998F, 28.355F);
      ((Path)localObject1).lineTo(80.110001F, 29.975F);
      ((Path)localObject1).cubicTo(78.867996F, 29.542999F, 77.788002F, 29.111F, 76.870003F, 28.652F);
      ((Path)localObject1).lineTo(76.870003F, 31.919001F);
      ((Path)localObject1).cubicTo(76.870003F, 33.323002F, 76.086998F, 34.051998F, 74.521004F, 34.051998F);
      ((Path)localObject1).lineTo(72.469002F, 34.051998F);
      ((Path)localObject1).lineTo(72.064003F, 32.431999F);
      ((Path)localObject1).lineTo(73.981003F, 32.486F);
      ((Path)localObject1).cubicTo(74.682999F, 32.486F, 75.033997F, 32.161999F, 75.033997F, 31.514F);
      ((Path)localObject1).lineTo(75.033997F, 29.516001F);
      ((Path)localObject1).lineTo(69.472F, 29.516001F);
      ((Path)localObject1).lineTo(69.472F, 34.700001F);
      ((Path)localObject1).lineTo(67.636002F, 34.700001F);
      ((Path)localObject1).lineTo(67.636002F, 29.516001F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(72.171997F, 13.316F);
      ((Path)localObject1).lineTo(64.855003F, 13.316F);
      ((Path)localObject1).lineTo(64.855003F, 15.044F);
      ((Path)localObject1).lineTo(72.171997F, 15.044F);
      ((Path)localObject1).lineTo(72.171997F, 13.316F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(75.331001F, 20.849001F);
      ((Path)localObject1).lineTo(75.331001F, 19.229F);
      ((Path)localObject1).lineTo(61.695999F, 19.229F);
      ((Path)localObject1).lineTo(61.695999F, 20.849001F);
      ((Path)localObject1).lineTo(75.331001F, 20.849001F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(61.695999F, 17.959999F);
      ((Path)localObject1).lineTo(75.331001F, 17.959999F);
      ((Path)localObject1).lineTo(75.331001F, 16.448F);
      ((Path)localObject1).lineTo(61.695999F, 16.448F);
      ((Path)localObject1).lineTo(61.695999F, 17.959999F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_video_danmaku_showed_btn
 * JD-Core Version:    0.7.0.1
 */