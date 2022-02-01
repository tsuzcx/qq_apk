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

public class finder_live_icon_location_loading
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      c.instancePaint(localPaint1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -96.0F, 0.0F, 1.0F, -519.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 96.0F, 0.0F, 1.0F, 519.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(40.0F, 0.0F);
      localPath.cubicTo(62.091389F, 0.0F, 80.0F, 17.908609F, 80.0F, 40.0F);
      localPath.cubicTo(80.0F, 62.091389F, 62.091389F, 80.0F, 40.0F, 80.0F);
      localPath.lineTo(40.0F, 73.0F);
      localPath.cubicTo(58.225395F, 73.0F, 73.0F, 58.225395F, 73.0F, 40.0F);
      localPath.cubicTo(73.0F, 21.774603F, 58.225395F, 7.0F, 40.0F, 7.0F);
      localPath.lineTo(40.0F, 0.0F);
      localPath.close();
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint3 = c.instancePaint(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 80.0F, 0.0F, 40.0F, 0.0F, 80.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.9408692F, 0.0F, 0.9408692F, 0.9055908F, new int[] { 15592941, 1290661357 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(40.0F, 0.0F);
      localPath.lineTo(40.0F, 7.0F);
      localPath.cubicTo(21.774603F, 7.0F, 7.0F, 21.774603F, 7.0F, 40.0F);
      localPath.cubicTo(7.0F, 58.225395F, 21.774603F, 73.0F, 40.0F, 73.0F);
      localPath.lineTo(40.0F, 80.0F);
      localPath.cubicTo(17.908609F, 80.0F, 0.0F, 62.091389F, 0.0F, 40.0F);
      localPath.cubicTo(0.0F, 17.908609F, 17.908609F, 0.0F, 40.0F, 0.0F);
      localPath.close();
      localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      localPaint3 = c.instancePaint(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 40.0F, 0.0F, 0.0F, 0.0F, 80.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 1.0F, 0.08673706F, 1.0F, 0.906287F, new int[] { -1184275, 1290661357 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1184275);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(40.5F, 0.0F);
      ((Path)localObject2).cubicTo(42.432999F, 0.0F, 44.0F, 1.567003F, 44.0F, 3.5F);
      ((Path)localObject2).cubicTo(44.0F, 5.432997F, 42.432999F, 7.0F, 40.5F, 7.0F);
      ((Path)localObject2).cubicTo(38.567001F, 7.0F, 37.0F, 5.432997F, 37.0F, 3.5F);
      ((Path)localObject2).cubicTo(37.0F, 1.567003F, 38.567001F, 0.0F, 40.5F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_icon_location_loading
 * JD-Core Version:    0.7.0.1
 */