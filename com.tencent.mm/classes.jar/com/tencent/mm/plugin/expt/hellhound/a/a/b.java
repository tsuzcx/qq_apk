package com.tencent.mm.plugin.expt.hellhound.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;

public final class b
{
  public static void vr(int paramInt)
  {
    AppMethodBeat.i(152314);
    if (!TextUtils.isEmpty("page_hell_seq_mmkv_key")) {
      as.apq("_hellhound_mmkv").putInt("page_hell_seq_mmkv_key", paramInt);
    }
    AppMethodBeat.o(152314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b
 * JD-Core Version:    0.7.0.1
 */