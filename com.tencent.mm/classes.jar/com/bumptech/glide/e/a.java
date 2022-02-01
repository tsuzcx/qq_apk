package com.bumptech.glide.e;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.g.b;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.d.e.c;
import com.bumptech.glide.load.d.e.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import java.util.Map;

public abstract class a<T extends a<T>>
  implements Cloneable
{
  public boolean aFI = true;
  com.bumptech.glide.load.g aFT = com.bumptech.glide.f.a.qq();
  public i aFV = new i();
  Class<?> aFX = Object.class;
  Map<Class<?>, l<?>> aFZ = new b();
  protected com.bumptech.glide.g aGc = com.bumptech.glide.g.aCO;
  com.bumptech.glide.load.b.j aGd = com.bumptech.glide.load.b.j.aHd;
  boolean aGe;
  boolean aGf = true;
  boolean aGr;
  boolean aHC;
  public boolean aHY;
  int aMU;
  float aMV = 1.0F;
  Drawable aMW;
  int aMX;
  Drawable aMY;
  int aMZ;
  protected int aNa = -1;
  protected int aNb = -1;
  private boolean aNc = true;
  Drawable aNd;
  int aNe;
  Resources.Theme aNf;
  public boolean aNg;
  boolean aNh;
  
  private <Y> T a(Class<Y> paramClass, l<Y> paraml, boolean paramBoolean)
  {
    for (a locala = this; locala.aNg; locala = locala.nQ()) {}
    com.bumptech.glide.g.j.checkNotNull(paramClass, "Argument must not be null");
    com.bumptech.glide.g.j.checkNotNull(paraml, "Argument must not be null");
    locala.aFZ.put(paramClass, paraml);
    locala.aMU |= 0x800;
    locala.aNc = true;
    locala.aMU |= 0x10000;
    locala.aGf = false;
    locala.aMU |= 0x20000;
    locala.aGe = true;
    return locala.pY();
  }
  
  private static boolean aQ(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public final T Q(float paramFloat)
  {
    for (a locala = this; locala.aNg; locala = locala.nQ()) {}
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F)) {
      throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }
    locala.aMV = paramFloat;
    locala.aMU |= 0x2;
    return locala.pY();
  }
  
  public final T a(com.bumptech.glide.load.b.j paramj)
  {
    for (a locala = this; locala.aNg; locala = locala.nQ()) {}
    locala.aGd = ((com.bumptech.glide.load.b.j)com.bumptech.glide.g.j.checkNotNull(paramj, "Argument must not be null"));
    locala.aMU |= 0x4;
    return locala.pY();
  }
  
  public final T a(l<Bitmap> paraml)
  {
    for (a locala = this; locala.aNg; locala = locala.nQ()) {}
    com.bumptech.glide.load.d.a.j localj = new com.bumptech.glide.load.d.a.j(paraml, true);
    locala.a(Bitmap.class, paraml, true);
    locala.a(Drawable.class, localj, true);
    locala.a(BitmapDrawable.class, localj, true);
    locala.a(c.class, new f(paraml), true);
    return locala.pY();
  }
  
  public final T aR(int paramInt1, int paramInt2)
  {
    for (a locala = this; locala.aNg; locala = locala.nQ()) {}
    locala.aNb = paramInt1;
    locala.aNa = paramInt2;
    locala.aMU |= 0x200;
    return locala.pY();
  }
  
  public T b(a<?> parama)
  {
    if (this.aNg) {
      return nQ().b(parama);
    }
    if (aQ(parama.aMU, 2)) {
      this.aMV = parama.aMV;
    }
    if (aQ(parama.aMU, 262144)) {
      this.aNh = parama.aNh;
    }
    if (aQ(parama.aMU, 1048576)) {
      this.aHC = parama.aHC;
    }
    if (aQ(parama.aMU, 4)) {
      this.aGd = parama.aGd;
    }
    if (aQ(parama.aMU, 8)) {
      this.aGc = parama.aGc;
    }
    if (aQ(parama.aMU, 16))
    {
      this.aMW = parama.aMW;
      this.aMX = 0;
      this.aMU &= 0xFFFFFFDF;
    }
    if (aQ(parama.aMU, 32))
    {
      this.aMX = parama.aMX;
      this.aMW = null;
      this.aMU &= 0xFFFFFFEF;
    }
    if (aQ(parama.aMU, 64))
    {
      this.aMY = parama.aMY;
      this.aMZ = 0;
      this.aMU &= 0xFFFFFF7F;
    }
    if (aQ(parama.aMU, 128))
    {
      this.aMZ = parama.aMZ;
      this.aMY = null;
      this.aMU &= 0xFFFFFFBF;
    }
    if (aQ(parama.aMU, 256)) {
      this.aFI = parama.aFI;
    }
    if (aQ(parama.aMU, 512))
    {
      this.aNb = parama.aNb;
      this.aNa = parama.aNa;
    }
    if (aQ(parama.aMU, 1024)) {
      this.aFT = parama.aFT;
    }
    if (aQ(parama.aMU, 4096)) {
      this.aFX = parama.aFX;
    }
    if (aQ(parama.aMU, 8192))
    {
      this.aNd = parama.aNd;
      this.aNe = 0;
      this.aMU &= 0xFFFFBFFF;
    }
    if (aQ(parama.aMU, 16384))
    {
      this.aNe = parama.aNe;
      this.aNd = null;
      this.aMU &= 0xFFFFDFFF;
    }
    if (aQ(parama.aMU, 32768)) {
      this.aNf = parama.aNf;
    }
    if (aQ(parama.aMU, 65536)) {
      this.aNc = parama.aNc;
    }
    if (aQ(parama.aMU, 131072)) {
      this.aGe = parama.aGe;
    }
    if (aQ(parama.aMU, 2048))
    {
      this.aFZ.putAll(parama.aFZ);
      this.aGf = parama.aGf;
    }
    if (aQ(parama.aMU, 524288)) {
      this.aGr = parama.aGr;
    }
    if (!this.aNc)
    {
      this.aFZ.clear();
      this.aMU &= 0xFFFFF7FF;
      this.aGe = false;
      this.aMU &= 0xFFFDFFFF;
      this.aGf = true;
    }
    this.aMU |= parama.aMU;
    this.aFV.a(parama.aFV);
    return pY();
  }
  
  public final T b(com.bumptech.glide.g paramg)
  {
    for (a locala = this; locala.aNg; locala = locala.nQ()) {}
    locala.aGc = ((com.bumptech.glide.g)com.bumptech.glide.g.j.checkNotNull(paramg, "Argument must not be null"));
    locala.aMU |= 0x8;
    return locala.pY();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (Float.compare(paramObject.aMV, this.aMV) == 0)
      {
        bool1 = bool2;
        if (this.aMX == paramObject.aMX)
        {
          bool1 = bool2;
          if (k.h(this.aMW, paramObject.aMW))
          {
            bool1 = bool2;
            if (this.aMZ == paramObject.aMZ)
            {
              bool1 = bool2;
              if (k.h(this.aMY, paramObject.aMY))
              {
                bool1 = bool2;
                if (this.aNe == paramObject.aNe)
                {
                  bool1 = bool2;
                  if (k.h(this.aNd, paramObject.aNd))
                  {
                    bool1 = bool2;
                    if (this.aFI == paramObject.aFI)
                    {
                      bool1 = bool2;
                      if (this.aNa == paramObject.aNa)
                      {
                        bool1 = bool2;
                        if (this.aNb == paramObject.aNb)
                        {
                          bool1 = bool2;
                          if (this.aGe == paramObject.aGe)
                          {
                            bool1 = bool2;
                            if (this.aNc == paramObject.aNc)
                            {
                              bool1 = bool2;
                              if (this.aNh == paramObject.aNh)
                              {
                                bool1 = bool2;
                                if (this.aGr == paramObject.aGr)
                                {
                                  bool1 = bool2;
                                  if (this.aGd.equals(paramObject.aGd))
                                  {
                                    bool1 = bool2;
                                    if (this.aGc == paramObject.aGc)
                                    {
                                      bool1 = bool2;
                                      if (this.aFV.equals(paramObject.aFV))
                                      {
                                        bool1 = bool2;
                                        if (this.aFZ.equals(paramObject.aFZ))
                                        {
                                          bool1 = bool2;
                                          if (this.aFX.equals(paramObject.aFX))
                                          {
                                            bool1 = bool2;
                                            if (k.h(this.aFT, paramObject.aFT))
                                            {
                                              bool1 = bool2;
                                              if (k.h(this.aNf, paramObject.aNf)) {
                                                bool1 = true;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int i = k.hashCode(this.aMV);
    i = k.hashCode(this.aMX, i);
    i = k.a(this.aMW, i);
    i = k.hashCode(this.aMZ, i);
    i = k.a(this.aMY, i);
    i = k.hashCode(this.aNe, i);
    i = k.a(this.aNd, i);
    i = k.b(this.aFI, i);
    i = k.hashCode(this.aNa, i);
    i = k.hashCode(this.aNb, i);
    i = k.b(this.aGe, i);
    i = k.b(this.aNc, i);
    i = k.b(this.aNh, i);
    i = k.b(this.aGr, i);
    i = k.a(this.aGd, i);
    i = k.a(this.aGc, i);
    i = k.a(this.aFV, i);
    i = k.a(this.aFZ, i);
    i = k.a(this.aFX, i);
    i = k.a(this.aFT, i);
    return k.a(this.aNf, i);
  }
  
  public T nQ()
  {
    try
    {
      a locala = (a)super.clone();
      locala.aFV = new i();
      locala.aFV.a(this.aFV);
      locala.aFZ = new b();
      locala.aFZ.putAll(this.aFZ);
      locala.aHY = false;
      locala.aNg = false;
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }
  
  public final T pW()
  {
    for (a locala = this; locala.aNg; locala = locala.nQ()) {}
    locala.aHC = true;
    locala.aMU |= 0x100000;
    return locala.pY();
  }
  
  public final T pX()
  {
    for (a locala = this; locala.aNg; locala = locala.nQ()) {}
    locala.aFI = false;
    locala.aMU |= 0x100;
    return locala.pY();
  }
  
  final T pY()
  {
    if (this.aHY) {
      throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }
    return this;
  }
  
  public final boolean pZ()
  {
    return k.aT(this.aNb, this.aNa);
  }
  
  protected final boolean qa()
  {
    return aQ(this.aMU, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.a
 * JD-Core Version:    0.7.0.1
 */