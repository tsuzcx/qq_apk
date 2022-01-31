package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.JgClassChecked;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.z.a.a;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtContentProviderBase
  extends ContentProvider
{
  protected static boolean hSq = false;
  private static HashMap<String, Long> jKg = new HashMap();
  public MatrixCursor hSn = new MatrixCursor(new String[0]);
  private long jKb = bk.UZ();
  private String jKc;
  public String jKd = "";
  private String[] jKe;
  private int jKf = 0;
  
  private int aNz()
  {
    return (int)bk.cp(this.jKb);
  }
  
  private void dd(Context paramContext)
  {
    if (paramContext == null) {
      y.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
    }
    do
    {
      return;
      y.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
      this.jKe = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
    } while (this.jKe != null);
    y.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
  }
  
  private static String g(Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    return bk.pm(paramUri.getQueryParameter("appid"));
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { aNA(), this.jKd, Integer.valueOf(this.jKf), Integer.valueOf(paramInt2), Integer.valueOf(aNz()) });
    h.nFQ.f(10505, new Object[] { aNA(), this.jKd, Integer.valueOf(this.jKf), Integer.valueOf(paramInt2), Integer.valueOf(aNz()), Integer.valueOf(paramInt3) });
    h.nFQ.a(300L, paramInt1, 1L, false);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt)
  {
    this.jKd = g(paramUri);
    dd(paramContext);
    this.jKf = paramInt;
    this.jKb = bk.UZ();
  }
  
  public final void a(Uri paramUri, Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    this.jKd = g(paramUri);
    if (paramArrayOfString == null) {
      dd(paramContext);
    }
    for (;;)
    {
      this.jKf = paramInt;
      this.jKb = bk.UZ();
      return;
      this.jKe = paramArrayOfString;
    }
  }
  
  protected final void a(Uri paramUri, Context paramContext, UriMatcher paramUriMatcher)
  {
    this.jKd = g(paramUri);
    dd(paramContext);
    if (paramUriMatcher != null)
    {
      this.jKf = paramUriMatcher.match(paramUri);
      if (this.jKf < 0) {
        this.jKf = 0;
      }
    }
    this.jKb = bk.UZ();
  }
  
  public final String aNA()
  {
    if (!bk.bl(this.jKc)) {
      return this.jKc;
    }
    if ((this.jKe == null) || (this.jKe.length <= 0)) {
      return "";
    }
    return this.jKe[0];
  }
  
  public final int aNB()
  {
    if (bk.bl(this.jKd))
    {
      y.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      return 7;
    }
    if ((this.jKe == null) || (this.jKe.length <= 0))
    {
      y.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      return 6;
    }
    try
    {
      localf = g.by(this.jKd, true);
      if (localf == null)
      {
        y.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        return 13;
      }
      if (localf.field_status == 3)
      {
        y.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localf.field_packageName });
        i = 10;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          int j;
          label220:
          this.jKc = ((String)localObject2);
          i = 1;
          if (i != 1) {}
        }
        catch (Exception localException2)
        {
          f localf;
          Object localObject1;
          Object localObject2;
          i = 1;
          continue;
        }
        try
        {
          localObject2 = (Integer)b.b.rSv.get(Integer.valueOf(this.jKf));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            cL(5, 16);
            y.i("MicroMsg.ExtContentProviderBase", "api flag = null");
            localObject1 = Integer.valueOf(64);
          }
          if (!g.a(localf, ((Integer)localObject1).intValue())) {
            i = 11;
          } else {
            y.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
          }
        }
        catch (Exception localException3) {}
      }
      localException1 = localException1;
      i = 0;
      y.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { localException1.getMessage() });
      y.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException1, "", new Object[0]);
      return i;
    }
    try
    {
      localObject1 = Long.valueOf(bk.a((Long)jKg.get(this.jKd), 0L));
      y.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - ((Long)localObject1).longValue() > 3600000L)
      {
        y.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.jKd });
        a.a.bru().KE(this.jKd);
        jKg.put(this.jKd, Long.valueOf(System.currentTimeMillis()));
      }
      return i;
    }
    catch (Exception localException4)
    {
      break label365;
      i = 0;
      break label281;
      i += 1;
      break label220;
    }
    localObject1 = this.jKe;
    j = localObject1.length;
    i = 0;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if ((!((String)localObject2).equals(localf.field_packageName)) || (!p.c(ae.getContext(), localf, (String)localObject2))) {
        break label417;
      }
      y.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject2 });
    }
  }
  
  public final boolean awd()
  {
    try
    {
      y.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
      if (!hSq)
      {
        b localb = new b();
        localb.b(4000L, new ExtContentProviderBase.1(this, localb));
      }
      if ((au.DK()) && (au.Hz()) && (!au.CW())) {}
      for (hSq = true;; hSq = false)
      {
        y.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + hSq);
        return hSq;
      }
      return false;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.ExtContentProviderBase", localException.getMessage());
      y.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException, "", new Object[0]);
    }
  }
  
  public final void cL(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { aNA(), this.jKd, Integer.valueOf(this.jKf), Integer.valueOf(paramInt1), Integer.valueOf(aNz()) });
    h.nFQ.f(10505, new Object[] { aNA(), this.jKd, Integer.valueOf(this.jKf), Integer.valueOf(paramInt1), Integer.valueOf(aNz()), Integer.valueOf(paramInt2) });
  }
  
  public final boolean dc(Context paramContext)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
      return false;
    }
    if (bk.bl(this.jKd))
    {
      y.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      return false;
    }
    if ((this.jKe == null) || (this.jKe.length <= 0))
    {
      y.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      return false;
    }
    try
    {
      localf = g.by(this.jKd, true);
      if (localf == null)
      {
        y.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        return false;
      }
      if (localf.field_status == 3)
      {
        y.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localf.field_packageName });
        bool = false;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          int j;
          label232:
          this.jKc = ((String)localObject);
          bool = true;
          if (!bool) {}
        }
        catch (Exception paramContext)
        {
          f localf;
          Object localObject;
          bool = true;
          continue;
        }
        try
        {
          localObject = (Integer)b.b.rSv.get(Integer.valueOf(this.jKf));
          paramContext = (Context)localObject;
          if (localObject == null) {
            paramContext = Integer.valueOf(64);
          }
          if (!g.a(localf, paramContext.intValue())) {
            bool = false;
          } else {
            y.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
          }
        }
        catch (Exception paramContext) {}
      }
      paramContext = paramContext;
      bool = false;
      y.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { paramContext.getMessage() });
      y.printErrStackTrace("MicroMsg.ExtContentProviderBase", paramContext, "", new Object[0]);
      return bool;
    }
    try
    {
      paramContext = Long.valueOf(bk.a((Long)jKg.get(this.jKd), 0L));
      y.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - paramContext.longValue() > 3600000L)
      {
        y.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.jKd });
        a.a.bru().KE(this.jKd);
        jKg.put(this.jKd, Long.valueOf(System.currentTimeMillis()));
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      break label364;
      bool = false;
      break label294;
      i += 1;
      break label232;
    }
    paramContext = this.jKe;
    j = paramContext.length;
    i = 0;
    if (i < j)
    {
      localObject = paramContext[i];
      if ((!((String)localObject).equals(localf.field_packageName)) || (!p.c(ae.getContext(), localf, (String)localObject))) {
        break label419;
      }
      y.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject });
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public final void qF(int paramInt)
  {
    y.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { aNA(), this.jKd, Integer.valueOf(this.jKf), Integer.valueOf(paramInt), Integer.valueOf(aNz()) });
    h.nFQ.f(10505, new Object[] { aNA(), this.jKd, Integer.valueOf(this.jKf), Integer.valueOf(paramInt), Integer.valueOf(aNz()) });
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
 * JD-Core Version:    0.7.0.1
 */