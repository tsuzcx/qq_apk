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
    AppMethodBeat.i(221472);
    this.e = true;
    this.a = parame;
    this.d = new a();
    enableSharpnessEnhancement(true);
    setFilterStrength(0.5F);
    AppMethodBeat.o(221472);
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
    AppMethodBeat.i(221474);
    if (paramBoolean)
    {
      this.b.c(this.d.a);
      this.b.d(this.d.b);
      this.b.e(this.d.c);
      this.b.f(this.d.d);
      AppMethodBeat.o(221474);
      return;
    }
    this.b.c(0);
    this.b.d(0);
    this.b.e(0);
    this.b.f(0);
    AppMethodBeat.o(221474);
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
    AppMethodBeat.i(221481);
    TXCLog.d("TXBeautyManager", "enableSharpnessEnhancement enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    a locala = this.d;
    if (paramBoolean) {
      i = 4;
    }
    locala.d = i;
    if ((this.b != null) && (this.e)) {
      this.b.f(this.d.d);
    }
    AppMethodBeat.o(221481);
  }
  
  public void setBeautyLevel(int paramInt)
  {
    AppMethodBeat.i(221479);
    TXCLog.d("TXBeautyManager", "setBeautyLevel beautyLevel:".concat(String.valueOf(paramInt)));
    this.d.a = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.c(paramInt);
    }
    AppMethodBeat.o(221479);
  }
  
  public void setBeautyStyle(int paramInt)
  {
    AppMethodBeat.i(221475);
    TXCLog.d("TXBeautyManager", "setBeautyStyle beautyStyle:".concat(String.valueOf(paramInt)));
    this.c = paramInt;
    if (this.b != null) {
      this.b.b(paramInt);
    }
    AppMethodBeat.o(221475);
  }
  
  public void setChinLevel(int paramInt)
  {
    AppMethodBeat.i(221486);
    TXCLog.d("TXBeautyManager", "setChinLevel chinLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221486);
      return;
    }
    this.d.h = paramInt;
    if (this.b != null) {
      this.b.k(paramInt);
    }
    AppMethodBeat.o(221486);
  }
  
  public void setEyeAngleLevel(int paramInt)
  {
    AppMethodBeat.i(221496);
    TXCLog.d("TXBeautyManager", "setEyeAngleLevel eyeAngleLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221496);
      return;
    }
    this.d.r = paramInt;
    if (this.b != null) {
      this.b.t(paramInt);
    }
    AppMethodBeat.o(221496);
  }
  
  public void setEyeDistanceLevel(int paramInt)
  {
    AppMethodBeat.i(221495);
    TXCLog.d("TXBeautyManager", "setEyeDistanceLevel eyeDistanceLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221495);
      return;
    }
    this.d.q = paramInt;
    if (this.b != null) {
      this.b.s(paramInt);
    }
    AppMethodBeat.o(221495);
  }
  
  public void setEyeLightenLevel(int paramInt)
  {
    AppMethodBeat.i(221489);
    TXCLog.d("TXBeautyManager", "setEyeLightenLevel eyeLightenLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221489);
      return;
    }
    this.d.k = paramInt;
    if (this.b != null) {
      this.b.m(paramInt);
    }
    AppMethodBeat.o(221489);
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    AppMethodBeat.i(221483);
    TXCLog.d("TXBeautyManager", "setEyeScaleLevel eyeScaleLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221483);
      return;
    }
    this.d.e = paramInt;
    if (this.b != null) {
      this.b.g(paramInt);
    }
    AppMethodBeat.o(221483);
  }
  
  public void setFaceBeautyLevel(int paramInt)
  {
    AppMethodBeat.i(221501);
    TXCLog.d("TXBeautyManager", "setFaceBeautyLevel faceBeautyLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221501);
      return;
    }
    this.d.w = paramInt;
    if (this.b != null) {
      this.b.y(paramInt);
    }
    AppMethodBeat.o(221501);
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    AppMethodBeat.i(221487);
    TXCLog.d("TXBeautyManager", "setFaceShortLevel faceShortLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221487);
      return;
    }
    this.d.i = paramInt;
    if (this.b != null) {
      this.b.j(paramInt);
    }
    AppMethodBeat.o(221487);
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    AppMethodBeat.i(221484);
    TXCLog.d("TXBeautyManager", "setFaceSlimLevel faceSlimLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221484);
      return;
    }
    this.d.f = paramInt;
    if (this.b != null) {
      this.b.h(paramInt);
    }
    AppMethodBeat.o(221484);
  }
  
  public void setFaceVLevel(int paramInt)
  {
    AppMethodBeat.i(221485);
    TXCLog.d("TXBeautyManager", "setFaceVLevel faceVLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221485);
      return;
    }
    this.d.g = paramInt;
    if (this.b != null) {
      this.b.i(paramInt);
    }
    AppMethodBeat.o(221485);
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    AppMethodBeat.i(221476);
    TXCLog.d("TXBeautyManager", "setFilter image:".concat(String.valueOf(paramBitmap)));
    this.d.z = paramBitmap;
    if (this.b != null) {
      this.b.a(paramBitmap);
    }
    AppMethodBeat.o(221476);
  }
  
  public void setFilterStrength(float paramFloat)
  {
    AppMethodBeat.i(221477);
    TXCLog.d("TXBeautyManager", "setFilterStrength strength:".concat(String.valueOf(paramFloat)));
    this.d.A = paramFloat;
    if (this.b != null) {
      this.b.a(paramFloat);
    }
    AppMethodBeat.o(221477);
  }
  
  public void setForeheadLevel(int paramInt)
  {
    AppMethodBeat.i(221494);
    TXCLog.d("TXBeautyManager", "setForeheadLevel foreheadLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221494);
      return;
    }
    this.d.p = paramInt;
    if (this.b != null) {
      this.b.r(paramInt);
    }
    AppMethodBeat.o(221494);
  }
  
  public void setGreenScreenFile(String paramString)
  {
    AppMethodBeat.i(221478);
    TXCLog.d("TXBeautyManager", "setGreenScreenFile path:".concat(String.valueOf(paramString)));
    this.d.B = paramString;
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile system version below 18");
      AppMethodBeat.o(221478);
      return;
    }
    if (!this.a.a())
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile is only supported in EnterprisePro license");
      AppMethodBeat.o(221478);
      return;
    }
    if (this.b != null) {
      this.b.a(paramString, true);
    }
    AppMethodBeat.o(221478);
  }
  
  public void setLipsThicknessLevel(int paramInt)
  {
    AppMethodBeat.i(221500);
    TXCLog.d("TXBeautyManager", "setLipsThicknessLevel lipsThicknessLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221500);
      return;
    }
    this.d.v = paramInt;
    if (this.b != null) {
      this.b.x(paramInt);
    }
    AppMethodBeat.o(221500);
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    AppMethodBeat.i(221503);
    TXCLog.d("TXBeautyManager", "setMotionMute motionMute:".concat(String.valueOf(paramBoolean)));
    this.d.y = paramBoolean;
    if (this.b != null) {
      this.b.c(paramBoolean);
    }
    AppMethodBeat.o(221503);
  }
  
  public void setMotionTmpl(String paramString)
  {
    AppMethodBeat.i(221502);
    TXCLog.d("TXBeautyManager", "setMotionTmpl tmplPath:".concat(String.valueOf(paramString)));
    this.d.x = paramString;
    if (this.b != null) {
      this.b.a(paramString);
    }
    AppMethodBeat.o(221502);
  }
  
  public void setMouthShapeLevel(int paramInt)
  {
    AppMethodBeat.i(221497);
    TXCLog.d("TXBeautyManager", "setMouthShapeLevel mouthShapeLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221497);
      return;
    }
    this.d.s = paramInt;
    if (this.b != null) {
      this.b.u(paramInt);
    }
    AppMethodBeat.o(221497);
  }
  
  public void setNosePositionLevel(int paramInt)
  {
    AppMethodBeat.i(221499);
    TXCLog.d("TXBeautyManager", "setNosePositionLevel nosePositionLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221499);
      return;
    }
    this.d.u = paramInt;
    if (this.b != null) {
      this.b.w(paramInt);
    }
    AppMethodBeat.o(221499);
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    AppMethodBeat.i(221488);
    TXCLog.d("TXBeautyManager", "setNoseSlimLevel noseSlimLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221488);
      return;
    }
    this.d.j = paramInt;
    if (this.b != null) {
      this.b.l(paramInt);
    }
    AppMethodBeat.o(221488);
  }
  
  public void setNoseWingLevel(int paramInt)
  {
    AppMethodBeat.i(221498);
    TXCLog.d("TXBeautyManager", "setNoseWingLevel noseWingLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221498);
      return;
    }
    this.d.t = paramInt;
    if (this.b != null) {
      this.b.v(paramInt);
    }
    AppMethodBeat.o(221498);
  }
  
  public void setPounchRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(221492);
    TXCLog.d("TXBeautyManager", "setPounchRemoveLevel pounchRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221492);
      return;
    }
    this.d.n = paramInt;
    if (this.b != null) {
      this.b.p(paramInt);
    }
    AppMethodBeat.o(221492);
  }
  
  public void setPreprocessor(d paramd)
  {
    AppMethodBeat.i(221473);
    this.b = paramd;
    if (this.b != null) {
      a();
    }
    AppMethodBeat.o(221473);
  }
  
  public void setRuddyLevel(int paramInt)
  {
    AppMethodBeat.i(221482);
    TXCLog.d("TXBeautyManager", "setRuddyLevel ruddyLevel:".concat(String.valueOf(paramInt)));
    this.d.c = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.e(paramInt);
    }
    AppMethodBeat.o(221482);
  }
  
  public void setSmileLinesRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(221493);
    TXCLog.d("TXBeautyManager", "setSmileLinesRemoveLevel smileLinesRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221493);
      return;
    }
    this.d.o = paramInt;
    if (this.b != null) {
      this.b.q(paramInt);
    }
    AppMethodBeat.o(221493);
  }
  
  public void setToothWhitenLevel(int paramInt)
  {
    AppMethodBeat.i(221490);
    TXCLog.d("TXBeautyManager", "setToothWhitenLevel toothWhitenLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221490);
      return;
    }
    this.d.l = paramInt;
    if (this.b != null) {
      this.b.n(paramInt);
    }
    AppMethodBeat.o(221490);
  }
  
  public void setWhitenessLevel(int paramInt)
  {
    AppMethodBeat.i(221480);
    TXCLog.d("TXBeautyManager", "setWhitenessLevel whitenessLevel:".concat(String.valueOf(paramInt)));
    this.d.b = paramInt;
    if ((this.b != null) && (this.e)) {
      this.b.d(paramInt);
    }
    AppMethodBeat.o(221480);
  }
  
  public void setWrinkleRemoveLevel(int paramInt)
  {
    AppMethodBeat.i(221491);
    TXCLog.d("TXBeautyManager", "setWrinkleRemoveLevel wrinkleRemoveLevel:".concat(String.valueOf(paramInt)));
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      AppMethodBeat.o(221491);
      return;
    }
    this.d.m = paramInt;
    if (this.b != null) {
      this.b.o(paramInt);
    }
    AppMethodBeat.o(221491);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b
 * JD-Core Version:    0.7.0.1
 */