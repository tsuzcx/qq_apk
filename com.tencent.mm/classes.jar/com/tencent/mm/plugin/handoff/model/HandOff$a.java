package com.tencent.mm.plugin.handoff.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOff$Companion;", "", "()V", "KId", "", "generateKey", "dataType", "", "handOffType", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HandOff$a
{
  public static String generateKey(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121692);
    String str = paramInt1 + '_' + paramInt2 + '_' + System.currentTimeMillis();
    AppMethodBeat.o(121692);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOff.a
 * JD-Core Version:    0.7.0.1
 */