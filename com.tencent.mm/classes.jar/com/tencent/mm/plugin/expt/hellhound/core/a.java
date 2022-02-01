package com.tencent.mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class a
{
  private static volatile a qYB;
  public final c qYC;
  public final e qYD;
  private WeakReference<Object> qYE;
  
  private a()
  {
    AppMethodBeat.i(121841);
    this.qYE = null;
    this.qYC = new com.tencent.mm.plugin.expt.hellhound.core.b.a.b();
    this.qYD = new g();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.cpm();
    d.cpt();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cpF();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
    ae.i("HABBYGE-MALI.ActivityBundleDao", "ActivityBundleDao reset");
    if (b.cpe()) {
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
      ae.printErrStackTrace("HABBYGE-MALI.PageStateDao", localException, "PageStateDao writeBack", new Object[0]);
      AppMethodBeat.o(121841);
    }
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(121844);
    d.cpt().qZj.qZk.qZn = paramf;
    AppMethodBeat.o(121844);
  }
  
  public static a cpd()
  {
    AppMethodBeat.i(121840);
    if (qYB == null) {}
    try
    {
      if (qYB == null) {
        qYB = new a();
      }
      a locala = qYB;
      AppMethodBeat.o(121840);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(121840);
    }
  }
  
  public final void cY(Object paramObject)
  {
    AppMethodBeat.i(195971);
    ae.w("HABBYGE-MALI.HellhoundMonitor", "HellhoundMonitor-setPageObj: %s", new Object[] { paramObject.getClass().getSimpleName() });
    this.qYE = new WeakReference(paramObject);
    AppMethodBeat.o(195971);
  }
  
  public final Object cpc()
  {
    AppMethodBeat.i(195972);
    if (this.qYE == null)
    {
      AppMethodBeat.o(195972);
      return null;
    }
    Object localObject = this.qYE.get();
    AppMethodBeat.o(195972);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a
 * JD-Core Version:    0.7.0.1
 */