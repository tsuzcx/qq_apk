package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.d;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.sdk.platformtools.ab;

public class EmojiUpdateReceiver
  extends BroadcastReceiver
{
  public static String ACTION = "com.tencent.mm.Emoji_Update";
  public static String exU = "type";
  public static String exV = "update_all_custom_emoji";
  public static String exW = "update_download_custom_emoji";
  public static String exX = "update_store_emoji";
  public static String exY = "update_group_info";
  public static String exZ = "update_capture_emoji";
  public static String eya = "update_emoji_download";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(62269);
    String str = paramIntent.getAction();
    if (ACTION.equals(str))
    {
      paramContext = paramIntent.getStringExtra(exU);
      ab.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", new Object[] { str, paramContext });
      if (exV.equals(paramContext))
      {
        d.Oz().cj(false);
        AppMethodBeat.o(62269);
        return;
      }
      if (exW.equals(paramContext))
      {
        d.Oz().ck(false);
        AppMethodBeat.o(62269);
        return;
      }
      if (exX.equals(paramContext))
      {
        d.Oz().ewt = true;
        AppMethodBeat.o(62269);
        return;
      }
      if (exY.equals(paramContext))
      {
        d.Oz().cl(false);
        AppMethodBeat.o(62269);
        return;
      }
      if (exZ.equals(paramContext))
      {
        d.Oz().cm(false);
        AppMethodBeat.o(62269);
        return;
      }
      if (eya.equals(paramContext))
      {
        str = paramIntent.getStringExtra("md5");
        boolean bool = paramIntent.getBooleanExtra("result", false);
        ab.i("MicroMsg.EmojiUpdateReceiver", "onReceive: %s, %s, %s", new Object[] { paramContext, str, Boolean.valueOf(bool) });
        paramContext = a.evk;
        a.r(str, bool);
      }
    }
    AppMethodBeat.o(62269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */