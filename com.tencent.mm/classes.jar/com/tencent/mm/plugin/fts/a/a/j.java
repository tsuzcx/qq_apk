package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class j
{
  private static final AtomicInteger wWR;
  public MMHandler handler;
  public final int id;
  public int kXb;
  public String query;
  public int scene;
  public String talker;
  public String wWS;
  public String wWT;
  public int[] wWU;
  public int[] wWV;
  public int wWW;
  public HashSet<String> wWX;
  public Comparator<m> wWY;
  public l wWZ;
  
  static
  {
    AppMethodBeat.i(131707);
    wWR = new AtomicInteger(0);
    AppMethodBeat.o(131707);
  }
  
  public j()
  {
    AppMethodBeat.i(131703);
    this.kXb = 0;
    this.query = null;
    this.wWS = null;
    this.wWT = null;
    this.talker = null;
    this.wWU = null;
    this.wWV = null;
    this.wWW = 2147483647;
    this.wWX = new HashSet();
    this.wWY = null;
    this.wWZ = null;
    this.handler = null;
    this.scene = -1;
    this.id = wWR.incrementAndGet();
    AppMethodBeat.o(131703);
  }
  
  public static j a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, HashSet<String> paramHashSet, Comparator<m> paramComparator, l paraml, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(131704);
    j localj = new j();
    localj.query = paramString;
    localj.wWS = null;
    localj.wWU = paramArrayOfInt1;
    localj.wWV = paramArrayOfInt2;
    localj.wWW = paramInt;
    localj.wWX = paramHashSet;
    localj.wWY = paramComparator;
    localj.wWZ = paraml;
    localj.handler = paramMMHandler;
    AppMethodBeat.o(131704);
    return localj;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(131705);
    if (this == paramObject)
    {
      AppMethodBeat.o(131705);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(131705);
      return false;
    }
    paramObject = (j)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(131705);
      return false;
    }
    AppMethodBeat.o(131705);
    return true;
  }
  
  public String toString()
  {
    AppMethodBeat.i(131706);
    String str = String.format("{id: %d, query: %s}", new Object[] { Integer.valueOf(this.id), this.query });
    AppMethodBeat.o(131706);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.j
 * JD-Core Version:    0.7.0.1
 */