package com.tencent.filter.a;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j
  extends BaseFilter
{
  private static String bxs = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float debug;\n uniform float inner;\n uniform float outer;\n uniform vec2 ellipse;\n uniform vec2 center;\n uniform vec3 line1;\n uniform vec3 line2;\n void main() {\n     vec4 original = texture2D(inputImageTexture2, textureCoordinate);\n     float fx = (textureCoordinate.x - center.x);\n     float fy = (textureCoordinate.y - center.y);\n     float dist = sqrt(fx * fx * ellipse.x + fy * fy * ellipse.y);\n     if (dist < inner) {\n         gl_FragColor = original;\n     } else {\n         vec3 point = vec3(textureCoordinate.x, textureCoordinate.y, 1.0);\n         float value1 = dot(line1, point);\n         float value2 = dot(line2, point);\n         if (value1 >= 0.0 && value2 >= 0.0) {\n             gl_FragColor = original;\n         } else {\n             vec4 blur = vec4(1.0, 0.0, 0.0, 1.0);\n             if (debug == 0.0) {\n                 blur = texture2D(inputImageTexture, textureCoordinate);\n             }\n             float lineAlpha = max(-value1 / 0.15, -value2 / 0.15);\n             float alpha = (dist - inner)/outer;\n             alpha = min(lineAlpha, alpha);\n             alpha = clamp(alpha, 0.0, 1.0);\n             gl_FragColor = mix(original, blur, alpha);\n         }\n     }\n }\n";
  private float angle;
  int arA;
  int arz;
  private float bxt;
  private boolean bxu;
  private float bxv;
  private BaseFilter bxw;
  private PointF center;
  private BaseFilter horizontal;
  private float radius;
  private BaseFilter vertical;
  
  public j()
  {
    super(GLSLRender.btg);
    AppMethodBeat.i(86443);
    this.center = new PointF(0.5F, 0.5F);
    this.radius = 0.35F;
    this.bxt = 1.333333F;
    this.angle = 0.0F;
    this.bxu = false;
    this.bxv = 0.0F;
    this.horizontal = null;
    this.vertical = null;
    this.bxw = null;
    AppMethodBeat.o(86443);
  }
  
  private void X(float paramFloat)
  {
    AppMethodBeat.i(86445);
    paramFloat = (float)(paramFloat / 180.0F * 3.141592653589793D);
    float[][] arrayOfFloat = new float[3][];
    arrayOfFloat[0] = { (float)Math.cos(paramFloat), (float)Math.sin(paramFloat), 0.0F };
    arrayOfFloat[1] = { -(float)Math.sin(paramFloat), (float)Math.cos(paramFloat), 0.0F };
    arrayOfFloat[2] = { 0.0F, 0.0F, 1.0F };
    float f1 = 0.9F;
    paramFloat = 1.5F;
    if (this.bxu)
    {
      f1 = 1.0F;
      paramFloat = 1.0F;
    }
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = (1.0F / (f1 * f1));
    arrayOfFloat1[1] = (1.0F / (paramFloat * paramFloat));
    float[] arrayOfFloat2 = new float[2];
    float[] tmp147_145 = arrayOfFloat2;
    tmp147_145[0] = 0.0F;
    float[] tmp151_147 = tmp147_145;
    tmp151_147[1] = 0.0F;
    tmp151_147;
    arrayOfFloat2[0] = (arrayOfFloat1[0] * arrayOfFloat[0][0] + arrayOfFloat1[1] * arrayOfFloat[0][1]);
    arrayOfFloat2[1] = (arrayOfFloat1[0] * arrayOfFloat[1][0] + arrayOfFloat1[1] * arrayOfFloat[1][1]);
    arrayOfFloat2[0] = Math.abs(arrayOfFloat2[0]);
    arrayOfFloat2[1] = (Math.abs(arrayOfFloat2[1]) * this.bxt * this.bxt);
    if (this.bxw != null) {
      this.bxw.addParam(new m.g("ellipse", arrayOfFloat2));
    }
    float[] arrayOfFloat3 = new float[3];
    float[] tmp275_273 = arrayOfFloat3;
    tmp275_273[0] = -0.3F;
    float[] tmp280_275 = tmp275_273;
    tmp280_275[1] = 1.0F;
    float[] tmp284_280 = tmp280_275;
    tmp284_280[2] = 0.0F;
    tmp284_280;
    arrayOfFloat1 = new float[3];
    float[] tmp296_294 = arrayOfFloat1;
    tmp296_294[0] = 0.3F;
    float[] tmp301_296 = tmp296_294;
    tmp301_296[1] = 1.0F;
    float[] tmp305_301 = tmp301_296;
    tmp305_301[2] = 0.0F;
    tmp305_301;
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
    arrayOfFloat2[2] = (-(arrayOfFloat2[0] * this.center.x + arrayOfFloat2[1] * this.center.y));
    arrayOfFloat3[2] = (-(arrayOfFloat3[0] * this.center.x + arrayOfFloat3[1] * this.center.y));
    if (this.bxu)
    {
      arrayOfFloat2[0] = 0.0F;
      arrayOfFloat2[1] = 0.0F;
      arrayOfFloat2[2] = -0.15F;
      arrayOfFloat3[0] = 0.0F;
      arrayOfFloat3[1] = 0.0F;
      arrayOfFloat3[2] = -0.15F;
    }
    if (this.bxw != null)
    {
      this.bxw.addParam(new m.g("line1", arrayOfFloat2));
      this.bxw.addParam(new m.g("line2", arrayOfFloat3));
    }
    paramFloat = this.center.x;
    f1 = this.center.y;
    if (this.bxw != null) {
      this.bxw.addParam(new m.g("center", new float[] { paramFloat, f1 }));
    }
    AppMethodBeat.o(86445);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86446);
    this.arz = ((int)paramFloat1);
    this.arA = ((int)paramFloat2);
    this.bxt = (paramFloat2 / paramFloat1);
    float f = Math.round(0.008333334F * paramFloat1);
    int i = 0;
    if (f >= 1.0F)
    {
      i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.00390625D * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
      i += i % 2;
    }
    this.horizontal = new BaseFilter(aj.b(i, f, true));
    this.vertical = new BaseFilter(aj.b(i, f, false));
    this.bxw = new BaseFilter(bxs);
    setNextFilter(this.horizontal, null);
    this.horizontal.setNextFilter(this.vertical, null);
    this.vertical.setNextFilter(this.bxw, new int[] { this.srcTextureIndex });
    this.bxw.addParam(new m.f("debug", this.bxv));
    this.bxw.addParam(new m.f("outer", 0.12F));
    this.bxw.addParam(new m.f("inner", this.radius));
    X(this.angle);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86446);
  }
  
  public final void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86447);
    if ((this.arz != paramInt2) || (this.arA != paramInt3))
    {
      this.arz = paramInt2;
      this.arA = paramInt3;
      float f = Math.round(0.008333334F * paramInt2);
      paramInt1 = 0;
      if (f >= 1.0F)
      {
        paramInt1 = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.00390625D * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
        paramInt1 += paramInt1 % 2;
      }
      this.horizontal.updateFragmentShader(aj.b(paramInt1, f, true));
      this.horizontal.clearGLSLSelf();
      this.horizontal.ApplyGLSLFilter();
      this.vertical.updateFragmentShader(aj.b(paramInt1, f, false));
      this.vertical.clearGLSLSelf();
      this.vertical.ApplyGLSLFilter();
      X(this.angle);
    }
    AppMethodBeat.o(86447);
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86444);
    if (paramMap.containsKey("circle")) {
      this.bxu = ((Boolean)paramMap.get("circle")).booleanValue();
    }
    if (paramMap.containsKey("debug"))
    {
      this.bxv = ((Float)paramMap.get("debug")).floatValue();
      if (this.bxw != null) {
        this.bxw.addParam(new m.f("debug", this.bxv));
      }
    }
    if (paramMap.containsKey("tx")) {
      this.center.x = ((Float)paramMap.get("tx")).floatValue();
    }
    if (paramMap.containsKey("ty")) {
      this.center.y = ((Float)paramMap.get("ty")).floatValue();
    }
    if (paramMap.containsKey("ratio")) {
      this.bxt = ((Float)paramMap.get("ratio")).floatValue();
    }
    if (paramMap.containsKey("radius"))
    {
      this.radius = ((Float)paramMap.get("radius")).floatValue();
      if (this.bxw != null) {
        this.bxw.addParam(new m.f("inner", this.radius));
      }
    }
    if (paramMap.containsKey("angle")) {
      this.angle = ((Float)paramMap.get("angle")).floatValue();
    }
    X(this.angle);
    AppMethodBeat.o(86444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.a.j
 * JD-Core Version:    0.7.0.1
 */