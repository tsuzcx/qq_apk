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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class y
{
  public static final com.tencent.mm.splash.d cJA;
  private static final HashSet cJB;
  
  static
  {
    AppMethodBeat.i(160106);
    cJA = new com.tencent.mm.splash.d()
    {
      public final boolean et(String paramAnonymousString)
      {
        AppMethodBeat.i(160130);
        boolean bool = y.eu(paramAnonymousString);
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
    cJB = new HashSet();
    cJB.addAll(Arrays.asList(new String[] { "com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.card.ui.CardHomePageNewUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI" }));
    AppMethodBeat.o(160106);
  }
  
  public static void KS()
  {
    AppMethodBeat.i(160103);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = com.tencent.mm.splash.h.GyE.iterator();
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
              ac.i("MicroMsg.PreventAccountNotReady", "replay message for %s", new Object[] { str });
            }
          }
        }
        catch (Throwable localThrowable)
        {
          ac.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
          localArrayList.add(localMessage);
        }
        break;
        label119:
        int i = 0;
      }
    }
    com.tencent.mm.splash.h.GyE.clear();
    com.tencent.mm.splash.h.GyE.addAll(localArrayList);
    AppMethodBeat.o(160103);
  }
  
  private static boolean cd(boolean paramBoolean)
  {
    AppMethodBeat.i(160101);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL())
    {
      if (paramBoolean) {
        ac.i("MicroMsg.PreventAccountNotReady", "not main process");
      }
      AppMethodBeat.o(160101);
      return true;
    }
    if ((com.tencent.mm.kernel.g.agS().gim) && (com.tencent.mm.kernel.g.agP().afY()))
    {
      if (paramBoolean) {
        ac.i("MicroMsg.PreventAccountNotReady", "account hasInitialized");
      }
      AppMethodBeat.o(160101);
      return true;
    }
    AppMethodBeat.o(160101);
    return false;
  }
  
  private static boolean et(String paramString)
  {
    AppMethodBeat.i(160102);
    ac.i("MicroMsg.PreventAccountNotReady", "eatActivity %s", new Object[] { paramString });
    if (cd(true))
    {
      AppMethodBeat.o(160102);
      return false;
    }
    if (paramString != null)
    {
      if (cJB.contains(paramString))
      {
        ac.w("MicroMsg.PreventAccountNotReady", "protect this activity %s", new Object[] { paramString });
        AppMethodBeat.o(160102);
        return true;
      }
      try
      {
        com.tencent.mm.kernel.g.agO();
        Object localObject = new ComponentName(ai.getPackageName(), paramString);
        localObject = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ca.getPackageManager().getActivityInfo((ComponentName)localObject, 128);
        if (localObject != null)
        {
          ac.i("MicroMsg.PreventAccountNotReady", "%s info.exported = %s", new Object[] { paramString, Boolean.valueOf(((ActivityInfo)localObject).exported) });
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
        ac.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramString, "", new Object[0]);
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