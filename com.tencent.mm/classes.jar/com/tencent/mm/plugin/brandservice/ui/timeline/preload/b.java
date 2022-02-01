package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webcanvas.c.a;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AppMsgContextEx;", "", "()V", "testClear", "", "plugin-brandservice_release"})
public final class b
{
  public static final b pAm;
  
  static
  {
    AppMethodBeat.i(6548);
    pAm = new b();
    AppMethodBeat.o(6548);
  }
  
  public static final void cnv()
  {
    AppMethodBeat.i(6547);
    Object localObject = m.pCU;
    m.cod().clearAll();
    localObject = m.pCU;
    m.coe().clearAll();
    localObject = v.pDG;
    v.cop().clearAll();
    localObject = v.pDG;
    v.coq().clearAll();
    localObject = com.tencent.mm.plugin.ad.c.ICA;
    com.tencent.mm.plugin.ad.c.fXj().clearAll();
    localObject = v.pDG;
    v.cor().clearAll();
    localObject = com.tencent.mm.plugin.ad.c.ICA;
    com.tencent.mm.plugin.ad.c.fXk().clearAll();
    localObject = v.pDG;
    v.cos().clearAll();
    localObject = com.tencent.mm.plugin.ad.c.ICA;
    com.tencent.mm.plugin.ad.c.fXl().clearAll();
    localObject = y.pFf;
    y.clearAll();
    localObject = com.tencent.mm.plugin.brandservice.c.pmm;
    com.tencent.mm.plugin.brandservice.c.cll().clearAll();
    localObject = com.tencent.mm.plugin.brandservice.c.pmm;
    com.tencent.mm.plugin.brandservice.c.clm().clearAll();
    localObject = com.tencent.mm.plugin.brandservice.c.pmm;
    com.tencent.mm.plugin.brandservice.c.cln().clearAll();
    localObject = v.pDG;
    v.cot().clearAll();
    u.coo().clearAll();
    localObject = com.tencent.mm.plugin.webcanvas.c.IzL;
    localObject = com.tencent.mm.plugin.webcanvas.c.fWq();
    c.a locala = com.tencent.mm.plugin.webcanvas.c.IzL;
    ((MMKVSlotManager)((f)localObject).getValue()).clearAll();
    c.cnx().clear();
    c.cnw().clear();
    AppMethodBeat.o(6547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b
 * JD-Core Version:    0.7.0.1
 */