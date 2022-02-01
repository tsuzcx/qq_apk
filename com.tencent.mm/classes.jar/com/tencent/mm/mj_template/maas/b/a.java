package com.tencent.mm.mj_template.maas.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/report/MaasCommonReport;", "", "()V", "value", "", "REPORT_SCENE", "getREPORT_SCENE", "()I", "setREPORT_SCENE", "(I)V", "", "REPORT_SESSION_KEY", "getREPORT_SESSION_KEY", "()Ljava/lang/String;", "setREPORT_SESSION_KEY", "(Ljava/lang/String;)V", "TAG", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final int Ue;
  public static final a obp;
  private static String obq;
  private static int obr;
  
  static
  {
    AppMethodBeat.i(239981);
    obp = new a();
    obq = "";
    Ue = 8;
    AppMethodBeat.o(239981);
  }
  
  public static void HH(String paramString)
  {
    AppMethodBeat.i(239962);
    s.u(paramString, "value");
    Log.i("MicroMsg.MaasMovieSessionManager", "setSessionKey " + paramString + ", field: " + obq);
    obq = paramString;
    AppMethodBeat.o(239962);
  }
  
  public static String bxG()
  {
    return obq;
  }
  
  public static int bxH()
  {
    return obr;
  }
  
  public static void uK(int paramInt)
  {
    AppMethodBeat.i(239976);
    Log.i("MicroMsg.MaasMovieSessionManager", "setReportScene: " + paramInt + ", field: " + obr);
    obr = paramInt;
    AppMethodBeat.o(239976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.b.a
 * JD-Core Version:    0.7.0.1
 */