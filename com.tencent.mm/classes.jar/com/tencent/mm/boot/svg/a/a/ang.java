package com.tencent.mm.boot.svg.a.a;

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

public final class ang
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2236963);
      localCanvas.saveLayerAlpha(null, 222, 4);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(13.408646F, 1.689919F);
      localPath.cubicTo(22.319056F, -1.129904F, 32.566528F, 5.027872F, 34.522228F, 14.085183F);
      localPath.cubicTo(36.098763F, 19.346195F, 33.484509F, 24.517532F, 30.890213F, 28.951529F);
      localPath.cubicTo(27.13846F, 35.01963F, 22.788025F, 40.719059F, 17.988577F, 46.0F);
      localPath.cubicTo(11.84209F, 39.005245F, 5.845274F, 31.601963F, 2.093522F, 23.012962F);
      localPath.cubicTo(-1.618318F, 14.404033F, 4.607994F, 3.931828F, 13.408646F, 1.689919F);
      localPath.lineTo(13.408646F, 1.689919F);
      localPath.close();
      localPath.moveTo(3.269147F, 20.083824F);
      localPath.cubicTo(6.01926F, 28.886927F, 12.355597F, 35.913349F, 18.006926F, 43.0F);
      localPath.cubicTo(23.275455F, 36.495541F, 28.846195F, 29.981043F, 32.079842F, 22.171675F);
      localPath.cubicTo(35.424301F, 14.271968F, 29.178625F, 4.796334F, 20.978659F, 3.381012F);
      localPath.cubicTo(11.398599F, 0.971953F, 1.204045F, 10.397397F, 3.269147F, 20.083824F);
      localPath.lineTo(3.269147F, 20.083824F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1907998);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 238, 4);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(7.295099F, 0.192574F);
      ((Path)localObject2).cubicTo(12.620774F, -1.008582F, 18.165449F, 3.587575F, 17.996222F, 9.017592F);
      ((Path)localObject2).cubicTo(18.175404F, 14.745417F, 11.923957F, 19.470623F, 6.448964F, 17.574585F);
      ((Path)localObject2).cubicTo(1.84997F, 16.333721F, -1.096571F, 11.032754F, 0.3866538F, 6.496159F);
      ((Path)localObject2).cubicTo(1.272607F, 3.309622F, 4.059876F, 0.8378228F, 7.295099F, 0.192574F);
      ((Path)localObject2).lineTo(7.295099F, 0.192574F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.408528F, 2.555081F);
      ((Path)localObject2).cubicTo(1.616241F, 4.349109F, 0.3174904F, 11.2947F, 4.586251F, 14.351562F);
      ((Path)localObject2).cubicTo(8.462366F, 18.069908F, 15.227949F, 15.013046F, 15.912561F, 10.001798F);
      ((Path)localObject2).cubicTo(16.778395F, 5.100796F, 11.039731F, 0.3501319F, 6.408528F, 2.555081F);
      ((Path)localObject2).lineTo(6.408528F, 2.555081F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ang
 * JD-Core Version:    0.7.0.1
 */