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
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtContentProviderBase
  extends ContentProvider
{
  protected static boolean nnj;
  private static HashMap<String, Long> qtD;
  protected MatrixCursor nng;
  public String qtA;
  private String[] qtB;
  private int qtC;
  private long qty;
  private String qtz;
  
  static
  {
    AppMethodBeat.i(24419);
    nnj = false;
    qtD = new HashMap();
    AppMethodBeat.o(24419);
  }
  
  public ExtContentProviderBase()
  {
    AppMethodBeat.i(24405);
    this.nng = new MatrixCursor(new String[0]);
    this.qty = bs.Gn();
    this.qtA = "";
    this.qtC = 0;
    AppMethodBeat.o(24405);
  }
  
  private int cmD()
  {
    AppMethodBeat.i(24409);
    int i = (int)bs.aO(this.qty);
    AppMethodBeat.o(24409);
    return i;
  }
  
  private void eH(Context paramContext)
  {
    AppMethodBeat.i(24418);
    if (paramContext == null)
    {
      ac.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
      AppMethodBeat.o(24418);
      return;
    }
    ac.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
    this.qtB = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
    if (this.qtB == null) {
      ac.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
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
    paramUri = bs.nullAsNil(paramUri.getQueryParameter("appid"));
    AppMethodBeat.o(24415);
    return paramUri;
  }
  
  protected final void CN(int paramInt)
  {
    AppMethodBeat.i(24406);
    ac.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { cmE(), this.qtA, Integer.valueOf(this.qtC), Integer.valueOf(paramInt), Integer.valueOf(cmD()) });
    com.tencent.mm.plugin.report.service.h.wUl.f(10505, new Object[] { cmE(), this.qtA, Integer.valueOf(this.qtC), Integer.valueOf(paramInt), Integer.valueOf(cmD()) });
    AppMethodBeat.o(24406);
  }
  
  protected final void Z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(24408);
    ac.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { cmE(), this.qtA, Integer.valueOf(this.qtC), Integer.valueOf(paramInt2), Integer.valueOf(cmD()) });
    com.tencent.mm.plugin.report.service.h.wUl.f(10505, new Object[] { cmE(), this.qtA, Integer.valueOf(this.qtC), Integer.valueOf(paramInt2), Integer.valueOf(cmD()), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(300L, paramInt1, 1L, false);
    AppMethodBeat.o(24408);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(24411);
    this.qtA = r(paramUri);
    eH(paramContext);
    this.qtC = paramInt;
    this.qty = bs.Gn();
    AppMethodBeat.o(24411);
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(24412);
    this.qtA = r(paramUri);
    if (paramArrayOfString == null) {
      eH(paramContext);
    }
    for (;;)
    {
      this.qtC = paramInt;
      this.qty = bs.Gn();
      AppMethodBeat.o(24412);
      return;
      this.qtB = paramArrayOfString;
    }
  }
  
  protected final void a(Uri paramUri, Context paramContext, UriMatcher paramUriMatcher)
  {
    AppMethodBeat.i(24410);
    this.qtA = r(paramUri);
    eH(paramContext);
    if (paramUriMatcher != null)
    {
      this.qtC = paramUriMatcher.match(paramUri);
      if (this.qtC < 0) {
        this.qtC = 0;
      }
    }
    this.qty = bs.Gn();
    AppMethodBeat.o(24410);
  }
  
  protected final boolean bIc()
  {
    AppMethodBeat.i(24414);
    try
    {
      ac.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
      if (!nnj)
      {
        final b localb = new b();
        localb.c(4000L, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24404);
            try
            {
              boolean bool = az.agM();
              if (!bool)
              {
                AppMethodBeat.o(24404);
                return;
              }
              az.agi().a(new bn(new bn.a()
              {
                public final void a(e paramAnonymous2e)
                {
                  AppMethodBeat.i(24403);
                  ac.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                  ExtContentProviderBase.1.this.nnp.countDown();
                  AppMethodBeat.o(24403);
                }
              }), 0);
              AppMethodBeat.o(24404);
              return;
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
              localb.countDown();
              AppMethodBeat.o(24404);
            }
          }
        });
      }
      if ((az.agM()) && (az.ayN()) && (!az.afS())) {}
      for (nnj = true;; nnj = false)
      {
        ac.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + nnj);
        boolean bool = nnj;
        AppMethodBeat.o(24414);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.ExtContentProviderBase", localException.getMessage());
      ac.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException, "", new Object[0]);
      AppMethodBeat.o(24414);
    }
  }
  
  public final String cmE()
  {
    AppMethodBeat.i(24413);
    if (!bs.isNullOrNil(this.qtz))
    {
      str = this.qtz;
      AppMethodBeat.o(24413);
      return str;
    }
    if ((this.qtB == null) || (this.qtB.length <= 0))
    {
      AppMethodBeat.o(24413);
      return "";
    }
    String str = this.qtB[0];
    AppMethodBeat.o(24413);
    return str;
  }
  
  protected final int cmF()
  {
    AppMethodBeat.i(24417);
    if (bs.isNullOrNil(this.qtA))
    {
      ac.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24417);
      return 7;
    }
    if ((this.qtB == null) || (this.qtB.length <= 0))
    {
      ac.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24417);
      return 6;
    }
    try
    {
      localg = com.tencent.mm.pluginsdk.model.app.h.k(this.qtA, true, false);
      if (localg == null)
      {
        ac.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(24417);
        return 13;
      }
      if (localg.field_status == 3)
      {
        ac.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localg.field_packageName });
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
          label255:
          this.qtz = ((String)localObject2);
          i = 1;
          if (i != 1) {}
        }
        catch (Exception localException2)
        {
          g localg;
          Object localObject1;
          Object localObject2;
          i = 1;
          continue;
        }
        try
        {
          localObject2 = (Integer)d.c.Dfv.get(Integer.valueOf(this.qtC));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            ft(5, 16);
            ac.i("MicroMsg.ExtContentProviderBase", "api flag = null");
            localObject1 = Integer.valueOf(64);
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.b(localg, ((Integer)localObject1).intValue()))
          {
            i = 11;
            continue;
          }
          ac.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception localException3)
        {
          continue;
        }
        localException1 = localException1;
        i = 0;
        ac.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { localException1.getMessage() });
        ac.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException1, "", new Object[0]);
      }
    }
    try
    {
      localObject1 = Long.valueOf(bs.a((Long)qtD.get(this.qtA), 0L));
      ac.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - ((Long)localObject1).longValue() > 3600000L)
      {
        ac.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.qtA });
        a.a.dnF().aoX(this.qtA);
        qtD.put(this.qtA, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24417);
      return i;
    }
    catch (Exception localException4)
    {
      break label401;
      i = 0;
      break label317;
      i += 1;
      break label255;
    }
    localObject1 = this.qtB;
    j = localObject1.length;
    i = 0;
    if (i < j)
    {
      localObject2 = localObject1[i];
      if ((!((String)localObject2).equals(localg.field_packageName)) || (!com.tencent.mm.pluginsdk.model.app.q.a(ai.getContext(), localg, (String)localObject2, false))) {
        break label454;
      }
      ac.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject2 });
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
      ac.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
      AppMethodBeat.o(24416);
      return false;
    }
    if (bs.isNullOrNil(this.qtA))
    {
      ac.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      AppMethodBeat.o(24416);
      return false;
    }
    if ((this.qtB == null) || (this.qtB.length <= 0))
    {
      ac.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      AppMethodBeat.o(24416);
      return false;
    }
    try
    {
      localg = com.tencent.mm.pluginsdk.model.app.h.k(this.qtA, true, false);
      if (localg == null)
      {
        ac.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
        AppMethodBeat.o(24416);
        return false;
      }
      if (localg.field_status == 3)
      {
        ac.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localg.field_packageName });
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
          label273:
          this.qtz = ((String)localObject);
          bool = true;
          if (!bool) {}
        }
        catch (Exception paramContext)
        {
          g localg;
          Object localObject;
          bool = true;
          continue;
        }
        try
        {
          localObject = (Integer)d.c.Dfv.get(Integer.valueOf(this.qtC));
          paramContext = (Context)localObject;
          if (localObject == null) {
            paramContext = Integer.valueOf(64);
          }
          if (!com.tencent.mm.pluginsdk.model.app.h.b(localg, paramContext.intValue()))
          {
            bool = false;
            continue;
          }
          ac.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        bool = false;
        ac.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { paramContext.getMessage() });
        ac.printErrStackTrace("MicroMsg.ExtContentProviderBase", paramContext, "", new Object[0]);
      }
    }
    try
    {
      paramContext = Long.valueOf(bs.a((Long)qtD.get(this.qtA), 0L));
      ac.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) });
      if (System.currentTimeMillis() - paramContext.longValue() > 3600000L)
      {
        ac.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.qtA });
        a.a.dnF().aoX(this.qtA);
        qtD.put(this.qtA, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(24416);
      return bool;
    }
    catch (Exception paramContext)
    {
      break label406;
      bool = false;
      break label336;
      i += 1;
      break label273;
    }
    paramContext = this.qtB;
    j = paramContext.length;
    i = 0;
    if (i < j)
    {
      localObject = paramContext[i];
      if ((!((String)localObject).equals(localg.field_packageName)) || (!com.tencent.mm.pluginsdk.model.app.q.a(ai.getContext(), localg, (String)localObject, false))) {
        break label461;
      }
      ac.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject });
    }
  }
  
  protected final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24407);
    ac.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { cmE(), this.qtA, Integer.valueOf(this.qtC), Integer.valueOf(paramInt1), Integer.valueOf(cmD()) });
    com.tencent.mm.plugin.report.service.h.wUl.f(10505, new Object[] { cmE(), this.qtA, Integer.valueOf(this.qtC), Integer.valueOf(paramInt1), Integer.valueOf(cmD()), Integer.valueOf(paramInt2) });
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