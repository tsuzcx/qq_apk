package com.tencent.mm.plugin.emojicapture.model.a;

import a.l;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerResListener;", "", "()V", "RES_TYPE", "", "TAG", "", "fileUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "getFileUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "broadcastResult", "", "subType", "result", "", "checkResUpdate", "version", "compareWithLocal", "destroy", "init", "plugin-emojicapture_release"})
public final class g
{
  public static final String TAG = "MicroMsg.EmojiStickerResListener";
  private static final c<bg> lug;
  public static final g luh;
  
  static
  {
    AppMethodBeat.i(2656);
    luh = new g();
    TAG = "MicroMsg.EmojiStickerResListener";
    lug = (c)new g.a();
    AppMethodBeat.o(2656);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(2654);
    lug.dead();
    AppMethodBeat.o(2654);
  }
  
  public static void init()
  {
    AppMethodBeat.i(2653);
    lug.alive();
    AppMethodBeat.o(2653);
  }
  
  public static void uK(int paramInt)
  {
    AppMethodBeat.i(2655);
    ab.i(TAG, "broadcastResult: " + paramInt + ", true");
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.Emoji_Capture_Res");
    localIntent.putExtra("res_sub_type", paramInt);
    localIntent.putExtra("res_result", true);
    ah.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(2655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.g
 * JD-Core Version:    0.7.0.1
 */