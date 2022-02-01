package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class b
{
  public static final a uHN;
  
  static
  {
    AppMethodBeat.i(211951);
    uHN = new a((byte)0);
    AppMethodBeat.o(211951);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil$Companion;", "", "()V", "checkSessionId", "", "sessionId", "", "genStringArray", "stringList", "", "plugin-gamelife_release"})
  public static final class a
  {
    public static boolean anx(String paramString)
    {
      AppMethodBeat.i(211949);
      if (paramString != null)
      {
        if (an.aUv(paramString))
        {
          AppMethodBeat.o(211949);
          return true;
        }
        ae.i("GameLife.PluginGameLife", "check sessionId failed");
        AppMethodBeat.o(211949);
        return false;
      }
      AppMethodBeat.o(211949);
      return false;
    }
    
    public static String ej(List<String> paramList)
    {
      AppMethodBeat.i(211950);
      p.h(paramList, "stringList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(211950);
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
      AppMethodBeat.o(211950);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b
 * JD-Core Version:    0.7.0.1
 */