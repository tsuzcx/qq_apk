package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.splash.d;
import com.tencent.mm.splash.i;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class y
{
  public static final d fdI;
  private static final HashSet fdJ;
  
  static
  {
    AppMethodBeat.i(160106);
    fdI = new d()
    {
      public final boolean gR(String paramAnonymousString)
      {
        AppMethodBeat.i(160130);
        boolean bool = y.gS(paramAnonymousString);
        AppMethodBeat.o(160130);
        return bool;
      }
      
      public final Activity p(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(160131);
        paramAnonymousActivity = y.o(paramAnonymousActivity);
        AppMethodBeat.o(160131);
        return paramAnonymousActivity;
      }
    };
    fdJ = new HashSet();
    fdJ.addAll(Arrays.asList(new String[] { "com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.card.ui.CardHomePageNewUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI" }));
    AppMethodBeat.o(160106);
  }
  
  public static void aba()
  {
    AppMethodBeat.i(160103);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = i.UZm.iterator();
    if (localIterator.hasNext())
    {
      Message localMessage = (Message)localIterator.next();
      for (;;)
      {
        try
        {
          String str = a.h(localMessage);
          if (str != null)
          {
            if ((m)Class.forName(str).getAnnotation(m.class) == null) {
              break label119;
            }
            i = 1;
            if (i != 0)
            {
              i.p(localMessage);
              Log.i("MicroMsg.PreventAccountNotReady", "replay message for %s", new Object[] { str });
            }
          }
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
          localArrayList.add(localMessage);
        }
        break;
        label119:
        int i = 0;
      }
    }
    i.UZm.clear();
    i.UZm.addAll(localArrayList);
    AppMethodBeat.o(160103);
  }
  
  private static boolean dk(boolean paramBoolean)
  {
    AppMethodBeat.i(160101);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      if (paramBoolean) {
        Log.i("MicroMsg.PreventAccountNotReady", "not main process");
      }
      AppMethodBeat.o(160101);
      return true;
    }
    if ((com.tencent.mm.kernel.h.aHH().kdm) && (com.tencent.mm.kernel.h.aHE().aGM()))
    {
      if (paramBoolean) {
        Log.i("MicroMsg.PreventAccountNotReady", "account hasInitialized");
      }
      AppMethodBeat.o(160101);
      return true;
    }
    AppMethodBeat.o(160101);
    return false;
  }
  
  private static boolean gR(String paramString)
  {
    AppMethodBeat.i(160102);
    Log.i("MicroMsg.PreventAccountNotReady", "eatActivity %s", new Object[] { paramString });
    if (dk(true))
    {
      AppMethodBeat.o(160102);
      return false;
    }
    if (paramString != null)
    {
      if (fdJ.contains(paramString))
      {
        Log.w("MicroMsg.PreventAccountNotReady", "protect this activity %s", new Object[] { paramString });
        AppMethodBeat.o(160102);
        return true;
      }
      try
      {
        com.tencent.mm.kernel.h.aHD().aHf();
        Object localObject = new ComponentName(MMApplicationContext.getPackageName(), paramString);
        localObject = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw.getPackageManager().getActivityInfo((ComponentName)localObject, 128);
        if (localObject != null)
        {
          Log.i("MicroMsg.PreventAccountNotReady", "%s info.exported = %s", new Object[] { paramString, Boolean.valueOf(((ActivityInfo)localObject).exported) });
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
        Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(160102);
    return false;
  }
  
  public static final class a
  {
    private static boolean fdK = false;
    private static Class fdL;
    private static Field fdM;
    private static Class fdN;
    private static Field fdO;
    
    public static String h(Message paramMessage)
    {
      AppMethodBeat.i(160115);
      if (!fdK) {}
      try
      {
        Object localObject = Class.forName("android.app.ActivityThread$ReceiverData");
        fdL = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredField("intent");
        fdM = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        localObject = Class.forName("android.app.ActivityThread$CreateServiceData");
        fdN = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredField("intent");
        fdO = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        fdK = true;
        if (!fdK)
        {
          AppMethodBeat.o(160115);
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
        }
        try
        {
          if (fdL.isInstance(paramMessage.obj)) {}
          for (paramMessage = (Intent)fdM.get(paramMessage.obj);; paramMessage = (Intent)fdO.get(paramMessage.obj))
          {
            if (paramMessage == null) {
              break label190;
            }
            paramMessage = paramMessage.getComponent().getClassName();
            AppMethodBeat.o(160115);
            return paramMessage;
            if (!fdN.isInstance(paramMessage.obj)) {
              break;
            }
          }
        }
        catch (Throwable paramMessage)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", paramMessage, "", new Object[0]);
            paramMessage = null;
          }
          label190:
          AppMethodBeat.o(160115);
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.y
 * JD-Core Version:    0.7.0.1
 */