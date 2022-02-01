package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeyCustomSync", "KeyDesignerSyncTime", "KeySuggestDelay", "KeySync", "KeyWordListUpdateTime", "TAG", "checkSize", "", "getDesignerSyncTime", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getSuggestDelay", "getWordListUpdateTime", "init", "isCaptureFull", "", "isCustomFull", "setCaptureFull", "full", "setCustomFull", "setDesignerSyncTime", "time", "setSuggestDelay", "setWordListUpdateTime", "plugin-emojisdk_release"})
public final class j
{
  private static final String TAG = "MicroMsg.EmojiStorageState";
  private static final String gke = "emoji_stg";
  public static final j gkf;
  
  static
  {
    AppMethodBeat.i(105518);
    gkf = new j();
    TAG = "MicroMsg.EmojiStorageState";
    gke = "emoji_stg";
    AppMethodBeat.o(105518);
  }
  
  public static boolean aeO()
  {
    AppMethodBeat.i(105513);
    boolean bool = getKV().getBoolean("capture_full", false);
    AppMethodBeat.o(105513);
    return bool;
  }
  
  public static int aeP()
  {
    AppMethodBeat.i(218946);
    int i = getKV().getInt("word_list_update_time", 0);
    AppMethodBeat.o(218946);
    return i;
  }
  
  public static void aeQ()
  {
    AppMethodBeat.i(105516);
    c.b("EmojiStorageState_checkSize", (a)a.gkg);
    AppMethodBeat.o(105516);
  }
  
  public static void dp(boolean paramBoolean)
  {
    AppMethodBeat.i(105514);
    getKV().putBoolean("custom_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("normal_custom_size", 0) < m.aeW())) {
      ad.w(TAG, "custom state mismatch!");
    }
    AppMethodBeat.o(105514);
  }
  
  public static void dq(boolean paramBoolean)
  {
    AppMethodBeat.i(105515);
    getKV().putBoolean("capture_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("capture_custom_size", 0) < m.aeX())) {
      ad.w(TAG, "capture state mismatch!");
    }
    AppMethodBeat.o(105515);
  }
  
  public static ax getKV()
  {
    AppMethodBeat.i(105512);
    ax localax = ax.aQz(gke);
    p.g(localax, "MultiProcessMMKV.getMMKV(KVName)");
    AppMethodBeat.o(105512);
    return localax;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    public static final a gkg;
    
    static
    {
      AppMethodBeat.i(105509);
      gkg = new a();
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