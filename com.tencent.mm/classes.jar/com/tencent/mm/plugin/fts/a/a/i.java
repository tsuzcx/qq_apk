package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class i
{
  private static final AtomicInteger mSM;
  public ak handler;
  public int hdl;
  public final int id;
  public String mSN;
  public String mSO;
  public int[] mSP;
  public int[] mSQ;
  public int mSR;
  public HashSet<String> mSS;
  public Comparator<l> mST;
  public com.tencent.mm.plugin.fts.a.l mSU;
  public String query;
  public int scene;
  public String talker;
  
  static
  {
    AppMethodBeat.i(114271);
    mSM = new AtomicInteger(0);
    AppMethodBeat.o(114271);
  }
  
  public i()
  {
    AppMethodBeat.i(114267);
    this.hdl = 0;
    this.query = null;
    this.mSN = null;
    this.mSO = null;
    this.talker = null;
    this.mSP = null;
    this.mSQ = null;
    this.mSR = 2147483647;
    this.mSS = new HashSet();
    this.mST = null;
    this.mSU = null;
    this.handler = null;
    this.scene = -1;
    this.id = mSM.incrementAndGet();
    AppMethodBeat.o(114267);
  }
  
  public static i a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, HashSet<String> paramHashSet, Comparator<l> paramComparator, com.tencent.mm.plugin.fts.a.l paraml, ak paramak)
  {
    AppMethodBeat.i(114268);
    i locali = new i();
    locali.query = paramString;
    locali.mSN = null;
    locali.mSP = paramArrayOfInt1;
    locali.mSQ = paramArrayOfInt2;
    locali.mSR = paramInt;
    locali.mSS = paramHashSet;
    locali.mST = paramComparator;
    locali.mSU = paraml;
    locali.handler = paramak;
    AppMethodBeat.o(114268);
    return locali;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114269);
    if (this == paramObject)
    {
      AppMethodBeat.o(114269);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(114269);
      return false;
    }
    paramObject = (i)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(114269);
      return false;
    }
    AppMethodBeat.o(114269);
    return true;
  }
  
  public String toString()
  {
    AppMethodBeat.i(114270);
    String str = String.format("{id: %d, query: %s}", new Object[] { Integer.valueOf(this.id), this.query });
    AppMethodBeat.o(114270);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.i
 * JD-Core Version:    0.7.0.1
 */