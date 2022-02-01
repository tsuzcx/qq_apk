package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeyCustomSync", "KeyDesignerSyncTime", "KeySuggestDelay", "KeySync", "KeyWordListUpdateTime", "TAG", "checkSize", "", "getDesignerSyncTime", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getSuggestDelay", "getWordListUpdateTime", "init", "isCaptureFull", "", "isCustomFull", "setCaptureFull", "full", "setCustomFull", "setDesignerSyncTime", "time", "setSuggestDelay", "setWordListUpdateTime", "plugin-emojisdk_release"})
public final class j
{
  private static final String TAG = "MicroMsg.EmojiStorageState";
  private static final String fQE = "emoji_stg";
  public static final j fQF;
  
  static
  {
    AppMethodBeat.i(105518);
    fQF = new j();
    TAG = "MicroMsg.EmojiStorageState";
    fQE = "emoji_stg";
    AppMethodBeat.o(105518);
  }
  
  public static boolean ack()
  {
    AppMethodBeat.i(105513);
    boolean bool = getKV().getBoolean("capture_full", false);
    AppMethodBeat.o(105513);
    return bool;
  }
  
  public static int acl()
  {
    AppMethodBeat.i(209826);
    int i = getKV().getInt("word_list_update_time", 0);
    AppMethodBeat.o(209826);
    return i;
  }
  
  public static void acm()
  {
    AppMethodBeat.i(105516);
    c.b("EmojiStorageState_checkSize", (a)a.fQG);
    AppMethodBeat.o(105516);
  }
  
  public static void dn(boolean paramBoolean)
  {
    AppMethodBeat.i(105514);
    getKV().putBoolean("custom_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("normal_custom_size", 0) < m.acs())) {
      ac.w(TAG, "custom state mismatch!");
    }
    AppMethodBeat.o(105514);
  }
  
  public static void jdMethod_do(boolean paramBoolean)
  {
    AppMethodBeat.i(105515);
    getKV().putBoolean("capture_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("capture_custom_size", 0) < m.act())) {
      ac.w(TAG, "capture state mismatch!");
    }
    AppMethodBeat.o(105515);
  }
  
  public static aw getKV()
  {
    AppMethodBeat.i(105512);
    aw localaw = aw.aKT(fQE);
    k.g(localaw, "MultiProcessMMKV.getMMKV(KVName)");
    AppMethodBeat.o(105512);
    return localaw;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    public static final a fQG;
    
    static
    {
      AppMethodBeat.i(105509);
      fQG = new a();
      AppMethodBeat.o(105509);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.j
 * JD-Core Version:    0.7.0.1
 */