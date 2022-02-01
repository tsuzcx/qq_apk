package com.tencent.mm.cj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/transvoice/TransVoiceTools;", "", "()V", "Companion", "plugin-audiologic_release"})
public final class a
{
  private static String BVb;
  private static boolean Jmu;
  private static String Jmv;
  private static boolean Jmw;
  public static final a Jmx;
  
  static
  {
    AppMethodBeat.i(148679);
    Jmx = new a((byte)0);
    BVb = "";
    Jmv = "";
    AppMethodBeat.o(148679);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/transvoice/TransVoiceTools$Companion;", "", "()V", "inNewTransVoiceScene", "", "getInNewTransVoiceScene", "()Z", "setInNewTransVoiceScene", "(Z)V", "inTransVoiceScene", "getInTransVoiceScene", "setInTransVoiceScene", "newVoiceFileName", "", "getNewVoiceFileName", "()Ljava/lang/String;", "setNewVoiceFileName", "(Ljava/lang/String;)V", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "isNewTransVoiceScene", "fileName", "isTransVoiceScene", "plugin-audiologic_release"})
  public static final class a
  {
    public static boolean aWJ(String paramString)
    {
      AppMethodBeat.i(148678);
      if ((a.fyC()) && (p.i(a.fyB(), paramString)))
      {
        AppMethodBeat.o(148678);
        return true;
      }
      AppMethodBeat.o(148678);
      return false;
    }
    
    public static void aWK(String paramString)
    {
      AppMethodBeat.i(185491);
      p.h(paramString, "<set-?>");
      a.aWI(paramString);
      AppMethodBeat.o(185491);
    }
    
    public static boolean aWL(String paramString)
    {
      AppMethodBeat.i(185492);
      if ((a.fyE()) && (p.i(a.fyD(), paramString)))
      {
        AppMethodBeat.o(185492);
        return true;
      }
      AppMethodBeat.o(185492);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cj.a
 * JD-Core Version:    0.7.0.1
 */