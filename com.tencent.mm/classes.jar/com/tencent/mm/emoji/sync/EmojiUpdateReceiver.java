package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public class EmojiUpdateReceiver
  extends BroadcastReceiver
{
  public static String ACTION = "com.tencent.mm.Emoji_Update";
  public static String gpH = "type";
  public static String gpI = "update_all_custom_emoji";
  public static String gpJ = "update_download_custom_emoji";
  public static String gpK = "update_store_emoji";
  public static String gpL = "update_group_info";
  public static String gpM = "update_capture_emoji";
  public static String gpN = "update_emoji_download";
  public static String gpO = "update_sticker_download";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(104486);
    String str = paramIntent.getAction();
    if (ACTION.equals(str))
    {
      paramContext = paramIntent.getStringExtra(gpH);
      ad.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", new Object[] { str, paramContext });
      if (gpI.equals(paramContext))
      {
        i.aeL().dl(false);
        a.IbL.l(new qo());
        AppMethodBeat.o(104486);
        return;
      }
      if (gpJ.equals(paramContext))
      {
        i.aeL().dm(false);
        a.IbL.l(new qo());
        AppMethodBeat.o(104486);
        return;
      }
      if (gpK.equals(paramContext))
      {
        i.aeL().gjX = true;
        a.IbL.l(new qo());
        AppMethodBeat.o(104486);
        return;
      }
      if (gpL.equals(paramContext))
      {
        i.aeL().dn(false);
        a.IbL.l(new qo());
        AppMethodBeat.o(104486);
        return;
      }
      if (gpM.equals(paramContext))
      {
        i.aeL().jdMethod_do(false);
        a.IbL.l(new qo());
        AppMethodBeat.o(104486);
        return;
      }
      boolean bool;
      if (gpN.equals(paramContext))
      {
        str = paramIntent.getStringExtra("md5");
        bool = paramIntent.getBooleanExtra("result", false);
        ad.i("MicroMsg.EmojiUpdateReceiver", "onReceive: %s, %s, %s", new Object[] { paramContext, str, Boolean.valueOf(bool) });
        paramContext = com.tencent.mm.emoji.loader.e.giz;
        com.tencent.mm.emoji.loader.e.s(str, bool);
        AppMethodBeat.o(104486);
        return;
      }
      if (gpO.equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("task_key");
        bool = paramIntent.getBooleanExtra("result", false);
        ad.i("MicroMsg.EmojiUpdateReceiver", "sticker download %s, %s", new Object[] { paramContext, Boolean.valueOf(bool) });
        paramIntent = com.tencent.mm.sticker.loader.e.ImJ;
        com.tencent.mm.sticker.loader.e.cI(paramContext, bool);
      }
    }
    AppMethodBeat.o(104486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */