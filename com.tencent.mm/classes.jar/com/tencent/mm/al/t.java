package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelbiz/MpDataMMkvSlot;", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "()V", "plugin-biz_release"})
public final class t
  extends MMKVSlotManager
{
  public static final t iOP;
  
  static
  {
    AppMethodBeat.i(124710);
    iOP = new t();
    AppMethodBeat.o(124710);
  }
  
  private t()
  {
    super(localMultiProcessMMKV, 604800L);
    AppMethodBeat.i(124709);
    AppMethodBeat.o(124709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.t
 * JD-Core Version:    0.7.0.1
 */