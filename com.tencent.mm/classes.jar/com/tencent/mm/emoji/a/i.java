package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeyCustomSync", "KeyDesignerSyncTime", "KeySync", "TAG", "checkSize", "", "getDesignerSyncTime", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "init", "isCaptureFull", "", "isCustomFull", "report", "reportNoThumbFile", "allCount", "thumbCount", "setCaptureFull", "full", "setCustomFull", "setDesignerSyncTime", "time", "plugin-emojisdk_release"})
public final class i
{
  private static final String TAG = "MicroMsg.EmojiStorageState";
  private static final String fMS = "emoji_stg";
  public static final i fMT;
  
  static
  {
    AppMethodBeat.i(105518);
    fMT = new i();
    TAG = "MicroMsg.EmojiStorageState";
    fMS = "emoji_stg";
    AppMethodBeat.o(105518);
  }
  
  public static boolean abm()
  {
    AppMethodBeat.i(105513);
    boolean bool = getKV().getBoolean("capture_full", false);
    AppMethodBeat.o(105513);
    return bool;
  }
  
  public static void abn()
  {
    AppMethodBeat.i(105516);
    c.b("EmojiStorageState_checkSize", (a)a.fMU);
    AppMethodBeat.o(105516);
  }
  
  public static void jdMethod_do(boolean paramBoolean)
  {
    AppMethodBeat.i(105514);
    getKV().putBoolean("custom_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("normal_custom_size", 0) < l.abt())) {
      ad.w(TAG, "custom state mismatch!");
    }
    AppMethodBeat.o(105514);
  }
  
  public static void dp(boolean paramBoolean)
  {
    AppMethodBeat.i(105515);
    getKV().putBoolean("capture_full", paramBoolean);
    if ((paramBoolean) && (getKV().getInt("capture_custom_size", 0) < l.abu())) {
      ad.w(TAG, "capture state mismatch!");
    }
    AppMethodBeat.o(105515);
  }
  
  public static ax getKV()
  {
    AppMethodBeat.i(105512);
    ax localax = ax.aFC(fMS);
    k.g(localax, "MultiProcessMMKV.getMMKV(KVName)");
    AppMethodBeat.o(105512);
    return localax;
  }
  
  public static void report()
  {
    AppMethodBeat.i(105517);
    c.b("EmojiStorageState_report", (a)b.fMV);
    AppMethodBeat.o(105517);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    public static final a fMU;
    
    static
    {
      AppMethodBeat.i(105509);
      fMU = new a();
      AppMethodBeat.o(105509);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    public static final b fMV;
    
    static
    {
      AppMethodBeat.i(105511);
      fMV = new b();
      AppMethodBeat.o(105511);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.i
 * JD-Core Version:    0.7.0.1
 */