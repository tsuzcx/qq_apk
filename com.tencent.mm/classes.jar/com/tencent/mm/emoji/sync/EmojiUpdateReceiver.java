package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public class EmojiUpdateReceiver
  extends BroadcastReceiver
{
  public static String ACTION = "com.tencent.mm.Emoji_Update";
  public static String fWe = "type";
  public static String fWf = "update_all_custom_emoji";
  public static String fWg = "update_download_custom_emoji";
  public static String fWh = "update_store_emoji";
  public static String fWi = "update_group_info";
  public static String fWj = "update_capture_emoji";
  public static String fWk = "update_emoji_download";
  public static String fWl = "update_sticker_download";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(104486);
    String str = paramIntent.getAction();
    if (ACTION.equals(str))
    {
      paramContext = paramIntent.getStringExtra(fWe);
      ac.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", new Object[] { str, paramContext });
      if (fWf.equals(paramContext))
      {
        i.ach().dj(false);
        a.GpY.l(new qd());
        AppMethodBeat.o(104486);
        return;
      }
      if (fWg.equals(paramContext))
      {
        i.ach().dk(false);
        a.GpY.l(new qd());
        AppMethodBeat.o(104486);
        return;
      }
      if (fWh.equals(paramContext))
      {
        i.ach().fQx = true;
        a.GpY.l(new qd());
        AppMethodBeat.o(104486);
        return;
      }
      if (fWi.equals(paramContext))
      {
        i.ach().dl(false);
        a.GpY.l(new qd());
        AppMethodBeat.o(104486);
        return;
      }
      if (fWj.equals(paramContext))
      {
        i.ach().dm(false);
        a.GpY.l(new qd());
        AppMethodBeat.o(104486);
        return;
      }
      boolean bool;
      if (fWk.equals(paramContext))
      {
        str = paramIntent.getStringExtra("md5");
        bool = paramIntent.getBooleanExtra("result", false);
        ac.i("MicroMsg.EmojiUpdateReceiver", "onReceive: %s, %s, %s", new Object[] { paramContext, str, Boolean.valueOf(bool) });
        paramContext = com.tencent.mm.emoji.loader.e.fOZ;
        com.tencent.mm.emoji.loader.e.s(str, bool);
        AppMethodBeat.o(104486);
        return;
      }
      if (fWl.equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("task_key");
        bool = paramIntent.getBooleanExtra("result", false);
        ac.i("MicroMsg.EmojiUpdateReceiver", "sticker download %s, %s", new Object[] { paramContext, Boolean.valueOf(bool) });
        paramIntent = com.tencent.mm.sticker.loader.e.GAP;
        com.tencent.mm.sticker.loader.e.cD(paramContext, bool);
      }
    }
    AppMethodBeat.o(104486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */