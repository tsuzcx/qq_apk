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

public final class j
{
  private static final a Htj;
  public String Hte;
  public String Htf;
  public String[] Htg;
  public String[] Hth;
  public List<c> Hti;
  
  static
  {
    AppMethodBeat.i(131701);
    Htj = new a()
    {
      public final String[] aEq(String paramAnonymousString)
      {
        AppMethodBeat.i(131688);
        paramAnonymousString = c.a.HrE.split(paramAnonymousString);
        AppMethodBeat.o(131688);
        return paramAnonymousString;
      }
      
      public final String[] aEr(String paramAnonymousString)
      {
        AppMethodBeat.i(131689);
        paramAnonymousString = c.a.HrE.split(paramAnonymousString, 2);
        AppMethodBeat.o(131689);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(131701);
  }
  
  private j()
  {
    AppMethodBeat.i(131696);
    this.Hti = new ArrayList();
    AppMethodBeat.o(131696);
  }
  
  public static j a(String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(131700);
    j localj = new j();
    localj.Hte = paramString;
    localj.Htf = d.aEh(paramString);
    localj.Htg = parama.aEq(localj.Htf);
    localj.Hth = parama.aEr(localj.Htf);
    paramString = localj.Htg;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      parama = paramString[i];
      localj.Hti.add(cb(parama, paramBoolean));
      i += 1;
    }
    AppMethodBeat.o(131700);
    return localj;
  }
  
  private static c cb(String paramString, boolean paramBoolean)
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
        if (!g.D(paramString.charAt(i))) {
          bool = false;
        }
      }
      else
      {
        localc = new c();
        if (!bool) {
          break label359;
        }
        localObject2 = g.Hsn;
        localObject1 = new ArrayList();
        localObject3 = paramString.toLowerCase().toCharArray();
        i = j;
        for (;;)
        {
          if (i >= localObject3.length) {
            break label144;
          }
          j = localObject3[i];
          if (localObject2.Hua.Hub[(j - 97)] == null) {
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
      ((b)localObject2).Htk = d.Hto;
      ((b)localObject2).content = Util.listToString((List)localObject1, "​");
      ((b)localObject2).Htl = ((List)localObject1);
      localc.Htm.add(localObject2);
    }
    Object localObject1 = g.Hsn.aEt(paramString);
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        if (((List)localObject2).size() > 0)
        {
          localObject3 = new b();
          ((b)localObject3).Htk = d.Htn;
          ((b)localObject3).content = Util.listToString((List)localObject2, "​");
          ((b)localObject3).Htl = ((List)localObject2);
          localc.Htm.add(localObject3);
        }
      }
    }
    localObject1 = new b();
    ((b)localObject1).Htk = d.Htp;
    ((b)localObject1).content = paramString;
    localc.Htm.add(localObject1);
    for (;;)
    {
      AppMethodBeat.o(131698);
      return localc;
      label359:
      localObject1 = new b();
      ((b)localObject1).Htk = d.Htp;
      ((b)localObject1).content = paramString;
      localc.Htm.add(localObject1);
    }
  }
  
  public static j cc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131699);
    paramString = a(paramString, paramBoolean, Htj);
    AppMethodBeat.o(131699);
    return paramString;
  }
  
  public static j hR(List<String> paramList)
  {
    AppMethodBeat.i(265536);
    j localj = new j();
    localj.Hte = "";
    localj.Htf = "";
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String[] arrayOfString = ((String)paramList.next()).split(",");
      c localc = new c();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        b localb = new b();
        localb.Htk = d.Htp;
        localb.content = str;
        localc.Htm.add(localb);
        i += 1;
      }
      localj.Hti.add(localc);
    }
    AppMethodBeat.o(265536);
    return localj;
  }
  
  public final String fxx()
  {
    AppMethodBeat.i(131697);
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < this.Hti.size())
    {
      ((StringBuffer)localObject).append("(");
      ((StringBuffer)localObject).append(((c)this.Hti.get(i)).fxA());
      ((StringBuffer)localObject).append(")");
      if (i != this.Hti.size() - 1) {
        ((StringBuffer)localObject).append(" AND ");
      }
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(131697);
    return localObject;
  }
  
  public final String fxy()
  {
    AppMethodBeat.i(265539);
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < this.Hti.size())
    {
      ((StringBuffer)localObject).append("(");
      ((StringBuffer)localObject).append(((c)this.Hti.get(i)).fxA());
      ((StringBuffer)localObject).append(")");
      if (i != this.Hti.size() - 1) {
        ((StringBuffer)localObject).append(" OR ");
      }
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(265539);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract String[] aEq(String paramString);
    
    public abstract String[] aEr(String paramString);
  }
  
  public static final class b
  {
    public j.d Htk;
    public List<String> Htl;
    public String content;
  }
  
  public static final class c
  {
    public List<j.b> Htm;
    
    public c()
    {
      AppMethodBeat.i(131690);
      this.Htm = new ArrayList();
      AppMethodBeat.o(131690);
    }
    
    private List<String> fxz()
    {
      AppMethodBeat.i(131691);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Htm.iterator();
      while (localIterator.hasNext())
      {
        j.b localb = (j.b)localIterator.next();
        if (!localArrayList.contains(localb.content)) {
          localArrayList.add(localb.content);
        }
      }
      AppMethodBeat.o(131691);
      return localArrayList;
    }
    
    public final String fxA()
    {
      AppMethodBeat.i(131692);
      Object localObject = fxz();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < ((List)localObject).size())
      {
        String str = (String)((List)localObject).get(i);
        localStringBuilder.append("\"");
        localStringBuilder.append(str);
        char c = str.charAt(str.length() - 1);
        if ((g.D(c)) || (g.E(c))) {
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
      Htn = new d("FullPY", 0);
      Hto = new d("ShortPY", 1);
      Htp = new d("OTHER", 2);
      Htq = new d[] { Htn, Hto, Htp };
      AppMethodBeat.o(131695);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.j
 * JD-Core Version:    0.7.0.1
 */