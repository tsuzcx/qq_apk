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

public class circle_notvisible
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-4144960);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 2.032928F);
      localPath.cubicTo(21.182825F, -0.5018033F, 27.471985F, -0.5018033F, 32.973755F, 1.12694F);
      localPath.cubicTo(32.993687F, 7.41796F, 33.033554F, 13.70898F, 32.943851F, 20.0F);
      localPath.cubicTo(27.452051F, 14.116166F, 21.721043F, 8.446104F, 16.089703F, 2.694605F);
      localPath.lineTo(16.0F, 2.032928F);
      localPath.lineTo(16.0F, 2.032928F);
      localPath.lineTo(16.0F, 2.032928F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-4144960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(35.044933F, 2.0F);
      localPath.cubicTo(40.505497F, 4.291358F, 45.505173F, 8.37037F, 48.0F, 13.723456F);
      localPath.cubicTo(44.072399F, 17.575308F, 40.054626F, 21.358025F, 36.297356F, 25.377777F);
      localPath.cubicTo(36.016811F, 25.535803F, 35.445709F, 25.851852F, 35.165165F, 26.0F);
      localPath.cubicTo(34.854565F, 18.019753F, 35.085011F, 10.0F, 35.044933F, 2.0F);
      localPath.lineTo(35.044933F, 2.0F);
      localPath.lineTo(35.044933F, 2.0F);
      localPath.lineTo(35.044933F, 2.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-4144960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(2.0F, 15.985457F);
      localPath.cubicTo(4.326753F, 10.500481F, 8.496777F, 5.326352F, 14.046737F, 3.0F);
      localPath.cubicTo(18.307413F, 7.36191F, 22.638597F, 11.643602F, 27.0F, 15.905239F);
      localPath.cubicTo(18.670025F, 16.085732F, 10.329976F, 15.945349F, 2.0F, 15.985457F);
      localPath.lineTo(2.0F, 15.985457F);
      localPath.lineTo(2.0F, 15.985457F);
      localPath.lineTo(2.0F, 15.985457F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-4144960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(49.047852F, 16.0F);
      localPath.cubicTo(50.593304F, 19.073931F, 50.989834F, 22.605059F, 51.0F, 26.0F);
      localPath.cubicTo(47.837929F, 24.025291F, 42.700947F, 24.778288F, 39.0F, 24.846382F);
      localPath.cubicTo(41.999393F, 22.443659F, 45.763771F, 17.663424F, 49.047852F, 16.0F);
      localPath.lineTo(49.047852F, 16.0F);
      localPath.lineTo(49.047852F, 16.0F);
      localPath.lineTo(49.047852F, 16.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-4144960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(1.126957F, 18.018436F);
      localPath.cubicTo(7.414564F, 17.989225F, 13.712394F, 17.998962F, 20.0F, 18.018436F);
      localPath.cubicTo(13.988435F, 23.636763F, 8.05866F, 29.547205F, 2.036871F, 35.0F);
      localPath.cubicTo(-0.2225779F, 29.634838F, -0.7133179F, 23.558867F, 1.126957F, 18.018436F);
      localPath.lineTo(1.126957F, 18.018436F);
      localPath.lineTo(1.126957F, 18.018436F);
      localPath.lineTo(1.126957F, 18.018436F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-4144960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(3.0F, 36.980186F);
      localPath.cubicTo(7.383488F, 32.72422F, 11.636574F, 28.336838F, 15.939815F, 24.0F);
      localPath.cubicTo(16.020061F, 32.329964F, 16.020061F, 40.670036F, 15.939815F, 49.0F);
      localPath.cubicTo(10.493055F, 46.674889F, 5.357253F, 42.520016F, 3.0F, 36.980186F);
      localPath.lineTo(3.0F, 36.980186F);
      localPath.lineTo(3.0F, 36.980186F);
      localPath.lineTo(3.0F, 36.980186F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-4144960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(18.0F, 31.0F);
      localPath.cubicTo(21.248619F, 34.507523F, 24.574585F, 37.933472F, 27.832872F, 41.430798F);
      localPath.cubicTo(28.335636F, 44.612038F, 29.979282F, 47.487392F, 32.0F, 49.873322F);
      localPath.cubicTo(27.53315F, 51.514923F, 22.534531F, 51.229427F, 18.029005F, 49.873322F);
      localPath.cubicTo(17.990332F, 43.582214F, 18.05801F, 37.291107F, 18.0F, 31.0F);
      localPath.lineTo(18.0F, 31.0F);
      localPath.lineTo(18.0F, 31.0F);
      localPath.lineTo(18.0F, 31.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-4802890);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 25.0F, 0.0F, 1.0F, 35.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.0F, 0.0F);
      localPath.cubicTo(3.855642F, 0.7027046F, 3.608863F, 2.771836F, 3.464505F, 3.47454F);
      localPath.lineTo(3.464505F, 4.0F);
      localPath.cubicTo(2.697358F, 3.250928F, 1.223613F, 2.137571F, 0.0F, 0.8100131F);
      localPath.cubicTo(1.223613F, 0.5459965F, 2.344398F, 0.2275163F, 4.0F, 0.0F);
      localPath.lineTo(4.0F, 0.0F);
      localPath.lineTo(4.0F, 0.0F);
      localPath.lineTo(4.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1150121);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 28.0F, 0.0F, 1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.0F, 30.0F);
      ((Path)localObject2).cubicTo(23.284271F, 30.0F, 30.0F, 23.284271F, 30.0F, 15.0F);
      ((Path)localObject2).cubicTo(30.0F, 6.715729F, 23.284271F, 0.0F, 15.0F, 0.0F);
      ((Path)localObject2).cubicTo(6.715729F, 0.0F, 0.0F, 6.715729F, 0.0F, 15.0F);
      ((Path)localObject2).cubicTo(0.0F, 23.284271F, 6.715729F, 30.0F, 15.0F, 30.0F);
      ((Path)localObject2).lineTo(15.0F, 30.0F);
      ((Path)localObject2).lineTo(15.0F, 30.0F);
      ((Path)localObject2).lineTo(15.0F, 30.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.0F, 12.0F);
      ((Path)localObject2).lineTo(24.0F, 12.0F);
      ((Path)localObject2).lineTo(24.0F, 18.0F);
      ((Path)localObject2).lineTo(6.0F, 18.0F);
      ((Path)localObject2).lineTo(6.0F, 12.0F);
      ((Path)localObject2).lineTo(6.0F, 12.0F);
      ((Path)localObject2).lineTo(6.0F, 12.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.circle_notvisible
 * JD-Core Version:    0.7.0.1
 */