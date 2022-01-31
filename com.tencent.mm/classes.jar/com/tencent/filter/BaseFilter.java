package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.util.d;
import com.tencent.util.g;
import com.tencent.view.b;
import com.tencent.view.e;
import com.tencent.view.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseFilter
{
  private String TAG = BaseFilter.class.getSimpleName();
  String defaultLensShader = "mee188x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1981811232x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x537541477x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1870012426x1830839401x678324577x2065697321x538976266x1818697760x1634879071x1819231079x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x694514785x2099251771x";
  private long glFilterId = 0L;
  public int glsl_programID = -1;
  String glsl_programShader = null;
  String glsl_vertextShader = "mee390x1667592816x1869181801x1768431726x544237671x1634692198x1628257140x1769108596x1702131042x1667593760x1869619252x1769236851x221998703x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980578661x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963801445x1868982638x1830841714x540308577x1785688656x1769235301x221998703x1718185589x544043631x880042349x1685015840x1769368677x540768101x1768846605x1836216166x1952541984x1702109236x1920300152x1952533861x1963794491x1868982638x1830841714x540308577x1952533876x1870007611x1830839401x678324577x1684631414x226168105x1348430951x1953067887x544108393x1917853757x1667590767x1852795252x1293953568x1818584175x2003134838x1869621792x1769236851x221998703x878929270x1886221344x1948269856x712270157x878929270x1886284072x1700033653x1920300152x1869562725x1852400754x778400865x1852386424x1416918384x1970567269x1866687858x1768190575x1702125934x808220974x824979502x992555054x2019914765x1701999988x1919905603x1634625892x1025533300x1886221344x997816366x32013x";
  int glsl_vertextshaderID = GLSLRender.bfp;
  boolean mIsGPU = true;
  protected boolean mIsPreviewFilter;
  BaseFilter mNextFilter;
  Map<String, m> mParamList = new HashMap();
  private int mProgramIds;
  int[] mTextureIndexMap;
  public boolean needFlipBlend = false;
  public boolean needReleaseFrmae = false;
  public float outPutScaleFact = 1.0F;
  public float scaleFact = 1.0F;
  public int srcTextureIndex = -1;
  
  public BaseFilter(int paramInt)
  {
    this.glsl_programID = paramInt;
  }
  
  public BaseFilter(int paramInt1, int paramInt2)
  {
    this.glsl_vertextshaderID = paramInt1;
    this.glsl_programID = paramInt2;
  }
  
  public BaseFilter(int paramInt, String paramString)
  {
    this.glsl_programID = paramInt;
    addParam(new m.o("inputImageTexture2", paramString, 33986));
  }
  
  public BaseFilter(String paramString)
  {
    this.glsl_programShader = paramString;
  }
  
  public BaseFilter(String paramString1, String paramString2)
  {
    this.glsl_vertextShader = paramString1;
    this.glsl_programShader = paramString2;
  }
  
  public static int getVersionCode()
  {
    return nativeGetVersion();
  }
  
  public static native String nativeDecrypt(String paramString);
  
  private native String nativeGetFilterShader(int paramInt1, int paramInt2);
  
  private static native int nativeGetVersion();
  
  private native long nativeInitialWithString(long paramLong, int paramInt, String paramString1, String paramString2);
  
  private native boolean nativeSetPositions(long paramLong, float[] paramArrayOfFloat);
  
  private native boolean nativeSetRenderMode(long paramLong, int paramInt);
  
  private native boolean nativeSetTexCords(long paramLong, float[] paramArrayOfFloat);
  
  public QImage ApplyFilter(QImage paramQImage)
  {
    return null;
  }
  
  public void ApplyGLSLFilter()
  {
    ApplyGLSLFilter(0);
  }
  
  public void ApplyGLSLFilter(int paramInt)
  {
    initFilterShader(paramInt);
    if (b.xdf) {
      setRenderMode(1);
    }
    this.mProgramIds = nativeApplyFilter(this.glFilterId, 0L);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).initialParams(this.mProgramIds);
    }
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.mIsPreviewFilter = paramBoolean;
    if (!IsFilterInvalute()) {
      ApplyGLSLFilter();
    }
    if (this.mNextFilter != null) {
      this.mNextFilter.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public void ClearGLSL()
  {
    clearGLSLSelf();
    if (this.mNextFilter != null) {
      this.mNextFilter.ClearGLSL();
    }
  }
  
  public boolean IsFilterInvalute()
  {
    return this.mProgramIds > 0;
  }
  
  public void OnDrawFrameGLSL()
  {
    GLES20.glUseProgram(this.mProgramIds);
    f.checkGlError("glUseProgram:" + this.mProgramIds);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).setParams(this.mProgramIds);
    }
  }
  
  public void RendProcessImage(QImage paramQImage, h paramh)
  {
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = new int[2];
    int[] tmp12_10 = arrayOfInt1;
    tmp12_10[0] = 1;
    int[] tmp16_12 = tmp12_10;
    tmp16_12[1] = 1;
    tmp16_12;
    GLSLRender.nativePreprocessJepg(paramQImage, arrayOfInt1);
    int[] arrayOfInt2 = new int[1];
    d.cRj().c(arrayOfInt2, true);
    float[] arrayOfFloat = new float[9];
    float[] tmp49_47 = arrayOfFloat;
    tmp49_47[0] = 1.0F;
    float[] tmp53_49 = tmp49_47;
    tmp53_49[1] = 0.0F;
    float[] tmp57_53 = tmp53_49;
    tmp57_53[2] = 0.0F;
    float[] tmp61_57 = tmp57_53;
    tmp61_57[3] = 0.0F;
    float[] tmp65_61 = tmp61_57;
    tmp65_61[4] = 1.0F;
    float[] tmp69_65 = tmp65_61;
    tmp69_65[5] = 0.0F;
    float[] tmp73_69 = tmp69_65;
    tmp73_69[6] = 0.0F;
    float[] tmp78_73 = tmp73_69;
    tmp78_73[7] = 0.0F;
    float[] tmp83_78 = tmp78_73;
    tmp83_78[8] = 1.0F;
    tmp83_78;
    int[] arrayOfInt3 = new int[2];
    int[] tmp96_94 = arrayOfInt3;
    tmp96_94[0] = 0;
    int[] tmp100_96 = tmp96_94;
    tmp100_96[1] = 0;
    tmp100_96;
    int i = 0;
    while (i < arrayOfInt1[0])
    {
      int j = 0;
      if (j < arrayOfInt1[1])
      {
        GLSLRender.nativePickJepgToTexture(paramQImage, i, j, arrayOfInt1[0], arrayOfInt1[1], arrayOfInt2[0], arrayOfInt3);
        arrayOfFloat[0] = (arrayOfInt3[0] / paramQImage.getWidth());
        arrayOfFloat[4] = (arrayOfInt3[1] / paramQImage.getHeight());
        arrayOfFloat[2] = (i / arrayOfInt1[0]);
        arrayOfFloat[5] = (j / arrayOfInt1[1]);
        setGlobalTextureMatrix(arrayOfFloat);
        if (b.xde >= 0)
        {
          RenderProcess(arrayOfInt2[0], arrayOfInt3[0], arrayOfInt3[1], -2, 0.0D, paramh);
          GLSLRender.nativePushJepgFromTexture(paramQImage, i, j, arrayOfInt1[0], arrayOfInt1[1], b.xde);
        }
        for (;;)
        {
          j += 1;
          break;
          RenderProcess(arrayOfInt2[0], arrayOfInt3[0], arrayOfInt3[1], -1, 0.0D, paramh);
          GLSLRender.nativePushJepgFromTexture(paramQImage, i, j, arrayOfInt1[0], arrayOfInt1[1], b.xde);
        }
      }
      i += 1;
    }
    setGlobalTextureMatrix(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
    GLES20.glDeleteTextures(1, arrayOfInt2, 0);
    g.h("BaseFilter", "RendProcessImage:" + (System.currentTimeMillis() - l));
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, h paramh)
  {
    RenderProcess(paramInt1, paramInt2, paramInt3, paramInt2, paramInt3, paramInt4, paramDouble, paramh);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, h paramh)
  {
    if (paramh == null) {}
    label188:
    label219:
    for (;;)
    {
      return;
      Object localObject = paramh;
      h localh1 = paramh;
      BaseFilter localBaseFilter = this;
      label93:
      label124:
      label383:
      while (localBaseFilter != null)
      {
        int i;
        if (localBaseFilter == this)
        {
          localBaseFilter.beforeRender(paramInt1, paramInt2, paramInt3);
          localh1.needReleaseFrmae = localBaseFilter.needReleaseFrmae;
          if (localBaseFilter.mNextFilter != null) {
            break label188;
          }
          localh1.a(paramInt6, (int)(paramInt4 * localBaseFilter.scaleFact * this.outPutScaleFact), (int)(paramInt5 * localBaseFilter.scaleFact * this.outPutScaleFact), paramDouble);
          f.checkGlError("before OnDrawFrameGLSL");
          localBaseFilter.OnDrawFrameGLSL();
          if ((localBaseFilter.mTextureIndexMap == null) || (localBaseFilter.mTextureIndexMap.length <= 0)) {
            break label271;
          }
          i = 0;
          if (i >= localBaseFilter.mTextureIndexMap.length) {
            break label271;
          }
          if (localBaseFilter.mTextureIndexMap[i] >= 0) {
            break label219;
          }
          localBaseFilter.setTextureParam(paramInt1, i);
        }
        for (;;)
        {
          i += 1;
          break label124;
          localBaseFilter.beforeRender(localObject.texture[0], ((h)localObject).width, ((h)localObject).height);
          break;
          localh1.a(-1, (int)(paramInt4 * localBaseFilter.scaleFact), (int)(paramInt5 * localBaseFilter.scaleFact), paramDouble);
          break label93;
          h localh2 = findFrame(paramh, localBaseFilter.mTextureIndexMap[i]);
          if (localh2 != null) {
            localBaseFilter.setTextureParam(localh2.texture[0], i);
          } else {
            g.i(this.TAG, "frame not found!");
          }
        }
        f.checkGlError("before nativeRenderTexture");
        if (localBaseFilter == this) {
          localBaseFilter.renderTexture(paramInt1, paramInt2, paramInt3);
        }
        for (;;)
        {
          f.checkGlError("after nativeRenderTexture");
          localBaseFilter = localBaseFilter.mNextFilter;
          if (localBaseFilter == null) {
            break label383;
          }
          if (localh1.bcD == null) {
            localh1.bcD = new h();
          }
          localh1 = localh1.bcD;
          break;
          localBaseFilter.renderTexture(localObject.texture[0], ((h)localObject).width, ((h)localObject).height);
          if (((h)localObject).needReleaseFrmae) {
            ((h)localObject).pH();
          }
          localObject = localh1;
        }
      }
    }
  }
  
  public void RenderProcessBitmap(Bitmap paramBitmap, h paramh)
  {
    e locale = e.ab(paramBitmap);
    if (b.xde < 0)
    {
      RenderProcess(locale.texture, locale.width, locale.height, locale.texture, 0.0D, paramh);
      f.a(locale.texture, locale.width, locale.height, paramBitmap);
    }
    for (;;)
    {
      if (locale.texture != -20000)
      {
        f.Ku(locale.texture);
        locale.texture = -20000;
      }
      return;
      RenderProcess(locale.texture, locale.width, locale.height, -2, 0.0D, paramh);
      GLSLRender.nativePushBitmapFromTexture(paramBitmap, b.xde);
    }
  }
  
  public BaseFilter addParam(m paramm)
  {
    if (paramm == null) {
      return this;
    }
    m localm = (m)this.mParamList.get(paramm.name);
    if (localm == null)
    {
      this.mParamList.put(paramm.name, paramm);
      return this;
    }
    paramm.handle = localm.handle;
    this.mParamList.put(paramm.name, paramm);
    return this;
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void clearGLSLSelf()
  {
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).clear();
    }
    nativeClear(this.glFilterId);
    this.glFilterId = 0L;
    this.mProgramIds = 0;
  }
  
  public void copy(BaseFilter paramBaseFilter)
  {
    if (paramBaseFilter == null) {
      return;
    }
    this.mProgramIds = paramBaseFilter.mProgramIds;
    this.glFilterId = paramBaseFilter.glFilterId;
    this.mParamList = paramBaseFilter.mParamList;
  }
  
  h findFrame(h paramh, int paramInt)
  {
    while (paramh != null)
    {
      if (paramInt == 0) {
        return paramh;
      }
      paramh = paramh.bcD;
      paramInt -= 1;
    }
    return null;
  }
  
  public BaseFilter getLastFilter()
  {
    for (BaseFilter localBaseFilter = this; localBaseFilter.mNextFilter != null; localBaseFilter = localBaseFilter.mNextFilter) {}
    return localBaseFilter;
  }
  
  public int getLastFilterID()
  {
    return getTheFilterIndex(getLastFilter());
  }
  
  public m getParam(String paramString)
  {
    return (m)this.mParamList.get(paramString);
  }
  
  public float getScaleFact()
  {
    return this.scaleFact;
  }
  
  public int getSrcFilterInddex()
  {
    return this.srcTextureIndex;
  }
  
  public int getTheFilterIndex(BaseFilter paramBaseFilter)
  {
    int i = 0;
    for (BaseFilter localBaseFilter = this; (localBaseFilter != null) && (localBaseFilter != paramBaseFilter); localBaseFilter = localBaseFilter.mNextFilter) {
      i += 1;
    }
    if (localBaseFilter == paramBaseFilter) {
      return i;
    }
    return -1;
  }
  
  public BaseFilter getmNextFilter()
  {
    return this.mNextFilter;
  }
  
  public int getmProgramIds()
  {
    return this.mProgramIds;
  }
  
  protected void initFilterShader(int paramInt)
  {
    if ((this.glsl_programShader != null) && (this.glsl_vertextShader != null))
    {
      this.glFilterId = nativeInitialWithString(this.glFilterId, paramInt, this.glsl_vertextShader, this.glsl_programShader);
      return;
    }
    try
    {
      String str2 = nativeGetFilterShader(0, this.glsl_programID);
      String str1 = this.glsl_vertextShader;
      if (this.glsl_vertextshaderID != 0) {
        str1 = nativeGetFilterShader(1, this.glsl_vertextshaderID);
      }
      this.glFilterId = nativeInitialWithString(this.glFilterId, paramInt, str1, str2);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      this.glFilterId = nativeInitialWithString(this.glFilterId, paramInt, this.glsl_vertextShader, this.defaultLensShader);
    }
  }
  
  public boolean isAdjustFilter()
  {
    return false;
  }
  
  public boolean isClass(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString) {}
    return false;
  }
  
  public boolean isGPUProcess()
  {
    return this.mIsGPU;
  }
  
  public boolean isNormal()
  {
    return (this.glsl_programID == GLSLRender.bcE) && (this.mNextFilter == null);
  }
  
  public boolean isSupportForGloableRender()
  {
    return true;
  }
  
  protected native int nativeApplyFilter(long paramLong1, long paramLong2);
  
  protected native boolean nativeClear(long paramLong);
  
  protected native boolean nativeRenderTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  protected native boolean nativeSetGlobalTextureMatrix(long paramLong, float[] paramArrayOfFloat);
  
  public boolean nativeSetGlobalTextureMatrix(float[] paramArrayOfFloat)
  {
    return nativeSetGlobalTextureMatrix(this.glFilterId, paramArrayOfFloat);
  }
  
  public boolean nativeSetRotationAndFlip(int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeSetRotationAndFlip(this.glFilterId, paramInt1, paramInt2, paramInt3);
  }
  
  protected native boolean nativeSetRotationAndFlip(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  protected native boolean nativeUpdateMatrix(long paramLong, float[] paramArrayOfFloat);
  
  public boolean nativeUpdateMatrix(float[] paramArrayOfFloat)
  {
    return nativeUpdateMatrix(this.glFilterId, paramArrayOfFloat);
  }
  
  protected native boolean nativeUpdateModelMatrix(long paramLong, float[] paramArrayOfFloat);
  
  public boolean nativeUpdateModelMatrix(float[] paramArrayOfFloat)
  {
    return nativeUpdateModelMatrix(this.glFilterId, paramArrayOfFloat);
  }
  
  public void removeTheFilter(BaseFilter paramBaseFilter)
  {
    BaseFilter localBaseFilter = this;
    if (paramBaseFilter == null) {}
    do
    {
      return;
      while ((localBaseFilter != null) && (localBaseFilter.mNextFilter != paramBaseFilter)) {
        localBaseFilter = localBaseFilter.mNextFilter;
      }
    } while ((localBaseFilter == null) || (localBaseFilter.mNextFilter != paramBaseFilter));
    localBaseFilter.mNextFilter = null;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeRenderTexture(this.glFilterId, paramInt1, paramInt2, paramInt3);
  }
  
  public void setAdjustParam(float paramFloat) {}
  
  public void setEffectIndex(int paramInt) {}
  
  protected void setGlobalTextureMatrix(float[] paramArrayOfFloat)
  {
    nativeSetGlobalTextureMatrix(this.glFilterId, paramArrayOfFloat);
    if (this.mNextFilter != null) {
      this.mNextFilter.setGlobalTextureMatrix(paramArrayOfFloat);
    }
  }
  
  public void setNextFilter(BaseFilter paramBaseFilter, int[] paramArrayOfInt)
  {
    this.mNextFilter = paramBaseFilter;
    if (paramBaseFilter != null) {
      paramBaseFilter.mTextureIndexMap = paramArrayOfInt;
    }
  }
  
  public void setParameterDic(Map<String, Object> paramMap) {}
  
  public void setParams()
  {
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).setParams(this.mProgramIds);
    }
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    return nativeSetPositions(this.glFilterId, paramArrayOfFloat);
  }
  
  public boolean setRenderMode(int paramInt)
  {
    return nativeSetRenderMode(this.glFilterId, paramInt);
  }
  
  public void setScaleFact(float paramFloat)
  {
    this.scaleFact = paramFloat;
  }
  
  public void setSrcFilterIndex(int paramInt)
  {
    this.srcTextureIndex = paramInt;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    return nativeSetTexCords(this.glFilterId, paramArrayOfFloat);
  }
  
  public void setTextureParam(int paramInt1, int paramInt2)
  {
    paramInt2 += 2;
    String str = "inputImageTexture" + paramInt2;
    int i = GLES20.glGetUniformLocation(this.mProgramIds, str);
    if (i >= 0)
    {
      GLES20.glActiveTexture(33984 + paramInt2);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(i, paramInt2);
    }
  }
  
  public void updateFilterShader(String paramString1, String paramString2)
  {
    this.glsl_vertextShader = paramString1;
    this.glsl_programShader = paramString2;
  }
  
  public void updateFragmentShader(String paramString)
  {
    this.glsl_programShader = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.BaseFilter
 * JD-Core Version:    0.7.0.1
 */