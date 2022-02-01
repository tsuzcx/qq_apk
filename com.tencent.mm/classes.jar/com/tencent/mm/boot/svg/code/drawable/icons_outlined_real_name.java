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

public class icons_outlined_real_name
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(18.0F, 13.0F);
      localPath.lineTo(18.0F, 17.0F);
      localPath.cubicTo(18.0F, 17.552284F, 17.552284F, 18.0F, 17.0F, 18.0F);
      localPath.lineTo(13.0F, 18.0F);
      localPath.lineTo(13.0F, 16.799999F);
      localPath.lineTo(16.799999F, 16.799999F);
      localPath.lineTo(16.799999F, 13.0F);
      localPath.lineTo(18.0F, 13.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(5.0F, 0.0F);
      localPath.lineTo(5.0F, 1.2F);
      localPath.lineTo(1.2F, 1.2F);
      localPath.lineTo(1.2F, 5.0F);
      localPath.lineTo(0.0F, 5.0F);
      localPath.lineTo(0.0F, 1.0F);
      localPath.cubicTo(0.0F, 0.4477153F, 0.4477153F, 0.0F, 1.0F, 0.0F);
      localPath.lineTo(5.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.83697E-016F, -1.0F, 18.0F, 1.0F, -1.83697E-016F, 13.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(5.0F, 13.0F);
      localPath.lineTo(5.0F, 17.0F);
      localPath.cubicTo(5.0F, 17.552284F, 4.552285F, 18.0F, 4.0F, 18.0F);
      localPath.lineTo(0.0F, 18.0F);
      localPath.lineTo(0.0F, 16.799999F);
      localPath.lineTo(3.8F, 16.799999F);
      localPath.lineTo(3.8F, 13.0F);
      localPath.lineTo(5.0F, 13.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.83697E-016F, -1.0F, 18.0F, 1.0F, -1.83697E-016F, -13.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(18.0F, 0.0F);
      ((Path)localObject1).lineTo(18.0F, 1.2F);
      ((Path)localObject1).lineTo(14.2F, 1.2F);
      ((Path)localObject1).lineTo(14.2F, 5.0F);
      ((Path)localObject1).lineTo(13.0F, 5.0F);
      ((Path)localObject1).lineTo(13.0F, 1.0F);
      ((Path)localObject1).cubicTo(13.0F, 0.4477153F, 13.447716F, 0.0F, 14.0F, 0.0F);
      ((Path)localObject1).lineTo(18.0F, 0.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.954579F, 3.9F);
      ((Path)localObject2).cubicTo(7.647746F, 3.9F, 6.609675F, 5.038992F, 6.609675F, 6.416029F);
      ((Path)localObject2).lineTo(6.609675F, 7.235078F);
      ((Path)localObject2).cubicTo(6.609675F, 8.04658F, 6.777059F, 8.850614F, 7.157232F, 9.345451F);
      ((Path)localObject2).lineTo(7.422504F, 9.694115F);
      ((Path)localObject2).cubicTo(7.481661F, 9.771126F, 7.422083F, 10.303252F, 7.428741F, 10.299685F);
      ((Path)localObject2).lineTo(6.591175F, 10.652569F);
      ((Path)localObject2).cubicTo(5.467669F, 11.134483F, 4.718575F, 11.495947F, 4.349126F, 11.737631F);
      ((Path)localObject2).cubicTo(3.743144F, 12.13405F, 3.468206F, 12.769984F, 3.534909F, 13.551054F);
      ((Path)localObject2).cubicTo(3.561474F, 13.862123F, 3.822151F, 14.100841F, 4.134352F, 14.1F);
      ((Path)localObject2).lineTo(13.870925F, 14.073718F);
      ((Path)localObject2).cubicTo(14.185677F, 14.072868F, 14.44627F, 13.828941F, 14.467889F, 13.514932F);
      ((Path)localObject2).cubicTo(14.530967F, 12.598752F, 14.165095F, 11.895576F, 13.398249F, 11.533316F);
      ((Path)localObject2).lineTo(12.992169F, 11.348414F);
      ((Path)localObject2).cubicTo(12.619717F, 11.183533F, 12.13145F, 10.977187F, 11.526298F, 10.728859F);
      ((Path)localObject2).lineTo(10.516F, 10.319F);
      ((Path)localObject2).lineTo(10.54015F, 10.352386F);
      ((Path)localObject2).cubicTo(10.450836F, 10.283905F, 10.422512F, 9.811966F, 10.511349F, 9.69632F);
      ((Path)localObject2).lineTo(10.783136F, 9.350859F);
      ((Path)localObject2).cubicTo(11.164985F, 8.853839F, 11.299482F, 8.108813F, 11.299482F, 7.235508F);
      ((Path)localObject2).lineTo(11.299482F, 6.416329F);
      ((Path)localObject2).cubicTo(11.299482F, 5.039171F, 10.262579F, 3.9F, 8.954579F, 3.9F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.954579F, 5.1F);
      ((Path)localObject2).cubicTo(9.573336F, 5.1F, 10.099483F, 5.67804F, 10.099483F, 6.416329F);
      ((Path)localObject2).lineTo(10.099483F, 7.235508F);
      ((Path)localObject2).cubicTo(10.099483F, 7.858089F, 10.002029F, 8.397913F, 9.835731F, 8.614398F);
      ((Path)localObject2).lineTo(9.563942F, 8.959859F);
      ((Path)localObject2).cubicTo(9.088173F, 9.579145F, 9.161912F, 10.807768F, 9.809983F, 11.304676F);
      ((Path)localObject2).lineTo(9.951616F, 11.38537F);
      ((Path)localObject2).lineTo(11.45544F, 11.997788F);
      ((Path)localObject2).cubicTo(12.097683F, 12.264446F, 12.575026F, 12.471584F, 12.885681F, 12.618339F);
      ((Path)localObject2).lineTo(12.978031F, 12.668512F);
      ((Path)localObject2).cubicTo(13.063879F, 12.722319F, 13.130333F, 12.787549F, 13.181F, 12.875F);
      ((Path)localObject2).lineTo(4.839F, 12.898F);
      ((Path)localObject2).lineTo(4.86673F, 12.861819F);
      ((Path)localObject2).cubicTo(4.905179F, 12.81699F, 4.951566F, 12.77749F, 5.006058F, 12.741842F);
      ((Path)localObject2).cubicTo(5.375301F, 12.500293F, 6.368551F, 12.038387F, 7.942927F, 11.382375F);
      ((Path)localObject2).cubicTo(8.696982F, 10.981484F, 8.853155F, 9.586598F, 8.375799F, 8.965267F);
      ((Path)localObject2).lineTo(8.110528F, 8.616603F);
      ((Path)localObject2).cubicTo(7.929674F, 8.381191F, 7.809676F, 7.804772F, 7.809676F, 7.235078F);
      ((Path)localObject2).lineTo(7.809676F, 6.416029F);
      ((Path)localObject2).cubicTo(7.809676F, 5.678165F, 8.336612F, 5.1F, 8.954579F, 5.1F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_real_name
 * JD-Core Version:    0.7.0.1
 */