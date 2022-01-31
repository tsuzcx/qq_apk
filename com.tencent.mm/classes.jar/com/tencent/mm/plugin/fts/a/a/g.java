package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private static final g.a mSB;
  public List<c> mSA;
  public String mSw;
  public String mSx;
  public String[] mSy;
  public String[] mSz;
  
  static
  {
    AppMethodBeat.i(114265);
    mSB = new g.1();
    AppMethodBeat.o(114265);
  }
  
  private g()
  {
    AppMethodBeat.i(114260);
    this.mSA = new ArrayList();
    AppMethodBeat.o(114260);
  }
  
  public static g a(String paramString, boolean paramBoolean, g.a parama)
  {
    AppMethodBeat.i(114264);
    g localg = new g();
    localg.mSw = paramString;
    localg.mSx = d.Pa(paramString);
    localg.mSy = parama.split(localg.mSx);
    localg.mSz = parama.Ph(localg.mSx);
    paramString = localg.mSy;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      parama = paramString[i];
      localg.mSA.add(aT(parama, paramBoolean));
      i += 1;
    }
    AppMethodBeat.o(114264);
    return localg;
  }
  
  private static c aT(String paramString, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(114262);
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
        if (!com.tencent.mm.plugin.fts.a.g.x(paramString.charAt(i))) {
          bool = false;
        }
      }
      else
      {
        localc = new c();
        if (!bool) {
          break label359;
        }
        localObject2 = com.tencent.mm.plugin.fts.a.g.mRK;
        localObject1 = new ArrayList();
        localObject3 = paramString.toLowerCase().toCharArray();
        i = j;
        for (;;)
        {
          if (i >= localObject3.length) {
            break label144;
          }
          j = localObject3[i];
          if (localObject2.mTp.mTq[(j - 97)] == null) {
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
      localObject2 = new g.b();
      ((g.b)localObject2).mSC = g.d.mSG;
      ((g.b)localObject2).content = bo.d((List)localObject1, "​");
      ((g.b)localObject2).mSD = ((List)localObject1);
      localc.mSE.add(localObject2);
    }
    Object localObject1 = com.tencent.mm.plugin.fts.a.g.mRK.Pj(paramString);
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        if (((List)localObject2).size() > 0)
        {
          localObject3 = new g.b();
          ((g.b)localObject3).mSC = g.d.mSF;
          ((g.b)localObject3).content = bo.d((List)localObject2, "​");
          ((g.b)localObject3).mSD = ((List)localObject2);
          localc.mSE.add(localObject3);
        }
      }
    }
    localObject1 = new g.b();
    ((g.b)localObject1).mSC = g.d.mSH;
    ((g.b)localObject1).content = paramString;
    localc.mSE.add(localObject1);
    for (;;)
    {
      AppMethodBeat.o(114262);
      return localc;
      label359:
      localObject1 = new g.b();
      ((g.b)localObject1).mSC = g.d.mSH;
      ((g.b)localObject1).content = paramString;
      localc.mSE.add(localObject1);
    }
  }
  
  public static g aU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(114263);
    paramString = a(paramString, paramBoolean, mSB);
    AppMethodBeat.o(114263);
    return paramString;
  }
  
  public final String bBX()
  {
    AppMethodBeat.i(114261);
    Object localObject = new StringBuffer();
    int i = 0;
    while (i < this.mSA.size())
    {
      ((StringBuffer)localObject).append("(");
      ((StringBuffer)localObject).append(((c)this.mSA.get(i)).bBZ());
      ((StringBuffer)localObject).append(")");
      if (i != this.mSA.size() - 1) {
        ((StringBuffer)localObject).append(" AND ");
      }
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(114261);
    return localObject;
  }
  
  public static final class c
  {
    public List<g.b> mSE;
    
    public c()
    {
      AppMethodBeat.i(114254);
      this.mSE = new ArrayList();
      AppMethodBeat.o(114254);
    }
    
    private List<String> bBY()
    {
      AppMethodBeat.i(114255);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mSE.iterator();
      while (localIterator.hasNext())
      {
        g.b localb = (g.b)localIterator.next();
        if (!localArrayList.contains(localb.content)) {
          localArrayList.add(localb.content);
        }
      }
      AppMethodBeat.o(114255);
      return localArrayList;
    }
    
    public final String bBZ()
    {
      AppMethodBeat.i(114256);
      Object localObject = bBY();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < ((List)localObject).size())
      {
        String str = (String)((List)localObject).get(i);
        localStringBuilder.append("\"");
        localStringBuilder.append(str);
        char c = str.charAt(str.length() - 1);
        if ((com.tencent.mm.plugin.fts.a.g.x(c)) || (com.tencent.mm.plugin.fts.a.g.y(c))) {
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
      AppMethodBeat.o(114256);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.g
 * JD-Core Version:    0.7.0.1
 */