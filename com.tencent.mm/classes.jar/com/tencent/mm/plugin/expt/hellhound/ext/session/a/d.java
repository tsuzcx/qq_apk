package com.tencent.mm.plugin.expt.hellhound.ext.session.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.d.a;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static String asq(String paramString)
  {
    AppMethodBeat.i(185584);
    if (!com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asF(paramString))
    {
      paramString = asr(paramString) + "#";
      AppMethodBeat.o(185584);
      return paramString;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(asr(paramString)).append("#");
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.asp(paramString);
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(localEntry.getKey()).append("_").append(localEntry.getValue()).append("|");
      }
    }
    localObject2 = a.zJT;
    paramString = a.ash(paramString);
    if (paramString != null)
    {
      Log.i("HABBYGE-MALI.SessionPageCollector", "getLastSessionPagePath, matchedPathList: %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject2 = (caw)paramString.next();
        if (((caw)localObject2).aajU.size() > 0) {
          ((StringBuilder)localObject1).append(((caw)localObject2).aajX).append("_").append(((cav)((caw)localObject2).aajU.get(0)).startTime).append("|");
        }
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
  
  private static String asr(String paramString)
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
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asD(str) + "_" + paramString;
      AppMethodBeat.o(185585);
      return paramString;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asD(paramString);
    AppMethodBeat.o(185585);
    return paramString;
  }
  
  public static String dLE()
  {
    AppMethodBeat.i(169348);
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLB();
    if (localObject1 == null)
    {
      AppMethodBeat.o(169348);
      return null;
    }
    Object localObject2 = (String)((Pair)localObject1).first;
    String str = (String)((Pair)localObject1).second;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(asr((String)localObject2)).append("#");
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.aso((String)localObject2);
    if ((localObject3 != null) && (!((Map)localObject3).isEmpty()))
    {
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        ((StringBuilder)localObject1).append(localEntry.getKey()).append("_").append(localEntry.getValue()).append("|");
      }
    }
    localObject3 = a.zJT;
    localObject2 = a.asg((String)localObject2);
    if (localObject2 != null)
    {
      Log.i("HABBYGE-MALI.SessionPageCollector", "realGetSessionPageId, matchingPathList: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (caw)((Iterator)localObject2).next();
        if (((caw)localObject3).aajU.size() > 0) {
          ((StringBuilder)localObject1).append(((caw)localObject3).aajX).append("_").append(((cav)((caw)localObject3).aajU.get(0)).startTime).append("|");
        }
      }
    }
    localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).endsWith("|")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    localObject1 = (String)localObject1 + "$" + asq(str);
    AppMethodBeat.o(169348);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.a.d
 * JD-Core Version:    0.7.0.1
 */