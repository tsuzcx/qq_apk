package com.tencent.mm.plugin.expt.hellhound.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class a
{
  private static volatile a zAM;
  public final c zAN;
  public final e zAO;
  private WeakReference<Object> zAP;
  
  private a()
  {
    AppMethodBeat.i(121841);
    this.zAP = null;
    this.zAN = new com.tencent.mm.plugin.expt.hellhound.core.b.a.b();
    this.zAO = new g();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.dIZ();
    d.dJg();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dJs();
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
    Log.i("HABBYGE-MALI.ActivityBundleDao", "ActivityBundleDao reset");
    if (b.isMMProcess()) {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_ac_ble_mmkv_key", new byte[0]);
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_key_page_se_dao", new byte[0]);
      AppMethodBeat.o(121841);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.PageStateDao", localException, "PageStateDao writeBack", new Object[0]);
      AppMethodBeat.o(121841);
    }
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(121844);
    d.dJg().zBw.zBx.zBy = paramf;
    AppMethodBeat.o(121844);
  }
  
  public static a dIT()
  {
    AppMethodBeat.i(121840);
    if (zAM == null) {}
    try
    {
      if (zAM == null) {
        zAM = new a();
      }
      a locala = zAM;
      AppMethodBeat.o(121840);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(121840);
    }
  }
  
  public final Object dIS()
  {
    AppMethodBeat.i(299938);
    if (this.zAP == null)
    {
      AppMethodBeat.o(299938);
      return null;
    }
    Object localObject = this.zAP.get();
    AppMethodBeat.o(299938);
    return localObject;
  }
  
  public final void fa(Object paramObject)
  {
    AppMethodBeat.i(299935);
    Log.w("HABBYGE-MALI.HellhoundMonitor", "HellhoundMonitor-setPageObj: %s", new Object[] { paramObject.getClass().getSimpleName() });
    this.zAP = new WeakReference(paramObject);
    AppMethodBeat.o(299935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a
 * JD-Core Version:    0.7.0.1
 */