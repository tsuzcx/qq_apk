package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ty;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiUpdateReceiver
  extends BroadcastReceiver
{
  public static String KEY_TYPE = "type";
  public static String mnL = "com.tencent.mm.Emoji_Update";
  public static String mnM = "update_all_custom_emoji";
  public static String mnN = "update_download_custom_emoji";
  public static String mnO = "update_store_emoji";
  public static String mnP = "update_group_info";
  public static String mnQ = "update_capture_emoji";
  public static String mnR = "TYPE_UPDATE_EMOJI_SYNC";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(104486);
    paramContext = paramIntent.getAction();
    if (mnL.equals(paramContext))
    {
      String str = paramIntent.getStringExtra(KEY_TYPE);
      Log.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", new Object[] { paramContext, str });
      if (mnM.equals(str))
      {
        l.aUF().ff(false);
        new ty().publish();
        AppMethodBeat.o(104486);
        return;
      }
      if (mnN.equals(str))
      {
        l.aUF().fg(false);
        new ty().publish();
        AppMethodBeat.o(104486);
        return;
      }
      if (mnO.equals(str))
      {
        l.aUF().mhO = true;
        new ty().publish();
        AppMethodBeat.o(104486);
        return;
      }
      if (mnP.equals(str))
      {
        l.aUF().fh(false);
        new ty().publish();
        AppMethodBeat.o(104486);
        return;
      }
      if (mnQ.equals(str))
      {
        l.aUF().fi(false);
        new ty().publish();
        AppMethodBeat.o(104486);
        return;
      }
      if (mnR.equals(str))
      {
        paramIntent = (EmojiSyncLoaderIPC.EmojiSyncData)paramIntent.getParcelableExtra("data");
        paramContext = g.mmX;
        if (paramIntent != null)
        {
          if (paramIntent.mjd == 1)
          {
            paramContext = g.b.aWo();
            if ((paramContext instanceof EmojiSyncLoaderIPC)) {}
            for (paramContext = (EmojiSyncLoaderIPC)paramContext; paramContext != null; paramContext = null)
            {
              paramContext.a(paramIntent);
              AppMethodBeat.o(104486);
              return;
            }
          }
          paramContext = g.b.aWn();
          if (!(paramContext instanceof EmojiSyncLoaderIPC)) {
            break label320;
          }
        }
      }
    }
    label320:
    for (paramContext = (EmojiSyncLoaderIPC)paramContext;; paramContext = null)
    {
      if (paramContext != null) {
        paramContext.a(paramIntent);
      }
      AppMethodBeat.o(104486);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */