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
  public boolean aFQ;
  public h aGb;
  public com.bumptech.glide.c.j aGd;
  public Class<?> aGf;
  public Map<Class<?>, m<?>> aGh;
  public g aGk;
  public com.bumptech.glide.c.b.i aGl;
  public boolean aGm;
  public boolean aGn;
  public boolean aGz;
  public boolean aHJ;
  public boolean aIe;
  public int aNg;
  public float aNh;
  public Drawable aNi;
  public int aNj;
  public Drawable aNk;
  public int aNl;
  public int aNm;
  public int aNn;
  public boolean aNo;
  public Drawable aNp;
  public int aNq;
  public Resources.Theme aNr;
  public boolean aNs;
  public boolean aNt;
  
  public e()
  {
    AppMethodBeat.i(77636);
    this.aNh = 1.0F;
    this.aGl = com.bumptech.glide.c.b.i.aHl;
    this.aGk = g.aCO;
    this.aFQ = true;
    this.aNm = -1;
    this.aNn = -1;
    this.aGb = a.qp();
    this.aNo = true;
    this.aGd = new com.bumptech.glide.c.j();
    this.aGh = new b();
    this.aGf = Object.class;
    this.aGn = true;
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
    for (e locale = this; locale.aNs; locale = locale.pX()) {}
    com.bumptech.glide.h.i.checkNotNull(paramClass, "Argument must not be null");
    com.bumptech.glide.h.i.checkNotNull(paramm, "Argument must not be null");
    locale.aGh.put(paramClass, paramm);
    locale.aNg |= 0x800;
    locale.aNo = true;
    locale.aNg |= 0x10000;
    locale.aGn = false;
    locale.aNg |= 0x20000;
    locale.aGm = true;
    paramClass = locale.pZ();
    AppMethodBeat.o(77648);
    return paramClass;
  }
  
  public static boolean aW(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public static e e(h paramh)
  {
    AppMethodBeat.i(77638);
    for (e locale = new e(); locale.aNs; locale = locale.pX()) {}
    locale.aGb = ((h)com.bumptech.glide.h.i.checkNotNull(paramh, "Argument must not be null"));
    locale.aNg |= 0x400;
    paramh = locale.pZ();
    AppMethodBeat.o(77638);
    return paramh;
  }
  
  public static e v(Class<?> paramClass)
  {
    AppMethodBeat.i(77639);
    for (e locale = new e(); locale.aNs; locale = locale.pX()) {}
    locale.aGf = ((Class)com.bumptech.glide.h.i.checkNotNull(paramClass, "Argument must not be null"));
    locale.aNg |= 0x1000;
    paramClass = locale.pZ();
    AppMethodBeat.o(77639);
    return paramClass;
  }
  
  public final e Q(float paramFloat)
  {
    AppMethodBeat.i(77640);
    for (Object localObject = this; ((e)localObject).aNs; localObject = ((e)localObject).pX()) {}
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      localObject = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
      AppMethodBeat.o(77640);
      throw ((Throwable)localObject);
    }
    ((e)localObject).aNh = paramFloat;
    ((e)localObject).aNg |= 0x2;
    localObject = ((e)localObject).pZ();
    AppMethodBeat.o(77640);
    return localObject;
  }
  
  public final e a(m<Bitmap> paramm)
  {
    AppMethodBeat.i(77647);
    for (e locale = this; locale.aNs; locale = locale.pX()) {}
    com.bumptech.glide.c.d.a.j localj = new com.bumptech.glide.c.d.a.j(paramm);
    locale.a(Bitmap.class, paramm);
    locale.a(Drawable.class, localj);
    locale.a(BitmapDrawable.class, localj);
    locale.a(c.class, new f(paramm));
    paramm = locale.pZ();
    AppMethodBeat.o(77647);
    return paramm;
  }
  
  public final e aX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77645);
    for (e locale = this; locale.aNs; locale = locale.pX()) {}
    locale.aNn = paramInt1;
    locale.aNm = paramInt2;
    locale.aNg |= 0x200;
    locale = locale.pZ();
    AppMethodBeat.o(77645);
    return locale;
  }
  
  public final e b(com.bumptech.glide.c.b.i parami)
  {
    AppMethodBeat.i(77642);
    for (e locale = this; locale.aNs; locale = locale.pX()) {}
    locale.aGl = ((com.bumptech.glide.c.b.i)com.bumptech.glide.h.i.checkNotNull(parami, "Argument must not be null"));
    locale.aNg |= 0x4;
    parami = locale.pZ();
    AppMethodBeat.o(77642);
    return parami;
  }
  
  public final e b(g paramg)
  {
    AppMethodBeat.i(77643);
    for (e locale = this; locale.aNs; locale = locale.pX()) {}
    locale.aGk = ((g)com.bumptech.glide.h.i.checkNotNull(paramg, "Argument must not be null"));
    locale.aNg |= 0x8;
    paramg = locale.pZ();
    AppMethodBeat.o(77643);
    return paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77649);
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      if ((Float.compare(paramObject.aNh, this.aNh) == 0) && (this.aNj == paramObject.aNj) && (com.bumptech.glide.h.j.g(this.aNi, paramObject.aNi)) && (this.aNl == paramObject.aNl) && (com.bumptech.glide.h.j.g(this.aNk, paramObject.aNk)) && (this.aNq == paramObject.aNq) && (com.bumptech.glide.h.j.g(this.aNp, paramObject.aNp)) && (this.aFQ == paramObject.aFQ) && (this.aNm == paramObject.aNm) && (this.aNn == paramObject.aNn) && (this.aGm == paramObject.aGm) && (this.aNo == paramObject.aNo) && (this.aNt == paramObject.aNt) && (this.aGz == paramObject.aGz) && (this.aGl.equals(paramObject.aGl)) && (this.aGk == paramObject.aGk) && (this.aGd.equals(paramObject.aGd)) && (this.aGh.equals(paramObject.aGh)) && (this.aGf.equals(paramObject.aGf)) && (com.bumptech.glide.h.j.g(this.aGb, paramObject.aGb)) && (com.bumptech.glide.h.j.g(this.aNr, paramObject.aNr)))
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
    int i = com.bumptech.glide.h.j.hashCode(this.aNh);
    i = com.bumptech.glide.h.j.hashCode(this.aNj, i);
    i = com.bumptech.glide.h.j.b(this.aNi, i);
    i = com.bumptech.glide.h.j.hashCode(this.aNl, i);
    i = com.bumptech.glide.h.j.b(this.aNk, i);
    i = com.bumptech.glide.h.j.hashCode(this.aNq, i);
    i = com.bumptech.glide.h.j.b(this.aNp, i);
    i = com.bumptech.glide.h.j.d(this.aFQ, i);
    i = com.bumptech.glide.h.j.hashCode(this.aNm, i);
    i = com.bumptech.glide.h.j.hashCode(this.aNn, i);
    i = com.bumptech.glide.h.j.d(this.aGm, i);
    i = com.bumptech.glide.h.j.d(this.aNo, i);
    i = com.bumptech.glide.h.j.d(this.aNt, i);
    i = com.bumptech.glide.h.j.d(this.aGz, i);
    i = com.bumptech.glide.h.j.b(this.aGl, i);
    i = com.bumptech.glide.h.j.b(this.aGk, i);
    i = com.bumptech.glide.h.j.b(this.aGd, i);
    i = com.bumptech.glide.h.j.b(this.aGh, i);
    i = com.bumptech.glide.h.j.b(this.aGf, i);
    i = com.bumptech.glide.h.j.b(this.aGb, i);
    i = com.bumptech.glide.h.j.b(this.aNr, i);
    AppMethodBeat.o(77650);
    return i;
  }
  
  public final e pV()
  {
    AppMethodBeat.i(77641);
    for (e locale = this; locale.aNs; locale = locale.pX()) {}
    locale.aHJ = true;
    locale.aNg |= 0x100000;
    locale = locale.pZ();
    AppMethodBeat.o(77641);
    return locale;
  }
  
  public final e pW()
  {
    AppMethodBeat.i(77644);
    for (e locale = this; locale.aNs; locale = locale.pX()) {}
    locale.aFQ = false;
    locale.aNg |= 0x100;
    locale = locale.pZ();
    AppMethodBeat.o(77644);
    return locale;
  }
  
  public final e pX()
  {
    AppMethodBeat.i(77646);
    try
    {
      e locale = (e)super.clone();
      locale.aGd = new com.bumptech.glide.c.j();
      locale.aGd.a(this.aGd);
      locale.aGh = new b();
      locale.aGh.putAll(this.aGh);
      locale.aIe = false;
      locale.aNs = false;
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
  
  public final e pY()
  {
    AppMethodBeat.i(77651);
    if ((this.aIe) && (!this.aNs))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
      AppMethodBeat.o(77651);
      throw localIllegalStateException;
    }
    this.aNs = true;
    this.aIe = true;
    AppMethodBeat.o(77651);
    return this;
  }
  
  public final e pZ()
  {
    AppMethodBeat.i(77652);
    if (this.aIe)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
      AppMethodBeat.o(77652);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(77652);
    return this;
  }
  
  public final boolean qa()
  {
    AppMethodBeat.i(77653);
    boolean bool = com.bumptech.glide.h.j.aZ(this.aNn, this.aNm);
    AppMethodBeat.o(77653);
    return bool;
  }
  
  public final boolean qb()
  {
    AppMethodBeat.i(77654);
    boolean bool = aW(this.aNg, 8);
    AppMethodBeat.o(77654);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.f.e
 * JD-Core Version:    0.7.0.1
 */