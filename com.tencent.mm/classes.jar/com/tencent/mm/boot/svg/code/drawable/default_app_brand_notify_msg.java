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

public class default_app_brand_notify_msg
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 3.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-9074725);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.153325F, 1.11165E-015F);
      ((Path)localObject2).lineTo(41.846676F, 2.652589E-015F);
      ((Path)localObject2).cubicTo(43.98632F, -1.541231E-015F, 44.762207F, 0.2227815F, 45.54443F, 0.6411185F);
      ((Path)localObject2).cubicTo(46.326653F, 1.059456F, 46.940544F, 1.673348F, 47.358883F, 2.45557F);
      ((Path)localObject2).cubicTo(47.777218F, 3.237793F, 48.0F, 4.01368F, 48.0F, 6.153325F);
      ((Path)localObject2).lineTo(48.0F, 41.846676F);
      ((Path)localObject2).cubicTo(48.0F, 43.98632F, 47.777218F, 44.762207F, 47.358883F, 45.54443F);
      ((Path)localObject2).cubicTo(46.940544F, 46.326653F, 46.326653F, 46.940544F, 45.54443F, 47.358883F);
      ((Path)localObject2).cubicTo(44.762207F, 47.777218F, 43.98632F, 48.0F, 41.846676F, 48.0F);
      ((Path)localObject2).lineTo(6.153325F, 48.0F);
      ((Path)localObject2).cubicTo(4.01368F, 48.0F, 3.237793F, 47.777218F, 2.45557F, 47.358883F);
      ((Path)localObject2).cubicTo(1.673348F, 46.940544F, 1.059456F, 46.326653F, 0.6411185F, 45.54443F);
      ((Path)localObject2).cubicTo(0.2227815F, 44.762207F, -6.940486E-016F, 43.98632F, 1.194517E-015F, 41.846676F);
      ((Path)localObject2).lineTo(1.657345E-016F, 6.153325F);
      ((Path)localObject2).cubicTo(-9.629649E-017F, 4.01368F, 0.2227815F, 3.237793F, 0.6411185F, 2.45557F);
      ((Path)localObject2).cubicTo(1.059456F, 1.673348F, 1.673348F, 1.059456F, 2.45557F, 0.6411185F);
      ((Path)localObject2).cubicTo(3.237793F, 0.2227815F, 4.01368F, -6.459004E-016F, 6.153325F, 1.11165E-015F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(29.928276F, 11.544827F);
      ((Path)localObject1).cubicTo(28.395653F, 11.544827F, 26.968695F, 11.947169F, 25.757242F, 12.631471F);
      ((Path)localObject1).cubicTo(23.535007F, 13.887473F, 22.049656F, 16.107447F, 22.049656F, 18.639591F);
      ((Path)localObject1).lineTo(22.049656F, 29.167305F);
      ((Path)localObject1).cubicTo(22.049656F, 31.06321F, 20.181959F, 32.600254F, 17.87862F, 32.600254F);
      ((Path)localObject1).cubicTo(15.57482F, 32.600254F, 13.707586F, 31.06321F, 13.707586F, 29.167305F);
      ((Path)localObject1).cubicTo(13.707586F, 27.817926F, 14.655802F, 26.653929F, 16.03178F, 26.092754F);
      ((Path)localObject1).cubicTo(16.130957F, 26.052475F, 16.231525F, 26.014027F, 16.334875F, 25.980154F);
      ((Path)localObject1).cubicTo(17.201059F, 25.63686F, 17.943968F, 24.99238F, 18.219719F, 24.243998F);
      ((Path)localObject1).cubicTo(18.62709F, 23.139044F, 17.868889F, 22.243731F, 16.526743F, 22.243731F);
      ((Path)localObject1).cubicTo(16.192133F, 22.243731F, 15.852888F, 22.299574F, 15.525694F, 22.400274F);
      ((Path)localObject1).cubicTo(15.524303F, 22.400732F, 15.522913F, 22.40119F, 15.521059F, 22.401648F);
      ((Path)localObject1).cubicTo(13.580602F, 22.951834F, 11.96085F, 24.158401F, 10.988535F, 25.734356F);
      ((Path)localObject1).cubicTo(10.360562F, 26.752796F, 10.0F, 27.922289F, 10.0F, 29.167305F);
      ((Path)localObject1).cubicTo(10.0F, 33.079494F, 13.534257F, 36.26207F, 17.87862F, 36.26207F);
      ((Path)localObject1).cubicTo(19.411243F, 36.26207F, 20.838202F, 35.859726F, 22.049656F, 35.175426F);
      ((Path)localObject1).cubicTo(24.271891F, 33.919422F, 25.757242F, 31.69945F, 25.757242F, 29.167305F);
      ((Path)localObject1).lineTo(25.757242F, 18.639591F);
      ((Path)localObject1).cubicTo(25.757242F, 16.743687F, 27.624474F, 15.206641F, 29.928276F, 15.206641F);
      ((Path)localObject1).cubicTo(32.231613F, 15.206641F, 34.099312F, 16.743687F, 34.099312F, 18.639591F);
      ((Path)localObject1).cubicTo(34.099312F, 20.046642F, 33.070919F, 21.255957F, 31.598543F, 21.786005F);
      ((Path)localObject1).cubicTo(30.648937F, 22.100462F, 29.870808F, 22.779272F, 29.574202F, 23.583498F);
      ((Path)localObject1).cubicTo(29.169147F, 24.682957F, 29.923641F, 25.574608F, 31.259764F, 25.574608F);
      ((Path)localObject1).cubicTo(31.562395F, 25.574608F, 31.868271F, 25.523342F, 32.166267F, 25.440037F);
      ((Path)localObject1).cubicTo(32.214931F, 25.426764F, 32.26313F, 25.412115F, 32.311325F, 25.397926F);
      ((Path)localObject1).cubicTo(34.2402F, 24.844534F, 35.85022F, 23.641628F, 36.817898F, 22.072542F);
      ((Path)localObject1).cubicTo(37.446335F, 21.054558F, 37.806896F, 19.884607F, 37.806896F, 18.639591F);
      ((Path)localObject1).cubicTo(37.806896F, 14.727402F, 34.27264F, 11.544827F, 29.928276F, 11.544827F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.default_app_brand_notify_msg
 * JD-Core Version:    0.7.0.1
 */