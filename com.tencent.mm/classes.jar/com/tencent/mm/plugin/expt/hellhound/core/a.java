package com.tencent.mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.sdk.platformtools.ac;

@TargetApi(14)
public class a
{
  private static volatile a qiE;
  public c qiF;
  public e qiG;
  
  private a()
  {
    AppMethodBeat.i(121841);
    this.qiG = null;
    if (!ciD())
    {
      AppMethodBeat.o(121841);
      return;
    }
    this.qiF = new com.tencent.mm.plugin.expt.hellhound.core.b.a.b();
    this.qiG = new com.tencent.mm.plugin.expt.hellhound.core.b.b.f();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.ciK();
    d.ciR();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cjd();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
    ac.i("ActivityBundleDao", "habbyge-mali, ActivityBundleDao reset");
    if (b.ciE()) {
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
      ac.printErrStackTrace("PageStateDao", localException, "habbyge-mali, PageStateDao writeBack", new Object[0]);
      AppMethodBeat.o(121841);
    }
  }
  
  public static void a(com.tencent.mm.plugin.expt.hellhound.core.stack.f paramf)
  {
    AppMethodBeat.i(121844);
    d.ciR().qjl.qjm.qjp = paramf;
    AppMethodBeat.o(121844);
  }
  
  public static a ciC()
  {
    AppMethodBeat.i(121840);
    if (qiE == null) {}
    try
    {
      if (qiE == null) {
        qiE = new a();
      }
      a locala = qiE;
      AppMethodBeat.o(121840);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(121840);
    }
  }
  
  public static boolean ciD()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a
 * JD-Core Version:    0.7.0.1
 */