package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbiz/MpDataMMkvSlot;", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "()V", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends MMKVSlotManager
{
  public static final t owL;
  
  static
  {
    AppMethodBeat.i(124710);
    owL = new t();
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
 * Qualified Name:     com.tencent.mm.an.t
 * JD-Core Version:    0.7.0.1
 */