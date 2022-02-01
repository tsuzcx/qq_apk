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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.r.a.a.a;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.e.c;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtContentProviderBase
  extends ContentProvider
{
  protected static boolean pep;
  private static HashMap<String, Long> sNc;
  protected MatrixCursor pem;
  private long sMX;
  private String sMY;
  public String sMZ;
  private String[] sNa;
  private int sNb;
  
  static
  {
    AppMethodBeat.i(24419);
    pep = false;
    sNc = new HashMap();
    AppMethodBeat.o(24419);
  }
  
  public ExtContentProviderBase()
  {
    AppMethodBeat.i(24405);
    this.pem = new MatrixCursor(new String[0]);
    this.sMX = Util.currentTicks();
    this.sMZ = "";
    this.sNb = 0;
    AppMethodBeat.o(24405);
  }
  
  private int cSs()
  {
    AppMethodBeat.i(24409);
    int i = (int)Util.ticksToNow(this.sMX);
    AppMethodBeat.o(24409);
    return i;
  }
  
  private void ff(Context paramContext)
  {
    AppMethodBeat.i(24418);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
      AppMethodBeat.o(24418);
      return;
    }
    Log.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
    this.sNa = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
    if (this.sNa == null) {
      Log.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
    }
    AppMethodBeat.o(24418);
  }
  
  private static String s(Uri paramUri)
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
  
  protected final void HF(int paramInt)
  {
    AppMethodBeat.i(24406);
    Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(paramInt), Integer.valueOf(cSs()) });
    com.tencent.mm.plugin.report.service.h.CyF.a(10505, new Object[] { cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(paramInt), Integer.valueOf(cSs()) });
    AppMethodBeat.o(24406);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(24411);
    this.sMZ = s(paramUri);
    ff(paramContext);
    this.sNb = paramInt;
    this.sMX = Util.currentTicks();
    AppMethodBeat.o(24411);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(24412);
    this.sMZ = s(paramUri);
    if (paramArrayOfString == null) {
      ff(paramContext);
    }
    for (;;)
    {
      this.sNb = paramInt;
      this.sMX = Util.currentTicks();
      AppMethodBeat.o(24412);
      return;
      this.sNa = paramArrayOfString;
    }
  }
  
  protected final void a(Uri paramUri, Context paramContext, UriMatcher paramUriMatcher)
  {
    AppMethodBeat.i(24410);
    this.sMZ = s(paramUri);
    ff(paramContext);
    if (paramUriMatcher != null)
    {
      this.sNb = paramUriMatcher.match(paramUri);
      if (this.sNb < 0) {
        this.sNb = 0;
      }
    }
    this.sMX = Util.currentTicks();
    AppMethodBeat.o(24410);
  }
  
  protected final void ac(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(24408);
    Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(paramInt2), Integer.valueOf(cSs()) });
    com.tencent.mm.plugin.report.service.h.CyF.a(10505, new Object[] { cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(paramInt2), Integer.valueOf(cSs()), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(300L, paramInt1, 1L, false);
    AppMethodBeat.o(24408);
  }
  
  public final String cSt()
  {
    AppMethodBeat.i(24413);
    if (!Util.isNullOrNil(this.sMY))
    {
      str = this.sMY;
      AppMethodBeat.o(24413);
      return str;
    }
    if ((this.sNa == null) || (this.sNa.length <= 0))
    {
      AppMethodBeat.o(24413);
      return "";
    }
    String str = this.sNa[0];
    AppMethodBeat.o(24413);
    return str;
  }
  
  protected final int cSu()
  {
    AppMethodBeat.i(24417);
    if (Util.isNullOrNil(this.sMZ))
    {
      Log.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24417);
      return 7;
    }
    if ((this.sNa == null) || (this.sNa.length <= 0))
    {
      Log.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24417);
      return 6;
    }
    try
    {
      localg = com.tencent.mm.pluginsdk.model.app.h.o(this.sMZ, true, false);
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
          label252:
          this.sMY = ((String)localObject2);
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
          localObject2 = (Integer)e.c.JSJ.get(Integer.valueOf(this.sNb));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            fP(5, 16);
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
      localObject1 = Long.valueOf(Util.nullAs((Long)sNc.get(this.sMZ), 0L));
      Log.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - ((Long)localObject1).longValue() > 3600000L)
      {
        Log.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.sMZ });
        a.a.eAZ().aJz(this.sMZ);
        sNc.put(this.sMZ, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24417);
      return i;
    }
    catch (Exception localException4)
    {
      break label398;
      i = 0;
      break label314;
      i += 1;
      break label252;
    }
    localObject1 = this.sNa;
    j = localObject1.length;
    i = 0;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if ((!((String)localObject2).equals(localg.field_packageName)) || (!q.a(MMApplicationContext.getContext(), localg, (String)localObject2, false))) {
        break label451;
      }
      Log.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject2 });
    }
  }
  
  protected final boolean ckf()
  {
    AppMethodBeat.i(24414);
    try
    {
      Log.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
      if (!pep)
      {
        final b localb = new b();
        localb.c(4000L, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24404);
            try
            {
              boolean bool = bg.aAc();
              if (!bool)
              {
                AppMethodBeat.o(24404);
                return;
              }
              bg.azz().a(new bu(new bu.a()
              {
                public final void a(com.tencent.mm.network.g paramAnonymous2g)
                {
                  AppMethodBeat.i(24403);
                  Log.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                  ExtContentProviderBase.1.this.pev.countDown();
                  AppMethodBeat.o(24403);
                }
              }), 0);
              AppMethodBeat.o(24404);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
              localb.countDown();
              AppMethodBeat.o(24404);
            }
          }
        });
      }
      if ((bg.aAc()) && (bg.aVG()) && (!bg.azj())) {}
      for (pep = true;; pep = false)
      {
        Log.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + pep);
        boolean bool = pep;
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
  
  protected final void fP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24407);
    Log.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(paramInt1), Integer.valueOf(cSs()) });
    com.tencent.mm.plugin.report.service.h.CyF.a(10505, new Object[] { cSt(), this.sMZ, Integer.valueOf(this.sNb), Integer.valueOf(paramInt1), Integer.valueOf(cSs()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24407);
  }
  
  protected final boolean fe(Context paramContext)
  {
    AppMethodBeat.i(24416);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
      AppMethodBeat.o(24416);
      return false;
    }
    if (Util.isNullOrNil(this.sMZ))
    {
      Log.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24416);
      return false;
    }
    if ((this.sNa == null) || (this.sNa.length <= 0))
    {
      Log.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24416);
      return false;
    }
    try
    {
      localg = com.tencent.mm.pluginsdk.model.app.h.o(this.sMZ, true, false);
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
          label270:
          this.sMY = ((String)localObject);
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
          localObject = (Integer)e.c.JSJ.get(Integer.valueOf(this.sNb));
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
      paramContext = Long.valueOf(Util.nullAs((Long)sNc.get(this.sMZ), 0L));
      Log.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - paramContext.longValue() > 3600000L)
      {
        Log.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.sMZ });
        a.a.eAZ().aJz(this.sMZ);
        sNc.put(this.sMZ, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24416);
      return bool;
    }
    catch (Exception paramContext)
    {
      break label403;
      bool = false;
      break label333;
      i += 1;
      break label270;
    }
    paramContext = this.sNa;
    j = paramContext.length;
    i = 0;
    if (i < j)
    {
      localObject = paramContext[i];
      if ((!((String)localObject).equals(localg.field_packageName)) || (!q.a(MMApplicationContext.getContext(), localg, (String)localObject, false))) {
        break label458;
      }
      Log.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject });
    }
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
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
 * JD-Core Version:    0.7.0.1
 */