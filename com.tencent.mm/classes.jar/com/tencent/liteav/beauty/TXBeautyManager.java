package com.tencent.liteav.beauty;

import com.tencent.liteav.basic.b.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXBeautyManager
{
  private static final String TAG = "TXBeautyManager";
  private a mBeautyParams;
  private int mBeautyStyle;
  private f mLicenceControl;
  private c mVideoPreprocessor;
  
  public TXBeautyManager(f paramf)
  {
    AppMethodBeat.i(15132);
    this.mLicenceControl = paramf;
    this.mBeautyParams = new a();
    AppMethodBeat.o(15132);
  }
  
  private void applyBeautyParams()
  {
    AppMethodBeat.i(15134);
    TXCLog.d("TXBeautyManager", "applyBeautyParams");
    this.mVideoPreprocessor.c(this.mBeautyStyle);
    this.mVideoPreprocessor.d(this.mBeautyParams.a);
    this.mVideoPreprocessor.e(this.mBeautyParams.b);
    this.mVideoPreprocessor.f(this.mBeautyParams.c);
    if (this.mLicenceControl.a())
    {
      this.mVideoPreprocessor.h(this.mBeautyParams.d);
      this.mVideoPreprocessor.i(this.mBeautyParams.e);
      this.mVideoPreprocessor.j(this.mBeautyParams.f);
      this.mVideoPreprocessor.l(this.mBeautyParams.g);
      this.mVideoPreprocessor.k(this.mBeautyParams.h);
      this.mVideoPreprocessor.m(this.mBeautyParams.i);
      this.mVideoPreprocessor.n(this.mBeautyParams.j);
      this.mVideoPreprocessor.o(this.mBeautyParams.k);
      this.mVideoPreprocessor.p(this.mBeautyParams.l);
      this.mVideoPreprocessor.q(this.mBeautyParams.m);
      this.mVideoPreprocessor.r(this.mBeautyParams.n);
      this.mVideoPreprocessor.s(this.mBeautyParams.o);
      this.mVideoPreprocessor.t(this.mBeautyParams.p);
      this.mVideoPreprocessor.u(this.mBeautyParams.q);
      this.mVideoPreprocessor.v(this.mBeautyParams.r);
      this.mVideoPreprocessor.w(this.mBeautyParams.s);
      this.mVideoPreprocessor.x(this.mBeautyParams.t);
      this.mVideoPreprocessor.y(this.mBeautyParams.u);
      this.mVideoPreprocessor.z(this.mBeautyParams.v);
    }
    this.mVideoPreprocessor.a(this.mBeautyParams.w);
    this.mVideoPreprocessor.d(this.mBeautyParams.x);
    AppMethodBeat.o(15134);
  }
  
  public void setBeautyLevel(int paramInt)
  {
    AppMethodBeat.i(15136);
    TXCLog.d("TXBeautyManager", "setBeautyLevel beautyLevel:".concat(String.valueOf(paramInt)));
    this.mBeautyParams.a = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.d(paramInt);
    }
    AppMethodBeat.o(15136);
  }
  
  public void setBeautyStyle(int paramInt)
  {
    AppMethodBeat.i(15135);
    TXCLog.d("TXBeautyManager", "setBeautyStyle beautyStyle:".concat(String.valueOf(paramInt)));
    this.mBeautyStyle = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.c(paramInt);
    }
    AppMethodBeat.o(15135);
  }
  
  public void setChinLevel(int paramInt)
  {
    AppMethodBeat.i(15142);
    TXCLog.d("TXBeautyManager", "setChinLevel chinLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15142);
      return;
    }
    this.mBeautyParams.g = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.l(paramInt);
    }
    AppMethodBeat.o(15142);
  }
  
  public void setEyeAngleLevel(int paramInt)
  {
    AppMethodBeat.i(15152);
    TXCLog.d("TXBeautyManager", "setEyeAngleLevel eyeAngleLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15152);
      return;
    }
    this.mBeautyParams.q = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.u(paramInt);
    }
    AppMethodBeat.o(15152);
  }
  
  public void setEyeDistanceLevel(int paramInt)
  {
    AppMethodBeat.i(15151);
    TXCLog.d("TXBeautyManager", "setEyeDistanceLevel eyeDistanceLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15151);
      return;
    }
    this.mBeautyParams.p = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.t(paramInt);
    }
    AppMethodBeat.o(15151);
  }
  
  public void setEyeLightenLevel(int paramInt)
  {
    AppMethodBeat.i(15145);
    TXCLog.d("TXBeautyManager", "setEyeLightenLevel eyeLightenLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15145);
      return;
    }
    this.mBeautyParams.j = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.n(paramInt);
    }
    AppMethodBeat.o(15145);
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    AppMethodBeat.i(15139);
    TXCLog.d("TXBeautyManager", "setEyeScaleLevel eyeScaleLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15139);
      return;
    }
    this.mBeautyParams.d = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.h(paramInt);
    }
    AppMethodBeat.o(15139);
  }
  
  public void setFaceBeautyLevel(int paramInt)
  {
    AppMethodBeat.i(15157);
    TXCLog.d("TXBeautyManager", "setFaceBeautyLevel faceBeautyLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15157);
      return;
    }
    this.mBeautyParams.v = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.z(paramInt);
    }
    AppMethodBeat.o(15157);
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    AppMethodBeat.i(15143);
    TXCLog.d("TXBeautyManager", "setFaceShortLevel faceShortLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15143);
      return;
    }
    this.mBeautyParams.h = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.k(paramInt);
    }
    AppMethodBeat.o(15143);
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    AppMethodBeat.i(15140);
    TXCLog.d("TXBeautyManager", "setFaceSlimLevel faceSlimLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15140);
      return;
    }
    this.mBeautyParams.e = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.i(paramInt);
    }
    AppMethodBeat.o(15140);
  }
  
  public void setFaceVLevel(int paramInt)
  {
    AppMethodBeat.i(15141);
    TXCLog.d("TXBeautyManager", "setFaceVLevel faceVLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15141);
      return;
    }
    this.mBeautyParams.f = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.j(paramInt);
    }
    AppMethodBeat.o(15141);
  }
  
  public void setForeheadLevel(int paramInt)
  {
    AppMethodBeat.i(15150);
    TXCLog.d("TXBeautyManager", "setForeheadLevel foreheadLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15150);
      return;
    }
    this.mBeautyParams.o = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.s(paramInt);
    }
    AppMethodBeat.o(15150);
  }
  
  public void setLipsThicknessLevel(int paramInt)
  {
    AppMethodBeat.i(15156);
    TXCLog.d("TXBeautyManager", "setLipsThicknessLevel lipsThicknessLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15156);
      return;
    }
    this.mBeautyParams.u = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.y(paramInt);
    }
    AppMethodBeat.o(15156);
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    AppMethodBeat.i(15159);
    TXCLog.d("TXBeautyManager", "setMotionMute motionMute:".concat(String.valueOf(paramBoolean)));
    this.mBeautyParams.x = paramBoolean;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.d(paramBoolean);
    }
    AppMethodBeat.o(15159);
  }
  
  public void setMotionTmpl(String paramString)
  {
    AppMethodBeat.i(15158);
    TXCLog.d("TXBeautyManager", "setMotionTmpl tmplPath:".concat(String.valueOf(paramString)));
    this.mBeautyParams.w = paramString;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.a(paramString);
    }
    AppMethodBeat.o(15158);
  }
  
  public void setMouthShapeLevel(int paramInt)
  {
    AppMethodBeat.i(15153);
    TXCLog.d("TXBeautyManager", "setMouthShapeLevel mouthShapeLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15153);
      return;
    }
    this.mBeautyParams.r = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.v(paramInt);
    }
    AppMethodBeat.o(15153);
  }
  
  public void setNosePositionLevel(int paramInt)
  {
    AppMethodBeat.i(15155);
    TXCLog.d("TXBeautyManager", "setNosePositionLevel nosePositionLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15155);
      return;
    }
    this.mBeautyParams.t = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.x(paramInt);
    }
    AppMethodBeat.o(15155);
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    AppMethodBeat.i(15144);
    TXCLog.d("TXBeautyManager", "setNoseSlimLevel noseSlimLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15144);
      return;
    }
    this.mBeautyParams.i = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.m(paramInt);
    }
    AppMethodBeat.o(15144);
  }
  
  public void setNoseWingLevel(int paramInt)
  {
    AppMethodBeat.i(15154);
    TXCLog.d("TXBeautyManager", "setNoseWingLevel noseWingLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15154);
      return;
    }
    this.mBeautyParams.s = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.w(paramInt);
    }
    AppMethodBeat.o(15154);
  }
  
  public void setPounchRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(15148);
    TXCLog.d("TXBeautyManager", "setPounchRemoveLevel pounchRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15148);
      return;
    }
    this.mBeautyParams.m = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.q(paramInt);
    }
    AppMethodBeat.o(15148);
  }
  
  public void setPreprocessor(c paramc)
  {
    AppMethodBeat.i(15133);
    this.mVideoPreprocessor = paramc;
    if (this.mVideoPreprocessor != null) {
      applyBeautyParams();
    }
    AppMethodBeat.o(15133);
  }
  
  public void setRuddyLevel(int paramInt)
  {
    AppMethodBeat.i(15138);
    TXCLog.d("TXBeautyManager", "setRuddyLevel ruddyLevel:".concat(String.valueOf(paramInt)));
    this.mBeautyParams.c = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.f(paramInt);
    }
    AppMethodBeat.o(15138);
  }
  
  public void setSmileLinesRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(15149);
    TXCLog.d("TXBeautyManager", "setSmileLinesRemoveLevel smileLinesRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15149);
      return;
    }
    this.mBeautyParams.n = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.r(paramInt);
    }
    AppMethodBeat.o(15149);
  }
  
  public void setToothWhitenLevel(int paramInt)
  {
    AppMethodBeat.i(15146);
    TXCLog.d("TXBeautyManager", "setToothWhitenLevel toothWhitenLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15146);
      return;
    }
    this.mBeautyParams.k = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.o(paramInt);
    }
    AppMethodBeat.o(15146);
  }
  
  public void setWhitenessLevel(int paramInt)
  {
    AppMethodBeat.i(15137);
    TXCLog.d("TXBeautyManager", "setWhitenessLevel whitenessLevel:".concat(String.valueOf(paramInt)));
    this.mBeautyParams.b = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.e(paramInt);
    }
    AppMethodBeat.o(15137);
  }
  
  public void setWrinkleRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(15147);
    TXCLog.d("TXBeautyManager", "setWrinkleRemoveLevel wrinkleRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.mLicenceControl.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(15147);
      return;
    }
    this.mBeautyParams.l = paramInt;
    if (this.mVideoPreprocessor != null) {
      this.mVideoPreprocessor.p(paramInt);
    }
    AppMethodBeat.o(15147);
  }
  
  class a
  {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public String w;
    public boolean x;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.TXBeautyManager
 * JD-Core Version:    0.7.0.1
 */