package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class j
{
  private static final AtomicInteger tFS;
  public aq handler;
  public final int id;
  public int jUf;
  public String query;
  public int scene;
  public String tFT;
  public String tFU;
  public int[] tFV;
  public int[] tFW;
  public int tFX;
  public HashSet<String> tFY;
  public Comparator<m> tFZ;
  public l tGa;
  public String talker;
  
  static
  {
    AppMethodBeat.i(131707);
    tFS = new AtomicInteger(0);
    AppMethodBeat.o(131707);
  }
  
  public j()
  {
    AppMethodBeat.i(131703);
    this.jUf = 0;
    this.query = null;
    this.tFT = null;
    this.tFU = null;
    this.talker = null;
    this.tFV = null;
    this.tFW = null;
    this.tFX = 2147483647;
    this.tFY = new HashSet();
    this.tFZ = null;
    this.tGa = null;
    this.handler = null;
    this.scene = -1;
    this.id = tFS.incrementAndGet();
    AppMethodBeat.o(131703);
  }
  
  public static j a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, HashSet<String> paramHashSet, Comparator<m> paramComparator, l paraml, aq paramaq)
  {
    AppMethodBeat.i(131704);
    j localj = new j();
    localj.query = paramString;
    localj.tFT = null;
    localj.tFV = paramArrayOfInt1;
    localj.tFW = paramArrayOfInt2;
    localj.tFX = paramInt;
    localj.tFY = paramHashSet;
    localj.tFZ = paramComparator;
    localj.tGa = paraml;
    localj.handler = paramaq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.j
 * JD-Core Version:    0.7.0.1
 */