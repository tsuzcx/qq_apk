package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;

public class x
  extends BaseFilter
{
  private float alpha = 0.0F;
  
  public x()
  {
    super("varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform lowp float alpha;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\nnewColor = mix(newColor, textureColor, alpha);\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n");
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new m.f("filterAdjustParam", this.alpha));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.alpha = paramFloat;
    addParam(new m.f("filterAdjustParam", this.alpha));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.x
 * JD-Core Version:    0.7.0.1
 */