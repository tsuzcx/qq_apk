package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;

public final class b
{
  public static void Dw(int paramInt)
  {
    AppMethodBeat.i(122030);
    if (!TextUtils.isEmpty("page_hell_seq_mmkv_key")) {
      ay.aRW("_hellhound_mmkv").putInt("page_hell_seq_mmkv_key", paramInt);
    }
    AppMethodBeat.o(122030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.b
 * JD-Core Version:    0.7.0.1
 */