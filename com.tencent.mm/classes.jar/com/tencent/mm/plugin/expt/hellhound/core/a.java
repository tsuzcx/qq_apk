package com.tencent.mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class a
{
  private static volatile a weO;
  public final c weP;
  public final e weQ;
  private WeakReference<Object> weR;
  
  private a()
  {
    AppMethodBeat.i(121841);
    this.weR = null;
    this.weP = new com.tencent.mm.plugin.expt.hellhound.core.b.a.b();
    this.weQ = new g();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.dcx();
    d.dcE();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
    Log.i("HABBYGE-MALI.ActivityBundleDao", "ActivityBundleDao reset");
    if (b.isMMProcess()) {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_ac_ble_mmkv_key", new byte[0]);
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_key_page_se_dao", new byte[0]);
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
    d.dcE().wfw.wfx.wfy = paramf;
    AppMethodBeat.o(121844);
  }
  
  public static a dcp()
  {
    AppMethodBeat.i(121840);
    if (weO == null) {}
    try
    {
      if (weO == null) {
        weO = new a();
      }
      a locala = weO;
      AppMethodBeat.o(121840);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(121840);
    }
  }
  
  public final void dc(Object paramObject)
  {
    AppMethodBeat.i(256938);
    Log.w("HABBYGE-MALI.HellhoundMonitor", "HellhoundMonitor-setPageObj: %s", new Object[] { paramObject.getClass().getSimpleName() });
    this.weR = new WeakReference(paramObject);
    AppMethodBeat.o(256938);
  }
  
  public final Object dco()
  {
    AppMethodBeat.i(256939);
    if (this.weR == null)
    {
      AppMethodBeat.o(256939);
      return null;
    }
    Object localObject = this.weR.get();
    AppMethodBeat.o(256939);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a
 * JD-Core Version:    0.7.0.1
 */