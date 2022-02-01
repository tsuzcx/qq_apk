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

public class bottomsheet_icon_hao_kan
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
      localPaint1.setColor(-8683388);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1105.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1105.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(29.562593F, 41.259117F);
      ((Path)localObject2).lineTo(16.244278F, 48.809719F);
      ((Path)localObject2).lineTo(11.775919F, 32.292778F);
      ((Path)localObject2).cubicTo(11.038423F, 29.547104F, 12.686943F, 26.715628F, 15.4634F, 25.986307F);
      ((Path)localObject2).lineTo(32.122139F, 21.56749F);
      ((Path)localObject2).lineTo(32.165524F, 36.754498F);
      ((Path)localObject2).cubicTo(32.165524F, 38.599247F, 31.167734F, 40.315292F, 29.562593F, 41.259117F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.165524F, 60.822041F);
      ((Path)localObject2).lineTo(32.122139F, 76.009048F);
      ((Path)localObject2).lineTo(15.4634F, 71.590233F);
      ((Path)localObject2).cubicTo(12.686943F, 70.860909F, 11.038423F, 68.029434F, 11.775919F, 65.28376F);
      ((Path)localObject2).lineTo(16.244278F, 48.809719F);
      ((Path)localObject2).lineTo(29.562593F, 56.360321F);
      ((Path)localObject2).cubicTo(31.167734F, 57.261246F, 32.165524F, 58.977291F, 32.165524F, 60.822041F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(50.646313F, 68.372643F);
      ((Path)localObject2).lineTo(63.921246F, 76.009048F);
      ((Path)localObject2).lineTo(51.687485F, 88.06427F);
      ((Path)localObject2).cubicTo(49.648521F, 90.080627F, 46.351482F, 90.080627F, 44.312519F, 88.06427F);
      ((Path)localObject2).lineTo(32.122139F, 76.009048F);
      ((Path)localObject2).lineTo(45.397076F, 68.372643F);
      ((Path)localObject2).cubicTo(47.002213F, 67.428818F, 48.997791F, 67.428818F, 50.646313F, 68.372643F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(66.437408F, 56.317421F);
      ((Path)localObject2).lineTo(79.755722F, 48.766819F);
      ((Path)localObject2).lineTo(84.224083F, 65.24086F);
      ((Path)localObject2).cubicTo(84.961578F, 67.986534F, 83.313057F, 70.818008F, 80.536606F, 71.547333F);
      ((Path)localObject2).lineTo(63.877865F, 75.966148F);
      ((Path)localObject2).lineTo(63.83448F, 60.77914F);
      ((Path)localObject2).cubicTo(63.83448F, 58.977291F, 64.832268F, 57.261246F, 66.437408F, 56.317421F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(63.83448F, 36.754498F);
      ((Path)localObject2).lineTo(63.877865F, 21.56749F);
      ((Path)localObject2).lineTo(80.536606F, 25.986307F);
      ((Path)localObject2).cubicTo(83.313057F, 26.715628F, 84.961578F, 29.547104F, 84.224083F, 32.292778F);
      ((Path)localObject2).lineTo(79.755722F, 48.766819F);
      ((Path)localObject2).lineTo(66.437408F, 41.216217F);
      ((Path)localObject2).cubicTo(64.832268F, 40.315292F, 63.83448F, 38.599247F, 63.83448F, 36.754498F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.397076F, 29.203894F);
      ((Path)localObject2).lineTo(32.122139F, 21.56749F);
      ((Path)localObject2).lineTo(44.312519F, 9.512265F);
      ((Path)localObject2).cubicTo(46.351482F, 7.495912F, 49.648521F, 7.495912F, 51.687485F, 9.512265F);
      ((Path)localObject2).lineTo(63.877865F, 21.56749F);
      ((Path)localObject2).lineTo(50.602928F, 29.203894F);
      ((Path)localObject2).cubicTo(48.997791F, 30.147718F, 47.002213F, 30.147718F, 45.397076F, 29.203894F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_hao_kan
 * JD-Core Version:    0.7.0.1
 */