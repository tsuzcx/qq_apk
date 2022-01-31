package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class d
  extends BaseFilter
{
  private BaseFilter bxl;
  private d.a bxm;
  private d.a bxn;
  float[] bxo;
  float bxp;
  private final int[] curve_static;
  private final int[] meitu_whiten;
  float opttype;
  float radius;
  float scale;
  float skinFilter;
  float whitenmag;
  
  public d()
  {
    super(GLSLRender.bvz);
    AppMethodBeat.i(86434);
    this.curve_static = new int[] { 0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 47, 49, 50, 52, 53, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 80, 82, 83, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 100, 101, 102, 104, 105, 106, 108, 109, 110, 112, 113, 114, 116, 117, 118, 119, 121, 122, 123, 125, 126, 127, 128, 130, 131, 132, 133, 134, 136, 137, 138, 139, 140, 142, 143, 144, 145, 146, 147, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 181, 182, 183, 184, 185, 186, 187, 188, 188, 189, 190, 191, 192, 193, 193, 194, 195, 196, 197, 197, 198, 199, 200, 201, 201, 202, 203, 204, 204, 205, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 219, 219, 220, 221, 221, 222, 222, 223, 224, 224, 225, 226, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 232, 233, 234, 234, 235, 235, 236, 236, 237, 237, 238, 238, 239, 240, 240, 241, 241, 242, 242, 243, 243, 244, 244, 245, 245, 246, 246, 247, 247, 248, 248, 249, 249, 250, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255 };
    this.meitu_whiten = new int[] { 0, 1, 3, 4, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 28, 29, 31, 33, 34, 36, 38, 39, 41, 42, 44, 46, 47, 49, 51, 52, 54, 55, 57, 59, 60, 62, 64, 65, 67, 68, 70, 71, 73, 75, 76, 78, 79, 81, 82, 84, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, 117, 119, 120, 121, 123, 124, 126, 127, 128, 130, 131, 133, 134, 135, 137, 138, 139, 141, 142, 143, 145, 146, 147, 149, 150, 151, 152, 154, 155, 156, 157, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 186, 187, 188, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 208, 209, 210, 211, 211, 212, 213, 214, 214, 215, 216, 216, 217, 218, 218, 219, 219, 220, 221, 221, 222, 223, 223, 224, 224, 225, 225, 226, 226, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, 233, 233, 234, 234, 234, 235, 235, 236, 236, 237, 237, 237, 238, 238, 239, 239, 240, 240, 240, 241, 241, 241, 242, 242, 243, 243, 243, 244, 244, 244, 245, 245, 245, 246, 246, 246, 247, 247, 247, 248, 248, 248, 249, 249, 249, 250, 250, 250, 251, 251, 251, 252, 252, 252, 253, 253, 253, 254, 254, 254, 255 };
    this.bxl = null;
    this.bxm = null;
    this.bxn = null;
    this.radius = 0.5F;
    this.whitenmag = 0.0F;
    this.opttype = 1.0F;
    this.scale = 1.0F;
    this.bxo = new float[7];
    this.skinFilter = 1.0F;
    this.bxp = 0.3F;
    setRadius(1.0F);
    AppMethodBeat.o(86434);
  }
  
  private void setRadius(float paramFloat)
  {
    AppMethodBeat.i(86436);
    this.radius = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    this.radius = this.radius;
    if (this.bxn != null)
    {
      this.bxm.W(this.radius);
      this.bxn.W(this.radius);
    }
    AppMethodBeat.o(86436);
  }
  
  public final void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86437);
    if (IsFilterInvalute())
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      AppMethodBeat.o(86437);
      return;
    }
    addParam(new m.g("levelMinimum", new float[] { 0.04F, 0.04F, 0.04F }));
    addParam(new m.g("levelMiddle", new float[] { 1.0F, 1.0F, 1.0F }));
    addParam(new m.g("levelMaximum", new float[] { 0.96F, 0.96F, 0.96F }));
    addParam(new m.g("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    addParam(new m.g("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    this.bxm = new d.a(true);
    this.bxm.W(this.radius);
    setNextFilter(this.bxm, null);
    this.bxn = new d.a(false);
    this.bxn.W(this.radius);
    this.bxm.setNextFilter(this.bxn, null);
    this.bxl = new BaseFilter(GLSLRender.bvy);
    this.bxl.addParam(new m.m("inputImageTexture2", this.curve_static, 33986));
    this.bxl.addParam(new m.m("inputImageTexture3", this.meitu_whiten, 33987));
    this.bxl.addParam(new m.f("whiten", this.whitenmag));
    this.bxl.addParam(new m.f("opttype", this.opttype));
    this.bxl.addParam(new m.f("skinFilter", this.skinFilter));
    this.bxl.addParam(new m.f("smoothMag", this.bxp));
    this.bxn.setNextFilter(this.bxl, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(86437);
  }
  
  public final void setParameterDic(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(86435);
    if (paramMap.containsKey("opttype"))
    {
      this.opttype = ((Float)paramMap.get("opttype")).floatValue();
      if (this.bxl != null) {
        this.bxl.addParam(new m.f("opttype", this.opttype));
      }
    }
    if (paramMap.containsKey("whitenmag"))
    {
      this.whitenmag = Math.max(0.0F, Math.min(((Float)paramMap.get("whitenmag")).floatValue(), 1.0F));
      if (this.bxl != null) {
        this.bxl.addParam(new m.f("whiten", this.whitenmag));
      }
    }
    if (paramMap.containsKey("scale")) {
      this.scale = ((Float)paramMap.get("scale")).floatValue();
    }
    if (paramMap.containsKey("radius")) {
      setRadius(((Float)paramMap.get("radius")).floatValue());
    }
    if (paramMap.containsKey("smoothMag"))
    {
      this.bxp = ((Float)paramMap.get("smoothMag")).floatValue();
      if (this.bxl != null) {
        this.bxl.addParam(new m.f("smoothMag", this.bxp));
      }
    }
    if (paramMap.containsKey("skinFilter"))
    {
      this.skinFilter = ((Float)paramMap.get("skinFilter")).floatValue();
      if (this.bxl != null) {
        this.bxl.addParam(new m.f("skinFilter", this.skinFilter));
      }
    }
    AppMethodBeat.o(86435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.a.d
 * JD-Core Version:    0.7.0.1
 */