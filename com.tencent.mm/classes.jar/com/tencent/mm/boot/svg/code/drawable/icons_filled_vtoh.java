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

public class icons_filled_vtoh
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
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 6.123234E-017F, 1.0F, 0.0F, -1.0F, 6.123234E-017F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject4 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.44F, 0.0F, 1.0F, -0.76F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      float[] arrayOfFloat = c.setMatrixFloatArray((float[])localObject4, -1.83697E-016F, -1.0F, 18.360001F, -1.0F, 1.83697E-016F, 10.840001F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.instancePaint(localPaint1, paramVarArgs);
      Paint localPaint2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject4).setColor(-1);
      localPaint2.setStrokeWidth(0.675F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.83697E-016F, -1.0F, 4.547654F, 1.0F, -1.83697E-016F, 0.5786539F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(1.9845F, 4.001308F);
      localPath.lineTo(3.969F, 1.125F);
      localPath.lineTo(-1.326717E-012F, 1.125F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setStrokeWidth(1.575F);
      localObject4 = c.setMatrixFloatArray(arrayOfFloat, 0.9702957F, 0.241922F, -1.166898F, -0.241922F, 0.9702957F, 1.569005F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(8.319938F, 9.343043F);
      ((Path)localObject1).cubicTo(8.436546F, 8.87535F, 8.483838F, 8.411162F, 8.483838F, 7.922247F);
      ((Path)localObject1).cubicTo(8.483838F, 5.017462F, 6.482186F, 2.580188F, 3.782953F, 1.914495F);
      ((Path)localObject1).cubicTo(3.30674F, 1.797049F, 3.138718F, 1.698133F, 3.127783F, 1.738942F);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(1.575F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.35F, 7.604431F);
      ((Path)localObject2).cubicTo(1.35F, 6.98311F, 1.85368F, 6.479431F, 2.475F, 6.479431F);
      ((Path)localObject2).lineTo(9.450001F, 6.479431F);
      ((Path)localObject2).cubicTo(10.071321F, 6.479431F, 10.575001F, 6.98311F, 10.575001F, 7.604431F);
      ((Path)localObject2).lineTo(10.575001F, 20.33943F);
      ((Path)localObject2).cubicTo(10.575001F, 20.960751F, 10.071321F, 21.46443F, 9.450001F, 21.46443F);
      ((Path)localObject2).lineTo(2.475F, 21.46443F);
      ((Path)localObject2).cubicTo(1.85368F, 21.46443F, 1.35F, 20.960751F, 1.35F, 20.33943F);
      ((Path)localObject2).lineTo(1.35F, 7.604431F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(5.9625F, 17.436001F);
      ((Path)localObject1).cubicTo(6.514785F, 17.436001F, 6.9625F, 17.883717F, 6.9625F, 18.436001F);
      ((Path)localObject1).cubicTo(6.9625F, 18.988285F, 6.514785F, 19.436001F, 5.9625F, 19.436001F);
      ((Path)localObject1).cubicTo(5.410215F, 19.436001F, 4.9625F, 18.988285F, 4.9625F, 18.436001F);
      ((Path)localObject1).cubicTo(4.9625F, 17.883717F, 5.410215F, 17.436001F, 5.9625F, 17.436001F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_vtoh
 * JD-Core Version:    0.7.0.1
 */