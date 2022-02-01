package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class j
{
  private static final AtomicInteger syA;
  public ao handler;
  public final int id;
  public int jwR;
  public String query;
  public int scene;
  public String syB;
  public String syC;
  public int[] syD;
  public int[] syE;
  public int syF;
  public HashSet<String> syG;
  public Comparator<m> syH;
  public l syI;
  public String talker;
  
  static
  {
    AppMethodBeat.i(131707);
    syA = new AtomicInteger(0);
    AppMethodBeat.o(131707);
  }
  
  public j()
  {
    AppMethodBeat.i(131703);
    this.jwR = 0;
    this.query = null;
    this.syB = null;
    this.syC = null;
    this.talker = null;
    this.syD = null;
    this.syE = null;
    this.syF = 2147483647;
    this.syG = new HashSet();
    this.syH = null;
    this.syI = null;
    this.handler = null;
    this.scene = -1;
    this.id = syA.incrementAndGet();
    AppMethodBeat.o(131703);
  }
  
  public static j a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, HashSet<String> paramHashSet, Comparator<m> paramComparator, l paraml, ao paramao)
  {
    AppMethodBeat.i(131704);
    j localj = new j();
    localj.query = paramString;
    localj.syB = null;
    localj.syD = paramArrayOfInt1;
    localj.syE = paramArrayOfInt2;
    localj.syF = paramInt;
    localj.syG = paramHashSet;
    localj.syH = paramComparator;
    localj.syI = paraml;
    localj.handler = paramao;
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