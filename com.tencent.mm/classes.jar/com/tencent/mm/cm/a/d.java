package com.tencent.mm.cm.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends h
{
  private float HkW;
  private int Rfv;
  private int Rfw;
  private int Rfx;
  private int Rfy;
  private int Rfz;
  
  public d()
  {
    super("varying mediump vec2 textureCoordinate;\nvarying mediump vec2 textureCoordinate2;\n \n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform mediump int mvControl;\nuniform mediump int mvSwitch;\nuniform mediump float noiseLevel;\nconst mediump float thresholdChroma = 0.015;\nconst mediump float belta = -0.06 ;\n \nconst mediump mat3 RGBtoYUV = mat3(0.299,  0.587, 0.114, 0.5, -0.4187, -0.0813, -0.169, -0.3313,  0.5 );\nmediump vec3 rgb2yuv(mediump vec3 c)\n{\nmediump vec3 yuv = c*RGBtoYUV;\nreturn yuv;\n}\n \nvoid main()\n{\nmediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nmediump vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\nmediump vec3 yuvCurFrame;\nmediump vec3 yuvPreFrame;\nmediump float thresholdLuma;\nif(mvControl == 1 || mvSwitch == 0) {\ngl_FragColor = textureColor;\n} else {\nyuvCurFrame = rgb2yuv(textureColor.rgb);\nyuvPreFrame = rgb2yuv(textureColor2.rgb);\n \nmediump float motionMask = 1.0;\nmediump float lumaDiff = abs(yuvCurFrame.r - yuvPreFrame.r);\nmediump float cbDiff = abs(yuvCurFrame.g - yuvPreFrame.g);\nmediump float crDiff = abs(yuvCurFrame.b - yuvPreFrame.b);\n \nif(yuvCurFrame.r > 0.40 ) {\nthresholdLuma = noiseLevel; \n} else {\nthresholdLuma = noiseLevel * 1.5; \n}\n \nif( lumaDiff >= thresholdLuma ) {\nmotionMask = 1.0;\n} else {\nmotionMask = 1.0 - exp(lumaDiff / belta);\n}\n \nif(cbDiff > thresholdChroma ||cbDiff > thresholdChroma ) {\nmotionMask = 1.0;\n}\ngl_FragColor =  vec4(motionMask)  ;\n}\n}");
  }
  
  public final void MC()
  {
    AppMethodBeat.i(190235);
    super.MC();
    this.Rfx = GLES20.glGetUniformLocation(hfa(), "mvControl");
    this.Rfy = GLES20.glGetUniformLocation(hfa(), "mvSwitch");
    this.Rfz = GLES20.glGetUniformLocation(hfa(), "noiseLevel");
    this.Rfv = 0;
    this.Rfw = 1;
    this.HkW = 0.05F;
    apI(this.Rfv);
    int i = this.Rfw;
    this.Rfw = i;
    lT(this.Rfy, i);
    cH(this.HkW);
    AppMethodBeat.o(190235);
  }
  
  public final void apI(int paramInt)
  {
    AppMethodBeat.i(190236);
    this.Rfv = paramInt;
    lT(this.Rfx, paramInt);
    AppMethodBeat.o(190236);
  }
  
  public final void cH(float paramFloat)
  {
    AppMethodBeat.i(190237);
    this.HkW = paramFloat;
    setFloat(this.Rfz, paramFloat);
    AppMethodBeat.o(190237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cm.a.d
 * JD-Core Version:    0.7.0.1
 */