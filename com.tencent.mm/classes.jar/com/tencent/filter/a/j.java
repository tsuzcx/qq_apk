package com.tencent.filter.a;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import java.util.Map;

public final class j
  extends BaseFilter
{
  private static String bgR = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float debug;\n uniform float inner;\n uniform float outer;\n uniform vec2 ellipse;\n uniform vec2 center;\n uniform vec3 line1;\n uniform vec3 line2;\n void main() {\n     vec4 original = texture2D(inputImageTexture2, textureCoordinate);\n     float fx = (textureCoordinate.x - center.x);\n     float fy = (textureCoordinate.y - center.y);\n     float dist = sqrt(fx * fx * ellipse.x + fy * fy * ellipse.y);\n     if (dist < inner) {\n         gl_FragColor = original;\n     } else {\n         vec3 point = vec3(textureCoordinate.x, textureCoordinate.y, 1.0);\n         float value1 = dot(line1, point);\n         float value2 = dot(line2, point);\n         if (value1 >= 0.0 && value2 >= 0.0) {\n             gl_FragColor = original;\n         } else {\n             vec4 blur = vec4(1.0, 0.0, 0.0, 1.0);\n             if (debug == 0.0) {\n                 blur = texture2D(inputImageTexture, textureCoordinate);\n             }\n             float lineAlpha = max(-value1 / 0.15, -value2 / 0.15);\n             float alpha = (dist - inner)/outer;\n             alpha = min(lineAlpha, alpha);\n             alpha = clamp(alpha, 0.0, 1.0);\n             gl_FragColor = mix(original, blur, alpha);\n         }\n     }\n }\n";
  int apf;
  int apg;
  private PointF bgS = new PointF(0.5F, 0.5F);
  private float bgT = 1.333333F;
  private float bgU = 0.0F;
  private boolean bgV = false;
  private float bgW = 0.0F;
  private BaseFilter bgX = null;
  private BaseFilter horizontal = null;
  private float radius = 0.35F;
  private BaseFilter vertical = null;
  
  public j()
  {
    super(GLSLRender.bcE);
  }
  
  private void X(float paramFloat)
  {
    paramFloat = (float)(paramFloat / 180.0F * 3.141592653589793D);
    float[][] arrayOfFloat = new float[3][];
    arrayOfFloat[0] = { (float)Math.cos(paramFloat), (float)Math.sin(paramFloat), 0.0F };
    arrayOfFloat[1] = { -(float)Math.sin(paramFloat), (float)Math.cos(paramFloat), 0.0F };
    arrayOfFloat[2] = { 0.0F, 0.0F, 1.0F };
    float f1 = 0.9F;
    paramFloat = 1.5F;
    if (this.bgV)
    {
      f1 = 1.0F;
      paramFloat = 1.0F;
    }
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = (1.0F / (f1 * f1));
    arrayOfFloat1[1] = (1.0F / (paramFloat * paramFloat));
    float[] arrayOfFloat2 = new float[2];
    float[] tmp142_140 = arrayOfFloat2;
    tmp142_140[0] = 0.0F;
    float[] tmp146_142 = tmp142_140;
    tmp146_142[1] = 0.0F;
    tmp146_142;
    arrayOfFloat2[0] = (arrayOfFloat1[0] * arrayOfFloat[0][0] + arrayOfFloat1[1] * arrayOfFloat[0][1]);
    arrayOfFloat2[1] = (arrayOfFloat1[0] * arrayOfFloat[1][0] + arrayOfFloat1[1] * arrayOfFloat[1][1]);
    arrayOfFloat2[0] = Math.abs(arrayOfFloat2[0]);
    arrayOfFloat2[1] = (Math.abs(arrayOfFloat2[1]) * this.bgT * this.bgT);
    if (this.bgX != null) {
      this.bgX.addParam(new m.g("ellipse", arrayOfFloat2));
    }
    float[] arrayOfFloat3 = new float[3];
    float[] tmp270_268 = arrayOfFloat3;
    tmp270_268[0] = -0.3F;
    float[] tmp275_270 = tmp270_268;
    tmp275_270[1] = 1.0F;
    float[] tmp279_275 = tmp275_270;
    tmp279_275[2] = 0.0F;
    tmp279_275;
    arrayOfFloat1 = new float[3];
    float[] tmp291_289 = arrayOfFloat1;
    tmp291_289[0] = 0.3F;
    float[] tmp296_291 = tmp291_289;
    tmp296_291[1] = 1.0F;
    float[] tmp300_296 = tmp296_291;
    tmp300_296[2] = 0.0F;
    tmp300_296;
    arrayOfFloat2 = new float[3];
    arrayOfFloat2[0] = (arrayOfFloat3[0] * arrayOfFloat[0][0] + arrayOfFloat3[1] * arrayOfFloat[0][1] + arrayOfFloat3[2] * arrayOfFloat[0][2]);
    arrayOfFloat2[1] = (arrayOfFloat3[0] * arrayOfFloat[1][0] + arrayOfFloat3[1] * arrayOfFloat[1][1] + arrayOfFloat3[2] * arrayOfFloat[1][2]);
    paramFloat = arrayOfFloat3[0];
    f1 = arrayOfFloat[2][0];
    float f2 = arrayOfFloat3[1];
    float f3 = arrayOfFloat[2][1];
    arrayOfFloat2[2] = (arrayOfFloat3[2] * arrayOfFloat[2][2] + (paramFloat * f1 + f2 * f3));
    arrayOfFloat3 = new float[3];
    arrayOfFloat3[0] = (arrayOfFloat1[0] * arrayOfFloat[0][0] + arrayOfFloat1[1] * arrayOfFloat[0][1] + arrayOfFloat1[2] * arrayOfFloat[0][2]);
    arrayOfFloat3[1] = (arrayOfFloat1[0] * arrayOfFloat[1][0] + arrayOfFloat1[1] * arrayOfFloat[1][1] + arrayOfFloat1[2] * arrayOfFloat[1][2]);
    paramFloat = arrayOfFloat1[0];
    f1 = arrayOfFloat[2][0];
    f2 = arrayOfFloat1[1];
    f3 = arrayOfFloat[2][1];
    arrayOfFloat3[2] = (arrayOfFloat1[2] * arrayOfFloat[2][2] + (paramFloat * f1 + f2 * f3));
    arrayOfFloat2[2] = (-(arrayOfFloat2[0] * this.bgS.x + arrayOfFloat2[1] * this.bgS.y));
    arrayOfFloat3[2] = (-(arrayOfFloat3[0] * this.bgS.x + arrayOfFloat3[1] * this.bgS.y));
    if (this.bgV)
    {
      arrayOfFloat2[0] = 0.0F;
      arrayOfFloat2[1] = 0.0F;
      arrayOfFloat2[2] = -0.15F;
      arrayOfFloat3[0] = 0.0F;
      arrayOfFloat3[1] = 0.0F;
      arrayOfFloat3[2] = -0.15F;
    }
    if (this.bgX != null)
    {
      this.bgX.addParam(new m.g("line1", arrayOfFloat2));
      this.bgX.addParam(new m.g("line2", arrayOfFloat3));
    }
    paramFloat = this.bgS.x;
    f1 = this.bgS.y;
    if (this.bgX != null) {
      this.bgX.addParam(new m.g("center", new float[] { paramFloat, f1 }));
    }
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.apf = ((int)paramFloat1);
    this.apg = ((int)paramFloat2);
    this.bgT = (paramFloat2 / paramFloat1);
    float f = Math.round(0.008333334F * paramFloat1);
    int i = 0;
    if (f >= 1.0F)
    {
      i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.00390625D * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
      i += i % 2;
    }
    this.horizontal = new BaseFilter(ae.b(i, f, true));
    this.vertical = new BaseFilter(ae.b(i, f, false));
    this.bgX = new BaseFilter(bgR);
    setNextFilter(this.horizontal, null);
    this.horizontal.setNextFilter(this.vertical, null);
    this.vertical.setNextFilter(this.bgX, new int[] { this.srcTextureIndex });
    this.bgX.addParam(new m.f("debug", this.bgW));
    this.bgX.addParam(new m.f("outer", 0.12F));
    this.bgX.addParam(new m.f("inner", this.radius));
    X(this.bgU);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.apf != paramInt2) || (this.apg != paramInt3))
    {
      this.apf = paramInt2;
      this.apg = paramInt3;
      float f = Math.round(0.008333334F * paramInt2);
      paramInt1 = 0;
      if (f >= 1.0F)
      {
        paramInt1 = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.00390625D * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
        paramInt1 += paramInt1 % 2;
      }
      this.horizontal.updateFragmentShader(ae.b(paramInt1, f, true));
      this.horizontal.clearGLSLSelf();
      this.horizontal.ApplyGLSLFilter();
      this.vertical.updateFragmentShader(ae.b(paramInt1, f, false));
      this.vertical.clearGLSLSelf();
      this.vertical.ApplyGLSLFilter();
      X(this.bgU);
    }
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("circle")) {
      this.bgV = ((Boolean)paramMap.get("circle")).booleanValue();
    }
    if (paramMap.containsKey("debug"))
    {
      this.bgW = ((Float)paramMap.get("debug")).floatValue();
      if (this.bgX != null) {
        this.bgX.addParam(new m.f("debug", this.bgW));
      }
    }
    if (paramMap.containsKey("tx")) {
      this.bgS.x = ((Float)paramMap.get("tx")).floatValue();
    }
    if (paramMap.containsKey("ty")) {
      this.bgS.y = ((Float)paramMap.get("ty")).floatValue();
    }
    if (paramMap.containsKey("ratio")) {
      this.bgT = ((Float)paramMap.get("ratio")).floatValue();
    }
    if (paramMap.containsKey("radius"))
    {
      this.radius = ((Float)paramMap.get("radius")).floatValue();
      if (this.bgX != null) {
        this.bgX.addParam(new m.f("inner", this.radius));
      }
    }
    if (paramMap.containsKey("angle")) {
      this.bgU = ((Float)paramMap.get("angle")).floatValue();
    }
    X(this.bgU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.a.j
 * JD-Core Version:    0.7.0.1
 */