package com.tencent.mm.plugin.base.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.tencent.mm.a.g;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private static List<com.tencent.mm.ag.d.a> hRM = new LinkedList();
  
  private static Bitmap V(Context paramContext, String paramString)
  {
    Bitmap localBitmap = com.tencent.mm.ag.b.a(paramString, false, -1);
    paramString = localBitmap;
    if (localBitmap != null)
    {
      paramString = localBitmap;
      if (!localBitmap.isRecycled())
      {
        int i = (int)(paramContext.getResources().getDisplayMetrics().density * 48.0F);
        paramString = Bitmap.createScaledBitmap(localBitmap, i, i, false);
      }
    }
    return paramString;
  }
  
  private static boolean W(Context paramContext, String paramString)
  {
    try
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      paramContext = paramContext.getPackageManager().getInstalledPackages(8);
      int i;
      label61:
      ProviderInfo localProviderInfo;
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        for (;;)
        {
          if (paramContext.hasNext())
          {
            ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
            if (arrayOfProviderInfo != null)
            {
              int j = arrayOfProviderInfo.length;
              i = 0;
              if (i < j)
              {
                localProviderInfo = arrayOfProviderInfo[i];
                if ("com.android.launcher.permission.READ_SETTINGS".equals(localProviderInfo.readPermission))
                {
                  paramContext = localProviderInfo.authority;
                  label91:
                  paramContext = localContentResolver.query(Uri.parse("content://" + paramContext + "/favorites?notify=true"), new String[] { "title", "iconResource" }, "title=?", new String[] { paramString }, null);
                  if (paramContext == null) {
                    break label214;
                  }
                  if (paramContext.getCount() <= 0) {
                    break label205;
                  }
                }
              }
            }
          }
        }
      }
      label205:
      for (boolean bool = true;; bool = false)
      {
        paramContext.close();
        return bool;
        if ("com.android.launcher.permission.READ_SETTINGS".equals(localProviderInfo.writePermission))
        {
          paramContext = localProviderInfo.authority;
          break label91;
        }
        i += 1;
        break label61;
        break;
        paramContext = null;
        break label91;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      return false;
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean)
  {
    y.i("MicroMsg.WebviewShrotcutManager", "buildIntent, install = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBitmap == null) && (paramBoolean)) {
      y.e("MicroMsg.WebviewShrotcutManager", "no bmp");
    }
    String str;
    do
    {
      return null;
      str = xJ(paramString1);
    } while (bk.bl(str));
    if (paramBoolean) {}
    for (Object localObject = "com.android.launcher.action.INSTALL_SHORTCUT";; localObject = "com.android.launcher.action.UNINSTALL_SHORTCUT")
    {
      Intent localIntent = new Intent((String)localObject);
      localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString3);
      localIntent.putExtra("duplicate", false);
      localObject = "";
      h localh = o.Kh().kp(paramString1);
      paramString1 = (String)localObject;
      if (localh != null) {
        paramString1 = g.o((paramString3 + localh.JY()).getBytes());
      }
      localObject = new Intent("com.tencent.mm.action.WX_SHORTCUT");
      ((Intent)localObject).putExtra("type", 2);
      ((Intent)localObject).putExtra("id", str);
      ((Intent)localObject).putExtra("ext_info", xJ(paramString2));
      ((Intent)localObject).putExtra("ext_info_1", xJ(paramString3));
      paramString3 = new StringBuilder();
      au.Hx();
      ((Intent)localObject).putExtra("token", cm(paramString2, c.CK()));
      ((Intent)localObject).putExtra("digest", paramString1);
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      ((Intent)localObject).addFlags(67108864);
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject);
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
      return localIntent;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, d.a parama)
  {
    if ((paramContext == null) || (bk.bl(paramString1)))
    {
      y.e("MicroMsg.WebviewShrotcutManager", "context or username is null");
      if (parama != null) {
        parama.el(false);
      }
    }
    do
    {
      return;
      y.d("MicroMsg.WebviewShrotcutManager", "addShortcut, username = %s", new Object[] { paramString1 });
      if ((au.DK()) && (!au.CW())) {
        break;
      }
      y.e("MicroMsg.WebviewShrotcutManager", "acc not ready");
    } while (parama == null);
    parama.el(false);
    return;
    au.Hx();
    ad localad = c.Fw().abl(paramString1);
    String str = "";
    if (localad != null) {
      str = localad.Bp();
    }
    if (bk.bl(str))
    {
      y.e("MicroMsg.WebviewShrotcutManager", "displayname is nil, should pull from service");
      com.tencent.mm.model.am.a.dVy.a(paramString1, "", new d.1(parama, paramString1, paramContext, paramString2));
      return;
    }
    a(paramContext, paramString1, paramString2, str, parama);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, d.a parama)
  {
    if (W(paramContext, paramString3))
    {
      y.i("MicroMsg.WebviewShrotcutManager", "shortcut has exist");
      if (parama != null) {
        parama.el(true);
      }
    }
    do
    {
      do
      {
        return;
        d.2 local2 = new d.2(paramString1, paramContext, parama, paramString2, paramString3);
        hRM.add(local2);
        o.JQ().a(local2);
        Bitmap localBitmap = V(paramContext, paramString1);
        if ((localBitmap == null) || (localBitmap.isRecycled()))
        {
          y.e("MicroMsg.WebviewShrotcutManager", "getAvatarBitmap fail, bmp is null, start timer.");
          new am(new b(new d.3(local2, parama, paramString1)), false).S(5000L, 5000L);
          return;
        }
        hRM.remove(local2);
        o.JQ().b(local2);
        paramString1 = a(paramContext, paramString1, paramString2, paramString3, localBitmap, true);
        if (paramString1 != null) {
          break;
        }
        y.e("MicroMsg.WebviewShrotcutManager", "intent is null");
      } while (parama == null);
      parama.el(false);
      return;
      b.n(paramContext, paramString1);
    } while (parama == null);
    parama.el(true);
  }
  
  public static String cm(String paramString1, String paramString2)
  {
    return g.o((g.o(paramString1.getBytes()) + b.cl(paramString2, paramString1)).getBytes());
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (bk.bl(paramString3))) {
      y.e("MicroMsg.WebviewShrotcutManager", "remove failed, invalid params");
    }
    paramString1 = a(paramContext, paramString1, paramString2, paramString3, null, false);
    if (paramString1 == null)
    {
      y.e("MicroMsg.WebviewShrotcutManager", "remove failed, intent is null");
      return;
    }
    b.o(paramContext, paramString1);
  }
  
  private static String xJ(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    do
    {
      return null;
      paramString = b.cl(paramString, q.zf());
    } while (bk.bl(paramString));
    return "shortcut_" + b.W(paramString.getBytes());
  }
  
  private static final class b
    implements com.tencent.mm.sdk.platformtools.am.a
  {
    private Runnable eKD;
    
    b(Runnable paramRunnable)
    {
      this.eKD = paramRunnable;
    }
    
    public final boolean tC()
    {
      if (this.eKD != null) {
        this.eKD.run();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.d
 * JD-Core Version:    0.7.0.1
 */