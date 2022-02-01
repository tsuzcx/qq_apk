package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeyCustomSync", "KeyDesignerSyncTime", "KeySuggestDelay", "KeySync", "KeyWordListUpdateTime", "TAG", "checkSize", "", "getDesignerSyncTime", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getSuggestDelay", "getWordListUpdateTime", "init", "isCaptureFull", "", "isCustomFull", "setCaptureFull", "full", "setCustomFull", "setDesignerSyncTime", "time", "setSuggestDelay", "setWordListUpdateTime", "plugin-emojisdk_release"})
public final class j
{
  private static final String TAG = "MicroMsg.EmojiStorageState";
  private static final String gmy = "emoji_stg";
  public static final j gmz;
  
  static
  {
    AppMethodBeat.i(105518);
    gmz = new j();
    TAG = "MicroMsg.EmojiStorageState";
    gmy = "emoji_stg";
    AppMethodBeat.o(105518);
  }
  
  public static boolean afc()
  {
    AppMethodBeat.i(105513);
    boolean bool = getKV().getBoolean("capture_full", false);
    AppMethodBeat.o(105513);
    return bool;
  }
  
  public static int afd()
  {
    AppMethodBeat.i(188557);
    int i = getKV().getInt("word_list_update_time", 0);
    AppMethodBeat.o(188557);
    return i;
  }
  
  public static void afe()
  {
    AppMethodBeat.i(105516);
    c.b("EmojiStorageState_checkSize", (a)a.gmA);
    AppMethodBeat.o(105516);
  }
  
  public static void dp(boolean paramBoolean)
  {
    AppMethodBeat.i(105514);
    getKV().putBoolean("custom_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("normal_custom_size", 0) < m.afk())) {
      ae.w(TAG, "custom state mismatch!");
    }
    AppMethodBeat.o(105514);
  }
  
  public static void dq(boolean paramBoolean)
  {
    AppMethodBeat.i(105515);
    getKV().putBoolean("capture_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("capture_custom_size", 0) < m.afl())) {
      ae.w(TAG, "capture state mismatch!");
    }
    AppMethodBeat.o(105515);
  }
  
  public static ay getKV()
  {
    AppMethodBeat.i(105512);
    ay localay = ay.aRW(gmy);
    p.g(localay, "MultiProcessMMKV.getMMKV(KVName)");
    AppMethodBeat.o(105512);
    return localay;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    public static final a gmA;
    
    static
    {
      AppMethodBeat.i(105509);
      gmA = new a();
      AppMethodBeat.o(105509);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.j
 * JD-Core Version:    0.7.0.1
 */