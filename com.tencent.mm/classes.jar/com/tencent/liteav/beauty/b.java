package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.license.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  implements TXBeautyManager
{
  private e a;
  private d b;
  private int c;
  private a d;
  private boolean e;
  
  public b(e parame)
  {
    AppMethodBeat.i(231755);
    this.e = true;
    this.a = parame;
    this.d = new a();
    enableSharpnessEnhancement(true);
    setFilterStrength(0.5F);
    AppMethodBeat.o(231755);
  }
  
  private int a(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(231812);
    paramInt = Math.round(paramInt * paramFloat);
    AppMethodBeat.o(231812);
    return paramInt;
  }
  
  private void a()
  {
    AppMethodBeat.i(15180);
    TXCLog.d("TXBeautyManager", "applyBeautyParams");
    this.b.b(this.c);
    b(this.e);
    if (this.a.a())
    {
      this.b.g(this.d.e);
      this.b.h(this.d.f);
      this.b.i(this.d.g);
      this.b.j(this.d.h);
      this.b.l(this.d.i);
      this.b.k(this.d.j);
      this.b.m(this.d.k);
      this.b.n(this.d.l);
      this.b.o(this.d.m);
      this.b.p(this.d.n);
      this.b.q(this.d.o);
      this.b.r(this.d.p);
      this.b.s(this.d.q);
      this.b.t(this.d.r);
      this.b.u(this.d.s);
      this.b.v(this.d.t);
      this.b.w(this.d.u);
      this.b.x(this.d.v);
      this.b.y(this.d.w);
      this.b.z(this.d.x);
      this.b.a(this.d.C, true);
    }
    this.b.a(this.d.A);
    this.b.a(this.d.B);
    this.b.a(this.d.y);
    this.b.c(this.d.z);
    AppMethodBeat.o(15180);
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(231761);
    if (paramBoolean)
    {
      this.b.c(this.d.a);
      this.b.d(this.d.b);
      this.b.e(this.d.c);
      this.b.f(this.d.d);
      AppMethodBeat.o(231761);
      return;
    }
    this.b.c(0);
    this.b.d(0);
    this.b.e(0);
    this.b.f(0);
    AppMethodBeat.o(231761);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(15168);
    this.e = paramBoolean;
    b(paramBoolean);
    AppMethodBeat.o(15168);
  }
  
  public void enableSharpnessEnhancement(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(231772);
    TXCLog.d("TXBeautyManager", "enableSharpnessEnhancement enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    a locala = this.d;
    if (paramBoolean) {
      i = 4;
    }
    locala.d = i;
    if ((this.b != null) && (this.e)) {
      this.b.f(this.d.d);
    }
    AppMethodBeat.o(231772);
  }
  
  public void setBeautyLevel(float paramFloat)
  {
    AppMethodBeat.i(231769);
    TXCLog.d("TXBeautyManager", "setBeautyLevel beautyLevel:".concat(String.valueOf(paramFloat)));
    this.d.a = ((int)paramFloat);
    if ((this.b != null) && (this.e)) {
      this.b.c(this.d.a);
    }
    AppMethodBeat.o(231769);
  }
  
  public void setBeautyStyle(int paramInt)
  {
    AppMethodBeat.i(231764);
    TXCLog.d("TXBeautyManager", "setBeautyStyle beautyStyle:".concat(String.valueOf(paramInt)));
    this.c = paramInt;
    if (this.b != null) {
      this.b.b(paramInt);
    }
    AppMethodBeat.o(231764);
  }
  
  public void setChinLevel(float paramFloat)
  {
    AppMethodBeat.i(231782);
    TXCLog.d("TXBeautyManager", "setChinLevel chinLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231782);
      return;
    }
    this.d.i = a(paramFloat, 15);
    if (this.b != null) {
      this.b.l(this.d.i);
    }
    AppMethodBeat.o(231782);
  }
  
  public void setEyeAngleLevel(float paramFloat)
  {
    AppMethodBeat.i(231797);
    TXCLog.d("TXBeautyManager", "setEyeAngleLevel eyeAngleLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231797);
      return;
    }
    this.d.s = a(paramFloat, 10);
    if (this.b != null) {
      this.b.u(this.d.s);
    }
    AppMethodBeat.o(231797);
  }
  
  public void setEyeDistanceLevel(float paramFloat)
  {
    AppMethodBeat.i(231796);
    TXCLog.d("TXBeautyManager", "setEyeDistanceLevel eyeDistanceLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231796);
      return;
    }
    this.d.r = a(paramFloat, 10);
    if (this.b != null) {
      this.b.t(this.d.r);
    }
    AppMethodBeat.o(231796);
  }
  
  public void setEyeLightenLevel(float paramFloat)
  {
    AppMethodBeat.i(231787);
    TXCLog.d("TXBeautyManager", "setEyeLightenLevel eyeLightenLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231787);
      return;
    }
    this.d.l = a(paramFloat, 10);
    if (this.b != null) {
      this.b.n(this.d.l);
    }
    AppMethodBeat.o(231787);
  }
  
  public void setEyeScaleLevel(float paramFloat)
  {
    AppMethodBeat.i(231775);
    TXCLog.d("TXBeautyManager", "setEyeScaleLevel eyeScaleLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231775);
      return;
    }
    this.d.e = a(paramFloat, 15);
    if (this.b != null) {
      this.b.g(this.d.e);
    }
    AppMethodBeat.o(231775);
  }
  
  public void setFaceBeautyLevel(float paramFloat)
  {
    AppMethodBeat.i(231807);
    TXCLog.d("TXBeautyManager", "setFaceBeautyLevel faceBeautyLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231807);
      return;
    }
    this.d.x = a(paramFloat, 10);
    if (this.b != null) {
      this.b.z(this.d.x);
    }
    AppMethodBeat.o(231807);
  }
  
  public void setFaceNarrowLevel(float paramFloat)
  {
    AppMethodBeat.i(231778);
    TXCLog.d("TXBeautyManager", "setFaceNarrowLevel faceNarrowLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231778);
      return;
    }
    this.d.g = a(paramFloat, 15);
    if (this.b != null) {
      this.b.i(this.d.g);
    }
    AppMethodBeat.o(231778);
  }
  
  public void setFaceShortLevel(float paramFloat)
  {
    AppMethodBeat.i(231783);
    TXCLog.d("TXBeautyManager", "setFaceShortLevel faceShortLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231783);
      return;
    }
    this.d.j = a(paramFloat, 15);
    if (this.b != null) {
      this.b.k(this.d.j);
    }
    AppMethodBeat.o(231783);
  }
  
  public void setFaceSlimLevel(float paramFloat)
  {
    AppMethodBeat.i(231777);
    TXCLog.d("TXBeautyManager", "setFaceSlimLevel faceSlimLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231777);
      return;
    }
    this.d.f = a(paramFloat, 15);
    if (this.b != null) {
      this.b.h(this.d.f);
    }
    AppMethodBeat.o(231777);
  }
  
  public void setFaceVLevel(float paramFloat)
  {
    AppMethodBeat.i(231780);
    TXCLog.d("TXBeautyManager", "setFaceVLevel faceVLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231780);
      return;
    }
    this.d.h = a(paramFloat, 15);
    if (this.b != null) {
      this.b.j(this.d.h);
    }
    AppMethodBeat.o(231780);
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    AppMethodBeat.i(231765);
    TXCLog.d("TXBeautyManager", "setFilter image:".concat(String.valueOf(paramBitmap)));
    this.d.A = paramBitmap;
    if (this.b != null) {
      this.b.a(paramBitmap);
    }
    AppMethodBeat.o(231765);
  }
  
  public void setFilterStrength(float paramFloat)
  {
    AppMethodBeat.i(231766);
    TXCLog.d("TXBeautyManager", "setFilterStrength strength:".concat(String.valueOf(paramFloat)));
    this.d.B = paramFloat;
    if (this.b != null) {
      this.b.a(paramFloat);
    }
    AppMethodBeat.o(231766);
  }
  
  public void setForeheadLevel(float paramFloat)
  {
    AppMethodBeat.i(231795);
    TXCLog.d("TXBeautyManager", "setForeheadLevel foreheadLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231795);
      return;
    }
    this.d.q = a(paramFloat, 10);
    if (this.b != null) {
      this.b.s(this.d.q);
    }
    AppMethodBeat.o(231795);
  }
  
  public void setGreenScreenFile(String paramString)
  {
    AppMethodBeat.i(231768);
    TXCLog.d("TXBeautyManager", "setGreenScreenFile path:".concat(String.valueOf(paramString)));
    this.d.C = paramString;
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile system version below 18");
      AppMethodBeat.o(231768);
      return;
    }
    if (!this.a.a())
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile is only supported in EnterprisePro license");
      AppMethodBeat.o(231768);
      return;
    }
    if (this.b != null) {
      this.b.a(paramString, true);
    }
    AppMethodBeat.o(231768);
  }
  
  public void setLipsThicknessLevel(float paramFloat)
  {
    AppMethodBeat.i(231805);
    TXCLog.d("TXBeautyManager", "setLipsThicknessLevel lipsThicknessLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231805);
      return;
    }
    this.d.w = a(paramFloat, 10);
    if (this.b != null) {
      this.b.y(this.d.w);
    }
    AppMethodBeat.o(231805);
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    AppMethodBeat.i(231811);
    TXCLog.d("TXBeautyManager", "setMotionMute motionMute:".concat(String.valueOf(paramBoolean)));
    this.d.z = paramBoolean;
    if (this.b != null) {
      this.b.c(paramBoolean);
    }
    AppMethodBeat.o(231811);
  }
  
  public void setMotionTmpl(String paramString)
  {
    AppMethodBeat.i(231809);
    TXCLog.d("TXBeautyManager", "setMotionTmpl tmplPath:".concat(String.valueOf(paramString)));
    this.d.y = paramString;
    if (this.b != null) {
      this.b.a(paramString);
    }
    AppMethodBeat.o(231809);
  }
  
  public void setMouthShapeLevel(float paramFloat)
  {
    AppMethodBeat.i(231800);
    TXCLog.d("TXBeautyManager", "setMouthShapeLevel mouthShapeLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231800);
      return;
    }
    this.d.t = a(paramFloat, 10);
    if (this.b != null) {
      this.b.v(this.d.t);
    }
    AppMethodBeat.o(231800);
  }
  
  public void setNosePositionLevel(float paramFloat)
  {
    AppMethodBeat.i(231803);
    TXCLog.d("TXBeautyManager", "setNosePositionLevel nosePositionLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231803);
      return;
    }
    this.d.v = a(paramFloat, 10);
    if (this.b != null) {
      this.b.x(this.d.v);
    }
    AppMethodBeat.o(231803);
  }
  
  public void setNoseSlimLevel(float paramFloat)
  {
    AppMethodBeat.i(231785);
    TXCLog.d("TXBeautyManager", "setNoseSlimLevel noseSlimLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231785);
      return;
    }
    this.d.k = a(paramFloat, 15);
    if (this.b != null) {
      this.b.m(this.d.k);
    }
    AppMethodBeat.o(231785);
  }
  
  public void setNoseWingLevel(float paramFloat)
  {
    AppMethodBeat.i(231802);
    TXCLog.d("TXBeautyManager", "setNoseWingLevel noseWingLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231802);
      return;
    }
    this.d.u = a(paramFloat, 10);
    if (this.b != null) {
      this.b.w(this.d.u);
    }
    AppMethodBeat.o(231802);
  }
  
  public void setPounchRemoveLevel(float paramFloat)
  {
    AppMethodBeat.i(231791);
    TXCLog.d("TXBeautyManager", "setPounchRemoveLevel pounchRemoveLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231791);
      return;
    }
    this.d.o = a(paramFloat, 10);
    if (this.b != null) {
      this.b.q(this.d.o);
    }
    AppMethodBeat.o(231791);
  }
  
  public void setPreprocessor(d paramd)
  {
    AppMethodBeat.i(231756);
    this.b = paramd;
    if (this.b != null) {
      a();
    }
    AppMethodBeat.o(231756);
  }
  
  public void setRuddyLevel(float paramFloat)
  {
    AppMethodBeat.i(231774);
    TXCLog.d("TXBeautyManager", "setRuddyLevel ruddyLevel:".concat(String.valueOf(paramFloat)));
    this.d.c = ((int)paramFloat);
    if ((this.b != null) && (this.e)) {
      this.b.e(this.d.c);
    }
    AppMethodBeat.o(231774);
  }
  
  public void setSmileLinesRemoveLevel(float paramFloat)
  {
    AppMethodBeat.i(231794);
    TXCLog.d("TXBeautyManager", "setSmileLinesRemoveLevel smileLinesRemoveLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231794);
      return;
    }
    this.d.p = a(paramFloat, 10);
    if (this.b != null) {
      this.b.r(this.d.p);
    }
    AppMethodBeat.o(231794);
  }
  
  public void setToothWhitenLevel(float paramFloat)
  {
    AppMethodBeat.i(231788);
    TXCLog.d("TXBeautyManager", "setToothWhitenLevel toothWhitenLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231788);
      return;
    }
    this.d.m = a(paramFloat, 10);
    if (this.b != null) {
      this.b.o(this.d.m);
    }
    AppMethodBeat.o(231788);
  }
  
  public void setWhitenessLevel(float paramFloat)
  {
    AppMethodBeat.i(231770);
    TXCLog.d("TXBeautyManager", "setWhitenessLevel whitenessLevel:".concat(String.valueOf(paramFloat)));
    this.d.b = ((int)paramFloat);
    if ((this.b != null) && (this.e)) {
      this.b.d(this.d.b);
    }
    AppMethodBeat.o(231770);
  }
  
  public void setWrinkleRemoveLevel(float paramFloat)
  {
    AppMethodBeat.i(231789);
    TXCLog.d("TXBeautyManager", "setWrinkleRemoveLevel wrinkleRemoveLevel:".concat(String.valueOf(paramFloat)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(231789);
      return;
    }
    this.d.n = a(paramFloat, 10);
    if (this.b != null) {
      this.b.p(this.d.n);
    }
    AppMethodBeat.o(231789);
  }
  
  class a
  {
    public Bitmap A;
    public float B;
    public String C;
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
    public int w;
    public int x;
    public String y;
    public boolean z;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b
 * JD-Core Version:    0.7.0.1
 */