package com.tencent.mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.sdk.platformtools.ad;

@TargetApi(14)
public class a
{
  private static volatile a pDR;
  public c pDS;
  public e pDT;
  
  private a()
  {
    AppMethodBeat.i(121841);
    this.pDT = null;
    if (!cbu())
    {
      AppMethodBeat.o(121841);
      return;
    }
    this.pDS = new com.tencent.mm.plugin.expt.hellhound.core.b.a.b();
    this.pDT = new com.tencent.mm.plugin.expt.hellhound.core.b.b.f();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.cbz();
    d.cbG();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
    ad.i("ActivityBundleDao", "habbyge-mali, ActivityBundleDao reset");
    if (b.cbv()) {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_ac_ble_mmkv_key", new byte[0]);
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_page_se_dao", new byte[0]);
      AppMethodBeat.o(121841);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("PageStateDao", localException, "habbyge-mali, PageStateDao writeBack", new Object[0]);
      AppMethodBeat.o(121841);
    }
  }
  
  public static void a(com.tencent.mm.plugin.expt.hellhound.core.stack.f paramf)
  {
    AppMethodBeat.i(121844);
    d.cbG().pEy.pEz.pEC = paramf;
    AppMethodBeat.o(121844);
  }
  
  public static a cbt()
  {
    AppMethodBeat.i(121840);
    if (pDR == null) {}
    try
    {
      if (pDR == null) {
        pDR = new a();
      }
      a locala = pDR;
      AppMethodBeat.o(121840);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(121840);
    }
  }
  
  public static boolean cbu()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a
 * JD-Core Version:    0.7.0.1
 */