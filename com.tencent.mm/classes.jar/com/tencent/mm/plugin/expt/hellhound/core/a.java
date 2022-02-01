package com.tencent.mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class a
{
  private static volatile a qQD;
  public final c qQE;
  public final e qQF;
  private WeakReference<Object> qQG;
  
  private a()
  {
    AppMethodBeat.i(121841);
    this.qQG = null;
    this.qQE = new com.tencent.mm.plugin.expt.hellhound.core.b.a.b();
    this.qQF = new g();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.cnK();
    d.cnR();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
    ad.i("HABBYGE-MALI.ActivityBundleDao", "ActivityBundleDao reset");
    if (b.cnC()) {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_ac_ble_mmkv_key", new byte[0]);
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_page_se_dao", new byte[0]);
      AppMethodBeat.o(121841);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.PageStateDao", localException, "PageStateDao writeBack", new Object[0]);
      AppMethodBeat.o(121841);
    }
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(121844);
    d.cnR().qRl.qRm.qRp = paramf;
    AppMethodBeat.o(121844);
  }
  
  public static a cnB()
  {
    AppMethodBeat.i(121840);
    if (qQD == null) {}
    try
    {
      if (qQD == null) {
        qQD = new a();
      }
      a locala = qQD;
      AppMethodBeat.o(121840);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(121840);
    }
  }
  
  public final void cX(Object paramObject)
  {
    AppMethodBeat.i(210311);
    ad.w("HABBYGE-MALI.HellhoundMonitor", "HellhoundMonitor-setPageObj: %s", new Object[] { paramObject.getClass().getSimpleName() });
    this.qQG = new WeakReference(paramObject);
    AppMethodBeat.o(210311);
  }
  
  public final Object cnA()
  {
    AppMethodBeat.i(210312);
    if (this.qQG == null)
    {
      AppMethodBeat.o(210312);
      return null;
    }
    Object localObject = this.qQG.get();
    AppMethodBeat.o(210312);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a
 * JD-Core Version:    0.7.0.1
 */