package com.tencent.mm.app;

import android.app.Application;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;
import java.util.HashSet;

public final class n
{
  public static final com.tencent.mm.splash.d bwZ = new n.1();
  private static final HashSet bxa = new HashSet();
  
  static
  {
    bxa.addAll(Arrays.asList(new String[] { "com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI" }));
  }
  
  private static boolean aO(boolean paramBoolean)
  {
    if (!((h)com.tencent.mm.kernel.g.DM().Dr()).Ex())
    {
      if (paramBoolean) {
        y.i("MicroMsg.PreventAccountNotReady", "not main process");
      }
      return true;
    }
    if ((com.tencent.mm.kernel.g.DQ().dKZ) && (com.tencent.mm.kernel.g.DN().Dc()))
    {
      if (paramBoolean) {
        y.i("MicroMsg.PreventAccountNotReady", "account hasInitialized");
      }
      return true;
    }
    return false;
  }
  
  private static boolean cn(String paramString)
  {
    y.i("MicroMsg.PreventAccountNotReady", "eatActivity %s", new Object[] { paramString });
    if (aO(true)) {
      return false;
    }
    if (paramString != null)
    {
      if (bxa.contains(paramString))
      {
        y.w("MicroMsg.PreventAccountNotReady", "protect this activity %s", new Object[] { paramString });
        return true;
      }
      try
      {
        com.tencent.mm.kernel.g.DM().Dr();
        Object localObject = new ComponentName(ae.getPackageName(), paramString);
        localObject = ((h)com.tencent.mm.kernel.g.DM().Dr()).bT.getPackageManager().getActivityInfo((ComponentName)localObject, 128);
        if (localObject != null)
        {
          y.i("MicroMsg.PreventAccountNotReady", "%s info.exported = %s", new Object[] { paramString, Boolean.valueOf(((ActivityInfo)localObject).exported) });
          boolean bool = ((ActivityInfo)localObject).exported;
          if (!bool) {
            return true;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        y.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramString, "", new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.n
 * JD-Core Version:    0.7.0.1
 */