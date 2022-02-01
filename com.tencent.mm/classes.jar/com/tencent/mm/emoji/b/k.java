package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeyCustomSync", "KeyDesignerSyncTime", "KeySuggestDelay", "KeySync", "KeyWordListUpdateTime", "TAG", "checkSize", "", "getDesignerSyncTime", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getSuggestDelay", "getWordListUpdateTime", "init", "isCaptureFull", "", "isCustomFull", "setCaptureFull", "full", "setCustomFull", "setDesignerSyncTime", "time", "setSuggestDelay", "setWordListUpdateTime", "plugin-emojisdk_release"})
public final class k
{
  private static final String TAG = "MicroMsg.EmojiStorageState";
  private static final String gXq = "emoji_stg";
  public static final k gXr;
  
  static
  {
    AppMethodBeat.i(105518);
    gXr = new k();
    TAG = "MicroMsg.EmojiStorageState";
    gXq = "emoji_stg";
    AppMethodBeat.o(105518);
  }
  
  public static boolean auQ()
  {
    AppMethodBeat.i(105513);
    boolean bool = getKV().getBoolean("capture_full", false);
    AppMethodBeat.o(105513);
    return bool;
  }
  
  public static int auR()
  {
    AppMethodBeat.i(199913);
    int i = getKV().getInt("word_list_update_time", 0);
    AppMethodBeat.o(199913);
    return i;
  }
  
  public static void auS()
  {
    AppMethodBeat.i(105516);
    d.b("EmojiStorageState_checkSize", (a)a.gXs);
    AppMethodBeat.o(105516);
  }
  
  public static void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(105514);
    getKV().putBoolean("custom_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("normal_custom_size", 0) < n.auY())) {
      Log.w(TAG, "custom state mismatch!");
    }
    AppMethodBeat.o(105514);
  }
  
  public static void ea(boolean paramBoolean)
  {
    AppMethodBeat.i(105515);
    getKV().putBoolean("capture_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("capture_custom_size", 0) < n.auZ())) {
      Log.w(TAG, "capture state mismatch!");
    }
    AppMethodBeat.o(105515);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(105512);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(gXq);
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(KVName)");
    AppMethodBeat.o(105512);
    return localMultiProcessMMKV;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    public static final a gXs;
    
    static
    {
      AppMethodBeat.i(105509);
      gXs = new a();
      AppMethodBeat.o(105509);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.k
 * JD-Core Version:    0.7.0.1
 */