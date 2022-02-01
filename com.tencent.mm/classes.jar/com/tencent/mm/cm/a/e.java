package com.tencent.mm.cm.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends g
{
  private int RfA;
  private int RfB;
  
  public e()
  {
    super("varying mediump vec2 textureCoordinate;\nvarying mediump vec2 textureCoordinate2;\nvarying mediump vec2 textureCoordinate3;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform mediump int srfControl;\nuniform mediump int srfSwitch;\nvoid main()\n{\nmediump vec4 motionMask = texture2D(inputImageTexture3, textureCoordinate3);\nmediump vec4 curFrame = texture2D(inputImageTexture, textureCoordinate);\nmediump vec4 preFrame = texture2D(inputImageTexture2,textureCoordinate2);\nmediump vec4 smoothFrame;\nif(srfSwitch == 1){\ngl_FragColor = curFrame;\n} else {\nsmoothFrame = preFrame * (1.0 - motionMask.r) + curFrame * motionMask.r;\ngl_FragColor = smoothFrame;\n}\n}\n");
  }
  
  public final void MC()
  {
    AppMethodBeat.i(190238);
    super.MC();
    this.RfB = GLES20.glGetUniformLocation(hfa(), "srfSwitch");
    this.RfA = 1;
    apJ(this.RfA);
    AppMethodBeat.o(190238);
  }
  
  public final void apJ(int paramInt)
  {
    AppMethodBeat.i(190239);
    this.RfA = paramInt;
    lT(this.RfB, paramInt);
    AppMethodBeat.o(190239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cm.a.e
 * JD-Core Version:    0.7.0.1
 */