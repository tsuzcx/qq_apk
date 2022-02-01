package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public class EmojiUpdateReceiver
  extends BroadcastReceiver
{
  public static String ACTION = "com.tencent.mm.Emoji_Update";
  public static String gsc = "type";
  public static String gsd = "update_all_custom_emoji";
  public static String gse = "update_download_custom_emoji";
  public static String gsf = "update_store_emoji";
  public static String gsg = "update_group_info";
  public static String gsh = "update_capture_emoji";
  public static String gsi = "update_emoji_download";
  public static String gsj = "update_sticker_download";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(104486);
    String str = paramIntent.getAction();
    if (ACTION.equals(str))
    {
      paramContext = paramIntent.getStringExtra(gsc);
      ae.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", new Object[] { str, paramContext });
      if (gsd.equals(paramContext))
      {
        i.aeX().dl(false);
        a.IvT.l(new qp());
        AppMethodBeat.o(104486);
        return;
      }
      if (gse.equals(paramContext))
      {
        i.aeX().dm(false);
        a.IvT.l(new qp());
        AppMethodBeat.o(104486);
        return;
      }
      if (gsf.equals(paramContext))
      {
        i.aeX().gmq = true;
        a.IvT.l(new qp());
        AppMethodBeat.o(104486);
        return;
      }
      if (gsg.equals(paramContext))
      {
        i.aeX().dn(false);
        a.IvT.l(new qp());
        AppMethodBeat.o(104486);
        return;
      }
      if (gsh.equals(paramContext))
      {
        i.aeX().jdMethod_do(false);
        a.IvT.l(new qp());
        AppMethodBeat.o(104486);
        return;
      }
      boolean bool;
      if (gsi.equals(paramContext))
      {
        str = paramIntent.getStringExtra("md5");
        bool = paramIntent.getBooleanExtra("result", false);
        ae.i("MicroMsg.EmojiUpdateReceiver", "onReceive: %s, %s, %s", new Object[] { paramContext, str, Boolean.valueOf(bool) });
        paramContext = com.tencent.mm.emoji.loader.e.gkR;
        com.tencent.mm.emoji.loader.e.s(str, bool);
        AppMethodBeat.o(104486);
        return;
      }
      if (gsj.equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("task_key");
        bool = paramIntent.getBooleanExtra("result", false);
        ae.i("MicroMsg.EmojiUpdateReceiver", "sticker download %s, %s", new Object[] { paramContext, Boolean.valueOf(bool) });
        paramIntent = com.tencent.mm.sticker.loader.e.IGU;
        com.tencent.mm.sticker.loader.e.cM(paramContext, bool);
      }
    }
    AppMethodBeat.o(104486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */