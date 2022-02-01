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

public final class nl
  extends c
{
  private final int height = 78;
  private final int width = 78;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 78;
      return 78;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -19.0F, 0.0F, 1.0F, -139.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 19.0F, 0.0F, 1.0F, 139.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-2565928);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(78.0F, 0.0F);
      localPath.lineTo(78.0F, 78.0F);
      localPath.lineTo(0.0F, 78.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.a(localPaint2, paramVarArgs));
      localCanvas.restore();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-4114126);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(4.0F, 3.0F);
      localPath.cubicTo(4.0F, 1.343146F, 5.343145F, 0.0F, 7.0F, 0.0F);
      localPath.lineTo(71.0F, 0.0F);
      localPath.cubicTo(72.656853F, 0.0F, 74.0F, 1.343146F, 74.0F, 3.0F);
      localPath.lineTo(74.0F, 75.0F);
      localPath.cubicTo(74.0F, 76.656853F, 72.656853F, 78.0F, 71.0F, 78.0F);
      localPath.lineTo(7.0F, 78.0F);
      localPath.cubicTo(5.343145F, 78.0F, 4.0F, 76.656853F, 4.0F, 75.0F);
      localPath.lineTo(4.0F, 3.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-3195594);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(4.0F, 3.0F);
      localPath.cubicTo(4.0F, 1.343146F, 5.343145F, 0.0F, 7.0F, 0.0F);
      localPath.lineTo(71.0F, 0.0F);
      localPath.cubicTo(72.656853F, 0.0F, 74.0F, 1.343146F, 74.0F, 3.0F);
      localPath.lineTo(74.0F, 72.0F);
      localPath.cubicTo(74.0F, 73.656853F, 72.656853F, 75.0F, 71.0F, 75.0F);
      localPath.lineTo(7.0F, 75.0F);
      localPath.cubicTo(5.343145F, 75.0F, 4.0F, 73.656853F, 4.0F, 72.0F);
      localPath.lineTo(4.0F, 3.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-3983053);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(38.99094F, 38.0F);
      localPath.cubicTo(28.32542F, 38.0F, 18.273897F, 34.220352F, 9.596006F, 29.342281F);
      localPath.cubicTo(7.661689F, 28.254951F, 3.994564F, 24.845966F, 4.000006F, 21.130112F);
      localPath.cubicTo(4.020538F, 7.110608F, 4.000006F, 7.201041F, 4.000006F, 4.003007F);
      localPath.cubicTo(5.01282F, 3.996242F, 5.868786F, 4.003007F, 38.99094F, 4.003007F);
      localPath.cubicTo(39.012661F, 17.169802F, 38.988136F, 28.86417F, 38.99094F, 38.0F);
      localPath.close();
      localPath.moveTo(39.009068F, 38.039093F);
      localPath.cubicTo(39.011868F, 28.893492F, 38.987331F, 17.183887F, 39.009068F, 4.00301F);
      localPath.cubicTo(72.146149F, 4.00301F, 72.966225F, 3.996238F, 73.979492F, 4.00301F);
      localPath.cubicTo(73.979492F, 7.204465F, 73.958954F, 7.115004F, 73.979492F, 21.149502F);
      localPath.cubicTo(73.98494F, 24.869329F, 70.316162F, 28.281961F, 68.380966F, 29.370455F);
      localPath.cubicTo(59.699165F, 34.253738F, 49.679394F, 38.039093F, 39.009068F, 38.039093F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-43948);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(38.99094F, 34.0F);
      localPath.cubicTo(28.32542F, 34.0F, 18.273897F, 31.22035F, 9.596006F, 26.342281F);
      localPath.cubicTo(7.661689F, 25.254951F, 3.994564F, 21.845966F, 4.000006F, 18.130112F);
      localPath.cubicTo(4.020538F, 4.110608F, 4.000006F, 3.201042F, 4.000006F, 0.003006567F);
      localPath.cubicTo(5.01282F, -0.003758209F, 5.868786F, 0.003006567F, 38.99094F, 0.003006567F);
      localPath.cubicTo(39.012661F, 13.169803F, 38.988136F, 24.86417F, 38.99094F, 34.0F);
      localPath.close();
      localPath.moveTo(39.009068F, 34.039093F);
      localPath.cubicTo(39.011868F, 24.893492F, 38.987331F, 13.183887F, 39.009068F, 0.003009782F);
      localPath.cubicTo(72.146149F, 0.003009782F, 72.966225F, -0.003762228F, 73.979492F, 0.003009782F);
      localPath.cubicTo(73.979492F, 3.204465F, 73.958954F, 4.115004F, 73.979492F, 18.149502F);
      localPath.cubicTo(73.98494F, 21.869329F, 70.316162F, 25.281961F, 68.380966F, 26.370455F);
      localPath.cubicTo(59.699165F, 31.25374F, 49.679394F, 34.039093F, 39.009068F, 34.039093F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 25.0F, 0.0F, 1.0F, 23.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-4507855);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 0.0F);
      ((Path)localObject2).cubicTo(21.731987F, 0.0F, 28.0F, 6.939586F, 28.0F, 15.5F);
      ((Path)localObject2).cubicTo(28.0F, 24.060413F, 21.731987F, 31.0F, 14.0F, 31.0F);
      ((Path)localObject2).cubicTo(6.268013F, 31.0F, 0.0F, 24.060413F, 0.0F, 15.5F);
      ((Path)localObject2).cubicTo(0.0F, 6.939586F, 6.268013F, 0.0F, 14.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-534697);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 0.0F);
      ((Path)localObject2).cubicTo(21.731987F, 0.0F, 28.0F, 6.268013F, 28.0F, 14.0F);
      ((Path)localObject2).cubicTo(28.0F, 21.731987F, 21.731987F, 28.0F, 14.0F, 28.0F);
      ((Path)localObject2).cubicTo(6.268013F, 28.0F, 0.0F, 21.731987F, 0.0F, 14.0F);
      ((Path)localObject2).cubicTo(0.0F, 6.268013F, 6.268013F, 0.0F, 14.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1599158);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(15.109375F, 7.089459F);
      ((Path)localObject1).cubicTo(15.65414F, 7.175626F, 16.154079F, 7.324041F, 16.609196F, 7.534706F);
      ((Path)localObject1).cubicTo(17.379314F, 7.891178F, 17.977009F, 8.402338F, 18.402298F, 9.068201F);
      ((Path)localObject1).cubicTo(18.827589F, 9.734064F, 19.055555F, 10.517619F, 19.086206F, 11.418888F);
      ((Path)localObject1).lineTo(17.327587F, 11.560131F);
      ((Path)localObject1).cubicTo(17.235632F, 10.598329F, 16.908049F, 9.885395F, 16.344828F, 9.421309F);
      ((Path)localObject1).cubicTo(16.012417F, 9.147407F, 15.600601F, 8.954334F, 15.109375F, 8.842089F);
      ((Path)localObject1).lineTo(15.109375F, 13.567871F);
      ((Path)localObject1).cubicTo(15.935555F, 13.789211F, 16.548517F, 13.987599F, 16.948277F, 14.163037F);
      ((Path)localObject1).cubicTo(17.791191F, 14.539687F, 18.4272F, 15.035714F, 18.856321F, 15.651134F);
      ((Path)localObject1).cubicTo(19.285442F, 16.266552F, 19.5F, 17.001345F, 19.5F, 17.855534F);
      ((Path)localObject1).cubicTo(19.5F, 18.702995F, 19.273949F, 19.474779F, 18.821838F, 20.17091F);
      ((Path)localObject1).cubicTo(18.36973F, 20.867039F, 17.754793F, 21.396694F, 16.977011F, 21.759893F);
      ((Path)localObject1).cubicTo(16.432417F, 22.0142F, 15.809875F, 22.179476F, 15.109375F, 22.255718F);
      ((Path)localObject1).lineTo(15.109375F, 24.0F);
      ((Path)localObject1).lineTo(13.109375F, 24.0F);
      ((Path)localObject1).lineTo(13.109375F, 22.2418F);
      ((Path)localObject1).cubicTo(11.886434F, 22.08934F, 10.876802F, 21.659672F, 10.08046F, 20.952791F);
      ((Path)localObject1).cubicTo(9.065129F, 20.051521F, 8.538315F, 18.83079F, 8.5F, 17.290562F);
      ((Path)localObject1).lineTo(10.224138F, 17.129141F);
      ((Path)localObject1).cubicTo(10.316092F, 17.942974F, 10.524902F, 18.57688F, 10.850574F, 19.030876F);
      ((Path)localObject1).cubicTo(11.176247F, 19.484875F, 11.64176F, 19.849749F, 12.247127F, 20.125509F);
      ((Path)localObject1).cubicTo(12.519079F, 20.249392F, 12.806495F, 20.345448F, 13.109375F, 20.413677F);
      ((Path)localObject1).lineTo(13.109375F, 15.072175F);
      ((Path)localObject1).cubicTo(12.039918F, 14.775104F, 11.262087F, 14.475423F, 10.775862F, 14.173126F);
      ((Path)localObject1).cubicTo(10.224135F, 13.830106F, 9.795021F, 13.394611F, 9.488505F, 12.866629F);
      ((Path)localObject1).cubicTo(9.181991F, 12.338646F, 9.028735F, 11.741733F, 9.028735F, 11.07587F);
      ((Path)localObject1).cubicTo(9.028735F, 9.878661F, 9.469344F, 8.900059F, 10.350574F, 8.140033F);
      ((Path)localObject1).cubicTo(11.067378F, 7.521819F, 11.986972F, 7.15504F, 13.109375F, 7.03969F);
      ((Path)localObject1).lineTo(13.109375F, 5.0F);
      ((Path)localObject1).lineTo(15.109375F, 5.0F);
      ((Path)localObject1).lineTo(15.109375F, 7.089459F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(15.109375F, 15.615809F);
      ((Path)localObject1).lineTo(15.109375F, 20.489592F);
      ((Path)localObject1).cubicTo(15.81324F, 20.398357F, 16.385973F, 20.181154F, 16.827587F, 19.83798F);
      ((Path)localObject1).cubicTo(17.429121F, 19.370529F, 17.729885F, 18.763527F, 17.729885F, 18.016954F);
      ((Path)localObject1).cubicTo(17.729885F, 17.579771F, 17.620691F, 17.198082F, 17.402298F, 16.871876F);
      ((Path)localObject1).cubicTo(17.183907F, 16.545671F, 16.854408F, 16.27832F, 16.413794F, 16.069818F);
      ((Path)localObject1).cubicTo(16.155186F, 15.947443F, 15.720381F, 15.796107F, 15.109375F, 15.615809F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(13.109375F, 13.050172F);
      ((Path)localObject1).lineTo(13.109375F, 8.779712F);
      ((Path)localObject1).cubicTo(12.486867F, 8.864984F, 11.984894F, 9.050263F, 11.603448F, 9.335554F);
      ((Path)localObject1).cubicTo(11.059384F, 9.74247F, 10.787356F, 10.268764F, 10.787356F, 10.914449F);
      ((Path)localObject1).cubicTo(10.787356F, 11.513053F, 10.986588F, 11.977133F, 11.385057F, 12.306701F);
      ((Path)localObject1).cubicTo(11.682429F, 12.552653F, 12.257197F, 12.800475F, 13.109375F, 13.050172F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.nl
 * JD-Core Version:    0.7.0.1
 */