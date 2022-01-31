package com.tencent.mm.emoji.a;

import a.f.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeySync", "TAG", "checkSize", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "init", "isCaptureFull", "", "isCustomFull", "setCaptureFull", "full", "setCustomFull", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiStorageState";
  private static final String ewy = "emoji_stg";
  public static final e ewz;
  
  static
  {
    AppMethodBeat.i(63244);
    ewz = new e();
    TAG = "MicroMsg.EmojiStorageState";
    ewy = "emoji_stg";
    AppMethodBeat.o(63244);
  }
  
  public static as OC()
  {
    AppMethodBeat.i(63239);
    as localas = as.apq(ewy);
    j.p(localas, "MultiProcessMMKV.getMMKV(KVName)");
    AppMethodBeat.o(63239);
    return localas;
  }
  
  public static boolean OD()
  {
    AppMethodBeat.i(63240);
    boolean bool = OC().getBoolean("capture_full", false);
    AppMethodBeat.o(63240);
    return bool;
  }
  
  public static void OE()
  {
    AppMethodBeat.i(63243);
    b.a("EmojiStorageState_checkSize", (a)e.a.ewA);
    AppMethodBeat.o(63243);
  }
  
  public static void cn(boolean paramBoolean)
  {
    AppMethodBeat.i(63241);
    OC().putBoolean("custom_full", paramBoolean);
    if ((paramBoolean) && (OC().getInt("normal_custom_size", 0) < h.OK())) {
      ab.w(TAG, "custom state mismatch!");
    }
    AppMethodBeat.o(63241);
  }
  
  public static void co(boolean paramBoolean)
  {
    AppMethodBeat.i(63242);
    OC().putBoolean("capture_full", paramBoolean);
    if ((paramBoolean) && (OC().getInt("capture_custom_size", 0) < h.OL())) {
      ab.w(TAG, "capture state mismatch!");
    }
    AppMethodBeat.o(63242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */