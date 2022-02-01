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

public class icons_filled_detail_skin_hb_mask_dark
  extends c
{
  private final int height = 444;
  private final int width = 1201;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 1201;
      return 444;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -96.0F, 0.0F, 1.0F, -605.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 96.0F, 0.0F, 1.0F, 605.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-14474461);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.00992795F, 275.60001F);
      ((Path)localObject2).cubicTo(0.00992795F, 289.88358F, 10.258303F, 306.87317F, 22.900314F, 313.53232F);
      ((Path)localObject2).cubicTo(22.900314F, 313.53232F, 52.041653F, 329.41473F, 80.792648F, 341.91141F);
      ((Path)localObject2).cubicTo(220.63646F, 402.69476F, 401.92905F, 439.37936F, 600.00995F, 439.37936F);
      ((Path)localObject2).cubicTo(798.34583F, 439.37936F, 979.85022F, 402.60025F, 1119.7672F, 341.67651F);
      ((Path)localObject2).cubicTo(1148.3163F, 329.24542F, 1177.1123F, 313.54172F, 1177.1123F, 313.54172F);
      ((Path)localObject2).cubicTo(1189.7782F, 306.91049F, 1200.0099F, 289.89032F, 1200.0099F, 275.60001F);
      ((Path)localObject2).lineTo(1200.0099F, 444.0F);
      ((Path)localObject2).lineTo(0.00992795F, 444.0F);
      ((Path)localObject2).lineTo(0.00992795F, 275.60001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-995729);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 275.60001F);
      ((Path)localObject1).cubicTo(0.0F, 288.51648F, 10.567902F, 304.75446F, 22.845072F, 311.67966F);
      ((Path)localObject1).lineTo(27.106369F, 313.97479F);
      ((Path)localObject1).lineTo(32.187141F, 316.65604F);
      ((Path)localObject1).cubicTo(33.539501F, 317.36371F, 34.951221F, 318.0979F, 36.417206F, 318.85532F);
      ((Path)localObject1).cubicTo(46.190487F, 323.90469F, 56.370468F, 328.95404F, 66.438721F, 333.6655F);
      ((Path)localObject1).cubicTo(70.245506F, 335.4469F, 73.969429F, 337.14795F, 77.594154F, 338.758F);
      ((Path)localObject1).lineTo(81.43045F, 340.44403F);
      ((Path)localObject1).cubicTo(225.10699F, 402.89328F, 407.27304F, 437.77939F, 600.00995F, 437.77939F);
      ((Path)localObject1).cubicTo(791.06323F, 437.77939F, 971.72656F, 403.49966F, 1114.8042F, 342.07907F);
      ((Path)localObject1).lineTo(1119.8541F, 339.89285F);
      ((Path)localObject1).cubicTo(1124.3289F, 337.9361F, 1128.9657F, 335.83185F, 1133.7327F, 333.60117F);
      ((Path)localObject1).cubicTo(1143.7661F, 328.90585F, 1153.9089F, 323.87387F, 1163.6449F, 318.8418F);
      ((Path)localObject1).lineTo(1167.8586F, 316.65009F);
      ((Path)localObject1).lineTo(1176.3701F, 312.12424F);
      ((Path)localObject1).cubicTo(1188.6996F, 305.66922F, 1199.5293F, 289.5502F, 1199.9944F, 276.46753F);
      ((Path)localObject1).lineTo(1200.0099F, 275.60001F);
      ((Path)localObject1).cubicTo(1200.0099F, 282.0F, 1200.0099F, 286.75137F, 1200.0099F, 289.85416F);
      ((Path)localObject1).cubicTo(1200.0099F, 289.87979F, 1199.978F, 292.52603F, 1199.9672F, 292.55164F);
      ((Path)localObject1).cubicTo(1195.6947F, 302.57938F, 1187.6565F, 312.10999F, 1178.7155F, 317.10852F);
      ((Path)localObject1).lineTo(1174.4143F, 319.42285F);
      ((Path)localObject1).cubicTo(1172.0438F, 320.68573F, 1169.4094F, 322.07208F, 1166.5516F, 323.55548F);
      ((Path)localObject1).lineTo(1165.1042F, 324.30518F);
      ((Path)localObject1).cubicTo(1155.3334F, 329.35526F, 1145.1541F, 334.4054F, 1135.079F, 339.12012F);
      ((Path)localObject1).cubicTo(1131.2466F, 340.91354F, 1127.4967F, 342.62607F, 1123.8458F, 344.24701F);
      ((Path)localObject1).lineTo(1120.396F, 345.7641F);
      ((Path)localObject1).cubicTo(976.22284F, 408.54111F, 793.40686F, 443.60001F, 600.0F, 443.60001F);
      ((Path)localObject1).cubicTo(408.77161F, 443.60001F, 227.89391F, 409.32687F, 84.479324F, 347.87006F);
      ((Path)localObject1).lineTo(79.001122F, 345.50058F);
      ((Path)localObject1).cubicTo(74.507774F, 343.53442F, 69.854431F, 341.42221F, 65.072502F, 339.18448F);
      ((Path)localObject1).cubicTo(56.647827F, 335.24213F, 48.148964F, 331.06604F, 39.8741F, 326.85104F);
      ((Path)localObject1).lineTo(34.938446F, 324.31891F);
      ((Path)localObject1).cubicTo(32.486439F, 323.05206F, 30.185429F, 321.84979F, 28.058937F, 320.72742F);
      ((Path)localObject1).lineTo(22.144714F, 317.56854F);
      ((Path)localObject1).cubicTo(12.846583F, 312.67081F, 4.403824F, 303.53986F, 0.0F, 293.20001F);
      ((Path)localObject1).cubicTo(0.0F, 293.17496F, 0.0F, 292.45557F, 0.0F, 292.43054F);
      ((Path)localObject1).cubicTo(0.0F, 288.29059F, 0.0F, 282.68042F, 0.0F, 275.60001F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_detail_skin_hb_mask_dark
 * JD-Core Version:    0.7.0.1
 */