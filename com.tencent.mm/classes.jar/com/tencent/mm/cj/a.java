package com.tencent.mm.cj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/transvoice/TransVoiceTools;", "", "()V", "Companion", "plugin-audiologic_release"})
public final class a
{
  private static String GvH;
  private static boolean Own;
  private static String Owo;
  private static boolean Owp;
  public static final a Owq;
  
  static
  {
    AppMethodBeat.i(148679);
    Owq = new a((byte)0);
    GvH = "";
    Owo = "";
    AppMethodBeat.o(148679);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/transvoice/TransVoiceTools$Companion;", "", "()V", "inNewTransVoiceScene", "", "getInNewTransVoiceScene", "()Z", "setInNewTransVoiceScene", "(Z)V", "inTransVoiceScene", "getInTransVoiceScene", "setInTransVoiceScene", "newVoiceFileName", "", "getNewVoiceFileName", "()Ljava/lang/String;", "setNewVoiceFileName", "(Ljava/lang/String;)V", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "isNewTransVoiceScene", "fileName", "isTransVoiceScene", "plugin-audiologic_release"})
  public static final class a
  {
    public static boolean blI(String paramString)
    {
      AppMethodBeat.i(148678);
      if ((a.gGq()) && (p.j(a.gGp(), paramString)))
      {
        AppMethodBeat.o(148678);
        return true;
      }
      AppMethodBeat.o(148678);
      return false;
    }
    
    public static void blJ(String paramString)
    {
      AppMethodBeat.i(185491);
      p.h(paramString, "<set-?>");
      a.blH(paramString);
      AppMethodBeat.o(185491);
    }
    
    public static boolean blK(String paramString)
    {
      AppMethodBeat.i(185492);
      if ((a.gGs()) && (p.j(a.gGr(), paramString)))
      {
        AppMethodBeat.o(185492);
        return true;
      }
      AppMethodBeat.o(185492);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cj.a
 * JD-Core Version:    0.7.0.1
 */