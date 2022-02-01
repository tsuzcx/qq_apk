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

public class icons_outlined_cheer
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject4 = c.setMatrixFloatArray((float[])localObject3, 0.7071068F, -0.7071068F, 7.253748F, 0.7071068F, 0.7071068F, -3.784297F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      ((Paint)localObject3).setStrokeWidth(0.7341176F);
      localObject4 = c.setMatrixFloatArray((float[])localObject4, 0.7071068F, 0.7071068F, -4.400744F, -0.7071068F, 0.7071068F, 8.947852F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(7.369032F, 5.834457F);
      localPath.lineTo(4.88748F, 13.93667F);
      localPath.lineTo(12.794427F, 10.902675F);
      localPath.lineTo(7.369032F, 5.834457F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.setMatrixFloatArray((float[])localObject4, 1.0F, 0.0F, 2.752941F, 0.0F, 1.0F, 0.323439F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject4 = c.setMatrixFloatArray((float[])localObject4, 0.7071068F, 0.7071068F, -1.157987F, -0.7071068F, 0.7071068F, 6.555245F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(8.604762F, 3.858901F);
      localPath.cubicTo(8.805445F, 3.861339F, 8.966135F, 4.02446F, 8.963703F, 4.223244F);
      localPath.cubicTo(8.961214F, 4.422028F, 8.796534F, 4.581198F, 8.595851F, 4.578761F);
      localPath.cubicTo(8.339446F, 4.575647F, 8.071219F, 4.62559F, 7.579461F, 4.765437F);
      localPath.cubicTo(7.457471F, 4.800129F, 7.32749F, 4.847958F, 7.191859F, 4.907212F);
      localPath.cubicTo(6.975717F, 5.001639F, 6.756896F, 5.1196F, 6.548174F, 5.248118F);
      localPath.lineTo(6.414381F, 5.332781F);
      localPath.lineTo(6.281758F, 5.422916F);
      localPath.cubicTo(6.119658F, 5.540131F, 5.89232F, 5.504989F, 5.773985F, 5.344423F);
      localPath.cubicTo(5.655649F, 5.183857F, 5.691127F, 4.958671F, 5.853227F, 4.841455F);
      localPath.lineTo(5.948977F, 4.774993F);
      localPath.lineTo(6.164475F, 4.636707F);
      localPath.cubicTo(6.400138F, 4.491599F, 6.647976F, 4.357997F, 6.898567F, 4.248519F);
      localPath.cubicTo(7.06274F, 4.176796F, 7.223156F, 4.117768F, 7.378902F, 4.073477F);
      localPath.cubicTo(7.9328F, 3.915958F, 8.264669F, 3.854771F, 8.604762F, 3.858901F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject4 = c.setMatrixFloatArray((float[])localObject4, 0.601815F, 0.7986355F, -0.708663F, -0.7986355F, 0.601815F, 9.569044F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.062869F, 5.476501F);
      localPath.cubicTo(10.062869F, 5.653211F, 9.934318F, 5.80018F, 9.764794F, 5.830658F);
      localPath.lineTo(9.699473F, 5.836458F);
      localPath.lineTo(8.7844F, 5.873859F);
      localPath.lineTo(8.719079F, 5.86806F);
      localPath.cubicTo(8.549555F, 5.837581F, 8.421003F, 5.690612F, 8.421003F, 5.513902F);
      localPath.cubicTo(8.421003F, 5.337192F, 8.549555F, 5.190223F, 8.719079F, 5.159745F);
      localPath.lineTo(8.7844F, 5.153945F);
      localPath.lineTo(9.699473F, 5.116544F);
      localPath.lineTo(9.764794F, 5.122344F);
      localPath.cubicTo(9.934318F, 5.152822F, 10.062869F, 5.299791F, 10.062869F, 5.476501F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStrokeWidth(0.7341176F);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, 0.7071068F, 0.7071068F, -1.545103F, -0.7071068F, 0.7071068F, 3.680817F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(4.656153F, 1.927655F);
      ((Path)localObject4).lineTo(3.391805F, 2.72805F);
      ((Path)localObject4).lineTo(1.89316F, 2.719825F);
      ((Path)localObject4).lineTo(2.694511F, 3.983898F);
      ((Path)localObject4).lineTo(2.685329F, 5.482968F);
      ((Path)localObject4).lineTo(3.951746F, 4.680795F);
      ((Path)localObject4).lineTo(5.448243F, 4.690522F);
      ((Path)localObject4).lineTo(4.647654F, 3.425344F);
      ((Path)localObject4).lineTo(4.656153F, 1.927655F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject3, 0.7071068F, 0.7071068F, 1.096594F, -0.7071068F, 0.7071068F, 6.875391F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(9.746595F, 1.6204F);
      ((Path)localObject1).lineTo(9.341775F, 2.253825F);
      ((Path)localObject1).lineTo(9.345934F, 3.004451F);
      ((Path)localObject1).lineTo(8.706596F, 2.602982F);
      ((Path)localObject1).lineTo(7.94866F, 2.60758F);
      ((Path)localObject1).lineTo(8.354242F, 1.973334F);
      ((Path)localObject1).lineTo(8.349322F, 1.22353F);
      ((Path)localObject1).lineTo(8.989283F, 1.624657F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_cheer
 * JD-Core Version:    0.7.0.1
 */