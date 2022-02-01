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

public final class bii
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -57.0F, 0.0F, 1.0F, -426.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 57.0F, 0.0F, 1.0F, 426.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(421178649);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 22.0F);
      ((Path)localObject3).cubicTo(0.008455056F, 16.672909F, 0.0F, 11.917717F, 0.0F, 6.0F);
      ((Path)localObject3).cubicTo(5.954051F, 4.108869F, 12.507443F, 1.953838F, 22.0F, 0.0F);
      ((Path)localObject3).cubicTo(30.492556F, 1.953838F, 37.045948F, 4.108869F, 43.0F, 6.0F);
      ((Path)localObject3).cubicTo(43.0F, 11.917717F, 42.991547F, 16.672909F, 43.0F, 22.0F);
      ((Path)localObject3).cubicTo(42.991547F, 35.808678F, 30.947437F, 43.57803F, 21.0F, 46.0F);
      ((Path)localObject3).cubicTo(12.052562F, 43.57803F, 0.008455056F, 35.808678F, 0.0F, 22.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-15028967);
      ((Paint)localObject1).setStrokeWidth(3.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.500001F, 22.000731F);
      ((Path)localObject2).cubicTo(1.507587F, 32.991032F, 10.078676F, 41.353813F, 21.020136F, 44.449203F);
      ((Path)localObject2).cubicTo(32.694691F, 41.477242F, 41.493172F, 33.148949F, 41.5F, 22.00238F);
      ((Path)localObject2).cubicTo(41.497402F, 20.365496F, 41.496265F, 18.710062F, 41.496243F, 16.854805F);
      ((Path)localObject2).cubicTo(41.496227F, 15.422399F, 41.496639F, 14.398892F, 41.498123F, 11.593655F);
      ((Path)localObject2).cubicTo(41.499176F, 9.594675F, 41.499725F, 8.331651F, 41.499916F, 7.096765F);
      ((Path)localObject2).cubicTo(40.838436F, 6.886138F, 40.11861F, 6.656828F, 39.971489F, 6.610029F);
      ((Path)localObject2).cubicTo(38.935696F, 6.280545F, 38.116764F, 6.021614F, 37.309078F, 5.768857F);
      ((Path)localObject2).cubicTo(35.254959F, 5.126039F, 33.440895F, 4.576554F, 31.624861F, 4.051996F);
      ((Path)localObject2).cubicTo(28.394964F, 3.119049F, 25.252028F, 2.293892F, 21.982248F, 1.535404F);
      ((Path)localObject2).cubicTo(18.317486F, 2.296731F, 14.915536F, 3.124503F, 11.540995F, 4.056751F);
      ((Path)localObject2).cubicTo(8.388928F, 4.927538F, 7.122994F, 5.313002F, 1.500083F, 7.097506F);
      ((Path)localObject2).cubicTo(1.500277F, 8.332155F, 1.500823F, 9.595075F, 1.501879F, 11.593655F);
      ((Path)localObject2).cubicTo(1.503361F, 14.398892F, 1.503775F, 15.422399F, 1.503758F, 16.854805F);
      ((Path)localObject2).cubicTo(1.503735F, 18.709438F, 1.502597F, 20.364384F, 1.500001F, 22.000731F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(1.500001F, 22.000731F);
      ((Path)localObject2).cubicTo(1.5F, 22.001282F, 1.499999F, 22.001831F, 1.499998F, 22.00238F);
      ((Path)localObject2).lineTo(1.5F, 21.999081F);
      ((Path)localObject2).cubicTo(1.5F, 21.999632F, 1.5F, 22.000181F, 1.500001F, 22.000731F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(13.085647F, 10.316628F);
      ((Path)localObject1).lineTo(23.235413F, 10.316628F);
      ((Path)localObject1).cubicTo(25.576914F, 10.316628F, 27.333014F, 10.822622F, 28.503765F, 11.834627F);
      ((Path)localObject1).cubicTo(29.674515F, 12.846633F, 30.259882F, 14.255481F, 30.259882F, 16.061216F);
      ((Path)localObject1).cubicTo(30.259882F, 17.073221F, 30.111061F, 17.911585F, 29.813412F, 18.576334F);
      ((Path)localObject1).cubicTo(29.515762F, 19.241081F, 29.168512F, 19.77684F, 28.771646F, 20.183628F);
      ((Path)localObject1).cubicTo(28.374783F, 20.590414F, 27.982883F, 20.883097F, 27.595942F, 21.061686F);
      ((Path)localObject1).cubicTo(27.208998F, 21.240276F, 26.926237F, 21.359333F, 26.747646F, 21.418863F);
      ((Path)localObject1).lineTo(26.747646F, 21.478392F);
      ((Path)localObject1).cubicTo(27.065138F, 21.518078F, 27.407429F, 21.617292F, 27.774529F, 21.776039F);
      ((Path)localObject1).cubicTo(28.14163F, 21.934786F, 28.483919F, 22.187782F, 28.801413F, 22.53504F);
      ((Path)localObject1).cubicTo(29.118904F, 22.882296F, 29.381823F, 23.333723F, 29.590176F, 23.889334F);
      ((Path)localObject1).cubicTo(29.798531F, 24.444944F, 29.902706F, 25.139446F, 29.902706F, 25.972862F);
      ((Path)localObject1).cubicTo(29.902706F, 27.222986F, 29.99696F, 28.358995F, 30.185471F, 29.380922F);
      ((Path)localObject1).cubicTo(30.373981F, 30.402847F, 30.666664F, 31.132076F, 31.06353F, 31.568628F);
      ((Path)localObject1).lineTo(27.075058F, 31.568628F);
      ((Path)localObject1).cubicTo(26.797253F, 31.112232F, 26.633549F, 30.606237F, 26.583941F, 30.050627F);
      ((Path)localObject1).cubicTo(26.534332F, 29.495016F, 26.509529F, 28.959257F, 26.509529F, 28.443333F);
      ((Path)localObject1).cubicTo(26.509529F, 27.471014F, 26.450001F, 26.63265F, 26.33094F, 25.928215F);
      ((Path)localObject1).cubicTo(26.211882F, 25.223782F, 25.993608F, 24.638414F, 25.676117F, 24.172098F);
      ((Path)localObject1).cubicTo(25.358625F, 23.705782F, 24.927042F, 23.363491F, 24.381353F, 23.145216F);
      ((Path)localObject1).cubicTo(23.835665F, 22.926941F, 23.1362F, 22.817804F, 22.282942F, 22.817804F);
      ((Path)localObject1).lineTo(16.806234F, 22.817804F);
      ((Path)localObject1).lineTo(16.806234F, 31.568628F);
      ((Path)localObject1).lineTo(13.085647F, 31.568628F);
      ((Path)localObject1).lineTo(13.085647F, 10.316628F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(16.806234F, 19.990156F);
      ((Path)localObject1).lineTo(22.908001F, 19.990156F);
      ((Path)localObject1).cubicTo(24.098595F, 19.990156F, 25.001448F, 19.707396F, 25.616589F, 19.141863F);
      ((Path)localObject1).cubicTo(26.23173F, 18.57633F, 26.539293F, 17.728045F, 26.539293F, 16.596981F);
      ((Path)localObject1).cubicTo(26.539293F, 15.922311F, 26.440079F, 15.371669F, 26.241648F, 14.945039F);
      ((Path)localObject1).cubicTo(26.043215F, 14.51841F, 25.770374F, 14.18604F, 25.423117F, 13.947922F);
      ((Path)localObject1).cubicTo(25.075861F, 13.709803F, 24.679003F, 13.551059F, 24.232529F, 13.471686F);
      ((Path)localObject1).cubicTo(23.786057F, 13.392313F, 23.324709F, 13.352628F, 22.848471F, 13.352628F);
      ((Path)localObject1).lineTo(16.806234F, 13.352628F);
      ((Path)localObject1).lineTo(16.806234F, 19.990156F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bii
 * JD-Core Version:    0.7.0.1
 */