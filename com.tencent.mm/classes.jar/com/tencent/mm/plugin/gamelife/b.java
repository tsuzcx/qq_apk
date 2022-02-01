package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class b
{
  public static final a DeG;
  
  static
  {
    AppMethodBeat.i(203161);
    DeG = new a((byte)0);
    AppMethodBeat.o(203161);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil$Companion;", "", "()V", "checkSessionId", "", "sessionId", "", "genStringArray", "stringList", "", "plugin-gamelife_release"})
  public static final class a
  {
    public static boolean aKC(String paramString)
    {
      AppMethodBeat.i(203466);
      if (paramString != null)
      {
        if (as.bvQ(paramString))
        {
          AppMethodBeat.o(203466);
          return true;
        }
        Log.i("GameLife.PluginGameLife", "check sessionId failed");
        AppMethodBeat.o(203466);
        return false;
      }
      AppMethodBeat.o(203466);
      return false;
    }
    
    public static String fq(List<String> paramList)
    {
      AppMethodBeat.i(203475);
      p.k(paramList, "stringList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(203475);
        return "()";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      int j = paramList.size();
      int i = 0;
      while (i < j - 1)
      {
        localStringBuilder.append("'").append((String)paramList.get(i)).append("',");
        i += 1;
      }
      localStringBuilder.append("'").append((String)paramList.get(paramList.size() - 1)).append("')");
      paramList = localStringBuilder.toString();
      p.j(paramList, "sb.toString()");
      AppMethodBeat.o(203475);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b
 * JD-Core Version:    0.7.0.1
 */