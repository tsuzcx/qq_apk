package com.tencent.mm.cq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/transvoice/TransVoiceTools;", "", "()V", "Companion", "plugin-audiologic_release"})
public final class a
{
  private static String Nja;
  private static boolean VPl;
  private static String VPm;
  private static boolean VPn;
  public static final a VPo;
  
  static
  {
    AppMethodBeat.i(148679);
    VPo = new a((byte)0);
    Nja = "";
    VPm = "";
    AppMethodBeat.o(148679);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/transvoice/TransVoiceTools$Companion;", "", "()V", "inNewTransVoiceScene", "", "getInNewTransVoiceScene", "()Z", "setInNewTransVoiceScene", "(Z)V", "inTransVoiceScene", "getInTransVoiceScene", "setInTransVoiceScene", "newVoiceFileName", "", "getNewVoiceFileName", "()Ljava/lang/String;", "setNewVoiceFileName", "(Ljava/lang/String;)V", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "isNewTransVoiceScene", "fileName", "isTransVoiceScene", "plugin-audiologic_release"})
  public static final class a
  {
    public static boolean byh(String paramString)
    {
      AppMethodBeat.i(148678);
      if ((a.hEX()) && (p.h(a.hEW(), paramString)))
      {
        AppMethodBeat.o(148678);
        return true;
      }
      AppMethodBeat.o(148678);
      return false;
    }
    
    public static void byi(String paramString)
    {
      AppMethodBeat.i(185491);
      p.k(paramString, "<set-?>");
      a.byg(paramString);
      AppMethodBeat.o(185491);
    }
    
    public static boolean byj(String paramString)
    {
      AppMethodBeat.i(185492);
      if ((a.hEZ()) && (p.h(a.hEY(), paramString)))
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
 * Qualified Name:     com.tencent.mm.cq.a
 * JD-Core Version:    0.7.0.1
 */