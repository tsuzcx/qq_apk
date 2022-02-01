package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.f.a.si;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiUpdateReceiver
  extends BroadcastReceiver
{
  public static String ACTION = "com.tencent.mm.Emoji_Update";
  public static String KEY_TYPE = "type";
  public static String jOT = "update_all_custom_emoji";
  public static String jOU = "update_download_custom_emoji";
  public static String jOV = "update_store_emoji";
  public static String jOW = "update_group_info";
  public static String jOX = "update_capture_emoji";
  public static String jOY = "update_emoji_download";
  public static String jOZ = "update_sticker_download";
  public static String jPa = "TYPE_UPDATE_EMOJI_SYNC";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = null;
    paramContext = null;
    AppMethodBeat.i(104486);
    String str = paramIntent.getAction();
    Object localObject2;
    if (ACTION.equals(str))
    {
      localObject2 = paramIntent.getStringExtra(KEY_TYPE);
      Log.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", new Object[] { str, localObject2 });
      if (jOT.equals(localObject2))
      {
        k.aBH().et(false);
        EventCenter.instance.publish(new si());
        AppMethodBeat.o(104486);
        return;
      }
      if (jOU.equals(localObject2))
      {
        k.aBH().eu(false);
        EventCenter.instance.publish(new si());
        AppMethodBeat.o(104486);
        return;
      }
      if (jOV.equals(localObject2))
      {
        k.aBH().jIg = true;
        EventCenter.instance.publish(new si());
        AppMethodBeat.o(104486);
        return;
      }
      if (jOW.equals(localObject2))
      {
        k.aBH().ev(false);
        EventCenter.instance.publish(new si());
        AppMethodBeat.o(104486);
        return;
      }
      if (jOX.equals(localObject2))
      {
        k.aBH().ew(false);
        EventCenter.instance.publish(new si());
        AppMethodBeat.o(104486);
        return;
      }
      boolean bool;
      if (jOY.equals(localObject2))
      {
        paramContext = paramIntent.getStringExtra("md5");
        bool = paramIntent.getBooleanExtra("result", false);
        Log.i("MicroMsg.EmojiUpdateReceiver", "onReceive: %s, %s, %s", new Object[] { localObject2, paramContext, Boolean.valueOf(bool) });
        paramIntent = com.tencent.mm.emoji.loader.e.jGI;
        com.tencent.mm.emoji.loader.e.v(paramContext, bool);
        AppMethodBeat.o(104486);
        return;
      }
      if (jOZ.equals(localObject2))
      {
        paramContext = paramIntent.getStringExtra("task_key");
        bool = paramIntent.getBooleanExtra("result", false);
        Log.i("MicroMsg.EmojiUpdateReceiver", "sticker download %s, %s", new Object[] { paramContext, Boolean.valueOf(bool) });
        paramIntent = com.tencent.mm.sticker.loader.e.Vbx;
        com.tencent.mm.sticker.loader.e.ds(paramContext, bool);
        AppMethodBeat.o(104486);
        return;
      }
      if (jPa.equals(localObject2))
      {
        localObject2 = (EmojiSyncLoaderIPC.EmojiSyncData)paramIntent.getParcelableExtra("data");
        paramIntent = g.jOs;
        if (localObject2 != null) {
          if (((EmojiSyncLoaderIPC.EmojiSyncData)localObject2).jJL == 1)
          {
            paramIntent = g.b.aDs();
            if ((paramIntent instanceof EmojiSyncLoaderIPC)) {
              break label500;
            }
          }
        }
      }
    }
    for (;;)
    {
      paramContext = (EmojiSyncLoaderIPC)paramContext;
      if (paramContext != null)
      {
        paramContext.a((EmojiSyncLoaderIPC.EmojiSyncData)localObject2);
        AppMethodBeat.o(104486);
        return;
      }
      AppMethodBeat.o(104486);
      return;
      paramContext = g.b.aDr();
      if (!(paramContext instanceof EmojiSyncLoaderIPC)) {
        paramContext = localObject1;
      }
      for (;;)
      {
        paramContext = (EmojiSyncLoaderIPC)paramContext;
        if (paramContext != null)
        {
          paramContext.a((EmojiSyncLoaderIPC.EmojiSyncData)localObject2);
          AppMethodBeat.o(104486);
          return;
        }
        AppMethodBeat.o(104486);
        return;
      }
      label500:
      paramContext = paramIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */