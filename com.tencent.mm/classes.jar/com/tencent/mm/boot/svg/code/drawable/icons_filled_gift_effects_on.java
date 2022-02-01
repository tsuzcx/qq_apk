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

public class icons_filled_gift_effects_on
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
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject4 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 0.477583F, 0.0F, 1.0F, 2.250883F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.2F);
      localObject4 = c.setMatrixFloatArray((float[])localObject4, 0.9902681F, -0.1391731F, 1.055779F, 0.1391731F, 0.9902681F, -1.698077F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      Object localObject5 = c.instancePath(paramVarArgs);
      ((Path)localObject5).moveTo(9.216066F, 1.296942F);
      ((Path)localObject5).lineTo(12.645176F, 3.262717F);
      ((Path)localObject5).lineTo(16.039898F, 1.473625F);
      ((Path)localObject5).lineTo(15.370597F, 5.2649F);
      ((Path)localObject5).lineTo(18.282576F, 8.053694F);
      ((Path)localObject5).lineTo(14.378903F, 8.45003F);
      ((Path)localObject5).lineTo(12.694072F, 11.85248F);
      ((Path)localObject5).lineTo(11.007288F, 8.448805F);
      ((Path)localObject5).lineTo(7.043308F, 7.868495F);
      ((Path)localObject5).lineTo(9.917522F, 5.259838F);
      ((Path)localObject5).lineTo(9.216066F, 1.296942F);
      ((Path)localObject5).close();
      localCanvas.drawPath((Path)localObject5, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject5 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject5).setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, -4.286264E-016F, -1.0F, 32.126064F, 1.0F, -4.286264E-016F, -3.169649F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(16.859009F, 13.674356F);
      ((Path)localObject4).lineTo(14.637919F, 14.448564F);
      ((Path)localObject4).lineTo(16.859009F, 15.222772F);
      ((Path)localObject4).lineTo(17.618765F, 17.545397F);
      ((Path)localObject4).lineTo(18.378521F, 15.222772F);
      ((Path)localObject4).lineTo(20.657791F, 14.448564F);
      ((Path)localObject4).lineTo(18.378521F, 13.674356F);
      ((Path)localObject4).lineTo(17.618765F, 11.411018F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 1);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject5);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(19.556242F, 10.132676F);
      ((Path)localObject4).lineTo(20.755367F, 10.517527F);
      ((Path)localObject4).lineTo(21.195787F, 11.739993F);
      ((Path)localObject4).lineTo(21.57329F, 10.517527F);
      ((Path)localObject4).lineTo(22.772417F, 10.132676F);
      ((Path)localObject4).lineTo(21.57329F, 9.683683F);
      ((Path)localObject4).lineTo(21.195787F, 8.461217F);
      ((Path)localObject4).lineTo(20.755367F, 9.683683F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(1.2F);
      localObject2 = c.setMatrixFloatArray((float[])localObject3, 0.7071068F, -0.7071068F, 10.961224F, 0.7071068F, 0.7071068F, -0.2345734F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(4.602145F, 6.872008F);
      ((Path)localObject1).lineTo(4.53239F, 18.82692F);
      ((Path)localObject1).cubicTo(4.528545F, 19.485794F, 5.059552F, 20.023033F, 5.718427F, 20.026878F);
      ((Path)localObject1).cubicTo(5.720748F, 20.026892F, 5.723068F, 20.026899F, 5.725388F, 20.026899F);
      ((Path)localObject1).cubicTo(6.389259F, 20.026899F, 6.928516F, 19.49078F, 6.93239F, 18.82692F);
      ((Path)localObject1).lineTo(7.002145F, 6.872008F);
      ((Path)localObject1).lineTo(7.002145F, 6.872008F);
      ((Path)localObject1).lineTo(5.76386F, 6.201262F);
      ((Path)localObject1).lineTo(4.602145F, 6.872008F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_gift_effects_on
 * JD-Core Version:    0.7.0.1
 */