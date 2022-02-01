package com.tencent.mm.cl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/transvoice/TransVoiceTools;", "", "()V", "Companion", "plugin-audiologic_release"})
public final class a
{
  private static boolean FFt;
  private static String FFu;
  private static boolean FFv;
  public static final a FFw;
  private static String yYd;
  
  static
  {
    AppMethodBeat.i(148679);
    FFw = new a((byte)0);
    yYd = "";
    FFu = "";
    AppMethodBeat.o(148679);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/transvoice/TransVoiceTools$Companion;", "", "()V", "inNewTransVoiceScene", "", "getInNewTransVoiceScene", "()Z", "setInNewTransVoiceScene", "(Z)V", "inTransVoiceScene", "getInTransVoiceScene", "setInTransVoiceScene", "newVoiceFileName", "", "getNewVoiceFileName", "()Ljava/lang/String;", "setNewVoiceFileName", "(Ljava/lang/String;)V", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "isNewTransVoiceScene", "fileName", "isTransVoiceScene", "plugin-audiologic_release"})
  public static final class a
  {
    public static boolean aJT(String paramString)
    {
      AppMethodBeat.i(148678);
      if ((a.eOQ()) && (k.g(a.eOP(), paramString)))
      {
        AppMethodBeat.o(148678);
        return true;
      }
      AppMethodBeat.o(148678);
      return false;
    }
    
    public static void aJU(String paramString)
    {
      AppMethodBeat.i(185491);
      k.h(paramString, "<set-?>");
      a.aJS(paramString);
      AppMethodBeat.o(185491);
    }
    
    public static boolean aJV(String paramString)
    {
      AppMethodBeat.i(185492);
      if ((a.eOS()) && (k.g(a.eOR(), paramString)))
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
 * Qualified Name:     com.tencent.mm.cl.a
 * JD-Core Version:    0.7.0.1
 */