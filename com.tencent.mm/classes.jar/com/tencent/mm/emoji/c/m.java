package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeyCustomSync", "KeyCustomSyncIndex", "KeyDesignerSyncTime", "KeyGameToCustom", "KeySuggestDelay", "KeySync", "KeyWordListUpdateTime", "TAG", "checkSize", "", "getCustomSyncCount", "", "getDesignerSyncTime", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getSuggestDelay", "getWordListUpdateTime", "init", "isCaptureFull", "", "isCustomFull", "isGameToCustom", "setCustomSyncCount", "index", "setDesignerSyncTime", "time", "setGameToCustom", "set", "setSuggestDelay", "setWordListUpdateTime", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  private static final String TAG;
  public static final m mhY;
  private static final String mhZ;
  
  static
  {
    AppMethodBeat.i(105518);
    mhY = new m();
    TAG = "MicroMsg.EmojiStorageState";
    mhZ = "emoji_stg";
    AppMethodBeat.o(105518);
  }
  
  public static boolean aUK()
  {
    AppMethodBeat.i(105513);
    boolean bool = getKV().getBoolean("capture_full", false);
    AppMethodBeat.o(105513);
    return bool;
  }
  
  public static int aUL()
  {
    AppMethodBeat.i(242634);
    int i = getKV().getInt("word_list_update_time", 0);
    AppMethodBeat.o(242634);
    return i;
  }
  
  public static void aUM()
  {
    boolean bool2 = true;
    AppMethodBeat.i(105516);
    Object localObject1 = l.aUF().aUG();
    s.s(localObject1, "customList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label102:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (!d.A((EmojiInfo)localObject3)) {}
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
    if (i >= o.aUQ())
    {
      bool1 = true;
      getKV().putInt("normal_custom_size", i);
      getKV().putBoolean("custom_full", bool1);
      j = l.aUF().fe(false).size();
      if (j < o.aUR()) {
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
  
  public static void fj(boolean paramBoolean)
  {
    AppMethodBeat.i(242638);
    getKV().putBoolean("game_to_custom", paramBoolean);
    AppMethodBeat.o(242638);
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(105512);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(mhZ);
    s.s(localMultiProcessMMKV, "getMMKV(KVName)");
    AppMethodBeat.o(105512);
    return localMultiProcessMMKV;
  }
  
  public static void init()
  {
    AppMethodBeat.i(242628);
    aUM();
    AppMethodBeat.o(242628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.m
 * JD-Core Version:    0.7.0.1
 */