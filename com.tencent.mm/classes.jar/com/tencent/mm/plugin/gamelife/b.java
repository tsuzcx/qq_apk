package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil;", "", "()V", "Companion", "plugin-gamelife_release"})
public final class b
{
  public static final a xZZ;
  
  static
  {
    AppMethodBeat.i(241190);
    xZZ = new a((byte)0);
    AppMethodBeat.o(241190);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil$Companion;", "", "()V", "checkSessionId", "", "sessionId", "", "genStringArray", "stringList", "", "plugin-gamelife_release"})
  public static final class a
  {
    public static boolean aAQ(String paramString)
    {
      AppMethodBeat.i(241188);
      if (paramString != null)
      {
        if (as.bju(paramString))
        {
          AppMethodBeat.o(241188);
          return true;
        }
        Log.i("GameLife.PluginGameLife", "check sessionId failed");
        AppMethodBeat.o(241188);
        return false;
      }
      AppMethodBeat.o(241188);
      return false;
    }
    
    public static String fc(List<String> paramList)
    {
      AppMethodBeat.i(241189);
      p.h(paramList, "stringList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(241189);
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
      p.g(paramList, "sb.toString()");
      AppMethodBeat.o(241189);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b
 * JD-Core Version:    0.7.0.1
 */