package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class l
{
  private static final AtomicInteger Htu;
  public HashSet<String> HtA;
  public Comparator<o> HtB;
  public com.tencent.mm.plugin.fts.a.l HtC;
  public List<String> HtD;
  public String Htv;
  public String Htw;
  public int[] Htx;
  public int[] Hty;
  public int Htz;
  public MMHandler handler;
  public final int id;
  public int qRb;
  public String query;
  public int scene;
  public String talker;
  
  static
  {
    AppMethodBeat.i(131707);
    Htu = new AtomicInteger(0);
    AppMethodBeat.o(131707);
  }
  
  public l()
  {
    AppMethodBeat.i(131703);
    this.qRb = 0;
    this.query = null;
    this.Htv = null;
    this.Htw = null;
    this.talker = null;
    this.Htx = null;
    this.Hty = null;
    this.Htz = 2147483647;
    this.HtA = new HashSet();
    this.HtB = null;
    this.HtC = null;
    this.handler = null;
    this.scene = -1;
    this.HtD = new ArrayList();
    this.id = Htu.incrementAndGet();
    AppMethodBeat.o(131703);
  }
  
  public static l a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, HashSet<String> paramHashSet, Comparator<o> paramComparator, com.tencent.mm.plugin.fts.a.l paraml, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(131704);
    l locall = new l();
    locall.query = paramString;
    locall.Htv = null;
    locall.Htx = paramArrayOfInt1;
    locall.Hty = paramArrayOfInt2;
    locall.Htz = paramInt;
    locall.HtA = paramHashSet;
    locall.HtB = paramComparator;
    locall.HtC = paraml;
    locall.handler = paramMMHandler;
    AppMethodBeat.o(131704);
    return locall;
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
    paramObject = (l)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.l
 * JD-Core Version:    0.7.0.1
 */