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

public class app_brand_video_danmu_on
  extends c
{
  private final int height = 24;
  private final int width = 26;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 26;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, -509.0F, 0.0F, 1.0F, -98.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 509.0F, 0.0F, 1.0F, 98.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setColor(-2565928);
      ((Paint)localObject2).setColor(-6842473);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.5F, 0.5F);
      ((Path)localObject1).lineTo(23.5F, 0.5F);
      ((Path)localObject1).lineTo(23.5F, 23.5F);
      ((Path)localObject1).lineTo(0.5F, 23.5F);
      ((Path)localObject1).lineTo(0.5F, 0.5F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject3);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.0F, 15.0F);
      ((Path)localObject2).cubicTo(12.0F, 12.790861F, 13.790861F, 11.0F, 16.0F, 11.0F);
      ((Path)localObject2).lineTo(22.0F, 11.0F);
      ((Path)localObject2).cubicTo(24.209139F, 11.0F, 26.0F, 12.790861F, 26.0F, 15.0F);
      ((Path)localObject2).lineTo(26.0F, 15.0F);
      ((Path)localObject2).cubicTo(26.0F, 17.209139F, 24.209139F, 19.0F, 22.0F, 19.0F);
      ((Path)localObject2).lineTo(16.0F, 19.0F);
      ((Path)localObject2).cubicTo(13.790861F, 19.0F, 12.0F, 17.209139F, 12.0F, 15.0F);
      ((Path)localObject2).lineTo(12.0F, 15.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16139513);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(22.0F, 11.0F);
      ((Path)localObject2).cubicTo(24.209139F, 11.0F, 26.0F, 12.790861F, 26.0F, 15.0F);
      ((Path)localObject2).cubicTo(26.0F, 17.209139F, 24.209139F, 19.0F, 22.0F, 19.0F);
      ((Path)localObject2).cubicTo(19.790861F, 19.0F, 18.0F, 17.209139F, 18.0F, 15.0F);
      ((Path)localObject2).cubicTo(18.0F, 12.790861F, 19.790861F, 11.0F, 22.0F, 11.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16139513);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(4.44F, 13.1F);
      ((Path)localObject1).cubicTo(4.47F, 14.070005F, 4.435F, 14.884997F, 4.335F, 15.545F);
      ((Path)localObject1).cubicTo(4.235F, 16.205004F, 4.085001F, 16.739998F, 3.885F, 17.15F);
      ((Path)localObject1).cubicTo(3.684999F, 17.560001F, 3.442501F, 17.855F, 3.1575F, 18.035F);
      ((Path)localObject1).cubicTo(2.872499F, 18.215002F, 2.560002F, 18.305F, 2.22F, 18.305F);
      ((Path)localObject1).cubicTo(1.839998F, 18.305F, 1.390003F, 18.160002F, 0.87F, 17.870001F);
      ((Path)localObject1).cubicTo(0.5199983F, 17.689999F, 0.2800007F, 17.487501F, 0.15F, 17.262501F);
      ((Path)localObject1).cubicTo(0.01999935F, 17.037498F, 0.044999F, 16.750002F, 0.225F, 16.4F);
      ((Path)localObject1).cubicTo(0.3350005F, 16.199999F, 0.507499F, 16.075001F, 0.7425F, 16.025F);
      ((Path)localObject1).cubicTo(0.9775012F, 15.975F, 1.214999F, 16.045F, 1.455F, 16.235001F);
      ((Path)localObject1).cubicTo(1.635001F, 16.385F, 1.794999F, 16.485001F, 1.935F, 16.535F);
      ((Path)localObject1).cubicTo(2.075001F, 16.585001F, 2.1975F, 16.5975F, 2.3025F, 16.5725F);
      ((Path)localObject1).cubicTo(2.407501F, 16.547501F, 2.4975F, 16.49F, 2.5725F, 16.4F);
      ((Path)localObject1).cubicTo(2.6475F, 16.309999F, 2.71F, 16.200001F, 2.76F, 16.07F);
      ((Path)localObject1).cubicTo(2.83F, 15.849999F, 2.8875F, 15.562502F, 2.9325F, 15.2075F);
      ((Path)localObject1).cubicTo(2.9775F, 14.852498F, 3.0F, 14.345003F, 3.0F, 13.685F);
      ((Path)localObject1).cubicTo(3.0F, 13.424999F, 2.98F, 13.262501F, 2.94F, 13.1975F);
      ((Path)localObject1).cubicTo(2.9F, 13.1325F, 2.810001F, 13.1F, 2.67F, 13.1F);
      ((Path)localObject1).lineTo(1.32F, 13.1F);
      ((Path)localObject1).cubicTo(1.069999F, 13.1F, 0.8550009F, 13.087501F, 0.675F, 13.0625F);
      ((Path)localObject1).cubicTo(0.4949991F, 13.0375F, 0.3525005F, 12.970001F, 0.2475F, 12.860001F);
      ((Path)localObject1).cubicTo(0.1424995F, 12.75F, 0.07250018F, 12.590001F, 0.0375F, 12.38F);
      ((Path)localObject1).cubicTo(0.002499825F, 12.169999F, 0.00999975F, 11.875002F, 0.06F, 11.495F);
      ((Path)localObject1).lineTo(0.255F, 9.485001F);
      ((Path)localObject1).cubicTo(0.295F, 9.184999F, 0.3374998F, 8.937501F, 0.3825F, 8.7425F);
      ((Path)localObject1).cubicTo(0.4275002F, 8.5475F, 0.4924996F, 8.392501F, 0.5775F, 8.2775F);
      ((Path)localObject1).cubicTo(0.6625004F, 8.162499F, 0.7799993F, 8.082501F, 0.93F, 8.0375F);
      ((Path)localObject1).cubicTo(1.080001F, 7.9925F, 1.284999F, 7.97F, 1.545F, 7.97F);
      ((Path)localObject1).lineTo(2.61F, 7.97F);
      ((Path)localObject1).cubicTo(2.730001F, 7.97F, 2.8125F, 7.942501F, 2.8575F, 7.8875F);
      ((Path)localObject1).cubicTo(2.9025F, 7.8325F, 2.925F, 7.705001F, 2.925F, 7.505F);
      ((Path)localObject1).lineTo(2.925F, 6.845F);
      ((Path)localObject1).cubicTo(2.925F, 6.674999F, 2.9075F, 6.555001F, 2.8725F, 6.485F);
      ((Path)localObject1).cubicTo(2.8375F, 6.415F, 2.750001F, 6.38F, 2.61F, 6.38F);
      ((Path)localObject1).lineTo(0.765F, 6.38F);
      ((Path)localObject1).cubicTo(0.4949987F, 6.38F, 0.3000006F, 6.315001F, 0.18F, 6.185F);
      ((Path)localObject1).cubicTo(0.0599994F, 6.055F, 0.0F, 5.840002F, 0.0F, 5.54F);
      ((Path)localObject1).cubicTo(0.0F, 5.229999F, 0.0599994F, 5.017501F, 0.18F, 4.9025F);
      ((Path)localObject1).cubicTo(0.3000006F, 4.7875F, 0.4949987F, 4.730001F, 0.765F, 4.730001F);
      ((Path)localObject1).lineTo(3.075F, 4.730001F);
      ((Path)localObject1).cubicTo(3.555003F, 4.730001F, 3.889999F, 4.867499F, 4.08F, 5.1425F);
      ((Path)localObject1).cubicTo(4.270001F, 5.417501F, 4.365F, 5.824997F, 4.365F, 6.365F);
      ((Path)localObject1).lineTo(4.365F, 8.165F);
      ((Path)localObject1).cubicTo(4.365F, 8.735004F, 4.262501F, 9.1275F, 4.0575F, 9.342501F);
      ((Path)localObject1).cubicTo(3.852499F, 9.557502F, 3.525002F, 9.665F, 3.075F, 9.665F);
      ((Path)localObject1).lineTo(2.025F, 9.665F);
      ((Path)localObject1).cubicTo(1.874999F, 9.665F, 1.78F, 9.685F, 1.74F, 9.725F);
      ((Path)localObject1).cubicTo(1.7F, 9.765F, 1.675F, 9.855F, 1.665F, 9.995F);
      ((Path)localObject1).lineTo(1.545F, 11.09F);
      ((Path)localObject1).cubicTo(1.525F, 11.240001F, 1.54F, 11.3325F, 1.59F, 11.3675F);
      ((Path)localObject1).cubicTo(1.64F, 11.4025F, 1.744999F, 11.42F, 1.905F, 11.42F);
      ((Path)localObject1).lineTo(3.09F, 11.42F);
      ((Path)localObject1).cubicTo(3.330001F, 11.42F, 3.534999F, 11.4425F, 3.705F, 11.4875F);
      ((Path)localObject1).cubicTo(3.875001F, 11.5325F, 4.012499F, 11.615F, 4.1175F, 11.735001F);
      ((Path)localObject1).cubicTo(4.2225F, 11.855F, 4.3F, 12.025F, 4.35F, 12.245F);
      ((Path)localObject1).cubicTo(4.4F, 12.465001F, 4.43F, 12.749998F, 4.44F, 13.1F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(10.103409F, 16.115F);
      ((Path)localObject1).lineTo(10.05F, 16.115F);
      ((Path)localObject1).lineTo(10.05F, 17.66F);
      ((Path)localObject1).cubicTo(10.05F, 18.000002F, 9.995001F, 18.234999F, 9.885F, 18.365F);
      ((Path)localObject1).cubicTo(9.775F, 18.495001F, 9.550002F, 18.559999F, 9.21F, 18.559999F);
      ((Path)localObject1).cubicTo(8.939999F, 18.559999F, 8.7425F, 18.495001F, 8.6175F, 18.365F);
      ((Path)localObject1).cubicTo(8.492499F, 18.234999F, 8.43F, 18.000002F, 8.43F, 17.66F);
      ((Path)localObject1).lineTo(8.43F, 16.115F);
      ((Path)localObject1).lineTo(5.145F, 16.115F);
      ((Path)localObject1).cubicTo(5.025F, 16.115F, 4.9275F, 16.09F, 4.8525F, 16.040001F);
      ((Path)localObject1).cubicTo(4.7775F, 15.99F, 4.7225F, 15.905001F, 4.6875F, 15.785F);
      ((Path)localObject1).cubicTo(4.6525F, 15.665F, 4.635F, 15.490002F, 4.635F, 15.26F);
      ((Path)localObject1).cubicTo(4.645F, 14.949999F, 4.724999F, 14.7475F, 4.875F, 14.6525F);
      ((Path)localObject1).cubicTo(5.025001F, 14.5575F, 5.259998F, 14.51F, 5.58F, 14.51F);
      ((Path)localObject1).lineTo(8.43F, 14.51F);
      ((Path)localObject1).lineTo(8.43F, 13.475F);
      ((Path)localObject1).lineTo(6.57F, 13.475F);
      ((Path)localObject1).cubicTo(5.999997F, 13.475F, 5.612501F, 13.355001F, 5.4075F, 13.115001F);
      ((Path)localObject1).cubicTo(5.202499F, 12.874999F, 5.1F, 12.470003F, 5.1F, 11.900001F);
      ((Path)localObject1).lineTo(5.1F, 7.415F);
      ((Path)localObject1).cubicTo(5.1F, 6.844997F, 5.217499F, 6.440002F, 5.4525F, 6.2F);
      ((Path)localObject1).cubicTo(5.687501F, 5.959999F, 6.064997F, 5.83F, 6.585F, 5.81F);
      ((Path)localObject1).cubicTo(6.555F, 5.76F, 6.5225F, 5.710001F, 6.4875F, 5.66F);
      ((Path)localObject1).cubicTo(6.4525F, 5.61F, 6.42F, 5.56F, 6.39F, 5.51F);
      ((Path)localObject1).cubicTo(6.219999F, 5.239999F, 6.145F, 5.005001F, 6.165F, 4.805F);
      ((Path)localObject1).cubicTo(6.185F, 4.604999F, 6.324999F, 4.410001F, 6.585F, 4.22F);
      ((Path)localObject1).cubicTo(6.815001F, 4.049999F, 7.049999F, 3.98F, 7.29F, 4.01F);
      ((Path)localObject1).cubicTo(7.530001F, 4.04F, 7.739999F, 4.219999F, 7.92F, 4.55F);
      ((Path)localObject1).cubicTo(8.030001F, 4.750001F, 8.1325F, 4.952499F, 8.2275F, 5.1575F);
      ((Path)localObject1).cubicTo(8.3225F, 5.362501F, 8.419999F, 5.579999F, 8.520001F, 5.81F);
      ((Path)localObject1).lineTo(9.93F, 5.81F);
      ((Path)localObject1).cubicTo(10.06F, 5.599999F, 10.174999F, 5.402501F, 10.275F, 5.2175F);
      ((Path)localObject1).cubicTo(10.375001F, 5.032499F, 10.48F, 4.830001F, 10.59F, 4.61F);
      ((Path)localObject1).cubicTo(10.750001F, 4.289999F, 10.932499F, 4.097501F, 11.1375F, 4.0325F);
      ((Path)localObject1).cubicTo(11.342501F, 3.9675F, 11.564999F, 4.0F, 11.805F, 4.13F);
      ((Path)localObject1).cubicTo(12.055001F, 4.270001F, 12.2125F, 4.435F, 12.2775F, 4.625001F);
      ((Path)localObject1).cubicTo(12.342501F, 4.815001F, 12.290001F, 5.064999F, 12.12F, 5.375001F);
      ((Path)localObject1).cubicTo(12.08F, 5.445001F, 12.0425F, 5.515F, 12.0075F, 5.585001F);
      ((Path)localObject1).cubicTo(11.9725F, 5.655001F, 11.93F, 5.73F, 11.88F, 5.81F);
      ((Path)localObject1).lineTo(11.94F, 5.81F);
      ((Path)localObject1).cubicTo(12.510003F, 5.81F, 12.897499F, 5.932499F, 13.1025F, 6.1775F);
      ((Path)localObject1).cubicTo(13.307501F, 6.422502F, 13.41F, 6.834997F, 13.41F, 7.415F);
      ((Path)localObject1).lineTo(13.41F, 9.58626F);
      ((Path)localObject1).cubicTo(12.794631F, 9.881192F, 12.237355F, 10.277955F, 11.76F, 10.754721F);
      ((Path)localObject1).lineTo(11.76F, 10.34F);
      ((Path)localObject1).lineTo(10.05F, 10.34F);
      ((Path)localObject1).lineTo(10.05F, 11.855F);
      ((Path)localObject1).lineTo(10.889319F, 11.855F);
      ((Path)localObject1).cubicTo(10.583056F, 12.351625F, 10.347156F, 12.896258F, 10.195518F, 13.475F);
      ((Path)localObject1).lineTo(10.05F, 13.475F);
      ((Path)localObject1).lineTo(10.05F, 14.221836F);
      ((Path)localObject1).cubicTo(10.017013F, 14.476559F, 10.0F, 14.736293F, 10.0F, 15.0F);
      ((Path)localObject1).cubicTo(10.0F, 15.381004F, 10.035513F, 15.753715F, 10.103409F, 16.115F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(11.76F, 7.535F);
      ((Path)localObject1).cubicTo(11.76F, 7.445F, 11.71F, 7.4F, 11.61F, 7.4F);
      ((Path)localObject1).lineTo(10.05F, 7.4F);
      ((Path)localObject1).lineTo(10.05F, 8.93F);
      ((Path)localObject1).lineTo(11.76F, 8.93F);
      ((Path)localObject1).lineTo(11.76F, 7.535F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(6.735F, 8.93F);
      ((Path)localObject1).lineTo(8.43F, 8.93F);
      ((Path)localObject1).lineTo(8.43F, 7.4F);
      ((Path)localObject1).lineTo(6.915F, 7.4F);
      ((Path)localObject1).cubicTo(6.835F, 7.4F, 6.785F, 7.4125F, 6.765F, 7.437501F);
      ((Path)localObject1).cubicTo(6.745F, 7.462501F, 6.735F, 7.51F, 6.735F, 7.58F);
      ((Path)localObject1).lineTo(6.735F, 8.93F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(6.735F, 11.690001F);
      ((Path)localObject1).cubicTo(6.735F, 11.76F, 6.745F, 11.805F, 6.765F, 11.825001F);
      ((Path)localObject1).cubicTo(6.785F, 11.845F, 6.835F, 11.855F, 6.915F, 11.855F);
      ((Path)localObject1).lineTo(8.43F, 11.855F);
      ((Path)localObject1).lineTo(8.43F, 10.34F);
      ((Path)localObject1).lineTo(6.735F, 10.34F);
      ((Path)localObject1).lineTo(6.735F, 11.690001F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_video_danmu_on
 * JD-Core Version:    0.7.0.1
 */