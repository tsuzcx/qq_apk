package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class bakmove_step2
  extends c
{
  private final int height = 54;
  private final int width = 54;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 54;
      return 54;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      c.instancePaint((Paint)localObject1, paramVarArgs).setStrokeWidth(1.0F);
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localCanvas.save();
      Object localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(26.0F, 0.0F);
      localPath.cubicTo(12.533542F, 0.5350773F, 0.8213729F, 11.880697F, 0.0F, 25.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(29.0F, 0.0F);
      localPath.lineTo(54.0F, 0.0F);
      localPath.lineTo(54.0F, 26.0F);
      localPath.cubicTo(53.438755F, 12.482031F, 42.085861F, 0.7210938F, 29.0F, 0.0F);
      localPath.lineTo(29.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.470905F, 3.711024F);
      localPath.cubicTo(33.007473F, 0.630928F, 45.994865F, 7.881154F, 49.63694F, 19.211506F);
      localPath.cubicTo(52.538589F, 26.971746F, 50.667526F, 36.102032F, 45.3545F, 42.382225F);
      localPath.cubicTo(40.441704F, 48.312412F, 32.527199F, 51.622513F, 24.852831F, 50.902493F);
      localPath.cubicTo(18.869425F, 50.292473F, 13.106144F, 47.452385F, 9.113872F, 42.922241F);
      localPath.cubicTo(3.650762F, 36.822052F, 1.479526F, 27.781773F, 4.121029F, 19.961529F);
      localPath.cubicTo(6.492379F, 11.971281F, 13.366292F, 5.591082F, 21.470905F, 3.711024F);
      localPath.lineTo(21.470905F, 3.711024F);
      localPath.close();
      localPath.moveTo(19.537832F, 16.591116F);
      localPath.cubicTo(18.1471F, 18.38323F, 18.035437F, 20.670403F, 17.781652F, 22.809057F);
      localPath.cubicTo(18.918602F, 22.828859F, 20.065702F, 22.848661F, 21.20265F, 22.858562F);
      localPath.cubicTo(21.334618F, 19.967419F, 22.654291F, 16.353489F, 26.095592F, 16.046553F);
      localPath.cubicTo(30.470816F, 15.016829F, 33.912117F, 20.007023F, 31.820944F, 23.729868F);
      localPath.cubicTo(29.039478F, 28.630951F, 22.491871F, 29.720081F, 19.334806F, 34.324131F);
      localPath.cubicTo(17.852713F, 36.264759F, 17.466961F, 38.680649F, 17.0F, 40.997524F);
      localPath.cubicTo(23.273523F, 40.997524F, 29.536894F, 41.007427F, 35.810417F, 40.987625F);
      localPath.lineTo(35.810417F, 38.037071F);
      localPath.cubicTo(30.856567F, 37.997467F, 25.902718F, 38.076675F, 20.948868F, 37.987568F);
      localPath.cubicTo(23.303976F, 31.789427F, 31.455496F, 31.096346F, 34.734375F, 25.611092F);
      localPath.cubicTo(36.866154F, 22.195185F, 36.338287F, 17.115879F, 32.896984F, 14.69009F);
      localPath.cubicTo(28.877058F, 11.957365F, 22.41066F, 12.501929F, 19.537832F, 16.591116F);
      localPath.lineTo(19.537832F, 16.591116F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 28.0F);
      localPath.cubicTo(0.554895F, 41.466824F, 11.880697F, 53.177986F, 25.0F, 54.0F);
      localPath.lineTo(0.0F, 54.0F);
      localPath.lineTo(0.0F, 28.0F);
      localPath.lineTo(0.0F, 28.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(28.0F, 54.0F);
      ((Path)localObject2).cubicTo(41.516758F, 53.468296F, 53.280594F, 42.105553F, 54.0F, 29.0F);
      ((Path)localObject2).lineTo(54.0F, 54.0F);
      ((Path)localObject2).lineTo(28.0F, 54.0F);
      ((Path)localObject2).lineTo(28.0F, 54.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16139513);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.639999F, 0.0F);
      ((Path)localObject2).lineTo(28.610001F, 0.0F);
      ((Path)localObject2).cubicTo(41.900002F, 0.71F, 53.43F, 12.29F, 54.0F, 25.6F);
      ((Path)localObject2).lineTo(54.0F, 28.610001F);
      ((Path)localObject2).cubicTo(53.290001F, 41.919998F, 41.68F, 53.459999F, 28.34F, 54.0F);
      ((Path)localObject2).lineTo(25.23F, 54.0F);
      ((Path)localObject2).cubicTo(11.99F, 53.189999F, 0.56F, 41.650002F, 0.0F, 28.379999F);
      ((Path)localObject2).lineTo(0.0F, 25.23F);
      ((Path)localObject2).cubicTo(0.81F, 11.99F, 12.36F, 0.54F, 25.639999F, 0.0F);
      ((Path)localObject2).lineTo(25.639999F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.470905F, 3.711024F);
      ((Path)localObject2).cubicTo(13.366292F, 5.591082F, 6.492379F, 11.971281F, 4.121029F, 19.961529F);
      ((Path)localObject2).cubicTo(1.479526F, 27.781773F, 3.650762F, 36.822052F, 9.113872F, 42.922241F);
      ((Path)localObject2).cubicTo(13.106144F, 47.452385F, 18.869425F, 50.292473F, 24.852831F, 50.902493F);
      ((Path)localObject2).cubicTo(32.527199F, 51.622513F, 40.441704F, 48.312412F, 45.3545F, 42.382225F);
      ((Path)localObject2).cubicTo(50.667526F, 36.102032F, 52.538589F, 26.971746F, 49.63694F, 19.211506F);
      ((Path)localObject2).cubicTo(45.994865F, 7.881154F, 33.007473F, 0.630928F, 21.470905F, 3.711024F);
      ((Path)localObject2).lineTo(21.470905F, 3.711024F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(19.537832F, 16.591116F);
      ((Path)localObject1).cubicTo(22.41066F, 12.501929F, 28.877058F, 11.957365F, 32.896984F, 14.69009F);
      ((Path)localObject1).cubicTo(36.338287F, 17.115879F, 36.866154F, 22.195185F, 34.734375F, 25.611092F);
      ((Path)localObject1).cubicTo(31.455496F, 31.096346F, 23.303976F, 31.789427F, 20.948868F, 37.987568F);
      ((Path)localObject1).cubicTo(25.902718F, 38.076675F, 30.856567F, 37.997467F, 35.810417F, 38.037071F);
      ((Path)localObject1).lineTo(35.810417F, 40.987625F);
      ((Path)localObject1).cubicTo(29.536894F, 41.007427F, 23.273523F, 40.997524F, 17.0F, 40.997524F);
      ((Path)localObject1).cubicTo(17.466961F, 38.680649F, 17.852713F, 36.264759F, 19.334806F, 34.324131F);
      ((Path)localObject1).cubicTo(22.491871F, 29.720081F, 29.039478F, 28.630951F, 31.820944F, 23.729868F);
      ((Path)localObject1).cubicTo(33.912117F, 20.007023F, 30.470816F, 15.016829F, 26.095592F, 16.046553F);
      ((Path)localObject1).cubicTo(22.654291F, 16.353489F, 21.334618F, 19.967419F, 21.20265F, 22.858562F);
      ((Path)localObject1).cubicTo(20.065702F, 22.848661F, 18.918602F, 22.828859F, 17.781652F, 22.809057F);
      ((Path)localObject1).cubicTo(18.035437F, 20.670403F, 18.1471F, 18.38323F, 19.537832F, 16.591116F);
      ((Path)localObject1).lineTo(19.537832F, 16.591116F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bakmove_step2
 * JD-Core Version:    0.7.0.1
 */