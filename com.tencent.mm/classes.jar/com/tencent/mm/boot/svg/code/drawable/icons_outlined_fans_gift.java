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

public class icons_outlined_fans_gift
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
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-436207616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 3.25F, 0.0F, 1.0F, 3.399998F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(11.415334F, 0.00162252F);
      localPath.cubicTo(12.231084F, -0.0228832F, 13.034506F, 0.2311826F, 13.680764F, 0.7188646F);
      localPath.cubicTo(14.490242F, 1.329779F, 14.966615F, 2.237291F, 15.029941F, 3.207448F);
      localPath.lineTo(15.029941F, 3.207448F);
      localPath.lineTo(15.035F, 3.333752F);
      localPath.lineTo(15.907692F, 3.334036F);
      localPath.cubicTo(16.583849F, 3.334036F, 17.138721F, 3.85332F, 17.195257F, 4.514838F);
      localPath.lineTo(17.195257F, 4.514838F);
      localPath.lineTo(17.200001F, 4.626343F);
      localPath.lineTo(17.200001F, 8.382775F);
      localPath.lineTo(16.299999F, 8.382252F);
      localPath.lineTo(16.299999F, 15.465386F);
      localPath.cubicTo(16.299999F, 16.519302F, 15.478493F, 17.381346F, 14.440895F, 17.446098F);
      localPath.lineTo(14.440895F, 17.446098F);
      localPath.lineTo(14.315385F, 17.450003F);
      localPath.lineTo(2.884615F, 17.450003F);
      localPath.cubicTo(1.788543F, 17.450003F, 0.9F, 16.561459F, 0.9F, 15.465386F);
      localPath.lineTo(0.9F, 15.465386F);
      localPath.lineTo(0.9F, 8.382252F);
      localPath.lineTo(0.0F, 8.382775F);
      localPath.lineTo(0.0F, 4.626343F);
      localPath.cubicTo(0.0F, 3.912622F, 0.5785859F, 3.334036F, 1.29224F, 3.334036F);
      localPath.lineTo(1.29224F, 3.334036F);
      localPath.lineTo(2.16125F, 3.333752F);
      localPath.cubicTo(2.188738F, 2.376258F, 2.620327F, 1.464546F, 3.38125F, 0.828231F);
      localPath.lineTo(3.38125F, 0.828231F);
      localPath.lineTo(3.518934F, 0.7188467F);
      localPath.cubicTo(4.165205F, 0.2311556F, 4.968633F, -0.02287997F, 5.784586F, 0.001620115F);
      localPath.cubicTo(6.758628F, 0.03075062F, 7.670919F, 0.447441F, 8.326952F, 1.171198F);
      localPath.lineTo(8.326952F, 1.171198F);
      localPath.lineTo(8.44906F, 1.314521F);
      localPath.lineTo(8.59925F, 1.501502F);
      localPath.lineTo(8.750658F, 1.314466F);
      localPath.cubicTo(9.359169F, 0.5580879F, 10.255918F, 0.09025167F, 11.231606F, 0.01175155F);
      localPath.lineTo(11.231606F, 0.01175155F);
      localPath.close();
      localPath.moveTo(15.1F, 8.38F);
      localPath.lineTo(2.1F, 8.38F);
      localPath.lineTo(2.1F, 15.465386F);
      localPath.cubicTo(2.1F, 15.862607F, 2.395176F, 16.190886F, 2.778148F, 16.24284F);
      localPath.lineTo(2.884615F, 16.250002F);
      localPath.lineTo(14.315385F, 16.250002F);
      localPath.cubicTo(14.748715F, 16.250002F, 15.1F, 15.898718F, 15.1F, 15.465386F);
      localPath.lineTo(15.1F, 15.465386F);
      localPath.lineTo(15.1F, 8.38F);
      localPath.close();
      localPath.moveTo(1.292308F, 4.534036F);
      localPath.cubicTo(1.241328F, 4.534036F, 1.2F, 4.575363F, 1.2F, 4.626343F);
      localPath.lineTo(1.2F, 4.626343F);
      localPath.lineTo(1.199F, 7.18F);
      localPath.lineTo(15.999F, 7.18F);
      localPath.lineTo(16.0F, 4.626343F);
      localPath.cubicTo(16.0F, 4.599154F, 15.988245F, 4.57471F, 15.969529F, 4.557817F);
      localPath.lineTo(15.936834F, 4.538742F);
      localPath.lineTo(15.907624F, 4.534036F);
      localPath.close();
      localPath.moveTo(5.748642F, 1.201082F);
      localPath.cubicTo(5.204862F, 1.184754F, 4.669292F, 1.354096F, 4.241708F, 1.67676F);
      localPath.cubicTo(3.697037F, 2.08768F, 3.386385F, 2.699501F, 3.360284F, 3.334443F);
      localPath.lineTo(8.533F, 3.334F);
      localPath.lineTo(7.525356F, 2.080323F);
      localPath.lineTo(7.426338F, 1.964029F);
      localPath.cubicTo(7.002163F, 1.496317F, 6.398323F, 1.220512F, 5.748642F, 1.201082F);
      localPath.close();
      localPath.moveTo(11.451366F, 1.201081F);
      localPath.lineTo(11.291344F, 1.211099F);
      localPath.cubicTo(10.65609F, 1.271817F, 10.078267F, 1.578633F, 9.685589F, 2.066732F);
      localPath.lineTo(9.685589F, 2.066732F);
      localPath.lineTo(8.665F, 3.334F);
      localPath.lineTo(13.837703F, 3.33446F);
      localPath.cubicTo(13.81321F, 2.751632F, 13.553189F, 2.194259F, 13.096588F, 1.790106F);
      localPath.lineTo(12.95791F, 1.676717F);
      localPath.cubicTo(12.530409F, 1.354115F, 11.994849F, 1.184755F, 11.451366F, 1.201081F);
      localPath.lineTo(11.451366F, 1.201081F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-436207616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 14.646447F, 0.7071068F, 0.7071068F, -3.874368F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 16.94264F);
      localPath.lineTo(9.878679F, 17.86396F);
      localPath.lineTo(10.8F, 15.74264F);
      localPath.lineTo(9.878679F, 13.621321F);
      localPath.lineTo(12.0F, 14.542641F);
      localPath.lineTo(14.121321F, 13.621321F);
      localPath.lineTo(13.2F, 15.74264F);
      localPath.lineTo(14.121321F, 17.86396F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 8.393398F, 0.7071068F, 0.7071068F, -13.091883F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(20.0F, 4.385787F);
      ((Path)localObject).lineTo(18.585787F, 5.0F);
      ((Path)localObject).lineTo(19.200001F, 3.585786F);
      ((Path)localObject).lineTo(18.585787F, 2.171573F);
      ((Path)localObject).lineTo(20.0F, 2.785786F);
      ((Path)localObject).lineTo(21.414213F, 2.171573F);
      ((Path)localObject).lineTo(20.799999F, 3.585786F);
      ((Path)localObject).lineTo(21.414213F, 5.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_fans_gift
 * JD-Core Version:    0.7.0.1
 */