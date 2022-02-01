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

public final class ab
{
  public static final d hhy;
  private static final HashSet hhz;
  
  static
  {
    AppMethodBeat.i(160106);
    hhy = new d()
    {
      public final boolean ir(String paramAnonymousString)
      {
        AppMethodBeat.i(160130);
        boolean bool = ab.is(paramAnonymousString);
        AppMethodBeat.o(160130);
        return bool;
      }
      
      public final Activity q(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(160131);
        paramAnonymousActivity = ab.p(paramAnonymousActivity);
        AppMethodBeat.o(160131);
        return paramAnonymousActivity;
      }
    };
    hhz = new HashSet();
    hhz.addAll(Arrays.asList(new String[] { "com.tencent.mm.plugin.card.ui.CardHomePageUI", "com.tencent.mm.plugin.card.ui.CardHomePageNewUI", "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI", "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI", "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", "com.tencent.mm.ui.chatting.ChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.scanner.ui.BaseScanUI", "com.tencent.mm.plugin.readerapp.ui.ReaderAppUI", "com.tencent.mm.ui.SingleChatInfoUI", "com.tencent.mm.plugin.sns.ui.SnsUploadUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI", "com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI", "com.tencent.mm.plugin.sns.ui.SnsBrowseUI", "com.tencent.mm.chatroom.ui.ChatroomInfoUI" }));
    AppMethodBeat.o(160106);
  }
  
  public static void aCM()
  {
    AppMethodBeat.i(160103);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = i.acAE.iterator();
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
              i.x(localMessage);
              Log.i("MicroMsg.PreventAccountNotReady", "replay message for %s", new Object[] { str });
              break;
            }
          }
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
          localArrayList.add(localMessage);
        }
        break;
        label119:
        int i = 0;
      }
    }
    i.acAE.clear();
    i.acAE.addAll(localArrayList);
    AppMethodBeat.o(160103);
  }
  
  private static boolean dV(boolean paramBoolean)
  {
    AppMethodBeat.i(160101);
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      if (paramBoolean) {
        Log.i("MicroMsg.PreventAccountNotReady", "not main process");
      }
      AppMethodBeat.o(160101);
      return true;
    }
    if ((com.tencent.mm.kernel.h.baF().mDv) && (com.tencent.mm.kernel.h.baC().aZN()))
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
  
  private static boolean ir(String paramString)
  {
    AppMethodBeat.i(160102);
    Log.i("MicroMsg.PreventAccountNotReady", "eatActivity %s", new Object[] { paramString });
    if (dV(true))
    {
      AppMethodBeat.o(160102);
      return false;
    }
    if (paramString != null)
    {
      if (hhz.contains(paramString))
      {
        Log.w("MicroMsg.PreventAccountNotReady", "protect this activity %s", new Object[] { paramString });
        AppMethodBeat.o(160102);
        return true;
      }
      try
      {
        com.tencent.mm.kernel.h.baB().bad();
        Object localObject = new ComponentName(MMApplicationContext.getPackageName(), paramString);
        localObject = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP.getPackageManager().getActivityInfo((ComponentName)localObject, 128);
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
    private static boolean hhA = false;
    private static Class hhB;
    private static Field hhC;
    private static Class hhD;
    private static Field hhE;
    
    public static String h(Message paramMessage)
    {
      AppMethodBeat.i(160115);
      if (!hhA) {}
      try
      {
        Object localObject = Class.forName("android.app.ActivityThread$ReceiverData");
        hhB = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredField("intent");
        hhC = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        localObject = Class.forName("android.app.ActivityThread$CreateServiceData");
        hhD = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredField("intent");
        hhE = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        hhA = true;
        if (!hhA)
        {
          AppMethodBeat.o(160115);
          return null;
        }
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.PreventAccountNotReady", localThrowable, "", new Object[0]);
        }
        try
        {
          if (hhB.isInstance(paramMessage.obj)) {}
          for (paramMessage = (Intent)hhC.get(paramMessage.obj);; paramMessage = (Intent)hhE.get(paramMessage.obj))
          {
            if (paramMessage == null) {
              break label190;
            }
            paramMessage = paramMessage.getComponent().getClassName();
            AppMethodBeat.o(160115);
            return paramMessage;
            if (!hhD.isInstance(paramMessage.obj)) {
              break;
            }
          }
        }
        finally
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
 * Qualified Name:     com.tencent.mm.app.ab
 * JD-Core Version:    0.7.0.1
 */