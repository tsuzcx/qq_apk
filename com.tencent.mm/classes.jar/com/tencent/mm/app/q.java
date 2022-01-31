package com.tencent.mm.app;

import android.app.Application;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class q
{
  public static final com.tencent.mm.splash.d bYM;
  private static final HashSet bYN;
  
  static
  {
    AppMethodBeat.i(137985);
    bYM = new q.1();
    bYN = new HashSet();
    bYN.addAll(Arrays.asList(new String[] { "com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.card.ui.CardHomePageNewUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI" }));
    AppMethodBeat.o(137985);
  }
  
  public static void Bw()
  {
    AppMethodBeat.i(137982);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = com.tencent.mm.splash.h.yvk.iterator();
    if (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      for (;;)
      {
        try
        {
          String str = q.a.h(localMessage);
          if (str != null)
          {
            if ((k)Class.forName(str).getAnnotation(k.class) == null) {
              break label119;
            }
            i = 1;
            if (i != 0)
            {
              com.tencent.mm.splash.h.x(localMessage);
              ab.i("MicroMsg.PreventAccountNotReady", "replay message for %s", new Object[] { str });
            }
          }
        }
        catch (Throwable localThrowable)
        {
          ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
          localArrayList.add(localMessage);
        }
        break;
        label119:
        int i = 0;
      }
    }
    com.tencent.mm.splash.h.yvk.clear();
    com.tencent.mm.splash.h.yvk.addAll(localArrayList);
    AppMethodBeat.o(137982);
  }
  
  private static boolean bp(boolean paramBoolean)
  {
    AppMethodBeat.i(137980);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD())
    {
      if (paramBoolean) {
        ab.i("MicroMsg.PreventAccountNotReady", "not main process");
      }
      AppMethodBeat.o(137980);
      return true;
    }
    if ((com.tencent.mm.kernel.g.RM().eIx) && (com.tencent.mm.kernel.g.RJ().QU()))
    {
      if (paramBoolean) {
        ab.i("MicroMsg.PreventAccountNotReady", "account hasInitialized");
      }
      AppMethodBeat.o(137980);
      return true;
    }
    AppMethodBeat.o(137980);
    return false;
  }
  
  private static boolean dz(String paramString)
  {
    AppMethodBeat.i(137981);
    ab.i("MicroMsg.PreventAccountNotReady", "eatActivity %s", new Object[] { paramString });
    if (bp(true))
    {
      AppMethodBeat.o(137981);
      return false;
    }
    if (paramString != null)
    {
      if (bYN.contains(paramString))
      {
        ab.w("MicroMsg.PreventAccountNotReady", "protect this activity %s", new Object[] { paramString });
        AppMethodBeat.o(137981);
        return true;
      }
      try
      {
        com.tencent.mm.kernel.g.RI();
        Object localObject = new ComponentName(ah.getPackageName(), paramString);
        localObject = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).bX.getPackageManager().getActivityInfo((ComponentName)localObject, 128);
        if (localObject != null)
        {
          ab.i("MicroMsg.PreventAccountNotReady", "%s info.exported = %s", new Object[] { paramString, Boolean.valueOf(((ActivityInfo)localObject).exported) });
          boolean bool = ((ActivityInfo)localObject).exported;
          if (!bool)
          {
            AppMethodBeat.o(137981);
            return true;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        ab.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(137981);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.q
 * JD-Core Version:    0.7.0.1
 */