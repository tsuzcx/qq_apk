package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.h;
import com.tencent.mm.sdk.platformtools.ad;

public class EmojiUpdateReceiver
  extends BroadcastReceiver
{
  public static String ACTION = "com.tencent.mm.Emoji_Update";
  public static String fSj = "type";
  public static String fSk = "update_all_custom_emoji";
  public static String fSl = "update_download_custom_emoji";
  public static String fSm = "update_store_emoji";
  public static String fSn = "update_group_info";
  public static String fSo = "update_capture_emoji";
  public static String fSp = "update_emoji_download";
  public static String fSq = "update_sticker_download";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(104486);
    String str = paramIntent.getAction();
    if (ACTION.equals(str))
    {
      paramContext = paramIntent.getStringExtra(fSj);
      ad.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", new Object[] { str, paramContext });
      if (fSk.equals(paramContext))
      {
        h.abj().dk(false);
        AppMethodBeat.o(104486);
        return;
      }
      if (fSl.equals(paramContext))
      {
        h.abj().dl(false);
        AppMethodBeat.o(104486);
        return;
      }
      if (fSm.equals(paramContext))
      {
        h.abj().fML = true;
        AppMethodBeat.o(104486);
        return;
      }
      if (fSn.equals(paramContext))
      {
        h.abj().dm(false);
        AppMethodBeat.o(104486);
        return;
      }
      if (fSo.equals(paramContext))
      {
        h.abj().dn(false);
        AppMethodBeat.o(104486);
        return;
      }
      boolean bool;
      if (fSp.equals(paramContext))
      {
        str = paramIntent.getStringExtra("md5");
        bool = paramIntent.getBooleanExtra("result", false);
        ad.i("MicroMsg.EmojiUpdateReceiver", "onReceive: %s, %s, %s", new Object[] { paramContext, str, Boolean.valueOf(bool) });
        paramContext = com.tencent.mm.emoji.loader.e.fLn;
        com.tencent.mm.emoji.loader.e.s(str, bool);
        AppMethodBeat.o(104486);
        return;
      }
      if (fSq.equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("task_key");
        bool = paramIntent.getBooleanExtra("result", false);
        ad.i("MicroMsg.EmojiUpdateReceiver", "sticker download %s, %s", new Object[] { paramContext, Boolean.valueOf(bool) });
        paramIntent = com.tencent.mm.sticker.loader.e.Fds;
        com.tencent.mm.sticker.loader.e.cx(paramContext, bool);
      }
    }
    AppMethodBeat.o(104486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */