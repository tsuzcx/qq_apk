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

public class ime_logo_selected
  extends c
{
  private final int height = 50;
  private final int width = 50;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 50;
      return 50;
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -40.0F, 0.0F, 1.0F, -976.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -25.0F, 0.0F, 1.0F, 916.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 65.0F, 0.0F, 1.0F, 60.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject3 = c.instancePaint(localPaint1, paramVarArgs);
      Paint localPaint3 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject3).setColor(-12799119);
      localPaint3.setColor(-12799119);
      localPaint3.setStrokeWidth(2.0F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(42.0F, 1.0F);
      localPath.cubicTo(43.932995F, 1.0F, 45.682995F, 1.783502F, 46.949749F, 3.050252F);
      localPath.cubicTo(48.216499F, 4.317003F, 49.0F, 6.067003F, 49.0F, 8.0F);
      localPath.lineTo(49.0F, 8.0F);
      localPath.lineTo(49.0F, 42.0F);
      localPath.cubicTo(49.0F, 43.932995F, 48.216499F, 45.682995F, 46.949749F, 46.949749F);
      localPath.cubicTo(45.682995F, 48.216499F, 43.932995F, 49.0F, 42.0F, 49.0F);
      localPath.lineTo(42.0F, 49.0F);
      localPath.lineTo(8.0F, 49.0F);
      localPath.cubicTo(6.067003F, 49.0F, 4.317003F, 48.216499F, 3.050252F, 46.949749F);
      localPath.cubicTo(1.783502F, 45.682995F, 1.0F, 43.932995F, 1.0F, 42.0F);
      localPath.lineTo(1.0F, 42.0F);
      localPath.lineTo(1.0F, 8.0F);
      localPath.cubicTo(1.0F, 6.067003F, 1.783502F, 4.317003F, 3.050252F, 3.050252F);
      localPath.cubicTo(4.317003F, 1.783502F, 6.067003F, 1.0F, 8.0F, 1.0F);
      localPath.lineTo(8.0F, 1.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 12.244898F, 0.0F, 1.0F, 10.204082F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(8.977992F, 21.940132F);
      ((Path)localObject3).lineTo(5.456673F, 23.447227F);
      ((Path)localObject3).cubicTo(5.318696F, 23.506281F, 5.158564F, 23.443241F, 5.099011F, 23.306423F);
      ((Path)localObject3).cubicTo(5.086884F, 23.278563F, 5.079584F, 23.248875F, 5.077416F, 23.218609F);
      ((Path)localObject3).lineTo(4.833759F, 19.816113F);
      ((Path)localObject3).cubicTo(2.188658F, 17.753901F, 0.5102041F, 14.678212F, 0.5102041F, 11.242588F);
      ((Path)localObject3).cubicTo(0.5102041F, 5.033478F, 5.992432F, 0.0F, 12.755102F, 0.0F);
      ((Path)localObject3).cubicTo(19.517773F, 0.0F, 25.0F, 5.033478F, 25.0F, 11.242588F);
      ((Path)localObject3).cubicTo(25.0F, 17.451698F, 19.517773F, 22.485176F, 12.755102F, 22.485176F);
      ((Path)localObject3).cubicTo(11.437057F, 22.485176F, 10.167651F, 22.293974F, 8.977992F, 21.940132F);
      ((Path)localObject3).lineTo(8.977992F, 21.940132F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.102041F, 28.571428F);
      ((Path)localObject2).cubicTo(5.102041F, 28.007872F, 5.558893F, 27.55102F, 6.122449F, 27.55102F);
      ((Path)localObject2).lineTo(19.387754F, 27.55102F);
      ((Path)localObject2).cubicTo(19.951311F, 27.55102F, 20.408163F, 28.007872F, 20.408163F, 28.571428F);
      ((Path)localObject2).lineTo(20.408163F, 28.571426F);
      ((Path)localObject2).cubicTo(20.408163F, 29.134983F, 19.951311F, 29.591835F, 19.387754F, 29.591835F);
      ((Path)localObject2).lineTo(6.122449F, 29.591835F);
      ((Path)localObject2).cubicTo(5.558893F, 29.591835F, 5.102041F, 29.134983F, 5.102041F, 28.571426F);
      ((Path)localObject2).lineTo(5.102041F, 28.571428F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-12799119);
      localPaint2.setColor(-12799119);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(8.163265F, 11.22449F);
      ((Path)localObject1).cubicTo(7.59971F, 11.22449F, 7.142857F, 10.767637F, 7.142857F, 10.204082F);
      ((Path)localObject1).cubicTo(7.142857F, 9.640526F, 7.59971F, 9.183674F, 8.163265F, 9.183674F);
      ((Path)localObject1).cubicTo(8.726821F, 9.183674F, 9.183674F, 9.640526F, 9.183674F, 10.204082F);
      ((Path)localObject1).cubicTo(9.183674F, 10.767637F, 8.726821F, 11.22449F, 8.163265F, 11.22449F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(17.346939F, 11.22449F);
      ((Path)localObject1).cubicTo(16.783382F, 11.22449F, 16.32653F, 10.767637F, 16.32653F, 10.204082F);
      ((Path)localObject1).cubicTo(16.32653F, 9.640526F, 16.783382F, 9.183674F, 17.346939F, 9.183674F);
      ((Path)localObject1).cubicTo(17.910494F, 9.183674F, 18.367348F, 9.640526F, 18.367348F, 10.204082F);
      ((Path)localObject1).cubicTo(18.367348F, 10.767637F, 17.910494F, 11.22449F, 17.346939F, 11.22449F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_logo_selected
 * JD-Core Version:    0.7.0.1
 */