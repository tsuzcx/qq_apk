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

public class icons_outlined_bellring_shake
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.003101F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.012224F, 2.237209F);
      ((Path)localObject).cubicTo(13.135202F, 2.237209F, 14.045557F, 3.146523F, 14.045557F, 4.268217F);
      ((Path)localObject).cubicTo(14.045557F, 4.383006F, 14.036023F, 4.495571F, 14.017704F, 4.605165F);
      ((Path)localObject).cubicTo(16.401466F, 5.433702F, 18.112225F, 7.697915F, 18.112225F, 10.36124F);
      ((Path)localObject).lineTo(18.112225F, 14.423256F);
      ((Path)localObject).cubicTo(18.112225F, 15.915345F, 18.660936F, 17.407434F, 19.758362F, 18.899523F);
      ((Path)localObject).cubicTo(19.886566F, 19.073835F, 19.955706F, 19.284481F, 19.955706F, 19.500774F);
      ((Path)localObject).cubicTo(19.955706F, 20.061638F, 19.500515F, 20.516308F, 18.939011F, 20.516308F);
      ((Path)localObject).lineTo(13.028891F, 20.516283F);
      ((Path)localObject).lineTo(13.028891F, 20.719379F);
      ((Path)localObject).cubicTo(13.028891F, 21.280228F, 12.573713F, 21.734884F, 12.012224F, 21.734884F);
      ((Path)localObject).cubicTo(11.450734F, 21.734884F, 10.995557F, 21.280228F, 10.995557F, 20.719379F);
      ((Path)localObject).lineTo(10.995557F, 20.516279F);
      ((Path)localObject).lineTo(5.085376F, 20.516279F);
      ((Path)localObject).cubicTo(4.868845F, 20.516279F, 4.65797F, 20.447224F, 4.483469F, 20.31917F);
      ((Path)localObject).cubicTo(4.043912F, 19.996614F, 3.939507F, 19.38763F, 4.238637F, 18.938772F);
      ((Path)localObject).lineTo(4.26605F, 18.899572F);
      ((Path)localObject).cubicTo(5.363499F, 17.407467F, 5.912224F, 15.915361F, 5.912224F, 14.423256F);
      ((Path)localObject).lineTo(5.912224F, 10.36124F);
      ((Path)localObject).cubicTo(5.912224F, 7.697915F, 7.622981F, 5.433702F, 10.006743F, 4.605165F);
      ((Path)localObject).cubicTo(9.988424F, 4.495571F, 9.97889F, 4.383006F, 9.97889F, 4.268217F);
      ((Path)localObject).cubicTo(9.97889F, 3.146523F, 10.889245F, 2.237209F, 12.012224F, 2.237209F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.715477F, 2.921375F);
      ((Path)localObject).cubicTo(19.268398F, 4.540612F, 20.859495F, 7.335749F, 20.895327F, 10.407534F);
      ((Path)localObject).lineTo(20.895945F, 10.596899F);
      ((Path)localObject).lineTo(19.295946F, 10.596899F);
      ((Path)localObject).lineTo(19.295946F, 10.513566F);
      ((Path)localObject).cubicTo(19.295946F, 7.98766F, 18.017244F, 5.681431F, 15.941929F, 4.326213F);
      ((Path)localObject).lineTo(15.858492F, 4.272514F);
      ((Path)localObject).lineTo(16.715477F, 2.921375F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.081277F, 2.921375F);
      ((Path)localObject).lineTo(7.938262F, 4.272514F);
      ((Path)localObject).cubicTo(5.841785F, 5.602243F, 4.535494F, 7.892735F, 4.501481F, 10.412649F);
      ((Path)localObject).lineTo(4.5008F, 10.513566F);
      ((Path)localObject).lineTo(4.5008F, 10.596899F);
      ((Path)localObject).lineTo(2.9008F, 10.596899F);
      ((Path)localObject).lineTo(2.9008F, 10.513566F);
      ((Path)localObject).cubicTo(2.9008F, 7.400163F, 4.49901F, 4.559226F, 7.081277F, 2.921375F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_bellring_shake
 * JD-Core Version:    0.7.0.1
 */