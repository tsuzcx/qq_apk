package com.tencent.mm.ck;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/transvoice/TransVoiceTools;", "", "()V", "Companion", "plugin-audiologic_release"})
public final class a
{
  private static String BDD;
  private static boolean IRM;
  private static String IRN;
  private static boolean IRO;
  public static final a IRP;
  
  static
  {
    AppMethodBeat.i(148679);
    IRP = new a((byte)0);
    BDD = "";
    IRN = "";
    AppMethodBeat.o(148679);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/transvoice/TransVoiceTools$Companion;", "", "()V", "inNewTransVoiceScene", "", "getInNewTransVoiceScene", "()Z", "setInNewTransVoiceScene", "(Z)V", "inTransVoiceScene", "getInTransVoiceScene", "setInTransVoiceScene", "newVoiceFileName", "", "getNewVoiceFileName", "()Ljava/lang/String;", "setNewVoiceFileName", "(Ljava/lang/String;)V", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "isNewTransVoiceScene", "fileName", "isTransVoiceScene", "plugin-audiologic_release"})
  public static final class a
  {
    public static boolean aVi(String paramString)
    {
      AppMethodBeat.i(148678);
      if ((a.fuB()) && (p.i(a.fuA(), paramString)))
      {
        AppMethodBeat.o(148678);
        return true;
      }
      AppMethodBeat.o(148678);
      return false;
    }
    
    public static void aVj(String paramString)
    {
      AppMethodBeat.i(185491);
      p.h(paramString, "<set-?>");
      a.aVh(paramString);
      AppMethodBeat.o(185491);
    }
    
    public static boolean aVk(String paramString)
    {
      AppMethodBeat.i(185492);
      if ((a.fuD()) && (p.i(a.fuC(), paramString)))
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