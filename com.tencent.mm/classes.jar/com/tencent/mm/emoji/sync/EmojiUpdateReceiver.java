package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiUpdateReceiver
  extends BroadcastReceiver
{
  public static String ACTION = "com.tencent.mm.Emoji_Update";
  public static String KEY_TYPE = "type";
  public static String hdn = "update_all_custom_emoji";
  public static String hdo = "update_download_custom_emoji";
  public static String hdp = "update_store_emoji";
  public static String hdq = "update_group_info";
  public static String hdr = "update_capture_emoji";
  public static String hds = "update_emoji_download";
  public static String hdt = "update_sticker_download";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(104486);
    String str = paramIntent.getAction();
    if (ACTION.equals(str))
    {
      paramContext = paramIntent.getStringExtra(KEY_TYPE);
      Log.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", new Object[] { str, paramContext });
      if (hdn.equals(paramContext))
      {
        j.auL().dV(false);
        EventCenter.instance.publish(new rj());
        AppMethodBeat.o(104486);
        return;
      }
      if (hdo.equals(paramContext))
      {
        j.auL().dW(false);
        EventCenter.instance.publish(new rj());
        AppMethodBeat.o(104486);
        return;
      }
      if (hdp.equals(paramContext))
      {
        j.auL().gXh = true;
        EventCenter.instance.publish(new rj());
        AppMethodBeat.o(104486);
        return;
      }
      if (hdq.equals(paramContext))
      {
        j.auL().dX(false);
        EventCenter.instance.publish(new rj());
        AppMethodBeat.o(104486);
        return;
      }
      if (hdr.equals(paramContext))
      {
        j.auL().dY(false);
        EventCenter.instance.publish(new rj());
        AppMethodBeat.o(104486);
        return;
      }
      boolean bool;
      if (hds.equals(paramContext))
      {
        str = paramIntent.getStringExtra("md5");
        bool = paramIntent.getBooleanExtra("result", false);
        Log.i("MicroMsg.EmojiUpdateReceiver", "onReceive: %s, %s, %s", new Object[] { paramContext, str, Boolean.valueOf(bool) });
        paramContext = com.tencent.mm.emoji.loader.e.gVM;
        com.tencent.mm.emoji.loader.e.s(str, bool);
        AppMethodBeat.o(104486);
        return;
      }
      if (hdt.equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("task_key");
        bool = paramIntent.getBooleanExtra("result", false);
        Log.i("MicroMsg.EmojiUpdateReceiver", "sticker download %s, %s", new Object[] { paramContext, Boolean.valueOf(bool) });
        paramIntent = com.tencent.mm.sticker.loader.e.NNN;
        com.tencent.mm.sticker.loader.e.dh(paramContext, bool);
      }
    }
    AppMethodBeat.o(104486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */