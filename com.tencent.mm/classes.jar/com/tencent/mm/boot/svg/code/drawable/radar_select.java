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

public class radar_select
  extends c
{
  private final int height = 74;
  private final int width = 74;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 74;
      return 74;
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16335356);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(34.948597F, 0.0F);
      localPath.lineTo(38.705669F, 0.0F);
      localPath.cubicTo(48.546585F, 0.5134044F, 58.08532F, 5.033377F, 64.622429F, 12.412307F);
      localPath.cubicTo(70.252998F, 18.613426F, 73.456078F, 26.797697F, 74.0F, 35.122902F);
      localPath.lineTo(74.0F, 38.646267F);
      localPath.cubicTo(73.506447F, 56.816757F, 57.883869F, 72.943695F, 39.692783F, 73.869835F);
      localPath.cubicTo(25.923563F, 75.087914F, 11.942819F, 67.658646F, 5.08339F, 55.709412F);
      localPath.cubicTo(-2.068143F, 43.901112F, -1.614877F, 28.106375F, 6.070503F, 16.660477F);
      localPath.cubicTo(12.37594F, 6.966193F, 23.425564F, 0.694606F, 34.948597F, 0.0F);
      localPath.lineTo(34.948597F, 0.0F);
      localPath.close();
      localPath.moveTo(55.60017F, 22.880356F);
      localPath.cubicTo(48.029774F, 30.035088F, 40.683239F, 37.427979F, 33.163719F, 44.652172F);
      localPath.cubicTo(29.073265F, 40.782066F, 25.227016F, 36.663879F, 21.004284F, 32.942627F);
      localPath.cubicTo(18.725027F, 31.414433F, 16.232088F, 33.66703F, 15.285789F, 35.621929F);
      localPath.cubicTo(14.817726F, 37.55698F, 16.496645F, 38.896633F, 17.7075F, 40.127129F);
      localPath.cubicTo(22.215141F, 44.423935F, 26.590502F, 48.859669F, 31.108318F, 53.146553F);
      localPath.cubicTo(32.410751F, 54.59536F, 34.761234F, 54.04958F, 35.829639F, 52.630539F);
      localPath.cubicTo(43.817219F, 44.801022F, 51.825146F, 36.981426F, 59.853428F, 29.201527F);
      localPath.cubicTo(60.952354F, 28.149652F, 62.336189F, 26.760384F, 61.654449F, 25.103186F);
      localPath.cubicTo(60.769199F, 22.959743F, 57.665745F, 20.717068F, 55.60017F, 22.880356F);
      localPath.lineTo(55.60017F, 22.880356F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 14.191781F, 0.0F, 1.0F, 21.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(41.408386F, 0.8803564F);
      ((Path)localObject2).cubicTo(43.473965F, -1.282932F, 46.577419F, 0.9597431F, 47.462666F, 3.103185F);
      ((Path)localObject2).cubicTo(48.144409F, 4.760384F, 46.760574F, 6.149652F, 45.661648F, 7.201526F);
      ((Path)localObject2).cubicTo(37.633366F, 14.981427F, 29.625437F, 22.801022F, 21.637857F, 30.630539F);
      ((Path)localObject2).cubicTo(20.569456F, 32.04958F, 18.218969F, 32.59536F, 16.916536F, 31.146553F);
      ((Path)localObject2).cubicTo(12.398722F, 26.859669F, 8.023359F, 22.423935F, 3.515719F, 18.127127F);
      ((Path)localObject2).cubicTo(2.304864F, 16.896633F, 0.6259456F, 15.556981F, 1.094008F, 13.621929F);
      ((Path)localObject2).cubicTo(2.040307F, 11.66703F, 4.533246F, 9.414432F, 6.812504F, 10.942627F);
      ((Path)localObject2).cubicTo(11.035236F, 14.66388F, 14.881485F, 18.782068F, 18.971939F, 22.652172F);
      ((Path)localObject2).cubicTo(26.491457F, 15.427978F, 33.837994F, 8.035087F, 41.408386F, 0.8803564F);
      ((Path)localObject2).lineTo(41.408386F, 0.8803564F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.radar_select
 * JD-Core Version:    0.7.0.1
 */