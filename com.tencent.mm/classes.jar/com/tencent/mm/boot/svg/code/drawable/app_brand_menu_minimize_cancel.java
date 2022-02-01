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

public class app_brand_menu_minimize_cancel
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.393304F, 11.485108F);
      ((Path)localObject2).lineTo(8.959925F, 14.0516F);
      ((Path)localObject2).cubicTo(5.596231F, 18.482311F, 3.6F, 24.008034F, 3.6F, 30.0F);
      ((Path)localObject2).cubicTo(3.6F, 44.580318F, 15.419683F, 56.400002F, 30.0F, 56.400002F);
      ((Path)localObject2).cubicTo(35.991966F, 56.400002F, 41.517689F, 54.40377F, 45.948399F, 51.040077F);
      ((Path)localObject2).lineTo(48.514893F, 53.606697F);
      ((Path)localObject2).cubicTo(43.415726F, 57.611588F, 36.986786F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject2).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject2).cubicTo(0.0F, 23.013216F, 2.388412F, 16.584274F, 6.393304F, 11.485108F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 0.0F);
      ((Path)localObject2).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject2).cubicTo(60.0F, 36.987175F, 57.61132F, 43.416447F, 53.606022F, 48.515751F);
      ((Path)localObject2).lineTo(58.274937F, 53.183765F);
      ((Path)localObject2).lineTo(55.729351F, 55.729351F);
      ((Path)localObject2).lineTo(5.545586F, 5.545585F);
      ((Path)localObject2).lineTo(8.09117F, 3.0F);
      ((Path)localObject2).lineTo(11.484251F, 6.393978F);
      ((Path)localObject2).cubicTo(16.583553F, 2.38868F, 23.012823F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.982403F, 20.073132F);
      ((Path)localObject2).lineTo(17.59371F, 22.684984F);
      ((Path)localObject2).cubicTo(16.326931F, 24.828817F, 15.6F, 27.329515F, 15.6F, 30.0F);
      ((Path)localObject2).cubicTo(15.6F, 37.9529F, 22.0471F, 44.400002F, 30.0F, 44.400002F);
      ((Path)localObject2).cubicTo(32.670483F, 44.400002F, 35.171185F, 43.673069F, 37.315018F, 42.406292F);
      ((Path)localObject2).lineTo(39.926868F, 45.017597F);
      ((Path)localObject2).cubicTo(37.081257F, 46.902374F, 33.668812F, 48.0F, 30.0F, 48.0F);
      ((Path)localObject2).cubicTo(20.058874F, 48.0F, 12.0F, 39.941124F, 12.0F, 30.0F);
      ((Path)localObject2).cubicTo(12.0F, 26.33119F, 13.097625F, 22.918743F, 14.982403F, 20.073132F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 3.6F);
      ((Path)localObject2).cubicTo(24.008106F, 3.6F, 18.482447F, 5.596181F, 14.051764F, 8.9598F);
      ((Path)localObject2).lineTo(20.073467F, 14.982182F);
      ((Path)localObject2).cubicTo(22.919012F, 13.097538F, 26.331333F, 12.0F, 30.0F, 12.0F);
      ((Path)localObject2).cubicTo(39.941124F, 12.0F, 48.0F, 20.058874F, 48.0F, 30.0F);
      ((Path)localObject2).cubicTo(48.0F, 33.668667F, 46.902462F, 37.08099F, 45.017818F, 39.926533F);
      ((Path)localObject2).lineTo(51.040199F, 45.948235F);
      ((Path)localObject2).cubicTo(54.40382F, 41.517551F, 56.400002F, 35.991894F, 56.400002F, 30.0F);
      ((Path)localObject2).cubicTo(56.400002F, 15.419683F, 44.580318F, 3.6F, 30.0F, 3.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 15.6F);
      ((Path)localObject2).cubicTo(27.329443F, 15.6F, 24.828678F, 16.326971F, 22.684807F, 17.593815F);
      ((Path)localObject2).lineTo(42.406185F, 37.315193F);
      ((Path)localObject2).cubicTo(43.673031F, 35.171322F, 44.400002F, 32.670559F, 44.400002F, 30.0F);
      ((Path)localObject2).cubicTo(44.400002F, 22.0471F, 37.9529F, 15.6F, 30.0F, 15.6F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_menu_minimize_cancel
 * JD-Core Version:    0.7.0.1
 */