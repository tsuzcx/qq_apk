package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class h
{
  private static final a BIB;
  public List<c> BIA;
  public String BIw;
  public String BIx;
  public String[] BIy;
  public String[] BIz;
  
  static
  {
    AppMethodBeat.i(131701);
    BIB = new a()
    {
      public final String[] aHS(String paramAnonymousString)
      {
        AppMethodBeat.i(131688);
        paramAnonymousString = c.a.BHa.split(paramAnonymousString);
        AppMethodBeat.o(131688);
        return paramAnonymousString;
      }
      
      public final String[] aHT(String paramAnonymousString)
      {
        AppMethodBeat.i(131689);
        paramAnonymousString = c.a.BHa.split(paramAnonymousString, 2);
        AppMethodBeat.o(131689);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(131701);
  }
  
  private h()
  {
    AppMethodBeat.i(131696);
    this.BIA = new ArrayList();
    AppMethodBeat.o(131696);
  }
  
  public static h a(String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(131700);
    h localh = new h();
    localh.BIw = paramString;
    localh.BIx = d.aHJ(paramString);
    localh.BIy = parama.aHS(localh.BIx);
    localh.BIz = parama.aHT(localh.BIx);
    paramString = localh.BIy;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      parama = paramString[i];
      localh.BIA.add(bI(parama, paramBoolean));
      i += 1;
    }
    AppMethodBeat.o(131700);
    return localh;
  }
  
  private static c bI(String paramString, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(131698);
    boolean bool = paramBoolean;
    int i;
    if (paramBoolean) {
      i = 0;
    }
    c localc;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      bool = paramBoolean;
      if (i < paramString.length())
      {
        if (!g.K(paramString.charAt(i))) {
          bool = false;
        }
      }
      else
      {
        localc = new c();
        if (!bool) {
          break label359;
        }
        localObject2 = g.BHI;
        localObject1 = new ArrayList();
        localObject3 = paramString.toLowerCase().toCharArray();
        i = j;
        for (;;)
        {
          if (i >= localObject3.length) {
            break label144;
          }
          j = localObject3[i];
          if (localObject2.BJq.BJr[(j - 97)] == null) {
            break;
          }
          ((List)localObject1).add(String.valueOf(localObject3[i]));
          i += 1;
        }
      }
      i += 1;
    }
    ((List)localObject1).clear();
    label144:
    if (((List)localObject1).size() > 0)
    {
      localObject2 = new b();
      ((b)localObject2).BIC = d.BIG;
      ((b)localObject2).content = Util.listToString((List)localObject1, "​");
      ((b)localObject2).BID = ((List)localObject1);
      localc.BIE.add(localObject2);
    }
    Object localObject1 = g.BHI.aHV(paramString);
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        if (((List)localObject2).size() > 0)
        {
          localObject3 = new b();
          ((b)localObject3).BIC = d.BIF;
          ((b)localObject3).content = Util.listToString((List)localObject2, "​");
          ((b)localObject3).BID = ((List)localObject2);
          localc.BIE.add(localObject3);
        }
      }
    }
    localObject1 = new b();
    ((b)localObject1).BIC = d.BIH;
    ((b)localObject1).content = paramString;
    localc.BIE.add(localObject1);
    for (;;)
    {
      AppMethodBeat.o(131698);
      return localc;
      label359:
      localObject1 = new b();
      ((b)localObject1).BIC = d.BIH;
      ((b)localObject1).content = paramString;
      localc.BIE.add(localObject1);
    }
  }
  
  public static h bJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131699);
    paramString = a(paramString, paramBoolean, BIB);
    AppMethodBeat.o(131699);
    return paramString;
  }
  
  public final String eqQ()
  {
    AppMethodBeat.i(131697);
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < this.BIA.size())
    {
      ((StringBuffer)localObject).append("(");
      ((StringBuffer)localObject).append(((c)this.BIA.get(i)).eqS());
      ((StringBuffer)localObject).append(")");
      if (i != this.BIA.size() - 1) {
        ((StringBuffer)localObject).append(" AND ");
      }
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(131697);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract String[] aHS(String paramString);
    
    public abstract String[] aHT(String paramString);
  }
  
  public static final class b
  {
    public h.d BIC;
    public List<String> BID;
    public String content;
  }
  
  public static final class c
  {
    public List<h.b> BIE;
    
    public c()
    {
      AppMethodBeat.i(131690);
      this.BIE = new ArrayList();
      AppMethodBeat.o(131690);
    }
    
    private List<String> eqR()
    {
      AppMethodBeat.i(131691);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.BIE.iterator();
      while (localIterator.hasNext())
      {
        h.b localb = (h.b)localIterator.next();
        if (!localArrayList.contains(localb.content)) {
          localArrayList.add(localb.content);
        }
      }
      AppMethodBeat.o(131691);
      return localArrayList;
    }
    
    public final String eqS()
    {
      AppMethodBeat.i(131692);
      Object localObject = eqR();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < ((List)localObject).size())
      {
        String str = (String)((List)localObject).get(i);
        localStringBuilder.append("\"");
        localStringBuilder.append(str);
        char c = str.charAt(str.length() - 1);
        if ((g.K(c)) || (g.L(c))) {
          localStringBuilder.append("\"*");
        }
        for (;;)
        {
          if (i != ((List)localObject).size() - 1) {
            localStringBuilder.append(" OR ");
          }
          i += 1;
          break;
          localStringBuilder.append("\"");
        }
      }
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(131692);
      return localObject;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(131695);
      BIF = new d("FullPY", 0);
      BIG = new d("ShortPY", 1);
      BIH = new d("OTHER", 2);
      BII = new d[] { BIF, BIG, BIH };
      AppMethodBeat.o(131695);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.h
 * JD-Core Version:    0.7.0.1
 */