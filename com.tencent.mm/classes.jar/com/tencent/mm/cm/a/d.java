package com.tencent.mm.cm.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends f
{
  private int agCc;
  private int agCd;
  
  public d()
  {
    super("varying mediump vec2 textureCoordinate;\nvarying mediump vec2 textureCoordinate2;\nvarying mediump vec2 textureCoordinate3;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform mediump int srfControl;\nuniform mediump int srfSwitch;\nvoid main()\n{\nmediump vec4 motionMask = texture2D(inputImageTexture3, textureCoordinate3);\nmediump vec4 curFrame = texture2D(inputImageTexture, textureCoordinate);\nmediump vec4 preFrame = texture2D(inputImageTexture2,textureCoordinate2);\nmediump vec4 smoothFrame;\nif(srfSwitch == 1){\ngl_FragColor = curFrame;\n} else {\nsmoothFrame = preFrame * (1.0 - motionMask.r) + curFrame * motionMask.r;\ngl_FragColor = smoothFrame;\n}\n}\n");
  }
  
  public final void aFM(int paramInt)
  {
    AppMethodBeat.i(231119);
    this.agCc = paramInt;
    ph(this.agCd, paramInt);
    AppMethodBeat.o(231119);
  }
  
  public final void apC()
  {
    AppMethodBeat.i(231117);
    super.apC();
    this.agCd = GLES20.glGetUniformLocation(jLG(), "srfSwitch");
    this.agCc = 1;
    aFM(this.agCc);
    AppMethodBeat.o(231117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.d
 * JD-Core Version:    0.7.0.1
 */