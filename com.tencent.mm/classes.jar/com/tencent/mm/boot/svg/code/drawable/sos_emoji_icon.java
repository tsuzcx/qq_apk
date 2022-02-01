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

public class sos_emoji_icon
  extends c
{
  private final int height = 42;
  private final int width = 42;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 42;
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
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-4737097);
      ((Paint)localObject3).setColor(-4737097);
      ((Paint)localObject3).setStrokeWidth(0.5F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(19.597933F, 30.307812F);
      localPath.cubicTo(16.679598F, 30.307812F, 13.962932F, 28.918991F, 12.334599F, 26.680159F);
      localPath.lineTo(26.861265F, 26.680159F);
      localPath.cubicTo(25.232931F, 28.918991F, 22.517099F, 30.307812F, 19.597933F, 30.307812F);
      localPath.moveTo(28.349598F, 25.0F);
      localPath.lineTo(10.845432F, 25.0F);
      localPath.cubicTo(10.553765F, 25.0F, 10.282932F, 25.149807F, 10.128765F, 25.393969F);
      localPath.cubicTo(9.973765F, 25.640612F, 9.957932F, 25.948503F, 10.085432F, 26.208389F);
      localPath.cubicTo(11.809599F, 29.719343F, 15.543765F, 31.98797F, 19.597933F, 31.98797F);
      localPath.cubicTo(23.652931F, 31.98797F, 27.386265F, 29.719343F, 29.109598F, 26.208389F);
      localPath.cubicTo(29.237932F, 25.947676F, 29.221266F, 25.640612F, 29.066265F, 25.393969F);
      localPath.cubicTo(28.912098F, 25.149807F, 28.641266F, 25.0F, 28.349598F, 25.0F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-4210753);
      ((Paint)localObject3).setColor(-4210753);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(19.975F, 38.047897F);
      ((Path)localObject3).cubicTo(9.894167F, 38.047897F, 1.691667F, 29.901197F, 1.691667F, 19.887285F);
      ((Path)localObject3).cubicTo(1.691667F, 9.87503F, 9.894167F, 1.729157F, 19.975F, 1.729157F);
      ((Path)localObject3).cubicTo(30.056667F, 1.729157F, 38.258335F, 9.87503F, 38.258335F, 19.887285F);
      ((Path)localObject3).cubicTo(38.258335F, 29.901197F, 30.056667F, 38.047897F, 19.975F, 38.047897F);
      ((Path)localObject3).moveTo(19.975F, 0.04899773F);
      ((Path)localObject3).cubicTo(8.96F, 0.04899773F, 0.0F, 8.948046F, 0.0F, 19.887285F);
      ((Path)localObject3).cubicTo(0.0F, 30.827354F, 8.96F, 39.728058F, 19.975F, 39.728058F);
      ((Path)localObject3).cubicTo(30.99F, 39.728058F, 39.950001F, 30.827354F, 39.950001F, 19.887285F);
      ((Path)localObject3).cubicTo(39.950001F, 8.948046F, 30.99F, 0.04899773F, 19.975F, 0.04899773F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-4737097);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.383333F, 14.045125F);
      ((Path)localObject2).cubicTo(12.845833F, 13.585771F, 13.46F, 13.333333F, 14.113334F, 13.333333F);
      ((Path)localObject2).cubicTo(14.766666F, 13.333333F, 15.381667F, 13.585771F, 15.843333F, 14.045125F);
      ((Path)localObject2).cubicTo(16.797501F, 14.992801F, 16.797501F, 16.534739F, 15.843333F, 17.482414F);
      ((Path)localObject2).cubicTo(14.92F, 18.399467F, 13.308333F, 18.399467F, 12.383333F, 17.482414F);
      ((Path)localObject2).cubicTo(11.920834F, 17.022234F, 11.666667F, 16.412245F, 11.666667F, 15.763356F);
      ((Path)localObject2).cubicTo(11.666667F, 15.114467F, 11.920834F, 14.504478F, 12.383333F, 14.045125F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-4737097);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(27.565332F, 17.653965F);
      ((Path)localObject1).cubicTo(26.642F, 18.571016F, 25.030333F, 18.571016F, 24.105333F, 17.653965F);
      ((Path)localObject1).cubicTo(23.642834F, 17.193783F, 23.388666F, 16.584623F, 23.388666F, 15.934906F);
      ((Path)localObject1).cubicTo(23.388666F, 15.286017F, 23.642834F, 14.676028F, 24.105333F, 14.216675F);
      ((Path)localObject1).cubicTo(24.568666F, 13.757321F, 25.182833F, 13.504884F, 25.836166F, 13.504884F);
      ((Path)localObject1).cubicTo(26.488667F, 13.504884F, 27.103666F, 13.757321F, 27.565332F, 14.216675F);
      ((Path)localObject1).cubicTo(28.519501F, 15.164351F, 28.519501F, 16.706289F, 27.565332F, 17.653965F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sos_emoji_icon
 * JD-Core Version:    0.7.0.1
 */