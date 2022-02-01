package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.d.a;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static String afA(String paramString)
  {
    AppMethodBeat.i(185584);
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afP(paramString))
    {
      paramString = afB(paramString) + "#";
      AppMethodBeat.o(185584);
      return paramString;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(afB(paramString)).append("#");
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.afz(paramString);
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(localEntry.getKey()).append("_").append(localEntry.getValue()).append("|");
      }
    }
    localObject2 = a.rgA;
    paramString = a.afr(paramString);
    ae.i("HABBYGE-MALI.SessionPageCollector", "getLastSessionPagePath, matchedPathList: %d", new Object[] { Integer.valueOf(paramString.size()) });
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (aus)paramString.next();
      if (((aus)localObject2).GLG.size() > 0) {
        ((StringBuilder)localObject1).append(((aus)localObject2).GLJ).append("_").append(((aur)((aus)localObject2).GLG.get(0)).startTime).append("|");
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
  
  private static String afB(String paramString)
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
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afN(str) + "_" + paramString;
      AppMethodBeat.o(185585);
      return paramString;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afN(paramString);
    AppMethodBeat.o(185585);
    return paramString;
  }
  
  public static String crn()
  {
    AppMethodBeat.i(169348);
    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.crk();
    if (localObject1 == null)
    {
      ae.e("HABBYGE-MALI.SessionPageCollector", "realGetSessionPageId, pair == null");
      AppMethodBeat.o(169348);
      return null;
    }
    Object localObject2 = (String)((Pair)localObject1).first;
    String str = (String)((Pair)localObject1).second;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(afB((String)localObject2)).append("#");
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.afy((String)localObject2);
    if ((localObject3 != null) && (!((Map)localObject3).isEmpty()))
    {
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(localEntry.getKey()).append("_").append(localEntry.getValue()).append("|");
      }
    }
    localObject3 = a.rgA;
    localObject2 = a.afq((String)localObject2);
    if (localObject2 != null)
    {
      ae.i("HABBYGE-MALI.SessionPageCollector", "realGetSessionPageId, matchingPathList: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (aus)((Iterator)localObject2).next();
        if (((aus)localObject3).GLG.size() > 0) {
          ((StringBuilder)localObject1).append(((aus)localObject3).GLJ).append("_").append(((aur)((aus)localObject3).GLG.get(0)).startTime).append("|");
        }
      }
    }
    localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).endsWith("|")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    localObject1 = (String)localObject1 + "$" + afA(str);
    AppMethodBeat.o(169348);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.d
 * JD-Core Version:    0.7.0.1
 */