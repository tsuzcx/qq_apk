package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class q
  extends g
{
  private static String v = "GPUSharpen";
  private int r;
  private float s;
  private int t;
  private int u;
  
  public q()
  {
    this(0.0F);
  }
  
  public q(float paramFloat)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float imageWidthFactor; \nuniform float imageHeightFactor; \n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate; \nvarying vec2 topTextureCoordinate;\nvarying vec2 bottomTextureCoordinate;\n\n\nvoid main()\n{\n    gl_Position = position;\n    \n    mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n    mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n    topTextureCoordinate = inputTextureCoordinate.xy + heightStep;     \n    bottomTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n}\n", "precision mediump float;\n\nuniform float sharpness;\nvarying mediump vec2 textureCoordinate;\nvarying mediump vec2 leftTextureCoordinate;\nvarying mediump vec2 rightTextureCoordinate; \nvarying mediump vec2 topTextureCoordinate;\nvarying mediump vec2 bottomTextureCoordinate;\n\nuniform sampler2D inputImageTexture;\nfloat centerMultiplier;\nfloat edgeMultiplier;\n\nvoid main()\n{\n    mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n\n    centerMultiplier = 1.0 + 4.0 * sharpness * (1.0 - textureColor.a);\n    edgeMultiplier = sharpness * (1.0 - textureColor.a);\n    gl_FragColor = vec4((textureColor.rgb * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), textureColor.a);    \n}\n");
    this.s = paramFloat;
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(146360);
    this.s = paramFloat;
    TXCLog.i(v, "set Sharpness ".concat(String.valueOf(paramFloat)));
    a(this.r, this.s);
    AppMethodBeat.o(146360);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66999);
    super.a(paramInt1, paramInt2);
    a(this.t, 1.0F / paramInt1);
    a(this.u, 1.0F / paramInt2);
    AppMethodBeat.o(66999);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(66996);
    boolean bool = super.b();
    this.r = GLES20.glGetUniformLocation(p(), "sharpness");
    this.t = GLES20.glGetUniformLocation(p(), "imageWidthFactor");
    this.u = GLES20.glGetUniformLocation(p(), "imageHeightFactor");
    a(this.s);
    AppMethodBeat.o(66996);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.q
 * JD-Core Version:    0.7.0.1
 */