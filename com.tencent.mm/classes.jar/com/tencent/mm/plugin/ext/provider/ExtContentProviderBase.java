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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.e.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtContentProviderBase
  extends ContentProvider
{
  protected static boolean nNW;
  private static HashMap<String, Long> rdr;
  protected MatrixCursor nNT;
  private long rdm;
  private String rdn;
  public String rdo;
  private String[] rdp;
  private int rdq;
  
  static
  {
    AppMethodBeat.i(24419);
    nNW = false;
    rdr = new HashMap();
    AppMethodBeat.o(24419);
  }
  
  public ExtContentProviderBase()
  {
    AppMethodBeat.i(24405);
    this.nNT = new MatrixCursor(new String[0]);
    this.rdm = bt.HI();
    this.rdo = "";
    this.rdq = 0;
    AppMethodBeat.o(24405);
  }
  
  private int csi()
  {
    AppMethodBeat.i(24409);
    int i = (int)bt.aO(this.rdm);
    AppMethodBeat.o(24409);
    return i;
  }
  
  private void eH(Context paramContext)
  {
    AppMethodBeat.i(24418);
    if (paramContext == null)
    {
      ad.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
      AppMethodBeat.o(24418);
      return;
    }
    ad.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
    this.rdp = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
    if (this.rdp == null) {
      ad.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
    }
    AppMethodBeat.o(24418);
  }
  
  private static String r(Uri paramUri)
  {
    AppMethodBeat.i(24415);
    if (paramUri == null)
    {
      AppMethodBeat.o(24415);
      return "";
    }
    paramUri = bt.nullAsNil(paramUri.getQueryParameter("appid"));
    AppMethodBeat.o(24415);
    return paramUri;
  }
  
  protected final void DF(int paramInt)
  {
    AppMethodBeat.i(24406);
    ad.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { csj(), this.rdo, Integer.valueOf(this.rdq), Integer.valueOf(paramInt), Integer.valueOf(csi()) });
    com.tencent.mm.plugin.report.service.g.yhR.f(10505, new Object[] { csj(), this.rdo, Integer.valueOf(this.rdq), Integer.valueOf(paramInt), Integer.valueOf(csi()) });
    AppMethodBeat.o(24406);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(24411);
    this.rdo = r(paramUri);
    eH(paramContext);
    this.rdq = paramInt;
    this.rdm = bt.HI();
    AppMethodBeat.o(24411);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(24412);
    this.rdo = r(paramUri);
    if (paramArrayOfString == null) {
      eH(paramContext);
    }
    for (;;)
    {
      this.rdq = paramInt;
      this.rdm = bt.HI();
      AppMethodBeat.o(24412);
      return;
      this.rdp = paramArrayOfString;
    }
  }
  
  protected final void a(Uri paramUri, Context paramContext, UriMatcher paramUriMatcher)
  {
    AppMethodBeat.i(24410);
    this.rdo = r(paramUri);
    eH(paramContext);
    if (paramUriMatcher != null)
    {
      this.rdq = paramUriMatcher.match(paramUri);
      if (this.rdq < 0) {
        this.rdq = 0;
      }
    }
    this.rdm = bt.HI();
    AppMethodBeat.o(24410);
  }
  
  protected final void ab(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(24408);
    ad.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { csj(), this.rdo, Integer.valueOf(this.rdq), Integer.valueOf(paramInt2), Integer.valueOf(csi()) });
    com.tencent.mm.plugin.report.service.g.yhR.f(10505, new Object[] { csj(), this.rdo, Integer.valueOf(this.rdq), Integer.valueOf(paramInt2), Integer.valueOf(csi()), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(300L, paramInt1, 1L, false);
    AppMethodBeat.o(24408);
  }
  
  protected final boolean bMn()
  {
    AppMethodBeat.i(24414);
    try
    {
      ad.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
      if (!nNW)
      {
        final b localb = new b();
        localb.c(4000L, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24404);
            try
            {
              boolean bool = ba.ajx();
              if (!bool)
              {
                AppMethodBeat.o(24404);
                return;
              }
              ba.aiU().a(new bo(new bo.a()
              {
                public final void a(e paramAnonymous2e)
                {
                  AppMethodBeat.i(24403);
                  ad.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                  ExtContentProviderBase.1.this.nOc.countDown();
                  AppMethodBeat.o(24403);
                }
              }), 0);
              AppMethodBeat.o(24404);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
              localb.countDown();
              AppMethodBeat.o(24404);
            }
          }
        });
      }
      if ((ba.ajx()) && (ba.aBR()) && (!ba.aiE())) {}
      for (nNW = true;; nNW = false)
      {
        ad.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + nNW);
        boolean bool = nNW;
        AppMethodBeat.o(24414);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.ExtContentProviderBase", localException.getMessage());
      ad.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException, "", new Object[0]);
      AppMethodBeat.o(24414);
    }
  }
  
  public final String csj()
  {
    AppMethodBeat.i(24413);
    if (!bt.isNullOrNil(this.rdn))
    {
      str = this.rdn;
      AppMethodBeat.o(24413);
      return str;
    }
    if ((this.rdp == null) || (this.rdp.length <= 0))
    {
      AppMethodBeat.o(24413);
      return "";
    }
    String str = this.rdp[0];
    AppMethodBeat.o(24413);
    return str;
  }
  
  protected final int csk()
  {
    AppMethodBeat.i(24417);
    if (bt.isNullOrNil(this.rdo))
    {
      ad.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24417);
      return 7;
    }
    if ((this.rdp == null) || (this.rdp.length <= 0))
    {
      ad.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24417);
      return 6;
    }
    try
    {
      localg = h.m(this.rdo, true, false);
      if (localg == null)
      {
        ad.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(24417);
        return 13;
      }
      if (localg.field_status == 3)
      {
        ad.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localg.field_packageName });
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
          label256:
          this.rdn = ((String)localObject2);
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
          localObject2 = (Integer)e.c.EJr.get(Integer.valueOf(this.rdq));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            fB(5, 16);
            ad.i("MicroMsg.ExtContentProviderBase", "api flag = null");
            localObject1 = Integer.valueOf(64);
          }
          if (!h.b(localg, ((Integer)localObject1).intValue()))
          {
            i = 11;
            continue;
          }
          ad.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception localException3)
        {
          continue;
        }
        localException1 = localException1;
        i = 0;
        ad.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { localException1.getMessage() });
        ad.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException1, "", new Object[0]);
      }
    }
    try
    {
      localObject1 = Long.valueOf(bt.a((Long)rdr.get(this.rdo), 0L));
      ad.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - ((Long)localObject1).longValue() > 3600000L)
      {
        ad.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.rdo });
        a.a.dxX().atX(this.rdo);
        rdr.put(this.rdo, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24417);
      return i;
    }
    catch (Exception localException4)
    {
      break label402;
      i = 0;
      break label318;
      i += 1;
      break label256;
    }
    localObject1 = this.rdp;
    j = localObject1.length;
    i = 0;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if ((!((String)localObject2).equals(localg.field_packageName)) || (!com.tencent.mm.pluginsdk.model.app.q.a(aj.getContext(), localg, (String)localObject2, false))) {
        break label455;
      }
      ad.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject2 });
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  protected final boolean eG(Context paramContext)
  {
    AppMethodBeat.i(24416);
    if (paramContext == null)
    {
      ad.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
      AppMethodBeat.o(24416);
      return false;
    }
    if (bt.isNullOrNil(this.rdo))
    {
      ad.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24416);
      return false;
    }
    if ((this.rdp == null) || (this.rdp.length <= 0))
    {
      ad.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24416);
      return false;
    }
    try
    {
      localg = h.m(this.rdo, true, false);
      if (localg == null)
      {
        ad.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(24416);
        return false;
      }
      if (localg.field_status == 3)
      {
        ad.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localg.field_packageName });
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
          label274:
          this.rdn = ((String)localObject);
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
          localObject = (Integer)e.c.EJr.get(Integer.valueOf(this.rdq));
          paramContext = (Context)localObject;
          if (localObject == null) {
            paramContext = Integer.valueOf(64);
          }
          if (!h.b(localg, paramContext.intValue()))
          {
            bool = false;
            continue;
          }
          ad.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        bool = false;
        ad.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { paramContext.getMessage() });
        ad.printErrStackTrace("MicroMsg.ExtContentProviderBase", paramContext, "", new Object[0]);
      }
    }
    try
    {
      paramContext = Long.valueOf(bt.a((Long)rdr.get(this.rdo), 0L));
      ad.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - paramContext.longValue() > 3600000L)
      {
        ad.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.rdo });
        a.a.dxX().atX(this.rdo);
        rdr.put(this.rdo, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24416);
      return bool;
    }
    catch (Exception paramContext)
    {
      break label407;
      bool = false;
      break label337;
      i += 1;
      break label274;
    }
    paramContext = this.rdp;
    j = paramContext.length;
    i = 0;
    if (i < j)
    {
      localObject = paramContext[i];
      if ((!((String)localObject).equals(localg.field_packageName)) || (!com.tencent.mm.pluginsdk.model.app.q.a(aj.getContext(), localg, (String)localObject, false))) {
        break label462;
      }
      ad.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject });
    }
  }
  
  protected final void fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24407);
    ad.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { csj(), this.rdo, Integer.valueOf(this.rdq), Integer.valueOf(paramInt1), Integer.valueOf(csi()) });
    com.tencent.mm.plugin.report.service.g.yhR.f(10505, new Object[] { csj(), this.rdo, Integer.valueOf(this.rdq), Integer.valueOf(paramInt1), Integer.valueOf(csi()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(24407);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
 * JD-Core Version:    0.7.0.1
 */