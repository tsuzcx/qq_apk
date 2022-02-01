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
  private static volatile a syS;
  public final c syT;
  public final e syU;
  private WeakReference<Object> syV;
  
  private a()
  {
    AppMethodBeat.i(121841);
    this.syV = null;
    this.syT = new com.tencent.mm.plugin.expt.hellhound.core.b.a.b();
    this.syU = new g();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.cNF();
    d.cNM();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
    Log.i("HABBYGE-MALI.ActivityBundleDao", "ActivityBundleDao reset");
    if (b.isMMProcess()) {
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
      Log.printErrStackTrace("HABBYGE-MALI.PageStateDao", localException, "PageStateDao writeBack", new Object[0]);
      AppMethodBeat.o(121841);
    }
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(121844);
    d.cNM().szA.szB.szE = paramf;
    AppMethodBeat.o(121844);
  }
  
  public static a cNx()
  {
    AppMethodBeat.i(121840);
    if (syS == null) {}
    try
    {
      if (syS == null) {
        syS = new a();
      }
      a locala = syS;
      AppMethodBeat.o(121840);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(121840);
    }
  }
  
  public final Object cNw()
  {
    AppMethodBeat.i(220399);
    if (this.syV == null)
    {
      AppMethodBeat.o(220399);
      return null;
    }
    Object localObject = this.syV.get();
    AppMethodBeat.o(220399);
    return localObject;
  }
  
  public final void df(Object paramObject)
  {
    AppMethodBeat.i(220398);
    Log.w("HABBYGE-MALI.HellhoundMonitor", "HellhoundMonitor-setPageObj: %s", new Object[] { paramObject.getClass().getSimpleName() });
    this.syV = new WeakReference(paramObject);
    AppMethodBeat.o(220398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a
 * JD-Core Version:    0.7.0.1
 */