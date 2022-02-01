package com.tencent.mm.mj_template.maas.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/sdk/MaasSdkResFileUtil;", "", "()V", "resListDir", "", "getResListDir", "()Ljava/lang/String;", "resResultDir", "getResResultDir", "setResResultDir", "(Ljava/lang/String;)V", "resRoot", "getResRoot", "resTempDir", "getResTempDir", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final int Ue;
  public static final e obI;
  private static final String obJ;
  private static final String obK;
  private static final String obL;
  private static String obM;
  
  static
  {
    AppMethodBeat.i(240089);
    obI = new e();
    String str = s.X(b.bms(), "maas-sdk");
    obJ = str;
    obK = s.X(str, "/list");
    obL = s.X(obJ, "/temp");
    obM = s.X(obJ, "/result");
    Ue = 8;
    AppMethodBeat.o(240089);
  }
  
  public static String bxN()
  {
    return obK;
  }
  
  public static String bxO()
  {
    return obL;
  }
  
  public static String bxP()
  {
    return obM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.sdk.e
 * JD-Core Version:    0.7.0.1
 */