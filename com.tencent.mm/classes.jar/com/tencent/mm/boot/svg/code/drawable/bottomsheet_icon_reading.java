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

public class bottomsheet_icon_reading
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-8683387);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 18.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.3293F, 71.960197F);
      ((Path)localObject2).cubicTo(13.4363F, 68.363197F, 11.7613F, 63.576199F, 11.7333F, 58.826199F);
      ((Path)localObject2).cubicTo(11.7123F, 55.3172F, 9.3753F, 52.236198F, 6.6693F, 48.668201F);
      ((Path)localObject2).cubicTo(6.0453F, 47.846199F, 5.4243F, 47.026199F, 4.8313F, 46.201199F);
      ((Path)localObject2).cubicTo(1.7113F, 41.8592F, 0.0413F, 36.305199F, 0.0003F, 30.1402F);
      ((Path)localObject2).cubicTo(-0.0897F, 16.2672F, 9.4763F, 3.9412F, 22.747299F, 0.8312F);
      ((Path)localObject2).cubicTo(31.8983F, -1.3138F, 41.284302F, 0.7372F, 48.497299F, 6.4552F);
      ((Path)localObject2).cubicTo(55.707298F, 12.1712F, 59.8433F, 20.721201F, 59.8433F, 29.9132F);
      ((Path)localObject2).cubicTo(59.8433F, 35.833199F, 58.112301F, 41.558201F, 54.837299F, 46.471199F);
      ((Path)localObject2).lineTo(47.348301F, 41.478199F);
      ((Path)localObject2).cubicTo(49.6353F, 38.049198F, 50.8433F, 34.050201F, 50.8433F, 29.9132F);
      ((Path)localObject2).cubicTo(50.8433F, 23.4862F, 47.950298F, 17.506201F, 42.9063F, 13.5082F);
      ((Path)localObject2).cubicTo(37.860298F, 9.5082F, 31.261299F, 8.0822F, 24.8013F, 9.5942F);
      ((Path)localObject2).cubicTo(15.5823F, 11.7542F, 8.9373F, 20.370199F, 9.0003F, 30.0812F);
      ((Path)localObject2).cubicTo(9.0293F, 34.371201F, 10.1153F, 38.130199F, 12.1403F, 40.950199F);
      ((Path)localObject2).cubicTo(12.6883F, 41.7122F, 13.2633F, 42.4692F, 13.8393F, 43.229198F);
      ((Path)localObject2).cubicTo(17.052299F, 47.465199F, 20.6943F, 52.266201F, 20.733299F, 58.773201F);
      ((Path)localObject2).cubicTo(20.7353F, 59.231201F, 20.924299F, 69.992203F, 31.785299F, 69.992203F);
      ((Path)localObject2).cubicTo(38.520302F, 69.992203F, 40.529301F, 65.093201F, 41.126301F, 62.173199F);
      ((Path)localObject2).cubicTo(42.2533F, 56.669201F, 38.796299F, 52.346199F, 31.1283F, 49.669201F);
      ((Path)localObject2).cubicTo(21.6763F, 46.054199F, 16.327299F, 38.870201F, 16.327299F, 29.9132F);
      ((Path)localObject2).cubicTo(16.327299F, 21.864201F, 22.011299F, 16.242201F, 30.1513F, 16.242201F);
      ((Path)localObject2).cubicTo(37.462299F, 16.242201F, 43.410301F, 22.3752F, 43.410301F, 29.9132F);
      ((Path)localObject2).cubicTo(43.410301F, 34.200199F, 41.304298F, 36.981201F, 40.5103F, 38.027199F);
      ((Path)localObject2).lineTo(32.939453F, 33.421631F);
      ((Path)localObject2).cubicTo(34.161301F, 32.040527F, 34.410301F, 31.176201F, 34.410301F, 29.9132F);
      ((Path)localObject2).cubicTo(34.410301F, 27.6672F, 33.214844F, 25.261963F, 30.0F, 25.261963F);
      ((Path)localObject2).cubicTo(26.785156F, 25.261963F, 25.327299F, 27.509521F, 25.327299F, 29.9132F);
      ((Path)localObject2).cubicTo(25.327299F, 36.4132F, 30.1173F, 39.635201F, 34.161301F, 41.196201F);
      ((Path)localObject2).cubicTo(51.860298F, 47.408199F, 50.7173F, 60.201199F, 49.944302F, 63.978199F);
      ((Path)localObject2).cubicTo(48.047298F, 73.239197F, 41.089298F, 78.992203F, 31.785299F, 78.992203F);
      ((Path)localObject2).cubicTo(23.6863F, 78.992203F, 18.910299F, 75.168198F, 16.3293F, 71.960197F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_reading
 * JD-Core Version:    0.7.0.1
 */