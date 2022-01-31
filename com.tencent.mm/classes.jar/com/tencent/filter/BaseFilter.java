package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.i;
import com.tencent.view.b;
import com.tencent.view.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseFilter
{
  private String TAG;
  String defaultLensShader;
  private long glFilterId;
  protected int glsl_programID;
  String glsl_programShader;
  String glsl_vertextShader;
  int glsl_vertextshaderID;
  boolean mIsGPU;
  protected boolean mIsPreviewFilter;
  BaseFilter mNextFilter;
  Map<String, m> mParamList;
  private int mProgramIds;
  int[] mTextureIndexMap;
  public boolean needFlipBlend;
  public boolean needReleaseFrmae;
  public float outPutScaleFact;
  public float scaleFact;
  protected int srcTextureIndex;
  
  public BaseFilter(int paramInt)
  {
    AppMethodBeat.i(86313);
    this.TAG = BaseFilter.class.getSimpleName();
    this.glFilterId = 0L;
    this.glsl_programID = -1;
    this.glsl_vertextshaderID = GLSLRender.bvS;
    this.defaultLensShader = "mee188x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1981811232x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x537541477x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1870012426x1830839401x678324577x2065697321x538976266x1818697760x1634879071x1819231079x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x694514785x2099251771x";
    this.glsl_programShader = null;
    this.glsl_vertextShader = "mee390x1667592816x1869181801x1768431726x544237671x1634692198x1628257140x1769108596x1702131042x1667593760x1869619252x1769236851x221998703x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980578661x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963801445x1868982638x1830841714x540308577x1785688656x1769235301x221998703x1718185589x544043631x880042349x1685015840x1769368677x540768101x1768846605x1836216166x1952541984x1702109236x1920300152x1952533861x1963794491x1868982638x1830841714x540308577x1952533876x1870007611x1830839401x678324577x1684631414x226168105x1348430951x1953067887x544108393x1917853757x1667590767x1852795252x1293953568x1818584175x2003134838x1869621792x1769236851x221998703x878929270x1886221344x1948269856x712270157x878929270x1886284072x1700033653x1920300152x1869562725x1852400754x778400865x1852386424x1416918384x1970567269x1866687858x1768190575x1702125934x808220974x824979502x992555054x2019914765x1701999988x1919905603x1634625892x1025533300x1886221344x997816366x32013x";
    this.mIsGPU = true;
    this.scaleFact = 1.0F;
    this.outPutScaleFact = 1.0F;
    this.needFlipBlend = false;
    this.needReleaseFrmae = false;
    this.srcTextureIndex = -1;
    this.mParamList = new HashMap();
    this.glsl_programID = paramInt;
    AppMethodBeat.o(86313);
  }
  
  public BaseFilter(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(86315);
    this.TAG = BaseFilter.class.getSimpleName();
    this.glFilterId = 0L;
    this.glsl_programID = -1;
    this.glsl_vertextshaderID = GLSLRender.bvS;
    this.defaultLensShader = "mee188x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1981811232x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x537541477x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1870012426x1830839401x678324577x2065697321x538976266x1818697760x1634879071x1819231079x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x694514785x2099251771x";
    this.glsl_programShader = null;
    this.glsl_vertextShader = "mee390x1667592816x1869181801x1768431726x544237671x1634692198x1628257140x1769108596x1702131042x1667593760x1869619252x1769236851x221998703x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980578661x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963801445x1868982638x1830841714x540308577x1785688656x1769235301x221998703x1718185589x544043631x880042349x1685015840x1769368677x540768101x1768846605x1836216166x1952541984x1702109236x1920300152x1952533861x1963794491x1868982638x1830841714x540308577x1952533876x1870007611x1830839401x678324577x1684631414x226168105x1348430951x1953067887x544108393x1917853757x1667590767x1852795252x1293953568x1818584175x2003134838x1869621792x1769236851x221998703x878929270x1886221344x1948269856x712270157x878929270x1886284072x1700033653x1920300152x1869562725x1852400754x778400865x1852386424x1416918384x1970567269x1866687858x1768190575x1702125934x808220974x824979502x992555054x2019914765x1701999988x1919905603x1634625892x1025533300x1886221344x997816366x32013x";
    this.mIsGPU = true;
    this.scaleFact = 1.0F;
    this.outPutScaleFact = 1.0F;
    this.needFlipBlend = false;
    this.needReleaseFrmae = false;
    this.srcTextureIndex = -1;
    this.mParamList = new HashMap();
    this.glsl_vertextshaderID = paramInt1;
    this.glsl_programID = paramInt2;
    AppMethodBeat.o(86315);
  }
  
  public BaseFilter(int paramInt, String paramString)
  {
    AppMethodBeat.i(86314);
    this.TAG = BaseFilter.class.getSimpleName();
    this.glFilterId = 0L;
    this.glsl_programID = -1;
    this.glsl_vertextshaderID = GLSLRender.bvS;
    this.defaultLensShader = "mee188x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1981811232x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x537541477x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1870012426x1830839401x678324577x2065697321x538976266x1818697760x1634879071x1819231079x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x694514785x2099251771x";
    this.glsl_programShader = null;
    this.glsl_vertextShader = "mee390x1667592816x1869181801x1768431726x544237671x1634692198x1628257140x1769108596x1702131042x1667593760x1869619252x1769236851x221998703x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980578661x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963801445x1868982638x1830841714x540308577x1785688656x1769235301x221998703x1718185589x544043631x880042349x1685015840x1769368677x540768101x1768846605x1836216166x1952541984x1702109236x1920300152x1952533861x1963794491x1868982638x1830841714x540308577x1952533876x1870007611x1830839401x678324577x1684631414x226168105x1348430951x1953067887x544108393x1917853757x1667590767x1852795252x1293953568x1818584175x2003134838x1869621792x1769236851x221998703x878929270x1886221344x1948269856x712270157x878929270x1886284072x1700033653x1920300152x1869562725x1852400754x778400865x1852386424x1416918384x1970567269x1866687858x1768190575x1702125934x808220974x824979502x992555054x2019914765x1701999988x1919905603x1634625892x1025533300x1886221344x997816366x32013x";
    this.mIsGPU = true;
    this.scaleFact = 1.0F;
    this.outPutScaleFact = 1.0F;
    this.needFlipBlend = false;
    this.needReleaseFrmae = false;
    this.srcTextureIndex = -1;
    this.mParamList = new HashMap();
    this.glsl_programID = paramInt;
    addParam(new m.o("inputImageTexture2", paramString, 33986));
    AppMethodBeat.o(86314);
  }
  
  public BaseFilter(String paramString)
  {
    AppMethodBeat.i(86317);
    this.TAG = BaseFilter.class.getSimpleName();
    this.glFilterId = 0L;
    this.glsl_programID = -1;
    this.glsl_vertextshaderID = GLSLRender.bvS;
    this.defaultLensShader = "mee188x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1981811232x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x537541477x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1870012426x1830839401x678324577x2065697321x538976266x1818697760x1634879071x1819231079x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x694514785x2099251771x";
    this.glsl_programShader = null;
    this.glsl_vertextShader = "mee390x1667592816x1869181801x1768431726x544237671x1634692198x1628257140x1769108596x1702131042x1667593760x1869619252x1769236851x221998703x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980578661x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963801445x1868982638x1830841714x540308577x1785688656x1769235301x221998703x1718185589x544043631x880042349x1685015840x1769368677x540768101x1768846605x1836216166x1952541984x1702109236x1920300152x1952533861x1963794491x1868982638x1830841714x540308577x1952533876x1870007611x1830839401x678324577x1684631414x226168105x1348430951x1953067887x544108393x1917853757x1667590767x1852795252x1293953568x1818584175x2003134838x1869621792x1769236851x221998703x878929270x1886221344x1948269856x712270157x878929270x1886284072x1700033653x1920300152x1869562725x1852400754x778400865x1852386424x1416918384x1970567269x1866687858x1768190575x1702125934x808220974x824979502x992555054x2019914765x1701999988x1919905603x1634625892x1025533300x1886221344x997816366x32013x";
    this.mIsGPU = true;
    this.scaleFact = 1.0F;
    this.outPutScaleFact = 1.0F;
    this.needFlipBlend = false;
    this.needReleaseFrmae = false;
    this.srcTextureIndex = -1;
    this.mParamList = new HashMap();
    this.glsl_programShader = paramString;
    AppMethodBeat.o(86317);
  }
  
  public BaseFilter(String paramString1, String paramString2)
  {
    AppMethodBeat.i(86316);
    this.TAG = BaseFilter.class.getSimpleName();
    this.glFilterId = 0L;
    this.glsl_programID = -1;
    this.glsl_vertextshaderID = GLSLRender.bvS;
    this.defaultLensShader = "mee188x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1981811232x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x537541477x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1870012426x1830839401x678324577x2065697321x538976266x1818697760x1634879071x1819231079x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x694514785x2099251771x";
    this.glsl_programShader = null;
    this.glsl_vertextShader = "mee390x1667592816x1869181801x1768431726x544237671x1634692198x1628257140x1769108596x1702131042x1667593760x1869619252x1769236851x221998703x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980578661x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x1963801445x1868982638x1830841714x540308577x1785688656x1769235301x221998703x1718185589x544043631x880042349x1685015840x1769368677x540768101x1768846605x1836216166x1952541984x1702109236x1920300152x1952533861x1963794491x1868982638x1830841714x540308577x1952533876x1870007611x1830839401x678324577x1684631414x226168105x1348430951x1953067887x544108393x1917853757x1667590767x1852795252x1293953568x1818584175x2003134838x1869621792x1769236851x221998703x878929270x1886221344x1948269856x712270157x878929270x1886284072x1700033653x1920300152x1869562725x1852400754x778400865x1852386424x1416918384x1970567269x1866687858x1768190575x1702125934x808220974x824979502x992555054x2019914765x1701999988x1919905603x1634625892x1025533300x1886221344x997816366x32013x";
    this.mIsGPU = true;
    this.scaleFact = 1.0F;
    this.outPutScaleFact = 1.0F;
    this.needFlipBlend = false;
    this.needReleaseFrmae = false;
    this.srcTextureIndex = -1;
    this.mParamList = new HashMap();
    this.glsl_vertextShader = paramString1;
    this.glsl_programShader = paramString2;
    AppMethodBeat.o(86316);
  }
  
  private void checkInputOutputValid(BaseFilter paramBaseFilter, h paramh, int paramInt)
  {
    AppMethodBeat.i(86332);
    if (paramInt == paramh.texture[0])
    {
      i.n("BaseFilter", "input and output texture is same!");
      if (g.isEnableLog())
      {
        paramBaseFilter = new RuntimeException("input and output texture is same!");
        AppMethodBeat.o(86332);
        throw paramBaseFilter;
      }
    }
    paramBaseFilter = paramBaseFilter.mParamList.values().iterator();
    while (paramBaseFilter.hasNext())
    {
      m localm = (m)paramBaseFilter.next();
      if (((localm instanceof m.n)) && (((m.n)localm).texture[0] == paramh.texture[0]))
      {
        i.n("BaseFilter", "input and output texture is same!");
        if (g.isEnableLog())
        {
          paramBaseFilter = new RuntimeException("input and output texture is same!");
          AppMethodBeat.o(86332);
          throw paramBaseFilter;
        }
      }
    }
    AppMethodBeat.o(86332);
  }
  
  public static int getVersionCode()
  {
    AppMethodBeat.i(86341);
    int i = nativeGetVersion();
    AppMethodBeat.o(86341);
    return i;
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
    AppMethodBeat.i(86328);
    ApplyGLSLFilter(0);
    AppMethodBeat.o(86328);
  }
  
  public void ApplyGLSLFilter(int paramInt)
  {
    AppMethodBeat.i(86327);
    initFilterShader(paramInt);
    if (b.BzM) {
      setRenderMode(1);
    }
    this.mProgramIds = nativeApplyFilter(this.glFilterId, 0L);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).initialParams(this.mProgramIds);
    }
    AppMethodBeat.o(86327);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(86324);
    this.mIsPreviewFilter = paramBoolean;
    if (!IsFilterInvalute()) {
      ApplyGLSLFilter();
    }
    if (this.mNextFilter != null) {
      this.mNextFilter.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(86324);
  }
  
  public void ClearGLSL()
  {
    AppMethodBeat.i(86323);
    clearGLSLSelf();
    if (this.mNextFilter != null) {
      this.mNextFilter.ClearGLSL();
    }
    AppMethodBeat.o(86323);
  }
  
  public boolean IsFilterInvalute()
  {
    return this.mProgramIds > 0;
  }
  
  public void OnDrawFrameGLSL()
  {
    AppMethodBeat.i(86330);
    GLES20.glUseProgram(this.mProgramIds);
    g.checkGlError("glUseProgram:" + this.mProgramIds);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).setParams(this.mProgramIds);
    }
    AppMethodBeat.o(86330);
  }
  
  public void RendProcessImage(QImage paramQImage, h paramh)
  {
    AppMethodBeat.i(86335);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = new int[2];
    int[] tmp18_16 = arrayOfInt1;
    tmp18_16[0] = 1;
    int[] tmp22_18 = tmp18_16;
    tmp22_18[1] = 1;
    tmp22_18;
    GLSLRender.nativePreprocessJepg(paramQImage, arrayOfInt1);
    int[] arrayOfInt2 = new int[1];
    com.tencent.util.f.dWZ().c(arrayOfInt2, true);
    float[] arrayOfFloat = new float[9];
    float[] tmp55_53 = arrayOfFloat;
    tmp55_53[0] = 1.0F;
    float[] tmp59_55 = tmp55_53;
    tmp59_55[1] = 0.0F;
    float[] tmp63_59 = tmp59_55;
    tmp63_59[2] = 0.0F;
    float[] tmp67_63 = tmp63_59;
    tmp67_63[3] = 0.0F;
    float[] tmp71_67 = tmp67_63;
    tmp71_67[4] = 1.0F;
    float[] tmp75_71 = tmp71_67;
    tmp75_71[5] = 0.0F;
    float[] tmp79_75 = tmp75_71;
    tmp79_75[6] = 0.0F;
    float[] tmp84_79 = tmp79_75;
    tmp84_79[7] = 0.0F;
    float[] tmp89_84 = tmp84_79;
    tmp89_84[8] = 1.0F;
    tmp89_84;
    int[] arrayOfInt3 = new int[2];
    int[] tmp102_100 = arrayOfInt3;
    tmp102_100[0] = 0;
    int[] tmp106_102 = tmp102_100;
    tmp106_102[1] = 0;
    tmp106_102;
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
        if (b.BzL >= 0)
        {
          RenderProcess(arrayOfInt2[0], arrayOfInt3[0], arrayOfInt3[1], -2, 0.0D, paramh);
          GLSLRender.nativePushJepgFromTexture(paramQImage, i, j, arrayOfInt1[0], arrayOfInt1[1], b.BzL);
        }
        for (;;)
        {
          j += 1;
          break;
          RenderProcess(arrayOfInt2[0], arrayOfInt3[0], arrayOfInt3[1], -1, 0.0D, paramh);
          GLSLRender.nativePushJepgFromTexture(paramQImage, i, j, arrayOfInt1[0], arrayOfInt1[1], b.BzL);
        }
      }
      i += 1;
    }
    setGlobalTextureMatrix(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
    GLES20.glDeleteTextures(1, arrayOfInt2, 0);
    i.l("BaseFilter", "RendProcessImage:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(86335);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, h paramh)
  {
    AppMethodBeat.i(86333);
    RenderProcess(paramInt1, paramInt2, paramInt3, paramInt2, paramInt3, paramInt4, paramDouble, paramh);
    AppMethodBeat.o(86333);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, h paramh)
  {
    AppMethodBeat.i(86331);
    if (paramh == null)
    {
      AppMethodBeat.o(86331);
      return;
    }
    Object localObject2 = paramh;
    Object localObject1 = paramh;
    Object localObject3 = this;
    if (localObject3 != null)
    {
      label105:
      int i;
      if (localObject3 == this)
      {
        ((BaseFilter)localObject3).beforeRender(paramInt1, paramInt2, paramInt3);
        ((h)localObject1).needReleaseFrmae = ((BaseFilter)localObject3).needReleaseFrmae;
        if (((BaseFilter)localObject3).mNextFilter != null) {
          break label200;
        }
        ((h)localObject1).a(paramInt6, (int)(paramInt4 * ((BaseFilter)localObject3).scaleFact * this.outPutScaleFact), (int)(paramInt5 * ((BaseFilter)localObject3).scaleFact * this.outPutScaleFact), paramDouble);
        g.checkGlError("before OnDrawFrameGLSL");
        ((BaseFilter)localObject3).OnDrawFrameGLSL();
        if ((((BaseFilter)localObject3).mTextureIndexMap == null) || (((BaseFilter)localObject3).mTextureIndexMap.length <= 0)) {
          break label283;
        }
        i = 0;
        label136:
        if (i >= ((BaseFilter)localObject3).mTextureIndexMap.length) {
          break label283;
        }
        if (localObject3.mTextureIndexMap[i] >= 0) {
          break label231;
        }
        ((BaseFilter)localObject3).setTextureParam(paramInt1, i);
      }
      label200:
      label231:
      Object localObject4;
      for (;;)
      {
        i += 1;
        break label136;
        ((BaseFilter)localObject3).beforeRender(localObject2.texture[0], ((h)localObject2).width, ((h)localObject2).height);
        break;
        ((h)localObject1).a(-1, (int)(paramInt4 * ((BaseFilter)localObject3).scaleFact), (int)(paramInt5 * ((BaseFilter)localObject3).scaleFact), paramDouble);
        break label105;
        localObject4 = findFrame(paramh, localObject3.mTextureIndexMap[i]);
        if (localObject4 != null) {
          ((BaseFilter)localObject3).setTextureParam(localObject4.texture[0], i);
        } else {
          i.n(this.TAG, "frame not found!");
        }
      }
      label283:
      g.checkGlError("before nativeRenderTexture");
      if (localObject3 == this)
      {
        ((BaseFilter)localObject3).renderTexture(paramInt1, paramInt2, paramInt3);
        i = paramInt1;
      }
      for (;;)
      {
        if (paramInt6 != 0) {
          checkInputOutputValid((BaseFilter)localObject3, (h)localObject1, i);
        }
        g.checkGlError("after nativeRenderTexture");
        localObject4 = ((BaseFilter)localObject3).mNextFilter;
        localObject3 = localObject1;
        if (localObject4 != null)
        {
          if (((h)localObject1).btf == null) {
            ((h)localObject1).btf = new h();
          }
          localObject3 = ((h)localObject1).btf;
        }
        localObject1 = localObject3;
        localObject3 = localObject4;
        break;
        i = localObject2.texture[0];
        ((BaseFilter)localObject3).renderTexture(localObject2.texture[0], ((h)localObject2).width, ((h)localObject2).height);
        if (((h)localObject2).needReleaseFrmae) {
          ((h)localObject2).tN();
        }
        localObject2 = localObject1;
      }
    }
    AppMethodBeat.o(86331);
  }
  
  public void RenderProcessBitmap(Bitmap paramBitmap, h paramh)
  {
    AppMethodBeat.i(86334);
    com.tencent.view.f localf = com.tencent.view.f.as(paramBitmap);
    if (b.BzL < 0)
    {
      RenderProcess(localf.texture, localf.width, localf.height, localf.texture, 0.0D, paramh);
      g.a(localf.texture, localf.width, localf.height, paramBitmap);
    }
    for (;;)
    {
      if (localf.texture != -20000)
      {
        g.Tn(localf.texture);
        localf.texture = -20000;
      }
      AppMethodBeat.o(86334);
      return;
      RenderProcess(localf.texture, localf.width, localf.height, -2, 0.0D, paramh);
      GLSLRender.nativePushBitmapFromTexture(paramBitmap, b.BzL);
    }
  }
  
  public BaseFilter addParam(m paramm)
  {
    AppMethodBeat.i(86319);
    if (paramm == null)
    {
      AppMethodBeat.o(86319);
      return this;
    }
    m localm = (m)this.mParamList.get(paramm.name);
    if (localm == null) {
      this.mParamList.put(paramm.name, paramm);
    }
    for (;;)
    {
      AppMethodBeat.o(86319);
      return this;
      paramm.handle = localm.handle;
      this.mParamList.put(paramm.name, paramm);
    }
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean checkApplyGLSLFilterResult()
  {
    return this.glFilterId != 0L;
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(86322);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).clear();
    }
    nativeClear(this.glFilterId);
    this.glFilterId = 0L;
    this.mProgramIds = 0;
    AppMethodBeat.o(86322);
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
      paramh = paramh.btf;
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
    AppMethodBeat.i(86321);
    int i = getTheFilterIndex(getLastFilter());
    AppMethodBeat.o(86321);
    return i;
  }
  
  public m getParam(String paramString)
  {
    AppMethodBeat.i(86320);
    paramString = (m)this.mParamList.get(paramString);
    AppMethodBeat.o(86320);
    return paramString;
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
    AppMethodBeat.i(86325);
    if ((this.glsl_programShader != null) && (this.glsl_vertextShader != null))
    {
      this.glFilterId = nativeInitialWithString(this.glFilterId, paramInt, this.glsl_vertextShader, this.glsl_programShader);
      AppMethodBeat.o(86325);
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
      AppMethodBeat.o(86325);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      this.glFilterId = nativeInitialWithString(this.glFilterId, paramInt, this.glsl_vertextShader, this.defaultLensShader);
      AppMethodBeat.o(86325);
    }
  }
  
  public boolean isAdjustFilter()
  {
    return false;
  }
  
  public boolean isClass(String paramString)
  {
    AppMethodBeat.i(86326);
    try
    {
      Class.forName(paramString);
      AppMethodBeat.o(86326);
      return true;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(86326);
    }
    return false;
  }
  
  public boolean isGPUProcess()
  {
    return this.mIsGPU;
  }
  
  public boolean isNormal()
  {
    return (this.glsl_programID == GLSLRender.btg) && (this.mNextFilter == null);
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
    AppMethodBeat.i(86342);
    boolean bool = nativeSetGlobalTextureMatrix(this.glFilterId, paramArrayOfFloat);
    AppMethodBeat.o(86342);
    return bool;
  }
  
  public boolean nativeSetRotationAndFlip(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86345);
    boolean bool = nativeSetRotationAndFlip(this.glFilterId, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(86345);
    return bool;
  }
  
  protected native boolean nativeSetRotationAndFlip(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  protected native boolean nativeUpdateMatrix(long paramLong, float[] paramArrayOfFloat);
  
  public boolean nativeUpdateMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(86343);
    boolean bool = nativeUpdateMatrix(this.glFilterId, paramArrayOfFloat);
    AppMethodBeat.o(86343);
    return bool;
  }
  
  protected native boolean nativeUpdateModelMatrix(long paramLong, float[] paramArrayOfFloat);
  
  public boolean nativeUpdateModelMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(86344);
    boolean bool = nativeUpdateModelMatrix(this.glFilterId, paramArrayOfFloat);
    AppMethodBeat.o(86344);
    return bool;
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
    AppMethodBeat.i(86336);
    i.m("BaseFilterParam", "Class:" + getClass().getSimpleName());
    i.m("BaseFilterParam", "mProgramIds:" + this.mProgramIds);
    i.m("BaseFilterParam", "mParamList:" + this.mParamList);
    boolean bool = nativeRenderTexture(this.glFilterId, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(86336);
    return bool;
  }
  
  public void setAdjustParam(float paramFloat) {}
  
  public void setEffectIndex(int paramInt) {}
  
  protected void setGlobalTextureMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(86329);
    nativeSetGlobalTextureMatrix(this.glFilterId, paramArrayOfFloat);
    if (this.mNextFilter != null) {
      this.mNextFilter.setGlobalTextureMatrix(paramArrayOfFloat);
    }
    AppMethodBeat.o(86329);
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
    AppMethodBeat.i(86337);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).setParams(this.mProgramIds);
    }
    AppMethodBeat.o(86337);
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(86338);
    boolean bool = nativeSetPositions(this.glFilterId, paramArrayOfFloat);
    AppMethodBeat.o(86338);
    return bool;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    AppMethodBeat.i(86340);
    boolean bool = nativeSetRenderMode(this.glFilterId, paramInt);
    AppMethodBeat.o(86340);
    return bool;
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
    AppMethodBeat.i(86339);
    boolean bool = nativeSetTexCords(this.glFilterId, paramArrayOfFloat);
    AppMethodBeat.o(86339);
    return bool;
  }
  
  public void setTextureParam(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(86318);
    paramInt2 += 2;
    String str = "inputImageTexture".concat(String.valueOf(paramInt2));
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
    AppMethodBeat.o(86318);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.BaseFilter
 * JD-Core Version:    0.7.0.1
 */