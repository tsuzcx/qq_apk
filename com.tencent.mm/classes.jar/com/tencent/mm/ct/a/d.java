package com.tencent.mm.ct.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends f
{
  private int YGv;
  private int YGw;
  
  public d()
  {
    super("varying mediump vec2 textureCoordinate;\nvarying mediump vec2 textureCoordinate2;\nvarying mediump vec2 textureCoordinate3;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform mediump int srfControl;\nuniform mediump int srfSwitch;\nvoid main()\n{\nmediump vec4 motionMask = texture2D(inputImageTexture3, textureCoordinate3);\nmediump vec4 curFrame = texture2D(inputImageTexture, textureCoordinate);\nmediump vec4 preFrame = texture2D(inputImageTexture2,textureCoordinate2);\nmediump vec4 smoothFrame;\nif(srfSwitch == 1){\ngl_FragColor = curFrame;\n} else {\nsmoothFrame = preFrame * (1.0 - motionMask.r) + curFrame * motionMask.r;\ngl_FragColor = smoothFrame;\n}\n}\n");
  }
  
  public final void Pu()
  {
    AppMethodBeat.i(188042);
    super.Pu();
    this.YGw = GLES20.glGetUniformLocation(igt(), "srfSwitch");
    this.YGv = 1;
    azi(this.YGv);
    AppMethodBeat.o(188042);
  }
  
  public final void azi(int paramInt)
  {
    AppMethodBeat.i(188043);
    this.YGv = paramInt;
    nk(this.YGw, paramInt);
    AppMethodBeat.o(188043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.d
 * JD-Core Version:    0.7.0.1
 */