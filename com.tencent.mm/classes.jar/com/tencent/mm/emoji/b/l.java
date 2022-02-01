package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeyCustomSync", "KeyCustomSyncIndex", "KeyDesignerSyncTime", "KeyGameToCustom", "KeySuggestDelay", "KeySync", "KeyWordListUpdateTime", "TAG", "checkSize", "", "getCustomSyncCount", "", "getDesignerSyncTime", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getSuggestDelay", "getWordListUpdateTime", "init", "isCaptureFull", "", "isCustomFull", "isGameToCustom", "setCustomSyncCount", "index", "setDesignerSyncTime", "time", "setGameToCustom", "set", "setSuggestDelay", "setWordListUpdateTime", "plugin-emojisdk_release"})
public final class l
{
  private static final String TAG = "MicroMsg.EmojiStorageState";
  private static final String jIp = "emoji_stg";
  public static final l jIq;
  
  static
  {
    AppMethodBeat.i(105518);
    jIq = new l();
    TAG = "MicroMsg.EmojiStorageState";
    jIp = "emoji_stg";
    AppMethodBeat.o(105518);
  }
  
  public static boolean aBM()
  {
    AppMethodBeat.i(105513);
    boolean bool = getKV().getBoolean("capture_full", false);
    AppMethodBeat.o(105513);
    return bool;
  }
  
  public static int aBN()
  {
    AppMethodBeat.i(226972);
    int i = getKV().getInt("word_list_update_time", 0);
    AppMethodBeat.o(226972);
    return i;
  }
  
  public static void aBO()
  {
    boolean bool2 = true;
    AppMethodBeat.i(105516);
    Object localObject1 = k.aBH().aBK();
    p.j(localObject1, "customList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label102:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (!b.A((EmojiInfo)localObject3)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label102;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    int i = ((List)localObject1).size();
    boolean bool1;
    int j;
    if (i >= o.aBT())
    {
      bool1 = true;
      getKV().putInt("normal_custom_size", i);
      getKV().putBoolean("custom_full", bool1);
      j = k.aBH().es(false).size();
      if (j < o.aBU()) {
        break label242;
      }
    }
    for (;;)
    {
      getKV().putInt("capture_custom_size", j);
      getKV().putBoolean("capture_full", bool2);
      Log.i(TAG, "init: normal size is " + i + ' ' + bool1 + "; capture size is " + j + ' ' + bool2);
      AppMethodBeat.o(105516);
      return;
      bool1 = false;
      break;
      label242:
      bool2 = false;
    }
  }
  
  public static void ex(boolean paramBoolean)
  {
    AppMethodBeat.i(226975);
    getKV().putBoolean("game_to_custom", paramBoolean);
    AppMethodBeat.o(226975);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(105512);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(jIp);
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(KVName)");
    AppMethodBeat.o(105512);
    return localMultiProcessMMKV;
  }
  
  public static void init()
  {
    AppMethodBeat.i(226969);
    aBO();
    AppMethodBeat.o(226969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.l
 * JD-Core Version:    0.7.0.1
 */