package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbiz/BizDigestExposeMMkvSlot;", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "()V", "plugin-biz_release"})
public final class c
  extends MMKVSlotManager
{
  public static final c lEh;
  
  static
  {
    AppMethodBeat.i(124704);
    lEh = new c();
    AppMethodBeat.o(124704);
  }
  
  private c()
  {
    super(localMultiProcessMMKV, 432000L);
    AppMethodBeat.i(124703);
    AppMethodBeat.o(124703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ao.c
 * JD-Core Version:    0.7.0.1
 */