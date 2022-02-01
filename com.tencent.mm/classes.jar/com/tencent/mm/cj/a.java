package com.tencent.mm.cj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/transvoice/TransVoiceTools;", "", "()V", "Companion", "plugin-audiologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static String TVZ;
  public static final a adtq;
  private static boolean adtr;
  private static String adts;
  private static boolean adtt;
  
  static
  {
    AppMethodBeat.i(148679);
    adtq = new a((byte)0);
    TVZ = "";
    adts = "";
    AppMethodBeat.o(148679);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/transvoice/TransVoiceTools$Companion;", "", "()V", "inNewTransVoiceScene", "", "getInNewTransVoiceScene", "()Z", "setInNewTransVoiceScene", "(Z)V", "inTransVoiceScene", "getInTransVoiceScene", "setInTransVoiceScene", "newVoiceFileName", "", "getNewVoiceFileName", "()Ljava/lang/String;", "setNewVoiceFileName", "(Ljava/lang/String;)V", "voiceFileName", "getVoiceFileName", "setVoiceFileName", "isNewTransVoiceScene", "fileName", "isTransVoiceScene", "plugin-audiologic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean bzC(String paramString)
    {
      AppMethodBeat.i(148678);
      if ((a.jhj()) && (s.p(a.jhi(), paramString)))
      {
        AppMethodBeat.o(148678);
        return true;
      }
      AppMethodBeat.o(148678);
      return false;
    }
    
    public static void bzD(String paramString)
    {
      AppMethodBeat.i(185491);
      s.u(paramString, "<set-?>");
      a.bzB(paramString);
      AppMethodBeat.o(185491);
    }
    
    public static boolean bzE(String paramString)
    {
      AppMethodBeat.i(185492);
      if ((a.jhl()) && (s.p(a.jhk(), paramString)))
      {
        AppMethodBeat.o(185492);
        return true;
      }
      AppMethodBeat.o(185492);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cj.a
 * JD-Core Version:    0.7.0.1
 */