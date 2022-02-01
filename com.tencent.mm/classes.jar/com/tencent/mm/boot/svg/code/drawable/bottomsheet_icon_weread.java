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

public class bottomsheet_icon_weread
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -340.0F, 0.0F, 1.0F, -201.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 349.0F, 0.0F, 1.0F, 210.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-13783042);
      Object localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(50.80595F, 0.0F);
      ((Path)localObject3).cubicTo(58.636501F, 0.0F, 62.5508F, 0.0F, 66.766052F, 1.3325F);
      ((Path)localObject3).cubicTo(71.36805F, 3.00755F, 74.992447F, 6.63195F, 76.667503F, 11.23395F);
      ((Path)localObject3).cubicTo(78.0F, 15.44855F, 78.0F, 19.364149F, 78.0F, 27.19405F);
      ((Path)localObject3).lineTo(78.0F, 50.80595F);
      ((Path)localObject3).cubicTo(78.0F, 58.636501F, 78.0F, 62.5508F, 76.667503F, 66.766052F);
      ((Path)localObject3).cubicTo(74.992447F, 71.36805F, 71.36805F, 74.992447F, 66.766052F, 76.666847F);
      ((Path)localObject3).cubicTo(62.5508F, 78.0F, 58.636501F, 78.0F, 50.80595F, 78.0F);
      ((Path)localObject3).lineTo(27.19405F, 78.0F);
      ((Path)localObject3).cubicTo(19.363501F, 78.0F, 15.44855F, 78.0F, 11.23395F, 76.666847F);
      ((Path)localObject3).cubicTo(6.63195F, 74.992447F, 3.00755F, 71.36805F, 1.3325F, 66.766052F);
      ((Path)localObject3).cubicTo(0.0F, 62.5508F, 0.0F, 58.636501F, 0.0F, 50.80595F);
      ((Path)localObject3).lineTo(0.0F, 27.19405F);
      ((Path)localObject3).cubicTo(0.0F, 19.364149F, 0.0F, 15.44855F, 1.3325F, 11.23395F);
      ((Path)localObject3).cubicTo(3.00755F, 6.63195F, 6.63195F, 3.00755F, 11.23395F, 1.3325F);
      ((Path)localObject3).cubicTo(15.44855F, 0.0F, 19.363501F, 0.0F, 27.19405F, 0.0F);
      ((Path)localObject3).lineTo(50.80595F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-201326593);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(77.15287F, 65.0F);
      ((Path)localObject2).cubicTo(77.014801F, 65.590508F, 76.854233F, 66.175323F, 76.667503F, 66.766052F);
      ((Path)localObject2).cubicTo(74.992447F, 71.36805F, 71.36805F, 74.992447F, 66.766052F, 76.666847F);
      ((Path)localObject2).cubicTo(62.5508F, 78.0F, 58.636501F, 78.0F, 50.80595F, 78.0F);
      ((Path)localObject2).lineTo(27.19405F, 78.0F);
      ((Path)localObject2).cubicTo(19.363501F, 78.0F, 15.44855F, 78.0F, 11.23395F, 76.666847F);
      ((Path)localObject2).cubicTo(6.63195F, 74.992447F, 3.00755F, 71.36805F, 1.3325F, 66.766052F);
      ((Path)localObject2).cubicTo(1.145764F, 66.175323F, 0.9851963F, 65.590508F, 0.847131F, 65.0F);
      ((Path)localObject2).lineTo(33.0F, 65.0F);
      ((Path)localObject2).cubicTo(35.795135F, 64.88961F, 38.521011F, 67.326401F, 39.0F, 70.0F);
      ((Path)localObject2).cubicTo(39.478985F, 67.326401F, 42.204865F, 64.88961F, 46.0F, 65.0F);
      ((Path)localObject2).lineTo(77.15287F, 65.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 230, 31);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-13783042);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(50.80595F, 0.0F);
      ((Path)localObject3).cubicTo(58.636501F, 0.0F, 62.5508F, 0.0F, 66.766052F, 1.3325F);
      ((Path)localObject3).cubicTo(71.36805F, 3.00755F, 74.992447F, 6.63195F, 76.667503F, 11.23395F);
      ((Path)localObject3).cubicTo(78.0F, 15.44855F, 78.0F, 19.364149F, 78.0F, 27.19405F);
      ((Path)localObject3).lineTo(78.0F, 50.80595F);
      ((Path)localObject3).cubicTo(78.0F, 58.636501F, 78.0F, 62.5508F, 76.667503F, 66.766052F);
      ((Path)localObject3).cubicTo(74.992447F, 71.36805F, 71.36805F, 74.992447F, 66.766052F, 76.666847F);
      ((Path)localObject3).cubicTo(62.5508F, 78.0F, 58.636501F, 78.0F, 50.80595F, 78.0F);
      ((Path)localObject3).lineTo(27.19405F, 78.0F);
      ((Path)localObject3).cubicTo(19.363501F, 78.0F, 15.44855F, 78.0F, 11.23395F, 76.666847F);
      ((Path)localObject3).cubicTo(6.63195F, 74.992447F, 3.00755F, 71.36805F, 1.3325F, 66.766052F);
      ((Path)localObject3).cubicTo(0.0F, 62.5508F, 0.0F, 58.636501F, 0.0F, 50.80595F);
      ((Path)localObject3).lineTo(0.0F, 27.19405F);
      ((Path)localObject3).cubicTo(0.0F, 19.364149F, 0.0F, 15.44855F, 1.3325F, 11.23395F);
      ((Path)localObject3).cubicTo(3.00755F, 6.63195F, 6.63195F, 3.00755F, 11.23395F, 1.3325F);
      ((Path)localObject3).cubicTo(15.44855F, 0.0F, 19.363501F, 0.0F, 27.19405F, 0.0F);
      ((Path)localObject3).lineTo(50.80595F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(50.503235F, 1.0F);
      ((Path)localObject3).cubicTo(58.132999F, 1.0F, 61.946934F, 1.0F, 66.0541F, 2.298333F);
      ((Path)localObject3).cubicTo(70.538101F, 3.930433F, 74.069565F, 7.4619F, 75.701668F, 11.9459F);
      ((Path)localObject3).cubicTo(77.0F, 16.052433F, 77.0F, 19.867634F, 77.0F, 27.496767F);
      ((Path)localObject3).lineTo(77.0F, 50.503235F);
      ((Path)localObject3).cubicTo(77.0F, 58.132999F, 77.0F, 61.946934F, 75.701668F, 66.0541F);
      ((Path)localObject3).cubicTo(74.069565F, 70.538101F, 70.538101F, 74.069565F, 66.0541F, 75.701035F);
      ((Path)localObject3).cubicTo(61.946934F, 77.0F, 58.132999F, 77.0F, 50.503235F, 77.0F);
      ((Path)localObject3).lineTo(27.496767F, 77.0F);
      ((Path)localObject3).cubicTo(19.867001F, 77.0F, 16.052433F, 77.0F, 11.9459F, 75.701035F);
      ((Path)localObject3).cubicTo(7.4619F, 74.069565F, 3.930433F, 70.538101F, 2.298333F, 66.0541F);
      ((Path)localObject3).cubicTo(1.0F, 61.946934F, 1.0F, 58.132999F, 1.0F, 50.503235F);
      ((Path)localObject3).lineTo(1.0F, 27.496767F);
      ((Path)localObject3).cubicTo(1.0F, 19.867634F, 1.0F, 16.052433F, 2.298333F, 11.9459F);
      ((Path)localObject3).cubicTo(3.930433F, 7.4619F, 7.4619F, 3.930433F, 11.9459F, 2.298333F);
      ((Path)localObject3).cubicTo(16.052433F, 1.0F, 19.867001F, 1.0F, 27.496767F, 1.0F);
      ((Path)localObject3).lineTo(50.503235F, 1.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 125.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(72.0F, 52.056374F);
      ((Path)localObject1).cubicTo(72.0F, 47.607002F, 67.746773F, 44.0F, 62.5F, 44.0F);
      ((Path)localObject1).cubicTo(57.253307F, 44.0F, 53.0F, 47.607002F, 53.0F, 52.056374F);
      ((Path)localObject1).cubicTo(53.0F, 56.505817F, 57.253307F, 60.11282F, 62.5F, 60.11282F);
      ((Path)localObject1).cubicTo(63.929562F, 60.11282F, 65.285088F, 59.844482F, 66.501205F, 59.364857F);
      ((Path)localObject1).cubicTo(67.811531F, 60.119751F, 69.119522F, 60.876648F, 69.286606F, 60.985985F);
      ((Path)localObject1).cubicTo(69.286842F, 60.984447F, 69.288086F, 60.982292F, 69.288788F, 60.980518F);
      ((Path)localObject1).cubicTo(69.316689F, 60.992764F, 69.347389F, 61.0F, 69.37989F, 61.0F);
      ((Path)localObject1).cubicTo(69.503876F, 61.0F, 69.604332F, 60.900673F, 69.604332F, 60.778244F);
      ((Path)localObject1).cubicTo(69.604332F, 60.755222F, 69.599808F, 60.733429F, 69.593185F, 60.712486F);
      ((Path)localObject1).cubicTo(69.600044F, 60.707481F, 69.604332F, 60.704327F, 69.604332F, 60.704327F);
      ((Path)localObject1).lineTo(68.724022F, 58.14304F);
      ((Path)localObject1).cubicTo(70.730896F, 56.665897F, 72.0F, 54.486835F, 72.0F, 52.056374F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(65.499954F, 51.0F);
      ((Path)localObject1).cubicTo(64.671585F, 51.0F, 64.0F, 50.328388F, 64.0F, 49.499954F);
      ((Path)localObject1).cubicTo(64.0F, 48.671612F, 64.671585F, 48.0F, 65.499954F, 48.0F);
      ((Path)localObject1).cubicTo(66.328415F, 48.0F, 67.0F, 48.671612F, 67.0F, 49.499954F);
      ((Path)localObject1).cubicTo(67.0F, 50.328388F, 66.328415F, 51.0F, 65.499954F, 51.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(59.500046F, 51.0F);
      ((Path)localObject1).cubicTo(58.671566F, 51.0F, 58.0F, 50.328388F, 58.0F, 49.499954F);
      ((Path)localObject1).cubicTo(58.0F, 48.671612F, 58.671566F, 48.0F, 59.500046F, 48.0F);
      ((Path)localObject1).cubicTo(60.328434F, 48.0F, 61.0F, 48.671612F, 61.0F, 49.499954F);
      ((Path)localObject1).cubicTo(61.0F, 50.328388F, 60.328434F, 51.0F, 59.500046F, 51.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_weread
 * JD-Core Version:    0.7.0.1
 */