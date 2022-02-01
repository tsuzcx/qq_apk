package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static final a syp;
  public String syk;
  public String syl;
  public String[] sym;
  public String[] syn;
  public List<c> syo;
  
  static
  {
    AppMethodBeat.i(131701);
    syp = new h.1();
    AppMethodBeat.o(131701);
  }
  
  private h()
  {
    AppMethodBeat.i(131696);
    this.syo = new ArrayList();
    AppMethodBeat.o(131696);
  }
  
  public static h a(String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(131700);
    h localh = new h();
    localh.syk = paramString;
    localh.syl = d.afQ(paramString);
    localh.sym = parama.split(localh.syl);
    localh.syn = parama.afY(localh.syl);
    paramString = localh.sym;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      parama = paramString[i];
      localh.syo.add(bh(parama, paramBoolean));
      i += 1;
    }
    AppMethodBeat.o(131700);
    return localh;
  }
  
  private static c bh(String paramString, boolean paramBoolean)
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
        if (!g.z(paramString.charAt(i))) {
          bool = false;
        }
      }
      else
      {
        localc = new c();
        if (!bool) {
          break label359;
        }
        localObject2 = g.sxv;
        localObject1 = new ArrayList();
        localObject3 = paramString.toLowerCase().toCharArray();
        i = j;
        for (;;)
        {
          if (i >= localObject3.length) {
            break label144;
          }
          j = localObject3[i];
          if (localObject2.szd.sze[(j - 97)] == null) {
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
      ((b)localObject2).syq = d.syu;
      ((b)localObject2).content = bs.n((List)localObject1, "​");
      ((b)localObject2).syr = ((List)localObject1);
      localc.sys.add(localObject2);
    }
    Object localObject1 = g.sxv.aga(paramString);
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        if (((List)localObject2).size() > 0)
        {
          localObject3 = new b();
          ((b)localObject3).syq = d.syt;
          ((b)localObject3).content = bs.n((List)localObject2, "​");
          ((b)localObject3).syr = ((List)localObject2);
          localc.sys.add(localObject3);
        }
      }
    }
    localObject1 = new b();
    ((b)localObject1).syq = d.syv;
    ((b)localObject1).content = paramString;
    localc.sys.add(localObject1);
    for (;;)
    {
      AppMethodBeat.o(131698);
      return localc;
      label359:
      localObject1 = new b();
      ((b)localObject1).syq = d.syv;
      ((b)localObject1).content = paramString;
      localc.sys.add(localObject1);
    }
  }
  
  public static h bi(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131699);
    paramString = a(paramString, paramBoolean, syp);
    AppMethodBeat.o(131699);
    return paramString;
  }
  
  public final String cKw()
  {
    AppMethodBeat.i(131697);
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < this.syo.size())
    {
      ((StringBuffer)localObject).append("(");
      ((StringBuffer)localObject).append(((c)this.syo.get(i)).cKy());
      ((StringBuffer)localObject).append(")");
      if (i != this.syo.size() - 1) {
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
    public abstract String[] afY(String paramString);
    
    public abstract String[] split(String paramString);
  }
  
  public static final class b
  {
    public String content;
    public h.d syq;
    public List<String> syr;
  }
  
  public static final class c
  {
    public List<h.b> sys;
    
    public c()
    {
      AppMethodBeat.i(131690);
      this.sys = new ArrayList();
      AppMethodBeat.o(131690);
    }
    
    private List<String> cKx()
    {
      AppMethodBeat.i(131691);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.sys.iterator();
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
    
    public final String cKy()
    {
      AppMethodBeat.i(131692);
      Object localObject = cKx();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < ((List)localObject).size())
      {
        String str = (String)((List)localObject).get(i);
        localStringBuilder.append("\"");
        localStringBuilder.append(str);
        char c = str.charAt(str.length() - 1);
        if ((g.z(c)) || (g.A(c))) {
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
      syt = new d("FullPY", 0);
      syu = new d("ShortPY", 1);
      syv = new d("OTHER", 2);
      syw = new d[] { syt, syu, syv };
      AppMethodBeat.o(131695);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.h
 * JD-Core Version:    0.7.0.1
 */