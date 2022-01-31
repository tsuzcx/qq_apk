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

public final class sf
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-6710887);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(28.262707F, 1.384934F);
      ((Path)localObject2).cubicTo(30.334364F, 1.046262F, 33.471729F, 0.3290745F, 34.716717F, 2.550363F);
      ((Path)localObject2).cubicTo(35.872063F, 4.811494F, 36.240578F, 7.361494F, 36.88797F, 9.801922F);
      ((Path)localObject2).cubicTo(38.541313F, 10.479266F, 40.184692F, 11.176531F, 41.828075F, 11.873796F);
      ((Path)localObject2).cubicTo(43.929611F, 10.618719F, 45.951469F, 9.194305F, 48.242245F, 8.317743F);
      ((Path)localObject2).cubicTo(50.682415F, 7.381415F, 52.295918F, 10.021063F, 53.670383F, 11.574968F);
      ((Path)localObject2).cubicTo(54.367577F, 14.832193F, 51.479206F, 17.46188F, 50.144585F, 20.201138F);
      ((Path)localObject2).cubicTo(50.831814F, 21.84469F, 51.509087F, 23.498205F, 52.20628F, 25.15172F);
      ((Path)localObject2).cubicTo(55.483082F, 26.207581F, 61.608414F, 26.078087F, 60.951061F, 31.008749F);
      ((Path)localObject2).cubicTo(61.588493F, 35.929451F, 55.473122F, 35.789997F, 52.19632F, 36.85582F);
      ((Path)localObject2).cubicTo(51.529007F, 38.509335F, 50.841774F, 40.162849F, 50.144585F, 41.8064F);
      ((Path)localObject2).cubicTo(51.399529F, 43.938042F, 52.863632F, 45.989994F, 53.720184F, 48.320854F);
      ((Path)localObject2).cubicTo(54.516975F, 50.900734F, 51.718246F, 52.594093F, 49.965305F, 53.908936F);
      ((Path)localObject2).cubicTo(46.867779F, 53.799366F, 44.437565F, 51.548195F, 41.838036F, 50.133743F);
      ((Path)localObject2).cubicTo(40.174732F, 50.831009F, 38.511433F, 51.538235F, 36.838173F, 52.215576F);
      ((Path)localObject2).cubicTo(35.981621F, 55.034523F, 35.95174F, 58.421238F, 33.730686F, 60.602684F);
      ((Path)localObject2).cubicTo(31.659029F, 60.961277F, 28.531624F, 61.668503F, 27.276678F, 59.447216F);
      ((Path)localObject2).cubicTo(26.12133F, 57.196045F, 25.782694F, 54.646046F, 25.145262F, 52.215576F);
      ((Path)localObject2).cubicTo(23.472F, 51.538235F, 21.808699F, 50.831009F, 20.135437F, 50.133743F);
      ((Path)localObject2).cubicTo(18.053822F, 51.388821F, 16.022003F, 52.813232F, 13.73123F, 53.679836F);
      ((Path)localObject2).cubicTo(11.291057F, 54.616161F, 9.677555F, 51.956593F, 8.31305F, 50.402687F);
      ((Path)localObject2).cubicTo(7.615858F, 47.145462F, 10.524145F, 44.535698F, 11.838851F, 41.79644F);
      ((Path)localObject2).cubicTo(11.141658F, 40.152885F, 10.464386F, 38.509335F, 9.787113F, 36.85582F);
      ((Path)localObject2).cubicTo(6.958505F, 35.989216F, 3.582103F, 35.949371F, 1.380967F, 33.757969F);
      ((Path)localObject2).cubicTo(0.972612F, 31.516758F, 0.3052993F, 28.010509F, 3.034309F, 27.014416F);
      ((Path)localObject2).cubicTo(5.205565F, 26.127893F, 7.516259F, 25.709534F, 9.787113F, 25.15172F);
      ((Path)localObject2).cubicTo(10.454426F, 23.488245F, 11.141658F, 21.84469F, 11.838851F, 20.191175F);
      ((Path)localObject2).cubicTo(10.593864F, 18.069498F, 9.139721F, 16.037466F, 8.273211F, 13.716569F);
      ((Path)localObject2).cubicTo(7.42662F, 11.27614F, 10.046071F, 9.662469F, 11.609773F, 8.297821F);
      ((Path)localObject2).cubicTo(14.836777F, 7.700165F, 17.436308F, 10.529071F, 20.145397F, 11.873796F);
      ((Path)localObject2).cubicTo(21.78878F, 11.176531F, 23.442122F, 10.479266F, 25.095463F, 9.801922F);
      ((Path)localObject2).cubicTo(25.961973F, 6.963056F, 26.031693F, 3.576339F, 28.262707F, 1.384934F);
      ((Path)localObject2).lineTo(28.262707F, 1.384934F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(27.355852F, 18.576183F);
      ((Path)localObject2).cubicTo(20.938553F, 20.263443F, 16.716909F, 27.431799F, 18.35367F, 33.881321F);
      ((Path)localObject2).cubicTo(19.661081F, 40.330845F, 26.45763F, 44.973305F, 32.94479F, 43.825169F);
      ((Path)localObject2).cubicTo(39.811199F, 42.966564F, 45.040848F, 35.918015F, 43.823257F, 29.089108F);
      ((Path)localObject2).cubicTo(42.944996F, 21.561335F, 34.571571F, 16.180077F, 27.355852F, 18.576183F);
      ((Path)localObject2).lineTo(27.355852F, 18.576183F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sf
 * JD-Core Version:    0.7.0.1
 */