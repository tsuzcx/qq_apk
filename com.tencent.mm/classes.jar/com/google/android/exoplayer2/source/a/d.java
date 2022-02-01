package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.m.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements g
{
  public l bkU;
  public final e blp;
  private final Format bmr;
  private final SparseArray<a> bms;
  private boolean bmt;
  private b bmu;
  public Format[] bmv;
  
  public d(e parame, Format paramFormat)
  {
    AppMethodBeat.i(92585);
    this.blp = parame;
    this.bmr = paramFormat;
    this.bms = new SparseArray();
    AppMethodBeat.o(92585);
  }
  
  public final void a(l paraml)
  {
    this.bkU = paraml;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(92586);
    this.bmu = paramb;
    if (!this.bmt)
    {
      this.blp.a(this);
      this.bmt = true;
      AppMethodBeat.o(92586);
      return;
    }
    this.blp.f(0L, 0L);
    int i = 0;
    while (i < this.bms.size())
    {
      ((a)this.bms.valueAt(i)).b(paramb);
      i += 1;
    }
    AppMethodBeat.o(92586);
  }
  
  public final com.google.android.exoplayer2.c.m bh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92587);
    a locala2 = (a)this.bms.get(paramInt1);
    a locala1 = locala2;
    if (locala2 == null) {
      if (this.bmv != null) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      locala1 = new a(paramInt1, paramInt2, this.bmr);
      locala1.b(this.bmu);
      this.bms.put(paramInt1, locala1);
      AppMethodBeat.o(92587);
      return locala1;
    }
  }
  
  public final void sL()
  {
    AppMethodBeat.i(92588);
    Format[] arrayOfFormat = new Format[this.bms.size()];
    int i = 0;
    while (i < this.bms.size())
    {
      arrayOfFormat[i] = ((a)this.bms.valueAt(i)).bmw;
      i += 1;
    }
    this.bmv = arrayOfFormat;
    AppMethodBeat.o(92588);
  }
  
  static final class a
    implements com.google.android.exoplayer2.c.m
  {
    private com.google.android.exoplayer2.c.m aZw;
    private final Format bmr;
    public Format bmw;
    private final int id;
    private final int type;
    
    public a(int paramInt1, int paramInt2, Format paramFormat)
    {
      this.id = paramInt1;
      this.type = paramInt2;
      this.bmr = paramFormat;
    }
    
    public final int a(f paramf, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(92582);
      paramInt = this.aZw.a(paramf, paramInt, paramBoolean);
      AppMethodBeat.o(92582);
      return paramInt;
    }
    
    public final void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, m.a parama)
    {
      AppMethodBeat.i(92584);
      this.aZw.a(paramLong, paramInt1, paramInt2, paramInt3, parama);
      AppMethodBeat.o(92584);
    }
    
    public final void a(com.google.android.exoplayer2.i.m paramm, int paramInt)
    {
      AppMethodBeat.i(92583);
      this.aZw.a(paramm, paramInt);
      AppMethodBeat.o(92583);
    }
    
    public final void b(d.b paramb)
    {
      AppMethodBeat.i(92580);
      if (paramb == null)
      {
        this.aZw = new com.google.android.exoplayer2.c.d();
        AppMethodBeat.o(92580);
        return;
      }
      this.aZw = paramb.eF(this.type);
      if (this.aZw != null) {
        this.aZw.f(this.bmw);
      }
      AppMethodBeat.o(92580);
    }
    
    public final void f(Format paramFormat)
    {
      AppMethodBeat.i(92581);
      Object localObject = this.bmr;
      if (paramFormat == localObject)
      {
        this.bmw = paramFormat;
        this.aZw.f(this.bmw);
        AppMethodBeat.o(92581);
        return;
      }
      String str3 = ((Format)localObject).id;
      String str1;
      label62:
      int i;
      label76:
      float f;
      label92:
      int j;
      int k;
      String str2;
      if (paramFormat.aSa == null)
      {
        str1 = ((Format)localObject).aSa;
        if (paramFormat.bitrate != -1) {
          break label245;
        }
        i = ((Format)localObject).bitrate;
        if (paramFormat.aSh != -1.0F) {
          break label253;
        }
        f = ((Format)localObject).aSh;
        j = paramFormat.aSs;
        k = ((Format)localObject).aSs;
        if (paramFormat.aSt != null) {
          break label261;
        }
        str2 = ((Format)localObject).aSt;
        label119:
        if (((Format)localObject).aSg == null) {
          break label270;
        }
      }
      label261:
      label270:
      for (localObject = ((Format)localObject).aSg;; localObject = paramFormat.aSg)
      {
        paramFormat = new Format(str3, paramFormat.aSc, paramFormat.aSd, str1, i, paramFormat.aSe, paramFormat.width, paramFormat.height, f, paramFormat.aSi, paramFormat.aSj, paramFormat.aSl, paramFormat.aSk, paramFormat.aSm, paramFormat.channelCount, paramFormat.sampleRate, paramFormat.pcmEncoding, paramFormat.aSp, paramFormat.aSq, j | k, str2, paramFormat.aSu, paramFormat.aSr, paramFormat.aSf, (DrmInitData)localObject, paramFormat.aSb);
        break;
        str1 = paramFormat.aSa;
        break label62;
        label245:
        i = paramFormat.bitrate;
        break label76;
        label253:
        f = paramFormat.aSh;
        break label92;
        str2 = paramFormat.aSt;
        break label119;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract com.google.android.exoplayer2.c.m eF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.d
 * JD-Core Version:    0.7.0.1
 */