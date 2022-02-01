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

public class icons_outlined_channels_enterprise_wechat
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
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(1.202114F, 7.863807F);
      ((Path)localObject3).cubicTo(1.202114F, 4.267744F, 4.633196F, 1.202114F, 9.065941F, 1.202114F);
      ((Path)localObject3).cubicTo(13.498634F, 1.202114F, 16.929768F, 4.267744F, 16.929768F, 7.863807F);
      ((Path)localObject3).cubicTo(16.929768F, 7.955468F, 16.927563F, 8.046728F, 16.923155F, 8.137689F);
      ((Path)localObject3).cubicTo(17.023232F, 8.122261F, 17.125813F, 8.114247F, 17.230295F, 8.114247F);
      ((Path)localObject3).cubicTo(17.548655F, 8.114247F, 17.849686F, 8.188478F, 18.117054F, 8.32071F);
      ((Path)localObject3).cubicTo(18.126873F, 8.169644F, 18.131882F, 8.017377F, 18.131882F, 7.863807F);
      ((Path)localObject3).cubicTo(18.131882F, 3.437685F, 13.983287F, 0.0F, 9.065941F, 0.0F);
      ((Path)localObject3).cubicTo(4.148634F, 0.0F, 0.0F, 3.437685F, 0.0F, 7.863807F);
      ((Path)localObject3).cubicTo(0.0F, 10.182283F, 1.152557F, 12.24451F, 2.947202F, 13.668613F);
      ((Path)localObject3).lineTo(2.600282F, 16.002317F);
      ((Path)localObject3).cubicTo(2.515924F, 16.569714F, 3.111541F, 16.992859F, 3.619594F, 16.726389F);
      ((Path)localObject3).lineTo(6.256831F, 15.343258F);
      ((Path)localObject3).cubicTo(7.142418F, 15.592997F, 8.086789F, 15.727633F, 9.065941F, 15.727633F);
      ((Path)localObject3).cubicTo(10.193223F, 15.727633F, 11.280033F, 15.547016F, 12.285802F, 15.215233F);
      ((Path)localObject3).cubicTo(11.979263F, 14.939949F, 11.758074F, 14.571501F, 11.666714F, 14.154468F);
      ((Path)localObject3).cubicTo(10.85699F, 14.394389F, 9.982953F, 14.52552F, 9.065941F, 14.52552F);
      ((Path)localObject3).cubicTo(8.117703F, 14.52552F, 7.210398F, 14.38327F, 6.371162F, 14.123613F);
      ((Path)localObject3).cubicTo(6.219326F, 14.07653F, 6.055047F, 14.091657F, 5.914289F, 14.165487F);
      ((Path)localObject3).lineTo(3.934288F, 15.203913F);
      ((Path)localObject3).lineTo(4.188515F, 13.493706F);
      ((Path)localObject3).cubicTo(4.221433F, 13.272317F, 4.128609F, 13.051027F, 3.947631F, 12.919296F);
      ((Path)localObject3).cubicTo(2.247141F, 11.68202F, 1.202114F, 9.863623F, 1.202114F, 7.863807F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.951071F, 16.569941F);
      ((Path)localObject2).cubicTo(18.391169F, 17.01004F, 18.391186F, 17.723619F, 17.951071F, 18.163734F);
      ((Path)localObject2).cubicTo(17.510956F, 18.603849F, 16.797377F, 18.603834F, 16.357277F, 18.163734F);
      ((Path)localObject2).cubicTo(16.19912F, 18.005577F, 16.097771F, 17.812075F, 16.053288F, 17.608669F);
      ((Path)localObject2).cubicTo(15.807026F, 16.830336F, 15.375353F, 16.098009F, 14.758183F, 15.480839F);
      ((Path)localObject2).cubicTo(14.656234F, 15.37889F, 14.551139F, 15.281998F, 14.443213F, 15.190168F);
      ((Path)localObject2).cubicTo(14.298044F, 15.041972F, 14.298023F, 14.804093F, 14.444727F, 14.657391F);
      ((Path)localObject2).cubicTo(14.59143F, 14.510687F, 14.829309F, 14.510708F, 14.97599F, 14.657391F);
      ((Path)localObject2).cubicTo(15.069334F, 14.763803F, 15.166225F, 14.868897F, 15.268175F, 14.970847F);
      ((Path)localObject2).cubicTo(15.885345F, 15.588017F, 16.617672F, 16.01969F, 17.396006F, 16.265951F);
      ((Path)localObject2).cubicTo(17.599411F, 16.310434F, 17.792913F, 16.411783F, 17.951071F, 16.569941F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.144772F, 10.93854F);
      ((Path)localObject2).cubicTo(16.275175F, 11.068944F, 16.289648F, 11.271387F, 16.188234F, 11.417784F);
      ((Path)localObject2).lineTo(16.144772F, 11.469805F);
      ((Path)localObject2).lineTo(16.146286F, 11.471319F);
      ((Path)localObject2).cubicTo(16.038361F, 11.563148F, 15.933265F, 11.66004F, 15.831315F, 11.76199F);
      ((Path)localObject2).cubicTo(15.214146F, 12.379159F, 14.782473F, 13.111485F, 14.53621F, 13.88982F);
      ((Path)localObject2).cubicTo(14.491728F, 14.093225F, 14.390378F, 14.286727F, 14.232221F, 14.444884F);
      ((Path)localObject2).cubicTo(13.792122F, 14.884984F, 13.078544F, 14.885F, 12.638428F, 14.444884F);
      ((Path)localObject2).cubicTo(12.198313F, 14.004769F, 12.198329F, 13.291191F, 12.638428F, 12.851092F);
      ((Path)localObject2).cubicTo(12.796586F, 12.692935F, 12.990088F, 12.591585F, 13.193493F, 12.547103F);
      ((Path)localObject2).cubicTo(13.971827F, 12.30084F, 14.704153F, 11.869167F, 15.321323F, 11.251997F);
      ((Path)localObject2).cubicTo(15.423272F, 11.150048F, 15.520164F, 11.044953F, 15.611994F, 10.937027F);
      ((Path)localObject2).lineTo(15.613507F, 10.93854F);
      ((Path)localObject2).cubicTo(15.76019F, 10.791859F, 15.998069F, 10.791838F, 16.144772F, 10.93854F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.66992F, 12.851092F);
      ((Path)localObject2).cubicTo(22.110035F, 13.291207F, 22.11002F, 14.004786F, 21.66992F, 14.444884F);
      ((Path)localObject2).cubicTo(21.511763F, 14.603042F, 21.31826F, 14.704391F, 21.114855F, 14.748874F);
      ((Path)localObject2).cubicTo(20.336521F, 14.995136F, 19.604195F, 15.426809F, 18.987024F, 16.04398F);
      ((Path)localObject2).cubicTo(18.885075F, 16.145929F, 18.788183F, 16.251024F, 18.694839F, 16.357435F);
      ((Path)localObject2).cubicTo(18.548159F, 16.504118F, 18.31028F, 16.504139F, 18.163576F, 16.357435F);
      ((Path)localObject2).cubicTo(18.016872F, 16.210732F, 18.016893F, 15.972854F, 18.162062F, 15.824657F);
      ((Path)localObject2).cubicTo(18.269989F, 15.732828F, 18.375082F, 15.635937F, 18.477032F, 15.533987F);
      ((Path)localObject2).cubicTo(19.094202F, 14.916818F, 19.525875F, 14.184491F, 19.772137F, 13.406157F);
      ((Path)localObject2).cubicTo(19.81662F, 13.202752F, 19.917969F, 13.00925F, 20.076126F, 12.851092F);
      ((Path)localObject2).cubicTo(20.516226F, 12.410993F, 21.229805F, 12.410976F, 21.66992F, 12.851092F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.951071F, 9.132242F);
      ((Path)localObject2).cubicTo(18.109228F, 9.2904F, 18.210577F, 9.483902F, 18.25506F, 9.687307F);
      ((Path)localObject2).cubicTo(18.501322F, 10.465641F, 18.932995F, 11.197968F, 19.550165F, 11.815138F);
      ((Path)localObject2).cubicTo(19.652115F, 11.917088F, 19.75721F, 12.013979F, 19.863621F, 12.107322F);
      ((Path)localObject2).cubicTo(20.010303F, 12.254004F, 20.010324F, 12.491883F, 19.863621F, 12.638586F);
      ((Path)localObject2).cubicTo(19.716919F, 12.78529F, 19.479038F, 12.785269F, 19.330843F, 12.6401F);
      ((Path)localObject2).cubicTo(19.239014F, 12.532174F, 19.142122F, 12.427079F, 19.040173F, 12.32513F);
      ((Path)localObject2).cubicTo(18.423002F, 11.70796F, 17.690676F, 11.276287F, 16.912342F, 11.030025F);
      ((Path)localObject2).cubicTo(16.708937F, 10.985541F, 16.515434F, 10.884192F, 16.357277F, 10.726035F);
      ((Path)localObject2).cubicTo(15.917178F, 10.285936F, 15.917162F, 9.572358F, 16.357277F, 9.132242F);
      ((Path)localObject2).cubicTo(16.797392F, 8.692127F, 17.510971F, 8.692143F, 17.951071F, 9.132242F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_channels_enterprise_wechat
 * JD-Core Version:    0.7.0.1
 */