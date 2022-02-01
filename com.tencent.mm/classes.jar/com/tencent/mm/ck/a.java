package com.tencent.mm.ck;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/transvoice/TransVoiceTools;", "", "()V", "Companion", "plugin-audiologic_release"})
public final class a
{
  private static String AlS;
  private static boolean Hew;
  private static String Hex;
  private static boolean Hey;
  public static final a Hez;
  
  static
  {
    AppMethodBeat.i(148679);
    Hez = new a((byte)0);
    AlS = "";
    Hex = "";
    AppMethodBeat.o(148679);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/transvoice/TransVoiceTools$Companion;", "", "()V", "inNewTransVoiceScene", "", "getInNewTransVoiceScene", "()Z", "setInNewTransVoiceScene", "(Z)V", "inTransVoiceScene", "getInTransVoiceScene", "setInTransVoiceScene", "newVoiceFileName", "", "getNewVoiceFileName", "()Ljava/lang/String;", "setNewVoiceFileName", "(Ljava/lang/String;)V", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "isNewTransVoiceScene", "fileName", "isTransVoiceScene", "plugin-audiologic_release"})
  public static final class a
  {
    public static boolean aPr(String paramString)
    {
      AppMethodBeat.i(148678);
      if ((a.feu()) && (k.g(a.fet(), paramString)))
      {
        AppMethodBeat.o(148678);
        return true;
      }
      AppMethodBeat.o(148678);
      return false;
    }
    
    public static void aPs(String paramString)
    {
      AppMethodBeat.i(185491);
      k.h(paramString, "<set-?>");
      a.aPq(paramString);
      AppMethodBeat.o(185491);
    }
    
    public static boolean aPt(String paramString)
    {
      AppMethodBeat.i(185492);
      if ((a.few()) && (k.g(a.fev(), paramString)))
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
 * Qualified Name:     com.tencent.mm.ck.a
 * JD-Core Version:    0.7.0.1
 */