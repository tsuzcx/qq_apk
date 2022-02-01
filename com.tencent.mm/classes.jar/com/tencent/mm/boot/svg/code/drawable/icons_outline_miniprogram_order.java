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

public class icons_outline_miniprogram_order
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(14211288);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-16268960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(18.766918F, 1.714286F);
      localPath.cubicTo(19.816103F, 1.714286F, 20.509159F, 2.347504F, 20.567442F, 3.362372F);
      localPath.lineTo(20.571428F, 3.503106F);
      localPath.lineTo(20.570572F, 8.123285F);
      localPath.lineTo(19.370571F, 9.323286F);
      localPath.lineTo(19.371429F, 3.503106F);
      localPath.cubicTo(19.371429F, 3.108739F, 19.23201F, 2.940718F, 18.863791F, 2.917202F);
      localPath.lineTo(18.766918F, 2.914286F);
      localPath.lineTo(5.233083F, 2.914286F);
      localPath.cubicTo(4.82611F, 2.914286F, 4.655385F, 3.051972F, 4.631528F, 3.409182F);
      localPath.lineTo(4.628572F, 3.503106F);
      localPath.lineTo(4.628572F, 20.496895F);
      localPath.cubicTo(4.628572F, 20.89126F, 4.767991F, 21.059282F, 5.13621F, 21.082798F);
      localPath.lineTo(5.233083F, 21.085714F);
      localPath.lineTo(18.766918F, 21.085714F);
      localPath.cubicTo(19.173889F, 21.085714F, 19.344616F, 20.948029F, 19.368473F, 20.590818F);
      localPath.lineTo(19.371429F, 20.496895F);
      localPath.lineTo(19.370571F, 15.385285F);
      localPath.lineTo(20.570572F, 14.185286F);
      localPath.lineTo(20.571428F, 20.496895F);
      localPath.cubicTo(20.571428F, 21.545938F, 19.92399F, 22.224768F, 18.907755F, 22.281813F);
      localPath.lineTo(18.766918F, 22.285715F);
      localPath.lineTo(5.233083F, 22.285715F);
      localPath.cubicTo(4.183897F, 22.285715F, 3.490841F, 21.652496F, 3.432558F, 20.637627F);
      localPath.lineTo(3.428572F, 20.496895F);
      localPath.lineTo(3.428572F, 3.503106F);
      localPath.cubicTo(3.428572F, 2.454061F, 4.076011F, 1.775233F, 5.092246F, 1.718187F);
      localPath.lineTo(5.233083F, 1.714286F);
      localPath.lineTo(18.766918F, 1.714286F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-16268960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.857143F, 6.0F);
      localPath.lineTo(17.142857F, 6.0F);
      localPath.lineTo(17.142857F, 7.2F);
      localPath.lineTo(6.857143F, 7.2F);
      localPath.lineTo(6.857143F, 6.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-16268960);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.857143F, 10.285714F);
      localPath.lineTo(15.428572F, 10.285714F);
      localPath.lineTo(15.428572F, 11.485714F);
      localPath.lineTo(6.857143F, 11.485714F);
      localPath.lineTo(6.857143F, 10.285714F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint3.setColor(16777215);
      localPaint2.setColor(-16268960);
      localPaint2.setStrokeWidth(1.2F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, 0.7071068F, -4.026967F, -0.7071068F, 0.7071068F, 15.159552F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.428572F, 14.583611F);
      localPath.lineTo(11.142858F, 14.583611F);
      localPath.lineTo(11.142858F, 10.297897F);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16268960);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, 0.7071068F, -4.287155F, -0.7071068F, 0.7071068F, 15.30283F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.085714F, 10.383612F);
      ((Path)localObject).lineTo(12.085714F, 14.069142F);
      ((Path)localObject).lineTo(21.771429F, 14.069325F);
      ((Path)localObject).lineTo(21.771429F, 15.269326F);
      ((Path)localObject).lineTo(10.885715F, 15.269326F);
      ((Path)localObject).lineTo(10.885715F, 10.383612F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outline_miniprogram_order
 * JD-Core Version:    0.7.0.1
 */