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

public class welab_icon_grey
  extends c
{
  private final int height = 45;
  private final int width = 33;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 33;
      return 45;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 0.785714F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 0.053569F, 0.0F, 1.0F, 0.421829F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-7829368);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(8.589289F, 33.004162F);
      ((Path)localObject3).cubicTo(8.589289F, 32.768894F, 8.780011F, 32.578171F, 9.015279F, 32.578171F);
      ((Path)localObject3).lineTo(21.159014F, 32.578171F);
      ((Path)localObject3).cubicTo(21.394281F, 32.578171F, 21.585003F, 32.768894F, 21.585003F, 33.004162F);
      ((Path)localObject3).lineTo(21.585003F, 34.509323F);
      ((Path)localObject3).cubicTo(21.585003F, 34.744591F, 21.394281F, 34.935314F, 21.159014F, 34.935314F);
      ((Path)localObject3).lineTo(9.015279F, 34.935314F);
      ((Path)localObject3).cubicTo(8.780011F, 34.935314F, 8.589289F, 34.744591F, 8.589289F, 34.509323F);
      ((Path)localObject3).lineTo(8.589289F, 33.004162F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-7829368);
      ((Paint)localObject2).setStrokeWidth(2.357143F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(22.859083F, 30.466698F);
      ((Path)localObject3).cubicTo(25.697063F, 28.206388F, 27.516407F, 24.719078F, 27.516407F, 20.806364F);
      ((Path)localObject3).cubicTo(27.516407F, 13.992444F, 21.998783F, 8.468672F, 15.192449F, 8.468672F);
      ((Path)localObject3).cubicTo(8.386114F, 8.468672F, 2.868491F, 13.992444F, 2.868491F, 20.806364F);
      ((Path)localObject3).cubicTo(2.868491F, 24.744936F, 4.71196F, 28.252464F, 7.582215F, 30.511353F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-7829368);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(11.901223F, 38.671078F);
      ((Path)localObject3).cubicTo(12.822826F, 38.835445F, 13.754634F, 38.918335F, 14.693224F, 38.918335F);
      ((Path)localObject3).cubicTo(15.647946F, 38.918335F, 16.595642F, 38.832573F, 17.532709F, 38.662533F);
      ((Path)localObject3).cubicTo(17.970507F, 38.583092F, 18.281555F, 37.997532F, 18.227455F, 37.354652F);
      ((Path)localObject3).cubicTo(18.173357F, 36.711769F, 17.774595F, 36.255009F, 17.3368F, 36.33445F);
      ((Path)localObject3).cubicTo(16.464689F, 36.492702F, 15.582418F, 36.572544F, 14.693224F, 36.572544F);
      ((Path)localObject3).cubicTo(13.819049F, 36.572544F, 12.95156F, 36.495377F, 12.093828F, 36.3424F);
      ((Path)localObject3).cubicTo(11.65592F, 36.264297F, 11.257809F, 36.722275F, 11.204622F, 37.365322F);
      ((Path)localObject3).cubicTo(11.151436F, 38.008369F, 11.463314F, 38.592976F, 11.901223F, 38.671078F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-7829368);
      ((Paint)localObject1).setStrokeWidth(2.357143F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.ROUND);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.922117F, 18.676264F);
      ((Path)localObject2).lineTo(12.898021F, 23.514427F);
      ((Path)localObject2).lineTo(16.873924F, 18.674042F);
      ((Path)localObject2).lineTo(20.849829F, 23.525074F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-7829368);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.303575F, 1.935888F);
      ((Path)localObject2).lineTo(14.303575F, 3.534917F);
      ((Path)localObject2).cubicTo(14.303575F, 4.185824F, 14.831239F, 4.713489F, 15.482145F, 4.713489F);
      ((Path)localObject2).cubicTo(16.133053F, 4.713489F, 16.660717F, 4.185824F, 16.660717F, 3.534917F);
      ((Path)localObject2).lineTo(16.660717F, 1.935888F);
      ((Path)localObject2).cubicTo(16.660717F, 1.284981F, 16.133053F, 0.7573163F, 15.482145F, 0.7573163F);
      ((Path)localObject2).cubicTo(14.831239F, 0.7573163F, 14.303575F, 1.284981F, 14.303575F, 1.935888F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-7829368);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(29.17959F, 7.334117F);
      ((Path)localObject2).lineTo(27.936911F, 8.340419F);
      ((Path)localObject2).cubicTo(27.431061F, 8.750048F, 27.35306F, 9.49219F, 27.762688F, 9.99804F);
      ((Path)localObject2).cubicTo(28.172318F, 10.503889F, 28.914459F, 10.581892F, 29.420309F, 10.172263F);
      ((Path)localObject2).lineTo(30.662989F, 9.165961F);
      ((Path)localObject2).cubicTo(31.168839F, 8.756332F, 31.246841F, 8.01419F, 30.837212F, 7.50834F);
      ((Path)localObject2).cubicTo(30.427582F, 7.00249F, 29.68544F, 6.924488F, 29.17959F, 7.334117F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-7829368);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.4369114F, 9.165961F);
      ((Path)localObject1).lineTo(1.679591F, 10.172263F);
      ((Path)localObject1).cubicTo(2.18544F, 10.581892F, 2.927583F, 10.503889F, 3.337212F, 9.99804F);
      ((Path)localObject1).cubicTo(3.746841F, 9.49219F, 3.668838F, 8.750048F, 3.162989F, 8.340419F);
      ((Path)localObject1).lineTo(1.92031F, 7.334117F);
      ((Path)localObject1).cubicTo(1.41446F, 6.924488F, 0.672318F, 7.00249F, 0.2626885F, 7.50834F);
      ((Path)localObject1).cubicTo(-0.1469406F, 8.01419F, -0.0689383F, 8.756332F, 0.4369114F, 9.165961F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.welab_icon_grey
 * JD-Core Version:    0.7.0.1
 */