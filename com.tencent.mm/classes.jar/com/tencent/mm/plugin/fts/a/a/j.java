package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class j
{
  private static final AtomicInteger rpG;
  public ap handler;
  public int iWB;
  public final int id;
  public String query;
  public String rpH;
  public String rpI;
  public int[] rpJ;
  public int[] rpK;
  public int rpL;
  public HashSet<String> rpM;
  public Comparator<m> rpN;
  public l rpO;
  public int scene;
  public String talker;
  
  static
  {
    AppMethodBeat.i(131707);
    rpG = new AtomicInteger(0);
    AppMethodBeat.o(131707);
  }
  
  public j()
  {
    AppMethodBeat.i(131703);
    this.iWB = 0;
    this.query = null;
    this.rpH = null;
    this.rpI = null;
    this.talker = null;
    this.rpJ = null;
    this.rpK = null;
    this.rpL = 2147483647;
    this.rpM = new HashSet();
    this.rpN = null;
    this.rpO = null;
    this.handler = null;
    this.scene = -1;
    this.id = rpG.incrementAndGet();
    AppMethodBeat.o(131703);
  }
  
  public static j a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, HashSet<String> paramHashSet, Comparator<m> paramComparator, l paraml, ap paramap)
  {
    AppMethodBeat.i(131704);
    j localj = new j();
    localj.query = paramString;
    localj.rpH = null;
    localj.rpJ = paramArrayOfInt1;
    localj.rpK = paramArrayOfInt2;
    localj.rpL = paramInt;
    localj.rpM = paramHashSet;
    localj.rpN = paramComparator;
    localj.rpO = paraml;
    localj.handler = paramap;
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