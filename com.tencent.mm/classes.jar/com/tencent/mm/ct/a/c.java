package com.tencent.mm.ct.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends g
{
  private float ObL;
  private int YGo;
  private int YGp;
  private int YGq;
  private int YGr;
  private int YGs;
  private int YGt;
  private int YGu;
  
  public c()
  {
    super("varying mediump vec2 textureCoordinate;\nvarying mediump vec2 textureCoordinate2;\n \n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform mediump int mvControl;\nuniform mediump int mvSwitch;\nuniform mediump float noiseLevel;\nuniform mediump float texelWidth;\nuniform mediump float texelHeight;\nconst mediump float thresholdChroma = 0.012;\nconst mediump float belta = -0.06 ;\n \nconst mediump mat3 RGBtoYUV = mat3(0.299,  0.587, 0.114, 0.5, -0.4187, -0.0813, -0.169, -0.3313,  0.5 );\nmediump vec3 rgb2yuv(mediump vec3 c)\n{\nmediump vec3 yuv = c*RGBtoYUV;\nreturn yuv;\n}\nmediump vec4 Sobel()\n{\n    mediump vec2 samplerSteps = vec2(1.0/texelWidth, 1.0/texelHeight);\n    mediump vec2 coords[8];\n    coords[0] = textureCoordinate - samplerSteps * 2.0;\n    coords[1] = textureCoordinate + vec2(0.0, -samplerSteps.y) * 2.0;\n    coords[2] = textureCoordinate + vec2(samplerSteps.x, -samplerSteps.y) * 2.0;\n\n    coords[3] = textureCoordinate - vec2(samplerSteps.x, 0.0) * 2.0;\n    coords[4] = textureCoordinate + vec2(samplerSteps.x, 0.0) * 2.0;\n\n    coords[5] = textureCoordinate + vec2(-samplerSteps.x, samplerSteps.y) * 2.0;\n    coords[6] = textureCoordinate + vec2(0.0, samplerSteps.y) * 2.0;\n    coords[7] = textureCoordinate + vec2(samplerSteps.x, samplerSteps.y) * 2.0;\n\n    mediump vec3 colors[8];\n    for(int i = 0; i < 8; ++i)\n    {\n        colors[i] = texture2D(inputImageTexture, coords[i]).rgb;\n    }\n\n    mediump vec4 src = texture2D(inputImageTexture, textureCoordinate);\n    mediump vec3 h = -colors[0] - 2.0 * colors[1] - colors[2] + colors[5] + 2.0 * colors[6] + colors[7];\n    mediump vec3 v = -colors[0] + colors[2] - 2.0 * colors[3] + 2.0 * colors[4] - colors[5] + colors[7];\n    return vec4(sqrt(h * h + v * v) * 1.2 , src.a);\n}\n \nvoid main()\n{\nmediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nmediump vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\nmediump vec3 yuvCurFrame;\nmediump vec3 yuvPreFrame;\nmediump float thresholdLuma;\nif(mvControl == 1 || mvSwitch == 0) {\ngl_FragColor = textureColor;\n} else {\nyuvCurFrame = rgb2yuv(textureColor.rgb);\nyuvPreFrame = rgb2yuv(textureColor2.rgb);\n \nmediump float motionMask = 1.0;\nmediump float lumaDiff = abs(yuvCurFrame.r - yuvPreFrame.r);\nmediump float cbDiff = abs(yuvCurFrame.g - yuvPreFrame.g);\nmediump float crDiff = abs(yuvCurFrame.b - yuvPreFrame.b);\nmediump vec4 sobleImage  = Sobel();\n \nif(yuvCurFrame.r > 0.40 ) {\nthresholdLuma = noiseLevel * 1.0; \n} else {\nthresholdLuma = noiseLevel * 1.2; \n}\n \nif( lumaDiff >= thresholdLuma || sobleImage.r > 0.9 || sobleImage.g > 0.9 || sobleImage.b > 0.9) {\nmotionMask = 1.0;\n} else {\nmotionMask = 1.0 - exp(lumaDiff / belta);\n}\n \nif(cbDiff > thresholdChroma || cbDiff > thresholdChroma ) {\nmotionMask = 1.0;\n}\ngl_FragColor = vec4(motionMask) ;\n}\n}");
  }
  
  public final void Pu()
  {
    AppMethodBeat.i(188019);
    super.Pu();
    this.YGq = GLES20.glGetUniformLocation(igt(), "mvControl");
    this.YGr = GLES20.glGetUniformLocation(igt(), "mvSwitch");
    this.YGs = GLES20.glGetUniformLocation(igt(), "noiseLevel");
    this.YGt = GLES20.glGetUniformLocation(igt(), "texelWidth");
    this.YGu = GLES20.glGetUniformLocation(igt(), "texelHeight");
    this.YGo = 0;
    this.YGp = 1;
    this.ObL = 0.05F;
    azh(this.YGo);
    int i = this.YGp;
    this.YGp = i;
    nk(this.YGr, i);
    dc(this.ObL);
    AppMethodBeat.o(188019);
  }
  
  public final void azh(int paramInt)
  {
    AppMethodBeat.i(188022);
    this.YGo = paramInt;
    nk(this.YGq, paramInt);
    AppMethodBeat.o(188022);
  }
  
  public final void dc(float paramFloat)
  {
    AppMethodBeat.i(188026);
    this.ObL = paramFloat;
    setFloat(this.YGs, paramFloat);
    AppMethodBeat.o(188026);
  }
  
  public final void nl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188034);
    setFloat(this.YGt, paramInt1);
    setFloat(this.YGu, paramInt2);
    AppMethodBeat.o(188034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.c
 * JD-Core Version:    0.7.0.1
 */