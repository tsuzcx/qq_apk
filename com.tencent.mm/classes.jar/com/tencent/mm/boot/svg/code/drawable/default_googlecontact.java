package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class default_googlecontact
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      Paint localPaint2 = c.instancePaint((Paint)localObject, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPaint2.setColor(-789517);
      localPaint2.setStrokeWidth(3.0F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(192.0F, 0.0F);
      localPath.lineTo(192.0F, 192.0F);
      localPath.lineTo(0.0F, 192.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-2274503);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(140.0F, 87.0F);
      ((Path)localObject).lineTo(122.0F, 87.0F);
      ((Path)localObject).lineTo(122.0F, 95.0F);
      ((Path)localObject).lineTo(140.0F, 95.0F);
      ((Path)localObject).lineTo(140.0F, 113.0F);
      ((Path)localObject).lineTo(148.0F, 113.0F);
      ((Path)localObject).lineTo(148.0F, 95.0F);
      ((Path)localObject).lineTo(166.0F, 95.0F);
      ((Path)localObject).lineTo(166.0F, 87.0F);
      ((Path)localObject).lineTo(148.0F, 87.0F);
      ((Path)localObject).lineTo(148.0F, 69.0F);
      ((Path)localObject).lineTo(140.0F, 69.0F);
      ((Path)localObject).lineTo(140.0F, 87.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(96.312538F, 40.209396F);
      ((Path)localObject).cubicTo(101.09022F, 43.690666F, 104.68676F, 48.525387F, 106.36096F, 54.364017F);
      ((Path)localObject).cubicTo(107.8931F, 59.707218F, 107.61439F, 65.190552F, 105.86462F, 70.285782F);
      ((Path)localObject).lineTo(105.86462F, 70.285782F);
      ((Path)localObject).cubicTo(104.48492F, 75.030106F, 101.48369F, 81.01255F, 95.0F, 86.0F);
      ((Path)localObject).cubicTo(82.0F, 96.0F, 99.0F, 106.0F, 99.0F, 106.0F);
      ((Path)localObject).cubicTo(118.0F, 124.0F, 112.0F, 135.0F, 112.0F, 135.0F);
      ((Path)localObject).cubicTo(112.0F, 150.0F, 90.0F, 163.0F, 72.5F, 162.0F);
      ((Path)localObject).cubicTo(48.0F, 162.0F, 34.0F, 156.52707F, 34.0F, 136.52707F);
      ((Path)localObject).cubicTo(34.0F, 122.71995F, 51.237038F, 111.0F, 72.5F, 111.0F);
      ((Path)localObject).cubicTo(74.544373F, 111.0F, 76.560776F, 111.0832F, 78.53569F, 111.24693F);
      ((Path)localObject).cubicTo(76.755737F, 109.66964F, 74.568863F, 106.98203F, 74.0F, 103.0F);
      ((Path)localObject).cubicTo(73.252831F, 97.769791F, 74.738724F, 94.214386F, 75.537834F, 92.7509F);
      ((Path)localObject).cubicTo(60.421795F, 94.132095F, 46.477638F, 86.022766F, 42.639042F, 72.635986F);
      ((Path)localObject).cubicTo(38.214382F, 57.20536F, 48.892124F, 40.606052F, 66.488449F, 35.56039F);
      ((Path)localObject).cubicTo(70.878929F, 34.301437F, 75.285301F, 33.880722F, 79.495033F, 34.198013F);
      ((Path)localObject).lineTo(79.0F, 34.0F);
      ((Path)localObject).lineTo(116.0F, 34.0F);
      ((Path)localObject).cubicTo(116.0F, 34.0F, 111.0F, 39.0F, 107.0F, 40.0F);
      ((Path)localObject).cubicTo(104.282F, 40.679501F, 99.255402F, 40.435558F, 96.312538F, 40.209396F);
      ((Path)localObject).lineTo(96.312538F, 40.209396F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(100.48076F, 130.73825F);
      ((Path)localObject).cubicTo(100.82511F, 132.25267F, 101.0F, 133.84477F, 101.0F, 135.5F);
      ((Path)localObject).cubicTo(101.0F, 147.37411F, 92.0F, 157.0F, 75.0F, 155.0F);
      ((Path)localObject).cubicTo(58.0F, 153.0F, 49.0F, 146.87411F, 49.0F, 135.0F);
      ((Path)localObject).cubicTo(49.0F, 123.12588F, 60.0F, 115.0F, 76.0F, 115.0F);
      ((Path)localObject).cubicTo(79.351738F, 115.0F, 82.396294F, 115.37853F, 85.11528F, 116.08617F);
      ((Path)localObject).cubicTo(89.293495F, 119.02377F, 96.631409F, 124.69926F, 100.48076F, 130.73825F);
      ((Path)localObject).lineTo(100.48076F, 130.73825F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(82.166092F, 87.416687F);
      ((Path)localObject).cubicTo(91.322853F, 84.61718F, 95.541954F, 71.868172F, 91.589714F, 58.940971F);
      ((Path)localObject).cubicTo(87.637474F, 46.013771F, 77.010521F, 37.80365F, 67.853752F, 40.603157F);
      ((Path)localObject).cubicTo(58.696987F, 43.40266F, 54.477886F, 56.151672F, 58.43013F, 69.078873F);
      ((Path)localObject).cubicTo(62.38237F, 82.006073F, 73.009323F, 90.216194F, 82.166092F, 87.416687F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_googlecontact
 * JD-Core Version:    0.7.0.1
 */