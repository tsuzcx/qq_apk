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

public class native_oauth_default_head_img
  extends c
{
  private final int height = 210;
  private final int width = 210;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 210;
      return 210;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -335.0F, 0.0F, 1.0F, -284.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 335.0F, 0.0F, 1.0F, 284.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-2565928);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 12.0F);
      ((Path)localObject2).cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      ((Path)localObject2).lineTo(198.0F, 0.0F);
      ((Path)localObject2).cubicTo(204.62741F, 0.0F, 210.0F, 5.372582F, 210.0F, 12.0F);
      ((Path)localObject2).lineTo(210.0F, 198.0F);
      ((Path)localObject2).cubicTo(210.0F, 204.62741F, 204.62741F, 210.0F, 198.0F, 210.0F);
      ((Path)localObject2).lineTo(12.0F, 210.0F);
      ((Path)localObject2).cubicTo(5.372582F, 210.0F, 0.0F, 204.62741F, 0.0F, 198.0F);
      ((Path)localObject2).lineTo(0.0F, 12.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(157.64894F, 92.3088F);
      ((Path)localObject1).lineTo(144.74844F, 105.2093F);
      ((Path)localObject1).lineTo(138.95433F, 99.415192F);
      ((Path)localObject1).lineTo(151.85483F, 86.514694F);
      ((Path)localObject1).cubicTo(159.84056F, 78.528969F, 159.70537F, 65.697449F, 151.70346F, 57.695538F);
      ((Path)localObject1).cubicTo(143.70525F, 49.697327F, 130.86548F, 49.562988F, 122.88431F, 57.544167F);
      ((Path)localObject1).lineTo(97.083305F, 83.345169F);
      ((Path)localObject1).cubicTo(89.09758F, 91.330887F, 89.232765F, 104.16241F, 97.23468F, 112.16432F);
      ((Path)localObject1).lineTo(91.501122F, 117.89788F);
      ((Path)localObject1).cubicTo(80.298676F, 106.69543F, 80.200867F, 88.639397F, 91.2892F, 77.551064F);
      ((Path)localObject1).lineTo(117.0902F, 51.750061F);
      ((Path)localObject1).cubicTo(128.17189F, 40.668373F, 146.23703F, 40.761997F, 157.43701F, 51.961983F);
      ((Path)localObject1).cubicTo(168.63947F, 63.164429F, 168.73727F, 81.220467F, 157.64894F, 92.3088F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(51.753483F, 117.08678F);
      ((Path)localObject1).lineTo(64.653984F, 104.18628F);
      ((Path)localObject1).lineTo(70.44809F, 109.98038F);
      ((Path)localObject1).lineTo(57.547588F, 122.88088F);
      ((Path)localObject1).cubicTo(49.561871F, 130.86661F, 49.697052F, 143.69812F, 57.698963F, 151.70004F);
      ((Path)localObject1).cubicTo(65.697174F, 159.69824F, 78.536942F, 159.83258F, 86.51812F, 151.85141F);
      ((Path)localObject1).lineTo(112.31912F, 126.05041F);
      ((Path)localObject1).cubicTo(120.30484F, 118.06469F, 120.16966F, 105.23316F, 112.16775F, 97.231255F);
      ((Path)localObject1).lineTo(117.90131F, 91.497696F);
      ((Path)localObject1).cubicTo(129.10376F, 102.70014F, 129.20155F, 120.75618F, 118.11323F, 131.84451F);
      ((Path)localObject1).lineTo(92.312225F, 157.64552F);
      ((Path)localObject1).cubicTo(81.230537F, 168.7272F, 63.165394F, 168.63358F, 51.965405F, 157.43359F);
      ((Path)localObject1).cubicTo(40.762959F, 146.23114F, 40.665154F, 128.17511F, 51.753483F, 117.08678F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.native_oauth_default_head_img
 * JD-Core Version:    0.7.0.1
 */