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

public class icons_outlined_play_control_2
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
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 22.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.0F, 2.0F);
      localPath.cubicTo(15.522847F, 2.0F, 20.0F, 6.477152F, 20.0F, 12.0F);
      localPath.cubicTo(20.0F, 17.522848F, 15.522847F, 22.0F, 10.0F, 22.0F);
      localPath.cubicTo(4.477152F, 22.0F, 0.0F, 17.522848F, 0.0F, 12.0F);
      localPath.cubicTo(0.0F, 6.477152F, 4.477152F, 2.0F, 10.0F, 2.0F);
      localPath.close();
      localPath.moveTo(10.0F, 3.2F);
      localPath.cubicTo(5.139894F, 3.2F, 1.2F, 7.139894F, 1.2F, 12.0F);
      localPath.cubicTo(1.2F, 16.860106F, 5.139894F, 20.799999F, 10.0F, 20.799999F);
      localPath.cubicTo(14.860106F, 20.799999F, 18.799999F, 16.860106F, 18.799999F, 12.0F);
      localPath.cubicTo(18.799999F, 7.139894F, 14.860106F, 3.2F, 10.0F, 3.2F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 7.5F, 0.0F, 1.0F, 7.805963F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.133743F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.2410104F, 0.4129185F);
      ((Path)localObject3).cubicTo(0.08499616F, 0.6079559F, 0.0F, 0.8502805F, 0.0F, 1.100041F);
      ((Path)localObject3).lineTo(0.0F, 7.019416F);
      ((Path)localObject3).cubicTo(0.0F, 7.626929F, 0.4924868F, 8.119415F, 1.1F, 8.119415F);
      ((Path)localObject3).cubicTo(1.349797F, 8.119415F, 1.592156F, 8.034394F, 1.787207F, 7.878337F);
      ((Path)localObject3).lineTo(5.194002F, 5.152625F);
      ((Path)localObject3).cubicTo(5.797745F, 4.669582F, 5.895591F, 3.788568F, 5.412548F, 3.184825F);
      ((Path)localObject3).cubicTo(5.34796F, 3.104098F, 5.274628F, 3.030773F, 5.193894F, 2.966193F);
      ((Path)localObject3).lineTo(1.787122F, 0.2410509F);
      ((Path)localObject3).cubicTo(1.346601F, -0.11133F, 0.7182744F, -0.07015223F, 0.3269224F, 0.3173649F);
      ((Path)localObject3).lineTo(0.2410104F, 0.4129185F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(1.2F, 6.810794F);
      ((Path)localObject3).lineTo(1.2F, 1.307794F);
      ((Path)localObject3).lineTo(4.444306F, 3.903272F);
      ((Path)localObject3).lineTo(4.475543F, 3.934505F);
      ((Path)localObject3).lineTo(4.507074F, 3.990236F);
      ((Path)localObject3).cubicTo(4.536067F, 4.068824F, 4.513321F, 4.160415F, 4.444322F, 4.21562F);
      ((Path)localObject3).lineTo(1.2F, 6.810794F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(4.628995F, 0.9370796F);
      ((Path)localObject2).lineTo(5.378583F, 0.0F);
      ((Path)localObject2).lineTo(9.253894F, 3.099936F);
      ((Path)localObject2).cubicTo(9.334628F, 3.164516F, 9.40796F, 3.23784F, 9.472549F, 3.318568F);
      ((Path)localObject2).cubicTo(9.925402F, 3.884577F, 9.867707F, 4.694281F, 9.361258F, 5.191299F);
      ((Path)localObject2).lineTo(9.254003F, 5.286368F);
      ((Path)localObject2).lineTo(5.378704F, 8.386921F);
      ((Path)localObject2).lineTo(4.628995F, 7.449915F);
      ((Path)localObject2).lineTo(8.504322F, 4.349362F);
      ((Path)localObject2).cubicTo(8.59057F, 4.280356F, 8.604549F, 4.154497F, 8.535543F, 4.068248F);
      ((Path)localObject2).lineTo(8.504307F, 4.037015F);
      ((Path)localObject2).lineTo(4.628995F, 0.9370796F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_play_control_2
 * JD-Core Version:    0.7.0.1
 */