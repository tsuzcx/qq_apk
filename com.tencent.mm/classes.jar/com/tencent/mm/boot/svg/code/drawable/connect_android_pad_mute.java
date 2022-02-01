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

public class connect_android_pad_mute
  extends c
{
  private final int height = 308;
  private final int width = 465;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 465;
      return 308;
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 28.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(354.0F, 252.0F);
      ((Path)localObject2).lineTo(12.0F, 252.0F);
      ((Path)localObject2).cubicTo(5.372583F, 252.0F, 0.0F, 246.62741F, 0.0F, 240.0F);
      ((Path)localObject2).lineTo(0.0F, 12.0F);
      ((Path)localObject2).cubicTo(0.0F, 5.372583F, 5.372583F, 0.0F, 12.0F, 0.0F);
      ((Path)localObject2).lineTo(354.0F, 0.0F);
      ((Path)localObject2).cubicTo(360.62741F, 0.0F, 366.0F, 5.372583F, 366.0F, 12.0F);
      ((Path)localObject2).lineTo(366.0F, 48.0F);
      ((Path)localObject2).lineTo(363.0F, 48.0F);
      ((Path)localObject2).lineTo(363.0F, 12.0F);
      ((Path)localObject2).cubicTo(363.0F, 7.206957F, 359.25323F, 3.289017F, 354.52881F, 3.015278F);
      ((Path)localObject2).lineTo(354.0F, 3.0F);
      ((Path)localObject2).lineTo(12.0F, 3.0F);
      ((Path)localObject2).cubicTo(7.206957F, 3.0F, 3.289017F, 6.74676F, 3.015278F, 11.471182F);
      ((Path)localObject2).lineTo(3.0F, 12.0F);
      ((Path)localObject2).lineTo(3.0F, 240.0F);
      ((Path)localObject2).cubicTo(3.0F, 244.79305F, 6.74676F, 248.71098F, 11.471182F, 248.98473F);
      ((Path)localObject2).lineTo(12.0F, 249.0F);
      ((Path)localObject2).lineTo(361.93695F, 249.00047F);
      ((Path)localObject2).cubicTo(359.82159F, 250.86728F, 357.04309F, 252.0F, 354.0F, 252.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(183.0F, 9.0F);
      ((Path)localObject2).cubicTo(184.65686F, 9.0F, 186.0F, 10.343145F, 186.0F, 12.0F);
      ((Path)localObject2).cubicTo(186.0F, 13.656855F, 184.65686F, 15.0F, 183.0F, 15.0F);
      ((Path)localObject2).cubicTo(181.34314F, 15.0F, 180.0F, 13.656855F, 180.0F, 12.0F);
      ((Path)localObject2).cubicTo(180.0F, 10.343145F, 181.34314F, 9.0F, 183.0F, 9.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(357.0F, 60.5F);
      ((Path)localObject2).cubicTo(357.0F, 60.223858F, 357.22385F, 60.0F, 357.5F, 60.0F);
      ((Path)localObject2).lineTo(374.5F, 60.0F);
      ((Path)localObject2).cubicTo(374.77615F, 60.0F, 375.0F, 60.223858F, 375.0F, 60.5F);
      ((Path)localObject2).lineTo(375.0F, 62.5F);
      ((Path)localObject2).cubicTo(375.0F, 62.776142F, 374.77615F, 63.0F, 374.5F, 63.0F);
      ((Path)localObject2).lineTo(357.5F, 63.0F);
      ((Path)localObject2).cubicTo(357.22385F, 63.0F, 357.0F, 62.776142F, 357.0F, 62.5F);
      ((Path)localObject2).lineTo(357.0F, 60.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(408.0F, 48.0F);
      ((Path)localObject2).cubicTo(416.28427F, 48.0F, 423.0F, 54.715729F, 423.0F, 63.0F);
      ((Path)localObject2).lineTo(423.0F, 237.0F);
      ((Path)localObject2).cubicTo(423.0F, 245.28427F, 416.28427F, 252.0F, 408.0F, 252.0F);
      ((Path)localObject2).lineTo(324.0F, 252.0F);
      ((Path)localObject2).cubicTo(315.71573F, 252.0F, 309.0F, 245.28427F, 309.0F, 237.0F);
      ((Path)localObject2).lineTo(309.0F, 63.0F);
      ((Path)localObject2).cubicTo(309.0F, 54.715729F, 315.71573F, 48.0F, 324.0F, 48.0F);
      ((Path)localObject2).lineTo(408.0F, 48.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(408.0F, 51.0F);
      ((Path)localObject2).lineTo(324.0F, 51.0F);
      ((Path)localObject2).cubicTo(317.57343F, 51.0F, 312.32675F, 56.051907F, 312.01468F, 62.401077F);
      ((Path)localObject2).lineTo(312.0F, 63.0F);
      ((Path)localObject2).lineTo(312.0F, 237.0F);
      ((Path)localObject2).cubicTo(312.0F, 243.42659F, 317.05191F, 248.67323F, 323.40109F, 248.98532F);
      ((Path)localObject2).lineTo(324.0F, 249.0F);
      ((Path)localObject2).lineTo(408.0F, 249.0F);
      ((Path)localObject2).cubicTo(414.42657F, 249.0F, 419.67325F, 243.94809F, 419.98532F, 237.59892F);
      ((Path)localObject2).lineTo(420.0F, 237.0F);
      ((Path)localObject2).lineTo(420.0F, 63.0F);
      ((Path)localObject2).cubicTo(420.0F, 56.573414F, 414.94809F, 51.326763F, 408.59891F, 51.014687F);
      ((Path)localObject2).lineTo(408.0F, 51.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(411.0F, 72.0F);
      ((Path)localObject2).cubicTo(412.65686F, 72.0F, 414.0F, 73.343147F, 414.0F, 75.0F);
      ((Path)localObject2).lineTo(414.0F, 222.0F);
      ((Path)localObject2).cubicTo(414.0F, 223.65686F, 412.65686F, 225.0F, 411.0F, 225.0F);
      ((Path)localObject2).lineTo(321.0F, 225.0F);
      ((Path)localObject2).cubicTo(319.34314F, 225.0F, 318.0F, 223.65686F, 318.0F, 222.0F);
      ((Path)localObject2).lineTo(318.0F, 75.0F);
      ((Path)localObject2).cubicTo(318.0F, 73.343147F, 319.34314F, 72.0F, 321.0F, 72.0F);
      ((Path)localObject2).lineTo(411.0F, 72.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(411.0F, 75.0F);
      ((Path)localObject2).lineTo(321.0F, 75.0F);
      ((Path)localObject2).lineTo(321.0F, 222.0F);
      ((Path)localObject2).lineTo(411.0F, 222.0F);
      ((Path)localObject2).lineTo(411.0F, 75.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(366.0F, 127.0F);
      ((Path)localObject1).cubicTo(368.20914F, 127.0F, 370.0F, 128.79086F, 370.0F, 131.0F);
      ((Path)localObject1).cubicTo(370.0F, 131.22607F, 369.98123F, 131.44777F, 369.94522F, 131.6636F);
      ((Path)localObject1).cubicTo(374.63458F, 133.29538F, 378.0F, 137.75467F, 378.0F, 143.0F);
      ((Path)localObject1).lineTo(378.0F, 151.0F);
      ((Path)localObject1).cubicTo(378.0F, 153.07217F, 378.53674F, 155.14436F, 379.61023F, 157.21654F);
      ((Path)localObject1).lineTo(386.84995F, 164.45584F);
      ((Path)localObject1).lineTo(385.15289F, 166.15289F);
      ((Path)localObject1).lineTo(351.69705F, 132.69705F);
      ((Path)localObject1).lineTo(353.3941F, 131.0F);
      ((Path)localObject1).lineTo(357.2171F, 134.82309F);
      ((Path)localObject1).cubicTo(358.53476F, 133.40842F, 360.19009F, 132.31247F, 362.05478F, 131.6636F);
      ((Path)localObject1).cubicTo(362.01877F, 131.44777F, 362.0F, 131.22607F, 362.0F, 131.0F);
      ((Path)localObject1).cubicTo(362.0F, 128.79086F, 363.79086F, 127.0F, 366.0F, 127.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(352.37341F, 163.00006F);
      ((Path)localObject1).cubicTo(351.94745F, 163.00006F, 351.53262F, 162.864F, 351.18933F, 162.6118F);
      ((Path)localObject1).cubicTo(350.29919F, 161.95786F, 350.10773F, 160.70613F, 350.76169F, 159.81599F);
      ((Path)localObject1).cubicTo(352.92053F, 156.8773F, 354.0F, 153.93864F, 354.0F, 151.0F);
      ((Path)localObject1).lineTo(354.0F, 143.0F);
      ((Path)localObject1).cubicTo(354.0F, 141.61897F, 354.23328F, 140.29245F, 354.6626F, 139.05766F);
      ((Path)localObject1).lineTo(356.60895F, 141.00302F);
      ((Path)localObject1).cubicTo(356.47177F, 141.6496F, 356.39999F, 142.31796F, 356.39999F, 143.0F);
      ((Path)localObject1).lineTo(356.39999F, 151.0F);
      ((Path)localObject1).cubicTo(356.39999F, 154.26065F, 355.297F, 157.47102F, 353.14844F, 160.60005F);
      ((Path)localObject1).lineTo(376.20636F, 160.60001F);
      ((Path)localObject1).lineTo(378.60635F, 163.0F);
      ((Path)localObject1).lineTo(368.0F, 163.0F);
      ((Path)localObject1).lineTo(368.0F, 163.39999F);
      ((Path)localObject1).cubicTo(368.0F, 164.50456F, 367.10458F, 165.39999F, 366.0F, 165.39999F);
      ((Path)localObject1).cubicTo(364.89542F, 165.39999F, 364.0F, 164.50456F, 364.0F, 163.39999F);
      ((Path)localObject1).lineTo(364.0F, 163.0F);
      ((Path)localObject1).lineTo(352.37341F, 163.00006F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(366.0F, 129.39999F);
      ((Path)localObject1).cubicTo(365.11633F, 129.39999F, 364.39999F, 130.11635F, 364.39999F, 131.0F);
      ((Path)localObject1).cubicTo(364.39999F, 131.09148F, 364.40744F, 131.181F, 364.42203F, 131.26836F);
      ((Path)localObject1).lineTo(364.7554F, 133.26501F);
      ((Path)localObject1).lineTo(362.84354F, 133.9303F);
      ((Path)localObject1).cubicTo(361.30933F, 134.46416F, 359.96951F, 135.36595F, 358.91486F, 136.52026F);
      ((Path)localObject1).lineTo(375.80121F, 153.40761F);
      ((Path)localObject1).cubicTo(375.66736F, 152.60846F, 375.60001F, 151.80576F, 375.60001F, 151.0F);
      ((Path)localObject1).lineTo(375.60001F, 143.0F);
      ((Path)localObject1).cubicTo(375.60001F, 138.88173F, 372.98279F, 135.26175F, 369.15646F, 133.9303F);
      ((Path)localObject1).lineTo(367.2446F, 133.26501F);
      ((Path)localObject1).lineTo(367.57797F, 131.26836F);
      ((Path)localObject1).cubicTo(367.59256F, 131.181F, 367.60001F, 131.09148F, 367.60001F, 131.0F);
      ((Path)localObject1).cubicTo(367.60001F, 130.11635F, 366.88367F, 129.39999F, 366.0F, 129.39999F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_android_pad_mute
 * JD-Core Version:    0.7.0.1
 */