package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.b.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  implements TXBeautyManager
{
  private f a;
  private d b;
  private int c;
  private a d;
  private boolean e;
  
  public b(f paramf)
  {
    AppMethodBeat.i(187072);
    this.e = true;
    this.a = paramf;
    this.d = new a();
    enableSharpnessEnhancement(true);
    setFilterStrength(0.5F);
    AppMethodBeat.o(187072);
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
      this.b.k(this.d.h);
      this.b.j(this.d.i);
      this.b.l(this.d.j);
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
      this.b.a(this.d.B, true);
    }
    this.b.a(this.d.z);
    this.b.a(this.d.A);
    this.b.a(this.d.x);
    this.b.c(this.d.y);
    AppMethodBeat.o(15180);
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(187074);
    if (paramBoolean)
    {
      this.b.c(this.d.a);
      this.b.d(this.d.b);
      this.b.e(this.d.c);
      this.b.f(this.d.d);
      AppMethodBeat.o(187074);
      return;
    }
    this.b.c(0);
    this.b.d(0);
    this.b.e(0);
    this.b.f(0);
    AppMethodBeat.o(187074);
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
    AppMethodBeat.i(187081);
    TXCLog.d("TXBeautyManager", "enableSharpnessEnhancement enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    a locala = this.d;
    if (paramBoolean) {
      i = 4;
    }
    locala.d = i;
    if ((this.b != null) && (this.e)) {
      this.b.f(this.d.d);
    }
    AppMethodBeat.o(187081);
  }
  
  public void setBeautyLevel(int paramInt)
  {
    AppMethodBeat.i(187079);
    TXCLog.d("TXBeautyManager", "setBeautyLevel beautyLevel:".concat(String.valueOf(paramInt)));
    this.d.a = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.c(paramInt);
    }
    AppMethodBeat.o(187079);
  }
  
  public void setBeautyStyle(int paramInt)
  {
    AppMethodBeat.i(187075);
    TXCLog.d("TXBeautyManager", "setBeautyStyle beautyStyle:".concat(String.valueOf(paramInt)));
    this.c = paramInt;
    if (this.b != null) {
      this.b.b(paramInt);
    }
    AppMethodBeat.o(187075);
  }
  
  public void setChinLevel(int paramInt)
  {
    AppMethodBeat.i(187086);
    TXCLog.d("TXBeautyManager", "setChinLevel chinLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187086);
      return;
    }
    this.d.h = paramInt;
    if (this.b != null) {
      this.b.k(paramInt);
    }
    AppMethodBeat.o(187086);
  }
  
  public void setEyeAngleLevel(int paramInt)
  {
    AppMethodBeat.i(187096);
    TXCLog.d("TXBeautyManager", "setEyeAngleLevel eyeAngleLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187096);
      return;
    }
    this.d.r = paramInt;
    if (this.b != null) {
      this.b.t(paramInt);
    }
    AppMethodBeat.o(187096);
  }
  
  public void setEyeDistanceLevel(int paramInt)
  {
    AppMethodBeat.i(187095);
    TXCLog.d("TXBeautyManager", "setEyeDistanceLevel eyeDistanceLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187095);
      return;
    }
    this.d.q = paramInt;
    if (this.b != null) {
      this.b.s(paramInt);
    }
    AppMethodBeat.o(187095);
  }
  
  public void setEyeLightenLevel(int paramInt)
  {
    AppMethodBeat.i(187089);
    TXCLog.d("TXBeautyManager", "setEyeLightenLevel eyeLightenLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187089);
      return;
    }
    this.d.k = paramInt;
    if (this.b != null) {
      this.b.m(paramInt);
    }
    AppMethodBeat.o(187089);
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    AppMethodBeat.i(187083);
    TXCLog.d("TXBeautyManager", "setEyeScaleLevel eyeScaleLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187083);
      return;
    }
    this.d.e = paramInt;
    if (this.b != null) {
      this.b.g(paramInt);
    }
    AppMethodBeat.o(187083);
  }
  
  public void setFaceBeautyLevel(int paramInt)
  {
    AppMethodBeat.i(187101);
    TXCLog.d("TXBeautyManager", "setFaceBeautyLevel faceBeautyLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187101);
      return;
    }
    this.d.w = paramInt;
    if (this.b != null) {
      this.b.y(paramInt);
    }
    AppMethodBeat.o(187101);
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    AppMethodBeat.i(187087);
    TXCLog.d("TXBeautyManager", "setFaceShortLevel faceShortLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187087);
      return;
    }
    this.d.i = paramInt;
    if (this.b != null) {
      this.b.j(paramInt);
    }
    AppMethodBeat.o(187087);
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    AppMethodBeat.i(187084);
    TXCLog.d("TXBeautyManager", "setFaceSlimLevel faceSlimLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187084);
      return;
    }
    this.d.f = paramInt;
    if (this.b != null) {
      this.b.h(paramInt);
    }
    AppMethodBeat.o(187084);
  }
  
  public void setFaceVLevel(int paramInt)
  {
    AppMethodBeat.i(187085);
    TXCLog.d("TXBeautyManager", "setFaceVLevel faceVLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187085);
      return;
    }
    this.d.g = paramInt;
    if (this.b != null) {
      this.b.i(paramInt);
    }
    AppMethodBeat.o(187085);
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    AppMethodBeat.i(187076);
    TXCLog.d("TXBeautyManager", "setFilter image:".concat(String.valueOf(paramBitmap)));
    this.d.z = paramBitmap;
    if (this.b != null) {
      this.b.a(paramBitmap);
    }
    AppMethodBeat.o(187076);
  }
  
  public void setFilterStrength(float paramFloat)
  {
    AppMethodBeat.i(187077);
    TXCLog.d("TXBeautyManager", "setFilterStrength strength:".concat(String.valueOf(paramFloat)));
    this.d.A = paramFloat;
    if (this.b != null) {
      this.b.a(paramFloat);
    }
    AppMethodBeat.o(187077);
  }
  
  public void setForeheadLevel(int paramInt)
  {
    AppMethodBeat.i(187094);
    TXCLog.d("TXBeautyManager", "setForeheadLevel foreheadLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187094);
      return;
    }
    this.d.p = paramInt;
    if (this.b != null) {
      this.b.r(paramInt);
    }
    AppMethodBeat.o(187094);
  }
  
  public void setGreenScreenFile(String paramString)
  {
    AppMethodBeat.i(187078);
    TXCLog.d("TXBeautyManager", "setGreenScreenFile path:".concat(String.valueOf(paramString)));
    this.d.B = paramString;
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile system version below 18");
      AppMethodBeat.o(187078);
      return;
    }
    if (!this.a.a())
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile is only supported in EnterprisePro license");
      AppMethodBeat.o(187078);
      return;
    }
    if (this.b != null) {
      this.b.a(paramString, true);
    }
    AppMethodBeat.o(187078);
  }
  
  public void setLipsThicknessLevel(int paramInt)
  {
    AppMethodBeat.i(187100);
    TXCLog.d("TXBeautyManager", "setLipsThicknessLevel lipsThicknessLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187100);
      return;
    }
    this.d.v = paramInt;
    if (this.b != null) {
      this.b.x(paramInt);
    }
    AppMethodBeat.o(187100);
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    AppMethodBeat.i(187103);
    TXCLog.d("TXBeautyManager", "setMotionMute motionMute:".concat(String.valueOf(paramBoolean)));
    this.d.y = paramBoolean;
    if (this.b != null) {
      this.b.c(paramBoolean);
    }
    AppMethodBeat.o(187103);
  }
  
  public void setMotionTmpl(String paramString)
  {
    AppMethodBeat.i(187102);
    TXCLog.d("TXBeautyManager", "setMotionTmpl tmplPath:".concat(String.valueOf(paramString)));
    this.d.x = paramString;
    if (this.b != null) {
      this.b.a(paramString);
    }
    AppMethodBeat.o(187102);
  }
  
  public void setMouthShapeLevel(int paramInt)
  {
    AppMethodBeat.i(187097);
    TXCLog.d("TXBeautyManager", "setMouthShapeLevel mouthShapeLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187097);
      return;
    }
    this.d.s = paramInt;
    if (this.b != null) {
      this.b.u(paramInt);
    }
    AppMethodBeat.o(187097);
  }
  
  public void setNosePositionLevel(int paramInt)
  {
    AppMethodBeat.i(187099);
    TXCLog.d("TXBeautyManager", "setNosePositionLevel nosePositionLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187099);
      return;
    }
    this.d.u = paramInt;
    if (this.b != null) {
      this.b.w(paramInt);
    }
    AppMethodBeat.o(187099);
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    AppMethodBeat.i(187088);
    TXCLog.d("TXBeautyManager", "setNoseSlimLevel noseSlimLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187088);
      return;
    }
    this.d.j = paramInt;
    if (this.b != null) {
      this.b.l(paramInt);
    }
    AppMethodBeat.o(187088);
  }
  
  public void setNoseWingLevel(int paramInt)
  {
    AppMethodBeat.i(187098);
    TXCLog.d("TXBeautyManager", "setNoseWingLevel noseWingLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187098);
      return;
    }
    this.d.t = paramInt;
    if (this.b != null) {
      this.b.v(paramInt);
    }
    AppMethodBeat.o(187098);
  }
  
  public void setPounchRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(187092);
    TXCLog.d("TXBeautyManager", "setPounchRemoveLevel pounchRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187092);
      return;
    }
    this.d.n = paramInt;
    if (this.b != null) {
      this.b.p(paramInt);
    }
    AppMethodBeat.o(187092);
  }
  
  public void setPreprocessor(d paramd)
  {
    AppMethodBeat.i(187073);
    this.b = paramd;
    if (this.b != null) {
      a();
    }
    AppMethodBeat.o(187073);
  }
  
  public void setRuddyLevel(int paramInt)
  {
    AppMethodBeat.i(187082);
    TXCLog.d("TXBeautyManager", "setRuddyLevel ruddyLevel:".concat(String.valueOf(paramInt)));
    this.d.c = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.e(paramInt);
    }
    AppMethodBeat.o(187082);
  }
  
  public void setSmileLinesRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(187093);
    TXCLog.d("TXBeautyManager", "setSmileLinesRemoveLevel smileLinesRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187093);
      return;
    }
    this.d.o = paramInt;
    if (this.b != null) {
      this.b.q(paramInt);
    }
    AppMethodBeat.o(187093);
  }
  
  public void setToothWhitenLevel(int paramInt)
  {
    AppMethodBeat.i(187090);
    TXCLog.d("TXBeautyManager", "setToothWhitenLevel toothWhitenLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187090);
      return;
    }
    this.d.l = paramInt;
    if (this.b != null) {
      this.b.n(paramInt);
    }
    AppMethodBeat.o(187090);
  }
  
  public void setWhitenessLevel(int paramInt)
  {
    AppMethodBeat.i(187080);
    TXCLog.d("TXBeautyManager", "setWhitenessLevel whitenessLevel:".concat(String.valueOf(paramInt)));
    this.d.b = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.d(paramInt);
    }
    AppMethodBeat.o(187080);
  }
  
  public void setWrinkleRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(187091);
    TXCLog.d("TXBeautyManager", "setWrinkleRemoveLevel wrinkleRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(187091);
      return;
    }
    this.d.m = paramInt;
    if (this.b != null) {
      this.b.o(paramInt);
    }
    AppMethodBeat.o(187091);
  }
  
  class a
  {
    public float A;
    public String B;
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
    public String x;
    public boolean y;
    public Bitmap z;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b
 * JD-Core Version:    0.7.0.1
 */