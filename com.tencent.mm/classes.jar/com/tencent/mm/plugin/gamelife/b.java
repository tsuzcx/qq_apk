package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class b
{
  public static final a uwo;
  
  static
  {
    AppMethodBeat.i(211188);
    uwo = new a((byte)0);
    AppMethodBeat.o(211188);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil$Companion;", "", "()V", "checkSessionId", "", "sessionId", "", "genStringArray", "stringList", "", "plugin-gamelife_release"})
  public static final class a
  {
    public static boolean amz(String paramString)
    {
      AppMethodBeat.i(211186);
      if (paramString != null)
      {
        if (am.aSV(paramString))
        {
          AppMethodBeat.o(211186);
          return true;
        }
        ad.i("GameLife.PluginGameLife", "check sessionId failed");
        AppMethodBeat.o(211186);
        return false;
      }
      AppMethodBeat.o(211186);
      return false;
    }
    
    public static String ef(List<String> paramList)
    {
      AppMethodBeat.i(211187);
      p.h(paramList, "stringList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(211187);
        return "()";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      int j = paramList.size();
      int i = 0;
      while (i < j - 1)
      {
        localStringBuilder.append("\"").append((String)paramList.get(i)).append("\",");
        i += 1;
      }
      localStringBuilder.append("\"").append((String)paramList.get(paramList.size() - 1)).append("\")");
      paramList = localStringBuilder.toString();
      p.g(paramList, "sb.toString()");
      AppMethodBeat.o(211187);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b
 * JD-Core Version:    0.7.0.1
 */