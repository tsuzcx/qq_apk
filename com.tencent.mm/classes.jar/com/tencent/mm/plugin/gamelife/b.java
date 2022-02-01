package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil;", "", "()V", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a IYX;
  
  static
  {
    AppMethodBeat.i(267755);
    IYX = new a((byte)0);
    AppMethodBeat.o(267755);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/GameLifeUtil$Companion;", "", "()V", "checkSessionId", "", "sessionId", "", "genStringArray", "stringList", "", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean aHt(String paramString)
    {
      AppMethodBeat.i(267728);
      if (paramString != null)
      {
        if (au.bwW(paramString))
        {
          AppMethodBeat.o(267728);
          return true;
        }
        Log.i("GameLife.PluginGameLife", "check sessionId failed");
        AppMethodBeat.o(267728);
        return false;
      }
      AppMethodBeat.o(267728);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b
 * JD-Core Version:    0.7.0.1
 */