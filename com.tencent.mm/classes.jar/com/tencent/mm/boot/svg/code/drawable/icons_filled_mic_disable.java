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

public class icons_filled_mic_disable
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 7.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.506432F, 6.860826F);
      ((Path)localObject2).cubicTo(5.636235F, 6.790162F, 5.676828F, 6.729498F, 5.712015F, 6.612761F);
      ((Path)localObject2).lineTo(5.991965F, 5.516953F);
      ((Path)localObject2).cubicTo(6.140923F, 4.939528F, 6.313309F, 4.283926F, 6.441841F, 3.82227F);
      ((Path)localObject2).cubicTo(6.494363F, 3.622027F, 6.587211F, 3.440218F, 6.740204F, 3.276154F);
      ((Path)localObject2).cubicTo(6.902759F, 3.101835F, 7.097464F, 2.995839F, 7.303811F, 2.939041F);
      ((Path)localObject2).cubicTo(8.442805F, 2.601703F, 9.615337F, 2.372323F, 10.794799F, 2.341113F);
      ((Path)localObject2).cubicTo(11.964005F, 2.300339F, 13.149704F, 2.447482F, 14.309488F, 2.704654F);
      ((Path)localObject2).cubicTo(14.5193F, 2.74694F, 14.73119F, 2.848677F, 14.89527F, 3.001685F);
      ((Path)localObject2).cubicTo(15.049095F, 3.145129F, 15.164673F, 3.32959F, 15.231053F, 3.525687F);
      ((Path)localObject2).lineTo(15.553032F, 4.442951F);
      ((Path)localObject2).cubicTo(15.781395F, 5.110322F, 16.015753F, 5.823044F, 16.127542F, 6.1829F);
      ((Path)localObject2).cubicTo(16.182976F, 6.349617F, 16.225382F, 6.427503F, 16.376434F, 6.491679F);
      ((Path)localObject2).lineTo(19.506844F, 7.781315F);
      ((Path)localObject2).cubicTo(19.878656F, 7.917158F, 20.292042F, 7.823377F, 20.589159F, 7.525319F);
      ((Path)localObject2).cubicTo(20.703903F, 7.402271F, 20.786497F, 7.210899F, 20.804928F, 7.170575F);
      ((Path)localObject2).cubicTo(21.372828F, 5.821413F, 21.088453F, 4.214275F, 19.960402F, 3.16235F);
      ((Path)localObject2).cubicTo(19.642496F, 2.865898F, 19.268604F, 2.670604F, 19.187256F, 2.613918F);
      ((Path)localObject2).cubicTo(16.574724F, 1.09789F, 13.633898F, 0.4067982F, 10.72079F, 0.5083862F);
      ((Path)localObject2).cubicTo(7.953338F, 0.6048948F, 5.210902F, 1.416797F, 2.799908F, 2.950418F);
      ((Path)localObject2).lineTo(2.328416F, 3.259014F);
      ((Path)localObject2).cubicTo(2.182032F, 3.35795F, 1.919624F, 3.552285F, 1.689072F, 3.799521F);
      ((Path)localObject2).cubicTo(0.6873345F, 4.873753F, 0.484151F, 6.397045F, 1.03786F, 7.668129F);
      ((Path)localObject2).lineTo(1.126587F, 7.856812F);
      ((Path)localObject2).cubicTo(1.14779F, 7.895755F, 1.233988F, 8.091161F, 1.366611F, 8.195663F);
      ((Path)localObject2).cubicTo(1.693385F, 8.462043F, 2.112315F, 8.526798F, 2.473734F, 8.365386F);
      ((Path)localObject2).lineTo(5.506432F, 6.860826F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_mic_disable
 * JD-Core Version:    0.7.0.1
 */