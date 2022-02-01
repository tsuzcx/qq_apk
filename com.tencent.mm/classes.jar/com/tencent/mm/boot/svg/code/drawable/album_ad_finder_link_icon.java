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

public class album_ad_finder_link_icon
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(1275068416);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(34.820702F, 0.55402F);
      ((Path)localObject2).cubicTo(35.8629F, 1.04513F, 36.646301F, 2.00355F, 37.154499F, 3.2757F);
      ((Path)localObject2).cubicTo(37.8451F, 5.0042F, 37.924999F, 7.7807F, 37.660099F, 10.8349F);
      ((Path)localObject2).cubicTo(37.3913F, 13.9333F, 36.752701F, 17.463499F, 35.896F, 20.7925F);
      ((Path)localObject2).cubicTo(35.040401F, 24.116899F, 33.958F, 27.2773F, 32.787998F, 29.624001F);
      ((Path)localObject2).cubicTo(32.2048F, 30.7939F, 31.5816F, 31.798901F, 30.9284F, 32.523602F);
      ((Path)localObject2).cubicTo(30.295799F, 33.2253F, 29.5112F, 33.800098F, 28.6017F, 33.800098F);
      ((Path)localObject2).cubicTo(27.6381F, 33.800098F, 26.740601F, 33.397099F, 25.8957F, 32.757099F);
      ((Path)localObject2).cubicTo(25.0539F, 32.119499F, 24.212099F, 31.207701F, 23.341499F, 30.0926F);
      ((Path)localObject2).cubicTo(22.550699F, 29.0795F, 21.732201F, 27.8811F, 20.897301F, 26.540501F);
      ((Path)localObject2).cubicTo(20.2486F, 25.4988F, 19.611799F, 24.4072F, 19.0F, 23.3036F);
      ((Path)localObject2).cubicTo(18.3881F, 24.4074F, 17.7514F, 25.4991F, 17.1028F, 26.540501F);
      ((Path)localObject2).cubicTo(16.2679F, 27.8811F, 15.4494F, 29.0795F, 14.6586F, 30.0926F);
      ((Path)localObject2).cubicTo(13.788F, 31.207701F, 12.9462F, 32.119499F, 12.1044F, 32.757099F);
      ((Path)localObject2).cubicTo(11.2594F, 33.397099F, 10.362F, 33.800098F, 9.3984F, 33.800098F);
      ((Path)localObject2).cubicTo(8.4889F, 33.800098F, 7.7043F, 33.2253F, 7.0717F, 32.523602F);
      ((Path)localObject2).cubicTo(6.4185F, 31.798901F, 5.7953F, 30.7939F, 5.2121F, 29.624001F);
      ((Path)localObject2).cubicTo(4.04213F, 27.2773F, 2.95969F, 24.117001F, 2.10413F, 20.792601F);
      ((Path)localObject2).cubicTo(1.24738F, 17.463499F, 0.60874F, 13.9333F, 0.34001F, 10.835F);
      ((Path)localObject2).cubicTo(0.07511F, 7.7808F, 0.15496F, 5.0043F, 0.84558F, 3.2758F);
      ((Path)localObject2).lineTo(0.9508898F, 3.025594F);
      ((Path)localObject2).cubicTo(1.459411F, 1.87791F, 2.206672F, 1.012409F, 3.17942F, 0.55403F);
      ((Path)localObject2).cubicTo(4.23151F, 0.05827F, 5.4199F, 0.09878F, 6.6049F, 0.57814F);
      ((Path)localObject2).cubicTo(8.2798F, 1.25566F, 10.0248F, 2.82112F, 11.8742F, 4.9939F);
      ((Path)localObject2).cubicTo(12.9876F, 6.3019F, 14.1455F, 7.8427F, 15.3308F, 9.5644F);
      ((Path)localObject2).cubicTo(16.596001F, 11.4022F, 17.834499F, 13.3598F, 19.0F, 15.3184F);
      ((Path)localObject2).lineTo(19.0F, 15.3184F);
      ((Path)localObject2).cubicTo(19.9238F, 13.7661F, 20.8932F, 12.2147F, 21.885401F, 10.7232F);
      ((Path)localObject2).lineTo(21.8888F, 10.7179F);
      ((Path)localObject2).lineTo(22.6693F, 9.5644F);
      ((Path)localObject2).cubicTo(23.854601F, 7.8426F, 25.012501F, 6.3019F, 26.125799F, 4.9939F);
      ((Path)localObject2).cubicTo(27.9753F, 2.82112F, 29.720301F, 1.25566F, 31.395201F, 0.57814F);
      ((Path)localObject2).cubicTo(32.5802F, 0.09878F, 33.7686F, 0.05827F, 34.820702F, 0.55402F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.2061F, 4.032F);
      ((Path)localObject2).cubicTo(33.174198F, 4.0296F, 33.0742F, 4.0362F, 32.845901F, 4.1286F);
      ((Path)localObject2).cubicTo(31.9795F, 4.479F, 30.6756F, 5.5787F, 29.0648F, 7.4711F);
      ((Path)localObject2).cubicTo(28.051001F, 8.6622F, 26.970699F, 10.098F, 25.846701F, 11.7306F);
      ((Path)localObject2).cubicTo(24.8421F, 13.1898F, 23.849199F, 14.7371F, 22.895901F, 16.3043F);
      ((Path)localObject2).cubicTo(22.8953F, 16.305201F, 22.8948F, 16.3062F, 22.894199F, 16.307199F);
      ((Path)localObject2).lineTo(21.8885F, 17.992399F);
      ((Path)localObject2).lineTo(21.1798F, 19.2237F);
      ((Path)localObject2).lineTo(21.2952F, 19.446899F);
      ((Path)localObject2).lineTo(21.298201F, 19.4527F);
      ((Path)localObject2).lineTo(21.726F, 20.264F);
      ((Path)localObject2).cubicTo(21.726299F, 20.264601F, 21.726601F, 20.2652F, 21.7269F, 20.2658F);
      ((Path)localObject2).cubicTo(22.504499F, 21.7216F, 23.3316F, 23.173401F, 24.1712F, 24.5215F);
      ((Path)localObject2).cubicTo(24.947701F, 25.768499F, 25.691F, 26.8547F, 26.3832F, 27.741301F);
      ((Path)localObject2).cubicTo(27.003099F, 28.5355F, 27.5578F, 29.128F, 27.998899F, 29.5131F);
      ((Path)localObject2).cubicTo(28.1826F, 29.6735F, 28.3361F, 29.788601F, 28.4573F, 29.8659F);
      ((Path)localObject2).cubicTo(28.5233F, 29.7752F, 28.602501F, 29.655001F, 28.693899F, 29.501301F);
      ((Path)localObject2).cubicTo(28.994801F, 28.995001F, 29.3643F, 28.233601F, 29.768101F, 27.259399F);
      ((Path)localObject2).cubicTo(30.572701F, 25.3183F, 31.4807F, 22.612101F, 32.2267F, 19.594801F);
      ((Path)localObject2).lineTo(32.532398F, 18.309099F);
      ((Path)localObject2).cubicTo(33.234699F, 15.232F, 33.695702F, 12.2921F, 33.874901F, 9.8656F);
      ((Path)localObject2).cubicTo(33.9646F, 8.6516F, 33.9828F, 7.578F, 33.9286F, 6.6866F);
      ((Path)localObject2).cubicTo(33.8736F, 5.783F, 33.7467F, 5.1179F, 33.576401F, 4.6917F);
      ((Path)localObject2).cubicTo(33.472301F, 4.431F, 33.383099F, 4.2609F, 33.308701F, 4.1519F);
      ((Path)localObject2).cubicTo(33.254501F, 4.0726F, 33.218899F, 4.0417F, 33.2061F, 4.032F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.935F, 7.4711F);
      ((Path)localObject2).cubicTo(7.3242F, 5.5787F, 6.0203F, 4.479F, 5.154F, 4.1286F);
      ((Path)localObject2).cubicTo(4.92562F, 4.0362F, 4.82565F, 4.0296F, 4.79374F, 4.032F);
      ((Path)localObject2).cubicTo(4.78093F, 4.0417F, 4.74538F, 4.0726F, 4.69114F, 4.1519F);
      ((Path)localObject2).cubicTo(4.61669F, 4.2609F, 4.52748F, 4.4311F, 4.42332F, 4.6919F);
      ((Path)localObject2).cubicTo(4.353524F, 4.866574F, 4.292532F, 5.076168F, 4.240973F, 5.319074F);
      ((Path)localObject2).lineTo(4.204827F, 5.504013F);
      ((Path)localObject2).cubicTo(4.040265F, 6.415586F, 3.993913F, 7.726831F, 4.09195F, 9.3722F);
      ((Path)localObject2).cubicTo(4.22239F, 11.5614F, 4.59911F, 14.2198F, 5.1908F, 17.045F);
      ((Path)localObject2).lineTo(5.4682F, 18.312599F);
      ((Path)localObject2).lineTo(5.7731F, 19.594801F);
      ((Path)localObject2).cubicTo(6.5191F, 22.612101F, 7.4271F, 25.318199F, 8.2317F, 27.259399F);
      ((Path)localObject2).cubicTo(8.6355F, 28.233601F, 9.005F, 28.995001F, 9.3059F, 29.501301F);
      ((Path)localObject2).cubicTo(9.3973F, 29.655001F, 9.4765F, 29.7752F, 9.5425F, 29.8659F);
      ((Path)localObject2).cubicTo(9.6637F, 29.788601F, 9.8172F, 29.6735F, 10.0009F, 29.513201F);
      ((Path)localObject2).cubicTo(10.442F, 29.128F, 10.9967F, 28.5355F, 11.6167F, 27.741301F);
      ((Path)localObject2).cubicTo(12.3088F, 26.8547F, 13.0521F, 25.768499F, 13.8287F, 24.5215F);
      ((Path)localObject2).cubicTo(14.4578F, 23.5112F, 15.0802F, 22.4424F, 15.6801F, 21.357F);
      ((Path)localObject2).lineTo(16.407801F, 20.012199F);
      ((Path)localObject2).lineTo(16.818399F, 19.2213F);
      ((Path)localObject2).lineTo(16.3941F, 18.4783F);
      ((Path)localObject2).lineTo(15.8128F, 17.485399F);
      ((Path)localObject2).cubicTo(15.8124F, 17.4848F, 15.8121F, 17.484301F, 15.8117F, 17.4837F);
      ((Path)localObject2).cubicTo(14.6472F, 15.5176F, 13.4093F, 13.5553F, 12.1531F, 11.7306F);
      ((Path)localObject2).cubicTo(11.778466F, 11.1864F, 11.408667F, 10.664066F, 11.044556F, 10.165374F);
      ((Path)localObject2).lineTo(10.863827F, 9.921013F);
      ((Path)localObject2).lineTo(10.682372F, 9.674627F);
      ((Path)localObject2).cubicTo(10.082F, 8.87007F, 9.498222F, 8.132822F, 8.935F, 7.4711F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.album_ad_finder_link_icon
 * JD-Core Version:    0.7.0.1
 */