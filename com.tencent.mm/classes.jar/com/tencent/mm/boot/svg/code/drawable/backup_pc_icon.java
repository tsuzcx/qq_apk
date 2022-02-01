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

public class backup_pc_icon
  extends c
{
  private final int height = 292;
  private final int width = 476;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 476;
      return 292;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-13158344);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 470.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(304.0F, 278.73099F);
      localPath.lineTo(304.0F, 284.00101F);
      localPath.lineTo(166.0F, 284.00101F);
      localPath.lineTo(166.0F, 278.73099F);
      localPath.lineTo(219.0F, 273.73099F);
      localPath.lineTo(219.0F, 240.00101F);
      localPath.lineTo(251.0F, 240.00101F);
      localPath.lineTo(251.0F, 273.73099F);
      localPath.lineTo(304.0F, 278.73099F);
      localPath.close();
      localPath.moveTo(254.0F, 240.0F);
      localPath.lineTo(366.98499F, 240.0F);
      localPath.lineTo(366.98499F, 237.00101F);
      localPath.lineTo(254.0F, 237.00101F);
      localPath.lineTo(216.0F, 237.0F);
      localPath.lineTo(62.006001F, 237.00101F);
      localPath.cubicTo(55.938F, 237.00101F, 51.0F, 232.063F, 51.0F, 225.994F);
      localPath.lineTo(51.0F, 14.007F);
      localPath.cubicTo(51.0F, 7.938F, 55.938F, 3.001F, 62.006001F, 3.001F);
      localPath.lineTo(407.99301F, 3.001F);
      localPath.cubicTo(414.06299F, 3.001F, 419.0F, 7.938F, 419.0F, 14.007F);
      localPath.lineTo(419.0F, 97.389999F);
      localPath.lineTo(422.0F, 97.389999F);
      localPath.lineTo(422.0F, 14.007F);
      localPath.cubicTo(422.0F, 6.266F, 415.729F, 0.0F, 407.99301F, 0.0F);
      localPath.lineTo(62.007F, 0.0F);
      localPath.cubicTo(54.276001F, 0.0F, 48.0F, 6.271F, 48.0F, 14.007F);
      localPath.lineTo(48.0F, 225.994F);
      localPath.cubicTo(48.0F, 233.735F, 54.271F, 240.0F, 62.007F, 240.0F);
      localPath.lineTo(216.0F, 240.0F);
      localPath.lineTo(216.0F, 271.0F);
      localPath.lineTo(163.0F, 276.0F);
      localPath.lineTo(163.0F, 287.0F);
      localPath.lineTo(307.0F, 287.0F);
      localPath.lineTo(307.0F, 276.0F);
      localPath.lineTo(254.0F, 271.0F);
      localPath.lineTo(254.0F, 240.0F);
      localPath.close();
      localPath.moveTo(365.98541F, 226.0006F);
      localPath.lineTo(62.000401F, 226.0006F);
      localPath.lineTo(62.000401F, 14.0006F);
      localPath.lineTo(408.0004F, 14.0006F);
      localPath.lineTo(408.0004F, 95.390602F);
      localPath.cubicTo(408.0004F, 95.390602F, 408.99939F, 97.022392F, 408.99939F, 95.017754F);
      localPath.lineTo(408.99939F, 13.0006F);
      localPath.lineTo(60.999401F, 13.0006F);
      localPath.lineTo(60.999401F, 227.0006F);
      localPath.lineTo(365.98541F, 227.0006F);
      localPath.lineTo(365.98541F, 226.0006F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 106.0F, 0.0F, 1.0F, 96.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-13092808);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(3.0F, 183.006F);
      localPath.lineTo(3.0F, 7.994F);
      localPath.cubicTo(3.0F, 5.24F, 5.243F, 3.0F, 8.0F, 3.0F);
      localPath.lineTo(98.0F, 3.0F);
      localPath.cubicTo(100.757F, 3.0F, 103.0F, 5.24F, 103.0F, 7.994F);
      localPath.lineTo(103.0F, 183.006F);
      localPath.cubicTo(103.0F, 185.75999F, 100.757F, 188.0F, 98.0F, 188.0F);
      localPath.lineTo(8.0F, 188.0F);
      localPath.cubicTo(5.243F, 188.0F, 3.0F, 185.75999F, 3.0F, 183.006F);
      localPath.lineTo(3.0F, 183.006F);
      localPath.close();
      localPath.moveTo(98.0F, 191.0F);
      localPath.cubicTo(102.418F, 191.0F, 106.0F, 187.418F, 106.0F, 183.006F);
      localPath.lineTo(106.0F, 7.994F);
      localPath.cubicTo(106.0F, 3.579F, 102.412F, 0.0F, 98.0F, 0.0F);
      localPath.lineTo(8.0F, 0.0F);
      localPath.cubicTo(3.582F, 0.0F, 0.0F, 3.582F, 0.0F, 7.994F);
      localPath.lineTo(0.0F, 183.006F);
      localPath.cubicTo(0.0F, 187.42101F, 3.588F, 191.0F, 8.0F, 191.0F);
      localPath.lineTo(98.0F, 191.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 35.0F, 0.0F, 1.0F, 77.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-13092808);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(1.0F, 157.0F);
      localPath.lineTo(91.0F, 157.0F);
      localPath.lineTo(91.0F, 11.0F);
      localPath.lineTo(1.0F, 11.0F);
      localPath.lineTo(1.0F, 157.0F);
      localPath.close();
      localPath.moveTo(0.0F, 158.0F);
      localPath.lineTo(92.0F, 158.0F);
      localPath.lineTo(92.0F, 10.0F);
      localPath.lineTo(0.0F, 10.0F);
      localPath.lineTo(0.0F, 158.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-15028967);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 0.0F, 92.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(13.652F, 52.567215F);
      ((Path)localObject1).cubicTo(12.7396F, 52.567215F, 12.0F, 51.936596F, 12.0F, 51.158642F);
      ((Path)localObject1).cubicTo(12.0F, 50.380619F, 12.7396F, 49.75F, 13.652F, 49.75F);
      ((Path)localObject1).lineTo(66.348F, 49.75F);
      ((Path)localObject1).cubicTo(67.260399F, 49.75F, 68.0F, 50.380619F, 68.0F, 51.158573F);
      ((Path)localObject1).cubicTo(68.0F, 51.936527F, 67.260399F, 52.567215F, 66.348F, 52.567215F);
      ((Path)localObject1).lineTo(13.652F, 52.567215F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(77.994003F, 68.137474F);
      ((Path)localObject1).lineTo(14.006001F, 68.137474F);
      ((Path)localObject1).cubicTo(12.898087F, 68.137474F, 12.0F, 67.506859F, 12.0F, 66.728905F);
      ((Path)localObject1).lineTo(12.0F, 66.728836F);
      ((Path)localObject1).cubicTo(12.0F, 65.950882F, 12.898087F, 65.320259F, 14.006001F, 65.320259F);
      ((Path)localObject1).lineTo(77.994003F, 65.320259F);
      ((Path)localObject1).cubicTo(79.101913F, 65.320259F, 80.0F, 65.950882F, 80.0F, 66.728836F);
      ((Path)localObject1).lineTo(80.0F, 66.728905F);
      ((Path)localObject1).cubicTo(80.0F, 67.506859F, 79.101913F, 68.137474F, 77.994003F, 68.137474F);
      ((Path)localObject1).lineTo(77.994003F, 68.137474F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(46.024593F, 83.0F);
      ((Path)localObject1).lineTo(13.975407F, 83.0F);
      ((Path)localObject1).cubicTo(12.884389F, 83.0F, 12.0F, 82.36937F, 12.0F, 81.591393F);
      ((Path)localObject1).lineTo(12.0F, 81.591393F);
      ((Path)localObject1).cubicTo(12.0F, 80.813416F, 12.884389F, 80.182785F, 13.975407F, 80.182785F);
      ((Path)localObject1).lineTo(46.024593F, 80.182785F);
      ((Path)localObject1).cubicTo(47.115612F, 80.182785F, 48.0F, 80.813416F, 48.0F, 81.591393F);
      ((Path)localObject1).lineTo(48.0F, 81.591393F);
      ((Path)localObject1).cubicTo(47.999901F, 82.36937F, 47.115513F, 83.0F, 46.024593F, 83.0F);
      ((Path)localObject1).lineTo(46.024593F, 83.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-13092808);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(39.0F, 3.0F);
      ((Path)localObject1).lineTo(53.0F, 3.0F);
      ((Path)localObject1).lineTo(53.0F, 0.0F);
      ((Path)localObject1).lineTo(39.0F, 0.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.backup_pc_icon
 * JD-Core Version:    0.7.0.1
 */