package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class apo
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-15432210);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(12.586262F, 1.4244F);
      localPath.lineTo(14.638473F, 2.910013F);
      localPath.cubicTo(14.808986F, 3.033449F, 15.014104F, 3.099929F, 15.224607F, 3.099983F);
      localPath.lineTo(17.763798F, 3.100628F);
      localPath.cubicTo(18.19655F, 3.100739F, 18.580128F, 3.379196F, 18.714279F, 3.790628F);
      localPath.lineTo(19.496529F, 6.189701F);
      localPath.cubicTo(19.562052F, 6.390654F, 19.689564F, 6.565677F, 19.860758F, 6.689644F);
      localPath.lineTo(21.909824F, 8.173447F);
      localPath.cubicTo(22.261541F, 8.428137F, 22.408686F, 8.880709F, 22.274004F, 9.293543F);
      localPath.lineTo(21.492556F, 11.688848F);
      localPath.cubicTo(21.426826F, 11.890326F, 21.426805F, 12.10748F, 21.492496F, 12.308972F);
      localPath.lineTo(22.274122F, 14.706372F);
      localPath.cubicTo(22.408733F, 15.119252F, 22.26148F, 15.571817F, 21.909683F, 15.826432F);
      localPath.lineTo(19.860958F, 17.30921F);
      localPath.cubicTo(19.689638F, 17.433203F, 19.56204F, 17.608318F, 19.4965F, 17.809389F);
      localPath.lineTo(18.71431F, 20.209059F);
      localPath.cubicTo(18.580151F, 20.620646F, 18.19639F, 20.899172F, 17.763491F, 20.899149F);
      localPath.lineTo(15.225917F, 20.899017F);
      localPath.cubicTo(15.015286F, 20.899006F, 14.810031F, 20.965504F, 14.639422F, 21.089025F);
      localPath.lineTo(12.586317F, 22.575499F);
      localPath.cubicTo(12.236458F, 22.828802F, 11.763507F, 22.82885F, 11.413596F, 22.575619F);
      localPath.lineTo(9.359278F, 21.088907F);
      localPath.cubicTo(9.1887F, 20.96546F, 8.983508F, 20.899006F, 8.772948F, 20.899017F);
      localPath.lineTo(6.236256F, 20.899149F);
      localPath.cubicTo(5.803478F, 20.899172F, 5.419798F, 20.6208F, 5.28554F, 20.209373F);
      localPath.lineTo(4.502263F, 17.809074F);
      localPath.cubicTo(4.436713F, 17.6082F, 4.309218F, 17.43325F, 4.138073F, 17.30933F);
      localPath.lineTo(2.090139F, 15.826488F);
      localPath.cubicTo(1.738438F, 15.571832F, 1.591265F, 15.119312F, 1.725883F, 14.706492F);
      localPath.lineTo(2.507354F, 12.310026F);
      localPath.cubicTo(2.57305F, 12.108562F, 2.57305F, 11.891438F, 2.507354F, 11.689974F);
      localPath.lineTo(1.725883F, 9.293508F);
      localPath.cubicTo(1.591265F, 8.880688F, 1.738438F, 8.428168F, 2.090139F, 8.173513F);
      localPath.lineTo(4.138073F, 6.690671F);
      localPath.cubicTo(4.309218F, 6.566749F, 4.436713F, 6.3918F, 4.502263F, 6.190926F);
      localPath.lineTo(5.285613F, 3.790404F);
      localPath.cubicTo(5.419836F, 3.379086F, 5.803357F, 3.100739F, 6.236022F, 3.100628F);
      localPath.lineTo(8.774259F, 3.099983F);
      localPath.cubicTo(8.984692F, 3.099929F, 9.189745F, 3.033493F, 9.360227F, 2.910133F);
      localPath.lineTo(11.413651F, 1.42428F);
      localPath.cubicTo(11.763538F, 1.171103F, 12.236426F, 1.171151F, 12.586262F, 1.4244F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(10.823438F, 14.139317F);
      ((Path)localObject).lineTo(16.422754F, 8.54F);
      ((Path)localObject).lineTo(17.485281F, 9.602528F);
      ((Path)localObject).lineTo(11.278302F, 15.806928F);
      ((Path)localObject).cubicTo(11.028384F, 16.056881F, 10.623159F, 16.056797F, 10.373276F, 15.806809F);
      ((Path)localObject).cubicTo(10.373252F, 15.806786F, 10.373229F, 15.806763F, 10.373276F, 15.80667F);
      ((Path)localObject).lineTo(7.0F, 12.430955F);
      ((Path)localObject).lineTo(7.0F, 12.430955F);
      ((Path)localObject).lineTo(8.057538F, 11.373417F);
      ((Path)localObject).lineTo(10.823438F, 14.139317F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apo
 * JD-Core Version:    0.7.0.1
 */