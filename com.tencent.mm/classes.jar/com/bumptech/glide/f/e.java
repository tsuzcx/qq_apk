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
  public boolean aDZ;
  public boolean aEI;
  public h aEk;
  public com.bumptech.glide.c.j aEm;
  public Class<?> aEo;
  public Map<Class<?>, m<?>> aEq;
  public g aEt;
  public com.bumptech.glide.c.b.i aEu;
  public boolean aEv;
  public boolean aEw;
  public boolean aFS;
  public boolean aGn;
  public Resources.Theme aLA;
  public boolean aLB;
  public boolean aLC;
  public int aLp;
  public float aLq;
  public Drawable aLr;
  public int aLs;
  public Drawable aLt;
  public int aLu;
  public int aLv;
  public int aLw;
  public boolean aLx;
  public Drawable aLy;
  public int aLz;
  
  public e()
  {
    AppMethodBeat.i(77636);
    this.aLq = 1.0F;
    this.aEu = com.bumptech.glide.c.b.i.aFu;
    this.aEt = g.aAX;
    this.aDZ = true;
    this.aLv = -1;
    this.aLw = -1;
    this.aEk = a.pX();
    this.aLx = true;
    this.aEm = new com.bumptech.glide.c.j();
    this.aEq = new b();
    this.aEo = Object.class;
    this.aEw = true;
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
    for (e locale = this; locale.aLB; locale = locale.pF()) {}
    com.bumptech.glide.h.i.checkNotNull(paramClass, "Argument must not be null");
    com.bumptech.glide.h.i.checkNotNull(paramm, "Argument must not be null");
    locale.aEq.put(paramClass, paramm);
    locale.aLp |= 0x800;
    locale.aLx = true;
    locale.aLp |= 0x10000;
    locale.aEw = false;
    locale.aLp |= 0x20000;
    locale.aEv = true;
    paramClass = locale.pH();
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
    for (e locale = new e(); locale.aLB; locale = locale.pF()) {}
    locale.aEk = ((h)com.bumptech.glide.h.i.checkNotNull(paramh, "Argument must not be null"));
    locale.aLp |= 0x400;
    paramh = locale.pH();
    AppMethodBeat.o(77638);
    return paramh;
  }
  
  public static e v(Class<?> paramClass)
  {
    AppMethodBeat.i(77639);
    for (e locale = new e(); locale.aLB; locale = locale.pF()) {}
    locale.aEo = ((Class)com.bumptech.glide.h.i.checkNotNull(paramClass, "Argument must not be null"));
    locale.aLp |= 0x1000;
    paramClass = locale.pH();
    AppMethodBeat.o(77639);
    return paramClass;
  }
  
  public final e S(float paramFloat)
  {
    AppMethodBeat.i(77640);
    for (Object localObject = this; ((e)localObject).aLB; localObject = ((e)localObject).pF()) {}
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      localObject = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
      AppMethodBeat.o(77640);
      throw ((Throwable)localObject);
    }
    ((e)localObject).aLq = paramFloat;
    ((e)localObject).aLp |= 0x2;
    localObject = ((e)localObject).pH();
    AppMethodBeat.o(77640);
    return localObject;
  }
  
  public final e a(m<Bitmap> paramm)
  {
    AppMethodBeat.i(77647);
    for (e locale = this; locale.aLB; locale = locale.pF()) {}
    com.bumptech.glide.c.d.a.j localj = new com.bumptech.glide.c.d.a.j(paramm);
    locale.a(Bitmap.class, paramm);
    locale.a(Drawable.class, localj);
    locale.a(BitmapDrawable.class, localj);
    locale.a(c.class, new f(paramm));
    paramm = locale.pH();
    AppMethodBeat.o(77647);
    return paramm;
  }
  
  public final e aW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77645);
    for (e locale = this; locale.aLB; locale = locale.pF()) {}
    locale.aLw = paramInt1;
    locale.aLv = paramInt2;
    locale.aLp |= 0x200;
    locale = locale.pH();
    AppMethodBeat.o(77645);
    return locale;
  }
  
  public final e b(com.bumptech.glide.c.b.i parami)
  {
    AppMethodBeat.i(77642);
    for (e locale = this; locale.aLB; locale = locale.pF()) {}
    locale.aEu = ((com.bumptech.glide.c.b.i)com.bumptech.glide.h.i.checkNotNull(parami, "Argument must not be null"));
    locale.aLp |= 0x4;
    parami = locale.pH();
    AppMethodBeat.o(77642);
    return parami;
  }
  
  public final e b(g paramg)
  {
    AppMethodBeat.i(77643);
    for (e locale = this; locale.aLB; locale = locale.pF()) {}
    locale.aEt = ((g)com.bumptech.glide.h.i.checkNotNull(paramg, "Argument must not be null"));
    locale.aLp |= 0x8;
    paramg = locale.pH();
    AppMethodBeat.o(77643);
    return paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77649);
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      if ((Float.compare(paramObject.aLq, this.aLq) == 0) && (this.aLs == paramObject.aLs) && (com.bumptech.glide.h.j.e(this.aLr, paramObject.aLr)) && (this.aLu == paramObject.aLu) && (com.bumptech.glide.h.j.e(this.aLt, paramObject.aLt)) && (this.aLz == paramObject.aLz) && (com.bumptech.glide.h.j.e(this.aLy, paramObject.aLy)) && (this.aDZ == paramObject.aDZ) && (this.aLv == paramObject.aLv) && (this.aLw == paramObject.aLw) && (this.aEv == paramObject.aEv) && (this.aLx == paramObject.aLx) && (this.aLC == paramObject.aLC) && (this.aEI == paramObject.aEI) && (this.aEu.equals(paramObject.aEu)) && (this.aEt == paramObject.aEt) && (this.aEm.equals(paramObject.aEm)) && (this.aEq.equals(paramObject.aEq)) && (this.aEo.equals(paramObject.aEo)) && (com.bumptech.glide.h.j.e(this.aEk, paramObject.aEk)) && (com.bumptech.glide.h.j.e(this.aLA, paramObject.aLA)))
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
    int i = com.bumptech.glide.h.j.hashCode(this.aLq);
    i = com.bumptech.glide.h.j.hashCode(this.aLs, i);
    i = com.bumptech.glide.h.j.b(this.aLr, i);
    i = com.bumptech.glide.h.j.hashCode(this.aLu, i);
    i = com.bumptech.glide.h.j.b(this.aLt, i);
    i = com.bumptech.glide.h.j.hashCode(this.aLz, i);
    i = com.bumptech.glide.h.j.b(this.aLy, i);
    i = com.bumptech.glide.h.j.d(this.aDZ, i);
    i = com.bumptech.glide.h.j.hashCode(this.aLv, i);
    i = com.bumptech.glide.h.j.hashCode(this.aLw, i);
    i = com.bumptech.glide.h.j.d(this.aEv, i);
    i = com.bumptech.glide.h.j.d(this.aLx, i);
    i = com.bumptech.glide.h.j.d(this.aLC, i);
    i = com.bumptech.glide.h.j.d(this.aEI, i);
    i = com.bumptech.glide.h.j.b(this.aEu, i);
    i = com.bumptech.glide.h.j.b(this.aEt, i);
    i = com.bumptech.glide.h.j.b(this.aEm, i);
    i = com.bumptech.glide.h.j.b(this.aEq, i);
    i = com.bumptech.glide.h.j.b(this.aEo, i);
    i = com.bumptech.glide.h.j.b(this.aEk, i);
    i = com.bumptech.glide.h.j.b(this.aLA, i);
    AppMethodBeat.o(77650);
    return i;
  }
  
  public final e pD()
  {
    AppMethodBeat.i(77641);
    for (e locale = this; locale.aLB; locale = locale.pF()) {}
    locale.aFS = true;
    locale.aLp |= 0x100000;
    locale = locale.pH();
    AppMethodBeat.o(77641);
    return locale;
  }
  
  public final e pE()
  {
    AppMethodBeat.i(77644);
    for (e locale = this; locale.aLB; locale = locale.pF()) {}
    locale.aDZ = false;
    locale.aLp |= 0x100;
    locale = locale.pH();
    AppMethodBeat.o(77644);
    return locale;
  }
  
  public final e pF()
  {
    AppMethodBeat.i(77646);
    try
    {
      e locale = (e)super.clone();
      locale.aEm = new com.bumptech.glide.c.j();
      locale.aEm.a(this.aEm);
      locale.aEq = new b();
      locale.aEq.putAll(this.aEq);
      locale.aGn = false;
      locale.aLB = false;
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
  
  public final e pG()
  {
    AppMethodBeat.i(77651);
    if ((this.aGn) && (!this.aLB))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
      AppMethodBeat.o(77651);
      throw localIllegalStateException;
    }
    this.aLB = true;
    this.aGn = true;
    AppMethodBeat.o(77651);
    return this;
  }
  
  public final e pH()
  {
    AppMethodBeat.i(77652);
    if (this.aGn)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
      AppMethodBeat.o(77652);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(77652);
    return this;
  }
  
  public final boolean pI()
  {
    AppMethodBeat.i(77653);
    boolean bool = com.bumptech.glide.h.j.aY(this.aLw, this.aLv);
    AppMethodBeat.o(77653);
    return bool;
  }
  
  public final boolean pJ()
  {
    AppMethodBeat.i(77654);
    boolean bool = aV(this.aLp, 8);
    AppMethodBeat.o(77654);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.f.e
 * JD-Core Version:    0.7.0.1
 */