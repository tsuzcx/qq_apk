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

public class finder_live_view_setting_icon
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
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.857143F, 0.0F, 1.0F, 2.142857F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 1.224647E-016F, 12.857142F, -1.224647E-016F, -1.0F, 9.142858F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 3.428572F);
      localPath.lineTo(12.857142F, 3.428572F);
      localPath.lineTo(12.857142F, 5.714286F);
      localPath.lineTo(0.0F, 5.714286F);
      localPath.lineTo(0.0F, 3.428572F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 1.224647E-016F, 39.428574F, -1.224647E-016F, -1.0F, 9.142858F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(17.428572F, 3.428572F);
      localPath.lineTo(22.0F, 3.428572F);
      localPath.lineTo(22.0F, 5.714286F);
      localPath.lineTo(17.428572F, 5.714286F);
      localPath.lineTo(17.428572F, 3.428572F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 1.224647E-016F, 30.285713F, -1.224647E-016F, -1.0F, 9.142858F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.142858F, 5.19965E-013F);
      localPath.cubicTo(17.667587F, 5.19965E-013F, 19.714285F, 2.046698F, 19.714285F, 4.571429F);
      localPath.cubicTo(19.714285F, 7.096159F, 17.667587F, 9.142858F, 15.142858F, 9.142858F);
      localPath.cubicTo(12.618127F, 9.142858F, 10.571428F, 7.096159F, 10.571428F, 4.571429F);
      localPath.cubicTo(10.571428F, 2.046698F, 12.618127F, 5.19965E-013F, 15.142858F, 5.19965E-013F);
      localPath.close();
      localPath.moveTo(15.142858F, 2.285714F);
      localPath.cubicTo(13.880492F, 2.285714F, 12.857142F, 3.309063F, 12.857142F, 4.571429F);
      localPath.cubicTo(12.857142F, 5.833794F, 13.880492F, 6.857143F, 15.142858F, 6.857143F);
      localPath.cubicTo(16.405222F, 6.857143F, 17.428572F, 5.833794F, 17.428572F, 4.571429F);
      localPath.cubicTo(17.428572F, 3.309063F, 16.405222F, 2.285714F, 15.142858F, 2.285714F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 0.857143F, 0.0F, 1.0F, 14.830357F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(9.142858F, 2.401786F);
      ((Path)localObject2).lineTo(22.0F, 2.401786F);
      ((Path)localObject2).lineTo(22.0F, 4.6875F);
      ((Path)localObject2).lineTo(9.142858F, 4.6875F);
      ((Path)localObject2).lineTo(9.142858F, 2.401786F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 2.401786F);
      ((Path)localObject2).lineTo(4.571429F, 2.401786F);
      ((Path)localObject2).lineTo(4.571429F, 4.6875F);
      ((Path)localObject2).lineTo(0.0F, 4.6875F);
      ((Path)localObject2).lineTo(0.0F, 2.401786F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(6.857143F, 0.0F);
      ((Path)localObject1).cubicTo(8.750691F, 0.0F, 10.285714F, 1.535024F, 10.285714F, 3.428572F);
      ((Path)localObject1).cubicTo(10.285714F, 5.322119F, 8.750691F, 6.857143F, 6.857143F, 6.857143F);
      ((Path)localObject1).cubicTo(4.963595F, 6.857143F, 3.428572F, 5.322119F, 3.428572F, 3.428572F);
      ((Path)localObject1).cubicTo(3.428572F, 1.535024F, 4.963595F, 0.0F, 6.857143F, 0.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(6.854286F, 1.885714F);
      ((Path)localObject1).cubicTo(6.002189F, 1.885714F, 5.311429F, 2.576475F, 5.311429F, 3.428572F);
      ((Path)localObject1).cubicTo(5.311429F, 4.280668F, 6.002189F, 4.971428F, 6.854286F, 4.971428F);
      ((Path)localObject1).cubicTo(7.706382F, 4.971428F, 8.397142F, 4.280668F, 8.397142F, 3.428572F);
      ((Path)localObject1).cubicTo(8.397142F, 2.576475F, 7.706382F, 1.885714F, 6.854286F, 1.885714F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_view_setting_icon
 * JD-Core Version:    0.7.0.1
 */