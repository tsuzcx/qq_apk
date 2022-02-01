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

public class mp_logo
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
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.288736F, 3.825859F);
      ((Path)localObject2).cubicTo(15.286312F, 1.764647F, 12.750555F, 0.0004042769F, 9.879645F, -7.177199E-016F);
      ((Path)localObject2).cubicTo(8.373181F, -0.0004038039F, 6.071767F, 0.5167679F, 4.351969F, 2.596364F);
      ((Path)localObject2).cubicTo(3.203484F, 3.985051F, 2.816817F, 5.610303F, 3.058838F, 7.231112F);
      ((Path)localObject2).cubicTo(3.2251F, 8.344647F, 3.845302F, 9.813738F, 4.732777F, 10.743031F);
      ((Path)localObject2).cubicTo(5.067322F, 8.387273F, 6.308131F, 6.534546F, 7.934999F, 5.172728F);
      ((Path)localObject2).cubicTo(10.872373F, 2.928687F, 14.008332F, 3.055758F, 16.288736F, 3.825859F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(18.580696F, 7.360021F);
      ((Path)localObject2).cubicTo(16.783524F, 5.027697F, 13.676858F, 4.375172F, 10.872414F, 5.415172F);
      ((Path)localObject2).cubicTo(10.962918F, 5.442445F, 11.053222F, 5.469313F, 11.143323F, 5.499818F);
      ((Path)localObject2).cubicTo(15.295444F, 6.914364F, 17.539484F, 11.418808F, 16.155645F, 15.560626F);
      ((Path)localObject2).cubicTo(15.787363F, 16.662445F, 15.197868F, 17.626081F, 14.455241F, 18.422647F);
      ((Path)localObject2).cubicTo(15.349787F, 18.174971F, 16.265343F, 17.820829F, 17.050797F, 17.215576F);
      ((Path)localObject2).cubicTo(20.21302F, 14.779011F, 20.835443F, 10.286081F, 18.580696F, 7.360021F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(9.871726F, 14.810808F);
      ((Path)localObject1).cubicTo(9.240817F, 14.810808F, 8.629706F, 14.738283F, 8.041827F, 14.60697F);
      ((Path)localObject1).cubicTo(7.97011F, 14.592222F, 7.896171F, 14.583535F, 7.819403F, 14.58697F);
      ((Path)localObject1).cubicTo(7.645262F, 14.594444F, 7.489101F, 14.654647F, 7.343242F, 14.748182F);
      ((Path)localObject1).lineTo(5.404252F, 15.991213F);
      ((Path)localObject1).cubicTo(5.349908F, 16.025759F, 5.297383F, 16.052828F, 5.231525F, 16.055656F);
      ((Path)localObject1).cubicTo(5.06405F, 16.062929F, 4.922636F, 15.931818F, 4.915363F, 15.763738F);
      ((Path)localObject1).cubicTo(4.91213F, 15.687778F, 4.938999F, 15.611213F, 4.954757F, 15.538283F);
      ((Path)localObject1).cubicTo(4.964252F, 15.494647F, 5.169706F, 14.562728F, 5.297787F, 13.981314F);
      ((Path)localObject1).cubicTo(5.312737F, 13.915859F, 5.324454F, 13.852828F, 5.321626F, 13.785556F);
      ((Path)localObject1).cubicTo(5.312939F, 13.583334F, 5.206676F, 13.408587F, 5.051323F, 13.30394F);
      ((Path)localObject1).cubicTo(3.007888F, 11.910404F, 1.606272F, 9.720707F, 1.297989F, 7.469394F);
      ((Path)localObject1).cubicTo(0.7840498F, 8.277273F, 0.5103124F, 8.919293F, 0.2424336F, 9.855253F);
      ((Path)localObject1).cubicTo(-0.7565563F, 13.347576F, 1.429908F, 17.531414F, 4.997989F, 18.703333F);
      ((Path)localObject1).cubicTo(9.101423F, 20.05101F, 13.016979F, 18.538282F, 14.369504F, 15.048384F);
      ((Path)localObject1).cubicTo(14.533949F, 14.624546F, 14.713747F, 13.904748F, 14.750918F, 13.306767F);
      ((Path)localObject1).cubicTo(13.313949F, 14.363939F, 11.792535F, 14.810808F, 9.871726F, 14.810808F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.mp_logo
 * JD-Core Version:    0.7.0.1
 */