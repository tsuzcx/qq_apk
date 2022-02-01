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

public class ime_about_large
  extends c
{
  private final int height = 128;
  private final int width = 128;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 128;
      return 128;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -313.0F, 0.0F, 1.0F, -272.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 313.0F, 0.0F, 1.0F, 272.0F, 0.0F, 0.0F, 1.0F);
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
      localPath.moveTo(120.0F, 1.0F);
      localPath.cubicTo(121.933F, 1.0F, 123.683F, 1.783502F, 124.94975F, 3.050252F);
      localPath.cubicTo(126.2165F, 4.317003F, 127.0F, 6.067003F, 127.0F, 8.0F);
      localPath.lineTo(127.0F, 8.0F);
      localPath.lineTo(127.0F, 120.0F);
      localPath.cubicTo(127.0F, 121.933F, 126.2165F, 123.683F, 124.94975F, 124.94975F);
      localPath.cubicTo(123.683F, 126.2165F, 121.933F, 127.0F, 120.0F, 127.0F);
      localPath.lineTo(120.0F, 127.0F);
      localPath.lineTo(8.0F, 127.0F);
      localPath.cubicTo(6.067003F, 127.0F, 4.317003F, 126.2165F, 3.050252F, 124.94975F);
      localPath.cubicTo(1.783502F, 123.683F, 1.0F, 121.933F, 1.0F, 120.0F);
      localPath.lineTo(1.0F, 120.0F);
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 26.0F, 0.0F, 0.0F, 1.0F);
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
      ((Path)localObject3).moveTo(21.875923F, 56.348312F);
      ((Path)localObject3).lineTo(12.903604F, 60.218952F);
      ((Path)localObject3).cubicTo(12.552035F, 60.370617F, 12.144022F, 60.20871F, 11.992278F, 59.857323F);
      ((Path)localObject3).cubicTo(11.96138F, 59.785774F, 11.942779F, 59.709526F, 11.937256F, 59.63179F);
      ((Path)localObject3).lineTo(11.316418F, 50.893242F);
      ((Path)localObject3).cubicTo(4.576701F, 45.596912F, 0.3F, 37.697697F, 0.3F, 28.874067F);
      ((Path)localObject3).cubicTo(0.3F, 12.927361F, 14.268716F, 0.0F, 31.5F, 0.0F);
      ((Path)localObject3).cubicTo(48.731285F, 0.0F, 62.700001F, 12.927361F, 62.700001F, 28.874067F);
      ((Path)localObject3).cubicTo(62.700001F, 44.820774F, 48.731285F, 57.748135F, 31.5F, 57.748135F);
      ((Path)localObject3).cubicTo(28.141623F, 57.748135F, 24.907175F, 57.257076F, 21.875923F, 56.348312F);
      ((Path)localObject3).lineTo(21.875923F, 56.348312F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.0F, 73.379311F);
      ((Path)localObject2).cubicTo(12.0F, 71.931946F, 13.173323F, 70.758621F, 14.620689F, 70.758621F);
      ((Path)localObject2).lineTo(48.379311F, 70.758621F);
      ((Path)localObject2).cubicTo(49.826679F, 70.758621F, 51.0F, 71.931946F, 51.0F, 73.379311F);
      ((Path)localObject2).lineTo(51.0F, 73.379311F);
      ((Path)localObject2).cubicTo(51.0F, 74.826675F, 49.826679F, 76.0F, 48.379311F, 76.0F);
      ((Path)localObject2).lineTo(14.620689F, 76.0F);
      ((Path)localObject2).cubicTo(13.173323F, 76.0F, 12.0F, 74.826675F, 12.0F, 73.379311F);
      ((Path)localObject2).lineTo(12.0F, 73.379311F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-12799119);
      localPaint2.setColor(-12799119);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(19.799999F, 28.827587F);
      ((Path)localObject1).cubicTo(18.364059F, 28.827587F, 17.200001F, 27.654264F, 17.200001F, 26.206896F);
      ((Path)localObject1).cubicTo(17.200001F, 24.759529F, 18.364059F, 23.586206F, 19.799999F, 23.586206F);
      ((Path)localObject1).cubicTo(21.235941F, 23.586206F, 22.4F, 24.759529F, 22.4F, 26.206896F);
      ((Path)localObject1).cubicTo(22.4F, 27.654264F, 21.235941F, 28.827587F, 19.799999F, 28.827587F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(43.200001F, 28.827587F);
      ((Path)localObject1).cubicTo(41.764061F, 28.827587F, 40.599998F, 27.654264F, 40.599998F, 26.206896F);
      ((Path)localObject1).cubicTo(40.599998F, 24.759529F, 41.764061F, 23.586206F, 43.200001F, 23.586206F);
      ((Path)localObject1).cubicTo(44.635941F, 23.586206F, 45.799999F, 24.759529F, 45.799999F, 26.206896F);
      ((Path)localObject1).cubicTo(45.799999F, 27.654264F, 44.635941F, 28.827587F, 43.200001F, 28.827587F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_about_large
 * JD-Core Version:    0.7.0.1
 */