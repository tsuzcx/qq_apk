package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class y
{
  public static final com.tencent.mm.splash.d cUN;
  private static final HashSet cUO;
  
  static
  {
    AppMethodBeat.i(160106);
    cUN = new com.tencent.mm.splash.d()
    {
      public final boolean fo(String paramAnonymousString)
      {
        AppMethodBeat.i(160130);
        boolean bool = y.fp(paramAnonymousString);
        AppMethodBeat.o(160130);
        return bool;
      }
      
      public final Activity q(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(160131);
        paramAnonymousActivity = y.p(paramAnonymousActivity);
        AppMethodBeat.o(160131);
        return paramAnonymousActivity;
      }
    };
    cUO = new HashSet();
    cUO.addAll(Arrays.asList(new String[] { "com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.card.ui.CardHomePageNewUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI" }));
    AppMethodBeat.o(160106);
  }
  
  public static void Mz()
  {
    AppMethodBeat.i(160103);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = com.tencent.mm.splash.h.Iky.iterator();
    if (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      for (;;)
      {
        try
        {
          String str = y.a.h(localMessage);
          if (str != null)
          {
            if ((k)Class.forName(str).getAnnotation(k.class) == null) {
              break label119;
            }
            i = 1;
            if (i != 0)
            {
              com.tencent.mm.splash.h.t(localMessage);
              ad.i("MicroMsg.PreventAccountNotReady", "replay message for %s", new Object[] { str });
            }
          }
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
          localArrayList.add(localMessage);
        }
        break;
        label119:
        int i = 0;
      }
    }
    com.tencent.mm.splash.h.Iky.clear();
    com.tencent.mm.splash.h.Iky.addAll(localArrayList);
    AppMethodBeat.o(160103);
  }
  
  private static boolean ce(boolean paramBoolean)
  {
    AppMethodBeat.i(160101);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
    {
      if (paramBoolean) {
        ad.i("MicroMsg.PreventAccountNotReady", "not main process");
      }
      AppMethodBeat.o(160101);
      return true;
    }
    if ((com.tencent.mm.kernel.g.ajD().gBW) && (com.tencent.mm.kernel.g.ajA().aiK()))
    {
      if (paramBoolean) {
        ad.i("MicroMsg.PreventAccountNotReady", "account hasInitialized");
      }
      AppMethodBeat.o(160101);
      return true;
    }
    AppMethodBeat.o(160101);
    return false;
  }
  
  private static boolean fo(String paramString)
  {
    AppMethodBeat.i(160102);
    ad.i("MicroMsg.PreventAccountNotReady", "eatActivity %s", new Object[] { paramString });
    if (ce(true))
    {
      AppMethodBeat.o(160102);
      return false;
    }
    if (paramString != null)
    {
      if (cUO.contains(paramString))
      {
        ad.w("MicroMsg.PreventAccountNotReady", "protect this activity %s", new Object[] { paramString });
        AppMethodBeat.o(160102);
        return true;
      }
      try
      {
        com.tencent.mm.kernel.g.ajz();
        Object localObject = new ComponentName(aj.getPackageName(), paramString);
        localObject = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).ca.getPackageManager().getActivityInfo((ComponentName)localObject, 128);
        if (localObject != null)
        {
          ad.i("MicroMsg.PreventAccountNotReady", "%s info.exported = %s", new Object[] { paramString, Boolean.valueOf(((ActivityInfo)localObject).exported) });
          boolean bool = ((ActivityInfo)localObject).exported;
          if (!bool)
          {
            AppMethodBeat.o(160102);
            return true;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        ad.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(160102);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.y
 * JD-Core Version:    0.7.0.1
 */