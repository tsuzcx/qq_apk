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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.plugin.openapi.a.a;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.e.c;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class ExtContentProviderBase
  extends ContentProvider
{
  protected static boolean vsk;
  private static HashMap<String, Long> zPd;
  protected MatrixCursor vsh;
  private long zOY;
  private String zOZ;
  public String zPa;
  private String[] zPb;
  private int zPc;
  
  static
  {
    AppMethodBeat.i(24419);
    vsk = false;
    zPd = new HashMap();
    AppMethodBeat.o(24419);
  }
  
  public ExtContentProviderBase()
  {
    AppMethodBeat.i(24405);
    this.vsh = new MatrixCursor(new String[0]);
    this.zOY = Util.currentTicks();
    this.zPa = "";
    this.zPc = 0;
    AppMethodBeat.o(24405);
  }
  
  private int dOd()
  {
    AppMethodBeat.i(24409);
    int i = (int)Util.ticksToNow(this.zOY);
    AppMethodBeat.o(24409);
    return i;
  }
  
  private void gi(Context paramContext)
  {
    AppMethodBeat.i(24418);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
      AppMethodBeat.o(24418);
      return;
    }
    Log.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
    this.zPb = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
    if (this.zPb == null) {
      Log.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
    }
    AppMethodBeat.o(24418);
  }
  
  private static String l(Uri paramUri)
  {
    AppMethodBeat.i(24415);
    if (paramUri == null)
    {
      AppMethodBeat.o(24415);
      return "";
    }
    paramUri = Util.nullAsNil(paramUri.getQueryParameter("appid"));
    AppMethodBeat.o(24415);
    return paramUri;
  }
  
  protected final void Mm(int paramInt)
  {
    AppMethodBeat.i(24406);
    Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { dOe(), this.zPa, Integer.valueOf(this.zPc), Integer.valueOf(paramInt), Integer.valueOf(dOd()) });
    com.tencent.mm.plugin.report.service.h.OAn.b(10505, new Object[] { dOe(), this.zPa, Integer.valueOf(this.zPc), Integer.valueOf(paramInt), Integer.valueOf(dOd()) });
    AppMethodBeat.o(24406);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(24411);
    this.zPa = l(paramUri);
    gi(paramContext);
    this.zPc = paramInt;
    this.zOY = Util.currentTicks();
    AppMethodBeat.o(24411);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(24412);
    this.zPa = l(paramUri);
    if (paramArrayOfString == null) {
      gi(paramContext);
    }
    for (;;)
    {
      this.zPc = paramInt;
      this.zOY = Util.currentTicks();
      AppMethodBeat.o(24412);
      return;
      this.zPb = paramArrayOfString;
    }
  }
  
  protected final void a(Uri paramUri, Context paramContext, UriMatcher paramUriMatcher)
  {
    AppMethodBeat.i(24410);
    this.zPa = l(paramUri);
    gi(paramContext);
    if (paramUriMatcher != null)
    {
      this.zPc = paramUriMatcher.match(paramUri);
      if (this.zPc < 0) {
        this.zPc = 0;
      }
    }
    this.zOY = Util.currentTicks();
    AppMethodBeat.o(24410);
  }
  
  protected final void au(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(24408);
    Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { dOe(), this.zPa, Integer.valueOf(this.zPc), Integer.valueOf(paramInt2), Integer.valueOf(dOd()) });
    com.tencent.mm.plugin.report.service.h.OAn.b(10505, new Object[] { dOe(), this.zPa, Integer.valueOf(this.zPc), Integer.valueOf(paramInt2), Integer.valueOf(dOd()), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(300L, paramInt1, 1L, false);
    AppMethodBeat.o(24408);
  }
  
  public final String dOe()
  {
    AppMethodBeat.i(24413);
    if (!Util.isNullOrNil(this.zOZ))
    {
      str = this.zOZ;
      AppMethodBeat.o(24413);
      return str;
    }
    if ((this.zPb == null) || (this.zPb.length <= 0))
    {
      AppMethodBeat.o(24413);
      return "";
    }
    String str = this.zPb[0];
    AppMethodBeat.o(24413);
    return str;
  }
  
  protected final int dOf()
  {
    AppMethodBeat.i(24417);
    if (Util.isNullOrNil(this.zPa))
    {
      Log.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24417);
      return 7;
    }
    if ((this.zPb == null) || (this.zPb.length <= 0))
    {
      Log.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24417);
      return 6;
    }
    try
    {
      localg = com.tencent.mm.pluginsdk.model.app.h.s(this.zPa, true, false);
      if (localg == null)
      {
        Log.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(24417);
        return 13;
      }
      if (localg.field_status == 3)
      {
        Log.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localg.field_packageName });
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
          label251:
          this.zOZ = ((String)localObject2);
          i = 1;
          if (i != 1) {}
        }
        catch (Exception localException2)
        {
          com.tencent.mm.pluginsdk.model.app.g localg;
          Object localObject1;
          Object localObject2;
          i = 1;
          continue;
        }
        try
        {
          localObject2 = (Integer)e.c.XNC.get(Integer.valueOf(this.zPc));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            hf(5, 16);
            Log.i("MicroMsg.ExtContentProviderBase", "api flag = null");
            localObject1 = Integer.valueOf(64);
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.b(localg, ((Integer)localObject1).intValue()))
          {
            i = 11;
            continue;
          }
          Log.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception localException3)
        {
          continue;
        }
        localException1 = localException1;
        i = 0;
        Log.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { localException1.getMessage() });
        Log.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException1, "", new Object[0]);
      }
    }
    try
    {
      localObject1 = Long.valueOf(Util.nullAs((Long)zPd.get(this.zPa), 0L));
      Log.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - ((Long)localObject1).longValue() > 3600000L)
      {
        Log.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.zPa });
        a.a.gxu().aRb(this.zPa);
        zPd.put(this.zPa, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24417);
      return i;
    }
    catch (Exception localException4)
    {
      break label397;
      i = 0;
      break label313;
      i += 1;
      break label251;
    }
    localObject1 = this.zPb;
    j = localObject1.length;
    i = 0;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if ((!((String)localObject2).equals(localg.field_packageName)) || (!u.a(MMApplicationContext.getContext(), localg, (String)localObject2, false))) {
        break label450;
      }
      Log.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject2 });
    }
  }
  
  protected final boolean dak()
  {
    AppMethodBeat.i(24414);
    try
    {
      Log.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
      if (!vsk)
      {
        final b localb = new b();
        localb.c(4000L, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24404);
            try
            {
              boolean bool = bh.baz();
              if (!bool)
              {
                AppMethodBeat.o(24404);
                return;
              }
              bh.aZW().a(new bw(new bw.a()
              {
                public final void b(com.tencent.mm.network.g paramAnonymous2g)
                {
                  AppMethodBeat.i(24403);
                  Log.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                  ExtContentProviderBase.1.this.vsq.asP();
                  AppMethodBeat.o(24403);
                }
              }), 0);
              AppMethodBeat.o(24404);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
              localb.asP();
              AppMethodBeat.o(24404);
            }
          }
        });
      }
      if ((bh.baz()) && (bh.bCA()) && (!bh.aZG())) {}
      for (vsk = true;; vsk = false)
      {
        Log.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + vsk);
        boolean bool = vsk;
        AppMethodBeat.o(24414);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.ExtContentProviderBase", localException.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException, "", new Object[0]);
      AppMethodBeat.o(24414);
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
  
  protected final boolean gh(Context paramContext)
  {
    AppMethodBeat.i(24416);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
      AppMethodBeat.o(24416);
      return false;
    }
    if (Util.isNullOrNil(this.zPa))
    {
      Log.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24416);
      return false;
    }
    if ((this.zPb == null) || (this.zPb.length <= 0))
    {
      Log.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24416);
      return false;
    }
    try
    {
      localg = com.tencent.mm.pluginsdk.model.app.h.s(this.zPa, true, false);
      if (localg == null)
      {
        Log.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(24416);
        return false;
      }
      if (localg.field_status == 3)
      {
        Log.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localg.field_packageName });
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
          label269:
          this.zOZ = ((String)localObject);
          bool = true;
          if (!bool) {}
        }
        catch (Exception paramContext)
        {
          com.tencent.mm.pluginsdk.model.app.g localg;
          Object localObject;
          bool = true;
          continue;
        }
        try
        {
          localObject = (Integer)e.c.XNC.get(Integer.valueOf(this.zPc));
          paramContext = (Context)localObject;
          if (localObject == null) {
            paramContext = Integer.valueOf(64);
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.b(localg, paramContext.intValue()))
          {
            bool = false;
            continue;
          }
          Log.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        bool = false;
        Log.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { paramContext.getMessage() });
        Log.printErrStackTrace("MicroMsg.ExtContentProviderBase", paramContext, "", new Object[0]);
      }
    }
    try
    {
      paramContext = Long.valueOf(Util.nullAs((Long)zPd.get(this.zPa), 0L));
      Log.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - paramContext.longValue() > 3600000L)
      {
        Log.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.zPa });
        a.a.gxu().aRb(this.zPa);
        zPd.put(this.zPa, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24416);
      return bool;
    }
    catch (Exception paramContext)
    {
      break label402;
      bool = false;
      break label332;
      i += 1;
      break label269;
    }
    paramContext = this.zPb;
    j = paramContext.length;
    i = 0;
    if (i < j)
    {
      localObject = paramContext[i];
      if ((!((String)localObject).equals(localg.field_packageName)) || (!u.a(MMApplicationContext.getContext(), localg, (String)localObject, false))) {
        break label457;
      }
      Log.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject });
    }
  }
  
  protected final void hf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24407);
    Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { dOe(), this.zPa, Integer.valueOf(this.zPc), Integer.valueOf(paramInt1), Integer.valueOf(dOd()) });
    com.tencent.mm.plugin.report.service.h.OAn.b(10505, new Object[] { dOe(), this.zPa, Integer.valueOf(this.zPc), Integer.valueOf(paramInt1), Integer.valueOf(dOd()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24407);
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
 * JD-Core Version:    0.7.0.1
 */