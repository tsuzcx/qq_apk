package com.tencent.mm.plugin.base.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.network.a;
import com.tencent.mm.network.af;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public static final String SOURCE_KEY;
  private static char[] lDt;
  private static String sfi;
  
  static
  {
    AppMethodBeat.i(151453);
    SOURCE_KEY = MMApplicationContext.getPackageName();
    sfi = "";
    lDt = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    AppMethodBeat.o(151453);
  }
  
  public static void L(final Activity paramActivity)
  {
    AppMethodBeat.i(151441);
    if (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("no_more_show_add_short_cut_dialog", false))
    {
      f.a locala = new f.a(paramActivity);
      locala.bBo(paramActivity.getString(c.h.shortcut_permission_dialog_no_more_notify));
      String str1 = paramActivity.getString(c.h.shortcut_permission_dialog_title_not_know_permission_status);
      String str2 = paramActivity.getString(c.h.shortcut_permission_dialog_msg_unknown_permission_status);
      locala.aR(str1);
      locala.bBl(str2);
      locala.ayp(c.h.app_i_known);
      locala.Qlf = true;
      locala.a(new f.b()
      {
        public final void H(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(151432);
          this.sfj.mUO.dismiss();
          if (paramAnonymousBoolean2) {
            paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).apply();
          }
          AppMethodBeat.o(151432);
        }
      });
      locala.show();
    }
    AppMethodBeat.o(151441);
  }
  
  public static int X(as paramas)
  {
    AppMethodBeat.i(151447);
    if (paramas.hxX())
    {
      AppMethodBeat.o(151447);
      return 2;
    }
    if (!ab.QY(paramas.field_username))
    {
      AppMethodBeat.o(151447);
      return 1;
    }
    AppMethodBeat.o(151447);
    return 0;
  }
  
  private static Intent a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(151444);
    if ((paramString1 == null) || (paramContext == null))
    {
      Log.e("MicroMsg.ShortcutManager", "getIntent, wrong parameters");
      AppMethodBeat.o(151444);
      return null;
    }
    Bitmap localBitmap = aj(paramContext, paramString1);
    if (localBitmap == null)
    {
      Log.e("MicroMsg.ShortcutManager", "no bmp");
      AppMethodBeat.o(151444);
      return null;
    }
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString1);
    if ((localas == null) || ((int)localas.jxt <= 0))
    {
      Log.e("MicroMsg.ShortcutManager", "no such user");
      AppMethodBeat.o(151444);
      return null;
    }
    String str = aoF(paramString1);
    Log.i("MicroMsg.ShortcutManager", "alvinluo encryptShortcutUser: %s", new Object[] { str });
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(151444);
      return null;
    }
    Intent localIntent = new Intent("com.tencent.mm.action.BIZSHORTCUT");
    localIntent.putExtra("LauncherUI.Shortcut.Username", str);
    localIntent.putExtra("LauncherUI.From.Biz.Shortcut", true);
    localIntent.putExtra("app_shortcut_custom_id", str);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.addFlags(67108864);
    if (paramBoolean) {}
    for (paramContext = "com.android.launcher.action.INSTALL_SHORTCUT";; paramContext = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      paramContext = new Intent(paramContext);
      paramContext.putExtra("android.intent.extra.shortcut.NAME", ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).b(localas, paramString1));
      paramContext.putExtra("duplicate", false);
      paramContext.putExtra("android.intent.extra.shortcut.INTENT", localIntent);
      paramContext.putExtra("android.intent.extra.shortcut.ICON", localBitmap);
      paramContext.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_SOURCE_KEY", SOURCE_KEY);
      paramContext.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_OWNER_ID", aoF(paramString2));
      paramContext.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_UNIQUE_ID", str);
      paramContext.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_TYPE", X(localas));
      paramContext.putExtra("com.tencent.qlauncher.extra.EXTRA_PUSH_ITEM_CONTAINER", 0);
      AppMethodBeat.o(151444);
      return paramContext;
    }
  }
  
  @TargetApi(26)
  private static ShortcutInfo a(Context paramContext, String paramString, Intent paramIntent1, Intent paramIntent2, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(151445);
    paramContext = new ShortcutInfo.Builder(paramContext, paramString).setShortLabel(paramIntent1.getStringExtra("android.intent.extra.shortcut.NAME")).setLongLabel(paramIntent1.getStringExtra("android.intent.extra.shortcut.NAME")).setIntent(paramIntent2);
    if (paramBoolean) {
      paramContext.setIcon(Icon.createWithBitmap(paramBitmap));
    }
    for (;;)
    {
      paramContext = paramContext.build();
      AppMethodBeat.o(151445);
      return paramContext;
      paramContext.setIcon(Icon.createWithAdaptiveBitmap(paramBitmap));
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(151436);
    if (paramContext == null)
    {
      Log.e("MicroMsg.ShortcutManager", "context is null");
      AppMethodBeat.o(151436);
      return;
    }
    if (paramIntent == null)
    {
      Log.e("MicroMsg.ShortcutManager", "intent is null");
      AppMethodBeat.o(151436);
      return;
    }
    if (Build.VERSION.SDK_INT < 26) {}
    for (boolean bool = c(paramContext, paramIntent, paramBoolean);; bool = b(paramContext, paramIntent, paramString1, paramString2, paramBoolean))
    {
      if ((!bool) && (paramBoolean)) {
        d(paramContext, false, paramBoolean);
      }
      AppMethodBeat.o(151436);
      return;
    }
  }
  
  private static void a(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151435);
    a(paramContext, paramIntent, paramString, null, paramBoolean);
    AppMethodBeat.o(151435);
  }
  
  public static boolean ah(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151433);
    sfi = z.bcZ();
    paramString = a(paramContext, paramString, true, sfi);
    Intent localIntent = (Intent)paramString.getParcelableExtra("android.intent.extra.shortcut.INTENT");
    if (localIntent == null)
    {
      AppMethodBeat.o(151433);
      return false;
    }
    a(paramContext, paramString, localIntent.getStringExtra("app_shortcut_custom_id"), true);
    AppMethodBeat.o(151433);
    return true;
  }
  
  public static boolean ai(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151442);
    sfi = z.bcZ();
    p(paramContext, a(paramContext, paramString, false, sfi));
    AppMethodBeat.o(151442);
    return true;
  }
  
  private static Bitmap aj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151446);
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * 48.0F);
    paramString = com.tencent.mm.am.d.a(paramString, false, -1, null);
    paramContext = paramString;
    if (paramString == null)
    {
      Log.e("MicroMsg.ShortcutManager", "getScaledBitmap fail, bmp is null");
      paramContext = BitmapUtil.getBitmapNative(c.d.default_avatar);
    }
    if (paramContext == null)
    {
      Log.e("MicroMsg.ShortcutManager", "use default avatar, bmp is null");
      AppMethodBeat.o(151446);
      return null;
    }
    paramContext = Bitmap.createScaledBitmap(paramContext, i, i, false);
    AppMethodBeat.o(151446);
    return paramContext;
  }
  
  public static String aoE(String paramString)
  {
    AppMethodBeat.i(151449);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(151449);
      return null;
    }
    String str1 = Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid());
    String str2 = MMApplicationContext.getPackageName();
    Log.i("MicroMsg.ShortcutManager", "process name: %s", new Object[] { str1 });
    try
    {
      if (str2.equals(str1))
      {
        boolean bool = com.tencent.mm.kernel.h.aHE().aGM();
        if (!bool)
        {
          AppMethodBeat.o(151449);
          return null;
        }
        com.tencent.mm.kernel.h.aHE();
      }
      for (int i = com.tencent.mm.kernel.b.getUin(); paramString.startsWith("shortcut_"); i = af.btU().muM.getUin())
      {
        paramString = fk(new String(aoG(paramString.substring(9))), String.valueOf(i));
        AppMethodBeat.o(151449);
        return paramString;
      }
      AppMethodBeat.o(151449);
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151449);
      return null;
    }
    return paramString;
  }
  
  public static String aoF(String paramString)
  {
    AppMethodBeat.i(151450);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(151450);
      return null;
    }
    Object localObject = Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid());
    String str = MMApplicationContext.getPackageName();
    if ((str.equals(localObject)) && (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      AppMethodBeat.o(151450);
      return null;
    }
    Log.i("MicroMsg.ShortcutManager", "process name: %s", new Object[] { localObject });
    try
    {
      if (str.equals(localObject))
      {
        localObject = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
      }
      for (paramString = fk(paramString, com.tencent.mm.kernel.b.getUin()); Util.isNullOrNil(paramString); paramString = fk(paramString, af.btU().muM.getUin()))
      {
        AppMethodBeat.o(151450);
        return null;
      }
      paramString = "shortcut_" + toHexString(paramString.getBytes());
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ShortcutManager", null, "exception: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(151450);
      return null;
    }
    AppMethodBeat.o(151450);
    return paramString;
  }
  
  public static final byte[] aoG(String paramString)
  {
    AppMethodBeat.i(151452);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(151452);
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    AppMethodBeat.o(151452);
    return arrayOfByte;
  }
  
  @TargetApi(26)
  private static boolean b(Context paramContext, Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(151439);
    ShortcutManager localShortcutManager = (ShortcutManager)paramContext.getSystemService(ShortcutManager.class);
    if (localShortcutManager == null)
    {
      Log.e("MicroMsg.ShortcutManager", "shortcut manager is null");
      AppMethodBeat.o(151439);
      return false;
    }
    if (!localShortcutManager.isRequestPinShortcutSupported())
    {
      Log.e("MicroMsg.ShortcutManager", "alvinluo not support pin shortcuts");
      AppMethodBeat.o(151439);
      return false;
    }
    if (paramIntent.getBooleanExtra("is_main_shortcut", false))
    {
      Log.i("MicroMsg.ShortcutManager", "alvinluo main icon, do not create shortcut");
      AppMethodBeat.o(151439);
      return false;
    }
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
    if (localIntent == null)
    {
      Log.e("MicroMsg.ShortcutManager", "alvinluo shortcut intent is null");
      AppMethodBeat.o(151439);
      return false;
    }
    Object localObject = paramString1;
    if (Util.isNullOrNil(paramString1)) {
      localObject = localIntent.getStringExtra("app_shortcut_custom_id");
    }
    int i;
    if (Util.isNullOrNil((String)localObject))
    {
      Log.i("MicroMsg.ShortcutManager", "alvinluo shortcutId is null, then use short name as shortcutId");
      paramString1 = paramIntent.getStringExtra("android.intent.extra.shortcut.NAME");
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.ShortcutManager", "alvinluo shortcutId: %s", new Object[] { paramString1 });
      String str = paramIntent.getStringExtra("android.intent.extra.shortcut.NAME");
      localObject = (Intent.ShortcutIconResource)paramIntent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
      if (localObject != null) {
        Log.i("MicroMsg.ShortcutManager", "alvinluo icon resource name: %s, %s", new Object[] { ((Intent.ShortcutIconResource)localObject).resourceName, ((Intent.ShortcutIconResource)localObject).packageName });
      }
      localObject = (Bitmap)paramIntent.getParcelableExtra("android.intent.extra.shortcut.ICON");
      int j;
      if (localObject == null)
      {
        Log.i("MicroMsg.ShortcutManager", "extra_shortcut_icon is null, use icon resource id");
        j = paramIntent.getIntExtra("shortcut_icon_resource_id", -1);
        if (j == -1)
        {
          Log.e("MicroMsg.ShortcutManager", "icon resource id is null");
          AppMethodBeat.o(151439);
          return false;
        }
        localObject = BitmapFactory.decodeResource(paramContext.getResources(), j);
      }
      for (;;)
      {
        if (localObject == null)
        {
          Log.e("MicroMsg.ShortcutManager", "icon bitmap is null");
          AppMethodBeat.o(151439);
          return false;
        }
        boolean bool2 = paramIntent.getBooleanExtra("shortcut_is_adaptive_icon", false);
        ShortcutInfo localShortcutInfo1 = a(paramContext, paramString1, paramIntent, localIntent, bool2, (Bitmap)localObject);
        boolean bool1 = paramIntent.getBooleanExtra("duplicate", false);
        Log.i("MicroMsg.ShortcutManager", "alvinluo add shortcut above android o, duplicate: %b", new Object[] { Boolean.valueOf(bool1) });
        if (bool1)
        {
          localShortcutManager.requestPinShortcut(localShortcutInfo1, null);
          d(paramContext, true, paramBoolean);
          AppMethodBeat.o(151439);
          return true;
        }
        List localList = localShortcutManager.getPinnedShortcuts();
        j = 0;
        label418:
        ShortcutInfo localShortcutInfo2;
        if (j < localList.size())
        {
          localShortcutInfo2 = (ShortcutInfo)localList.get(j);
          if (i != 0)
          {
            if ((localShortcutInfo2 == null) || (localShortcutInfo2.getShortLabel() == null) || (!localShortcutInfo2.getShortLabel().equals(str))) {
              break label629;
            }
            i = 0;
            bool1 = true;
          }
        }
        for (;;)
        {
          label481:
          Log.i("MicroMsg.ShortcutManager", "alvinluo shortcut exist: %b, shortcutName: %s", new Object[] { Boolean.valueOf(bool1), str });
          if (i != 0) {}
          for (paramIntent = a(paramContext, paramString2, paramIntent, localIntent, bool2, (Bitmap)localObject);; paramIntent = localShortcutInfo1)
          {
            if (bool1)
            {
              paramString1 = new ArrayList();
              paramString1.add(paramIntent);
              Log.i("MicroMsg.ShortcutManager", "alvinluo update shortcuts result: %b", new Object[] { Boolean.valueOf(localShortcutManager.updateShortcuts(paramString1)) });
              d(paramContext, true, paramBoolean);
              break;
              if ((localShortcutInfo2 != null) && (localShortcutInfo2.getId().equals(paramString2)))
              {
                i = 1;
                bool1 = true;
                break label481;
              }
              if ((localShortcutInfo2 != null) && (localShortcutInfo2.getId().equals(paramString1)))
              {
                i = 0;
                bool1 = true;
                break label481;
              }
              label629:
              j += 1;
              break label418;
            }
            if (paramBoolean)
            {
              paramString1 = localShortcutManager.createShortcutResultIntent(paramIntent);
              paramString1.setClass(paramContext, ShortcutBroadCastReceiver.class);
              localShortcutManager.requestPinShortcut(paramIntent, PendingIntent.getBroadcast(paramContext, 0, paramString1, 134217728).getIntentSender());
              break;
            }
            localShortcutManager.requestPinShortcut(paramIntent, null);
            break;
          }
          i = 0;
          bool1 = false;
        }
      }
      i = 0;
      paramString1 = (String)localObject;
    }
  }
  
  private static boolean c(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(151438);
    paramContext.sendBroadcast(paramIntent);
    d(paramContext, true, paramBoolean);
    AppMethodBeat.o(151438);
    return true;
  }
  
  private static void d(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(151440);
    if (paramBoolean2) {
      if (!paramBoolean1) {
        break label35;
      }
    }
    label35:
    for (String str = paramContext.getString(c.h.app_added);; str = paramContext.getString(c.h.app_add_failed))
    {
      com.tencent.mm.ui.base.h.cO(paramContext, str);
      AppMethodBeat.o(151440);
      return;
    }
  }
  
  public static String fk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151448);
    int[] arrayOfInt;
    byte[] arrayOfByte;
    int i;
    for (;;)
    {
      try
      {
        arrayOfInt = new int[256];
        arrayOfByte = new byte[256];
        i = 0;
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.ShortcutManager", "Exception in rc4, %s", new Object[] { paramString1.getMessage() });
        Log.printErrStackTrace("MicroMsg.ShortcutManager", paramString1, "", new Object[0]);
        AppMethodBeat.o(151448);
        return null;
      }
      if (i >= 256) {
        break label249;
      }
      arrayOfByte[i] = ((byte)paramString2.charAt(i % paramString2.length()));
      i = (short)(i + 1);
    }
    for (;;)
    {
      paramString1 = paramString1.toCharArray();
      paramString2 = new char[paramString1.length];
      i = 0;
      int k = 0;
      int j = 0;
      while (i < paramString1.length)
      {
        k = (k + 1) % 256;
        j = (j + arrayOfInt[k]) % 256;
        int m = arrayOfInt[k];
        arrayOfInt[k] = arrayOfInt[j];
        arrayOfInt[j] = m;
        m = arrayOfInt[((arrayOfInt[k] + arrayOfInt[j] % 256) % 256)];
        int n = paramString1[i];
        paramString2[i] = ((char)((char)m ^ n));
        i = (short)(i + 1);
      }
      paramString1 = new String(paramString2);
      AppMethodBeat.o(151448);
      return paramString1;
      while (i < 256)
      {
        arrayOfInt[i] = i;
        i += 1;
      }
      i = 0;
      break;
      label249:
      i = 0;
      j = 0;
      while (i < 255)
      {
        j = (j + arrayOfInt[i] + arrayOfByte[i]) % 256;
        k = arrayOfInt[i];
        arrayOfInt[i] = arrayOfInt[j];
        arrayOfInt[j] = k;
        i += 1;
      }
    }
  }
  
  public static void n(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(151434);
    a(paramContext, paramIntent, null, true);
    AppMethodBeat.o(151434);
  }
  
  public static void o(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(151437);
    a(paramContext, paramIntent, null, false);
    AppMethodBeat.o(151437);
  }
  
  public static boolean p(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(151443);
    if (paramContext == null)
    {
      Log.e("MicroMsg.ShortcutManager", "context is null");
      AppMethodBeat.o(151443);
      return false;
    }
    if (paramIntent == null)
    {
      Log.e("MicroMsg.ShortcutManager", "intent is null");
      AppMethodBeat.o(151443);
      return false;
    }
    if (Build.VERSION.SDK_INT < 26)
    {
      paramContext.sendBroadcast(paramIntent);
      AppMethodBeat.o(151443);
      return true;
    }
    AppMethodBeat.o(151443);
    return true;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151451);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(151451);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(lDt[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(lDt[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(151451);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.b
 * JD-Core Version:    0.7.0.1
 */