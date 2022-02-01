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
    AppMethodBeat.i(221201);
    this.e = true;
    this.a = paramf;
    this.d = new a();
    enableSharpnessEnhancement(true);
    setFilterStrength(0.5F);
    AppMethodBeat.o(221201);
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
    AppMethodBeat.i(221203);
    if (paramBoolean)
    {
      this.b.c(this.d.a);
      this.b.d(this.d.b);
      this.b.e(this.d.c);
      this.b.f(this.d.d);
      AppMethodBeat.o(221203);
      return;
    }
    this.b.c(0);
    this.b.d(0);
    this.b.e(0);
    this.b.f(0);
    AppMethodBeat.o(221203);
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
    AppMethodBeat.i(221210);
    TXCLog.d("TXBeautyManager", "enableSharpnessEnhancement enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    a locala = this.d;
    if (paramBoolean) {
      i = 4;
    }
    locala.d = i;
    if ((this.b != null) && (this.e)) {
      this.b.f(this.d.d);
    }
    AppMethodBeat.o(221210);
  }
  
  public void setBeautyLevel(int paramInt)
  {
    AppMethodBeat.i(221208);
    TXCLog.d("TXBeautyManager", "setBeautyLevel beautyLevel:".concat(String.valueOf(paramInt)));
    this.d.a = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.c(paramInt);
    }
    AppMethodBeat.o(221208);
  }
  
  public void setBeautyStyle(int paramInt)
  {
    AppMethodBeat.i(221204);
    TXCLog.d("TXBeautyManager", "setBeautyStyle beautyStyle:".concat(String.valueOf(paramInt)));
    this.c = paramInt;
    if (this.b != null) {
      this.b.b(paramInt);
    }
    AppMethodBeat.o(221204);
  }
  
  public void setChinLevel(int paramInt)
  {
    AppMethodBeat.i(221215);
    TXCLog.d("TXBeautyManager", "setChinLevel chinLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221215);
      return;
    }
    this.d.h = paramInt;
    if (this.b != null) {
      this.b.k(paramInt);
    }
    AppMethodBeat.o(221215);
  }
  
  public void setEyeAngleLevel(int paramInt)
  {
    AppMethodBeat.i(221225);
    TXCLog.d("TXBeautyManager", "setEyeAngleLevel eyeAngleLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221225);
      return;
    }
    this.d.r = paramInt;
    if (this.b != null) {
      this.b.t(paramInt);
    }
    AppMethodBeat.o(221225);
  }
  
  public void setEyeDistanceLevel(int paramInt)
  {
    AppMethodBeat.i(221224);
    TXCLog.d("TXBeautyManager", "setEyeDistanceLevel eyeDistanceLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221224);
      return;
    }
    this.d.q = paramInt;
    if (this.b != null) {
      this.b.s(paramInt);
    }
    AppMethodBeat.o(221224);
  }
  
  public void setEyeLightenLevel(int paramInt)
  {
    AppMethodBeat.i(221218);
    TXCLog.d("TXBeautyManager", "setEyeLightenLevel eyeLightenLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221218);
      return;
    }
    this.d.k = paramInt;
    if (this.b != null) {
      this.b.m(paramInt);
    }
    AppMethodBeat.o(221218);
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    AppMethodBeat.i(221212);
    TXCLog.d("TXBeautyManager", "setEyeScaleLevel eyeScaleLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221212);
      return;
    }
    this.d.e = paramInt;
    if (this.b != null) {
      this.b.g(paramInt);
    }
    AppMethodBeat.o(221212);
  }
  
  public void setFaceBeautyLevel(int paramInt)
  {
    AppMethodBeat.i(221230);
    TXCLog.d("TXBeautyManager", "setFaceBeautyLevel faceBeautyLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221230);
      return;
    }
    this.d.w = paramInt;
    if (this.b != null) {
      this.b.y(paramInt);
    }
    AppMethodBeat.o(221230);
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    AppMethodBeat.i(221216);
    TXCLog.d("TXBeautyManager", "setFaceShortLevel faceShortLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221216);
      return;
    }
    this.d.i = paramInt;
    if (this.b != null) {
      this.b.j(paramInt);
    }
    AppMethodBeat.o(221216);
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    AppMethodBeat.i(221213);
    TXCLog.d("TXBeautyManager", "setFaceSlimLevel faceSlimLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221213);
      return;
    }
    this.d.f = paramInt;
    if (this.b != null) {
      this.b.h(paramInt);
    }
    AppMethodBeat.o(221213);
  }
  
  public void setFaceVLevel(int paramInt)
  {
    AppMethodBeat.i(221214);
    TXCLog.d("TXBeautyManager", "setFaceVLevel faceVLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221214);
      return;
    }
    this.d.g = paramInt;
    if (this.b != null) {
      this.b.i(paramInt);
    }
    AppMethodBeat.o(221214);
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    AppMethodBeat.i(221205);
    TXCLog.d("TXBeautyManager", "setFilter image:".concat(String.valueOf(paramBitmap)));
    this.d.z = paramBitmap;
    if (this.b != null) {
      this.b.a(paramBitmap);
    }
    AppMethodBeat.o(221205);
  }
  
  public void setFilterStrength(float paramFloat)
  {
    AppMethodBeat.i(221206);
    TXCLog.d("TXBeautyManager", "setFilterStrength strength:".concat(String.valueOf(paramFloat)));
    this.d.A = paramFloat;
    if (this.b != null) {
      this.b.a(paramFloat);
    }
    AppMethodBeat.o(221206);
  }
  
  public void setForeheadLevel(int paramInt)
  {
    AppMethodBeat.i(221223);
    TXCLog.d("TXBeautyManager", "setForeheadLevel foreheadLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221223);
      return;
    }
    this.d.p = paramInt;
    if (this.b != null) {
      this.b.r(paramInt);
    }
    AppMethodBeat.o(221223);
  }
  
  public void setGreenScreenFile(String paramString)
  {
    AppMethodBeat.i(221207);
    TXCLog.d("TXBeautyManager", "setGreenScreenFile path:".concat(String.valueOf(paramString)));
    this.d.B = paramString;
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile system version below 18");
      AppMethodBeat.o(221207);
      return;
    }
    if (!this.a.a())
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile is only supported in EnterprisePro license");
      AppMethodBeat.o(221207);
      return;
    }
    if (this.b != null) {
      this.b.a(paramString, true);
    }
    AppMethodBeat.o(221207);
  }
  
  public void setLipsThicknessLevel(int paramInt)
  {
    AppMethodBeat.i(221229);
    TXCLog.d("TXBeautyManager", "setLipsThicknessLevel lipsThicknessLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221229);
      return;
    }
    this.d.v = paramInt;
    if (this.b != null) {
      this.b.x(paramInt);
    }
    AppMethodBeat.o(221229);
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    AppMethodBeat.i(221232);
    TXCLog.d("TXBeautyManager", "setMotionMute motionMute:".concat(String.valueOf(paramBoolean)));
    this.d.y = paramBoolean;
    if (this.b != null) {
      this.b.c(paramBoolean);
    }
    AppMethodBeat.o(221232);
  }
  
  public void setMotionTmpl(String paramString)
  {
    AppMethodBeat.i(221231);
    TXCLog.d("TXBeautyManager", "setMotionTmpl tmplPath:".concat(String.valueOf(paramString)));
    this.d.x = paramString;
    if (this.b != null) {
      this.b.a(paramString);
    }
    AppMethodBeat.o(221231);
  }
  
  public void setMouthShapeLevel(int paramInt)
  {
    AppMethodBeat.i(221226);
    TXCLog.d("TXBeautyManager", "setMouthShapeLevel mouthShapeLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221226);
      return;
    }
    this.d.s = paramInt;
    if (this.b != null) {
      this.b.u(paramInt);
    }
    AppMethodBeat.o(221226);
  }
  
  public void setNosePositionLevel(int paramInt)
  {
    AppMethodBeat.i(221228);
    TXCLog.d("TXBeautyManager", "setNosePositionLevel nosePositionLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221228);
      return;
    }
    this.d.u = paramInt;
    if (this.b != null) {
      this.b.w(paramInt);
    }
    AppMethodBeat.o(221228);
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    AppMethodBeat.i(221217);
    TXCLog.d("TXBeautyManager", "setNoseSlimLevel noseSlimLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221217);
      return;
    }
    this.d.j = paramInt;
    if (this.b != null) {
      this.b.l(paramInt);
    }
    AppMethodBeat.o(221217);
  }
  
  public void setNoseWingLevel(int paramInt)
  {
    AppMethodBeat.i(221227);
    TXCLog.d("TXBeautyManager", "setNoseWingLevel noseWingLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221227);
      return;
    }
    this.d.t = paramInt;
    if (this.b != null) {
      this.b.v(paramInt);
    }
    AppMethodBeat.o(221227);
  }
  
  public void setPounchRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(221221);
    TXCLog.d("TXBeautyManager", "setPounchRemoveLevel pounchRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221221);
      return;
    }
    this.d.n = paramInt;
    if (this.b != null) {
      this.b.p(paramInt);
    }
    AppMethodBeat.o(221221);
  }
  
  public void setPreprocessor(d paramd)
  {
    AppMethodBeat.i(221202);
    this.b = paramd;
    if (this.b != null) {
      a();
    }
    AppMethodBeat.o(221202);
  }
  
  public void setRuddyLevel(int paramInt)
  {
    AppMethodBeat.i(221211);
    TXCLog.d("TXBeautyManager", "setRuddyLevel ruddyLevel:".concat(String.valueOf(paramInt)));
    this.d.c = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.e(paramInt);
    }
    AppMethodBeat.o(221211);
  }
  
  public void setSmileLinesRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(221222);
    TXCLog.d("TXBeautyManager", "setSmileLinesRemoveLevel smileLinesRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221222);
      return;
    }
    this.d.o = paramInt;
    if (this.b != null) {
      this.b.q(paramInt);
    }
    AppMethodBeat.o(221222);
  }
  
  public void setToothWhitenLevel(int paramInt)
  {
    AppMethodBeat.i(221219);
    TXCLog.d("TXBeautyManager", "setToothWhitenLevel toothWhitenLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221219);
      return;
    }
    this.d.l = paramInt;
    if (this.b != null) {
      this.b.n(paramInt);
    }
    AppMethodBeat.o(221219);
  }
  
  public void setWhitenessLevel(int paramInt)
  {
    AppMethodBeat.i(221209);
    TXCLog.d("TXBeautyManager", "setWhitenessLevel whitenessLevel:".concat(String.valueOf(paramInt)));
    this.d.b = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.d(paramInt);
    }
    AppMethodBeat.o(221209);
  }
  
  public void setWrinkleRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(221220);
    TXCLog.d("TXBeautyManager", "setWrinkleRemoveLevel wrinkleRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221220);
      return;
    }
    this.d.m = paramInt;
    if (this.b != null) {
      this.b.o(paramInt);
    }
    AppMethodBeat.o(221220);
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