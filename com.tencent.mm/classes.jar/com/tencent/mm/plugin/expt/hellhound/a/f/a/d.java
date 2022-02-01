package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.d.a;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static String aaQ(String paramString)
  {
    AppMethodBeat.i(185584);
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abg(paramString))
    {
      paramString = aaR(paramString);
      AppMethodBeat.o(185584);
      return paramString;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(aaR(paramString)).append("#");
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.aaP(paramString);
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(localEntry.getKey()).append("_").append(localEntry.getValue()).append("|");
      }
    }
    localObject2 = a.qpv;
    paramString = a.aaH(paramString);
    ac.i("SessionPageCollector", "HABBYGE-MALI, getLastSessionPagePath, matchedPathList: %d", new Object[] { Integer.valueOf(paramString.size()) });
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (aqg)paramString.next();
      if (((aqg)localObject2).EJg.size() > 0) {
        ((StringBuilder)localObject1).append(((aqg)localObject2).EJj).append("_").append(((aqf)((aqg)localObject2).EJg.get(0)).startTime).append("|");
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    paramString = (String)localObject1;
    if (((String)localObject1).endsWith("|")) {
      paramString = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    AppMethodBeat.o(185584);
    return paramString;
  }
  
  private static String aaR(String paramString)
  {
    AppMethodBeat.i(185585);
    if (paramString == null)
    {
      AppMethodBeat.o(185585);
      return null;
    }
    int i = paramString.lastIndexOf("_");
    if ((i > 0) && (i < paramString.length() - 1))
    {
      String str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abe(str) + "_" + paramString;
      AppMethodBeat.o(185585);
      return paramString;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abe(paramString);
    AppMethodBeat.o(185585);
    return paramString;
  }
  
  public static String ckv()
  {
    AppMethodBeat.i(169348);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cks();
    if (localObject1 == null)
    {
      ac.e("SessionPageCollector", "HABBYGE-MALI, realGetSessionPageId, pair == null");
      AppMethodBeat.o(169348);
      return null;
    }
    Object localObject2 = (String)((Pair)localObject1).first;
    String str = (String)((Pair)localObject1).second;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(aaR((String)localObject2)).append("#");
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.aaO((String)localObject2);
    if ((localObject3 != null) && (!((Map)localObject3).isEmpty()))
    {
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(localEntry.getKey()).append("_").append(localEntry.getValue()).append("|");
      }
    }
    localObject3 = a.qpv;
    localObject2 = a.aaG((String)localObject2);
    if (localObject2 != null)
    {
      ac.i("SessionPageCollector", "HABBYGE-MALI, realGetSessionPageId, matchingPathList: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (aqg)((Iterator)localObject2).next();
        if (((aqg)localObject3).EJg.size() > 0) {
          ((StringBuilder)localObject1).append(((aqg)localObject3).EJj).append("_").append(((aqf)((aqg)localObject3).EJg.get(0)).startTime).append("|");
        }
      }
    }
    localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).endsWith("|")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    localObject1 = (String)localObject1 + "$" + aaQ(str);
    AppMethodBeat.o(169348);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.d
 * JD-Core Version:    0.7.0.1
 */