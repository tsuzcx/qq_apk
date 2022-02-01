package com.bumptech.glide.f;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.d.e.c;
import com.bumptech.glide.c.d.e.f;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.m;
import com.bumptech.glide.g;
import com.bumptech.glide.g.a;
import com.bumptech.glide.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e
  implements Cloneable
{
  public g aDC;
  public com.bumptech.glide.c.b.i aDD;
  public boolean aDE;
  public boolean aDF;
  public boolean aDR;
  public boolean aDi;
  public h aDt;
  public com.bumptech.glide.c.j aDv;
  public Class<?> aDx;
  public Map<Class<?>, m<?>> aDz;
  public boolean aFc;
  public boolean aFx;
  public float aKA;
  public Drawable aKB;
  public int aKC;
  public Drawable aKD;
  public int aKE;
  public int aKF;
  public int aKG;
  public boolean aKH;
  public Drawable aKI;
  public int aKJ;
  public Resources.Theme aKK;
  public boolean aKL;
  public boolean aKM;
  public int aKz;
  
  public e()
  {
    AppMethodBeat.i(77636);
    this.aKA = 1.0F;
    this.aDD = com.bumptech.glide.c.b.i.aEE;
    this.aDC = g.aAd;
    this.aDi = true;
    this.aKF = -1;
    this.aKG = -1;
    this.aDt = a.pN();
    this.aKH = true;
    this.aDv = new com.bumptech.glide.c.j();
    this.aDz = new b();
    this.aDx = Object.class;
    this.aDF = true;
    AppMethodBeat.o(77636);
  }
  
  public static e a(com.bumptech.glide.c.b.i parami)
  {
    AppMethodBeat.i(77637);
    parami = new e().b(parami);
    AppMethodBeat.o(77637);
    return parami;
  }
  
  private <T> e a(Class<T> paramClass, m<T> paramm)
  {
    AppMethodBeat.i(77648);
    for (e locale = this; locale.aKL; locale = locale.pv()) {}
    com.bumptech.glide.h.i.checkNotNull(paramClass, "Argument must not be null");
    com.bumptech.glide.h.i.checkNotNull(paramm, "Argument must not be null");
    locale.aDz.put(paramClass, paramm);
    locale.aKz |= 0x800;
    locale.aKH = true;
    locale.aKz |= 0x10000;
    locale.aDF = false;
    locale.aKz |= 0x20000;
    locale.aDE = true;
    paramClass = locale.px();
    AppMethodBeat.o(77648);
    return paramClass;
  }
  
  public static boolean aV(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public static e e(h paramh)
  {
    AppMethodBeat.i(77638);
    for (e locale = new e(); locale.aKL; locale = locale.pv()) {}
    locale.aDt = ((h)com.bumptech.glide.h.i.checkNotNull(paramh, "Argument must not be null"));
    locale.aKz |= 0x400;
    paramh = locale.px();
    AppMethodBeat.o(77638);
    return paramh;
  }
  
  public static e v(Class<?> paramClass)
  {
    AppMethodBeat.i(77639);
    for (e locale = new e(); locale.aKL; locale = locale.pv()) {}
    locale.aDx = ((Class)com.bumptech.glide.h.i.checkNotNull(paramClass, "Argument must not be null"));
    locale.aKz |= 0x1000;
    paramClass = locale.px();
    AppMethodBeat.o(77639);
    return paramClass;
  }
  
  public final e O(float paramFloat)
  {
    AppMethodBeat.i(77640);
    for (Object localObject = this; ((e)localObject).aKL; localObject = ((e)localObject).pv()) {}
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      localObject = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
      AppMethodBeat.o(77640);
      throw ((Throwable)localObject);
    }
    ((e)localObject).aKA = paramFloat;
    ((e)localObject).aKz |= 0x2;
    localObject = ((e)localObject).px();
    AppMethodBeat.o(77640);
    return localObject;
  }
  
  public final e a(m<Bitmap> paramm)
  {
    AppMethodBeat.i(77647);
    for (e locale = this; locale.aKL; locale = locale.pv()) {}
    com.bumptech.glide.c.d.a.j localj = new com.bumptech.glide.c.d.a.j(paramm);
    locale.a(Bitmap.class, paramm);
    locale.a(Drawable.class, localj);
    locale.a(BitmapDrawable.class, localj);
    locale.a(c.class, new f(paramm));
    paramm = locale.px();
    AppMethodBeat.o(77647);
    return paramm;
  }
  
  public final e aW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77645);
    for (e locale = this; locale.aKL; locale = locale.pv()) {}
    locale.aKG = paramInt1;
    locale.aKF = paramInt2;
    locale.aKz |= 0x200;
    locale = locale.px();
    AppMethodBeat.o(77645);
    return locale;
  }
  
  public final e b(com.bumptech.glide.c.b.i parami)
  {
    AppMethodBeat.i(77642);
    for (e locale = this; locale.aKL; locale = locale.pv()) {}
    locale.aDD = ((com.bumptech.glide.c.b.i)com.bumptech.glide.h.i.checkNotNull(parami, "Argument must not be null"));
    locale.aKz |= 0x4;
    parami = locale.px();
    AppMethodBeat.o(77642);
    return parami;
  }
  
  public final e b(g paramg)
  {
    AppMethodBeat.i(77643);
    for (e locale = this; locale.aKL; locale = locale.pv()) {}
    locale.aDC = ((g)com.bumptech.glide.h.i.checkNotNull(paramg, "Argument must not be null"));
    locale.aKz |= 0x8;
    paramg = locale.px();
    AppMethodBeat.o(77643);
    return paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77649);
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      if ((Float.compare(paramObject.aKA, this.aKA) == 0) && (this.aKC == paramObject.aKC) && (com.bumptech.glide.h.j.e(this.aKB, paramObject.aKB)) && (this.aKE == paramObject.aKE) && (com.bumptech.glide.h.j.e(this.aKD, paramObject.aKD)) && (this.aKJ == paramObject.aKJ) && (com.bumptech.glide.h.j.e(this.aKI, paramObject.aKI)) && (this.aDi == paramObject.aDi) && (this.aKF == paramObject.aKF) && (this.aKG == paramObject.aKG) && (this.aDE == paramObject.aDE) && (this.aKH == paramObject.aKH) && (this.aKM == paramObject.aKM) && (this.aDR == paramObject.aDR) && (this.aDD.equals(paramObject.aDD)) && (this.aDC == paramObject.aDC) && (this.aDv.equals(paramObject.aDv)) && (this.aDz.equals(paramObject.aDz)) && (this.aDx.equals(paramObject.aDx)) && (com.bumptech.glide.h.j.e(this.aDt, paramObject.aDt)) && (com.bumptech.glide.h.j.e(this.aKK, paramObject.aKK)))
      {
        AppMethodBeat.o(77649);
        return true;
      }
      AppMethodBeat.o(77649);
      return false;
    }
    AppMethodBeat.o(77649);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77650);
    int i = com.bumptech.glide.h.j.hashCode(this.aKA);
    i = com.bumptech.glide.h.j.hashCode(this.aKC, i);
    i = com.bumptech.glide.h.j.b(this.aKB, i);
    i = com.bumptech.glide.h.j.hashCode(this.aKE, i);
    i = com.bumptech.glide.h.j.b(this.aKD, i);
    i = com.bumptech.glide.h.j.hashCode(this.aKJ, i);
    i = com.bumptech.glide.h.j.b(this.aKI, i);
    i = com.bumptech.glide.h.j.d(this.aDi, i);
    i = com.bumptech.glide.h.j.hashCode(this.aKF, i);
    i = com.bumptech.glide.h.j.hashCode(this.aKG, i);
    i = com.bumptech.glide.h.j.d(this.aDE, i);
    i = com.bumptech.glide.h.j.d(this.aKH, i);
    i = com.bumptech.glide.h.j.d(this.aKM, i);
    i = com.bumptech.glide.h.j.d(this.aDR, i);
    i = com.bumptech.glide.h.j.b(this.aDD, i);
    i = com.bumptech.glide.h.j.b(this.aDC, i);
    i = com.bumptech.glide.h.j.b(this.aDv, i);
    i = com.bumptech.glide.h.j.b(this.aDz, i);
    i = com.bumptech.glide.h.j.b(this.aDx, i);
    i = com.bumptech.glide.h.j.b(this.aDt, i);
    i = com.bumptech.glide.h.j.b(this.aKK, i);
    AppMethodBeat.o(77650);
    return i;
  }
  
  public final e pt()
  {
    AppMethodBeat.i(77641);
    for (e locale = this; locale.aKL; locale = locale.pv()) {}
    locale.aFc = true;
    locale.aKz |= 0x100000;
    locale = locale.px();
    AppMethodBeat.o(77641);
    return locale;
  }
  
  public final e pu()
  {
    AppMethodBeat.i(77644);
    for (e locale = this; locale.aKL; locale = locale.pv()) {}
    locale.aDi = false;
    locale.aKz |= 0x100;
    locale = locale.px();
    AppMethodBeat.o(77644);
    return locale;
  }
  
  public final e pv()
  {
    AppMethodBeat.i(77646);
    try
    {
      e locale = (e)super.clone();
      locale.aDv = new com.bumptech.glide.c.j();
      locale.aDv.a(this.aDv);
      locale.aDz = new b();
      locale.aDz.putAll(this.aDz);
      locale.aFx = false;
      locale.aKL = false;
      AppMethodBeat.o(77646);
      return locale;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localCloneNotSupportedException);
      AppMethodBeat.o(77646);
      throw localRuntimeException;
    }
  }
  
  public final e pw()
  {
    AppMethodBeat.i(77651);
    if ((this.aFx) && (!this.aKL))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
      AppMethodBeat.o(77651);
      throw localIllegalStateException;
    }
    this.aKL = true;
    this.aFx = true;
    AppMethodBeat.o(77651);
    return this;
  }
  
  public final e px()
  {
    AppMethodBeat.i(77652);
    if (this.aFx)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
      AppMethodBeat.o(77652);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(77652);
    return this;
  }
  
  public final boolean py()
  {
    AppMethodBeat.i(77653);
    boolean bool = com.bumptech.glide.h.j.aY(this.aKG, this.aKF);
    AppMethodBeat.o(77653);
    return bool;
  }
  
  public final boolean pz()
  {
    AppMethodBeat.i(77654);
    boolean bool = aV(this.aKz, 8);
    AppMethodBeat.o(77654);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.f.e
 * JD-Core Version:    0.7.0.1
 */