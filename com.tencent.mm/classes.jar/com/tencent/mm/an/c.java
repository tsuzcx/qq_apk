package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbiz/BizDigestExposeMMkvSlot;", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "()V", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MMKVSlotManager
{
  public static final c ovO;
  
  static
  {
    AppMethodBeat.i(124704);
    ovO = new c();
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
 * Qualified Name:     com.tencent.mm.an.c
 * JD-Core Version:    0.7.0.1
 */