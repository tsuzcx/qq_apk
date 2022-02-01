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

public class default_chatroom_box
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-526345);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(19.485527F, -1.694073E-015F);
      localPath.lineTo(172.51447F, 1.694073E-015F);
      localPath.cubicTo(179.29001F, -9.843051E-016F, 181.74699F, 0.7054747F, 184.22403F, 2.030209F);
      localPath.cubicTo(186.70107F, 3.354943F, 188.64507F, 5.298935F, 189.96979F, 7.775973F);
      localPath.cubicTo(191.29453F, 10.25301F, 192.0F, 12.709985F, 192.0F, 19.485527F);
      localPath.lineTo(192.0F, 172.51447F);
      localPath.cubicTo(192.0F, 179.29001F, 191.29453F, 181.74699F, 189.96979F, 184.22403F);
      localPath.cubicTo(188.64507F, 186.70107F, 186.70107F, 188.64507F, 184.22403F, 189.96979F);
      localPath.cubicTo(181.74699F, 191.29453F, 179.29001F, 192.0F, 172.51447F, 192.0F);
      localPath.lineTo(19.485527F, 192.0F);
      localPath.cubicTo(12.709985F, 192.0F, 10.25301F, 191.29453F, 7.775973F, 189.96979F);
      localPath.cubicTo(5.298935F, 188.64507F, 3.354943F, 186.70107F, 2.030209F, 184.22403F);
      localPath.cubicTo(0.7054747F, 181.74699F, 8.318356E-016F, 179.29001F, -1.43166E-015F, 172.51447F);
      localPath.lineTo(1.43166E-015F, 19.485527F);
      localPath.cubicTo(-8.318356E-016F, 12.709985F, 0.7054747F, 10.25301F, 2.030209F, 7.775973F);
      localPath.cubicTo(3.354943F, 5.298935F, 5.298935F, 3.354943F, 7.775973F, 2.030209F);
      localPath.cubicTo(10.25301F, 0.7054747F, 12.709985F, 9.843051E-016F, 19.485527F, -1.694073E-015F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-352965);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 40.0F, 0.0F, 1.0F, 40.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(88.666664F, 70.0F);
      ((Path)localObject2).cubicTo(98.975983F, 70.0F, 107.33334F, 78.357353F, 107.33334F, 88.666664F);
      ((Path)localObject2).cubicTo(107.33334F, 98.975983F, 98.975983F, 107.33334F, 88.666664F, 107.33334F);
      ((Path)localObject2).cubicTo(78.357353F, 107.33334F, 70.0F, 98.975983F, 70.0F, 88.666664F);
      ((Path)localObject2).cubicTo(70.0F, 78.357353F, 78.357353F, 70.0F, 88.666664F, 70.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(49.0F, 14.0F);
      ((Path)localObject2).cubicTo(59.309315F, 14.0F, 67.666664F, 22.367241F, 67.666664F, 32.667633F);
      ((Path)localObject2).lineTo(67.666664F, 40.647533F);
      ((Path)localObject2).cubicTo(67.666664F, 45.963383F, 64.871017F, 53.586681F, 61.451073F, 57.640675F);
      ((Path)localObject2).lineTo(59.76392F, 59.640621F);
      ((Path)localObject2).cubicTo(57.012817F, 62.901772F, 57.872208F, 67.052521F, 61.719227F, 68.929047F);
      ((Path)localObject2).lineTo(71.309845F, 73.607086F);
      ((Path)localObject2).cubicTo(67.872437F, 77.671249F, 65.800003F, 82.926933F, 65.800003F, 88.666664F);
      ((Path)localObject2).cubicTo(65.800003F, 91.985458F, 66.492882F, 95.142426F, 67.741882F, 98.000793F);
      ((Path)localObject2).lineTo(9.340005F, 98.0F);
      ((Path)localObject2).cubicTo(6.758991F, 98.0F, 4.666667F, 95.926857F, 4.666667F, 93.340622F);
      ((Path)localObject2).lineTo(4.666667F, 90.138832F);
      ((Path)localObject2).cubicTo(4.666667F, 86.94175F, 6.991371F, 83.215569F, 9.865789F, 81.812889F);
      ((Path)localObject2).lineTo(36.280769F, 68.922668F);
      ((Path)localObject2).cubicTo(40.111759F, 67.053185F, 41.002541F, 62.91256F, 38.236076F, 59.633648F);
      ((Path)localObject2).lineTo(36.548927F, 57.633976F);
      ((Path)localObject2).cubicTo(33.11615F, 53.565331F, 30.333334F, 45.964317F, 30.333334F, 40.643356F);
      ((Path)localObject2).lineTo(30.333334F, 32.664707F);
      ((Path)localObject2).cubicTo(30.333334F, 22.356474F, 38.711662F, 14.0F, 49.0F, 14.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(98.0F, 86.333336F);
      ((Path)localObject2).lineTo(79.333336F, 86.333336F);
      ((Path)localObject2).lineTo(79.333336F, 91.0F);
      ((Path)localObject2).lineTo(98.0F, 91.0F);
      ((Path)localObject2).lineTo(98.0F, 86.333336F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(68.992653F, 18.674973F);
      ((Path)localObject2).cubicTo(77.434258F, 18.945921F, 84.193626F, 25.810858F, 84.193626F, 34.22303F);
      ((Path)localObject2).lineTo(84.193626F, 40.872944F);
      ((Path)localObject2).cubicTo(84.193626F, 45.302818F, 81.839394F, 51.655567F, 78.959442F, 55.033894F);
      ((Path)localObject2).lineTo(77.538681F, 56.700516F);
      ((Path)localObject2).cubicTo(75.221962F, 59.41814F, 75.945663F, 62.877102F, 79.185257F, 64.440872F);
      ((Path)localObject2).lineTo(82.82299F, 66.196648F);
      ((Path)localObject2).cubicTo(80.540573F, 66.836311F, 78.399605F, 67.814369F, 76.457619F, 69.073303F);
      ((Path)localObject2).lineTo(64.400002F, 63.192516F);
      ((Path)localObject2).lineTo(65.275841F, 62.154301F);
      ((Path)localObject2).cubicTo(69.764618F, 56.833313F, 73.140991F, 47.609905F, 73.140991F, 40.647533F);
      ((Path)localObject2).lineTo(73.140991F, 32.667633F);
      ((Path)localObject2).cubicTo(73.140991F, 27.506985F, 71.616241F, 22.700583F, 68.992653F, 18.674973F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_chatroom_box
 * JD-Core Version:    0.7.0.1
 */