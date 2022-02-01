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

public class app_msg_share_nearby_life_default
  extends c
{
  private final int height = 27;
  private final int width = 22;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 22;
      return 27;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint.setColor(-2565928);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(14.830475F, 11.264064F);
      localPath.cubicTo(14.830475F, 13.443658F, 13.071956F, 15.210672F, 10.902841F, 15.210672F);
      localPath.cubicTo(8.733725F, 15.210672F, 6.975206F, 13.443658F, 6.975206F, 11.264064F);
      localPath.cubicTo(6.975206F, 9.08447F, 8.733725F, 7.317455F, 10.902841F, 7.317455F);
      localPath.cubicTo(13.071956F, 7.317455F, 14.830475F, 9.08447F, 14.830475F, 11.264064F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.134616F, 0.0F, 1.0F, 17.988773F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2565928);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.431921F, 8.575048F);
      localPath.lineTo(0.3210942F, 4.443936F);
      localPath.cubicTo(0.135575F, 4.257308F, 0.135575F, 3.954835F, 0.3210942F, 3.768419F);
      localPath.lineTo(2.147517F, 1.933173F);
      localPath.cubicTo(2.333248F, 1.746545F, 2.634267F, 1.746758F, 2.819787F, 1.933173F);
      localPath.lineTo(4.431921F, 3.553521F);
      localPath.cubicTo(4.617652F, 3.740149F, 4.918671F, 3.740149F, 5.10419F, 3.553733F);
      localPath.lineTo(8.379652F, 0.2624483F);
      localPath.cubicTo(8.565171F, 0.0758203F, 8.86619F, 0.0758203F, 9.051921F, 0.2624483F);
      localPath.lineTo(10.878345F, 2.097695F);
      localPath.cubicTo(11.063864F, 2.28411F, 11.063864F, 2.586584F, 10.878345F, 2.773212F);
      localPath.lineTo(5.10419F, 8.575048F);
      localPath.cubicTo(4.918671F, 8.761676F, 4.617652F, 8.761676F, 4.431921F, 8.575048F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.1337F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-2565928);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(4.545221F, 20.379143F);
      ((Path)localObject2).lineTo(3.328029F, 19.156069F);
      ((Path)localObject2).cubicTo(-1.022894F, 14.784127F, -1.169279F, 7.482466F, 3.252721F, 3.182794F);
      ((Path)localObject2).cubicTo(7.55224F, -0.997844F, 14.436548F, -0.955969F, 18.684029F, 3.312031F);
      ((Path)localObject2).cubicTo(22.858316F, 7.506272F, 22.971279F, 14.260379F, 19.022913F, 18.592997F);
      ((Path)localObject2).cubicTo(18.842049F, 18.79174F, 18.527491F, 18.791529F, 18.338163F, 18.601288F);
      ((Path)localObject2).lineTo(16.510895F, 16.76519F);
      ((Path)localObject2).cubicTo(16.329393F, 16.582813F, 16.330875F, 16.294369F, 16.501163F, 16.101364F);
      ((Path)localObject2).cubicTo(17.712009F, 14.728436F, 18.373491F, 12.980765F, 18.373491F, 11.130427F);
      ((Path)localObject2).cubicTo(18.373491F, 8.834988F, 17.355356F, 6.697693F, 15.533587F, 5.237616F);
      ((Path)localObject2).cubicTo(12.87751F, 3.109036F, 9.003818F, 3.088417F, 6.328702F, 5.192978F);
      ((Path)localObject2).cubicTo(4.365837F, 6.737229F, 3.316817F, 9.059451F, 3.442683F, 11.528128F);
      ((Path)localObject2).cubicTo(3.540625F, 13.449036F, 4.431837F, 15.243683F, 5.785471F, 16.603857F);
      ((Path)localObject2).lineTo(7.043913F, 17.86838F);
      ((Path)localObject2).cubicTo(7.229433F, 18.055006F, 7.229433F, 18.357481F, 7.043913F, 18.543896F);
      ((Path)localObject2).lineTo(5.21749F, 20.379143F);
      ((Path)localObject2).cubicTo(5.03176F, 20.565769F, 4.730952F, 20.565769F, 4.545221F, 20.379143F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_msg_share_nearby_life_default
 * JD-Core Version:    0.7.0.1
 */